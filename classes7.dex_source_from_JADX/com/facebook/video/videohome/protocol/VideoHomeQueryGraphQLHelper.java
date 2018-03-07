package com.facebook.video.videohome.protocol;

import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.video.videohome.protocol.VideoHomeQuery.VideoHomePrefetchMetadataNoBadgingQueryString;
import com.facebook.video.videohome.protocol.VideoHomeQuery.VideoHomePrefetchMetadataQueryString;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataNoBadgingQueryModel;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataQueryModel;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: digital_goods_cursor */
public class VideoHomeQueryGraphQLHelper {
    public final GraphQLQueryExecutor f15760a;
    public final Executor f15761b;

    @Inject
    public VideoHomeQueryGraphQLHelper(Executor executor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f15761b = executor;
        this.f15760a = graphQLQueryExecutor;
    }

    public static GraphQLRequest<VideoHomePrefetchMetadataQueryModel> m19684c(GraphQLCachePolicy graphQLCachePolicy) {
        return GraphQLRequest.a(new VideoHomePrefetchMetadataQueryString()).a(graphQLCachePolicy).a(10);
    }

    public static GraphQLRequest<VideoHomePrefetchMetadataNoBadgingQueryModel> m19683a(GraphQLCachePolicy graphQLCachePolicy) {
        return GraphQLRequest.a(new VideoHomePrefetchMetadataNoBadgingQueryString()).a(graphQLCachePolicy).a(10);
    }
}
