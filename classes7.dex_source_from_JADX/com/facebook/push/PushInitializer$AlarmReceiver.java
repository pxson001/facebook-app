package com.facebook.push;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;

/* compiled from: icon_image_before */
class PushInitializer$AlarmReceiver implements ActionReceiver {
    public PushInitializer f11216a;

    /* compiled from: icon_image_before */
    class C09901 implements Runnable {
        final /* synthetic */ PushInitializer$AlarmReceiver f11215a;

        C09901(PushInitializer$AlarmReceiver pushInitializer$AlarmReceiver) {
            this.f11215a = pushInitializer$AlarmReceiver;
        }

        public void run() {
            PushInitializer.j(this.f11215a.f11216a);
            PushInitializer.k(this.f11215a.f11216a);
        }
    }

    PushInitializer$AlarmReceiver() {
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -845146868);
        AppInitLockHelper.a(context);
        this.f11216a = PushInitializer.a(FbInjector.get(context));
        this.f11216a.f.set(false);
        ExecutorDetour.a(this.f11216a.d, new C09901(this), -397550243);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -462023502, a);
    }
}
