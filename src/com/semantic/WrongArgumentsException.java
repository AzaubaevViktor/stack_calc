package com.semantic;

import com.parser.Token;

public class WrongArgumentsException extends Exception {
    public final boolean toMany;
    public final boolean toFew;
    public final Token token;

    public WrongArgumentsException(boolean isToMany,
                                   boolean isToFew,
                                   Token token) {
        toMany = isToMany;
        toFew = isToFew;
        this.token = token;
    }

    public String toString() {
        if (toMany) {
            return "To many arguments";
        } else if (toFew) {
            return "To less arguments";
        } else {
            return "Incorrect argument";
        }
    }
}
