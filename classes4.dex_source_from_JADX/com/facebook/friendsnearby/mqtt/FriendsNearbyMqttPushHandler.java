package com.facebook.friendsnearby.mqtt;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.ImmutableLocation.Builder;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetchTopContactsByCfphatParams */
public class FriendsNearbyMqttPushHandler implements MqttPushHandler {
    public static final String f11675a = (FriendsNearbyMqttPushHandler.class.getCanonicalName() + ".ACTION_RECEIVE_FRIENDS_LOCATION");
    private static final Class<?> f11676b = FriendsNearbyMqttPushHandler.class;
    private final ObjectMapper f11677c;
    private final BaseFbBroadcastManager f11678d;

    @Inject
    public FriendsNearbyMqttPushHandler(ObjectMapper objectMapper, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f11677c = objectMapper;
        this.f11678d = baseFbBroadcastManager;
    }

    public void onMessage(String str, byte[] bArr) {
        try {
            if ("/friends_locations".equals(str)) {
                JsonNode a = this.f11677c.a(StringUtil.a(bArr));
                m12222a(m12223b(a), m12221a(a), JSONUtil.b(a.b("nearby_context")), JSONUtil.b(a.b("meta_context")));
            }
        } catch (IOException e) {
        }
    }

    private static UserKey m12221a(JsonNode jsonNode) {
        return UserKey.b(JSONUtil.b(jsonNode.b("id")));
    }

    private static ImmutableLocation m12223b(JsonNode jsonNode) {
        float f = JSONUtil.f(jsonNode.b("lat"));
        float f2 = JSONUtil.f(jsonNode.b("lon"));
        float f3 = JSONUtil.f(jsonNode.b("acc"));
        long c = JSONUtil.c(jsonNode.b("ts"));
        Builder a = ImmutableLocation.a((double) f, (double) f2);
        if (f3 >= 0.0f) {
            a.b(f3);
        }
        if (c > 0) {
            a.c(1000 * c);
        }
        return a.a();
    }

    private void m12222a(@Nullable ImmutableLocation immutableLocation, @Nullable UserKey userKey, @Nullable String str, @Nullable String str2) {
        Intent intent = new Intent(f11675a);
        if (userKey != null) {
            intent.putExtra("user_id", userKey);
        }
        if (immutableLocation != null) {
            intent.putExtra("user_location", immutableLocation);
        }
        if (str != null) {
            intent.putExtra("user_nearby_context", str);
        }
        if (str2 != null) {
            intent.putExtra("user_meta_context", str2);
        }
        if (intent.getExtras().size() > 0) {
            this.f11678d.a(intent);
        }
    }
}
