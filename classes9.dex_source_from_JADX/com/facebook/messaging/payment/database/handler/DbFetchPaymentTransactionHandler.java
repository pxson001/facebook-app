package com.facebook.messaging.payment.database.handler;

import android.database.Cursor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.contacts.graphql.Contact;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionsTable;
import com.facebook.messaging.payment.database.serialization.DbCommerceOrderSerialization;
import com.facebook.messaging.payment.database.serialization.DbPlatformItemSerialization;
import com.facebook.messaging.payment.database.serialization.DbThemeSerialization;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionBuilder;
import com.facebook.messaging.payment.model.Receiver;
import com.facebook.messaging.payment.model.Sender;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: insertOrReplacePaymentPin */
public class DbFetchPaymentTransactionHandler {
    private static volatile DbFetchPaymentTransactionHandler f12949h;
    private final DbPaymentsPropertyUtil f12950a;
    public final DbPaymentsUtil f12951b;
    private final PaymentsDatabaseSupplier f12952c;
    private final DbThemeSerialization f12953d;
    private final DbPlatformItemSerialization f12954e;
    private final DbCommerceOrderSerialization f12955f;
    private final AbstractFbErrorReporter f12956g;

    public static com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler m13242a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12949h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler.class;
        monitor-enter(r1);
        r0 = f12949h;	 Catch:{ all -> 0x003a }
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
        r0 = m13244b(r0);	 Catch:{ all -> 0x0035 }
        f12949h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12949h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler");
    }

    private static DbFetchPaymentTransactionHandler m13244b(InjectorLike injectorLike) {
        return new DbFetchPaymentTransactionHandler(DbPaymentsPropertyUtil.m13206a(injectorLike), DbPaymentsUtil.m13275a(injectorLike), PaymentsDatabaseSupplier.m13210a(injectorLike), DbThemeSerialization.m13290b(injectorLike), DbPlatformItemSerialization.m13287b(injectorLike), DbCommerceOrderSerialization.m13284b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbFetchPaymentTransactionHandler(DbPaymentsPropertyUtil dbPaymentsPropertyUtil, DbPaymentsUtil dbPaymentsUtil, PaymentsDatabaseSupplier paymentsDatabaseSupplier, DbThemeSerialization dbThemeSerialization, DbPlatformItemSerialization dbPlatformItemSerialization, DbCommerceOrderSerialization dbCommerceOrderSerialization, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12950a = dbPaymentsPropertyUtil;
        this.f12951b = dbPaymentsUtil;
        this.f12952c = paymentsDatabaseSupplier;
        this.f12953d = dbThemeSerialization;
        this.f12954e = dbPlatformItemSerialization;
        this.f12955f = dbCommerceOrderSerialization;
        this.f12956g = abstractFbErrorReporter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    public final com.facebook.messaging.payment.model.PaymentTransaction m13245a(long r10) {
        /*
        r9 = this;
        r8 = 0;
        r0 = "getPaymentTransaction";
        r1 = -1612924040; // 0xffffffff9fdcbb78 float:-9.3483765E-20 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r9.f12952c;	 Catch:{ all -> 0x009f }
        r0 = r0.a();	 Catch:{ all -> 0x009f }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r1.<init>();	 Catch:{ all -> 0x009f }
        r2 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.TransactionsTable.f12910a;	 Catch:{ all -> 0x009f }
        r2 = r2.a();	 Catch:{ all -> 0x009f }
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r2 = "=";
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r1 = r1.append(r10);	 Catch:{ all -> 0x009f }
        r3 = r1.toString();	 Catch:{ all -> 0x009f }
        r1 = "transactions";
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x009f }
        r0 = r1.getCount();	 Catch:{ Exception -> 0x0085 }
        r2 = 1;
        if (r0 <= r2) goto L_0x0063;
    L_0x003e:
        r0 = r9.f12956g;	 Catch:{ Exception -> 0x0085 }
        r2 = "DbFetchPaymentTransactionsHandler";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0085 }
        r4 = "Transactions table should only have one row for a given transaction ID, but it has ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0085 }
        r4 = r1.getCount();	 Catch:{ Exception -> 0x0085 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0085 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0085 }
        r0.b(r2, r3);	 Catch:{ Exception -> 0x0085 }
        r1.close();	 Catch:{  }
        r0 = 1166804308; // 0x458c0554 float:4480.666 double:5.76477924E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
    L_0x0062:
        return r0;
    L_0x0063:
        r0 = r1.getCount();	 Catch:{  }
        if (r0 != 0) goto L_0x0074;
    L_0x0069:
        r1.close();	 Catch:{  }
        r0 = -1456639904; // 0xffffffffa92d7060 float:-3.8511186E-14 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0062;
    L_0x0074:
        r1.moveToFirst();	 Catch:{  }
        r0 = r9.m13243a(r1);	 Catch:{  }
        r1.close();	 Catch:{  }
        r1 = 772515373; // 0x2e0ba62d float:3.1752535E-11 double:3.816733067E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0062;
    L_0x0085:
        r0 = move-exception;
        r2 = r9.f12956g;	 Catch:{ all -> 0x009a }
        r3 = "DbFetchPaymentTransactionsHandler";
        r4 = "Reading the transaction from the database threw an exception.";
        r2.b(r3, r4, r0);	 Catch:{ all -> 0x009a }
        r1.close();	 Catch:{  }
        r0 = -1310987410; // 0xffffffffb1dbeb6e float:-6.400504E-9 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0062;
    L_0x009a:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x009f:
        r0 = move-exception;
        r1 = -942369179; // 0xffffffffc7d49665 float:-108844.79 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler.a(long):com.facebook.messaging.payment.model.PaymentTransaction");
    }

    private PaymentTransaction m13243a(Cursor cursor) {
        Sender sender;
        Receiver receiver;
        String string = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12911b.d));
        Contact b = this.f12951b.m13279b(string);
        if (b == null) {
            sender = null;
        } else {
            sender = new Sender(string, b.e().i(), b.s());
        }
        Sender sender2 = sender;
        string = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12912c.d));
        b = this.f12951b.m13279b(string);
        if (b == null) {
            receiver = null;
        } else {
            receiver = new Receiver(string, b.e().i(), b.s());
        }
        Receiver receiver2 = receiver;
        if (sender2 == null || receiver2 == null) {
            return null;
        }
        Amount amount = new Amount(cursor.getString(cursor.getColumnIndex(TransactionsTable.f12919j.d)), cursor.getInt(cursor.getColumnIndex(TransactionsTable.f12918i.d)), cursor.getInt(cursor.getColumnIndex(TransactionsTable.f12917h.d)));
        Amount amount2 = new Amount(cursor.getString(cursor.getColumnIndex(TransactionsTable.f12919j.d)), cursor.getInt(cursor.getColumnIndex(TransactionsTable.f12918i.d)), cursor.getInt(cursor.getColumnIndex(TransactionsTable.f12920k.d)));
        Builder builder = new Builder();
        builder.f13469a = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12921l.d));
        Builder builder2 = builder;
        builder2.f13470b = this.f12953d.m13291a(cursor.getString(cursor.getColumnIndex(TransactionsTable.f12922m.d)));
        TransferContextModel a = builder2.m13943a();
        PaymentTransactionBuilder newBuilder = PaymentTransaction.newBuilder();
        newBuilder.f13243a = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12910a.d));
        newBuilder = newBuilder;
        newBuilder.f13245c = sender2;
        PaymentTransactionBuilder paymentTransactionBuilder = newBuilder;
        paymentTransactionBuilder.f13246d = receiver2;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13247e = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12914e.d));
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13250h = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12915f.d));
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13249g = cursor.getString(cursor.getColumnIndex(TransactionsTable.f12916g.d));
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13248f = TransferStatus.fromString(cursor.getString(cursor.getColumnIndex(TransactionsTable.f12913d.d)));
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13251i = amount;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13252j = amount2;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13253k = a;
        PaymentTransactionBuilder paymentTransactionBuilder2 = paymentTransactionBuilder;
        paymentTransactionBuilder2.f13254l = this.f12954e.m13288a(cursor.getString(cursor.getColumnIndex(TransactionsTable.f12923n.d)));
        paymentTransactionBuilder2 = paymentTransactionBuilder2;
        paymentTransactionBuilder2.f13255m = this.f12955f.m13285a(cursor.getString(cursor.getColumnIndex(TransactionsTable.f12924o.d)));
        return paymentTransactionBuilder2.m13534o();
    }
}
