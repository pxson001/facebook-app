package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.transactions.MutatePaymentPlatformContextParams;
import com.facebook.user.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: flowName */
public class MutatePaymentPlatformContextMethod implements ApiMethod<MutatePaymentPlatformContextParams, Boolean> {
    private final Provider<User> f14611a;

    public static MutatePaymentPlatformContextMethod m15138a(InjectorLike injectorLike) {
        return new MutatePaymentPlatformContextMethod(IdBasedProvider.a(injectorLike, 3596));
    }

    public final ApiRequest m15139a(Object obj) {
        MutatePaymentPlatformContextParams mutatePaymentPlatformContextParams = (MutatePaymentPlatformContextParams) obj;
        if (this.f14611a.get() == null) {
            throw new IllegalStateException("Logged in user found to be null.");
        }
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("platform_context_id", mutatePaymentPlatformContextParams.f14752b));
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/%s", ((User) this.f14611a.get()).a, mutatePaymentPlatformContextParams.f14751a.mutation);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "mutate_payment_platform_context";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = arrayList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public MutatePaymentPlatformContextMethod(Provider<User> provider) {
        this.f14611a = provider;
    }

    public final Object m15140a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
