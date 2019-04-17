package com.tq.hacknight4.financr.Config;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.request.SandboxPublicTokenCreateRequest;
import com.plaid.client.request.common.Product;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Response;

@Configuration
public class PlaidConfig {

    public static final String FIRST_PLATYPUS_BANK_INSTITUTION_ID = "ins_109508";
    public static final String FIRST_GINGHAM_CREDIT_UNION_INSTITION_ID = "ins_109509";
    public static final String TATTERSALL_FEDERAL_CREDIT_UNION_INSTITUTION_ID = "ins_109510";
    public static final String TARTAN_BANK_INSTITUTION_ID = "ins_109511";
    public static final String HOUNDSTOOTH_BANK_INSTITUTION_ID = "ins_109512";

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

    String publicToken =
        getClient()
            .service()
            .sandboxPublicTokenCreate(new SandboxPublicTokenCreateRequest(FIRST_PLATYPUS_BANK_INSTITUTION_ID,
                Collections.singletonList(Product.TRANSACTIONS)))
            .execute()
            .body()
            .getPublicToken();

      // Synchronously exchange a Link public_token for an API access_token
      // Required request parameters are always Request object constructor arguments
      Response<ItemPublicTokenExchangeResponse> response = getClient().service()
          .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(publicToken)).execute();

        return response.body().getAccessToken();

    }

}
