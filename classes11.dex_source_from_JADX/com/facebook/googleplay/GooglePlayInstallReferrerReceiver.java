package com.facebook.googleplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: albums/{#%s} */
public class GooglePlayInstallReferrerReceiver extends BroadcastReceiver {
    @Inject
    public FbWakeLockManager f10073a;

    @Deprecated
    private static <T> void m10420a(Class<T> cls, T t, Context context) {
        m10421a(t, context);
    }

    public static void m10421a(Object obj, Context context) {
        ((GooglePlayInstallReferrerReceiver) obj).f10073a = FbWakeLockManager.a(FbInjector.get(context));
    }

    private void m10419a(FbWakeLockManager fbWakeLockManager) {
        this.f10073a = fbWakeLockManager;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1843743446);
        if (this.f10073a == null) {
            Class cls = GooglePlayInstallReferrerReceiver.class;
            m10421a(this, context);
        }
        GooglePlayInstallRefererService.m10413a(context, intent, this.f10073a);
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1721655410, a);
    }
}
