package com.facebook.feed.data;

import android.content.Context;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.feed.feedtype.FeedTypeDataItem;
import com.facebook.feed.feedtype.STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem;
import com.facebook.feed.loader.EndOfFeedState;
import com.facebook.feed.loader.FeedDataLoaderListener;
import com.facebook.feed.loader.FetchFeedParamsGenerator;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.loader.InitializationStatus;
import com.facebook.feed.loader.NoOpFeedDataLoaderListener;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.data.MegaphoneStore.C07251;
import com.facebook.megaphone.data.MegaphoneStore.MegaphoneEntry;
import com.facebook.megaphone.fetcher.MegaphoneFetcher;
import com.facebook.megaphone.fetcher.MegaphoneFetcher.C07241;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: sg/fundraiser/?source=%1$s&fundraiser_campaign_id=%2$s */
public abstract class BaseFeedDataLoader implements IFeedDataLoader, InjectableComponentWithContext {
    public static final int f5158k = ((int) TimeUnit.MILLISECONDS.toSeconds(540000));
    private static final String f5159s = SafeUUIDGenerator.m2795a().toString();
    @Inject
    public NewsFeedXConfigReader f5160a;
    @Inject
    public FeedUnitCollection f5161b;
    @Inject
    protected EndOfFeedState f5162c;
    @Inject
    Lazy<FbNetworkManager> f5163d;
    @Inject
    NewsFeedEventLogger f5164e;
    @Inject
    protected FetchFeedParamsGenerator f5165f;
    @Inject
    public InitializationStatus f5166g;
    @Inject
    Lazy<MegaphoneStore> f5167h;
    @Inject
    Lazy<Set<FeedTypeDataItem>> f5168i;
    @Inject
    TopicFeedsTestUtil f5169j;
    protected final FeedDataLoaderListener f5170l = new NoOpFeedDataLoaderListener();
    protected FeedDataLoaderListener f5171m = this.f5170l;
    protected FeedType f5172n;
    protected AbstractFeedTypeDataItem f5173o;
    private final Context f5174p;
    @Inject
    public GatekeeperStoreImpl f5175q;
    @Inject
    private Lazy<PerfTestConfig> f5176r;
    private boolean f5177t = false;
    private boolean f5178u = false;
    private String f5179v = null;

