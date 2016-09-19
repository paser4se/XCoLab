package org.xcolab.client.proposals;


import org.xcolab.client.contest.ContestClient;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.ContestPhase;
import org.xcolab.client.contest.pojo.ContestType;
import org.xcolab.client.proposals.enums.ProposalJudgeType;
import org.xcolab.client.proposals.exceptions.PlanTemplateNotFoundException;
import org.xcolab.client.proposals.exceptions.Proposal2PhaseNotFoundException;
import org.xcolab.client.proposals.exceptions.ProposalAttributeNotFoundException;
import org.xcolab.client.proposals.exceptions.ProposalNotFoundException;
import org.xcolab.client.proposals.pojo.PlanSectionDefinition;
import org.xcolab.client.proposals.pojo.PlanTemplate;
import org.xcolab.client.proposals.pojo.PointType;
import org.xcolab.client.proposals.pojo.PointsDistributionConfiguration;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.Proposal2Phase;
import org.xcolab.client.proposals.pojo.ProposalAttribute;
import org.xcolab.client.proposals.pojo.ProposalContestPhaseAttribute;
import org.xcolab.client.proposals.pojo.ProposalRating;
import org.xcolab.client.proposals.pojo.ProposalRatingType;
import org.xcolab.client.proposals.pojo.ProposalRatingValue;
import org.xcolab.client.proposals.pojo.ProposalReference;
import org.xcolab.client.proposals.pojo.ProposalSupporter;
import org.xcolab.client.proposals.pojo.ProposalVersion;
import org.xcolab.client.proposals.pojo.ProposalVote;
import org.xcolab.util.enums.contest.ProposalContestPhaseAttributeKeys;
import org.xcolab.util.http.caching.CacheKeys;
import org.xcolab.util.http.caching.CacheRetention;
import org.xcolab.util.http.client.RestResource;
import org.xcolab.util.http.client.RestService;
import org.xcolab.util.http.exceptions.EntityNotFoundException;

import java.util.List;

public final class ProposalsClient {

    private static final RestService proposalService = new RestService("proposals-service");
    private static final RestResource<Proposal> proposalResource = new RestResource<>(
            proposalService, "proposals", Proposal.TYPES);

    private static final RestResource<Proposal2Phase> proposal2PhaseResource = new RestResource<>(
            proposalService, "proposal2Phases", Proposal2Phase.TYPES);

    private static final RestResource<ProposalVote> proposalVoteResource = new RestResource<>(proposalService,
            "proposalVotes", ProposalVote.TYPES);

    private static final RestResource<ProposalContestPhaseAttribute> proposalContestPhaseAttributeResource = new RestResource<>(proposalService,
            "proposalContestPhaseAttributes", ProposalContestPhaseAttribute.TYPES);

    private static final RestResource<ProposalAttribute> proposalAttributeResource = new RestResource<>(proposalService,
            "proposalAttributes", ProposalAttribute.TYPES);

    private static final RestResource<ProposalSupporter> proposalSupporterResource = new RestResource<>(proposalService,
            "proposalSupporters", ProposalSupporter.TYPES);

    private static final RestResource<ProposalVersion> proposalVersionResource = new RestResource<>(proposalService,
            "proposalVersions", ProposalVersion.TYPES);

    private static final RestResource<PlanTemplate> planTemplateResource = new RestResource<>(proposalService,
            "planTemplates", PlanTemplate.TYPES);

    private static final RestResource<PlanSectionDefinition> planSectionDefinitionResource = new RestResource<>(proposalService,
            "planSectionDefinitions", PlanSectionDefinition.TYPES);

    private static final RestResource<ProposalRating> proposalRatingResource = new RestResource<>(proposalService,
            "proposalRatings", ProposalRating.TYPES);

    private static final RestResource<ProposalRatingValue> proposalRatingValueResource = new RestResource<>(proposalService,
            "proposalRatingValues", ProposalRatingValue.TYPES);

    private static final RestResource<ProposalRatingType> proposalRatingTypeResource = new RestResource<>(proposalService,
            "proposalRatingTypes", ProposalRatingType.TYPES);

