package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.model.retail.CommerceDataSerialization;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.share.ShareBuilder;
import com.facebook.messaging.model.share.ShareMedia;
import com.facebook.messaging.model.share.ShareMedia.Type;
import com.facebook.messaging.model.share.ShareMediaBuilder;
import com.facebook.messaging.model.share.ShareProperty;
import com.facebook.messaging.model.share.SharePropertyBuilder;
import com.facebook.messaging.momentsinvite.model.MomentsInviteData;
import com.facebook.messaging.momentsinvite.model.MomentsInviteDataBuilder;
import com.facebook.messaging.momentsinvite.model.MomentsInviteDataSerialization;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext.Span;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: looking_at_sync_tab */
public class DbShareSerialization {
    private final ObjectMapperWithUncheckedException f8833a;
    private final CommerceDataSerialization f8834b;
    private final MomentsInviteDataSerialization f8835c;

    public static DbShareSerialization m9156b(InjectorLike injectorLike) {
        return new DbShareSerialization(ObjectMapperWithUncheckedException.a(injectorLike), CommerceDataSerialization.m9161a(injectorLike), MomentsInviteDataSerialization.m9175b(injectorLike));
    }

    @Inject
    public DbShareSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException, CommerceDataSerialization commerceDataSerialization, MomentsInviteDataSerialization momentsInviteDataSerialization) {
        this.f8833a = objectMapperWithUncheckedException;
        this.f8834b = commerceDataSerialization;
        this.f8835c = momentsInviteDataSerialization;
    }

    public final ObjectNode m9159a(@Nullable Share share) {
        if (share == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("name", share.c);
        objectNode.a("caption", share.d);
        objectNode.a("description", share.e);
        objectNode.a("href", share.f);
        String str = "media";
        ImmutableList<ShareMedia> immutableList = share.g;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (ShareMedia shareMedia : immutableList) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("type", shareMedia.a.toString());
            objectNode2.a("src", shareMedia.c);
            objectNode2.a("href", shareMedia.b);
            if (Type.VIDEO.equals(shareMedia.a) && shareMedia.d != null) {
                objectNode2.a("playable_src", shareMedia.d);
            }
            arrayNode.a(objectNode2);
        }
        objectNode.c(str, arrayNode);
        objectNode.c("properties", m9154a(share.h));
        objectNode.c("robotext", m9155a(share.i));
        objectNode.a("attribution", share.j);
        objectNode.a("deep_link_url", share.k);
        objectNode.c("commerce_data", CommerceDataSerialization.m9163a(share.l));
        objectNode.c("moments_invite_data", this.f8835c.m9177a(share.m));
        return objectNode;
    }

    private ArrayNode m9154a(Collection<ShareProperty> collection) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (ShareProperty shareProperty : collection) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("name", shareProperty.a);
            objectNode.a("text", shareProperty.b);
            objectNode.a("href", shareProperty.c);
            arrayNode.a(objectNode);
        }
        return arrayNode;
    }

    private ObjectNode m9155a(OpenGraphActionRobotext openGraphActionRobotext) {
        if (openGraphActionRobotext == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("robotext", openGraphActionRobotext.a);
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Span span : openGraphActionRobotext.b) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("start", span.mOffset);
            objectNode2.a("end", span.b());
            arrayNode.a(objectNode2);
        }
        objectNode.c("spans", arrayNode);
        return objectNode;
    }

    public final Share m9158a(JsonNode jsonNode) {
        MomentsInviteData e;
        ShareBuilder shareBuilder = new ShareBuilder();
        shareBuilder.a = JSONUtil.b(jsonNode.b("fbid"));
        shareBuilder.c = JSONUtil.b(jsonNode.b("name"));
        shareBuilder.d = JSONUtil.b(jsonNode.b("caption"));
        shareBuilder.e = JSONUtil.b(jsonNode.b("description"));
        JsonNode b = jsonNode.b("media");
        Builder builder = ImmutableList.builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            ShareMediaBuilder shareMediaBuilder = new ShareMediaBuilder();
            shareMediaBuilder.b = JSONUtil.b(jsonNode2.b("href"));
            shareMediaBuilder.a = Type.fromString(JSONUtil.b(jsonNode2.b("type")));
            shareMediaBuilder.c = JSONUtil.b(jsonNode2.b("src"));
            if (jsonNode2.d("playable_src")) {
                shareMediaBuilder.d = JSONUtil.b(jsonNode2.b("playable_src"));
            } else if (jsonNode2.d("video")) {
                shareMediaBuilder.d = JSONUtil.b(jsonNode2.b("video").b("source_url"));
            }
            builder.c(shareMediaBuilder.e());
        }
        shareBuilder.g = builder.b();
        shareBuilder.f = JSONUtil.b(jsonNode.b("href"));
        b = jsonNode.b("properties");
        List a = Lists.a();
        for (int i = 0; i < b.e(); i++) {
            JsonNode a2 = b.a(i);
            if (a2.d("name") && a2.d("text")) {
                SharePropertyBuilder sharePropertyBuilder = new SharePropertyBuilder();
                sharePropertyBuilder.a = JSONUtil.b(a2.b("name"));
                sharePropertyBuilder.b = JSONUtil.b(a2.b("text"));
                sharePropertyBuilder.c = JSONUtil.b(a2.b("href"));
                a.add(sharePropertyBuilder.d());
            }
        }
        shareBuilder.h = a;
        shareBuilder.i = m9157e(jsonNode.b("robotext"));
        shareBuilder.j = JSONUtil.b(jsonNode.b("attribution"));
        shareBuilder.k = JSONUtil.b(jsonNode.b("deep_link_url"));
        shareBuilder.l = this.f8834b.m9174b(jsonNode.b("commerce_data"));
        MomentsInviteDataSerialization momentsInviteDataSerialization = this.f8835c;
        JsonNode b2 = jsonNode.b("moments_invite_data");
        if (((Boolean) momentsInviteDataSerialization.f8836a.get()).booleanValue() && b2 != null && b2.i()) {
            a = Lists.a();
            if (b2.d("image_srcs")) {
                it = b2.b("image_srcs").iterator();
                while (it.hasNext()) {
                    String b3 = JSONUtil.b((JsonNode) it.next());
                    if (!Strings.isNullOrEmpty(b3)) {
                        a.add(b3);
                    }
                }
            }
            MomentsInviteDataBuilder newBuilder = MomentsInviteDataBuilder.newBuilder();
            newBuilder.a(a);
            if (b2.d("photo_count")) {
                newBuilder.b = JSONUtil.d(b2.b("photo_count"));
            }
            if (b2.d("share_xma_token")) {
                newBuilder.c = JSONUtil.b(b2.b("share_xma_token"));
            }
            if (b2.d("share_id")) {
                newBuilder.d = JSONUtil.b(b2.b("share_id"));
            }
            e = newBuilder.e();
        } else {
            e = null;
        }
        shareBuilder.m = e;
        return shareBuilder.n();
    }

    private OpenGraphActionRobotext m9157e(JsonNode jsonNode) {
        if (jsonNode == null || (jsonNode instanceof NullNode)) {
            return null;
        }
        String b = JSONUtil.b(jsonNode.b("robotext"));
        List a = Lists.a();
        JsonNode b2 = jsonNode.b("spans");
        for (int i = 0; i < b2.e(); i++) {
            JsonNode a2 = b2.a(i);
            int d = JSONUtil.d(a2.b("start"));
            a.add(new Span(d, JSONUtil.d(a2.b("end")) - d));
        }
        return new OpenGraphActionRobotext(b, a);
    }
}
