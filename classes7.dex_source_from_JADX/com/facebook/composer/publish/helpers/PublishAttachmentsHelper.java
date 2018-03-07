package com.facebook.composer.publish.helpers;

import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.Builder;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
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
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.FaceBoxStoreCopy;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TagStoreCopy;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: contextItemRows */
public class PublishAttachmentsHelper<DataProvider extends ProvidesAppAttribution & ProvidesAttachments & ProvidesIsFeedOnlyPost & ProvidesIsImplicitLocationSupported & ProvidesIsUserSelectedTags & ProvidesMarketplaceId & ProvidesPublishScheduleTime & ProvidesSessionId & ProvidesTargetAlbum & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesContentType & ProvidesLocationInfo & ProvidesPageData & ProvidesPrivacyData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> {
    @Inject
    @LoggedInUser
    public volatile Provider<User> f16827a = UltralightRuntime.a;
    private final DataProvider f16828b;
    private final ComposerVideoUploader f16829c;
    private final Clock f16830d;
    private final UploadOperationFactory f16831e;
    private final AbstractFbErrorReporter f16832f;
    private final TagStore f16833g;
    private final FaceBoxStore f16834h;
    private final UploadManager f16835i;
    private final Toaster f16836j;
    private final FbSharedPreferences f16837k;
    private final Photos360QEHelper f16838l;
    private long f16839m = -1;
    private ImmutableList<ComposerAttachment> f16840n;
    public GraphQLTextWithEntities f16841o;

    @Inject
    public PublishAttachmentsHelper(@Assisted DataProvider dataProvider, ComposerVideoUploader composerVideoUploader, Clock clock, Toaster toaster, UploadOperationFactory uploadOperationFactory, FbErrorReporter fbErrorReporter, TagStore tagStore, FaceBoxStore faceBoxStore, UploadManager uploadManager, FbSharedPreferences fbSharedPreferences, Photos360QEHelper photos360QEHelper) {
        this.f16828b = dataProvider;
        this.f16829c = composerVideoUploader;
        this.f16830d = clock;
        this.f16836j = toaster;
        this.f16831e = uploadOperationFactory;
        this.f16832f = fbErrorReporter;
        this.f16833g = tagStore;
        this.f16834h = faceBoxStore;
        this.f16835i = uploadManager;
        this.f16840n = AttachmentUtils.a(((ProvidesAttachments) this.f16828b).m());
        this.f16841o = ((ProvidesTextWithEntities) this.f16828b).ae();
        this.f16837k = fbSharedPreferences;
        this.f16838l = photos360QEHelper;
    }

    public final boolean m20829a() {
        if (m20827f()) {
            return true;
        }
        if (!AttachmentUtils.k(((ProvidesAttachments) this.f16828b).m()) && !AttachmentUtils.i(((ProvidesAttachments) this.f16828b).m())) {
            return false;
        }
        if (AttachmentUtils.k(((ProvidesAttachments) this.f16828b).m())) {
            Editor edit = this.f16837k.edit();
            edit.a(FeedPrefKeys.u, this.f16830d.a());
            edit.commit();
        }
        if (((ProvidesIsImplicitLocationSupported) this.f16828b).G() || ((ProvidesLocationInfo) this.f16828b).g().a() != null) {
            this.f16839m = ((ProvidesLocationInfo) this.f16828b).g().j();
        }
        if (((ProvidesTargetAlbum) this.f16828b).ad() != null) {
            this.f16840n = m20825a(this.f16840n, this.f16841o);
            this.f16841o = GraphQLHelper.h;
        } else if (this.f16840n.size() == 1 && !StringUtil.a(((ComposerAttachment) this.f16840n.get(0)).d().a())) {
            int i = (StringUtil.a(this.f16841o.a()) || StringUtil.a(((ComposerAttachment) this.f16840n.get(0)).d().a())) ? 0 : 1;
            if (i != 0) {
                this.f16841o = GraphQLHelper.a(this.f16841o, GraphQLHelper.a("\n"));
            }
            this.f16841o = GraphQLHelper.a(this.f16841o, ((ComposerAttachment) this.f16840n.get(0)).d());
            Builder a = Builder.a((ComposerAttachment) this.f16840n.get(0));
            a.d = GraphQLHelper.h;
            this.f16840n = ImmutableList.of(a.a());
        }
        return true;
    }

