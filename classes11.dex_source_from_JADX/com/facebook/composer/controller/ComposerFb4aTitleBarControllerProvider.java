package com.facebook.composer.controller;

import android.content.Context;
import android.view.ViewStub;
import com.facebook.composer.controller.ComposerFb4aTitleBarController.Delegate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesCanSubmit;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPostCompositionOverlayShowing;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPostCompositionViewSupported;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginTitleGetter;

/* compiled from: initial fetch */
public class ComposerFb4aTitleBarControllerProvider extends AbstractAssistedProvider<ComposerFb4aTitleBarController> {
    public final <DataProvider extends ProvidesTargetData & ProvidesPluginPublishButtonTextGetter & ProvidesPluginTitleGetter & ProvidesConfiguration & ProvidesCanSubmit & ProvidesIsPostCompositionOverlayShowing & ProvidesIsPostCompositionViewSupported & ProvidesFacecastInfo & ProvidesPublishMode & ProvidesRedSpaceValue> ComposerFb4aTitleBarController<DataProvider> m7717a(ViewStub viewStub, DataProvider dataProvider, ComposerMenuCreator composerMenuCreator, Delegate delegate) {
        return new ComposerFb4aTitleBarController(viewStub, (ProvidesTargetData) dataProvider, composerMenuCreator, delegate, (Context) getInstance(Context.class), ComposerTitleGenerator.m7751b(this), (ComposerPublishButtonGeneratorProvider) getOnDemandAssistedProviderForStaticDi(ComposerPublishButtonGeneratorProvider.class));
    }
}
