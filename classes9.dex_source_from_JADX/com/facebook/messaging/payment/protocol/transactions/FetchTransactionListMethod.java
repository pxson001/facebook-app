package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchAllTransactionListQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchIncomingTransactionListQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchOutgoingTransactionListQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchAllTransactionListQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchIncomingTransactionListQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchOutgoingTransactionListQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionsModel;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: flow_id */
public class FetchTransactionListMethod extends AbstractPersistedGraphQlApiMethod<FetchTransactionListParams, FetchTransactionListResult> {
    private static volatile FetchTransactionListMethod f14607d;
    private final PaymentTransactionQueryUtils f14608c;

    public static com.facebook.messaging.payment.protocol.transactions.FetchTransactionListMethod m15128a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14607d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.transactions.FetchTransactionListMethod.class;
        monitor-enter(r1);
        r0 = f14607d;	 Catch:{ all -> 0x003a }
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
        r0 = m15130b(r0);	 Catch:{ all -> 0x0035 }
        f14607d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14607d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.transactions.FetchTransactionListMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.transactions.FetchTransactionListMethod");
    }

    private static FetchTransactionListMethod m15130b(InjectorLike injectorLike) {
        return new FetchTransactionListMethod(PaymentTransactionQueryUtils.m15141b(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m15131a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        PaymentTransactionsModel b = m15129b((FetchTransactionListParams) obj, jsonParser);
        if (b == null) {
            return new FetchTransactionListResult(RegularImmutableList.a, true);
        }
        Builder builder = new Builder();
        ImmutableList a = b.m13866a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(this.f14608c.m15142a((PaymentTransactionModel) a.get(i)));
        }
        return new FetchTransactionListResult(builder.b(), !b.m13867j().m13862a());
    }

    public final GraphQlQueryString m15133f(Object obj) {
        GraphQlQueryString fetchAllTransactionListQueryString;
        FetchTransactionListParams fetchTransactionListParams = (FetchTransactionListParams) obj;
        switch (fetchTransactionListParams.f14746c) {
            case ALL:
                fetchAllTransactionListQueryString = new FetchAllTransactionListQueryString();
                break;
            case INCOMING:
                fetchAllTransactionListQueryString = new FetchIncomingTransactionListQueryString();
                break;
            case OUTGOING:
                fetchAllTransactionListQueryString = new FetchOutgoingTransactionListQueryString();
                break;
            default:
                throw new IllegalArgumentException("Unknown queryType seen " + fetchTransactionListParams.f14746c);
        }
        fetchAllTransactionListQueryString.a("max_transactions", Integer.valueOf(fetchTransactionListParams.f14747d));
        return fetchAllTransactionListQueryString;
    }

    @Inject
    public FetchTransactionListMethod(PaymentTransactionQueryUtils paymentTransactionQueryUtils, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f14608c = paymentTransactionQueryUtils;
    }

    public final int m15132b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    @Nullable
    private static PaymentTransactionsModel m15129b(FetchTransactionListParams fetchTransactionListParams, JsonParser jsonParser) {
        PaymentTransactionsModel a;
        switch (fetchTransactionListParams.f14746c) {
            case ALL:
                a = ((FetchAllTransactionListQueryModel) jsonParser.a(FetchAllTransactionListQueryModel.class)).m13592a();
                break;
            case INCOMING:
                a = ((FetchIncomingTransactionListQueryModel) jsonParser.a(FetchIncomingTransactionListQueryModel.class)).m13612a();
                break;
            case OUTGOING:
                a = ((FetchOutgoingTransactionListQueryModel) jsonParser.a(FetchOutgoingTransactionListQueryModel.class)).m13632a();
                break;
            default:
                throw new IllegalArgumentException("Unknown queryType seen " + fetchTransactionListParams.f14746c);
        }
        if (a == null || a.m13867j() == null) {
            return null;
        }
        return a;
    }
}
