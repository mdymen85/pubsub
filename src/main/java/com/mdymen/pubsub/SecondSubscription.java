package com.mdymen.pubsub;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.cloud.gcp.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

@Configuration
@Slf4j
public class SecondSubscription {

    // Create a message channel for messages arriving from the subscription `sub-one`.
    @Bean("inputMessageChannelSecond")
    public MessageChannel inputMessageChannelSecond() {
        return new PublishSubscribeChannel();
    }

    // Create an inbound channel adapter to listen to the subscription `sub-one` and send
// messages to the input message channel.
    @Bean
    public PubSubInboundChannelAdapter inboundChannelAdapterSecond(@Qualifier("inputMessageChannelSecond") MessageChannel messageChannel, PubSubTemplate pubSubTemplate) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "projects/pubsub-teste-370601/subscriptions/second");
        adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(TestObject.class);
        return adapter;
    }

    // Define what happens to the messages arriving in the message channel.
    @ServiceActivator(inputChannel = "inputMessageChannelSecond")
    public void messageReceiver(TestObject payload, @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
        log.info("Message arrived via an inbound channel adapter from sub-one! Payload: " + payload);
        message.ack();
    }

}
