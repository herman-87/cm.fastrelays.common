package cm.fastrelay.common.config;

import cm.fastrelay.keycloak.api.KeycloakAdminUserApi;
import cm.fastrelay.keycloak.api.KeycloakAuthApi;
import cm.fastrelay.common.security.TokenRequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class KeycloakRestClientConfig {

  @Value("${keycloak.admin.api.base-url}")
  private String keycloakAdminBaseUrl;

  @Value("${keycloak.token.api.base-url}")
  private String keycloakTokenBaseUrl;

  @Bean
  public KeycloakAdminUserApi keycloakAdminUserApi() {
    RestClient restClient =
        RestClient.builder()
            .baseUrl(keycloakAdminBaseUrl)
            .requestInterceptor(new TokenRequestInterceptor())
            .requestFactory(new SimpleClientHttpRequestFactory())
            .build();

    RestClientAdapter adapter = RestClientAdapter.create(restClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

    return factory.createClient(KeycloakAdminUserApi.class);
  }

  @Bean
  public KeycloakAuthApi keycloakAuthApi() {
    RestClient restClient =
        RestClient.builder()
            .baseUrl(keycloakTokenBaseUrl)
            .requestFactory(new SimpleClientHttpRequestFactory())
            .build();

    RestClientAdapter adapter = RestClientAdapter.create(restClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

    return factory.createClient(KeycloakAuthApi.class);
  }
}
