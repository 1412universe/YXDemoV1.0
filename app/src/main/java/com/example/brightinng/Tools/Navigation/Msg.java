package com.example.brightinng.Tools.Navigation;

public class Msg {
    public static final int TYPE_RECEIVED = 0; //消息类型的值 收到的消息
    public static final int TYPE_SENT = 1; //消息类型的值 发送的消息
    private int type; //消息类型
    private String content; //消息内容

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}