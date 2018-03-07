package com.facebook.feedback.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.DeferredConsumptionController.C04061;
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
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.FlyoutUtil;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIContentFragment;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollPerfHelper;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selected_state */
public abstract class BaseFeedbackFragment extends FbFragment implements AnalyticsFragmentWithExtraData, FragmentWithDebugInfo, Bindable<GraphQLFeedback>, OnFeedbackLoadListener, UFIContentFragment {
    private static final CallerContext aH = CallerContext.a(BaseFeedbackFragment.class);
    @Inject
    CommentsHelperProvider f4128a;
    @Inject
    @ForUiThread
    Executor aA;
    public FeedbackParams aB;
    protected ScrollingViewProxy aC;
    protected PopoverFragmentContainer aD;
    public GraphQLFeedback aE;
    protected GraphQLFeedback aF;
    public CommentsHelper aG;
    public CommentComposerView aI;
    public ViewGroup aJ;
    public BaseCommentsEnvironment aK;
    public CommentAdapter aL;
    public MultiAdapterListAdapter aM;
    public LoadingIndicatorState aN;
    public FeedbackLoadingIndicatorController aO;
    public Set<Bindable<FeedProps<GraphQLFeedback>>> aP;
    public ViewStub aQ;
    public boolean aR;
    public boolean aS;
    public boolean aT;
    public boolean aU;
    public boolean aV;
    public final RetryTrigger aW = new RetryTrigger(this);
    public Runnable aX;
    @Inject
    BaseCommentsEnvironmentProvider al;
    @Inject
    FeedbackAnalyticsLogger am;
    @Inject
    PerfTestConfig an;
    @Inject
    Lazy<ScrollPerfHelper> ao;
    @Inject
    AbstractFbErrorReporter ap;
    @Inject
    @ForUiThread
    public Handler aq;
    @Inject
    public QeAccessor ar;
    @Inject
    GatekeeperStoreImpl as;
    @Inject
    SaveUpsellUiController at;
    @Inject
    FunnelLoggerImpl au;
    @Inject
    CommentComposerNuxHelper av;
    @Inject
    FeedbackHeaderAdapter aw;
    @Inject
    DeferredConsumptionController ax;
    @Inject
    InlineReplyExpansionExperimentUtil ay;
    @Inject
    FeedbackLoader az;
    @Inject
    CommentAdapterFactory f4129b;
    @Inject
    FeedbackControllerProvider f4130c;
    @Inject
    SingletonFeedbackController f4131d;
    @Inject
    FeedbackLoadingIndicatorControllerProvider f4132e;
    @Inject
    FlyoutUtil f4133f;
    @Inject
    ObjectMapper f4134g;
    @Inject
    VpvEventHelper f4135h;
    @Inject
    FeedbackCommentNavigationDelegateProvider f4136i;

    /* compiled from: selected_state */
    class C03482 extends Animation {
        final /* synthetic */ BaseFeedbackFragment f4104a;

        C03482(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4104a = baseFeedbackFragment;
        }
    }

    /* compiled from: selected_state */
    class C03493 extends BaseAnimationListener {
        final /* synthetic */ BaseFeedbackFragment f4105a;

        C03493(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4105a = baseFeedbackFragment;
        }

        public void onAnimationEnd(Animation animation) {
            if (animation.getDuration() != 0) {
                this.f4105a.aV = true;
                BaseFeedbackFragment.m4727a(this.f4105a, false);
            }
            if (this.f4105a.aD != null) {
                this.f4105a.aD.dC_();
            }
        }
    }

    /* compiled from: selected_state */
    class C03526 implements Runnable {
        final /* synthetic */ BaseFeedbackFragment f4110a;
        private int f4111b = 0;

        C03526(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4110a = baseFeedbackFragment;
        }

        public void run() {
            this.f4111b++;
            if (this.f4111b <= 5) {
                if (this.f4110a.aS && this.f4110a.aT) {
                    BaseFeedbackFragment.m4733f(this.f4110a, this.f4110a.aF);
                    if (GraphQLHelper.f(this.f4110a.aF) > 0 || this.f4110a.ar.a(ExperimentsForNewsFeedAbTestModule.o, false)) {
                        this.f4110a.aO.b();
                    }
                    BaseFeedbackFragment.m4727a(this.f4110a, false);
                    return;
                }
                HandlerDetour.a(this.f4110a.aq, this, 1109958965);
            }
        }
    }

