package com.facebook.facecastdisplay.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: sticker_comment_posted */
public class LiveVideoInviteFriendsMethod implements ApiMethod<LiveVideoInviteFriendsParams, Void> {
    public final ApiRequest m4044a(Object obj) {
        LiveVideoInviteFriendsParams liveVideoInviteFriendsParams = (LiveVideoInviteFriendsParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        String str = "recipient_ids";
        JSONArray jSONArray = new JSONArray();
        int size = liveVideoInviteFriendsParams.f3276b.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put((String) liveVideoInviteFriendsParams.f3276b.get(i));
        }
        arrayList.add(new BasicNameValuePair(str, jSONArray.toString()));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "live_video_subscriptions";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = liveVideoInviteFriendsParams.f3275a + "/invite_notifications";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m4045a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
