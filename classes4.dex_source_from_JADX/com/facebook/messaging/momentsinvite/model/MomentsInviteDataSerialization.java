package com.facebook.messaging.momentsinvite.model;

import com.facebook.common.util.JSONUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: long */
public class MomentsInviteDataSerialization {
    public final Provider<Boolean> f8836a;

    public static MomentsInviteDataSerialization m9175b(InjectorLike injectorLike) {
        return new MomentsInviteDataSerialization(IdBasedProvider.a(injectorLike, 4170));
    }

    @Inject
    public MomentsInviteDataSerialization(Provider<Boolean> provider) {
        this.f8836a = provider;
    }

    public final boolean m9178a(@Nullable JsonNode jsonNode) {
        return ((Boolean) this.f8836a.get()).booleanValue() && jsonNode != null && jsonNode.i() && jsonNode.d("fb_object_type") && Objects.equal(jsonNode.b("fb_object_type").B(), "shoerack_invitation") && jsonNode.d("fb_object_contents") && jsonNode.b("fb_object_contents").i();
    }

    @Nullable
    public final MomentsInviteData m9176a(String str, @Nullable JsonNode jsonNode) {
        if (!m9178a(jsonNode)) {
            return null;
        }
        String b;
        List a = Lists.a();
        if (jsonNode.d("media")) {
            Iterator it = jsonNode.b("media").iterator();
            while (it.hasNext()) {
                JsonNode jsonNode2 = (JsonNode) it.next();
                if (jsonNode2.d("src")) {
                    b = JSONUtil.b(jsonNode2.b("src"));
                    if (!Strings.isNullOrEmpty(b)) {
                        a.add(b);
                        break;
                    }
                }
            }
        }
        JsonNode b2 = jsonNode.b("fb_object_contents");
        if (b2 != null && b2.d("additional_srcs")) {
            Iterator it2 = b2.b("additional_srcs").iterator();
            while (it2.hasNext()) {
                b = JSONUtil.b((JsonNode) it2.next());
                if (!Strings.isNullOrEmpty(b)) {
                    a.add(b);
                }
            }
        }
        if (a.isEmpty()) {
            return null;
        }
        MomentsInviteDataBuilder newBuilder = MomentsInviteDataBuilder.newBuilder();
        newBuilder.a(a);
        if (b2 != null && b2.d("folder_photo_count")) {
            newBuilder.b = JSONUtil.d(b2.b("folder_photo_count"));
        }
        newBuilder.d = str;
        return newBuilder.e();
    }

    @Nullable
    public final JsonNode m9177a(@Nullable MomentsInviteData momentsInviteData) {
        if (!((Boolean) this.f8836a.get()).booleanValue() || momentsInviteData == null) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        ImmutableList immutableList = momentsInviteData.a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayNode.h((String) immutableList.get(i));
        }
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.c("image_srcs", arrayNode);
        objectNode.a("photo_count", momentsInviteData.b);
        if (momentsInviteData.c != null) {
            objectNode.a("share_xma_token", momentsInviteData.c);
        }
        if (momentsInviteData.d == null) {
            return objectNode;
        }
        objectNode.a("share_id", momentsInviteData.d);
        return objectNode;
    }
}
