package com.facebook.search.util;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.util.SearchQueryMatcher.Builder;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: menu_item_remove_bookmark */
public class GraphSearchConfig {
    private static final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8899a = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED);
    private static final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8900b = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.STORIES);
    private static final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8901c = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS);
    public static final SearchQueryMatcher f8902d = new Builder().m10657a().m10659b();
    public static final ImmutableMap<ScopedEntityType, SearchQueryMatcher> f8903e = ImmutableMap.builder().b(ScopedEntityType.GROUP, SearchQueryMatcher.m10660a(ScopedEntityType.GROUP).m10657a().m10659b()).b(ScopedEntityType.USER, SearchQueryMatcher.m10660a(ScopedEntityType.USER).m10657a().m10658a(SearchAbTestGatekeepers.r).m10659b()).b(ScopedEntityType.PAGE, SearchQueryMatcher.m10660a(ScopedEntityType.PAGE).m10657a().m10658a(SearchAbTestGatekeepers.q).m10659b()).b(ScopedEntityType.URL, SearchQueryMatcher.m10660a(ScopedEntityType.URL).m10657a().m10659b()).b(ScopedEntityType.VIDEO, SearchQueryMatcher.m10660a(ScopedEntityType.VIDEO).m10659b()).b(ScopedEntityType.MARKETPLACE, SearchQueryMatcher.m10660a(ScopedEntityType.MARKETPLACE).m10659b()).b();
    private static volatile GraphSearchConfig f8904h;
    public final GatekeeperStoreImpl f8905f;
    public final boolean f8906g;

    /* compiled from: menu_item_remove_bookmark */
    /* synthetic */ class C09241 {
        static final /* synthetic */ int[] f8898a = new int[ScopedEntityType.values().length];

        static {
            try {
                f8898a[ScopedEntityType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static com.facebook.search.util.GraphSearchConfig m10639a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8904h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.util.GraphSearchConfig.class;
        monitor-enter(r1);
        r0 = f8904h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10642b(r0);	 Catch:{ all -> 0x0035 }
        f8904h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8904h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.GraphSearchConfig.a(com.facebook.inject.InjectorLike):com.facebook.search.util.GraphSearchConfig");
    }

    private static GraphSearchConfig m10642b(InjectorLike injectorLike) {
        return new GraphSearchConfig(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GraphSearchConfig(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8905f = gatekeeperStoreImpl;
        this.f8906g = gatekeeperStoreImpl.a(SearchAbTestGatekeepers.f, false);
    }

    public static ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m10640a(@Nullable GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery == null) {
            return f8899a;
        }
        ScopedEntityType scopedEntityType = graphSearchQuery.h;
        if (scopedEntityType == null || graphSearchQuery.i != ScopedSearchStyle.TAB) {
            return f8899a;
        }
        switch (C09241.f8898a[scopedEntityType.ordinal()]) {
            case 1:
                return f8901c;
            default:
                return f8900b;
        }
    }

    public static boolean m10643b(@Nullable GraphSearchQuery graphSearchQuery) {
        return graphSearchQuery != null && graphSearchQuery.h == ScopedEntityType.VIDEO;
    }

    public static boolean m10641a(@Nullable TypeaheadRequest typeaheadRequest) {
        return (typeaheadRequest instanceof GraphSearchQuery) && m10643b((GraphSearchQuery) typeaheadRequest);
    }

    public static boolean m10644c(@Nullable GraphSearchQuery graphSearchQuery) {
        return graphSearchQuery != null && graphSearchQuery.h == ScopedEntityType.MARKETPLACE;
    }

    public final boolean m10645e(@Nullable GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery == null || graphSearchQuery.h == null || !this.f8906g) {
            return false;
        }
        boolean z = false;
        if (graphSearchQuery != null) {
            ScopedEntityType scopedEntityType = graphSearchQuery.h;
            if (scopedEntityType != null) {
                SearchQueryMatcher searchQueryMatcher = f8903e.containsKey(scopedEntityType) ? (SearchQueryMatcher) f8903e.get(scopedEntityType) : f8902d;
                GatekeeperStoreImpl gatekeeperStoreImpl = this.f8905f;
                boolean z2 = false;
                if ((searchQueryMatcher.f8928a == null || graphSearchQuery.h == searchQueryMatcher.f8928a) && ((searchQueryMatcher.f8929b == -1 || gatekeeperStoreImpl.a(searchQueryMatcher.f8929b, false)) && (!searchQueryMatcher.f8930c || graphSearchQuery.j()))) {
                    z2 = true;
                }
                z = z2;
            }
        }
        if (z && graphSearchQuery.i == ScopedSearchStyle.TAB && graphSearchQuery.j) {
            return true;
        }
        return false;
    }

    public final boolean m10646f(@Nullable GraphSearchQuery graphSearchQuery) {
        return m10645e(graphSearchQuery) && graphSearchQuery != null && graphSearchQuery.h == ScopedEntityType.GROUP;
    }

    public final boolean m10647g(@Nullable GraphSearchQuery graphSearchQuery) {
        Object obj;
        if (m10645e(graphSearchQuery) && graphSearchQuery != null && graphSearchQuery.h == ScopedEntityType.PAGE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = (m10645e(graphSearchQuery) && graphSearchQuery != null && graphSearchQuery.h == ScopedEntityType.USER) ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean m10648h(@Nullable GraphSearchQuery graphSearchQuery) {
        return this.f8906g && graphSearchQuery != null && graphSearchQuery.j() && (graphSearchQuery.i == null || graphSearchQuery.i == ScopedSearchStyle.SINGLE_STATE);
    }
}
