package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.AndroidReachabilityListener;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.composer.facecast.feedattachment.FacecastComposerStateController.2;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.rtmpssl.AndroidRtmpSSLFactoryHolder;
import com.facebook.video.videostreaming.protocol.VideoBroadcastDiskRecordingConfig;
import com.facebook.video.videostreaming.protocol.VideoBroadcastInitMethod;
import com.facebook.video.videostreaming.protocol.VideoBroadcastInitResponse;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
@TargetApi(18)
/* compiled from: saved_video_download_state */
public class LiveStreamer {
    private static volatile LiveStreamer f5307G;
    protected static final String f5308a = LiveStreamer.class.getName();
    private final AndroidRtmpSSLFactoryHolder f5309A;
    private final AbstractFbErrorReporter f5310B;
    public LiveStreamingEncoder f5311C;
    public LiveStreamingEncoder f5312D;
    public LiveStreamingMuxer f5313E;
    private LiveStreamingMetrics f5314F;
    public final MonotonicClock f5315b;
    private final LiveStreamingAudioRecorder f5316c;
    public volatile VideoBroadcastInitResponse f5317d;
    public volatile ApiErrorResult f5318e;
    public STREAMING_STATE f5319f = STREAMING_STATE.STREAMING_OFF;
    public final Handler f5320g;
    private final HandlerThread f5321h;
    public final ExecutorService f5322i;
    private final DefaultXAnalyticsProvider f5323j;
    private final Map<String, String> f5324k;
    public volatile LiveStreamerStreamingListener f5325l;
    public volatile LiveStreamerPrefetchingListener f5326m;
    public volatile 2 f5327n;
    private final AndroidReachabilityListener f5328o;
    public AndroidLiveStreamingSession f5329p;
    private String f5330q;
    private final AbstractSingleMethodRunner f5331r;
    private String f5332s;
    public boolean f5333t = false;
    public boolean f5334u = false;
    private VideoBroadcastInitMethod f5335v;
    public Handler f5336w;
    public final SkywalkerSubscriptionConnector f5337x;
    public final ObjectMapper f5338y;
    public final GatekeeperStoreImpl f5339z;

    /* compiled from: saved_video_download_state */
    public class C03191 implements Runnable {
        final /* synthetic */ LiveStreamer f5292a;

        public C03191(LiveStreamer liveStreamer) {
            this.f5292a = liveStreamer;
        }

