package com.facebook.richdocument;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateRecyclerViewScrollListener;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.tinyclicks.MasterTouchDelegateController;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateFrameLayout;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateLayout;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.richdocument.BaseRichDocumentActivity.C06721;
import com.facebook.richdocument.RichDocumentFragment.C06811;
import com.facebook.richdocument.event.MediaTiltCoordinator;
import com.facebook.richdocument.event.NativeAdsRecyclerViewFocusCoordinator;
import com.facebook.richdocument.event.RecyclerViewFocusCoordinator;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFirstRenderSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentOutgoingAnimationCompleteSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksErrorEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksFetchStartedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent.FragmentLifeCycleEvent;
import com.facebook.richdocument.event.RichDocumentSessionEvent;
import com.facebook.richdocument.event.RichDocumentSessionEvent.Action;
import com.facebook.richdocument.event.RichDocumentSessionEventBus;
import com.facebook.richdocument.event.StartupStateMachine;
import com.facebook.richdocument.fetcher.BaseRichDocumentFetcher;
import com.facebook.richdocument.fetcher.Retryable;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import com.facebook.richdocument.fetcher.RichDocumentFetcher;
import com.facebook.richdocument.fonts.RichDocumentFontManager;
import com.facebook.richdocument.fonts.RichDocumentFonts;
import com.facebook.richdocument.fonts.RichDocumentStyleFontHelper;
import com.facebook.richdocument.genesis.BlockViewHolderFactoryProvider;
import com.facebook.richdocument.logging.ImagePerfLogger;
import com.facebook.richdocument.logging.NativeAdsPerfInfoLogger;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.logging.RichDocumentLongClickTracker;
import com.facebook.richdocument.logging.RichDocumentPerfInfoLogger;
import com.facebook.richdocument.logging.RichDocumentScrollDepthLogger;
import com.facebook.richdocument.logging.RichDocumentSessionTracker;
import com.facebook.richdocument.logging.SimpleFrameRateUtil;
import com.facebook.richdocument.logging.SimpleFrameRateUtil.LogMode;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger.WebViewPerfEventInfo;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocks;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.VideoBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel.FallbackArticleStyleModel;
import com.facebook.richdocument.presenter.WebViewBlockPresenter;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.performance.IncrementalUiIdleJobManager;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager;
import com.facebook.richdocument.view.touch.RichDocumentTouchTargetFinder;
import com.facebook.richdocument.view.transition.motion.GyroBasedMediaTiltSensor;
import com.facebook.richdocument.view.transition.motion.RichDocumentOrientationSensor;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory.RecyclableViewFactory;
import com.facebook.richdocument.view.util.RecyclableViewUtil;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.facebook.richdocument.view.widget.ExpandedMediaHolder;
import com.facebook.richdocument.view.widget.RichDocumentActivityTransitioner;
import com.facebook.richdocument.view.widget.RichDocumentRecyclerView;
import com.facebook.richdocument.view.widget.RotatableCandidateSelector;
import com.facebook.richdocument.view.widget.VideoCandidateSelector;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.dialogs.FbDialog;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: product_seller_profile_photo_size */
public abstract class RichDocumentDelegateImpl<REQUEST, RESULT> implements AnalyticsFragmentWithExtraData, InjectableComponentWithContext, RichDocumentDelegate {
    public RichDocumentActivityTransitioner f5064A;
    private C06811 f5065B;
    private C06721 f5066C;
    private LayoutManager f5067D;
    private SimpleFrameRateUtil f5068E;
    public RichDocumentBlocksImpl f5069F;
    private Handler f5070G;
    private Thread f5071H;
    public boolean f5072I = false;
    private int f5073J;
    private boolean f5074K = false;
    private GyroBasedMediaTiltSensor f5075L;
    private RichDocumentOrientationSensor f5076M;
    private RotatableCandidateSelector f5077N;
    private VideoCandidateSelector f5078O;
    private FrameRateRecyclerViewScrollListener f5079P;
    private final FbEventSubscriberListManager f5080Q = new FbEventSubscriberListManager();
    private final RichDocumentStartupUiTasksCompletedSubscriber f5081R = new C06731(this);
    private final RichDocumentFirstRenderSubscriber f5082S = new C06742(this);
    private final RichDocumentOutgoingAnimationCompleteSubscriber f5083T = new C06753(this);
    @Inject
    public Lazy<RichDocumentEventBus> f5084a;
    @Inject
    Lazy<RichDocumentScrollDepthLogger> f5085b;
    @Inject
    Lazy<RichDocumentFontManager> f5086c;
    @Inject
    Lazy<RichDocumentFonts> f5087d;
    @Inject
    Lazy<FbErrorReporter> f5088e;
    @Inject
    Lazy<MasterTouchDelegateController> f5089f;
    @Inject
    Lazy<FbSharedPreferences> f5090g;
    @Inject
    Lazy<CompositeRecyclableViewFactory> f5091h;
    @Inject
    Lazy<GatekeeperStore> f5092i;
    @Inject
    Lazy<SequenceLogger> f5093j;
    @Inject
    StartupStateMachine f5094k;
    @Inject
    Lazy<RichDocumentSessionTracker> f5095l;
    @Inject
    Lazy<RichDocumentLongClickTracker> f5096m;
    @Inject
    RichDocumentPerfInfoLogger f5097n;
    @Inject
    Lazy<ExpandedMediaHolder> f5098o;
    @Inject
    Lazy<WebViewPerfInfoLogger> f5099p;
    @Inject
    Lazy<NativeAdsPerfInfoLogger> f5100q;
    @Inject
    Lazy<RichDocumentAnalyticsLogger> f5101r;
    @Inject
    Lazy<ImagePerfLogger> f5102s;
    @Inject
    Lazy<IncrementalUiIdleJobManager> f5103t;
    @Inject
    Lazy<RichDocumentSessionEventBus> f5104u;
    @Inject
    BlockViewHolderFactoryProvider f5105v;
    private Context f5106w;
    public View f5107x;
    public Bundle f5108y;
    public BetterRecyclerView f5109z;

