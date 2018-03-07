package com.facebook.groups.editfavorites.event;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;

/* compiled from: ad_gen */
public abstract class GroupFavoriteStatusEventSubscriber extends FbEventSubscriber<GroupFavoriteStatusEvent> {
    public abstract void mo260a(GroupFavoriteStatusEvent groupFavoriteStatusEvent);

    public /* synthetic */ void mo261b(FbEvent fbEvent) {
        mo260a((GroupFavoriteStatusEvent) fbEvent);
    }

    public final Class<GroupFavoriteStatusEvent> m10457a() {
        return GroupFavoriteStatusEvent.class;
    }
}