    private static final RestResource<PointsDistributionConfiguration> pointsDistributionConfigurationResource = new RestResource<>(proposalService,
            "pointsDistributionConfigurations", PointsDistributionConfiguration.TYPES);

    private static final RestResource<PointType> pointTypeResource = new RestResource<>(proposalService,
            "pointTypes", PointType.TYPES);

    public static Proposal createProposal(Proposal proposal) {
        return proposalResource.create(proposal).execute();
    }

    public static List<Proposal> listProposals(long contestId) {
        return listProposals(0, Integer.MAX_VALUE, contestId, null, null, null);
    }

    public static List<Proposal> getProposalsInContestPhase(Long contestPhaseId) {
        return listProposals(0, Integer.MAX_VALUE, null, true, contestPhaseId, null);
    }


    public static List<Proposal> listProposals(int start, int limit, Long contestId,
                                               Boolean visible, Long contestPhaseId, Integer ribbon) {
        return proposalResource.list()
                .addRange(start, limit)
                .optionalQueryParam("contestId", contestId)
                .optionalQueryParam("visible", visible)
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("ribbon", ribbon)
                .execute();
    }

    public static List<Proposal> getActiveProposalsInContestPhase(Long contestPhaseId) {
        return proposalResource.list()
                .addRange(0, Integer.MAX_VALUE)
                .optionalQueryParam("visible", true)
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .execute();
    }




    public static Proposal getProposal(long proposalId) throws ProposalNotFoundException {
        return getProposal(proposalId, false);
    }

    public static Proposal getProposal(long proposalId, boolean includeDeleted)
            throws ProposalNotFoundException {
        try {
            return proposalResource.get(proposalId)
                    .queryParam("includeDeleted", includeDeleted)
                    .withCache(CacheKeys.withClass(Proposal.class)
                                    .withParameter("proposalId", proposalId)
                                    .withParameter("includeDeleted", includeDeleted).build(),
                            CacheRetention.REQUEST)
                    .executeChecked();
        } catch (EntityNotFoundException e) {
            throw new ProposalNotFoundException(proposalId);
        }
    }

    public static List<Proposal> getContestIntegrationRelevantSubproposals(Long proposalId) {
        return proposalResource.getSubRestResource(proposalId, "contestIntegrationRelevantSubproposal", Proposal.TYPES).list().execute();
    }

    public static Integer getNumberOfProposalsForJudge(Long userId, Long contestPhaseId) {
        return proposalResource.service("numberOfProposalsForJudge", Integer.class)
                .queryParam("userId", userId)
                .queryParam("contestPhaseId", contestPhaseId)
                .get();

    }

    public static boolean updateProposal(Proposal proposal) {
        return proposalResource.update(proposal, proposal.getProposalId()).execute();
    }

    public static boolean deleteProposal(long proposalId) {
        return proposalResource.delete(proposalId).execute();
    }

    public static Proposal2Phase getProposal2PhaseByProposalIdContestPhaseId(Long proposalId, Long contestPhaseId) throws Proposal2PhaseNotFoundException {
        try {
            return proposal2PhaseResource.service("getByContestPhaseIdProposalId", Proposal2Phase.class)
                    .queryParam("proposalId", proposalId)
                    .queryParam("contestPhaseId", contestPhaseId)
                    .getChecked();
        } catch (EntityNotFoundException ignored) {
            throw new Proposal2PhaseNotFoundException(proposalId);
        }
    }

    public static List<Proposal2Phase> getProposal2PhaseByProposalId(Long proposalId) {
        return proposal2PhaseResource.list()
                .optionalQueryParam("proposalId", proposalId)
                .execute();
    }

    public static List<ProposalSupporter> getProposalSupporters(Long proposalId) {
        return proposalSupporterResource.list()
                .optionalQueryParam("proposalId", proposalId)
                .execute();
    }

    public static Integer getProposalSupportersCount(Long proposalId) {

        return proposalSupporterResource.service("count", Integer.class)
                .optionalQueryParam("proposalId", proposalId)
                .get();

    }

