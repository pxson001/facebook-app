package com.facebook.adinterfaces.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.UnitLocale;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Uninitialized session! */
public class MapPickerLocaleAwareGeoHelper {
    private static MapPickerLocaleAwareGeoHelper f23341f;
    private static final Object f23342g = new Object();
    public final MapPickerGeoHelperMetric f23343a;
    private final double f23344b;
    public final Resources f23345c;
    public final boolean f23346d;
    public String f23347e;

    private static MapPickerLocaleAwareGeoHelper m25282b(InjectorLike injectorLike) {
        return new MapPickerLocaleAwareGeoHelper(ResourcesMethodAutoProvider.a(injectorLike), LocaleMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MapPickerLocaleAwareGeoHelper(Resources resources, Locale locale) {
        this.f23345c = resources;
        this.f23346d = UnitLocale.from(locale) == UnitLocale.IMPERIAL;
        this.f23344b = this.f23346d ? 1609.344d : 1000.0d;
        this.f23343a = new MapPickerGeoHelperMetric(this.f23344b, this.f23346d ? 80467.2d : 80000.0d);
    }

    public final double m25283a(Projection projection, View view) {
        return Math.max(MapPickerGeoHelperMetric.m25279a(projection, view) / this.f23344b, 1.0d);
    }

    public static MapPickerLocaleAwareGeoHelper m25281a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MapPickerLocaleAwareGeoHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23342g) {
                MapPickerLocaleAwareGeoHelper mapPickerLocaleAwareGeoHelper;
                if (a2 != null) {
                    mapPickerLocaleAwareGeoHelper = (MapPickerLocaleAwareGeoHelper) a2.a(f23342g);
                } else {
                    mapPickerLocaleAwareGeoHelper = f23341f;
                }
                if (mapPickerLocaleAwareGeoHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25282b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23342g, b3);
                        } else {
                            f23341f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mapPickerLocaleAwareGeoHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final float m25284a(FacebookMap facebookMap, LatLng latLng, double d, int i) {
        return MapPickerGeoHelperMetric.m25280a(facebookMap, latLng, this.f23344b * d, i);
    }
}
