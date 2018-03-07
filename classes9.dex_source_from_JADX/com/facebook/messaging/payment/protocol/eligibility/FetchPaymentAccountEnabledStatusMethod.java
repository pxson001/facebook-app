package com.facebook.messaging.payment.protocol.eligibility;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchPaymentAccountEnabledStatusQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentAccountEnabledStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchPaymentAccountEnabledStatusQueryModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: folders_timestamp_index */
public class FetchPaymentAccountEnabledStatusMethod extends AbstractPersistedGraphQlApiMethod<Void, PaymentAccountEnabledStatus> {
    private static volatile FetchPaymentAccountEnabledStatusMethod f14590c;

    public static com.facebook.messaging.payment.protocol.eligibility.FetchPaymentAccountEnabledStatusMethod m15052a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14590c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.eligibility.FetchPaymentAccountEnabledStatusMethod.class;
        monitor-enter(r1);
        r0 = f14590c;	 Catch:{ all -> 0x003a }
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
        r0 = m15053b(r0);	 Catch:{ all -> 0x0035 }
        f14590c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14590c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.eligibility.FetchPaymentAccountEnabledStatusMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.eligibility.FetchPaymentAccountEnabledStatusMethod");
    }

    private static FetchPaymentAccountEnabledStatusMethod m15053b(InjectorLike injectorLike) {
        return new FetchPaymentAccountEnabledStatusMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    @Inject
    public FetchPaymentAccountEnabledStatusMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m15054a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return ((FetchPaymentAccountEnabledStatusQueryModel) jsonParser.a(FetchPaymentAccountEnabledStatusQueryModel.class)).m13637a();
    }

    public final int m15055b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final GraphQlQueryString m15056f(Object obj) {
        return new FetchPaymentAccountEnabledStatusQueryString();
    }
}
