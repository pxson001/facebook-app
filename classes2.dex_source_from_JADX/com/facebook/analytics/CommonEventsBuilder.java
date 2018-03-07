package com.facebook.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_webdialogs_save_manifest */
public class CommonEventsBuilder {
    public final Lazy<QeAccessor> f9552a;

    public static CommonEventsBuilder m14539b(InjectorLike injectorLike) {
        return new CommonEventsBuilder(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3219));
    }

    @Inject
    public CommonEventsBuilder(Lazy<QeAccessor> lazy) {
        this.f9552a = lazy;
    }

    public static HoneyClientEvent m14537a(String str, String str2, String str3, String str4) {
        if (Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str2) || Strings.isNullOrEmpty(str3) || str4 == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent(str).m5090b("legacy_api_post_id", str2).m5090b("does_viewer_like", str3);
        b.f3099c = str4;
        return b;
    }

    public static CommonEventsBuilder m14535a(InjectorLike injectorLike) {
        return m14539b(injectorLike);
    }

    public static HoneyClientEvent m14540b(String str, String str2, String str3, String str4) {
        if (Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str2) || Strings.isNullOrEmpty(str3) || str4 == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent(str).m5090b("legacy_api_post_id", str2).m5090b("is_viewer_subscribed", str3);
        b.f3099c = str4;
        return b;
    }

    public static HoneyClientEvent m14536a(String str, String str2, String str3) {
        if (Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str2) || str3 == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent(str).m5090b("legacy_api_post_id", str2);
        b.f3099c = str3;
        return b;
    }

    public final HoneyClientEvent m14542a(String str, boolean z, JsonNode jsonNode, String str2, int i) {
        if (jsonNode == null || jsonNode.mo712e() == 0 || Strings.isNullOrEmpty(str)) {
            return null;
        }
        return m14541a(str, z, jsonNode, str2).m5083a("item_index", i);
    }

    public final HoneyClientEvent m14544a(String str, boolean z, JsonNode jsonNode, String str2, @Nullable Map<String, ?> map) {
        HoneyClientEvent a = m14541a(str, z, jsonNode, str2);
        if (map != null) {
            a.m5088a((Map) map);
        }
        return a;
    }

    public final HoneyClientEvent m14541a(String str, boolean z, JsonNode jsonNode, String str2) {
        if (jsonNode == null || jsonNode.mo712e() == 0 || str == null) {
            return null;
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("open_link");
        honeyClientEvent.f3100d = "url";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3101e = str;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3099c = str2;
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (((QeAccessor) this.f9552a.get()).mo596a(ExperimentsForAnalyticsClientModule.c, false)) {
            honeyClientEvent2.f3107k = true;
        }
        return honeyClientEvent2.m5085a("tracking", jsonNode).mo699b(z);
    }

    public final HoneyClientEvent m14543a(String str, boolean z, JsonNode jsonNode, String str2, @Nullable String str3, @Nullable String str4) {
        return m14538a(str, z, jsonNode, str2, str3, true, str4);
    }

    public final HoneyClientEvent m14545b(String str, boolean z, JsonNode jsonNode, String str2, @Nullable String str3, @Nullable String str4) {
        return m14538a(str, z, jsonNode, str2, str3, false, str4);
    }

    private static HoneyClientEvent m14538a(String str, boolean z, JsonNode jsonNode, String str2, @Nullable String str3, boolean z2, @Nullable String str4) {
        if (jsonNode == null || jsonNode.mo712e() == 0 || str == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("open_link").m5085a("tracking", jsonNode).mo699b(z);
        b.f3100d = "url";
        b = b;
        b.f3101e = str;
        b = b;
        b.f3099c = str2;
        b = b;
        if (str4 != null) {
            b.m5090b("instant_article_id", str4);
        }
        if (!z2) {
            return b;
        }
        if (str3 != null) {
            b.m5090b(str3, "1");
            return b;
        }
        b.m5090b("cta_click", "1");
        return b;
    }
}
