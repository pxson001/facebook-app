package com.facebook.offers.graphql;

import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.offers.graphql.OfferQueriesModels.ImageDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferStoryAttachmentFieldsModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferStoryAttachmentFieldsModel.MediaModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferStoryFieldsModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferStoryFieldsModel.ShareableModel;
import com.google.common.collect.ImmutableList;

/* compiled from: current_region_tos_links */
public final class OfferGraphQLConversionHelper {
    public static GraphQLStory m19043a(OfferStoryFieldsModel offerStoryFieldsModel) {
        if (offerStoryFieldsModel == null) {
            return null;
        }
        GraphQLEntity graphQLEntity;
        Builder builder = new Builder();
        if (offerStoryFieldsModel.m19279b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < offerStoryFieldsModel.m19279b().size(); i++) {
                GraphQLStoryAttachment graphQLStoryAttachment;
                OfferStoryAttachmentFieldsModel offerStoryAttachmentFieldsModel = (OfferStoryAttachmentFieldsModel) offerStoryFieldsModel.m19279b().get(i);
                if (offerStoryAttachmentFieldsModel == null) {
                    graphQLStoryAttachment = null;
                } else {
                    GraphQLMedia graphQLMedia;
                    GraphQLStoryAttachment.Builder builder3 = new GraphQLStoryAttachment.Builder();
                    MediaModel a = offerStoryAttachmentFieldsModel.m19260a();
                    if (a == null) {
                        graphQLMedia = null;
                    } else {
                        GraphQLImage graphQLImage;
                        GraphQLMedia.Builder builder4 = new GraphQLMedia.Builder();
                        builder4.bv = a.m19252a();
                        ImageDataModel b = a.m19254b();
                        if (b == null) {
                            graphQLImage = null;
                        } else {
                            GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
                            builder5.g = b.m19151a();
                            graphQLImage = builder5.a();
                        }
                        builder4.N = graphQLImage;
                        graphQLMedia = builder4.a();
                    }
                    builder3.l = graphQLMedia;
                    builder3.u = offerStoryAttachmentFieldsModel.m19261b();
                    graphQLStoryAttachment = builder3.a();
                }
                builder2.c(graphQLStoryAttachment);
            }
            builder.m = builder2.b();
        }
        builder.K = offerStoryFieldsModel.m19280c();
        ShareableModel d = offerStoryFieldsModel.m19281d();
        if (d == null) {
            graphQLEntity = null;
        } else {
            GraphQLEntity.Builder builder6 = new GraphQLEntity.Builder();
            builder6.S = d.m19270b();
            builder6.m = d.m19271c();
            graphQLEntity = builder6.a();
        }
        builder.al = graphQLEntity;
        return builder.a();
    }
}
