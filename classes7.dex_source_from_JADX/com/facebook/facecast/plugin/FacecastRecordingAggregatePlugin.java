package com.facebook.facecast.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.plugin.FacecastBottomContainerPlugin.FacecastBroadcastFinishedListener;
import com.facebook.facecast.plugin.FacecastEndTimerView.FacecastEndTimerViewListener;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakFunnelLogger;
import com.facebook.facecast.plugin.commercialbreak.FacecastCommercialBreakAggregatePlugin;
import com.facebook.facecast.plugin.commercialbreak.FacecastStartCommercialBreakPlugin.CommercialBreakEligibility;
import com.facebook.facecast.plugin.commercialbreak.FacecastStartCommercialBreakPlugin.FacecastStartCommercialBreakListener;
import com.facebook.facecast.plugin.commercialbreak.FinishDuringCommercialBreakPopoverWindow;
import com.facebook.facecast.plugin.creativetools.CreativeToolsModel;
import com.facebook.facecast.plugin.creativetools.CreativeToolsModel.C16151;
import com.facebook.facecast.plugin.creativetools.CreativeToolsModelProvider;
import com.facebook.facecast.plugin.creativetools.CreativeToolsPack;
import com.facebook.facecast.plugin.creativetools.CreativeToolsUtil;
import com.facebook.facecast.plugin.creativetools.FacecastCreativeToolsButtonPlugin;
import com.facebook.facecast.plugin.creativetools.FacecastCreativeToolsButtonPlugin.CreativeToolsButtonClickListener;
import com.facebook.facecast.plugin.creativetools.FacecastCreativeToolsPlugin;
import com.facebook.facecast.protocol.FacecastVideoFeedbackLoader;
import com.facebook.facecast.protocol.FacecastVideoFeedbackLoader.VideoFeedbackLoaderListener;
import com.facebook.facecast.protocol.FacecastVideoFeedbackLoaderProvider;
import com.facebook.facecast.protocol.FetchCreativeToolsQuery.FetchCreativeToolsQueryString;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.google.common.util.concurrent.Futures;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderBottomLeftRadius */
public class FacecastRecordingAggregatePlugin extends FacecastAggregatedBasePlugin implements FacecastBroadcastFinishedListener, CommercialBreakBroadcastStateChangeListener, CreativeToolsButtonClickListener, VideoFeedbackLoaderListener {
    public long f18477A;
    public long f18478B;
    private FacecastVideoFeedbackLoader f18479C;
    @Inject
    GatekeeperStoreImpl f18480c;
    @Inject
    public FacecastAnalyticsLogger f18481d;
    @Inject
    public FacecastUtil f18482e;
    @Inject
    public CommercialBreakBroadcastStateManager f18483f;
    @Inject
    public CreativeToolsModelProvider f18484g;
    @Inject
    FacecastVideoFeedbackLoaderProvider f18485h;
    @Inject
    public CommercialBreakFunnelLogger f18486i;
    public final FacecastBottomContainerPlugin f18487j;
    public final FacecastLiveStatusPlugin f18488k;
    public final FacecastLiveVideoStatusPlugin f18489l;
    @Nullable
    private FacecastWeakConnectionOverlayPlugin f18490m;
    @Nullable
    private final FacecastStreamingReactionsPlugin f18491n;
    @Nullable
    public FacecastCommercialBreakAggregatePlugin f18492o;
    @Nullable
    public FacecastCreativeToolsButtonPlugin f18493p;
    @Nullable
    public FacecastCreativeToolsPlugin f18494q;
    @Nullable
    public FinishDuringCommercialBreakPopoverWindow f18495r;
    @Nullable
    public CreativeToolsModel f18496s;
    @Nullable
    public List<CreativeToolsPack> f18497t;
    @Nullable
    private FacecastPreviewPlugin f18498u;
    public String f18499v;
    private boolean f18500w;
    public boolean f18501x;
    public boolean f18502y;
    private long f18503z;

    /* compiled from: borderBottomLeftRadius */
    public class C15851 {
        public final /* synthetic */ FacecastRecordingAggregatePlugin f18471a;

        public C15851(FacecastRecordingAggregatePlugin facecastRecordingAggregatePlugin) {
            this.f18471a = facecastRecordingAggregatePlugin;
        }
    }

    /* compiled from: borderBottomLeftRadius */
    public class CommercialBreakController implements FacecastStartCommercialBreakListener {
        public final /* synthetic */ FacecastRecordingAggregatePlugin f18475a;

        public CommercialBreakController(FacecastRecordingAggregatePlugin facecastRecordingAggregatePlugin) {
            this.f18475a = facecastRecordingAggregatePlugin;
        }

