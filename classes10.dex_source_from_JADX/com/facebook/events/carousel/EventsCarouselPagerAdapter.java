package com.facebook.events.carousel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.util.StringUtil;
import com.facebook.events.carousel.EventCardViewBinder.C22321;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.permalinkintent.EventPermalinkIntentBuilder;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: contacts_sets */
public class EventsCarouselPagerAdapter extends PagerAdapter {
    public final Context f16015a;
    public final EventAnalyticsParams f16016b;
    public final ActionMechanism f16017c;
    private final String f16018d;
    public final EventEventLogger f16019e;
    private final List<EventCardViewBinder> f16020f;
    private final HashMap<String, Integer> f16021g = m16427a(this.f16020f.size());
    private final EventGraphQLModelHelper f16022h;
    public final EventPermalinkIntentBuilder f16023i;
    public EventsSuggestionsPagerAdapterEmptiedListener f16024j;

    /* compiled from: contacts_sets */
    public interface EventsSuggestionsPagerAdapterEmptiedListener {
        void mo774a();
    }

    /* compiled from: contacts_sets */
    public /* synthetic */ class C22362 {
        public static final /* synthetic */ int[] f16014a = new int[ActionSource.values().length];

        static {
            try {
                f16014a[ActionSource.MOBILE_SUBSCRIPTIONS_DASHBOARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16014a[ActionSource.MOBILE_SUGGESTIONS_DASHBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public EventsCarouselPagerAdapter(@Assisted Context context, @Assisted EventAnalyticsParams eventAnalyticsParams, @Assisted List<EventCardViewBinder> list, @Assisted ActionSource actionSource, @Assisted ActionMechanism actionMechanism, @Assisted String str, EventEventLogger eventEventLogger, EventGraphQLModelHelper eventGraphQLModelHelper, EventPermalinkIntentBuilder eventPermalinkIntentBuilder) {
        this.f16015a = context;
        this.f16016b = new EventAnalyticsParams(eventAnalyticsParams, actionSource);
        this.f16017c = actionMechanism;
        this.f16020f = Lists.a(list);
        this.f16019e = eventEventLogger;
        this.f16018d = str;
        this.f16022h = eventGraphQLModelHelper;
        this.f16023i = eventPermalinkIntentBuilder;
    }

    public final Object m16429a(ViewGroup viewGroup, final int i) {
        EventsCardView eventsCardView = new EventsCardView(this.f16015a);
        eventsCardView.setLayoutParams(new LayoutParams(-1, -2));
        final EventCardViewBinder eventCardViewBinder = (EventCardViewBinder) this.f16020f.get(i);
        ActionMechanism actionMechanism = this.f16017c;
        String str = this.f16018d;
        eventCardViewBinder.f15999w = eventsCardView;
        eventCardViewBinder.f16000x = actionMechanism;
        eventCardViewBinder.f16001y = this;
        eventCardViewBinder.f16002z = str;
        eventCardViewBinder.f15987k.a(eventCardViewBinder.f15977B);
        eventsCardView.a(eventCardViewBinder.f15982f.getDrawable(2130839488));
        eventsCardView.c();
        eventsCardView.setCoverPhotoController(eventCardViewBinder.f15980d);
        eventsCardView.setCoverPhotoFocusPoint(eventCardViewBinder.f15981e);
        eventsCardView.setTitleText(eventCardViewBinder.f15991o);
        eventsCardView.setCalendarFormatStartDate(eventCardViewBinder.f15992p);
        eventsCardView.a(eventCardViewBinder.f15993q, eventCardViewBinder.f15994r);
        eventsCardView.setSocialContextText(eventCardViewBinder.f15995s);
        eventsCardView.g.a(eventCardViewBinder.f15983g.a(eventCardViewBinder.f15997u, eventCardViewBinder.f15996t, eventCardViewBinder.f15998v));
        View view = eventsCardView.h;
        if (eventCardViewBinder.f15976A == null || eventCardViewBinder.f15976A.isEmpty()) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        if (!(eventCardViewBinder.f15976A == null || eventCardViewBinder.f15976A.isEmpty())) {
            if (eventCardViewBinder.f15976A.size() == 1) {
                view.setContentDescription(((EventCardRemover) eventCardViewBinder.f15976A.get(0)).mo797a(eventCardViewBinder.f15978b, eventCardViewBinder.f15990n));
            } else {
                view.setContentDescription(eventCardViewBinder.f15982f.getString(2131236895));
            }
        }
        view.setOnClickListener(new C22321(eventCardViewBinder, view));
        viewGroup.addView(eventsCardView);
        eventsCardView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventsCarouselPagerAdapter f16013c;

            public void onClick(View view) {
                String str;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1943379978);
                EventEventLogger eventEventLogger = this.f16013c.f16019e;
                String str2 = eventCardViewBinder.f15990n.a;
                switch (C22362.f16014a[this.f16013c.f16016b.b.e.ordinal()]) {
                    case 1:
                        str = "event_subscriptions";
                        break;
                    case 2:
                        str = "event_suggestions";
                        break;
                    default:
                        str = "unknown";
                        break;
                }
                eventEventLogger.m18139b(str2, str, i, this.f16013c.f16016b.b.e.getParamValue());
                this.f16013c.f16023i.a(this.f16013c.f16015a, eventCardViewBinder.f15990n.a, this.f16013c.f16016b.b.a(this.f16013c.f16017c));
                Logger.a(2, EntryType.UI_INPUT_END, -1582881174, a);
            }
        });
        return eventsCardView;
    }

    public final void m16430a(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < this.f16020f.size()) {
            ((EventCardViewBinder) this.f16020f.get(i)).m16415a();
        }
        viewGroup.removeView((View) obj);
    }

    public final int m16434b() {
        return this.f16020f.size();
    }

    public final boolean m16433a(View view, Object obj) {
        return view == obj;
    }

    public final int m16428a(Object obj) {
        return -2;
    }

    public final void m16432a(EventCommonFragment eventCommonFragment) {
        Integer num = (Integer) this.f16021g.get(eventCommonFragment.dL_());
        if (num != null) {
            ((EventCardViewBinder) this.f16020f.get(num.intValue())).m16416a(EventGraphQLModelHelper.m19281c(eventCommonFragment).b());
            kR_();
        }
    }

    private HashMap<String, Integer> m16427a(int i) {
        HashMap<String, Integer> hashMap = new HashMap(i);
        for (int i2 = 0; i2 < this.f16020f.size(); i2++) {
            hashMap.put(((EventCardViewBinder) this.f16020f.get(i2)).f15990n.a, Integer.valueOf(i2));
        }
        return hashMap;
    }

    public final void m16431a(EventCardViewBinder eventCardViewBinder, EventCardRemover eventCardRemover) {
        String str = eventCardViewBinder.f15990n.al;
        if (!eventCardRemover.mo799a() || StringUtil.a(str)) {
            eventCardViewBinder.m16415a();
            this.f16020f.remove(eventCardViewBinder);
        } else {
            List<EventCardViewBinder> a = Lists.a();
            for (EventCardViewBinder eventCardViewBinder2 : this.f16020f) {
                if (str.equals(eventCardViewBinder2.f15990n.al)) {
                    a.add(eventCardViewBinder2);
                }
            }
            for (EventCardViewBinder eventCardViewBinder22 : a) {
                eventCardViewBinder22.m16415a();
                this.f16020f.remove(eventCardViewBinder22);
            }
        }
        kR_();
        if (this.f16020f.isEmpty() && this.f16024j != null) {
            this.f16024j.mo774a();
        }
    }
}
