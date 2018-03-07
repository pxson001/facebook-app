package com.facebook.transliteration;

/* compiled from: extra_js_to_execute */
public enum Algorithm {
    UNIGRAM,
    BIGRAM;

    public static Algorithm fromOrdinal(int i) {
        return values()[i];
    }
}
