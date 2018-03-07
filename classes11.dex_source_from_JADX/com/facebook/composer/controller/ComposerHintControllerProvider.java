package com.facebook.composer.controller;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.controller.ComposerHintController.Delegate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginStatusHintGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: implicit_location_disabled */
public class ComposerHintControllerProvider extends AbstractAssistedProvider<ComposerHintController> {
    public final <DataProvider extends ProvidesConfiguration & ProvidesContentType & ProvidesPluginStatusHintGetter> ComposerHintController<DataProvider> m7721a(DataProvider dataProvider, Delegate delegate) {
        return new ComposerHintController((ProvidesConfiguration) dataProvider, delegate, ResourcesMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
