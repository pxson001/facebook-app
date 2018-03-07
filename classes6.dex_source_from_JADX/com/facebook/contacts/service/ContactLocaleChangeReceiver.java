package com.facebook.contacts.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

/* compiled from: p. */
public class ContactLocaleChangeReceiver extends DynamicSecureBroadcastReceiver {
    private static final Class<?> f8495a = ContactLocaleChangeReceiver.class;

    /* compiled from: p. */
    class InternalReceiver implements ActionReceiver {
        public final void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -125566624);
            new StringBuilder("Received intent: ").append(intent);
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(context, ContactLocaleChangeService.class));
            context.startService(intent2);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -941068813, a);
        }
    }

    public ContactLocaleChangeReceiver() {
        super(m12305c());
    }

    private static Map<String, ActionReceiver> m12305c() {
        return new Builder().b("android.intent.action.LOCALE_CHANGED", new InternalReceiver()).b();
    }
}
