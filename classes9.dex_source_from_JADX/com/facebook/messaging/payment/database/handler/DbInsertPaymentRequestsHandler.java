package com.facebook.messaging.payment.database.handler;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentPropertyKey;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RequestsTable;
import com.facebook.messaging.payment.database.serialization.DbThemeSerialization;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: input_string */
public class DbInsertPaymentRequestsHandler {
    private static volatile DbInsertPaymentRequestsHandler f12965e;
    private final DbPaymentsPropertyUtil f12966a;
    private final PaymentsDatabaseSupplier f12967b;
    private final DbThemeSerialization f12968c;
    private final AbstractFbErrorReporter f12969d;

    public static com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler m13258a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12965e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler.class;
        monitor-enter(r1);
        r0 = f12965e;	 Catch:{ all -> 0x003a }
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
        r0 = m13259b(r0);	 Catch:{ all -> 0x0035 }
        f12965e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12965e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler");
    }

    private static DbInsertPaymentRequestsHandler m13259b(InjectorLike injectorLike) {
        return new DbInsertPaymentRequestsHandler(DbPaymentsPropertyUtil.m13206a(injectorLike), PaymentsDatabaseSupplier.m13210a(injectorLike), DbThemeSerialization.m13290b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbInsertPaymentRequestsHandler(DbPaymentsPropertyUtil dbPaymentsPropertyUtil, PaymentsDatabaseSupplier paymentsDatabaseSupplier, DbThemeSerialization dbThemeSerialization, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12966a = dbPaymentsPropertyUtil;
        this.f12967b = paymentsDatabaseSupplier;
        this.f12968c = dbThemeSerialization;
        this.f12969d = abstractFbErrorReporter;
    }

    public final void m13262a(ImmutableList<PaymentRequest> immutableList) {
        TracerDetour.a("insertOrUpdateIncomingPaymentRequests", 1058817102);
        try {
            SQLiteDatabase a = this.f12967b.a();
            SQLiteDetour.a(a, 1528031940);
            try {
                a.delete("incoming_request_ids", null, null);
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    PaymentRequestModel paymentRequestModel = (PaymentRequestModel) immutableList.get(i);
                    m13260c(paymentRequestModel);
                    m13263b(paymentRequestModel);
                }
                DbPaymentsPropertyUtil dbPaymentsPropertyUtil = this.f12966a;
                DbPaymentPropertyKey dbPaymentPropertyKey = DbPaymentsProperties.f12848d;
                SQLiteDetour.b(a, -340998697);
            } finally {
                SQLiteDetour.b(a, -686624153);
            }
        } finally {
            TracerDetour.a(-1126051244);
        }
    }

    public final void m13261a(PaymentRequestModel paymentRequestModel) {
        if (this.f12966a.a(DbPaymentsProperties.f12848d, false)) {
            m13260c(paymentRequestModel);
        }
        m13263b(paymentRequestModel);
    }

    public final void m13263b(PaymentRequestModel paymentRequestModel) {
        String str = null;
        TracerDetour.a("insertOrUpdatePaymentRequest", -13403817);
        try {
            SQLiteDatabase a = this.f12967b.a();
            SQLiteDetour.a(a, -714181379);
            TracerDetour.a(-357519393);
            return;
        } catch (Throwable th) {
            TracerDetour.a(1005089119);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(RequestsTable.f12891a.a(), paymentRequestModel.lw_());
            contentValues.put(RequestsTable.f12892b.a(), paymentRequestModel.m13816k().m13879c());
            contentValues.put(RequestsTable.f12893c.a(), paymentRequestModel.m13815j().m13879c());
            contentValues.put(RequestsTable.f12894d.a(), paymentRequestModel.lx_().toString());
            contentValues.put(RequestsTable.f12895e.a(), Long.valueOf(paymentRequestModel.m13812c()));
            contentValues.put(RequestsTable.f12896f.a(), Long.valueOf(paymentRequestModel.m13818m()));
            contentValues.put(RequestsTable.f12897g.a(), Integer.valueOf(paymentRequestModel.m13811b().m13703a()));
            contentValues.put(RequestsTable.f12898h.a(), Integer.valueOf(paymentRequestModel.m13811b().m13708c()));
            contentValues.put(RequestsTable.f12899i.a(), paymentRequestModel.m13811b().m13707b());
            contentValues.put(RequestsTable.f12900j.a(), paymentRequestModel.m13814g());
            contentValues.put(RequestsTable.f12901k.a(), this.f12968c.m13292a(paymentRequestModel.ly_()));
            contentValues.put(RequestsTable.f12902l.a(), paymentRequestModel.m13813d());
            String a2 = RequestsTable.f12903m.a();
            if (paymentRequestModel.m13817l() != null) {
                str = paymentRequestModel.m13817l().lC_();
            }
            contentValues.put(a2, str);
            if (a.update("requests", contentValues, RequestsTable.f12891a.a() + " = ? ", new String[]{String.valueOf(paymentRequestModel.lw_())}) == 0) {
                SQLiteDetour.a(887816255);
                a.insertOrThrow("requests", null, contentValues);
                SQLiteDetour.a(1547528280);
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -888281364);
        } catch (Throwable e) {
            this.f12969d.b("DbInsertPaymentRequestsHandler", "A SQLException occurred when trying to insert into the database", e);
            SQLiteDetour.b(a, 2006093831);
        } catch (Throwable th2) {
            SQLiteDetour.b(a, 1954653523);
        }
    }

    private void m13260c(PaymentRequestModel paymentRequestModel) {
        TracerDetour.a("insertOrUpdateIncomingPaymentRequest", 1018570503);
        try {
            SQLiteDatabase a = this.f12967b.a();
            SQLiteDetour.a(a, 1122552790);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(RequestsTable.f12891a.a(), paymentRequestModel.lw_());
                if (a.update("incoming_request_ids", contentValues, RequestsTable.f12891a.a() + " = ? ", new String[]{String.valueOf(paymentRequestModel.lw_())}) == 0) {
                    String str = "incoming_request_ids";
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 1832402911);
            } finally {
                SQLiteDetour.b(a, 141500945);
            }
        } finally {
            TracerDetour.a(-1820175846);
        }
    }
}
