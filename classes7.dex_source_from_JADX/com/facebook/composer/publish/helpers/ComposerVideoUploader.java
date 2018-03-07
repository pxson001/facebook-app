package com.facebook.composer.publish.helpers;

import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsUserSelectedTags;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMarketplaceId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: context_item_edit_click */
public class ComposerVideoUploader {
    @Inject
    @LoggedInUser
    public volatile Provider<User> f16817a = UltralightRuntime.a;
    private final MediaItemFactory f16818b;
    private final AbstractFbErrorReporter f16819c;
    private final UploadOperationFactory f16820d;
    public final UploadManager f16821e;

    public static ComposerVideoUploader m20818b(InjectorLike injectorLike) {
        ComposerVideoUploader composerVideoUploader = new ComposerVideoUploader(MediaItemFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UploadOperationFactory.b(injectorLike), UploadManager.a(injectorLike));
        composerVideoUploader.f16817a = IdBasedProvider.a(injectorLike, 3595);
        return composerVideoUploader;
    }

    @Inject
    private ComposerVideoUploader(MediaItemFactory mediaItemFactory, AbstractFbErrorReporter abstractFbErrorReporter, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager) {
        this.f16818b = mediaItemFactory;
        this.f16819c = abstractFbErrorReporter;
        this.f16820d = uploadOperationFactory;
        this.f16821e = uploadManager;
    }

    public final <DataProvider extends ProvidesAppAttribution & ProvidesAttachments & ProvidesIsFeedOnlyPost & ProvidesIsUserSelectedTags & ProvidesMarketplaceId & ProvidesPublishScheduleTime & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesLocationInfo & ProvidesPageData & ProvidesPrivacyData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> UploadOperation m20819a(DataProvider dataProvider) {
        long parseLong = Long.parseLong(((User) this.f16817a.get()).d());
        long j = ((ProvidesTargetData) dataProvider).s().targetId;
        VideoItem videoItem = null;
        ComposerAttachment f = AttachmentUtils.f(((ProvidesAttachments) dataProvider).m());
        if (!(f == null || f.b() == null)) {
            videoItem = (VideoItem) f.b();
        }
        String a = MentionsUtils.a(((ProvidesTextWithEntities) dataProvider).ae());
        ImmutableList a2 = ComposerTagUtil.a(((ProvidesTaggedUsers) dataProvider).h());
        String ab = ((ProvidesSessionId) dataProvider).ab();
        PublishMode j2 = ((ProvidesPublishMode) dataProvider).j();
        Long Y = ((ComposerDataProviderImpl) dataProvider).Y();
        if (videoItem == null) {
            this.f16819c.b("video upload error", StringFormatUtil.formatStrLocaleSafe("Null VideoItem"));
            return null;
        }
        ImmutableList a3 = TopicFeedsHelper.m20848a((ProvidesTopics) dataProvider);
        if (parseLong == j || j <= 0) {
            return this.f16820d.a(videoItem, AttachmentUtils.h(((ProvidesAttachments) dataProvider).m()), a, MinutiaeObject.a(((ProvidesMinutiae) dataProvider).l()), new PhotoUploadPrivacy(((ProvidesPrivacyData) dataProvider).ag().m1946a()), a2, ((ProvidesLocationInfo) dataProvider).g().j(), ((ProvidesLocationInfo) dataProvider).g().c(), ((ProvidesLocationInfo) dataProvider).g().d(), ((ProvidesRedSpaceValue) dataProvider).k(), ab, dataProvider.a(), ((ComposerDataProviderImpl) dataProvider).T(), ((ProvidesLocationInfo) dataProvider).g().a() != null, ((ProvidesConfiguration) dataProvider).o().getSourceType().toString(), a3, ((ComposerDataProviderImpl) dataProvider).E());
        } else if (((ComposerDataProviderImpl) dataProvider).p() == null || ((ComposerDataProviderImpl) dataProvider).p().getPostAsPageViewerContext() == null) {
            return this.f16820d.a(videoItem, AttachmentUtils.h(((ProvidesAttachments) dataProvider).m()), j, ((ProvidesTargetData) dataProvider).s().targetType.toString(), a, MinutiaeObject.a(((ProvidesMinutiae) dataProvider).l()), a2, ((ProvidesLocationInfo) dataProvider).g().j(), ((ProvidesLocationInfo) dataProvider).g().a() != null, ((ProvidesLocationInfo) dataProvider).g().c(), ((ProvidesLocationInfo) dataProvider).g().d(), ((ProvidesRedSpaceValue) dataProvider).k(), ab, ((ProvidesProductItemAttachment) dataProvider).i(), ((ComposerDataProviderImpl) dataProvider).U(), ((ProvidesConfiguration) dataProvider).o().getSourceType().toString(), a3);
        } else {
            return this.f16820d.a(videoItem, AttachmentUtils.h(((ProvidesAttachments) dataProvider).m()), j, a, MinutiaeObject.a(((ProvidesMinutiae) dataProvider).l()), ((ProvidesLocationInfo) dataProvider).g().j(), ((ProvidesLocationInfo) dataProvider).g().a() != null, ((ProvidesLocationInfo) dataProvider).g().c(), ((ProvidesLocationInfo) dataProvider).g().d(), ((ProvidesRedSpaceValue) dataProvider).k(), j2, Y, ab, ((ComposerDataProviderImpl) dataProvider).p().getPostAsPageViewerContext(), ((ProvidesConfiguration) dataProvider).o().getSourceType().toString(), a3);
        }
    }
}
