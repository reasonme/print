package cn.fintecher.print.model;

/**
 * Created by sun on 2017/4/25 0025.
 */
public class WebSocketMessage<T> {
    private String messageType;
    T data;
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public WebSocketMessage(String messageType) {
        this.messageType = messageType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