        public final void mo1424a() {
            if (this.f18475a.f18492o != null) {
                CommercialBreakEligibility a = this.f18475a.f18492o.m22200a(this.f18475a.f18477A, this.f18475a.f18478B);
                if (a == CommercialBreakEligibility.ELIGIBLE) {
                    this.f18475a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PROMPT);
                    this.f18475a.f18486i.m22193c();
                } else if (a != CommercialBreakEligibility.IN_COMMERCIAL_BREAK) {
                    this.f18475a.f18492o.m22204a(a, this.f18475a.f18477A, this.f18475a.f18478B);
                    this.f18475a.f18486i.m22193c();
                }
            }
        }

        public final void m22118c() {
            this.f18475a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_ELIGIBLE);
            this.f18475a.f18486i.m22195e();
        }
    }

    /* compiled from: borderBottomLeftRadius */
    public class FinishDuringCommercialBreakPopoverCallback {
        public final /* synthetic */ FacecastRecordingAggregatePlugin f18476a;

        public FinishDuringCommercialBreakPopoverCallback(FacecastRecordingAggregatePlugin facecastRecordingAggregatePlugin) {
            this.f18476a = facecastRecordingAggregatePlugin;
        }
    }

    public static void m22122a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FacecastRecordingAggregatePlugin) obj).m22121a(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FacecastAnalyticsLogger.m21959a(injectorLike), FacecastUtil.m3107b(injectorLike), CommercialBreakBroadcastStateManager.m22183a(injectorLike), (CreativeToolsModelProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreativeToolsModelProvider.class), (FacecastVideoFeedbackLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastVideoFeedbackLoaderProvider.class), CommercialBreakFunnelLogger.m22189a(injectorLike));
    }

    public FacecastRecordingAggregatePlugin(Context context) {
        this(context, null);
    }

    private FacecastRecordingAggregatePlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastRecordingAggregatePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastRecordingAggregatePlugin.class;
        m22122a((Object) this, getContext());
        this.f18487j = new FacecastBottomContainerPlugin(context);
        m21957a(this.f18487j);
        this.f18502y = this.f18480c.a(VideoAbTestGatekeepers.f, false);
        if (this.f18502y) {
            this.f18489l = new FacecastLiveVideoStatusPlugin(context);
            m21955a(this.f18489l);
            this.f18488k = null;
        } else {
            this.f18488k = new FacecastLiveStatusPlugin(context);
            m21955a(this.f18488k);
            this.f18489l = null;
        }
        if (this.f18482e.m3109a()) {
            this.f18491n = new FacecastStreamingReactionsPlugin(context);
            m21955a(this.f18491n);
            return;
        }
        this.f18491n = null;
    }

    public final void m22127a(String str, long j, long j2, ComposerTargetData composerTargetData, FacecastPreviewPlugin facecastPreviewPlugin, boolean z, float f, boolean z2) {
        this.f18499v = str;
        this.f18487j.m21974a(str, composerTargetData, z, f);
        this.f18503z = j;
        this.f18498u = facecastPreviewPlugin;
        this.f18487j.f18213e = this;
        if (this.f18502y) {
            FacecastEndTimerViewListener facecastEndTimerViewListener = this.f18489l;
            facecastEndTimerViewListener.f18442f.m22077a(j2, facecastEndTimerViewListener);
            facecastEndTimerViewListener.f18440d.m22561a();
        } else {
            this.f18488k.m22086a(j2);
        }
        if (z2) {
            this.f18492o = new FacecastCommercialBreakAggregatePlugin(getContext());
            m21955a(this.f18492o);
            this.f18483f.m22186a((CommercialBreakBroadcastStateChangeListener) this);
            this.f18483f.m22186a(this.f18492o);
            this.f18483f.m22186a(this.f18489l);
            this.f18483f.m22186a(this.f18498u);
            this.f18492o.m22201a(this.f18487j.getToolbarContainer(), new CommercialBreakController(this));
            this.f18486i.f18574b = str;
        }
    }

    protected final void hE_() {
        super.hE_();
        if (this.f18502y && this.f18482e.m3118o()) {
            if (this.f18496s == null) {
                CreativeToolsModelProvider creativeToolsModelProvider = this.f18484g;
                this.f18496s = new CreativeToolsModel(GraphQLQueryExecutor.a(creativeToolsModelProvider), Handler_ForUiThreadMethodAutoProvider.b(creativeToolsModelProvider), GatekeeperStoreImplMethodAutoProvider.a(creativeToolsModelProvider), this.f18499v, new C15851(this));
            } else {
                this.f18496s.m22275b();
            }
            CreativeToolsModel creativeToolsModel = this.f18496s;
            if (creativeToolsModel.f18708g == null) {
                creativeToolsModel.f18709h = false;
                GraphQlQueryString fetchCreativeToolsQueryString = new FetchCreativeToolsQueryString();
                fetchCreativeToolsQueryString.a("videoID", creativeToolsModel.f18706e);
                creativeToolsModel.f18708g = creativeToolsModel.f18703b.a(GraphQLRequest.a(fetchCreativeToolsQueryString));
                Futures.a(creativeToolsModel.f18708g, new C16151(creativeToolsModel));
            }
        }
        this.f18479C = this.f18485h.m22315a(this.f18499v, this);
        FacecastVideoFeedbackLoader.m22314a(this.f18479C, 0);
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        this.f18483f.m22188b(this);
        this.f18483f.m22188b(this.f18492o);
        this.f18483f.m22188b(this.f18489l);
        this.f18483f.m22188b(this.f18498u);
        if (this.f18496s != null) {
            this.f18496s.m22275b();
        }
        if (this.f18479C != null) {
            FacecastVideoFeedbackLoader facecastVideoFeedbackLoader = this.f18479C;
            if (facecastVideoFeedbackLoader.f18777g != null) {
                facecastVideoFeedbackLoader.f18777g.cancel(true);
            }
            this.f18479C = null;
        }
    }

    public final void hD_() {
        if (this.f18483f.f18570b == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PLAYING || this.f18483f.f18570b == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_RESUME) {
            this.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_INTERRUPTED);
        } else if (this.f18477A < this.f18503z * 1000) {
            FacecastBottomContainerPlugin facecastBottomContainerPlugin = this.f18487j;
            long j = this.f18503z;
            Tooltip tooltip = new Tooltip(facecastBottomContainerPlugin.getContext(), 2);
            tooltip.b(facecastBottomContainerPlugin.getResources().getString(2131238234, new Object[]{Long.valueOf(j)}));
            tooltip.c(facecastBottomContainerPlugin.f18217i);
            tooltip.d();
        } else {
            this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH);
        }
    }

    public Map<String, String> getLoggingInfo() {
        if (this.f18489l != null) {
            return this.f18489l.getLoggingInfo();
        }
        return null;
    }

    public final void m22130g() {
        if (this.f18502y) {
            this.f18489l.f18439c.a();
        } else {
            this.f18488k.f18430c.a();
        }
        this.f18487j.m21975a(false);
        this.f18500w = true;
        if (this.f18501x) {
            this.f18501x = false;
            if (this.f18502y) {
                this.f18489l.setWeakConnection(false);
            } else {
                this.f18488k.setWeakConnection(false);
                this.f18490m.setWeakConnection(false);
            }
        }
        this.f18487j.setSuspended(true);
        if (this.f18491n != null) {
            this.f18491n.f18522c.m4150e();
        }
        if (this.f18492o != null) {
            this.f18486i.f18573a.b(FunnelRegistry.C);
        }
    }

    public final void m22131h() {
        if (this.f18502y) {
            FacecastLiveVideoStatusPlugin facecastLiveVideoStatusPlugin = this.f18489l;
            facecastLiveVideoStatusPlugin.f18439c.a(this.f18499v);
        } else {
            FacecastLiveStatusPlugin facecastLiveStatusPlugin = this.f18488k;
            facecastLiveStatusPlugin.f18430c.a(this.f18499v);
        }
        this.f18500w = false;
        this.f18487j.m21975a(true);
        this.f18487j.setSuspended(false);
        if (this.f18491n != null) {
            this.f18491n.f18522c.m4151f();
        }
        if (this.f18492o != null) {
            CommercialBreakFunnelLogger commercialBreakFunnelLogger = this.f18486i;
            commercialBreakFunnelLogger.f18577e = 0;
            commercialBreakFunnelLogger.f18576d = -1;
            commercialBreakFunnelLogger.f18573a.a(FunnelRegistry.C);
        }
    }

    public final boolean mo1409a() {
        if (this.f18500w) {
            return super.mo1409a();
        }
        if (this.f18493p == null || !this.f18493p.f18735d) {
            if (super.mo1409a()) {
                return true;
            }
            hD_();
            return true;
        } else if (!this.f18493p.f18734c.isEnabled()) {
            return true;
        } else {
            FacecastCreativeToolsButtonPlugin facecastCreativeToolsButtonPlugin = this.f18493p;
            facecastCreativeToolsButtonPlugin.f18735d = false;
            FacecastCreativeToolsButtonPlugin.m22289k(facecastCreativeToolsButtonPlugin);
            m22123b(false);
            CreativeToolsUtil.m22287a(this.f18481d, false, "back");
            return true;
        }
    }

    public final void mo1426a(boolean z) {
        if (this.f18494q == null) {
            this.f18494q = new FacecastCreativeToolsPlugin(getContext());
            m21956a(this.f18494q, this.f18487j);
            FacecastCreativeToolsPlugin facecastCreativeToolsPlugin = this.f18494q;
            FacecastPreviewPlugin facecastPreviewPlugin = this.f18498u;
            facecastCreativeToolsPlugin.f18737d.m22284a(facecastPreviewPlugin.f18462l, facecastPreviewPlugin.f18460j);
            facecastCreativeToolsPlugin = this.f18494q;
            facecastCreativeToolsPlugin.f18736c.setCreativeToolsPacks(this.f18497t);
        }
        m22123b(z);
        CreativeToolsUtil.m22287a(this.f18481d, z, "tap");
    }

    public void setWeakConnection(boolean z) {
        if (this.f18501x != z) {
            this.f18501x = z;
            Map hashMap = new HashMap();
            hashMap.put("network_state_during_recording", this.f18501x ? "network_weak" : "network_recovered");
            this.f18481d.m21965a(hashMap);
            if (this.f18502y) {
                this.f18489l.setWeakConnection(z);
                return;
            }
            if (this.f18490m == null) {
                this.f18490m = new FacecastWeakConnectionOverlayPlugin(getContext());
                m21955a(this.f18490m);
            }
            this.f18488k.setWeakConnection(z);
            this.f18490m.setWeakConnection(z);
        }
    }

    public final void mo1425a(GraphQLFeedback graphQLFeedback) {
        if (this.f18491n != null) {
            FacecastStreamingReactionsPlugin facecastStreamingReactionsPlugin = this.f18491n;
            facecastStreamingReactionsPlugin.f18522c.m4146a(this.f18499v, graphQLFeedback.z_(), true);
            this.f18491n.f18522c.m4148b();
        }
        this.f18487j.f18216h.setFeedback(graphQLFeedback);
        this.f18479C = null;
    }

    private void m22123b(final boolean z) {
        int i = 0;
        this.f18493p.setButtonEnabled(false);
        AnimatorListener c15862 = new AnimatorListenerAdapter(this) {
            final /* synthetic */ FacecastRecordingAggregatePlugin f18473b;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f18473b.f18493p.setButtonEnabled(true);
                if (!z) {
                    FacecastCreativeToolsPlugin facecastCreativeToolsPlugin = this.f18473b.f18494q;
                    facecastCreativeToolsPlugin.f18736c.setVisibility(8);
                    facecastCreativeToolsPlugin.f18737d.setVisibility(8);
                    facecastCreativeToolsPlugin.f18737d.m22285b();
                }
            }
        };
        if (z) {
            FacecastCreativeToolsPlugin facecastCreativeToolsPlugin = this.f18494q;
            facecastCreativeToolsPlugin.f18736c.setVisibility(0);
            facecastCreativeToolsPlugin.f18737d.setVisibility(0);
            facecastCreativeToolsPlugin.f18737d.m22283a();
            facecastCreativeToolsPlugin.f18736c.m22279a();
            this.f18494q.f18736c.animate().alpha(1.0f).start();
            i = this.f18494q.getResources().getDimensionPixelSize(2131432371);
        } else {
            this.f18494q.f18736c.animate().alpha(0.0f).start();
        }
        this.f18487j.f18211c.animate().translationY((float) i).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(c15862).start();
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        switch (commercialBreakBroadcastState2) {
            case COMMERCIAL_BREAK_BROADCAST_INTERRUPTED:
                if (this.f18495r != null) {
                    this.f18495r.l();
                    break;
                }
                break;
        }
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_INTERRUPTED:
                if (this.f18495r == null) {
                    this.f18495r = new FinishDuringCommercialBreakPopoverWindow(getContext());
                }
                this.f18495r.f18635a = new FinishDuringCommercialBreakPopoverCallback(this);
                this.f18495r.a(this.f18487j.f18211c);
                return;
            case COMMERCIAL_BREAK_BROADCAST_PROMPT:
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                if (this.f18493p != null) {
                    this.f18493p.f18734c.setVisibility(4);
                    return;
                }
                return;
            case COMMERCIAL_BREAK_BROADCAST_ELIGIBLE:
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                if (this.f18493p != null) {
                    this.f18493p.f18734c.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m22121a(GatekeeperStoreImpl gatekeeperStoreImpl, FacecastAnalyticsLogger facecastAnalyticsLogger, FacecastUtil facecastUtil, CommercialBreakBroadcastStateManager commercialBreakBroadcastStateManager, CreativeToolsModelProvider creativeToolsModelProvider, FacecastVideoFeedbackLoaderProvider facecastVideoFeedbackLoaderProvider, CommercialBreakFunnelLogger commercialBreakFunnelLogger) {
        this.f18480c = gatekeeperStoreImpl;
        this.f18481d = facecastAnalyticsLogger;
        this.f18482e = facecastUtil;
        this.f18483f = commercialBreakBroadcastStateManager;
        this.f18484g = creativeToolsModelProvider;
        this.f18485h = facecastVideoFeedbackLoaderProvider;
        this.f18486i = commercialBreakFunnelLogger;
    }
}
