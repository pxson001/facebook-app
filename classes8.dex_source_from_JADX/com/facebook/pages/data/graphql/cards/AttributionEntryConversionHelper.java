package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.model.GraphQLEntityWithImage;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLModels.EntityWithImageFragmentModel;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLModels.EntityWithImageFragmentModel.ImageModel;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLModels.ReviewWithPillTextWithEntitiesFieldsModel;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLModels.ReviewWithPillTextWithEntitiesFieldsModel.ImageRangesModel;
import com.google.common.collect.ImmutableList;

/* compiled from: cool_down_hours */
public final class AttributionEntryConversionHelper {
    public static GraphQLTextWithEntities m20222a(ReviewWithPillTextWithEntitiesFieldsModel reviewWithPillTextWithEntitiesFieldsModel) {
        if (reviewWithPillTextWithEntitiesFieldsModel == null) {
            return null;
        }
        Builder builder = new Builder();
        if (reviewWithPillTextWithEntitiesFieldsModel.m20754b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reviewWithPillTextWithEntitiesFieldsModel.m20754b().size(); i++) {
                GraphQLImageAtRange graphQLImageAtRange;
                ImageRangesModel imageRangesModel = (ImageRangesModel) reviewWithPillTextWithEntitiesFieldsModel.m20754b().get(i);
                if (imageRangesModel == null) {
                    graphQLImageAtRange = null;
                } else {
                    GraphQLEntityWithImage graphQLEntityWithImage;
                    GraphQLImageAtRange.Builder builder3 = new GraphQLImageAtRange.Builder();
                    EntityWithImageFragmentModel a = imageRangesModel.m20746a();
                    if (a == null) {
                        graphQLEntityWithImage = null;
                    } else {
                        GraphQLImage graphQLImage;
                        GraphQLEntityWithImage.Builder builder4 = new GraphQLEntityWithImage.Builder();
                        builder4.f = a.m20719a();
                        ImageModel b = a.m20721b();
                        if (b == null) {
                            graphQLImage = null;
                        } else {
                            GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
                            builder5.g = b.m20715a();
                            graphQLImage = builder5.a();
                        }
                        builder4.e = graphQLImage;
                        graphQLEntityWithImage = builder4.a();
                    }
                    builder3.d = graphQLEntityWithImage;
                    builder3.e = imageRangesModel.m20748b();
                    builder3.f = imageRangesModel.m20749c();
                    graphQLImageAtRange = builder3.a();
                }
                builder2.c(graphQLImageAtRange);
            }
            builder.f = builder2.b();
        }
        builder.i = reviewWithPillTextWithEntitiesFieldsModel.m20753a();
        return builder.a();
    }
}
