package com.facebook.composer.publish.helpers;

import android.content.Intent;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.privacy.common.ComposerPrivacyUtil;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.protocol.PostReviewParams.Builder;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: contacts_upload_started */
public class PublishReviewHelper {
    public final ComposerDataProviderImpl f16859a;
    public final PublishAttachmentsHelper f16860b;
    public final OptimisticPostHelper f16861c;
    public final int f16862d;
    public final UploadOperationFactory f16863e;

    @Inject
    public PublishReviewHelper(@Assisted ComposerDataProviderImpl composerDataProviderImpl, @Assisted PublishAttachmentsHelper publishAttachmentsHelper, @Assisted OptimisticPostHelper optimisticPostHelper, @Assisted Integer num, UploadOperationFactory uploadOperationFactory) {
        this.f16859a = composerDataProviderImpl;
        this.f16861c = optimisticPostHelper;
        this.f16862d = num.intValue();
        this.f16860b = publishAttachmentsHelper;
        this.f16863e = uploadOperationFactory;
    }

    private PostReviewParams m20842b() {
        MediaItem mediaItem;
        ImmutableList o = AttachmentUtils.o(this.f16859a.m());
        GraphQLPrivacyOption b = ComposerPrivacyUtil.m1948b(this.f16859a.ag());
        Preconditions.checkNotNull(b, "Review must have selectable privacy data");
        Builder builder = new Builder(this.f16859a.s().targetId, b, this.f16862d, this.f16859a.o().getOgMechanism(), this.f16859a.o().getOgSurface());
        builder.a = this.f16859a.ab();
        builder = builder;
        builder.c = MentionsUtils.a(this.f16859a.ae());
        builder = builder;
        if (o.isEmpty()) {
            mediaItem = null;
        } else {
            mediaItem = (MediaItem) o.get(0);
        }
        builder.h = mediaItem;
        return builder.a();
    }

    public final Intent m20843a() {
        if (this.f16860b.m20829a()) {
            GraphQLPrivacyOption b = ComposerPrivacyUtil.m1948b(this.f16859a.ag());
            Preconditions.checkNotNull(b, "Review must have selectable privacy data");
            UploadOperationFactory uploadOperationFactory = this.f16863e;
            ImmutableList o = AttachmentUtils.o(this.f16859a.m());
            Builder builder = new Builder(this.f16859a.s().targetId, b, this.f16862d, this.f16859a.o().getOgMechanism(), this.f16859a.o().getOgSurface());
            builder.a = this.f16859a.ab();
            builder = builder;
            builder.c = MentionsUtils.a(this.f16860b.f16841o);
            this.f16860b.m20828a(uploadOperationFactory.a(o, builder.a(), this.f16859a.ab()));
            if (!this.f16861c.m20822a()) {
                this.f16860b.m20831d();
            }
        }
        PostReviewParams b2 = m20842b();
        Intent intent = new Intent();
        intent.putExtra("publishReviewParams", b2);
        intent.putExtra("extra_feed_unit_cache_id", this.f16859a.o().getCacheId());
        if (this.f16861c.m20822a()) {
            intent.putExtra("extra_optimistic_feed_story", this.f16861c.m20823b().m4478a());
        }
        return intent;
    }
}
