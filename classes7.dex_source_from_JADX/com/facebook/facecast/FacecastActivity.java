package com.facebook.facecast;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device.ScreenUtil;
import com.facebook.facecast.FacecastCopyrightMonitor.CopyrightStateListener;
import com.facebook.facecast.FacecastCopyrightMonitor.CopyrightViolationInfo;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.FacecastStateManager.FacecastStateChangeListener;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig;
import com.facebook.facecast.abtest.FacecastEndScreenQEHelper;
import com.facebook.facecast.model.FacecastCompositionData;
import com.facebook.facecast.model.FacecastCompositionData.Builder;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.facecast.plugin.FacecastCopyrightViolationPlugin;
import com.facebook.facecast.plugin.FacecastEditTitlePlugin;
import com.facebook.facecast.plugin.FacecastEndScreenBasePlugin;
import com.facebook.facecast.plugin.FacecastEndScreenBasePlugin.DoneButtonClickedListener;
import com.facebook.facecast.plugin.FacecastEndScreenPlugin;
import com.facebook.facecast.plugin.FacecastEndScreenV2Plugin;
import com.facebook.facecast.plugin.FacecastEndingBlankScreenPlugin;
import com.facebook.facecast.plugin.FacecastEndingCountdownPlugin;
import com.facebook.facecast.plugin.FacecastGoLiveButtonPlugin;
import com.facebook.facecast.plugin.FacecastLiveStatusPlugin;
import com.facebook.facecast.plugin.FacecastLiveVideoStatusPlugin;
import com.facebook.facecast.plugin.FacecastPausedPlugin;
import com.facebook.facecast.plugin.FacecastPreviewPlugin;
import com.facebook.facecast.plugin.FacecastPreviewPlugin.EncoderSurfaceType;
import com.facebook.facecast.plugin.FacecastReconnectingPlugin;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin;
import com.facebook.facecast.plugin.FacecastRotateCameraPlugin;
import com.facebook.facecast.plugin.FacecastRotateCameraPlugin.Corner;
import com.facebook.facecast.plugin.FacecastRotateCameraPlugin.RotateCameraClickListener;
import com.facebook.facecast.plugin.FacecastStartingAggregatePlugin;
import com.facebook.facecast.plugin.FacecastStartingAggregatePlugin.FacecastStartingAggregatePluginListener;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.facecast.plugin.commercialbreak.FacecastStartCommercialBreakPlugin.CommercialBreakEligibility;
import com.facebook.facecast.plugin.commercialbreak.PageCommercialBreakEligibilityFetcher;
import com.facebook.facecast.plugin.commercialbreak.PageCommercialBreakEligibilityFetcher.C16091;
import com.facebook.facecast.plugin.commercialbreak.PageCommercialBreakEligibilityFetcher.PageCommercialBreakEligibilityModelListener;
import com.facebook.facecast.plugin.tipjar.FacecastTipJarEndScreenPlugin;
import com.facebook.facecast.protocol.FacecastNetworker;
import com.facebook.facecast.protocol.FetchPageCommercialBreakEligibilityQuery.FetchPageCommercialBreakEligibilityQueryString;
import com.facebook.facecast.protocol.VideoBroadcastSealRequest;
import com.facebook.facecastdisplay.FacecastUiUtil;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLPrivacyRowInput;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.commercialbreak.CommercialBreakMessagePublisher;
import com.facebook.video.videostreaming.DisplayListenerDelegate;
import com.facebook.video.videostreaming.LiveStreamEncoderSurface;
import com.facebook.video.videostreaming.LiveStreamer;
import com.facebook.video.videostreaming.LiveStreamer.LiveStreamerPrefetchingListener;
import com.facebook.video.videostreaming.LiveStreamer.LiveStreamerStreamingListener;
import com.facebook.video.videostreaming.LiveStreamingError;
import com.facebook.video.videostreaming.LiveStreamingNetworkState;
import com.facebook.video.videostreaming.NetworkSpeedTest;
import com.facebook.video.videostreaming.NetworkSpeedTest.Status;
import com.facebook.video.videostreaming.RecordingListenerDelegate;
import com.facebook.video.videostreaming.protocol.VideoBroadcastInitResponse;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
public class FacecastActivity extends FbFragmentActivity implements CameraHandlerDelegate, CopyrightStateListener, FacecastStateChangeListener, DoneButtonClickedListener, RotateCameraClickListener, FacecastStartingAggregatePluginListener, CommercialBreakBroadcastStateChangeListener, PageCommercialBreakEligibilityModelListener, DisplayListenerDelegate, LiveStreamerPrefetchingListener, LiveStreamerStreamingListener, RecordingListenerDelegate {
    private static final String f17927L = FacecastActivity.class.getName();
    private static final String[] f17928M = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    @Inject
    FacecastUtil f17929A;
    @Inject
    QeAccessor f17930B;
    @Inject
    CommercialBreakMessagePublisher f17931C;
    @Inject
    FbNetworkManager f17932D;
    @Inject
    CommercialBreakBroadcastStateManager f17933E;
    @Inject
    FacecastEndScreenQEHelper f17934F;
    @Inject
    FacecastNetworker f17935G;
    @Inject
    FacecastPausedNotificationManager f17936H;
    @Inject
    FacecastBroadcasterCommercialBreakConfig f17937I;
    @Inject
    ScreenUtil f17938J;
    @Inject
    PageCommercialBreakEligibilityFetcher f17939K;
    private final List<FacecastBasePlugin> f17940N = new ArrayList();
    private ViewGroup f17941O;
    @Nullable
    private VideoBroadcastInitResponse f17942P;
    @Nullable
    private ApiErrorResult f17943Q;
    private Window f17944R;
    private long f17945S;
    private long f17946T;
    private long f17947U;
    private volatile boolean f17948V;
    private boolean f17949W;
    private boolean f17950X;
    private Runnable f17951Y;
    @Nullable
    private AlertDialog f17952Z;
    private FacecastCompositionData aa;
    private FacecastCamera ab;
    @Nullable
    private CopyrightViolationInfo ac;
    @Nullable
    private FacecastCopyrightMonitor ad;
    private boolean ae;
    private Runnable af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private CountDownLatch ak;
    private CountDownLatch al;
    @Nullable
    public FacecastRotateCameraPlugin am;
    @Nullable
    public FacecastStartingAggregatePlugin an;
    @Nullable
    private FacecastRecordingAggregatePlugin ao;
    @Nullable
    private FacecastEndingCountdownPlugin ap;
    @Nullable
    private FacecastEndScreenBasePlugin aq;
    @Nullable
    private FacecastEndScreenV2Plugin ar;
    @Nullable
    private FacecastPausedPlugin as;
    @Nullable
    private FacecastPreviewPlugin at;
    @Nullable
    private FacecastReconnectingPlugin au;
    @Nullable
    private FacecastCopyrightViolationPlugin av;
    @Nullable
    private FacecastEndingBlankScreenPlugin aw;
    @Inject
    FacecastCameraProvider f17953p;
    @Inject
    FacecastAnalyticsLogger f17954q;
    @Inject
    @ForUiThread
    Handler f17955r;
    @Inject
    ActivityRuntimePermissionsManagerProvider f17956s;
    @Inject
    MonotonicClock f17957t;
    @Inject
    Clock f17958u;
    @Inject
    FacecastStateManager f17959v;
    @Inject
    Toaster f17960w;
    @Inject
    LiveStreamer f17961x;
    @Inject
    LiveStreamDvrUploader f17962y;
    @Inject
    FacecastCopyrightMonitorProvider f17963z;

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    class C15121 implements Runnable {
        final /* synthetic */ FacecastActivity f17917a;

        C15121(FacecastActivity facecastActivity) {
            this.f17917a = facecastActivity;
        }

        public void run() {
            FacecastActivity.m21775D(this.f17917a);
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    class C15132 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ FacecastActivity f17918a;

        C15132(FacecastActivity facecastActivity) {
            this.f17918a = facecastActivity;
        }

        public final void m21760a() {
            if (this.f17918a.an != null) {
                this.f17918a.an.f18512e.m22012h();
            }
        }

        public final void m21761a(String[] strArr, String[] strArr2) {
            this.f17918a.setResult(0);
            this.f17918a.finish();
        }

        public final void m21762b() {
            this.f17918a.setResult(0);
            this.f17918a.finish();
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    class C15143 implements Runnable {
        final /* synthetic */ FacecastActivity f17919a;

        C15143(FacecastActivity facecastActivity) {
            this.f17919a = facecastActivity;
        }

        public void run() {
            this.f17919a.am.m22133g();
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    class C15154 implements Runnable {
        final /* synthetic */ FacecastActivity f17920a;

        C15154(FacecastActivity facecastActivity) {
            this.f17920a = facecastActivity;
        }

        public void run() {
            FacecastActivity.m21772A(this.f17920a);
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    class C15165 implements Runnable {
        final /* synthetic */ FacecastActivity f17921a;

        C15165(FacecastActivity facecastActivity) {
            this.f17921a = facecastActivity;
        }

        public void run() {
            this.f17921a.f17961x.g();
            this.f17921a.f17954q.m21963a(this.f17921a.f17959v.f18048b.loggerName, "speed_test_ui_timeout");
            this.f17921a.m21782a(ErrorMessage.SPEEDTEST);
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    public class C15176 {
        final /* synthetic */ FacecastActivity f17922a;

        C15176(FacecastActivity facecastActivity) {
            this.f17922a = facecastActivity;
        }

        public final void m21763a() {
            this.f17922a.setResult(-1);
            this.f17922a.finish();
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    class C15187 implements OnDismissListener {
        final /* synthetic */ FacecastActivity f17923a;

        C15187(FacecastActivity facecastActivity) {
            this.f17923a = facecastActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f17923a.setResult(0);
            if (this.f17923a.an != null) {
                this.f17923a.an.f18512e.m22013i();
            }
            this.f17923a.finish();
        }
    }

    /* compiled from: c7eb9496c4ea761616e01079cfe358f2 */
    enum ErrorMessage {
        INTERNET,
        SPEEDTEST,
        CAMERA
    }

    private static <T extends Context> void m21788a(Class<T> cls, T t) {
        m21789a((Object) t, (Context) t);
    }

    public static void m21789a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FacecastActivity) obj).m21785a((FacecastCameraProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastCameraProvider.class), FacecastAnalyticsLogger.m21959a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FacecastStateManager.m21878a(injectorLike), Toaster.a(injectorLike), LiveStreamer.a(injectorLike), LiveStreamDvrUploader.m21891a(injectorLike), (FacecastCopyrightMonitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastCopyrightMonitorProvider.class), FacecastUtil.m3105a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CommercialBreakMessagePublisher.a(injectorLike), FbNetworkManager.a(injectorLike), CommercialBreakBroadcastStateManager.m22183a(injectorLike), FacecastEndScreenQEHelper.m3060a(injectorLike), FacecastNetworker.m22306a(injectorLike), FacecastPausedNotificationManager.m21872a(injectorLike), FacecastBroadcasterCommercialBreakConfig.m3058a(injectorLike), ScreenUtil.a(injectorLike), PageCommercialBreakEligibilityFetcher.m22229a(injectorLike));
    }

    public static Bundle m21779a(FacecastCompositionData facecastCompositionData, ComposerFacecastInfo composerFacecastInfo, boolean z) {
        Preconditions.checkNotNull(facecastCompositionData);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_composition_data", facecastCompositionData);
        bundle.putParcelable("extra_composer_facecast_info", composerFacecastInfo);
        bundle.putBoolean("extra_composition_editing", z);
        return bundle;
    }

    public static Bundle m21780a(ComposerTargetData composerTargetData) {
        return m21781a(null, composerTargetData);
    }

    public static Bundle m21781a(@Nullable ComposerSourceSurface composerSourceSurface, ComposerTargetData composerTargetData) {
        Builder builder = new Builder();
        builder.f18141c = composerTargetData;
        builder = builder;
        builder.f18149k = composerSourceSurface;
        FacecastCompositionData a = builder.m21945a();
        ComposerFacecastInfo.Builder builder2 = new ComposerFacecastInfo.Builder();
        builder2.c = false;
        return m21779a(a, builder2.a(), true);
    }

    public final void m21818b(Bundle bundle) {
        String str;
        setContentView(2130904186);
        Class cls = FacecastActivity.class;
        m21789a((Object) this, (Context) this);
        this.f17944R = getWindow();
        if (this.f17929A.m3124y()) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        this.f17944R.addFlags(128);
        this.ag = this.f17929A.m3121u();
        this.f17941O = (ViewGroup) a(2131561594);
        this.aa = (FacecastCompositionData) getIntent().getParcelableExtra("extra_composition_data");
        ComposerTargetData composerTargetData = this.aa.f18154c;
        if (composerTargetData == null || composerTargetData.targetType == TargetType.UNDIRECTED) {
            str = null;
        } else {
            str = String.valueOf(composerTargetData.targetId);
        }
        FacecastAnalyticsLogger facecastAnalyticsLogger = this.f17954q;
        TargetType targetType = composerTargetData.targetType;
        facecastAnalyticsLogger.f18177G = targetType == null ? "null" : targetType.toString();
        if (composerTargetData.a()) {
            PageCommercialBreakEligibilityFetcher pageCommercialBreakEligibilityFetcher = this.f17939K;
            String l = Long.toString(composerTargetData.targetId);
            if (pageCommercialBreakEligibilityFetcher.f18640c == null) {
                GraphQlQueryString fetchPageCommercialBreakEligibilityQueryString = new FetchPageCommercialBreakEligibilityQueryString();
                fetchPageCommercialBreakEligibilityQueryString.a("page_id", l);
                pageCommercialBreakEligibilityFetcher.f18640c = pageCommercialBreakEligibilityFetcher.f18639b.a(GraphQLRequest.a(fetchPageCommercialBreakEligibilityQueryString));
                Futures.a(pageCommercialBreakEligibilityFetcher.f18640c, new C16091(pageCommercialBreakEligibilityFetcher, this));
            }
        }
        ComposerFacecastInfo composerFacecastInfo = (ComposerFacecastInfo) getIntent().getParcelableExtra("extra_composer_facecast_info");
        this.f17961x.a(str);
        if (!(composerFacecastInfo == null || composerFacecastInfo.videoBroadcastInitResponse == null)) {
            this.f17942P = composerFacecastInfo.videoBroadcastInitResponse;
            this.f17950X = true;
            this.f17949W = true;
            this.f17954q.f18176F = this.f17942P.broadcastId;
        }
        int i = (composerFacecastInfo == null || composerFacecastInfo.facecastCameraIndex == -1) ? 1 : composerFacecastInfo.facecastCameraIndex;
        this.ab = this.f17953p.m21853a(i);
        this.ab.m21849a((CameraHandlerDelegate) this);
        this.ab.m21848a(this.f17961x.l());
        this.f17959v.m21882a((FacecastStateChangeListener) this);
        FacecastStateManager facecastStateManager = this.f17959v;
        FacecastBroadcastState facecastBroadcastState = FacecastBroadcastState.FACECAST_BROADCAST_STATE_STARTING;
        facecastStateManager.f18048b = FacecastBroadcastState.FACECAST_BROADCAST_STATE_UNINITIALIZED;
        facecastStateManager.f18049c = FacecastBroadcastState.FACECAST_BROADCAST_STATE_UNINITIALIZED;
        facecastStateManager.m21883b(facecastBroadcastState);
        if (Camera.getNumberOfCameras() > 1) {
            this.am = new FacecastRotateCameraPlugin(this);
            this.am.setCorner(Corner.TOP_RIGHT);
            m21786a(this.am);
            this.am.setOnClickListener(this);
        }
        this.f17945S = this.f17958u.a();
        this.f17954q.f18178H = this.aa.f18162k;
        this.ae = this.f17929A.f2822a.a(578, false);
        this.af = new C15121(this);
        this.f17933E.m22186a((CommercialBreakBroadcastStateChangeListener) this);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -88033328);
        this.al = new CountDownLatch(1);
        super.onResume();
        this.f17936H.m21874b();
        for (FacecastBasePlugin e : this.f17940N) {
            e.mo1419e();
        }
        if (this.f17956s.a(this).a(f17928M)) {
            if (this.f17933E.m22187b() != CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PLAYING) {
                m21805z();
            }
            if (this.f17933E.m22187b() == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_INTERRUPTED) {
                this.f17933E.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PLAYING);
            }
            this.ab.m21847a(2, Integer.valueOf(m21799t()));
        } else {
            this.al.countDown();
            m21798s();
        }
        try {
            this.al.await(2, TimeUnit.SECONDS);
            this.al = null;
        } catch (Throwable e2) {
            BLog.b(f17927L, "onResume potentially stuck", e2);
            this.al = null;
        } catch (Throwable th) {
            this.al = null;
            LogUtils.c(-106742764, a);
        }
        HandlerDetour.a(this.f17955r, this.af, 2132034339);
        LogUtils.c(536384485, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.at != null && this.f17929A.m3124y()) {
            PreviewRenderer previewRenderer = this.at.f18462l;
            previewRenderer.f18081b.sendMessageAtFrontOfQueue(previewRenderer.f18081b.obtainMessage(15));
        }
    }

    private void m21798s() {
        this.f17956s.a(this).a(f17928M, getString(2131238254), getString(2131238255), new C15132(this));
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 353803601);
        this.ak = new CountDownLatch(1);
        super.onPause();
        for (FacecastBasePlugin d : this.f17940N) {
            d.mo1413d();
        }
        if (m21776E()) {
            this.f17959v.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_INTERRUPTED);
        }
        CommercialBreakBroadcastState b = this.f17933E.m22187b();
        switch (b) {
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
                this.f17933E.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_ELIGIBLE);
                break;
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                this.f17933E.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_INTERRUPTED);
                break;
        }
        if (b != CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PLAYING) {
            this.f17961x.k();
            this.ab.m21847a(1, null);
        }
        try {
            this.ak.await(2, TimeUnit.SECONDS);
            this.ak = null;
        } catch (Throwable e) {
            BLog.b(f17927L, "On pause potentially stuck", e);
            this.ak = null;
        } catch (Throwable th) {
            this.ak = null;
            LogUtils.c(-1359003708, a);
        }
        HandlerDetour.a(this.f17955r, this.af);
        LogUtils.c(7446413, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1711615020);
        super.onDestroy();
        for (FacecastBasePlugin c : this.f17940N) {
            c.m21950c();
        }
        this.f17955r.removeCallbacksAndMessages(null);
        this.f17940N.clear();
        this.f17959v.f18050d.clear();
        this.f17961x.i();
        this.f17961x.m = null;
        this.f17961x.l = null;
        this.ab.m21849a(null);
        this.f17933E.f18569a.clear();
        CommercialBreakBroadcastStateManager commercialBreakBroadcastStateManager = this.f17933E;
        commercialBreakBroadcastStateManager.f18571c = CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED;
        commercialBreakBroadcastStateManager.f18570b = CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED;
        this.f17936H.m21874b();
        LogUtils.c(201602232, a);
    }

    public void onBackPressed() {
        int i;
        for (FacecastBasePlugin a : this.f17940N) {
            if (a.mo1409a()) {
                return;
            }
        }
        if (this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_FINISHED) {
            i = -1;
        } else {
            i = 0;
        }
        setResult(i);
        super.onBackPressed();
    }

    @TargetApi(3)
    public final void q_(int i) {
        if (this.at != null) {
            this.at.m22107a(i, this.f17942P != null ? this.f17942P.clientRenderingDurationMs : 0);
        }
    }

    public final void mo1393p() {
        this.ab.m21847a(3, null);
    }

    public final void mo1394q() {
        setResult(-1);
        finish();
    }

    public final void mo1390m() {
        if (this.at != null) {
            this.at.m22113h();
        }
    }

    public final void mo1391n() {
        if (this.at != null) {
            this.at.m22109a(this.ab);
            ComposerFacecastInfo composerFacecastInfo = (ComposerFacecastInfo) getIntent().getParcelableExtra("extra_composer_facecast_info");
            if (composerFacecastInfo != null) {
                FacecastPreviewPlugin facecastPreviewPlugin = this.at;
                int i = composerFacecastInfo.facecastCameraZoomLevel;
                if (facecastPreviewPlugin.f18463m != null && facecastPreviewPlugin.f18463m.m21852g() && facecastPreviewPlugin.f18463m.m21850d()) {
                    facecastPreviewPlugin.f18463m.m21847a(4, Integer.valueOf(i));
                }
            }
        }
    }

    public final void mo1392o() {
        if (this.at != null) {
            this.at.m22112b(this.ab);
        }
        if (this.am != null) {
            HandlerDetour.a(this.f17955r, new C15143(this), 1664078374);
        }
    }

    public final void mo1387a(Exception exception) {
        this.f17959v.m21881a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FAILED, "Camera open failed", new LiveStreamingError(exception));
        m21782a(ErrorMessage.CAMERA);
    }

    private void m21785a(FacecastCameraProvider facecastCameraProvider, FacecastAnalyticsLogger facecastAnalyticsLogger, Handler handler, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, MonotonicClock monotonicClock, Clock clock, FacecastStateManager facecastStateManager, Toaster toaster, LiveStreamer liveStreamer, LiveStreamDvrUploader liveStreamDvrUploader, FacecastCopyrightMonitorProvider facecastCopyrightMonitorProvider, FacecastUtil facecastUtil, QeAccessor qeAccessor, CommercialBreakMessagePublisher commercialBreakMessagePublisher, FbNetworkManager fbNetworkManager, CommercialBreakBroadcastStateManager commercialBreakBroadcastStateManager, FacecastEndScreenQEHelper facecastEndScreenQEHelper, FacecastNetworker facecastNetworker, FacecastPausedNotificationManager facecastPausedNotificationManager, FacecastBroadcasterCommercialBreakConfig facecastBroadcasterCommercialBreakConfig, ScreenUtil screenUtil, PageCommercialBreakEligibilityFetcher pageCommercialBreakEligibilityFetcher) {
        this.f17953p = facecastCameraProvider;
        this.f17954q = facecastAnalyticsLogger;
        this.f17955r = handler;
        this.f17956s = activityRuntimePermissionsManagerProvider;
        this.f17957t = monotonicClock;
        this.f17958u = clock;
        this.f17959v = facecastStateManager;
        this.f17960w = toaster;
        this.f17961x = liveStreamer;
        this.f17962y = liveStreamDvrUploader;
        this.f17963z = facecastCopyrightMonitorProvider;
        this.f17929A = facecastUtil;
        this.f17930B = qeAccessor;
        this.f17931C = commercialBreakMessagePublisher;
        this.f17932D = fbNetworkManager;
        this.f17933E = commercialBreakBroadcastStateManager;
        this.f17934F = facecastEndScreenQEHelper;
        this.f17935G = facecastNetworker;
        this.f17936H = facecastPausedNotificationManager;
        this.f17937I = facecastBroadcasterCommercialBreakConfig;
        this.f17938J = screenUtil;
        this.f17939K = pageCommercialBreakEligibilityFetcher;
    }

    public final void m21808a(SurfaceTexture surfaceTexture) {
        if (this.al != null) {
            this.al.countDown();
        }
        if (surfaceTexture != null) {
            this.ab.m21847a(0, (Object) surfaceTexture);
            this.f17948V = true;
            HandlerDetour.a(this.f17955r, new C15154(this), 1481978354);
        }
    }

    public final List<LiveStreamEncoderSurface> m21828j() {
        LiveStreamer liveStreamer = this.f17961x;
        ArrayList arrayList = new ArrayList();
        if (liveStreamer.C.o != null) {
            arrayList.add(liveStreamer.C.o);
            if (liveStreamer.u && liveStreamer.D != null) {
                arrayList.add(liveStreamer.D.o);
            }
        }
        return arrayList;
    }

    public final void m21817b() {
        this.f17948V = false;
        this.f17961x.f();
    }

    private int m21799t() {
        return getWindowManager().getDefaultDisplay().getRotation();
    }

    public final int m21821c() {
        return m21799t();
    }

    public final void m21829k() {
        this.f17961x.f();
    }

    public final void m21830l() {
        if (m21776E() || this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE) {
            LiveStreamer liveStreamer = this.f17961x;
            liveStreamer.g.sendMessageAtFrontOfQueue(liveStreamer.g.obtainMessage(1));
        }
    }

    public final void m21806a() {
        if ((this.f17961x.b() && m21776E()) || this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE) {
            LiveStreamer liveStreamer = this.f17961x;
            liveStreamer.g.sendMessageAtFrontOfQueue(liveStreamer.g.obtainMessage(3));
        }
    }

    public final void m21824f() {
        if (this.at != null) {
            this.at.f18462l.mo1402b();
        }
    }

    public final void m21825g() {
        if (this.at != null) {
            FacecastPreviewPlugin facecastPreviewPlugin = this.at;
            facecastPreviewPlugin.f18462l.mo1401a(EncoderSurfaceType.LIVE_STREAM);
        }
    }

    public final void m21826h() {
        if (this.f17935G == null) {
            BLog.a(f17927L, "mFacecastNetworker is null. Unable to send seal request");
        } else if (this.f17942P != null) {
            FacecastNetworker facecastNetworker = this.f17935G;
            Parcelable videoBroadcastSealRequest = new VideoBroadcastSealRequest(this.f17942P.broadcastId);
            Bundle bundle = new Bundle();
            bundle.putParcelable("video_broadcast_seal_key", videoBroadcastSealRequest);
            BlueServiceOperationFactoryDetour.a(facecastNetworker.f18762a, "video_broadcast_seal_type", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacecastNetworker.class), 2096875608).a();
            this.f17954q.m21964a(null, FacecastBroadcastState.FACECAST_BROADCAST_STATE_SEAL_BROADCAST_REQUEST.loggerName, "Seal Broadcast Request", null, this.f17961x.s());
        } else {
            BLog.a(f17927L, "mVideoBroadcastInitResponse is null Unable to send seal request ");
        }
        if (this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_FINISHED) {
            this.f17959v.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_SHOW_END_SCREEN);
        }
    }

    public final void m21807a(long j) {
        if (m21776E()) {
            this.f17946T = j;
            if (this.ao != null) {
                FacecastRecordingAggregatePlugin facecastRecordingAggregatePlugin = this.ao;
                facecastRecordingAggregatePlugin.f18477A = j;
                if (facecastRecordingAggregatePlugin.f18502y) {
                    FacecastLiveVideoStatusPlugin facecastLiveVideoStatusPlugin = facecastRecordingAggregatePlugin.f18489l;
                    facecastLiveVideoStatusPlugin.f18442f.m22076a(j);
                    facecastLiveVideoStatusPlugin.f18440d.setTimeElapsed(j);
                } else {
                    FacecastLiveStatusPlugin facecastLiveStatusPlugin = facecastRecordingAggregatePlugin.f18488k;
                    facecastLiveStatusPlugin.f18433f.m22076a(j);
                    facecastLiveStatusPlugin.f18432e.setTimeElapsed(j);
                }
                if (facecastRecordingAggregatePlugin.f18492o != null) {
                    facecastRecordingAggregatePlugin.f18486i.f18575c = j;
                    if (facecastRecordingAggregatePlugin.f18492o.m22200a(facecastRecordingAggregatePlugin.f18477A, facecastRecordingAggregatePlugin.f18478B) == CommercialBreakEligibility.ELIGIBLE) {
                        CommercialBreakBroadcastState commercialBreakBroadcastState = facecastRecordingAggregatePlugin.f18483f.f18570b;
                        if (commercialBreakBroadcastState == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED || commercialBreakBroadcastState == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_FINISH) {
                            facecastRecordingAggregatePlugin.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_ELIGIBLE);
                            facecastRecordingAggregatePlugin.f18486i.m22192b();
                        }
                    }
                }
                facecastRecordingAggregatePlugin.f18487j.f18216h.setTimeElapsed(j);
                if (this.f17946T - this.f17947U > 1000) {
                    this.f17947U = this.f17946T;
                    if (!this.ae) {
                        if (this.f17961x.p()) {
                            this.ao.setWeakConnection(true);
                        }
                        if (this.f17961x.q()) {
                            this.ao.setWeakConnection(false);
                        }
                    }
                }
            }
        }
    }

    public final void m21815a(VideoBroadcastInitResponse videoBroadcastInitResponse) {
        this.f17942P = videoBroadcastInitResponse;
        this.f17951Y = new C15165(this);
        HandlerDetour.b(this.f17955r, this.f17951Y, videoBroadcastInitResponse.speedTestTimeoutSeconds * 1000, 1344567842);
        this.f17954q.f18176F = videoBroadcastInitResponse.broadcastId;
        this.f17949W = true;
        m21772A(this);
    }

    public final void mo1388b(boolean z) {
        if (z) {
            m21772A(this);
            return;
        }
        this.f17959v.m21880a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FAILED, "Failed to fetch user privacy");
        m21782a(ErrorMessage.INTERNET);
    }

    public final void mo1396r() {
        this.ag = !this.ag;
        if (this.at != null) {
            this.at.f18460j.setFullScreen(this.ag);
            FacecastPreviewPlugin facecastPreviewPlugin = this.at;
            float F = m21777F();
            PreviewRenderer previewRenderer = facecastPreviewPlugin.f18462l;
            previewRenderer.f18081b.sendMessageAtFrontOfQueue(previewRenderer.f18081b.obtainMessage(16, Float.valueOf(F)));
        }
        if (this.an != null) {
            this.an.setFullscreen(this.ag);
        }
    }

    public final void m21812a(@Nullable ApiErrorResult apiErrorResult) {
        this.f17943Q = apiErrorResult;
        this.f17959v.m21880a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FAILED, "fetch_broadcast_id_failed");
        m21782a(ErrorMessage.INTERNET);
    }

    public final void hx_() {
        m21773B();
        m21772A(this);
    }

    public final void m21814a(NetworkSpeedTest networkSpeedTest) {
        m21773B();
        if (networkSpeedTest.state == Status.Succeeded && networkSpeedTest.speedTestPassesThreshold) {
            m21772A(this);
        } else if (networkSpeedTest.state != Status.Canceled) {
            this.f17954q.m21963a(this.f17959v.f18048b.loggerName, "speed_test_failed");
            m21782a(ErrorMessage.SPEEDTEST);
        }
    }

    public final void m21813a(LiveStreamingError liveStreamingError) {
        if (!this.ae && m21776E()) {
            m21803x();
            this.f17959v.m21881a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE, "lost_connection", liveStreamingError);
        }
    }

    public final void m21823e() {
        if (!this.ae && this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE) {
            this.f17959v.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING);
        }
    }

    public final void m21819b(LiveStreamingError liveStreamingError) {
        this.f17960w.a(new ToastBuilder(2131238256));
        this.f17959v.m21881a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FAILED, "broadcast_session_failed", liveStreamingError);
        setResult(0);
        finish();
    }

    public final Map<String, String> m21827i() {
        if (this.ao != null) {
            return this.ao.getLoggingInfo();
        }
        return null;
    }

    public final void mo1385a(FacecastBroadcastState facecastBroadcastState, FacecastBroadcastState facecastBroadcastState2) {
        switch (facecastBroadcastState2) {
            case FACECAST_BROADCAST_STATE_STARTING:
                Preconditions.checkNotNull(this.an);
                if (facecastBroadcastState == FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING) {
                    this.an.m22143h();
                    this.ah = m21790a(this.an.f18518k);
                    this.an.m22137a(this.f17942P.broadcastId, this.ah);
                    this.aa = this.an.getFacecastCompositionData();
                }
                m21794b(this.an);
                this.an = null;
                break;
            case FACECAST_BROADCAST_STATE_RECORDING:
                Preconditions.checkNotNull(this.ao);
                this.ao.m22130g();
                if (this.ad != null) {
                    this.ad.m21858b();
                    break;
                }
                break;
            case FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH:
                Preconditions.checkNotNull(this.ap);
                m21794b(this.ap);
                break;
            case FACECAST_BROADCAST_STATE_FINISHED:
                Preconditions.checkNotNull(this.aw);
                m21794b(this.aw);
                break;
            case FACECAST_BROADCAST_STATE_INTERRUPTED:
                Preconditions.checkNotNull(this.as);
                m21794b(this.as);
                break;
            case FACECAST_BROADCAST_STATE_COPYRIGHT_VIOLATION:
                Preconditions.checkNotNull(this.av);
                m21794b(this.av);
                break;
            case FACECAST_BROADCAST_STATE_NETWORK_FAILURE:
                Preconditions.checkNotNull(this.au);
                m21794b(this.au);
                break;
        }
        switch (facecastBroadcastState) {
            case FACECAST_BROADCAST_STATE_STARTING:
                Preconditions.checkArgument(this.an == null);
                this.an = new FacecastStartingAggregatePlugin(this);
                this.an.m22136a(this.aa, getIntent().getBooleanExtra("extra_composition_editing", true), this.ag, this);
                m21786a(this.an);
                return;
            case FACECAST_BROADCAST_STATE_RECORDING:
                this.f17961x.a(m21777F());
                if (this.ao == null) {
                    this.ao = new FacecastRecordingAggregatePlugin(new ContextThemeWrapper(this, this.ag ? FacecastUiUtil.m3104b() : FacecastUiUtil.m3097a()));
                    this.ao.m22127a(this.f17942P.videoId, this.f17942P.minBroadcastDurationSeconds, this.f17942P.maxBroadcastDurationSeconds, this.aa.m21946c(), this.at, this.ag, m21777F(), this.ah);
                    if (this.f17930B.a(ExperimentsForFacecastAbtestModule.f2781b, false)) {
                        this.f17931C.d = this.f17942P.videoId;
                    }
                    m21786a(this.ao);
                }
                this.ao.m22131h();
                m21774C();
                return;
            case FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH:
                if (this.f17961x.b()) {
                    m21803x();
                }
                if (this.ap == null) {
                    this.ap = new FacecastEndingCountdownPlugin(this);
                }
                m21786a(this.ap);
                return;
            case FACECAST_BROADCAST_STATE_FINISHED:
                if (this.f17961x.b()) {
                    m21803x();
                }
                if (this.aw == null) {
                    this.aw = new FacecastEndingBlankScreenPlugin(this);
                }
                m21786a(this.aw);
                this.f17961x.i();
                if (this.ad != null) {
                    this.ad.m21859c();
                    return;
                }
                return;
            case FACECAST_BROADCAST_STATE_INTERRUPTED:
                if (this.as == null) {
                    this.as = new FacecastPausedPlugin(this);
                }
                m21786a(this.as);
                this.f17936H.m21873a();
                return;
            case FACECAST_BROADCAST_STATE_COPYRIGHT_VIOLATION:
                if (this.f17961x.b()) {
                    m21803x();
                }
                if (this.av == null) {
                    this.av = new FacecastCopyrightViolationPlugin(this);
                    this.av.setViolationText(this.ac);
                    this.av.f18239e = this.f17942P.broadcastId;
                }
                if (this.ad != null) {
                    this.ad.m21859c();
                    this.ad = null;
                }
                m21786a(this.av);
                return;
            case FACECAST_BROADCAST_STATE_NETWORK_FAILURE:
                if (this.au == null) {
                    this.au = new FacecastReconnectingPlugin(this);
                }
                m21803x();
                m21786a(this.au);
                return;
            case FACECAST_BROADCAST_STATE_SHOW_END_SCREEN:
                m21800u();
                return;
            default:
                return;
        }
    }

    public final void mo1389c(boolean z) {
        this.ai = z;
        this.aj = true;
        m21772A(this);
    }

    private void m21800u() {
        this.f17944R.clearFlags(128);
        if (this.f17934F.f2806a.a(ExperimentsForFacecastAbtestModule.f2795p, false)) {
            m21802w();
        } else {
            m21801v();
        }
    }

    private void m21801v() {
        int i;
        if (this.ao == null) {
            i = 0;
        } else {
            int i2;
            FacecastRecordingAggregatePlugin facecastRecordingAggregatePlugin = this.ao;
            if (facecastRecordingAggregatePlugin.f18502y) {
                i2 = facecastRecordingAggregatePlugin.f18489l.f18440d.f18984l;
            } else {
                i2 = facecastRecordingAggregatePlugin.f18488k.f18432e.f18933i;
            }
            i = i2;
        }
        if (this.aq == null) {
            FacecastEndScreenBasePlugin facecastTipJarEndScreenPlugin;
            if (this.f17930B.a(ExperimentsForFacecastAbtestModule.f2785f, false)) {
                facecastTipJarEndScreenPlugin = new FacecastTipJarEndScreenPlugin(this);
            } else {
                facecastTipJarEndScreenPlugin = new FacecastEndScreenPlugin(this);
            }
            this.aq = facecastTipJarEndScreenPlugin;
            this.aq.f18312r = this;
        }
        this.aq.mo1440a(this.f17945S, this.f17946T, this.f17942P.broadcastId, this.f17942P.videoId, this.aa.f18154c, i);
        m21786a(this.aq);
    }

    private void m21802w() {
        if (this.ar == null) {
            this.ar = new FacecastEndScreenV2Plugin(this);
        }
        this.ar.f18362A = new C15176(this);
        this.ar.m22065a(this.f17945S, this.f17946T, this.f17942P.broadcastId, this.f17942P.videoId, this.aa.f18154c, this.aa.f18153b);
        m21786a(this.ar);
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        switch (commercialBreakBroadcastState2) {
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
                if (commercialBreakBroadcastState != CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_ELIGIBLE) {
                    m21803x();
                    break;
                }
                break;
        }
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                this.f17931C.a(this.f17946T, (long) this.f17937I.f2803e);
                if (this.am != null) {
                    this.am.f18508d.setVisibility(4);
                    return;
                }
                return;
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                if (this.f17959v.f18048b != FacecastBroadcastState.FACECAST_BROADCAST_STATE_INTERRUPTED) {
                    m21805z();
                    this.f17961x.a(m21777F());
                }
                if (this.am != null) {
                    this.am.f18508d.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m21803x() {
        this.f17961x.k();
        this.at.f18462l.mo1403c();
    }

    public final void mo1384a(CopyrightViolationInfo copyrightViolationInfo) {
        if (this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING) {
            this.ac = copyrightViolationInfo;
            this.f17959v.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_COPYRIGHT_VIOLATION);
        }
    }

    private void m21804y() {
        this.f17961x.l = this;
        if (this.f17942P == null) {
            this.f17961x.a();
            this.f17961x.m = this;
            this.f17961x.h();
        }
    }

    private void m21805z() {
        if (this.at == null) {
            this.at = new FacecastPreviewPlugin(this);
            this.at.f18460j.setFullScreen(this.ag);
            this.at.m22111a(this, this, m21777F());
            this.at.m22108a(this.f17961x.l());
            m21787a(this.at, 0);
            m21804y();
        }
    }

    private void m21786a(FacecastBasePlugin facecastBasePlugin) {
        m21787a(facecastBasePlugin, -1);
    }

    private void m21787a(FacecastBasePlugin facecastBasePlugin, int i) {
        facecastBasePlugin.m21948a(this.f17941O, this.f17959v, i);
        this.f17940N.add(0, facecastBasePlugin);
    }

    private void m21794b(FacecastBasePlugin facecastBasePlugin) {
        this.f17940N.remove(facecastBasePlugin);
        facecastBasePlugin.m21950c();
    }

    public static void m21772A(FacecastActivity facecastActivity) {
        if (facecastActivity.f17949W && facecastActivity.f17948V && facecastActivity.f17950X && facecastActivity.an != null) {
            Object obj;
            FacecastStartingAggregatePlugin facecastStartingAggregatePlugin = facecastActivity.an;
            if (facecastStartingAggregatePlugin.f18512e != null) {
                Object obj2;
                FacecastEditTitlePlugin facecastEditTitlePlugin = facecastStartingAggregatePlugin.f18512e;
                if (facecastEditTitlePlugin.f18274t == null && facecastEditTitlePlugin.f18275u == null) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    obj = 1;
                    if (obj != null && facecastActivity.m21778G()) {
                        facecastStartingAggregatePlugin = facecastActivity.an;
                        if (facecastStartingAggregatePlugin.f18519l) {
                            FacecastGoLiveButtonPlugin facecastGoLiveButtonPlugin = facecastStartingAggregatePlugin.f18513f;
                            if (!facecastGoLiveButtonPlugin.f18425f) {
                                facecastGoLiveButtonPlugin.f18424e.end();
                                facecastGoLiveButtonPlugin.f18423d.setBackgroundResource(2130839610);
                                facecastGoLiveButtonPlugin.f18423d.setTextColor(ContextCompat.b(facecastGoLiveButtonPlugin.getContext(), 2131361920));
                                facecastGoLiveButtonPlugin.f18423d.setText(facecastGoLiveButtonPlugin.getResources().getString(2131238228));
                                facecastGoLiveButtonPlugin.f18425f = true;
                            }
                            return;
                        }
                        FacecastStartingAggregatePlugin.m22135l(facecastStartingAggregatePlugin);
                        return;
                    }
                }
            }
            obj = null;
            if (obj != null) {
            }
        }
    }

    private void m21782a(ErrorMessage errorMessage) {
        if (!isFinishing() && !isDestroyed() && this.f17952Z == null) {
            AlertDialog.Builder a = new AlertDialog.Builder(this).a(true).a(2131230726, null).a(new C15187(this));
            if (errorMessage != ErrorMessage.INTERNET || this.f17943Q == null) {
                int i;
                a.a(2131238251);
                switch (errorMessage) {
                    case INTERNET:
                        i = 2131238252;
                        break;
                    case SPEEDTEST:
                        i = 2131238253;
                        break;
                    case CAMERA:
                        i = 2131234296;
                        break;
                    default:
                        BLog.b(f17927L, "Invalid error message.");
                        return;
                }
                this.f17952Z = a.b(i).b();
                return;
            }
            this.f17952Z = a.a(this.f17943Q.mErrorUserTitle).b(this.f17943Q.mErrorUserMessage).b();
        }
    }

    private void m21773B() {
        HandlerDetour.a(this.f17955r, this.f17951Y);
        this.f17950X = true;
    }

    private void m21774C() {
        if (this.f17929A.f2822a.a(580, false) && this.f17942P != null && this.ac == null) {
            if (this.ad == null) {
                this.ad = this.f17963z.m21860a(this.f17942P.videoId, this);
            }
            this.ad.m21857a();
        }
    }

    public static void m21775D(FacecastActivity facecastActivity) {
        if (facecastActivity.ae) {
            int i;
            LiveStreamer liveStreamer = facecastActivity.f17961x;
            if (liveStreamer.p == null) {
                i = -1;
            } else {
                i = liveStreamer.p.getCurrentNetworkState();
            }
            LiveStreamingNetworkState fromInteger = LiveStreamingNetworkState.fromInteger(i);
            if (!facecastActivity.f17932D.d() && facecastActivity.m21776E()) {
                facecastActivity.f17959v.m21880a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE, "lost_connection");
            } else if (facecastActivity.m21776E() && fromInteger == LiveStreamingNetworkState.SHOULD_STOP_STREAMING) {
                facecastActivity.f17959v.m21880a(FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE, "network_lagging");
            } else if (facecastActivity.m21776E() && fromInteger == LiveStreamingNetworkState.WEAK) {
                facecastActivity.ao.setWeakConnection(true);
            } else if (facecastActivity.m21776E() && fromInteger == LiveStreamingNetworkState.NORMAL) {
                facecastActivity.ao.setWeakConnection(false);
            } else if (facecastActivity.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE && facecastActivity.f17932D.d() && fromInteger == LiveStreamingNetworkState.NORMAL) {
                facecastActivity.f17959v.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING);
            } else if (facecastActivity.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_NETWORK_FAILURE && facecastActivity.f17932D.d() && fromInteger == LiveStreamingNetworkState.WEAK) {
                facecastActivity.f17959v.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING);
                facecastActivity.ao.setWeakConnection(true);
            }
            HandlerDetour.b(facecastActivity.f17955r, facecastActivity.af, 1000, 1482736507);
        }
    }

    private boolean m21776E() {
        return this.f17959v.f18048b == FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING;
    }

    private float m21777F() {
        if (this.ag) {
            return ((float) this.f17938J.c()) / ((float) this.f17938J.d());
        }
        return 1.0f;
    }

    private boolean m21790a(FacecastCompositionData facecastCompositionData) {
        if (facecastCompositionData.f18154c != null && facecastCompositionData.f18154c.a()) {
            return this.ai;
        }
        boolean z = this.f17937I.f2804f && !m21792a(facecastCompositionData.f18153b);
        if (!this.f17937I.f2799a || z) {
            return false;
        }
        return true;
    }

    private static boolean m21792a(SelectablePrivacyData selectablePrivacyData) {
        if (selectablePrivacyData == null || selectablePrivacyData.d == null || selectablePrivacyData.d.n() == null) {
            return false;
        }
        GraphQLPrivacyRowInput n = selectablePrivacyData.d.n();
        if (m21791a(n) || m21795b(n)) {
            return true;
        }
        return false;
    }

    private static boolean m21791a(GraphQLPrivacyRowInput graphQLPrivacyRowInput) {
        return graphQLPrivacyRowInput.j() == GraphQLPrivacyBaseState.SELF && graphQLPrivacyRowInput.a() != null && graphQLPrivacyRowInput.a().size() == 1 && ((String) graphQLPrivacyRowInput.a().get(0)).equals("114000975315193");
    }

    private static boolean m21795b(GraphQLPrivacyRowInput graphQLPrivacyRowInput) {
        return graphQLPrivacyRowInput.j() == GraphQLPrivacyBaseState.SELF && graphQLPrivacyRowInput.a() != null && graphQLPrivacyRowInput.a().isEmpty();
    }

    private boolean m21778G() {
        if (this.aa.f18154c == null || !this.aa.f18154c.a()) {
            return true;
        }
        return this.aj;
    }
}
