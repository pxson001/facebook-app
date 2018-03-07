package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: first_send_delta */
public class SendPaymentMessageMethod implements ApiMethod<SendPaymentMessageParams, SendPaymentMessageResult> {
    private final ObjectMapper f14614a;

    public static SendPaymentMessageMethod m15147a(InjectorLike injectorLike) {
        return new SendPaymentMessageMethod((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m15148a(Object obj) {
        SendPaymentMessageParams sendPaymentMessageParams = (SendPaymentMessageParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("offline_threading_id", sendPaymentMessageParams.f14767i));
        a.add(new BasicNameValuePair("amount", sendPaymentMessageParams.f14760b));
        a.add(new BasicNameValuePair("currency", sendPaymentMessageParams.f14761c));
        a.add(new BasicNameValuePair("sender_credential", sendPaymentMessageParams.f14762d));
        a.add(new BasicNameValuePair("memo_text", sendPaymentMessageParams.f14764f));
        a.add(new BasicNameValuePair("pin", sendPaymentMessageParams.f14765g));
        a.add(new BasicNameValuePair("theme_id", sendPaymentMessageParams.f14773o));
        a.add(new BasicNameValuePair("idempotence_token", StringFormatUtil.formatStrLocaleSafe("%s_%s", sendPaymentMessageParams.f14767i, "messenger_payments")));
        a.add(new BasicNameValuePair("group_thread_id", sendPaymentMessageParams.f14766h));
        a.add(new BasicNameValuePair("platform_context_id", sendPaymentMessageParams.f14768j));
        a.add(new BasicNameValuePair("shipping_address_id", sendPaymentMessageParams.f14770l));
        a.add(new BasicNameValuePair("shipping_option_id", sendPaymentMessageParams.f14771m));
        a.add(new BasicNameValuePair("request_id", sendPaymentMessageParams.f14772n));
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "messenger_payments";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%d/%s", Long.valueOf(Long.parseLong(sendPaymentMessageParams.f14763e)), "messenger_payments");
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public SendPaymentMessageMethod(ObjectMapper objectMapper) {
        this.f14614a = objectMapper;
    }

    public final Object m15149a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (SendPaymentMessageResult) this.f14614a.a(apiResponse.c().c(), this.f14614a._typeFactory.a(SendPaymentMessageResult.class));
    }
}
