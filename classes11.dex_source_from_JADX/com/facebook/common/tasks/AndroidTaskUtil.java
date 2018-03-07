package com.facebook.common.tasks;

import android.app.ActivityManager;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: items_after */
public class AndroidTaskUtil {
    private final ActivityManager f5921a;

    private static AndroidTaskUtil m7337b(InjectorLike injectorLike) {
        return new AndroidTaskUtil(ActivityManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public AndroidTaskUtil(ActivityManager activityManager) {
        this.f5921a = activityManager;
    }
}
