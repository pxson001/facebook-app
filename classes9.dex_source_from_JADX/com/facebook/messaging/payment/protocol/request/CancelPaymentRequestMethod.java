package com.facebook.messaging.payment.protocol.request;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.request.CancelPaymentRequestParams;
import com.facebook.user.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: folderName */
public class CancelPaymentRequestMethod implements ApiMethod<CancelPaymentRequestParams, Boolean> {
    private final Provider<User> f14591a;

    public static CancelPaymentRequestMethod m15063a(InjectorLike injectorLike) {
        return new CancelPaymentRequestMethod(IdBasedProvider.a(injectorLike, 3596));
    }

    public final ApiRequest m15064a(Object obj) {
        CancelPaymentRequestParams cancelPaymentRequestParams = (CancelPaymentRequestParams) obj;
        if (this.f14591a.get() == null) {
            throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("null ViewerContextUser found when canceling payment request id %s", cancelPaymentRequestParams.f14705b));
        }
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("request_id", cancelPaymentRequestParams.f14705b));
        arrayList.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "cancel_payment_request";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%s/p2p_canceled_payment_requests", ((User) this.f14591a.get()).a);
        newBuilder = apiRequestBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public CancelPaymentRequestMethod(Provider<User> provider) {
        this.f14591a = provider;
    }

    public final Object m15065a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
