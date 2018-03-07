package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.PostGameScoreParams;
import com.facebook.messaging.service.model.PostGameScoreResult;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: current_photo_url */
public class PostGameScoreMethod implements ApiMethod<PostGameScoreParams, PostGameScoreResult> {
    public final ApiRequest m17002a(Object obj) {
        String str;
        PostGameScoreParams postGameScoreParams = (PostGameScoreParams) obj;
        String str2 = "%s/game_scores";
        if (postGameScoreParams.f17257b == null) {
            str = postGameScoreParams.f17258c;
        } else {
            str = String.valueOf(postGameScoreParams.f17257b.i());
        }
        str2 = StringFormatUtil.formatStrLocaleSafe(str2, MessagingIdUtil.m17834a(str));
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("game_type", postGameScoreParams.f17259d));
        arrayList.add(new BasicNameValuePair("score", String.valueOf(postGameScoreParams.f17260e)));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "postGameScore";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = str2;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m17003a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return new PostGameScoreResult(apiResponse.c().b("success").a(false));
    }
}
