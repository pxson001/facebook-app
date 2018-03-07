package com.facebook.notifications.widget;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.base.Absent;

/* compiled from: method/mobile.zeroBalanceDetection */
public class NotificationsFragment$15 implements ActionReceiver {
    final /* synthetic */ NotificationsFragment f9047a;

    public NotificationsFragment$15(NotificationsFragment notificationsFragment) {
        this.f9047a = notificationsFragment;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1595927397);
        Object obj = (!this.f9047a.bJ.isPresent() || this.f9047a.ar.a() - ((Long) this.f9047a.bJ.get()).longValue() <= this.f9047a.aY.s() * 1000) ? null : 1;
        if (obj != null) {
            int i = this.f9047a.bm;
            NotificationsFragment.av(this.f9047a);
            this.f9047a.bm = NotificationsFragment.at(this.f9047a);
            NotificationsFragment.ar(this.f9047a);
            if (this.f9047a.aY.I()) {
                NotificationsFragment.f(this.f9047a, i);
            }
            AdapterDetour.a(this.f9047a.bb, 2061818367);
        }
        this.f9047a.bJ = Absent.INSTANCE;
        LogUtils.e(588879530, a);
    }
}
