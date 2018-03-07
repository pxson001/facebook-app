package com.facebook.maps;

import android.content.res.Resources;
import android.location.Location;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationDisplayUtil;
import com.facebook.location.LocationDisplayUtil.DistanceUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: watermarkTimestamp */
public class MapsLocationUtils {
    private final Resources f323a;
    private final LocationDisplayUtil f324b;

    public static MapsLocationUtils m276b(InjectorLike injectorLike) {
        return new MapsLocationUtils(new LocationDisplayUtil(ResourcesMethodAutoProvider.a(injectorLike)), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MapsLocationUtils(LocationDisplayUtil locationDisplayUtil, Resources resources) {
        this.f324b = locationDisplayUtil;
        this.f323a = resources;
    }

    public final String m278a(Location location, Location location2) {
        float[] fArr = new float[1];
        Location.distanceBetween(location.getLatitude(), location.getLongitude(), location2.getLatitude(), location2.getLongitude(), fArr);
        return m274a((double) fArr[0]);
    }

    @Nullable
    public final String m279a(ImmutableLocation immutableLocation, ImmutableLocation immutableLocation2, double d, @Nullable String str) {
        float[] fArr = new float[1];
        Location.distanceBetween(immutableLocation.a(), immutableLocation.b(), immutableLocation2.a(), immutableLocation2.b(), fArr);
        double d2 = (double) fArr[0];
        return d2 <= d ? m274a(d2) : str;
    }

    private String m274a(double d) {
        DistanceUnit distanceUnit;
        if (LocationDisplayUtil.f49a.contains(this.f324b.f50b.getConfiguration().locale.getCountry())) {
            distanceUnit = DistanceUnit.IMPERIAL;
        } else {
            distanceUnit = DistanceUnit.METRIC;
        }
        if (distanceUnit == DistanceUnit.IMPERIAL) {
            if (m275b(3.28084d * d) >= 1000) {
                return this.f323a.getString(2131230955, new Object[]{Double.valueOf(m277c(r0 / 5280.0d))});
            }
            return this.f323a.getString(2131230956, new Object[]{Integer.valueOf(r2)});
        }
        if (m275b(d) >= 1000) {
            return this.f323a.getString(2131230958, new Object[]{Double.valueOf(m277c(d / 1000.0d))});
        }
        return this.f323a.getString(2131230957, new Object[]{Integer.valueOf(r0)});
    }

    private static int m275b(double d) {
        double pow = Math.pow(10.0d, Math.floor(Math.log10(d)));
        return (int) (pow * ((double) Math.round(d / pow)));
    }

    private static double m277c(double d) {
        double pow = Math.pow(10.0d, Math.floor(Math.log10(d))) / 100.0d;
        return pow * ((double) Math.round(d / pow));
    }
}
