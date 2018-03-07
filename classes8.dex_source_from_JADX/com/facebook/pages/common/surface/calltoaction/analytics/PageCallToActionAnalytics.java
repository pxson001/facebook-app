package com.facebook.pages.common.surface.calltoaction.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import javax.inject.Inject;

/* compiled from: created_place_id */
public class PageCallToActionAnalytics {
    public final AnalyticsLogger f16655a;

    public static PageCallToActionAnalytics m19690b(InjectorLike injectorLike) {
        return new PageCallToActionAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PageCallToActionAnalytics(AnalyticsLogger analyticsLogger) {
        this.f16655a = analyticsLogger;
    }

    public final void m19692a(String str, String str2) {
        this.f16655a.a(m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_NEXT_BUTTON, str).b("step", str2));
    }

    public final void m19693b(String str, String str2) {
        this.f16655a.a(m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_BACK_BUTTON, str).b("step", str2));
    }

    public final void m19691a(String str, PageCallToActionErrorState pageCallToActionErrorState) {
        this.f16655a.a(m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_ERROR, str).a("error", pageCallToActionErrorState));
    }

    public static HoneyClientEvent m19689a(PageCallToActionEvent pageCallToActionEvent, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(pageCallToActionEvent.getName());
        honeyClientEvent.c = "pages_public_view";
        return honeyClientEvent.b("page_id", str);
    }
}
