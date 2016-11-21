package org.xcolab.portlets.contestmanagement.beans;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;


public class ContestBatchBean {

    @Length(min = 0, max = 3000, message = "The contest description must have not more than 3000 characters (including html tags).")
    private String contestDescription;

    @NotNull(message = "A plan template must be selected.")
    private Long planTemplateId;

    @NotNull(message = "A schedule template must be selected.")
    private Long scheduleTemplateId;

    @NotNull(message = "A contest tier must be selected.")
    private Long contestTier;

    @NotNull(message = "A contest type must be selected.")
    private Long contestType;

    private Long contestLogoId;

    private Long sponsorLogoId;

    private List<ContestCSVBean> contestCSVs;

    public List<ContestCSVBean> getContestCSVs() {
        return contestCSVs;
    }

    public void setContestCSVs(List<ContestCSVBean> contestCSVs) {
        this.contestCSVs = contestCSVs;
    }

    public Long getSponsorLogoId() {
        return sponsorLogoId;
    }

    public void setSponsorLogoId(Long sponsorLogoId) {
        this.sponsorLogoId = sponsorLogoId;
    }


    public Long getContestLogoId() {
        return contestLogoId;
    }

    public void setContestLogoId(Long contestLogoId) {
        this.contestLogoId = contestLogoId;
    }

    public String getContestDescription() {
        return contestDescription;
    }

    public void setContestDescription(String contestDescription) {
        this.contestDescription = contestDescription;
    }

    public Long getPlanTemplateId() {
        return planTemplateId;
    }

    public void setPlanTemplateId(Long planTemplateId) {
        this.planTemplateId = planTemplateId;
    }

    public Long getScheduleTemplateId() {
        return scheduleTemplateId;
    }

    public void setScheduleTemplateId(Long scheduleTemplateId) {
        this.scheduleTemplateId = scheduleTemplateId;
    }

    public Long getContestTier() {
        return contestTier;
    }

    public void setContestTier(Long contestTier) {
        this.contestTier = contestTier;
    }

    public Long getContestType() {
        return contestType;
    }

    public void setContestType(Long contestType) {
        this.contestType = contestType;
    }
}
