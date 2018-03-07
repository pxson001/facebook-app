package com.facebook.orca.contacts.picker;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.search.UserNameSearchQuery.UserNameSearchQueryString;
import com.facebook.messaging.graphql.search.UserNameSearchQueryModels.UserNameSearchQueryModel;
import com.facebook.messaging.graphql.search.UserNameSearchQueryModels.UserNameSearchQueryModel.SearchResultsModel.NodesModel;
import com.facebook.messaging.graphql.search.UserNameSearchQueryModels.UserNameSearchQueryModel.SearchResultsModel.NodesModel.TimelineContextItemsModel.TimelineContextItemsNodesModel;
import com.facebook.messaging.service.model.SearchUserParams;
import com.facebook.messaging.service.model.SearchUserResult;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

@UserScoped
/* compiled from: num_selected */
public class SearchUsersFetcher {
    private static final Object f6091c = new Object();
    private final GraphQLQueryExecutor f6092a;
    private final ListeningExecutorService f6093b;

    private static SearchUsersFetcher m5809b(InjectorLike injectorLike) {
        return new SearchUsersFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    public final ListenableFuture<SearchUserResult> m5811a(final SearchUserParams searchUserParams) {
        String str = searchUserParams.b;
        UserNameSearchQueryString userNameSearchQueryString = new UserNameSearchQueryString();
        userNameSearchQueryString.a("results_limit", Integer.valueOf(20)).a("name_search_string", str);
        GraphQLRequest a = GraphQLRequest.a(userNameSearchQueryString);
        a.a(GraphQLCachePolicy.a);
        a.a(3600);
        return Futures.a(this.f6092a.a(a), new Function<GraphQLResult<UserNameSearchQueryModel>, SearchUserResult>(this) {
            final /* synthetic */ SearchUsersFetcher f6090b;

            public Object apply(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                Preconditions.checkNotNull(graphQLResult);
                return SearchUsersFetcher.m5806a(this.f6090b, searchUserParams, graphQLResult);
            }
        }, this.f6093b);
    }

    @Inject
    public SearchUsersFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f6092a = graphQLQueryExecutor;
        this.f6093b = listeningExecutorService;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.contacts.picker.SearchUsersFetcher m5807a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f6091c;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m5809b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6091c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.contacts.picker.SearchUsersFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.contacts.picker.SearchUsersFetcher) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f6091c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.contacts.picker.SearchUsersFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.contacts.picker.SearchUsersFetcher.a(com.facebook.inject.InjectorLike):com.facebook.orca.contacts.picker.SearchUsersFetcher");
    }

    public static SearchUserResult m5806a(SearchUsersFetcher searchUsersFetcher, SearchUserParams searchUserParams, GraphQLResult graphQLResult) {
        ImmutableSet a = searchUserParams.a();
        boolean contains = a.contains(Integer.valueOf(0));
        boolean contains2 = a.contains(Integer.valueOf(2));
        boolean contains3 = a.contains(Integer.valueOf(1));
        boolean contains4 = a.contains(Integer.valueOf(3));
        ImmutableList a2 = ((UserNameSearchQueryModel) graphQLResult.d()).m2315a().m2311a();
        Builder builder = contains ? ImmutableList.builder() : null;
        Builder builder2 = contains2 ? ImmutableList.builder() : null;
        Builder builder3 = contains3 ? ImmutableList.builder() : null;
        Builder builder4 = contains4 ? ImmutableList.builder() : null;
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a2.get(i);
            User b = m5810b(nodesModel);
            if (contains && builder != null && GraphQLFriendshipStatus.ARE_FRIENDS.equals(nodesModel.m2299k())) {
                builder.c(b);
            } else if (contains2 && builder2 != null && nodesModel.m2302n()) {
                builder2.c(b);
            } else if (contains3 && builder3 != null && m5808a(nodesModel)) {
                builder3.c(b);
            } else if (contains4) {
                builder4.c(b);
            }
        }
        return new SearchUserResult(searchUserParams.b(), contains ? builder.b() : null, contains2 ? builder2.b() : null, contains3 ? builder3.b() : null, contains4 ? builder4.b() : null);
    }

    private static boolean m5808a(NodesModel nodesModel) {
        return nodesModel.m2303o().m2268a() > 0;
    }

    private static User m5810b(NodesModel nodesModel) {
        String a;
        UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, nodesModel.m2300l());
        a2.g = new Name(null, null, nodesModel.m2304p());
        a2 = a2;
        a2.l = nodesModel.m2307s();
        a2 = a2;
        a2.n = nodesModel.m2305q().m2276a();
        a2 = a2;
        a2.A = nodesModel.m2301m();
        a2 = a2;
        a2.t = (float) nodesModel.m2298j();
        a2 = a2;
        ImmutableList a3 = nodesModel.m2306r().m2292a();
        if (a3.size() > 0) {
            a = ((TimelineContextItemsNodesModel) a3.get(0)).m2289a().m2286a();
        } else {
            a = null;
        }
        a2.x = a;
        return a2.aa();
    }
}
