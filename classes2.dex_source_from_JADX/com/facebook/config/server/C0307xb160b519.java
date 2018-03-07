package com.facebook.config.server;

import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidProductionConfig;

/* compiled from: requests_in_flight_snapshot */
public class C0307xb160b519 extends AbstractProvider<PlatformAppHttpConfig> {
    public static PlatformAppHttpConfig m11748a(InjectorLike injectorLike) {
        return ServerConfigModule.m11753b(FbandroidProductionConfig.m9456a(injectorLike));
    }

    public Object get() {
        return ServerConfigModule.m11753b(FbandroidProductionConfig.m9456a(this));
    }
}
