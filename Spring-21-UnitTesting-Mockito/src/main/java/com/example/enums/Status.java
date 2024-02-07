package com.example.enums;

public enum Status {
    Open("Open"),IN_PROGRESS("In Progress"),COMPLETE("Completed");
    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
