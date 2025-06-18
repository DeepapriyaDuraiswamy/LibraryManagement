package com.deepa.book.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.deepa.book.library.service.ChatService;

import reactor.core.publisher.Mono;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    // WebSocket: client sends to /app/message
    @MessageMapping("/message")
    @SendTo("/topic/replies")
    public Mono<String> handleMessage(String message) {
        return chatService.getReply(message);
    }
}
