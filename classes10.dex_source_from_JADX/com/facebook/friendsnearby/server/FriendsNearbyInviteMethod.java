package com.facebook.friendsnearby.server;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: [FB Only] Please select a city using the "EDIT CITY" button */
public class FriendsNearbyInviteMethod implements ApiMethod<FriendsNearbyInviteParams, Boolean> {
    public final ApiRequest m21163a(Object obj) {
        FriendsNearbyInviteParams friendsNearbyInviteParams = (FriendsNearbyInviteParams) obj;
        List a = Lists.a();
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/info_requests", friendsNearbyInviteParams.f20675a);
        a.add(new BasicNameValuePair("field_types", m21162a(friendsNearbyInviteParams.f20677c)));
        a.add(new BasicNameValuePair("additional_recipients", m21162a(friendsNearbyInviteParams.f20676b)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "FRIENDS_NEARBY_INVITE";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.C();
    }

    private static String m21162a(List<String> list) {
        ArrayNode b = JsonNodeFactory.a.b();
        for (String str : list) {
            JsonNodeFactory jsonNodeFactory = JsonNodeFactory.a;
            b.a(TextNode.h(str));
        }
        return b.toString();
    }

    public final Object m21164a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(Boolean.parseBoolean(apiResponse.b()));
    }
}
