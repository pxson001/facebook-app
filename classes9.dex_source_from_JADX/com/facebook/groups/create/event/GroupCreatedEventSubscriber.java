package com.facebook.groups.create.event;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;

/* compiled from: payments_state_appear */
public abstract class GroupCreatedEventSubscriber extends FbEventSubscriber<GroupCreatedEvent> {
    public abstract void mo272a(GroupCreatedEvent groupCreatedEvent);

    public /* synthetic */ void mo273b(FbEvent fbEvent) {
        mo272a((GroupCreatedEvent) fbEvent);
    }

    public final Class<GroupCreatedEvent> m7104a() {
        return GroupCreatedEvent.class;
    }
}
