package com.facebook.katana;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.AppInitLock.Listener;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.provider.legacykeyvalue.UserValuesManager;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession$LogoutReason;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: subdomain */
public class FacebookAccountReceiver extends BroadcastReceiver {
    private static final Class<?> f1610a = FacebookAccountReceiver.class;

    public void onReceive(final Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2057603358);
        final Intent intent2 = (Intent) intent.clone();
        AppInitLock.a(FbInjector.get(context)).a(new Listener(this) {
            final /* synthetic */ FacebookAccountReceiver f1613c;

            public final void m1851a() {
                FacebookAccountReceiver.m1850a(context);
            }
        });
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1903762973, a);
    }

    public static void m1850a(Context context) {
        String b = UserValuesManager.m11492b(context);
        if (b != null) {
            if (FacebookAuthenticationService.m1124a(context, b) != null) {
                new StringBuilder("Account still exists: ").append(b);
                return;
            }
            AppSession a = AppSession.a(context, false);
            if (a != null) {
                if (BLog.b(3)) {
                    new StringBuilder("Session status: ").append(a.f);
                }
                switch (2.a[a.f.ordinal()]) {
                    case 1:
                        return;
                    case 2:
                        if (BLog.b(3)) {
                            new StringBuilder("Logging out: ").append(b);
                        }
                        a.a(context, AppSession$LogoutReason.ACCOUNT_REMOVED);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
