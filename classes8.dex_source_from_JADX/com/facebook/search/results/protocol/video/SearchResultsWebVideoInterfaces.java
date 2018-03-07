package com.facebook.search.results.protocol.video;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import javax.annotation.Nullable;

/* compiled from: moments_segue */
public class SearchResultsWebVideoInterfaces {

    /* compiled from: moments_segue */
    public interface SearchResultsWebVideo {

        /* compiled from: moments_segue */
        public interface AllShareStories {
            int mo564a();
        }

        /* compiled from: moments_segue */
        public interface LinkMedia {
            @Nullable
            GraphQLObjectType mo565a();

            @Nullable
            DefaultImageFields mo567j();
        }

        /* compiled from: moments_segue */
        public interface VideoShare {
            @Nullable
            String mo569a();

            int mo570b();
        }

        @Nullable
        String mo572C();

        @Nullable
        LinkMedia mo577N();

        @Nullable
        DefaultTextWithEntitiesLongFields al();

        @Nullable
        DefaultTextWithEntitiesLongFields at();

        @Nullable
        VideoShare av();

        @Nullable
        AllShareStories mo588d();

        long mo592q();

        @Nullable
        String mo593v();
    }
}
