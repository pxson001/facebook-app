package com.facebook.platform.composer.titlebar;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.platform.composer.composer.PlatformComposerFragment;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05317;

/* compiled from: result_id */
public class PlatformComposerTargetSelectorControllerProvider extends AbstractAssistedProvider<PlatformComposerTargetSelectorController> {
    public final PlatformComposerTargetSelectorController m4297a(PlatformComposerFragment platformComposerFragment, C05317 c05317) {
        return new PlatformComposerTargetSelectorController(new PlatformComposerTargetTypesBuilder(Boolean_IsWorkBuildMethodAutoProvider.a(this)), FunnelLoggerImpl.a(this), ResourcesMethodAutoProvider.a(this), Boolean_IsWorkBuildMethodAutoProvider.a(this), ComposerMultimediaCapability.b(this), platformComposerFragment, c05317);
    }
}
