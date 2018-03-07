package com.facebook.location;

import android.app.PendingIntent;
import android.content.Intent;
import javax.annotation.Nullable;

/* compiled from: jniexecutors */
public interface FbLocationContinuousListener {
    @Nullable
    ImmutableLocation mo784a(Intent intent);

    void mo785a(PendingIntent pendingIntent);

    void mo786a(PendingIntent pendingIntent, FbLocationContinuousListenerParams fbLocationContinuousListenerParams);
}
