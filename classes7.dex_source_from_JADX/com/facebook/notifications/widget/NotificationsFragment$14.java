package com.facebook.notifications.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.event.NotificationsEvents.NotificationsSubscriptionUpdatedEvent;

/* compiled from: method/mobile.zeroBalanceDetection */
public class NotificationsFragment$14 implements OnClickListener {
    final /* synthetic */ int f9044a;
    final /* synthetic */ NotificationsSubscriptionUpdatedEvent f9045b;
    final /* synthetic */ NotificationsFragment f9046c;

    public NotificationsFragment$14(NotificationsFragment notificationsFragment, int i, NotificationsSubscriptionUpdatedEvent notificationsSubscriptionUpdatedEvent) {
        this.f9046c = notificationsFragment;
        this.f9044a = i;
        this.f9045b = notificationsSubscriptionUpdatedEvent;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1799865783);
        this.f9046c.bb.a(this.f9044a, this.f9045b.e);
        this.f9046c.aV.a(this.f9045b.c, "long_press", this.f9045b.a, this.f9044a);
        Logger.a(2, EntryType.UI_INPUT_END, 1272444379, a);
    }
}
