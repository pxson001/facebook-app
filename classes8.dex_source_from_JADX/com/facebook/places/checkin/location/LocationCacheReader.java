package com.facebook.places.checkin.location;

import android.location.Location;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.location.FbLocationCache;
import com.facebook.places.checkin.protocol.CheckinLocationCache;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cityguide */
public class LocationCacheReader {
    public static final long f18045a = TimeUnit.SECONDS.toMillis(300);
    public final CheckinLocationCache f18046b;
    public final FbLocationCache f18047c;
    private final PerfTestConfig f18048d;
    @Nullable
    public Location f18049e;
    public Location f18050f;
    public boolean f18051g = false;

    @Inject
    public LocationCacheReader(CheckinLocationCache checkinLocationCache, FbLocationCache fbLocationCache, PerfTestConfig perfTestConfig) {
        this.f18046b = checkinLocationCache;
        this.f18047c = fbLocationCache;
        this.f18048d = perfTestConfig;
    }
}
