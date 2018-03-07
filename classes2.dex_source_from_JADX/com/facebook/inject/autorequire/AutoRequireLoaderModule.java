package com.facebook.inject.autorequire;

import com.facebook.common.process.PrivateProcessName;
import com.facebook.inject.AbstractPrivateModule;

/* compiled from: zero_optin */
public class AutoRequireLoaderModule extends AbstractPrivateModule {
    private final PrivateProcessName f534a;

    public AutoRequireLoaderModule(PrivateProcessName privateProcessName) {
        this.f534a = privateProcessName;
    }

    protected void configure() {
        AutoRequireModuleLoader.m1442a(this.f534a, this.mBinder);
    }
}
