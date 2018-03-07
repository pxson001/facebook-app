package com.facebook.friends.protocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: matchedTokens */
public class BlacklistPeopleYouMayKnowMethod implements ApiMethod<String, Boolean> {
    public final ApiRequest m16779a(Object obj) {
        String str = (String) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("user", str));
        return new ApiRequest("blacklistPeopleYouMayKnow", "POST", "me/blacklisted_pymk_users", RequestPriority.NON_INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m16780a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
