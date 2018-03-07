package com.facebook.camera.support;

import android.content.Intent;

/* compiled from: all_top_stories */
public class CameraSupport$TypedIntent {
    public Intent f10974a;
    public IntentType f10975b;

    /* compiled from: all_top_stories */
    public enum IntentType {
        INTERNAL,
        EXTERNAL
    }

    public CameraSupport$TypedIntent(Intent intent, IntentType intentType) {
        this.f10974a = intent;
        this.f10975b = intentType;
    }
}
