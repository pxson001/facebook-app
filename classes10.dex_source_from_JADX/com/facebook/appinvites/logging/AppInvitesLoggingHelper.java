package com.facebook.appinvites.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInviteFieldsModel;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: editEventParams */
public class AppInvitesLoggingHelper {
    public final AnalyticsLogger f14610a;

    public static AppInvitesLoggingHelper m14767b(InjectorLike injectorLike) {
        return new AppInvitesLoggingHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AppInvitesLoggingHelper(AnalyticsLogger analyticsLogger) {
        this.f14610a = analyticsLogger;
    }

    public static HoneyClientEvent m14766b(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "app_invite";
        return honeyClientEvent;
    }

    public final void m14768a(String str, AppInviteFieldsModel appInviteFieldsModel) {
        HoneyClientEvent b = m14766b(str);
        b.e = appInviteFieldsModel.ne_();
        b.b("app_id", appInviteFieldsModel.m15017c().m14991d());
        b.b("sender_id", appInviteFieldsModel.nf_().m15002b());
        this.f14610a.a(b);
    }
}
