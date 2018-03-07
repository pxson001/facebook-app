package com.facebook.funnellogger.beacon;

import com.facebook.analytics2.beacon.idgenerator.BeaconIdGenerator;
import javax.annotation.Nullable;

/* compiled from: dbl */
public enum BeaconLogger$BeaconType {
    FUNNEL_STARTED("funnel_started"),
    FUNNEL_ENDED("funnel_ended"),
    FUNNEL_CANCELLED("funnel_cancelled");
    
    @Nullable
    BeaconIdGenerator beaconIdGenerator;
    String name;

    private BeaconLogger$BeaconType(String str) {
        this.name = str;
        this.beaconIdGenerator = null;
    }
}
