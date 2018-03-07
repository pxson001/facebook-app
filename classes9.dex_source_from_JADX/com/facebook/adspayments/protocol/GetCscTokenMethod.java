package com.facebook.adspayments.protocol;

import com.facebook.common.util.ParcelablePair;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Inject;

/* compiled from: USER_LOCATION */
public class GetCscTokenMethod extends UnrestrictedResultPaymentsNetworkOperation<ParcelablePair<CreditCard, String>, String> {
    public static GetCscTokenMethod m25723b(InjectorLike injectorLike) {
        return new GetCscTokenMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    public final ApiRequest m25724a(Object obj) {
        ApiRequestBuilder a = PaymentsTokenProxyApiRequestBuilder.a("/%s/csc_tokens", new Object[]{((CreditCard) ((ParcelablePair) obj).first).a()});
        a.b = m25726a();
        a = a;
        a.c = "POST";
        a = a.a(ImmutableBiMap.b("csc", r5.second));
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    @Inject
    public GetCscTokenMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, String.class);
    }

    public final Object m25725a(Object obj, ApiResponse apiResponse) {
        return UnrestrictedResultPaymentsNetworkOperation.a(apiResponse, "cached_csc_token");
    }

    protected final String m25726a() {
        return "get_csc_token";
    }
}
