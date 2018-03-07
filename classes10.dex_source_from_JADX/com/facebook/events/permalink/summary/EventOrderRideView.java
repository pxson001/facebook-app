package com.facebook.events.permalink.summary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.appspecific.AppNameResolver;
import com.facebook.messaging.business.ride.utils.RideshareUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_one_nux_upsell_data_fetch_fail */
public class EventOrderRideView extends FbTextView implements OnClickListener, EventPermalinkSummaryRow {
    @Inject
    AnalyticsLogger f18906a;
    @Inject
    QeAccessor f18907b;
    @Inject
    SecureContextHelper f18908c;
    @Inject
    EventSummaryRowBuilder f18909d;
    @Inject
    RideshareUtil f18910e;
    @Inject
    public SystemClock f18911f;
    private Event f18912g;
    private EventAnalyticsParams f18913h;

    public static void m19151a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventOrderRideView) obj).m19150a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), EventSummaryRowBuilder.m19164b(fbInjector), RideshareUtil.a(fbInjector), SystemClockMethodAutoProvider.a(fbInjector));
    }

    private void m19150a(AnalyticsLogger analyticsLogger, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, EventSummaryRowBuilder eventSummaryRowBuilder, RideshareUtil rideshareUtil, SystemClock systemClock) {
        this.f18906a = analyticsLogger;
        this.f18907b = qeAccessor;
        this.f18908c = secureContextHelper;
        this.f18909d = eventSummaryRowBuilder;
        this.f18910e = rideshareUtil;
        this.f18911f = systemClock;
    }

    public EventOrderRideView(Context context) {
        super(context);
        Class cls = EventOrderRideView.class;
        m19151a((Object) this, getContext());
        setOnClickListener(this);
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        int a = this.f18907b.a(ExperimentsForEventsGatingModule.W, 120);
        if (StringUtil.a(event.P) || !event.P() || !this.f18910e.a() || !this.f18907b.a(ExperimentsForEventsGatingModule.V, false)) {
            return false;
        }
        Object obj;
        long K = event.K() - (60000 * ((long) a));
        long a2 = event.L() == null ? TimeUtil.a(180) + K : event.M();
        long a3 = this.f18911f.a();
        if (a3 < K || a3 > a2) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    public final void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        this.f18912g = event;
        this.f18913h = eventAnalyticsParams;
        this.f18909d.m19166a((TextView) this, getContext().getString(2131237000), getContext().getString(2131237001, new Object[]{AppNameResolver.a(getResources())}), z);
        this.f18909d.m19165a(this, 2130838282, z);
    }

    public void onClick(View view) {
        String str;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1760423948);
        String str2 = this.f18912g.Q;
        if (StringUtil.a(str2)) {
            str = null;
        } else {
            String str3 = "\n";
            str = str2.replaceAll(str3, getContext().getString(2131236994, new Object[]{"", ""}));
        }
        str2 = str;
        if (Strings.isNullOrEmpty(str2)) {
            str2 = this.f18912g.P;
        }
        Uri a2 = RideshareUtil.a(str2, Double.valueOf(this.f18912g.Q()), Double.valueOf(this.f18912g.R()), null, "events_summary_view_order_ride");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(a2);
        this.f18908c.a(intent, getContext());
        HoneyClientEventFast a3 = this.f18906a.a("event_location_summary_order_ride", true);
        if (a3.a()) {
            a3.a("event_permalink").b("Event").c(this.f18912g.a).a("source_module", this.f18913h.d).a("ref_module", this.f18913h.c).b();
        }
        LogUtils.a(-1199040954, a);
    }
}
