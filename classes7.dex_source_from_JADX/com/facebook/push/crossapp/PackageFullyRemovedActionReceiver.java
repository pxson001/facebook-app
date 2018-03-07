package com.facebook.push.crossapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: how long to batch logs before send them back */
class PackageFullyRemovedActionReceiver implements ActionReceiver {
    private static final Class<?> f11241a = PackageFullyRemovedActionReceiver.class;

    PackageFullyRemovedActionReceiver() {
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -737229886);
        if (intent == null) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1186347356, a);
            return;
        }
        String str;
        Uri data = intent.getData();
        if (data == null) {
            str = null;
        } else {
            str = data.getSchemeSpecificPart();
        }
        String str2 = str;
        intent.getAction();
        if (PackageRemovedReceiverInitializer.a(str2)) {
            if ("android.intent.action.PACKAGE_FULLY_REMOVED".equals(intent.getAction())) {
                PackageRemovedReporterService.m13155a(context, str2, "receiver");
            }
            LogUtils.e(-1170781306, a);
            return;
        }
        LogUtils.e(1160441299, a);
    }
}
