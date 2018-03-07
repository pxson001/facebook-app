package com.facebook.analytics.analyticsmodule;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.analytics.analyticsmodule.abtest.ExperimentsForAnalyticsDefaultProcessModule;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_from_photo_edit_clicked */
public class BatteryDrainAnalyzer {
    private static final String f3987a = BatteryDrainAnalyzer.class.getSimpleName();
    private static final IntentFilter f3988b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static volatile BatteryDrainAnalyzer f3989s;
    private final Context f3990c;
    private final MonotonicClock f3991d;
    private final AbstractFbErrorReporter f3992e;
    private final BatteryDrainAnalyticsLogger f3993f;
    private final DynamicSecureBroadcastReceiver f3994g = new DynamicSecureBroadcastReceiver("android.intent.action.BATTERY_CHANGED", new C03591(this));
    private final boolean f3995h;
    private boolean f3996i;
    private boolean f3997j;
    private int f3998k = -1;
    private int f3999l = -1;
    private int f4000m = -1;
    private int f4001n = -1;
    private int f4002o = -1;
    private long f4003p = -1;
    private int f4004q = -1;
    private long f4005r = -1;

    /* compiled from: send_from_photo_edit_clicked */
    class C03591 implements ActionReceiver {
        final /* synthetic */ BatteryDrainAnalyzer f3986a;

        C03591(BatteryDrainAnalyzer batteryDrainAnalyzer) {
            this.f3986a = batteryDrainAnalyzer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1471964403);
            BatteryDrainAnalyzer.m3892a(this.f3986a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 374736092, a);
        }
    }

    public static com.facebook.analytics.analyticsmodule.BatteryDrainAnalyzer m3891a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3989s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.analyticsmodule.BatteryDrainAnalyzer.class;
        monitor-enter(r1);
        r0 = f3989s;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3894b(r0);	 Catch:{ all -> 0x0035 }
        f3989s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3989s;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.analyticsmodule.BatteryDrainAnalyzer.a(com.facebook.inject.InjectorLike):com.facebook.analytics.analyticsmodule.BatteryDrainAnalyzer");
    }

    private static BatteryDrainAnalyzer m3894b(InjectorLike injectorLike) {
        return new BatteryDrainAnalyzer((Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), BatteryDrainAnalyticsLogger.m3888a(injectorLike));
    }

    @Inject
    public BatteryDrainAnalyzer(Context context, QeAccessor qeAccessor, MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter, BatteryDrainAnalyticsLogger batteryDrainAnalyticsLogger) {
        this.f3990c = context;
        this.f3991d = monotonicClock;
        this.f3992e = abstractFbErrorReporter;
        this.f3993f = batteryDrainAnalyticsLogger;
        this.f3995h = qeAccessor.a(ExperimentsForAnalyticsDefaultProcessModule.f4031a, false);
    }

    public final void m3897a() {
        if (this.f3995h) {
            this.f3997j = true;
            this.f3999l = -1;
            this.f4000m = -1;
            Intent registerReceiver = this.f3990c.registerReceiver(this.f3994g, f3988b);
            this.f3996i = true;
            m3895b(registerReceiver);
        }
    }

    public final void m3898b() {
        if (this.f3995h) {
            this.f3997j = false;
            m3896c();
            if (this.f3996i) {
                this.f3990c.unregisterReceiver(this.f3994g);
                this.f3996i = false;
            }
        }
    }

    public static void m3892a(BatteryDrainAnalyzer batteryDrainAnalyzer, Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        if (intExtra == -1) {
            batteryDrainAnalyzer.f3992e.a(f3987a, "Could not read the battery level from the intent");
            return;
        }
        int intExtra2 = intent.getIntExtra("status", 1);
        if (batteryDrainAnalyzer.f4000m != intExtra2 || batteryDrainAnalyzer.f3999l != intExtra) {
            batteryDrainAnalyzer.f3999l = intExtra;
            batteryDrainAnalyzer.f4000m = intExtra2;
            if (!m3893a(intExtra2)) {
                batteryDrainAnalyzer.m3896c();
            } else if (batteryDrainAnalyzer.f3998k == -1) {
                batteryDrainAnalyzer.m3895b(intent);
            } else if (batteryDrainAnalyzer.f3998k != intExtra) {
                long now = batteryDrainAnalyzer.f3991d.now();
                if (batteryDrainAnalyzer.f4002o == -1) {
                    batteryDrainAnalyzer.f4002o = intExtra;
                    batteryDrainAnalyzer.f4003p = now;
                    return;
                }
                batteryDrainAnalyzer.f4004q = intExtra;
                batteryDrainAnalyzer.f4005r = now;
            }
        }
    }

    private void m3895b(@Nullable Intent intent) {
        if (intent == null) {
            this.f3992e.a(f3987a, "Failed to start monitoring because battery intent is null");
        } else if (this.f3997j && m3893a(intent.getIntExtra("status", 1))) {
            this.f3998k = intent.getIntExtra("level", -1);
            this.f4001n = intent.getIntExtra("scale", -1);
            this.f3999l = this.f3998k;
            this.f4000m = 3;
            if (this.f3998k == -1 || this.f4001n == -1) {
                this.f3992e.a(f3987a, "Could not read the current or max battery level from the intent");
            }
        }
    }

    private void m3896c() {
        if (!(this.f4002o == -1 || this.f4004q == -1)) {
            this.f3993f.m3890a(this.f4002o, this.f4004q, this.f4001n, this.f4005r - this.f4003p);
        }
        this.f3998k = -1;
        this.f4001n = -1;
        this.f4004q = -1;
        this.f4005r = -1;
        this.f4002o = -1;
        this.f4003p = -1;
    }

    public static boolean m3893a(int i) {
        return i == 3;
    }
}
