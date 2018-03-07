package com.facebook.adspayments.protocol;

import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.utils.AdsPaymentsPreconditions;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.PaymentsNetworkOperation;
import com.google.common.base.Predicates;
import javax.inject.Inject;

/* compiled from: USE_PASSWORD */
public class GetAccountDetailsMethod extends PaymentsNetworkOperation<PaymentsFlowContext, GetAccountDetailsResult> {
    public static GetAccountDetailsMethod m25712b(InjectorLike injectorLike) {
        return new GetAccountDetailsMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    public final ApiRequest m25713a(Object obj) {
        String str = (String) AdsPaymentsPreconditions.m25752a((Object) ((PaymentsFlowContext) obj).f3969d, Predicates.not(Predicates.equalTo("0")));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/act_%s", str);
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.b = "get_account_details";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "GET";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    @Inject
    public GetAccountDetailsMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, GetAccountDetailsResult.class);
    }

    protected final String m25714a() {
        return "get_account_details";
    }
}
