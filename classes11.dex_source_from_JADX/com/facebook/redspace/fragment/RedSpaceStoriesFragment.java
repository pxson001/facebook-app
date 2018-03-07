package com.facebook.redspace.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowMultiAdapter;
import com.facebook.feed.rows.adapter.SingleRowFbListAdapter;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.ui.MultiRowAdapterRecyclerViewProxy;
import com.facebook.feed.ui.controllers.SeeMoreController;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.adapter.RedSpaceFeedStateAdapter;
import com.facebook.redspace.adapter.RedSpaceFeedStateAdapterProvider;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.analytics.logger.RedSpaceTimeLogger;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceHeaderCollection;
import com.facebook.redspace.data.RedSpaceMutationsExecutor;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.redspace.data.RedSpaceWallCollection.State;
import com.facebook.redspace.data.RedSpaceWallFetcherHelper;
import com.facebook.redspace.data.RedSpaceWallFetcherHelperProvider;
import com.facebook.redspace.debug.RedSpaceStoriesDebugWriter;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceWallResult;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceStoriesControllerCallbacksDispatcher;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceStoriesDispatcherFactory;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceComposerActivityController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.ChangeRendererEventSubscriber;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.FeedUnitMutatedEventSubscriber;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.OfflinePostLoaderListener;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.SeeMoreControllerSubscriber;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.StoryDeleteSubscriber;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.StoryVisibilityEventSubscriber;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventControllerProvider;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFriendViewMutationController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceSelfViewMutationController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceViewportMonitorFragmentController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceWallLoadEventController;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.redspace.rows.RedSpaceEnvironmentGenerated;
import com.facebook.redspace.rows.RedSpaceEnvironmentGeneratedProvider;
import com.facebook.redspace.rows.RedSpaceFeedListType;
import com.facebook.redspace.rows.RedSpaceFeedRootGroupPartDefinition;
import com.facebook.redspace.ui.RedSpaceFeedVerticalScrollHelper.HasFeedScrollListener;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener.OnScrolledToBottomListener;
import com.facebook.redspace.ui.RedSpaceStoryLoadingIndicatorAdapter;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: Parent fragment must implement FundraiserMessageGuestsListener */
public class RedSpaceStoriesFragment extends FbFragment implements FragmentWithDebugInfo {
    private static final String f11997c = RedSpaceStoriesFragment.class.getSimpleName();
    @Inject
    volatile Provider<RedSpaceTabUnseenCountFetcher> f11998a = UltralightRuntime.a;
    @Inject
    private RedSpaceWallFetcherHelperProvider aA;
    @Inject
    public Resources aB;
    @Inject
    private RedSpaceFeedEventControllerProvider aC;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceLogger> aD = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceTimeLogger> aE = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceStoriesDebugWriter> aF = UltralightRuntime.b;
    @Inject
    private RedSpaceFeedProfileUnreadStoriesHelper aG;
    @Inject
    private MultiRowImagePrefetcherFactory aH;
    @Inject
    private RedSpaceStoriesDispatcherFactory aI;
    private MultiRowAdapter aJ;
    public RedSpaceFeedStateAdapter aK;
    public RedSpaceFeedProfileFragmentModel aL;
    private MultiRowMultiAdapter aM;
    public RetryClickedListener aN;
    private RedSpaceLoadingScrollListener aO;
    public RedSpaceStoryLoadingIndicatorAdapter aP;
    public TimelineContext aQ;
    public int aR;
    private OnScrollListener aS;
    private HasFeedScrollListener aT;
    private MultiRowAdapterRecyclerViewProxy aU;
    public boolean aV;
    public State aW;
    public RedSpaceHeaderCollection.State aX;
    public RedSpaceWallFetcherHelper aY;
    public RedSpaceStoriesControllerCallbacksDispatcher aZ;
    @Inject
    private RedSpaceEnvironmentGeneratedProvider al;
    @Inject
    private com.facebook.inject.Lazy<RedSpaceFeedRootGroupPartDefinition> am;
    @Inject
    private ViewportMonitor an;
    @Inject
    private FeedEventBus ao;
    @Inject
    private ConsumptionPhotoEventBus ap;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DeleteStoryHelper> aq = UltralightRuntime.b;
    @Inject
    private TimelineStoryEventBus ar;
    @Inject
    private SeeMoreController as;
    @Inject
    private QeAccessor at;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FeedStoryMutator> au = UltralightRuntime.b;
    @Inject
    private Clock av;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceMutationsExecutor> aw = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LoggedInUserAuthDataStore> ax = UltralightRuntime.b;
    @Inject
    public RedSpaceWallCollection ay;
    @Inject
    private RedSpaceHeaderCollection az;
    @Inject
    volatile Provider<RedSpaceOptimisticBadgeStore> f11999b = UltralightRuntime.a;
    private RedSpaceEnvironmentGenerated ba;
    private final Runnable bb = new C14381(this);
    @Inject
    private GraphQLSubscriptionHolder f12000d;
    @Inject
    @LoggedInUserId
    public String f12001e;
    @Inject
    private MultipleRowsStoriesRecycleCallback f12002f;
    @Inject
    private MultiRowAdapterBuilder f12003g;
    @Inject
    private RedSpaceFeedStateAdapterProvider f12004h;
    @Inject
    private TasksManager f12005i;

