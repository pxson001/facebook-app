package com.facebook.runtimepermissions;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: answered */
public class ActivitylessRuntimePermissionsManagerProvider extends AbstractAssistedProvider<ActivitylessRuntimePermissionsManager> {
    public final ActivitylessRuntimePermissionsManager m19957a(Fragment fragment) {
        ActivitylessRuntimePermissionsManager activitylessRuntimePermissionsManager = new ActivitylessRuntimePermissionsManager(fragment);
        RuntimePermissionsUtil b = RuntimePermissionsUtil.b(this);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(this);
        activitylessRuntimePermissionsManager.f20392c = (Context) getInstance(Context.class);
        activitylessRuntimePermissionsManager.f20393d = b;
        activitylessRuntimePermissionsManager.f20394e = secureContextHelper;
        return activitylessRuntimePermissionsManager;
    }
}
