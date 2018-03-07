package com.facebook.placetips.gpscore;

import com.facebook.location.ImmutableLocation;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import javax.annotation.Nullable;

/* compiled from: TimelineAppSectionUrlBuilder_nullCollectionsPeek */
public class PlaceTipsGpsHelper {
    public static PresenceSource m11092a(@Nullable ImmutableLocation immutableLocation) {
        if (immutableLocation == null) {
            return PresenceSource.a(PresenceSourceType.GPS);
        }
        return PresenceSource.a(immutableLocation.a(), immutableLocation.b(), (Float) immutableLocation.c().orNull());
    }
}
