package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.messaging.business.commerce.model.retail.CommerceDataSerialization;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.share.ShareBuilder;
import com.facebook.messaging.model.share.ShareMedia;
import com.facebook.messaging.model.share.ShareMedia.Type;
import com.facebook.messaging.model.share.ShareMediaBuilder;
import com.facebook.messaging.model.share.ShareProperty;
import com.facebook.messaging.model.share.SharePropertyBuilder;
import com.facebook.messaging.momentsinvite.model.MomentsInviteDataSerialization;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotextMessage;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: credential_id */
public class ShareDeserializer {
    private final ObjectMapper f16985a;
    private final CommerceDataSerialization f16986b;
    private final MomentsInviteDataSerialization f16987c;

    @Inject
    public ShareDeserializer(ObjectMapper objectMapper, CommerceDataSerialization commerceDataSerialization, MomentsInviteDataSerialization momentsInviteDataSerialization) {
        this.f16985a = objectMapper;
        this.f16986b = commerceDataSerialization;
        this.f16987c = momentsInviteDataSerialization;
    }

    public final ImmutableList<Share> m17061a(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator j = jsonNode.j();
        while (j.hasNext()) {
            String str = (String) j.next();
            builder.c(m17058a(str, jsonNode.b(str)));
        }
        return builder.b();
    }

    private Share m17058a(String str, JsonNode jsonNode) {
        ShareBuilder shareBuilder = new ShareBuilder();
        shareBuilder.b(JSONUtil.b(jsonNode.b("name")));
        shareBuilder.c(JSONUtil.b(jsonNode.b("caption")));
        shareBuilder.d(JSONUtil.b(jsonNode.b("description")));
        shareBuilder.e(JSONUtil.b(jsonNode.b("href")));
        if (jsonNode.d("media")) {
            shareBuilder.a(m17060c(jsonNode.b("media")));
        }
        if (jsonNode.d("properties")) {
            shareBuilder.b(m17059b(jsonNode.b("properties")));
        }
        if (jsonNode.d("robotext")) {
            JsonParser c = jsonNode.c();
            c.a(this.f16985a);
            try {
                shareBuilder.a((OpenGraphActionRobotextMessage) c.a(OpenGraphActionRobotextMessage.class));
            } catch (IOException e) {
            }
        }
        if (jsonNode.d("attribution")) {
            shareBuilder.f(JSONUtil.b(jsonNode.b("attribution")));
        }
        if (jsonNode.d("deep_link_url")) {
            shareBuilder.g(JSONUtil.b(jsonNode.b("deep_link_url")));
        }
        if (this.f16986b.a(jsonNode)) {
            shareBuilder.a(this.f16986b.b(jsonNode));
        }
        if (this.f16987c.a(jsonNode)) {
            shareBuilder.a(this.f16987c.a(str, jsonNode));
        }
        return shareBuilder.n();
    }

    private static List<ShareProperty> m17059b(JsonNode jsonNode) {
        List<ShareProperty> arrayList = new ArrayList();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            if (jsonNode2.d("name") && jsonNode2.d("text")) {
                SharePropertyBuilder sharePropertyBuilder = new SharePropertyBuilder();
                sharePropertyBuilder.a = JSONUtil.b(jsonNode2.b("name"));
                sharePropertyBuilder.b = JSONUtil.b(jsonNode2.b("text"));
                sharePropertyBuilder.c = JSONUtil.b(jsonNode2.b("href"));
                arrayList.add(sharePropertyBuilder.d());
            }
        }
        return arrayList;
    }

    private ImmutableList<ShareMedia> m17060c(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            ShareMediaBuilder shareMediaBuilder = new ShareMediaBuilder();
            shareMediaBuilder.b = JSONUtil.b(jsonNode2.b("href"));
            shareMediaBuilder.a = Type.fromString(JSONUtil.b(jsonNode2.b("type")));
            shareMediaBuilder.c = JSONUtil.b(jsonNode2.b("src"));
            if (jsonNode2.d("video")) {
                shareMediaBuilder.d = JSONUtil.b(jsonNode2.b("video").b("source_url"));
            }
            builder.c(shareMediaBuilder.e());
        }
        return builder.b();
    }
}
