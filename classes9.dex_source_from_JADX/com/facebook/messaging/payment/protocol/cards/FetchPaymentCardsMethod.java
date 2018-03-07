package com.facebook.messaging.payment.protocol.cards;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.model.P2pCreditCardWrapper;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.service.model.cards.FetchPaymentCardsResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: force_show_legal_screen */
public class FetchPaymentCardsMethod implements ApiMethod<Void, FetchPaymentCardsResult> {
    public static final String f14580a = StringFormatUtil.formatStrLocaleSafe("id, mobile_csc_verified, zip_verified, web_csc_verified, method_category, commerce_payment_eligible, personal_transfer_eligible, is_default_receiving, %s", "credit_card { credential_id, number, first_name, last_name, expire_month, expire_year, association, address { postal_code }}");
    private static final Class<?> f14581c = FetchPaymentCardsMethod.class;
    private static volatile FetchPaymentCardsMethod f14582d;
    @VisibleForTesting
    String f14583b;

    /* compiled from: force_show_legal_screen */
    class C16641 extends TypeReference<ImmutableList<P2pCreditCardWrapper>> {
        final /* synthetic */ FetchPaymentCardsMethod f14579b;

        C16641(FetchPaymentCardsMethod fetchPaymentCardsMethod) {
            this.f14579b = fetchPaymentCardsMethod;
        }
    }

    public static com.facebook.messaging.payment.protocol.cards.FetchPaymentCardsMethod m15026a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14582d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.cards.FetchPaymentCardsMethod.class;
        monitor-enter(r1);
        r0 = f14582d;	 Catch:{ all -> 0x0039 }
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
        r0 = m15027b();	 Catch:{ all -> 0x0034 }
        f14582d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14582d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.cards.FetchPaymentCardsMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.cards.FetchPaymentCardsMethod");
    }

    private static FetchPaymentCardsMethod m15027b() {
        return new FetchPaymentCardsMethod();
    }

    public final ApiRequest m15028a(Object obj) {
        List a = Lists.a();
        this.f14583b = StringFormatUtil.formatStrLocaleSafe("viewer() { peer_to_peer_payments { peer_to_peer_payment_methods { %s } } }", f14580a);
        a.add(new BasicNameValuePair("q", this.f14583b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "fetchPaymentCards";
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

    public final Object m15029a(Object obj, ApiResponse apiResponse) {
        JsonParser d = apiResponse.d();
        while (d.g() != JsonToken.START_ARRAY) {
            d.c();
        }
        ImmutableList immutableList = (ImmutableList) d.a(new C16641(this));
        Builder builder = new Builder();
        PaymentCard paymentCard = null;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            PaymentCard paymentCard2;
            PaymentCard paymentCard3 = new PaymentCard((P2pCreditCardWrapper) immutableList.get(i));
            builder.c(paymentCard3);
            if (paymentCard3.mo525l()) {
                paymentCard2 = paymentCard3;
            } else {
                paymentCard2 = paymentCard;
            }
            i++;
            paymentCard = paymentCard2;
        }
        return new FetchPaymentCardsResult(paymentCard, builder.b());
    }
}
