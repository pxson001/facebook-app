package com.facebook.config.server;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.http.config.PlatformAppHttpConfig;

/* compiled from: sequence */
public class PresenceAwarePlatformHttpConfig extends DelegatingPlatformAppHttpConfig {
    private final AppStateManager f5568a;
    private final String f5569b;
    private final String f5570c = (this.f5569b + " FBBK/1");

    public PresenceAwarePlatformHttpConfig(PlatformAppHttpConfig platformAppHttpConfig, AppStateManager appStateManager, String str) {
        super(platformAppHttpConfig);
        this.f5568a = appStateManager;
        this.f5569b = str;
    }

    public final String mo1366h() {
        if (this.f5568a.m2262j()) {
            return this.f5570c;
        }
        return this.f5569b;
    }
}
