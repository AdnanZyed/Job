package com.example.job.models;

import java.util.List;

public class FilterResponse {
    private boolean status;
    private Message message;
    private List<FilterItem> data;

    public boolean isStatus() { return status; }
    public Message getMessage() { return message; }
    public List<FilterItem> getData() { return data; }

    public class Message {
        private String message;
        public String getMessage() { return message; }
    }
}
