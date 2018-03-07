package com.facebook.location;

import android.location.Location;
import android.location.LocationManager;
import com.facebook.common.android.LocationManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus.State;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: sms_takeover_enable_stickers */
public class FbLocationCache {
    private static final ImmutableSet<String> f4540a = ImmutableSet.of("gps", "network");
    private final FbLocationStatusUtil f4541b;
    private final LocationManager f4542c;
    private final LocationAgeUtil f4543d;
    private ImmutableLocation f4544e = null;

    public static FbLocationCache m8244b(InjectorLike injectorLike) {
        return new FbLocationCache(FbLocationStatusUtil.m8253a(injectorLike), LocationManagerMethodAutoProvider.m8262b(injectorLike), LocationAgeUtil.m8265a(injectorLike));
    }

    @Inject
    public FbLocationCache(FbLocationStatusUtil fbLocationStatusUtil, LocationManager locationManager, LocationAgeUtil locationAgeUtil) {
        this.f4541b = fbLocationStatusUtil;
        this.f4542c = locationManager;
        this.f4543d = locationAgeUtil;
    }

    public static FbLocationCache m8243a(InjectorLike injectorLike) {
        return m8244b(injectorLike);
    }

    @Nullable
    public final ImmutableLocation m8245a() {
        return m8247a(Long.MAX_VALUE, Float.MAX_VALUE);
    }

    @Nullable
    public final ImmutableLocation m8246a(long j) {
        return m8247a(j, Float.MAX_VALUE);
    }

    @Nullable
    public final ImmutableLocation m8247a(long j, float f) {
        boolean z = true;
        Preconditions.checkArgument(j > 0);
        if (f <= 0.0f) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (this.f4541b.m8257a() != State.OKAY) {
            return null;
        }
        Location location;
        ImmutableLocation immutableLocation = this.f4544e;
        if (immutableLocation == null || this.f4543d.m8269a(immutableLocation) > j || ((Float) immutableLocation.m11986c().get()).floatValue() > f) {
            location = null;
        } else {
            location = immutableLocation.m11995l();
        }
        Iterator it = f4540a.iterator();
        Location location2 = location;
        while (it.hasNext()) {
            try {
                location = this.f4542c.getLastKnownLocation((String) it.next());
                if (location != null && LocationValidityUtil.m11965a(location)) {
                    if (this.f4543d.m8268a(location) > j || location.getAccuracy() > f || (location2 != null && location2.getTime() >= location.getTime())) {
                        location = location2;
                    }
                    location2 = location;
                }
            } catch (SecurityException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
        return ImmutableLocation.m11981b(location2);
    }

    final void m8248a(ImmutableLocation immutableLocation) {
        ImmutableLocation immutableLocation2 = this.f4544e;
        if (immutableLocation2 == null || ((Long) immutableLocation.m11990g().get()).longValue() > ((Long) immutableLocation2.m11990g().get()).longValue()) {
            this.f4544e = immutableLocation;
        }
    }
}
