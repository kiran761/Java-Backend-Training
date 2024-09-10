//package com.example.LbGateway;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringCloudConfiguration {
//    @Bean
//     RouteLocator gatewayRoutes(RouteLocatorBuilder builder)
//    {
//        return
//                builder.routes().
//                        route(
//                                "LbService-route",
//                                r-> r.path("/test/**")
//                                        .uri("lb://LBSERVICE")
//                        )
//                                 .build();
//
//    }
//}
