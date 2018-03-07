package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.AddCommentParams;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: promptViewState */
public class AddCommentMethod implements ApiMethod<AddCommentParams, String> {
    public static AddCommentMethod m10318a(InjectorLike injectorLike) {
        return new AddCommentMethod();
    }

    public final ApiRequest m10319a(Object obj) {
        AddCommentParams addCommentParams = (AddCommentParams) obj;
        List a = Lists.a();
        if (!Strings.isNullOrEmpty(addCommentParams.c)) {
            a.add(new BasicNameValuePair("message", addCommentParams.c));
        }
        if (addCommentParams.f != null) {
            JsonNode jsonNode = addCommentParams.f.a;
            if (jsonNode != null && jsonNode.e() > 0) {
                a.add(new BasicNameValuePair("tracking", jsonNode.toString()));
            }
            String str = addCommentParams.f.b;
            if (!StringUtil.a(str)) {
                a.add(new BasicNameValuePair("nectar_module", str));
            }
            str = addCommentParams.f.c;
            if (!StringUtil.a(str)) {
                a.add(new BasicNameValuePair("feedback_source", str));
            }
            if ("native_newsfeed".toString().equals(str)) {
                Preconditions.checkArgument(jsonNode != null, "Comments from news feed must include tracking codes");
            }
        }
        if (addCommentParams.g != null) {
            a.add(new BasicNameValuePair("idempotence_token", addCommentParams.g));
        }
        if (addCommentParams.d != null) {
            a.add(new BasicNameValuePair("attachment_id", addCommentParams.d));
        }
        if (!(addCommentParams.i == null || addCommentParams.h == null)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threaded_comments", addCommentParams.h);
            jSONObject.put("comment_post_return_type", addCommentParams.i);
            a.add(new BasicNameValuePair("breaking_changes_override", jSONObject.toString()));
        }
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("graphObjectComments", "POST", addCommentParams.b + "/comments", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m10320a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.b(apiResponse.c().b("id"));
    }
}