    public static Boolean isMemberProposalSupporter(Long proposalId, Long memberId) {

        return proposalSupporterResource.service("isMemberProposalSupporter", Boolean.class)
                .optionalQueryParam("proposalId", proposalId)
                .optionalQueryParam("memberId", memberId)
                .get();

    }


    public static ProposalVersion getProposalVersionByProposalIdVersion(Long proposalId, Integer version) {
        return proposalVersionResource.service("getByProposalIdVersion", ProposalVersion.class)
                .queryParam("proposalId", proposalId)
                .queryParam("version", version)
                .get();
    }

    public static ProposalVersion getProposalVersionByProposal(Long proposalId) {
        return proposalVersionResource.service("getByProposalIdVersion", ProposalVersion.class)
                .queryParam("proposalId", proposalId)
                .get();
    }


    public static Integer getProposalCountForActiveContestPhase(Long contestPhasePK) {

        try {
            return proposal2PhaseResource.service(contestPhasePK, "getProposalCount", Integer.class).getChecked();
        } catch (EntityNotFoundException ignored) {
            return 0;
        }
    }

    public static List<ProposalContestPhaseAttribute> getAllProposalContestPhaseProposalAttributes(Long contestPhaseId, Long proposalId) {
        return proposalContestPhaseAttributeResource.list()
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("proposalId", proposalId)
                .execute();
    }

    public static ProposalContestPhaseAttribute getProposalContestPhaseAttribute(Long contestPhaseId, Long proposalId, String name) {
        return proposalContestPhaseAttributeResource.service("getByContestPhaseProposalIdName", ProposalContestPhaseAttribute.class)
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("proposalId", proposalId)
                .optionalQueryParam("name", name)
                .get();
    }

    public static Boolean isProposalContestPhaseAttributeSetAndTrue(Long proposalId, long contestPhaseId, String name) {
        ProposalContestPhaseAttribute proposalAttribute = getProposalContestPhaseAttribute(proposalId, contestPhaseId, name);
        if (proposalAttribute != null) {
            return proposalAttribute.getStringValue().equals("true");
        } else {
            return false;
        }

    }

    public static ProposalContestPhaseAttribute createProposalContestPhaseAttribute(ProposalContestPhaseAttribute proposalContestPhaseAttribute) {
        return proposalContestPhaseAttributeResource.create(proposalContestPhaseAttribute).execute();
    }
    public static boolean persistSelectedJudgesAttribute(Long proposalId, Long contestPhaseId,java.util.List<java.lang.Long> selectedJudges ){
        ProposalContestPhaseAttribute judges = getProposalContestPhaseAttribute(proposalId, contestPhaseId, ProposalContestPhaseAttributeKeys.SELECTED_JUDGES);

        StringBuilder attributeValue = new StringBuilder("");
        if (selectedJudges != null) {
            for (Long userId : selectedJudges) {
                attributeValue.append(userId).append(";");
            }
        }
        judges.setStringValue(attributeValue.toString().replaceAll(";$", ""));

        updateProposalContestPhaseAttribute(judges);
        return true;
    }
    public static ProposalContestPhaseAttribute persistProposalContestPhaseAttribute(Long proposalId, Long contestPhaseId,String name, Long aditionalId,Long numericValue, String stringValue){
        ProposalContestPhaseAttribute proposalContestPhaseAttribute = getProposalContestPhaseAttribute(proposalId, contestPhaseId, name);
        if(proposalContestPhaseAttribute== null){
            proposalContestPhaseAttribute.setAdditionalId(aditionalId);
            proposalContestPhaseAttribute.setNumericValue(numericValue);
            proposalContestPhaseAttribute.setStringValue(stringValue);
            updateProposalContestPhaseAttribute(proposalContestPhaseAttribute);
            return proposalContestPhaseAttribute;
        }else {
            proposalContestPhaseAttribute = new ProposalContestPhaseAttribute();
            proposalContestPhaseAttribute.setProposalId(proposalId);
            proposalContestPhaseAttribute.setName(name);
            proposalContestPhaseAttribute.setAdditionalId(aditionalId);
            proposalContestPhaseAttribute.setNumericValue(numericValue);
            proposalContestPhaseAttribute.setStringValue(stringValue);
            proposalContestPhaseAttribute = createProposalContestPhaseAttribute(proposalContestPhaseAttribute);
            return proposalContestPhaseAttribute;
        }
    }


