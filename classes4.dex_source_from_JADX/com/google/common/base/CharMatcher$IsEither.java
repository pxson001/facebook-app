package com.google.common.base;

import com.google.common.base.CharMatcher.FastMatcher;

/* compiled from: wrong_channel */
public final class CharMatcher$IsEither extends FastMatcher {
    private final char match1;
    private final char match2;

    public CharMatcher$IsEither(char c, char c2) {
        this.match1 = c;
        this.match2 = c2;
    }

    public final boolean matches(char c) {
        return c == this.match1 || c == this.match2;
    }

    public final String toString() {
        return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.match1) + CharMatcher.showCharacter(this.match2) + "\")";
    }
}
