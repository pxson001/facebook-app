package com.facebook.contacts.protocol.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.contacts.server.FetchMessagingFavoritesResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: rtc_jni_audio */
public class FetchMessagingFavoritesMethod implements ApiMethod<Void, FetchMessagingFavoritesResult> {
    public static FetchMessagingFavoritesMethod m3461a(InjectorLike injectorLike) {
        return new FetchMessagingFavoritesMethod();
    }

    public final ApiRequest m3462a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("query", "SELECT favorite_id, ordering FROM messaging_favorite WHERE uid=me() ORDER BY ordering ASC"));
        return new ApiRequest("fetchMessagingFavorites", TigonRequest.GET, "method/fql.query", a, ApiResponseType.JSON);
    }

    public final Object m3463a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        ArrayNode arrayNode = (ArrayNode) apiResponse.c();
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < arrayNode.e(); i++) {
            JsonNode a = arrayNode.a(i);
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.a(Type.FACEBOOK, JSONUtil.b(a.b("favorite_id")));
            builder.c(userBuilder.aa());
        }
        return new FetchMessagingFavoritesResult(DataFreshnessResult.FROM_SERVER, builder.b(), System.currentTimeMillis());
    }
}
