package com.facebook.webrtc;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcUiInterface.AudioOutputRoute;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: later */
public class WebrtcManager implements INeedInit, IWebrtcCallMonitorInterface {
    public static final Class<?> f9483a = WebrtcManager.class;
    private static volatile WebrtcManager f9484z;
    private final Context f9485b;
    private final DataUsageCounters f9486c;
    private final AbstractFbErrorReporter f9487d;
    public final MonotonicClock f9488e;
    private final ChannelConnectivityTracker f9489f;
    public final MqttPushServiceClientManagerImpl f9490g;
    private final GatekeeperListenersImpl f9491h;
    private final FbAppType f9492i;
    public final Provider<Long> f9493j;
    private final WebrtcCrashReporter f9494k;
    private final DefaultAndroidThreadUtil f9495l;
    private final FbTracer f9496m;
    private final GatekeeperStoreImpl f9497n;
    private IWebrtcUiInterface f9498o;
    private Listener f9499p;
    private WebrtcUiHandler f9500q;
    private IWebrtcConfigInterface f9501r;
    private IWebrtcLoggingInterface f9502s;
    private IWebrtcSignalingMessageInterface f9503t;
    private OnGatekeeperChangeListener f9504u;
    public volatile long f9505v;
    public volatile WebrtcEngine f9506w;
    private ImmediateActiveSecondReporter f9507x;
    private long f9508y = -1;

    /* compiled from: later */
    class C05621 extends OnGatekeeperChangeListener {
        final /* synthetic */ WebrtcManager f11620a;

        C05621(WebrtcManager webrtcManager) {
            this.f11620a = webrtcManager;
        }

