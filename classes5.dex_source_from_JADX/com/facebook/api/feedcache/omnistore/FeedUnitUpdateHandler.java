package com.facebook.api.feedcache.omnistore;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedcache.omnistore.analytics.OmnistoreUpdateAnalyticLogger;
import com.facebook.api.feedcache.omnistore.util.FeedUnitUpdateUtil;
import com.facebook.api.feedcache.omnistore.util.OmnistoreUpdateUtil;
import com.facebook.api.feedtype.FeedType;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.model.ClientFeedUnitEdgeStoryTypeClassifier;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@UserScoped
/* compiled from: application_requests_social_context */
public class FeedUnitUpdateHandler {
    private static final Object f8832c = new Object();
    private final FeedUnitUpdateSubscriber f8833a;
    private final OmnistoreUpdateAnalyticLogger f8834b;

    private static FeedUnitUpdateHandler m14712b(InjectorLike injectorLike) {
        return new FeedUnitUpdateHandler(FeedUnitUpdateSubscriber.a(injectorLike), OmnistoreUpdateAnalyticLogger.b(injectorLike));
    }

    @Inject
    public FeedUnitUpdateHandler(FeedUnitUpdateSubscriber feedUnitUpdateSubscriber, OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger) {
        this.f8833a = feedUnitUpdateSubscriber;
        this.f8834b = omnistoreUpdateAnalyticLogger;
    }

    public final void m14719a(String str, String str2, FeedUnit feedUnit) {
        TracerDetour.a("FeedUnitUpdateHandler.saveFeedUnit", 490862920);
        try {
            if (FeedUnitUpdateUtil.m14737d(feedUnit)) {
                m14711a(str, str2, FeedUnitUpdateUtil.m14731a(feedUnit), 1, FeedUnitUpdateUtil.m14733b(feedUnit), FeedUnitUpdateUtil.m14736c(feedUnit));
                TracerDetour.a(1729870986);
            }
        } finally {
            TracerDetour.a(715795812);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler m14708a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8832c;	 Catch:{ all -> 0x006c }
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
        r1 = m14712b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8832c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler) r0;	 Catch:{  }
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
        r0 = f8832c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler");
    }

    public final void m14716a(FetchFeedResult fetchFeedResult) {
        TracerDetour.a("FeedUnitUpdateHandler.saveFeedUnits", -1383268035);
        try {
            if (FeedType.b == fetchFeedResult.g().f()) {
                m14713c(fetchFeedResult.d());
                TracerDetour.a(-1614357051);
            }
        } finally {
            TracerDetour.a(-2008541704);
        }
    }

