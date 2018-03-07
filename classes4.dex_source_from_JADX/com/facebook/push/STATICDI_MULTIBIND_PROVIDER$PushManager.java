package com.facebook.push;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.push.adm.ADMPushManager;
import com.facebook.push.c2dm.C2dmPushManager;
import com.facebook.push.fbns.FbnsPushManager;
import com.facebook.push.fbnslite.FbnsLitePushManager;
import com.facebook.push.nna.NNAPushManager;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$PushManager implements MultiBindIndexedProvider<PushManager>, Provider<Set<PushManager>> {
    private final InjectorLike f10189a;

    public STATICDI_MULTIBIND_PROVIDER$PushManager(InjectorLike injectorLike) {
        this.f10189a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10189a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ADMPushManager.m10704a(injector);
            case 1:
                return C2dmPushManager.m10942a(injector);
            case 2:
                return FbnsPushManager.m10980a(injector);
            case 3:
                return FbnsLitePushManager.m10988a(injector);
            case 4:
                return NNAPushManager.m11007a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
