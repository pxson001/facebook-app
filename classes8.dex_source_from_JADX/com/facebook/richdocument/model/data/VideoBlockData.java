package com.facebook.richdocument.model.data;

import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import javax.annotation.Nullable;

/* compiled from: photo_view_clicked */
public interface VideoBlockData extends AnnotatableBlock, BlockData, CoverMediaBlock, MediaPresentationBlock, OGBlock, SlideBlock {
    @Nullable
    FBVideo mo305p();

    @Nullable
    FBPhoto mo306q();

    @Nullable
    GraphQLDocumentVideoAutoplayStyle mo307r();

    @Nullable
    GraphQLDocumentVideoControlStyle mo308s();

    @Nullable
    GraphQLDocumentVideoLoopingStyle mo309t();
}
