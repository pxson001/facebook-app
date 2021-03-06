package com.facebook.composer.minutiae.protocol;

import android.support.v4.util.Pair;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: time_since_creation */
public class MinutiaeTaggableObjectsPreloader {
    public static final Ordering<MinutiaeVerbModelEdge> f1696d = Ordering.a(new C01611());
    private static final Object f1697e = new Object();
    public final MinutiaeTaggableObjectsFetcher f1698a;
    private final DefaultAndroidThreadUtil f1699b;
    public final List<Pair<FetchMinutiaeTaggableObjectsParams, ListenableFuture<GraphQLResult<FetchTaggableObjectsQueryModel>>>> f1700c = new ArrayList();

    /* compiled from: time_since_creation */
    final class C01611 implements Comparator<MinutiaeVerbModelEdge> {
        C01611() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((MinutiaeVerbModelEdge) obj).f1703a.m() - ((MinutiaeVerbModelEdge) obj2).f1703a.m();
        }
    }

    /* compiled from: time_since_creation */
    public class C01622 implements Predicate<Pair<FetchMinutiaeTaggableObjectsParams, ListenableFuture<GraphQLResult<FetchTaggableObjectsQueryModel>>>> {
        final /* synthetic */ MinutiaeTaggableObjectsPreloader f1695a;

        public C01622(MinutiaeTaggableObjectsPreloader minutiaeTaggableObjectsPreloader) {
            this.f1695a = minutiaeTaggableObjectsPreloader;
        }

        public boolean apply(@Nullable Object obj) {
            return FutureUtils.c((Future) ((Pair) obj).b);
        }
    }

    private static MinutiaeTaggableObjectsPreloader m1693b(InjectorLike injectorLike) {
        return new MinutiaeTaggableObjectsPreloader(MinutiaeTaggableObjectsFetcher.m1686a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsPreloader m1692a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f1697e;	 Catch:{ all -> 0x006c }
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
        r1 = m1693b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f1697e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsPreloader) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsPreloader) r0;	 Catch:{  }
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
        r0 = f1697e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsPreloader) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsPreloader.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsPreloader");
    }

    @Inject
    public MinutiaeTaggableObjectsPreloader(MinutiaeTaggableObjectsFetcher minutiaeTaggableObjectsFetcher, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f1698a = minutiaeTaggableObjectsFetcher;
        this.f1699b = defaultAndroidThreadUtil;
    }

    @Nullable
    public final ListenableFuture<GraphQLResult<FetchTaggableObjectsQueryModel>> m1694a(FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams) {
        this.f1699b.a();
        Iterables.a(this.f1700c, new C01622(this));
        for (Pair pair : this.f1700c) {
            Object obj;
            FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams2 = (FetchMinutiaeTaggableObjectsParams) pair.a;
            if (StringUtil.c(fetchMinutiaeTaggableObjectsParams2.f1638c, fetchMinutiaeTaggableObjectsParams.f1638c) && StringUtil.c(fetchMinutiaeTaggableObjectsParams2.f1637b, fetchMinutiaeTaggableObjectsParams.f1637b) && StringUtil.c(fetchMinutiaeTaggableObjectsParams2.f1636a, fetchMinutiaeTaggableObjectsParams.f1636a) && fetchMinutiaeTaggableObjectsParams2.f1644i == fetchMinutiaeTaggableObjectsParams.f1644i && fetchMinutiaeTaggableObjectsParams2.f1640e == fetchMinutiaeTaggableObjectsParams.f1640e && fetchMinutiaeTaggableObjectsParams2.f1643h == fetchMinutiaeTaggableObjectsParams.f1643h && fetchMinutiaeTaggableObjectsParams2.f1639d == fetchMinutiaeTaggableObjectsParams.f1639d && StringUtil.c(fetchMinutiaeTaggableObjectsParams2.f1645j, fetchMinutiaeTaggableObjectsParams.f1645j)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return (ListenableFuture) pair.b;
            }
        }
        return null;
    }
}