    public static boolean updateProposalContestPhaseAttribute(ProposalContestPhaseAttribute proposalContestPhaseAttribute) {
        return proposalContestPhaseAttributeResource.update(proposalContestPhaseAttribute, proposalContestPhaseAttribute.getId_())
                .execute();
    }
    public static Integer countProposalVotesInContestPhase(Long contestPhaseId) {
        try {
            return proposalVoteResource.<Proposal, Integer>service("count", Integer.class)
                    .optionalQueryParam("contestPhaseId", contestPhaseId)
                    .withCache(CacheKeys.withClass(Proposal.class)
                            .withParameter("contestPhaseId", contestPhaseId)
                            .asCount(), CacheRetention.REQUEST)
                    .getChecked();
        } catch (EntityNotFoundException e) {
            return 0;
        }
    }

    public static Integer countProposalVotesInContestPhaseProposalId(Long proposalId, Long contestPhaseId) {
        return proposalVoteResource.service("count", Integer.class)
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("proposalId", proposalId)
                .get();
    }

    public static Boolean hasUserVoted(Long proposalId, Long contestPhaseId, Long memberId) {
        return proposalVoteResource.service("hasUserVoted", Boolean.class)
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("memberId", memberId)
                .optionalQueryParam("proposalId", proposalId)
                .get();
    }

    public static List<ProposalVote> getProposalVotes(Long contestPhaseId, Long proposalId, Long userId) {
        return proposalVoteResource.list()
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("proposalId", proposalId)
                .optionalQueryParam("userId", userId)
                .execute();
    }

    public static ProposalAttribute createProposalAttribute(ProposalAttribute proposalAttribute) {
        return proposalAttributeResource.create(proposalAttribute).execute();
    }

    public static ProposalAttribute getImpactProposalAttributes(Long proposalId){
            proposalAttributeResource
    }

    public static ProposalAttribute getProposalAttribute(Long proposalId, String name, Long additionalId) {
        return proposalAttributeResource.service("getByProposalIdVersionAditionalId", ProposalAttribute.class)
                .queryParam("proposalId", proposalId)
                .queryParam("name", name)
                .queryParam("additionalId", additionalId)
                .get();
    }


    public static List<ProposalVersion> getAllProposalVersions(Long proposalId) {
        return proposalVersionResource.list()
                .optionalQueryParam("proposalId", proposalId)
                .execute();
    }

    public static ProposalAttribute getProposalAttribute(long id_) throws ProposalAttributeNotFoundException {
        return proposalAttributeResource.get(id_)
                .execute();

    }

    public static boolean updateProposalAttribute(ProposalAttribute proposalAttribute) {
        return proposalAttributeResource.update(proposalAttribute, proposalAttribute.getId_())
                .execute();
    }

    public static Contest getCurrentContestForProposal(Long proposalId) throws ContestNotFoundException {

        Long contestPhaseId = getLatestContestPhaseIdInProposal(proposalId);
        ContestPhase contestPhase = ContestClient.getContestPhase(contestPhaseId);
        return ContestClient.getContest(contestPhase.getContestPhasePK());

    }

    public static ContestType getContestTypeFromProposalId(Long proposalId) {
        try {
            Contest contest = getCurrentContestForProposal(proposalId);
            return ContestClient.getContestType(contest.getContestTypeId());
        } catch (ContestNotFoundException ignored) {
            return null;
        }
    }

