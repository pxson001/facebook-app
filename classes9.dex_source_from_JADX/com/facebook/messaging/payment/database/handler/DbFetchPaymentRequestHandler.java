package com.facebook.messaging.payment.database.handler;

import android.database.Cursor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RequestsTable;
import com.facebook.messaging.payment.database.serialization.DbThemeSerialization;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentCurrencyQuantityModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: insertOrReplacePrimaryPaymentCardId */
public class DbFetchPaymentRequestHandler {
    private static volatile DbFetchPaymentRequestHandler f12940i;
    private final DbPaymentsPropertyUtil f12941a;
    private final PaymentsDatabaseSupplier f12942b;
    private final DbThemeSerialization f12943c;
    private final AbstractFbErrorReporter f12944d;
    private final DbPaymentsUtil f12945e;
    private final PaymentRequestUtil f12946f;
    private final Provider<User> f12947g;
    private final DbFetchPaymentTransactionHandler f12948h;

    public static com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler m13234a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12940i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler.class;
        monitor-enter(r1);
        r0 = f12940i;	 Catch:{ all -> 0x003a }
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
        r0 = m13237b(r0);	 Catch:{ all -> 0x0035 }
        f12940i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12940i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler");
    }

    private static DbFetchPaymentRequestHandler m13237b(InjectorLike injectorLike) {
        return new DbFetchPaymentRequestHandler(DbPaymentsPropertyUtil.m13206a(injectorLike), PaymentsDatabaseSupplier.m13210a(injectorLike), DbThemeSerialization.m13290b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DbPaymentsUtil.m13275a(injectorLike), PaymentRequestUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 3596), DbFetchPaymentTransactionHandler.m13242a(injectorLike));
    }

    @Inject
    public DbFetchPaymentRequestHandler(DbPaymentsPropertyUtil dbPaymentsPropertyUtil, PaymentsDatabaseSupplier paymentsDatabaseSupplier, DbThemeSerialization dbThemeSerialization, FbErrorReporter fbErrorReporter, DbPaymentsUtil dbPaymentsUtil, PaymentRequestUtil paymentRequestUtil, Provider<User> provider, DbFetchPaymentTransactionHandler dbFetchPaymentTransactionHandler) {
        this.f12941a = dbPaymentsPropertyUtil;
        this.f12942b = paymentsDatabaseSupplier;
        this.f12943c = dbThemeSerialization;
        this.f12944d = fbErrorReporter;
        this.f12945e = dbPaymentsUtil;
        this.f12946f = paymentRequestUtil;
        this.f12947g = provider;
        this.f12948h = dbFetchPaymentTransactionHandler;
    }

    @Nullable
    public final ImmutableList<PaymentRequest> m13241a() {
        TracerDetour.a("getIncomingPaymentRequests", 1420054441);
        try {
            ImmutableList b = m13238b();
            if (b == null) {
                return null;
            }
            this.f12945e.m13278a(m13236a(b));
            Builder builder = new Builder();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                PaymentRequestModel a = m13240a(((Long) b.get(i)).longValue());
                if (a != null) {
                    builder.c(a);
                }
            }
            ImmutableList<PaymentRequest> a2 = this.f12946f.a(builder.b());
            TracerDetour.a(-325197757);
            return a2;
        } finally {
            TracerDetour.a(-406518249);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    public final com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel m13240a(long r10) {
        /*
        r9 = this;
        r8 = 0;
        r0 = "getPaymentRequest";
        r1 = 1471451291; // 0x57b4909b float:3.97066338E14 double:7.269935324E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r9.f12942b;	 Catch:{ all -> 0x009f }
        r0 = r0.a();	 Catch:{ all -> 0x009f }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r1.<init>();	 Catch:{ all -> 0x009f }
        r2 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RequestsTable.f12891a;	 Catch:{ all -> 0x009f }
        r2 = r2.a();	 Catch:{ all -> 0x009f }
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r2 = "=";
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r1 = r1.append(r10);	 Catch:{ all -> 0x009f }
        r3 = r1.toString();	 Catch:{ all -> 0x009f }
        r1 = "requests";
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
        r0 = r9.f12944d;	 Catch:{ Exception -> 0x0085 }
        r2 = "DbFetchPaymentRequestsHandler";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0085 }
        r4 = "Requests table should only have one row for a given request ID, but it has ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0085 }
        r4 = r1.getCount();	 Catch:{ Exception -> 0x0085 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0085 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0085 }
        r0.b(r2, r3);	 Catch:{ Exception -> 0x0085 }
        r1.close();	 Catch:{  }
        r0 = 538341131; // 0x20166f0b float:1.2742235E-19 double:2.659758586E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
    L_0x0062:
        return r0;
    L_0x0063:
        r0 = r1.getCount();	 Catch:{  }
        if (r0 != 0) goto L_0x0074;
    L_0x0069:
        r1.close();	 Catch:{  }
        r0 = -757293453; // 0xffffffffd2dc9e73 float:-4.73775571E11 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0062;
    L_0x0074:
        r1.moveToFirst();	 Catch:{  }
        r0 = r9.m13235a(r1);	 Catch:{  }
        r1.close();	 Catch:{  }
        r1 = -309436223; // 0xffffffffed8e60c1 float:-5.50798E27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0062;
    L_0x0085:
        r0 = move-exception;
        r2 = r9.f12944d;	 Catch:{ all -> 0x009a }
        r3 = "DbFetchPaymentRequestHandler";
        r4 = "Reading the request from the database threw an exception.";
        r2.b(r3, r4, r0);	 Catch:{ all -> 0x009a }
        r1.close();	 Catch:{  }
        r0 = 2044562805; // 0x79dd8d75 float:1.4379584E35 double:1.0101482427E-314;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0062;
    L_0x009a:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x009f:
        r0 = move-exception;
        r1 = -961711302; // 0xffffffffc6ad733a float:-22201.613 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler.a(long):com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels$PaymentRequestModel");
    }

    private PaymentRequestModel m13235a(Cursor cursor) {
        PaymentTransactionModel paymentTransactionModel = null;
        String string = cursor.getString(cursor.getColumnIndex(RequestsTable.f12892b.d));
        String string2 = cursor.getString(cursor.getColumnIndex(RequestsTable.f12893c.d));
        PaymentCurrencyQuantityModel.Builder builder = new PaymentCurrencyQuantityModel.Builder();
        builder.f13310a = cursor.getInt(cursor.getColumnIndex(RequestsTable.f12897g.d));
        builder = builder;
        builder.f13312c = cursor.getInt(cursor.getColumnIndex(RequestsTable.f12898h.d));
        builder = builder;
        builder.f13311b = cursor.getString(cursor.getColumnIndex(RequestsTable.f12899i.d));
        PaymentCurrencyQuantityModel a = builder.m13698a();
        ThemeModel a2 = this.f12943c.m13291a(cursor.getString(cursor.getColumnIndex(RequestsTable.f12901k.d)));
        String string3 = cursor.getString(cursor.getColumnIndex(RequestsTable.f12903m.d));
        PaymentTransaction a3 = string3 == null ? null : this.f12948h.m13245a(Long.parseLong(string3));
        PaymentRequestModel.Builder builder2 = new PaymentRequestModel.Builder();
        builder2.f13366d = cursor.getString(cursor.getColumnIndex(RequestsTable.f12891a.d));
        builder2 = builder2;
        builder2.f13371i = PaymentUserModel.m13871a(this.f12945e.m13277a(string));
        PaymentRequestModel.Builder builder3 = builder2;
        builder3.f13370h = PaymentUserModel.m13871a(this.f12945e.m13277a(string2));
        builder3 = builder3;
        builder3.f13364b = cursor.getLong(cursor.getColumnIndex(RequestsTable.f12895e.d));
        builder3 = builder3;
        builder3.f13373k = cursor.getLong(cursor.getColumnIndex(RequestsTable.f12896f.d));
        builder3 = builder3;
        builder3.f13368f = GraphQLPeerToPeerPaymentRequestStatus.fromString(cursor.getString(cursor.getColumnIndex(RequestsTable.f12894d.d)));
        builder3 = builder3;
        builder3.f13363a = a;
        builder3 = builder3;
        builder3.f13367e = cursor.getString(cursor.getColumnIndex(RequestsTable.f12900j.d));
        builder3 = builder3;
        if (a2 instanceof ThemeModel) {
            a2 = a2;
        } else {
            a2 = null;
        }
        builder3.f13369g = a2;
        PaymentRequestModel.Builder builder4 = builder3;
        builder4.f13365c = cursor.getString(cursor.getColumnIndex(RequestsTable.f12902l.d));
        builder4 = builder4;
        if (a3 != null) {
            paymentTransactionModel = a3.m13532p();
        }
        builder4.f13372j = paymentTransactionModel;
        return builder4.m13795a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    @com.google.common.annotations.VisibleForTesting
    private com.google.common.collect.ImmutableList<java.lang.Long> m13238b() {
        /*
        r9 = this;
        r8 = 0;
        r0 = "getIncomingRequestIds";
        r1 = -1150899409; // 0xffffffffbb66ab2f float:-0.0035197248 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r9.f12941a;	 Catch:{ all -> 0x006d }
        r1 = com.facebook.messaging.payment.database.DbPaymentsProperties.f12848d;	 Catch:{ all -> 0x006d }
        r2 = 0;
        r0 = r0.a(r1, r2);	 Catch:{ all -> 0x006d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = -1780362517; // 0xffffffff95e1d2eb float:-9.1209546E-26 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = r9.f12942b;	 Catch:{  }
        r0 = r0.a();	 Catch:{  }
        r1 = "incoming_request_ids";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{  }
        r0 = com.google.common.collect.ImmutableList.builder();	 Catch:{ Exception -> 0x0045 }
    L_0x0032:
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x005a;
    L_0x0038:
        r2 = 0;
        r2 = r1.getLong(r2);	 Catch:{ Exception -> 0x0045 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0045 }
        r0.c(r2);	 Catch:{ Exception -> 0x0045 }
        goto L_0x0032;
    L_0x0045:
        r0 = move-exception;
        r2 = r9.f12944d;	 Catch:{ all -> 0x0068 }
        r3 = "DbFetchPaymentRequestHandler";
        r4 = "Reading the request from the database threw an exception.";
        r2.b(r3, r4, r0);	 Catch:{ all -> 0x0068 }
        r1.close();	 Catch:{  }
        r0 = -1115839861; // 0xffffffffbd7da28b float:-0.06192259 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x001b;
    L_0x005a:
        r0 = r0.b();	 Catch:{  }
        r1.close();	 Catch:{  }
        r1 = 2099401666; // 0x7d2253c2 float:1.3485614E37 double:1.03724224E-314;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x001b;
    L_0x0068:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006d:
        r0 = move-exception;
        r1 = 1557049307; // 0x5cceafdb float:4.65417603E17 double:7.692845715E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler.b():com.google.common.collect.ImmutableList<java.lang.Long>");
    }

    @VisibleForTesting
    private ImmutableList<String> m13236a(ImmutableList<Long> immutableList) {
        Builder builder = new Builder();
        builder.c(((User) this.f12947g.get()).a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(m13239b(((Long) immutableList.get(i)).longValue()));
        }
        return builder.b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    @com.google.common.annotations.VisibleForTesting
    private java.lang.String m13239b(long r10) {
        /*
        r9 = this;
        r8 = 0;
        r0 = "getRequesterIdForRequest";
        r1 = 1885379883; // 0x70609d2b float:2.7805859E29 double:9.315014296E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r9.f12942b;	 Catch:{ all -> 0x00a9 }
        r0 = r0.a();	 Catch:{ all -> 0x00a9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a9 }
        r1.<init>();	 Catch:{ all -> 0x00a9 }
        r2 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RequestsTable.f12891a;	 Catch:{ all -> 0x00a9 }
        r2 = r2.a();	 Catch:{ all -> 0x00a9 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00a9 }
        r2 = "=";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00a9 }
        r1 = r1.append(r10);	 Catch:{ all -> 0x00a9 }
        r3 = r1.toString();	 Catch:{ all -> 0x00a9 }
        r1 = "requests";
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00a9 }
        r0 = r1.getCount();	 Catch:{ Exception -> 0x008f }
        r2 = 1;
        if (r0 <= r2) goto L_0x0063;
    L_0x003e:
        r0 = r9.f12944d;	 Catch:{ Exception -> 0x008f }
        r2 = "DbFetchPaymentRequestsHandler";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008f }
        r4 = "Requests table should only have one row for a given request ID, but it has ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x008f }
        r4 = r1.getCount();	 Catch:{ Exception -> 0x008f }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x008f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x008f }
        r0.b(r2, r3);	 Catch:{ Exception -> 0x008f }
        r1.close();	 Catch:{  }
        r0 = -610956459; // 0xffffffffdb958b55 float:-8.4185937E16 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
    L_0x0062:
        return r0;
    L_0x0063:
        r0 = r1.getCount();	 Catch:{  }
        if (r0 != 0) goto L_0x0074;
    L_0x0069:
        r1.close();	 Catch:{  }
        r0 = 705800193; // 0x2a11a801 float:1.2936875E-13 double:3.48711628E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0062;
    L_0x0074:
        r1.moveToFirst();	 Catch:{  }
        r0 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RequestsTable.f12892b;	 Catch:{  }
        r0 = r0.a();	 Catch:{  }
        r0 = r1.getColumnIndex(r0);	 Catch:{  }
        r0 = r1.getString(r0);	 Catch:{  }
        r1.close();	 Catch:{  }
        r1 = -1911726636; // 0xffffffff8e0d5dd4 float:-1.7424768E-30 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0062;
    L_0x008f:
        r0 = move-exception;
        r2 = r9.f12944d;	 Catch:{ all -> 0x00a4 }
        r3 = "DbFetchPaymentRequestHandler";
        r4 = "Reading the request from the database threw an exception.";
        r2.b(r3, r4, r0);	 Catch:{ all -> 0x00a4 }
        r1.close();	 Catch:{  }
        r0 = -1070074633; // 0xffffffffc037f4f7 float:-2.8743265 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r8;
        goto L_0x0062;
    L_0x00a4:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00a9:
        r0 = move-exception;
        r1 = 1870042219; // 0x6f76946b float:7.631274E28 double:9.239236167E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler.b(long):java.lang.String");
    }
}
