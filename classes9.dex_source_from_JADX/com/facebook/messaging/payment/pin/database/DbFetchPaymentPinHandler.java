package com.facebook.messaging.payment.pin.database;

import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hasInstalledMoments */
public class DbFetchPaymentPinHandler {
    private static volatile DbFetchPaymentPinHandler f13688b;
    private final PaymentPinDatabaseSupplier f13689a;

    public static com.facebook.messaging.payment.pin.database.DbFetchPaymentPinHandler m14245a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13688b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.pin.database.DbFetchPaymentPinHandler.class;
        monitor-enter(r1);
        r0 = f13688b;	 Catch:{ all -> 0x003a }
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
        r0 = m14246b(r0);	 Catch:{ all -> 0x0035 }
        f13688b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13688b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.pin.database.DbFetchPaymentPinHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.pin.database.DbFetchPaymentPinHandler");
    }

    private static DbFetchPaymentPinHandler m14246b(InjectorLike injectorLike) {
        return new DbFetchPaymentPinHandler(PaymentPinDatabaseSupplier.m14254a(injectorLike));
    }

    @Inject
    public DbFetchPaymentPinHandler(PaymentPinDatabaseSupplier paymentPinDatabaseSupplier) {
        this.f13689a = paymentPinDatabaseSupplier;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    public final com.facebook.messaging.payment.pin.model.PaymentPin m14247a() {
        /*
        r9 = this;
        r8 = 0;
        r0 = "getPaymentPin";
        r1 = 91696631; // 0x5772df7 float:1.16223266E-35 double:4.5304155E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r9.f13689a;	 Catch:{ all -> 0x0053 }
        r0 = r0.a();	 Catch:{ all -> 0x0053 }
        r1 = "payment_pin_id";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0053 }
        r0 = r1.getCount();	 Catch:{ all -> 0x004e }
        r2 = 1;
        if (r0 == r2) goto L_0x002d;
    L_0x0022:
        r1.close();	 Catch:{  }
        r0 = 1993662213; // 0x76d4df05 float:2.1587701E33 double:9.85000009E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
    L_0x002c:
        return r0;
    L_0x002d:
        r1.moveToFirst();	 Catch:{  }
        r0 = com.facebook.messaging.payment.pin.database.PaymentPinDbSchemaPart.PaymentPinIdTable.f13696a;	 Catch:{  }
        r2 = r0.c(r1);	 Catch:{  }
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0048;
    L_0x003c:
        r0 = com.facebook.messaging.payment.pin.model.PaymentPin.f13711a;	 Catch:{  }
    L_0x003e:
        r1.close();	 Catch:{  }
        r1 = 1303802017; // 0x4db670a1 float:3.8260432E8 double:6.441637856E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x002c;
    L_0x0048:
        r0 = new com.facebook.messaging.payment.pin.model.PaymentPin;	 Catch:{  }
        r0.<init>(r2);	 Catch:{  }
        goto L_0x003e;
    L_0x004e:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0053:
        r0 = move-exception;
        r1 = -1939847836; // 0xffffffff8c604564 float:-1.7277214E-31 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.pin.database.DbFetchPaymentPinHandler.a():com.facebook.messaging.payment.pin.model.PaymentPin");
    }
}
