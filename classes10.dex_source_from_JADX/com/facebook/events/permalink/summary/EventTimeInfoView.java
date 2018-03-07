package com.facebook.events.permalink.summary;

import android.content.Context;
import android.widget.TextView;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_miniphone_displayed */
public class EventTimeInfoView extends FbTextView implements EventPermalinkSummaryRow {
    @Inject
    public EventsDashboardTimeFormatUtil f18940a;
    @Inject
    public EventSummaryRowBuilder f18941b;

    public static void m19181a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventTimeInfoView eventTimeInfoView = (EventTimeInfoView) obj;
        EventsDashboardTimeFormatUtil a = EventsDashboardTimeFormatUtil.a(fbInjector);
        EventSummaryRowBuilder b = EventSummaryRowBuilder.m19164b(fbInjector);
        eventTimeInfoView.f18940a = a;
        eventTimeInfoView.f18941b = b;
    }

    public EventTimeInfoView(Context context) {
        super(context);
        Class cls = EventTimeInfoView.class;
        m19181a((Object) this, getContext());
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        return event != null;
    }

    public final void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        this.f18941b.m19166a((TextView) this, this.f18940a.b(event.M, event.J(), event.L()), this.f18940a.c(event.M, event.J(), event.L()), z);
        this.f18941b.m19165a(this, 2130838285, z);
    }
}
