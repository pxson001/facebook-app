package com.facebook.groups.service.protocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: video_resolution */
public class BlacklistGroupsYouShouldJoinMethod implements ApiMethod<String, Boolean> {
    public final ApiRequest m588a(Object obj) {
        String str = (String) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("group_id", str));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "blacklistGroupsYouShouldJoin";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/blacklisted_gysj_groups";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.NON_INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    public final Object m589a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
