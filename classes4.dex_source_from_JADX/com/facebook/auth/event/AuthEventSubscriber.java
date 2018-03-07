package com.facebook.auth.event;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;

/* compiled from: unseen */
public abstract class AuthEventSubscriber<T extends AuthEvent> extends FbEventSubscriber<T> {
    public abstract void mo58a(T t);

    public /* synthetic */ void mo59b(FbEvent fbEvent) {
        mo58a((AuthEvent) fbEvent);
    }
}
