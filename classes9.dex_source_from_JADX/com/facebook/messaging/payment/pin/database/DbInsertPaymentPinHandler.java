package com.facebook.messaging.payment.pin.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.pin.database.PaymentPinDbSchemaPart.PaymentPinIdTable;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hasHeaderRow */
public class DbInsertPaymentPinHandler {
    private static volatile DbInsertPaymentPinHandler f13690c;
    private final PaymentPinDatabaseSupplier f13691a;
    private final AbstractFbErrorReporter f13692b;

    public static com.facebook.messaging.payment.pin.database.DbInsertPaymentPinHandler m14248a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13690c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.pin.database.DbInsertPaymentPinHandler.class;
        monitor-enter(r1);
        r0 = f13690c;	 Catch:{ all -> 0x003a }
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
        r0 = m14249b(r0);	 Catch:{ all -> 0x0035 }
        f13690c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13690c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.pin.database.DbInsertPaymentPinHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.pin.database.DbInsertPaymentPinHandler");
    }

    private static DbInsertPaymentPinHandler m14249b(InjectorLike injectorLike) {
        return new DbInsertPaymentPinHandler(PaymentPinDatabaseSupplier.m14254a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbInsertPaymentPinHandler(PaymentPinDatabaseSupplier paymentPinDatabaseSupplier, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13691a = paymentPinDatabaseSupplier;
        this.f13692b = abstractFbErrorReporter;
    }

    public final void m14251a(PaymentPin paymentPin) {
        TracerDetour.a("insertOrReplacePaymentPin", 775936027);
        try {
            SQLiteDatabase a = this.f13691a.a();
            SQLiteDetour.a(a, 1238577944);
            try {
                m14250b();
                ContentValues contentValues = new ContentValues();
                contentValues.put(PaymentPinIdTable.f13696a.a(), Long.valueOf(paymentPin.m14261a().isPresent() ? ((Long) paymentPin.m14261a().get()).longValue() : 0));
                SQLiteDetour.a(1438561420);
                a.insertOrThrow("payment_pin_id", null, contentValues);
                SQLiteDetour.a(1278602068);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 1654127723);
            } catch (Throwable e) {
                this.f13692b.b("DbInsertPaymentPinHandler", "A SQLException occurred when trying to insert into the database", e);
                SQLiteDetour.b(a, 19673543);
            } catch (Throwable th) {
                SQLiteDetour.b(a, -555970513);
            }
            TracerDetour.a(2070361956);
        } catch (Throwable th2) {
            TracerDetour.a(-1617254519);
        }
    }

    private void m14250b() {
        TracerDetour.a("clearPinTable", 663806452);
        try {
            SQLiteDatabase a = this.f13691a.a();
            SQLiteDetour.a(a, 1650615479);
            try {
                int i = "payment_pin_id";
                a.delete(i, null, null);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, i);
            } finally {
                SQLiteDetour.b(a, 841826675);
            }
        } finally {
            TracerDetour.a(-386062172);
        }
    }
}
