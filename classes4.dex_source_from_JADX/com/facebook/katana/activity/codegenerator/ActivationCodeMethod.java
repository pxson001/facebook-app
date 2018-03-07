package com.facebook.katana.activity.codegenerator;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sms_confirmation_reader_pointer */
public class ActivationCodeMethod implements ApiMethod<ActivationCodeParams, FetchCodeResult> {
    public final ApiRequest m2217a(Object obj) {
        ActivationCodeParams activationCodeParams = (ActivationCodeParams) obj;
        List arrayList = new ArrayList();
        Preconditions.checkNotNull(arrayList);
        Preconditions.checkNotNull(Long.valueOf(activationCodeParams.a));
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("client_time", activationCodeParams.b));
        arrayList.add(new BasicNameValuePair("nonce", activationCodeParams.c));
        return new ApiRequest("activateCodeGeneratorWithCode", TigonRequest.POST, StringFormatUtil.a("/%d/totpkeys", new Object[]{Long.valueOf(activationCodeParams.a)}), arrayList, ApiResponseType.JSON);
    }

    public final Object m2218a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("key"));
        return new FetchCodeResult(CodeGeneratorValidator.m2399b(b), JSONUtil.b(c.b("time_offset")));
    }
}
