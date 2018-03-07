package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.AttributionVisibilityBuilder;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.facebook.share.model.ComposerAppAttribution;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mStoredProcedureMutex */
public class DbAppAttributionSerialization {
    private final ObjectMapperWithUncheckedException f15388a;

    public static DbAppAttributionSerialization m21932b(InjectorLike injectorLike) {
        return new DbAppAttributionSerialization(ObjectMapperWithUncheckedException.m21860a(injectorLike));
    }

    @Inject
    public DbAppAttributionSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f15388a = objectMapperWithUncheckedException;
    }

    public static String m21931a(@Nullable ComposerAppAttribution composerAppAttribution) {
        if (composerAppAttribution == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("app_id", composerAppAttribution.a());
        if (!StringUtil.m3589a(composerAppAttribution.b())) {
            objectNode.m5137a("app_name", composerAppAttribution.b());
        }
        objectNode.m5137a("app_key_hash", composerAppAttribution.c());
        return objectNode.toString();
    }

    public static DbAppAttributionSerialization m21929a(InjectorLike injectorLike) {
        return m21932b(injectorLike);
    }

    public static String m21930a(ContentAppAttribution contentAppAttribution) {
        if (contentAppAttribution == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("attachment_fbid", contentAppAttribution.a);
        objectNode.m5137a("app_id", contentAppAttribution.b);
        if (!StringUtil.m3589a(contentAppAttribution.c)) {
            objectNode.m5137a("app_name", contentAppAttribution.c);
        }
        if (!StringUtil.m3589a(contentAppAttribution.d)) {
            objectNode.m5137a("app_key_hash", contentAppAttribution.d);
        }
        if (!StringUtil.m3589a(contentAppAttribution.e)) {
            objectNode.m5137a("app_package", contentAppAttribution.e);
        }
        if (!StringUtil.m3589a(contentAppAttribution.f)) {
            objectNode.m5137a("metadata", contentAppAttribution.f);
        }
        objectNode.m5143c("app_scoped_user_ids", JSONUtil.m13452a(contentAppAttribution.g));
        ObjectNode k = objectNode.m5151k("visibility");
        k.m5138a("hideAttribution", contentAppAttribution.h.c);
        k.m5138a("hideInstallButton", contentAppAttribution.h.e);
        k.m5138a("hideReplyButton", contentAppAttribution.h.f);
        k.m5138a("hideAppIcon", contentAppAttribution.h.g);
        return objectNode.toString();
    }

    public final ComposerAppAttribution m21933a(@Nullable String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return null;
        }
        String s;
        JsonNode a = this.f15388a.m21862a(str);
        String s2 = a.mo709b("app_id").mo728s();
        if (a.mo730d("app_name")) {
            s = a.mo709b("app_name").mo728s();
        } else {
            s = null;
        }
        return new ComposerAppAttribution(s2, s, a.mo709b("app_key_hash").mo728s(), null);
    }

    public final ContentAppAttribution m21934b(String str) {
        String str2 = null;
        if (StringUtil.m3589a((CharSequence) str)) {
            return null;
        }
        String s;
        String s2;
        String s3;
        AttributionVisibility h;
        JsonNode a = this.f15388a.m21862a(str);
        String s4 = a.mo730d("attachment_fbid") ? a.mo709b("attachment_fbid").mo728s() : null;
        String s5 = a.mo709b("app_id").mo728s();
        if (a.mo730d("app_name")) {
            s = a.mo709b("app_name").mo728s();
        } else {
            s = null;
        }
        if (a.mo730d("app_key_hash")) {
            s2 = a.mo709b("app_key_hash").mo728s();
        } else {
            s2 = null;
        }
        if (a.mo730d("app_package")) {
            s3 = a.mo709b("app_package").mo728s();
        } else {
            s3 = null;
        }
        if (a.mo730d("metadata")) {
            str2 = a.mo709b("metadata").mo728s();
        }
        AttributionVisibility attributionVisibility = AttributionVisibility.b;
        if (a.mo730d("visibility")) {
            JsonNode b = a.mo709b("visibility");
            boolean F = b.mo709b("hideAttribution").mo1646F();
            boolean F2 = b.mo709b("hideInstallButton").mo1646F();
            boolean F3 = b.mo709b("hideReplyButton").mo1646F();
            boolean a2 = JSONUtil.m13456a(b.mo709b("hideAppIcon"), false);
            AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
            newBuilder.a = F;
            AttributionVisibilityBuilder attributionVisibilityBuilder = newBuilder;
            attributionVisibilityBuilder.c = F2;
            attributionVisibilityBuilder = attributionVisibilityBuilder;
            attributionVisibilityBuilder.d = F3;
            attributionVisibilityBuilder = attributionVisibilityBuilder;
            attributionVisibilityBuilder.e = a2;
            h = attributionVisibilityBuilder.h();
        } else {
            h = attributionVisibility;
        }
        Builder builder = ImmutableMap.builder();
        if (a.mo730d("app_scoped_user_ids")) {
            Iterator H = a.mo709b("app_scoped_user_ids").mo705H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                builder.m609b(entry.getKey(), ((JsonNode) entry.getValue()).mo728s());
            }
        }
        ContentAppAttributionBuilder newBuilder2 = ContentAppAttribution.newBuilder();
        newBuilder2.a = s4;
        newBuilder2 = newBuilder2;
        newBuilder2.b = s5;
        newBuilder2 = newBuilder2;
        newBuilder2.c = s;
        newBuilder2 = newBuilder2;
        newBuilder2.d = s2;
        newBuilder2 = newBuilder2;
        newBuilder2.e = s3;
        newBuilder2 = newBuilder2;
        newBuilder2.f = str2;
        newBuilder2 = newBuilder2.a(builder.m610b());
        newBuilder2.h = h;
        return newBuilder2.i();
    }
}
