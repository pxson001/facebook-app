package com.facebook.messaging.payment.protocol.request;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.request.DeclinePaymentRequestParams;
import com.facebook.user.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: folder=? AND initial_fetch_complete=0 */
public class DeclinePaymentRequestMethod implements ApiMethod<DeclinePaymentRequestParams, Boolean> {
    private final Provider<User> f14592a;

    public static DeclinePaymentRequestMethod m15069a(InjectorLike injectorLike) {
        return new DeclinePaymentRequestMethod(IdBasedProvider.a(injectorLike, 3596));
    }

    public final ApiRequest m15070a(Object obj) {
        DeclinePaymentRequestParams declinePaymentRequestParams = (DeclinePaymentRequestParams) obj;
        if (this.f14592a.get() == null) {
            throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("null ViewerContextUser found when declining payment request id %s", declinePaymentRequestParams.f14715b));
        }
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("request_id", declinePaymentRequestParams.f14715b));
        arrayList.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "decline_payment_request";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%s/p2p_declined_payment_requests", ((User) this.f14592a.get()).a);
        newBuilder = apiRequestBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public DeclinePaymentRequestMethod(Provider<User> provider) {
        this.f14592a = provider;
    }

    public final Object m15071a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