    /* compiled from: selected_state */
    class C03537 implements Runnable {
        final /* synthetic */ BaseFeedbackFragment f4112a;

        C03537(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4112a = baseFeedbackFragment;
        }

        public void run() {
            this.f4112a.aI.mo248i();
        }
    }

    /* compiled from: selected_state */
    public class C03558 implements Runnable {
        final /* synthetic */ View f4114a;
        final /* synthetic */ BaseFeedbackFragment f4115b;

        /* compiled from: selected_state */
        public class C03541 {
            final /* synthetic */ C03558 f4113a;

            C03541(C03558 c03558) {
                this.f4113a = c03558;
            }

            public final void m4717a() {
                DeferredConsumptionController deferredConsumptionController = this.f4113a.f4115b.ax;
                FeedbackParams feedbackParams = this.f4113a.f4115b.aB;
                if (deferredConsumptionController.f4417l == null) {
                    deferredConsumptionController.f4417l = deferredConsumptionController.f4413h.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C04061(deferredConsumptionController)).a();
                    deferredConsumptionController.f4417l.b();
                }
                deferredConsumptionController.f4408c.put(DeferredConsumptionController.m5017b(feedbackParams), feedbackParams);
            }
        }

        public C03558(BaseFeedbackFragment baseFeedbackFragment, View view) {
            this.f4115b = baseFeedbackFragment;
            this.f4114a = view;
        }

