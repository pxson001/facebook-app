package com.facebook.events.permalink.guestlist;

import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.Builder;
import com.facebook.events.permalink.guestlist.EventGuestListSection.Type;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: boarding_pass_message */
public class EventMutableGuestListSection extends EventGuestListSection {
    public EventMutableGuestListSection(String str, List<Type> list) {
        super(str, list);
    }

    protected final List<EventUser> mo846g() {
        return new LinkedList();
    }

    public final void mo843a(EventUser eventUser) {
        this.f18465a.add(eventUser);
    }

    public final void mo845a(List<EventUser> list) {
        this.f18465a.addAll(list);
    }

    public static void m18839a(List<EventUser> list, List<EventGuestListSection> list2) {
        for (EventGuestListSection eventGuestListSection : list2) {
            if (eventGuestListSection instanceof EventMutableGuestListSection) {
                EventMutableGuestListSection eventMutableGuestListSection = (EventMutableGuestListSection) eventGuestListSection;
                Set hashSet = new HashSet();
                for (EventUser eventUser : list) {
                    hashSet.add(eventUser.b);
                }
                Iterator it = eventMutableGuestListSection.f18465a.iterator();
                while (it.hasNext()) {
                    if (hashSet.contains(((EventUser) it.next()).b)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void mo844a(String str, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        for (int i = 0; i < this.f18465a.size(); i++) {
            if (str.equals(((EventUser) this.f18465a.get(i)).b)) {
                Builder builder = new Builder((EventUser) this.f18465a.get(i));
                builder.h = graphQLFriendshipStatus;
                this.f18465a.set(i, builder.a());
            }
        }
    }
}
