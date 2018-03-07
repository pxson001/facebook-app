package com.facebook.common.pagesprotocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: invitee_id */
public class BlacklistPageReviewSuggestionMethod implements ApiMethod<String, Boolean> {
    public static BlacklistPageReviewSuggestionMethod m12611a(InjectorLike injectorLike) {
        return new BlacklistPageReviewSuggestionMethod();
    }

    public final ApiRequest m12612a(Object obj) {
        String str = (String) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("surface", "NATIVE_NETEGO"));
        a.add(new BasicNameValuePair("mechanism", "XOUT_BUTTON"));
        return new ApiRequest("blackListPageReview", "POST", str + "/rating_suggestion_blacklist", a, ApiResponseType.JSON);
    }

    public final Object m12613a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}
