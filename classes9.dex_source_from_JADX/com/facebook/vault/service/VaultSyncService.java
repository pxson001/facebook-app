package com.facebook.vault.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.facebook.base.service.FbService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.prefs.LastSyncedDatePref;
import com.facebook.vault.prefs.RetryIntervalPref;
import com.facebook.vault.prefs.SyncOldPhotoPref;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: text_editing_present */
public class VaultSyncService extends FbService {
    public static final Class<?> f1953a = VaultSyncService.class;
    private FbInjector f1954b;
    private Looper f1955c;
    private Handler f1956d;
    private VaultLogger f1957e;
    private long f1958f;
    private VaultTable f1959g;
    private VaultNotificationManager f1960h;
    private VaultDeviceSetup f1961i;
    private VaultSyncJobGenerator f1962j;
    private VaultLocalImageFetcher f1963k;
    private RetryIntervalPref f1964l;
    private SyncOldPhotoPref f1965m;
    private DeviceIDPref f1966n;
    private LastSyncedDatePref f1967o;
    private VaultHelpers f1968p;
    public AbstractFbErrorReporter f1969q;

    /* compiled from: text_editing_present */
    class C01841 implements UncaughtExceptionHandler {
        final /* synthetic */ VaultSyncService f1948a;

        C01841(VaultSyncService vaultSyncService) {
            this.f1948a = vaultSyncService;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            BLog.b(VaultSyncService.f1953a, th, "An exception occurred in %s", new Object[]{thread.getName()});
            this.f1948a.f1969q.b(th.getClass().getName(), th.getMessage(), th);
        }
    }

    /* compiled from: text_editing_present */
    public class VaultSyncServiceRunnable implements Runnable {
        Context f1949a;
        Intent f1950b;
        int f1951c;
        final /* synthetic */ VaultSyncService f1952d;

        public VaultSyncServiceRunnable(VaultSyncService vaultSyncService, Context context, Intent intent, int i) {
            this.f1952d = vaultSyncService;
            this.f1949a = context;
            this.f1950b = intent;
            this.f1951c = i;
        }

        public void run() {
            this.f1952d.m2004a(this.f1950b, this.f1951c);
        }
    }

    public final void m2010a() {
        super.a();
        AppInitLockHelper.a(this);
        this.f1954b = FbInjector.get(this);
        HandlerThread a = FbHandlerThreadFactory.a(this.f1954b).a("vault_thread");
        a.setUncaughtExceptionHandler(new C01841(this));
        a.start();
        this.f1955c = a.getLooper();
        this.f1956d = new Handler(this.f1955c);
        this.f1958f = 0;
        this.f1961i = VaultDeviceSetup.b(this.f1954b);
        FbInjector fbInjector = this.f1954b;
        this.f1962j = new VaultSyncJobGenerator((Context) fbInjector.getInstance(Context.class), VaultTable.a(fbInjector), VaultHelpers.b(fbInjector), VaultNotificationManager.a(fbInjector));
        this.f1963k = VaultLocalImageFetcher.c(this.f1954b);
        this.f1957e = VaultLogger.c(this.f1954b);
        this.f1959g = VaultTable.a(this.f1954b);
        this.f1960h = VaultNotificationManager.a(this.f1954b);
        this.f1964l = RetryIntervalPref.m1923a(this.f1954b);
        this.f1965m = SyncOldPhotoPref.a(this.f1954b);
        this.f1966n = DeviceIDPref.a(this.f1954b);
        this.f1967o = LastSyncedDatePref.a(this.f1954b);
        this.f1968p = VaultHelpers.b(this.f1954b);
        this.f1969q = (AbstractFbErrorReporter) FbErrorReporterImpl.a(this.f1954b);
    }

    public final int m2009a(Intent intent, int i, int i2) {
        if (intent == null) {
            this.f1969q.a("VaultSyncService onStartCommand", "started with null intent");
        } else if (intent.hasExtra("sync_reason")) {
            int intExtra = intent.getIntExtra("sync_reason", -1);
            if (m2007b(intExtra)) {
                Integer.valueOf(intExtra);
                Integer.valueOf(i2);
            } else if (this.f1961i.a() || intExtra == 4) {
                HandlerDetour.b(this.f1956d, new VaultSyncServiceRunnable(this, this, intent, i2), m2001a(intExtra), -1535088465);
                Integer.valueOf(i2);
                Integer.valueOf(intExtra);
            } else {
                BLog.b(f1953a, "Device has not been setup, and sync reason not SYNC_REASON_SETUP");
            }
        } else {
            BLog.b(f1953a, "intent sent to VaultSyncService had no reason key, so no sync queued");
        }
        return 2;
    }

    private void m2004a(Intent intent, int i) {
        int i2 = 0;
        try {
            int intExtra = intent.getIntExtra("sync_reason", -1);
            if (this.f1963k.b()) {
                this.f1960h.d();
            } else if (this.f1968p.a(intExtra)) {
                this.f1959g.a(1800000);
                this.f1960h.a(this.f1959g.b());
                if (intExtra != 8) {
                    if (intExtra == 3) {
                        i2 = this.f1962j.m1984a(50);
                        if (i2 == 0) {
                            this.f1964l.m1925a(120000);
                        }
                    } else if (intExtra == 11) {
                        String[] stringArrayExtra = intent.getStringArrayExtra("photo_hashes");
                        if (stringArrayExtra != null) {
                            i2 = this.f1962j.m1986a(new HashSet(Arrays.asList(stringArrayExtra)), intExtra);
                        }
                    } else if (intExtra == 12) {
                        i2 = this.f1962j.m1985a(50, intExtra);
                        i2 += this.f1962j.m1987b(Math.max(0, 50 - i2));
                    } else {
                        i2 = this.f1962j.m1985a(50, intExtra);
                        if (i2 == 0 && this.f1965m.a() && this.f1959g.c()) {
                            while (true) {
                                int c = m2008c();
                                i2 = this.f1962j.m1985a(50, 10);
                                if (c > 0) {
                                    if (i2 != 0) {
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                if (i2 == 0) {
                    this.f1960h.d();
                } else {
                    long a = this.f1966n.a();
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f1967o.a(currentTimeMillis);
                    this.f1961i.a(a, currentTimeMillis);
                    m2003a(i2, intExtra);
                }
                stopSelfResult(i);
            } else {
                this.f1960h.d();
                stopSelfResult(i);
            }
        } finally {
            stopSelfResult(i);
        }
    }

    private static long m2001a(int i) {
        if (i == 0) {
            return 30000;
        }
        return 0;
    }

    private boolean m2007b(int i) {
        if (i != 2 && i != 1 && i != 5 && i != 6 && i != 7 && i != 9 && i != 10 && i != 4) {
            return false;
        }
        if (System.currentTimeMillis() - this.f1958f < 2000) {
            return true;
        }
        this.f1958f = System.currentTimeMillis();
        return false;
    }

    public final void m2011k() {
        super.k();
        this.f1955c.quit();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void m2003a(int i, int i2) {
        if (i > 0) {
            this.f1957e.a(i2, i);
            Integer.valueOf(i);
            Integer.valueOf(i2);
        }
    }

    private int m2008c() {
        Set a = this.f1959g.a(6);
        this.f1960h.a(a);
        return a.size();
    }
}
