package com.facebook.places.features;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
@Deprecated
/* compiled from: former_participants */
public class PlacesFeatures {
    private static PlacesFeatures f14705b;
    private static final Object f14706c = new Object();
    private final Provider<Boolean> f14707a;

    private static PlacesFeatures m22268b(InjectorLike injectorLike) {
        return new PlacesFeatures(IdBasedProvider.a(injectorLike, 4261));
    }

    @Inject
    public PlacesFeatures(Provider<Boolean> provider) {
        this.f14707a = provider;
    }

    public final boolean m22269a() {
        return ((Boolean) this.f14707a.get()).booleanValue();
    }

    public static PlacesFeatures m22267a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlacesFeatures b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14706c) {
                PlacesFeatures placesFeatures;
                if (a2 != null) {
                    placesFeatures = (PlacesFeatures) a2.a(f14706c);
                } else {
                    placesFeatures = f14705b;
                }
                if (placesFeatures == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22268b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14706c, b3);
                        } else {
                            f14705b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placesFeatures;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