    @Nullable
    public final UploadOperation m20830c() {
        if (!m20827f()) {
            String composerSourceType;
            long parseLong = Long.parseLong(((User) this.f16827a.get()).d());
            ImmutableList a = ComposerTagUtil.a(((ProvidesTaggedUsers) this.f16828b).h());
            if (((ProvidesConfiguration) this.f16828b).o().getSourceType() != ComposerSourceType.UNKNOWN) {
                composerSourceType = ((ProvidesConfiguration) this.f16828b).o().getSourceType().toString();
            } else {
                composerSourceType = ((ProvidesConfiguration) this.f16828b).o().getLaunchLoggingParams().getSourceSurface().toString();
            }
            if (((ProvidesTargetAlbum) this.f16828b).ad() != null) {
                if (((ProvidesTargetData) this.f16828b).s().a()) {
                    return this.f16831e.a(AttachmentUtils.o(this.f16840n), AttachmentUtils.p(this.f16840n), Long.parseLong(((ProvidesTargetAlbum) this.f16828b).ad().u()), MentionsUtils.a(this.f16841o), ((ProvidesSessionId) this.f16828b).ab(), ((ComposerPageData) Preconditions.checkNotNull(this.f16828b.p())).getPostAsPageViewerContext(), composerSourceType);
                }
                return m20826e();
            } else if (((ProvidesTargetData) this.f16828b).s().targetId == parseLong) {
                r14 = AttachmentUtils.o(this.f16840n);
                r15 = AttachmentUtils.p(this.f16840n);
                r13 = this.f16831e;
                String a2 = MentionsUtils.a(this.f16841o);
                MinutiaeTag a3 = MinutiaeObject.a(((ProvidesMinutiae) this.f16828b).l());
                PhotoUploadPrivacy photoUploadPrivacy = new PhotoUploadPrivacy(((ProvidesPrivacyData) this.f16828b).ag().m1946a());
                r20 = this.f16839m;
                String c = ((ProvidesLocationInfo) this.f16828b).g().c();
                boolean d = ((ProvidesLocationInfo) this.f16828b).g().d();
                RedSpaceValue k = ((ProvidesRedSpaceValue) this.f16828b).k();
                boolean z = AttachmentUtils.r(this.f16840n) && this.f16838l.i();
                return r13.a(r14, r15, a2, a3, photoUploadPrivacy, a, r20, c, d, k, z, AttachmentUtils.s(this.f16840n), ((ProvidesSessionId) this.f16828b).ab(), this.f16828b.a(), this.f16828b.T(), ((ProvidesLocationInfo) this.f16828b).g().a() != null, composerSourceType, AttachmentUtils.l(this.f16840n), TopicFeedsHelper.m20848a((ProvidesTopics) this.f16828b), this.f16828b.E());
            } else if (((ProvidesTargetData) this.f16828b).s().targetId <= 0 || this.f16840n.size() <= 0) {
                this.f16832f.b("photo upload error", StringFormatUtil.formatStrLocaleSafe("Unsupported upload type target=%d, user=%d, attach=%s", Long.valueOf(((ProvidesTargetData) this.f16828b).s().targetId), Long.valueOf(parseLong), Integer.valueOf(this.f16840n.size())));
                return null;
            } else if (!((ProvidesTargetData) this.f16828b).s().a() && (this.f16828b.p() == null || this.f16828b.p().getPostAsPageViewerContext() == null)) {
                UploadOperationFactory uploadOperationFactory = this.f16831e;
                ImmutableList o = AttachmentUtils.o(this.f16840n);
                ImmutableList p = AttachmentUtils.p(this.f16840n);
                long j = ((ProvidesTargetData) this.f16828b).s().targetId;
                String targetType = ((ProvidesTargetData) this.f16828b).s().targetType.toString();
                String a4 = MentionsUtils.a(this.f16841o);
                MinutiaeTag a5 = MinutiaeObject.a(((ProvidesMinutiae) this.f16828b).l());
                long j2 = this.f16839m;
                boolean z2 = ((ProvidesLocationInfo) this.f16828b).g().a() != null;
                String c2 = ((ProvidesLocationInfo) this.f16828b).g().c();
                boolean d2 = ((ProvidesLocationInfo) this.f16828b).g().d();
                RedSpaceValue k2 = ((ProvidesRedSpaceValue) this.f16828b).k();
                boolean z3 = AttachmentUtils.r(this.f16840n) && this.f16838l.i();
                return uploadOperationFactory.a(o, p, j, targetType, a4, a5, a, j2, z2, c2, d2, k2, z3, AttachmentUtils.s(this.f16840n), ((ProvidesSessionId) this.f16828b).ab(), ((ProvidesProductItemAttachment) this.f16828b).i(), this.f16828b.U(), composerSourceType, AttachmentUtils.l(this.f16840n), TopicFeedsHelper.m20848a((ProvidesTopics) this.f16828b));
            } else if (((ProvidesContentType) this.f16828b).c() == ComposerContentType.SLIDESHOW) {
                return this.f16831e.a(AttachmentUtils.o(this.f16840n), AttachmentUtils.p(this.f16840n), ((ProvidesTargetData) this.f16828b).s().targetId, MentionsUtils.a(this.f16841o), MinutiaeObject.a(((ProvidesMinutiae) this.f16828b).l()), this.f16839m, ((ProvidesSessionId) this.f16828b).ab(), this.f16828b.p().getPostAsPageViewerContext(), ((ProvidesPublishMode) this.f16828b).j(), ((ComposerDataProviderImpl) this.f16828b).Y() != null ? this.f16828b.Y().longValue() : 0, null, composerSourceType, ((ProvidesLocationInfo) this.f16828b).g().a() != null, TopicFeedsHelper.m20848a((ProvidesTopics) this.f16828b));
            } else {
                r13 = this.f16831e;
                r14 = AttachmentUtils.o(this.f16840n);
                r15 = AttachmentUtils.p(this.f16840n);
                long j3 = ((ProvidesTargetData) this.f16828b).s().targetId;
                String a6 = MentionsUtils.a(this.f16841o);
                MinutiaeTag a7 = MinutiaeObject.a(((ProvidesMinutiae) this.f16828b).l());
                r20 = this.f16839m;
                ((ProvidesLocationInfo) this.f16828b).g().c();
                boolean d3 = ((ProvidesLocationInfo) this.f16828b).g().d();
                RedSpaceValue k3 = ((ProvidesRedSpaceValue) this.f16828b).k();
                boolean z4 = AttachmentUtils.r(this.f16840n) && this.f16838l.i();
                return r13.a(r14, r15, j3, a6, a7, r20, d3, k3, z4, AttachmentUtils.s(this.f16840n), ((ProvidesSessionId) this.f16828b).ab(), this.f16828b.p().getPostAsPageViewerContext(), ((ProvidesPublishMode) this.f16828b).j(), ((ComposerDataProviderImpl) this.f16828b).Y() != null ? this.f16828b.Y().longValue() : 0, null, composerSourceType, ((ProvidesLocationInfo) this.f16828b).g().a() != null, AttachmentUtils.l(this.f16840n), TopicFeedsHelper.m20848a((ProvidesTopics) this.f16828b));
            }
        } else if (((ProvidesTargetAlbum) this.f16828b).ad() == null || ((ProvidesTargetData) this.f16828b).s().a()) {
            return this.f16829c.m20819a(this.f16828b);
        } else {
            return m20826e();
        }
    }

