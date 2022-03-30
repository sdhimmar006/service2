//package com.example.demo;
//
//import com.google.cloud.opentelemetry.trace.TraceConfiguration;
//import com.google.cloud.opentelemetry.trace.TraceExporter;
//import io.opentelemetry.sdk.trace.export.SpanExporter;
//import lombok.SneakyThrows;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Config {
//
//
//    @Bean
//    @SneakyThrows
//    public SpanExporter googleTraceExporter() {
//        return TraceExporter.createWithConfiguration(
//                TraceConfiguration.builder()
//                        .build()
//        );
//    }
//
//
//}
