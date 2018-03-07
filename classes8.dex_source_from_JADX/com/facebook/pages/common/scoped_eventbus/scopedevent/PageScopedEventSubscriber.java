package com.facebook.pages.common.scoped_eventbus.scopedevent;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.google.common.base.Preconditions;

/* compiled from: creditCardNumber */
public abstract class PageScopedEventSubscriber<ID, T extends PageScopedEvent<ID>> extends FbEventSubscriber<T> {
    public final ID f16573a;

    public final boolean m19597a(FbEvent fbEvent) {
        return this.f16573a != null && this.f16573a.equals(((PageScopedEvent) fbEvent).f16571a);
    }

    public PageScopedEventSubscriber(ID id) {
        Preconditions.checkNotNull(id);
        this.f16573a = id;
    }
}
