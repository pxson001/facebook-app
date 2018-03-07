package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.AttributionVisibilityBuilder;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: dbl_nux_dismiss_forward */
public class AppAttributionDeserializer {
    public static AppAttributionDeserializer m16858a(InjectorLike injectorLike) {
        return new AppAttributionDeserializer();
    }

    public static ContentAppAttribution m16859b(@Nullable String str, JsonNode jsonNode) {
        String b = JSONUtil.b(jsonNode.b("id"));
        String b2 = JSONUtil.b(jsonNode.b("name"));
        String b3 = JSONUtil.b(jsonNode.b("android_package_name"));
        String b4 = JSONUtil.b(jsonNode.b("metadata"));
        Builder builder = ImmutableMap.builder();
        if (jsonNode.d("other_user_app_scoped_ids")) {
            Iterator H = jsonNode.b("other_user_app_scoped_ids").H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                builder.b(entry.getKey(), ((JsonNode) entry.getValue()).s());
            }
        }
        AttributionVisibility attributionVisibility = AttributionVisibility.b;
        if (jsonNode.d("visibility")) {
            JsonNode c = jsonNode.c("visibility");
            boolean a = JSONUtil.a(c.b("hide_attribution"), true);
            boolean a2 = JSONUtil.a(c.b("hide_install_button"), true);
            boolean a3 = JSONUtil.a(c.b("hide_reply_button"), true);
            boolean a4 = JSONUtil.a(c.b("hide_install_button"), true);
            AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
            newBuilder.a = a;
            AttributionVisibilityBuilder attributionVisibilityBuilder = newBuilder;
            attributionVisibilityBuilder.c = a2;
            attributionVisibilityBuilder = attributionVisibilityBuilder;
            attributionVisibilityBuilder.d = a3;
            attributionVisibilityBuilder = attributionVisibilityBuilder;
            attributionVisibilityBuilder.e = a4;
            attributionVisibility = attributionVisibilityBuilder.h();
        }
        ContentAppAttributionBuilder newBuilder2 = ContentAppAttribution.newBuilder();
        newBuilder2.a = str;
        newBuilder2 = newBuilder2;
        newBuilder2.b = b;
        ContentAppAttributionBuilder contentAppAttributionBuilder = newBuilder2;
        contentAppAttributionBuilder.c = b2;
        contentAppAttributionBuilder = contentAppAttributionBuilder;
        contentAppAttributionBuilder.e = b3;
        contentAppAttributionBuilder = contentAppAttributionBuilder;
        contentAppAttributionBuilder.f = b4;
        contentAppAttributionBuilder = contentAppAttributionBuilder.a(builder.b());
        contentAppAttributionBuilder.h = attributionVisibility;
        return contentAppAttributionBuilder.i();
    }
}
