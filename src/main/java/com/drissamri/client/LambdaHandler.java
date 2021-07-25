package com.drissamri.client;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.drissamri.client.core.AppConfig;
import com.drissamri.client.core.http.HttpResponses;
import com.drissamri.client.model.Client;
import com.drissamri.client.service.ClientService;
import com.fasterxml.jackson.jr.ob.JSON;
import org.apache.logging.log4j.LogManager;
import software.amazon.lambda.powertools.logging.Logging;

import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Logger LOG = LogManager.getLogger();
    private final ClientService clientService;

    public LambdaHandler() {
        this(AppConfig.clientService());
    }

    public LambdaHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    @Logging
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        try {
            Client client = JSON.std.beanFrom(Client.class, event.getBody());
            LOG.info("Creating client: {}", client);
            clientService.create(client);
            LOG.info("Client created: {}", client.getName());
            return HttpResponses.ok(JSON.std.asString(client));
        } catch (IOException ex) {
            LOG.warn("Invocation failed: {}", ex.getMessage());
            return HttpResponses.unprocessableEntity("Invalid input");
        }
    }
}
