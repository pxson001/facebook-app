package com.facebook.appupdate;

import android.os.Handler;

/* compiled from: friend_confirmations */
public class AppUpdateInitializer {
    public final AppUpdateOperationFactory f11411a;
    public final AppUpdateFilesCleaner f11412b;
    public final Handler f11413c;

    public AppUpdateInitializer(AppUpdateOperationFactory appUpdateOperationFactory, AppUpdateFilesCleaner appUpdateFilesCleaner, Handler handler) {
        this.f11411a = appUpdateOperationFactory;
        this.f11412b = appUpdateFilesCleaner;
        this.f11413c = handler;
    }
}
