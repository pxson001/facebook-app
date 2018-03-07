package com.facebook.content;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import javax.annotation.Nullable;

/* compiled from: free_facebook_settings */
public class DefaultInternalIntentHandler implements InternalIntentHandler {
    public final boolean mo3407a(Intent intent, Context context) {
        context.startActivity(intent);
        return true;
    }

    public final boolean mo3405a(Intent intent, int i, Activity activity) {
        activity.startActivityForResult(intent, i);
        return true;
    }

    public final boolean mo3406a(Intent intent, int i, Fragment fragment) {
        fragment.m248a(intent, i);
        return true;
    }

    @Nullable
    public final ComponentName mo3408b(Intent intent, Context context) {
        return context.startService(intent);
    }
}
