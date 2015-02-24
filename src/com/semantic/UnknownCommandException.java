package com.semantic;

import com.parser.Token;


public class UnknownCommandException extends Exception {
    public Token token;
    public UnknownCommandException(Token token) {
        this.token = token;
    }
}
