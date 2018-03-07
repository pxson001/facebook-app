package com.facebook.notifications.widget;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: method/mobile.zeroBalanceDetection */
public class NotificationsFragment$16 implements ActionReceiver {
    final /* synthetic */ NotificationsFragment f9048a;

    public NotificationsFragment$16(NotificationsFragment notificationsFragment) {
        this.f9048a = notificationsFragment;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1131735461);
        this.f9048a.bJ = Optional.of(Long.valueOf(this.f9048a.ar.a()));
        if (this.f9048a.bF == null || this.f9048a.bF.isEmpty() || ((NotificationsEdgeFields) this.f9048a.bF.get(0)).k() == null) {
            this.f9048a.bK = Absent.INSTANCE;
        } else {
            this.f9048a.bK = Optional.of(Long.valueOf(((NotificationsEdgeFields) this.f9048a.bF.get(0)).k().V()));
        }
        LogUtils.e(-1263419729, a);
    }
}
