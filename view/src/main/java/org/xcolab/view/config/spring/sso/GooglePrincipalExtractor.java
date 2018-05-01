package org.xcolab.view.config.spring.sso;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.xcolab.client.members.pojo.Member;
import org.xcolab.view.auth.login.spring.MemberDetails;
import org.xcolab.view.auth.login.spring.MemberDetailsService;
import org.xcolab.view.pages.loginregister.LoginRegisterService;

import java.util.Map;
import java.util.Optional;

public class GooglePrincipalExtractor extends CustomPrincipalExtractor<String> {

    public GooglePrincipalExtractor(LoginRegisterService loginRegisterService,
            MemberDetailsService memberDetailsService) {
        super(loginRegisterService, memberDetailsService);
    }

    @Override
    protected MemberDetails loadFromSsoId(String googleId) throws UsernameNotFoundException {
        return memberDetailsService.loadUserByGoogleId(googleId);
    }

    @Override
    protected void setSsoId(Member member, String ssoId) {
        member.setGoogleId(ssoId);
    }

    @Override
    protected String extractId(Map map) {
        return (String) map.get("sub");
    }

    @Override
    protected String extractFirstName(Map<String, Object> map) {
        return (String) map.get("given_name");
    }

    @Override
    protected String extractLastName(Map<String, Object> map) {
        return (String) map.get("family_name");
    }

    @Override
    protected Optional<String> extractProfileImageUrl(Map<String, Object> userInfoMap) {
        //TODO: deactivated until it can be fixed
        if (false) {
            //TODO: check if it's the default picture
            return Optional.of((String) userInfoMap.get("picture"));
        }
        return Optional.empty();
    }
}
