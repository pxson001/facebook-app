package com.facebook.composer.publish.helpers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsUserSelectedTags;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMarketplaceId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.ui.toaster.Toaster;

/* compiled from: context must not be null */
public class PublishAttachmentsHelperProvider extends AbstractAssistedProvider<PublishAttachmentsHelper> {
    public final <DataProvider extends ProvidesAppAttribution & ProvidesAttachments & ProvidesIsFeedOnlyPost & ProvidesIsImplicitLocationSupported & ProvidesIsUserSelectedTags & ProvidesMarketplaceId & ProvidesPublishScheduleTime & ProvidesSessionId & ProvidesTargetAlbum & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesContentType & ProvidesLocationInfo & ProvidesPageData & ProvidesPrivacyData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> PublishAttachmentsHelper<DataProvider> m20832a(DataProvider dataProvider) {
        PublishAttachmentsHelper<DataProvider> publishAttachmentsHelper = new PublishAttachmentsHelper((ComposerDataProviderImpl) dataProvider, ComposerVideoUploader.m20818b(this), (Clock) SystemClockMethodAutoProvider.a(this), Toaster.b(this), UploadOperationFactory.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TagStore.a(this), FaceBoxStore.a(this), UploadManager.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), Photos360QEHelper.a(this));
        publishAttachmentsHelper.f16827a = IdBasedProvider.a(this, 3595);
        return publishAttachmentsHelper;
    }
}
