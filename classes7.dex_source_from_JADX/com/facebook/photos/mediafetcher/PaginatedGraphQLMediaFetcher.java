package com.facebook.photos.mediafetcher;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.query.PaginatedMediaQuery;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: lastViewTime */
public class PaginatedGraphQLMediaFetcher<GRAPHQL_RESULT_TYPE> extends PaginatedGraphQLFetcher<GRAPHQL_RESULT_TYPE, MediaMetadata> {
    @Inject
    public PaginatedGraphQLMediaFetcher(@Assisted PaginatedMediaQuery paginatedMediaQuery, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ExecutorService executorService, GraphQLSubscriptionHolder graphQLSubscriptionHolder, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(paginatedMediaQuery, defaultAndroidThreadUtil, executorService, graphQLSubscriptionHolder, abstractFbErrorReporter);
    }
}
