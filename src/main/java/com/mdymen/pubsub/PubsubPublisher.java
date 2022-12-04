package com.mdymen.pubsub;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PubsubPublisher {

    private final PubSubTemplate pubSubTemplate;

    public void publishMessage(String mensagem) {
        // Passamos para o metodo publish o nosso topico criado e a mensagem recebida
        this.pubSubTemplate.publish("projects/pubsub-teste-370601/topics/my-topic-teste", TestObject.builder().text(mensagem).build());
        // O pubSubTemplate publica a mensagem no topico "my-topic-teste"
        System.out.println("Mensagem publicada!!! ");
    }
}