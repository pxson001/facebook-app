package com.facebook.vault.service;

import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: floating_window_timeout_disabled */
public class VaultManagerService extends FbIntentService {
    public static String f11511a = "method_key";
    private static final String f11512b = VaultDeviceSetup.class.getSimpleName();
    private VaultHelpers f11513c;
    private VaultTable f11514d;
    private VaultNotificationManager f11515e;
    private VaultDeviceSetup f11516f;
    private VaultManager f11517g;
    private AbstractFbErrorReporter f11518h;

    public VaultManagerService() {
        super("VaultSyncManagerService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1253777991);
        super.onCreate();
        AppInitLockHelper.a(this);
        InjectorLike injectorLike = FbInjector.get(this);
        this.f11513c = VaultHelpers.m9810b(injectorLike);
        this.f11514d = VaultTable.m12041a(injectorLike);
        this.f11515e = VaultNotificationManager.m12091a(injectorLike);
        this.f11516f = VaultDeviceSetup.m12012b(injectorLike);
        this.f11517g = VaultManager.m9796a(injectorLike);
        this.f11518h = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 79158031, a);
    }

    protected final void m12011a(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(f11511a, -1)) {
                case 1:
                    m12008b();
                    return;
                case 2:
                    m12009c();
                    return;
                default:
                    this.f11518h.b(f11512b, "Unsupported method");
                    return;
            }
        }
    }

    private void m12008b() {
        if (this.f11516f.m12016a()) {
            if (this.f11513c.m9814b()) {
                this.f11517g.m9801b();
            }
        } else if (this.f11516f.m12018c()) {
            if (this.f11513c.m9814b()) {
                this.f11517g.m9801b();
            }
            m12010d();
        }
    }

    private void m12009c() {
        if (this.f11516f.m12016a()) {
            this.f11517g.m9801b();
            this.f11513c.m9815c(5);
        } else if (this.f11516f.m12017b()) {
            this.f11517g.m9801b();
            this.f11513c.m9815c(5);
        } else {
            m12010d();
            this.f11517g.m9801b();
            this.f11513c.m9815c(4);
        }
        startService(new Intent(this, VaultUpdateService.class));
    }

    private void m12010d() {
        this.f11515e.m12105a(this.f11514d.m12062a());
    }
}
