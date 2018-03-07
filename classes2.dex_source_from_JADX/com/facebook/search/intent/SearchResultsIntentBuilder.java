package com.facebook.search.intent;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: java. */
public class SearchResultsIntentBuilder {
    private static final ImmutableSet<GraphQLGraphSearchResultsDisplayStyle> f18709a = ImmutableSet.of(GraphQLGraphSearchResultsDisplayStyle.AGGREGATED_STORIES, GraphQLGraphSearchResultsDisplayStyle.APPS, GraphQLGraphSearchResultsDisplayStyle.BLENDED, GraphQLGraphSearchResultsDisplayStyle.EVENTS, GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL, GraphQLGraphSearchResultsDisplayStyle.GROUPS, GraphQLGraphSearchResultsDisplayStyle.PAGES, GraphQLGraphSearchResultsDisplayStyle.PHOTOS, GraphQLGraphSearchResultsDisplayStyle.PLACES, GraphQLGraphSearchResultsDisplayStyle.STORIES, GraphQLGraphSearchResultsDisplayStyle.TRENDING_FINITE_SERP_SEE_MORE, GraphQLGraphSearchResultsDisplayStyle.USERS, GraphQLGraphSearchResultsDisplayStyle.VIDEOS, GraphQLGraphSearchResultsDisplayStyle.VIDEOS_LIVE, GraphQLGraphSearchResultsDisplayStyle.VIDEOS_WEB);
    private static volatile SearchResultsIntentBuilder f18710f;
    private final Provider<ComponentName> f18711b;
    private final Provider<Boolean> f18712c;
    private final QeAccessor f18713d;
    private final ImmutableMap<GraphQLGraphSearchResultsDisplayStyle, Integer> f18714e;

