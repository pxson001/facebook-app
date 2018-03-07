package com.facebook.rtcpresence;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: session_cookies */
public class RtcPresenceMethod implements ApiMethod<RtcPresenceParams, RtcPresenceResult> {
    RtcPresenceDecoder f2544a;

    public final ApiRequest m2828a(Object obj) {
        String str;
        RtcPresenceParams rtcPresenceParams = (RtcPresenceParams) obj;
        List arrayList = new ArrayList();
        String str2 = "ids";
        if (rtcPresenceParams.a.isEmpty()) {
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (UserKey b : rtcPresenceParams.a) {
                stringBuilder.append(b.b()).append(",");
            }
            str = stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        arrayList.add(new BasicNameValuePair(str2, str));
        arrayList.add(new BasicNameValuePair("fields", "voip_info"));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "rtcPresenceFetch";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.c = TigonRequest.GET;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    @Inject
    public RtcPresenceMethod(RtcPresenceDecoder rtcPresenceDecoder) {
        this.f2544a = rtcPresenceDecoder;
    }

    public final Object m2829a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        Iterator H = apiResponse.c().H();
        RtcPresenceResult rtcPresenceResult = new RtcPresenceResult();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            rtcPresenceResult.a(UserKey.b((String) entry.getKey()), this.f2544a.m2832a((JsonNode) entry.getValue()));
        }
        return rtcPresenceResult;
    }
}