    private void m14713c(ImmutableList<GraphQLFeedUnitEdge> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m14710a((GraphQLFeedUnitEdge) immutableList.get(i));
        }
    }

    private void m14714d(ImmutableList<ClientFeedUnitEdge> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m14709a((ClientFeedUnitEdge) immutableList.get(i));
        }
    }

    private void m14709a(ClientFeedUnitEdge clientFeedUnitEdge) {
        FeedUnit c = clientFeedUnitEdge.c();
        if ((c instanceof GraphQLStory) && "User".equals(clientFeedUnitEdge.z)) {
            m14711a(DedupableUtil.a(clientFeedUnitEdge), clientFeedUnitEdge.d(), FeedUnitUpdateUtil.m14731a(c), 1, FeedUnitUpdateUtil.m14733b(c), FeedUnitUpdateUtil.m14736c(c));
        }
    }

    private void m14710a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        FeedUnit c = graphQLFeedUnitEdge.c();
        String a = ClientFeedUnitEdgeStoryTypeClassifier.a(graphQLFeedUnitEdge);
        if ((c instanceof GraphQLStory) && "User".equals(a)) {
            m14711a(DedupableUtil.a(graphQLFeedUnitEdge), graphQLFeedUnitEdge.d(), FeedUnitUpdateUtil.m14731a(c), 1, FeedUnitUpdateUtil.m14733b(c), FeedUnitUpdateUtil.m14736c(c));
        }
    }

    private void m14711a(String str, String str2, String str3, int i, int i2, int i3) {
        this.f8834b.a(str, str2, str3, i, i2, i3);
        if (!StringUtil.a(new CharSequence[]{str})) {
            this.f8833a.b().saveObject(str, str2, FeedUnitTranscription.m14707a(str3, i, i2, i3));
        }
    }

    public final void m14718a(String str) {
        TracerDetour.a("FeedUnitUpdateHandler.deleteFeedUnit", 1953368281);
        try {
            this.f8833a.b().deleteObject(str);
        } finally {
            TracerDetour.a(-81180787);
        }
    }

    public final void m14717a(ImmutableList<String> immutableList) {
        TracerDetour.a("FeedUnitUpdateHandler.deleteFeedUnits", 1053352189);
        try {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                this.f8833a.b().deleteObject((String) immutableList.get(i));
            }
        } finally {
            TracerDetour.a(-1765073814);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m14715a() {
        /*
        r5 = this;
        r0 = "FeedUnitUpdateHandler.getCacheEntriesCount";
        r1 = 2133185563; // 0x7f25d41b float:2.2042393E38 double:1.053933703E-314;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = 0;
        r1 = r5.f8833a;	 Catch:{ all -> 0x0039 }
        r1 = r1.b();	 Catch:{ all -> 0x0039 }
        r2 = com.facebook.api.feed.util.FeedEdgeComparator.b;	 Catch:{ all -> 0x0039 }
        r3 = -1;
        r4 = com.facebook.omnistore.Collection.SortDirection.DESCENDING;	 Catch:{ all -> 0x0039 }
        r2 = r1.query(r2, r3, r4);	 Catch:{ all -> 0x0039 }
        r1 = 0;
    L_0x0019:
        r3 = r2.step();	 Catch:{ Throwable -> 0x002e }
        if (r3 == 0) goto L_0x0022;
    L_0x001f:
        r0 = r0 + 1;
        goto L_0x0019;
    L_0x0022:
        if (r2 == 0) goto L_0x0027;
    L_0x0024:
        r2.close();	 Catch:{  }
    L_0x0027:
        r1 = -1720280402; // 0xffffffff99769aae float:-1.2749139E-23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        return r0;
    L_0x002e:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0030 }
    L_0x0030:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0038;
    L_0x0033:
        if (r1 == 0) goto L_0x0046;
    L_0x0035:
        r2.close();	 Catch:{ Throwable -> 0x0041 }
    L_0x0038:
        throw r0;	 Catch:{  }
    L_0x0039:
        r0 = move-exception;
        r1 = -729086639; // 0xffffffffd48b0551 float:-4.7767172E12 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x0041:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);	 Catch:{  }
        goto L_0x0038;
    L_0x0046:
        r2.close();	 Catch:{  }
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler.a():int");
    }

    public final void m14720b(ImmutableList<ClientFeedUnitEdge> immutableList) {
        TracerDetour.a("FeedUnitUpdateHandler.synchronizedCacheWithHomeStoriesDB", 1247173563);
        try {
            int i;
            Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (i = 0; i < size; i++) {
                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) immutableList.get(i);
                if ((clientFeedUnitEdge.c() instanceof GraphQLStory) && "User".equals(clientFeedUnitEdge.A())) {
                    builder.c(clientFeedUnitEdge);
                }
            }
            int size2 = builder.b().size();
            i = m14715a();
            Builder builder2 = ImmutableList.builder();
            Builder builder3 = ImmutableList.builder();
            OmnistoreUpdateUtil.m14738a(builder.b(), builder2, builder3, this.f8833a);
            m14714d(builder2.b());
            m14717a(builder3.b());
            this.f8834b.c(size2, i, builder2.b().size(), builder3.b().size());
        } finally {
            TracerDetour.a(-80983065);
        }
    }
}
