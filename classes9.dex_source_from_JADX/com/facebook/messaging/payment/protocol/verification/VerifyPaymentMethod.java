package com.facebook.messaging.payment.protocol.verification;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentParams;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentResult;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: first_message_first_send_delta */
public class VerifyPaymentMethod implements ApiMethod<VerifyPaymentParams, VerifyPaymentResult> {
    private final FbObjectMapper f14616a;

    public static VerifyPaymentMethod m15154a(InjectorLike injectorLike) {
        return new VerifyPaymentMethod(FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m15155a(Object obj) {
        ApiRequestBuilder a;
        VerifyPaymentParams verifyPaymentParams = (VerifyPaymentParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("transfer_id", String.valueOf(verifyPaymentParams.f14790b)));
        if (verifyPaymentParams.f14791c != null) {
            arrayList.add(new BasicNameValuePair("submitted_screen", verifyPaymentParams.f14791c));
        }
        if (verifyPaymentParams.f14792d != null) {
            arrayList.add(new BasicNameValuePair("user_input", this.f14616a.a(verifyPaymentParams.f14792d)));
        }
        if (verifyPaymentParams.f14793e != null) {
            arrayList.add(new BasicNameValuePair("csc", verifyPaymentParams.f14793e));
        }
        if (verifyPaymentParams.f14793e != null) {
            a = PaymentsTokenProxyApiRequestBuilder.a("/%d/p2p_verification_flows", new Object[]{Long.valueOf(Long.parseLong(verifyPaymentParams.f14794f))});
        } else {
            a = ApiRequest.newBuilder();
            a.d = StringFormatUtil.formatStrLocaleSafe("/%d/p2p_verification_flows", Long.valueOf(Long.parseLong(verifyPaymentParams.f14794f)));
            a = a;
        }
        a.b = "p2p_verification";
        a = a;
        a.c = "POST";
        a = a;
        a.g = arrayList;
        a = a;
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    @Inject
    public VerifyPaymentMethod(FbObjectMapper fbObjectMapper) {
        this.f14616a = fbObjectMapper;
    }

    public final Object m15156a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (VerifyPaymentResult) this.f14616a.a(apiResponse.c().c(), this.f14616a._typeFactory.a(VerifyPaymentResult.class));
    }
}
