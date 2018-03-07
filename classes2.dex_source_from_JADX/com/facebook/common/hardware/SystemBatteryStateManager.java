package com.facebook.common.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.base.broadcast.BroadcastReceiverManager;
import com.facebook.base.broadcast.ForwardingBroadcastReceiver;
import com.facebook.base.broadcast.GlobalBroadcastReceiverManager;
import com.facebook.common.hardware.BatteryStateManager.BatteryChangeListener;
import com.facebook.common.hardware.BatteryStateManager.HealthState;
import com.facebook.common.hardware.BatteryStateManager.PluggedState;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: retry_policy */
public class SystemBatteryStateManager {
    private static final IntentFilter f6728a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static volatile SystemBatteryStateManager f6729g;
    private final Object f6730b = new Object();
    private final Context f6731c;
    private final BroadcastReceiverManager<BatteryChangeListener> f6732d;
    private boolean f6733e = false;
    @Nullable
    public Intent f6734f;

    /* compiled from: retry_policy */
    class C02951 implements ForwardingBroadcastReceiver<BatteryChangeListener> {
        final /* synthetic */ SystemBatteryStateManager f6739a;

        C02951(SystemBatteryStateManager systemBatteryStateManager) {
            this.f6739a = systemBatteryStateManager;
        }

        public final void mo1252a(Collection<BatteryChangeListener> collection, Intent intent) {
            for (BatteryChangeListener a : collection) {
                a.a(intent);
            }
        }
    }

    /* compiled from: retry_policy */
    class C02962 extends BroadcastReceiver {
        final /* synthetic */ SystemBatteryStateManager f6740a;

        C02962(SystemBatteryStateManager systemBatteryStateManager) {
            this.f6740a = systemBatteryStateManager;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 926313603);
            this.f6740a.f6734f = intent;
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1381924752, a);
        }
    }

    public static com.facebook.common.hardware.SystemBatteryStateManager m11461a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f6729g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.hardware.SystemBatteryStateManager.class;
        monitor-enter(r1);
        r0 = f6729g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11463b(r0);	 Catch:{ all -> 0x0035 }
        f6729g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6729g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.hardware.SystemBatteryStateManager.a(com.facebook.inject.InjectorLike):com.facebook.common.hardware.SystemBatteryStateManager");
    }

    private static SystemBatteryStateManager m11463b(InjectorLike injectorLike) {
        return new SystemBatteryStateManager((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public SystemBatteryStateManager(Context context) {
        this.f6731c = (Context) Preconditions.checkNotNull(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        this.f6732d = new GlobalBroadcastReceiverManager(this.f6731c, new C02951(this), intentFilter);
    }

    public final void m11466a(BatteryChangeListener batteryChangeListener) {
        m11462a(batteryChangeListener, null);
    }

    private void m11462a(BatteryChangeListener batteryChangeListener, @Nullable Handler handler) {
        synchronized (this.f6730b) {
            this.f6732d.m8556a(batteryChangeListener, handler);
        }
    }

    public final void m11469b(BatteryChangeListener batteryChangeListener) {
        synchronized (this.f6730b) {
            this.f6732d.m8555a((Object) batteryChangeListener);
        }
    }

    public final HealthState m11470c() {
        Intent e = m11464e();
        if (e == null) {
            return HealthState.UNKNOWN;
        }
        switch (e.getIntExtra("health", 1)) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return HealthState.GOOD;
            case 3:
                return HealthState.OVERHEAT;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return HealthState.DEAD;
            case 5:
                return HealthState.OVER_VOLTAGE;
            case 6:
                return HealthState.UNSPECIFIED_FAILURE;
            case 7:
                return HealthState.COLD;
            default:
                return HealthState.UNKNOWN;
        }
    }

    public final float m11465a() {
        Intent e = m11464e();
        if (e == null) {
            return -1.0f;
        }
        int intExtra = e.getIntExtra("level", -1);
        int intExtra2 = e.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 < 0) {
            return -1.0f;
        }
        return ((float) intExtra) / ((float) intExtra2);
    }

    public final BatteryStateManager$ChargeState m11468b() {
        Intent e = m11464e();
        if (e == null) {
            return BatteryStateManager$ChargeState.UNKNOWN;
        }
        switch (e.getIntExtra("status", 1)) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                switch (e.getIntExtra("plugged", -1)) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        return BatteryStateManager$ChargeState.CHARGING_AC;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        return BatteryStateManager$ChargeState.CHARGING_USB;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        return BatteryStateManager$ChargeState.CHARGING_WIRELESS;
                    default:
                        return BatteryStateManager$ChargeState.UNKNOWN;
                }
            case 3:
                return BatteryStateManager$ChargeState.DISCHARGING;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return BatteryStateManager$ChargeState.NOT_CHARGING;
            case 5:
                return BatteryStateManager$ChargeState.FULL;
            default:
                return BatteryStateManager$ChargeState.UNKNOWN;
        }
    }

    public final PluggedState m11471d() {
        Intent e = m11464e();
        if (e == null) {
            return PluggedState.UNKNOWN;
        }
        switch (e.getIntExtra("plugged", 0)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return PluggedState.PLUGGED_AC;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return PluggedState.PLUGGED_USB;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return PluggedState.PLUGGED_WIRELESS;
            default:
                return PluggedState.NOT_PLUGGED;
        }
    }

    public final boolean m11467a(int i) {
        Intent e = m11464e();
        if (e == null) {
            return false;
        }
        switch (e.getIntExtra("status", 1)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 5:
                return false;
            default:
                int intExtra = e.getIntExtra("level", -1);
                int intExtra2 = e.getIntExtra("scale", -1);
                if (intExtra < 0 || intExtra2 < 0 || (((float) intExtra) / ((float) intExtra2)) * 100.0f >= ((float) i)) {
                    return false;
                }
                return true;
        }
    }

    @Nullable
    private Intent m11464e() {
        Intent intent = null;
        if (this.f6733e) {
            return this.f6734f;
        }
        try {
            this.f6734f = this.f6731c.registerReceiver(new C02962(this), f6728a);
            this.f6733e = true;
            return this.f6734f;
        } catch (Throwable e) {
            String message = e.getMessage();
            if (message != null && message.contains("Unable to find app for caller")) {
                return intent;
            }
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e2) {
            return intent;
        }
    }
}
