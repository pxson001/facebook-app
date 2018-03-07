package com.facebook.vault.service;

import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: text1 */
public class VaultUpdateService extends FbIntentService {
    public VaultUpdateService() {
        super("VaultUpdateService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1588850435);
        super.onCreate();
        AppInitLockHelper.a(this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1330528086, a);
    }

    protected final void m2012a(Intent intent) {
        if (intent != null) {
            VaultDeviceSetup.b(FbInjector.get(this)).d();
        }
    }
}