    /* compiled from: Parent fragment must implement FundraiserMessageGuestsListener */
    class C14381 implements Runnable {
        final /* synthetic */ RedSpaceStoriesFragment f11993a;

        C14381(RedSpaceStoriesFragment redSpaceStoriesFragment) {
            this.f11993a = redSpaceStoriesFragment;
        }

        public void run() {
            RedSpaceStoriesFragment.at(this.f11993a);
        }
    }

    /* compiled from: Parent fragment must implement FundraiserMessageGuestsListener */
    class C14392 implements RetryClickedListener {
        final /* synthetic */ RedSpaceStoriesFragment f11994a;

        C14392(RedSpaceStoriesFragment redSpaceStoriesFragment) {
            this.f11994a = redSpaceStoriesFragment;
        }

        public final void m12438a() {
            RedSpaceStoriesFragment.aw(this.f11994a);
        }
    }

    /* compiled from: Parent fragment must implement FundraiserMessageGuestsListener */
    class C14403 implements OnScrolledToBottomListener {
        final /* synthetic */ RedSpaceStoriesFragment f11995a;

        C14403(RedSpaceStoriesFragment redSpaceStoriesFragment) {
            this.f11995a = redSpaceStoriesFragment;
        }

        public final void mo340a() {
            if (!this.f11995a.aY.f11915n) {
                RedSpaceStoriesFragment.aw(this.f11995a);
            }
        }
    }

    /* compiled from: Parent fragment must implement FundraiserMessageGuestsListener */
    class C14414 implements Delegate {
        final /* synthetic */ RedSpaceStoriesFragment f11996a;

        C14414(RedSpaceStoriesFragment redSpaceStoriesFragment) {
            this.f11996a = redSpaceStoriesFragment;
        }

        public final void m12440a(HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
        }
    }

