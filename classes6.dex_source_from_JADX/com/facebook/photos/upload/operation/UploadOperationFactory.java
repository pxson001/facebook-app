package com.facebook.photos.upload.operation;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.publishing.graphql.CommerceProductItemMutateParams;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.graphql.model.GraphQLBudgetRecommendationData;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory$PhotoItemBuilder;
import com.facebook.photos.base.media.MediaItemFactory$VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingDataUtil;
import com.facebook.photos.upload.operation.UploadOperation.Builder;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@NotThreadSafe
/* compiled from: glUseProgram */
public class UploadOperationFactory {
    public final Provider<String> f13816a;
    public final Clock f13817b;
    public final MediaResourceHelper f13818c;
    private final Lazy<QeAccessor> f13819d;
    public final UploadOperationBitrateDecider f13820e;

    public static UploadOperationFactory m21557b(InjectorLike injectorLike) {
        return new UploadOperationFactory(IdBasedProvider.a(injectorLike, 4442), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219), MediaResourceHelper.a(injectorLike), UploadOperationBitrateDecider.m21551b(injectorLike));
    }

    public static UploadOperationFactory m21556a(InjectorLike injectorLike) {
        return m21557b(injectorLike);
    }

    @Inject
    public UploadOperationFactory(Provider<String> provider, Clock clock, Lazy<QeAccessor> lazy, MediaResourceHelper mediaResourceHelper, UploadOperationBitrateDecider uploadOperationBitrateDecider) {
        this.f13816a = provider;
        this.f13817b = clock;
        this.f13818c = mediaResourceHelper;
        this.f13819d = lazy;
        this.f13820e = uploadOperationBitrateDecider;
    }

    public final UploadOperation m21575a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, String str, MinutiaeTag minutiaeTag, PhotoUploadPrivacy photoUploadPrivacy, ImmutableList<Long> immutableList3, long j, @Nullable String str2, boolean z, RedSpaceValue redSpaceValue, boolean z2, @Nullable String str3, String str4, ComposerAppAttribution composerAppAttribution, boolean z3, boolean z4, String str5, boolean z5, ImmutableList<String> immutableList4, boolean z6) {
        Preconditions.checkNotNull(immutableList);
        PublishMethod publishMethod = z5 ? PublishMethod.MULTIMEDIA : immutableList.size() == 1 ? PublishMethod.SINGLE_PHOTO : PublishMethod.STATUS;
        return new Builder().m21465a(str4).m21464a(ImmutableList.copyOf(immutableList)).m21470b((ImmutableList) immutableList2).m21475c(ImmutableList.copyOf(immutableList3)).m21476c(str).m21456a(minutiaeTag).m21453a(Long.parseLong((String) this.f13816a.get())).m21480d("own_timeline").m21469b(j).m21483e(str2).m21466a(z).m21459a(redSpaceValue).m21472b(z2).m21486f(str3).m21462a(photoUploadPrivacy).m21460a(publishMethod).m21461a(Type.OWN_TIMELINE).m21478d(this.f13817b.a() / 1000).m21463a(composerAppAttribution).m21481d(z3).m21484e(z4).m21489g(str5).m21479d((ImmutableList) immutableList4).m21490g(z6).m21467a();
    }

    public final UploadOperation m21570a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, long j, String str, @Nullable MinutiaeTag minutiaeTag, long j2, boolean z, RedSpaceValue redSpaceValue, boolean z2, @Nullable String str2, String str3, ViewerContext viewerContext, PublishMode publishMode, long j3, GraphQLBudgetRecommendationData graphQLBudgetRecommendationData, String str4, boolean z3, boolean z4, ImmutableList<String> immutableList3) {
        Preconditions.checkNotNull(immutableList);
        PublishMethod publishMethod = PublishMethod.STATUS;
        String str5 = "own_page_timeline";
        if (immutableList.size() == 1 && (viewerContext == null || Long.parseLong(viewerContext.a()) != j)) {
            publishMethod = PublishMethod.TARGET;
            str5 = "target_as_target";
        } else if (immutableList.size() == 1 && (graphQLBudgetRecommendationData == null || Math.round(graphQLBudgetRecommendationData.j().a()) == 0)) {
            publishMethod = PublishMethod.SINGLE_PHOTO;
        } else if (z4) {
            publishMethod = PublishMethod.MULTIMEDIA;
        }
        return new Builder().m21465a(str3).m21464a(ImmutableList.copyOf(immutableList)).m21470b((ImmutableList) immutableList2).m21476c(str).m21456a(minutiaeTag).m21453a(j).m21480d(str5).m21469b(j2).m21466a(z).m21459a(redSpaceValue).m21472b(z2).m21486f(str2).m21462a(PhotoUploadPrivacy.f14023d).m21460a(publishMethod).m21461a(Type.TARGET).m21454a(viewerContext).m21478d(this.f13817b.a() / 1000).m21458a(publishMode).m21482e(j3).m21455a(graphQLBudgetRecommendationData).m21489g(str4).m21484e(z3).m21479d((ImmutableList) immutableList3).m21467a();
    }

    public final UploadOperation m21569a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, long j, String str, @Nullable MinutiaeTag minutiaeTag, long j2, String str2, ViewerContext viewerContext, PublishMode publishMode, long j3, GraphQLBudgetRecommendationData graphQLBudgetRecommendationData, String str3, boolean z, ImmutableList<String> immutableList3) {
        Preconditions.checkNotNull(immutableList);
        return new Builder().m21465a(str2).m21464a((ImmutableList) immutableList).m21470b((ImmutableList) immutableList2).m21476c(str).m21456a(minutiaeTag).m21453a(j).m21480d("own_page_timeline").m21469b(j2).m21462a(PhotoUploadPrivacy.f14023d).m21460a(PublishMethod.SLIDESHOW).m21461a(Type.TARGET).m21454a(viewerContext).m21478d(this.f13817b.a() / 1000).m21458a(publishMode).m21482e(j3).m21455a(graphQLBudgetRecommendationData).m21489g(str3).m21484e(z).m21479d((ImmutableList) immutableList3).m21467a();
    }

    public final UploadOperation m21562a(MediaItem mediaItem, @Nullable Bundle bundle, long j, String str, @Nullable MinutiaeTag minutiaeTag, long j2, boolean z, @Nullable String str2, boolean z2, RedSpaceValue redSpaceValue, PublishMode publishMode, @Nullable Long l, String str3, ViewerContext viewerContext, String str4, ImmutableList<String> immutableList) {
        Preconditions.checkNotNull(mediaItem);
        return new Builder().m21465a(str3).m21464a(ImmutableList.of(mediaItem)).m21470b(bundle == null ? null : ImmutableList.of(bundle)).m21476c(str).m21456a(minutiaeTag).m21453a(j).m21480d("own_page_timeline").m21469b(j2).m21484e(z).m21483e(str2).m21466a(z2).m21459a(redSpaceValue).m21458a(publishMode).m21482e(l != null ? l.longValue() : 0).m21462a(PhotoUploadPrivacy.f14023d).m21460a(PublishMethod.VIDEO_STATUS).m21461a(Type.VIDEO).m21454a(viewerContext).m21478d(this.f13817b.a() / 1000).m21489g(str4).m21477d(40).m21473c(this.f13820e.m21553a(bundle)).m21479d((ImmutableList) immutableList).m21467a();
    }

    public final UploadOperation m21571a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, long j, String str, String str2, ViewerContext viewerContext, String str3) {
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkArgument(j > 0);
        Builder builder = new Builder();
        builder.f13726a = str2;
        builder = builder;
        builder.f13727b = ImmutableList.copyOf(immutableList);
        builder = builder;
        builder.f13728c = immutableList2;
        builder = builder;
        builder.f13730e = str;
        builder = builder.m21453a(j);
        builder.f13733h = "own_page_album";
        builder = builder.m21469b(-1);
        builder.f13740o = PhotoUploadPrivacy.f14023d;
        builder = builder;
        builder.f13741p = PublishMethod.TARGET;
        builder = builder;
        builder.f13742q = Type.ALBUM;
        builder = builder;
        builder.f13743r = viewerContext;
        builder = builder.m21478d(this.f13817b.a() / 1000);
        builder.f13707H = str3;
        return builder.m21467a();
    }

    public final UploadOperation m21574a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, String str, long j, ImmutableList<Long> immutableList3, long j2, @Nullable String str2, boolean z, RedSpaceValue redSpaceValue, boolean z2, @Nullable String str3, String str4, @Nullable ComposerAppAttribution composerAppAttribution, boolean z3, boolean z4, String str5, boolean z5, ImmutableList<String> immutableList4, boolean z6) {
        Preconditions.checkNotNull(immutableList);
        return !z5 ? new Builder().m21465a(str4).m21464a(ImmutableList.copyOf(immutableList)).m21470b((ImmutableList) immutableList2).m21475c(ImmutableList.copyOf(immutableList3)).m21476c(str).m21453a(j).m21480d("album").m21469b(j2).m21483e(str2).m21466a(z).m21459a(redSpaceValue).m21472b(z2).m21486f(str3).m21462a(PhotoUploadPrivacy.f14020a).m21460a(PublishMethod.TARGET).m21461a(Type.ALBUM).m21478d(this.f13817b.a() / 1000).m21463a(composerAppAttribution).m21481d(z3).m21484e(z4).m21489g(str5).m21479d((ImmutableList) immutableList4).m21490g(z6).m21467a() : new Builder().m21465a(str4).m21464a(ImmutableList.copyOf(immutableList)).m21470b((ImmutableList) immutableList2).m21475c(ImmutableList.copyOf(immutableList3)).m21476c(str).m21453a(Long.parseLong((String) this.f13816a.get())).m21474c(j).m21480d("own_timeline").m21469b(j2).m21483e(str2).m21466a(z).m21459a(redSpaceValue).m21472b(z2).m21486f(str3).m21462a(PhotoUploadPrivacy.f14020a).m21460a(PublishMethod.MULTIMEDIA).m21461a(Type.OWN_TIMELINE).m21478d(this.f13817b.a() / 1000).m21463a(composerAppAttribution).m21481d(z3).m21484e(z4).m21489g(str5).m21479d((ImmutableList) immutableList4).m21490g(z6).m21467a();
    }

    public final UploadOperation m21572a(ImmutableList<MediaItem> immutableList, @Nullable ImmutableList<Bundle> immutableList2, long j, String str, String str2, MinutiaeTag minutiaeTag, ImmutableList<Long> immutableList3, long j2, boolean z, @Nullable String str3, boolean z2, RedSpaceValue redSpaceValue, boolean z3, @Nullable String str4, String str5, @Nullable ProductItemAttachment productItemAttachment, long j3, String str6, boolean z4, ImmutableList<String> immutableList4) {
        PublishMethod publishMethod;
        Builder a;
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkArgument(j > 0);
        if (productItemAttachment == null) {
            if (z4) {
                publishMethod = PublishMethod.MULTIMEDIA;
            } else if (immutableList.size() == 1) {
                publishMethod = PublishMethod.TARGET;
            }
            a = new Builder().m21465a(str5).m21464a(ImmutableList.copyOf(immutableList)).m21470b((ImmutableList) immutableList2).m21475c(ImmutableList.copyOf(immutableList3)).m21476c(str2).m21456a(minutiaeTag).m21453a(j);
            if (StringUtil.a(str)) {
                str = "targeted";
            }
            return a.m21480d(str).m21469b(j2).m21484e(z).m21483e(str3).m21466a(z2).m21459a(redSpaceValue).m21472b(z3).m21486f(str4).m21462a(PhotoUploadPrivacy.f14020a).m21460a(publishMethod).m21461a(Type.TARGET).m21478d(this.f13817b.a() / 1000).m21457a(productItemAttachment).m21485f(j3).m21489g(str6).m21479d((ImmutableList) immutableList4).m21467a();
        }
        publishMethod = PublishMethod.STATUS;
        a = new Builder().m21465a(str5).m21464a(ImmutableList.copyOf(immutableList)).m21470b((ImmutableList) immutableList2).m21475c(ImmutableList.copyOf(immutableList3)).m21476c(str2).m21456a(minutiaeTag).m21453a(j);
        if (StringUtil.a(str)) {
            str = "targeted";
        }
        return a.m21480d(str).m21469b(j2).m21484e(z).m21483e(str3).m21466a(z2).m21459a(redSpaceValue).m21472b(z3).m21486f(str4).m21462a(PhotoUploadPrivacy.f14020a).m21460a(publishMethod).m21461a(Type.TARGET).m21478d(this.f13817b.a() / 1000).m21457a(productItemAttachment).m21485f(j3).m21489g(str6).m21479d((ImmutableList) immutableList4).m21467a();
    }

    public final UploadOperation m21576a(ImmutableList<MediaItem> immutableList, String str, String str2, String str3, EditPostParams editPostParams) {
        Preconditions.checkNotNull(immutableList);
        Builder builder = new Builder();
        builder.f13726a = str2;
        builder = builder;
        builder.f13727b = ImmutableList.copyOf(immutableList);
        builder = builder;
        builder.f13732g = editPostParams.targetId;
        builder = builder;
        builder.f13718S = editPostParams.legacyStoryApiId;
        builder = builder;
        if (StringUtil.a(str)) {
            str = "photo_story";
        }
        builder.f13733h = str;
        builder = builder;
        builder.f13734i = -1;
        builder = builder;
        builder.f13740o = PhotoUploadPrivacy.f14020a;
        builder = builder;
        builder.f13741p = PublishMethod.EDIT_POST;
        builder = builder;
        builder.f13742q = Type.TARGET;
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        builder = builder;
        builder.f13707H = str3;
        builder = builder;
        builder.f13719T = editPostParams;
        return builder.m21467a();
    }

    public final UploadOperation m21565a(VideoItem videoItem, @Nullable Bundle bundle, String str, MinutiaeTag minutiaeTag, PhotoUploadPrivacy photoUploadPrivacy, ImmutableList<Long> immutableList, long j, @Nullable String str2, boolean z, RedSpaceValue redSpaceValue, String str3, ComposerAppAttribution composerAppAttribution, boolean z2, boolean z3, String str4, ImmutableList<String> immutableList2, boolean z4) {
        Preconditions.checkNotNull(videoItem);
        Preconditions.checkNotNull(photoUploadPrivacy);
        Preconditions.checkNotNull(immutableList);
        ImmutableList immutableList3 = null;
        if (bundle != null) {
            immutableList3 = ImmutableList.of(bundle);
        }
        return new Builder().m21465a(str3).m21464a(ImmutableList.of(videoItem)).m21470b(immutableList3).m21475c((ImmutableList) immutableList).m21476c(str).m21456a(minutiaeTag).m21453a(Long.parseLong((String) this.f13816a.get())).m21480d("own_timeline").m21469b(j).m21483e(str2).m21466a(z).m21459a(redSpaceValue).m21462a(photoUploadPrivacy).m21460a(PublishMethod.VIDEO_TARGET).m21461a(Type.VIDEO).m21478d(this.f13817b.a() / 1000).m21463a(composerAppAttribution).m21481d(z2).m21484e(z3).m21489g(str4).m21477d(40).m21473c(this.f13820e.m21553a(bundle)).m21479d((ImmutableList) immutableList2).m21490g(z4).m21467a();
    }

    public final UploadOperation m21563a(MediaItem mediaItem, String str, long j, ViewerContext viewerContext) {
        Preconditions.checkNotNull(mediaItem);
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong((String) this.f13816a.get());
        if (parseLong == j || j <= 0) {
            j = parseLong;
        }
        Builder builder = new Builder();
        builder.f13726a = str;
        Builder builder2 = builder;
        builder2.f13727b = ImmutableList.of(mediaItem);
        builder2 = builder2;
        builder2.f13740o = PhotoUploadPrivacy.f14021b;
        builder2 = builder2;
        builder2.f13732g = j;
        builder2 = builder2;
        builder2.f13733h = "own_timeline";
        builder2 = builder2;
        builder2.f13741p = PublishMethod.VIDEO_TARGET;
        builder2 = builder2;
        builder2.f13742q = Type.VIDEO;
        builder2 = builder2;
        builder2.f13748w = this.f13817b.a() / 1000;
        builder2 = builder2;
        builder2.f13706G = Boolean.valueOf(true).booleanValue();
        builder2.m21477d(40).f13720U = this.f13820e.m21552a();
        if (viewerContext != null) {
            builder.f13743r = viewerContext;
            builder.f13741p = PublishMethod.VIDEO_STATUS;
        }
        return builder.m21467a();
    }

    public final UploadOperation m21577a(String str, String str2) {
        VideoItem a = new MediaItemFactory$VideoItemBuilder().m20107b(str).m20108c(this.f13818c.a((Uri) Preconditions.checkNotNull(Uri.parse(str)))).m20105a();
        Builder builder = new Builder();
        builder.f13727b = ImmutableList.of(a);
        Builder builder2 = builder;
        builder2.f13726a = SafeUUIDGenerator.a().toString();
        builder = builder2.m21456a(MinutiaeTag.a);
        builder.f13732g = Long.parseLong((String) this.f13816a.get());
        builder2 = builder;
        builder2.f13707H = "facecast_live_video";
        builder2 = builder2;
        builder2.f13733h = "own_timeline";
        builder2 = builder2;
        builder2.f13742q = Type.LIVE_VIDEO;
        builder2 = builder2;
        builder2.f13725Z = str2;
        builder2 = builder2;
        builder2.f13729d = RegularImmutableList.a;
        builder2 = builder2;
        builder2.f13734i = -1;
        builder2 = builder2;
        builder2.f13736k = false;
        builder2 = builder2;
        builder2.f13740o = PhotoUploadPrivacy.f14020a;
        builder2 = builder2;
        builder2.f13748w = this.f13817b.a() / 1000;
        builder2 = builder2;
        builder2.f13750y = false;
        builder2 = builder2;
        builder2.f13751z = false;
        builder2 = builder2.m21477d(40);
        builder2.f13700A = PublishMode.SAVE_DRAFT;
        builder2 = builder2;
        builder2.f13741p = PublishMethod.VIDEO_TARGET;
        builder2 = builder2;
        builder2.f13720U = -2;
        return builder2.m21467a();
    }

    public final UploadOperation m21564a(VideoItem videoItem, @Nullable Bundle bundle, long j, String str, String str2, MinutiaeTag minutiaeTag, ImmutableList<Long> immutableList, long j2, boolean z, @Nullable String str3, boolean z2, RedSpaceValue redSpaceValue, String str4, @Nullable ProductItemAttachment productItemAttachment, long j3, String str5, ImmutableList<String> immutableList2) {
        Preconditions.checkNotNull(videoItem);
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkArgument(j > 0, "Invalid targetId %d", new Object[]{Long.valueOf(j)});
        Builder a = new Builder().m21465a(str4).m21464a(ImmutableList.of(videoItem)).m21470b(bundle == null ? null : ImmutableList.of(bundle)).m21475c((ImmutableList) immutableList).m21476c(str2).m21456a(minutiaeTag).m21453a(j);
        if (StringUtil.a(str)) {
            str = "targeted";
        }
        return a.m21480d(str).m21469b(j2).m21484e(z).m21483e(str3).m21466a(z2).m21459a(redSpaceValue).m21462a(PhotoUploadPrivacy.f14020a).m21460a(PublishMethod.VIDEO_TARGET).m21461a(Type.VIDEO).m21478d(this.f13817b.a() / 1000).m21457a(productItemAttachment).m21485f(j3).m21489g(str5).m21477d(40).m21473c(this.f13820e.m21552a()).m21479d((ImmutableList) immutableList2).m21467a();
    }

    public final UploadOperation m21567a(ImmutableList<MediaItem> immutableList, PostReviewParams postReviewParams, String str) {
        Preconditions.checkNotNull(postReviewParams);
        Preconditions.checkNotNull(immutableList);
        Builder builder = new Builder();
        builder.f13726a = str;
        builder = builder;
        builder.f13727b = immutableList;
        builder = builder;
        builder.f13730e = postReviewParams.f7935c;
        builder = builder;
        builder.f13732g = -1;
        builder = builder;
        builder.f13733h = "review";
        builder = builder;
        builder.f13734i = postReviewParams.f7934b;
        builder = builder;
        builder.f13740o = new PhotoUploadPrivacy(postReviewParams.f7936d.c());
        builder = builder;
        builder.f13741p = PublishMethod.PHOTO_REVIEW;
        builder = builder;
        builder.f13742q = Type.PHOTO_REVIEW;
        builder = builder;
        builder.f13745t = true;
        builder = builder;
        builder.f13746u = postReviewParams;
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        return builder.m21467a();
    }

    public final UploadOperation m21560a(ViewerContext viewerContext, String str, String str2, String str3, int i, @Nullable String str4, long j, @Nullable String str5, @Nullable CreativeEditingData creativeEditingData, @Nullable String str6) {
        boolean a = CreativeEditingDataUtil.m4458a(creativeEditingData);
        long parseLong = Long.parseLong(viewerContext.a());
        Bundle bundle = new Bundle();
        bundle.putParcelable("creative_editing_metadata", creativeEditingData);
        bundle.putString("temp_file_to_clean_up", str);
        bundle.putString("caption", str6);
        Builder a2 = new Builder().m21465a(str2).m21464a(ImmutableList.of(new MediaItemFactory$PhotoItemBuilder().m20099b(str).m20093a(i).m20098a())).m21470b(ImmutableList.of(bundle)).m21476c("").m21453a(parseLong).m21480d("profile_pic").m21469b(-1).m21462a(PhotoUploadPrivacy.f14020a).m21460a(PublishMethod.PROFILE_PIC).m21461a(Type.PROFILE_PIC);
        if (!viewerContext.d()) {
            viewerContext = null;
        }
        return a2.m21454a(viewerContext).m21478d(this.f13817b.a() / 1000).m21491h(str3).m21492i(str4).m21488g(j).m21493j(str5).m21487f(a).m21467a();
    }

    public final UploadOperation m21559a(ViewerContext viewerContext, MediaItem mediaItem, Bundle bundle, String str, String str2, String str3, long j, String str4, @Nullable ComposerAppAttribution composerAppAttribution) {
        long parseLong = Long.parseLong(viewerContext.a());
        bundle.putString("temp_file_to_clean_up", mediaItem.e());
        return new Builder().m21465a(str).m21464a(ImmutableList.of(mediaItem)).m21470b(ImmutableList.of(bundle)).m21476c(str3).m21453a(parseLong).m21480d("profile_video").m21469b(-1).m21462a(PhotoUploadPrivacy.f14020a).m21463a(composerAppAttribution).m21460a(PublishMethod.PROFILE_VIDEO).m21461a(Type.PROFILE_VIDEO).m21478d(this.f13817b.a() / 1000).m21491h(str2).m21477d(40).m21473c(-2).m21488g(j).m21493j(str4).m21467a();
    }

    public final UploadOperation m21558a(ViewerContext viewerContext, MediaItem mediaItem, float f, float f2, String str) {
        Preconditions.checkNotNull(mediaItem);
        long parseLong = Long.parseLong(viewerContext.mUserId);
        Bundle bundle = new Bundle();
        bundle.putFloat("focusX", f);
        bundle.putFloat("focusY", f2);
        Builder builder = new Builder();
        builder.f13726a = str;
        builder = builder;
        builder.f13727b = ImmutableList.of(mediaItem);
        builder = builder;
        builder.f13728c = ImmutableList.of(bundle);
        Builder builder2 = builder;
        builder2.f13730e = "";
        builder2 = builder2;
        builder2.f13732g = parseLong;
        Builder builder3 = builder2;
        builder3.f13733h = "cover_photo";
        builder3 = builder3;
        builder3.f13734i = -1;
        builder3 = builder3;
        builder3.f13740o = PhotoUploadPrivacy.f14020a;
        builder3 = builder3;
        builder3.f13741p = PublishMethod.COVER_PHOTO;
        builder3 = builder3;
        builder3.f13742q = Type.COVER_PHOTO;
        builder3 = builder3;
        if (!viewerContext.mIsPageContext) {
            viewerContext = null;
        }
        builder3.f13743r = viewerContext;
        builder3 = builder3;
        builder3.f13748w = this.f13817b.a() / 1000;
        return builder3.m21467a();
    }

    public final UploadOperation m21573a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, PhotoUploadPrivacy photoUploadPrivacy, ComposerLifeEventParam composerLifeEventParam, String str) {
        Preconditions.checkNotNull(immutableList);
        Builder builder = new Builder();
        builder.f13726a = str;
        builder = builder;
        builder.f13727b = ImmutableList.copyOf(immutableList);
        builder = builder;
        builder.f13728c = immutableList2;
        builder = builder;
        builder.f13733h = "life_event";
        builder = builder;
        builder.f13747v = composerLifeEventParam;
        builder = builder;
        builder.f13740o = photoUploadPrivacy;
        builder = builder;
        builder.f13741p = PublishMethod.LIFE_EVENT;
        builder = builder;
        builder.f13742q = Type.LIFE_EVENT;
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        return builder.m21467a();
    }

    public final UploadOperation m21568a(ImmutableList<MediaItem> immutableList, ImmutableList<Bundle> immutableList2, long j, ViewerContext viewerContext, String str) {
        Builder builder = new Builder();
        builder.f13726a = str;
        builder = builder;
        builder.f13727b = immutableList;
        builder = builder;
        builder.f13728c = immutableList2;
        builder = builder;
        builder.f13734i = j;
        builder = builder;
        builder.f13740o = PhotoUploadPrivacy.f14023d;
        builder = builder;
        builder.f13741p = PublishMethod.MENU_PHOTO;
        builder = builder;
        builder.f13742q = Type.MENU_PHOTO;
        builder = builder;
        builder.f13733h = "menu_photo";
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        builder = builder;
        builder.f13743r = viewerContext;
        return builder.m21467a();
    }

    public final UploadOperation m21566a(ImmutableList<MediaItem> immutableList, long j, String str) {
        Builder builder = new Builder();
        builder.f13726a = str;
        builder = builder;
        builder.f13727b = ImmutableList.copyOf(immutableList);
        builder = builder;
        builder.f13734i = j;
        builder = builder;
        builder.f13741p = PublishMethod.PLACE_PHOTO;
        builder = builder;
        builder.f13740o = PhotoUploadPrivacy.f14023d;
        builder = builder;
        builder.f13742q = Type.PLACE_PHOTO;
        builder = builder;
        builder.f13733h = "place_photo";
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        return builder.m21467a();
    }

    public final UploadOperation m21561a(CommerceProductItemMutateParams commerceProductItemMutateParams, ImmutableList<MediaItem> immutableList, String str, @Nullable ViewerContext viewerContext) {
        Builder builder = new Builder();
        builder.f13714O = commerceProductItemMutateParams;
        builder = builder;
        builder.f13726a = str;
        builder = builder;
        builder.f13743r = viewerContext;
        builder = builder;
        builder.f13727b = immutableList;
        builder = builder;
        builder.f13740o = PhotoUploadPrivacy.f14023d;
        builder = builder;
        builder.f13741p = PublishMethod.PRODUCT_IMAGE;
        builder = builder;
        builder.f13742q = Type.PRODUCT_IMAGE;
        builder = builder;
        builder.f13733h = "product_image";
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        return builder.m21467a();
    }

    public final UploadOperation m21578b(String str) {
        Builder builder = new Builder();
        builder.f13726a = str;
        builder = builder;
        builder.f13733h = "cancel";
        builder = builder;
        builder.f13740o = PhotoUploadPrivacy.f14020a;
        builder = builder;
        builder.f13741p = PublishMethod.TARGET;
        builder = builder;
        builder.f13742q = Type.TARGET;
        builder = builder;
        builder.f13748w = this.f13817b.a() / 1000;
        return builder.m21467a();
    }
}
