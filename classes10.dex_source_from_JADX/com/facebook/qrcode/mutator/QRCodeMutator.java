package com.facebook.qrcode.mutator;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.qrcode.graphql.QRCodeGraphQLModels.CreateQRCodeMutationModel;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: like_icon_picker */
public class QRCodeMutator {
    public final ListeningExecutorService f8668a;
    public final GraphQLQueryExecutor f8669b;
    public final String f8670c;

    /* compiled from: like_icon_picker */
    public class C12921 implements Function<GraphQLResult<CreateQRCodeMutationModel>, String> {
        final /* synthetic */ QRCodeMutator f8667a;

        public C12921(QRCodeMutator qRCodeMutator) {
            this.f8667a = qRCodeMutator;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((CreateQRCodeMutationModel) graphQLResult.e).m8633a() == null || ((CreateQRCodeMutationModel) graphQLResult.e).m8633a().m8629j() == null || ((CreateQRCodeMutationModel) graphQLResult.e).m8633a().m8629j().m8607a() == null) {
                return null;
            }
            return ((CreateQRCodeMutationModel) graphQLResult.e).m8633a().m8629j().m8607a();
        }
    }

    public static QRCodeMutator m8685a(InjectorLike injectorLike) {
        return new QRCodeMutator(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public QRCodeMutator(ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, String str) {
        this.f8668a = listeningExecutorService;
        this.f8669b = graphQLQueryExecutor;
        this.f8670c = str;
    }
}
