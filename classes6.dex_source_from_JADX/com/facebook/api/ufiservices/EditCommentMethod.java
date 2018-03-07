package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.EditCommentParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: promptId */
public class EditCommentMethod implements ApiMethod<EditCommentParams, Void> {
    public final ApiRequest m10325a(Object obj) {
        EditCommentParams editCommentParams = (EditCommentParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("message", editCommentParams.c));
        if (editCommentParams.d != null) {
            a.add(new BasicNameValuePair("attachment_id", editCommentParams.d));
        }
        return new ApiRequest("editComment", "POST", editCommentParams.b, a, ApiResponseType.JSON);
    }

    public final Object m10326a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
