package com.facebook.common.activitylistener;

import com.facebook.auth.module.MyListenerMethodAutoProvider;
import com.facebook.bugreporter.ActivityListenerMethodAutoProvider;
import com.facebook.common.appstate.MyActivityListenerMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionModule;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.iorg.common.upsell.activity.ZeroInterstitialActivityListener;
import com.facebook.katana.app.module.FacebookActivityDelegateMethodAutoProvider;
import com.facebook.katana.ui.CustomMenuController;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbActivityListener implements MultiBindIndexedProvider<FbActivityListener>, Provider<Set<FbActivityListener>> {
    private final InjectorLike f3837a;

    public STATICDI_MULTIBIND_PROVIDER$FbActivityListener(InjectorLike injectorLike) {
        this.f3837a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3837a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 7;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return MyListenerMethodAutoProvider.m6438a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ActivityListenerMethodAutoProvider.m6440b(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return MyActivityListenerMethodAutoProvider.m6464a(injector);
            case 3:
                return UserInteractionModule.m6469a(DefaultUserInteractionController.m1747a((InjectorLike) injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return ZeroInterstitialActivityListener.m6470a(injector);
            case 5:
                return FacebookActivityDelegateMethodAutoProvider.m6473a(injector);
            case 6:
                return CustomMenuController.m6514a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
