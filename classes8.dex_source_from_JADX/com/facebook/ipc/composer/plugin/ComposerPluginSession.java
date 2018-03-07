package com.facebook.ipc.composer.plugin;

import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.36;
import com.facebook.composer.activity.ComposerFragment.5;
import com.google.common.base.Preconditions;

/* compiled from: unknown text view attribute =  */
public class ComposerPluginSession {
    public final ComposerDataProviderImpl f1139a;
    public final 36 f1140b;
    public final 5 f1141c;

    public ComposerPluginSession(ComposerDataProviderImpl composerDataProviderImpl, 36 36, 5 5) {
        this.f1139a = (ComposerDataProviderImpl) Preconditions.checkNotNull(composerDataProviderImpl);
        this.f1140b = (36) Preconditions.checkNotNull(36);
        this.f1141c = (5) Preconditions.checkNotNull(5);
    }

    public final ComposerDataProviderImpl m1370a() {
        return this.f1139a;
    }
}
