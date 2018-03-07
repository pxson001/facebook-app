package com.facebook.pages.identity.timeline;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ParcelUuid;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEventBus;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEvents.BoostedPostStatusChangedEventSubscriber;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.feed.util.composer.ComposerActivityReceiver.Listener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.context.TimelinePageContext.PageProfilePermissionsProvider;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageTimelineFirstLoadEvent;
import com.facebook.pages.common.sequencelogger.PageFirstStoriesSequenceLoggerHelper;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageDataFetchType;
import com.facebook.pages.identity.fragments.about.PageAboutFragment;
import com.facebook.pages.identity.fragments.about.PageAboutFragment.AnonymousClass17;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.timeline.units.model.TimelineSectionData.Placeholder;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEvent;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_permalink_context_row */
public class PageIdentityInfinitePostsTimelineFragment extends PageIdentityTimelineFragment implements AnalyticsFragment, DialtoneStateChangedListener {
    private FbEventSubscriberListManager aA;
    private RefreshStoriesEventSubscriber aB;
    private AdInterfacesExternalEventBus aC;
    private PageFirstStoriesSequenceLoggerHelper aD;
    private boolean aE = true;
    private ParcelUuid aF;
    @Nullable
    private GraphQLStory aG;
    @Nullable
    private GraphQLStory aH;
    public PageProfilePermissionsProvider aI;
    private Provider<FeedbackMutator> aJ;
    private GraphQLActorCacheImpl aK;
    private FeedEventBus aL;
    private PageIdentityTimelineEnvironmentProvider aM;
    private DialtoneController aN;
    public MultiAdapterListAdapter al;
    private PageIdentityPostsByPageAdapter am;
    private PageIdentityCreatePageAdapter an;
    private MultiRowAdapterBuilder ao;
    public MultiRowAdapter ap;
    public MultiRowAdapter aq;
    private Lazy<PageIdentityPinnedPostGroupPartDefinition> ar;
    private Lazy<NewsFeedRootGroupPartDefinition> as;
    public OneItemListItemCollection<GraphQLStory> at;
    public OneItemListItemCollection<GraphQLStory> au;
    private FbEventSubscriberListManager av;
    private ComposerActivityReceiver aw;
    public Lazy<FbErrorReporter> ax;
    private PageScopedEventBus ay;
    public AnonymousClass17 az;
    public long f4165g;
    private ScrollingViewProxy f4166h;
    public MultiRowAdapter f4167i;

    /* compiled from: page_permalink_context_row */
    class C05691 implements OnDrawListener {
        final /* synthetic */ PageIdentityInfinitePostsTimelineFragment f4153a;

        C05691(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
            this.f4153a = pageIdentityInfinitePostsTimelineFragment;
        }

