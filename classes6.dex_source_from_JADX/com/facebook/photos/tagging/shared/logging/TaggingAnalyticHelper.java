package com.facebook.photos.tagging.shared.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: gte */
public class TaggingAnalyticHelper {
    private final AnalyticsLogger f13408a;
    private Optional<String> f13409b = Absent.INSTANCE;

    public static TaggingAnalyticHelper m21080a(InjectorLike injectorLike) {
        return new TaggingAnalyticHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TaggingAnalyticHelper(AnalyticsLogger analyticsLogger) {
        this.f13408a = analyticsLogger;
    }

    public final void m21083a(String str, String str2) {
        this.f13409b = Optional.of(SafeUUIDGenerator.a().toString());
        HoneyClientEvent a = m21079a("session_start");
        a.b("data_source", str);
        a.b("media_container_id", str2);
        this.f13408a.a(a);
    }

    private void m21081a(String str, String str2, String str3) {
        if (this.f13409b.isPresent()) {
            HoneyClientEvent a = m21079a("session_end");
            a.b("data_source", str);
            a.b("session_end_reason", str3);
            a.b("media_container_id", str2);
            this.f13408a.a(a);
            Absent absent = Absent.INSTANCE;
        }
    }

    public final void m21084b(String str, String str2) {
        m21081a(str, str2, "cancel");
    }

    public final void m21082a(TaggingProfile taggingProfile, String str, String str2) {
        if (this.f13409b.isPresent()) {
            HoneyClientEvent a = m21079a("selection");
            a.a("selected_result_type", taggingProfile.f17542e);
            a.a("selected_result_id", taggingProfile.f17539b);
            a.b("selected_result_display_text", taggingProfile.m25532i());
            a.b("data_source", taggingProfile.f17546i);
            a.b("selected_result_typeaehad_type", taggingProfile.f17545h);
            a.b("selected_input_query", str);
            a.b("media_container_id", str2);
            this.f13408a.a(a);
            m21081a(taggingProfile.f17546i, str2, "select");
        }
    }

    private HoneyClientEvent m21079a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.c = "tagging";
        return honeyClientEvent.b("action", str).b("session_id", (String) this.f13409b.get());
    }
}
