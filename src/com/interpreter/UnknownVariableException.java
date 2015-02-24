package com.interpreter;

public class UnknownVariableException extends Exception {
    static public int line = -1;
    static public int pos = -1;
}
