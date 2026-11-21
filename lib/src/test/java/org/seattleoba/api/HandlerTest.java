package org.seattleoba.api;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import java.util.Map;
import org.crac.Context;
import org.crac.Resource;
import org.junit.jupiter.api.Test;

class HandlerTest {
  private final Handler handler = new Handler();

  @Test
  void returnsNotFoundStatusCode() {
    final APIGatewayV2HTTPResponse response = handler.handleRequest(null, null);

    assertEquals(404, response.getStatusCode());
    assertEquals("Hello world!", response.getBody());
    assertEquals(Map.of("Content-Type", "text-plain"), response.getHeaders());
  }

  @Test
  @SuppressWarnings("unchecked")
  void survivesSnapStartCheckpointAndRestore() {
    final Context<? extends Resource> context = mock(Context.class);

    assertDoesNotThrow(() -> handler.beforeCheckpoint(context));
    assertDoesNotThrow(() -> handler.afterRestore(context));
  }
}