        public void run() {
            if (this.f5292a.f5325l != null) {
                this.f5292a.f5325l.m8022e();
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public class C03202 implements Runnable {
        final /* synthetic */ LiveStreamer f5293a;

        public C03202(LiveStreamer liveStreamer) {
            this.f5293a = liveStreamer;
        }

        public void run() {
            if (this.f5293a.f5326m != null) {
                this.f5293a.f5326m.hx_();
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public class C03213 implements Runnable {
        final /* synthetic */ NetworkSpeedTest f5294a;
        final /* synthetic */ LiveStreamer f5295b;

        public C03213(LiveStreamer liveStreamer, NetworkSpeedTest networkSpeedTest) {
            this.f5295b = liveStreamer;
            this.f5294a = networkSpeedTest;
        }

        public void run() {
            if (this.f5295b.f5326m != null) {
                this.f5295b.f5326m.m8017a(this.f5294a);
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public class C03224 implements Runnable {
        final /* synthetic */ LiveStreamingError f5296a;
        final /* synthetic */ LiveStreamer f5297b;

        public C03224(LiveStreamer liveStreamer, LiveStreamingError liveStreamingError) {
            this.f5297b = liveStreamer;
            this.f5296a = liveStreamingError;
        }

        public void run() {
            if (this.f5297b.f5325l != null) {
                this.f5297b.f5325l.m8021b(this.f5296a);
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public class C03246 implements Runnable {
        final /* synthetic */ LiveStreamer f5300a;

        public C03246(LiveStreamer liveStreamer) {
            this.f5300a = liveStreamer;
        }

        public void run() {
            LiveStreamer liveStreamer = this.f5300a;
            boolean A = LiveStreamer.m8027A(this.f5300a);
            if (liveStreamer.f5326m != null) {
                HandlerDetour.a(liveStreamer.f5336w, new C03257(liveStreamer, A), 1441024956);
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public class C03257 implements Runnable {
        final /* synthetic */ boolean f5301a;
        final /* synthetic */ LiveStreamer f5302b;

        public C03257(LiveStreamer liveStreamer, boolean z) {
            this.f5302b = liveStreamer;
            this.f5301a = z;
        }

        public void run() {
            if (this.f5302b.f5326m != null) {
                if (this.f5301a) {
                    this.f5302b.f5326m.m8018a(this.f5302b.f5317d);
                } else {
                    this.f5302b.f5326m.m8016a(this.f5302b.f5318e);
                }
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public class C03279 implements LiveStreamingEncoderOutputConsumer {
        final /* synthetic */ LiveStreamer f5305a;

        public C03279(LiveStreamer liveStreamer) {
            this.f5305a = liveStreamer;
        }

        public final void mo361a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, BufferInfo bufferInfo) {
            if (this.f5305a.f5334u) {
                this.f5305a.f5313E.m8083a(byteBuffer, i, i2, i3, i5, i6, bufferInfo);
            }
            this.f5305a.f5329p.sendAudioData(byteBuffer, i, i2, i3, i4, i5);
            this.f5305a.m8044a((long) i4);
        }

        public final void mo362b(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, BufferInfo bufferInfo) {
            this.f5305a.f5329p.sendVideoData(byteBuffer, i, i2, i3, i4, i5);
        }
    }

    /* compiled from: saved_video_download_state */
    class LiveStreamerHandler extends Handler {
        final /* synthetic */ LiveStreamer f5306a;

        LiveStreamerHandler(LiveStreamer liveStreamer, Looper looper) {
            this.f5306a = liveStreamer;
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            LiveStreamer liveStreamer;
            switch (i) {
                case 0:
                    liveStreamer = this.f5306a;
                    Preconditions.checkArgument(liveStreamer.f5333t, "videoTargetId wasn't set");
                    ExecutorDetour.a(liveStreamer.f5322i, new C03246(liveStreamer), 951713312);
                    return;
                case 1:
                    LiveStreamer.m8039x(this.f5306a);
                    return;
                case 2:
                    LiveStreamer.m8036u(this.f5306a);
                    return;
                case 3:
                    liveStreamer = this.f5306a;
                    if (liveStreamer.f5319f == STREAMING_STATE.STREAMING_STARTED) {
                        liveStreamer.f5311C.m8076h();
                        if (liveStreamer.f5334u && liveStreamer.f5312D != null) {
                            liveStreamer.f5312D.m8076h();
                        }
                    }
                    return;
                case 4:
                    LiveStreamer.m8036u(this.f5306a);
                    LiveStreamer.m8030F(this.f5306a);
                    return;
                case 5:
                    LiveStreamer.m8036u(this.f5306a);
                    LiveStreamer.m8030F(this.f5306a);
                    Looper.myLooper().quit();
                    return;
                case 7:
                    LiveStreamer.m8035b(this.f5306a, ((Float) message.obj).floatValue());
                    return;
                case 8:
                    this.f5306a.f5329p.close();
                    return;
                case 9:
                    LiveStreamer.m8032J(this.f5306a);
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    /* compiled from: saved_video_download_state */
    public interface LiveStreamerPrefetchingListener {
        void m8016a(@Nullable ApiErrorResult apiErrorResult);

        void m8017a(NetworkSpeedTest networkSpeedTest);

        void m8018a(VideoBroadcastInitResponse videoBroadcastInitResponse);

        void hx_();
    }

    /* compiled from: saved_video_download_state */
    public interface LiveStreamerStreamingListener {
        void m8019a(long j);

        void m8020a(LiveStreamingError liveStreamingError);

        void m8021b(LiveStreamingError liveStreamingError);

        void m8022e();

        void m8023f();

        void m8024g();

        void m8025h();

        @Nullable
        Map<String, String> m8026i();
    }

    /* compiled from: saved_video_download_state */
    public enum STREAMING_STATE {
        STREAMING_OFF,
        STREAMING_INIT_COMPLETE,
        STREAMING_STARTED,
        STREAMING_STOPPED,
        STREAMING_FINISHED
    }

    public static com.facebook.video.videostreaming.LiveStreamer m8033a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5307G;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videostreaming.LiveStreamer.class;
        monitor-enter(r1);
        r0 = f5307G;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8034b(r0);	 Catch:{ all -> 0x0035 }
        f5307G = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5307G;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videostreaming.LiveStreamer.a(com.facebook.inject.InjectorLike):com.facebook.video.videostreaming.LiveStreamer");
    }

    private static LiveStreamer m8034b(InjectorLike injectorLike) {
        return new LiveStreamer((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FbHandlerThreadFactory.a(injectorLike), AndroidReachabilityListener.a(injectorLike), DefaultXAnalyticsProvider.a(injectorLike), SkywalkerSubscriptionConnector.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LiveStreamingMuxer.m8079b(injectorLike), LiveStreamingMetrics.m8077a(injectorLike), AndroidRtmpSSLFactoryHolder.m7990a(injectorLike));
    }

    @Inject
    public LiveStreamer(AbstractSingleMethodRunner abstractSingleMethodRunner, ExecutorService executorService, MonotonicClock monotonicClock, FbHandlerThreadFactory fbHandlerThreadFactory, AndroidReachabilityListener androidReachabilityListener, DefaultXAnalyticsProvider defaultXAnalyticsProvider, SkywalkerSubscriptionConnector skywalkerSubscriptionConnector, ObjectMapper objectMapper, GatekeeperStoreImpl gatekeeperStoreImpl, AbstractFbErrorReporter abstractFbErrorReporter, LiveStreamingMuxer liveStreamingMuxer, LiveStreamingMetrics liveStreamingMetrics, AndroidRtmpSSLFactoryHolder androidRtmpSSLFactoryHolder) {
        this.f5331r = abstractSingleMethodRunner;
        this.f5322i = executorService;
        this.f5315b = monotonicClock;
        this.f5321h = fbHandlerThreadFactory.a("Live Stream Video Thread");
        this.f5321h.start();
        this.f5320g = new LiveStreamerHandler(this, this.f5321h.getLooper());
        this.f5328o = androidReachabilityListener;
        this.f5323j = defaultXAnalyticsProvider;
        this.f5337x = skywalkerSubscriptionConnector;
        this.f5338y = objectMapper;
        this.f5339z = gatekeeperStoreImpl;
        this.f5310B = abstractFbErrorReporter;
        this.f5324k = new HashMap();
        this.f5313E = liveStreamingMuxer;
        this.f5309A = androidRtmpSSLFactoryHolder;
        this.f5316c = new LiveStreamingAudioRecorder(this.f5322i);
        this.f5314F = liveStreamingMetrics;
    }

    public final void m8042a() {
        this.f5335v = new VideoBroadcastInitMethod();
        this.f5336w = new Handler();
        this.f5319f = STREAMING_STATE.STREAMING_OFF;
        this.f5317d = null;
        this.f5330q = null;
        this.f5334u = false;
        this.f5312D = null;
        this.f5311C = null;
        this.f5329p = null;
        LiveStreamingMuxer liveStreamingMuxer = this.f5313E;
        liveStreamingMuxer.f5377d = null;
        if (liveStreamingMuxer.f5380g) {
            BLog.a(LiveStreamingMuxer.f5374a, "LiveStreamMux Muxer was not stopped after previous broadcast. Stopping it now");
            liveStreamingMuxer.m8085c();
        }
        liveStreamingMuxer.f5382i = false;
        liveStreamingMuxer.f5380g = false;
        liveStreamingMuxer.f5381h = -1;
        LiveStreamingMetrics liveStreamingMetrics = this.f5314F;
        liveStreamingMetrics.f5369a.clear();
        liveStreamingMetrics.f5370b.clear();
        liveStreamingMetrics.f5371c = -1;
        liveStreamingMetrics.f5372d = -1;
        liveStreamingMetrics.f5373e = -1;
    }

    public final void m8045a(String str) {
        this.f5332s = str;
        this.f5333t = true;
    }

    public final boolean m8047b() {
        return this.f5319f == STREAMING_STATE.STREAMING_STARTED;
    }

    public final File m8048d() {
        if (this.f5319f == STREAMING_STATE.STREAMING_FINISHED && this.f5334u) {
            LiveStreamingMuxer liveStreamingMuxer = this.f5313E;
            File file = null;
            if (liveStreamingMuxer.f5382i) {
                BLog.b(LiveStreamingMuxer.f5374a, "Muxing Failed for DVR");
            } else if (liveStreamingMuxer.f5377d == null || liveStreamingMuxer.f5377d.length() == 0) {
                BLog.b(LiveStreamingMuxer.f5374a, "Unable to create valid muxed file for DVR");
            } else {
                file = liveStreamingMuxer.f5377d;
            }
            return file;
        }
        this.f5310B.a(f5308a, "getDvrFile failed preconditions - state:" + this.f5319f + " enabled:" + this.f5334u);
        return null;
    }

    public final void m8043a(float f) {
        this.f5320g.sendMessageAtFrontOfQueue(this.f5320g.obtainMessage(7, Float.valueOf(f)));
    }

    public final void m8049f() {
        this.f5320g.sendMessageAtFrontOfQueue(this.f5320g.obtainMessage(2));
    }

    public final void m8050g() {
        this.f5320g.sendMessage(this.f5320g.obtainMessage(8));
    }

    public final void m8051h() {
        this.f5320g.sendMessageAtFrontOfQueue(this.f5320g.obtainMessage(0));
    }

    public final void m8052i() {
        this.f5320g.sendMessage(this.f5320g.obtainMessage(4));
    }

    public final void m8053k() {
        this.f5316c.m8062c();
    }

    public final Looper m8054l() {
        return this.f5321h.getLooper();
    }

    public final void m8046b(final LiveStreamingError liveStreamingError) {
        if (this.f5325l != null) {
            HandlerDetour.a(this.f5336w, new Runnable(this) {
                final /* synthetic */ LiveStreamer f5299b;

                public void run() {
                    if (this.f5299b.f5325l != null) {
                        this.f5299b.f5325l.m8020a(liveStreamingError);
                    }
                }
            }, -467001982);
        }
    }

    public final boolean m8055p() {
        return this.f5329p.isNetworkWeak();
    }

    public final boolean m8056q() {
        return this.f5329p.hasNetworkRecoveredFromWeak();
    }

    public final int m8041a(int i, int i2, int i3) {
        this.f5324k.clear();
        Map i4 = this.f5325l.m8026i();
        if (i4 != null) {
            this.f5324k.putAll(i4);
        }
        this.f5324k.put("base_system_version", VERSION.RELEASE);
        i4 = ImmutableMap.copyOf(this.f5311C.f5367u);
        if (i4 != null) {
            this.f5324k.putAll(i4);
        }
        int computeNewBitrate = (int) this.f5329p.computeNewBitrate((double) i, this.f5324k);
        LiveStreamingMetrics liveStreamingMetrics = this.f5314F;
        Integer valueOf = Integer.valueOf(i3);
        int i5 = computeNewBitrate / 1000;
        if (i5 != liveStreamingMetrics.f5371c) {
            liveStreamingMetrics.f5369a.put(valueOf.toString(), Integer.valueOf(i5));
            liveStreamingMetrics.f5371c = i5;
        }
        if (i2 != liveStreamingMetrics.f5372d) {
            liveStreamingMetrics.f5370b.put(valueOf.toString(), Integer.valueOf(i2));
            liveStreamingMetrics.f5372d = i2;
        }
        liveStreamingMetrics.f5373e = valueOf.intValue();
        return computeNewBitrate;
    }

    public final Map<String, String> m8057s() {
        LiveStreamingMetrics liveStreamingMetrics = this.f5314F;
        if (liveStreamingMetrics.f5373e != -1) {
            String num = Integer.valueOf(liveStreamingMetrics.f5373e).toString();
            if (!liveStreamingMetrics.f5369a.containsKey(num)) {
                liveStreamingMetrics.f5369a.put(num, Integer.valueOf(liveStreamingMetrics.f5371c));
            }
            if (!liveStreamingMetrics.f5370b.containsKey(num)) {
                liveStreamingMetrics.f5370b.put(num, Integer.valueOf(liveStreamingMetrics.f5372d));
            }
        }
        Map<String, String> hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        Map hashMap4 = new HashMap();
        hashMap3.put("uplink_bwe", liveStreamingMetrics.f5370b);
        hashMap4.put("ul_bwe", liveStreamingMetrics.f5369a);
        hashMap2.put("bwe", hashMap3);
        hashMap2.put("video_mts", hashMap4);
        hashMap.put("media", new JSONObject(hashMap2).toString());
        return hashMap;
    }

    public static void m8036u(LiveStreamer liveStreamer) {
        if (liveStreamer.f5319f == STREAMING_STATE.STREAMING_STARTED || liveStreamer.f5319f == STREAMING_STATE.STREAMING_INIT_COMPLETE) {
            try {
                if (liveStreamer.f5319f == STREAMING_STATE.STREAMING_STARTED) {
                    liveStreamer.f5316c.m8065f();
                    liveStreamer.f5311C.m8073c();
                    if (liveStreamer.f5334u && liveStreamer.f5312D != null) {
                        liveStreamer.f5312D.m8073c();
                    }
                }
                liveStreamer.m8038w();
            } catch (Throwable th) {
                liveStreamer.m8038w();
            }
        }
        liveStreamer.m8037v();
        liveStreamer.f5320g.sendMessage(liveStreamer.f5320g.obtainMessage(9));
    }

    private void m8037v() {
        if (this.f5325l != null) {
            LiveStreamerStreamingListener liveStreamerStreamingListener = this.f5325l;
        }
    }

    private void m8038w() {
        this.f5316c.m8063d();
        this.f5311C.m8072b();
        if (this.f5334u && this.f5312D != null) {
            this.f5312D.m8072b();
        }
        this.f5319f = STREAMING_STATE.STREAMING_STOPPED;
    }

    public static void m8039x(LiveStreamer liveStreamer) {
        if (liveStreamer.f5319f == STREAMING_STATE.STREAMING_STARTED) {
            BLog.a(f5308a, "Duplicate start request. Streaming already started.");
            liveStreamer.m8040y();
            return;
        }
        Preconditions.checkState(liveStreamer.f5319f == STREAMING_STATE.STREAMING_INIT_COMPLETE);
        liveStreamer.f5316c.m8064e();
        liveStreamer.f5319f = STREAMING_STATE.STREAMING_STARTED;
        liveStreamer.m8040y();
    }

    private void m8040y() {
        if (this.f5325l != null) {
            this.f5325l.m8024g();
        }
    }

    public final void m8044a(final long j) {
        if (this.f5325l != null) {
            HandlerDetour.a(this.f5336w, new Runnable(this) {
                final /* synthetic */ LiveStreamer f5304b;

                public void run() {
                    this.f5304b.f5325l.m8019a(j);
                }
            }, 1204253157);
        }
    }

    public static boolean m8027A(LiveStreamer liveStreamer) {
        for (int i = 0; i < 3; i++) {
            if (liveStreamer.f5330q == null || liveStreamer.f5330q.isEmpty()) {
                try {
                    liveStreamer.f5317d = liveStreamer.m8028B();
                    liveStreamer.m8029C();
                    return true;
                } catch (ApiException e) {
                    ApiErrorResult b = e.b();
                    BLog.b(f5308a, "Unable to retrieve broadcast ID. ", e);
                    liveStreamer.f5318e = b;
                    return false;
                } catch (Throwable e2) {
                    BLog.b(f5308a, "Unable to retrieve broadcast ID. ", e2);
                    try {
                        Thread.sleep((long) (10 << i));
                    } catch (Throwable e22) {
                        BLog.b(f5308a, "Thread.sleep() threw InterruptedException ", e22);
                        return false;
                    }
                }
            }
        }
        BLog.b(f5308a, "Could not connect to RTMP server.");
        return false;
    }

    private VideoBroadcastInitResponse m8028B() {
        return (VideoBroadcastInitResponse) this.f5331r.a(this.f5335v, this.f5332s, null, CallerContext.a(LiveStreamer.class));
    }

    private void m8029C() {
        this.f5330q = this.f5317d.rtmpPublishUrl;
        this.f5334u = this.f5317d.mIsDiskRecordingEnabled;
        this.f5311C = new LiveStreamingEncoder(this.f5315b, this, new C03279(this));
        this.f5311C.m8068a();
        if (this.f5334u) {
            this.f5312D = new LiveStreamingEncoder(this.f5315b, this, new LiveStreamingEncoderOutputConsumer(this) {
                final /* synthetic */ LiveStreamer f5289a;

                {
                    this.f5289a = r1;
                }

                public final void mo361a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, BufferInfo bufferInfo) {
                }

                public final void mo362b(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, BufferInfo bufferInfo) {
                    if (this.f5289a.f5334u) {
                        this.f5289a.f5313E.m8084b(byteBuffer, i, i2, i3, i5, i6, bufferInfo);
                    }
                }
            });
            this.f5312D.m8068a();
        }
        if (this.f5334u) {
            LiveStreamingMuxer liveStreamingMuxer = this.f5313E;
            LiveStreamingEncoder liveStreamingEncoder = this.f5311C;
            LiveStreamingEncoder liveStreamingEncoder2 = this.f5312D;
            liveStreamingMuxer.f5378e = liveStreamingEncoder;
            liveStreamingMuxer.f5379f = liveStreamingEncoder2;
            liveStreamingMuxer.f5377d = liveStreamingMuxer.f5375b.a("video_transcode", ".mp4", Privacy.REQUIRE_PRIVATE);
            if (liveStreamingMuxer.f5377d == null) {
                liveStreamingMuxer.f5382i = true;
                BLog.b(LiveStreamingMuxer.f5374a, "LiveStreamMux Unable to create output file");
            }
        }
        this.f5329p = new AndroidLiveStreamingSession(this, this.f5317d.m8141a(), this.f5323j, this.f5309A);
        this.f5311C.m8070a(this.f5317d.videoStreamingConfig, this.f5317d.audioStreamingConfig, this.f5329p.getABRComputeInterval());
        if (this.f5334u) {
            JsonNode a = this.f5317d.m8141a();
            VideoBroadcastDiskRecordingConfig videoBroadcastDiskRecordingConfig = new VideoBroadcastDiskRecordingConfig();
            JsonNode b = a.b("stream_disk_recording_space_check_interval_in_seconds");
            JsonNode b2 = a.b("stream_disk_recording_space_check_interval_in_seconds");
            videoBroadcastDiskRecordingConfig.f5451a = b == null ? 0.0d : b.E();
            videoBroadcastDiskRecordingConfig.f5452b = b2 == null ? 0 : b2.C();
            videoBroadcastDiskRecordingConfig.f5453c = VideoBroadcastDiskRecordingConfig.m8133b(a);
            videoBroadcastDiskRecordingConfig.f5454d = VideoBroadcastDiskRecordingConfig.m8134c(a);
            VideoBroadcastDiskRecordingConfig videoBroadcastDiskRecordingConfig2 = videoBroadcastDiskRecordingConfig;
            this.f5312D.m8070a(videoBroadcastDiskRecordingConfig2.f5453c, videoBroadcastDiskRecordingConfig2.f5454d, -1);
        }
        this.f5316c.m8059a(this.f5311C);
        this.f5316c.m8060b();
    }

    public static void m8030F(LiveStreamer liveStreamer) {
        if (liveStreamer.f5319f != STREAMING_STATE.STREAMING_FINISHED && liveStreamer.f5329p != null) {
            if (liveStreamer.f5327n != null) {
                HandlerDetour.a(liveStreamer.f5336w, new Runnable(liveStreamer) {
                    final /* synthetic */ LiveStreamer f5290a;

                    {
                        this.f5290a = r1;
                    }

                    public void run() {
                        if (this.f5290a.f5327n != null) {
                            2 2 = this.f5290a.f5327n;
                            if (2.a.j != null) {
                                2.a.j.o();
                            }
                        }
                    }
                }, -905649462);
            }
            liveStreamer.f5329p.close();
            liveStreamer.f5332s = null;
            liveStreamer.f5333t = false;
            liveStreamer.f5319f = STREAMING_STATE.STREAMING_FINISHED;
            liveStreamer.f5329p.m7998a();
            liveStreamer.f5316c.m8061b(liveStreamer.f5311C);
            if (liveStreamer.f5334u) {
                liveStreamer.f5313E.m8085c();
            }
            if (liveStreamer.f5325l != null) {
                HandlerDetour.a(liveStreamer.f5336w, new Runnable(liveStreamer) {
                    final /* synthetic */ LiveStreamer f5291a;

                    {
                        this.f5291a = r1;
                    }

                    public void run() {
                        if (this.f5291a.f5325l != null) {
                            this.f5291a.f5325l.m8025h();
                        }
                    }
                }, -1274239685);
            }
        }
    }

    public static void m8035b(LiveStreamer liveStreamer, float f) {
        if (liveStreamer.f5319f == STREAMING_STATE.STREAMING_INIT_COMPLETE || liveStreamer.f5319f == STREAMING_STATE.STREAMING_STARTED) {
            BLog.b(f5308a, "Init already done. returning");
            liveStreamer.m8031H();
            return;
        }
        liveStreamer.f5316c.m8058a();
        liveStreamer.f5311C.m8069a(f);
        if (liveStreamer.f5334u && liveStreamer.f5312D != null) {
            liveStreamer.f5312D.m8069a(f);
        }
        liveStreamer.f5319f = STREAMING_STATE.STREAMING_INIT_COMPLETE;
        liveStreamer.m8031H();
    }

    private void m8031H() {
        if (this.f5325l != null) {
            this.f5325l.m8023f();
        }
    }

    public static void m8032J(LiveStreamer liveStreamer) {
        if (liveStreamer.f5319f == STREAMING_STATE.STREAMING_STOPPED) {
            liveStreamer.f5329p.sendStreamInterrupted();
            if (!(liveStreamer.f5317d == null || liveStreamer.f5317d.videoId == null || !liveStreamer.f5339z.a(VideoAbTestGatekeepers.g, false))) {
                String str = "video_broadcast/interrupt_" + liveStreamer.f5317d.videoId;
                ObjectNode e = liveStreamer.f5338y.e();
                e.a("broadcast_id", liveStreamer.f5317d.broadcastId);
                e.a("time_position", liveStreamer.f5311C.f5355i);
                liveStreamer.f5337x.a(str, e);
                str = liveStreamer.f5317d.videoId;
                str = liveStreamer.f5317d.broadcastId;
            }
            if (liveStreamer.f5317d.sendStreamInterruptedIntervalInSeconds != 0) {
                liveStreamer.f5320g.sendMessageDelayed(liveStreamer.f5320g.obtainMessage(9), TimeUnit.SECONDS.toMillis(liveStreamer.f5317d.sendStreamInterruptedIntervalInSeconds));
            }
        }
    }
}
