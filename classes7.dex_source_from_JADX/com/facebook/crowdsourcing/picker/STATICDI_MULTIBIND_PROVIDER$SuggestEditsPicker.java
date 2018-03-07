package com.facebook.crowdsourcing.picker;

import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$SuggestEditsPicker implements MultiBindIndexedProvider<SuggestEditsPicker>, Provider<Set<SuggestEditsPicker>> {
    private final InjectorLike f17450a;

    public STATICDI_MULTIBIND_PROVIDER$SuggestEditsPicker(InjectorLike injectorLike) {
        this.f17450a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f17450a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CategoryPicker(IdBasedProvider.a(injector, 12));
            case 1:
                return new CityPicker(IdBasedProvider.a(injector, 12));
            case 2:
                return new HoursPicker(IdBasedProvider.a(injector, 12), HoursDataHelper.m21326b((InjectorLike) injector));
            case 3:
                return PhotoPicker.m21353a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