    public static void m9007a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BaseFeedDataLoader) obj).m9006a(NewsFeedXConfigReader.m8187a(injectorLike), FeedUnitCollection.m9651b(injectorLike), EndOfFeedState.m9787b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 585), NewsFeedEventLogger.m4405a(injectorLike), FetchFeedParamsGenerator.m9794b(injectorLike), InitializationStatus.m9851a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2539), STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem.m9856a(injectorLike), TopicFeedsTestUtil.m8789b(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 593));
    }

    protected abstract CallerContext mo1310v();

    protected abstract void mo1311w();

    private void m9006a(NewsFeedXConfigReader newsFeedXConfigReader, FeedUnitCollection feedUnitCollection, EndOfFeedState endOfFeedState, Lazy<FbNetworkManager> lazy, NewsFeedEventLogger newsFeedEventLogger, FetchFeedParamsGenerator fetchFeedParamsGenerator, InitializationStatus initializationStatus, Lazy<MegaphoneStore> lazy2, Lazy<Set<FeedTypeDataItem>> lazy3, TopicFeedsTestUtil topicFeedsTestUtil, GatekeeperStore gatekeeperStore, Lazy<PerfTestConfig> lazy4) {
        this.f5160a = newsFeedXConfigReader;
        this.f5161b = feedUnitCollection;
        this.f5162c = endOfFeedState;
        this.f5163d = lazy;
        this.f5164e = newsFeedEventLogger;
        this.f5165f = fetchFeedParamsGenerator;
        this.f5166g = initializationStatus;
        this.f5167h = lazy2;
        this.f5168i = lazy3;
        this.f5169j = topicFeedsTestUtil;
        this.f5175q = gatekeeperStore;
        this.f5176r = lazy4;
    }

    protected BaseFeedDataLoader(Context context) {
        this.f5174p = context;
        Class cls = BaseFeedDataLoader.class;
        m9007a((Object) this, getContext());
        this.f5165f.f5681f = mo1310v();
    }

    public Context getContext() {
        return this.f5174p;
    }

    protected final long m9023u() {
        return TimeUnit.HOURS.toMillis((long) this.f5160a.m8197i());
    }

    protected final void m9026x() {
        if (!this.f5177t) {
            MegaphoneStore megaphoneStore = (MegaphoneStore) this.f5167h.get();
            GraphQLMegaphoneLocation graphQLMegaphoneLocation = GraphQLMegaphoneLocation.NEWSFEED;
            CallerContext v = mo1310v();
            if (!megaphoneStore.f10304k.contains(graphQLMegaphoneLocation)) {
                MegaphoneEntry megaphoneEntry = (MegaphoneEntry) megaphoneStore.f10302i.get(graphQLMegaphoneLocation);
                if (megaphoneEntry == null || megaphoneStore.f10297d.mo211a() >= megaphoneEntry.f10312b) {
                    megaphoneStore.f10304k.add(graphQLMegaphoneLocation);
                    MegaphoneFetcher megaphoneFetcher = megaphoneStore.f10298e;
                    Futures.m2457a(megaphoneFetcher.f10307c.mo271a(new C07241(megaphoneFetcher, graphQLMegaphoneLocation, v)), new C07251(megaphoneStore, graphQLMegaphoneLocation));
                }
            }
            this.f5177t = true;
        }
    }

    protected final void m9011a(Event event) {
        this.f5164e.m4410a(m9005B(), event);
    }

    protected final void m9012a(Event event, String str) {
        this.f5164e.m4411a(m9005B(), event, str);
    }

    private String m9005B() {
        if (this.f5179v == null) {
            this.f5179v = mo1310v().f5181b + " (" + mo1318l() + ")";
        }
        return this.f5179v;
    }

    public final boolean m9027y() {
        if (this.f5175q.m2185a(726).asBoolean(false) || this.f5173o == null || !this.f5173o.f5766d) {
            return false;
        }
        this.f5176r.get();
        if (PerfTestConfigBase.m2938a()) {
            this.f5176r.get();
            if (PerfTestConfigBase.f1509d) {
                return false;
            }
        }
        return true;
    }

    public final PerfTestConfig m9028z() {
        return (PerfTestConfig) this.f5176r.get();
    }

    public final void mo1317j() {
        mo1311w();
        if (!this.f5169j.m8802l()) {
            this.f5161b.m9696m();
        }
    }

    public void mo1295b() {
        mo1304k();
        this.f5161b.f5628d.m9714a(GraphQLFeedOptimisticPublishState.POSTING);
        this.f5161b.f5628d.m9714a(GraphQLFeedOptimisticPublishState.RETRYING_IN_BACKGROUND);
    }

    public void mo1291a(FeedDataLoaderListener feedDataLoaderListener) {
        Preconditions.checkNotNull(feedDataLoaderListener);
        this.f5171m = feedDataLoaderListener;
    }

    public void mo1297b(FeedDataLoaderListener feedDataLoaderListener) {
        Preconditions.checkArgument(feedDataLoaderListener != this.f5170l);
        if (this.f5171m == feedDataLoaderListener) {
            this.f5171m = this.f5170l;
        }
    }

    public final void mo1316i() {
        if (this.f5161b.m9697n()) {
            this.f5161b.f5640p = null;
        }
    }

    public final FeedType mo1318l() {
        return this.f5172n;
    }

    public final void mo1313a(FeedType feedType) {
        Preconditions.checkState(this.f5172n == null);
        this.f5172n = feedType;
        for (AbstractFeedTypeDataItem abstractFeedTypeDataItem : (Set) this.f5168i.get()) {
            if (abstractFeedTypeDataItem.f5763a.equals(mo1318l().f5044g)) {
                this.f5173o = abstractFeedTypeDataItem;
                return;
            }
        }
    }

    public final String mo1312a() {
        return f5159s;
    }

    public final FeedUnitCollection mo1315c() {
        return this.f5161b;
    }

    public final void mo1319m() {
        this.f5171m.mo1368a();
        this.f5161b.m9696m();
        this.f5171m.mo1373c();
        this.f5162c.m9790d();
    }

    public final void mo1314a(boolean z) {
        this.f5178u = z;
    }

    public final boolean mo1321q() {
        return this.f5178u;
    }

    public final boolean mo1320n() {
        return this.f5166g.m9852a();
    }
}
