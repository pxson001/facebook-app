package com.facebook.controller.mutation.gk;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: newContactPoint */
public class ControllerMutationGatekeepers {
    private final GatekeeperStoreImpl f12382a;

    public static ControllerMutationGatekeepers m18449b(InjectorLike injectorLike) {
        return new ControllerMutationGatekeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ControllerMutationGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12382a = gatekeeperStoreImpl;
    }

    public final boolean m18450a() {
        return this.f12382a.m2189a(655, false);
    }

    public final boolean m18451b() {
        return !m18450a();
    }

    public static ControllerMutationGatekeepers m18448a(InjectorLike injectorLike) {
        return m18449b(injectorLike);
    }
}
