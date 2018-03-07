package com.facebook.runtimepermissions;

import android.app.Activity;
import com.facebook.content.AppInfo;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: extra_on_messenger_map */
public class ActivityRuntimePermissionsManagerProvider extends AbstractAssistedProvider<ActivityRuntimePermissionsManager> {
    public final ActivityRuntimePermissionsManager m13233a(Activity activity) {
        return new ActivityRuntimePermissionsManager(activity, AppInfo.a(this), RuntimePermissionsUtil.b(this));
    }
}
