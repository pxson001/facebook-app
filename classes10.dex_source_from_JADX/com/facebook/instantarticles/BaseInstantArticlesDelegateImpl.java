package com.facebook.instantarticles;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.fps.BaseFrameRateLoggerCallback;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.RichDocumentConstants;
import com.facebook.richdocument.RichDocumentDelegateImpl;
import com.facebook.richdocument.RichDocumentDelegateImpl.RichDocumentDialog;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.ThirdPartyTrackerHandler;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksAppendedSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksErrorSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksFetchStartedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksErrorEvent;
import com.facebook.richdocument.fetcher.Retryable;
import com.facebook.richdocument.genesis.BlockViewHolderFactoryProvider;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.logging.RichDocumentLoggingUtils;
import com.facebook.richdocument.logging.RichDocumentLongClickTracker;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.RichDocumentItemDecorator;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager;
import com.facebook.richdocument.view.util.RichDocumentBlocksFetchProgressUpdater;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.widget.RichDocumentBlocksFetchProgressListener;
import com.facebook.richdocument.view.widget.RichDocumentRetryViewGroup;
import com.facebook.richdocument.view.widget.RichDocumentRetryViewGroup.1;
import com.facebook.richdocument.view.widget.ShareBar;
import com.facebook.richdocument.view.widget.ShareBar.OnCloseClickedListener;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.base.Optional;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: view_people */
public abstract class BaseInstantArticlesDelegateImpl<REQUEST, RESULT> extends RichDocumentDelegateImpl<REQUEST, RESULT> {
    @Inject
    AbstractFbErrorReporter f417A;
    @Inject
    Lazy<RichDocumentLongClickTracker> f418B;
    @Inject
    Lazy<RichDocumentLoggingUtils> f419C;
    @Inject
    Lazy<RichDocumentAnalyticsLogger> f420D;
    @Inject
    Lazy<ThirdPartyTrackerHandler> f421E;
    @Inject
    Lazy<GatekeeperStore> f422F;
    @Inject
    RichDocumentInfo f423G;
    @Inject
    QeAccessor f424H;
    @Inject
    Lazy<GatekeeperStore> f425I;
    public Handler f426J = new Handler(Looper.myLooper());
    private ShareBar f427K;
    private RichDocumentItemDecorator f428L;
    public RichDocumentRetryViewGroup f429M;
    public ViewStub f430N;
    public ProgressBar f431O;
    public RichDocumentBlocksFetchProgressListener f432P;
    public RichDocumentBlocksFetchProgressUpdater f433Q;
    public Runnable f434R;
    private FrameLayout f435S;
    private final RichDocumentBlocksFetchStartedSubscriber f436T = new C00671(this);
    private final RichDocumentBlocksErrorSubscriber f437U = new C00682(this);
    private final RichDocumentBlocksAppendedSubscriber f438V = new C00693(this);
    @Inject
    FrameRateLoggerProvider f439w;
    @Inject
    BlockViewHolderFactoryProvider f440x;
    @Inject
    Lazy<ConnectionQualityMonitor> f441y;
    @Inject
    Lazy<SequenceLogger> f442z;

    /* compiled from: view_people */
    class C00671 extends RichDocumentBlocksFetchStartedSubscriber {
        final /* synthetic */ BaseInstantArticlesDelegateImpl f411a;

        C00671(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl) {
            this.f411a = baseInstantArticlesDelegateImpl;
        }

        public final void m533b(FbEvent fbEvent) {
            BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl = this.f411a;
            HandlerDetour.b(baseInstantArticlesDelegateImpl.f426J, baseInstantArticlesDelegateImpl.f434R, RichDocumentUIConfig.P, -156504474);
            if (baseInstantArticlesDelegateImpl.f429M != null) {
                baseInstantArticlesDelegateImpl.f429M.a();
            }
        }
    }

    /* compiled from: view_people */
    class C00682 extends RichDocumentBlocksErrorSubscriber {
        final /* synthetic */ BaseInstantArticlesDelegateImpl f412a;

        C00682(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl) {
            this.f412a = baseInstantArticlesDelegateImpl;
        }

