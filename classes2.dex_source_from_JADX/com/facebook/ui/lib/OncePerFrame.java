package com.facebook.ui.lib;

import android.annotation.SuppressLint;

/* compiled from: num_dismiss_since_last_photo_prompt_post */
public class OncePerFrame {
    private long f11972a = 0;
    private int f11973b = 0;

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public final boolean m17667a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f11973b >= 10) {
            this.f11973b = 0;
            this.f11972a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - this.f11972a < 16) {
            this.f11973b++;
            return true;
        } else {
            this.f11972a = currentTimeMillis;
            this.f11973b = 0;
            return false;
        }
    }
}
