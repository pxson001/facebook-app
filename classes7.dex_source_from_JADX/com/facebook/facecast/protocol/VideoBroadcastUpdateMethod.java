package com.facebook.facecast.protocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.facecast.model.FacecastCompositionData;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: away_voting_page */
public class VideoBroadcastUpdateMethod implements ApiMethod<VideoBroadcastUpdateRequest, Void> {
    public final ApiRequest m22405a(Object obj) {
        String str;
        VideoBroadcastUpdateRequest videoBroadcastUpdateRequest = (VideoBroadcastUpdateRequest) obj;
        Preconditions.checkNotNull(videoBroadcastUpdateRequest.f18804b);
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("description", videoBroadcastUpdateRequest.f18804b.f18152a));
        String str2 = "privacy";
        FacecastCompositionData facecastCompositionData = videoBroadcastUpdateRequest.f18804b;
        if (facecastCompositionData.f18153b == null || facecastCompositionData.f18153b.d == null) {
            str = null;
        } else {
            str = facecastCompositionData.f18153b.d.c();
        }
        builder.c(new BasicNameValuePair(str2, str));
        builder.c(new BasicNameValuePair("place", videoBroadcastUpdateRequest.f18804b.f18155d));
        builder.c(new BasicNameValuePair("og_action_type_id", videoBroadcastUpdateRequest.f18804b.f18156e));
        builder.c(new BasicNameValuePair("og_object_id", videoBroadcastUpdateRequest.f18804b.f18157f));
        builder.c(new BasicNameValuePair("og_phrase", videoBroadcastUpdateRequest.f18804b.f18159h));
        builder.c(new BasicNameValuePair("og_icon_id", videoBroadcastUpdateRequest.f18804b.f18158g));
        builder.c(new BasicNameValuePair("tags", "[" + Joiner.on(',').skipNulls().join(Sets.b(videoBroadcastUpdateRequest.f18804b.f18160i)) + "]"));
        str2 = "feed_topics";
        Set<String> b = Sets.b(videoBroadcastUpdateRequest.f18804b.f18161j);
        if (b == null || b.isEmpty()) {
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str3 : b) {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("[").append(str3);
                } else {
                    stringBuilder.append(",").append(str3);
                }
            }
            stringBuilder.append("]");
            str3 = stringBuilder.toString();
        }
        builder.c(new BasicNameValuePair(str2, str3));
        builder.c(new BasicNameValuePair("is_eligible_for_commercial_break", Boolean.toString(videoBroadcastUpdateRequest.f18804b.f18163l)));
        if (videoBroadcastUpdateRequest.f18804b.f18164m) {
            builder.c(new BasicNameValuePair("post_surfaces_blacklist", JSONUtil.b(ImmutableList.of("2")).toString()));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "video_broadcast_update";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = videoBroadcastUpdateRequest.f18803a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        return newBuilder.C();
    }

    public final Object m22406a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
