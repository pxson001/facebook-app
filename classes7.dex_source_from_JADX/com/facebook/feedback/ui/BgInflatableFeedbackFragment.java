package com.facebook.feedback.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateProxyScrollListener;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironmentProvider;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.FeedbackParams.Builder;
import com.facebook.ufiservices.flyout.FlyoutUtil;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIContentFragment;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollPerfHelper;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selected_object_id */
public final class BgInflatableFeedbackFragment extends FbFragment implements AnalyticsFragmentWithExtraData, FragmentWithDebugInfo, Bindable<GraphQLFeedback>, OnFeedbackLoadListener, UFIContentFragment {
    private static final CallerContext f4160a = CallerContext.a(BgInflatableFeedbackFragment.class);
    public static final String f4161b = BgInflatableFeedbackFragment.class.getSimpleName();
    @Inject
    @ForUiThread
    public ListeningExecutorService aA;
    @BackgroundExecutorService
    @Inject
    public ListeningExecutorService aB;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService aC;
    @Inject
    private InlineReplyExpansionExperimentUtil aD;
    @Inject
    private FeedbackLoader aE;
    public FeedbackParams aF;
    public ScrollingViewProxy aG;
    private PopoverFragmentContainer aH;
    public GraphQLFeedback aI;
    public CommentsHelper aJ;
    public CommentComposerView aK;
    private ViewGroup aL;
    private BaseCommentsEnvironment aM;
    public CommentAdapter aN;
    public MultiAdapterListAdapter aO;
    private LoadingIndicatorState aP;
    public FeedbackLoadingIndicatorController aQ;
    private Set<Bindable<FeedProps<GraphQLFeedback>>> aR;
    public ViewStub aS;
    private final RetryTrigger aT = new RetryTrigger(this);
    private FeedbackHeaderView aU;
    private FrameRateLogger aV;
    private ContextThemeWrapper aW;
    private OriginalPostButtonView aX;
    public ListenableFuture<ViewGroup> aY;
    public boolean aZ;
    @Inject
    public FeedbackCommentNavigationDelegateProvider al;
    @Inject
    private BaseCommentsEnvironmentProvider am;
    @Inject
    public FeedbackAnalyticsLogger an;
    @Inject
    private PerfTestConfig ao;
    @Inject
    private Lazy<ScrollPerfHelper> ap;
    @Inject
    public AbstractFbErrorReporter aq;
    @Inject
    @ForUiThread
    private Handler ar;
    @Inject
    public QeAccessor as;
    @Inject
    private GatekeeperStoreImpl at;
    @Inject
    private FunnelLoggerImpl au;
    @Inject
    public CommentComposerNuxHelper av;
    @Inject
    private FrameRateLoggerProvider aw;
    @Inject
    public UfiPerfUtil ax;
    @Inject
    private FeedbackHeaderViewListenerProvider ay;
    @Inject
    private OriginalPostButtonUtil az;
    private boolean ba;
    private boolean bb;
    public boolean bc;
    public boolean bd;
    public boolean be;
    private final OnDrawListener bf = new C03611(this);
    @Inject
    private CommentsHelperProvider f4162c;
    @Inject
    private CommentAdapterFactory f4163d;
    @Inject
    private SingletonFeedbackController f4164e;
    @Inject
    private FeedbackLoadingIndicatorControllerProvider f4165f;
    @Inject
    private FlyoutUtil f4166g;
    @Inject
    private ObjectMapper f4167h;
    @Inject
    private VpvEventHelper f4168i;

