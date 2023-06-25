package com.commerce.api.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {

    public Mono<String> findOrder() {
        return Mono.empty();
    }
}
