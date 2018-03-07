package com.facebook.common.carrier;

import android.content.Context;
import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: registration_validate_registration_data */
public class CarrierMonitor {
    private static volatile CarrierMonitor f7765j;
    public final Context f7766a;
    private final Handler f7767b;
    public final TelephonyManager f7768c;
    public final MonotonicClock f7769d;
    private volatile boolean f7770e;
    private volatile String f7771f;
    private volatile String f7772g;
    private volatile String f7773h;
    public long f7774i = Long.MIN_VALUE;

    /* compiled from: registration_validate_registration_data */
    class C05041 implements Runnable {
        final /* synthetic */ CarrierMonitor f11976a;

        C05041(CarrierMonitor carrierMonitor) {
            this.f11976a = carrierMonitor;
        }

        public void run() {
            try {
                if (this.f11976a.f7766a.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    CarrierMonitor.m12303a(this.f11976a, 17);
                } else {
                    CarrierMonitor.m12303a(this.f11976a, 1);
                }
            } catch (RuntimeException e) {
                CarrierMonitor.m12303a(this.f11976a, 1);
            }
        }
    }

    /* compiled from: registration_validate_registration_data */
    class C05052 extends PhoneStateListener {
        final /* synthetic */ CarrierMonitor f11986a;

        C05052(CarrierMonitor carrierMonitor) {
            this.f11986a = carrierMonitor;
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            CarrierMonitor.m12307g(this.f11986a);
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            this.f11986a.f7774i = this.f11986a.f7769d.now();
        }
    }

    public static com.facebook.common.carrier.CarrierMonitor m12302a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7765j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.carrier.CarrierMonitor.class;
        monitor-enter(r1);
        r0 = f7765j;	 Catch:{ all -> 0x003a }
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
        r0 = m12304b(r0);	 Catch:{ all -> 0x0035 }
        f7765j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7765j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.carrier.CarrierMonitor.a(com.facebook.inject.InjectorLike):com.facebook.common.carrier.CarrierMonitor");
    }

    private static CarrierMonitor m12304b(InjectorLike injectorLike) {
        return new CarrierMonitor((Context) injectorLike.getInstance(Context.class), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), TelephonyManagerMethodAutoProvider.m3851b(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public CarrierMonitor(Context context, Handler handler, TelephonyManager telephonyManager, MonotonicClock monotonicClock) {
        this.f7766a = context;
        this.f7767b = handler;
        this.f7768c = telephonyManager;
        this.f7769d = monotonicClock;
        this.f7770e = false;
    }

    public final String m12308a() {
        m12305e();
        return this.f7771f;
    }

    public final String m12309b() {
        m12305e();
        return this.f7772g;
    }

    public final String m12310c() {
        m12305e();
        return this.f7773h;
    }

    private void m12305e() {
        if (!this.f7770e) {
            synchronized (this) {
                if (!this.f7770e) {
                    m12306f();
                    this.f7770e = true;
                }
            }
        }
    }

    private void m12306f() {
        m12307g(this);
        HandlerDetour.a(this.f7767b, new C05041(this), 422406808);
    }

    public static void m12303a(CarrierMonitor carrierMonitor, int i) {
        carrierMonitor.f7768c.listen(new C05052(carrierMonitor), i);
    }

    public static void m12307g(CarrierMonitor carrierMonitor) {
        carrierMonitor.f7771f = Strings.nullToEmpty(carrierMonitor.f7768c.getNetworkOperator());
        carrierMonitor.f7772g = Strings.nullToEmpty(carrierMonitor.f7768c.getSimOperator());
        carrierMonitor.f7773h = "";
        if (carrierMonitor.f7768c.getPhoneType() == 2) {
            CellLocation cellLocation;
            int checkCallingOrSelfPermission = carrierMonitor.f7766a.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
            int checkCallingOrSelfPermission2 = carrierMonitor.f7766a.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
            if (checkCallingOrSelfPermission == 0 || checkCallingOrSelfPermission2 == 0) {
                cellLocation = carrierMonitor.f7768c.getCellLocation();
            } else {
                cellLocation = null;
            }
            CellLocation cellLocation2 = cellLocation;
            if (cellLocation2 != null && (cellLocation2 instanceof CdmaCellLocation)) {
                carrierMonitor.f7773h = Strings.nullToEmpty(Integer.toString(((CdmaCellLocation) cellLocation2).getSystemId()));
            }
        }
    }

    public final Optional<Long> m12311d() {
        if (this.f7774i == Long.MIN_VALUE) {
            return Absent.INSTANCE;
        }
        return Optional.of(Long.valueOf(this.f7769d.now() - this.f7774i));
    }
}
