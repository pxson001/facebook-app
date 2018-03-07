package com.facebook.http.protocol;

import java.io.IOException;

/* compiled from: dialtone_mode_selection_interstitial_impression */
public class InsufficientDataException extends IOException {
    public InsufficientDataException(long j, long j2) {
        super("Expected " + j2 + " bytes but got " + j + " bytes");
    }
}
