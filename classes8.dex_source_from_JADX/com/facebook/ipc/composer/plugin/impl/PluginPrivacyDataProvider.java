package com.facebook.ipc.composer.plugin.impl;

import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.DataProvider;

/* compiled from: unknown relative layout attribute =  */
public class PluginPrivacyDataProvider implements DataProvider {
    ComposerDataProviderImpl f1143a;

    public PluginPrivacyDataProvider(ComposerDataProviderImpl composerDataProviderImpl) {
        this.f1143a = composerDataProviderImpl;
    }

    public final boolean m1371a() {
        return this.f1143a.w();
    }

    public final boolean m1372b() {
        return this.f1143a.u.b();
    }

    public final boolean m1373c() {
        return this.f1143a.ag() == null || this.f1143a.ag().d;
    }
}
