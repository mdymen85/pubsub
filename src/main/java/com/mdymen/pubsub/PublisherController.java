package com.mdymen.pubsub;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filas")
@RequiredArgsConstructor
public class PublisherController {


    private final PubsubPublisher pubsubPublisher;

    // injetando a nossa service que ira publicar a mensagem
    @GetMapping("/publish/{mensagem}")
    public void publicar(@PathVariable String mensagem) {
        pubsubPublisher.publishMessage(mensagem);
        // envia a mensagem passsada como parametro para a service
        System.out.println("Recebida no controller !!!");
    }
}