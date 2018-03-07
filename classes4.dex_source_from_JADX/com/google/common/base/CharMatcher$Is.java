package com.google.common.base;

import com.google.common.base.CharMatcher.FastMatcher;

/* compiled from: wrong_channel */
final class CharMatcher$Is extends FastMatcher {
    private final char match;

    CharMatcher$Is(char c) {
        this.match = c;
    }

    public final boolean matches(char c) {
        return c == this.match;
    }

    public final CharMatcher or(CharMatcher charMatcher) {
        return charMatcher.matches(this.match) ? charMatcher : super.or(charMatcher);
    }

    public final String toString() {
        return "CharMatcher.is('" + CharMatcher.showCharacter(this.match) + "')";
    }
}
