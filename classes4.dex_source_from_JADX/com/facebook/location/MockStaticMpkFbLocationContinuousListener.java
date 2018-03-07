package com.facebook.location;

import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import javax.annotation.Nullable;

/* compiled from: job_id */
public class MockStaticMpkFbLocationContinuousListener implements FbLocationContinuousListener {
    public final void mo786a(PendingIntent pendingIntent, FbLocationContinuousListenerParams fbLocationContinuousListenerParams) {
    }

    public final void mo785a(PendingIntent pendingIntent) {
    }

    @Nullable
    public final ImmutableLocation mo784a(Intent intent) {
        return ImmutableLocation.c((Location) intent.getParcelableExtra("location"));
    }
}
