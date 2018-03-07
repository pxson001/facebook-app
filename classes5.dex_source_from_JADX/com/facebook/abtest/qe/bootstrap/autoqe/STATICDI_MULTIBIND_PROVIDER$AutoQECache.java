package com.facebook.abtest.qe.bootstrap.autoqe;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.appdiscovery.lite.abtest.AutoQECacheForLiteAbTestModule;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.instantshopping.abtest.AutoQECacheForInstantShoppingAbtestModule;
import com.facebook.sideloading.AutoQECacheForSideloadingModule;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$AutoQECache implements MultiBindIndexedProvider<AutoQECache>, Provider<Set<AutoQECache>> {
    private final InjectorLike f1699a;

    public STATICDI_MULTIBIND_PROVIDER$AutoQECache(InjectorLike injectorLike) {
        this.f1699a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1699a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AutoQECacheForLiteAbTestModule.a(injector);
            case 1:
                return AutoQECacheForInstantShoppingAbtestModule.a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return AutoQECacheForSideloadingModule.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
