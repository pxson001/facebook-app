package com.facebook.interstitial.manager;

import com.facebook.common.init.INeedInit;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: TOPIC_BUSINESS_SERVICES */
public class UpgradeInterstitialOnAppUpgrade implements INeedInit {
    private static final Class<?> f13879a = UpgradeInterstitialOnAppUpgrade.class;
    private final Lazy<InterstitialManager> f13880b;

    @Inject
    public UpgradeInterstitialOnAppUpgrade(Lazy<InterstitialManager> lazy) {
        this.f13880b = lazy;
    }

    public void init() {
        ((InterstitialManager) this.f13880b.get()).b();
    }
}
