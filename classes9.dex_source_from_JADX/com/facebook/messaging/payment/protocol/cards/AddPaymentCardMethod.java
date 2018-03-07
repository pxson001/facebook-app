package com.facebook.messaging.payment.protocol.cards;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.cards.AddPaymentCardParams;
import com.facebook.messaging.payment.service.model.cards.AddPaymentCardResult;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: formatted_high_fare */
public class AddPaymentCardMethod implements ApiMethod<AddPaymentCardParams, AddPaymentCardResult> {
    private static final Class<?> f14576a = AddPaymentCardMethod.class;

    public static AddPaymentCardMethod m15016a(InjectorLike injectorLike) {
        return new AddPaymentCardMethod();
    }

    public final ApiRequest m15017a(Object obj) {
        AddPaymentCardParams addPaymentCardParams = (AddPaymentCardParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("creditCardNumber", addPaymentCardParams.f14617a));
        a.add(new BasicNameValuePair("month", String.valueOf(addPaymentCardParams.f14618b)));
        a.add(new BasicNameValuePair("year", String.valueOf(addPaymentCardParams.f14619c)));
        a.add(new BasicNameValuePair("csc", addPaymentCardParams.f14620d));
        a.add(new BasicNameValuePair("zip", addPaymentCardParams.f14621e));
        a.add(new BasicNameValuePair("product_type", addPaymentCardParams.f14623g));
        if (!StringUtil.a(addPaymentCardParams.f14624h)) {
            a.add(new BasicNameValuePair("product_id", addPaymentCardParams.f14624h));
        }
        ApiRequestBuilder a2 = PaymentsTokenProxyApiRequestBuilder.a("/%d/p2p_credit_cards", new Object[]{Long.valueOf(Long.parseLong(addPaymentCardParams.f14622f))});
        a2.b = "p2p_credit_cards";
        a2 = a2;
        a2.c = "POST";
        a2 = a2;
        a2.g = a;
        ApiRequestBuilder apiRequestBuilder = a2;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m15018a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (AddPaymentCardResult) apiResponse.d().a(AddPaymentCardResult.class);
    }
}
