package com.deepa.book.library.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final WebClient webClient;

    public ChatService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer YOUR_OPENAI_API_KEY")
                .build();
    }

    public Mono<String> getReply(String message) {
        return webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of(
                        "model", "gpt-3.5-turbo",
                        "messages", List.of(Map.of("role", "user", "content", message))
                ))
                .retrieve()
                .bodyToMono(String.class) // Or use ChatResponse.class if mapping JSON
                .map(this::extractText);
    }

    private String extractText(String json) {
        // TODO: Parse actual response JSON using Jackson or simple string extraction
        return "ChatGPT says: [Placeholder]";
    }
}

