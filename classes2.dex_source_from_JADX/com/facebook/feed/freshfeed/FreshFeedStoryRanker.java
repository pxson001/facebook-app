package com.facebook.feed.freshfeed;

import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.data.freshfeed.ranking.ClientFeedUnitEdgeScorer;
import com.facebook.feed.data.freshfeed.ranking.ClientFeedUnitEdgeScorerProvider;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: search_typeahead */
public class FreshFeedStoryRanker implements FreshFeedRanker {
    private static volatile FreshFeedStoryRanker f5855g;
    private final FreshFeedConfigReader f5856a;
    private ClientFeedUnitEdgeScorer f5857b;
    private final Lazy<FbErrorReporter> f5858c;
    private final ClientFeedUnitEdgeScorerProvider f5859d;
    private long f5860e;
    private Clock f5861f;

    public static com.facebook.feed.freshfeed.FreshFeedStoryRanker m10014a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5855g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.freshfeed.FreshFeedStoryRanker.class;
        monitor-enter(r1);
        r0 = f5855g;	 Catch:{ all -> 0x003a }
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
        r0 = m10016b(r0);	 Catch:{ all -> 0x0035 }
        f5855g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5855g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.freshfeed.FreshFeedStoryRanker.a(com.facebook.inject.InjectorLike):com.facebook.feed.freshfeed.FreshFeedStoryRanker");
    }

    private static FreshFeedStoryRanker m10016b(InjectorLike injectorLike) {
        return new FreshFeedStoryRanker(FreshFeedConfigReader.m9080a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), (ClientFeedUnitEdgeScorerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ClientFeedUnitEdgeScorerProvider.class), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public FreshFeedStoryRanker(FreshFeedConfigReader freshFeedConfigReader, Lazy<FbErrorReporter> lazy, ClientFeedUnitEdgeScorerProvider clientFeedUnitEdgeScorerProvider, Clock clock) {
        this.f5856a = freshFeedConfigReader;
        this.f5858c = lazy;
        this.f5859d = clientFeedUnitEdgeScorerProvider;
        this.f5861f = clock;
    }

    private void m10015a() {
        TracerDetour.a("FreshFeedStoryRanker.init", 1653434333);
        try {
            this.f5857b = this.f5859d.m9360a(this.f5856a.m9082a("{\"ctr_multiply_values\" : {\"base_values\" : { \"weight_final\" : \"1\", \"seen\" : {\"viewed\" : \"-10000\"}, \"!fresh\" : {\"viewed\" : \"-2000\"}}},\"ctr_value_features\": {\"seen\": \"client_has_seen\", \"fresh\": \"cur_client_story_age_ms < 540001\"}}"));
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f5858c.get()).m2346a("FreshFeedStoryRanker", e);
            this.f5857b = this.f5859d.m9360a("{\"ctr_multiply_values\" : {\"base_values\" : { \"weight_final\" : \"1\", \"seen\" : {\"viewed\" : \"-10000\"}, \"!fresh\" : {\"viewed\" : \"-2000\"}}},\"ctr_value_features\": {\"seen\": \"client_has_seen\", \"fresh\": \"cur_client_story_age_ms < 540001\"}}");
        } finally {
            TracerDetour.a(765963536);
        }
    }

    public final void mo1415a(List<ClientFeedUnitEdge> list) {
        if (this.f5857b == null || this.f5861f.mo211a() - this.f5860e > 1800000) {
            m10015a();
            this.f5857b.m30094a(true);
            this.f5860e = this.f5861f.mo211a();
        }
        TracerDetour.a("FreshFeedStoryRanker.rerank", 1557825931);
        try {
            this.f5857b.m30093a((List) list);
        } finally {
            TracerDetour.a(-109809095);
        }
    }
}
