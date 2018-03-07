package com.facebook.platform.webdialogs;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.platform.common.activity.PlatformActivityRequest;

/* compiled from: location_older_than_last_geofence */
public class PlatformActivityWebDialogsRequest extends PlatformActivityRequest {
    public Bundle f8475a;
    public Bundle f8476b;

    protected final boolean m8384a(Intent intent) {
        this.f8475a = intent.getExtras();
        return true;
    }

    protected final boolean m8385a(Bundle bundle) {
        this.f8476b = bundle;
        if (this.f8476b == null) {
            this.f8476b = new Bundle();
        }
        return true;
    }
}
