package com.facebook.composer.capability;

import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.qe.api.QeAccessor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: createAndProcessCoreModulesPackage */
public class ComposerHeaderCapability {
    public final Lazy<QeAccessor> f16690a;

    @Inject
    public ComposerHeaderCapability(Lazy<QeAccessor> lazy) {
        this.f16690a = lazy;
    }

    public final boolean m20720b(@Nullable ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        return m20721c(composerPluginGetters$BooleanGetter) && ((QeAccessor) this.f16690a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.V, false);
    }

    public final boolean m20721c(@Nullable ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        return (composerPluginGetters$BooleanGetter == null || composerPluginGetters$BooleanGetter.mo1301a()) && ((QeAccessor) this.f16690a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.Q, false);
    }
}
