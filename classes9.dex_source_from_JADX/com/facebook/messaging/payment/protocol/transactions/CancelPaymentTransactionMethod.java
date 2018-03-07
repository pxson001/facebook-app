package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.transactions.CancelPaymentTransactionParams;
import com.facebook.user.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fn */
public class CancelPaymentTransactionMethod implements ApiMethod<CancelPaymentTransactionParams, Boolean> {
    private final Provider<User> f14598a;

    public static CancelPaymentTransactionMethod m15101a(InjectorLike injectorLike) {
        return new CancelPaymentTransactionMethod(IdBasedProvider.a(injectorLike, 3596));
    }

    public final ApiRequest m15102a(Object obj) {
        CancelPaymentTransactionParams cancelPaymentTransactionParams = (CancelPaymentTransactionParams) obj;
        if (this.f14598a.get() == null) {
            throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("null ViewerContextUser found when canceling payment transaction id %s", cancelPaymentTransactionParams.f14733b));
        }
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("transfer_id", cancelPaymentTransactionParams.f14733b));
        arrayList.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "cancel_payment_transaction";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%s/p2p_canceled_transfers", ((User) this.f14598a.get()).a);
        newBuilder = apiRequestBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public CancelPaymentTransactionMethod(Provider<User> provider) {
        this.f14598a = provider;
    }

    public final Object m15103a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
