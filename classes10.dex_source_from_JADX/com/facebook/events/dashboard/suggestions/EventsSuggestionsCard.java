package com.facebook.events.dashboard.suggestions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.events.carousel.EventsCarouselCard;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.SuggestedEventCutModel;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE */
public class EventsSuggestionsCard extends EventsCarouselCard {
    @Inject
    public EventPermalinkController f17198c;
    public SuggestedEventCutModel f17199d;
    public EventAnalyticsParams f17200e;

    /* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE */
    public class C24111 implements OnClickListener {
        final /* synthetic */ EventsSuggestionsCard f17197a;

        public C24111(EventsSuggestionsCard eventsSuggestionsCard) {
            this.f17197a = eventsSuggestionsCard;
        }

        public void onClick(View view) {
            String str;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1347757883);
            EventPermalinkController eventPermalinkController = this.f17197a.f17198c;
            Context context = this.f17197a.getContext();
            SuggestedEventCutModel suggestedEventCutModel = this.f17197a.f17199d;
            EventActionContext eventActionContext = this.f17197a.f17200e.b;
            String module = this.f17197a.getModule();
            Intent component = new Intent().setComponent((ComponentName) eventPermalinkController.f17857d.get());
            component.putExtra("target_fragment", ContentFragmentType.EVENTS_SUGGESTIONS_FRAGMENT.ordinal());
            if (suggestedEventCutModel.a() == null) {
                str = null;
            } else {
                str = suggestedEventCutModel.a().name();
            }
            component.putExtras(EventsSuggestionsFragment.m17525a(str, suggestedEventCutModel.b(), eventActionContext, module));
            eventPermalinkController.f17855b.a(component, context);
            Logger.a(2, EntryType.UI_INPUT_END, 1813000143, a);
        }
    }

    public static void m17521a(Object obj, Context context) {
        ((EventsSuggestionsCard) obj).f17198c = EventPermalinkController.m18262b(FbInjector.get(context));
    }

    public EventsSuggestionsCard(Context context) {
        super(context);
        Class cls = EventsSuggestionsCard.class;
        m17521a(this, getContext());
    }

    protected CharSequence getTitle() {
        return this.f17199d == null ? getContext().getString(2131237155) : this.f17199d.b();
    }

    protected CharSequence getViewAllText() {
        if (this.f17199d == null) {
            return null;
        }
        return getContext().getString(2131237140, new Object[]{getTitle()});
    }

    protected final String mo800c(int i) {
        if (this.f17199d == null || this.f17199d.c() == null || this.f17199d.c().a().size() <= i) {
            return null;
        }
        return ((EventCommonFragment) this.f17199d.c().a().get(i)).dL_();
    }

    protected EventAnalyticsParams getEventAnalyticsParams() {
        return this.f17200e;
    }

    protected String getModule() {
        return "event_suggestions";
    }
}
