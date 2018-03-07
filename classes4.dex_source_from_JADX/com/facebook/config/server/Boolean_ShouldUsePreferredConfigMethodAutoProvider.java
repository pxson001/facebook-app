package com.facebook.config.server;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;

/* compiled from: has_default_privacy */
public class Boolean_ShouldUsePreferredConfigMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ServerConfigModule.a(Boolean_IsInternalPrefsEnabledMethodAutoProvider.a(this), (FbAppType) getInstance(FbAppType.class));
    }
}
