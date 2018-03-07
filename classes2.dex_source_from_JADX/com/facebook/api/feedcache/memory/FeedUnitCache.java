package com.facebook.api.feedcache.memory;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feed.FeedMemoryCacheModule;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.module.Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbMutationRequest;
import com.facebook.api.story.FetchSingleStoryResult;
import com.facebook.cache.AbstractLruCacheListener;
import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLQuerySubscriber;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: sandbox/ */
public class FeedUnitCache {
    private static volatile FeedUnitCache f6303k;
    @GuardedBy("this")
    final TrackedLruCache<String, CacheEntry> f6304a;
    private final Clock f6305b;
    @GuardedBy("this")
    public final HashMultimap<String, String> f6306c;
    @GuardedBy("this")
    public final HashMultimap<String, String> f6307d;
    private final GraphQLQuerySubscriber f6308e;
    private final DefaultBlueServiceOperationFactory f6309f;
    private final FeedDbMutationService f6310g;
    private final boolean f6311h;
    @GuardedBy("this")
    private final List<FeedUnitCacheSubscriber> f6312i;
    private final FeedStoryMutator f6313j;

    /* compiled from: sandbox/ */
    class C02771 extends AbstractLruCacheListener<String, CacheEntry> {
        final /* synthetic */ FeedUnitCache f6339a;

        C02771(FeedUnitCache feedUnitCache) {
            this.f6339a = feedUnitCache;
        }

        public final void mo1391a(boolean z, Object obj, Object obj2, @Nullable Object obj3) {
            CacheEntry cacheEntry = (CacheEntry) obj2;
            FeedUnitCommon feedUnitCommon = cacheEntry.f17858a;
            synchronized (this.f6339a) {
                for (String str : cacheEntry.f17862e) {
                    this.f6339a.f6306c.mo412c(str, feedUnitCommon.mo2507g());
                    this.f6339a.f6307d.mo412c(feedUnitCommon.mo2507g(), str);
                }
            }
        }
    }

    /* compiled from: sandbox/ */
    public interface FeedUnitCacheSubscriber {
        void mo1887a(MutationType mutationType, Throwable th);

        void mo1890a(FeedUnit feedUnit);
    }

    /* compiled from: sandbox/ */
    class CacheEntry {
        volatile FeedUnit f17858a;
        @Nullable
        public final String f17859b;
        @Nullable
        public final String f17860c;
        @Nullable
        public final String f17861d;
        public Set<String> f17862e;
        final /* synthetic */ FeedUnitCache f17863f;

        public CacheEntry(FeedUnitCache feedUnitCache, FeedUnit feedUnit, @Nullable String str, @Nullable String str2, @Nullable String str3, Set<String> set) {
            this.f17863f = feedUnitCache;
            this.f17858a = feedUnit;
            this.f17859b = str;
            this.f17860c = str2;
            this.f17861d = str3;
            this.f17862e = ImmutableSet.copyOf((Collection) set);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equal(this.f17858a.mo2507g(), ((CacheEntry) obj).f17858a.mo2507g());
        }

        public int hashCode() {
            return Objects.hashCode(this.f17858a.mo2507g());
        }
    }

