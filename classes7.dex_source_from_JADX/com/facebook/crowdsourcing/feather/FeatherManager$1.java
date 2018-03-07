package com.facebook.crowdsourcing.feather;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.protocol.graphql.FeatherQueriesModels.FeatherQuestionsQueryModel;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Strings;

/* compiled from: com.facebook.zero.notification.ZeroPersistentNotificationService.SHOW */
public class FeatherManager$1 extends AbstractDisposableFutureCallback<GraphQLResult<FeatherQuestionsQueryModel>> {
    final /* synthetic */ String f17393a;
    final /* synthetic */ FeatherManager f17394b;

    public FeatherManager$1(FeatherManager featherManager, String str) {
        this.f17394b = featherManager;
        this.f17393a = str;
    }

    protected final void m21281a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((FeatherQuestionsQueryModel) graphQLResult.e).m2381a() == null || ((FeatherQuestionsQueryModel) graphQLResult.e).m2381a().isEmpty() || Strings.isNullOrEmpty(((FeatherQuestionsQueryModel) graphQLResult.e).m2384j())) {
            this.f17394b.h = null;
            this.f17394b.i = null;
            this.f17394b.j = null;
            this.f17394b.f.b(FunnelRegistry.S, "prefetch_successful_no_data");
            return;
        }
        this.f17394b.f.b(FunnelRegistry.S, "prefetch_successful");
        this.f17394b.h = this.f17393a;
        this.f17394b.i = ((FeatherQuestionsQueryModel) graphQLResult.e).m2384j();
        this.f17394b.j = ((FeatherQuestionsQueryModel) graphQLResult.e).m2381a();
    }

    protected final void m21282a(Throwable th) {
        this.f17394b.f.b(FunnelRegistry.S, "prefetch_failed");
        this.f17394b.a.a("Feather", "Failed to prefetch Feather questions");
    }
}
