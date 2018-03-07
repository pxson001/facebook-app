package com.facebook.common.i18n;

import java.text.BreakIterator;

/* compiled from: sparse.shift */
public class StringLengthHelper {
    public static int m3728a(String str) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.last();
    }
}
