package com.facebook.vault.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: thirdPartyRegistration */
public class VaultPowerConnectionReceiver extends BroadcastReceiver {
    private static Class<?> f1911a = VaultPowerConnectionReceiver.class;

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 9515138);
        FbInjector fbInjector = FbInjector.get(context);
        if (AppInitLock.a(fbInjector).c()) {
            VaultHelpers.b(fbInjector).c(9);
            VaultNotificationManager.a(fbInjector).b();
        }
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -929696274, a);
    }
}
