package com.facebook.composer.minutiae;

import android.app.Activity;
import com.facebook.inject.Assisted;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import javax.inject.Inject;

/* compiled from: total_assets_count */
public class RidgeRuntimePermissionManager {
    public static final String[] f1452a = new String[]{"android.permission.RECORD_AUDIO"};
    public final ActivityRuntimePermissionsManager f1453b;
    public final String f1454c;

    @Inject
    public RidgeRuntimePermissionManager(@Assisted Activity activity, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f1453b = activityRuntimePermissionsManagerProvider.a(activity);
        this.f1454c = activity.getString(2131234704);
    }

    public final void m1536a(RuntimePermissionsListener runtimePermissionsListener) {
        this.f1453b.a(f1452a, runtimePermissionsListener);
    }
}