    private UploadOperation m20826e() {
        UploadOperationFactory uploadOperationFactory = this.f16831e;
        ImmutableList o = AttachmentUtils.o(this.f16840n);
        ImmutableList p = AttachmentUtils.p(this.f16840n);
        String a = MentionsUtils.a(this.f16841o);
        long parseLong = Long.parseLong(((ProvidesTargetAlbum) this.f16828b).ad().u());
        ImmutableList a2 = ComposerTagUtil.a(((ProvidesTaggedUsers) this.f16828b).h());
        long j = this.f16839m;
        String c = ((ProvidesLocationInfo) this.f16828b).g().c();
        boolean d = ((ProvidesLocationInfo) this.f16828b).g().d();
        RedSpaceValue k = ((ProvidesRedSpaceValue) this.f16828b).k();
        boolean z = AttachmentUtils.r(this.f16840n) && this.f16838l.i();
        return uploadOperationFactory.a(o, p, a, parseLong, a2, j, c, d, k, z, AttachmentUtils.s(this.f16840n), ((ProvidesSessionId) this.f16828b).ab(), this.f16828b.a(), this.f16828b.T(), ((ProvidesLocationInfo) this.f16828b).g().a() != null, ((ProvidesConfiguration) this.f16828b).o().getSourceType().toString(), AttachmentUtils.i(this.f16840n), TopicFeedsHelper.m20848a((ProvidesTopics) this.f16828b), this.f16828b.E());
    }

