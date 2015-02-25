package com.semantic;


public class ConfigErrorException extends Exception {
    private final String lineStr;

    public ConfigErrorException(String lineStr) {
        this.lineStr = lineStr;
    }
}
