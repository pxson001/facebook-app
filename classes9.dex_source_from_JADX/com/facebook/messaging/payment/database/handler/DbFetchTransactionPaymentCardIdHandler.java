package com.facebook.messaging.payment.database.handler;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: insertMoreTransactions */
public class DbFetchTransactionPaymentCardIdHandler {
    private static volatile DbFetchTransactionPaymentCardIdHandler f12957c;
    private final PaymentsDatabaseSupplier f12958a;
    private final AbstractFbErrorReporter f12959b;

    public static com.facebook.messaging.payment.database.handler.DbFetchTransactionPaymentCardIdHandler m13246a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12957c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbFetchTransactionPaymentCardIdHandler.class;
        monitor-enter(r1);
        r0 = f12957c;	 Catch:{ all -> 0x003a }
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
        r0 = m13247b(r0);	 Catch:{ all -> 0x0035 }
        f12957c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12957c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchTransactionPaymentCardIdHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbFetchTransactionPaymentCardIdHandler");
    }

    private static DbFetchTransactionPaymentCardIdHandler m13247b(InjectorLike injectorLike) {
        return new DbFetchTransactionPaymentCardIdHandler(PaymentsDatabaseSupplier.m13210a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbFetchTransactionPaymentCardIdHandler(PaymentsDatabaseSupplier paymentsDatabaseSupplier, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12958a = paymentsDatabaseSupplier;
        this.f12959b = abstractFbErrorReporter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    public final java.lang.Long m13248a(long r12) {
        /*
        r11 = this;
        r9 = 1;
        r8 = 0;
        r0 = "getPaymentCardIdForTransaction";
        r1 = -75992601; // 0xfffffffffb7871e7 float:-1.2899998E36 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r11.f12958a;	 Catch:{ all -> 0x00ac }
        r0 = r0.a();	 Catch:{ all -> 0x00ac }
        r1 = 2;
        r2 = new java.lang.String[r1];	 Catch:{ all -> 0x00ac }
        r1 = 0;
        r3 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionPaymentCardIdTable.f12906a;	 Catch:{ all -> 0x00ac }
        r3 = r3.a();	 Catch:{ all -> 0x00ac }
        r2[r1] = r3;	 Catch:{ all -> 0x00ac }
        r1 = 1;
        r3 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionPaymentCardIdTable.f12907b;	 Catch:{ all -> 0x00ac }
        r3 = r3.a();	 Catch:{ all -> 0x00ac }
        r2[r1] = r3;	 Catch:{ all -> 0x00ac }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
        r1.<init>();	 Catch:{ all -> 0x00ac }
        r3 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionPaymentCardIdTable.f12906a;	 Catch:{ all -> 0x00ac }
        r3 = r3.a();	 Catch:{ all -> 0x00ac }
        r1 = r1.append(r3);	 Catch:{ all -> 0x00ac }
        r3 = "=";
        r1 = r1.append(r3);	 Catch:{ all -> 0x00ac }
        r1 = r1.append(r12);	 Catch:{ all -> 0x00ac }
        r3 = r1.toString();	 Catch:{ all -> 0x00ac }
        r1 = "transaction_payment_card_id";
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00ac }
        r0 = r1.getCount();	 Catch:{ all -> 0x00a7 }
        if (r0 <= r9) goto L_0x0077;
    L_0x0052:
        r0 = r11.f12959b;	 Catch:{ all -> 0x00a7 }
        r2 = "DbFetchTransactionPaymentCardIdHandler";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a7 }
        r4 = "TransactionPaymentCardId table should only have one row for a given transactionID, but it has ";
        r3.<init>(r4);	 Catch:{ all -> 0x00a7 }
        r4 = r1.getCount();	 Catch:{ all -> 0x00a7 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00a7 }
        r3 = r3.toString();	 Catch:{ all -> 0x00a7 }
        r0.b(r2, r3);	 Catch:{ all -> 0x00a7 }
        r1.close();	 Catch:{  }
        r0 = -1894058807; // 0xffffffff8f1af4c9 float:-7.63993E-30 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
    L_0x0076:
        return r0;
    L_0x0077:
        r0 = r1.getCount();	 Catch:{  }
        if (r0 != 0) goto L_0x0088;
    L_0x007d:
        r1.close();	 Catch:{  }
        r0 = 1597826583; // 0x5f3ce617 float:1.3611592E19 double:7.894312227E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0076;
    L_0x0088:
        r1.moveToFirst();	 Catch:{  }
        r0 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionPaymentCardIdTable.f12907b;	 Catch:{  }
        r0 = r0.a();	 Catch:{  }
        r0 = r1.getColumnIndex(r0);	 Catch:{  }
        r2 = r1.getLong(r0);	 Catch:{  }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{  }
        r1.close();	 Catch:{  }
        r1 = -1833706960; // 0xffffffff92b3da30 float:-1.1350276E-27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0076;
    L_0x00a7:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00ac:
        r0 = move-exception;
        r1 = -411480986; // 0xffffffffe7794c66 float:-1.17727856E24 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchTransactionPaymentCardIdHandler.a(long):java.lang.Long");
    }
}
