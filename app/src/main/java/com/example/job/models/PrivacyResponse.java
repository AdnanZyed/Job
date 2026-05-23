package com.example.job.models;

public class PrivacyResponse {
    private boolean status;
    private Message message;
    private PrivacyData data;

    public boolean isStatus() { return status; }
    public Message getMessage() { return message; }
    public PrivacyData getData() { return data; }

    public static class Message {
        private String message;
        public String getMessage() { return message; }
    }
}
