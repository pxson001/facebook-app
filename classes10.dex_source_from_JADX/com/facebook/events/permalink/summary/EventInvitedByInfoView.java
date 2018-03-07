package com.facebook.events.permalink.summary;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_one_page_nux_status_abnormal */
public class EventInvitedByInfoView extends FbTextView implements OnClickListener, EventPermalinkSummaryRow {
    @Inject
    EventEventLogger f18866a;
    @Inject
    EventPermalinkController f18867b;
    @Inject
    EventSummaryRowBuilder f18868c;
    @Inject
    EventsConnectionExperimentController f18869d;
    @Inject
    EventSocialContextFormatter f18870e;
    private EventAnalyticsParams f18871f;
    private Event f18872g;
    public boolean f18873h = true;

    public static void m19138a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventInvitedByInfoView) obj).m19137a(EventEventLogger.m18119b(injectorLike), EventPermalinkController.m18262b(injectorLike), EventSummaryRowBuilder.m19164b(injectorLike), EventsConnectionExperimentController.a(injectorLike), EventSocialContextFormatter.b(injectorLike));
    }

    public EventInvitedByInfoView(Context context) {
        super(context);
        Class cls = EventInvitedByInfoView.class;
        m19138a((Object) this, getContext());
        setOnClickListener(this);
    }

    private void m19137a(EventEventLogger eventEventLogger, EventPermalinkController eventPermalinkController, EventSummaryRowBuilder eventSummaryRowBuilder, EventsConnectionExperimentController eventsConnectionExperimentController, EventSocialContextFormatter eventSocialContextFormatter) {
        this.f18866a = eventEventLogger;
        this.f18867b = eventPermalinkController;
        this.f18868c = eventSummaryRowBuilder;
        this.f18869d = eventsConnectionExperimentController;
        this.f18870e = eventSocialContextFormatter;
    }

    public final void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        this.f18872g = event;
        this.f18871f = eventAnalyticsParams;
        Object obj = (this.f18873h && Event.a(event)) ? 1 : null;
        EventUser eventUser = this.f18872g.ai;
        if (eventUser == null) {
            Object obj2 = null;
        } else {
            String str = eventUser.c;
        }
        if (StringUtil.a(obj2)) {
            setText("");
        } else {
            this.f18868c.m19166a((TextView) this, this.f18870e.a(obj2, this.f18872g.m, this.f18872g.l), null, z);
        }
        this.f18868c.m19165a(this, obj != null ? 2130838283 : 2130838281, z);
    }

    public void onClick(View view) {
        EventUser eventUser;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2098232537);
        if (this.f18872g != null) {
            EventEventLogger eventEventLogger = this.f18866a;
            String str = this.f18872g.a;
            int paramValue = this.f18871f.b.e.getParamValue();
            int paramValue2 = this.f18871f.b.f.getParamValue();
            HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_invited_by_summary_click", false);
            if (a2.a()) {
                a2.a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("action_source", paramValue).a("action_ref", paramValue2).a("has_installed_launcher", false).b();
            }
        }
        if (this.f18872g == null) {
            eventUser = null;
        } else {
            eventUser = this.f18872g.ai;
        }
        if (eventUser != null) {
            this.f18867b.m18268a(getContext(), eventUser);
        }
        LogUtils.a(-865714728, a);
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        return event.G && event.ai != null;
    }
}
