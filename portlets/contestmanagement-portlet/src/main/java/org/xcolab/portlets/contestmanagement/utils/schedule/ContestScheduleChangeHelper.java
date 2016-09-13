package org.xcolab.portlets.contestmanagement.utils.schedule;

import org.springframework.util.Assert;

import org.xcolab.client.contest.ContestClient;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.ContestPhase;
import org.xcolab.enums.ContestPhasePromoteType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ContestScheduleChangeHelper {

    private final Contest contest;
    private final long newScheduleId;
    private final List<ContestPhase> existingPhases;
    private final List<ContestPhase> schedulePhases;

    public ContestScheduleChangeHelper(Contest contest, long newScheduleId) {
        this.contest = contest;
        this.newScheduleId = newScheduleId;
        existingPhases = ContestClient.getAllContestPhases(contest.getContestPK());
        schedulePhases = ContestClient.getPhasesForContestScheduleId(newScheduleId);
    }

    public void changeScheduleForStartedContest() {
        updateContestPhasesWithProposalsToNewScheduleId();
        createMissingContestPhasesIfContestDoesNotHaveSamePhasesAsSchedule(schedulePhases);
        updateContestPhasesOfContestAccordingToContestSchedule();
    }

    public void changeScheduleForBlankContest() {
        removeExistingContestPhases(contest.getContestPK());

        List<ContestPhase> contestSchedulePhases = ContestClient
                .getPhasesForContestScheduleId(newScheduleId);
        for (ContestPhase contestSchedulePhase : contestSchedulePhases) {
            createContestPhaseFromExistingContestPhaseWithContestId(contestSchedulePhase,
                    contest.getContestPK());
        }
    }

    private void updateContestPhasesWithProposalsToNewScheduleId() {

        Date now = new Date();
        for (ContestPhase phase : existingPhases) {
            if (!(phase.getPhaseStartDate().after(now))) {
                phase.setContestScheduleId(newScheduleId);
                ContestClient.updateContestPhase(phase);
            }
        }

    }

    private void createMissingContestPhasesIfContestDoesNotHaveSamePhasesAsSchedule(
            List<ContestPhase> schedulePhases) {

        for (ContestPhase schedulePhase : schedulePhases) {
            long contestPhaseType = schedulePhase.getContestPhaseType();
            if (!isContestPhaseTypeInContestPhaseList(existingPhases, contestPhaseType)) {
                createContestPhaseFromExistingContestPhaseWithContestId(
                        schedulePhase, contest.getContestPK());
            }
        }
    }

    private static boolean isContestPhaseTypeInContestPhaseList(List<ContestPhase> contestPhases,
            Long contestPhaseType) {
        Assert.notNull(contestPhaseType, "ContestPhase type is required");
        for (ContestPhase phase : contestPhases) {
            if (contestPhaseType.equals(phase.getContestPhaseType())) {
                return true;
            }
        }
        return false;
    }

    public void updateContestPhasesOfContestAccordingToContestSchedule() {

        Map<Long, ContestPhase> phasesByPhaseTypeId =
                ContestScheduleUtil.groupContestPhasesByPhaseTypeId(existingPhases);

        List<ContestPhase> existingPhasesToProcess = new ArrayList<>(existingPhases);

        List<ContestPhase> schedulePhases = ContestClient.
                getTemplatePhasesForContestScheduleId(newScheduleId);
        List<ContestPhase> newPhasesForContest = new ArrayList<>();
        for (ContestPhase schedulePhase : schedulePhases) {

            ContestPhase existingPhaseOfMatchingType =
                    phasesByPhaseTypeId.get(schedulePhase.getContestPhaseType());

            if (existingPhaseOfMatchingType == null) {
                ContestScheduleLifecycleUtil.removeContestPhases(newPhasesForContest);
                throw new SchedulePhasesMismatchException(contest.getContestPK(),
                        newScheduleId, schedulePhase.getContestPhaseType());
            }
            updateExistingContestPhaseAccordingToContestSchedulePhase(
                    existingPhaseOfMatchingType,
                    schedulePhase);
            existingPhasesToProcess.remove(existingPhaseOfMatchingType);
        }

        ContestScheduleLifecycleUtil.removeContestPhases(existingPhasesToProcess);
    }

    private static void updateExistingContestPhaseAccordingToContestSchedulePhase(
            ContestPhase existingContestPhase, ContestPhase contestSchedulePhase) {
        existingContestPhase.setContestPhaseType(contestSchedulePhase.getContestPhaseType());
        existingContestPhase.setContestScheduleId(contestSchedulePhase.getContestScheduleId());
        existingContestPhase.setContestPhaseDescriptionOverride(
                contestSchedulePhase.getContestPhaseDescriptionOverride());
        existingContestPhase.setPhaseStartDate(contestSchedulePhase.getPhaseStartDate());
        existingContestPhase.setPhaseEndDate(contestSchedulePhase.getPhaseEndDate());
        if (!isContestPhaseAlreadyPromoted(existingContestPhase)) {
            existingContestPhase
                    .setContestPhaseAutopromote(contestSchedulePhase.getContestPhaseAutopromote());
        }
        existingContestPhase
                .setFellowScreeningActive(contestSchedulePhase.getFellowScreeningActive());

        ContestClient.updateContestPhase(existingContestPhase);

    }

    private static boolean isContestPhaseAlreadyPromoted(ContestPhase contestPhase) {
        return contestPhase.getContestPhaseAutopromote()
                .equals(ContestPhasePromoteType.PROMOTE_DONE.getValue());
    }

    private static void createContestPhaseFromExistingContestPhaseWithContestId(
            ContestPhase contestSchedulePhase, Long contestId) {

        ContestPhase newContestPhase = ContestPhase
                .createFromContestPhase(contestSchedulePhase);
        newContestPhase.setContestPK(contestId);
        ContestClient.createContestPhase(newContestPhase);

    }

    private static void removeExistingContestPhases(long contestId) {
        List<ContestPhase> contestPhases = ContestClient.getAllContestPhases(contestId);
        for (ContestPhase contestPhase : contestPhases) {
            ContestClient.deleteContestPhase(contestPhase.getContestPhasePK());
        }
    }
}
