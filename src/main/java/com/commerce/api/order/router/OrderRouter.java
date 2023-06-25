package com.commerce.api.order.router;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
@RequiredArgsConstructor
public class OrderRouter {

    public RouterFunction<ServerResponse> orderApi(final OrderHandler orderHandler) {
        return RouterFunctions.route()
                .GET("/orders/{orderId}", orderHandler::getOrder)
                .build();
    }
}
