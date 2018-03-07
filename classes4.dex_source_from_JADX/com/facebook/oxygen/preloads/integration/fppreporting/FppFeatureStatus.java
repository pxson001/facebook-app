package com.facebook.oxygen.preloads.integration.fppreporting;

import com.facebook.analytics.feature.PeriodicFeatureStatus;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresence;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;

/* compiled from: group_post_mention */
public class FppFeatureStatus extends PeriodicFeatureStatus {
    private final PreloadSdkPresence f10948a;

    @Inject
    public FppFeatureStatus(PreloadSdkPresence preloadSdkPresence) {
        this.f10948a = preloadSdkPresence;
    }

    public final String mo61b() {
        return "fpp_available";
    }

    public final boolean mo62c() {
        return this.f10948a.b();
    }

    public final JsonNode mo829a() {
        return null;
    }
}
