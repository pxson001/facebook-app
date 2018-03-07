package com.facebook.zero.sdk.ui;

import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.token.AbstractZeroTokenManager;
import com.facebook.zero.service.FbZeroTokenManager;
import javax.inject.Inject;

/* compiled from: com.android.internal.os.BatteryStatsImpl$Uid$Wakelock */
public class ZeroContentInterstitialController {
    private static final Class<?> f5907a = ZeroContentInterstitialController.class;
    private final AbstractZeroTokenManager f5908b;

    private static ZeroContentInterstitialController m10704b(InjectorLike injectorLike) {
        return new ZeroContentInterstitialController((AbstractZeroTokenManager) FbZeroTokenManager.b(injectorLike));
    }

    @Inject
    public ZeroContentInterstitialController(AbstractZeroTokenManager abstractZeroTokenManager) {
        this.f5908b = abstractZeroTokenManager;
    }
}
