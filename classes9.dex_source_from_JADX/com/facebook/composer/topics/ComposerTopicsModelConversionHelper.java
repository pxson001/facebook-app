package com.facebook.composer.topics;

import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLExploreFeed.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel.DisabledFavoriteIconModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel.EnabledFavoriteIconModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel.HeaderImageModel;

/* compiled from: Trying to pass a param that was generated from the graphql query with identity %d into request with identity %d */
public final class ComposerTopicsModelConversionHelper {
    public static GraphQLExploreFeed m25885a(TopicFeedFragmentModel topicFeedFragmentModel) {
        if (topicFeedFragmentModel == null) {
            return null;
        }
        GraphQLImage graphQLImage;
        Builder builder = new Builder();
        builder.d = topicFeedFragmentModel.b();
        builder.e = topicFeedFragmentModel.c();
        DisabledFavoriteIconModel d = topicFeedFragmentModel.d();
        if (d == null) {
            graphQLImage = null;
        } else {
            GraphQLImage.Builder builder2 = new GraphQLImage.Builder();
            builder2.g = d.a();
            graphQLImage = builder2.a();
        }
        builder.f = graphQLImage;
        EnabledFavoriteIconModel fd_ = topicFeedFragmentModel.fd_();
        if (fd_ == null) {
            graphQLImage = null;
        } else {
            builder2 = new GraphQLImage.Builder();
            builder2.g = fd_.a();
            graphQLImage = builder2.a();
        }
        builder.g = graphQLImage;
        HeaderImageModel g = topicFeedFragmentModel.g();
        if (g == null) {
            graphQLImage = null;
        } else {
            builder2 = new GraphQLImage.Builder();
            builder2.g = g.a();
            graphQLImage = builder2.a();
        }
        builder.h = graphQLImage;
        builder.i = topicFeedFragmentModel.fb_();
        boolean fc_ = topicFeedFragmentModel.fc_();
        builder.j = fc_;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 6, fc_);
        }
        builder.k = topicFeedFragmentModel.j();
        builder.l = topicFeedFragmentModel.k();
        builder.m = topicFeedFragmentModel.l();
        return builder.a();
    }
}
