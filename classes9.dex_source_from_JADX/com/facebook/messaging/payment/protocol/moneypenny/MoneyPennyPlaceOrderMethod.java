package com.facebook.messaging.payment.protocol.moneypenny;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.moneypenny.MoneyPennyPlaceOrderParams;
import com.facebook.messaging.payment.service.model.moneypenny.MoneyPennyPlaceOrderResult;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: folder_tag */
public class MoneyPennyPlaceOrderMethod implements ApiMethod<MoneyPennyPlaceOrderParams, MoneyPennyPlaceOrderResult> {
    public static MoneyPennyPlaceOrderMethod m15057a(InjectorLike injectorLike) {
        return new MoneyPennyPlaceOrderMethod();
    }

    public final ApiRequest m15058a(Object obj) {
        MoneyPennyPlaceOrderParams moneyPennyPlaceOrderParams = (MoneyPennyPlaceOrderParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("amount", moneyPennyPlaceOrderParams.f14665b));
        arrayList.add(new BasicNameValuePair("user_credential", moneyPennyPlaceOrderParams.f14666c));
        arrayList.add(new BasicNameValuePair("pin", moneyPennyPlaceOrderParams.f14667d));
        arrayList.add(new BasicNameValuePair("external_request_id", String.valueOf(moneyPennyPlaceOrderParams.f14668e)));
        arrayList.add(new BasicNameValuePair("item_id", String.valueOf(moneyPennyPlaceOrderParams.f14669f)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "money_penny_place_order";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%s/%s", moneyPennyPlaceOrderParams.f14670g, "moneypenny_payments");
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m15059a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (MoneyPennyPlaceOrderResult) apiResponse.d().a(MoneyPennyPlaceOrderResult.class);
    }
}
