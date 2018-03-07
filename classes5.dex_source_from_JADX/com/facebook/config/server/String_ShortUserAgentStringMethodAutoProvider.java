package com.facebook.config.server;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidProductionConfig;

/* compiled from: sentry_warning_with_user_confirmation_required */
public class String_ShortUserAgentStringMethodAutoProvider extends AbstractProvider<String> {
    private static String m3972b(InjectorLike injectorLike) {
        return ServerConfigModule.e((ServerConfig) FbandroidProductionConfig.a(injectorLike));
    }

    public Object get() {
        return ServerConfigModule.e((ServerConfig) FbandroidProductionConfig.a(this));
    }
}
