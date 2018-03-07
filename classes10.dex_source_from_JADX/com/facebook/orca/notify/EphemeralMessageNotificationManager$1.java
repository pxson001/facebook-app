package com.facebook.orca.notify;

import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.NewEphemeralMessageNotification;

/* compiled from: nodeId */
class EphemeralMessageNotificationManager$1 implements Runnable {
    final /* synthetic */ NewEphemeralMessageNotification f6227a;
    final /* synthetic */ ThreadKey f6228b;
    final /* synthetic */ Builder f6229c;
    final /* synthetic */ EphemeralMessageNotificationManager f6230d;

    EphemeralMessageNotificationManager$1(EphemeralMessageNotificationManager ephemeralMessageNotificationManager, NewEphemeralMessageNotification newEphemeralMessageNotification, ThreadKey threadKey, Builder builder) {
        this.f6230d = ephemeralMessageNotificationManager;
        this.f6227a = newEphemeralMessageNotification;
        this.f6228b = threadKey;
        this.f6229c = builder;
    }

    public void run() {
        Object obj;
        EphemeralMessageNotificationManager ephemeralMessageNotificationManager = this.f6230d;
        NewEphemeralMessageNotification newEphemeralMessageNotification = this.f6227a;
        ThreadKey threadKey = this.f6228b;
        Builder builder = this.f6229c;
        Message message = newEphemeralMessageNotification.c;
        if (message.a.equals(ephemeralMessageNotificationManager.h.get(message.b))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            ephemeralMessageNotificationManager.c.a(newEphemeralMessageNotification, new EphemeralMessageNotificationManager$2(ephemeralMessageNotificationManager, builder, newEphemeralMessageNotification, threadKey));
        }
    }
}