    public static com.facebook.api.feedcache.memory.FeedUnitCache m10541a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6303k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.memory.FeedUnitCache.class;
        monitor-enter(r1);
        r0 = f6303k;	 Catch:{ all -> 0x003a }
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
        r0 = m10546b(r0);	 Catch:{ all -> 0x0035 }
        f6303k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6303k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.memory.FeedUnitCache.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.memory.FeedUnitCache");
    }

    private static FeedUnitCache m10546b(InjectorLike injectorLike) {
        return new FeedUnitCache(VMMemoryInfoMethodAutoProvider.m2302a(injectorLike), FeedMemoryCacheModule.m10576b(), FeedStoryMutator.m10586b(injectorLike), FactoryMethodAutoProvider.m9805a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), GraphQLQuerySubscriber.m10365a(injectorLike), DefaultBlueServiceOperationFactory.m3782b(injectorLike), FeedDbMutationService.m9091a(injectorLike), Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider.m10689b(injectorLike));
    }

    @Inject
    public FeedUnitCache(VMMemoryInfo vMMemoryInfo, Integer num, FeedStoryMutator feedStoryMutator, Factory factory, Clock clock, GraphQLQuerySubscriber graphQLQuerySubscriber, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FeedDbMutationService feedDbMutationService, Boolean bool) {
        int intValue = vMMemoryInfo.m2306a() ? num.intValue() / 3 : num.intValue();
        this.f6313j = feedStoryMutator;
        this.f6305b = clock;
        this.f6306c = HashMultimap.m10690u();
        this.f6307d = HashMultimap.m10690u();
        this.f6309f = defaultBlueServiceOperationFactory;
        MemoryTrimmable a = factory.m9822a(intValue, "feed_unit", new C02771(this));
        factory.f5705c.mo1390a(a);
        this.f6304a = a;
        this.f6308e = graphQLQuerySubscriber;
        this.f6310g = feedDbMutationService;
        this.f6311h = bool.booleanValue();
        this.f6312i = new ArrayList();
    }

    public final synchronized void m10555a(FeedUnitCacheSubscriber feedUnitCacheSubscriber) {
        if (!this.f6312i.contains(feedUnitCacheSubscriber)) {
            this.f6312i.add(feedUnitCacheSubscriber);
        }
    }

    public final synchronized void m10566b(FeedUnitCacheSubscriber feedUnitCacheSubscriber) {
        this.f6312i.remove(feedUnitCacheSubscriber);
    }

    public final synchronized void m10557a(FeedUnit feedUnit) {
        for (FeedUnitCacheSubscriber a : this.f6312i) {
            a.mo1890a(feedUnit);
        }
    }

    public final synchronized void m10558a(FeedUnit feedUnit, MutationType mutationType, Throwable th) {
        for (FeedUnitCacheSubscriber a : this.f6312i) {
            a.mo1887a(mutationType, th);
        }
    }

    public final synchronized void m10567b(FeedUnit feedUnit) {
        Object g = feedUnit.mo2507g();
        if (g == null) {
            throw new RuntimeException("Cache id should not be null");
        }
        CacheEntry cacheEntry = (CacheEntry) this.f6304a.m9841a(g);
        if (cacheEntry == null) {
            BLog.b("FeedUnitCache", "Cache entry doesn't exist. cacheId=%s", new Object[]{g});
        } else {
            cacheEntry.f17858a = feedUnit;
        }
        m10557a(feedUnit);
    }

    public final synchronized void m10554a(FetchFeedResult fetchFeedResult) {
        if (fetchFeedResult.m22439d() != null) {
            ImmutableList d = fetchFeedResult.m22439d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i);
                m10544a(graphQLFeedUnitEdge.mo2540c(), DedupableUtil.m23084a(graphQLFeedUnitEdge), graphQLFeedUnitEdge.m19084d());
            }
        }
    }

    public final synchronized void m10569c(FeedUnit feedUnit) {
        CacheEntry h = m10549h(feedUnit.mo2507g());
        if (h != null) {
            m10544a(feedUnit, h.f17860c, h.f17861d);
        }
    }

    private FetchSingleStoryResult m10542a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        return new FetchSingleStoryResult(graphQLStory, DataFreshnessResult.FROM_CACHE_STALE, graphQLStory.T_());
    }

    public final FetchSingleStoryResult m10552a(String str) {
        return m10542a(m10550i(str));
    }

    public final FetchSingleStoryResult m10565b(String str) {
        FeedUnit d = m10570d((String) Preconditions.checkNotNull(str));
        if (d instanceof GraphQLStory) {
            return m10542a((GraphQLStory) d);
        }
        return null;
    }

    private synchronized void m10545a(FeedUnit feedUnit, @Nullable String str, String str2, String str3) {
        if (feedUnit != null) {
            Object a = FeedUnitTagHelper.m23086a(feedUnit, this.f6311h);
            this.f6304a.m9842a(feedUnit.mo2507g(), new CacheEntry(this, feedUnit, str, str2, str3, a));
            Iterator it = a.iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                this.f6306c.mo431a((Object) str4, (Object) feedUnit.mo2507g());
                this.f6307d.mo431a((Object) feedUnit.mo2507g(), (Object) str4);
            }
            m10571d(feedUnit);
        }
    }

    private void m10543a(MutableFlatBuffer mutableFlatBuffer) {
        String str = (String) mutableFlatBuffer.m21541b(0);
        String str2 = (String) mutableFlatBuffer.m21541b(1);
        String str3 = (String) mutableFlatBuffer.m21541b(2);
        String str4 = (String) mutableFlatBuffer.m21541b(3);
        if (this.f6310g == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str4)) {
            BLog.c("FeedUnitCache", "Error saving mutations. dedupKey=%s, sortKey=%s, feedType=%s, fetchTime=%s", new Object[]{str2, str3, str, str4});
        }
    }

    public final void m10571d(FeedUnit feedUnit) {
        MutableFlatBuffer w_ = feedUnit.w_();
        if (w_ != null && w_.f15024d) {
            String str = (String) w_.m21541b(0);
            String str2 = (String) w_.m21541b(1);
            String str3 = (String) w_.m21541b(2);
            String str4 = (String) w_.m21541b(3);
            if (this.f6310g != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
                byte[] array;
                ByteBuffer e;
                byte[] array2;
                if (w_.m21545b()) {
                    ByteBuffer c = w_.m21548c();
                    if (c != null) {
                        array = c.array();
                        if (w_.m21553d()) {
                            e = w_.m21554e();
                            if (e != null) {
                                array2 = e.array();
                                if (array == null || array2 != null) {
                                    this.f6310g.m9112a(new FeedDbMutationRequest(feedUnit, str, str2, str3, str4, array, array2));
                                }
                                return;
                            }
                        }
                        array2 = null;
                        if (array == null) {
                        }
                        this.f6310g.m9112a(new FeedDbMutationRequest(feedUnit, str, str2, str3, str4, array, array2));
                    }
                }
                array = null;
                if (w_.m21553d()) {
                    e = w_.m21554e();
                    if (e != null) {
                        array2 = e.array();
                        if (array == null) {
                        }
                        this.f6310g.m9112a(new FeedDbMutationRequest(feedUnit, str, str2, str3, str4, array, array2));
                    }
                }
                array2 = null;
                if (array == null) {
                }
                this.f6310g.m9112a(new FeedDbMutationRequest(feedUnit, str, str2, str3, str4, array, array2));
            }
        }
    }

    public final synchronized void m10564a(ArrayList<String> arrayList) {
        Set b = Sets.m1324b(arrayList);
        Set<Object> a = Sets.m1313a();
        for (String str : this.f6306c.mo418i()) {
            if (!b.contains(str)) {
                a.add(str);
            }
        }
        for (Object b2 : a) {
            this.f6304a.m9848b(b2);
        }
    }

    private synchronized void m10548g(String str) {
        this.f6304a.m9848b((Object) str);
        Params params = new Params(null, Lists.m1300a(str), null, DeleteMode.LOCAL_ONLY);
        Bundle bundle = new Bundle();
        bundle.putParcelable("deleteStoryParams", params);
        BlueServiceOperationFactoryDetour.a(this.f6309f, "feed_delete_story", bundle, -213450532).mo3452a();
    }

    private synchronized void m10544a(FeedUnit feedUnit, String str, String str2) {
        if (feedUnit != null) {
            if (feedUnit.mo2507g() != null) {
                CacheEntry h;
                if (str == null) {
                    h = m10549h(feedUnit.mo2507g());
                    if (h != null) {
                        str = h.f17860c;
                    }
                }
                h = m10549h(feedUnit.mo2507g());
                if (h == null || h.f17861d == null || str2 == null || h.f17861d.compareTo(str2) <= 0) {
                    MutableFlatBuffer w_ = feedUnit.w_();
                    if (w_ != null && w_.m21559f()) {
                        m10543a(w_);
                    }
                    m10545a(feedUnit, null, str, str2);
                    if (h != null) {
                        this.f6308e.m10368a(-1, ImmutableSet.of(feedUnit.mo2507g()));
                    }
                }
            }
        }
    }

    public final synchronized void m10556a(CacheVisitor cacheVisitor) {
        Set<String> a = Sets.m1313a();
        for (String j : cacheVisitor.a()) {
            a.addAll(m10551j(j));
        }
        for (String j2 : a) {
            CacheEntry h = m10549h(j2);
            if (h != null) {
                FeedUnit feedUnit = (FeedUnit) cacheVisitor.a(h.f17858a);
                if (feedUnit == null) {
                    m10548g(h.f17858a.mo2507g());
                } else if (feedUnit != h.f17858a) {
                    FetchTimeMsHelper.m22314a((FeedUnitCommon) feedUnit, feedUnit.T_() + 1);
                    m10545a(feedUnit, h.f17859b, h.f17860c, h.f17861d);
                } else {
                    m10571d(feedUnit);
                }
            }
        }
    }

    public final ImmutableList<String> m10568c(String str) {
        return m10551j(str);
    }

    public final synchronized FeedUnit m10570d(String str) {
        FeedUnit feedUnit = null;
        synchronized (this) {
            if (str != null) {
                CacheEntry h = m10549h(str);
                if (h != null) {
                    feedUnit = h.f17858a;
                }
            }
        }
        return feedUnit;
    }

    private CacheEntry m10549h(String str) {
        if (str == null) {
            return null;
        }
        CacheEntry cacheEntry;
        synchronized (this) {
            cacheEntry = (CacheEntry) this.f6304a.m9841a((Object) str);
        }
        return cacheEntry;
    }

    public final synchronized void m10573e(String str) {
        CacheEntry h = m10549h(str);
        if (!(h == null || !(h.f17858a instanceof Sponsorable) || ImpressionUtil.m29326c((Sponsorable) h.f17858a))) {
            ImpressionUtil.m29325b((Sponsorable) h.f17858a);
            FetchTimeMsHelper.m22314a(h.f17858a, this.f6305b.mo211a());
            m10571d(h.f17858a);
        }
    }

    public final synchronized void m10574f(String str) {
        if (str != null) {
            CacheEntry h = m10549h(str);
            if (!(h == null || h.f17858a == null)) {
                if ((h.f17858a instanceof GraphQLSurveyFeedUnit) || (h.f17858a instanceof GraphQLResearchPollFeedUnit)) {
                    FeedUnit a = FeedUnitMutator.a(h.f17858a).a(StoryVisibility.GONE).a(true).a();
                    h.f17858a = a;
                    m10571d(a);
                } else {
                    BLog.c(FeedUnitCache.class, "setSurveyOrResearchPollCompleted called with wrong type: %s", new Object[]{h.f17858a.getClass().getSimpleName()});
                }
            }
        }
    }

    public final synchronized void m10561a(String str, int i) {
        if (str != null) {
            CacheEntry h = m10549h(str);
            if (!(h == null || h.f17858a == null)) {
                if (h.f17858a instanceof ScrollableItemListFeedUnit) {
                    FeedUnit feedUnit = (ScrollableItemListFeedUnit) h.f17858a;
                    VisibleItemHelper.m26979a((ScrollableItemListFeedUnit) feedUnit, i);
                    m10571d(feedUnit);
                } else {
                    BLog.c(FeedUnitCache.class, "setVisibleItemIndex called with wrong type: %s", new Object[]{h.f17858a.getClass().getSimpleName()});
                }
            }
        }
    }

    public final synchronized void m10562a(String str, List<String> list) {
        if (str != null) {
            CacheEntry h = m10549h(str);
            if (h != null) {
                if (h.f17858a instanceof GraphQLPlaceReviewFeedUnit) {
                    FeedUnit feedUnit = h.f17858a;
                    feedUnit = (GraphQLPlaceReviewFeedUnit) FeedUnitMutator.a(h.f17858a).a(ImmutableList.copyOf((Collection) list)).a();
                    h.f17858a = feedUnit;
                    m10571d(feedUnit);
                } else {
                    BLog.c(FeedUnitCache.class, "setValidPYMKOrPlaceReviewItems called with wrong type: %s", new Object[]{h.f17858a.getClass().getSimpleName()});
                }
            }
        }
    }

    public final synchronized void m10559a(GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit) {
        m10571d((FeedUnit) graphQLGroupsYouShouldCreateFeedUnit);
    }

    public final synchronized void m10553a() {
        this.f6306c.mo415g();
        this.f6307d.mo415g();
        this.f6304a.m9843a();
    }

    public final synchronized void m10560a(GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = graphQLPeopleYouShouldFollowFeedUnit.m25810q().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem = (GraphQLPeopleYouShouldFollowFeedUnitItem) a.get(i);
            if (!graphQLPeopleYouShouldFollowFeedUnitItem.m().ad()) {
                builder.m1069c(graphQLPeopleYouShouldFollowFeedUnitItem.k());
            }
        }
        m10571d(FeedUnitMutator.a(graphQLPeopleYouShouldFollowFeedUnit).a(builder.m1068b()).a());
    }

    private synchronized GraphQLStory m10550i(String str) {
        GraphQLStory graphQLStory;
        Preconditions.checkNotNull(str);
        for (String d : m10551j(str)) {
            FeedUnit d2 = m10570d(d);
            if (d2 instanceof GraphQLStory) {
                graphQLStory = (GraphQLStory) d2;
                if (graphQLStory.m22350c().equals(str)) {
                    break;
                }
                graphQLStory = StoryHierarchyHelper.m27433a(graphQLStory, str);
                if (graphQLStory != null) {
                    break;
                }
            }
        }
        graphQLStory = null;
        return graphQLStory;
    }

    private synchronized ImmutableList<String> m10551j(String str) {
        return ImmutableList.copyOf(this.f6306c.mo1474a(str));
    }

    private synchronized ImmutableSet<String> m10547f(FeedUnit feedUnit) {
        ImmutableSet<String> copyOf;
        int i = 1403061107;
        TracerDetour.a("FeedUnitCache.getTagsForCacheId", 1403061107);
        try {
            if (feedUnit.mo2507g() != null) {
                TrackedLruCache trackedLruCache = this.f6304a;
                i = feedUnit.mo2507g();
                if (trackedLruCache.m9841a((Object) i) != null) {
                    copyOf = ImmutableSet.copyOf(this.f6307d.mo1474a(feedUnit.mo2507g()));
                    TracerDetour.a(2043961181);
                }
            }
            copyOf = FeedUnitTagHelper.m23086a(feedUnit, this.f6311h);
            m10571d(feedUnit);
            TracerDetour.a(i);
        } finally {
            i = -421172851;
            TracerDetour.a(-421172851);
        }
        return copyOf;
    }

    public final void m10563a(String str, boolean z) {
        GraphQLStory graphQLStory = (GraphQLStory) m10570d(str);
        if (graphQLStory != null) {
            FeedUnit a = this.f6313j.m10614a(graphQLStory, z);
            if (a != null) {
                m10544a(a, m10549h(str).f17860c, m10549h(str).f17861d);
            }
        }
    }

    public final ImmutableSet<String> m10572e(FeedUnit feedUnit) {
        return m10547f(feedUnit);
    }
}
