package com.facebook.search.results.fragment.spec;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SEE_ALL_SUGGESTED_EVENTS_TAP */
public class GraphSearchResultFragmentSpecificationRegistry {
    private static volatile GraphSearchResultFragmentSpecificationRegistry f23150b;
    private final ImmutableMap<SearchResultsTab, Lazy<? extends GraphSearchResultFragmentSpecification>> f23151a;

    public static com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry m26828a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23150b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry.class;
        monitor-enter(r1);
        r0 = f23150b;	 Catch:{ all -> 0x003a }
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
        r0 = m26829b(r0);	 Catch:{ all -> 0x0035 }
        f23150b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23150b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry.a(com.facebook.inject.InjectorLike):com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry");
    }

    private static GraphSearchResultFragmentSpecificationRegistry m26829b(InjectorLike injectorLike) {
        return new GraphSearchResultFragmentSpecificationRegistry(IdBasedSingletonScopeProvider.b(injectorLike, 10578), IdBasedSingletonScopeProvider.b(injectorLike, 10582), IdBasedSingletonScopeProvider.b(injectorLike, 10585), IdBasedSingletonScopeProvider.b(injectorLike, 10586), IdBasedSingletonScopeProvider.b(injectorLike, 10588), IdBasedSingletonScopeProvider.b(injectorLike, 10591), IdBasedSingletonScopeProvider.b(injectorLike, 10592), IdBasedSingletonScopeProvider.b(injectorLike, 10590), IdBasedSingletonScopeProvider.b(injectorLike, 10583), IdBasedSingletonScopeProvider.b(injectorLike, 10587), IdBasedSingletonScopeProvider.b(injectorLike, 10589), IdBasedSingletonScopeProvider.b(injectorLike, 10580), IdBasedSingletonScopeProvider.b(injectorLike, 10584), IdBasedSingletonScopeProvider.b(injectorLike, 10579), IdBasedSingletonScopeProvider.b(injectorLike, 10594), IdBasedSingletonScopeProvider.b(injectorLike, 10593));
    }

    @Inject
    public GraphSearchResultFragmentSpecificationRegistry(Lazy<AppsFragmentSpec> lazy, Lazy<GroupsFragmentSpec> lazy2, Lazy<PagesFragmentSpec> lazy3, Lazy<PeopleFragmentSpec> lazy4, Lazy<PlacesFragmentSpec> lazy5, Lazy<TopFragmentSpec> lazy6, Lazy<TopReactionFragmentSpec> lazy7, Lazy<TopEntitiesFragmentSpec> lazy8, Lazy<LatestFragmentSpec> lazy9, Lazy<PhotosFragmentSpec> lazy10, Lazy<PostsFragmentSpec> lazy11, Lazy<EventsFragmentSpec> lazy12, Lazy<MarketplaceFragmentSpec> lazy13, Lazy<BlendedVideosFragmentSpec> lazy14, Lazy<VideosFragmentSpec> lazy15, Lazy<VideoChannelsFragmentSpec> lazy16) {
        this.f23151a = ImmutableMap.builder().b(SearchResultsTab.APPS, lazy).b(SearchResultsTab.GROUPS, lazy2).b(SearchResultsTab.PAGES, lazy3).b(SearchResultsTab.PEOPLE, lazy4).b(SearchResultsTab.PLACES, lazy5).b(SearchResultsTab.TOP, lazy6).b(SearchResultsTab.TOP_REACTION, lazy7).b(SearchResultsTab.TOP_ENTITIES, lazy8).b(SearchResultsTab.LATEST, lazy9).b(SearchResultsTab.PHOTOS, lazy10).b(SearchResultsTab.POSTS, lazy11).b(SearchResultsTab.EVENTS, lazy12).b(SearchResultsTab.MARKETPLACE, lazy13).b(SearchResultsTab.VIDEOS, lazy15).b(SearchResultsTab.BLENDED_VIDEOS, lazy14).b(SearchResultsTab.VIDEO_CHANNELS, lazy16).b();
    }

    public final AbstractFragmentSpec m26830a(SearchResultsTab searchResultsTab) {
        return (AbstractFragmentSpec) ((Lazy) this.f23151a.get(searchResultsTab)).get();
    }
}
