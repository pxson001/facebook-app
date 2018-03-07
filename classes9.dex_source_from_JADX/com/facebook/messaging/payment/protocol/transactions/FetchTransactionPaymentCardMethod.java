package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.model.P2pCreditCard;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentCardBuilder;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionPaymentCardParams;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: flow_context_id */
public class FetchTransactionPaymentCardMethod implements ApiMethod<FetchTransactionPaymentCardParams, PaymentCard> {
    private static volatile FetchTransactionPaymentCardMethod f14609b;
    @VisibleForTesting
    String f14610a;

    public static com.facebook.messaging.payment.protocol.transactions.FetchTransactionPaymentCardMethod m15135a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f14609b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.transactions.FetchTransactionPaymentCardMethod.class;
        monitor-enter(r1);
        r0 = f14609b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m15134a();	 Catch:{ all -> 0x0034 }
        f14609b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14609b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.transactions.FetchTransactionPaymentCardMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.transactions.FetchTransactionPaymentCardMethod");
    }

    private static FetchTransactionPaymentCardMethod m15134a() {
        return new FetchTransactionPaymentCardMethod();
    }

    public final ApiRequest m15136a(Object obj) {
        this.f14610a = StringFormatUtil.formatStrLocaleSafe("node(%s) { payment_method { credential_id, number, first_name, last_name, expire_month, expire_year, association, address { postal_code } } }", ((FetchTransactionPaymentCardParams) obj).f14750a);
        List a = Lists.a();
        a.add(new BasicNameValuePair("q", this.f14610a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "fetchTransactionPaymentCard";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "graphql";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    @Nullable
    public final Object m15137a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonParser d = apiResponse.d();
        d.c();
        while (d.h() && d.i() != "payment_method") {
            d.c();
        }
        if (d.h()) {
            d.c();
            P2pCreditCard p2pCreditCard = (P2pCreditCard) d.a(P2pCreditCard.class);
            if (p2pCreditCard != null) {
                PaymentCardBuilder newBuilder = PaymentCard.newBuilder();
                newBuilder.f13219e = p2pCreditCard.m13484f();
                newBuilder = newBuilder;
                newBuilder.f13220f = p2pCreditCard.m13485g();
                newBuilder = newBuilder;
                newBuilder.f13215a = p2pCreditCard.m13480b();
                newBuilder = newBuilder;
                newBuilder.f13217c = p2pCreditCard.m13482d();
                newBuilder = newBuilder;
                newBuilder.f13218d = p2pCreditCard.m13482d();
                newBuilder = newBuilder;
                newBuilder.f13216b = p2pCreditCard.m13481c();
                return new PaymentCard(newBuilder);
            }
        }
        return null;
    }
}
