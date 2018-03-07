package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.ToggleLikeParams;
import com.facebook.common.util.StringUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: promoScreenTitle */
public class ToggleLikeMethod implements ApiMethod<ToggleLikeParams, Boolean> {
    public final ApiRequest m10350a(Object obj) {
        ToggleLikeParams toggleLikeParams = (ToggleLikeParams) obj;
        List a = Lists.a();
        if (toggleLikeParams.d != null) {
            JsonNode jsonNode = toggleLikeParams.d.a;
            if (jsonNode != null && jsonNode.e() > 0) {
                a.add(new BasicNameValuePair("tracking", jsonNode.toString()));
            }
            String str = toggleLikeParams.d.b;
            if (!StringUtil.a(str)) {
                a.add(new BasicNameValuePair("nectar_module", str));
            }
            str = toggleLikeParams.d.c;
            if (!StringUtil.a(str)) {
                a.add(new BasicNameValuePair("feedback_source", str));
            }
            if ("native_newsfeed".toString().equals(str)) {
                Preconditions.checkArgument(jsonNode != null, "Likes from news feed must include tracking codes");
            }
        }
        if (!StringUtil.a(toggleLikeParams.f)) {
            a.add(new BasicNameValuePair("fan_origin", toggleLikeParams.f));
        }
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("graphObjectLike", toggleLikeParams.b ? "POST" : "DELETE", toggleLikeParams.a + "/likes", RequestPriority.NON_INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m10351a(Object obj, ApiResponse apiResponse) {
        ToggleLikeParams toggleLikeParams = (ToggleLikeParams) obj;
        apiResponse.i();
        return Boolean.valueOf(toggleLikeParams.b);
    }
}
