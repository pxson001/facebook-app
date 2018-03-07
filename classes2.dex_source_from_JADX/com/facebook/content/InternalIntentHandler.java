package com.facebook.content;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import javax.annotation.Nullable;

/* compiled from: fresh_definition */
public interface InternalIntentHandler {
    boolean mo3405a(Intent intent, int i, Activity activity);

    boolean mo3406a(Intent intent, int i, Fragment fragment);

    boolean mo3407a(Intent intent, Context context);

    @Nullable
    ComponentName mo3408b(Intent intent, Context context);
}
