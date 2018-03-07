package com.facebook.composer.publish.helpers;

import android.content.Intent;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.LinkEdit;
import com.facebook.composer.util.ComposerTagComparator;
import com.facebook.composer.util.ComposerTagComparatorProvider;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilder;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPrivacyOverride;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.OptimisticPostPrivacy;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.topics.protocol.TopicListHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: content_watching */
public class PublishEditHelper<DataProvider extends ProvidesAttachments & ProvidesPrivacyOverride & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesLocationInfo & ProvidesPrivacyData & ProvidesShareParams & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment> {
    public final DataProvider f16842a;
    public final ComposerTagComparator f16843b;
    private final OptimisticPostHelper f16844c;
    private final ComposerAnalyticsLogger f16845d;
    @Nullable
    public final MinutiaeTag f16846e;
    @Nullable
    public final ImmutableSet<Long> f16847f;
    @Nullable
    public final String f16848g;
    public final Clock f16849h;
    private final UploadOperationFactory f16850i;
    private final UploadManager f16851j;
    private final MediaItemFactory f16852k;

    @Inject
    public PublishEditHelper(@Assisted DataProvider dataProvider, @Assisted OptimisticPostHelper optimisticPostHelper, ComposerTagComparatorProvider composerTagComparatorProvider, ComposerAnalyticsLogger composerAnalyticsLogger, Clock clock, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager, MediaItemFactory mediaItemFactory) {
        MinutiaeTag minutiaeTag;
        ImmutableSet copyOf;
        String str;
        this.f16842a = dataProvider;
        this.f16844c = optimisticPostHelper;
        this.f16843b = ComposerTagComparatorProvider.m2086a(dataProvider);
        this.f16845d = composerAnalyticsLogger;
        if (!this.f16843b.m2083a()) {
            minutiaeTag = null;
        } else if (((ProvidesMinutiae) this.f16842a).l() == null) {
            minutiaeTag = MinutiaeTag.b;
        } else {
            minutiaeTag = ((ProvidesMinutiae) this.f16842a).l().d();
        }
        this.f16846e = minutiaeTag;
        if (this.f16843b.m2084b()) {
            copyOf = ImmutableSet.copyOf(ComposerTagUtil.a(((ProvidesTaggedUsers) this.f16842a).h()));
        } else {
            copyOf = null;
        }
        this.f16847f = copyOf;
        if (!this.f16843b.m2085c()) {
            str = null;
        } else if (((ProvidesLocationInfo) this.f16842a).g().j() == -1) {
            str = "0";
        } else {
            str = String.valueOf(((ProvidesLocationInfo) this.f16842a).g().j());
        }
        this.f16848g = str;
        this.f16849h = clock;
        this.f16850i = uploadOperationFactory;
        this.f16851j = uploadManager;
        this.f16852k = mediaItemFactory;
    }

    @VisibleForTesting
    private void m20836e() {
        if (((ProvidesConfiguration) this.f16842a).o().isEditTagEnabled()) {
            m20835a(Events.COMPOSER_EDIT_TAGS);
            if (this.f16846e != null) {
                if (((ProvidesMinutiae) this.f16842a).l() == null) {
                    m20835a(Events.COMPOSER_EDIT_REMOVE_MINUTIAE_TAG);
                } else if (((ProvidesConfiguration) this.f16842a).o().getMinutiaeObjectTag() == null) {
                    m20835a(Events.COMPOSER_EDIT_ADD_MINUTIAE_TAG);
                } else {
                    m20835a(Events.COMPOSER_EDIT_CHANGE_MINUTIAE_TAG);
                }
            }
            if (this.f16847f != null) {
                if (((ProvidesTaggedUsers) this.f16842a).h().isEmpty()) {
                    m20835a(Events.COMPOSER_EDIT_REMOVE_WITH_TAG);
                } else if (((ProvidesConfiguration) this.f16842a).o().getInitialTaggedUsers().isEmpty()) {
                    m20835a(Events.COMPOSER_EDIT_ADD_WITH_TAG);
                } else {
                    m20835a(Events.COMPOSER_EDIT_CHANGE_WITH_TAG);
                }
            }
            if (this.f16848g == null) {
                return;
            }
            if (((ProvidesLocationInfo) this.f16842a).g().j() == -1) {
                m20835a(Events.COMPOSER_EDIT_REMOVE_PLACE_TAG);
            } else if (((ProvidesConfiguration) this.f16842a).o().getInitialLocationInfo().a() == null) {
                m20835a(Events.COMPOSER_EDIT_ADD_PLACE_TAG);
            } else {
                m20835a(Events.COMPOSER_EDIT_CHANGE_PLACE_TAG);
            }
        }
    }

    private void m20835a(Events events) {
        this.f16845d.a(events, ((ProvidesSessionId) this.f16842a).ab());
    }

    public final Intent m20837a() {
        return m20838a(false);
    }

