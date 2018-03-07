package com.facebook.search.results.fragment.photos;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLPageInfo.Builder;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.photos.pandora.common.data.GraphSearchPandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQuery.Fb4aGraphSearchPhotoQueryString;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryModels.Fb4aGraphSearchPhotoQueryModel;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SEQUENCE */
public class GraphSearchFetchPhotosFutureGenerator extends PandoraPhotoCollageFetchPhotosFutureGenerator {
    private final ExecutorService f23064a;
    private final GraphQLQueryExecutor f23065b;
    private final SizeAwareImageUtil f23066c;
    private final Function<String, String> f23067d;
    public final SearchResultsMediaTwiddler f23068e;
    private final GraphQLToPandoraConvertFunction f23069f = new GraphQLToPandoraConvertFunction(this);
    @Nullable
    private final FutureCallback<GraphQLResult<Fb4aGraphSearchPhotoQueryModel>> f23070g;

    /* compiled from: SEQUENCE */
    class GraphQLToPandoraConvertFunction implements Function<GraphQLResult<Fb4aGraphSearchPhotoQueryModel>, OperationResult> {
        final /* synthetic */ GraphSearchFetchPhotosFutureGenerator f23063a;

        public GraphQLToPandoraConvertFunction(GraphSearchFetchPhotosFutureGenerator graphSearchFetchPhotosFutureGenerator) {
            this.f23063a = graphSearchFetchPhotosFutureGenerator;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return OperationResult.a(ErrorCode.API_ERROR);
            }
            GraphQLPageInfo graphQLPageInfo;
            ImmutableList a;
            Fb4aGraphSearchPhotoQueryModel fb4aGraphSearchPhotoQueryModel = (Fb4aGraphSearchPhotoQueryModel) graphQLResult.e;
            if (fb4aGraphSearchPhotoQueryModel == null || fb4aGraphSearchPhotoQueryModel.m8490a() == null || fb4aGraphSearchPhotoQueryModel.m8490a().m8485k() == null) {
                graphQLPageInfo = null;
            } else {
                GraphQLPageInfo graphQLPageInfo2;
                DefaultPageInfoTailFieldsModel j = fb4aGraphSearchPhotoQueryModel.m8490a().m8485k().m8496j();
                if (j == null) {
                    graphQLPageInfo2 = null;
                } else {
                    Builder builder = new Builder();
                    builder.e = j.a();
                    builder.f = j.b();
                    graphQLPageInfo2 = builder.a();
                }
                graphQLPageInfo = graphQLPageInfo2;
            }
            GraphQLPageInfo graphQLPageInfo3 = graphQLPageInfo;
            fb4aGraphSearchPhotoQueryModel = (Fb4aGraphSearchPhotoQueryModel) graphQLResult.e;
            SearchResultsMediaTwiddler searchResultsMediaTwiddler = this.f23063a.f23068e;
            if (fb4aGraphSearchPhotoQueryModel == null || fb4aGraphSearchPhotoQueryModel.m8490a() == null || fb4aGraphSearchPhotoQueryModel.m8490a().m8485k() == null || fb4aGraphSearchPhotoQueryModel.m8490a().m8485k().m8495a().isEmpty()) {
                a = searchResultsMediaTwiddler.m26732a(RegularImmutableList.a, false);
            } else {
                ImmutableList a2 = fb4aGraphSearchPhotoQueryModel.m8490a().m8485k().m8495a();
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    builder2.c(new PandoraSingleMediaModel((PandoraMediaModel) a2.get(i)));
                }
                a = searchResultsMediaTwiddler.m26732a(builder2.b(), true);
            }
            return OperationResult.a(new PandoraSlicedFeedResult(graphQLPageInfo3, a));
        }
    }

    @Inject
    public GraphSearchFetchPhotosFutureGenerator(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, SizeAwareImageUtil sizeAwareImageUtil, SearchResultsMediaTwiddler searchResultsMediaTwiddler, @Assisted Function<String, String> function, @Assisted FutureCallback<GraphQLResult<Fb4aGraphSearchPhotoQueryModel>> futureCallback) {
        this.f23064a = executorService;
        this.f23065b = graphQLQueryExecutor;
        this.f23066c = sizeAwareImageUtil;
        this.f23067d = function;
        this.f23068e = searchResultsMediaTwiddler;
        this.f23070g = futureCallback;
    }

    public final ListenableFuture<OperationResult> mo903a(@Nullable String str, @Nullable String str2, PandoraInstanceId pandoraInstanceId, int i, boolean z) {
        GraphQLQueryFuture a = this.f23065b.a(GraphQLRequest.a(m26729a(i, pandoraInstanceId, str, str2)).a(GraphQLCachePolicy.c).a(RequestPriority.INTERACTIVE));
        if (this.f23070g != null) {
            Futures.a(a, this.f23070g, this.f23064a);
        }
        return Futures.a(a, this.f23069f, this.f23064a);
    }

    private Fb4aGraphSearchPhotoQueryString m26729a(int i, PandoraInstanceId pandoraInstanceId, @Nullable String str, @Nullable String str2) {
        GraphQlQueryString fb4aGraphSearchPhotoQueryString = new Fb4aGraphSearchPhotoQueryString();
        this.f23066c.a(fb4aGraphSearchPhotoQueryString);
        GraphSearchPandoraInstanceId graphSearchPandoraInstanceId = (GraphSearchPandoraInstanceId) pandoraInstanceId;
        fb4aGraphSearchPhotoQueryString.a("query", (String) this.f23067d.apply(graphSearchPandoraInstanceId.f17358a));
        fb4aGraphSearchPhotoQueryString.a("count", Integer.valueOf(i));
        fb4aGraphSearchPhotoQueryString.a("tsid", graphSearchPandoraInstanceId.f17359b);
        if (!Strings.isNullOrEmpty(str)) {
            fb4aGraphSearchPhotoQueryString.a("before_cursor", str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            fb4aGraphSearchPhotoQueryString.a("after_cursor", str2);
        }
        return fb4aGraphSearchPhotoQueryString;
    }
}
