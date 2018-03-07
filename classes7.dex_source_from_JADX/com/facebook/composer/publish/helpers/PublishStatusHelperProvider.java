package com.facebook.composer.publish.helpers;

import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingDataSpec.ProvidesComposerSessionLoggingData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsBackoutDraft;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsUserSelectedTags;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMarketplaceId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocation.ProvidesViewerCoordinates;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;

/* compiled from: contacts_upload_friend_finder */
public class PublishStatusHelperProvider extends AbstractAssistedProvider<PublishStatusHelper> {
    public final <DataProvider extends ProvidesAppAttribution & ProvidesIsBackoutDraft & ProvidesIsFeedOnlyPost & ProvidesIsImplicitLocationSupported & ProvidesIsUserSelectedTags & ProvidesMarketplaceId & ProvidesPublishScheduleTime & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesViewerCoordinates & ProvidesLocationInfo & ProvidesPageData & ProvidesPrivacyData & ProvidesComposerSessionLoggingData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> PublishStatusHelper<DataProvider> m20847a(DataProvider dataProvider, PublishAttachmentsHelper publishAttachmentsHelper, OptimisticPostHelper optimisticPostHelper) {
        PublishStatusHelper<DataProvider> publishStatusHelper = new PublishStatusHelper((ComposerDataProviderImpl) dataProvider, publishAttachmentsHelper, optimisticPostHelper, FbDataConnectionManager.a(this), (Clock) SystemClockMethodAutoProvider.a(this));
        publishStatusHelper.f16864a = IdBasedProvider.a(this, 3595);
        return publishStatusHelper;
    }
}