    public final void m20828a(UploadOperation uploadOperation) {
        if (m20827f() && ((ProvidesTargetAlbum) this.f16828b).ad() == null && uploadOperation.r == Type.VIDEO) {
            this.f16829c.f16821e.a(uploadOperation);
            return;
        }
        Preconditions.checkNotNull(uploadOperation);
        List arrayList = new ArrayList();
        ImmutableList immutableList = uploadOperation.a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if (mediaItem.m() == MediaType.PHOTO) {
                arrayList.add(mediaItem.d());
            }
        }
        uploadOperation.a(TagStoreCopy.a(this.f16833g, arrayList), FaceBoxStoreCopy.a(this.f16834h, arrayList));
        this.f16835i.a(uploadOperation);
    }

    private static ImmutableList<ComposerAttachment> m20825a(ImmutableList<ComposerAttachment> immutableList, GraphQLTextWithEntities graphQLTextWithEntities) {
        int i;
        int i2 = 0;
        Preconditions.checkArgument(!immutableList.isEmpty());
        ImmutableList.Builder builder = ImmutableList.builder();
        ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(0);
        if (StringUtil.a(composerAttachment.d().a()) || StringUtil.a(graphQLTextWithEntities.a())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            graphQLTextWithEntities = GraphQLHelper.a(graphQLTextWithEntities, GraphQLHelper.a("\n"));
        }
        GraphQLTextWithEntities a = GraphQLHelper.a(graphQLTextWithEntities, composerAttachment.d());
        Builder a2 = Builder.a((ComposerAttachment) immutableList.get(0));
        a2.d = a;
        Builder builder2 = a2;
        builder2.e = ((ComposerAttachment) immutableList.get(0)).e();
        builder.c(builder2.a());
        ImmutableList subList = immutableList.subList(1, immutableList.size());
        i = subList.size();
        while (i2 < i) {
            builder.c((ComposerAttachment) subList.get(i2));
            i2++;
        }
        return builder.b();
    }

    public final void m20831d() {
        int i;
        if (AttachmentUtils.m(((ProvidesAttachments) this.f16828b).m())) {
            if (AttachmentUtils.d(((ProvidesAttachments) this.f16828b).m())) {
                i = 2131234577;
            } else if (((ProvidesAttachments) this.f16828b).m().size() > 1) {
                i = 2131234550;
            } else {
                i = 2131234549;
            }
        } else if (m20827f()) {
            i = 2131234551;
        } else if (AttachmentUtils.l(((ProvidesAttachments) this.f16828b).m())) {
            i = 2131234552;
        } else {
            return;
        }
        this.f16836j.b(new ToastBuilder(i));
    }

    private boolean m20827f() {
        return AttachmentUtils.n(((ProvidesAttachments) this.f16828b).m());
    }
}
