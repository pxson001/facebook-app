package com.facebook.config.server;

import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidProductionConfig;

/* compiled from: requested_afro_faceweb */
public class C0308x7c2db9b2 extends AbstractProvider<PlatformAppHttpConfig> {
    public static PlatformAppHttpConfig m11757a(InjectorLike injectorLike) {
        return ServerConfigModule.m11754c(FbandroidProductionConfig.m9456a(injectorLike));
    }

    public Object get() {
        return ServerConfigModule.m11754c(FbandroidProductionConfig.m9456a(this));
    }
}
