package com.facebook.messaging.payment.protocol.shipping;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchShippingAddressQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.MailingAddressInfo;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchShippingAddressQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.MailingAddressInfoModel;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: folder='%1$s' AND archived=0 */
public class FetchShippingAddressesMethod extends AbstractPersistedGraphQlApiMethod<Void, ArrayList<MailingAddressInfo>> {
    private static volatile FetchShippingAddressesMethod f14594d;
    private final Provider<String> f14595c;

    public static com.facebook.messaging.payment.protocol.shipping.FetchShippingAddressesMethod m15087a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14594d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.shipping.FetchShippingAddressesMethod.class;
        monitor-enter(r1);
        r0 = f14594d;	 Catch:{ all -> 0x003a }
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
        r0 = m15088b(r0);	 Catch:{ all -> 0x0035 }
        f14594d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14594d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.shipping.FetchShippingAddressesMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.shipping.FetchShippingAddressesMethod");
    }

    private static FetchShippingAddressesMethod m15088b(InjectorLike injectorLike) {
        return new FetchShippingAddressesMethod(GraphQLProtocolHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4443));
    }

    @Inject
    public FetchShippingAddressesMethod(GraphQLProtocolHelper graphQLProtocolHelper, Provider<String> provider) {
        super(graphQLProtocolHelper);
        this.f14595c = provider;
    }

    public final Object m15089a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ArrayList arrayList = new ArrayList();
        ImmutableList a = ((FetchShippingAddressQueryModel) jsonParser.a(FetchShippingAddressQueryModel.class)).m13662a().m13658a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((MailingAddressInfoModel) a.get(i));
        }
        return arrayList;
    }

    public final int m15090b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final GraphQlQueryString m15091f(Object obj) {
        return new FetchShippingAddressQueryString().a("user_id", (String) this.f14595c.get());
    }
}
