package com.facebook.feed.loader;

import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilder;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.user.model.User;
import javax.inject.Inject;

@UserScoped
/* compiled from: policies */
public class FeedDataLoaderHelper {
    private static final Object f9515b = new Object();
    private final Lazy<User> f9516a;

    private static FeedDataLoaderHelper m14501b(InjectorLike injectorLike) {
        return new FeedDataLoaderHelper(IdBasedLazy.m1808a(injectorLike, 3595));
    }

    @Inject
    public FeedDataLoaderHelper(Lazy<User> lazy) {
        this.f9516a = lazy;
    }

    public final boolean m14502a(FeedType feedType, long j, GraphQLStory graphQLStory) {
        if (Name.f5048c.equals(feedType.f5044g)) {
            return true;
        }
        if (!feedType.f5044g.equals(Name.f5046a)) {
            return false;
        }
        if (GraphQLHelper.m22511j(graphQLStory) == GraphQLRedSpaceVisibilityState.REDSPACE_ONLY) {
            return false;
        }
        if (graphQLStory.m22326L() != null || OptimisticPostStoryBuilder.a(graphQLStory)) {
            return true;
        }
        return Long.parseLong(((User) this.f9516a.get()).f3598a) == j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.feed.loader.FeedDataLoaderHelper m14500a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9515b;	 Catch:{ all -> 0x006c }
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
        r1 = m14501b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9515b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.feed.loader.FeedDataLoaderHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.feed.loader.FeedDataLoaderHelper) r0;	 Catch:{  }
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
        r0 = f9515b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.feed.loader.FeedDataLoaderHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.loader.FeedDataLoaderHelper.a(com.facebook.inject.InjectorLike):com.facebook.feed.loader.FeedDataLoaderHelper");
    }
}
