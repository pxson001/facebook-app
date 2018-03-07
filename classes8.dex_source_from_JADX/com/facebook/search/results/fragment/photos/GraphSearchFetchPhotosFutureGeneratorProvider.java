package com.facebook.search.results.fragment.photos;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryModels.Fb4aGraphSearchPhotoQueryModel;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.ExecutorService;

/* compiled from: SENT_CODE_SMS */
public class GraphSearchFetchPhotosFutureGeneratorProvider extends AbstractAssistedProvider<GraphSearchFetchPhotosFutureGenerator> {
    public final GraphSearchFetchPhotosFutureGenerator m26731a(Function<String, String> function, FutureCallback<GraphQLResult<Fb4aGraphSearchPhotoQueryModel>> futureCallback) {
        return new GraphSearchFetchPhotosFutureGenerator((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), SizeAwareImageUtil.a(this), new SearchResultsMediaTwiddler(), function, futureCallback);
    }
}
