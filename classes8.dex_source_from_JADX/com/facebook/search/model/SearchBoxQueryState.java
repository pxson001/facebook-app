package com.facebook.search.model;

import java.util.Locale;

/* compiled from: TINT */
public enum SearchBoxQueryState {
    TYPED,
    NULL_STATE,
    SINGLE_STATE;

    public final String toString() {
        return name().toLowerCase(Locale.US);
    }
}
