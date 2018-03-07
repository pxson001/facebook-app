package com.facebook.compost.publish.graphql;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentConnection;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLWithTagsConnection;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.base.media.PhotoItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.nokia.pushnotifications.intent.UNREGISTER */
public class CompostGraphQLCreators {
    public static GraphQLProfile m21275a(ComposerTargetData composerTargetData) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(composerTargetData.targetId > 0, "[createTargetProfileFromComposerTargetData] Invalid targetId: " + composerTargetData.targetId);
        if (StringUtil.a(composerTargetData.targetName)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "[createTargetProfileFromComposerTargetData] Empty targetName");
        if (StringUtil.a(composerTargetData.targetProfilePicUrl)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "[createTargetProfileFromComposerTargetData] Empty targetProfilePicUrl");
        if (composerTargetData.targetType != TargetType.USER) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        Builder builder = new Builder();
        builder.G = String.valueOf(composerTargetData.targetId);
        builder = builder;
        builder.Q = composerTargetData.targetName;
        builder = builder;
        GraphQLImage.Builder builder2 = new GraphQLImage.Builder();
        builder2.g = composerTargetData.targetProfilePicUrl;
        builder.ae = builder2.a();
        builder = builder;
        builder.aE = new GraphQLObjectType(2645995);
        return builder.a();
    }

    public static GraphQLPrivacyScope m21274a(ComposerPrivacyData composerPrivacyData) {
        GraphQLPrivacyOption a;
        Preconditions.checkArgument(!StringUtil.a(composerPrivacyData.m1946a()), "[createPrivacyScopeFromComposerPrivacyData] selectedLegacyGraphApiPrivacyJson empty");
        GraphQLPrivacyScope.Builder builder = new GraphQLPrivacyScope.Builder();
        GraphQLPrivacyOptionsContentConnection.Builder builder2 = new GraphQLPrivacyOptionsContentConnection.Builder();
        GraphQLPrivacyOptionsContentEdge.Builder builder3 = new GraphQLPrivacyOptionsContentEdge.Builder();
        if (composerPrivacyData.f2001b == null || composerPrivacyData.f2001b.d == null) {
            GraphQLPrivacyOption.Builder builder4 = new GraphQLPrivacyOption.Builder();
            builder4.j = composerPrivacyData.m1946a();
            a = builder4.a();
        } else {
            a = composerPrivacyData.f2001b.d;
        }
        builder3.e = a;
        builder2.d = ImmutableList.of(builder3.a());
        builder.k = builder2.a();
        return builder.a();
    }

    public static GraphQLStoryAttachment m21279a(List<ComposerAttachment> list) {
        if (list.size() == 1) {
            return m21277a((ComposerAttachment) list.get(0));
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (ComposerAttachment a : list) {
            builder.c(m21277a(a));
        }
        GraphQLStoryAttachment.Builder builder2 = new GraphQLStoryAttachment.Builder();
        builder2.k = true;
        builder2 = builder2;
        builder2.r = builder.b();
        builder2 = builder2;
        builder2.q = ImmutableList.of(GraphQLStoryAttachmentStyle.ALBUM);
        return builder2.a();
    }

    public static GraphQLStoryAttachment m21276a(Uri uri, MediaItemFactory mediaItemFactory) {
        MediaItem a = mediaItemFactory.a(uri, FallbackMediaId.DEFAULT);
        GraphQLStoryAttachment.Builder builder = new GraphQLStoryAttachment.Builder();
        builder.k = true;
        builder = builder;
        builder.l = m21273a((PhotoItem) a, null);
        GraphQLStoryAttachment.Builder builder2 = builder;
        builder2.q = ImmutableList.of(GraphQLStoryAttachmentStyle.PHOTO);
        return builder2.a();
    }

    public static GraphQLStoryAttachment m21278a(ComposerShareParams composerShareParams) {
        GraphQLMedia graphQLMedia;
        boolean z = true;
        Preconditions.checkArgument(composerShareParams.sharePreview != null, "[createLinkStoryAttachmentFromComposerShareParams] sharePreview empty");
        if (StringUtil.a(composerShareParams.linkForShare)) {
            z = false;
        }
        Preconditions.checkArgument(z, "[createLinkStoryAttachmentFromComposerShareParams] linkForShare empty");
        GraphQLStoryAttachment.Builder builder = new GraphQLStoryAttachment.Builder();
        builder.u = composerShareParams.sharePreview.title;
        builder = builder;
        GraphQLTextWithEntities.Builder builder2 = new GraphQLTextWithEntities.Builder();
        builder2.i = composerShareParams.sharePreview.subTitle;
        builder.h = builder2.a();
        builder = builder;
        builder2 = new GraphQLTextWithEntities.Builder();
        builder2.i = composerShareParams.sharePreview.summary;
        builder.o = builder2.a();
        GraphQLStoryAttachment.Builder builder3 = builder;
        if (StringUtil.a(composerShareParams.sharePreview.imageUrl)) {
            graphQLMedia = null;
        } else {
            GraphQLMedia.Builder builder4 = new GraphQLMedia.Builder();
            GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
            builder5.g = composerShareParams.sharePreview.imageUrl;
            builder4.N = builder5.a();
            graphQLMedia = builder4.a();
        }
        builder3.l = graphQLMedia;
        builder = builder3;
        builder.q = ImmutableList.of(GraphQLStoryAttachmentStyle.SHARE, GraphQLStoryAttachmentStyle.FALLBACK);
        builder = builder;
        GraphQLNode.Builder builder6 = new GraphQLNode.Builder();
        GraphQLObjectType.Builder builder7 = new GraphQLObjectType.Builder();
        builder7.a = 514783620;
        builder6.kQ = builder7.a();
        builder.t = builder6.a();
        builder = builder;
        builder.w = composerShareParams.linkForShare;
        return builder.a();
    }

    public static GraphQLWithTagsConnection m21280b(List<ComposerTaggedUser> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (ComposerTaggedUser composerTaggedUser : list) {
            boolean z;
            long a = composerTaggedUser.a();
            Object b = composerTaggedUser.b();
            Object c = composerTaggedUser.c();
            boolean z2 = true;
            Preconditions.checkArgument(a != 0, "[createActor] Invalid actorId");
            if (StringUtil.a(b)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "[createActor] Empty name");
            if (StringUtil.a(c)) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "[createActor] Empty imageUrl");
            GraphQLImage a2 = GraphQLHelper.a(c, 0, 0);
            GraphQLActor.Builder builder2 = new GraphQLActor.Builder();
            builder2.B = String.valueOf(a);
            builder2.V = b;
            builder2.ad = a2;
            builder2.aH = new GraphQLObjectType(2645995);
            builder.c(builder2.a());
        }
        GraphQLWithTagsConnection.Builder builder3 = new GraphQLWithTagsConnection.Builder();
        builder3.d = builder.b();
        return builder3.a();
    }

    private static GraphQLMedia m21273a(PhotoItem photoItem, @Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        if (photoItem == null) {
            return null;
        }
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.g = photoItem.f().toString();
        GraphQLImage a = builder.a();
        GraphQLMedia.Builder builder2 = new GraphQLMedia.Builder();
        builder2.N = a;
        builder2 = builder2;
        builder2.U = a;
        builder2 = builder2;
        builder2.O = a;
        GraphQLMedia.Builder builder3 = builder2;
        builder3.ay = graphQLTextWithEntities;
        builder3 = builder3;
        builder3.bv = new GraphQLObjectType(77090322);
        builder3 = builder3;
        builder3.M = String.valueOf(photoItem.c.mMediaStoreId);
        return builder3.a();
    }

    private static GraphQLStoryAttachment m21277a(ComposerAttachment composerAttachment) {
        Preconditions.checkArgument(composerAttachment.b() instanceof PhotoItem, "[createPhotoStoryAttachmentFromComposerAttachment] attachment type: " + composerAttachment.b().b().mType.name());
        GraphQLStoryAttachment.Builder builder = new GraphQLStoryAttachment.Builder();
        builder.k = true;
        GraphQLStoryAttachment.Builder builder2 = builder;
        builder2.l = m21273a((PhotoItem) composerAttachment.b(), composerAttachment.d());
        builder = builder2;
        builder.q = ImmutableList.of(GraphQLStoryAttachmentStyle.PHOTO);
        return builder.a();
    }
}
