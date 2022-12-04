package com.mdymen.pubsub;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gcp.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
        return new JacksonPubSubMessageConverter(new ObjectMapper());
    }

}
