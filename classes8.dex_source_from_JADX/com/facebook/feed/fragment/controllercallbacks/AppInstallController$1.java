package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.feed.platformads.listener.AppInstalledListener.InstalledAppInfo;
import com.facebook.feed.ui.InstallNotificationBeeper;

/* compiled from: group_side_conversation_displayed */
class AppInstallController$1 implements Runnable {
    final /* synthetic */ InstalledAppInfo f11878a;
    final /* synthetic */ AppInstallController f11879b;

    AppInstallController$1(AppInstallController appInstallController, InstalledAppInfo installedAppInfo) {
        this.f11879b = appInstallController;
        this.f11878a = installedAppInfo;
    }

    public void run() {
        if (this.f11879b.e != null) {
            if (this.f11879b.d == null) {
                this.f11879b.d = (InstallNotificationBeeper) this.f11879b.e.inflate();
            }
            if (!this.f11879b.d.b(this.f11878a)) {
                this.f11879b.d.a(this.f11878a);
                this.f11879b.b.b(this.f11879b.d);
            }
        }
    }
}
