package com.facebook.vault.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.facebook.base.service.FbService;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.vault.prefs.RetryIntervalPref;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.facebook.vault.provider.VaultImageProviderRow;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: text_encrypted */
public class VaultSyncJobProcessor extends FbService {
    private static final Class<?> f1936a;
    public static final String f1937b;
    private Looper f1938c;
    private Handler f1939d;
    private Context f1940e;
    public FbInjector f1941f;
    private RetryIntervalPref f1942g;
    public VaultTable f1943h;
    public VaultNewImageUploader f1944i;
    private VaultHelpers f1945j;
    public AbstractFbErrorReporter f1946k;
    public RetryType f1947l = RetryType.NO_RETRY;

    /* compiled from: text_encrypted */
    class C01821 implements UncaughtExceptionHandler {
        final /* synthetic */ VaultSyncJobProcessor f1931a;

        C01821(VaultSyncJobProcessor vaultSyncJobProcessor) {
            this.f1931a = vaultSyncJobProcessor;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            BLog.b(VaultSyncJobProcessor.f1937b, th, "An exception occurred in %s", new Object[]{thread.getName()});
            this.f1931a.f1943h.a(0);
            this.f1931a.stopSelf();
            this.f1931a.f1946k.b(th.getClass().getName(), th.getMessage(), th);
        }
    }

    /* compiled from: text_encrypted */
    enum RetryType {
        NO_RETRY,
        RESET_RETRY,
        MAINTAIN_RETRY
    }

    /* compiled from: text_encrypted */
    class VaultSyncJobRunnable implements Runnable {
        VaultImageProviderRow f1933a;
        int f1934b;
        final /* synthetic */ VaultSyncJobProcessor f1935c;

        public VaultSyncJobRunnable(VaultSyncJobProcessor vaultSyncJobProcessor, VaultImageProviderRow vaultImageProviderRow, int i) {
            this.f1935c = vaultSyncJobProcessor;
            this.f1933a = vaultImageProviderRow;
            this.f1934b = i;
        }

        public void run() {
            VaultImageProviderRow a = this.f1935c.f1943h.a(this.f1933a.f1874a);
            if (a == null || a.f1879f == 5) {
                VaultNotificationManager.a(this.f1935c.f1941f).a(this.f1933a.f1874a);
            } else if (this.f1935c.f1944i.m1973a(this.f1933a, this.f1934b) && this.f1935c.f1947l != RetryType.RESET_RETRY) {
                this.f1935c.f1947l = this.f1934b == 3 ? RetryType.MAINTAIN_RETRY : RetryType.RESET_RETRY;
            }
        }
    }

    static {
        Class cls = VaultSyncJobProcessor.class;
        f1936a = cls;
        f1937b = cls.getSimpleName();
    }

    public final void m1999a() {
        super.a();
        AppInitLockHelper.a(this);
        this.f1940e = this;
        this.f1941f = FbInjector.get(this.f1940e);
        HandlerThread a = FbHandlerThreadFactory.a(this.f1941f).a("vault_sync_job_processor");
        a.setUncaughtExceptionHandler(new C01821(this));
        a.start();
        this.f1942g = RetryIntervalPref.m1923a(this.f1941f);
        this.f1944i = VaultNewImageUploader.m1971b(this.f1941f);
        this.f1943h = VaultTable.a(this.f1941f);
        this.f1945j = VaultHelpers.b(this.f1941f);
        this.f1946k = (AbstractFbErrorReporter) FbErrorReporterImpl.a(this.f1941f);
        this.f1938c = a.getLooper();
        this.f1939d = new Handler(this, this.f1938c) {
            final /* synthetic */ VaultSyncJobProcessor f1932a;

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.f1932a.stopSelfResult(message.arg1);
                        return;
                    default:
                        this.f1932a.f1946k.b(VaultSyncJobProcessor.f1937b, StringFormatUtil.a("msg.what %d is not defined", new Object[0]));
                        return;
                }
            }
        };
    }

    public final int m1998a(Intent intent, int i, int i2) {
        if (intent == null) {
            this.f1946k.a("VaultSyncJobProcessor onStartCommand", "started with null intent");
        } else {
            new StringBuilder("Starting VaultSyncJobProcessor Service with startId ").append(i2);
            int intExtra = intent.getIntExtra("sync_reason", -1);
            int intExtra2 = intent.getIntExtra("queuing_type", 2);
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("queuing_objects");
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                if (intExtra2 == 1) {
                    Collections.reverse(parcelableArrayListExtra);
                }
                int size = parcelableArrayListExtra.size();
                for (int i3 = 0; i3 < size; i3++) {
                    VaultImageProviderRow vaultImageProviderRow = (VaultImageProviderRow) parcelableArrayListExtra.get(i3);
                    if (intExtra2 == 2) {
                        m1994b(vaultImageProviderRow, intExtra);
                    } else {
                        m1991a(vaultImageProviderRow, intExtra);
                    }
                }
                this.f1939d.sendMessage(Message.obtain(this.f1939d, 1, i2, 0));
            }
        }
        return 2;
    }

    public final void m2000k() {
        super.k();
        this.f1938c.quit();
        this.f1945j.c(7);
        if (this.f1947l != RetryType.NO_RETRY) {
            m1990a(this.f1940e, this.f1947l == RetryType.RESET_RETRY);
            this.f1947l = RetryType.NO_RETRY;
        }
    }

    private void m1990a(Context context, boolean z) {
        long j;
        Intent b = this.f1945j.b(3);
        long a = this.f1942g.f1845a.a(VaultPrefKeys.e, 120000);
        if (z) {
            j = 120000;
        } else {
            j = a;
        }
        PendingIntent service = PendingIntent.getService(context, 0, b, 0);
        FbAlarmManagerImpl a2 = FbAlarmManagerImpl.a(this.f1941f);
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (VERSION.SDK_INT < 19) {
            a2.a.set(0, currentTimeMillis, service);
        } else {
            a2.a.setExact(0, currentTimeMillis, service);
        }
        new StringBuilder("scheduling retry with interval: ").append(j);
        this.f1942g.m1925a(Math.min(j * 2, 43200000));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void m1991a(VaultImageProviderRow vaultImageProviderRow, int i) {
        HandlerDetour.b(this.f1939d, new VaultSyncJobRunnable(this, vaultImageProviderRow, i), 1902797029);
    }

    private void m1994b(VaultImageProviderRow vaultImageProviderRow, int i) {
        HandlerDetour.a(this.f1939d, new VaultSyncJobRunnable(this, vaultImageProviderRow, i), 1699130608);
    }
}