        public final boolean gD_() {
            if (this.f4153a.al == null) {
                return false;
            }
            int i = 0;
            while (i < this.f4153a.al.getCount()) {
                if ((this.f4153a.al.getItem(i) instanceof Placeholder) || this.f4153a.al.getItem(i) == null) {
                    i++;
                } else {
                    TriState triState = TriState.UNSET;
                    if (PageIdentityInfinitePostsTimelineFragment.aS(this.f4153a)) {
                        triState = TriState.YES;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: page_permalink_context_row */
    public class C05702 implements Listener {
        final /* synthetic */ PageIdentityInfinitePostsTimelineFragment f4154a;

        public C05702(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
            this.f4154a = pageIdentityInfinitePostsTimelineFragment;
        }

        public final boolean m5105a(long j, GraphQLStory graphQLStory) {
            return this.f4154a.f4165g == j;
        }

        public final void m5104a(GraphQLStory graphQLStory) {
            this.f4154a.aC();
            if (this.f4154a.az != null) {
                PageAboutFragment pageAboutFragment = this.f4154a.az.f3903a;
                if (pageAboutFragment.aZ != null) {
                    HandlerDetour.b(pageAboutFragment.ce, pageAboutFragment.ci, 0, 1722286368);
                }
            }
        }

        public final void m5107b(GraphQLStory graphQLStory) {
            this.f4154a.m5146g();
            if (this.f4154a.az != null) {
                AnonymousClass17 anonymousClass17 = this.f4154a.az;
                anonymousClass17.f3903a.ba.setRefreshing(false);
                anonymousClass17.f3903a.bn.m3465a(PageDataFetchType.FORCED_BY_USER);
            }
        }

        public final void m5103a() {
            this.f4154a.aC();
            ((AbstractFbErrorReporter) this.f4154a.ax.get()).a("page_optimistic_post_failed", "Failed to post to page timeline " + this.f4154a.f4165g);
            this.f4154a.m5143e();
        }

        public final void m5106b() {
            this.f4154a.m5143e();
        }
    }

    /* compiled from: page_permalink_context_row */
    class C05713 implements Runnable {
        final /* synthetic */ PageIdentityInfinitePostsTimelineFragment f4155a;

        C05713(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
            this.f4155a = pageIdentityInfinitePostsTimelineFragment;
        }

        public void run() {
            this.f4155a.f4167i.notifyDataSetChanged();
        }
    }

    /* compiled from: page_permalink_context_row */
    class C05724 extends LikeClickedEventSubscriber {
        final /* synthetic */ PageIdentityInfinitePostsTimelineFragment f4156a;

        C05724(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
            this.f4156a = pageIdentityInfinitePostsTimelineFragment;
        }

        public final void m5108b(FbEvent fbEvent) {
            LikeClickedEvent likeClickedEvent = (LikeClickedEvent) fbEvent;
            if (likeClickedEvent.b != null) {
                if (this.f4156a.au.a() > 0 && likeClickedEvent.b.equals(((GraphQLStory) this.f4156a.au.a(0)).l().j())) {
                    PageIdentityInfinitePostsTimelineFragment.m5127a(this.f4156a, this.f4156a.au);
                    this.f4156a.aq.notifyDataSetChanged();
                } else if (this.f4156a.at.a() > 0 && likeClickedEvent.b.equals(((GraphQLStory) this.f4156a.at.a(0)).l().j())) {
                    PageIdentityInfinitePostsTimelineFragment.m5127a(this.f4156a, this.f4156a.at);
                    this.f4156a.ap.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: page_permalink_context_row */
    class ReactionUpdatedEventSubscriber extends com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEventSubscriber {
        final /* synthetic */ PageIdentityInfinitePostsTimelineFragment f4157a;

        public ReactionUpdatedEventSubscriber(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
            this.f4157a = pageIdentityInfinitePostsTimelineFragment;
        }

        public final void m5109b(FbEvent fbEvent) {
            ReactionUpdatedEvent reactionUpdatedEvent = (ReactionUpdatedEvent) fbEvent;
            if (reactionUpdatedEvent.b != null) {
                if (this.f4157a.au.a() > 0 && reactionUpdatedEvent.b.equals(((GraphQLStory) this.f4157a.au.a(0)).g())) {
                    PageIdentityInfinitePostsTimelineFragment.m5128a(this.f4157a, this.f4157a.au, reactionUpdatedEvent.c);
                    this.f4157a.aq.notifyDataSetChanged();
                } else if (this.f4157a.at.a() > 0 && reactionUpdatedEvent.b.equals(((GraphQLStory) this.f4157a.at.a(0)).g())) {
                    PageIdentityInfinitePostsTimelineFragment.m5128a(this.f4157a, this.f4157a.at, reactionUpdatedEvent.c);
                    this.f4157a.ap.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: page_permalink_context_row */
    public class RefreshStoriesEventSubscriber extends BoostedPostStatusChangedEventSubscriber {
        final /* synthetic */ PageIdentityInfinitePostsTimelineFragment f4158a;

        public RefreshStoriesEventSubscriber(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
            this.f4158a = pageIdentityInfinitePostsTimelineFragment;
        }

        public final void m5110b(FbEvent fbEvent) {
            this.f4158a.m5143e();
        }
    }

    public static void m5129a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityInfinitePostsTimelineFragment) obj).m5126a(ComposerActivityReceiver.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), AdInterfacesExternalEventBus.a(fbInjector), PageFirstStoriesSequenceLoggerHelper.a(fbInjector), PageScopedEventBus.a(fbInjector), PageIdentityPostsByPageAdapter.m5189a(fbInjector), PageIdentityCreatePageAdapter.m5099b(fbInjector), MultiRowAdapterBuilder.b(fbInjector), IdBasedLazy.a(fbInjector, 9102), IdBasedLazy.a(fbInjector, 1480), IdBasedSingletonScopeProvider.a(fbInjector, 996), GraphQLActorCacheImpl.a(fbInjector), FeedEventBus.a(fbInjector), (PageIdentityTimelineEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageIdentityTimelineEnvironmentProvider.class), (DialtoneController) DialtoneControllerImpl.a(fbInjector));
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        if (!z) {
            this.f4167i.notifyDataSetChanged();
        }
    }

    @Inject
    private void m5126a(ComposerActivityReceiver composerActivityReceiver, Lazy<FbErrorReporter> lazy, AdInterfacesExternalEventBus adInterfacesExternalEventBus, PageFirstStoriesSequenceLoggerHelper pageFirstStoriesSequenceLoggerHelper, PageScopedEventBus pageScopedEventBus, PageIdentityPostsByPageAdapter pageIdentityPostsByPageAdapter, PageIdentityCreatePageAdapter pageIdentityCreatePageAdapter, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<PageIdentityPinnedPostGroupPartDefinition> lazy2, Lazy<NewsFeedRootGroupPartDefinition> lazy3, Provider<FeedbackMutator> provider, GraphQLActorCache graphQLActorCache, FeedEventBus feedEventBus, PageIdentityTimelineEnvironmentProvider pageIdentityTimelineEnvironmentProvider, DialtoneController dialtoneController) {
        this.aw = composerActivityReceiver;
        this.ax = lazy;
        this.aC = adInterfacesExternalEventBus;
        this.aD = pageFirstStoriesSequenceLoggerHelper;
        this.ay = pageScopedEventBus;
        this.am = pageIdentityPostsByPageAdapter;
        this.an = pageIdentityCreatePageAdapter;
        this.ao = multiRowAdapterBuilder;
        this.ar = lazy2;
        this.as = lazy3;
        this.aJ = provider;
        this.aK = graphQLActorCache;
        this.aL = feedEventBus;
        this.aM = pageIdentityTimelineEnvironmentProvider;
        this.at = new OneItemListItemCollection();
        this.au = new OneItemListItemCollection();
        this.aN = dialtoneController;
    }

    public static PageIdentityInfinitePostsTimelineFragment m5125a(long j, String str, PageProfilePermissionsProvider pageProfilePermissionsProvider, ParcelUuid parcelUuid) {
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putString("timeline_filter", str);
        bundle.putParcelable("page_fragment_uuid", parcelUuid);
        PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment = new PageIdentityInfinitePostsTimelineFragment();
        pageIdentityInfinitePostsTimelineFragment.g(bundle);
        pageIdentityInfinitePostsTimelineFragment.aI = pageProfilePermissionsProvider;
        return pageIdentityInfinitePostsTimelineFragment;
    }

    public final void m5138a(ScrollingViewProxy scrollingViewProxy) {
        this.f4166h = scrollingViewProxy;
        if (this.f4166h != null) {
            this.f4166h.b(new C05691(this));
        } else if (this.ax != null) {
            ((AbstractFbErrorReporter) this.ax.get()).b(getClass().getName(), "setListView called with null listview");
        }
    }

    public final void m5135a(AnonymousClass17 anonymousClass17) {
        this.az = anonymousClass17;
    }

    public final void mo111c(Bundle bundle) {
        super.mo111c(bundle);
        Class cls = PageIdentityInfinitePostsTimelineFragment.class;
        m5129a((Object) this, getContext());
        this.aA = new FbEventSubscriberListManager();
        this.aB = new RefreshStoriesEventSubscriber(this);
        this.aA.a(this.aB);
        this.aA.a(this.aC);
        this.av = new FbEventSubscriberListManager();
        this.aN.a(this);
        Bundle bundle2 = this.s;
        this.f4165g = bundle2.getLong("com.facebook.katana.profile.id", -1);
        String string = bundle2.getString("timeline_filter");
        this.aF = null;
        if (bundle != null) {
            this.aF = (ParcelUuid) bundle.getParcelable("fragment_uuid");
        }
        if (this.aF == null) {
            this.aF = (ParcelUuid) this.s.getParcelable("page_fragment_uuid");
            if (this.aF == null) {
                ((AbstractFbErrorReporter) this.ax.get()).b(getClass().getName(), "fragment UUID not available");
                this.aF = new ParcelUuid(SafeUUIDGenerator.a());
            }
        }
        if (bundle != null) {
            Preconditions.checkNotNull(bundle);
            if (this.aI == null) {
                List stringArrayList;
                if (bundle.containsKey("extra_viewer_profile_permissions")) {
                    stringArrayList = bundle.getStringArrayList("extra_viewer_profile_permissions");
                } else {
                    stringArrayList = new ArrayList();
                }
                this.aI = new PageProfilePermissionsProviderImpl(new ProfilePermissions(stringArrayList), this.ax);
            }
        }
        m5118a(this.f4165g, this.aF, string, this.aI);
        at().g = false;
        this.f4167i = aL();
        AnyEnvironment anyEnvironment = this.aD;
        Builder a = this.ao.a(this.ar, this.at);
        a.f = anyEnvironment;
        this.ap = a.e();
        a = this.ao.a(this.as, this.au);
        a.f = anyEnvironment;
        this.aq = a.e();
        this.al = MultiAdapterListAdapter.a(new FbListAdapter[]{this.ap, this.aq, this.am, this.f4167i, this.an});
        this.aw.a(new C05702(this), at().f);
        aP();
        aQ();
        aV();
    }

    public final void mo101G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1576833672);
        super.mo101G();
        if (this.av != null) {
            this.av.a(this.aL);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 917133571, a);
    }

    public final void m5140b(boolean z) {
        this.am.f4206a = z;
        AdapterDetour.a(this.am, 1558891677);
    }

    public final void aI() {
        this.an.f4148a = this.f4165g;
        AdapterDetour.a(this.an, 212989);
    }

    public final void m5134a(GraphQLStory graphQLStory, GraphQLStory graphQLStory2) {
        if (this.aG != graphQLStory) {
            this.aG = graphQLStory;
            aP();
        }
        if (this.aH != graphQLStory2) {
            this.aH = graphQLStory2;
            aQ();
        }
    }

    private void aP() {
        if (this.at != null && this.ap != null) {
            this.at.a = this.aG;
            this.ap.notifyDataSetChanged();
        }
    }

    private void aQ() {
        if (this.au != null && this.aq != null) {
            this.au.a = this.aH;
            this.aq.notifyDataSetChanged();
        }
    }

    public final void m5142d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 988683533);
        super.d(bundle);
        if (m5149n() == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 564705887, a);
            return;
        }
        aN();
        LogUtils.f(300510207, a);
    }

    public final void aJ() {
    }

    public final ScrollingViewProxy m5149n() {
        return this.f4166h;
    }

    protected final BasicAdapter ax() {
        return this.al;
    }

    protected final String aB() {
        return "pages_identity_ufi";
    }

    protected final int m5145g(int i) {
        return this.f4167i.s_(i);
    }

    public final void m5143e() {
        if (av() != null) {
            at().g = true;
            av().b();
            av().a(false);
        }
        if (this.aE) {
            this.ay.a(new PageTimelineFirstLoadEvent(this.aF));
            this.aE = false;
        }
    }

    public final void m5144e(Bundle bundle) {
        super.e(bundle);
        TimelineContext aA = aA();
        if (aA != null) {
            bundle.putParcelable("fragment_uuid", aA.d);
        }
        if (this.aI != null && this.aI.mo28a() != null) {
            String str = "extra_viewer_profile_permissions";
            ProfilePermissions a = this.aI.mo28a();
            ArrayList arrayList = new ArrayList();
            if (a != null) {
                for (Permission permission : ProfilePermissions.a) {
                    if (a.a(permission)) {
                        arrayList.add(permission.name());
                    }
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }
    }

    public final void mo103I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 452311231);
        super.mo103I();
        this.ap.jc_();
        this.aq.jc_();
        this.f4167i.jc_();
        if (this.aw != null) {
            this.aw.b();
            this.aw = null;
        }
        this.aA.b(this.aC);
        this.aN.b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1771703303, a);
    }

    public final void m5146g() {
        aC();
    }

    public final void m5133a(DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
    }

    public final void mo105a(TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        m5146g();
        this.f4161f.a("pages_public_view", NetworkSuccessEvent.EVENT_SECTION_LOADED, this.f4165g);
        if (timelineSectionFetchParams.h) {
            Map c = Maps.c();
            c.put("data_freshness", dataFreshnessResult.toString());
            PageFirstStoriesSequenceLoggerHelper b = this.aD.b("FetchFirstUnitsStories");
            boolean aS = aS(this);
            ImmutableMap copyOf = ImmutableMap.copyOf(c);
            if (b.b != Product.PAA) {
                if (aS) {
                    if (b.a.e(PageSequences.j) != null) {
                        b.a.d(PageSequences.j);
                    }
                } else if (b.a.e(PageSequences.k) != null) {
                    b.a.d(PageSequences.k);
                }
            }
            int size = b.c.size();
            for (int i = 0; i < size; i++) {
                AbstractSequenceDefinition abstractSequenceDefinition = (AbstractSequenceDefinition) b.c.get(i);
                if (b.a.e(abstractSequenceDefinition) != null) {
                    b.a.b(abstractSequenceDefinition, copyOf);
                }
            }
        }
    }

    public final void mo110b(TimelineSectionFetchParams timelineSectionFetchParams) {
        this.f4161f.a("pages_public_view", NetworkFailureEvent.EVENT_SECTION_LOAD_ERROR, this.f4165g);
        if (timelineSectionFetchParams.g) {
            this.aD.b();
        }
    }

    public final String am_() {
        return "pages_native_timeline";
    }

    public final void m5147i() {
    }

    public final void m5148j() {
    }

    public final void mX_() {
    }

    public final void mo104a(TimelineSectionFetchParams timelineSectionFetchParams) {
        if (timelineSectionFetchParams.g) {
            PageFirstStoriesSequenceLoggerHelper pageFirstStoriesSequenceLoggerHelper = this.aD;
            String str = "FetchFirstUnitsStories";
            int size = pageFirstStoriesSequenceLoggerHelper.c.size();
            for (int i = 0; i < size; i++) {
                Sequence e = pageFirstStoriesSequenceLoggerHelper.a.e((AbstractSequenceDefinition) pageFirstStoriesSequenceLoggerHelper.c.get(i));
                if (e != null) {
                    SequenceLoggerDetour.a(e, str, null, null, 675578690);
                }
            }
            PageFirstStoriesSequenceLoggerHelper pageFirstStoriesSequenceLoggerHelper2 = pageFirstStoriesSequenceLoggerHelper;
        }
    }

    public final void mo102H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -857176911);
        super.mo102H();
        if (this.av != null) {
            this.av.b(this.aL);
        }
        this.aD.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 775043395, a);
    }

