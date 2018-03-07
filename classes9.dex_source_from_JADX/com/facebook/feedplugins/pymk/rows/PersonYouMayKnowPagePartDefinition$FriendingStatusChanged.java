package com.facebook.feedplugins.pymk.rows;

import com.facebook.content.event.FbEvent;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItemUtil;
import java.lang.ref.WeakReference;

/* compiled from: THREAD_VIEW_BANNER */
public class PersonYouMayKnowPagePartDefinition$FriendingStatusChanged<E extends HasInvalidate & HasPersistentState> extends FriendshipStatusChangedEventSubscriber {
    private final WeakReference<PeopleYouMayKnowFeedUnit> f24847a;
    private final WeakReference<PeopleYouMayKnowFeedUnitItem> f24848b;
    private final WeakReference<E> f24849c;

    public final void m26643b(FbEvent fbEvent) {
        FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
        PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit = (PeopleYouMayKnowFeedUnit) this.f24847a.get();
        PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem = (PeopleYouMayKnowFeedUnitItem) this.f24848b.get();
        HasInvalidate hasInvalidate = (HasInvalidate) this.f24849c.get();
        if (peopleYouMayKnowFeedUnit != null && peopleYouMayKnowFeedUnitItem != null && hasInvalidate != null && friendshipStatusChangedEvent != null && String.valueOf(friendshipStatusChangedEvent.a).equals(peopleYouMayKnowFeedUnitItem.l())) {
            FriendshipContextStateKey friendshipContextStateKey = new FriendshipContextStateKey(peopleYouMayKnowFeedUnitItem.l(), PeopleYouMayKnowFeedUnitItemUtil.a(peopleYouMayKnowFeedUnitItem));
            FriendshipPersistentState friendshipPersistentState = (FriendshipPersistentState) ((HasPersistentState) hasInvalidate).a(friendshipContextStateKey, peopleYouMayKnowFeedUnit);
            boolean z = friendshipPersistentState.f24684b;
            if (friendshipStatusChangedEvent.b != friendshipPersistentState.f24683a) {
                if (friendshipStatusChangedEvent.b == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                    z = false;
                }
                ((HasPersistentState) ((HasInvalidate) this.f24849c.get())).a(friendshipContextStateKey, new FriendshipPersistentState(friendshipStatusChangedEvent.b, z));
                ((HasInvalidate) this.f24849c.get()).a(new Object[]{peopleYouMayKnowFeedUnit});
            }
        }
    }

    public PersonYouMayKnowPagePartDefinition$FriendingStatusChanged(WeakReference<PeopleYouMayKnowFeedUnit> weakReference, WeakReference<PeopleYouMayKnowFeedUnitItem> weakReference2, WeakReference<E> weakReference3) {
        this.f24847a = weakReference;
        this.f24848b = weakReference2;
        this.f24849c = weakReference3;
    }
}