    /* compiled from: selected_object_id */
    /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] f4141a = new int[Direction.values().length];

        static {
            try {
                f4141a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4141a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: selected_object_id */
    class C03611 implements OnDrawListener {
        final /* synthetic */ BgInflatableFeedbackFragment f4142a;

        C03611(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
            this.f4142a = bgInflatableFeedbackFragment;
        }

        public final boolean gD_() {
            if (this.f4142a.bd) {
                this.f4142a.ax.F();
                this.f4142a.bd = false;
            }
            if (!this.f4142a.be) {
                return false;
            }
            this.f4142a.ax.G();
            this.f4142a.be = false;
            return true;
        }
    }

    /* compiled from: selected_object_id */
    class C03644 implements Runnable {
        final /* synthetic */ BgInflatableFeedbackFragment f4149a;

        C03644(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
            this.f4149a = bgInflatableFeedbackFragment;
        }

        public void run() {
            AdapterDetour.a(this.f4149a.aO, 559505008);
        }
    }

    /* compiled from: selected_object_id */
    class C03655 implements ScrollingProxy {
        final /* synthetic */ BgInflatableFeedbackFragment f4150a;

        C03655(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
            this.f4150a = bgInflatableFeedbackFragment;
        }

        public final int mo196a() {
            return this.f4150a.aO.a(this.f4150a.aN);
        }
    }

    /* compiled from: selected_object_id */
    class C03666 implements Function<GraphQLFeedback, Void> {
        final /* synthetic */ BgInflatableFeedbackFragment f4151a;

        C03666(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
            this.f4151a = bgInflatableFeedbackFragment;
        }

        public Object apply(@Nullable Object obj) {
            this.f4151a.m4780a((GraphQLFeedback) obj);
            return null;
        }
    }

    /* compiled from: selected_object_id */
    class C03699 extends Animation {
        final /* synthetic */ BgInflatableFeedbackFragment f4158a;

        C03699(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
            this.f4158a = bgInflatableFeedbackFragment;
        }
    }

    /* compiled from: selected_object_id */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ BgInflatableFeedbackFragment f4159a;

        public RetryTrigger(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
            this.f4159a = bgInflatableFeedbackFragment;
        }

        public final void m4762a() {
            BgInflatableFeedbackFragment.ay(this.f4159a);
        }
    }

    public static void m4765a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BgInflatableFeedbackFragment) obj).m4764a((CommentsHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentsHelperProvider.class), CommentAdapterFactory.m4798a(injectorLike), SingletonFeedbackController.m5296a(injectorLike), (FeedbackLoadingIndicatorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackLoadingIndicatorControllerProvider.class), FlyoutUtil.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), VpvEventHelper.a(injectorLike), (FeedbackCommentNavigationDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackCommentNavigationDelegateProvider.class), (BaseCommentsEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseCommentsEnvironmentProvider.class), FeedbackAnalyticsLogger.a(injectorLike), PerfTestConfig.a(injectorLike), IdBasedLazy.a(injectorLike, 3731), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike), CommentComposerNuxHelper.m4819a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), UfiPerfUtil.a(injectorLike), (FeedbackHeaderViewListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackHeaderViewListenerProvider.class), OriginalPostButtonUtil.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike), FeedbackLoader.a(injectorLike));
    }

    private void m4764a(CommentsHelperProvider commentsHelperProvider, CommentAdapterFactory commentAdapterFactory, SingletonFeedbackController singletonFeedbackController, FeedbackLoadingIndicatorControllerProvider feedbackLoadingIndicatorControllerProvider, FlyoutUtil flyoutUtil, ObjectMapper objectMapper, VpvEventHelper vpvEventHelper, FeedbackCommentNavigationDelegateProvider feedbackCommentNavigationDelegateProvider, BaseCommentsEnvironmentProvider baseCommentsEnvironmentProvider, FeedbackAnalyticsLogger feedbackAnalyticsLogger, PerfTestConfig perfTestConfig, Lazy<ScrollPerfHelper> lazy, FbErrorReporter fbErrorReporter, Handler handler, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, FunnelLogger funnelLogger, CommentComposerNuxHelper commentComposerNuxHelper, FrameRateLoggerProvider frameRateLoggerProvider, UfiPerfUtil ufiPerfUtil, FeedbackHeaderViewListenerProvider feedbackHeaderViewListenerProvider, OriginalPostButtonUtil originalPostButtonUtil, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, ListeningExecutorService listeningExecutorService3, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil, FeedbackLoader feedbackLoader) {
        this.f4162c = commentsHelperProvider;
        this.f4163d = commentAdapterFactory;
        this.f4164e = singletonFeedbackController;
        this.f4165f = feedbackLoadingIndicatorControllerProvider;
        this.f4166g = flyoutUtil;
        this.f4167h = objectMapper;
        this.f4168i = vpvEventHelper;
        this.al = feedbackCommentNavigationDelegateProvider;
        this.am = baseCommentsEnvironmentProvider;
        this.an = feedbackAnalyticsLogger;
        this.ao = perfTestConfig;
        this.ap = lazy;
        this.aq = fbErrorReporter;
        this.ar = handler;
        this.as = qeAccessor;
        this.at = gatekeeperStore;
        this.au = funnelLogger;
        this.av = commentComposerNuxHelper;
        this.aw = frameRateLoggerProvider;
        this.ax = ufiPerfUtil;
        this.ay = feedbackHeaderViewListenerProvider;
        this.az = originalPostButtonUtil;
        this.aA = listeningExecutorService;
        this.aB = listeningExecutorService2;
        this.aC = listeningExecutorService3;
        this.aD = inlineReplyExpansionExperimentUtil;
        this.aE = feedbackLoader;
    }

    public final void m4787c(Bundle bundle) {
        Class cls = BgInflatableFeedbackFragment.class;
        m4765a((Object) this, getContext());
        if (bundle == null) {
            bundle = this.s;
        }
        if (bundle != null) {
            this.aF = (FeedbackParams) bundle.getParcelable("feedbackParams");
            this.aF.a(FeedbackDisplayType.DEFAULT_FEEDBACK);
            this.aP = (LoadingIndicatorState) bundle.getParcelable("loadingState");
        }
        if (this.aI == null) {
            this.aI = this.aF.a;
        }
        ay(this);
        Object obj = (this.aI == null || !(this.aI.z_() == null || this.aI.j() == null)) ? null : 1;
        if (obj != null) {
            String i;
            if (this.aF.g != null) {
                i = this.aF.g.i();
            } else {
                i = "no logging debug info";
            }
            this.aq.a("BgInflatableFeedbackFragment_FeedbackNullIDs", "Feedback passed to BgInflatableFeedbackFragment has a null id: id: " + this.aI.z_() + ", legacyapipostid: " + this.aI.j() + ", loggingparams: " + i);
        }
        this.aR = Collections.synchronizedSet(new HashSet());
        this.aV = this.aw.a(Boolean.valueOf(false), "default_feedback_scroll_perf", Absent.INSTANCE);
        this.ax.i();
    }

    public final View m4775a(LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 558983663);
        this.ax.j();
        final LayoutInflater from = LayoutInflater.from(aC());
        final ViewGroup viewGroup2 = (ViewGroup) from.inflate(2130904355, viewGroup, false);
        this.aY = (this.as.a(ExperimentsForFeedbackTestModule.c, false) ? this.aC : this.aB).a(new Callable<ViewGroup>(this) {
            final /* synthetic */ BgInflatableFeedbackFragment f4145c;

            public Object call() {
                return BgInflatableFeedbackFragment.m4763a(this.f4145c, from, viewGroup);
            }
        });
        Futures.a(this.aY, new FutureCallback<ViewGroup>(this) {
            final /* synthetic */ BgInflatableFeedbackFragment f4148c;

            public void onSuccess(@Nullable Object obj) {
                int i;
                ViewGroup viewGroup = (ViewGroup) obj;
                if (viewGroup == null) {
                    BLog.b(BgInflatableFeedbackFragment.f4161b, "mBackgroundInflateFuture has null result");
                }
                this.f4148c.ax.l();
                BgInflatableFeedbackFragment bgInflatableFeedbackFragment = this.f4148c;
                ViewGroup viewGroup2 = viewGroup2;
                int i2 = 0;
                View[] viewArr = new View[viewGroup.getChildCount()];
                for (i = 0; i < viewGroup.getChildCount(); i++) {
                    viewArr[i] = viewGroup.getChildAt(i);
                }
                viewGroup.removeAllViews();
                viewGroup2.removeAllViews();
                i = viewArr.length;
                while (i2 < i) {
                    viewGroup2.addView(viewArr[i2]);
                    i2++;
                }
                BgInflatableFeedbackFragment.m4766b(this.f4148c, viewGroup2, bundle);
                this.f4148c.ax.m();
                this.f4148c.ax.a.c(3735584, "NNF_FlyoutBgInflatableFeedbackTotalTime");
            }

            public void onFailure(Throwable th) {
                BLog.b(BgInflatableFeedbackFragment.f4161b, "backgroundInflationImpl() error", th);
            }
        }, this.aA);
        this.aZ = false;
        this.ax.k();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -545312594, a);
        return viewGroup2;
    }

    public static ViewGroup m4763a(BgInflatableFeedbackFragment bgInflatableFeedbackFragment, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        bgInflatableFeedbackFragment.ax.a.d(3735585, "NNF_FlyoutBgInflationTime");
        bgInflatableFeedbackFragment.aH = (PopoverFragmentContainer) bgInflatableFeedbackFragment.G;
        bgInflatableFeedbackFragment.aQ = bgInflatableFeedbackFragment.f4165f.m5110a(bgInflatableFeedbackFragment.aP, bgInflatableFeedbackFragment.aT);
        bgInflatableFeedbackFragment.aQ.a();
        BaseCommentNavigationDelegate a = bgInflatableFeedbackFragment.al.m5040a(bgInflatableFeedbackFragment.aH, bgInflatableFeedbackFragment.aF);
        bgInflatableFeedbackFragment.aM = bgInflatableFeedbackFragment.am.m5348a(bgInflatableFeedbackFragment.aC(), a, new C03644(bgInflatableFeedbackFragment));
        bgInflatableFeedbackFragment.aN = bgInflatableFeedbackFragment.f4163d.m4801a(a, bgInflatableFeedbackFragment.aM, bgInflatableFeedbackFragment.aF.c);
        bgInflatableFeedbackFragment.aO = MultiAdapterListAdapter.a(new FbListAdapter[]{bgInflatableFeedbackFragment.aN});
        bgInflatableFeedbackFragment.aJ = bgInflatableFeedbackFragment.f4162c.m4974a(bgInflatableFeedbackFragment, bgInflatableFeedbackFragment.aN, bgInflatableFeedbackFragment.aM, new C03655(bgInflatableFeedbackFragment), new C03666(bgInflatableFeedbackFragment));
        bgInflatableFeedbackFragment.aJ.m4959a(bgInflatableFeedbackFragment.aF.g);
        if (bgInflatableFeedbackFragment.aF.k != null) {
            bgInflatableFeedbackFragment.aJ.m4962a(bgInflatableFeedbackFragment.aF.k);
        }
        bgInflatableFeedbackFragment.aR.add(bgInflatableFeedbackFragment.aJ);
        bgInflatableFeedbackFragment.aJ.m4960a(bgInflatableFeedbackFragment.aF.l);
        bgInflatableFeedbackFragment.an.d(bgInflatableFeedbackFragment.aF.g);
        View view = (ViewGroup) layoutInflater.inflate(2130904356, viewGroup, false);
        bgInflatableFeedbackFragment.m4767d(view);
        bgInflatableFeedbackFragment.aU = (FeedbackHeaderView) FindViewUtil.b(view, 2131562057);
        bgInflatableFeedbackFragment.aU.f4541g = bgInflatableFeedbackFragment.ay.m5103a(bgInflatableFeedbackFragment);
        bgInflatableFeedbackFragment.aR.add(bgInflatableFeedbackFragment.aU);
        bgInflatableFeedbackFragment.aL = (ViewGroup) FindViewUtil.b(view, 2131562055);
        bgInflatableFeedbackFragment.aS = (ViewStub) FindViewUtil.b(view, 2131562054);
        bgInflatableFeedbackFragment.ax.a.c(3735585, "NNF_FlyoutBgInflationTime");
        return view;
    }

    public final void m4778a(View view, Bundle bundle) {
    }

    public static void m4766b(BgInflatableFeedbackFragment bgInflatableFeedbackFragment, View view, Bundle bundle) {
        if (!bgInflatableFeedbackFragment.aZ) {
            super.a(view, bundle);
            BetterRecyclerView betterRecyclerView = (BetterRecyclerView) ((ViewStub) FindViewUtil.b(view, 2131562052)).inflate();
            betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
            betterRecyclerView.setWillNotDraw(false);
            bgInflatableFeedbackFragment.aG = new RecyclerViewProxy(betterRecyclerView);
            bgInflatableFeedbackFragment.aG.a(bgInflatableFeedbackFragment.aO);
            bgInflatableFeedbackFragment.aK = (CommentComposerView) FindViewUtil.b(view, 2131558483);
            if (PerfTestConfigBase.a()) {
                final ScrollPerfHelper scrollPerfHelper = (ScrollPerfHelper) bgInflatableFeedbackFragment.ap.get();
                bgInflatableFeedbackFragment.aG.a(new OnScrollListener(bgInflatableFeedbackFragment) {
                    final /* synthetic */ BgInflatableFeedbackFragment f4153b;

                    public final void m4760a(ScrollingViewProxy scrollingViewProxy, int i) {
                        scrollPerfHelper.a(i);
                    }

                    public final void m4761a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                    }
                });
            }
            bgInflatableFeedbackFragment.aJ.m4958a(view, bgInflatableFeedbackFragment.aG);
            bgInflatableFeedbackFragment.au.a(FunnelRegistry.D);
            bgInflatableFeedbackFragment.aG.b(bgInflatableFeedbackFragment.bf);
            bgInflatableFeedbackFragment.aG.a(new FrameRateProxyScrollListener(bgInflatableFeedbackFragment.aV));
            bgInflatableFeedbackFragment.aH.dC_();
            bgInflatableFeedbackFragment.ba = true;
            bgInflatableFeedbackFragment.m4771j(bgInflatableFeedbackFragment.aI);
            if (bgInflatableFeedbackFragment.bc) {
                bgInflatableFeedbackFragment.m4769e(bgInflatableFeedbackFragment.aI);
            } else {
                Object obj;
                GraphQLFeedback graphQLFeedback = bgInflatableFeedbackFragment.aI;
                if (graphQLFeedback == null || (GraphQLHelper.g(graphQLFeedback) == 0 && GraphQLHelper.f(graphQLFeedback) > 0)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    View inflate = bgInflatableFeedbackFragment.aS.inflate();
                    LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) FindViewUtil.b(inflate, 2131562060);
                    bgInflatableFeedbackFragment.aG.f(inflate);
                    bgInflatableFeedbackFragment.aQ.a(loadingIndicatorView);
                }
                bgInflatableFeedbackFragment.ax();
            }
            if (bgInflatableFeedbackFragment.bb) {
                bgInflatableFeedbackFragment.az();
                bgInflatableFeedbackFragment.aA();
            }
        }
    }

    private void ax() {
        if (aD()) {
            this.aJ.m4972g();
        }
    }

    public final void m4777a(final int i, final int i2, final Intent intent) {
        super.a(i, i2, intent);
        Futures.a(this.aY, new FutureCallback<ViewGroup>(this) {
            final /* synthetic */ BgInflatableFeedbackFragment f4157d;

            public void onSuccess(@Nullable Object obj) {
                if (!this.f4157d.aZ) {
                    this.f4157d.aJ.m4957a(i, i2, intent);
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.aA);
    }

    public final void m4789d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 384004604);
        this.ax.n();
        super.d(bundle);
        this.ax.o();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1359180439, a);
    }

    public final void m4773H() {
        ArrayNode arrayNode;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -131756443);
        this.ax.C();
        this.aV.b();
        super.H();
        if (this.aF.g != null) {
            arrayNode = this.aF.g.a;
        } else {
            arrayNode = null;
        }
        this.f4168i.a(arrayNode, "story_feedback_flyout");
        if (this.aJ != null) {
            this.aJ.m4968c();
        }
        LogUtils.f(-654700189, a);
    }

    public final void m4772G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -875654640);
        this.ax.p();
        this.ax.w();
        super.G();
        this.f4168i.a();
        this.f4168i.b();
        if (this.aJ != null) {
            this.aJ.m4969d();
        }
        this.ax.q();
        this.ax.r();
        this.ax.z();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1121076450, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 800846496);
        super.mY_();
        this.aZ = true;
        if (this.aJ != null) {
            this.aR.remove(this.aJ);
            this.aJ.m4956a();
        }
        if (this.aQ != null) {
            this.aQ.c();
        }
        if (this.aG != null) {
            if (!this.at.a(831, false)) {
                this.aG.a(null);
                this.aG.f(null);
            }
            this.aG.x();
            this.aG.a(null);
            this.aG = null;
        }
        if (this.aU != null) {
            this.aU.f4541g = null;
            this.aR.remove(this.aU);
            this.aU = null;
        }
        this.aK = null;
        this.aL = null;
        this.aS = null;
        this.aX = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 14012994, a);
    }

    public final void m4774I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1846732606);
        super.I();
        if (this.aJ != null) {
            this.aJ.m4967b();
        }
        if (this.aN != null) {
            this.aN.jc_();
        }
        if (!(this.aM == null || this.at.a(831, false))) {
            this.aM.m5335a();
        }
        if (this.aY != null) {
            this.aY.cancel(true);
            this.aY = null;
        }
        this.aH = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1336442638, a);
    }

    public final void m4791e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("feedbackParams", this.aF);
        if (this.aQ != null) {
            bundle.putParcelable("loadingState", this.aQ.a);
        }
    }

    public final String ar() {
        return "flyout_feedback_animation_perf";
    }

    public final Animation m4776a(int i, boolean z, int i2) {
        if (!this.f4166g.a) {
            Animation c03699 = new C03699(this);
            c03699.setDuration(0);
            return c03699;
        } else if (i2 != 0) {
            return AnimationUtils.loadAnimation(getContext(), i2);
        } else {
            return null;
        }
    }

    public final void m4780a(GraphQLFeedback graphQLFeedback) {
        this.aI = graphQLFeedback;
        if (this.ba && F() != null) {
            GraphQLFeedback a = this.aJ.m4955a(graphQLFeedback);
            Object c = a != null ? FeedProps.c(a) : null;
            synchronized (this.aR) {
                for (Bindable a2 : this.aR) {
                    a2.mo198a(c);
                }
            }
        }
    }

    public final boolean m4785b() {
        return this.aJ != null && this.aJ.m4966a(getContext());
    }

    public final void m4790e() {
        this.ax.A();
        this.ax.x();
    }

    public final void aq() {
        this.bb = true;
        if (this.ba) {
            az();
            aA();
        }
        this.ax.y();
        this.ax.B();
    }

    public final void as() {
        if (this.aK != null) {
            this.aK.mo247h();
        }
    }

    public final boolean m4782a(float f, float f2, Direction direction) {
        if (this.T == null) {
            return true;
        }
        if (this.aK == null || !this.aK.mo243a(f, f2)) {
            return false;
        }
        switch (AnonymousClass12.f4141a[direction.ordinal()]) {
            case 1:
                return this.aG.l();
            case 2:
                return this.aG.n();
            default:
                return false;
        }
    }

    public final View at() {
        if (this.aK == null) {
            return null;
        }
        return this.aK.getSelfAsView();
    }

    public final void m4783b(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.aL.addView(view);
        }
    }

    public final void mo199b(final GraphQLFeedback graphQLFeedback) {
        if (CommentOrderType.getOrder(graphQLFeedback).equals(CommentOrderType.RANKED_ORDER) && this.aD.b()) {
            Futures.a(this.aE.a(graphQLFeedback), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                final /* synthetic */ BgInflatableFeedbackFragment f4138b;

                protected final void m4755a(Object obj) {
                    BgInflatableFeedbackFragment.m4768d(this.f4138b, (GraphQLFeedback) obj);
                }

                protected final void m4756a(Throwable th) {
                    BgInflatableFeedbackFragment.m4768d(this.f4138b, graphQLFeedback);
                }
            }, this.aA);
        } else {
            m4768d(this, graphQLFeedback);
        }
    }

    public static void m4768d(BgInflatableFeedbackFragment bgInflatableFeedbackFragment, GraphQLFeedback graphQLFeedback) {
        bgInflatableFeedbackFragment.bc = true;
        bgInflatableFeedbackFragment.be = true;
        bgInflatableFeedbackFragment.aI = graphQLFeedback;
        boolean z = false;
        if (!(graphQLFeedback == null || bgInflatableFeedbackFragment.aI == null)) {
            boolean z2 = GraphQLHelper.p(graphQLFeedback) != GraphQLHelper.p(bgInflatableFeedbackFragment.aI);
            if (GraphQLHelper.f(graphQLFeedback) != GraphQLHelper.f(bgInflatableFeedbackFragment.aI)) {
                z = true;
            }
            if (z2 || z) {
                FeedbackLoggingParams feedbackLoggingParams;
                FeedbackAnalyticsLogger feedbackAnalyticsLogger = bgInflatableFeedbackFragment.an;
                GraphQLFeedback graphQLFeedback2 = bgInflatableFeedbackFragment.aI;
                if (bgInflatableFeedbackFragment.aF != null) {
                    feedbackLoggingParams = bgInflatableFeedbackFragment.aF.g;
                } else {
                    feedbackLoggingParams = null;
                }
                feedbackAnalyticsLogger.a(graphQLFeedback2, feedbackLoggingParams, z, z2);
            }
        }
        if (bgInflatableFeedbackFragment.ba) {
            bgInflatableFeedbackFragment.m4771j(graphQLFeedback);
            bgInflatableFeedbackFragment.m4769e(graphQLFeedback);
        }
        bgInflatableFeedbackFragment.ax.h();
        if (GraphQLHelper.f(graphQLFeedback) == 0) {
            bgInflatableFeedbackFragment.ax.G();
        }
    }

    private void m4769e(GraphQLFeedback graphQLFeedback) {
        if (!(this.aK == null || this.aK.getPhotoButton() == null)) {
            this.av.m4820a(graphQLFeedback, this.aK.getPhotoButton());
            if (this.av.m4821a()) {
                Builder builder = new Builder();
                builder = Builder.a(this.aF);
                builder.i = false;
                this.aF = builder.a();
            }
        }
        if (this.aF.m != null) {
            this.aJ.m4964a(this.aF.m);
        } else if (this.aF.h && !CommentOrderType.isReverseOrder(this.aI)) {
            this.aJ.m4970e();
        }
        this.aQ.b();
        if (aD()) {
            this.aJ.m4973h();
        }
    }

    public final void mo200c(final GraphQLFeedback graphQLFeedback) {
        if (CommentOrderType.getOrder(graphQLFeedback).equals(CommentOrderType.RANKED_ORDER) && this.aD.b()) {
            Futures.a(this.aE.b(graphQLFeedback), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                final /* synthetic */ BgInflatableFeedbackFragment f4140b;

                protected final void m4757a(Object obj) {
                    BgInflatableFeedbackFragment.m4770h(this.f4140b, (GraphQLFeedback) obj);
                }

                protected final void m4758a(Throwable th) {
                    BgInflatableFeedbackFragment.m4770h(this.f4140b, graphQLFeedback);
                }
            }, this.aA);
        } else {
            m4770h(this, graphQLFeedback);
        }
    }

    public static void m4770h(BgInflatableFeedbackFragment bgInflatableFeedbackFragment, GraphQLFeedback graphQLFeedback) {
        bgInflatableFeedbackFragment.bd = true;
        if (graphQLFeedback == null || GraphQLHelper.e(graphQLFeedback)) {
            bgInflatableFeedbackFragment.ax.f();
            return;
        }
        Object obj = 1;
        if (bgInflatableFeedbackFragment.bc || graphQLFeedback == null) {
            obj = null;
        } else if (bgInflatableFeedbackFragment.aI != null && GraphQLHelper.g(graphQLFeedback) <= GraphQLHelper.g(bgInflatableFeedbackFragment.aI)) {
            obj = null;
        }
        if (obj != null) {
            bgInflatableFeedbackFragment.aI = graphQLFeedback;
            if (bgInflatableFeedbackFragment.ba) {
                bgInflatableFeedbackFragment.m4771j(graphQLFeedback);
                bgInflatableFeedbackFragment.aQ.b();
            }
        }
        bgInflatableFeedbackFragment.ax.e();
        bgInflatableFeedbackFragment.ax.g();
        if (GraphQLHelper.f(graphQLFeedback) == 0) {
            bgInflatableFeedbackFragment.ax.F();
        }
    }

    public final void mo197a(ServiceException serviceException, FeedbackParams feedbackParams) {
        if (hn_()) {
            if (this.aQ != null) {
                this.aQ.m5109a(serviceException, jW_(), this.aT);
            }
            if (this.aJ != null && aD()) {
                this.aJ.m4973h();
            }
            this.ax.a(serviceException);
        }
    }

    public static void ay(BgInflatableFeedbackFragment bgInflatableFeedbackFragment) {
        if (bgInflatableFeedbackFragment.aQ != null) {
            bgInflatableFeedbackFragment.aQ.a();
        }
        bgInflatableFeedbackFragment.f4164e.m5303a(bgInflatableFeedbackFragment.aF, f4160a, bgInflatableFeedbackFragment);
    }

    private void m4771j(GraphQLFeedback graphQLFeedback) {
        m4780a(graphQLFeedback);
        double log10 = Math.log10((double) GraphQLHelper.g(graphQLFeedback)) / Math.log10(2.0d);
        long round = Math.round(log10);
        if (((double) round) < log10) {
            round++;
        }
        this.au.a(FunnelRegistry.D, "comments_shown_" + round);
    }

    private void az() {
        if (this.aF.i && this.aK != null) {
            this.aK.mo248i();
            this.aK.mo252m();
            Builder builder = new Builder();
            builder = Builder.a(this.aF);
            builder.i = false;
            this.aF = builder.a();
        }
    }

    private void aA() {
        if ("after_animation".equals(this.as.a(ExperimentsForFeedbackTestModule.Q, "no_upgrade")) && this.aK != null) {
            this.aK.mo251l();
        }
    }

    public final Map<String, String> getDebugInfo() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Feedback Params", this.aF.u());
        hashMap.put("Has Fetched Feedback: ", this.bc ? "True" : "False");
        if (this.aI != null) {
            try {
                hashMap.put("Feedback Object", this.f4167h.g().a().a(this.aI));
            } catch (IOException e) {
            }
        }
        return hashMap;
    }

    public final String am_() {
        return "story_feedback_flyout";
    }

    public final Map<String, Object> m4786c() {
        Map<String, Object> hashMap = new HashMap();
        Bundle bundle = this.s;
        if (bundle == null) {
            return hashMap;
        }
        FeedbackParams feedbackParams = (FeedbackParams) bundle.getParcelable("feedbackParams");
        if (feedbackParams == null) {
            return hashMap;
        }
        GraphQLFeedback graphQLFeedback = feedbackParams.a;
        if (graphQLFeedback != null) {
            if (CommentOrderType.isRanked(graphQLFeedback)) {
                hashMap.put("ranked_comments", Boolean.valueOf(true));
            }
            if (graphQLFeedback.j() != null) {
                hashMap.put("post_id", graphQLFeedback.j());
            } else if (feedbackParams.d() != null) {
                hashMap.put("post_id", feedbackParams.d());
            }
            if (feedbackParams.k != null) {
                hashMap.put("source_group_id", feedbackParams.k);
            }
        }
        return hashMap;
    }

    private Context aC() {
        if (this.aW == null) {
            this.aW = new ContextThemeWrapper(getContext(), 2131625259);
        }
        return this.aW;
    }

    private boolean aD() {
        if (this.aI == null || GraphQLHelper.f(this.aI) <= 0 || this.aF.o == CommentOrderType.RANKED_ORDER || !this.as.a(ExperimentsForFeedbackTestModule.G, false)) {
            return false;
        }
        return true;
    }

    private void m4767d(View view) {
        if (this.aF != null) {
            FeedProps feedProps = this.aF.c;
            if (this.az.a(feedProps) && !this.as.a(ExperimentsForFeedbackTestModule.P, false)) {
                GraphQLStory L = ((GraphQLStory) feedProps.a).L();
                this.aX = (OriginalPostButtonView) ((ViewStub) view.findViewById(2131562058)).inflate();
                this.aX.m5187a(L);
            }
        }
    }
}
