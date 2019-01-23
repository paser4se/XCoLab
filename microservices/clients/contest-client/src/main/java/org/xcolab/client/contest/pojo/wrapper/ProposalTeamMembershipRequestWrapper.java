package org.xcolab.client.contest.pojo.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.core.ParameterizedTypeReference;

import org.xcolab.client.contest.pojo.tables.pojos.ProposalTeamMembershipRequest;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.commons.exceptions.ReferenceResolutionException;
import org.xcolab.util.http.client.types.TypeProvider;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ProposalTeamMembershipRequestWrapper extends ProposalTeamMembershipRequest
        implements Serializable {

    public static final TypeProvider<ProposalTeamMembershipRequestWrapper> TYPES =
            new TypeProvider<>(ProposalTeamMembershipRequestWrapper.class,
                    new ParameterizedTypeReference<List<ProposalTeamMembershipRequestWrapper>>() {});

    private Member requestUser;

    public ProposalTeamMembershipRequestWrapper() {
    }

    public ProposalTeamMembershipRequestWrapper(ProposalTeamMembershipRequestWrapper value) {
        super(value);
    }

    public ProposalTeamMembershipRequestWrapper(ProposalTeamMembershipRequest abstractMembershipRequest) {
        super(abstractMembershipRequest);
    }

    public Member getRequestUser(){
        if(this.requestUser == null){
            if(this.getUserId() != null) {
                try {
                    this.requestUser = MembersClient.getMember(this.getUserId());
                } catch (MemberNotFoundException e) {
                    throw ReferenceResolutionException
                            .toObject(Member.class, this.getUserId())
                            .fromObject(ProposalTeamMembershipRequestWrapper.class,
                                    this.getId());
                }
            }else{
                requestUser = null;
            }
        }

        return requestUser;
    }

    public ProposalTeamMembershipRequestWrapper getMembershipRequest(){
        return this;
    }
}