    public final Intent m20838a(boolean z) {
        ImmutableList immutableList;
        String str;
        m20836e();
        Builder builder = new Builder();
        if (this.f16842a.m() != null) {
            ImmutableList m = this.f16842a.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                ComposerAttachment composerAttachment = (ComposerAttachment) m.get(i);
                if (!MediaItemFactory.a(composerAttachment.c())) {
                    builder.c(String.valueOf(composerAttachment.b().d().b));
                }
            }
        }
        EditPostParams.Builder builder2 = new EditPostParams.Builder();
        builder2.a = ((ProvidesSessionId) this.f16842a).ab();
        builder2 = builder2;
        builder2.b = ((ProvidesConfiguration) this.f16842a).o().getLegacyApiStoryId();
        builder2 = builder2;
        builder2.c = ((ProvidesTextWithEntities) this.f16842a).ae();
        builder2 = builder2;
        builder2.d = ((ProvidesConfiguration) this.f16842a).o().getStoryId();
        builder2 = builder2;
        if (((ProvidesConfiguration) this.f16842a).o().getCacheId() == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.of(((ProvidesConfiguration) this.f16842a).o().getCacheId());
        }
        EditPostParams.Builder a = builder2.a(immutableList);
        a.f = this.f16846e;
        a = a;
        ImmutableSet immutableSet = this.f16847f;
        a.g = immutableSet == null ? null : ImmutableList.copyOf(immutableSet);
        a = a;
        a.h = this.f16848g;
        builder2 = a;
        builder2.j = ((ProvidesProductItemAttachment) this.f16842a).i();
        builder2 = builder2;
        SelectablePrivacyData selectablePrivacyData = ((ProvidesPrivacyData) this.f16842a).ag().f2001b;
        if (selectablePrivacyData == null) {
            str = null;
        } else {
            str = selectablePrivacyData.d();
        }
        builder2.i = str;
        a = builder2;
        a.k = z;
        a = a;
        a.l = this.f16849h.a() / 1000;
        builder2 = a;
        builder2.o = ((ProvidesTargetData) this.f16842a).s().targetId;
        builder2 = builder2;
        builder2.m = ((ProvidesConfiguration) this.f16842a).o().canViewerEditPostMedia();
        builder2 = builder2;
        if (!TopicListHelper.m19025a(((ProvidesConfiguration) this.f16842a).o().getTopics(), ((ProvidesTopics) this.f16842a).af())) {
            builder2.t = ((ProvidesTopics) this.f16842a).af();
        }
        ComposerShareParams q = ((ProvidesShareParams) this.f16842a).q();
        ComposerShareParams initialShareParams = ((ProvidesConfiguration) this.f16842a).o().getInitialShareParams();
        if (q == null && initialShareParams != null) {
            builder2.s = LinkEdit.a;
        } else if (!(q == null || StringUtil.a(q.linkForShare) || (initialShareParams != null && initialShareParams.linkForShare != null && initialShareParams.linkForShare.equals(q.linkForShare)))) {
            builder2.s = LinkEdit.a(q.linkForShare);
        }
        if (((ProvidesConfiguration) this.f16842a).o().canViewerEditPostMedia()) {
            builder2.n = builder.b();
            builder2.q = AttachmentUtils.q(this.f16842a.m());
        }
        EditPostParams a2 = builder2.a();
        Intent intent = new Intent();
        intent.putExtra("publishEditPostParamsKey", m20833a(a2, intent));
        if (this.f16844c.m20822a()) {
            intent.putExtra("extra_optimistic_feed_story", m20834a(a2));
        }
        return intent;
    }

    private GraphQLStory m20834a(EditPostParams editPostParams) {
        OptimisticPostStoryBuilder b = this.f16844c.m20823b();
        b.f3802B = ((ProvidesConfiguration) this.f16842a).o().getStoryId();
        b = b;
        b.f3807G = ((ProvidesConfiguration) this.f16842a).o().getLegacyApiStoryId();
        OptimisticPostStoryBuilder optimisticPostStoryBuilder = b;
        optimisticPostStoryBuilder.f3803C = GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        b = optimisticPostStoryBuilder;
        b.f3810J = ((ProvidesTopics) this.f16842a).af();
        b = b;
        ComposerPrivacyData ag = ((ProvidesPrivacyData) this.f16842a).ag();
        GraphQLPrivacyOption X = ((ComposerDataProviderImpl) this.f16842a).X();
        if (!((ag != null && ag.f2002c && ag.f2001b != null) || X == null || X.b() == null)) {
            b.f3834w = new OptimisticPostPrivacy(X.b().d(), X.d());
        }
        b.f3805E = editPostParams.storyId;
        return b.m4478a();
    }

    private EditPostParams m20833a(EditPostParams editPostParams, Intent intent) {
        if (((ProvidesConfiguration) this.f16842a).o().canViewerEditPostMedia()) {
            ImmutableList o = AttachmentUtils.o(this.f16842a.m());
            Builder builder = new Builder();
            int size = o.size();
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) o.get(i);
                if (MediaItemFactory.a(mediaItem.f())) {
                    builder.c(mediaItem);
                }
            }
            ImmutableList b = builder.b();
            if (!b.isEmpty()) {
                EditPostParams.Builder builder2 = new EditPostParams.Builder(editPostParams);
                builder2.p = true;
                this.f16851j.a(this.f16850i.a(b, null, editPostParams.composerSessionId, null, builder2.a()));
                intent.putExtra("is_uploading_media", true);
            }
        }
        return editPostParams;
    }
}
