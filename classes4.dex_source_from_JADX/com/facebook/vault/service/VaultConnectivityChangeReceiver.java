package com.facebook.vault.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: first_use */
public class VaultConnectivityChangeReceiver extends BroadcastReceiver {
    private static final Class<?> f11557a = VaultConnectivityChangeReceiver.class;

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2027907816);
        InjectorLike injectorLike = FbInjector.get(context);
        if (AppInitLock.a(injectorLike).c()) {
            VaultHelpers.m9810b(injectorLike).m9815c(2);
            VaultNotificationManager.m12091a(FbInjector.get(context)).m12106b();
        }
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -249924014, a);
    }
}
