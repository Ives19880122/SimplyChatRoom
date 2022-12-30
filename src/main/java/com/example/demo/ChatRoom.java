package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class ChatRoom {

    private String name;
    private Sinks.Many<ChatMessage> sink;
    private Flux<ChatMessage> flux;

    public ChatRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joinRoom(ChatMember chatMember) {
        System.out.printf("%s --- Joined --- %s \n", chatMember.getName(), this.name);
        this.subscribe(chatMember);
        chatMember.setMessageConsumer(msg -> this.postMessage(msg, chatMember));
    }

    private void subscribe(ChatMember chatMember) {
        this.flux
                .filter(sh -> !chatMember.getName().equals(sh.getFrom()))
                .doOnNext(sh -> sh.setTo(chatMember.getName()))
                .map(ChatMessage::toString)
                .subscribe(chatMember::receives);
    }

    private void postMessage(String msg, ChatMember chatMember) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setFrom(chatMember.getName());
        chatMessage.setMsg(msg);
        this.sink.tryEmitNext(chatMessage);
    }
}
