package com.facebook.http.common;

import com.facebook.http.config.SocketConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: regStatus */
public class SocketConfigMethodAutoProvider extends AbstractProvider<SocketConfig> {
    public static DefaultSocketConfig m12343b(InjectorLike injectorLike) {
        return FbHttpModule.m12162a(TriState_IsReducedTimeoutEnabledGatekeeperAutoProvider.m12344b(injectorLike));
    }

    public Object get() {
        return FbHttpModule.m12162a(TriState_IsReducedTimeoutEnabledGatekeeperAutoProvider.m12344b(this));
    }
}
