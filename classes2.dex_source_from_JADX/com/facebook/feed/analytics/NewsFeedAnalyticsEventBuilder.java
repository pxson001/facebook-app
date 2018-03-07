package com.facebook.feed.analytics;

import com.facebook.analytics.logger.ClickEventCreator;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLMEgoPageAdminPanelEvent;
import com.facebook.graphql.enums.GraphQLMEgoPageAdminPanelSource;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_succeeded */
public class NewsFeedAnalyticsEventBuilder {
    private static volatile NewsFeedAnalyticsEventBuilder f9211a;

    /* compiled from: prefetch_succeeded */
    public enum ViewportWaterfallStage {
        AFTER_ENTER_VIEWPORT(100),
        IN_VIEWPORT_FOR_MORE_THAN_VPV_DURATION(150),
        BEFORE_EXIT_VIEWPORT(200),
        BEFORE_TIME_THRESHOLD(300),
        BEFORE_DEDUP(400),
        BEFORE_VALIDATION(500),
        BEFORE_SENT_TO_QUEUE(600),
        BEFORE_SENT_TO_MARAUDER(700);
        
        private int code;

        private ViewportWaterfallStage(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder m14112a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9211a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder.class;
        monitor-enter(r1);
        r0 = f9211a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m14120c();	 Catch:{ all -> 0x0034 }
        f9211a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f9211a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder.a(com.facebook.inject.InjectorLike):com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder");
    }

    private static NewsFeedAnalyticsEventBuilder m14120c() {
        return new NewsFeedAnalyticsEventBuilder();
    }

    public static HoneyClientEvent m14093a(double d, double d2, String str, JsonNode jsonNode, Map<String, ?> map) {
        if (m14092B(jsonNode) || str == null) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent("client_long_click").m5085a("tracking", jsonNode).m5090b("URL", str).m5082a("web_view_time", d).m5088a((Map) map);
        a.f3099c = "native_newsfeed";
        a = a;
        if (d2 <= 0.0d) {
            return a;
        }
        a.m5082a("page_load_time", d2);
        return a;
    }

    public static HoneyClientEvent m14108a(String str, ArrayNode arrayNode, String str2) {
        if (arrayNode == null || arrayNode.mo712e() == 0) {
            return null;
        }
        HoneyClientEvent j = new HoneyClientEvent(str).m5085a("tracking", (JsonNode) arrayNode).m5097j(str2);
        j.f3099c = "native_newsfeed";
        return j;
    }

    public static HoneyClientEvent m14110a(String str, boolean z, JsonNode jsonNode, StoryRenderContext storyRenderContext) {
        if (m14092B(jsonNode) || str == null) {
            return null;
        }
        HoneyClientEvent j = new HoneyClientEvent("open_photo").m5085a("tracking", jsonNode).mo699b(z).m5097j(str);
        j.f3099c = storyRenderContext.analyticModule;
        return j;
    }

    public static HoneyClientEvent m14124h(JsonNode jsonNode) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent("pymk_imp").m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14126l(JsonNode jsonNode) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent("ig_pff_install").m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    @Nullable
    public static HoneyClientEvent m14103a(@Nullable JsonNode jsonNode, String str) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("pyma_imp").m5085a("tracking", jsonNode).m5090b("pyma_category", str);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14094a(int i, String str, DataFreshnessResult dataFreshnessResult) {
        HoneyClientEvent b = new HoneyClientEvent("infinite_hscroll_fetch").m5083a("inf_hscroll_fetch_offset", i).m5086a("inf_hscroll_fetch_result", (Object) dataFreshnessResult).m5090b("inf_hscroll_fetch_type", str);
        b.f3099c = "native_newsfeed";
        return b;
    }