    public static boolean aS(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment) {
        return (pageIdentityInfinitePostsTimelineFragment.aI == null || pageIdentityInfinitePostsTimelineFragment.aI.mo28a() == null || !pageIdentityInfinitePostsTimelineFragment.aI.mo28a().a(Permission.BASIC_ADMIN)) ? false : true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f4167i.notifyDataSetChanged();
    }

    protected final Runnable aK() {
        return new C05713(this);
    }

    private void aV() {
        this.av.a(new FbEventSubscriber[]{new C05724(this), new ReactionUpdatedEventSubscriber(this)});
    }

    public static void m5127a(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment, OneItemListItemCollection oneItemListItemCollection) {
        GraphQLStory graphQLStory = (GraphQLStory) oneItemListItemCollection.a(0);
        GraphQLFeedback a = ((FeedbackMutator) pageIdentityInfinitePostsTimelineFragment.aJ.get()).a(graphQLStory.l(), pageIdentityInfinitePostsTimelineFragment.aK.a());
        GraphQLStory.Builder a2 = GraphQLStory.Builder.a(graphQLStory);
        a2.D = a;
        a2 = a2;
        a2.F = System.currentTimeMillis();
        oneItemListItemCollection.a = a2.a();
    }

    public static void m5128a(PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment, OneItemListItemCollection oneItemListItemCollection, FeedbackReaction feedbackReaction) {
        GraphQLStory graphQLStory = (GraphQLStory) oneItemListItemCollection.a(0);
        GraphQLStory.Builder a = GraphQLStory.Builder.a(graphQLStory);
        a.D = ((FeedbackMutator) pageIdentityInfinitePostsTimelineFragment.aJ.get()).a(pageIdentityInfinitePostsTimelineFragment.aK.a(), graphQLStory.l(), ReactionsMutationController.a(graphQLStory.l(), graphQLStory.l().S(), feedbackReaction).a());
        oneItemListItemCollection.a = a.a();
    }
}
