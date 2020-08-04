package com.test.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component

public class FilterConfig implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isBlank(username)) {

            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);

            return exchange.getResponse().setComplete();

        }
        return chain.filter(exchange);
    }

    /**
     * 返回值越小   优先级越高。
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
