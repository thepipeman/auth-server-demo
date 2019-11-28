package com.pipecrafts.authserverdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients
          .inMemory()
          .withClient("first-client")
          .secret(passwordEncoder.encode("noonewilleverguess"))
          .scopes("resource:read")
          .authorizedGrantTypes("authorization_code")
          .redirectUris("http://localhost:8081/oauth/login/client-app");
   }

}
