package com.facebook.orca.notify;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

/* compiled from: no_recent_story */
public class MessagesNotificationBroadcastReceiver extends DynamicSecureBroadcastReceiver {

    /* compiled from: no_recent_story */
    class NotificationsActionReceiver implements ActionReceiver {
        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1995338601);
            Intent intent2 = new Intent(intent);
            intent2.setClass(context, MessagesNotificationService.class);
            context.startService(intent2);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1209837646, a);
        }
    }

    public MessagesNotificationBroadcastReceiver() {
        super(m5948c());
    }

    private static Map<String, ActionReceiver> m5948c() {
        NotificationsActionReceiver notificationsActionReceiver = new NotificationsActionReceiver();
        return new Builder().b(MessagesNotificationIntents.a, notificationsActionReceiver).b(MessagesNotificationIntents.b, notificationsActionReceiver).b(MessagesNotificationIntents.h, notificationsActionReceiver).b(MessagesNotificationIntents.c, notificationsActionReceiver).b(MessagesNotificationIntents.d, notificationsActionReceiver).b(MessagesNotificationIntents.i, notificationsActionReceiver).b(MessagesNotificationIntents.j, notificationsActionReceiver).b(MessagesNotificationIntents.k, notificationsActionReceiver).b(MessagesNotificationIntents.l, notificationsActionReceiver).b(MessagesNotificationIntents.p, notificationsActionReceiver).b(MessagesNotificationIntents.m, notificationsActionReceiver).b(MessagesNotificationIntents.q, notificationsActionReceiver).b(MessagesNotificationIntents.o, notificationsActionReceiver).b(MessagesNotificationIntents.r, notificationsActionReceiver).b(MessagesNotificationIntents.s, notificationsActionReceiver).b(MessagesNotificationIntents.t, notificationsActionReceiver).b(MessagesNotificationIntents.w, notificationsActionReceiver).b(MessagesNotificationIntents.e, notificationsActionReceiver).b(MessagesNotificationIntents.f, notificationsActionReceiver).b(MessagesNotificationIntents.g, notificationsActionReceiver).b(MessagesNotificationIntents.u, notificationsActionReceiver).b(MessagesNotificationIntents.v, notificationsActionReceiver).b(MessagesNotificationIntents.n, notificationsActionReceiver).b(MessagesNotificationIntents.x, notificationsActionReceiver).b(MessagesNotificationIntents.y, notificationsActionReceiver).b("ACTION_MQTT_NO_AUTH", notificationsActionReceiver).b(MessagesNotificationIntents.z, notificationsActionReceiver).b(MessagesNotificationIntents.A, notificationsActionReceiver).b(MessagesNotificationIntents.B, notificationsActionReceiver).b();
    }
}
