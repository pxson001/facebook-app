package com.facebook.ufiservices.util;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.ipc.media.StickerItem;
import com.facebook.stickers.model.Sticker;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: crop_rect_left */
public class FeedCommentPreview {

    /* compiled from: crop_rect_left */
    /* synthetic */ class C13551 {
        static final /* synthetic */ int[] f18313a = new int[MediaType.values().length];

        static {
            try {
                f18313a[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18313a[MediaType.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18313a[MediaType.PHOTO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static GraphQLComment m26840a(GraphQLActor graphQLActor, String str, List<GraphQLEntityAtRange> list, String str2, @Nullable MediaItem mediaItem, @Nullable StickerItem stickerItem, PendingCommentCache pendingCommentCache) {
        ImmutableList of;
        String str3 = null;
        Preconditions.checkNotNull(graphQLActor);
        Preconditions.checkNotNull(str);
        GraphQLFeedback a = new Builder().a();
        GraphQLTextWithEntities a2 = GraphQLHelper.a(str, list, Lists.a(), Lists.a());
        if (mediaItem != null) {
            switch (C13551.f18313a[mediaItem.l().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    Uri fromFile = Uri.fromFile(new File(mediaItem.e()));
                    GraphQLImage.Builder builder = new GraphQLImage.Builder();
                    builder.g = fromFile.toString();
                    GraphQLImage a3 = builder.a();
                    GraphQLMedia.Builder builder2 = new GraphQLMedia.Builder();
                    builder2.N = a3;
                    GraphQLMedia.Builder builder3 = builder2;
                    if (mediaItem.o() != -1) {
                        str3 = Long.toString(mediaItem.o());
                    }
                    builder3.M = str3;
                    GraphQLMedia a4 = builder3.a();
                    GraphQLStoryAttachment.Builder builder4 = new GraphQLStoryAttachment.Builder();
                    builder4.l = a4;
                    GraphQLStoryAttachment.Builder builder5 = builder4;
                    builder5.q = ImmutableList.of(GraphQLStoryAttachmentStyle.PHOTO);
                    of = ImmutableList.of(builder5.a());
                    break;
            }
        }
        if (stickerItem != null) {
            Sticker sticker = stickerItem.a;
            builder3 = new GraphQLMedia.Builder();
            builder3.M = sticker.f4938a;
            builder3 = builder3;
            builder = new GraphQLImage.Builder();
            builder.g = sticker.f4940c.toString();
            builder3.N = builder.a();
            GraphQLMedia.Builder builder6 = builder3;
            builder6.bv = new GraphQLObjectType(-225599203);
            a4 = builder6.a();
            builder4 = new GraphQLStoryAttachment.Builder();
            builder4.l = a4;
            builder5 = builder4;
            builder5.q = ImmutableList.of(GraphQLStoryAttachmentStyle.STICKER);
            of = ImmutableList.of(builder5.a());
        }
        GraphQLComment.Builder builder7 = new GraphQLComment.Builder();
        builder7.g = graphQLActor;
        builder7 = builder7;
        builder7.h = a2;
        GraphQLComment.Builder a5 = builder7.a(System.currentTimeMillis() / 1000);
        a5.o = a;
        GraphQLComment.Builder builder8 = a5;
        builder8.z = str2;
        builder8 = builder8;
        builder8.f = of;
        GraphQLComment a6 = builder8.a();
        pendingCommentCache.m26492a(a6.H(), GraphQLFeedOptimisticPublishState.POSTING);
        return a6;
    }
}
