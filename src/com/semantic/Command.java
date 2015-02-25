package com.semantic;

import com.interpreter.State;
import com.interpreter.UnknownVariableException;
import com.parser.Line;


public abstract class Command {
    public abstract void init(Line line) throws WrongArgumentsException;
    public abstract void calculate(State st) throws UnknownVariableException;
}
