package com.google.common.base;

/* compiled from: can_override */
final class CharMatcher$Or extends CharMatcher {
    final CharMatcher first;
    final CharMatcher second;

    @Deprecated
    public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return super.apply((Character) obj);
    }

    CharMatcher$Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
        this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
    }

    public final boolean matches(char c) {
        return this.first.matches(c) || this.second.matches(c);
    }

    public final String toString() {
        return "CharMatcher.or(" + this.first + ", " + this.second + ")";
    }
}
