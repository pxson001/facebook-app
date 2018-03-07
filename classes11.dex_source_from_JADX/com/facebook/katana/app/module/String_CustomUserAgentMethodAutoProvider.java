package com.facebook.katana.app.module;

import com.facebook.config.server.ServerConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.katana.orca.FbandroidProductionConfig;

/* compiled from: UpcomingEventsDashboard */
public class String_CustomUserAgentMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return MainProcessModule.a((ServerConfig) FbandroidProductionConfig.a(this));
    }
}
