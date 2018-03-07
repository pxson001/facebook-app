package com.facebook.search.results.protocol.video;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLInterfaces.SphericalMetadata;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel;
import javax.annotation.Nullable;

/* compiled from: module_title */
public class SearchResultsVideoInterfaces {

    /* compiled from: module_title */
    public interface SearchResultsVideo extends SphericalMetadata {
        boolean mo571A();

        @Nullable
        DefaultImageFields mo575F();

        boolean mo576J();

        @Nullable
        DefaultTextWithEntitiesLongFields mo578R();

        @Nullable
        OwnerModel mo580Y();

        int ad();

        int ae();

        long mo590o();

        @Nullable
        GraphQLStory mo591p();
    }
}
