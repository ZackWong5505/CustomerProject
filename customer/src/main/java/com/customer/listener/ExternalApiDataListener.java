package com.customer.listener;

import com.customer.event.ExternalApiDataEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ExternalApiDataListener {

    @Async
    @EventListener
    public void handleExternalApiDataEvent(ExternalApiDataEvent event) {
        System.out.println("Handling event data: " + event.getData());
    }
}