package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.WearableExtender;
import com.facebook.messaging.notify.NewMessageNotification;

/* compiled from: not recognized */
public class DefaultMessagingNotificationHandler$10 {
    final /* synthetic */ Builder f6191a;
    final /* synthetic */ PendingIntent f6192b;
    final /* synthetic */ NewMessageNotification f6193c;
    final /* synthetic */ DefaultMessagingNotificationHandler f6194d;

    DefaultMessagingNotificationHandler$10(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, Builder builder, PendingIntent pendingIntent, NewMessageNotification newMessageNotification) {
        this.f6194d = defaultMessagingNotificationHandler;
        this.f6191a = builder;
        this.f6192b = pendingIntent;
        this.f6193c = newMessageNotification;
    }

    public final void m5918a(WearableExtender wearableExtender) {
        this.f6194d.a(wearableExtender, this.f6191a, this.f6192b, this.f6193c);
    }
}