        public final void m534b(FbEvent fbEvent) {
            Object obj;
            RichDocumentBlocksErrorEvent richDocumentBlocksErrorEvent = (RichDocumentBlocksErrorEvent) fbEvent;
            BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl = this.f412a;
            Retryable retryable = richDocumentBlocksErrorEvent.c;
            HandlerDetour.a(baseInstantArticlesDelegateImpl.f426J, baseInstantArticlesDelegateImpl.f434R);
            baseInstantArticlesDelegateImpl.f433Q.b();
            baseInstantArticlesDelegateImpl.f431O.setVisibility(8);
            if (baseInstantArticlesDelegateImpl.f430N != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (baseInstantArticlesDelegateImpl.f429M == null) {
                    baseInstantArticlesDelegateImpl.f429M = (RichDocumentRetryViewGroup) baseInstantArticlesDelegateImpl.f430N.inflate();
                }
                RichDocumentRetryViewGroup richDocumentRetryViewGroup = baseInstantArticlesDelegateImpl.f429M;
                richDocumentRetryViewGroup.getRetryButton().setOnClickListener(new 1(richDocumentRetryViewGroup, retryable));
                baseInstantArticlesDelegateImpl.f429M.b();
            }
        }
    }

    /* compiled from: view_people */
    class C00693 extends RichDocumentBlocksAppendedSubscriber {
        final /* synthetic */ BaseInstantArticlesDelegateImpl f413a;

        C00693(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl) {
            this.f413a = baseInstantArticlesDelegateImpl;
        }

        public final void m535b(FbEvent fbEvent) {
            BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl = this.f413a;
            HandlerDetour.a(baseInstantArticlesDelegateImpl.f426J, baseInstantArticlesDelegateImpl.f434R);
            baseInstantArticlesDelegateImpl.f431O.setVisibility(8);
            baseInstantArticlesDelegateImpl.f433Q.b();
            if (baseInstantArticlesDelegateImpl.f429M != null) {
                baseInstantArticlesDelegateImpl.f429M.a();
            }
        }
    }

    /* compiled from: view_people */
    class C00704 implements OnCloseClickedListener {
        final /* synthetic */ BaseInstantArticlesDelegateImpl f414a;

        C00704(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl) {
            this.f414a = baseInstantArticlesDelegateImpl;
        }

        public final void m536a() {
            this.f414a.A.b();
        }
    }

    /* compiled from: view_people */
    class C00715 extends BaseFrameRateLoggerCallback {
        final /* synthetic */ BaseInstantArticlesDelegateImpl f415a;

        C00715(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl) {
            this.f415a = baseInstantArticlesDelegateImpl;
        }

        public final void m537a(HoneyClientEventFast honeyClientEventFast) {
            honeyClientEventFast.a("instant_article_id", this.f415a.mo17E());
        }
    }

    /* compiled from: view_people */
    final class StartFakeProgressUpdaterRunnable implements Runnable {
        WeakReference<BaseInstantArticlesDelegateImpl> f416a;

        public StartFakeProgressUpdaterRunnable(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl) {
            this.f416a = new WeakReference(baseInstantArticlesDelegateImpl);
        }

        public final void run() {
            BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl = (BaseInstantArticlesDelegateImpl) this.f416a.get();
            if (baseInstantArticlesDelegateImpl != null) {
                RichDocumentBlocksFetchProgressUpdater richDocumentBlocksFetchProgressUpdater = baseInstantArticlesDelegateImpl.f433Q;
                if (!richDocumentBlocksFetchProgressUpdater.b.isRunning()) {
                    richDocumentBlocksFetchProgressUpdater.b.start();
                    richDocumentBlocksFetchProgressUpdater.f = true;
                    richDocumentBlocksFetchProgressUpdater.g = false;
                }
            }
        }
    }

