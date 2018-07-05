package me.wjx.block_queue;

import java.util.UUID;

/**
 * @author wjx
 * @date 2018/7/3 10:42
 */
public class Message {
    private  String id= UUID.randomUUID().toString();
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
