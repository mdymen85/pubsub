package com.mdymen.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PubsubConsumer implements ApplicationRunner {

    private final PubSubTemplate pubSubTemplate;
    private final JacksonPubSubMessageConverter jacksonPubSubMessageConverter;;

    @Override
    public void run(ApplicationArguments args) throws Exception {}

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        this.pubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter);
//
//        var result = pubSubTemplate.subscribeAndConvert("projects/pubsub-teste-370601/subscriptions/my-topic-teste-sub",convertedBasicAcknowledgeablePubsubMessage -> {
//
//            var testObject = convertedBasicAcknowledgeablePubsubMessage.getPayload();
//
//            System.out.println("mensagem recebida " + testObject);
//
//            convertedBasicAcknowledgeablePubsubMessage.ack();
//
//        },TestObject.class);
//
//    }
}