package com.facebook.composer.controller;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: hpp_body */
public class ComposerPublishButtonGeneratorProvider extends AbstractAssistedProvider<ComposerPublishButtonGenerator> {
    public final <DataProvider extends ProvidesConfiguration & ProvidesFacecastInfo & ProvidesPluginPublishButtonTextGetter & ProvidesTargetData & ProvidesPublishMode> ComposerPublishButtonGenerator<DataProvider> m7726a(DataProvider dataProvider) {
        return new ComposerPublishButtonGenerator((ProvidesConfiguration) dataProvider, ResourcesMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 494), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
