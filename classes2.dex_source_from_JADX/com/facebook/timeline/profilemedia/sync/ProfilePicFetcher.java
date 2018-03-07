package com.facebook.timeline.profilemedia.sync;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQL.FetchProfilePicGraphQLString;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQLModels.FetchProfilePicGraphQLModel;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

@UserScoped
/* compiled from: place_more_info_action */
public class ProfilePicFetcher {
    private static final Object f9811e = new Object();
    @Inject
    public GraphQLQueryExecutor f9812a;
    @Inject
    public LoggedInUserSessionManager f9813b;
    @Inject
    public GraphQLCacheManager f9814c;
    private GraphQLRequest<FetchProfilePicGraphQLModel> f9815d;

    private static ProfilePicFetcher m14835b(InjectorLike injectorLike) {
        ProfilePicFetcher profilePicFetcher = new ProfilePicFetcher();
        LoggedInUserSessionManager a = LoggedInUserSessionManager.m2511a(injectorLike);
        GraphQLCacheManager a2 = GraphQLCacheManager.m14847a(injectorLike);
        profilePicFetcher.f9812a = GraphQLQueryExecutor.m10435a(injectorLike);
        profilePicFetcher.f9813b = a;
        profilePicFetcher.f9814c = a2;
        return profilePicFetcher;
    }

    public final ListenableFuture<DefaultImageFieldsModel> m14837a() {
        return Futures.m2450a(this.f9812a.m10446a(m14836c()), new 1(this), MoreExecutors.m1815b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.timeline.profilemedia.sync.ProfilePicFetcher m14834a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f9811e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m14835b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9811e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.timeline.profilemedia.sync.ProfilePicFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.timeline.profilemedia.sync.ProfilePicFetcher) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f9811e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.timeline.profilemedia.sync.ProfilePicFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.profilemedia.sync.ProfilePicFetcher.a(com.facebook.inject.InjectorLike):com.facebook.timeline.profilemedia.sync.ProfilePicFetcher");
    }

    public final void m14838b() {
        this.f9814c.m14851a(m14836c());
    }

    private GraphQLRequest<FetchProfilePicGraphQLModel> m14836c() {
        if (this.f9815d == null) {
            TypedGraphQlQueryString fetchProfilePicGraphQLString = new FetchProfilePicGraphQLString();
            fetchProfilePicGraphQLString.m11314a("square_profile_pic_size_small", Integer.valueOf(GraphQlQueryDefaults.m11419b())).m11314a("square_profile_pic_size_big", Integer.valueOf(GraphQlQueryDefaults.m11421c())).m11314a("square_profile_pic_size_huge", Integer.valueOf(GraphQlQueryDefaults.m11422d()));
            this.f9815d = GraphQLRequest.m11587a(fetchProfilePicGraphQLString).m11594a(GraphQLCachePolicy.f7109a).m11590a(86400);
        }
        return this.f9815d;
    }
}
