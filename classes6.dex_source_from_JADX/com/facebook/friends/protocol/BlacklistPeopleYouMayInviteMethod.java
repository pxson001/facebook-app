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

/* compiled from: matched_length */
public class BlacklistPeopleYouMayInviteMethod implements ApiMethod<String, Boolean> {
    private final String f10670a;

    public final ApiRequest m16777a(Object obj) {
        String str = (String) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("contact_id", str));
        arrayList.add(new BasicNameValuePair("id", this.f10670a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "blacklistPeopleYouMayInvite";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/blacklisted_pymi_contacts";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.NON_INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    @Inject
    public BlacklistPeopleYouMayInviteMethod(Provider<String> provider) {
        this.f10670a = (String) provider.get();
    }

    public final Object m16778a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
