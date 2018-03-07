package com.facebook.placetips.pulsarcore;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import javax.inject.Inject;

/* compiled from: method/user.createMessengerOnlyAccount */
public class PulsarLocationStatusChecker {
    private final Lazy<FbLocationStatusUtil> f13558a;

    public static PulsarLocationStatusChecker m19945b(InjectorLike injectorLike) {
        return new PulsarLocationStatusChecker(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2483));
    }

    @Inject
    public PulsarLocationStatusChecker(Lazy<FbLocationStatusUtil> lazy) {
        this.f13558a = lazy;
    }

    public final boolean m19946a() {
        FbLocationStatus b = ((FbLocationStatusUtil) this.f13558a.get()).m8259b();
        if (b == null) {
            return false;
        }
        return b.f15655a == State.OKAY;
    }
}
