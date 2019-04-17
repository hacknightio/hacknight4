package com.tq.hacknight4.financr.Config;

import com.plaid.client.PlaidClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaidConfig {

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


}
