package com.facebook.search.results.logging;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics;
import com.facebook.search.logging.api.SearchResultsAnalytics.ResultsState;
import com.facebook.search.results.model.SearchResults;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsGraphQLStoryFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsAnnotationUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsSpellCorrectionUnit;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SCROLL_FINISHED */
public class SearchResultsFeedLoggingProcessor {
    private static volatile SearchResultsFeedLoggingProcessor f23323b;
    private final SearchResultsLogger f23324a;

    public static com.facebook.search.results.logging.SearchResultsFeedLoggingProcessor m27017a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23323b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.results.logging.SearchResultsFeedLoggingProcessor.class;
        monitor-enter(r1);
        r0 = f23323b;	 Catch:{ all -> 0x003a }
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
        r0 = m27020b(r0);	 Catch:{ all -> 0x0035 }
        f23323b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23323b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.logging.SearchResultsFeedLoggingProcessor.a(com.facebook.inject.InjectorLike):com.facebook.search.results.logging.SearchResultsFeedLoggingProcessor");
    }

    private static SearchResultsFeedLoggingProcessor m27020b(InjectorLike injectorLike) {
        return new SearchResultsFeedLoggingProcessor(SearchResultsLogger.m25460a(injectorLike));
    }

    @Inject
    public SearchResultsFeedLoggingProcessor(SearchResultsLogger searchResultsLogger) {
        this.f23324a = searchResultsLogger;
    }

    public final void m27021a(SearchResultsContext searchResultsContext, SearchResults searchResults, SearchResultsFeedCollection searchResultsFeedCollection, @Nullable ImmutableList<Filters> immutableList, int i, int i2) {
        this.f23324a.m25469a((SearchResultsMutableContext) searchResultsContext, i, searchResults.m27026c(), i2, (ImmutableList) immutableList, m27016a(searchResultsFeedCollection), null);
        ImmutableList a = searchResults.m27024a();
        int size = a.size();
        for (int i3 = 0; i3 < size; i3++) {
            FeedUnit feedUnit = (FeedUnit) a.get(i3);
            int b = searchResultsFeedCollection.m27064b(feedUnit);
            m27019a(searchResultsFeedCollection, feedUnit, b, searchResultsContext);
            m27018a(feedUnit, b, i3 + 1 < size ? (FeedUnit) a.get(i3 + 1) : null, immutableList, searchResultsContext);
        }
    }

    private static void m27019a(SearchResultsFeedCollection searchResultsFeedCollection, FeedUnit feedUnit, int i, SearchResultsMutableContext searchResultsMutableContext) {
        if ((feedUnit instanceof GraphQLStory) || (feedUnit instanceof SearchResultsGraphQLStoryFeedUnit)) {
            GraphQLStory f = feedUnit instanceof SearchResultsGraphQLStoryFeedUnit ? ((SearchResultsGraphQLStoryFeedUnit) feedUnit).mo1333f() : (GraphQLStory) feedUnit;
            FeedProps c = FeedProps.c(f);
            String c2 = f.c();
            GraphQLGraphSearchResultRole a = searchResultsFeedCollection.m27054a(f);
            String b = searchResultsFeedCollection.m27066b(f);
            ObjectNode a2 = new ObjectNode(JsonNodeFactory.a).a("results_vertical", searchResultsMutableContext.m27102v().mo596l()).a("session_id", searchResultsMutableContext.m27102v().mo595k()).a("filter_type", SearchResultsAnalytics.a(searchResultsMutableContext.m27098l())).a("tapped_result_position", i).a("tapped_result_entity_id", c2);
            if (a != null) {
                a2.a("results_module_role", a.toString());
            }
            if (b != null) {
                a2.a("results_module_extra_logging", b);
            }
            TrackableFeedProps.a(c).h(a2.toString());
        }
    }

    private void m27018a(FeedUnit feedUnit, int i, @Nullable FeedUnit feedUnit2, @Nullable ImmutableList<Filters> immutableList, SearchResultsContext searchResultsContext) {
        if (feedUnit instanceof SearchResultsSpellCorrectionUnit) {
            SearchResultsSpellCorrectionUnit searchResultsSpellCorrectionUnit = (SearchResultsSpellCorrectionUnit) feedUnit;
            this.f23324a.m25473a((SearchResultsMutableContext) searchResultsContext, i, searchResultsSpellCorrectionUnit.f23517a, searchResultsSpellCorrectionUnit.f23520d, searchResultsSpellCorrectionUnit.f23521e);
        } else if (feedUnit instanceof SearchResultsCollectionUnit) {
            SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedUnit;
            this.f23324a.m25475a(searchResultsContext, i, immutableList, searchResultsCollectionUnit.mo1321k(), (String) searchResultsCollectionUnit.mo1322l().orNull(), (GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.m27156q().orNull(), (GraphQLObjectType) searchResultsCollectionUnit.m27155p().orNull(), (String) searchResultsCollectionUnit.mo1330m().orNull(), searchResultsCollectionUnit.m27157s().size());
        } else if ((feedUnit instanceof SearchResultsFeedImpressionTrackable) && !(feedUnit instanceof SearchResultsStoryUnit)) {
            this.f23324a.m25472a((SearchResultsMutableContext) searchResultsContext, i, ((SearchResultsFeedImpressionTrackable) feedUnit).mo1321k(), (String) ((SearchResultsFeedImpressionTrackable) feedUnit).mo1322l().orNull());
        } else if ((feedUnit instanceof SearchResultsAnnotationUnit) && feedUnit2 != null && (feedUnit2 instanceof SearchResultsStoryUnit)) {
            this.f23324a.m25472a((SearchResultsMutableContext) searchResultsContext, i, ((SearchResultsStoryUnit) feedUnit2).mo1321k(), (String) ((SearchResultsStoryUnit) feedUnit2).mo1322l().orNull());
        }
    }

    private static ResultsState m27016a(SearchResultsFeedCollection searchResultsFeedCollection) {
        if (searchResultsFeedCollection.m27063b() == 0) {
            return ResultsState.EMPTY;
        }
        if (searchResultsFeedCollection.m27069c() == 0) {
            return ResultsState.ONLY_RESULTS;
        }
        if (searchResultsFeedCollection.m27063b() > searchResultsFeedCollection.m27069c()) {
            return ResultsState.TOP_MODULE_AND_RESULTS;
        }
        return ResultsState.ONLY_TOP_MODULE;
    }
}
