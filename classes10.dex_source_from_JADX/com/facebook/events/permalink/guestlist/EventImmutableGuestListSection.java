package com.facebook.events.permalink.guestlist;

import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.Builder;
import com.facebook.events.permalink.guestlist.EventGuestListSection.Type;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: boarding_pass_share */
public class EventImmutableGuestListSection extends EventGuestListSection {
    private Map<String, Integer> f18503b = Maps.c();

    public EventImmutableGuestListSection(String str, List<Type> list) {
        super(str, list);
    }

    public final void mo845a(List<EventUser> list) {
        int size = this.f18465a.size();
        int i = size;
        for (EventUser eventUser : list) {
            this.f18465a.add(eventUser);
            size = i + 1;
            this.f18503b.put(eventUser.b, Integer.valueOf(i));
            i = size;
        }
    }

    protected final List<EventUser> mo846g() {
        return new ArrayList();
    }

    public final void mo843a(EventUser eventUser) {
        int size = this.f18465a.size();
        this.f18465a.add(eventUser);
        this.f18503b.put(eventUser.b, Integer.valueOf(size));
    }

    public final void mo844a(String str, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (this.f18503b.containsKey(str)) {
            Integer num = (Integer) this.f18503b.get(str);
            Builder builder = new Builder((EventUser) this.f18465a.get(num.intValue()));
            builder.h = graphQLFriendshipStatus;
            this.f18465a.set(num.intValue(), builder.a());
        }
    }
}
