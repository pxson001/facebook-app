package com.facebook.qrcode.fetcher;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.qrcode.graphql.QRCodeGraphQLModels.FetchQRCodesQueryModel;
import com.facebook.qrcode.graphql.QRCodeGraphQLModels.FetchQRCodesQueryModel.AllQrcodesModel.EdgesModel;
import com.facebook.qrcode.graphql.QRCodeGraphQLModels.FetchQRCodesQueryModel.AllQrcodesModel.EdgesModel.NodeModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: link_tag */
public class QRCodeFetcher {
    public final ListeningExecutorService f8636a;
    public final GraphQLQueryExecutor f8637b;

    /* compiled from: link_tag */
    public class C12911 implements Function<GraphQLResult<FetchQRCodesQueryModel>, String> {
        final /* synthetic */ QRCodeFetcher f8635a;

        public C12911(QRCodeFetcher qRCodeFetcher) {
            this.f8635a = qRCodeFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchQRCodesQueryModel) graphQLResult.e).m8665a() == null) {
                return null;
            }
            ImmutableList asList = ((FetchQRCodesQueryModel) graphQLResult.e).m8665a().m8660a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                NodeModel a = ((EdgesModel) asList.get(i)).m8656a();
                if (a != null && a.m8652k() && a.m8651j() != null && a.m8651j().m8641a() != null) {
                    return a.m8651j().m8641a();
                }
            }
            return null;
        }
    }

    public static QRCodeFetcher m8599a(InjectorLike injectorLike) {
        return new QRCodeFetcher(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public QRCodeFetcher(ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f8636a = listeningExecutorService;
        this.f8637b = graphQLQueryExecutor;
    }
}
