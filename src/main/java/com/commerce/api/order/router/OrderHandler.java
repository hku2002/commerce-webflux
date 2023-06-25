package com.commerce.api.order.router;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrderHandler {

    public Mono<ServerResponse> getOrder(final ServerRequest serverRequest) {
        return Mono.empty();
    }
}
