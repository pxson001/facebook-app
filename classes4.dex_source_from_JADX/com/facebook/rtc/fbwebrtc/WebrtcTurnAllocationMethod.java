package com.facebook.rtc.fbwebrtc;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sender_webrtc_application_layer */
public class WebrtcTurnAllocationMethod implements ApiMethod<WebrtcTurnAllocationParams, String> {
    public static WebrtcTurnAllocationMethod m2923a(InjectorLike injectorLike) {
        return new WebrtcTurnAllocationMethod();
    }

    public final ApiRequest m2924a(Object obj) {
        WebrtcTurnAllocationParams webrtcTurnAllocationParams = (WebrtcTurnAllocationParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("access_token", webrtcTurnAllocationParams.a));
        arrayList.add(new BasicNameValuePair("user_name", webrtcTurnAllocationParams.b));
        arrayList.add(new BasicNameValuePair("pwd", webrtcTurnAllocationParams.c));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "webrtcTurnAllocationFetch";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = TigonRequest.GET;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "method/voicechat.discoverturn";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m2925a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.b();
    }
}