    @Nullable
    public static HoneyClientEvent m14099a(JsonNode jsonNode, long j, String str) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("percent_feed_unit_seen").m5085a("tracking", jsonNode).m5084a("viewport_entry_ts", j).m5090b("ts_percent_in_viewport", str);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14096a(JsonNode jsonNode, long j, int i) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent("viewport_visible_duration").m5085a("tracking", jsonNode).m5084a("vpvd_time_delta", j).m5083a("scroll_index", i);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14116b(boolean z, JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("pyml_profile").m5085a("tracking", jsonNode).mo699b(z);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14111a(boolean z, JsonNode jsonNode, boolean z2) {
        if (jsonNode == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent(z2 ? "pyml_fan" : "pyml_unfan").m5085a("tracking", jsonNode).mo699b(z);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14115b(String str, JsonNode jsonNode) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent(str).m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14118c(String str, JsonNode jsonNode) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent(str).m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14119c(boolean z, JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("open_share_composer").m5085a("tracking", jsonNode).mo699b(z);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14104a(JsonNode jsonNode, boolean z) {
        HoneyClientEvent a = new HoneyClientEvent(z ? "ad_useful" : "ad_neutral").m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14122e(JsonNode jsonNode, boolean z) {
        String str;
        if (z) {
            str = "survey_unhide_feed_unit";
        } else {
            str = "survey_hide_feed_unit";
        }
        HoneyClientEvent a = new HoneyClientEvent(str).m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14097a(JsonNode jsonNode, long j, long j2, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent("page_admin_panel_profile_tap").m5085a("tracking", jsonNode).m5084a("admin_id", j).m5090b("event_name", GraphQLMEgoPageAdminPanelEvent.CLICK.name().toLowerCase()).m5084a("page_id", j2).m5087a("is_ego_show_single_page_item", z).m5090b("source", GraphQLMEgoPageAdminPanelSource.PROFILE_COVER_PHOTO.name().toLowerCase());
        b.f3099c = "page_admin_panel";
        return b;
    }

    public static HoneyClientEvent m14113b(JsonNode jsonNode, long j, long j2, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent("page_admin_panel_context_item_tap").m5085a("tracking", jsonNode).m5084a("admin_id", j).m5090b("event_name", GraphQLMEgoPageAdminPanelEvent.CLICK.name().toLowerCase()).m5084a("page_id", j2).m5087a("is_ego_show_single_page_item", z).m5090b("source", GraphQLMEgoPageAdminPanelSource.CONTEXT_ROW.name().toLowerCase());
        b.f3099c = "page_admin_panel";
        return b;
    }

    public static HoneyClientEvent m14098a(JsonNode jsonNode, long j, long j2, boolean z, String str) {
        HoneyClientEvent b = new HoneyClientEvent("page_admin_panel_aymt_tap").m5085a("tracking", jsonNode).m5084a("admin_id", j).m5090b("event_name", GraphQLMEgoPageAdminPanelEvent.CLICK.name().toLowerCase()).m5084a("page_id", j2).m5087a("is_ego_show_single_page_item", z).m5090b("source", GraphQLMEgoPageAdminPanelSource.AYMT_TIP.name().toLowerCase()).m5090b("action", str);
        b.f3099c = "page_admin_panel";
        return b;
    }

    public final HoneyClientEvent m14127a(JsonNode jsonNode, GraphQLObjectType graphQLObjectType, String str) {
        return m14100a(jsonNode, graphQLObjectType, str, 0);
    }

    public static HoneyClientEvent m14100a(JsonNode jsonNode, GraphQLObjectType graphQLObjectType, String str, int i) {
        HoneyClientEvent a = new HoneyClientEvent("ad_invalidated").m5085a("tracking", jsonNode).m5090b("unit_type", graphQLObjectType.m22299e()).m5090b("reason", str).m5083a("distance", i);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14105a(ArrayNode arrayNode) {
        HoneyClientEvent a = new HoneyClientEvent("ad_validated").m5085a("tracking", (JsonNode) arrayNode);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static HoneyClientEvent m14106a(ArrayNode arrayNode, int i, int i2, boolean z, boolean z2, @Nullable String str) {
        HoneyClientEvent b = new HoneyClientEvent("ad_swap").m5085a("tracking", (JsonNode) arrayNode).m5087a("success", z).m5087a("delayed", z2).m5083a("from_index", i).m5083a("offset", i2).m5090b("reason", str);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14123f(String str) {
        HoneyClientEvent b = new HoneyClientEvent("ad_screenshot").m5090b("client_token", str);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14109a(String str, String str2, boolean z, int i, int i2, int i3) {
        HoneyClientEvent a = new HoneyClientEvent("feed_unit_collection").m5090b("previous_state", str).m5090b("current_state", str2).m5087a("client_invalidation", z).m5083a("previous_cache_size", i).m5083a("current_cache_size", i2).m5083a("sequence", i3);
        a.f3099c = "native_newsfeed";
        return a;
    }

    public static Map<String, Object> m14117b(String str, String str2, boolean z, JsonNode jsonNode) {
        Map<String, Object> c = Maps.m838c();
        if (!(m14092B(jsonNode) || StringUtil.m3589a((CharSequence) str) || StringUtil.m3589a((CharSequence) str2))) {
            c.put("unit_type", str);
            c.put("application_link_type", str2);
            c.put("sponsored", Boolean.valueOf(z));
            c.put("tracking", jsonNode);
        }
        return c;
    }

    public static Map<String, Object> m14121d(boolean z, JsonNode jsonNode) {
        Map c = Maps.m838c();
        if (!m14092B(jsonNode)) {
            c.put("sponsored", Boolean.valueOf(z));
            c.put("tracking", jsonNode);
        }
        return c;
    }

    public static HoneyClientEvent m14101a(JsonNode jsonNode, ImpressionType impressionType, int i) {
        return new HoneyClientEvent("organic_impression").mo699b(false).m5085a("tracking", jsonNode).m5090b("io", impressionType == ImpressionType.ORIGINAL ? "1" : "0").m5090b("isv", impressionType == ImpressionType.VIEWABILITY ? "1" : "0").m5083a("scroll_index", i);
    }

    public static HoneyClientEvent m14102a(JsonNode jsonNode, ImpressionType impressionType, SponsoredImpressionPhase sponsoredImpressionPhase, boolean z, @Nullable String str, int i, boolean z2) {
        return new HoneyClientEvent("ad_phase_impression").m5085a("tracking", jsonNode).m5090b("io", impressionType == ImpressionType.ORIGINAL ? "1" : "0").m5090b("isv", impressionType == ImpressionType.VIEWABILITY ? "1" : "0").m5086a("imp_phase", (Object) sponsoredImpressionPhase).m5087a("imp_success", z).m5090b("imp_reason", str).m5083a("imp_seq", i).m5090b("imp_connection_state", z2 ? "1" : "0");
    }

    @Nullable
    public static HoneyClientEvent m14114b(@Nullable JsonNode jsonNode, @Nullable String str, String str2) {
        if (jsonNode == null) {
            return null;
        }
        Object obj;
        String str3 = "action_name";
        String str4 = "tracking";
        String str5 = "collection_id";
        if (str == null) {
            obj = "";
        } else {
            String str6 = str;
        }
        return ClickEventCreator.a("native_newsfeed", null, null, ImmutableMap.of(str3, str2, str4, jsonNode, str5, obj));
    }

    @Nullable
    public static HoneyClientEvent m14125i(@Nullable JsonNode jsonNode, @Nullable String str) {
        if (m14092B(jsonNode)) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("chained_story_hide").m5085a("tracking", jsonNode).m5090b("reason", str);
        b.f3099c = "native_newsfeed";
        return b;
    }

    public static HoneyClientEvent m14095a(int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4) {
        HoneyClientEvent a = new HoneyClientEvent("ad_distance").m5083a("distance", i).m5087a("client_invalidation", z).m5087a("first_ad", z2).m5087a("new_unit", z3).m5087a("reinserted_unit", z4);
        a.f3099c = "native_newsfeed";
        a = a;
        if (i2 >= 0) {
            a.m5083a("position", i2);
        }
        if (i3 >= 0) {
            a.m5083a("position_after_gap", i3);
        }
        if (i4 >= 0) {
            a.m5083a("gaps_above", i4);
        }
        return a;
    }

    public static HoneyClientEvent m14107a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, JsonNode jsonNode) {
        HoneyClientEvent b = new HoneyClientEvent("feed_chevron").m5090b("option_name", str).m5083a("option_pos", i).m5087a("is_secondary", z2).m5087a("self", z4).mo699b(z3);
        b.f3099c = "native_newsfeed";
        HoneyClientEvent a = b.m5085a("tracking", jsonNode);
        a.m5090b("event_type", z ? "clk" : "imp");
        return a;
    }

    public static boolean m14092B(@Nullable JsonNode jsonNode) {
        return jsonNode == null || ((jsonNode.mo715k() == JsonNodeType.STRING && jsonNode.m5205q()) || (jsonNode.mo715k() != JsonNodeType.STRING && jsonNode.mo712e() == 0));
    }
}
