package com.facebook.messaging.payment.protocol.pay;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.cards.ManualTransferMethod;
import com.facebook.messaging.payment.service.model.cards.NetBankingMethod;
import com.facebook.messaging.payment.service.model.pay.SendPaymentParams;
import com.facebook.messaging.payment.service.model.pay.SendPaymentResult;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: folder_counts */
public class SendPaymentMethod implements ApiMethod<SendPaymentParams, SendPaymentResult> {
    public static SendPaymentMethod m15060a(InjectorLike injectorLike) {
        return new SendPaymentMethod();
    }

    public final ApiRequest m15061a(Object obj) {
        Object obj2;
        SendPaymentParams sendPaymentParams = (SendPaymentParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("payment_type", sendPaymentParams.f14674a.getValue()));
        arrayList.add(new BasicNameValuePair("receiver_id", sendPaymentParams.f14679f));
        arrayList.add(new BasicNameValuePair("amount", sendPaymentParams.f14675b));
        arrayList.add(new BasicNameValuePair("currency", sendPaymentParams.f14676c));
        Object obj3 = sendPaymentParams.f14677d;
        if (StringUtil.a(obj3) || StringUtil.a(obj3, "0")) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            arrayList.add(new BasicNameValuePair("credential_id", sendPaymentParams.f14677d));
        }
        arrayList.add(new BasicNameValuePair("action", sendPaymentParams.f14678e));
        arrayList.add(new BasicNameValuePair("csc", sendPaymentParams.f14680g));
        arrayList.add(new BasicNameValuePair("mailing_address_id", sendPaymentParams.f14682i));
        arrayList.add(new BasicNameValuePair("shipping_option_id", sendPaymentParams.f14683j));
        arrayList.add(new BasicNameValuePair("order_id", sendPaymentParams.f14685l));
        PaymentMethodType b = sendPaymentParams.f14684k.b();
        JSONObject put = new JSONObject().put("type", b.getValue());
        if (b.equals(PaymentMethodType.NET_BANKING)) {
            put.put("data", new JSONObject().put("bank_code", ((NetBankingMethod) sendPaymentParams.f14684k).f14642a));
        } else if (b.equals(PaymentMethodType.MANUAL_TRANSFER)) {
            ManualTransferMethod manualTransferMethod = (ManualTransferMethod) sendPaymentParams.f14684k;
            put.put("data", new JSONObject().put("transfer_option_id", manualTransferMethod.m15159a()).put("receipt_image_id", manualTransferMethod.f14638b));
        }
        arrayList.add(new BasicNameValuePair("nmor_payment_method", put.toString()));
        arrayList.add(new BasicNameValuePair("format", "json"));
        if (sendPaymentParams.f14686m != null) {
            arrayList.add(new BasicNameValuePair("extra_data", sendPaymentParams.f14686m.toString()));
        }
        arrayList.add(new BasicNameValuePair("request_id", sendPaymentParams.f14687n));
        ApiRequestBuilder a = PaymentsTokenProxyApiRequestBuilder.a("/me/payments", new Object[0]);
        a.b = "send_payment";
        a = a;
        a.c = "POST";
        a = a;
        a.g = arrayList;
        a = a;
        a.k = ApiResponseType.JSONPARSER;
        return a.C();
    }

    public final Object m15062a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (SendPaymentResult) apiResponse.d().a(SendPaymentResult.class);
    }
}
