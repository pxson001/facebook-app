package com.facebook.search.logging;

import android.view.View;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.SearchResultsRequestType;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchQuery;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.ResultsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel.ModulesModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel.ModulesModel.EdgesModel;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: The 'Only Me' option is missing in the privacy option list! */
public class SearchResultsPerformanceLogger {
    static final KeywordSearchLoadSequenceDefinition f21965a = new KeywordSearchLoadSequenceDefinition();
    static final KeywordSearchLoadMoreSequenceDefinition f21966b = new KeywordSearchLoadMoreSequenceDefinition();
    private static final String f21967c = "0";
    private static final ImmutableMap<String, String> f21968f = ImmutableMap.of("version", "2", "see_more", Boolean.TRUE.toString());
    private static volatile SearchResultsPerformanceLogger f21969l;
    private final Map<SearchResultsRequestType, List<SearchResultsFeedUnitHeightRegistry>> f21970d = new HashMap();
    private final Map<FeedUnit, SearchResultsFeedUnitHeightRegistry> f21971e = new HashMap();
    @GuardedBy("this")
    private final SequenceLogger f21972g;
    private final QuickPerformanceLogger f21973h;
    private final MonotonicClock f21974i;
    private final HashMultimap<SequenceDefinition, String> f21975j = HashMultimap.u();
    @GuardedBy("this")
    private final Set<String> f21976k = new HashSet();

    /* compiled from: The 'Only Me' option is missing in the privacy option list! */
    final class KeywordSearchLoadMoreSequenceDefinition extends AbstractSequenceDefinition {
        public KeywordSearchLoadMoreSequenceDefinition() {
            super(458765, "KeywordSearchResultPageLoadMore", false, ImmutableSet.of("com.facebook.search.results.fragment.feed.SearchResultsFeedFragment"));
        }
    }

    /* compiled from: The 'Only Me' option is missing in the privacy option list! */
    final class KeywordSearchLoadSequenceDefinition extends AbstractSequenceDefinition {
        public KeywordSearchLoadSequenceDefinition() {
            super(458764, "KeywordSearchResultPageLoad", false, ImmutableSet.of("com.facebook.search.results.fragment.feed.SearchResultsFeedFragment"));
        }
    }