    /* compiled from: product_seller_profile_photo_size */
    class C06731 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ RichDocumentDelegateImpl f5051a;

        C06731(RichDocumentDelegateImpl richDocumentDelegateImpl) {
            this.f5051a = richDocumentDelegateImpl;
        }

        public final void m5043b(FbEvent fbEvent) {
            Sequence e = ((SequenceLogger) this.f5051a.f5093j.get()).e(this.f5051a.m5058C());
            if (e != null) {
                SequenceLoggerDetour.e(e, "rich_document_startup_tasks_complete", -868950102);
            }
            RichDocumentPerfInfoLogger richDocumentPerfInfoLogger = this.f5051a.f5097n;
            Map hashMap = new HashMap();
            hashMap.put("data_freshness", richDocumentPerfInfoLogger.f5543o != null ? richDocumentPerfInfoLogger.f5543o.name() : DataFreshnessResult.NO_DATA.name());
            hashMap.put("connection_quality_at_start", richDocumentPerfInfoLogger.f5547s != null ? richDocumentPerfInfoLogger.f5547s.name() : ConnectionQuality.UNKNOWN.name());
            hashMap.put("fetched_from_memory_cache", Boolean.toString(richDocumentPerfInfoLogger.f5548t));
            hashMap.put("first_open_since_start", Boolean.toString(richDocumentPerfInfoLogger.f5549u));
            ((SequenceLogger) this.f5051a.f5093j.get()).b(this.f5051a.m5058C(), ImmutableMap.copyOf(hashMap));
            this.f5051a.m5085k();
        }
    }

    /* compiled from: product_seller_profile_photo_size */
    class C06742 extends RichDocumentFirstRenderSubscriber {
        final /* synthetic */ RichDocumentDelegateImpl f5052a;

        C06742(RichDocumentDelegateImpl richDocumentDelegateImpl) {
            this.f5052a = richDocumentDelegateImpl;
        }

        public final void m5045b(FbEvent fbEvent) {
            ((RichDocumentAnalyticsLogger) this.f5052a.f5101r.get()).m5370c("native_article_open");
            Sequence e = ((SequenceLogger) this.f5052a.f5093j.get()).e(this.f5052a.m5058C());
            if (e != null) {
                SequenceLoggerDetour.e(e, "rich_document_first_render", -731176073);
            }
            ((RichDocumentEventBus) this.f5052a.f5084a.get()).b(this);
        }
    }

    /* compiled from: product_seller_profile_photo_size */
    class C06753 extends RichDocumentOutgoingAnimationCompleteSubscriber {
        final /* synthetic */ RichDocumentDelegateImpl f5053a;

        C06753(RichDocumentDelegateImpl richDocumentDelegateImpl) {
            this.f5053a = richDocumentDelegateImpl;
        }

        public final void m5047b(FbEvent fbEvent) {
            this.f5053a.m5087n();
        }
    }

    /* compiled from: product_seller_profile_photo_size */
    class C06805 implements Runnable {
        final /* synthetic */ RichDocumentDelegateImpl f5062a;

        C06805(RichDocumentDelegateImpl richDocumentDelegateImpl) {
            this.f5062a = richDocumentDelegateImpl;
        }

        public void run() {
            this.f5062a.m5087n();
            try {
                Activity A = this.f5062a.m5057A();
                if (A != null && (A instanceof BaseRichDocumentActivity) && !A.isFinishing()) {
                    A.finish();
                    A.overridePendingTransition(0, 0);
                }
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: product_seller_profile_photo_size */
    public class RichDocumentDialog extends FbDialog {
        final /* synthetic */ RichDocumentDelegateImpl f5063a;

        public RichDocumentDialog(RichDocumentDelegateImpl richDocumentDelegateImpl) {
            this.f5063a = richDocumentDelegateImpl;
            super(richDocumentDelegateImpl.getContext(), 16973841);
        }

        public RichDocumentDialog(RichDocumentDelegateImpl richDocumentDelegateImpl, int i) {
            this.f5063a = richDocumentDelegateImpl;
            super(richDocumentDelegateImpl.getContext(), i);
        }

        public void onBackPressed() {
            this.f5063a.mo253a();
        }
    }

    public static void m5056a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RichDocumentDelegateImpl) obj).m5055a(IdBasedLazy.a(injectorLike, 10298), IdBasedLazy.a(injectorLike, 10340), IdBasedLazy.a(injectorLike, 10307), IdBasedLazy.a(injectorLike, 10308), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 5807), IdBasedSingletonScopeProvider.b(injectorLike, 3078), IdBasedLazy.a(injectorLike, 10358), IdBasedSingletonScopeProvider.b(injectorLike, 2128), IdBasedSingletonScopeProvider.b(injectorLike, 3422), StartupStateMachine.m5147a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10341), IdBasedLazy.a(injectorLike, 10338), RichDocumentPerfInfoLogger.m5390a(injectorLike), IdBasedLazy.a(injectorLike, 10361), IdBasedLazy.a(injectorLike, 10343), IdBasedLazy.a(injectorLike, 10333), IdBasedLazy.a(injectorLike, 10334), IdBasedLazy.a(injectorLike, 10332), IdBasedLazy.a(injectorLike, 10352), IdBasedSingletonScopeProvider.b(injectorLike, 10299), (BlockViewHolderFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BlockViewHolderFactoryProvider.class));
    }

    public abstract AbstractSequenceDefinition m5058C();

    public abstract LinearLayoutManager m5059a(BetterRecyclerView betterRecyclerView);

    protected abstract View m5061a(View view);

    protected abstract RichDocumentBlocks m5062a(RESULT result);

    protected abstract void m5071a(Throwable th);

    protected abstract int m5088q();

    protected abstract RichDocumentFetcher<REQUEST, RESULT> m5090u();

    protected abstract RichDocumentFetchParams<REQUEST> m5091v();

    private void m5055a(Lazy<RichDocumentEventBus> lazy, Lazy<RichDocumentScrollDepthLogger> lazy2, Lazy<RichDocumentFontManager> lazy3, Lazy<RichDocumentFonts> lazy4, Lazy<FbErrorReporter> lazy5, Lazy<MasterTouchDelegateController> lazy6, Lazy<FbSharedPreferences> lazy7, Lazy<CompositeRecyclableViewFactory> lazy8, Lazy<GatekeeperStore> lazy9, Lazy<SequenceLogger> lazy10, StartupStateMachine startupStateMachine, Lazy<RichDocumentSessionTracker> lazy11, Lazy<RichDocumentLongClickTracker> lazy12, RichDocumentPerfInfoLogger richDocumentPerfInfoLogger, Lazy<ExpandedMediaHolder> lazy13, Lazy<WebViewPerfInfoLogger> lazy14, Lazy<NativeAdsPerfInfoLogger> lazy15, Lazy<RichDocumentAnalyticsLogger> lazy16, Lazy<ImagePerfLogger> lazy17, Lazy<IncrementalUiIdleJobManager> lazy18, Lazy<RichDocumentSessionEventBus> lazy19, BlockViewHolderFactoryProvider blockViewHolderFactoryProvider) {
        this.f5084a = lazy;
        this.f5085b = lazy2;
        this.f5086c = lazy3;
        this.f5087d = lazy4;
        this.f5088e = lazy5;
        this.f5089f = lazy6;
        this.f5090g = lazy7;
        this.f5091h = lazy8;
        this.f5092i = lazy9;
        this.f5093j = lazy10;
        this.f5094k = startupStateMachine;
        this.f5095l = lazy11;
        this.f5096m = lazy12;
        this.f5097n = richDocumentPerfInfoLogger;
        this.f5098o = lazy13;
        this.f5099p = lazy14;
        this.f5100q = lazy15;
        this.f5101r = lazy16;
        this.f5102s = lazy17;
        this.f5103t = lazy18;
        this.f5104u = lazy19;
        this.f5105v = blockViewHolderFactoryProvider;
    }

    public final void mo248a(Context context) {
        this.f5106w = context;
    }

    public final Context getContext() {
        return this.f5106w;
    }

    public void mo249a(Bundle bundle) {
    }

    public Dialog mo262j() {
        return new RichDocumentDialog(this);
    }

    public final void mo259g() {
        Activity A = m5057A();
        if (A != null && !(A instanceof BaseRichDocumentActivity)) {
            this.f5073J = A.getRequestedOrientation();
            this.f5074K = true;
            A.setRequestedOrientation(1);
        }
    }

    public final View mo247a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f5107x = m5073b(layoutInflater, viewGroup, bundle);
        return this.f5107x;
    }

    public View m5073b(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Class cls = RichDocumentDelegateImpl.class;
        m5056a((Object) this, getContext());
        Sequence e = ((SequenceLogger) this.f5093j.get()).e(m5058C());
        if (e != null) {
            SequenceLoggerDetour.a(e, "rich_document_fragment_starts", -12012673);
        }
        StartupStateMachine startupStateMachine = this.f5094k;
        startupStateMachine.f5192a.a(startupStateMachine.f5193b);
        startupStateMachine.f5192a.a(startupStateMachine.f5194c);
        ((RichDocumentSessionTracker) this.f5095l.get()).m5406a(getContext());
        ((RichDocumentSessionEventBus) this.f5104u.get()).a(new RichDocumentSessionEvent(Action.OPEN_DOCUMENT));
        this.f5071H = Thread.currentThread();
        this.f5070G = new Handler();
        LayoutInflater from = LayoutInflater.from(getContext());
        if (e != null) {
            SequenceLoggerDetour.a(e, "rich_document_layout_inflation", 344110172);
        }
        View inflate = from.inflate(m5088q(), viewGroup, false);
        if (e != null) {
            SequenceLoggerDetour.b(e, "rich_document_layout_inflation", 224885001);
        }
        MasterTouchDelegateFrameLayout masterTouchDelegateFrameLayout = (MasterTouchDelegateFrameLayout) inflate.findViewById(2131562983);
        if (masterTouchDelegateFrameLayout != null) {
            masterTouchDelegateFrameLayout.a.g = new RichDocumentTouchTargetFinder(getContext());
        }
        if (e != null) {
            SequenceLoggerDetour.a(e, "rich_document_view_initialization", -1511307724);
        }
        this.f5109z = (BetterRecyclerView) inflate.findViewById(2131559427);
        if (this.f5109z instanceof RichDocumentRecyclerView) {
            ((RichDocumentRecyclerView) this.f5109z).f7342u = m5058C();
        }
        this.f5064A = (RichDocumentActivityTransitioner) inflate.findViewById(2131562981);
        this.f5064A.m7538a(m5061a(inflate), this.f5109z);
        ((RichDocumentEventBus) this.f5084a.get()).a(this.f5083T);
        ((RichDocumentScrollDepthLogger) this.f5085b.get()).f5557b = this.f5109z;
        this.f5067D = m5059a(this.f5109z);
        this.f5109z.setLayoutManager(this.f5067D);
        ItemDecoration r = m5089r();
        if (r != null) {
            this.f5109z.a(r);
        }
        if (e != null) {
            SequenceLoggerDetour.b(e, "rich_document_view_initialization", -1646604304);
        }
        this.f5080Q.a(new RecyclerViewFocusCoordinator(this.f5109z));
        this.f5080Q.a(new NativeAdsRecyclerViewFocusCoordinator(this.f5109z));
        this.f5075L = new GyroBasedMediaTiltSensor(getContext());
        this.f5080Q.a(new MediaTiltCoordinator(this.f5075L));
        this.f5076M = new RichDocumentOrientationSensor(getContext());
        this.f5077N = new RotatableCandidateSelector(this.f5109z, this.f5076M);
        this.f5078O = new VideoCandidateSelector(this.f5109z);
        this.f5080Q.a((FbEventBus) this.f5084a.get());
        ((RichDocumentEventBus) this.f5084a.get()).a(new RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent.ON_CREATE));
        ((RichDocumentEventBus) this.f5084a.get()).a(this.f5081R);
        ((RichDocumentEventBus) this.f5084a.get()).a(this.f5082S);
        RichDocumentPerfInfoLogger richDocumentPerfInfoLogger = this.f5097n;
        richDocumentPerfInfoLogger.f5546r = richDocumentPerfInfoLogger.f5530b.now();
        if (e != null) {
            SequenceLoggerDetour.b(e, "rich_document_fragment_starts", 1561996213);
        }
        return inflate;
    }

    public void mo250a(View view, @Nullable Bundle bundle) {
        RichDocumentPerfInfoLogger richDocumentPerfInfoLogger = this.f5097n;
        Bundle bundle2 = this.f5108y;
        richDocumentPerfInfoLogger.f5538j = bundle2.getLong("external_click_time", 0);
        richDocumentPerfInfoLogger.f5540l = bundle2.getString("extra_instant_articles_id");
        richDocumentPerfInfoLogger.f5551x = bundle2.getString("extra_instant_articles_referrer");
        m5094y();
        m5053D(this);
    }

    protected final void m5070a(Runnable runnable) {
        if (Thread.currentThread() == this.f5071H) {
            runnable.run();
        } else {
            HandlerDetour.a(this.f5070G, runnable, -726406256);
        }
    }

    public static void m5053D(RichDocumentDelegateImpl richDocumentDelegateImpl) {
        richDocumentDelegateImpl.m5092w();
        BaseRichDocumentFetcher u = richDocumentDelegateImpl.m5090u();
        RichDocumentFetchParams v = richDocumentDelegateImpl.m5091v();
        ((RichDocumentEventBus) richDocumentDelegateImpl.f5084a.get()).a(new RichDocumentBlocksFetchStartedEvent());
        final Sequence e = ((SequenceLogger) richDocumentDelegateImpl.f5093j.get()).e(richDocumentDelegateImpl.m5058C());
        if (e != null) {
            SequenceLoggerDetour.a(e, "rich_document_fetch", 1183909599);
        }
        u.a(v, new ResultFutureCallback<RESULT>(richDocumentDelegateImpl) {
            final /* synthetic */ RichDocumentDelegateImpl f5061b;

            protected final void m5051a(final ServiceException serviceException) {
                if (e != null) {
                    SequenceLoggerDetour.b(e, "rich_document_fetch", -2143529721);
                }
                this.f5061b.m5070a(new Runnable(this) {
                    final /* synthetic */ C06794 f5057b;

                    /* compiled from: product_seller_profile_photo_size */
                    class C06761 extends Retryable {
                        final /* synthetic */ C06771 f5055a;

                        C06761(C06771 c06771) {
                            this.f5055a = c06771;
                        }

                        protected final void mo246b() {
                            RichDocumentDelegateImpl.m5053D(this.f5055a.f5057b.f5061b);
                        }
                    }

                    public void run() {
                        ((RichDocumentEventBus) this.f5057b.f5061b.f5084a.get()).a(new RichDocumentBlocksErrorEvent(null, serviceException, new C06761(this)));
                        this.f5057b.f5061b.m5071a(serviceException);
                    }
                });
            }

            protected final void m5052a(final RESULT result) {
                if (e != null) {
                    SequenceLoggerDetour.b(e, "rich_document_fetch", -1197558105);
                }
                if (!this.f5061b.f5072I) {
                    this.f5061b.m5070a(new Runnable(this) {
                        final /* synthetic */ C06794 f5059b;

                        public void run() {
                            if (e != null) {
                                SequenceLoggerDetour.a(e, "rich_document_parse", -237910655);
                            }
                            this.f5059b.f5061b.f5069F = this.f5059b.f5061b.m5062a(result);
                            if (this.f5059b.f5061b.f5069F == null) {
                                this.f5059b.f5061b.m5087n();
                                return;
                            }
                            RichDocumentDelegateImpl richDocumentDelegateImpl = this.f5059b.f5061b;
                            RichDocumentBlocksImpl richDocumentBlocksImpl = this.f5059b.f5061b.f5069F;
                            richDocumentDelegateImpl.f5109z.setAdapter(richDocumentDelegateImpl.m5076c(richDocumentBlocksImpl));
                            richDocumentDelegateImpl.m5075b(richDocumentBlocksImpl);
                            this.f5059b.f5061b.m5093x();
                            if (e != null) {
                                SequenceLoggerDetour.b(e, "rich_document_parse", -1117054692);
                            }
                        }
                    });
                }
            }
        });
    }

    public final void mo260h() {
        ((RichDocumentEventBus) this.f5084a.get()).a(new RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent.ON_DESTROY));
        this.f5080Q.b((FbEventBus) this.f5084a.get());
        this.f5075L.m7337a();
        this.f5077N.m7636b();
        this.f5076M.m7342a();
        if (this.f5078O != null) {
            this.f5078O.m7763b();
        }
        if (this.f5068E != null) {
            this.f5068E.m5410a();
        }
    }

    protected void m5085k() {
        boolean z = true;
        boolean z2;
        if (this.f5109z == null) {
            AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) this.f5088e.get();
            if (abstractFbErrorReporter != null) {
                String str = "instant_articles";
                String str2 = "RecyclerView null. isDetached = %s, isFocused = %s, isHidden = %s";
                Object[] objArr = new Object[3];
                if (this.f5107x.isAttachedToWindow()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                objArr[0] = Boolean.toString(z2);
                objArr[1] = Boolean.toString(this.f5107x.isFocused());
                if (this.f5107x.getVisibility() != 8) {
                    z = false;
                }
                objArr[2] = Boolean.toString(z);
                abstractFbErrorReporter.a(str, StringFormatUtil.a(str2, objArr));
                return;
            }
            return;
        }
        TracerDetour.a("RichDocumentDelegateImpl.onStartupUITasksComplete", 268400416);
        MasterTouchDelegateController masterTouchDelegateController = (MasterTouchDelegateController) this.f5089f.get();
        masterTouchDelegateController.d = false;
        if (masterTouchDelegateController.a != null) {
            boolean z3;
            MasterTouchDelegateFrameLayout masterTouchDelegateFrameLayout = masterTouchDelegateController.a;
            if (null == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            masterTouchDelegateFrameLayout.setWillNotDraw(z3);
        }
        for (MasterTouchDelegateLayout masterTouchDelegateLayout : masterTouchDelegateController.b) {
            boolean z4;
            if (null == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            masterTouchDelegateLayout.setWillNotDraw(z4);
        }
        TracerDetour.a(295395247);
        z2 = ((FbSharedPreferences) this.f5090g.get()).a(RichDocumentConstants.f5045i, false);
        boolean a = ((FbSharedPreferences) this.f5090g.get()).a(RichDocumentConstants.f5046j, true);
        if (z2) {
            this.f5068E = new SimpleFrameRateUtil(getContext(), a ? LogMode.ONLY_DROPS : LogMode.ALL_FRAME_INTERVALS);
            this.f5109z.a(this.f5068E);
        }
        m5054E();
    }

    protected final void m5068a(RichDocumentStyleModel richDocumentStyleModel) {
        Map map;
        Object obj;
        Map a;
        RichDocumentFonts richDocumentFonts = (RichDocumentFonts) this.f5087d.get();
        RichDocumentFontManager richDocumentFontManager = (RichDocumentFontManager) this.f5086c.get();
        Set<String> a2 = new RichDocumentStyleFontHelper(richDocumentStyleModel).m5219a();
        if (richDocumentStyleModel == null || CollectionUtil.a(richDocumentStyleModel.m6358o())) {
            map = null;
        } else {
            map = richDocumentFontManager.m5211a(richDocumentStyleModel.m6358o(), a2, false);
        }
        Map map2 = map;
        for (String str : a2) {
            if ((map2 == null || !map2.containsKey(str)) && RichDocumentFontManager.m5202a(str) == null) {
                obj = null;
                break;
            }
        }
        obj = 1;
        if (obj != null) {
            a = RichDocumentFontManager.m5207a((Set) a2, map2);
        } else {
            a = new HashMap();
        }
        richDocumentFonts.f5279a = a;
        richDocumentFonts = (RichDocumentFonts) this.f5087d.get();
        richDocumentFontManager = (RichDocumentFontManager) this.f5086c.get();
        RichDocumentStyleFontHelper richDocumentStyleFontHelper = new RichDocumentStyleFontHelper(richDocumentStyleModel);
        Set hashSet = new HashSet();
        if (!(richDocumentStyleFontHelper.f5282a == null || richDocumentStyleFontHelper.f5282a.m6360q() == null)) {
            FallbackArticleStyleModel q = richDocumentStyleFontHelper.f5282a.m6360q();
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6311p());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6317v());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6316u());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6301b());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6300a());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6309n());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6310o());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6314s());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6313r());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6315t());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6307l());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6306k());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6305j());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.ir_());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.is_());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6304g());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.it_());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6303d());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6302c());
            RichDocumentStyleFontHelper.m5217a(hashSet, q.m6308m());
            RichDocumentStyleFontHelper.m5218a(hashSet, q.m6312q());
        }
        richDocumentFonts.f5280b = RichDocumentFontManager.m5207a(hashSet, null);
    }

    public void mo257e() {
        ((RichDocumentEventBus) this.f5084a.get()).a(new RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent.ON_RESUME));
        Sequence e = ((SequenceLogger) this.f5093j.get()).e(m5058C());
        if (e != null) {
            SequenceLoggerDetour.e(e, "rich_document_fragment_resume", -290237841);
        }
        if (this.f5096m != null) {
            RichDocumentLongClickTracker richDocumentLongClickTracker = (RichDocumentLongClickTracker) this.f5096m.get();
            richDocumentLongClickTracker.f5514i = richDocumentLongClickTracker.f5507b.now();
        }
        if (this.f5069F != null) {
            RichDocumentBlocksImpl richDocumentBlocksImpl = this.f5069F;
            int c = richDocumentBlocksImpl.m5459c();
            for (int i = 0; i < c; i++) {
                BlockData a = richDocumentBlocksImpl.m5457a(i);
                if (a instanceof VideoBlockDataImpl) {
                    VideoBlockDataImpl videoBlockDataImpl = (VideoBlockDataImpl) a;
                    if (videoBlockDataImpl.f5787l != null) {
                        videoBlockDataImpl.f5787l.a(true);
                    }
                }
            }
        }
    }

    public void mo258f() {
        ((RichDocumentEventBus) this.f5084a.get()).a(new RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent.ON_PAUSE));
        if (this.f5067D instanceof RichDocumentLayoutManager) {
            ((RichDocumentLayoutManager) this.f5067D).m7184c();
        }
        if (this.f5096m != null) {
            ((RichDocumentLongClickTracker) this.f5096m.get()).m5384b();
        }
        if (this.f5069F != null) {
            RichDocumentBlocksImpl richDocumentBlocksImpl = this.f5069F;
            int c = richDocumentBlocksImpl.m5459c();
            for (int i = 0; i < c; i++) {
                BlockData a = richDocumentBlocksImpl.m5457a(i);
                if (a instanceof VideoBlockDataImpl) {
                    VideoBlockDataImpl videoBlockDataImpl = (VideoBlockDataImpl) a;
                    if (videoBlockDataImpl.f5787l != null) {
                        videoBlockDataImpl.f5787l.a(false);
                    }
                }
            }
        }
    }

    public void mo254b(Bundle bundle) {
        ((RichDocumentEventBus) this.f5084a.get()).a(new RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent.ON_SAVE_INSTANCE_STATE));
    }

    public final void mo261i() {
        ((RichDocumentEventBus) this.f5084a.get()).a(new RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent.ON_LOW_MEMORY));
    }

    public void m5086l() {
        if (this.f5109z != null && this.f5109z.o != null) {
            Adapter adapter = this.f5109z.o;
            int childCount = this.f5109z.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder a = this.f5109z.a(this.f5109z.getChildAt(i));
                if (a != null) {
                    adapter.d(a);
                }
                if ((a instanceof BlockViewHolder) && (((BlockViewHolder) a).m7383w() instanceof WebViewBlockPresenter)) {
                    ((WebViewBlockPresenter) ((BlockViewHolder) a).m7383w()).m6843e();
                }
            }
            if (this.f5079P != null) {
                this.f5109z.b(this.f5079P);
            }
        }
    }

    public final void m5069a(BetterRecyclerView betterRecyclerView, FrameRateLogger frameRateLogger) {
        this.f5079P = new FrameRateRecyclerViewScrollListener(frameRateLogger);
        betterRecyclerView.a(this.f5079P);
    }

    private void m5054E() {
        if (((GatekeeperStoreImpl) this.f5092i.get()).a(704, false)) {
            TracerDetour.a("RichDocumentDelegateImpl.maybePreinflateUfiAndTextAnnotations", 1355415251);
            Map a = new RecyclableViewUtil((RichDocumentAdapter) this.f5109z.o).m7363a(ImmutableSet.of(Integer.valueOf(2130906862), Integer.valueOf(2130906884)));
            CompositeRecyclableViewFactory compositeRecyclableViewFactory = (CompositeRecyclableViewFactory) this.f5091h.get();
            Object obj = null;
            for (Integer num : a.keySet()) {
                Object obj2;
                int a2 = ((RecyclableViewFactory) compositeRecyclableViewFactory.f7049b.get(num)).m7354a(((Integer) a.get(num)).intValue());
                if (obj != null || a2 > 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = obj2;
            }
            TracerDetour.a(2126306529);
        }
    }

    public void m5087n() {
        if (!this.f5072I) {
            this.f5072I = true;
            ((RichDocumentAnalyticsLogger) this.f5101r.get()).m5370c("native_article_close");
            m5086l();
            IncrementalUiIdleJobManager incrementalUiIdleJobManager = (IncrementalUiIdleJobManager) this.f5103t.get();
            if (incrementalUiIdleJobManager.f6914g != null) {
                incrementalUiIdleJobManager.f6914g.a();
            }
            incrementalUiIdleJobManager.f6908a.clear();
            incrementalUiIdleJobManager.f6914g = null;
            WebViewPerfInfoLogger webViewPerfInfoLogger = (WebViewPerfInfoLogger) this.f5099p.get();
            for (Entry value : webViewPerfInfoLogger.f5599a.entrySet()) {
                WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) value.getValue();
                if (webViewPerfEventInfo.m5418b() && ((float) webViewPerfEventInfo.f5588h) > 0.0f && ((float) webViewPerfEventInfo.f5589i) <= 0.0f) {
                    webViewPerfEventInfo.f5589i = webViewPerfInfoLogger.f5601c.now();
                }
            }
            ((WebViewPerfInfoLogger) this.f5099p.get()).m5426b();
            ((NativeAdsPerfInfoLogger) this.f5100q.get()).m5358a();
            this.f5097n.m5393a();
            ((RichDocumentLongClickTracker) this.f5096m.get()).m5385c();
            ((ImagePerfLogger) this.f5102s.get()).m5349a();
            ((RichDocumentSessionTracker) this.f5095l.get()).m5408b(getContext());
            ((RichDocumentSessionEventBus) this.f5104u.get()).a(new RichDocumentSessionEvent(Action.CLOSE_DOCUMENT));
            Activity A = m5057A();
            if (A != null && this.f5074K) {
                A.setRequestedOrientation(this.f5073J);
            }
            if (this.f5065B != null) {
                C06811 c06811 = this.f5065B;
                if (c06811.f5110a.ap() && !c06811.f5110a.x) {
                    c06811.f5110a.b();
                }
            }
            if (this.f5066C != null) {
                C06721 c06721 = this.f5066C;
                if (!c06721.f5035a.isFinishing()) {
                    c06721.f5035a.finish();
                    c06721.f5035a.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public final String am_() {
        return "native_article_story";
    }

    public boolean mo253a() {
        if (!((ExpandedMediaHolder) this.f5098o.get()).mo447a(Event.BACK)) {
            this.f5064A.m7540b();
            HandlerDetour.b(this.f5070G, new C06805(this), 1000, -419763078);
        }
        return true;
    }

    public final void mo252a(C06811 c06811) {
        this.f5065B = c06811;
    }

    public final void mo251a(C06721 c06721) {
        this.f5066C = c06721;
    }

    public void mo256d() {
    }

    @Nullable
    protected ItemDecoration m5089r() {
        return null;
    }

    public void m5075b(RichDocumentBlocksImpl richDocumentBlocksImpl) {
    }

    public Adapter m5076c(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        return new RichDocumentAdapter(getContext(), richDocumentBlocksImpl, this.f5105v.m5228a(m5058C()), (LinearLayoutManager) this.f5109z.getLayoutManager(), this.f5109z, m5058C());
    }

    protected void m5092w() {
    }

    protected void m5093x() {
    }

    public void m5094y() {
    }

    public final void mo255c(Bundle bundle) {
        this.f5108y = bundle;
    }

    public final Activity m5057A() {
        return (Activity) ContextUtils.a(getContext(), Activity.class);
    }
}