    public static void m539a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BaseInstantArticlesDelegateImpl) obj).m538a((FrameRateLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), (BlockViewHolderFactoryProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BlockViewHolderFactoryProvider.class), IdBasedLazy.a(fbInjector, 3297), IdBasedSingletonScopeProvider.b(fbInjector, 3422), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 10338), IdBasedLazy.a(fbInjector, 10337), IdBasedLazy.a(fbInjector, 10334), IdBasedLazy.a(fbInjector, 10296), IdBasedSingletonScopeProvider.b(fbInjector, 2128), RichDocumentInfo.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2128));
    }

    protected abstract String mo17E();

    private void m538a(FrameRateLoggerProvider frameRateLoggerProvider, BlockViewHolderFactoryProvider blockViewHolderFactoryProvider, Lazy<ConnectionQualityMonitor> lazy, Lazy<SequenceLogger> lazy2, FbErrorReporter fbErrorReporter, Lazy<RichDocumentLongClickTracker> lazy3, Lazy<RichDocumentLoggingUtils> lazy4, Lazy<RichDocumentAnalyticsLogger> lazy5, Lazy<ThirdPartyTrackerHandler> lazy6, Lazy<GatekeeperStore> lazy7, RichDocumentInfo richDocumentInfo, QeAccessor qeAccessor, Lazy<GatekeeperStore> lazy8) {
        this.f439w = frameRateLoggerProvider;
        this.f440x = blockViewHolderFactoryProvider;
        this.f441y = lazy;
        this.f442z = lazy2;
        this.f417A = fbErrorReporter;
        this.f418B = lazy3;
        this.f419C = lazy4;
        this.f420D = lazy5;
        this.f421E = lazy6;
        this.f422F = lazy7;
        this.f423G = richDocumentInfo;
        this.f424H = qeAccessor;
        this.f425I = lazy8;
    }

    public final void m544a(Bundle bundle) {
        super.a(bundle);
        Class cls = BaseInstantArticlesDelegateImpl.class;
        m539a(this, getContext());
    }

    public View mo18b(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewStub viewStub;
        Sequence e = ((SequenceLogger) this.f442z.get()).e(C());
        if (e != null) {
            SequenceLoggerDetour.a(e, "instant_articles_base_view_creation", -1499037711);
        }
        String E = mo17E();
        String string = this.y.getString("tracking_codes");
        this.f423G.b = E;
        this.f423G.b(string);
        this.f423G.e = this.y.getBoolean("extra_instant_articles_saved", false);
        this.f423G.f = this.y.getString("richdocument_fragment_tag");
        this.f428L = new RichDocumentItemDecorator(getContext());
        if (e != null) {
            SequenceLoggerDetour.a(e, "instant_articles_base_view_init", 1892937456);
        }
        View b = super.b(layoutInflater, viewGroup, bundle);
        this.f427K = (ShareBar) b.findViewById(2131562986);
        this.f427K.G = new C00704(this);
        if (this.f430N != null) {
            viewStub = this.f430N;
        } else {
            viewStub = (ViewStub) b.findViewById(2131562989);
        }
        this.f430N = viewStub;
        this.f431O = (ProgressBar) b.findViewById(2131562988);
        this.f432P = (RichDocumentBlocksFetchProgressListener) b.findViewById(2131562985);
        this.f433Q = new RichDocumentBlocksFetchProgressUpdater(this, (((ConnectionQualityMonitor) this.f441y.get()).a().compareTo(ConnectionQuality.GOOD) < 0 ? RichDocumentUIConfig.N : RichDocumentUIConfig.O) - RichDocumentUIConfig.P);
        this.f434R = new StartFakeProgressUpdaterRunnable(this);
        if (e != null) {
            SequenceLoggerDetour.a(e, "instant_articles_base_view_init", 1007867344);
        }
        ((RichDocumentEventBus) this.a.get()).a(this.f436T);
        ((RichDocumentEventBus) this.a.get()).a(this.f437U);
        ((RichDocumentEventBus) this.a.get()).a(this.f438V);
        this.f435S = (FrameLayout) b.findViewById(2131562984);
        if (e != null) {
            SequenceLoggerDetour.b(e, "instant_articles_base_view_creation", 1369737081);
        }
        return b;
    }

    protected final void m554y() {
        super.y();
        this.f427K.F = this.y.getBoolean("is_called_by_sample_app", false);
        String string = this.y.getString("extra_instant_articles_id");
        ((RichDocumentAnalyticsLogger) this.f420D.get()).f = string;
        RichDocumentLoggingUtils richDocumentLoggingUtils = (RichDocumentLoggingUtils) this.f419C.get();
        richDocumentLoggingUtils.a.edit().a(RichDocumentConstants.b, RichDocumentLoggingUtils.a(string, 0, null, null)).a(RichDocumentConstants.c, richDocumentLoggingUtils.b.now()).commit();
        RichDocumentLongClickTracker richDocumentLongClickTracker = (RichDocumentLongClickTracker) this.f418B.get();
        richDocumentLongClickTracker.l = this.y.getString("extra_instant_articles_click_url");
        richDocumentLongClickTracker.m = string;
    }

    protected final int m552q() {
        return m540D() ? 2130904818 : 2130904816;
    }

    public final Dialog m548j() {
        boolean a = this.f424H.a(ExperimentsForRichDocumentAbtestModule.p, false);
        String a2 = this.f424H.a(ExperimentsForRichDocumentAbtestModule.q, "app_global");
        if (!a) {
            return new RichDocumentDialog(this, 16973841);
        }
        RichDocumentDialog richDocumentDialog = new RichDocumentDialog(this, 16973840);
        if (!(a2 == null || a2.equals("app_global"))) {
            if (VERSION.SDK_INT >= 21) {
                richDocumentDialog.getWindow().setFlags(Integer.MIN_VALUE, Integer.MIN_VALUE);
                richDocumentDialog.getWindow().setStatusBarColor(Color.parseColor(a2));
                return richDocumentDialog;
            }
            richDocumentDialog.getWindow().setFlags(67108864, 67108864);
            View view = new View(getContext());
            int i = 0;
            int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = getContext().getResources().getDimensionPixelSize(identifier);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i);
            view.setBackground(new ColorDrawable(Color.parseColor(a2)));
            ((ViewGroup) richDocumentDialog.getWindow().getDecorView()).addView(view, layoutParams);
        }
        return richDocumentDialog;
    }

    public final boolean m540D() {
        return ((GatekeeperStoreImpl) this.f425I.get()).a(102, false) ? true : this.f424H.a(ExperimentsForRichDocumentAbtestModule.d, false);
    }

    public final LinearLayoutManager m542a(BetterRecyclerView betterRecyclerView) {
        return new RichDocumentLayoutManager(getContext(), betterRecyclerView);
    }

    @Nullable
    protected final ItemDecoration m553r() {
        return this.f428L;
    }

    public final void m550l() {
        super.l();
        if (this.f427K != null && (this.f427K.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f427K.getParent()).removeView(this.f427K);
            this.f427K = null;
        }
    }

    protected void mo19b(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        if (VERSION.SDK_INT >= 16) {
            this.z.setBackground(new ColorDrawable(richDocumentBlocksImpl.b.getInt("background_color")));
        } else {
            this.z.setBackgroundColor(richDocumentBlocksImpl.b.getInt("background_color"));
        }
        String string = richDocumentBlocksImpl.b.getString("url");
        this.f427K.A = string;
        this.f423G.c = string;
        String string2 = this.y.getString("extra_instant_articles_click_url");
        ThirdPartyTrackerHandler thirdPartyTrackerHandler = (ThirdPartyTrackerHandler) this.f421E.get();
        thirdPartyTrackerHandler.i = this.f435S;
        thirdPartyTrackerHandler.j = string2;
        thirdPartyTrackerHandler.k = string;
        this.f427K.B = string2;
        RichDocumentLoggingUtils richDocumentLoggingUtils = (RichDocumentLoggingUtils) this.f419C.get();
        Bundle bundle = richDocumentBlocksImpl.b;
        richDocumentLoggingUtils.a.edit().a(RichDocumentConstants.b, RichDocumentLoggingUtils.a(richDocumentBlocksImpl.a, bundle.getInt("version"), bundle.getString("title"), bundle.getString("url"))).a(RichDocumentConstants.c, richDocumentLoggingUtils.b.now()).commit();
        if (this.f423G.g != null) {
            a(this.f423G.g);
        }
    }

    protected final void m549k() {
        super.k();
        FrameRateLogger a = this.f439w.a(Boolean.valueOf(false), ((GatekeeperStoreImpl) this.f422F.get()).a(684, false) ? "instant_article_improved_scroll_perf" : "instant_article_scroll_perf", Optional.of("native_article_story".toString()));
        a.n = new C00715(this);
        a(this.z, a);
    }

    protected final Adapter m547c(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        return new RichDocumentAdapter(getContext(), richDocumentBlocksImpl, this.f440x.a(C()), (RichDocumentLayoutManager) this.z.getLayoutManager(), this.z, C());
    }

    protected final View m543a(View view) {
        return view.findViewById(2131562982);
    }

    public void mo20n() {
        super.n();
        if (this.f421E != null) {
            ThirdPartyTrackerHandler thirdPartyTrackerHandler = (ThirdPartyTrackerHandler) this.f421E.get();
            if (thirdPartyTrackerHandler.i != null) {
                while (thirdPartyTrackerHandler.i.getChildCount() > 0) {
                    View childAt = thirdPartyTrackerHandler.i.getChildAt(0);
                    if (childAt instanceof WebView) {
                        WebViewUtils.b((WebView) childAt);
                    }
                    thirdPartyTrackerHandler.i.removeView(childAt);
                }
                thirdPartyTrackerHandler.i = null;
            }
        }
    }
}
