package com.facebook.analytics.impression;

import android.app.Activity;
import android.content.Context;
import javax.inject.Inject;

/* compiled from: queries */
public class ImpressionActivityListener {
    private final ImpressionManager f8456a;

    @Inject
    public ImpressionActivityListener(ImpressionManager impressionManager) {
        this.f8456a = impressionManager;
    }

    public final void m13013a(Activity activity) {
        this.f8456a.m5538a((Context) activity);
    }
}