    public static ProposalAttribute setProposalAttribute(Long userId, Long proposalId, String name,  Long aditionalId, Long numericValue) {
        ProposalAttribute proposalAttribute = createProposalAttribute( userId,  proposalId,  name,   aditionalId);
        proposalAttribute.setNumericValue(numericValue);
        return setProposalAttribute(proposalAttribute, userId);

    }
    private static ProposalAttribute createProposalAttribute(Long userId, Long proposalId, String name,  Long aditionalId){
        ProposalAttribute proposalAttribute = new ProposalAttribute();
        proposalAttribute.setProposalId(proposalId);
        proposalAttribute.setName(name);
        proposalAttribute.setAdditionalId(aditionalId);
        return proposalAttribute;
    }
    public static ProposalAttribute setProposalAttribute(Long userId, Long proposalId, String name,  Long aditionalId, String stringValue) {
        ProposalAttribute proposalAttribute = createProposalAttribute( userId,  proposalId,  name,   aditionalId);
        proposalAttribute.setStringValue(stringValue);
        return setProposalAttribute(proposalAttribute, userId);

    }

    public static ProposalAttribute setProposalAttribute(ProposalAttribute proposalAttribute, Long authorId) {
        return proposalAttributeResource.create(proposalAttribute).queryParam("authorId", authorId)
                .execute();
    }

    public static Contest getLatestContestInProposal(Long proposalId) throws ContestNotFoundException {
        return ContestClient.getContest(getLatestContestPhaseInContest(proposalId).getContestPK());
    }

    public static Long getLatestContestPhaseIdInProposal(Long proposalId) {
        List<Proposal2Phase> allP2p = getProposal2PhaseByProposalId(proposalId);
        long newestVersionContestPhaseId = 0;
        int newestVersion = 0;
        for (Proposal2Phase p2p : allP2p) {
            long contestPhaseId = p2p.getContestPhaseId();
            if (p2p.getVersionTo() == -1) {
                return contestPhaseId;
            } else if (p2p.getVersionTo() > newestVersion) {
                newestVersion = p2p.getVersionTo();
                newestVersionContestPhaseId = contestPhaseId;
            }
        }

        if (newestVersion != 0 && newestVersionContestPhaseId != 0) {
            return newestVersionContestPhaseId;
        }
        return null;
    }

    public static ContestPhase getLatestContestPhaseInContest(Long proposalId) {
        Long contestPhaseId = getLatestContestPhaseIdInProposal(proposalId);
        return ContestClient.getContestPhase(contestPhaseId);
    }

    public static List<ProposalAttribute> getAllProposalAttributes(Long proposalId, Integer version) {
        return proposalAttributeResource.list()
                .optionalQueryParam("proposalId", proposalId)
                .optionalQueryParam("version", version)
                .execute();
    }

    public static PlanTemplate getPlanTemplate(long Id_) throws PlanTemplateNotFoundException {
        return planTemplateResource.get(Id_)
                .execute();

    }

    public static List<PlanSectionDefinition> getPlanSectionDefinitionByPlanTemplateId(Long planTemplateId, Boolean weight) {

        return planSectionDefinitionResource.list()
                .optionalQueryParam("planTemplateId", planTemplateId)
                .optionalQueryParam("weight", ((weight == null) ? (false) : weight))
                .execute();
    }

    public static List<ProposalRating> getProposalRatingsByProposalUserContestPhase(Long proposalId, Long contestPhaseId, Long userId) {
        return proposalRatingResource.list()
                .optionalQueryParam("proposalId", proposalId)
                .optionalQueryParam("contestPhaseId", contestPhaseId)
                .optionalQueryParam("userId", userId)
                .execute();
    }


    public static List<ProposalRating> getFellowRatingsForProposal(long proposalId, long contestPhaseId) {
        return getRatingsForProposal(proposalId, contestPhaseId, ProposalJudgeType.FELLOW.getId());
    }


    public static List<ProposalRating> getJudgeRatingsForProposal(long proposalId, long contestPhaseId) {
        return getRatingsForProposal(proposalId, contestPhaseId, ProposalJudgeType.JUDGE.getId());
    }

