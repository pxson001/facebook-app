package com.facebook.composer.capability;

import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cover photo loaded */
public class ComposerRedSpaceCapability {
    private final QeAccessor f16700a;

    @Inject
    public ComposerRedSpaceCapability(QeAccessor qeAccessor) {
        this.f16700a = qeAccessor;
    }

    public final boolean m20732b(@Nullable ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter, ComposerConfiguration composerConfiguration, TargetType targetType, boolean z) {
        if ((targetType == TargetType.UNDIRECTED || targetType == TargetType.USER) && !composerConfiguration.isEdit()) {
            return (composerPluginGetters$BooleanGetter == null || composerPluginGetters$BooleanGetter.mo1301a()) && !z && this.f16700a.a(ExperimentsForRedSpaceExperimentsModule.h, false) && this.f16700a.a(ExperimentsForRedSpaceExperimentsModule.b, false);
        } else {
            return false;
        }
    }
}