        public void run() {
            if (this.f4115b.aO != null && State.LOADING.equals(this.f4115b.aO.a.a)) {
                this.f4115b.at.m5226a(this.f4114a, new C03541(this));
            }
        }
    }

    /* compiled from: selected_state */
    /* synthetic */ class C03569 {
        static final /* synthetic */ int[] f4116a = new int[Direction.values().length];

        static {
            try {
                f4116a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4116a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: selected_state */
    class FragmentSetupRunnable implements Runnable {
        final /* synthetic */ BaseFeedbackFragment f4120a;

        /* compiled from: selected_state */
        class C03571 implements Runnable {
            final /* synthetic */ FragmentSetupRunnable f4117a;

            C03571(FragmentSetupRunnable fragmentSetupRunnable) {
                this.f4117a = fragmentSetupRunnable;
            }

            public void run() {
                AdapterDetour.a(this.f4117a.f4120a.aM, 1808066870);
            }
        }

        /* compiled from: selected_state */
        class C03582 implements ScrollingProxy {
            final /* synthetic */ FragmentSetupRunnable f4118a;

            C03582(FragmentSetupRunnable fragmentSetupRunnable) {
                this.f4118a = fragmentSetupRunnable;
            }

            public final int mo196a() {
                return this.f4118a.f4120a.aM.a(this.f4118a.f4120a.aL);
            }
        }

        /* compiled from: selected_state */
        class C03593 implements Function<GraphQLFeedback, Void> {
            final /* synthetic */ FragmentSetupRunnable f4119a;

            C03593(FragmentSetupRunnable fragmentSetupRunnable) {
                this.f4119a = fragmentSetupRunnable;
            }

            public Object apply(@Nullable Object obj) {
                this.f4119a.f4120a.m4743a((GraphQLFeedback) obj);
                return null;
            }
        }

        public FragmentSetupRunnable(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4120a = baseFeedbackFragment;
        }

        public void run() {
            MultiAdapterListAdapter multiAdapterListAdapter;
            this.f4120a.aD = (PopoverFragmentContainer) this.f4120a.G;
            this.f4120a.aO = this.f4120a.f4132e.m5110a(this.f4120a.aN, this.f4120a.aW);
            if (this.f4120a.ar.a(ExperimentsForFeedbackTestModule.y, false)) {
                this.f4120a.aO.a();
            } else if (!this.f4120a.aR) {
                BaseFeedbackFragment.az(this.f4120a);
            }
            BaseCommentNavigationDelegate a = this.f4120a.mo265a(this.f4120a.aD, this.f4120a.aB);
            this.f4120a.aK = this.f4120a.al.m5348a(this.f4120a.ay(), a, new C03571(this));
            this.f4120a.aL = this.f4120a.f4129b.m4801a(a, this.f4120a.aK, this.f4120a.aB.c);
            Builder builder = ImmutableList.builder();
            builder.c(this.f4120a.aw);
            builder.c(this.f4120a.aL);
            BaseFeedbackFragment baseFeedbackFragment = this.f4120a;
            if (this.f4120a.aU) {
                multiAdapterListAdapter = new MultiAdapterListAdapter(true, builder.b());
            } else {
                multiAdapterListAdapter = MultiAdapterListAdapter.a(builder.b());
            }
            baseFeedbackFragment.aM = multiAdapterListAdapter;
            this.f4120a.aG = this.f4120a.f4128a.m4974a(this.f4120a, this.f4120a.aL, this.f4120a.aK, new C03582(this), new C03593(this));
            this.f4120a.aG.m4959a(this.f4120a.aB.g);
            if (this.f4120a.aB.k != null) {
                this.f4120a.aG.m4962a(this.f4120a.aB.k);
            }
            this.f4120a.aP.add(this.f4120a.aG);
            this.f4120a.aG.m4960a(this.f4120a.aB.l);
            this.f4120a.am.d(this.f4120a.aB.g);
            this.f4120a.aS = true;
            this.f4120a.av();
        }
    }

    /* compiled from: selected_state */
    class LoadingIndicatorRunnable implements Runnable {
        final /* synthetic */ BaseFeedbackFragment f4121a;

        public LoadingIndicatorRunnable(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4121a = baseFeedbackFragment;
        }

        public void run() {
            if (this.f4121a.aF == null && BaseFeedbackFragment.m4730d(this.f4121a, this.f4121a.aE)) {
                View inflate = this.f4121a.aQ.inflate();
                BaseFeedbackFragment baseFeedbackFragment = this.f4121a;
                if (baseFeedbackFragment.ar.a(ExperimentsForFeedbackTestModule.aa, false)) {
                    baseFeedbackFragment.aX = new C03558(baseFeedbackFragment, inflate);
                    HandlerDetour.b(baseFeedbackFragment.aq, baseFeedbackFragment.aX, (long) baseFeedbackFragment.ar.a(ExperimentsForFeedbackTestModule.ac, 5000), 1842457849);
                }
                baseFeedbackFragment = this.f4121a;
                LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) FindViewUtil.b(inflate, 2131562060);
                this.f4121a.aC.f(inflate);
                this.f4121a.aO.a(loadingIndicatorView);
            }
        }
    }

    /* compiled from: selected_state */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ BaseFeedbackFragment f4122a;

        public RetryTrigger(BaseFeedbackFragment baseFeedbackFragment) {
            this.f4122a = baseFeedbackFragment;
        }

        public final void m4720a() {
            BaseFeedbackFragment.az(this.f4122a);
        }
    }

    /* compiled from: selected_state */
    class ViewCreateRunnable implements Runnable {
        final /* synthetic */ BaseFeedbackFragment f4125a;
        private final View f4126b;
        private int f4127c = 0;

        public ViewCreateRunnable(BaseFeedbackFragment baseFeedbackFragment, View view) {
            this.f4125a = baseFeedbackFragment;
            this.f4126b = view;
        }

        public void run() {
            this.f4127c++;
            if (this.f4127c <= 5) {
                if (!this.f4125a.aS) {
                    HandlerDetour.a(this.f4125a.aq, this, -1185207245);
                } else if (this.f4125a.aC != null) {
                    this.f4125a.aI = (CommentComposerView) FindViewUtil.b(this.f4126b, 2131558483);
                    BaseFeedbackFragment baseFeedbackFragment = this.f4125a;
                    BaseFeedbackFragment baseFeedbackFragment2 = this.f4125a;
                    baseFeedbackFragment.aJ = (ViewGroup) FindViewUtil.b(this.f4126b, 2131562055);
                    this.f4125a.aC.a(this.f4125a.aM);
                    baseFeedbackFragment = this.f4125a;
                    baseFeedbackFragment2 = this.f4125a;
                    baseFeedbackFragment.aQ = (ViewStub) FindViewUtil.b(this.f4126b, 2131562054);
                    if (!this.f4125a.ar.a(ExperimentsForFeedbackTestModule.g, false)) {
                        View inflate = this.f4125a.aQ.inflate();
                        baseFeedbackFragment2 = this.f4125a;
                        if (baseFeedbackFragment2.ar.a(ExperimentsForFeedbackTestModule.aa, false)) {
                            baseFeedbackFragment2.aX = new C03558(baseFeedbackFragment2, inflate);
                            HandlerDetour.b(baseFeedbackFragment2.aq, baseFeedbackFragment2.aX, (long) baseFeedbackFragment2.ar.a(ExperimentsForFeedbackTestModule.ac, 5000), 1842457849);
                        }
                        baseFeedbackFragment2 = this.f4125a;
                        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) FindViewUtil.b(inflate, 2131562060);
                        this.f4125a.aC.f(inflate);
                        this.f4125a.aO.a(loadingIndicatorView);
                    }
                    PerfTestConfig perfTestConfig = this.f4125a.an;
                    if (PerfTestConfigBase.a()) {
                        final ScrollPerfHelper scrollPerfHelper = (ScrollPerfHelper) this.f4125a.ao.get();
                        this.f4125a.aC.a(new OnScrollListener(this) {
                            final /* synthetic */ ViewCreateRunnable f4124b;

                            public final void m4721a(ScrollingViewProxy scrollingViewProxy, int i) {
                                scrollPerfHelper.a(i);
                            }

                            public final void m4722a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                            }
                        });
                    }
                    this.f4125a.aG.m4958a(this.f4126b, this.f4125a.aC);
                    this.f4125a.au.a(FunnelRegistry.D);
                    this.f4125a.aT = true;
                    this.f4125a.m4743a(this.f4125a.aE);
                    BaseFeedbackFragment.m4727a(this.f4125a, false);
                    if (this.f4125a.ar.a(ExperimentsForFeedbackTestModule.g, false) && this.f4125a.aF == null && BaseFeedbackFragment.m4730d(this.f4125a, this.f4125a.aE)) {
                        HandlerDetour.a(this.f4125a.aq, new LoadingIndicatorRunnable(this.f4125a), 12447529);
                    }
                    this.f4125a.aw();
                }
            }
        }
    }

    public static void m4729a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BaseFeedbackFragment) obj).m4728a((CommentsHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentsHelperProvider.class), CommentAdapterFactory.m4798a(injectorLike), (FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), SingletonFeedbackController.m5296a(injectorLike), (FeedbackLoadingIndicatorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackLoadingIndicatorControllerProvider.class), FlyoutUtil.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), VpvEventHelper.a(injectorLike), (FeedbackCommentNavigationDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackCommentNavigationDelegateProvider.class), (BaseCommentsEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseCommentsEnvironmentProvider.class), FeedbackAnalyticsLogger.a(injectorLike), PerfTestConfig.a(injectorLike), IdBasedLazy.a(injectorLike, 3731), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SaveUpsellUiController.m5223a(injectorLike), FunnelLoggerImpl.a(injectorLike), CommentComposerNuxHelper.m4819a(injectorLike), FeedbackHeaderAdapter.m5086a(injectorLike), DeferredConsumptionController.m5014a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike), FeedbackLoader.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected abstract FeedbackDisplayType au();

    protected abstract Context ay();

    private void m4728a(CommentsHelperProvider commentsHelperProvider, CommentAdapterFactory commentAdapterFactory, FeedbackControllerProvider feedbackControllerProvider, SingletonFeedbackController singletonFeedbackController, FeedbackLoadingIndicatorControllerProvider feedbackLoadingIndicatorControllerProvider, FlyoutUtil flyoutUtil, ObjectMapper objectMapper, VpvEventHelper vpvEventHelper, FeedbackCommentNavigationDelegateProvider feedbackCommentNavigationDelegateProvider, BaseCommentsEnvironmentProvider baseCommentsEnvironmentProvider, FeedbackAnalyticsLogger feedbackAnalyticsLogger, PerfTestConfig perfTestConfig, Lazy<ScrollPerfHelper> lazy, FbErrorReporter fbErrorReporter, Handler handler, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, SaveUpsellUiController saveUpsellUiController, FunnelLogger funnelLogger, CommentComposerNuxHelper commentComposerNuxHelper, FeedbackHeaderAdapter feedbackHeaderAdapter, DeferredConsumptionController deferredConsumptionController, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil, FeedbackLoader feedbackLoader, Executor executor) {
        this.f4128a = commentsHelperProvider;
        this.f4129b = commentAdapterFactory;
        this.f4130c = feedbackControllerProvider;
        this.f4131d = singletonFeedbackController;
        this.f4132e = feedbackLoadingIndicatorControllerProvider;
        this.f4133f = flyoutUtil;
        this.f4134g = objectMapper;
        this.f4135h = vpvEventHelper;
        this.f4136i = feedbackCommentNavigationDelegateProvider;
        this.al = baseCommentsEnvironmentProvider;
        this.am = feedbackAnalyticsLogger;
        this.an = perfTestConfig;
        this.ao = lazy;
        this.ap = fbErrorReporter;
        this.aq = handler;
        this.ar = qeAccessor;
        this.as = gatekeeperStore;
        this.at = saveUpsellUiController;
        this.au = funnelLogger;
        this.av = commentComposerNuxHelper;
        this.aw = feedbackHeaderAdapter;
        this.ax = deferredConsumptionController;
        this.ay = inlineReplyExpansionExperimentUtil;
        this.az = feedbackLoader;
        this.aA = executor;
    }

    public void mo217c(Bundle bundle) {
        boolean z;
        String i;
        Class cls = BaseFeedbackFragment.class;
        m4729a((Object) this, getContext());
        if (bundle == null) {
            bundle = this.s;
        }
        if (bundle != null) {
            this.aB = (FeedbackParams) bundle.getParcelable("feedbackParams");
            this.aB.a(au());
            this.aN = (LoadingIndicatorState) bundle.getParcelable("loadingState");
        }
        if (bundle == null || !bundle.containsKey("useRecyclerView")) {
            this.aU = this.ar.a(ExperimentsForFeedbackTestModule.n, false);
        } else {
            this.aU = bundle.getBoolean("useRecyclerView");
        }
        if (this.aE == null) {
            this.aE = this.aB.a;
            if (this.aE != null && (this.aE.z_() == null || this.aE.j() == null)) {
                z = true;
                if (this.ar.a(ExperimentsForFeedbackTestModule.y, false) && !this.aR) {
                    az(this);
                }
                if (z) {
                    if (this.aB.g == null) {
                        i = this.aB.g.i();
                    } else {
                        i = "no logging debug info";
                    }
                    this.ap.a("BaseFeedbackFragment_FeedbackNullIDs", "Feedback passed to BaseFeedbackFragment has a null id: id: " + this.aE.z_() + ", legacyapipostid: " + this.aE.j() + ", loggingparams: " + i);
                }
                this.aP = new HashSet();
                if (this.ar.a(ExperimentsForFeedbackTestModule.z, false)) {
                    new FragmentSetupRunnable(this).run();
                } else {
                    HandlerDetour.a(this.aq, new FragmentSetupRunnable(this), -2068095859);
                }
            }
        }
        z = false;
        az(this);
        if (z) {
            if (this.aB.g == null) {
                i = "no logging debug info";
            } else {
                i = this.aB.g.i();
            }
            this.ap.a("BaseFeedbackFragment_FeedbackNullIDs", "Feedback passed to BaseFeedbackFragment has a null id: id: " + this.aE.z_() + ", legacyapipostid: " + this.aE.j() + ", loggingparams: " + i);
        }
        this.aP = new HashSet();
        if (this.ar.a(ExperimentsForFeedbackTestModule.z, false)) {
            new FragmentSetupRunnable(this).run();
        } else {
            HandlerDetour.a(this.aq, new FragmentSetupRunnable(this), -2068095859);
        }
    }

    protected void av() {
    }

    public void mo211a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (this.aU) {
            BetterRecyclerView betterRecyclerView = (BetterRecyclerView) ((ViewStub) FindViewUtil.b(view, 2131562052)).inflate();
            betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
            betterRecyclerView.setWillNotDraw(false);
            this.aC = new RecyclerViewProxy(betterRecyclerView);
        } else {
            this.aC = new ListViewProxy((BetterListView) ((ViewStub) FindViewUtil.b(view, 2131562051)).inflate());
        }
        if (this.aS) {
            new ViewCreateRunnable(this, view).run();
        } else {
            HandlerDetour.a(this.aq, new ViewCreateRunnable(this, view), -1900317404);
        }
    }

    protected void aw() {
    }

    public final void m4739a(final int i, final int i2, Intent intent) {
        Intent intent2;
        super.a(i, i2, intent);
        if (intent == null) {
            intent2 = null;
        } else {
            intent2 = (Intent) intent.clone();
        }
        Runnable c03471 = new Runnable(this) {
            final /* synthetic */ BaseFeedbackFragment f4102d;
            private int f4103e = 0;

            public void run() {
                this.f4103e++;
                if (this.f4103e <= 5) {
                    if (this.f4102d.aS) {
                        this.f4102d.aG.m4957a(i, i2, intent2);
                    } else {
                        HandlerDetour.a(this.f4102d.aq, this, -714319089);
                    }
                }
            }
        };
        if (this.aS) {
            c03471.run();
        } else {
            HandlerDetour.a(this.aq, c03471, -572827672);
        }
    }

    public void mo210H() {
        ArrayNode arrayNode;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 974893292);
        super.H();
        if (this.aB.g != null) {
            arrayNode = this.aB.g.a;
        } else {
            arrayNode = null;
        }
        this.f4135h.a(arrayNode, "story_feedback_flyout");
        if (this.aG != null) {
            this.aG.m4968c();
        }
        LogUtils.f(1881356220, a);
    }

    public void mo209G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -557412584);
        super.G();
        this.f4135h.a();
        this.f4135h.b();
        if (this.aG != null) {
            this.aG.m4969d();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 534515608, a);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -823169833);
        super.mY_();
        if (this.aG != null) {
            this.aG.m4956a();
        }
        if (this.aO != null) {
            this.aO.c();
        }
        if (this.aX != null) {
            HandlerDetour.a(this.aq, this.aX);
        }
        if (this.aC != null) {
            if (!this.as.a(831, false)) {
                this.aC.a(null);
                this.aC.f(null);
            }
            this.aC.x();
            this.aC.a(null);
            this.aC = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 49056464, a);
    }

    public void mo264I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 601886427);
        super.I();
        if (this.aG != null) {
            this.aG.m4967b();
        }
        if (this.aL != null) {
            this.aL.jc_();
        }
        if (!(this.aK == null || this.as.a(831, false))) {
            this.aK.m5335a();
        }
        this.aD = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1061347122, a);
    }

    public final void m4754e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("feedbackParams", this.aB);
        if (this.aO != null) {
            bundle.putParcelable("loadingState", this.aO.a);
        }
        bundle.putBoolean("useRecyclerView", this.aU);
    }

    public final Animation m4737a(int i, boolean z, int i2) {
        Animation animation = null;
        if (!this.f4133f.a) {
            animation = new C03482(this);
            animation.setDuration(0);
        } else if (i2 != 0) {
            animation = AnimationUtils.loadAnimation(getContext(), i2);
        }
        if (animation != null) {
            animation.setAnimationListener(new C03493(this));
        }
        return animation;
    }

    public final void m4743a(GraphQLFeedback graphQLFeedback) {
        this.aE = graphQLFeedback;
        if (this.T != null) {
            Object c;
            GraphQLFeedback a = this.aG.m4955a(graphQLFeedback);
            if (a != null) {
                c = FeedProps.c(a);
            } else {
                c = null;
            }
            for (Bindable a2 : this.aP) {
                a2.mo198a(c);
            }
            this.aw.m5089a(this.aB.c != null ? (GraphQLStory) this.aB.c.a : null);
        }
    }

    public final boolean m4749b() {
        return this.aG != null && this.aG.m4966a(getContext());
    }

    public void mo218e() {
    }

    public void aq() {
        this.aV = true;
        m4727a(this, true);
        if (!this.aR && aD()) {
            this.aG.m4972g();
        }
        if ("after_animation".equals(this.ar.a(ExperimentsForFeedbackTestModule.Q, "no_upgrade")) && this.aI != null) {
            this.aI.mo251l();
        }
    }

    public final void as() {
        if (this.aI != null) {
            this.aI.mo247h();
        }
    }

    public final boolean m4745a(float f, float f2, Direction direction) {
        if (this.T == null) {
            return true;
        }
        if (this.aI == null || !this.aI.mo243a(f, f2)) {
            return false;
        }
        switch (C03569.f4116a[direction.ordinal()]) {
            case 1:
                return this.aC.l();
            case 2:
                return this.aC.n();
            default:
                return false;
        }
    }

    public final View at() {
        if (this.aI == null) {
            return null;
        }
        return this.aI.getSelfAsView();
    }

    public final void m4746b(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.aJ.addView(view);
        }
    }

    public void mo199b(final GraphQLFeedback graphQLFeedback) {
        if (CommentOrderType.getOrder(graphQLFeedback).equals(CommentOrderType.RANKED_ORDER) && this.ay.b()) {
            Futures.a(this.az.a(graphQLFeedback), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                final /* synthetic */ BaseFeedbackFragment f4107b;

                protected final void m4713a(Object obj) {
                    BaseFeedbackFragment.m4730d(this.f4107b, (GraphQLFeedback) obj);
                }

                protected final void m4714a(Throwable th) {
                    BaseFeedbackFragment.m4730d(this.f4107b, graphQLFeedback);
                }
            }, this.aA);
        } else {
            m4730d(this, graphQLFeedback);
        }
    }

    public static void m4730d(BaseFeedbackFragment baseFeedbackFragment, GraphQLFeedback graphQLFeedback) {
        if (!(graphQLFeedback == null || baseFeedbackFragment.aF == null)) {
            boolean z;
            boolean z2 = GraphQLHelper.p(graphQLFeedback) != GraphQLHelper.p(baseFeedbackFragment.aF);
            if (GraphQLHelper.f(graphQLFeedback) != GraphQLHelper.f(baseFeedbackFragment.aF)) {
                z = true;
            } else {
                z = false;
            }
            if (z2 || z) {
                FeedbackLoggingParams feedbackLoggingParams;
                FeedbackAnalyticsLogger feedbackAnalyticsLogger = baseFeedbackFragment.am;
                GraphQLFeedback graphQLFeedback2 = baseFeedbackFragment.aF;
                if (baseFeedbackFragment.aB != null) {
                    feedbackLoggingParams = baseFeedbackFragment.aB.g;
                } else {
                    feedbackLoggingParams = null;
                }
                feedbackAnalyticsLogger.a(graphQLFeedback2, feedbackLoggingParams, z, z2);
            }
        }
        m4733f(baseFeedbackFragment, graphQLFeedback);
        baseFeedbackFragment.aO.b();
        m4727a(baseFeedbackFragment, true);
        if (!(baseFeedbackFragment.aI == null || baseFeedbackFragment.aI.getPhotoButton() == null)) {
            baseFeedbackFragment.av.m4820a(graphQLFeedback, baseFeedbackFragment.aI.getPhotoButton());
            if (baseFeedbackFragment.av.m4821a()) {
                FeedbackParams.Builder builder = new FeedbackParams.Builder();
                builder = FeedbackParams.Builder.a(baseFeedbackFragment.aB);
                builder.i = false;
                baseFeedbackFragment.aB = builder.a();
            }
        }
        if (baseFeedbackFragment.aB.m != null) {
            baseFeedbackFragment.aG.m4964a(baseFeedbackFragment.aB.m);
        } else if (baseFeedbackFragment.aB.h && !CommentOrderType.isReverseOrder(baseFeedbackFragment.aE)) {
            baseFeedbackFragment.aG.m4970e();
        }
        baseFeedbackFragment.aR = true;
        if (baseFeedbackFragment.aD()) {
            baseFeedbackFragment.aG.m4973h();
        }
    }

    public void mo200c(final GraphQLFeedback graphQLFeedback) {
        if (CommentOrderType.getOrder(graphQLFeedback).equals(CommentOrderType.RANKED_ORDER) && this.ay.b()) {
            Futures.a(this.az.b(graphQLFeedback), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                final /* synthetic */ BaseFeedbackFragment f4109b;

                protected final void m4715a(Object obj) {
                    BaseFeedbackFragment.m4732e(this.f4109b, (GraphQLFeedback) obj);
                }

                protected final void m4716a(Throwable th) {
                    BaseFeedbackFragment.m4732e(this.f4109b, graphQLFeedback);
                }
            }, this.aA);
        } else {
            m4732e(this, graphQLFeedback);
        }
    }

    public static void m4732e(BaseFeedbackFragment baseFeedbackFragment, GraphQLFeedback graphQLFeedback) {
        baseFeedbackFragment.aF = graphQLFeedback;
        Runnable c03526 = new C03526(baseFeedbackFragment);
        if (baseFeedbackFragment.aS && baseFeedbackFragment.aT) {
            c03526.run();
        } else {
            HandlerDetour.a(baseFeedbackFragment.aq, c03526, 227447745);
        }
    }

    public void mo197a(ServiceException serviceException, FeedbackParams feedbackParams) {
        if (hn_()) {
            HandlerDetour.a(this.aq, this.aX);
            this.at.m5225a();
            this.aO.m5109a(serviceException, jW_(), this.aW);
            if (aD()) {
                this.aG.m4973h();
            }
        }
    }

    protected BaseCommentNavigationDelegate mo265a(PopoverFragmentContainer popoverFragmentContainer, FeedbackParams feedbackParams) {
        return this.f4136i.m5040a(popoverFragmentContainer, feedbackParams);
    }

    protected final void m4742a(Bindable<FeedProps<GraphQLFeedback>> bindable) {
        this.aP.add(bindable);
    }

    protected final void m4747b(Bindable<FeedProps<GraphQLFeedback>> bindable) {
        this.aP.remove(bindable);
    }

    public static void az(BaseFeedbackFragment baseFeedbackFragment) {
        if (baseFeedbackFragment.aO != null) {
            baseFeedbackFragment.aO.a();
        }
        if (baseFeedbackFragment.ar.a(ExperimentsForFeedbackTestModule.y, false)) {
            baseFeedbackFragment.f4131d.m5303a(baseFeedbackFragment.aB, aH, baseFeedbackFragment, baseFeedbackFragment.ax);
            return;
        }
        FeedbackControllerProvider feedbackControllerProvider = baseFeedbackFragment.f4130c;
        FeedbackControllerParams.Builder builder = new FeedbackControllerParams.Builder();
        builder.f4496a = baseFeedbackFragment.aB.q;
        feedbackControllerProvider.m5074a(builder.m5071a()).m5069a(baseFeedbackFragment.aB, (OnFeedbackLoadListener) baseFeedbackFragment, aH);
    }

    public static void m4733f(BaseFeedbackFragment baseFeedbackFragment, GraphQLFeedback graphQLFeedback) {
        HandlerDetour.a(baseFeedbackFragment.aq, baseFeedbackFragment.aX);
        baseFeedbackFragment.at.m5225a();
        baseFeedbackFragment.m4743a(graphQLFeedback);
        double log10 = Math.log10((double) GraphQLHelper.g(graphQLFeedback)) / Math.log10(2.0d);
        long round = Math.round(log10);
        if (((double) round) < log10) {
            round++;
        }
        baseFeedbackFragment.au.a(FunnelRegistry.D, "comments_shown_" + round);
    }

    public static void m4727a(BaseFeedbackFragment baseFeedbackFragment, boolean z) {
        if (baseFeedbackFragment.aB.i) {
            Object obj;
            if (baseFeedbackFragment.aO == null || baseFeedbackFragment.aO.a.a != State.LOAD_FINISHED) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null && baseFeedbackFragment.aI != null) {
                if (baseFeedbackFragment.ar.a(ExperimentsForFeedbackTestModule.S, false)) {
                    if (baseFeedbackFragment.aV) {
                        HandlerDetour.a(baseFeedbackFragment.aq, new C03537(baseFeedbackFragment), 464158473);
                        baseFeedbackFragment.aB();
                    }
                } else if (z) {
                    baseFeedbackFragment.aI.mo248i();
                    baseFeedbackFragment.aB();
                }
            }
        }
    }

    private void aB() {
        this.aI.mo252m();
        FeedbackParams.Builder a = FeedbackParams.Builder.a(this.aB);
        a.i = false;
        this.aB = a.a();
    }

    public Map<String, String> getDebugInfo() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Feedback Params", this.aB.u());
        hashMap.put("Has Fetched Feedback: ", this.aR ? "True" : "False");
        if (this.aE != null) {
            try {
                hashMap.put("Feedback Object", this.f4134g.g().a().a(this.aE));
            } catch (IOException e) {
            }
        }
        return hashMap;
    }

    public final Map<String, Object> m4750c() {
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

    private boolean aD() {
        if (this.aF == null || GraphQLHelper.f(this.aF) <= 0 || this.aB.o == CommentOrderType.RANKED_ORDER || !this.ar.a(ExperimentsForFeedbackTestModule.G, false)) {
            return false;
        }
        return true;
    }

    static /* synthetic */ boolean m4731d(BaseFeedbackFragment baseFeedbackFragment, GraphQLFeedback graphQLFeedback) {
        boolean z = graphQLFeedback != null && GraphQLHelper.g(graphQLFeedback) == 0 && GraphQLHelper.f(graphQLFeedback) > 0;
        return z;
    }
}
