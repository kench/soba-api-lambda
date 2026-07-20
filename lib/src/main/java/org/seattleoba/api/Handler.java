package org.seattleoba.api;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;

import java.util.Collections;

import org.crac.Resource;

public class Handler implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse>, Resource {
    @Override
    public void beforeCheckpoint(org.crac.Context<? extends Resource> context) throws Exception {
        // TODO: Save dependency state once they exist.
    }

    @Override
    public void afterRestore(org.crac.Context<? extends Resource> context) throws Exception {
        // TODO: Restore dependencies once they exist.
    }

    @Override
    public APIGatewayV2HTTPResponse handleRequest(final APIGatewayV2HTTPEvent input, final Context context) {
        return APIGatewayV2HTTPResponse.builder()
                .withHeaders(Collections.singletonMap("Content-Type", "text-plain"))
                .withBody("Hello world!")
                .withStatusCode(404)
                .build();
    }
}
