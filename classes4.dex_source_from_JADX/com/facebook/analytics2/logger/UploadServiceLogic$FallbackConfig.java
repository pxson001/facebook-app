package com.facebook.analytics2.logger;

import android.os.Bundle;

/* compiled from: wifi_enabled */
public class UploadServiceLogic$FallbackConfig {
    public final long f91a;
    public final long f92b;

    public UploadServiceLogic$FallbackConfig(long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException("minDelayMs < 0");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("maxDelayMs < 0");
        } else if (j > j2) {
            throw new IllegalArgumentException("minDelay=" + j + "; maxDelay=" + j2);
        } else {
            this.f91a = j;
            this.f92b = j2;
        }
    }

    public UploadServiceLogic$FallbackConfig(Bundle bundle) {
        this(bundle.getLong("min_delay_ms", -1), bundle.getLong("max_delay_ms", -1));
    }
}
