package com.facebook.messaging.payment.database.handler;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.PaymentCardIdsTable;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: insertOrUpdateIncomingPaymentRequest */
public class DbFetchPaymentCardIdsHandler {
    private static volatile DbFetchPaymentCardIdsHandler f12938b;
    private final PaymentsDatabaseSupplier f12939a;

    public static com.facebook.messaging.payment.database.handler.DbFetchPaymentCardIdsHandler m13230a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12938b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbFetchPaymentCardIdsHandler.class;
        monitor-enter(r1);
        r0 = f12938b;	 Catch:{ all -> 0x003a }
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
        r0 = m13231b(r0);	 Catch:{ all -> 0x0035 }
        f12938b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12938b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentCardIdsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbFetchPaymentCardIdsHandler");
    }

    private static DbFetchPaymentCardIdsHandler m13231b(InjectorLike injectorLike) {
        return new DbFetchPaymentCardIdsHandler(PaymentsDatabaseSupplier.m13210a(injectorLike));
    }

    @Inject
    public DbFetchPaymentCardIdsHandler(PaymentsDatabaseSupplier paymentsDatabaseSupplier) {
        this.f12939a = paymentsDatabaseSupplier;
    }

    public final ImmutableList<Long> m13232a() {
        TracerDetour.a("getPaymentCardIds", -934332144);
        try {
            Cursor a = m13229a(this.f12939a.a(), "payment_card_ids");
            try {
                Builder builder = new Builder();
                while (a.moveToNext()) {
                    builder.c(Long.valueOf(PaymentCardIdsTable.f12862a.c(a)));
                }
                ImmutableList<Long> b = builder.b();
                return b;
            } finally {
                a.close();
            }
        } finally {
            TracerDetour.a(1033055039);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    public final java.lang.Long m13233b() {
        /*
        r4 = this;
        r0 = 1;
        r1 = "getPrimaryPaymentCardId";
        r2 = 347322404; // 0x14b3b824 float:1.8147012E-26 double:1.71600068E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1, r2);
        r1 = r4.f12939a;	 Catch:{ all -> 0x0051 }
        r1 = r1.a();	 Catch:{ all -> 0x0051 }
        r2 = "primary_payment_card_id";
        r1 = m13229a(r1, r2);	 Catch:{ all -> 0x0051 }
        r2 = r1.getCount();	 Catch:{ all -> 0x004c }
        if (r2 > r0) goto L_0x002f;
    L_0x001b:
        com.google.common.base.Preconditions.checkArgument(r0);	 Catch:{ all -> 0x004c }
        r0 = r1.getCount();	 Catch:{ all -> 0x004c }
        if (r0 != 0) goto L_0x0031;
    L_0x0024:
        r1.close();	 Catch:{  }
        r0 = -1807123267; // 0xffffffff94497cbd float:-1.0172507E-26 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = 0;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = 0;
        goto L_0x001b;
    L_0x0031:
        r1.moveToFirst();	 Catch:{  }
        r0 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.PrimaryPaymentCardIdTable.f12865a;	 Catch:{  }
        r0 = r0.b(r1);	 Catch:{  }
        r2 = java.lang.Long.parseLong(r0);	 Catch:{  }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{  }
        r1.close();	 Catch:{  }
        r1 = -2014706954; // 0xffffffff87ea02f6 float:-3.5210147E-34 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x002e;
    L_0x004c:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0051:
        r0 = move-exception;
        r1 = 1076112905; // 0x40242e09 float:2.5653098 double:5.316704174E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentCardIdsHandler.b():java.lang.Long");
    }

    private static Cursor m13229a(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.query(str, null, null, null, null, null, null);
    }
}
