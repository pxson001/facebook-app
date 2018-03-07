package com.facebook.contacts.database;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

@Deprecated
/* compiled from: photo_menu_upload */
public class AddressBookPeriodicRunner {
    private static final Class<?> f8141a = AddressBookPeriodicRunner.class;

    /* compiled from: photo_menu_upload */
    public class LocalBroadcastReceiver extends DynamicSecureBroadcastReceiver {

        /* compiled from: photo_menu_upload */
        class C04941 implements ActionReceiver {
            C04941() {
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -272362108);
                intent.toString();
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -138767046, a);
            }
        }

        public LocalBroadcastReceiver() {
            super("com.facebook.orca.database.ACTION_ALARM", new C04941());
        }
    }
}
