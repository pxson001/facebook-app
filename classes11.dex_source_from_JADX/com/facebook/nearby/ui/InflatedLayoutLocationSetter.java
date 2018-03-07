package com.facebook.nearby.ui;

import android.location.Location;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.Locations;
import com.facebook.maps.MapsLocationUtils;
import com.facebook.view.inflation.DynamicLayoutInflater;
import javax.inject.Inject;

/* compiled from: topPageSelected */
public class InflatedLayoutLocationSetter {
    private static final Class<?> f779a = InflatedLayoutLocationSetter.class;
    private final MapsLocationUtils f780b;

    /* compiled from: topPageSelected */
    public class InflatedLayoutLocationSetterException extends IllegalArgumentException {
    }

    public static InflatedLayoutLocationSetter m1064b(InjectorLike injectorLike) {
        return new InflatedLayoutLocationSetter(MapsLocationUtils.b(injectorLike));
    }

    @Inject
    public InflatedLayoutLocationSetter(MapsLocationUtils mapsLocationUtils) {
        this.f780b = mapsLocationUtils;
    }

    public final void m1065a(DynamicLayoutInflater dynamicLayoutInflater, View view, Location location, Location location2) {
        try {
            Integer a = dynamicLayoutInflater.a("place_distance");
            if (a != null) {
                View a2 = m1063a(view, a.intValue());
                if (a2 == null || !(a2 instanceof TextView)) {
                    throw new InflatedLayoutLocationSetterException();
                }
                ((TextView) a2).setText(this.f780b.a(location2, Locations.a(location.getLatitude(), location.getLongitude())));
            }
        } catch (Exception e) {
            BLog.a(f779a, "caught %s, message = %s", new Object[]{e.getClass(), e.getMessage()});
            throw new InflatedLayoutLocationSetterException();
        }
    }

    private View m1063a(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return view.getId() != i ? null : view;
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            View findViewById = viewGroup.findViewById(i);
            if (findViewById != null) {
                return findViewById;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View a = m1063a(viewGroup.getChildAt(i2), i);
                if (a != null) {
                    return a;
                }
            }
            return null;
        }
    }
}
