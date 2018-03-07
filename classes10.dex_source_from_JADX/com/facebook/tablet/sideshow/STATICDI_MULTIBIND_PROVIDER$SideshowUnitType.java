package com.facebook.tablet.sideshow;

import com.facebook.events.sideshow.EventsSideshowUnitType;
import com.facebook.groups.sideshow.RecentActiveGroupsSideshowUnitType;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.tablet.sideshow.ads.AdsSideshowUnitType;
import com.facebook.tablet.sideshow.example.ExampleSideshowUnitType;
import com.facebook.tablet.sideshow.nux.NuxSideshowUnitType;
import com.facebook.tablet.sideshow.pymk.PeopleYouMayKnowSideshowUnitType;
import com.facebook.tablet.sideshow.pyml.PagesYouMayLikeSideshowUnitType;
import com.facebook.tablet.sideshow.trending.TrendingSideshowUnitType;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: return_scopes */
public final class STATICDI_MULTIBIND_PROVIDER$SideshowUnitType implements MultiBindIndexedProvider<SideshowUnitType>, Provider<Set<SideshowUnitType>> {
    private final InjectorLike f10100a;

    public STATICDI_MULTIBIND_PROVIDER$SideshowUnitType(InjectorLike injectorLike) {
        this.f10100a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10100a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 8;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return EventsSideshowUnitType.a(injector);
            case 1:
                return RecentActiveGroupsSideshowUnitType.m410a((InjectorLike) injector);
            case 2:
                return AdsSideshowUnitType.a(injector);
            case 3:
                return ExampleSideshowUnitType.a(injector);
            case 4:
                return NuxSideshowUnitType.a(injector);
            case 5:
                return PeopleYouMayKnowSideshowUnitType.a(injector);
            case 6:
                return PagesYouMayLikeSideshowUnitType.a(injector);
            case 7:
                return TrendingSideshowUnitType.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
