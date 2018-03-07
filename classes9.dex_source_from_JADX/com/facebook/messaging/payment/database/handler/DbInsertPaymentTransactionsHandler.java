package com.facebook.messaging.payment.database.handler;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecentAllTransactionsTable;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecentIncomingTransactionsTable;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecentOutgoingTransactionsTable;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionsTable;
import com.facebook.messaging.payment.database.handler.DbPaymentsUtil.TransactionsTableResult;
import com.facebook.messaging.payment.database.serialization.DbCommerceOrderSerialization;
import com.facebook.messaging.payment.database.serialization.DbPlatformItemSerialization;
import com.facebook.messaging.payment.database.serialization.DbThemeSerialization;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsParams;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: input_longitude */
public class DbInsertPaymentTransactionsHandler {
    private static volatile DbInsertPaymentTransactionsHandler f12970h;
    private final PaymentsDatabaseSupplier f12971a;
    private final DbPaymentsPropertyUtil f12972b;
    private final PaymentTransactionUtil f12973c;
    private final DbThemeSerialization f12974d;
    private final DbPlatformItemSerialization f12975e;
    private final DbCommerceOrderSerialization f12976f;
    private final AbstractFbErrorReporter f12977g;

    public static com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler m13264a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12970h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler.class;
        monitor-enter(r1);
        r0 = f12970h;	 Catch:{ all -> 0x003a }
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
        r0 = m13266b(r0);	 Catch:{ all -> 0x0035 }
        f12970h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12970h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler");
    }

    private static DbInsertPaymentTransactionsHandler m13266b(InjectorLike injectorLike) {
        return new DbInsertPaymentTransactionsHandler(PaymentsDatabaseSupplier.m13210a(injectorLike), DbPaymentsUtil.m13275a(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), PaymentTransactionUtil.m15519a(injectorLike), DbThemeSerialization.m13290b(injectorLike), DbPlatformItemSerialization.m13287b(injectorLike), DbCommerceOrderSerialization.m13284b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbInsertPaymentTransactionsHandler(PaymentsDatabaseSupplier paymentsDatabaseSupplier, DbPaymentsUtil dbPaymentsUtil, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, PaymentTransactionUtil paymentTransactionUtil, DbThemeSerialization dbThemeSerialization, DbPlatformItemSerialization dbPlatformItemSerialization, DbCommerceOrderSerialization dbCommerceOrderSerialization, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12971a = paymentsDatabaseSupplier;
        this.f12972b = dbPaymentsPropertyUtil;
        this.f12973c = paymentTransactionUtil;
        this.f12974d = dbThemeSerialization;
        this.f12975e = dbPlatformItemSerialization;
        this.f12976f = dbCommerceOrderSerialization;
        this.f12977g = abstractFbErrorReporter;
    }

    public final void m13269a(FetchTransactionListParams fetchTransactionListParams, FetchTransactionListResult fetchTransactionListResult) {
        TracerDetour.a("insertTransactionList", -1093417410);
        try {
            TransactionsTableResult a = DbPaymentsUtil.m13274a(fetchTransactionListParams.m15202a());
            SQLiteDatabase a2 = this.f12971a.a();
            SQLiteDetour.a(a2, -249682737);
            try {
                a2.delete(a.f12983a, null, null);
                ImmutableList a3 = fetchTransactionListResult.m15203a();
                int size = a3.size();
                for (int i = 0; i < size; i++) {
                    PaymentTransaction paymentTransaction = (PaymentTransaction) a3.get(i);
                    m13265a(paymentTransaction, a.f12983a, a.f12985c, a.f12984b);
                    m13270b(paymentTransaction);
                }
                int i2 = this.f12972b;
                i2.b(a.f12986d, fetchTransactionListResult.m15204b());
                a2.setTransactionSuccessful();
                SQLiteDetour.b(a2, i2);
            } finally {
                SQLiteDetour.b(a2, 1819547278);
            }
        } finally {
            TracerDetour.a(-1522947345);
        }
    }

    public final void m13268a(FetchMoreTransactionsParams fetchMoreTransactionsParams, FetchMoreTransactionsResult fetchMoreTransactionsResult) {
        TracerDetour.a("insertMoreTransactions", -57999751);
        try {
            TransactionsTableResult a = DbPaymentsUtil.m13274a(fetchMoreTransactionsParams.m15199a());
            ImmutableList a2 = fetchMoreTransactionsResult.m15200a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                PaymentTransaction paymentTransaction = (PaymentTransaction) a2.get(i);
                m13265a(paymentTransaction, a.f12983a, a.f12985c, a.f12984b);
                m13270b(paymentTransaction);
            }
            this.f12972b.b(a.f12986d, fetchMoreTransactionsResult.m15201b());
        } finally {
            TracerDetour.a(1027636871);
        }
    }

    public final void m13267a(PaymentTransaction paymentTransaction) {
        TracerDetour.a("insertOrUpdateTransactionInRecentTables", -1145550435);
        try {
            m13265a(paymentTransaction, "recent_all_transactions", RecentAllTransactionsTable.f12872a.a(), RecentAllTransactionsTable.f12873b.a());
            if (this.f12973c.m15527c(paymentTransaction)) {
                m13265a(paymentTransaction, "recent_incoming_transactions", RecentIncomingTransactionsTable.f12877a.a(), RecentIncomingTransactionsTable.f12878b.a());
            } else {
                m13265a(paymentTransaction, "recent_outgoing_transactions", RecentOutgoingTransactionsTable.f12882a.a(), RecentOutgoingTransactionsTable.f12883b.a());
            }
            TracerDetour.a(848211338);
        } catch (Throwable th) {
            TracerDetour.a(1897043502);
        }
    }

    public final void m13270b(PaymentTransaction paymentTransaction) {
        int contentValues;
        TracerDetour.a("insertOrUpdatePaymentTransaction", -147784501);
        try {
            SQLiteDatabase a = this.f12971a.a();
            SQLiteDetour.a(a, 727058820);
            try {
                contentValues = new ContentValues();
                contentValues.put(TransactionsTable.f12910a.a(), paymentTransaction.m13520b());
                contentValues.put(TransactionsTable.f12911b.a(), paymentTransaction.m13521d().mo526b());
                contentValues.put(TransactionsTable.f12912c.a(), paymentTransaction.m13522e().mo526b());
                contentValues.put(TransactionsTable.f12913d.a(), paymentTransaction.m13524g().toString());
                contentValues.put(TransactionsTable.f12914e.a(), paymentTransaction.m13523f());
                contentValues.put(TransactionsTable.f12915f.a(), paymentTransaction.m13526i());
                contentValues.put(TransactionsTable.f12916g.a(), paymentTransaction.m13525h());
                contentValues.put(TransactionsTable.f12917h.a(), Integer.valueOf(paymentTransaction.m13527j().m13469d()));
                contentValues.put(TransactionsTable.f12918i.a(), Integer.valueOf(paymentTransaction.m13527j().m13468c()));
                contentValues.put(TransactionsTable.f12919j.a(), paymentTransaction.m13527j().m13467b());
                contentValues.put(TransactionsTable.f12920k.a(), Integer.valueOf(paymentTransaction.m13528k().m13469d()));
                contentValues.put(TransactionsTable.f12921l.a(), paymentTransaction.m13529l().m13950a());
                contentValues.put(TransactionsTable.f12922m.a(), this.f12974d.m13292a(paymentTransaction.m13529l().m13951b()));
                contentValues.put(TransactionsTable.f12923n.a(), this.f12975e.m13289a(paymentTransaction.m13530m()));
                contentValues.put(TransactionsTable.f12924o.a(), this.f12976f.m13286a(paymentTransaction.m13531n()));
                if (a.update("transactions", contentValues, TransactionsTable.f12910a.a() + " = ? ", new String[]{paymentTransaction.m13520b()}) == 0) {
                    String str = "transactions";
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, -1469466865);
            } catch (SQLException e) {
                contentValues = e;
                this.f12977g.b("DbInsertPaymentTransactionsHandler", "A SQLException occurred when trying to insert into the database", contentValues);
                SQLiteDetour.b(a, contentValues);
                TracerDetour.a(-1466984109);
            } finally {
                SQLiteDetour.b(a, 1955980938);
            }
            TracerDetour.a(-1466984109);
        } catch (Throwable th) {
            TracerDetour.a(1225891858);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13265a(com.facebook.messaging.payment.model.PaymentTransaction r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
        r6 = this;
        r0 = "insertOrUpdateTransactionInRecentAll";
        r1 = 1500916779; // 0x59762c2b float:4.33071297E15 double:7.41551418E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r6.f12971a;	 Catch:{ all -> 0x007a }
        r1 = r0.a();	 Catch:{ all -> 0x007a }
        r0 = 661184396; // 0x2768df8c float:3.2317653E-15 double:3.266684956E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1, r0);	 Catch:{ all -> 0x007a }
        r0 = new android.content.ContentValues;	 Catch:{ all -> 0x0072 }
        r0.<init>();	 Catch:{ all -> 0x0072 }
        r2 = r7.m13523f();	 Catch:{ all -> 0x0072 }
        r2 = java.lang.Long.parseLong(r2);	 Catch:{ all -> 0x0072 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0072 }
        r0.put(r9, r2);	 Catch:{ all -> 0x0072 }
        r2 = r7.m13520b();	 Catch:{ all -> 0x0072 }
        r0.put(r10, r2);	 Catch:{ all -> 0x0072 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
        r2.<init>();	 Catch:{ all -> 0x0072 }
        r2 = r2.append(r10);	 Catch:{ all -> 0x0072 }
        r3 = " = ? ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0072 }
        r2 = r2.toString();	 Catch:{ all -> 0x0072 }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ all -> 0x0072 }
        r4 = 0;
        r5 = r7.m13520b();	 Catch:{ all -> 0x0072 }
        r3[r4] = r5;	 Catch:{ all -> 0x0072 }
        r2 = r1.update(r8, r0, r2, r3);	 Catch:{ all -> 0x0072 }
        if (r2 != 0) goto L_0x0062;
    L_0x0052:
        r2 = 0;
        r3 = -1924442291; // 0xffffffff8d4b574d float:-6.265929E-31 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r3);	 Catch:{ all -> 0x0072 }
        r1.insertOrThrow(r8, r2, r0);	 Catch:{ all -> 0x0072 }
        r0 = -2025875473; // 0xffffffff873f97ef float:-1.4413892E-34 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0);	 Catch:{ all -> 0x0072 }
    L_0x0062:
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x0072 }
        r0 = -2085646447; // 0xffffffff83af8f91 float:-1.0318537E-36 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);	 Catch:{  }
        r0 = -210023077; // 0xfffffffff37b4d5b float:-1.9910209E31 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        return;
    L_0x0072:
        r0 = move-exception;
        r2 = 666402560; // 0x27b87f00 float:5.1207953E-15 double:3.29246611E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r2);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x007a:
        r0 = move-exception;
        r1 = 243174332; // 0xe7e8bbc float:3.1375197E-30 double:1.201440834E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler.a(com.facebook.messaging.payment.model.PaymentTransaction, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
