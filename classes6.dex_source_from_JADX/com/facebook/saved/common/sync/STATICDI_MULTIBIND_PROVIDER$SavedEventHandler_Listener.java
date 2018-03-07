package com.facebook.saved.common.sync;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.saved.common.sync.SavedEventHandler.Listener;
import com.facebook.saved.data.SavedDashboardPrefetcher;
import com.facebook.saved.loader.SavedDashboardItemLoader;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$SavedEventHandler_Listener implements MultiBindIndexedProvider<Listener>, Provider<Set<Listener>> {
    private final InjectorLike f4868a;

    public STATICDI_MULTIBIND_PROVIDER$SavedEventHandler_Listener(InjectorLike injectorLike) {
        this.f4868a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4868a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new SavedDashboardPrefetcher(SavedDashboardItemLoader.b(injector), DefaultAndroidThreadUtil.b(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
