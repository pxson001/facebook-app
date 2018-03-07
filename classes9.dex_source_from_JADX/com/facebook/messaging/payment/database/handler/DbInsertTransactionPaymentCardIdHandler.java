package com.facebook.messaging.payment.database.handler;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionPaymentCardIdTable;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: input_latitude */
public class DbInsertTransactionPaymentCardIdHandler {
    private static volatile DbInsertTransactionPaymentCardIdHandler f12978d;
    private final PaymentsDatabaseSupplier f12979a;
    private final DbFetchTransactionPaymentCardIdHandler f12980b;
    private final AbstractFbErrorReporter f12981c;

    public static com.facebook.messaging.payment.database.handler.DbInsertTransactionPaymentCardIdHandler m13271a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12978d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbInsertTransactionPaymentCardIdHandler.class;
        monitor-enter(r1);
        r0 = f12978d;	 Catch:{ all -> 0x003a }
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
        r0 = m13272b(r0);	 Catch:{ all -> 0x0035 }
        f12978d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12978d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbInsertTransactionPaymentCardIdHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbInsertTransactionPaymentCardIdHandler");
    }

    private static DbInsertTransactionPaymentCardIdHandler m13272b(InjectorLike injectorLike) {
        return new DbInsertTransactionPaymentCardIdHandler(PaymentsDatabaseSupplier.m13210a(injectorLike), DbFetchTransactionPaymentCardIdHandler.m13246a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbInsertTransactionPaymentCardIdHandler(PaymentsDatabaseSupplier paymentsDatabaseSupplier, DbFetchTransactionPaymentCardIdHandler dbFetchTransactionPaymentCardIdHandler, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12979a = paymentsDatabaseSupplier;
        this.f12981c = abstractFbErrorReporter;
        this.f12980b = dbFetchTransactionPaymentCardIdHandler;
    }

    public final void m13273a(long j, long j2) {
        int i;
        TracerDetour.a("setPaymentCardIdForTransaction", -1982467348);
        try {
            if (this.f12980b.m13248a(j) == null) {
                SQLiteDatabase a = this.f12979a.a();
                SQLiteDetour.a(a, -258047276);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TransactionPaymentCardIdTable.f12906a.a(), Long.valueOf(j));
                    contentValues.put(TransactionPaymentCardIdTable.f12907b.a(), Long.valueOf(j2));
                    SQLiteDetour.a(-54484592);
                    a.insertOrThrow("transaction_payment_card_id", null, contentValues);
                    i = 89943107;
                    SQLiteDetour.a(89943107);
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, i);
                } catch (SQLException e) {
                    i = e;
                    this.f12981c.b("DbInsertTransactionPaymentCardIdHandler", "A SQLException occurred when trying to insert into the database", i);
                    SQLiteDetour.b(a, i);
                    TracerDetour.a(-1687671474);
                } finally {
                    SQLiteDetour.b(a, 344882677);
                }
                TracerDetour.a(-1687671474);
            }
        } finally {
            TracerDetour.a(-695040816);
        }
    }
}
