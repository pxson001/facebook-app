package com.facebook.composer.publish.helpers;

import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilderProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsBackoutDraft;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: context_item_add_click */
public class OptimisticPostHelperProvider extends AbstractAssistedProvider<OptimisticPostHelper> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsBackoutDraft & ProvidesIsImplicitLocationSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesContentType & ProvidesLocationInfo & ProvidesPrivacyData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> OptimisticPostHelper<DataProvider> m20824a(DataProvider dataProvider, ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        return new OptimisticPostHelper((ProvidesAttachments) dataProvider, composerPluginGetters$BooleanGetter, IdBasedProvider.a(this, 3595), (OptimisticPostStoryBuilderProvider) getOnDemandAssistedProviderForStaticDi(OptimisticPostStoryBuilderProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
