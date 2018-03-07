package com.facebook.rapidfeedback;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: fake review publish break */
public class RapidFeedbackGatekeepers {
    private final GatekeeperStoreImpl f15361a;

    public static RapidFeedbackGatekeepers m22986b(InjectorLike injectorLike) {
        return new RapidFeedbackGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RapidFeedbackGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f15361a = gatekeeperStoreImpl;
    }

    public final boolean m22987a() {
        return this.f15361a != null && this.f15361a.a(883, false);
    }
}
