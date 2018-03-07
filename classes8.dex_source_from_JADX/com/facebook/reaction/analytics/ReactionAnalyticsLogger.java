package com.facebook.reaction.analytics;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionSource;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.analytics.ReactionAnalytics.WelcomeHeaderInteractionType;
import com.facebook.reaction.common.ReactionInteractionTracker.Unit;
import com.facebook.reaction.constants.ReactionIntentConstants.EntryPoint;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: bottom_margin */
public class ReactionAnalyticsLogger {
    private static volatile ReactionAnalyticsLogger f18799b;
    public final AnalyticsLogger f18800a;

    /* compiled from: bottom_margin */
    public enum Event {
        LOCAL_SERP_CLOSE("local_serp_close"),
        LOCAL_SERP_IMPRESSION("local_serp_impression"),
        REACTION_ATTACHMENT_INVALID("reaction_attachment_invalid"),
        REACTION_ATTACHMENT_INVALIDATED("reaction_attachment_invalidated"),
        REACTION_ATTACHMENTS_CLOSED("reaction_attachments_closed"),
        REACTION_ERROR("reaction_error"),
        REACTION_FETCH("reaction_fetch"),
        REACTION_FORWARD_SCROLL("reaction_forward_scroll"),
        REACTION_HEADER_DISPLAYED("reaction_header_displayed"),
        REACTION_HEADER_INTERACTION("reaction_header_interaction"),
        REACTION_HSCROLL_COMPONENT_IMPRESSION("reaction_hscroll_component_impression"),
        REACTION_OVERLAY_CLOSED("reaction_overlay_closed"),
        REACTION_OVERLAY_CLOSED_WITH_PLACE("reaction_overlay_closed_with_place"),
        REACTION_OVERLAY_DISPLAY_ATTEMPTED("reaction_overlay_display_attempted"),
        REACTION_OVERLAY_DISPLAY_ABORTED("reaction_overlay_display_aborted"),
        REACTION_OVERLAY_DISPLAYED("reaction_overlay_displayed"),
        REACTION_OVERLAY_ERROR("reaction_overlay_error"),
        REACTION_SCROLLED_TO_BOTTOM("reaction_scrolled_to_bottom"),
        REACTION_PAGE_ERROR("reaction_page_error"),
        REACTION_PAGE_LOAD("reaction_page_load"),
        REACTION_UNIT_IMPRESSION("reaction_unit_impression"),
        REACTION_UNIT_INTERACTION("reaction_unit_interaction");
        
        public final String name;

        private Event(String str) {
            this.name = str;
        }
    }

