package com.facebook.messaging.groups.admin;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.ultralight.Inject;

/* compiled from: sideloading_on_download_success */
public class GroupsAdminLogger {
    public final GroupAdminController f2430a;
    public final AnalyticsLogger f2431b;

    public static GroupsAdminLogger m2349b(InjectorLike injectorLike) {
        return new GroupsAdminLogger(GroupAdminController.m2341b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private GroupsAdminLogger(GroupAdminController groupAdminController, AnalyticsLogger analyticsLogger) {
        this.f2430a = groupAdminController;
        this.f2431b = analyticsLogger;
    }

    public final void m2350a(ThreadSummary threadSummary, String str) {
        if (threadSummary != null && threadSummary.a.b() && this.f2430a.m2344a(threadSummary)) {
            int size = GroupAdminController.m2340a(threadSummary.h).size();
            if (size != 0) {
                this.f2431b.a(new HoneyClientEvent("group_admin_rollout_exposure").a("tfbid", threadSummary.a.i()).a("num_admin_in_thread", size).b("exposure_point", str));
            }
        }
    }

    public static GroupsAdminLogger m2348a(InjectorLike injectorLike) {
        return m2349b(injectorLike);
    }
}
