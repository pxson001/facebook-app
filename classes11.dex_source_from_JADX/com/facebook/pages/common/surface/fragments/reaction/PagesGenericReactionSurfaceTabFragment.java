package com.facebook.pages.common.surface.fragments.reaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.context.TimelinePageContext;
import com.facebook.pages.common.context.TimelinePageContext.PageProfilePermissionsProvider;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.reaction.state.PageNuxViewStateStore;
import com.facebook.pages.common.resulthandlers.ActivityResultHandlerResolver;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.sequencelogger.PagesSurfaceFirstCardPerfLogger;
import com.facebook.pages.common.sequencelogger.PagesSurfaceFirstCardPerfLogger.OnFirstCardRenderedListenerImpl;
import com.facebook.pages.common.surface.fragments.common.PagesFragmentWithUuid;
import com.facebook.pages.common.surface.fragments.eventsubscribers.StoryMenuNotifyMeEventSubscriber;
import com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesHelper;
import com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesHelperProvider;
import com.facebook.pages.common.surface.util.PagesReactionActionStyleToTabTypeMapper;
import com.facebook.pages.common.surfaceinterfaces.CanHandleCreateNewTab;
import com.facebook.pages.common.surfaceinterfaces.HasPageProfilePermissionsProvider;
import com.facebook.pages.common.surfaceinterfaces.HasPagesSurfaceTabs;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.pages.identity.timeline.storymenu.PagesTimelineFeedStoryMenuHelper;
import com.facebook.pages.identity.timeline.storymenu.PagesTimelineFeedStoryMenuHelperProvider;
import com.facebook.reaction.ReactionCacheWithNetworkReplayFetcher;
import com.facebook.reaction.ReactionCacheWithNetworkReplayFetcherProvider;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageAddTabEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageAddTabEventSubscriber;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageSeeAllEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageSeeAllEventSubscriber;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.ui.fragment.BaseReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEvent;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEventSubscriber;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.timeline.rows.TimelineFeedType;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_loaded_from_cache */
public class PagesGenericReactionSurfaceTabFragment extends BaseReactionFragment implements AnalyticsFragment, PagesFragmentWithUuid, PagesSurfaceTabFragment, ReactionSessionListener, ReactionCardContainer {
    @Inject
    PagesTimelineFeedStoryMenuHelperProvider f2441a;
    @Inject
    Lazy<DeleteStoryHelper> aA;
    @Inject
    Lazy<ActivityResultHandlerResolver> aB;
    @Inject
    Lazy<ReactionIntentLauncher> aC;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager aD;
    @Inject
    PageRelatedPagesHelperProvider aE;
    @Inject
    PageNuxViewStateStore aF;
    @Inject
    PagesReactionSessionEarlyFetchControllerProvider aG;
    @Inject
    ReactionCacheWithNetworkReplayFetcherProvider aH;
    private ReactionCacheWithNetworkReplayFetcher aI;
    private PagesSurfaceFragment aJ;
    private TimelinePageContext aK;
    private PagesTimelineFeedStoryMenuHelper aL;
    private FeedListType aM;
    public PageProfilePermissionsProvider aN;
    private FbEventSubscriberListManager aO;
    private FbEventSubscriberListManager aP;
    private FbEventSubscriberListManager aQ;
    private SelfRegistrableReceiverImpl aR;
    private PageRelatedPagesHelper aS;
    @Nullable
    public PagesSurfaceFirstCardPerfLogger aT;
    private boolean aU = true;
    public long aV;
    private PagesReactionSessionEarlyFetchController aW;
    public boolean aX;
    public boolean aY = false;
    public Surface aZ;
    @Inject
    @LoggedInUserId
    String am;
    @Inject
    public TasksManager an;
    @Inject
    Toaster ao;
    @Inject
    TimelineStoryEventBus ap;
    @Inject
    FeedEventBus aq;
    @Inject
    ReactionEventBus ar;
    @Inject
    StoryMenuNotifyMeEventSubscriber as;
    @Inject
    PagesGenericReactionMixedRecyclerViewAdapterProvider at;
    @Inject
    PagesAnalytics au;
    @Inject
    Lazy<ReactionSessionHelper> av;
    @Inject
    Lazy<ReactionSessionManager> aw;
    @Inject
    public Lazy<ComposerPublishServiceHelper> ax;
    @Inject
    public Lazy<FbErrorReporter> ay;
    @Inject
    Lazy<BlueServiceOperationFactory> az;
    public boolean ba;
    private boolean bb;
    public boolean bc;
    private boolean bd;
    public ParcelUuid be;
    private int bf = 0;
    private int bg;

