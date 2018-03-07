package com.facebook.dialtone;

import com.facebook.analytics.feature.FeatureCode;
import com.facebook.analytics.feature.FeatureStatus;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unread */
public class DialtoneFeatureStatus extends FeatureStatus {
    private Provider<Boolean> f567a;

    @Inject
    public DialtoneFeatureStatus(Provider<Boolean> provider) {
        this.f567a = provider;
    }

    public final FeatureCode mo60a() {
        return FeatureCode.DIALTONE;
    }

    public final String mo61b() {
        return "dialtone";
    }

    public final boolean mo62c() {
        return ((Boolean) this.f567a.get()).booleanValue();
    }
}
