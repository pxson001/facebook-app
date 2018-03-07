package com.facebook.messaging.events.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.events.abtest.ExperimentsForEventsAbTestModule;
import com.facebook.messaging.events.abtest.LightweightEventsGatekeepers;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: social_search_conversion */
public class EventReminderNotification extends AbstractBannerNotification {
    private Context f2328a;
    public DataCache f2329b;
    public final EventsDashboardTimeFormatUtil f2330c;
    private EventReminderLogger f2331d;
    public EventReminderMembersUtil f2332e;
    private EventReminderMutator f2333f;
    public final LightweightEventsGatekeepers f2334g;
    private final QeAccessor f2335h;
    public ThreadSummary f2336i;
    public ThreadEventReminder f2337j;
    public EventReminderBannerView f2338k;
    public EventReminderMembers f2339l;

    public static EventReminderNotification m2193a(InjectorLike injectorLike) {
        return new EventReminderNotification((Context) injectorLike.getInstance(Context.class), DataCache.a(injectorLike), EventsDashboardTimeFormatUtil.a(injectorLike), new EventReminderLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)), EventReminderMembersUtil.m2177b(injectorLike), EventReminderMutator.m2188b(injectorLike), LightweightEventsGatekeepers.m2154b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventReminderNotification(Context context, DataCache dataCache, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, EventReminderLogger eventReminderLogger, EventReminderMembersUtil eventReminderMembersUtil, EventReminderMutator eventReminderMutator, LightweightEventsGatekeepers lightweightEventsGatekeepers, QeAccessor qeAccessor) {
        super("EventReminderNotification");
        this.f2328a = context;
        this.f2329b = dataCache;
        this.f2330c = eventsDashboardTimeFormatUtil;
        this.f2331d = eventReminderLogger;
        this.f2332e = eventReminderMembersUtil;
        this.f2333f = eventReminderMutator;
        this.f2334g = lightweightEventsGatekeepers;
        this.f2335h = qeAccessor;
    }

    public final View m2195a(ViewGroup viewGroup) {
        this.f2338k = new EventReminderBannerView(this.f2328a);
        if (!m2194g()) {
            return this.f2338k;
        }
        EventReminderBannerView eventReminderBannerView = this.f2338k;
        Date date = new Date();
        date.setTime(TimeUnit.SECONDS.toMillis(this.f2337j.b));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f2330c.a(false, date, null));
        String str = this.f2337j.c;
        if (!Strings.isNullOrEmpty(str) && this.f2334g.f2277a.a(253, false)) {
            stringBuilder.append(" ⋅ ");
            stringBuilder.append(str);
        }
        eventReminderBannerView.f2286f.setText(stringBuilder.toString());
        this.f2331d.m2169a(this.f2337j, this.f2336i);
        return this.f2338k;
    }

    public final void m2197e() {
        if (m2194g() && this.f2335h.a(ExperimentsForEventsAbTestModule.f2276a, false)) {
            this.a.a(this);
            if (this.f2338k != null) {
                this.f2338k.m2158a(this.f2337j, this.f2336i.a, this.f2339l);
                return;
            }
            return;
        }
        this.a.b(this);
    }

    private boolean m2194g() {
        return this.f2337j != null;
    }

    public final void m2196b() {
        m2197e();
    }
}
