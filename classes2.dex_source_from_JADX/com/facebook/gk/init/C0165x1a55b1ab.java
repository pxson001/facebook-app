package com.facebook.gk.init;

import com.facebook.breakpad.OnInitBreakpadFlagsControllerGKListenerRegistration;
import com.facebook.composer.shareintent.C0166x9d663795;
import com.facebook.deeplinking.C0167x82630536;
import com.facebook.dialtone.DialtoneController.OnInitDialtoneControllerGatekeeperListenerRegistration;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.urimap.C0168x226977e2;
import com.facebook.messaging.newphoto.NewPhotoIntentGatekeeperListenerRegistration;
import com.facebook.messaging.sms.SmsTakeoverKillSwitch$GatekeeperListenerRegistration;
import com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper.GatekeeperListenerRegistration;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.service.FbZeroTokenManager.OnInitZeroTokenManagerGatekeepersListenerRegistration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0165x1a55b1ab implements MultiBindIndexedProvider<INeedInitForGatekeepersListenerRegistration>, Provider<Set<INeedInitForGatekeepersListenerRegistration>> {
    private final InjectorLike f2422a;

    public C0165x1a55b1ab(InjectorLike injectorLike) {
        this.f2422a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2422a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 9;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new OnInitBreakpadFlagsControllerGKListenerRegistration(IdBasedLazy.m1808a(injector, 412));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return C0166x9d663795.m4621a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return C0167x82630536.m4624a(injector);
            case 3:
                return OnInitDialtoneControllerGatekeeperListenerRegistration.m4627a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return C0168x226977e2.m4630a(injector);
            case 5:
                return NewPhotoIntentGatekeeperListenerRegistration.m4633a(injector);
            case 6:
                return SmsTakeoverKillSwitch$GatekeeperListenerRegistration.m4657a(injector);
            case 7:
                return GatekeeperListenerRegistration.m4660a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return OnInitZeroTokenManagerGatekeepersListenerRegistration.m4663a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
