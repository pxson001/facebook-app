package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: cursors */
public class ParticipantInfoDeserializer {
    public static ParticipantInfoDeserializer m16987a(InjectorLike injectorLike) {
        return new ParticipantInfoDeserializer();
    }

    public final ImmutableList<ParticipantInfo> m16989a(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            builder.c(m16990b((JsonNode) it.next()));
        }
        return builder.b();
    }

    public final ParticipantInfo m16990b(JsonNode jsonNode) {
        return m16986a(jsonNode, null);
    }

    public static ParticipantInfo m16986a(JsonNode jsonNode, @Nullable ImmutableMap<String, Boolean> immutableMap) {
        UserKey userKey;
        boolean z;
        String b = JSONUtil.b(jsonNode.b("email"));
        String b2 = JSONUtil.b(jsonNode.b("phone"));
        if (jsonNode.d("user_id")) {
            String a = m16988a(JSONUtil.b(jsonNode.b("user_id")));
            if (a != null) {
                boolean booleanValue;
                UserKey userKey2 = new UserKey(Type.FACEBOOK, a);
                Boolean bool = immutableMap == null ? null : (Boolean) immutableMap.get(a);
                if (bool != null) {
                    booleanValue = bool.booleanValue();
                } else {
                    booleanValue = false;
                }
                userKey = userKey2;
                z = booleanValue;
            } else {
                z = false;
                userKey = new UserKey(Type.EMAIL, b);
            }
        } else {
            z = false;
            userKey = new UserKey(Type.FACEBOOK_OBJECT, JSONUtil.b(jsonNode.b("id")));
        }
        return new ParticipantInfo(userKey, JSONUtil.b(jsonNode.b("name")), b, b2, z);
    }

    private static String m16988a(String str) {
        return "0".equals(str) ? null : str;
    }
}
