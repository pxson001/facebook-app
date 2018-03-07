package com.facebook.xconfig.sync;

import com.facebook.debug.log.BLog;

/* compiled from: location_opt_in_confirmation_not_now_tapped */
class XSyncComponent$1 implements Runnable {
    final /* synthetic */ XSyncComponent f9940a;

    XSyncComponent$1(XSyncComponent xSyncComponent) {
        this.f9940a = xSyncComponent;
    }

    public void run() {
        try {
            this.f9940a.c.a(null).a();
        } catch (Throwable e) {
            BLog.c("XSyncComponent", e, "Pre-logout xconfig sync failed", new Object[0]);
        }
    }
}
