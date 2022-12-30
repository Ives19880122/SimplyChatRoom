package com.example.demo;

import java.util.function.Consumer;

public class ChatMember {
    private String name;
    private Consumer<String> messageConsumer;

    public ChatMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receives(String msg) {
        System.out.println(msg);
    }

    public void says(String msg) {
        this.messageConsumer.accept(msg);
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
}
