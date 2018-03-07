package com.facebook.common.pagesprotocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: invited_users */
public class DeletePageReviewMethod implements ApiMethod<DeletePageReviewParams, Boolean> {
    public final ApiRequest m12614a(Object obj) {
        DeletePageReviewParams deletePageReviewParams = (DeletePageReviewParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(deletePageReviewParams.f10685c);
        Preconditions.checkNotNull(deletePageReviewParams.f10684b);
        a.add(new BasicNameValuePair("mechanism", deletePageReviewParams.f10684b.toString()));
        a.add(new BasicNameValuePair("surface", deletePageReviewParams.f10685c.toString()));
        return new ApiRequest("deletePageReview", "DELETE", deletePageReviewParams.f10683a + "/open_graph_ratings", a, ApiResponseType.JSON);
    }

    public final Object m12615a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}