    /* compiled from: results_loaded_from_cache */
    public class C03091 {
        public final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2426a;

        C03091(PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment) {
            this.f2426a = pagesGenericReactionSurfaceTabFragment;
        }
    }

    /* compiled from: results_loaded_from_cache */
    class C03124 extends ReactionPageSeeAllEventSubscriber {
        final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2432a;

        C03124(PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment) {
            this.f2432a = pagesGenericReactionSurfaceTabFragment;
        }

        public final void m3372b(FbEvent fbEvent) {
            ReactionPageSeeAllEvent reactionPageSeeAllEvent = (ReactionPageSeeAllEvent) fbEvent;
            HasPagesSurfaceTabs hasPagesSurfaceTabs = (HasPagesSurfaceTabs) this.f2432a.a(HasPagesSurfaceTabs.class);
            GraphQLReactionStoryActionStyle valueOf = GraphQLReactionStoryActionStyle.valueOf(reactionPageSeeAllEvent.c);
            GraphQLPagePresenceTabType graphQLPagePresenceTabType = (GraphQLPagePresenceTabType) PagesReactionActionStyleToTabTypeMapper.f2703a.get(valueOf);
            if (hasPagesSurfaceTabs != null && hasPagesSurfaceTabs.mo99c(graphQLPagePresenceTabType)) {
                hasPagesSurfaceTabs.mo100d(graphQLPagePresenceTabType);
                this.f2432a.au.a(this.f2432a.aV, graphQLPagePresenceTabType, valueOf);
            } else if (reactionPageSeeAllEvent.d != null) {
                ((ReactionIntentLauncher) this.f2432a.aC.get()).a(reactionPageSeeAllEvent.b, reactionPageSeeAllEvent.d, this.f2432a, this.f2432a.getContext());
            }
        }
    }

    /* compiled from: results_loaded_from_cache */
    class C03135 extends ReactionPageAddTabEventSubscriber {
        final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2433a;

        C03135(PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment) {
            this.f2433a = pagesGenericReactionSurfaceTabFragment;
        }

        public final void m3373b(FbEvent fbEvent) {
            ReactionPageAddTabEvent reactionPageAddTabEvent = (ReactionPageAddTabEvent) fbEvent;
            CanHandleCreateNewTab canHandleCreateNewTab = (CanHandleCreateNewTab) this.f2433a.a(CanHandleCreateNewTab.class);
            HasPagesSurfaceTabs hasPagesSurfaceTabs = (HasPagesSurfaceTabs) this.f2433a.a(HasPagesSurfaceTabs.class);
            GraphQLPagePresenceTabType graphQLPagePresenceTabType = reactionPageAddTabEvent.c;
            if (canHandleCreateNewTab != null && canHandleCreateNewTab.mo97a(graphQLPagePresenceTabType)) {
                canHandleCreateNewTab.mo98b(graphQLPagePresenceTabType);
            } else if (hasPagesSurfaceTabs != null && hasPagesSurfaceTabs.mo99c(graphQLPagePresenceTabType)) {
                hasPagesSurfaceTabs.mo100d(graphQLPagePresenceTabType);
            } else if (reactionPageAddTabEvent.d != null) {
                ((ReactionIntentLauncher) this.f2433a.aC.get()).a(reactionPageAddTabEvent.b, reactionPageAddTabEvent.d, this.f2433a, this.f2433a.getContext());
            }
        }
    }

