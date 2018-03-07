package com.facebook.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import javax.inject.Inject;

/* compiled from: sensor_power */
public class DefaultExternalIntentHandler implements ExternalIntentHandler {
    private final IntentSanitizer f2844a;

    @Inject
    public DefaultExternalIntentHandler(IntentSanitizer intentSanitizer) {
        this.f2844a = intentSanitizer;
    }

    public final boolean mo581a(Intent intent, Context context) {
        this.f2844a.m3984a(intent);
        context.startActivity(intent);
        return true;
    }

    public final boolean mo579a(Intent intent, int i, Activity activity) {
        this.f2844a.m3984a(intent);
        activity.startActivityForResult(intent, i);
        return true;
    }

    public final boolean mo580a(Intent intent, int i, Fragment fragment) {
        this.f2844a.m3984a(intent);
        fragment.a(intent, i);
        return true;
    }
}
