package org.xcolab.view.pages.proposals.utils;

import org.xcolab.client.proposals.pojo.Proposal;

import java.util.Comparator;

public enum ProposalsColumn {
    NAME(Comparator.comparing(o -> o.getName().toLowerCase())),
    AUTHOR(Comparator.comparing(o -> o.getAuthorName().toLowerCase())),
    SUPPORTERS((o1, o2) -> (int) (o1.getSupportersCount() - o2.getSupportersCount())),
    VOTES((o1, o2) -> {
        try {
            return (int) (o1.getVotesCountFromCache() - o2.getVotesCountFromCache());
        }
        catch (Exception e) {
            return (int) (o1.getProposalId() - o2.getProposalId());
        }
    }),
    COMMENTS((o1, o2) -> (int) (o1.getCommentsCount() - o2.getCommentsCount())),
    JUDGESTATUS(
            (o1, o2) -> (o1.getJudgeStatus().getStatusValue() - o2.getJudgeStatus().getStatusValue())),
    OVERALLSTATUS(
            (o1, o2) -> (o1.getOverallStatus().getStatusValue() - o2.getOverallStatus().getStatusValue())),
    SCREENINGSTATUS(
            (o1, o2) -> (o1.getScreeningStatus().getStatusValue() - o2.getScreeningStatus().getStatusValue())),
    MODIFIED(Comparator.comparing(Proposal::getLastModifiedDate)),
    CONTRIBUTORS((o1, o2) -> {
        if (o1.isOpen()) {
            return o2.isOpen() ? 0 : -1;
        } else {
            return o2.isOpen() ? 1 : 0;
        }
    });
    
    private final Comparator<Proposal> proposalsComparator;
    
    ProposalsColumn(Comparator<Proposal> comparator) {
        proposalsComparator = comparator;
    }

    public Comparator<Proposal> getComparator() {
        return proposalsComparator;
    }

}
