package com.facebook.composer.controller;

import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.controller.ComposerSubmitEnabledController.NonModelDataProvider;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.util.ComposerTagComparatorProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesHasPrivacyChanged;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsSubmitGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginHasUserEditedContentGetter;

/* compiled from: heading_type */
public class ComposerSubmitEnabledControllerProvider extends AbstractAssistedProvider<ComposerSubmitEnabledController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesHasPrivacyChanged & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPluginAllowsSubmitGetter & ProvidesPluginHasUserEditedContentGetter & ProvidesPrivacyData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesMinutiae> ComposerSubmitEnabledController<DataProvider> m7749a(DataProvider dataProvider, NonModelDataProvider nonModelDataProvider) {
        return new ComposerSubmitEnabledController((ProvidesAttachments) dataProvider, nonModelDataProvider, (ComposerTagComparatorProvider) getOnDemandAssistedProviderForStaticDi(ComposerTagComparatorProvider.class));
    }
}
