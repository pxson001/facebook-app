package com.facebook.feed.rows.sections.attachments.linkshare;

import com.facebook.feed.rows.sections.attachments.linkshare.BaseAttachmentCoverPhotoPartDefinition.CoverPhotoImageProvider;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;

/* compiled from: ViewManagerPropertyUpdater */
public class BaseAttachmentCoverPhotoPartDefinition$1 implements CoverPhotoImageProvider {
    final /* synthetic */ BaseAttachmentCoverPhotoPartDefinition f20959a;

    public BaseAttachmentCoverPhotoPartDefinition$1(BaseAttachmentCoverPhotoPartDefinition baseAttachmentCoverPhotoPartDefinition) {
        this.f20959a = baseAttachmentCoverPhotoPartDefinition;
    }

    public final GraphQLImage m23872a(GraphQLMedia graphQLMedia, float f) {
        return graphQLMedia.bt();
    }
}
