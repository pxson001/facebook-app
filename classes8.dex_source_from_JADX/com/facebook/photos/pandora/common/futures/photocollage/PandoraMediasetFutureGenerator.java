package com.facebook.photos.pandora.common.futures.photocollage;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper;
import com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction;
import com.facebook.photos.pandora.protocols.PandoraQuery.PandoraMediasetQueryString;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediasetQueryModel;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: commercial_break */
public class PandoraMediasetFutureGenerator extends PandoraPhotoCollageFetchPhotosFutureGenerator {
    private final String f17420a;
    private final PandoraGraphQLParamImageHelper f17421b;
    private final GraphQLQueryExecutor f17422c;
    private final ExecutorService f17423d;
    private final PandoraResultConverterFunction f17424e;

    /* compiled from: commercial_break */
    class GraphQLToPandoraConverterFunction implements Function<GraphQLResult<PandoraMediasetQueryModel>, OperationResult> {
        final /* synthetic */ PandoraMediasetFutureGenerator f17419a;

        public GraphQLToPandoraConverterFunction(PandoraMediasetFutureGenerator pandoraMediasetFutureGenerator) {
            this.f17419a = pandoraMediasetFutureGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return OperationResult.a(ErrorCode.API_ERROR);
            }
            return OperationResult.a(new PandoraSlicedFeedResult(PandoraResultConverterFunction.m21397b((PandoraMediasetQueryModel) graphQLResult.e), PandoraResultConverterFunction.m21396a((PandoraMediasetQueryModel) graphQLResult.e)));
        }
    }

    @Inject
    public PandoraMediasetFutureGenerator(@Assisted String str, ExecutorService executorService, PandoraGraphQLParamImageHelper pandoraGraphQLParamImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, PandoraResultConverterFunction pandoraResultConverterFunction) {
        this.f17420a = str;
        this.f17423d = executorService;
        this.f17421b = pandoraGraphQLParamImageHelper;
        this.f17422c = graphQLQueryExecutor;
        this.f17424e = pandoraResultConverterFunction;
    }

    public final ListenableFuture<OperationResult> mo903a(@Nullable String str, @Nullable String str2, PandoraInstanceId pandoraInstanceId, int i, boolean z) {
        GraphQlQueryString pandoraMediasetQueryString = new PandoraMediasetQueryString();
        pandoraMediasetQueryString.a("node_id", this.f17420a);
        pandoraMediasetQueryString.a("count", String.valueOf(i));
        if (!Strings.isNullOrEmpty(str)) {
            pandoraMediasetQueryString.a("before", str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            pandoraMediasetQueryString.a("after", str2);
        }
        this.f17421b.m21387a(pandoraMediasetQueryString);
        return Futures.a(this.f17422c.a(GraphQLRequest.a(pandoraMediasetQueryString).a(GraphQLCachePolicy.c).a(z ? RequestPriority.INTERACTIVE : RequestPriority.CAN_WAIT)), new GraphQLToPandoraConverterFunction(this), this.f17423d);
    }
}
