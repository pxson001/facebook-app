package com.facebook.search.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.search.model.SearchAwarenessUnitProperties;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: redspace */
public class SearchAwarenessLogger {
    private final AnalyticsLogger f7855a;

    public static SearchAwarenessLogger m12394b(InjectorLike injectorLike) {
        return new SearchAwarenessLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    public final void m12407b(SearchAwarenessUnitProperties searchAwarenessUnitProperties, ImmutableMap<String, ?> immutableMap) {
        m12395b(searchAwarenessUnitProperties.a.jF_().toString(), ImmutableMap.builder().m608a((Map) immutableMap).m609b("unit_id", searchAwarenessUnitProperties.a.b()).m609b("root_unit_id", searchAwarenessUnitProperties.g).m609b("test_name", searchAwarenessUnitProperties.c).m610b());
    }

    private void m12396c(String str) {
        m12393a(str, RegularImmutableBiMap.f695a);
    }

    public final void m12406b(SearchAwarenessUnitProperties searchAwarenessUnitProperties) {
        m12407b(searchAwarenessUnitProperties, RegularImmutableBiMap.f695a);
    }

    @Inject
    public SearchAwarenessLogger(AnalyticsLogger analyticsLogger) {
        this.f7855a = analyticsLogger;
    }

    public final void m12400a(SearchAwarenessUnitProperties searchAwarenessUnitProperties, ImmutableMap<String, ?> immutableMap) {
        Builder builder = ImmutableMap.builder();
        builder.m608a((Map) immutableMap);
        builder.m609b("unit_id", searchAwarenessUnitProperties.a.b());
        builder.m609b("root_unit_id", searchAwarenessUnitProperties.g);
        builder.m609b("test_name", searchAwarenessUnitProperties.c);
        m12393a(searchAwarenessUnitProperties.a.jF_().toString(), builder.m610b());
    }

    private void m12393a(String str, ImmutableMap<String, ?> immutableMap) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("search_awareness_unit_impression");
        honeyClientEvent.m5090b("template", str);
        honeyClientEvent.m5088a((Map) immutableMap);
        this.f7855a.mo526a(honeyClientEvent);
    }

    public final void m12398a(int i) {
        m12393a("TUTORIAL_NUX", ImmutableBiMap.m978b("card_shown", Integer.valueOf(i)));
    }

    public final void m12405b(int i) {
        m12393a("SPOTLIGHT", ImmutableBiMap.m978b("card_shown", Integer.valueOf(i)));
    }

    public final void m12397a() {
        m12396c("PROFILE_PILL");
    }

    public final void m12404b() {
        m12396c("GROUPS_PILL");
    }

    public final void m12401a(String str) {
        m12393a("OPT_OUT_DIALOG", ImmutableBiMap.m978b("feature", str));
    }

    public final void m12399a(SearchAwarenessUnitProperties searchAwarenessUnitProperties) {
        m12393a("TYPEAHEAD_TOOLTIP", ImmutableMap.of("unit_id", searchAwarenessUnitProperties.a.b(), "root_unit_id", searchAwarenessUnitProperties.g, "test_name", searchAwarenessUnitProperties.c));
    }

    private void m12395b(String str, ImmutableMap<String, ?> immutableMap) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("search_awareness_unit_dismissed");
        honeyClientEvent.m5090b("template", str);
        honeyClientEvent.m5088a((Map) immutableMap);
        this.f7855a.mo526a(honeyClientEvent);
    }

    public final void m12410c(SearchAwarenessUnitProperties searchAwarenessUnitProperties) {
        m12395b("TYPEAHEAD_TOOLTIP", ImmutableMap.of("unit_id", searchAwarenessUnitProperties.a.b(), "root_unit_id", searchAwarenessUnitProperties.g, "test_name", searchAwarenessUnitProperties.c));
    }

    public final void m12408b(String str) {
        m12395b("TUTORIAL_NUX", ImmutableBiMap.m978b("action", str));
    }

    public final void m12403a(boolean z) {
        m12395b("PROFILE_PILL", ImmutableBiMap.m978b("was_clicked", Boolean.valueOf(z)));
    }

    public final void m12409b(boolean z) {
        m12395b("GROUPS_PILL", ImmutableBiMap.m978b("was_clicked", Boolean.valueOf(z)));
    }

    public final void m12402a(String str, String str2) {
        m12395b("OPT_OUT_DIALOG", ImmutableMap.of("feature", str, "action", str2));
    }
}
