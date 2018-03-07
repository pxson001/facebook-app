package com.facebook.tagging.logging;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.tagging.model.MentionSurface;
import com.facebook.tagging.model.TaggingProfile;
import javax.inject.Inject;

/* compiled from: deltaThreadDelete */
public class MentionsTypeaheadAnalyticHelper {
    private final AnalyticsLogger f17521a;
    private String f17522b = "";

    @Inject
    public MentionsTypeaheadAnalyticHelper(AnalyticsLogger analyticsLogger) {
        this.f17521a = analyticsLogger;
    }

    public final void m25509a(String str, Long l, MentionSurface mentionSurface) {
        this.f17522b = SafeUUIDGenerator.a().toString();
        HoneyClientEvent a = m25507a("session_start");
        a.b("selected_input_query", str);
        a.a("group_id", l);
        a.a("surface", mentionSurface);
        this.f17521a.c(a);
    }

    public final void m25510b(String str, Long l, MentionSurface mentionSurface) {
        HoneyClientEvent a = m25507a("session_end");
        a.b("session_end_reason", str);
        a.a("group_id", l);
        a.a("surface", mentionSurface);
        this.f17521a.c(a);
        this.f17522b = "";
    }

    public final void m25508a(TaggingProfile taggingProfile, int i, String str, Long l, MentionSurface mentionSurface) {
        HoneyClientEvent a = m25507a("selection");
        a.a("selected_result_type", taggingProfile.f17542e);
        a.a("selected_result_id", taggingProfile.f17539b);
        a.b("selected_result_display_text", taggingProfile.m25532i());
        a.b("selected_result_data_source", taggingProfile.f17546i);
        a.b("selected_result_typeahead_type", taggingProfile.f17545h);
        a.b("selected_input_query", str);
        a.a("selected_position", i);
        a.a("group_id", l);
        a.a("surface", mentionSurface);
        this.f17521a.c(a);
    }

    private HoneyClientEvent m25507a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.c = "mentions";
        return honeyClientEvent.b("action", str).b("session_id", this.f17522b);
    }
}
