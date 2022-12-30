package com.example.demo;

import lombok.Data;

@Data
public class ChatMessage {
    private String from;
    private String to;
    private String msg;

    @Override
    public String toString() {
        return String.format("%s-> %s : %s", from, to, msg);
    }
}
