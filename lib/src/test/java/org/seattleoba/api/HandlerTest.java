package org.seattleoba.api;

import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandlerTest {
    @Test void returnsNotFoundStatusCode() {
        final Handler handler = new Handler();

        final APIGatewayV2HTTPResponse response = handler.handleRequest(null, null);

        assertEquals(404, response.getStatusCode());
    }
}
