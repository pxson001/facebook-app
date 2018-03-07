package com.facebook.feed.xconfig;

import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;

/* compiled from: prefetch_duration_ms */
public class VpvStrippedTrackingDataXConfigController {
    private final XConfigReader f9241a;
    private ImmutableSet<String> f9242b = null;

    @Inject
    public VpvStrippedTrackingDataXConfigController(XConfigReader xConfigReader) {
        this.f9241a = xConfigReader;
    }

    public final ImmutableSet<String> m14179a() {
        if (this.f9242b == null) {
            ImmutableSet immutableSet;
            String a = this.f9241a.m2685a(VpvStrippedTrackingDataXConfig.c, null);
            if (a == null) {
                immutableSet = RegularImmutableSet.f688a;
            } else {
                immutableSet = ImmutableSet.copyOf(a.split("\\s*,\\s*"));
            }
            this.f9242b = immutableSet;
        }
        return this.f9242b;
    }
}