    protected static List<ProposalRating> getRatingsForProposal(long proposalId, long contestPhaseId, int judgeType) {
        try {
            return proposalRatingResource.service("findByProposalIdJudgeTypeJudgeIdContestPhaseId", List.class)
                    .queryParam("proposalId", proposalId)
                    .queryParam("judgeType", judgeType)
                    .queryParam("contestPhaseId", contestPhaseId).getChecked();
        } catch (EntityNotFoundException ignored) {

        }
        return null;
    }


    public static List<ProposalRating> getJudgeRatingsForProposalAndUser(long userId, long proposalId, long contestPhaseId) {
        return getRatingsForProposalAndUser(proposalId, ProposalJudgeType.JUDGE.getId(), userId, contestPhaseId);
    }

    public static List<ProposalRating> getFellowRatingForProposalAndUser(long userId, long proposalId, long contestPhaseId) {
        return getRatingsForProposalAndUser(proposalId, ProposalJudgeType.FELLOW.getId(), userId, contestPhaseId);
    }

    protected static List<ProposalRating> getRatingsForProposalAndUser(long proposalId, int judgeType, long userId, long contestPhaseId) {
        try {
            return proposalRatingResource.service("findByProposalIdJudgeTypeJudgeIdContestPhaseId", List.class)
                    .queryParam("proposalId", proposalId)
                    .queryParam("judgeType", judgeType)
                    .queryParam("userId", userId)
                    .queryParam("contestPhaseId", contestPhaseId).getChecked();
        } catch (EntityNotFoundException ignored) {

        }
        return null;
    }

    public static ProposalRating createProposalRating(ProposalRating proposalRating) {
        return proposalRatingResource.create(proposalRating).execute();
    }


    public static boolean updateProposalRating(ProposalRating proposalRating) {
        return proposalRatingResource.update(proposalRating, proposalRating.getId_())
                .execute();
    }

    public static ProposalRatingValue getProposalRatingValue(long id) {
        return proposalRatingValueResource.get(id)
                .execute();
    }

    public static ProposalRatingType getProposalRatingType(long id) {
        return proposalRatingTypeResource.get(id)
                .execute();

    }

    public static PointsDistributionConfiguration createPointsDistributionConfiguration(PointsDistributionConfiguration pointsDistributionConfiguration) {
        return pointsDistributionConfigurationResource.create(pointsDistributionConfiguration).execute();
    }


    public static List<PointsDistributionConfiguration> getPointsDistributionByProposalIdPointTypeId(Long proposalId, Long pointTypeId) {
        return pointsDistributionConfigurationResource.list()
                .optionalQueryParam("proposalId", proposalId)
                .optionalQueryParam("pointTypeId", pointTypeId)
                .execute();
    }

    public static Boolean deletePointsDistributionConfigurationByProposalId(Long proposalId) {
        return pointsDistributionConfigurationResource.service("removeByProposalId", Boolean.class)
                .queryParam("proposalId", proposalId).execute();
    }

    public static PointType getPointType(long Id_) {
        return pointTypeResource.get(Id_)
                .execute();

    }

    public static List<PointType> getChildrenOfPointType(Long parentPointTypeId) {
        return pointTypeResource.list()
                .optionalQueryParam("parentPointTypeId", parentPointTypeId)
                .execute();
    }

    public static void updateProposal2Phase(Proposal2Phase proposal2Phase) {
         proposal2PhaseResource.service("updateProposal2Phase", Boolean.class).post(proposal2Phase);
    }

    public static void deleteProposal2Phase(Proposal2Phase proposal2Phase) {
        proposal2PhaseResource.service("deleteProposal2Phase", Boolean.class)
                .post(proposal2Phase);
    }

    private static final RestResource<ProposalReference> proposalReferenceResource = new RestResource<>(proposalService,
            "proposalReference", ProposalReference.TYPES);



    public static void populateTableWithProposal(long proposalId) {
             proposalReferenceResource.service("populateTableWithProposal", Boolean.class)
                    .queryParam("proposalId",proposalId)
                    .get();

    }
}
