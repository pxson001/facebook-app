package com.facebook.push.registration;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.adm.ADMRegistrar;
import com.facebook.push.c2dm.C2DMRegistrar;
import com.facebook.push.fbns.FbnsRegistrar;
import com.facebook.push.fbnslite.FbnsLiteRegistrar;
import com.facebook.push.nna.NNARegistrar;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: has_top_border */
class FacebookPushServerRegistrar$LocalBroadcastReceiver$1 implements ActionReceiver {
    FacebookPushServerRegistrar$LocalBroadcastReceiver$1() {
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2118101703);
        if (intent != null && "com.facebook.push.registration.ACTION_ALARM".equals(intent.getAction()) && intent.hasExtra("serviceType")) {
            AppInitLockHelper.a(context);
            InjectorLike injectorLike = FbInjector.get(context);
            FacebookPushServerRegistrar a2 = FacebookPushServerRegistrar.a(injectorLike);
            String stringExtra = intent.getStringExtra("serviceType");
            if (stringExtra == null) {
                LogUtils.e(-460901601, a);
                return;
            }
            try {
                ServiceType valueOf = ServiceType.valueOf(stringExtra);
                switch (FacebookPushServerRegistrar$2.f11343b[valueOf.ordinal()]) {
                    case 1:
                        a2.a(valueOf, ADMRegistrar.a(injectorLike).a);
                        break;
                    case 2:
                        a2.a(valueOf, FbnsRegistrar.b(injectorLike).a);
                        break;
                    case 3:
                        a2.a(valueOf, C2DMRegistrar.a(injectorLike).a);
                        break;
                    case 4:
                        a2.a(valueOf, NNARegistrar.m13203a(injectorLike).f11322a);
                        break;
                    case 5:
                        a2.a(valueOf, FbnsLiteRegistrar.a(injectorLike).a);
                        break;
                }
                LogUtils.e(-1208272847, a);
                return;
            } catch (Throwable e) {
                BLog.b(FacebookPushServerRegistrar.a, e, "Failed to convert serviceType", new Object[0]);
                LogUtils.e(514014604, a);
                return;
            }
        }
        BLog.a(FacebookPushServerRegistrar.a, "Incorrect intent %s", new Object[]{intent});
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1158270420, a);
    }
}
