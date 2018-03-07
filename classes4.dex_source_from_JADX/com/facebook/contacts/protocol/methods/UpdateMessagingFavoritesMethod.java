package com.facebook.contacts.protocol.methods;

import com.facebook.contacts.server.UpdateFavoriteContactsParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.user.model.User;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: rtc_group_audio_level_android */
public class UpdateMessagingFavoritesMethod implements ApiMethod<UpdateFavoriteContactsParams, Void> {
    public static UpdateMessagingFavoritesMethod m3465a(InjectorLike injectorLike) {
        return new UpdateMessagingFavoritesMethod();
    }

    public final ApiRequest m3466a(Object obj) {
        UpdateFavoriteContactsParams updateFavoriteContactsParams = (UpdateFavoriteContactsParams) obj;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        ImmutableList immutableList = updateFavoriteContactsParams.a;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = i2 + 1;
            objectNode.a(Integer.toString(i2), ((User) immutableList.get(i)).a);
            i++;
            i2 = i3;
        }
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("favorites", objectNode.toString()));
        return new ApiRequest("updateMessagingFavorites", TigonRequest.POST, "/me/messagingfavorites", a, ApiResponseType.JSON);
    }

    public final Object m3467a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
