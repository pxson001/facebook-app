package com.google.common.base;

import java.util.Arrays;

/* compiled from: can_override */
final class CharMatcher$AnyOf extends CharMatcher {
    private final char[] chars;

    @Deprecated
    public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return super.apply((Character) obj);
    }

    public CharMatcher$AnyOf(CharSequence charSequence) {
        this.chars = charSequence.toString().toCharArray();
        Arrays.sort(this.chars);
    }

    public final boolean matches(char c) {
        return Arrays.binarySearch(this.chars, c) >= 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
        for (char showCharacter : this.chars) {
            stringBuilder.append(CharMatcher.showCharacter(showCharacter));
        }
        stringBuilder.append("\")");
        return stringBuilder.toString();
    }
}
