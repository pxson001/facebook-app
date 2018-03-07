package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.events.permalink.messageguests.EventBasicGuestListAdapter;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: broadcast_message */
public class EventGuestListAdapter extends EventBasicGuestListAdapter {
    private final Context f18335c;
    private final String f18336d;
    public EventGuestListFragment f18337e;
    private String f18338f;
    private ImmutableList<EventGuestSingleListModel> f18339g;
    private boolean f18340h;
    private EventActionContext f18341i;
    public Map<String, EventGuestListType> f18342j = new HashMap();
    private final Map<String, EventUser> f18343k = Maps.c();
    public final FriendingEventBus f18344l;
    public FriendshipStatusChangedEventSubscriber f18345m = new FriendshipStatusChangedEventSubscriber(this);

    /* compiled from: broadcast_message */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ EventGuestListAdapter f18328a;

        public FriendshipStatusChangedEventSubscriber(EventGuestListAdapter eventGuestListAdapter) {
            this.f18328a = eventGuestListAdapter;
        }

        public final void m18668b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null) {
                ImmutableList immutableList = this.f18328a.f18334h;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    ((EventGuestListSection) immutableList.get(i)).mo844a(Long.toString(friendshipStatusChangedEvent.a), friendshipStatusChangedEvent.b);
                }
                AdapterDetour.a(this.f18328a, -686613185);
            }
        }
    }

    /* compiled from: broadcast_message */
    enum ViewTypes {
        HEADER,
        CHILD,
        LOADING
    }

    @Inject
    public EventGuestListAdapter(FriendingEventBus friendingEventBus, Context context, @Assisted EventActionContext eventActionContext, @Assisted EventsGuestListInitializationModel eventsGuestListInitializationModel, @Assisted EventGuestListType eventGuestListType, @Assisted boolean z) {
        super(new ContextThemeWrapper(context, 2131625810));
        this.f18344l = friendingEventBus;
        this.f18344l.a(this.f18345m);
        this.f18335c = context;
        this.f18341i = eventActionContext;
        this.f18338f = eventsGuestListInitializationModel.b;
        this.f18336d = eventsGuestListInitializationModel.c;
        this.f18339g = eventsGuestListInitializationModel.h;
        this.f18333g = eventGuestListType;
        this.f18340h = z;
    }

    private View m18682a(ViewTypes viewTypes) {
        switch (viewTypes) {
            case CHILD:
                View eventGuestListRowView = new EventGuestListRowView(this.f18335c);
                eventGuestListRowView.f18462v = this.f18337e;
                return eventGuestListRowView;
            case LOADING:
                return new EventGuestListLoadingRowView(this.f18335c);
            default:
                return null;
        }
    }

    public final View m18683a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View a;
        if (m18680f(i) < i2) {
            m18679d(i, i2);
        }
        ViewTypes viewTypes = ViewTypes.values()[m18678c(i, i2)];
        if (view == null) {
            a = m18682a(viewTypes);
        } else {
            a = view;
        }
        if (viewTypes == ViewTypes.CHILD) {
            EventUser eventUser = (EventUser) m18671a(i, i2);
            ((EventGuestListRowView) a).m18788a(this.f18338f, eventUser, this.f18342j.containsKey(eventUser.e()) ? (EventGuestListType) this.f18342j.get(eventUser.e()) : m18681i(), m18681i(), this.f18341i, this.f18340h, this.f18339g, this.f18336d);
        }
        return a;
    }
}