    /* compiled from: results_loaded_from_cache */
    class C03146 implements ActionReceiver {
        final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2434a;

        C03146(PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment) {
            this.f2434a = pagesGenericReactionSurfaceTabFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1865180929);
            Result valueOf = Result.valueOf(intent.getStringExtra("extra_result"));
            if (!(valueOf == Result.SUCCESS || valueOf == Result.CANCELLED)) {
                this.f2434a.ao.a(new ToastBuilder(this.f2434a.jW_().getString(2131230758)));
                ((AbstractFbErrorReporter) this.f2434a.ay.get()).a(getClass().getName(), "Cannot edit post");
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1673124567, a);
        }
    }

    /* compiled from: results_loaded_from_cache */
    public class C03157 {
        public final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2435a;

        C03157(PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment) {
            this.f2435a = pagesGenericReactionSurfaceTabFragment;
        }
    }

    /* compiled from: results_loaded_from_cache */
    class DeleteStoryEventSubscriber extends DeleteStoryClickedEventSubscriber {
        final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2440a;

        public final void m3376b(FbEvent fbEvent) {
            final DeleteStoryClickedEvent deleteStoryClickedEvent = (DeleteStoryClickedEvent) fbEvent;
            this.f2440a.an.a(PagesAsyncTaskType.PAGE_TIMELINE_DELETE_POST, new Callable<ListenableFuture<OperationResult>>(this) {
                final /* synthetic */ DeleteStoryEventSubscriber f2437b;

                public Object call() {
                    Params params = new Params(deleteStoryClickedEvent.a, ImmutableList.of(deleteStoryClickedEvent.b), deleteStoryClickedEvent.c, DeleteMode.LOCAL_AND_SERVER);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("operationParams", params);
                    return BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f2437b.f2440a.az.get(), "timeline_delete_story", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), -1833046353).a();
                }
            }, new OperationResultFutureCallback(this) {
                final /* synthetic */ DeleteStoryEventSubscriber f2439b;

                protected final void m3374a(ServiceException serviceException) {
                    this.f2439b.f2440a.ao.a(new ToastBuilder(this.f2439b.f2440a.getContext().getResources().getString(2131230758)));
                    ((AbstractFbErrorReporter) this.f2439b.f2440a.ay.get()).a(getClass().getName(), StringFormatUtil.formatStrLocaleSafe("Cannot delete post: storyId = %s, cacheId = %s, legacyApiStoryId = %s", deleteStoryClickedEvent.c, deleteStoryClickedEvent.b, deleteStoryClickedEvent.a));
                }

                protected final void m3375a(Object obj) {
                    ((DeleteStoryHelper) this.f2439b.f2440a.aA.get()).a(new Params(deleteStoryClickedEvent.a, ImmutableList.of(deleteStoryClickedEvent.b), deleteStoryClickedEvent.c, DeleteMode.LOCAL_ONLY));
                }
            });
        }

        public DeleteStoryEventSubscriber(PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment) {
            this.f2440a = pagesGenericReactionSurfaceTabFragment;
            super(null);
        }
    }

    public static void m3379a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PagesGenericReactionSurfaceTabFragment) obj).m3378a((PagesTimelineFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesTimelineFeedStoryMenuHelperProvider.class), String_LoggedInUserIdMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), Toaster.a(injectorLike), TimelineStoryEventBus.a(injectorLike), FeedEventBus.a(injectorLike), ReactionEventBus.a(injectorLike), StoryMenuNotifyMeEventSubscriber.m3360a(injectorLike), (PagesGenericReactionMixedRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesGenericReactionMixedRecyclerViewAdapterProvider.class), PagesAnalytics.a(injectorLike), IdBasedLazy.a(injectorLike, 9835), IdBasedSingletonScopeProvider.b(injectorLike, 9836), IdBasedLazy.a(injectorLike, 5272), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 1144), IdBasedLazy.a(injectorLike, 6089), IdBasedLazy.a(injectorLike, 8972), IdBasedSingletonScopeProvider.b(injectorLike, 10086), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (PageRelatedPagesHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageRelatedPagesHelperProvider.class), PageNuxViewStateStore.m3160a(injectorLike), (PagesReactionSessionEarlyFetchControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesReactionSessionEarlyFetchControllerProvider.class), (ReactionCacheWithNetworkReplayFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionCacheWithNetworkReplayFetcherProvider.class));
    }

    public static PagesGenericReactionSurfaceTabFragment m3377a(long j, boolean z, boolean z2, Surface surface, String str, String str2, PageProfilePermissionsProvider pageProfilePermissionsProvider, ParcelUuid parcelUuid) {
        Preconditions.checkNotNull(pageProfilePermissionsProvider);
        Bundle bundle = new Bundle();
        PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment = new PagesGenericReactionSurfaceTabFragment();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putBoolean("extra_should_enable_related_pages_like_chaining", z);
        bundle.putBoolean("arg_should_support_cache", z2);
        bundle.putSerializable("arg_pages_surface_reaction_surface", surface);
        bundle.putString("arg_precreated_reaction_session_id", str);
        bundle.putString("arg_precreated_cached_reaction_session_id", str2);
        bundle.putParcelable("page_fragment_uuid", parcelUuid);
        pagesGenericReactionSurfaceTabFragment.g(bundle);
        pagesGenericReactionSurfaceTabFragment.aN = pageProfilePermissionsProvider;
        return pagesGenericReactionSurfaceTabFragment;
    }

    public final void m3390c(Bundle bundle) {
        PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger = null;
        Class cls = PagesGenericReactionSurfaceTabFragment.class;
        m3379a((Object) this, getContext());
        this.aV = this.s.getLong("com.facebook.katana.profile.id", -1);
        this.aX = this.s.getBoolean("extra_should_enable_related_pages_like_chaining", false);
        this.aY = this.s.getBoolean("arg_should_support_cache", false);
        this.aZ = (Surface) this.s.getSerializable("arg_pages_surface_reaction_surface");
        if (au()) {
            this.aT.a();
        }
        this.aV = this.s.getLong("com.facebook.katana.profile.id", -1);
        PagesReactionSessionEarlyFetchControllerProvider pagesReactionSessionEarlyFetchControllerProvider = this.aG;
        String valueOf = String.valueOf(this.aV);
        String string = this.s.getString("arg_precreated_reaction_session_id", null);
        String string2 = this.s.getString("arg_precreated_cached_reaction_session_id", null);
        C03091 c03091 = new C03091(this);
        if (this.bc) {
            pagesSurfaceFirstCardPerfLogger = this.aT;
        }
        this.aW = pagesReactionSessionEarlyFetchControllerProvider.m3434a(valueOf, string, string2, c03091, pagesSurfaceFirstCardPerfLogger);
        this.be = (ParcelUuid) this.s.getParcelable("page_fragment_uuid");
        as();
        super.c(bundle);
        if (this.aX) {
            this.aS = this.aE.m3635a(String.valueOf(this.aV), this, this.be);
            this.aS.m3634a();
        }
    }

    public final void m3387a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aJ = pagesSurfaceFragment;
    }

    public final void D_(int i) {
        this.bg = i;
        PagesScrollUtils.a(this.aq, this.bg);
    }

    public final void m3385a(View view, @Nullable Bundle bundle) {
        view.setBackgroundResource(0);
        this.aq.setVerticalScrollBarEnabled(false);
        if (au()) {
            this.aq.a(new OnFirstCardRenderedListenerImpl(this.aT));
        }
        E_(this.bf);
        D_(this.bg);
        if (au()) {
            PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger = this.aT;
            pagesSurfaceFirstCardPerfLogger.a.b("TimeToSurfaceTabFragmentViewCreated", PageSequences.g);
            pagesSurfaceFirstCardPerfLogger.b.a(1245309, (short) 101);
        }
    }

    protected final AbstractReactionRecyclerViewAdapter m3388b(Context context) {
        return this.at.m3368a(context, aP(), aO(), this);
    }

    public final void E_(int i) {
        this.bf = i;
        if (this.at != null) {
            ((PagesGenericReactionMixedRecyclerViewAdapter) this.at).m3367h(this.bf);
            this.at.notifyDataSetChanged();
        }
    }

    public final void m3386a(C05581 c05581) {
    }

    public final void m3391e() {
        boolean z = this.ba;
        this.ba = true;
        if (!z && this.bb) {
            kQ_();
            this.bb = false;
        }
    }

    public final String am_() {
        return "page_reaction_fragment";
    }

    public final void m3380G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1277462765);
        super.G();
        if (this.aO != null) {
            this.aO.a(this.ap);
        }
        if (this.aP != null) {
            this.aP.a(this.aq);
        }
        if (this.aQ != null) {
            this.aQ.a(this.ar);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 551029586, a);
    }

    public final void m3381H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1339103247);
        super.H();
        if (this.aO != null) {
            this.aO.b(this.ap);
        }
        if (this.aP != null) {
            this.aP.b(this.aq);
        }
        if (this.aQ != null) {
            this.aQ.b(this.ar);
        }
        if (au()) {
            this.aT.e();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1506085996, a);
    }

    public final void m3383a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            final ActivityResultHandler a = ((ActivityResultHandlerResolver) this.aB.get()).m3200a(i);
            if (a != null) {
                final DialogBasedProgressIndicator a2 = a.mo45a();
                if (a2 != null) {
                    a2.a();
                }
                final ListenableFuture a3 = a.mo46a(this.aV, null, this, intent, i);
                if (a3 != null) {
                    this.an.a("pages_activity_result_handler", new Callable<ListenableFuture>(this) {
                        final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2431b;

                        public Object call() {
                            return a3;
                        }
                    }, new OperationResultFutureCallback(this) {
                        final /* synthetic */ PagesGenericReactionSurfaceTabFragment f2429c;

                        public final void m3370a(Object obj) {
                            OperationResult operationResult = (OperationResult) obj;
                            if (a2 != null) {
                                a2.b();
                            }
                            if (a.mo49b()) {
                                this.f2429c.m3393j();
                            }
                            a.mo47a(operationResult);
                        }

                        protected final void m3369a(ServiceException serviceException) {
                            if (a2 != null) {
                                a2.b();
                            }
                            a.mo48a(serviceException);
                        }

                        protected final void m3371a(CancellationException cancellationException) {
                            super.a(cancellationException);
                            if (a2 != null) {
                                a2.b();
                            }
                        }
                    });
                }
                return;
            }
            switch (i) {
                case 1758:
                    if (i2 == -1 && intent != null) {
                        ((ComposerPublishServiceHelper) this.ax.get()).c(intent);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.at != null) {
            this.at.a(configuration);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1563879819);
        super.mY_();
        this.an.c();
        if (this.aR != null) {
            this.aR.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -561643115, a);
    }

    public final void m3382I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -751670665);
        super.I();
        if (this.aX) {
            PageRelatedPagesHelper pageRelatedPagesHelper = this.aS;
            pageRelatedPagesHelper.f2694f.m3628a(pageRelatedPagesHelper.f2692d);
            pageRelatedPagesHelper.f2696h.b(pageRelatedPagesHelper.f2697i);
            pageRelatedPagesHelper.f2690b.c();
        }
        PageNuxViewStateStore pageNuxViewStateStore = this.aF;
        pageNuxViewStateStore.f2138a.remove(String.valueOf(this.aV));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1531912844, a);
    }

    private void as() {
        this.aO = new FbEventSubscriberListManager();
        this.aP = new FbEventSubscriberListManager();
        this.aQ = new FbEventSubscriberListManager();
        this.aO.a(new DeleteStoryEventSubscriber(this));
        this.aP.a(this.as);
        if (ReactionSurfaceUtil.j(this.aZ)) {
            this.aQ.a(new C03124(this));
            this.aQ.a(new C03135(this));
        }
        this.aR = this.aD.a().a("com.facebook.STREAM_PUBLISH_COMPLETE", new C03146(this)).a();
        this.aR.b();
    }

    protected final ReactionSession ax() {
        String str;
        ReactionSession a;
        if (au()) {
            PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger = this.aT;
            pagesSurfaceFirstCardPerfLogger.a.b("TimeToFirstCardDataLoadStart", PageSequences.g);
            pagesSurfaceFirstCardPerfLogger.b.a(1245309, (short) 102);
        }
        if (!this.bd) {
            Object obj;
            if (this.aW.f2471k != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return this.aW.m3433a((ReactionSessionListener) this);
            }
        }
        if (au()) {
            this.aT.a("SurfaceFirstCardFromEarlyFetcher", "false");
        }
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.l = Long.valueOf(this.aV);
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.t = Long.valueOf(this.aV);
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.b = 2;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.i = NegativeFeedbackExperienceLocation.TIMELINE.stringValueOf();
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.o = RequestPriority.INTERACTIVE;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.y = this.aZ.toString();
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.w = am_();
        ReactionQueryParams reactionQueryParams2 = reactionQueryParams;
        if (this.bd) {
            str = "SubsequentLoad";
        } else {
            str = "InitialLoad";
        }
        reactionQueryParams2.x = str;
        reactionQueryParams = reactionQueryParams2;
        reactionQueryParams.z = ImmutableSet.of("page_reaction_initial_fetch_tag");
        reactionQueryParams2 = reactionQueryParams;
        if (!this.aY) {
            a = ((ReactionSessionHelper) this.av.get()).a(this.aZ, reactionQueryParams2);
            a.a(this);
        } else if (this.bd) {
            a = ((ReactionSessionHelper) this.av.get()).b(this.aZ, reactionQueryParams2);
            a.a(this);
        } else {
            this.aI = new ReactionCacheWithNetworkReplayFetcher(this, new C03157(this), ReactionSessionHelper.b(this.aH));
            ReactionCacheWithNetworkReplayFetcher reactionCacheWithNetworkReplayFetcher = this.aI;
            Surface surface = this.aZ;
            ReactionSession c = reactionCacheWithNetworkReplayFetcher.a.c(surface, reactionQueryParams2);
            c.a(reactionCacheWithNetworkReplayFetcher.b);
            reactionCacheWithNetworkReplayFetcher.d = reactionCacheWithNetworkReplayFetcher.a.b(surface, reactionQueryParams2);
            reactionCacheWithNetworkReplayFetcher.e = true;
            reactionCacheWithNetworkReplayFetcher.d.a(reactionCacheWithNetworkReplayFetcher.f);
            a = c;
        }
        reactionQueryParams2.x = "SubsequentLoad";
        reactionQueryParams2.b = 5;
        return a;
    }

    private void m3378a(PagesTimelineFeedStoryMenuHelperProvider pagesTimelineFeedStoryMenuHelperProvider, String str, TasksManager tasksManager, Toaster toaster, TimelineStoryEventBus timelineStoryEventBus, FeedEventBus feedEventBus, ReactionEventBus reactionEventBus, StoryMenuNotifyMeEventSubscriber storyMenuNotifyMeEventSubscriber, PagesGenericReactionMixedRecyclerViewAdapterProvider pagesGenericReactionMixedRecyclerViewAdapterProvider, PagesAnalytics pagesAnalytics, Lazy<ReactionSessionHelper> lazy, Lazy<ReactionSessionManager> lazy2, Lazy<ComposerPublishServiceHelper> lazy3, Lazy<FbErrorReporter> lazy4, Lazy<BlueServiceOperationFactory> lazy5, Lazy<DeleteStoryHelper> lazy6, Lazy<ActivityResultHandlerResolver> lazy7, Lazy<ReactionIntentLauncher> lazy8, FbBroadcastManager fbBroadcastManager, PageRelatedPagesHelperProvider pageRelatedPagesHelperProvider, PageNuxViewStateStore pageNuxViewStateStore, PagesReactionSessionEarlyFetchControllerProvider pagesReactionSessionEarlyFetchControllerProvider, ReactionCacheWithNetworkReplayFetcherProvider reactionCacheWithNetworkReplayFetcherProvider) {
        this.f2441a = pagesTimelineFeedStoryMenuHelperProvider;
        this.am = str;
        this.an = tasksManager;
        this.ao = toaster;
        this.ap = timelineStoryEventBus;
        this.aq = feedEventBus;
        this.ar = reactionEventBus;
        this.as = storyMenuNotifyMeEventSubscriber;
        this.at = pagesGenericReactionMixedRecyclerViewAdapterProvider;
        this.au = pagesAnalytics;
        this.av = lazy;
        this.aw = lazy2;
        this.ax = lazy3;
        this.ay = lazy4;
        this.az = lazy5;
        this.aA = lazy6;
        this.aB = lazy7;
        this.aC = lazy8;
        this.aD = fbBroadcastManager;
        this.aE = pageRelatedPagesHelperProvider;
        this.aF = pageNuxViewStateStore;
        this.aG = pagesReactionSessionEarlyFetchControllerProvider;
        this.aH = reactionCacheWithNetworkReplayFetcherProvider;
    }

    protected final BaseFeedStoryMenuHelper aO() {
        if (this.aL == null) {
            this.aL = this.f2441a.m5214a(at(), null);
            this.aL.f4234w = this;
        }
        return this.aL;
    }

    protected final FeedListType aP() {
        if (this.aM == null) {
            this.aM = new TimelineFeedType(at());
        }
        return this.aM;
    }

    protected final void m3384a(RecyclerView recyclerView) {
        if (this.aJ != null && D()) {
            this.aJ.m5039a((ViewGroup) recyclerView, aK());
        }
    }

    private TimelinePageContext at() {
        if (this.aK == null) {
            if (this.aN == null) {
                HasPageProfilePermissionsProvider hasPageProfilePermissionsProvider = (HasPageProfilePermissionsProvider) a(HasPageProfilePermissionsProvider.class);
                if (hasPageProfilePermissionsProvider != null) {
                    this.aN = hasPageProfilePermissionsProvider.mo96a();
                }
            }
            this.aK = TimelinePageContext.m2142a(Long.parseLong(this.am), this.aV, getSessionId(), new ParcelUuid(SafeUUIDGenerator.a()), "page_only", this.aN);
        }
        return this.aK;
    }

    public final void m3393j() {
        this.bd = true;
        ((ReactionSessionManager) this.aw.get()).g(getSessionId());
        this.bb = false;
        this.aU = true;
        az();
        aA();
        this.at.b(this.av);
    }

    public final boolean aD() {
        return false;
    }

    public final boolean kq_() {
        return this.aU;
    }

    public final void kQ_() {
        if (this.ba) {
            if (au() && this.av != null && this.av.A()) {
                this.aT.d();
            }
            super.kQ_();
            return;
        }
        this.bb = true;
    }

    public final void kp_() {
        super.kp_();
        if (au()) {
            this.aT.f();
        }
    }

    private boolean au() {
        return this.bc && this.aT != null;
    }

    protected final void m3389b(String str) {
    }

    public final ParcelUuid mo55h() {
        return this.be;
    }
}
