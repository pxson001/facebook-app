package com.facebook.messaging.payment.database.handler;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.PaymentCardIdsTable;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.PrimaryPaymentCardIdTable;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: insert-address-token */
public class DbInsertPaymentCardIdsHandler {
    private static final Class<?> f12960a = DbInsertPaymentCardIdsHandler.class;
    private static volatile DbInsertPaymentCardIdsHandler f12961e;
    private final PaymentsDatabaseSupplier f12962b;
    private final AbstractFbErrorReporter f12963c;
    private final DbFetchPaymentCardIdsHandler f12964d;

    public static com.facebook.messaging.payment.database.handler.DbInsertPaymentCardIdsHandler m13249a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12961e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbInsertPaymentCardIdsHandler.class;
        monitor-enter(r1);
        r0 = f12961e;	 Catch:{ all -> 0x003a }
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
        r0 = m13250b(r0);	 Catch:{ all -> 0x0035 }
        f12961e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12961e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbInsertPaymentCardIdsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbInsertPaymentCardIdsHandler");
    }

    private static DbInsertPaymentCardIdsHandler m13250b(InjectorLike injectorLike) {
        return new DbInsertPaymentCardIdsHandler(PaymentsDatabaseSupplier.m13210a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DbFetchPaymentCardIdsHandler.m13230a(injectorLike));
    }

    @Inject
    public DbInsertPaymentCardIdsHandler(PaymentsDatabaseSupplier paymentsDatabaseSupplier, AbstractFbErrorReporter abstractFbErrorReporter, DbFetchPaymentCardIdsHandler dbFetchPaymentCardIdsHandler) {
        this.f12962b = paymentsDatabaseSupplier;
        this.f12963c = abstractFbErrorReporter;
        this.f12964d = dbFetchPaymentCardIdsHandler;
    }

    public final void m13255a(ImmutableList<Long> immutableList) {
        int i;
        Preconditions.checkNotNull(immutableList);
        TracerDetour.a("insertPaymentCardIds (%d paymentCardIds)", Integer.valueOf(immutableList.size()), 1078560901);
        try {
            SQLiteDatabase a = this.f12962b.a();
            SQLiteDetour.a(a, 395861020);
            try {
                int size = immutableList.size();
                i = 0;
                int i2 = 0;
                while (i2 < size) {
                    m13251d(((Long) immutableList.get(i2)).longValue());
                    i = i2 + 1;
                    i2 = i;
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, i);
            } catch (SQLException e) {
                i = e;
                this.f12963c.b("DbInsertPaymentCardIdsHandler", "A SQLException occurred when trying to insert into the database", i);
                SQLiteDetour.b(a, i);
                TracerDetour.a(-1918345730);
            } finally {
                SQLiteDetour.b(a, -1120692437);
            }
            TracerDetour.a(-1918345730);
        } catch (Throwable th) {
            TracerDetour.a(-272139059);
        }
    }

    public final void m13254a(long j) {
        TracerDetour.a("insertOrReplacePrimaryPaymentCardId", 1362860415);
        try {
            SQLiteDatabase a = this.f12962b.a();
            SQLiteDetour.a(a, 1863928915);
            int i;
            try {
                m13251d(j);
                a.delete("primary_payment_card_id", null, null);
                ContentValues contentValues = new ContentValues();
                contentValues.put(PrimaryPaymentCardIdTable.f12865a.a(), Long.valueOf(j));
                SQLiteDetour.a(2090159709);
                a.insertOrThrow("primary_payment_card_id", null, contentValues);
                i = 675769312;
                SQLiteDetour.a(675769312);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, i);
            } catch (SQLException e) {
                i = e;
                this.f12963c.b("DbInsertPaymentCardIdsHandler", "A SQLException occurred when trying to insert into the database", i);
                SQLiteDetour.b(a, i);
                TracerDetour.a(-1570661640);
            } finally {
                SQLiteDetour.b(a, -1096718290);
            }
            TracerDetour.a(-1570661640);
        } catch (Throwable th) {
            TracerDetour.a(690182770);
        }
    }

    private void m13251d(long j) {
        TracerDetour.a("addPaymentCardId", -1400856319);
        try {
            if (!this.f12964d.m13232a().contains(Long.valueOf(j))) {
                SQLiteDatabase a = this.f12962b.a();
                SQLiteDetour.a(a, 1653582849);
                int i;
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(PaymentCardIdsTable.f12862a.a(), Long.valueOf(j));
                    SQLiteDetour.a(-597868279);
                    a.insertOrThrow("payment_card_ids", null, contentValues);
                    i = 43274738;
                    SQLiteDetour.a(43274738);
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, i);
                } catch (SQLException e) {
                    i = e;
                    this.f12963c.b("DbInsertPaymentCardIdsHandler", "A SQLException occurred when trying to insert into the database", i);
                    SQLiteDetour.b(a, i);
                    TracerDetour.a(1619575559);
                } finally {
                    SQLiteDetour.b(a, 281190530);
                }
                TracerDetour.a(1619575559);
            }
        } finally {
            TracerDetour.a(27173166);
        }
    }

    public final void m13257b(long j) {
        TracerDetour.a("deletePaymentCardId", 677079045);
        try {
            SQLiteDatabase a = this.f12962b.a();
            SQLiteDetour.a(a, -591189299);
            try {
                if (m13252e(j)) {
                    m13256b();
                }
                a.delete("payment_card_ids", PaymentCardIdsTable.f12862a.a() + " = ? ", new String[]{String.valueOf(j)});
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, -1687027830);
            } catch (Throwable th) {
                SQLiteDetour.b(a, 1934809480);
            }
        } finally {
            TracerDetour.a(-2036109827);
        }
    }

    public final void m13253a() {
        TracerDetour.a("deleteAllCardIds", -1712271912);
        try {
            SQLiteDatabase a = this.f12962b.a();
            SQLiteDetour.a(a, -1043289268);
            try {
                m13256b();
                int i = "payment_card_ids";
                a.delete(i, null, null);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, i);
            } finally {
                SQLiteDetour.b(a, 737859821);
            }
        } finally {
            TracerDetour.a(1831711403);
        }
    }

    public final void m13256b() {
        TracerDetour.a("clearPrimaryCardIdStatus", -739976037);
        try {
            SQLiteDatabase a = this.f12962b.a();
            SQLiteDetour.a(a, 85027526);
            try {
                int i = "primary_payment_card_id";
                a.delete(i, null, null);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, i);
            } finally {
                SQLiteDetour.b(a, 1748170680);
            }
        } finally {
            TracerDetour.a(-1534719620);
        }
    }

    private boolean m13252e(long j) {
        Long b = this.f12964d.m13233b();
        if (b != null && b.longValue() == j) {
            return true;
        }
        return false;
    }
}
