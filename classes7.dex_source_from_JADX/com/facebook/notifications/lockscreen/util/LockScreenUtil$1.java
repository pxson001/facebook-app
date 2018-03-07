package com.facebook.notifications.lockscreen.util;

import com.facebook.common.executors.NamedRunnable;
import com.facebook.notifications.lockscreen.db.PushNotificationDbHelper;

/* compiled from: newSelectedPosition needs to be valid */
public class LockScreenUtil$1 extends NamedRunnable {
    final /* synthetic */ LockScreenUtil f8228c;

    public LockScreenUtil$1(LockScreenUtil lockScreenUtil, String str, String str2) {
        this.f8228c = lockScreenUtil;
        super(str, str2);
    }

    public void run() {
        ((PushNotificationDbHelper) this.f8228c.m.get()).m9799b();
        this.f8228c.h();
    }
}
