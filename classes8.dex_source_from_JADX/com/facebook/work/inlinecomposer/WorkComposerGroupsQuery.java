package com.facebook.work.inlinecomposer;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerMultiRowInjectedFeedAdapter.3;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.work.inlinecomposer.protocol.FetchTopComposerGroups.FetchTopComposerGroupsString;
import com.facebook.work.inlinecomposer.protocol.FetchTopComposerGroupsModels.FetchTopComposerGroupsModel;
import com.facebook.work.inlinecomposer.protocol.FetchTopComposerGroupsModels.FetchTopComposerGroupsModel.AccountUserModel.GroupsModel.NodesModel;
import com.facebook.work.inlinecomposer.protocol.FetchTopComposerGroupsModels.FetchTopComposerGroupsModel.AccountUserModel.GroupsModel.NodesModel.GroupPurposesModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: location_opt_in_feed_unit_click */
public class WorkComposerGroupsQuery {
    private static WorkComposerGroupsQuery f9917d;
    private static final Object f9918e = new Object();
    private final GraphQLQueryExecutor f9919a;
    private final Executor f9920b;
    public 3 f9921c;

    private static WorkComposerGroupsQuery m11635b(InjectorLike injectorLike) {
        return new WorkComposerGroupsQuery(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WorkComposerGroupsQuery(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f9919a = graphQLQueryExecutor;
        this.f9920b = executorService;
    }

    private void m11634a(GraphQLCachePolicy graphQLCachePolicy, final 3 3) {
        GraphQlQueryString fetchTopComposerGroupsString = new FetchTopComposerGroupsString();
        fetchTopComposerGroupsString.a("iconWidth", Integer.valueOf(60));
        fetchTopComposerGroupsString.a("scale", Integer.valueOf(1));
        fetchTopComposerGroupsString.a("limit", Integer.valueOf(6));
        Futures.a(this.f9919a.a(GraphQLRequest.a(fetchTopComposerGroupsString).a(graphQLCachePolicy)), new FutureCallback<GraphQLResult<FetchTopComposerGroupsModel>>(this) {
            final /* synthetic */ WorkComposerGroupsQuery f9916b;

            public void onSuccess(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (3 != null) {
                    if (graphQLResult.e == null || ((FetchTopComposerGroupsModel) graphQLResult.e).m11692a() == null || ((FetchTopComposerGroupsModel) graphQLResult.e).m11692a().m11685a() == null || ((FetchTopComposerGroupsModel) graphQLResult.e).m11692a().m11685a().m11681a().isEmpty()) {
                        3.a(RegularImmutableList.a);
                        return;
                    }
                    ImmutableList a = ((FetchTopComposerGroupsModel) graphQLResult.e).m11692a().m11685a().m11681a();
                    Builder builder = ImmutableList.builder();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        Uri uri;
                        NodesModel nodesModel = (NodesModel) a.get(i);
                        String l = nodesModel.m11676l();
                        String m = nodesModel.m11677m();
                        if (nodesModel.m11674j() == null || nodesModel.m11674j().m11656a() == null || nodesModel.m11674j().m11656a().m11652a() == null) {
                            uri = null;
                        } else {
                            uri = Uri.parse(nodesModel.m11674j().m11656a().m11652a().m11648a());
                        }
                        Uri uri2 = uri;
                        if (uri2 == null) {
                            if (nodesModel.m11675k() == null || nodesModel.m11675k().m11666a().isEmpty()) {
                                uri = null;
                            } else {
                                uri = Uri.parse(((EdgesModel) nodesModel.m11675k().m11666a().get(0)).m11662a().a().a());
                            }
                            uri2 = uri;
                        }
                        builder.c(new WorkComposerGroup(l, m, uri2));
                    }
                    3.a(builder.b());
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f9920b);
    }

    public static WorkComposerGroupsQuery m11633a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkComposerGroupsQuery b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9918e) {
                WorkComposerGroupsQuery workComposerGroupsQuery;
                if (a2 != null) {
                    workComposerGroupsQuery = (WorkComposerGroupsQuery) a2.a(f9918e);
                } else {
                    workComposerGroupsQuery = f9917d;
                }
                if (workComposerGroupsQuery == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11635b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9918e, b3);
                        } else {
                            f9917d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workComposerGroupsQuery;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m11636a() {
        m11634a(GraphQLCachePolicy.a, this.f9921c);
    }

    public final void m11637b() {
        m11634a(GraphQLCachePolicy.d, this.f9921c);
    }
}