    public static void m12442a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RedSpaceStoriesFragment) obj).m12443a(IdBasedSingletonScopeProvider.a(injectorLike, 10165), IdBasedSingletonScopeProvider.a(injectorLike, 3265), GraphQLSubscriptionHolder.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.a(injectorLike), MultipleRowsStoriesRecycleCallback.a(injectorLike), MultiRowAdapterBuilder.a(injectorLike), (RedSpaceFeedStateAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceFeedStateAdapterProvider.class), TasksManager.a(injectorLike), (RedSpaceEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceEnvironmentGeneratedProvider.class), IdBasedLazy.a(injectorLike, 10205), ViewportMonitor.a(injectorLike), FeedEventBus.a(injectorLike), ConsumptionPhotoEventBus.a(injectorLike), IdBasedLazy.a(injectorLike, 6089), TimelineStoryEventBus.a(injectorLike), SeeMoreController.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 994), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10172), IdBasedSingletonScopeProvider.b(injectorLike, 339), RedSpaceWallCollection.m12324a(injectorLike), RedSpaceHeaderCollection.m12244a(injectorLike), (RedSpaceWallFetcherHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceWallFetcherHelperProvider.class), ResourcesMethodAutoProvider.a(injectorLike), (RedSpaceFeedEventControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceFeedEventControllerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 10162), IdBasedLazy.a(injectorLike, 10163), IdBasedLazy.a(injectorLike, 10181), RedSpaceFeedProfileUnreadStoriesHelper.m12202a(injectorLike), MultiRowImagePrefetcherFactory.a(injectorLike), RedSpaceStoriesDispatcherFactory.m12496a(injectorLike));
    }

    private void m12443a(Provider<RedSpaceTabUnseenCountFetcher> provider, Provider<RedSpaceOptimisticBadgeStore> provider2, GraphQLSubscriptionHolder graphQLSubscriptionHolder, String str, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, MultiRowAdapterBuilder multiRowAdapterBuilder, RedSpaceFeedStateAdapterProvider redSpaceFeedStateAdapterProvider, TasksManager tasksManager, RedSpaceEnvironmentGeneratedProvider redSpaceEnvironmentGeneratedProvider, com.facebook.inject.Lazy<RedSpaceFeedRootGroupPartDefinition> lazy, ViewportMonitor viewportMonitor, FeedEventBus feedEventBus, ConsumptionPhotoEventBus consumptionPhotoEventBus, com.facebook.inject.Lazy<DeleteStoryHelper> lazy2, TimelineStoryEventBus timelineStoryEventBus, SeeMoreController seeMoreController, QeAccessor qeAccessor, com.facebook.inject.Lazy<FeedStoryMutator> lazy3, Clock clock, com.facebook.inject.Lazy<RedSpaceMutationsExecutor> lazy4, com.facebook.inject.Lazy<LoggedInUserAuthDataStore> lazy5, RedSpaceWallCollection redSpaceWallCollection, RedSpaceHeaderCollection redSpaceHeaderCollection, RedSpaceWallFetcherHelperProvider redSpaceWallFetcherHelperProvider, Resources resources, RedSpaceFeedEventControllerProvider redSpaceFeedEventControllerProvider, com.facebook.inject.Lazy<RedSpaceLogger> lazy6, com.facebook.inject.Lazy<RedSpaceTimeLogger> lazy7, com.facebook.inject.Lazy<RedSpaceStoriesDebugWriter> lazy8, RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory, RedSpaceStoriesDispatcherFactory redSpaceStoriesDispatcherFactory) {
        this.f11998a = provider;
        this.f11999b = provider2;
        this.f12000d = graphQLSubscriptionHolder;
        this.f12001e = str;
        this.f12002f = multipleRowsStoriesRecycleCallback;
        this.f12003g = multiRowAdapterBuilder;
        this.f12004h = redSpaceFeedStateAdapterProvider;
        this.f12005i = tasksManager;
        this.al = redSpaceEnvironmentGeneratedProvider;
        this.am = lazy;
        this.an = viewportMonitor;
        this.ao = feedEventBus;
        this.ap = consumptionPhotoEventBus;
        this.aq = lazy2;
        this.ar = timelineStoryEventBus;
        this.as = seeMoreController;
        this.at = qeAccessor;
        this.au = lazy3;
        this.av = clock;
        this.aw = lazy4;
        this.ax = lazy5;
        this.ay = redSpaceWallCollection;
        this.az = redSpaceHeaderCollection;
        this.aA = redSpaceWallFetcherHelperProvider;
        this.aB = resources;
        this.aC = redSpaceFeedEventControllerProvider;
        this.aD = lazy6;
        this.aE = lazy7;
        this.aF = lazy8;
        this.aG = redSpaceFeedProfileUnreadStoriesHelper;
        this.aH = multiRowImagePrefetcherFactory;
        this.aI = redSpaceStoriesDispatcherFactory;
    }

    public final void a_(Context context) {
        super.a_(context);
        if (context instanceof HasFeedScrollListener) {
            this.aT = (HasFeedScrollListener) context;
            this.aS = this.aT.mo348c();
        }
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1134822920);
        this.aT = null;
        this.aS = null;
        super.dE_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 999387957, a);
    }

    public final void m12451c(Bundle bundle) {
        super.c(bundle);
        Class cls = RedSpaceStoriesFragment.class;
        m12442a((Object) this, getContext());
        if (bundle == null) {
            this.aV = false;
        } else {
            this.aV = true;
            this.aW = (State) bundle.getParcelable("bundle_wall_collection");
            this.aX = (RedSpaceHeaderCollection.State) bundle.getParcelable("bundle_header_collection");
        }
        Bundle bundle2 = this.s;
        this.aL = (RedSpaceFeedProfileFragmentModel) FlatBufferModelHelper.a(bundle2, "bundle_profile_model");
        this.aR = bundle2.getInt("bundle_feed_padding_top", 0);
        this.aQ = TimelineUserContext.a(Long.parseLong(this.f12001e), Long.parseLong(this.aL.k()), this.f12001e + this.aL.k(), new ParcelUuid(SafeUUIDGenerator.a()));
        aq();
        as();
        m12444o(bundle);
        aw(this);
    }

    private void aq() {
        this.ay.f11892e = this;
        this.ay.f11891d = this.aL;
        this.ay.m12345a(this.aW, this.f12000d);
        this.az.m12250a(this.aX);
        this.aN = new C14392(this);
        this.aO = new RedSpaceLoadingScrollListener(3, new C14403(this));
        RedSpaceWallFetcherHelperProvider redSpaceWallFetcherHelperProvider = this.aA;
        RedSpaceWallFetcherHelper redSpaceWallFetcherHelper = new RedSpaceWallFetcherHelper(this, this.aL, this.f12000d, this.ay);
        redSpaceWallFetcherHelper.m12357a(IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 10184), IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 10187), IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 10185), IdBasedSingletonScopeProvider.b(redSpaceWallFetcherHelperProvider, 494), IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 2164), IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 3561), IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 10174), IdBasedLazy.a(redSpaceWallFetcherHelperProvider, 4442));
        this.aY = redSpaceWallFetcherHelper;
    }

    public final void m12450a(RedSpaceWallResult redSpaceWallResult) {
        RedSpaceStoriesControllerCallbacksDispatcher redSpaceStoriesControllerCallbacksDispatcher = this.aZ;
        RedSpaceStoriesQueryModel redSpaceStoriesQueryModel = (RedSpaceStoriesQueryModel) redSpaceWallResult.a().e;
        if (redSpaceStoriesControllerCallbacksDispatcher.f12016d != null) {
            redSpaceStoriesControllerCallbacksDispatcher.f12016d.m12531c();
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12018f != null) {
            redSpaceStoriesControllerCallbacksDispatcher.f12018f.m12567f();
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12020h != null) {
            redSpaceStoriesControllerCallbacksDispatcher.f12020h.m12554a();
        }
        this.az.m12251a(redSpaceWallResult);
        this.aK.m12150b();
        this.aP.b();
        at(this);
        ar();
    }

    private void ar() {
        if (D() && this.an != null && this.aU != null) {
            this.an.a(this.aU);
        }
    }

    private void as() {
        this.ba = this.al.m12653a(getContext(), new RedSpaceFeedListType(this.aQ), this.bb, null, new C14414(this), this.aH.a(), this.aQ, GraphQLHelper.a(this.aL.n()));
        this.aP = new RedSpaceStoryLoadingIndicatorAdapter(this.aB);
        this.aJ = m12441a(this.ay, this.ba);
        this.aK = new RedSpaceFeedStateAdapter(this.ay, this.aL);
        if (this.aW != null) {
            this.aK.m12150b();
        }
        Builder builder = ImmutableList.builder();
        builder.c(m12441a(this.az, this.ba)).c(this.aJ).c(new SingleRowFbListAdapter(this.aK)).c(new SingleRowFbListAdapter(this.aP));
        this.aM = new MultiRowMultiAdapter(true, builder.b());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aJ.a(configuration);
    }

    private void m12444o(Bundle bundle) {
        this.aZ = this.aI.m12499a(this.an, this.aC.m12526a(this.aQ, this.ay, this.aM, this.aT), this.aL, this.ay, this.az, this.aQ);
        RedSpaceStoriesControllerCallbacksDispatcher redSpaceStoriesControllerCallbacksDispatcher = this.aZ;
        if (redSpaceStoriesControllerCallbacksDispatcher.f12013a != null) {
            redSpaceStoriesControllerCallbacksDispatcher.f12013a.a(this);
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12014b != null) {
            RedSpaceViewportMonitorFragmentController redSpaceViewportMonitorFragmentController = redSpaceStoriesControllerCallbacksDispatcher.f12014b;
            redSpaceViewportMonitorFragmentController.f12108a.a(redSpaceViewportMonitorFragmentController.f12109b);
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12015c != null) {
            RedSpaceFeedEventController redSpaceFeedEventController = redSpaceStoriesControllerCallbacksDispatcher.f12015c;
            redSpaceFeedEventController.f12055f.c = new SeeMoreControllerSubscriber(redSpaceFeedEventController);
            redSpaceFeedEventController.f12060k.a(redSpaceFeedEventController.f12055f.b);
            redSpaceFeedEventController.f12060k.a(new StoryVisibilityEventSubscriber(redSpaceFeedEventController));
            redSpaceFeedEventController.f12060k.a(new ChangeRendererEventSubscriber(redSpaceFeedEventController));
            redSpaceFeedEventController.f12060k.a(new FeedUnitMutatedEventSubscriber(redSpaceFeedEventController));
            redSpaceFeedEventController.f12061l.a(new StoryDeleteSubscriber(redSpaceFeedEventController));
            redSpaceFeedEventController.f12056g.a(new OfflinePostLoaderListener(redSpaceFeedEventController), redSpaceFeedEventController.f12057h.f11893f);
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12016d != null) {
            RedSpaceFriendViewMutationController redSpaceFriendViewMutationController = redSpaceStoriesControllerCallbacksDispatcher.f12016d;
            if (bundle != null) {
                redSpaceFriendViewMutationController.f12072h = bundle.getBoolean("bundle_friend_view_sent");
                redSpaceFriendViewMutationController.f12073i = bundle.getBoolean("bundle_friend_view_fetch");
            }
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12018f != null) {
            RedSpaceWallLoadEventController redSpaceWallLoadEventController = redSpaceStoriesControllerCallbacksDispatcher.f12018f;
            if (bundle != null) {
                redSpaceWallLoadEventController.f12115f = bundle.getInt("bundle_initial_badge_count");
                redSpaceWallLoadEventController.f12113d = bundle.getBoolean("bundle_wall_load_flushed");
                redSpaceWallLoadEventController.f12114e = bundle.getLong("bundle_wall_load_finished");
            }
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12019g != null) {
            RedSpaceComposerActivityController redSpaceComposerActivityController = redSpaceStoriesControllerCallbacksDispatcher.f12019g;
            redSpaceComposerActivityController.f12037a.a(redSpaceComposerActivityController.f12042f, redSpaceComposerActivityController.f12041e.f11893f);
        }
        if (redSpaceStoriesControllerCallbacksDispatcher.f12020h != null) {
            RedSpaceSelfViewMutationController redSpaceSelfViewMutationController = redSpaceStoriesControllerCallbacksDispatcher.f12020h;
            if (bundle != null) {
                redSpaceSelfViewMutationController.f12105c = bundle.getBoolean("bundle_self_view_sent");
                redSpaceSelfViewMutationController.f12106d = bundle.getBoolean("bundle_self_view_fetch");
            }
        }
        this.aZ.m12475a(this.aM, this.aU, this.ba);
    }

    public static void at(RedSpaceStoriesFragment redSpaceStoriesFragment) {
        if (redSpaceStoriesFragment.aM != null && !redSpaceStoriesFragment.aM.ba_()) {
            AdapterDetour.a(redSpaceStoriesFragment.aM, -1044251942);
        }
    }

    public final View m12448a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -676428659);
        View inflate = layoutInflater.inflate(2130906792, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 715151621, a);
        return inflate;
    }

    public final void m12449a(View view, Bundle bundle) {
        super.a(view, bundle);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) FindViewUtil.b(view, 2131566890);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        betterRecyclerView.setPadding(betterRecyclerView.getPaddingLeft(), this.aR, betterRecyclerView.getPaddingRight(), betterRecyclerView.getPaddingBottom());
        this.aU = new MultiRowAdapterRecyclerViewProxy(betterRecyclerView);
        this.an.a(false, this.aU);
        this.aU.a(this.aM);
        this.aU.a(this.f12002f.a());
        this.aU.b(this.an);
        betterRecyclerView.a(this.aO);
        if (this.aS != null) {
            betterRecyclerView.a(this.aS);
        }
    }

    public final void m12445G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -693682779);
        super.G();
        if (D()) {
            this.an.a(true, this.aU);
        }
        this.f12000d.e();
        at(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1097000094, a);
    }

    public final void m12446H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 12383199);
        this.an.a(false, this.aU);
        this.f12000d.d();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 182325274, a);
    }

    public final void m12447I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -633634865);
        this.ay.f11892e = null;
        this.f12000d.a();
        this.aJ.jc_();
        this.aM.jc_();
        this.aZ.kF_();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -950822343, a);
    }

    public final void m12452e(Bundle bundle) {
        super.e(bundle);
        RedSpaceWallCollection redSpaceWallCollection = this.ay;
        bundle.putParcelable("bundle_wall_collection", new State(redSpaceWallCollection.f11893f, redSpaceWallCollection.f11890c, redSpaceWallCollection.f11889b, redSpaceWallCollection.f11891d));
        RedSpaceHeaderCollection redSpaceHeaderCollection = this.az;
        bundle.putParcelable("bundle_header_collection", new RedSpaceHeaderCollection.State(redSpaceHeaderCollection.f11812b, redSpaceHeaderCollection.f11813c, redSpaceHeaderCollection.f11814d));
    }

    public final void m12453g(boolean z) {
        super.g(z);
        if (this.aU != null) {
            this.an.a(z, this.aU);
        }
        ar();
    }

    private MultiRowAdapter m12441a(ListItemCollection<?> listItemCollection, RedSpaceEnvironment redSpaceEnvironment) {
        MultiRowAdapterBuilder.Builder a = this.f12003g.a(this.am, listItemCollection);
        a.f = redSpaceEnvironment;
        return a.e();
    }

    public static void aw(RedSpaceStoriesFragment redSpaceStoriesFragment) {
        redSpaceStoriesFragment.aY.m12358a(redSpaceStoriesFragment.aV);
    }

    public Map<String, String> getDebugInfo() {
        if (this.aU == null) {
            return null;
        }
        return ((RedSpaceStoriesDebugWriter) this.aF.get()).m12369a(this.aU.q(), this.aU.r(), this.aM, (RedSpaceOptimisticBadgeStore) this.f11999b.get(), (RedSpaceTabUnseenCountFetcher) this.f11998a.get());
    }
}
