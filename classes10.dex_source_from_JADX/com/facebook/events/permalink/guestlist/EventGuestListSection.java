package com.facebook.events.permalink.guestlist;

import android.annotation.SuppressLint;
import com.facebook.events.model.EventUser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.widget.listview.ExpandableSectionedListSection;
import java.util.ArrayList;
import java.util.List;

/* compiled from: bookmarks_section */
public abstract class EventGuestListSection extends ExpandableSectionedListSection<EventUser> {
    public List<EventUser> f18465a;
    public final List<Type> f18466b;

    /* compiled from: bookmarks_section */
    public enum Type {
        SELF,
        FRIENDS,
        NON_FRIENDS,
        EMAILS,
        SMS,
        TODAY,
        YESTERDAY,
        EARLIER
    }

    public abstract void mo843a(EventUser eventUser);

    public abstract void mo844a(String str, GraphQLFriendshipStatus graphQLFriendshipStatus);

    public abstract void mo845a(List<EventUser> list);

    protected abstract List<EventUser> mo846g();

    private EventGuestListSection(String str) {
        super(str);
        this.f18466b = new ArrayList();
        this.f18465a = mo846g();
    }

    public EventGuestListSection(String str, List<Type> list) {
        this(str);
        this.f18466b.addAll(list);
    }

    @SuppressLint({"PublicMethodReturnMutableCollection"})
    protected final List<EventUser> m18792d() {
        return this.f18465a;
    }

    public final List<EventUser> m18793e() {
        return this.f18465a;
    }
}
