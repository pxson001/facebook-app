package com.facebook.feed.platformads;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

/* compiled from: admin_click_notif */
public class AppInstallService extends FbIntentService {
    private static final Class<?> f19801a = AppInstallService.class;
    @Inject
    private NewsFeedAnalyticsEventBuilder f19802b;
    @Inject
    private AnalyticsLogger f19803c;
    @Inject
    private AppInstallTracker f19804d;

    private static <T extends Context> void m23066a(Class<T> cls, T t) {
        m23067a((Object) t, (Context) t);
    }

    public static void m23067a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AppInstallService) obj).m23064a(NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AppInstallTracker.m23070a(injectorLike));
    }

    public AppInstallService() {
        super(f19801a.getSimpleName());
        setIntentRedelivery(true);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1718551593);
        super.onCreate();
        Class cls = AppInstallService.class;
        m23067a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -199559870, a);
    }

    protected final void m23069a(Intent intent) {
        if (this.f19804d.m23081a() && intent != null) {
            String stringExtra = intent.getStringExtra("package_name");
            if (!StringUtil.a(stringExtra)) {
                TrackedPackage a = this.f19804d.m23078a(stringExtra);
                if (a == null) {
                    return;
                }
                if (intent.getStringExtra("action_type").equals("install")) {
                    m23065a(a);
                } else if (intent.getStringExtra("action_type").equals("uninstall") && this.f19804d.f19808c.a(1005, false)) {
                    m23068b(a);
                    this.f19804d.m23079a(a);
                }
            }
        }
    }

    private void m23065a(TrackedPackage trackedPackage) {
        if (this.f19802b != null && this.f19803c != null) {
            ArrayNode arrayNode = trackedPackage.trackingCodes;
            HoneyClientEvent j = new HoneyClientEvent("store_conversion_v2").a("tracking", arrayNode).j(trackedPackage.fbid);
            j.c = "native_newsfeed";
            this.f19803c.d(j);
        }
    }

    private void m23068b(TrackedPackage trackedPackage) {
        if (this.f19802b != null && this.f19803c != null) {
            ArrayNode arrayNode = trackedPackage.trackingCodes;
            HoneyClientEvent j = new HoneyClientEvent("third_party_app_uninstall").a("tracking", arrayNode).j(trackedPackage.fbid);
            j.c = "native_newsfeed";
            this.f19803c.d(j);
        }
    }

    private void m23064a(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, AppInstallTracker appInstallTracker) {
        this.f19802b = newsFeedAnalyticsEventBuilder;
        this.f19803c = analyticsLogger;
        this.f19804d = appInstallTracker;
    }
}