    public static com.facebook.reaction.analytics.ReactionAnalyticsLogger m22814a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f18799b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.analytics.ReactionAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f18799b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22817b(r0);	 Catch:{ all -> 0x0035 }
        f18799b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18799b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.analytics.ReactionAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.reaction.analytics.ReactionAnalyticsLogger");
    }

    private static ReactionAnalyticsLogger m22817b(InjectorLike injectorLike) {
        return new ReactionAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReactionAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f18800a = analyticsLogger;
    }

    public final void m22831a(String str, Surface surface, String str2, String str3, int i, String str4) {
        this.f18800a.c(m22812a(Event.REACTION_UNIT_INTERACTION, str, "reaction_attachment", surface, str2).b("interacted_story_id", str3).b("interacted_story_type", str4).b("interaction_type", UnitInteractionType.INNER_SCROLL.name).a("unit_position", i));
    }

    public final void m22833a(String str, Surface surface, String str2, String str3, String str4, int i, String str5) {
        this.f18800a.c(m22812a(Event.REACTION_HSCROLL_COMPONENT_IMPRESSION, str, "reaction_attachment", surface, str2).b("unit_id", str3).b("unit_type", str4).a("hscroll_component_position", i).b("component_tracking_data", str5));
    }

    public final void m22826a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, @Nullable String str3, Iterable<String> iterable, Iterable<String> iterable2, Iterable<String> iterable3, long j, long j2, long j3, long j4, long j5) {
        HoneyClientEvent a = m22810a(Event.REACTION_OVERLAY_DISPLAYED, str, surface, str2, entryPoint, str3, (Iterable) iterable, (Iterable) iterable2, (Iterable) iterable3, j, j2, j4);
        a.a("perceivedLatency", j3);
        a.a("wait_time", j5);
        this.f18800a.c(a);
    }

    public final void m22834a(String str, Surface surface, Throwable th) {
        this.f18800a.c(m22811a(Event.REACTION_ERROR, str, "reaction_attachment", surface).b("error", "NETWORK_FAILURE").a("error_message", th));
    }

    public final void m22824a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, long j, long j2, @Nullable Long l) {
        this.f18800a.c(m22813a(str, surface, str2, entryPoint, "NETWORK_TIME_EXCEEDED", null, l).a("network_fetch_time", j).a("network_fetch_time_limit", j2));
    }

    public final void m22827a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, @Nullable String str3, Iterable<String> iterable, Iterable<String> iterable2, Iterable<String> iterable3, long j, long j2, long j3, String str4) {
        HoneyClientEvent a = m22810a(Event.REACTION_OVERLAY_DISPLAY_ABORTED, str, surface, str2, entryPoint, str3, (Iterable) iterable, (Iterable) iterable2, (Iterable) iterable3, j, j2, j3);
        a.b("error", str4);
        this.f18800a.c(a);
    }

    public final void m22825a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, @Nullable String str3, Iterable<String> iterable, long j, long j2, Iterable<String> iterable2, Iterable<String> iterable3, Iterable<UnitInteractionType> iterable4, int i) {
        m22816a(Event.REACTION_OVERLAY_CLOSED, str, surface, str2, entryPoint, null, str3, (Iterable) iterable, j, j2, (Iterable) iterable2, (Iterable) iterable3, (Iterable) iterable4, i);
    }

    public final void m22829a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, @Nullable String str3, Long l, Iterable<String> iterable, long j, long j2, Iterable<String> iterable2, Iterable<String> iterable3, Iterable<UnitInteractionType> iterable4, int i) {
        m22816a(Event.REACTION_OVERLAY_CLOSED_WITH_PLACE, str, surface, str2, entryPoint, l, str3, (Iterable) iterable, j, j2, (Iterable) iterable2, (Iterable) iterable3, (Iterable) iterable4, i);
    }

    public final void m22821a(String str, Surface surface, int i, int i2, long j, long j2, long j3, long j4, long j5) {
        this.f18800a.c(m22811a(Event.REACTION_PAGE_LOAD, str, "reaction_overlay", surface).a("page_number", i).a("num_added_units", i2).a("scroll_request_delay", j).a("scroll_spinner_delay", j2).a("network_fetch_time", j3).a("page_wait_time", j4).a("client_time", j5));
    }

    public final void m22819a(ReactionSession reactionSession, @Nullable Long l, @Nullable String str, String str2, @Nullable String str3, String str4, long j, long j2, Iterable<Unit> iterable, Iterable<String> iterable2) {
        this.f18800a.a(m22811a(Event.LOCAL_SERP_CLOSE, reactionSession.m22562f(), "serp_module", reactionSession.m22575w()).b("reaction_session_id", reactionSession.m22562f()).a("place_id", l).b("semantic", str).b("source", str2).b("search_ts_token", str3).a("total_visible_time", j2).a("total_active_time", j).b("typeahead_sid", str4).a("network_fetch_time", reactionSession.m22566k()).a("seen_unit_ids", m22818b((Iterable) iterable)).a("interacted_unit_ids", m22815a((Iterable) iterable2)));
    }

    public final void m22820a(ReactionSession reactionSession, String str, String str2, @Nullable String str3, String str4, String str5, String str6) {
        this.f18800a.a(m22811a(Event.LOCAL_SERP_IMPRESSION, reactionSession.f18658a, "local_serp", reactionSession.f18660c).b("candidate_result_sid", str4).b("query", str).b("reaction_session_id", reactionSession.f18658a).b("results_vertical", str6).b("source", str2).b("search_ts_token", str3).b("typeahead_sid", str5));
    }

    public final void m22828a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, String str3, @Nullable Long l) {
        this.f18800a.c(m22813a(str, surface, str2, entryPoint, str3, null, l));
    }

    public final void m22822a(String str, Surface surface, @Nullable Bundle bundle, @Nullable String str2, String str3, String str4, int i, String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable UnitInteractionSource unitInteractionSource, UnitInteractionType unitInteractionType, @Nullable String str9) {
        HoneyClientEvent a = m22812a(Event.REACTION_UNIT_INTERACTION, str, "reaction_overlay", surface, str3).b("source", str2).b("interacted_story_id", str4).b("interacted_story_type", str5).b("destination_entity_id", str8).b("interaction_type", unitInteractionType.name).a("unit_position", i);
        if (!StringUtil.a(str6)) {
            a.b("component_tracking_data", str6);
        }
        if (!StringUtil.a(str7)) {
            a.b("source_entity_id", str7);
        }
        if (!StringUtil.a(str9)) {
            a.b("event_suggestion_token", str9);
        }
        if (unitInteractionSource != null) {
            a.b("interaction_source", unitInteractionSource.name);
        }
        if (!(bundle == null || bundle.isEmpty())) {
            for (String str10 : bundle.keySet()) {
                a.b(str10, bundle.getString(str10));
            }
        }
        this.f18800a.c(a);
    }

    public final void m22830a(String str, Surface surface, String str2, String str3, int i, int i2, int i3, int i4, long j, @Nullable String str4, @Nullable String str5) {
        HoneyClientEvent b = m22812a(Event.REACTION_UNIT_IMPRESSION, str, "reaction_units", surface, str4).b("source", str5).a("unit_count", i).b("unit_id", str2).a("unit_position", i2).a("vpvd_time_delta", j).b("unit_type", str3);
        if (i3 > 0 && i4 > 0) {
            b.a("attachments_loaded", i3);
            b.a("attachments_visible", i4);
        }
        this.f18800a.c(b);
    }

    public final void m22832a(String str, Surface surface, String str2, String str3, long j, String str4, String str5, UnitInteractionType unitInteractionType) {
        this.f18800a.c(m22812a(Event.REACTION_ATTACHMENTS_CLOSED, str, "reaction_attachment", surface, str2).b("valid_story_types", str3).a("total_visible_time", j).b("interacted_story_ids", str4).b("interacted_story_types", str5).a("interaction_types", unitInteractionType).a("num_interactions", 1).b("closed_reason", "user_dismiss"));
    }

    public final void m22823a(String str, Surface surface, String str2, WelcomeHeaderInteractionType welcomeHeaderInteractionType, @Nullable String str3) {
        this.f18800a.c(m22811a(Event.REACTION_HEADER_INTERACTION, str, "reaction_overlay", surface).b("context_row_type", str3).b("place_id", str2).b("interaction_type", welcomeHeaderInteractionType.name));
    }

    private void m22816a(Event event, String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, @Nullable Long l, @Nullable String str3, Iterable<String> iterable, long j, long j2, Iterable<String> iterable2, Iterable<String> iterable3, Iterable<UnitInteractionType> iterable4, int i) {
        this.f18800a.c(m22811a(event, str, "reaction_overlay", surface).a("place_id", l).b("source", str3).a("valid_story_types", m22815a((Iterable) iterable)).a("total_active_time", j).a("total_visible_time", j2).a("interacted_story_ids", m22815a((Iterable) iterable2)).a("interacted_story_types", m22815a((Iterable) iterable3)).a("interaction_types", m22815a((Iterable) iterable4)).a("num_interactions", i).b("closed_reason", "user_dismiss").b("entry_point", EntryPoint.getMarauderValue(entryPoint)).b("gravity_suggestifier_id", str2));
    }

    private HoneyClientEvent m22810a(Event event, String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, @Nullable String str3, Iterable<String> iterable, Iterable<String> iterable2, Iterable<String> iterable3, long j, long j2, long j3) {
        Preconditions.checkArgument(!StringUtil.a(str));
        HoneyClientEvent b = m22811a(event, str, "reaction_overlay", surface).b("source", str3).a("valid_story_types", m22815a((Iterable) iterable)).a("invalid_story_types", m22815a((Iterable) iterable2)).a("invalidated_story_reasons", m22815a((Iterable) iterable3)).a("request_client_time", j2).b("entry_point", EntryPoint.getMarauderValue(entryPoint)).b("gravity_suggestifier_id", str2);
        if (j >= 0) {
            b.a("network_fetch_time", j);
        }
        if (j3 >= 0) {
            b.a("response_minus_ready", j3);
        }
        return b;
    }

    private HoneyClientEvent m22813a(String str, Surface surface, @Nullable String str2, @Nullable EntryPoint entryPoint, String str3, @Nullable String str4, @Nullable Long l) {
        return m22811a(Event.REACTION_OVERLAY_DISPLAY_ABORTED, str, "reaction_overlay", surface).b("error", str3).b("error_message", str4).a("response_minus_ready", l).b("entry_point", EntryPoint.getMarauderValue(entryPoint)).b("gravity_suggestifier_id", str2);
    }

    public static HoneyClientEvent m22811a(Event event, String str, String str2, Surface surface) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.name);
        honeyClientEvent.c = str2;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = str;
        return honeyClientEvent.b("session_id", str).a("surface", surface);
    }

    private HoneyClientEvent m22812a(Event event, String str, String str2, Surface surface, String str3) {
        return m22811a(event, str, str2, surface).b("impression_info", str3);
    }

    private static ArrayNode m22815a(Iterable<?> iterable) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Object obj : iterable) {
            arrayNode.h(obj.toString());
        }
        return arrayNode;
    }

    private static JsonNode m22818b(Iterable<Unit> iterable) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Unit unit : iterable) {
            if (unit.f18854i > 0) {
                arrayNode.a(new ObjectNode(JsonNodeFactory.a).a(unit.f18846a, new LongNode(unit.f18854i)));
            }
        }
        return arrayNode;
    }
}
