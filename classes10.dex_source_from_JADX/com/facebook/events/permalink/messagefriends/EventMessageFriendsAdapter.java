package com.facebook.events.permalink.messagefriends;

import com.facebook.events.graphql.EventFriendsGraphQLModels.BasicEventGuestModel;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.SectionLookUpResult;
import com.facebook.widget.sectionedadapter.SectionedAdapterForRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: birthday_card */
public class EventMessageFriendsAdapter extends SectionedAdapterForRecyclerView<EventFriendsSection> {
    public final ImmutableList<EventFriendsSection> f18616a;
    @Nullable
    public EventMessageFriendsFragment f18617b;
    private int f18618c = 0;

    public EventMessageFriendsAdapter(ImmutableList<EventFriendsSection> immutableList) {
        super(immutableList, true);
        this.f18616a = immutableList;
    }

    public final void m18932f(int i) {
        boolean z = true;
        SectionLookUpResult e = e(i);
        EventFriendsSection eventFriendsSection = (EventFriendsSection) e.b;
        int i2 = e.a;
        Object item = eventFriendsSection.getItem(i2);
        if (item instanceof BasicEventGuestModel) {
            String b = ((BasicEventGuestModel) item).b();
            if (eventFriendsSection.f18615d.contains(b)) {
                eventFriendsSection.f18615d.remove(b);
            } else {
                eventFriendsSection.f18615d.add(b);
            }
            eventFriendsSection.j_(i2);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f18616a.size(); i4++) {
            i3 += ((EventFriendsSection) this.f18616a.get(i4)).f18615d.size();
        }
        int i5 = i3;
        boolean z2 = (this.f18618c == 0) != (i5 == 0);
        this.f18618c = i5;
        if (z2 && this.f18617b != null) {
            EventMessageFriendsFragment eventMessageFriendsFragment = this.f18617b;
            if (this.f18618c == 0) {
                z = false;
            }
            eventMessageFriendsFragment.m18945a(z);
        }
    }
}
