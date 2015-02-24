package com.semantic;

import com.parser.Line;

public abstract class CommandCreator {
    public abstract String commandName();
    public abstract Command lineHandler(Line line) throws WrongArgumentsException;
}
