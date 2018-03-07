package com.facebook.events.permalink.summary;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeUtil;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.location.FbLocationCache;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_one_page_nux_privacy_data_fetch_fail */
public class EventLocationSharingInfoView extends FbTextView implements OnClickListener, EventPermalinkSummaryRow {
    @Inject
    EventSummaryRowBuilder f18899a;
    @Inject
    public FbLocationCache f18900b;
    @Inject
    IFeedIntentBuilder f18901c;
    @Inject
    public FbLocationStatusUtil f18902d;
    @Inject
    QeAccessor f18903e;
    @Inject
    public SystemClock f18904f;
    public Event f18905g;

    public static void m19147a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventLocationSharingInfoView) obj).m19146a(EventSummaryRowBuilder.m19164b(fbInjector), FbLocationCache.b(fbInjector), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), FbLocationStatusUtil.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), SystemClockMethodAutoProvider.a(fbInjector));
    }

    private void m19146a(EventSummaryRowBuilder eventSummaryRowBuilder, FbLocationCache fbLocationCache, IFeedIntentBuilder iFeedIntentBuilder, FbLocationStatusUtil fbLocationStatusUtil, QeAccessor qeAccessor, SystemClock systemClock) {
        this.f18899a = eventSummaryRowBuilder;
        this.f18900b = fbLocationCache;
        this.f18901c = iFeedIntentBuilder;
        this.f18902d = fbLocationStatusUtil;
        this.f18903e = qeAccessor;
        this.f18904f = systemClock;
    }

    public EventLocationSharingInfoView(Context context) {
        super(context);
        Class cls = EventLocationSharingInfoView.class;
        m19147a((Object) this, getContext());
        setOnClickListener(this);
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        if (fetchEventPermalinkFragmentModel == null || !event.P() || !this.f18903e.a(ExperimentsForEventsGatingModule.H, false)) {
            return false;
        }
        Object obj;
        long K = event.K() - (((long) fetchEventPermalinkFragmentModel.Y()) * 1000);
        long a = event.L() == null ? TimeUtil.a(180) + K : event.M();
        long a2 = this.f18904f.a();
        if (a2 < K || a2 > a) {
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
        String string;
        this.f18905g = event;
        Preconditions.checkNotNull(fetchEventPermalinkFragmentModel);
        int X = fetchEventPermalinkFragmentModel.X();
        if (X == 0) {
            string = getResources().getString(2131237015);
        } else {
            string = getResources().getQuantityString(2131689665, X, new Object[]{Integer.valueOf(X)});
        }
        CharSequence charSequence = string;
        if (X == 0) {
            string = getResources().getString(2131237016);
        } else {
            string = null;
        }
        this.f18899a.m19166a((TextView) this, charSequence, (CharSequence) string, z);
        this.f18899a.m19165a(this, 2130839969, z);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1639297154);
        if (this.f18905g == null) {
            Logger.a(2, EntryType.UI_INPUT_END, 1533265661, a);
            return;
        }
        IFeedIntentBuilder iFeedIntentBuilder = this.f18901c;
        Context context = getContext();
        State a2 = this.f18902d.a();
        Builder encodedPath = new Builder().encodedPath("/events/location_sharing/map/");
        encodedPath.appendQueryParameter("event_id", this.f18905g.a);
        encodedPath.appendQueryParameter("location_services_enabled", Boolean.toString(a2 == State.OKAY));
        m19145a(encodedPath, "location_services_status", Optional.fromNullable(a2));
        ImmutableLocation a3 = this.f18900b.a();
        if (a3 != null) {
            encodedPath.appendQueryParameter("lat", Double.toString(a3.a()));
            encodedPath.appendQueryParameter("long", Double.toString(a3.b()));
            m19145a(encodedPath, "bearing", a3.e());
            m19145a(encodedPath, "altm", a3.d());
            m19145a(encodedPath, "acch", a3.c());
            m19145a(encodedPath, "ts", a3.g());
        }
        iFeedIntentBuilder.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(encodedPath.build().toString())));
        LogUtils.a(-2140029491, a);
    }

    public static void m19145a(Builder builder, String str, Optional<?> optional) {
        if (optional.isPresent()) {
            builder.appendQueryParameter(str, optional.get().toString());
        }
    }
}
