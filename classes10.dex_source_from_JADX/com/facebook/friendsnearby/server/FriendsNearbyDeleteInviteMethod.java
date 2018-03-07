package com.facebook.friendsnearby.server;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: [TK; */
public class FriendsNearbyDeleteInviteMethod implements ApiMethod<FriendsNearbyDeleteInviteParams, Void> {
    public final ApiRequest m21160a(Object obj) {
        FriendsNearbyDeleteInviteParams friendsNearbyDeleteInviteParams = (FriendsNearbyDeleteInviteParams) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/info_requests", friendsNearbyDeleteInviteParams.f20673a);
        List a = Lists.a();
        String str = "field_types";
        ImmutableList<String> immutableList = friendsNearbyDeleteInviteParams.f20674b;
        ArrayNode b = JsonNodeFactory.a.b();
        for (String h : immutableList) {
            b.h(h);
        }
        a.add(new BasicNameValuePair(str, b.toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "FRIENDS_NEARBY_DELETE_INVITE";
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m21161a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
