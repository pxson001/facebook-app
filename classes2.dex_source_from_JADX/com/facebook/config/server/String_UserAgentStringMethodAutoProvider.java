package com.facebook.config.server;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidProductionConfig;

/* compiled from: refresh_mode */
public class String_UserAgentStringMethodAutoProvider extends AbstractProvider<String> {
    public static String m12348b(InjectorLike injectorLike) {
        return ServerConfigModule.m11755d(FbandroidProductionConfig.m9456a(injectorLike));
    }

    public Object get() {
        return ServerConfigModule.m11755d(FbandroidProductionConfig.m9456a(this));
    }

    public static String m12347a(InjectorLike injectorLike) {
        return m12348b(injectorLike);
    }
}
