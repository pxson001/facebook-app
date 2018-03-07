package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: cropHeight */
public class SetThreadNameMethod implements ApiMethod<ModifyThreadParams, Void> {
    public final ApiRequest m17048a(Object obj) {
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("tid", modifyThreadParams.m17156q()));
        a.add(new BasicNameValuePair("name", modifyThreadParams.f17224d));
        return new ApiRequest("setThreadName", "POST", "method/messaging.setthreadname", a, ApiResponseType.STRING);
    }

    public final Object m17049a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
