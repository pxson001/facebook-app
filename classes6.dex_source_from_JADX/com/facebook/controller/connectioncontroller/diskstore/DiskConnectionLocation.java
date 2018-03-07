package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.google.common.base.Preconditions;

/* compiled from: optout */
public class DiskConnectionLocation extends ConnectionLocation {
    public final String f8614b;

    public DiskConnectionLocation(String str, String str2, LocationType locationType, boolean z) {
        super(str2, locationType, z);
        this.f8614b = (String) Preconditions.checkNotNull(str);
    }

    public final String m12432d() {
        return this.f8614b;
    }
}
