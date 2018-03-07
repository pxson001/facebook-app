package com.facebook.config.server;

import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidProductionConfig;

/* compiled from: render_complete */
public class PlatformAppHttpConfigMethodAutoProvider extends AbstractProvider<PlatformAppHttpConfig> {
    public static PlatformAppHttpConfig m12160b(InjectorLike injectorLike) {
        return ServerConfigModule.m11749a((ServerConfig) FbandroidProductionConfig.m9456a(injectorLike));
    }

    public Object get() {
        return ServerConfigModule.m11749a((ServerConfig) FbandroidProductionConfig.m9456a(this));
    }
}