    public static com.facebook.search.logging.SearchResultsPerformanceLogger m25495a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21969l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.logging.SearchResultsPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f21969l;	 Catch:{ all -> 0x003a }
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
        r0 = m25501b(r0);	 Catch:{ all -> 0x0035 }
        f21969l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21969l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.logging.SearchResultsPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.logging.SearchResultsPerformanceLogger");
    }

    private static SearchResultsPerformanceLogger m25501b(InjectorLike injectorLike) {
        return new SearchResultsPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchResultsPerformanceLogger(SequenceLogger sequenceLogger, MonotonicClock monotonicClock, QuickPerformanceLogger quickPerformanceLogger) {
        this.f21972g = sequenceLogger;
        this.f21974i = monotonicClock;
        this.f21973h = quickPerformanceLogger;
    }

    public final synchronized void m25508a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str) {
        m25502d();
        Sequence a = m25497a(m25496a(true), graphSearchQuerySpec.mo1213c());
        ImmutableMap b = str == null ? ImmutableBiMap.b("version", "2") : ImmutableMap.of("version", "2", "typeahead_sid", str);
        SequenceLoggerDetour.a(a, "tti", -1057993962);
        SequenceLoggerDetour.a(a, "pre_fetch", null, b, 1793143594);
        this.f21973h.b(458789);
    }

    public final synchronized void m25504a() {
        m25502d();
        SequenceLoggerDetour.a(m25497a(m25496a(true), "SEE_MORE_SEQUENCE"), "pre_fetch", null, f21968f, -755524231);
        this.f21973h.b(458789);
    }

    public final synchronized void m25506a(GraphSearchQuerySpec graphSearchQuerySpec) {
        KeywordSearchLoadMoreSequenceDefinition keywordSearchLoadMoreSequenceDefinition = f21966b;
        String c = graphSearchQuerySpec.mo1213c();
        if (this.f21972g.b(keywordSearchLoadMoreSequenceDefinition, c) == null) {
            Sequence a = this.f21972g.a(keywordSearchLoadMoreSequenceDefinition, c, null, this.f21974i.now());
            this.f21975j.a(keywordSearchLoadMoreSequenceDefinition, c);
            SequenceLoggerDetour.a(a, "pre_fetch", null, ImmutableBiMap.b("version", "2"), -169060021);
            this.f21973h.b(458789);
        }
    }

    public final synchronized void m25512a(SearchResultsRequestType searchResultsRequestType, KeywordSearchModuleFragment keywordSearchModuleFragment, ImmutableList<? extends FeedUnit> immutableList) {
        int i = 0;
        synchronized (this) {
            List list;
            List list2 = (List) this.f21970d.get(searchResultsRequestType);
            if (list2 == null) {
                LinkedList linkedList = new LinkedList();
                this.f21970d.put(searchResultsRequestType, linkedList);
                list = linkedList;
            } else {
                list = list2;
            }
            ImmutableList a = keywordSearchModuleFragment.m8536a();
            GraphQLGraphSearchResultRole jx_ = keywordSearchModuleFragment.jx_();
            int size = (keywordSearchModuleFragment.m8541g() == null || keywordSearchModuleFragment.m8541g().m8515a() == null) ? 0 : keywordSearchModuleFragment.m8541g().m8515a().size();
            SearchResultsFeedUnitHeightRegistry searchResultsFeedUnitHeightRegistry = new SearchResultsFeedUnitHeightRegistry(searchResultsRequestType, a, jx_, size);
            list.add(searchResultsFeedUnitHeightRegistry);
            int size2 = immutableList.size();
            while (i < size2) {
                FeedUnit feedUnit = (FeedUnit) immutableList.get(i);
                searchResultsFeedUnitHeightRegistry.m25455a(feedUnit);
                this.f21971e.put(feedUnit, searchResultsFeedUnitHeightRegistry);
                i++;
            }
        }
    }

    public final synchronized void m25505a(FeedUnit feedUnit, View view) {
        SearchResultsFeedUnitHeightRegistry searchResultsFeedUnitHeightRegistry = (SearchResultsFeedUnitHeightRegistry) this.f21971e.get(feedUnit);
        if (searchResultsFeedUnitHeightRegistry != null) {
            searchResultsFeedUnitHeightRegistry.m25456a(feedUnit, view, view.getHeight());
        }
    }

    public final synchronized void m25514b() {
        m25502d();
    }

    public final synchronized void m25511a(GraphSearchQuerySpec graphSearchQuerySpec, boolean z, String str) {
        m25510a(graphSearchQuerySpec, z, ImmutableList.of(str));
    }

    public final synchronized void m25510a(GraphSearchQuerySpec graphSearchQuerySpec, boolean z, Iterable<String> iterable) {
        Sequence b = this.f21972g.b(m25496a(z), graphSearchQuerySpec.mo1213c());
        if (b != null) {
            Sequence b2;
            if (b.f("pre_fetch")) {
                b2 = SequenceLoggerDetour.b(b, "pre_fetch", null, ImmutableMap.of("query_function", graphSearchQuerySpec.mo1212b(), "query_vertical", graphSearchQuerySpec.jH_()), -1697236527);
            } else {
                b2 = b;
            }
            for (String str : iterable) {
                SequenceLoggerDetour.a(b2, "network", str, ImmutableBiMap.b("id", str), -775959011);
                if (z) {
                    this.f21976k.add(str);
                }
            }
        }
    }

    public final synchronized void m25509a(GraphSearchQuerySpec graphSearchQuerySpec, boolean z, KeywordSearchQueryModel keywordSearchQueryModel, String str, @Nullable String str2) {
        Sequence b = this.f21972g.b(m25496a(z), graphSearchQuerySpec.mo1213c());
        if (b != null && b.c("network", str)) {
            SequenceLoggerDetour.a(SequenceLoggerDetour.b(b, "network", str, str2 == null ? ImmutableBiMap.a() : ImmutableBiMap.b("session_id", str2), -327131746), "post_fetch", str, m25498a(keywordSearchQueryModel, str), -208779824);
        }
    }

    public final synchronized boolean m25513a(GraphSearchQuerySpec graphSearchQuerySpec, ImmutableList<String> immutableList, boolean z, boolean z2) {
        boolean z3;
        AbstractSequenceDefinition a = m25496a(z);
        String c = graphSearchQuerySpec.mo1213c();
        Sequence b = this.f21972g.b(a, c);
        if (b == null) {
            z3 = true;
        } else {
            this.f21976k.removeAll(immutableList);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) immutableList.get(i);
                if (!b.c("post_fetch", str)) {
                    z3 = false;
                    break;
                }
                SequenceLoggerDetour.b(b, "post_fetch", str, null, 1673698480);
            }
            if (z2 || this.f21976k.isEmpty()) {
                SequenceLoggerDetour.b(b, "tti", 485673594);
            }
            if (this.f21976k.isEmpty()) {
                Object a2;
                try {
                    a2 = FbObjectMapper.i().a(this.f21970d);
                } catch (JsonProcessingException e) {
                    BLog.b(getClass(), "can't serialize the module view size", e);
                    a2 = e.getMessage();
                }
                this.f21972g.b(a, c, ImmutableBiMap.b("module_size", a2), this.f21974i.now());
                this.f21975j.c(a, c);
                this.f21973h.b(458789, (short) 2);
                m25503e();
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public final synchronized void m25516c() {
        m25502d();
        m25503e();
    }

    public final synchronized void m25515b(GraphSearchQuerySpec graphSearchQuerySpec) {
        m25499a(graphSearchQuerySpec, ImmutableBiMap.b("did_not_finish", Boolean.TRUE.toString()));
    }

    public final synchronized void m25507a(GraphSearchQuerySpec graphSearchQuerySpec, int i) {
        m25499a(graphSearchQuerySpec, ImmutableBiMap.b("request_timeout", String.valueOf(i)));
    }

    private void m25499a(GraphSearchQuerySpec graphSearchQuerySpec, ImmutableMap immutableMap) {
        String c = graphSearchQuerySpec.mo1213c();
        if (this.f21972g.b(f21965a, c) != null) {
            m25500a(f21965a, c, immutableMap);
        }
        if (this.f21972g.b(f21966b, c) != null) {
            m25500a(f21966b, c, immutableMap);
        }
        this.f21973h.d(458789);
        m25503e();
    }

    private synchronized Sequence<?> m25497a(SequenceDefinition sequenceDefinition, String str) {
        Sequence<?> b;
        b = this.f21972g.b(sequenceDefinition, str);
        if (b == null) {
            this.f21975j.a(sequenceDefinition, str);
            b = this.f21972g.a(sequenceDefinition, str, null, this.f21974i.now());
        }
        return b;
    }

    private synchronized void m25500a(AbstractSequenceDefinition abstractSequenceDefinition, String str, ImmutableMap immutableMap) {
        this.f21972g.b(abstractSequenceDefinition, str, immutableMap, this.f21974i.now());
        this.f21975j.c(abstractSequenceDefinition, str);
    }

    private synchronized void m25502d() {
        for (String a : this.f21975j.a(f21965a)) {
            this.f21972g.a(f21965a, a);
        }
        for (String a2 : this.f21975j.a(f21966b)) {
            this.f21972g.a(f21966b, a2);
        }
        m25503e();
        this.f21975j.g();
        this.f21973h.d(458789);
    }

    private static AbstractSequenceDefinition m25496a(boolean z) {
        return z ? f21965a : f21966b;
    }

    private synchronized void m25503e() {
        this.f21970d.clear();
        this.f21971e.clear();
        this.f21976k.clear();
    }

    private static ImmutableMap<String, String> m25498a(KeywordSearchQuery keywordSearchQuery, String str) {
        Builder builder = new Builder();
        builder.b("id", str);
        FilteredQueryModel a = keywordSearchQuery.m8635a();
        if (a == null) {
            return builder.b();
        }
        ModulesModel c = a.m8589c();
        if (c == null) {
            return builder.b();
        }
        ImmutableList c2 = c.m8573c();
        int size = c2.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            EdgesModel edgesModel = (EdgesModel) c2.get(i);
            if (edgesModel.m8564a() != null) {
                KeywordSearchModuleFragmentModel a2 = edgesModel.m8564a();
                ResultsModel g = a2.m8541g();
                String str2 = i2 + "_result";
                if (g == null || g.m8515a() == null) {
                    builder.b(str2, f21967c);
                } else {
                    builder.b(str2, String.valueOf(g.m8515a().size()));
                }
                builder.b(i2 + "_role", a2.jx_().toString());
                if (a2.m8536a() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    Object obj = 1;
                    ImmutableList a3 = a2.m8536a();
                    int size2 = a3.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) a3.get(i4);
                        if (obj != null) {
                            obj = null;
                        } else {
                            stringBuilder.append(',');
                        }
                        stringBuilder.append(graphQLGraphSearchResultsDisplayStyle.toString());
                    }
                    builder.b(i2 + "_display", stringBuilder.toString());
                }
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return builder.b();
    }
}