        public final void m12131a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            long longValue = ((Long) this.f11620a.f9493j.get()).longValue();
            if (this.f11620a.f9505v != longValue) {
                this.f11620a.f9505v = longValue;
                try {
                    MqttPushServiceClient a = this.f11620a.f9490g.a();
                    JsonNode objectNode = new ObjectNode(JsonNodeFactory.a);
                    objectNode.a("endpoint_capabilities", this.f11620a.f9505v);
                    try {
                        a.mo855a("/send_endpoint_capabilities", objectNode, MqttQOSLevel.FIRE_AND_FORGET, null);
                    } catch (Throwable th) {
                    } finally {
                        a.mo870f();
                    }
                } catch (Throwable th2) {
                }
            }
        }
    }

    public static com.facebook.webrtc.WebrtcManager m9858a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9484z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.webrtc.WebrtcManager.class;
        monitor-enter(r1);
        r0 = f9484z;	 Catch:{ all -> 0x003a }
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
        r0 = m9861b(r0);	 Catch:{ all -> 0x0035 }
        f9484z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9484z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webrtc.WebrtcManager.a(com.facebook.inject.InjectorLike):com.facebook.webrtc.WebrtcManager");
    }

    private static WebrtcManager m9861b(InjectorLike injectorLike) {
        return new WebrtcManager((Context) injectorLike.getInstance(Context.class), DataUsageCounters.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ChannelConnectivityTracker.a(injectorLike), MqttPushServiceClientManagerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FbTracer.a(injectorLike), ImmediateActiveSecondReporter.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), GatekeeperListenersImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4430), WebrtcCrashReporter.m9877b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WebrtcManager(Context context, DataUsageCounters dataUsageCounters, FbErrorReporter fbErrorReporter, ChannelConnectivityTracker channelConnectivityTracker, MqttPushServiceClientManager mqttPushServiceClientManager, MonotonicClock monotonicClock, AndroidThreadUtil androidThreadUtil, FbTracer fbTracer, ImmediateActiveSecondReporter immediateActiveSecondReporter, FbAppType fbAppType, GatekeeperListeners gatekeeperListeners, Provider<Long> provider, WebrtcCrashReporter webrtcCrashReporter, GatekeeperStore gatekeeperStore) {
        this.f9485b = context;
        this.f9486c = dataUsageCounters;
        this.f9487d = fbErrorReporter;
        this.f9490g = mqttPushServiceClientManager;
        this.f9489f = channelConnectivityTracker;
        this.f9488e = monotonicClock;
        this.f9495l = androidThreadUtil;
        this.f9507x = immediateActiveSecondReporter;
        this.f9496m = fbTracer;
        this.f9491h = gatekeeperListeners;
        this.f9493j = provider;
        this.f9494k = webrtcCrashReporter;
        this.f9492i = fbAppType;
        this.f9497n = gatekeeperStore;
    }

    public void init() {
        if (this.f9492i.j == Product.MESSENGER || this.f9492i.j == Product.PHONE || this.f9492i.j == Product.FB4A) {
            this.f9505v = 0;
            this.f9504u = new C05621(this);
            this.f9491h.a(this.f9504u, 984);
        }
    }

    public void onInitializingCall(long j) {
        this.f9502s.setLastCallId(j);
    }

    public void onCallStarted(long j) {
        this.f9508y = this.f9507x.a();
        this.f9502s.pauseLogUpload();
        this.f9502s.logInitialBatteryLevel();
    }

    public void onCallEnded(long j, long j2, long j3) {
        if (this.f9508y >= 0) {
            long j4 = this.f9508y / 1000;
            this.f9507x.a("voip", j4, this.f9507x.a() / 1000);
        }
        this.f9508y = -1;
        this.f9502s.resumeLogUpload();
        this.f9486c.a("voip_bytes_sent", j2);
        this.f9486c.a("voip_bytes_received", j3);
    }

    public final boolean m9873a() {
        if (m9862e() && this.f9506w != null) {
            WebrtcEngine webrtcEngine = this.f9506w;
            if (WebrtcEngine.c) {
                return true;
            }
        }
        return false;
    }

    public final void m9868a(IWebrtcUiInterface iWebrtcUiInterface, Listener listener, WebrtcUiHandler webrtcUiHandler, IWebrtcConfigInterface iWebrtcConfigInterface, IWebrtcLoggingInterface iWebrtcLoggingInterface, IWebrtcSignalingMessageInterface iWebrtcSignalingMessageInterface) {
        this.f9498o = iWebrtcUiInterface;
        this.f9499p = listener;
        this.f9500q = webrtcUiHandler;
        this.f9501r = iWebrtcConfigInterface;
        this.f9502s = iWebrtcLoggingInterface;
        this.f9503t = iWebrtcSignalingMessageInterface;
        this.f9498o.setWebrtcManager(this);
        this.f9503t.setWebrtcManager(this);
        if (m9862e() && !m9873a()) {
            TracerDetour.a("%s.lazyInit()", getClass().getSimpleName(), -379596652);
            Object obj = null;
            try {
                if (this.f9506w == null) {
                    synchronized (this) {
                        if (this.f9506w == null) {
                            this.f9506w = new WebrtcEngine(this.f9485b, this.f9487d, this.f9503t, this.f9498o, this.f9501r, this.f9502s, this, this.f9499p, this.f9494k);
                            m9860a(new String[]{"instantvideo.dev"});
                            this.f9501r.setWebrtcEngine(this.f9506w);
                            obj = 1;
                        }
                    }
                }
                WebrtcEngine webrtcEngine = this.f9506w;
                if (obj != null) {
                    IWebrtcLoggingInterface iWebrtcLoggingInterface2 = this.f9502s;
                    webrtcEngine = this.f9506w;
                    iWebrtcLoggingInterface2.logEngineCreationEvent(WebrtcEngine.a());
                }
                TracerDetour.a(-1690904620);
            } catch (Throwable th) {
                TracerDetour.a(-270908130);
            }
        }
    }

    private boolean m9862e() {
        if (this.f9492i.j == Product.MESSENGER || this.f9492i.j == Product.PHONE) {
            return this.f9497n.a(984, false);
        }
        return this.f9492i.j == Product.FB4A ? false : false;
    }

    public final void m9874b() {
        WebrtcEngine webrtcEngine = null;
        synchronized (this) {
            if (this.f9506w != null) {
                webrtcEngine = this.f9506w;
                this.f9506w = null;
            }
        }
        if (webrtcEngine != null) {
            webrtcEngine.b();
        }
        this.f9500q.a();
    }

    public final void m9871a(String str, boolean z, boolean z2, boolean z3) {
        if (m9873a()) {
            this.f9506w.acceptCall(str, z, z2, z3);
        }
    }

    public final void m9865a(long j, View view) {
        if (m9873a()) {
            this.f9506w.setRendererWindow(j, view);
        }
    }

    public final void m9867a(AudioOutputRoute audioOutputRoute) {
        if (m9873a()) {
            this.f9506w.a(audioOutputRoute);
        }
        audioOutputRoute.toString();
    }

    public final void m9875b(boolean z) {
        if (m9873a()) {
            this.f9506w.setSpeakerOn(z);
        }
    }

    public final void m9872a(String str, byte[] bArr, boolean z) {
        if (m9873a()) {
            this.f9506w.onThriftMessageFromPeer(str, bArr, z ? "gcm" : "mqtt");
        }
    }

    public final void m9870a(String str, String str2, int i, String str3, String str4) {
        if (m9873a()) {
            this.f9506w.onMultiwayMessageSendError(str, str2, i, str3, str4);
        }
    }

    public final void m9876c(boolean z) {
        this.f9506w.setBluetoothState(z);
    }

    public final void m9864a(long j, long j2, String str, String str2, String str3, String str4) {
        if (m9873a()) {
            this.f9506w.startCustomCallToDevice(j, str2, "instantvideo.dev", str3, true, true, true, true, j2, str, str4);
        }
    }

    public final void m9866a(long j, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        if (m9873a()) {
            m9859a(new 2(this, j, str, str2, z, z2, z3, z4, str3));
        }
    }

    private void m9859a(Runnable runnable) {
        if (this.f9489f.e()) {
            runnable.run();
            return;
        }
        this.f9495l.a(new 3(this, runnable), new Void[0]);
    }

    private void m9860a(String[] strArr) {
        if (m9873a()) {
            this.f9506w.setSupportedCallTypes(strArr);
        }
    }

    public final void m9863a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (m9873a()) {
            this.f9506w.setVideoParameters(i, i2, i3, i4, i5, i6);
        }
    }

    public final void m9869a(String str, long j, long j2, String str2, int i, String str3) {
        if (m9873a()) {
            FbTraceNode fbTraceNode = FbTraceNode.a;
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(fbTraceNode);
            if (str != null) {
                fbTraceNode = this.f9496m.b(str);
                a = FbTraceEventAnnotationsUtil.m12132a(fbTraceNode);
                a.put("op", "webrtc_response");
                a.put("service", "sender_webrtc_application_layer");
                a.put("msg_id", Long.valueOf(j2));
                a.put("call_id", Long.valueOf(j));
            }
            if (i == 0) {
                a.put("success", "true");
                this.f9496m.a(fbTraceNode, FbTraceEvent.RESPONSE_RECEIVE, a);
                this.f9506w.onMessageSendSuccess(j, j2);
                return;
            }
            a.put("success", "false");
            a.put("error_code", Integer.valueOf(i));
            this.f9496m.a(fbTraceNode, FbTraceEvent.RESPONSE_RECEIVE, a);
            this.f9506w.onMessageSendError(j, j2, i, str3, str2);
        }
    }
}
