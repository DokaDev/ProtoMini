package com.infinityIterators.view.interaction;

public enum DisplayType {
    NORMAL("\u001B[0m"),
    ERROR("\u001B[31m"),
    SYSTEM("\u001B[95m"),
    MENU("\u001B[32m"),
    MENU_HEADER("\u001B[34m"),
    DESCRIPTION("\u001B[33m");

    private final String code;
    DisplayType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}