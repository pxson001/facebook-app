package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.DeleteCommentParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: promptSessionId */
public class DeleteCommentMethod implements ApiMethod<DeleteCommentParams, Void> {
    public final ApiRequest m10323a(Object obj) {
        DeleteCommentParams deleteCommentParams = (DeleteCommentParams) obj;
        List a = Lists.a();
        if (deleteCommentParams.c != null) {
            a.add(new BasicNameValuePair("tracking", deleteCommentParams.c));
            a.add(new BasicNameValuePair("format", "json"));
        }
        return new ApiRequest("graphCommentDelete", "DELETE", deleteCommentParams.a, a, ApiResponseType.JSON);
    }

    public final Object m10324a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
