package com.example.demo;

public class ChatRoomDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom("demoRoom");
        ChatMember mart = new ChatMember("mart");
        ChatMember jack = new ChatMember("jack");

        chatRoom.joinRoom(mart);
        mart.says("Hi everyOne");

        chatRoom.joinRoom(jack);
        jack.says("Good Morning");
        mart.says("It is a good Day!!");

        ChatMember ives = new ChatMember("ives");
        chatRoom.joinRoom(ives);
    }
}
