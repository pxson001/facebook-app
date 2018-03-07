package com.facebook.location;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* compiled from:  ·  */
public class LocationSignalThrowablePackage {
    @Nullable
    public final Throwable f72a;
    @Nullable
    public final Throwable f73b;

    public LocationSignalThrowablePackage(@Nullable Throwable th, @Nullable Throwable th2) {
        this.f72a = th;
        this.f73b = th2;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("location_manager_throwable", this.f72a).add("wifi_scan_throwable", this.f73b).toString();
    }
}
