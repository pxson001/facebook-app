package com.facebook.messaging.business.common.calltoaction;

import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsManager;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsUriHandler;
import com.facebook.messaging.business.ride.helper.RideOauthHelper;
import com.facebook.messaging.business.ride.uri.RideOrderUriHandler;
import com.facebook.messaging.business.ride.uri.RidePromoUriHandler;
import com.facebook.messaging.business.ride.utils.RideshareUtil;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$BusinessUriHandler implements MultiBindIndexedProvider<BusinessUriHandler>, Provider<Set<BusinessUriHandler>> {
    private final InjectorLike f8732a;

    public STATICDI_MULTIBIND_PROVIDER$BusinessUriHandler(InjectorLike injectorLike) {
        this.f8732a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8732a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MessengerExtensionsUriHandler(MessengerExtensionsManager.a(injector), (SecureContextHelper) DefaultSecureContextHelper.a(injector));
            case 1:
                return new RideOrderUriHandler(RideOauthHelper.m9729b((InjectorLike) injector), RideshareUtil.m9769a((InjectorLike) injector));
            case 2:
                return RidePromoUriHandler.m9758b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
