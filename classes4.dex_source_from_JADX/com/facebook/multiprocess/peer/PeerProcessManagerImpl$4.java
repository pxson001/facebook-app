package com.facebook.multiprocess.peer;

import com.facebook.auth.event.AuthEvent;
import com.facebook.auth.event.AuthEventSubscriber;
import com.facebook.auth.event.AuthLoggedInEvent;
import com.facebook.content.event.FbEvent;

/* compiled from: unseen_stories */
public class PeerProcessManagerImpl$4 extends AuthEventSubscriber<AuthLoggedInEvent> {
    final /* synthetic */ PeerProcessManagerImpl f542a;

    public PeerProcessManagerImpl$4(PeerProcessManagerImpl peerProcessManagerImpl) {
        this.f542a = peerProcessManagerImpl;
    }

    public final /* synthetic */ void mo58a(AuthEvent authEvent) {
        m837b();
    }

    public final /* bridge */ /* synthetic */ void mo59b(FbEvent fbEvent) {
        m837b();
    }

    private void m837b() {
        this.f542a.n.b(this.f542a.q);
        if (PeerProcessManagerImpl.c(this.f542a) == null) {
            this.f542a.e.a(PeerProcessManager.class.getSimpleName(), "userId is still null after AuthLoggedInEvent fired");
        }
    }

    public final Class<AuthLoggedInEvent> m838a() {
        return AuthLoggedInEvent.class;
    }
}
