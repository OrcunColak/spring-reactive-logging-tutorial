package com.colak.springtutorial.config;

import com.colak.springtutorial.util.logging.LoggingUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/**
 * context is updated and sent to the filter chain
 */

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)

@Slf4j
public class CorrelationIdFilterConfiguration implements WebFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestId = LoggingUtil.getCorrelationId(request.getHeaders());
        return chain
                .filter(exchange)
                .doOnEach(LoggingUtil.logOnEach(r -> log.info("{} {}", request.getMethod(), request.getURI())))
                .contextWrite(Context.of(LoggingUtil.CONTEXT_KEY, requestId))
                .doFinally((r) -> MDC.clear());
    }
}
