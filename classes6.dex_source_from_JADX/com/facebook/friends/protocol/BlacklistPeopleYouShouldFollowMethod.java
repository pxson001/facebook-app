package com.facebook.friends.protocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: matchedPosition */
public class BlacklistPeopleYouShouldFollowMethod implements ApiMethod<String, Boolean> {
    private final String f10671a;

    public final ApiRequest m16781a(Object obj) {
        String str = (String) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("user_id", str));
        arrayList.add(new BasicNameValuePair("id", this.f10671a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "blacklistPeopleYouShouldFollow";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/blacklisted_pysf_users";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.NON_INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    @Inject
    public BlacklistPeopleYouShouldFollowMethod(Provider<String> provider) {
        this.f10671a = (String) provider.get();
    }

    public final Object m16782a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
