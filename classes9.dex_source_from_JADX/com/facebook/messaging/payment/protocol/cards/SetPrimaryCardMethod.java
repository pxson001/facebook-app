package com.facebook.messaging.payment.protocol.cards;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.cards.SetPrimaryCardParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: for_thread_list */
public class SetPrimaryCardMethod implements ApiMethod<SetPrimaryCardParams, Boolean> {
    private static final Class<?> f14584a = SetPrimaryCardMethod.class;

    public static SetPrimaryCardMethod m15030a(InjectorLike injectorLike) {
        return new SetPrimaryCardMethod();
    }

    public final ApiRequest m15031a(Object obj) {
        SetPrimaryCardParams setPrimaryCardParams = (SetPrimaryCardParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("preset_credential_id", String.valueOf(setPrimaryCardParams.f14654b)));
        if (setPrimaryCardParams.f14656d != null) {
            a.add(new BasicNameValuePair("transfer_id", setPrimaryCardParams.f14656d));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "p2p_credit_cards";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%d/p2p_settings", Long.valueOf(Long.parseLong(setPrimaryCardParams.f14655c)));
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m15032a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
