package com.dash.a02_event_bus;

/**
 * Created by Dash on 2018/3/9.
 */
public class ToastEvent {
    private String content;

    public ToastEvent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
