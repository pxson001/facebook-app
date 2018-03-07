package com.facebook.http.protocol;

import java.io.IOException;

/* compiled from: dialtone_mode_selection_interstitial_full_fb_button_click */
public class LimitExceededException extends IOException {
    public LimitExceededException(long j, int i) {
        super("Exceeded limit of " + j + " bytes by " + i + " bytes");
    }
}
