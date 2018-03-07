package com.facebook.notes.gk;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: is_secure */
public class NotesGatekeepers {
    private final GatekeeperStoreImpl f18887a;

    public static NotesGatekeepers m26566b(InjectorLike injectorLike) {
        return new NotesGatekeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public NotesGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f18887a = gatekeeperStoreImpl;
    }

    public final boolean m26567a() {
        return this.f18887a.m2189a(24, false);
    }

    public static NotesGatekeepers m26565a(InjectorLike injectorLike) {
        return m26566b(injectorLike);
    }
}
