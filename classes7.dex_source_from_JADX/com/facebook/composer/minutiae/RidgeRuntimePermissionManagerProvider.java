package com.facebook.composer.minutiae;

import android.app.Activity;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;

/* compiled from: topics_set_favorites */
public class RidgeRuntimePermissionManagerProvider extends AbstractAssistedProvider<RidgeRuntimePermissionManager> {
    public final RidgeRuntimePermissionManager m1537a(Activity activity) {
        return new RidgeRuntimePermissionManager(activity, (ActivityRuntimePermissionsManagerProvider) getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }
}
