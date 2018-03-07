package com.facebook.fql;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: streaming_profile_picture */
public class FqlApiRequestHelper {
    public static ApiRequest m1879a(String str, String str2, RequestPriority requestPriority, ApiResponseType apiResponseType) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("q", str2));
        return new ApiRequest(str, TigonRequest.GET, "fql", requestPriority, a, apiResponseType);
    }
}
