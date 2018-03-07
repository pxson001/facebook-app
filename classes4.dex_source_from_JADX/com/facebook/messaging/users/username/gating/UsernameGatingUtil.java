package com.facebook.messaging.users.username.gating;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: getCallbacks */
public class UsernameGatingUtil {
    private final GatekeeperStoreImpl f11203a;

    public static UsernameGatingUtil m11627b(InjectorLike injectorLike) {
        return new UsernameGatingUtil(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UsernameGatingUtil(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f11203a = gatekeeperStoreImpl;
    }

    public final boolean m11628a() {
        return this.f11203a.a(913, false);
    }
}
