package com.facebook.events.dashboard.subscriptions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.carousel.EventsCarouselCard;
import com.facebook.events.carousel.EventsCarouselPagerAdapter;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.action.request.LIKE_DIALOG */
public class EventsSubscriptionsCard extends EventsCarouselCard {
    @Inject
    public EventPermalinkController f17159c;
    private List<NodesModel> f17160d;
    public int f17161e;
    public EventAnalyticsParams f17162f;

    /* compiled from: com.facebook.platform.action.request.LIKE_DIALOG */
    public class C24021 implements OnClickListener {
        final /* synthetic */ EventsSubscriptionsCard f17158a;

        public C24021(EventsSubscriptionsCard eventsSubscriptionsCard) {
            this.f17158a = eventsSubscriptionsCard;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 155789935);
            this.f17158a.f17159c.m18264a(this.f17158a.getContext(), this.f17158a.f17162f.b, this.f17158a.getModule());
            Logger.a(2, EntryType.UI_INPUT_END, -42504505, a);
        }
    }

    public static void m17493a(Object obj, Context context) {
        ((EventsSubscriptionsCard) obj).f17159c = EventPermalinkController.m18262b(FbInjector.get(context));
    }

    public EventsSubscriptionsCard(Context context) {
        super(context);
        Class cls = EventsSubscriptionsCard.class;
        m17493a(this, getContext());
    }

    public final void m17495a(List<NodesModel> list, int i, @Nonnull EventsCarouselPagerAdapter eventsCarouselPagerAdapter, @Nonnull EventAnalyticsParams eventAnalyticsParams) {
        ActionSource actionSource;
        if (eventAnalyticsParams.b.e == ActionSource.DASHBOARD) {
            actionSource = ActionSource.MOBILE_SUBSCRIPTIONS_DASHBOARD;
        } else {
            actionSource = eventAnalyticsParams.b.e;
        }
        this.f17160d = list;
        this.f17161e = i;
        if (this.f17160d.isEmpty() && i > 0) {
            m16425a(2131237189, 2130839868, 2131361974);
        }
        this.f17162f = eventAnalyticsParams.a(actionSource);
        setPagerAdapter(eventsCarouselPagerAdapter);
    }

    protected CharSequence getTitle() {
        return getContext().getString(2131237188);
    }

    protected CharSequence getViewAllText() {
        return getContext().getString(2131237190);
    }

    protected final String mo800c(int i) {
        if (this.f17160d == null || this.f17160d.size() <= i) {
            return null;
        }
        return ((NodesModel) this.f17160d.get(i)).dL_();
    }

    protected EventAnalyticsParams getEventAnalyticsParams() {
        return this.f17162f;
    }

    protected String getModule() {
        return "event_subscriptions";
    }

    public final void mo774a() {
        m16425a(2131237189, 2130839868, 2131361974);
    }
}
