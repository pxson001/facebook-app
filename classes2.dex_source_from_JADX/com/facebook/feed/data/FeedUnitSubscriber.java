package com.facebook.feed.data;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.common.collect.BaseListObserver;
import com.facebook.common.collect.ListObserver;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.loader.FeedDataLoaderListener;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_resolve_taggable_profile_ids */
public class FeedUnitSubscriber {
    private final GraphQLSubscriptionHolder f9579a;
    public final Clock f9580b;
    private final FeedUnitCache f9581c;
    private final QeAccessor f9582d;
    private final ListObserver f9583e = new CollectionObserver(this);
    private final AbstractFbErrorReporter f9584f;
    @Nullable
    public FeedUnitCollection f9585g = null;
    public FeedOnDataChangeListener f9586h = null;
    private boolean f9587i;

    /* compiled from: platform_resolve_taggable_profile_ids */
    class CollectionObserver extends BaseListObserver<FeedEdge> {
        final /* synthetic */ FeedUnitSubscriber f9594a;

        public CollectionObserver(FeedUnitSubscriber feedUnitSubscriber) {
            this.f9594a = feedUnitSubscriber;
        }

        public final void mo1387a(int i, Object obj, Object obj2, boolean z) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) obj2;
            m14641b((GraphQLFeedUnitEdge) obj);
            m14640a(graphQLFeedUnitEdge);
        }

        public final /* bridge */ /* synthetic */ void mo1388a(int i, Object obj, boolean z) {
            m14640a((GraphQLFeedUnitEdge) obj);
        }

        public final /* bridge */ /* synthetic */ void mo1389b(int i, Object obj, boolean z) {
            m14641b((GraphQLFeedUnitEdge) obj);
        }

        private void m14640a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
            FeedUnitSubscriber.m14611a(this.f9594a, graphQLFeedUnitEdge);
        }

        private void m14641b(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
            FeedUnitSubscriber.m14614b(this.f9594a, graphQLFeedUnitEdge);
        }
    }

    /* compiled from: platform_resolve_taggable_profile_ids */
    class UpdatedStoryCallback implements FutureCallback<GraphQLResult<FeedUnit>> {
        final /* synthetic */ FeedUnitSubscriber f19194a;
        @Nullable
        private final String f19195b;
        @Nullable
        private final String f19196c;
        private final FeedUnit f19197d;

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FeedOnDataChangeListener feedOnDataChangeListener = this.f19194a.f9586h;
            FeedUnitCollection feedUnitCollection = this.f19194a.f9585g;
            if (feedOnDataChangeListener != null && feedUnitCollection != null) {
                if (graphQLResult.f6203e instanceof GraphQLStory) {
                    PropertyHelper.m21281a((GraphQLStory) graphQLResult.f6203e, null);
                }
                if (feedOnDataChangeListener instanceof FeedDataLoaderListener) {
                    ((FeedDataLoaderListener) feedOnDataChangeListener).mo1368a();
                }
                if (graphQLResult.f6203e != null) {
                    FetchTimeMsHelper.m22314a((FeedUnitCommon) graphQLResult.f6203e, this.f19194a.f9580b.mo211a());
                    if (this.f19195b != null) {
                        String str = this.f19195b;
                        FeedUnit feedUnit = (FeedUnit) graphQLResult.f6203e;
                        GraphQLFeedUnitEdge b = feedUnitCollection.f5631g.m9773b(str);
                        if (b != null) {
                            Builder builder = new Builder();
                            builder.f15732i = feedUnit;
                            builder = builder;
                            builder.f15729f = str;
                            builder = builder;
                            builder.f15734k = b.m19084d();
                            builder = builder;
                            builder.f15728e = b.m19086g();
                            builder = builder;
                            builder.f15733j = b.X_();
                            builder = builder;
                            builder.f15731h = b.m19088k();
                            builder = builder;
                            builder.f15730g = b.m19089l();
                            GraphQLFeedUnitEdge a = builder.m22415a();
                            PropertyHelper.m21292b(a, b.W_());
                            PropertyHelper.m21272a(a, b.V_());
                            if (b.mo2540c() != null) {
                                PropertyHelper.m21266a(feedUnit, PropertyHelper.m21303f(b.mo2540c()));
                                PropertyHelper.m21268a(feedUnit, PropertyHelper.m21264a(b.mo2540c()));
                                PropertyHelper.m21291b(feedUnit, PropertyHelper.m21289b(b.mo2540c()));
                            }
                            feedUnitCollection.m9680b(a);
                        }
                    }
                    if (graphQLResult.f6203e instanceof GraphQLStory) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLResult.f6203e;
                        if (graphQLStory.mo2890l() != null) {
                            PendingStoryCache pendingStoryCache = feedUnitCollection.f5628d;
                            GraphQLStory.Builder a2 = GraphQLStory.Builder.a(graphQLStory);
                            a2.o = null;
                            pendingStoryCache.m9717a(a2.a());
                        }
                    }
                } else if (this.f19195b != null) {
                    Builder builder2 = new Builder();
                    builder2.f15732i = null;
                    builder2 = builder2;
                    builder2.f15729f = this.f19195b;
                    builder2 = builder2;
                    builder2.f15734k = null;
                    builder2 = builder2;
                    builder2.f15728e = null;
                    feedUnitCollection.m9685c(builder2.m22415a());
                } else if (this.f19196c != null) {
                    feedUnitCollection.f5628d.m9718b(this.f19196c);
                }
                feedOnDataChangeListener.mo1373c();
            }
        }

        UpdatedStoryCallback(FeedUnitSubscriber feedUnitSubscriber, @Nullable String str, @Nullable String str2, FeedUnit feedUnit) {
            this.f19194a = feedUnitSubscriber;
            this.f19195b = str;
            this.f19196c = str2;
            this.f19197d = feedUnit;
        }

        public void onFailure(Throwable th) {
            BLog.a(getClass(), "Failed to update feed", th);
        }
    }

    public static FeedUnitSubscriber m14613b(InjectorLike injectorLike) {
        return new FeedUnitSubscriber(QeInternalImplMethodAutoProvider.m3744a(injectorLike), GraphQLSubscriptionHolder.m14626b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FeedUnitCache.m10541a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public static FeedUnitSubscriber m14610a(InjectorLike injectorLike) {
        return m14613b(injectorLike);
    }

    @Inject
    public FeedUnitSubscriber(QeAccessor qeAccessor, GraphQLSubscriptionHolder graphQLSubscriptionHolder, Clock clock, FeedUnitCache feedUnitCache, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9582d = qeAccessor;
        this.f9579a = graphQLSubscriptionHolder;
        this.f9580b = clock;
        this.f9581c = feedUnitCache;
        this.f9584f = abstractFbErrorReporter;
    }

    public final void m14618a(FeedUnitCollection feedUnitCollection, FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f9587i = this.f9582d.mo596a(ExperimentsForNewsFeedAbTestModule.f5096W, false);
        m14617a();
        this.f9585g = feedUnitCollection;
        this.f9586h = feedOnDataChangeListener;
        if (this.f9587i) {
            this.f9585g.mo1376a(this.f9583e);
        }
        m14619a((Iterable) feedUnitCollection);
    }

    public final void m14617a() {
        if (this.f9585g != null && this.f9587i) {
            this.f9585g.mo1377b(this.f9583e);
        }
        this.f9585g = null;
        this.f9586h = null;
    }

    public final void m14619a(Iterable<? extends FeedEdge> iterable) {
        if (!this.f9587i) {
            TracerDetour.a("FeedUnitSubscriber.addEdges", -1035011556);
            try {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    m14611a(this, (GraphQLFeedUnitEdge) it.next());
                }
                if (((double) this.f9579a.m14637c()) > ((double) (this.f9585g == null ? 0 : this.f9585g.m9695k())) * 1.5d) {
                    int c = this.f9579a.m14637c();
                    m14620b();
                    this.f9584f.m2341a("FeedUnitSubscriberManualGC", String.format(Locale.US, "Started at: %d Ended at: %d Feed Size: %d", new Object[]{Integer.valueOf(c), Integer.valueOf(this.f9579a.m14637c()), Integer.valueOf(r0)}), 10000);
                }
                TracerDetour.a(-2050724274);
            } catch (Throwable th) {
                TracerDetour.a(1910172045);
            }
        }
    }

    public final void m14620b() {
        if (!this.f9587i) {
            TracerDetour.a("FeedUnitSubscriber.reInitialize", -330069722);
            try {
                Iterable iterable = this.f9585g;
                Iterable c = this.f9585g != null ? this.f9585g.m9682c() : null;
                if (iterable == null && c == null) {
                    this.f9579a.m14629a();
                } else {
                    Set a = Sets.m1313a();
                    m14612a(iterable, a);
                    m14612a(c, a);
                    this.f9579a.m14633a(a);
                }
                TracerDetour.a(-2036991629);
            } catch (Throwable th) {
                TracerDetour.a(1784908481);
            }
        }
    }

    private void m14612a(Iterable<FeedEdge> iterable, Set<String> set) {
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                String a = m14611a(this, (GraphQLFeedUnitEdge) it.next());
                if (a != null) {
                    set.add(a);
                }
            }
        }
    }

    public static String m14611a(FeedUnitSubscriber feedUnitSubscriber, GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        String str = null;
        TracerDetour.a("FeedUnitSubscriber.subscribeToUnit", 1291292258);
        try {
            String d = m14616d(graphQLFeedUnitEdge);
            FeedUnit c = graphQLFeedUnitEdge.mo2540c();
            String c2 = feedUnitSubscriber.m14615c(graphQLFeedUnitEdge);
            if (c2 == null) {
                return null;
            }
            GraphQLResult a = feedUnitSubscriber.f9579a.m14627a(graphQLFeedUnitEdge.mo2540c(), DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, feedUnitSubscriber.f9581c.m10572e(c));
            GraphQLSubscriptionHolder graphQLSubscriptionHolder = feedUnitSubscriber.f9579a;
            if (c instanceof GraphQLStory) {
                str = ((GraphQLStory) c).ai();
            }
            graphQLSubscriptionHolder.m14632a(new UpdatedStoryCallback(feedUnitSubscriber, d, str, c), c2, a);
            TracerDetour.a(831474965);
            return c2;
        } finally {
            TracerDetour.a(911791764);
        }
    }

    public static void m14614b(FeedUnitSubscriber feedUnitSubscriber, GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        String c = feedUnitSubscriber.m14615c(graphQLFeedUnitEdge);
        if (c != null) {
            feedUnitSubscriber.f9579a.m14636b(c);
        }
    }

    @Nullable
    private String m14615c(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        String d = m14616d(graphQLFeedUnitEdge);
        if (d != null) {
            return d;
        }
        FeedUnitCommon c = graphQLFeedUnitEdge.mo2540c();
        String g = c.mo2507g();
        if (g != null) {
            return g;
        }
        return c instanceof GraphQLStory ? ((GraphQLStory) c).m22350c() : null;
    }

    @Nullable
    private static String m14616d(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        String a = DedupableUtil.m23084a(graphQLFeedUnitEdge);
        if (Objects.equal(a, FeedEdgeComparator.f5642b)) {
            return null;
        }
        return a;
    }

    public final void m14621c() {
        this.f9579a.m14638d();
    }

    public final void m14622d() {
        this.f9579a.m14639e();
    }

    public final void m14623e() {
        this.f9579a.m14629a();
    }
}
