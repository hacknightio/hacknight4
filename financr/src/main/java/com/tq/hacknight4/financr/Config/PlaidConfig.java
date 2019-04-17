package com.tq.hacknight4.financr.Config;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Response;

@Configuration
public class PlaidConfig {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value(value="${financr.client_id}")
    String clientId;

    @Value(value="${financr.secret}")
    String secret;

    @Value(value="${financr.public_key}")
    String publicKey;

    @Bean
    PlaidClient getClient() {
        return PlaidClient.newBuilder().clientIdAndSecret(clientId, secret)
                                .publicKey(publicKey)
                                .sandboxBaseUrl()
                                .build();
    }


    @Bean("api_token")
    String getToken() throws IOException {
      // Synchronously exchange a Link public_token for an API access_token
      // Required request parameters are always Request object constructor arguments
      Response<ItemPublicTokenExchangeResponse> response = getClient().service()
          .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest("the_link_public_token")).execute();

        return response.body().getAccessToken();

    }

}
