package com.facebook.events.dashboard.suggestions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.guestlist.EventGuestListLoadingRowView;
import com.facebook.events.widget.eventrow.EventRowView;
import com.facebook.events.widget.eventrow.EventRowView.EventRowViewUpdateRsvpStatusListener;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.stickers.STICKER_CONFIG_CHANGED */
public class EventsSimpleListAdapter extends BaseAdapter {
    private static final Object f17191a = new Object();
    private final Context f17192b;
    private EventAnalyticsParams f17193c;
    public List<Event> f17194d;
    private boolean f17195e = true;
    private EventRowViewUpdateRsvpStatusListener f17196f;

    /* compiled from: com.facebook.orca.stickers.STICKER_CONFIG_CHANGED */
    class C24101 implements EventRowViewUpdateRsvpStatusListener {
        final /* synthetic */ EventsSimpleListAdapter f17190a;

        C24101(EventsSimpleListAdapter eventsSimpleListAdapter) {
            this.f17190a = eventsSimpleListAdapter;
        }

        public final void m17515a(String str, Event event) {
            for (int i = 0; i < this.f17190a.f17194d.size(); i++) {
                if (((Event) this.f17190a.f17194d.get(i)).a.equals(str)) {
                    this.f17190a.f17194d.set(i, event);
                }
            }
            AdapterDetour.a(this.f17190a, 916261563);
        }
    }

    /* compiled from: com.facebook.orca.stickers.STICKER_CONFIG_CHANGED */
    enum ViewTypes {
        EVENT,
        LOADING
    }

    @Inject
    public EventsSimpleListAdapter(@Assisted EventAnalyticsParams eventAnalyticsParams, Context context) {
        this.f17193c = eventAnalyticsParams;
        this.f17192b = context;
        this.f17194d = Lists.a();
        this.f17196f = new C24101(this);
    }

    public final void m17518a(List<Event> list) {
        this.f17194d.addAll(list);
        AdapterDetour.a(this, -359747932);
    }

    public int getCount() {
        return this.f17195e ? this.f17194d.size() + 1 : this.f17194d.size();
    }

    public final int m17516a() {
        return this.f17194d.size();
    }

    public Object getItem(int i) {
        if (i < this.f17194d.size()) {
            return this.f17194d.get(i);
        }
        return f17191a;
    }

    public final Event m17517a(int i) {
        if (i < this.f17194d.size()) {
            return (Event) this.f17194d.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItem(i) == f17191a) {
            return !(view instanceof EventGuestListLoadingRowView) ? new EventGuestListLoadingRowView(this.f17192b) : view;
        } else {
            EventRowView eventRowView;
            if (view instanceof EventRowView) {
                eventRowView = view;
            } else {
                eventRowView = new EventRowView(this.f17192b);
            }
            eventRowView.a((Event) this.f17194d.get(i), this.f17193c, i != 0, this.f17196f, false);
            return eventRowView;
        }
    }

    public final void m17519a(boolean z) {
        if (z != this.f17195e) {
            this.f17195e = z;
            AdapterDetour.a(this, -842784406);
        }
    }
}
