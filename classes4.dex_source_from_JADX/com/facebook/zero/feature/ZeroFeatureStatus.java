package com.facebook.zero.feature;

import com.facebook.analytics.feature.FeatureCode;
import com.facebook.analytics.feature.FeatureStatus;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unpause_upload */
public class ZeroFeatureStatus extends FeatureStatus {
    Provider<Boolean> f568a;

    @Inject
    public ZeroFeatureStatus(Provider<Boolean> provider) {
        this.f568a = provider;
    }

    public final FeatureCode mo60a() {
        return FeatureCode.ZERO_RATING;
    }

    public final String mo61b() {
        return "zero_rating";
    }

    public final boolean mo62c() {
        return ((Boolean) this.f568a.get()).booleanValue();
    }
}
