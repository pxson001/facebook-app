package com.facebook.friendsnearby.pingdialog.ui;

import com.facebook.friendsnearby.pingdialog.LocationPingTime;
import com.google.common.base.Preconditions;

/* compiled from: [[icon]] */
public class LocationPingOption {
    public final LocationPingTime f20657a;
    public final String f20658b;
    public final String f20659c;
    public final String f20660d;

    public LocationPingOption(LocationPingTime locationPingTime, String str, String str2, String str3) {
        this.f20657a = (LocationPingTime) Preconditions.checkNotNull(locationPingTime);
        this.f20658b = (String) Preconditions.checkNotNull(str);
        this.f20659c = (String) Preconditions.checkNotNull(str2);
        this.f20660d = (String) Preconditions.checkNotNull(str3);
    }
}
