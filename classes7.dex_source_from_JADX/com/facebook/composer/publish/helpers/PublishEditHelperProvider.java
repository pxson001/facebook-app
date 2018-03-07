package com.facebook.composer.publish.helpers;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.util.ComposerTagComparatorProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPrivacyOverride;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;

/* compiled from: content_time_offset */
public class PublishEditHelperProvider extends AbstractAssistedProvider<PublishEditHelper> {
    public final <DataProvider extends ProvidesAttachments & ProvidesPrivacyOverride & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesLocationInfo & ProvidesPrivacyData & ProvidesShareParams & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment> PublishEditHelper<DataProvider> m20839a(DataProvider dataProvider, OptimisticPostHelper optimisticPostHelper) {
        return new PublishEditHelper((ProvidesAttachments) dataProvider, optimisticPostHelper, (ComposerTagComparatorProvider) getOnDemandAssistedProviderForStaticDi(ComposerTagComparatorProvider.class), ComposerAnalyticsLogger.a(this), (Clock) SystemClockMethodAutoProvider.a(this), UploadOperationFactory.b(this), UploadManager.a(this), MediaItemFactory.b(this));
    }
}
