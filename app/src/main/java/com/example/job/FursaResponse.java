package com.example.job;

import java.util.List;

public class FursaResponse {
    private boolean status;
    private Message message;
    private List<FursaItem> data;

    public boolean isStatus() { return status; }
    public Message getMessage() { return message; }
    public List<FursaItem> getData() { return data; }

    public class Message {
        private String message;
        public String getMessage() { return message; }
    }
}
