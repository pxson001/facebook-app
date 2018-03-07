package com.facebook.composer.publish.helpers;

import android.content.Intent;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.Clock;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingDataSpec.ProvidesComposerSessionLoggingData;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsBackoutDraft;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsUserSelectedTags;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMarketplaceId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocation.ProvidesViewerCoordinates;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: contacts_upload_messaging */
public class PublishStatusHelper<DataProvider extends ProvidesAppAttribution & ProvidesIsBackoutDraft & ProvidesIsFeedOnlyPost & ProvidesIsImplicitLocationSupported & ProvidesIsUserSelectedTags & ProvidesMarketplaceId & ProvidesPublishScheduleTime & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesViewerCoordinates & ProvidesLocationInfo & ProvidesPageData & ProvidesPrivacyData & ProvidesComposerSessionLoggingData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> {
    @Inject
    @LoggedInUser
    public volatile Provider<User> f16864a = UltralightRuntime.a;
    public final DataProvider f16865b;
    private final FbDataConnectionManager f16866c;
    private final Clock f16867d;
    public final PublishAttachmentsHelper f16868e;
    public final OptimisticPostHelper f16869f;

    @Inject
    public PublishStatusHelper(@Assisted DataProvider dataProvider, @Assisted PublishAttachmentsHelper publishAttachmentsHelper, @Assisted OptimisticPostHelper optimisticPostHelper, FbDataConnectionManager fbDataConnectionManager, Clock clock) {
        this.f16865b = dataProvider;
        this.f16868e = publishAttachmentsHelper;
        this.f16869f = optimisticPostHelper;
        this.f16866c = fbDataConnectionManager;
        this.f16867d = clock;
    }

