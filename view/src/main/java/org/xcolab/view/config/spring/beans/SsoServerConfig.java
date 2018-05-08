package org.xcolab.view.config.spring.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.client.members.pojo.Member;
import org.xcolab.view.config.spring.sso.openid.OpenIdHelper;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("ProhibitedExceptionDeclared")
@EnableAuthorizationServer
@RestController
@Configuration
public class SsoServerConfig extends OAuth2AuthorizationServerConfiguration {

    private final TokenEnhancer tokenEnhancer;

    @Autowired
    public SsoServerConfig(BaseClientDetails details, AuthenticationManager authenticationManager,
            ObjectProvider<TokenStore> tokenStore,
            ObjectProvider<AccessTokenConverter> tokenConverter,
            AuthorizationServerProperties properties, TokenEnhancer tokenEnhancer) {
        super(details, authenticationManager, tokenStore, tokenConverter, properties);
        this.tokenEnhancer = tokenEnhancer;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenEnhancer(tokenEnhancer);
        super.configure(endpoints);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        super.configure(security);
    }

    @GetMapping(OpenIdHelper.OAUTH_USERINFO_ENDPOINT)
    public Map<String, Object> user(Member member) {
        OAuth2Authentication authentication =
                (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        final OpenIdHelper openIdHelper = new OpenIdHelper(authentication);
        Map<String, Object> map = new LinkedHashMap<>();
        openIdHelper.addSubjectField(map, member);
        if (openIdHelper.hasEmailScope()) {
            openIdHelper.addEmailScopedFields(map, member);
        }
        if (openIdHelper.hasProfileScope()) {
            openIdHelper.addProfileScopedFields(map, member);
        }
        return map;
    }

    @GetMapping("/.well-known/openid-configuration")
    public Map<String, Object> openIdConfiguration() {
        return OpenIdHelper.getOpenIdConfiguration();
    }

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.antMatcher(OpenIdHelper.OAUTH_USERINFO_ENDPOINT).authorizeRequests().anyRequest()
                    .authenticated();
        }
    }
}