    public static com.facebook.search.intent.SearchResultsIntentBuilder m26283a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18710f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.intent.SearchResultsIntentBuilder.class;
        monitor-enter(r1);
        r0 = f18710f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m26285b(r0);	 Catch:{ all -> 0x0035 }
        f18710f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18710f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.intent.SearchResultsIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.search.intent.SearchResultsIntentBuilder");
    }

    private static SearchResultsIntentBuilder m26285b(InjectorLike injectorLike) {
        return new SearchResultsIntentBuilder(IdBasedProvider.m1811a(injectorLike, 12), IdBasedProvider.m1811a(injectorLike, 4323), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public SearchResultsIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider, Provider<Boolean> provider2, QeAccessor qeAccessor) {
        this.f18711b = provider;
        this.f18712c = provider2;
        this.f18713d = qeAccessor;
        Builder builder = new Builder();
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.BLENDED, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.STORIES, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.AGGREGATED_STORIES, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.APPS, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_ENTITIES_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.EVENTS, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_ENTITIES_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.GROUPS, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_ENTITIES_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.PAGES, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_ENTITIES_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.USERS, Integer.valueOf(this.f18713d.mo596a(ExperimentsForSearchAbTestModule.f7400W, false) ? FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FRAGMENT.ordinal() : FragmentConstants$ContentFragmentType.SEARCH_RESULTS_ENTITIES_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.PLACES, Integer.valueOf(this.f18713d.mo596a(ExperimentsForSearchAbTestModule.ah, false) ? FragmentConstants$ContentFragmentType.SEARCH_RESULTS_PLACES_FRAGMENT.ordinal() : FragmentConstants$ContentFragmentType.SEARCH_RESULTS_ENTITIES_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.PHOTOS, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_PANDORA_PHOTOS_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS_LIVE, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS_WEB, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FRAGMENT.ordinal()));
        builder.m609b(GraphQLGraphSearchResultsDisplayStyle.TRENDING_FINITE_SERP_SEE_MORE, Integer.valueOf(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal()));
        this.f18714e = builder.m610b();
    }

    public static boolean m26284a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        return f18709a.contains(graphQLGraphSearchResultsDisplayStyle);
    }

    public final Intent m26287a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, String str, String str2, String str3, SearchResultsSource searchResultsSource, SearchTypeaheadSession searchTypeaheadSession) {
        if (m26284a(graphQLGraphSearchResultsDisplayStyle)) {
            return m26281a(((Integer) this.f18714e.get(graphQLGraphSearchResultsDisplayStyle)).intValue(), searchTypeaheadSession, graphQLGraphSearchResultsDisplayStyle, str, str2, str3, null, searchResultsSource, null);
        }
        throw new IllegalArgumentException("Unsupported display style: " + graphQLGraphSearchResultsDisplayStyle);
    }

    public final Intent m26286a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, String str, String str2, String str3, SearchResultsSource searchResultsSource, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, SearchTypeaheadSession searchTypeaheadSession) {
        if (m26284a(graphQLGraphSearchResultsDisplayStyle)) {
            return m26281a(((Integer) this.f18714e.get(graphQLGraphSearchResultsDisplayStyle)).intValue(), searchTypeaheadSession, graphQLGraphSearchResultsDisplayStyle, str, str2, str3, null, searchResultsSource, null).putExtra("source_module_role", graphQLGraphSearchResultRole.toString());
        }
        throw new IllegalArgumentException("Unsupported display style: " + graphQLGraphSearchResultsDisplayStyle);
    }

    public final Intent m26289a(String str, @Nullable String str2, String str3, SearchResultsSource searchResultsSource, Surface surface, SearchTypeaheadSession searchTypeaheadSession) {
        return m26282a(str, searchResultsSource, surface, searchTypeaheadSession).putExtra("reaction_session_id", str2).putExtra("semantic", str3);
    }

    public final Intent m26292a(String str, String str2, @Nullable String str3, @Nullable String str4, SearchResultsSource searchResultsSource, Surface surface, @Nullable SearchTypeaheadSession searchTypeaheadSession) {
        return m26282a(str2, searchResultsSource, surface, searchTypeaheadSession).putExtra("place_id", str).putExtra("ranking_data", str3).putExtra("reaction_session_id", str4);
    }

    public final Intent m26295b(String str, String str2, @Nullable String str3, SearchResultsSource searchResultsSource, Surface surface, @Nullable SearchTypeaheadSession searchTypeaheadSession) {
        return m26292a(str, str2, null, str3, searchResultsSource, surface, searchTypeaheadSession);
    }

    private Intent m26282a(String str, SearchResultsSource searchResultsSource, Surface surface, @Nullable SearchTypeaheadSession searchTypeaheadSession) {
        Intent a = m26290a(str, SearchQueryFunctions.a(GraphQLGraphSearchResultsDisplayStyle.BLENDED, str), "content", searchResultsSource, searchTypeaheadSession == null ? SearchTypeaheadSession.a : searchTypeaheadSession, ExactMatchInputExactMatch.FALSE);
        a.putExtra("reaction_surface", surface);
        return a;
    }

    public final Intent m26293a(String str, String str2, String str3, String str4, SearchResultsSource searchResultsSource, SearchTypeaheadSession searchTypeaheadSession, ExactMatchInputExactMatch exactMatchInputExactMatch) {
        return m26281a(FragmentConstants$ContentFragmentType.SEARCH_FRAGMENT.ordinal(), searchTypeaheadSession, null, str, str2, str3, str4, searchResultsSource, exactMatchInputExactMatch);
    }

    public final Intent m26290a(String str, String str2, String str3, SearchResultsSource searchResultsSource, SearchTypeaheadSession searchTypeaheadSession, ExactMatchInputExactMatch exactMatchInputExactMatch) {
        return m26281a(FragmentConstants$ContentFragmentType.SEARCH_FRAGMENT.ordinal(), searchTypeaheadSession, null, str, str2, str3, null, searchResultsSource, exactMatchInputExactMatch);
    }

    public final Intent m26291a(String str, String str2, String str3, SearchResultsSource searchResultsSource, SearchTypeaheadSession searchTypeaheadSession, ExactMatchInputExactMatch exactMatchInputExactMatch, ScopedEntityType scopedEntityType, String str4, String str5) {
        return m26281a(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal(), searchTypeaheadSession, null, str, str2, str3, null, searchResultsSource, exactMatchInputExactMatch).putExtra("graph_search_scoped_entity_type", scopedEntityType).putExtra("graph_search_scoped_entity_id", str4).putExtra("graph_search_scoped_entity_name", str5);
    }

    public final Intent m26288a(SearchTypeaheadSession searchTypeaheadSession, String str, String str2, SearchResultsSource searchResultsSource) {
        String a;
        if (((Boolean) this.f18712c.get()).booleanValue()) {
            a = StringFormatUtil.a("keywords_topic_trending(%s)", new Object[]{str});
        } else {
            a = SearchQueryFunctions.j(str);
        }
        return m26290a(str2, a, "news_v2", searchResultsSource, searchTypeaheadSession, ExactMatchInputExactMatch.FALSE);
    }

    public final Intent m26294b(SearchTypeaheadSession searchTypeaheadSession, String str, String str2, SearchResultsSource searchResultsSource) {
        return m26281a(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal(), searchTypeaheadSession, GraphQLGraphSearchResultsDisplayStyle.STORIES, str, SearchQueryFunctions.m(str2), "content", null, searchResultsSource, ExactMatchInputExactMatch.FALSE);
    }

    public final Intent m26296c(SearchTypeaheadSession searchTypeaheadSession, String str, String str2, SearchResultsSource searchResultsSource) {
        return m26281a(FragmentConstants$ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal(), searchTypeaheadSession, GraphQLGraphSearchResultsDisplayStyle.STORIES, str, SearchQueryFunctions.n(str2), "content", null, searchResultsSource, ExactMatchInputExactMatch.FALSE);
    }

    private Intent m26281a(int i, SearchTypeaheadSession searchTypeaheadSession, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, String str, String str2, String str3, String str4, SearchResultsSource searchResultsSource, ExactMatchInputExactMatch exactMatchInputExactMatch) {
        String str5 = null;
        Intent putExtra = new Intent().setComponent((ComponentName) this.f18711b.get()).putExtra("target_fragment", i).putExtra("typeahead_session_id", searchTypeaheadSession.b).putExtra("candidate_session_id", searchTypeaheadSession.c).putExtra("display_style", graphQLGraphSearchResultsDisplayStyle != null ? graphQLGraphSearchResultsDisplayStyle.toString() : null).putExtra("query_title", str).putExtra("query_function", str2).putExtra("query_vertical", str3).putExtra("graph_search_keyword_type", str4).putExtra("source", searchResultsSource != null ? searchResultsSource.toString() : null);
        String str6 = "exact_match";
        if (exactMatchInputExactMatch != null) {
            str5 = exactMatchInputExactMatch.toString();
        }
        return putExtra.putExtra(str6, str5);
    }
}