    public final PublishPostParams m20845a() {
        String valueOf;
        boolean z;
        long longValue;
        String str;
        boolean z2 = true;
        if (((ProvidesLocationInfo) this.f16865b).g().a() != null || ((ProvidesIsImplicitLocationSupported) this.f16865b).G()) {
            valueOf = String.valueOf(((ProvidesLocationInfo) this.f16865b).g().j());
        } else {
            valueOf = null;
        }
        ImmutableList a = ComposerTagUtil.a(((ProvidesTaggedUsers) this.f16865b).h());
        User user = (User) this.f16864a.get();
        ComposerConfiguration o = ((ProvidesConfiguration) this.f16865b).o();
        Builder builder = new Builder();
        builder.G = ((ProvidesSessionId) this.f16865b).ab();
        builder = builder;
        builder.r = ((ProvidesSessionId) this.f16865b).ab();
        Builder builder2 = builder;
        builder2.t = this.f16867d.a() / 1000;
        builder = builder2;
        builder.b = ((ProvidesTargetData) this.f16865b).s().targetId;
        builder = builder;
        builder.c = MentionsUtils.a(((ProvidesTextWithEntities) this.f16865b).ae());
        builder2 = builder;
        builder2.d = valueOf;
        builder2 = builder2;
        builder2.p = o.getComposerType();
        Builder builder3 = builder2;
        if (((ProvidesLocationInfo) this.f16865b).g().a() != null) {
            z = true;
        } else {
            z = false;
        }
        builder3.s = z;
        builder2 = builder3.d(a);
        builder2.j = Long.parseLong(user.a);
        Builder builder4 = builder2;
        builder4.m = o.getNectarModule();
        builder2 = builder4;
        builder2.w = this.f16865b.T();
        builder4 = builder2;
        builder4.A = o.getPlatformConfiguration().insightsPlatformRef;
        builder2 = builder4;
        builder2.S = this.f16865b.f();
        builder2 = builder2;
        builder2.o = ((ProvidesPublishMode) this.f16865b).j();
        builder2 = builder2;
        builder2.ab = ((ProvidesLocationInfo) this.f16865b).g().c();
        builder3 = builder2;
        if (this.f16865b.Y() != null) {
            longValue = this.f16865b.Y().longValue();
        } else {
            longValue = 0;
        }
        builder2 = builder3.a(Long.valueOf(longValue));
        builder2.T = ((ProvidesProductItemAttachment) this.f16865b).i();
        builder2 = builder2;
        builder2.U = this.f16865b.U();
        builder4 = builder2;
        builder4.W = o.isThrowbackPost();
        builder4 = builder4.a(MinutiaeObject.a(((ProvidesMinutiae) this.f16865b).l()));
        builder4.Y = this.f16866c.c().name();
        builder2 = builder4;
        builder2.Z = ((ProvidesLocationInfo) this.f16865b).g().d();
        builder2 = builder2;
        builder2.aa = ((ProvidesRedSpaceValue) this.f16865b).k();
        builder2 = builder2;
        builder2.g = ((ProvidesPrivacyData) this.f16865b).ag().m1946a();
        builder2 = builder2;
        builder2.h = this.f16865b.b();
        builder4 = builder2;
        builder4.R = true;
        builder2 = builder4;
        builder2.u = ((ProvidesLocationInfo) this.f16865b).g().b();
        builder4 = builder2;
        builder4.ac = o.getSourceType().toString();
        builder4 = builder4;
        if (((ProvidesStickerData) this.f16865b).r() == null) {
            str = null;
        } else {
            str = ((ProvidesStickerData) this.f16865b).r().stickerId;
        }
        builder4.O = str;
        builder2 = builder4;
        builder2.ad = ((ProvidesIsBackoutDraft) this.f16865b).z();
        builder2 = builder2;
        if (((ProvidesShareParams) this.f16865b).q() == null || !((ProvidesShareParams) this.f16865b).q().includeReshareContext) {
            z2 = false;
        }
        builder2.X = z2;
        builder2 = builder2;
        builder2.v = TopicFeedsHelper.m20848a((ProvidesTopics) this.f16865b);
        builder2 = builder2;
        builder2.ao = this.f16865b.E();
        builder2 = builder2;
        ComposerShareParams q = ((ProvidesShareParams) this.f16865b).q();
        if (q != null) {
            if (q.linkForShare != null) {
                builder2.i = q.linkForShare;
                builder3 = builder2;
                builder3.B = o.getPlatformConfiguration().nameForShareLink;
                builder3 = builder3;
                builder3.C = o.getPlatformConfiguration().captionForShareLink;
                builder3 = builder3;
                builder3.D = o.getPlatformConfiguration().descriptionForShareLink;
                builder3.F = o.getPlatformConfiguration().pictureForShareLink;
            }
            if (q.quoteText != null) {
                builder2.E = q.quoteText;
            }
            builder2.k = q.shareable;
            builder2.l = q.shareTracking;
        }
        if (this.f16865b.a() != null) {
            builder2.y = this.f16865b.a().b();
            builder4 = builder2;
            builder4.x = this.f16865b.a().a();
            builder4.z = this.f16865b.a().c();
        }
        return builder2.a();
    }

    public final Intent m20846b() {
        boolean z;
        PublishPostParams a = m20845a();
        if (this.f16868e.m20829a()) {
            this.f16868e.m20828a(this.f16868e.m20830c());
            if (!this.f16869f.m20822a()) {
                this.f16868e.m20831d();
            }
            z = true;
        } else {
            z = false;
        }
        return m20844a(a, z);
    }

    public final Intent m20844a(PublishPostParams publishPostParams, boolean z) {
        Intent intent = new Intent();
        if (z) {
            Builder builder = new Builder(publishPostParams);
            builder.q = true;
            publishPostParams = builder.a();
            intent.putExtra("is_uploading_media", true);
        } else if (((ProvidesPublishMode) this.f16865b).j() == PublishMode.SCHEDULE_POST) {
            intent.putExtra("extra_actor_viewer_context", ((ComposerPageData) Preconditions.checkNotNull(this.f16865b.p())).getPostAsPageViewerContext());
        }
        intent.putExtra("publishPostParams", publishPostParams);
        if (this.f16869f.m20822a()) {
            intent.putExtra("extra_optimistic_feed_story", this.f16869f.m20823b().m4478a());
        }
        return intent;
    }
}
