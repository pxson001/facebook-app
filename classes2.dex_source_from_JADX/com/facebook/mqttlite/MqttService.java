package com.facebook.mqttlite;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0061x63d21d68;
import com.facebook.common.executors.SingleThreadedExecutorService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.BitmaskEnumUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTracer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.requestrouting.RequestRoutingHelper;
import com.facebook.messaging.requestrouting.RequestRoutingXConfig;
import com.facebook.mqtt.capabilities.MqttEndpointCapability;
import com.facebook.mqtt.debug.MqttStats;
import com.facebook.mqttlite.keepaliveexperiment.ExperimentsForKeepaliveExperimentModule;
import com.facebook.mqttlite.trafficcontrol.MqttTrafficControlParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.mqtt.annotations.IsBatchPendingMessagesInConnect;
import com.facebook.push.mqtt.annotations.IsMqttCombineConnectGetDiffsEnabled;
import com.facebook.push.mqtt.annotations.IsMqttPublishOptionalCompression;
import com.facebook.push.mqtt.annotations.IsMqttPublishWithEnumTopic;
import com.facebook.push.mqtt.annotations.IsMqttSendForegroundStateOverThriftEnabled;
import com.facebook.push.mqtt.annotations.IsMqttSendInboxOverThriftEnabled;
import com.facebook.push.mqtt.annotations.IsSuppressGetDiffInConnect;
import com.facebook.push.mqtt.annotations.MqttScreenOnKeepaliveGatekeeper;
import com.facebook.push.mqtt.external.IsWebRtcRetryEnabled;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.push.mqtt.external.MqttThread;
import com.facebook.push.mqtt.external.PublishedPayloadDescriptor;
import com.facebook.push.mqtt.external.PushStateBroadcaster;
import com.facebook.push.mqtt.external.RefCode;
import com.facebook.push.mqtt.external.STATICDI_MULTIBIND_PROVIDER$MqttPushHandler;
import com.facebook.push.mqtt.external.ServiceChannelStateListenerManager;
import com.facebook.push.mqtt.external.WebrtcPreemptiveReconnectTimeoutMs;
import com.facebook.push.mqtt.ipc.IMqttPushService.Stub;
import com.facebook.push.mqtt.ipc.MqttChannelStateInfo;
import com.facebook.push.mqtt.ipc.MqttChannelStateListener;
import com.facebook.push.mqtt.ipc.MqttPublishArrivedListener;
import com.facebook.push.mqtt.ipc.MqttPublishListener;
import com.facebook.push.mqtt.ipc.StickySubscribeTopic;
import com.facebook.push.mqtt.ipc.SubscribeTopic;
import com.facebook.push.mqtt.ipc.SyncQueueTracker;
import com.facebook.push.prefs.IsMobileOnlineAvailabilityEnabled;
import com.facebook.push.prefs.PushPrefKeys;
import com.facebook.rti.common.thrift.MqttTopic;
import com.facebook.rti.common.util.NonInjectProvider;
import com.facebook.rti.mqtt.capability.MqttCapability;
import com.facebook.rti.mqtt.common.analytics.ConnectTriggerReason;
import com.facebook.rti.mqtt.common.analytics.DisconnectDetailReason;
import com.facebook.rti.mqtt.common.util.SignatureAuthSecureIntent;
import com.facebook.rti.mqtt.credentials.MqttAuthenticationKeySecretPair;
import com.facebook.rti.mqtt.manager.ConnectionState;
import com.facebook.rti.mqtt.manager.MqttConnectionManager;
import com.facebook.rti.mqtt.manager.MqttPushServiceBootstrap;
import com.facebook.rti.mqtt.protocol.MqttException;
import com.facebook.rti.mqtt.protocol.messages.MqttQOSLevel;
import com.facebook.rti.mqtt.protocol.serialization.MqttPayloadCompressionUtil;
import com.facebook.rti.push.service.FbnsService;
import com.facebook.rti.push.service.FbnsServiceBootstrap;
import com.facebook.rti.push.service.FbnsServiceIdManager;
import com.facebook.rti.push.service.MqttDeviceAuthCredentials;
import com.facebook.rti.push.service.idsharing.DeviceIdAndSecretSharer;
import com.facebook.rti.push.service.idsharing.DeviceIdAndSecretSharingRequester;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: fragment coordinator */
public class MqttService extends FbnsService implements PropertyBag, OnSharedPreferenceChangeListener {
    public static final Class<?> ab = MqttService.class;
    public static final Object ac = new Object();
    @Inject
    MonotonicClock f23339A;
    @Inject
    @MqttEndpointCapability
    Provider<Long> f23340B;
    @Inject
    FbSharedPreferences f23341C;
    @Inject
    FbTracer f23342D;
    @Inject
    MqttLiteAnalyticsSamplePolicy f23343E;
    @Inject
    @IsMobileOnlineAvailabilityEnabled
    Provider<Boolean> f23344F;
    @IsMqttPublishWithEnumTopic
    @Inject
    Provider<Boolean> f23345G;
    @Inject
    @IsSuppressGetDiffInConnect
    Provider<Boolean> f23346H;
    @Inject
    MqttliteKeepaliveParms f23347I;
    @Inject
    AbstractFbErrorReporter f23348J;
    @Inject
    @IsMqttSendForegroundStateOverThriftEnabled
    Provider<Boolean> f23349K;
    @Inject
    RequestRoutingHelper f23350L;
    @Inject
    @IsDataRestrictionDetectorEnabled
    Provider<Boolean> f23351M;
    @Inject
    @IsWebRtcRetryEnabled
    Provider<Boolean> f23352N;
    @WebrtcPreemptiveReconnectTimeoutMs
    @Inject
    Provider<Integer> f23353O;
    @Inject
    @CrossFbProcessBroadcast
    BaseFbBroadcastManager f23354P;
    @Inject
    @IsMqttCombineConnectGetDiffsEnabled
    Provider<Boolean> f23355Q;
    @IsMqttPublishOptionalCompression
    @Inject
    Provider<Boolean> f23356R;
    @Inject
    RefCode f23357S;
    @Inject
    @SingleThreadedExecutorService
    ExecutorService f23358T;
    @Inject
    MqttTrafficControlParams f23359U;
    @Inject
    WhistleCoreBuilder f23360V;
    @Inject
    @MqttScreenOnKeepaliveGatekeeper
    Provider<TriState> f23361W;
    @IsMqttSendInboxOverThriftEnabled
    @Inject
    Provider<Boolean> f23362X;
    @Inject
    GatekeeperStoreImpl f23363Y;
    @Inject
    @IsBatchPendingMessagesInConnect
    Provider<Boolean> f23364Z;
    private Looper aa;
    private ExecutorService ad;
    private final PropertyBagHelper ae = new PropertyBagHelper();
    private final Random af = new Random();
    public Long ag;
    private final Stub ah = new C09471(this);
    @Inject
    MqttUserAuthCredentials f23365r;
    @Inject
    MqttServiceIdManager f23366s;
    @Inject
    MqttStats f23367t;
    @Inject
    MqttConnectionConfigManager f23368u;
    @Inject
    MqttWakeLockHolder f23369v;
    @Inject
    Set<MqttPushHandler> f23370w;
    @Inject
    PushStateBroadcaster f23371x;
    @Inject
    @MqttThread
    Handler f23372y;
    @Inject
    ServiceChannelStateListenerManager f23373z;

    /* compiled from: fragment coordinator */
    class C09471 extends Stub {
        final /* synthetic */ MqttService f23374a;

        C09471(MqttService mqttService) {
            this.f23374a = mqttService;
        }

        public final void mo3416a(MqttChannelStateListener mqttChannelStateListener) {
            this.f23374a.a();
            this.f23374a.f23373z.m31705a(mqttChannelStateListener);
        }

        public final void mo3426b(MqttChannelStateListener mqttChannelStateListener) {
            this.f23374a.a();
            this.f23374a.f23373z.m31706b(mqttChannelStateListener);
        }

        public final boolean mo3422a() {
            this.f23374a.a();
            return this.f23374a.c.h();
        }

        public final boolean mo3428b() {
            this.f23374a.a();
            return this.f23374a.c.i();
        }

        public final boolean mo3423a(long j) {
            this.f23374a.a();
            return this.f23374a.c.a(j);
        }

        public final void mo3417a(SyncQueueTracker syncQueueTracker) {
            this.f23374a.a();
            this.f23374a.c.D = new SyncQueueTrackerImpl(syncQueueTracker);
        }

        public final int mo3415a(String str, byte[] bArr, int i, MqttPublishListener mqttPublishListener) {
            this.f23374a.a();
            try {
                return this.f23374a.c.a(str, bArr, MqttQOSLevel.fromInt(i), mqttPublishListener != null ? new MqttLitePublishListenerImpl(mqttPublishListener) : null);
            } catch (MqttException e) {
                throw new RemoteException(e.toString());
            }
        }

        public final boolean mo3424a(String str, byte[] bArr, long j, MqttPublishListener mqttPublishListener, long j2) {
            return mo3425a(str, bArr, j, mqttPublishListener, j2, null);
        }

        public final boolean mo3425a(String str, byte[] bArr, long j, MqttPublishListener mqttPublishListener, long j2, String str2) {
            Throwable e;
            this.f23374a.a();
            try {
                return this.f23374a.c.a(str, bArr, j, mqttPublishListener != null ? new MqttLitePublishListenerImpl(mqttPublishListener) : null, j2, str2);
            } catch (InterruptedException e2) {
                e = e2;
                BLog.b(MqttService.ab, e, "send/publish/exception; topic=%s", new Object[]{str});
                throw new RemoteException(e.toString());
            } catch (MqttException e3) {
                e = e3;
                BLog.b(MqttService.ab, e, "send/publish/exception; topic=%s", new Object[]{str});
                throw new RemoteException(e.toString());
            } catch (ExecutionException e4) {
                e = e4;
                BLog.b(MqttService.ab, e, "send/publish/exception; topic=%s", new Object[]{str});
                throw new RemoteException(e.toString());
            } catch (TimeoutException e5) {
                e = e5;
                BLog.b(MqttService.ab, e, "send/publish/exception; topic=%s", new Object[]{str});
                throw new RemoteException(e.toString());
            }
        }

        public final void mo3430c(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
            this.f23374a.a();
        }

        public final void mo3432d(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
            this.f23374a.a();
        }

        public final void mo3419a(List<SubscribeTopic> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
            this.f23374a.a();
            if (list != null && !list.isEmpty()) {
                List arrayList = new ArrayList(list.size());
                for (SubscribeTopic subscribeTopic : list) {
                    arrayList.add(new com.facebook.rti.mqtt.protocol.messages.SubscribeTopic(subscribeTopic.a, subscribeTopic.b));
                }
                this.f23374a.c.a(arrayList);
            }
        }

        public final void mo3427b(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
            this.f23374a.a();
            MqttConnectionManager mqttConnectionManager = this.f23374a.c;
            if (mqttConnectionManager.w.c(list)) {
                MqttConnectionManager.x(mqttConnectionManager);
            }
        }

        public final void mo3418a(List<StickySubscribeTopic> list) {
            this.f23374a.a();
            if (list != null && !list.isEmpty()) {
                List arrayList = new ArrayList(list.size());
                for (StickySubscribeTopic stickySubscribeTopic : list) {
                    SubscribeTopic subscribeTopic = stickySubscribeTopic.a;
                    arrayList.add(new com.facebook.rti.mqtt.protocol.messages.SubscribeTopic(subscribeTopic.a, subscribeTopic.b));
                }
                this.f23374a.c.a(arrayList);
            }
        }

        public final void mo3421a(boolean z, List<SubscribeTopic> list, List<String> list2) {
            this.f23374a.a();
            Object obj = ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) ? null : 1;
            Optional withType = Absent.withType();
            Optional withType2 = Absent.withType();
            synchronized (MqttService.ac) {
                if (this.f23374a.c.b(z)) {
                    withType = Optional.of(Boolean.valueOf(z));
                    withType2 = Optional.of(Integer.valueOf(this.f23374a.c.l()));
                }
                if (withType.isPresent() || obj != null) {
                    this.f23374a.m31523a(withType, withType2, list, list2);
                }
            }
        }

        public final void mo3420a(boolean z) {
            this.f23374a.a();
            MqttService.m31530b(this.f23374a, z);
        }

        public final String mo3429c() {
            this.f23374a.a();
            return this.f23374a.c;
        }

        public final String mo3431d() {
            this.f23374a.a();
            try {
                return this.f23374a.h.a(this.f23374a.c.p()).a();
            } catch (Throwable th) {
                return th.toString();
            }
        }

        public final String mo3433e() {
            this.f23374a.a();
            if (MqttPushServiceBootstrap.E != null) {
                return MqttPushServiceBootstrap.E.a().toString();
            }
            return "";
        }

        public final MqttChannelStateInfo mo3434f() {
            this.f23374a.a();
            return MqttService.m31527b(this.f23374a, mo3429c());
        }
    }

    /* compiled from: fragment coordinator */
    class C09522 implements Provider<Boolean> {
        final /* synthetic */ MqttService f23480a;

        C09522(MqttService mqttService) {
            this.f23480a = mqttService;
        }

        public Object get() {
            return Boolean.valueOf(this.f23480a.c.u.get());
        }
    }

    /* compiled from: fragment coordinator */
    class C09533 implements NonInjectProvider<String> {
        final /* synthetic */ MqttService f23481a;

        C09533(MqttService mqttService) {
            this.f23481a = mqttService;
        }

        public final Object m31786a() {
            RequestRoutingHelper requestRoutingHelper = this.f23481a.f23350L;
            String str = null;
            if (requestRoutingHelper.f23464b == Product.MESSENGER || requestRoutingHelper.f23464b == Product.PAA) {
                str = requestRoutingHelper.f23463a.m2685a(RequestRoutingXConfig.d, null);
            }
            return str;
        }
    }

    /* compiled from: fragment coordinator */
    class C09544 implements NonInjectProvider<Long> {
        final /* synthetic */ MqttService f23482a;

        C09544(MqttService mqttService) {
            this.f23482a = mqttService;
        }

        public final Object m31788a() {
            long longValue = ((Long) this.f23482a.f23340B.get()).longValue();
            if (this.f23482a.f23341C.mo286a(MqttPrefKeys.f23401c, false)) {
                longValue = (longValue | BitmaskEnumUtil.m32026a(MqttCapability.USER_AND_DEVICE_AUTH)) | BitmaskEnumUtil.m32026a(MqttCapability.SHARED_SECRET);
            }
            return Long.valueOf(longValue);
        }
    }

    /* compiled from: fragment coordinator */
    final class AnonymousClass11 implements NonInjectProvider<T> {
        final /* synthetic */ Provider f23483a;

        AnonymousClass11(Provider provider) {
            this.f23483a = provider;
        }

        public final T m31789a() {
            return this.f23483a.get();
        }
    }

    /* compiled from: fragment coordinator */
    class C09555 implements NonInjectProvider<MqttTopic> {
        final /* synthetic */ MqttService f23484a;

        C09555(MqttService mqttService) {
            this.f23484a = mqttService;
        }

        public final Object m31790a() {
            return new ThriftMqttTopic(((Boolean) this.f23484a.f23345G.get()).booleanValue());
        }
    }

    /* compiled from: fragment coordinator */
    class C09596 implements NonInjectProvider<Boolean> {
        final /* synthetic */ MqttService f23512a;

        C09596(MqttService mqttService) {
            this.f23512a = mqttService;
        }

        public final Object m31834a() {
            return Boolean.valueOf(this.f23512a.f23363Y.m2189a(373, false));
        }
    }

    private static <T extends Context> void m31524a(Class<T> cls, T t) {
        m31525a((Object) t, (Context) t);
    }

    private static void m31525a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MqttService) obj).m31522a(MqttUserAuthCredentials.m31644a(injectorLike), MqttServiceIdManager.m31652a(injectorLike), MqttStats.m31660a(injectorLike), MqttConnectionConfigManager.m31664a(injectorLike), MqttWakeLockHolder.m31676a(injectorLike), STATICDI_MULTIBIND_PROVIDER$MqttPushHandler.m31698a(injectorLike), PushStateBroadcaster.m9409a(injectorLike), Handler_MqttThreadMethodAutoProvider.m31699a(injectorLike), ServiceChannelStateListenerManager.m31701a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4430), FbSharedPreferencesImpl.m1826a(injectorLike), FbTracer.m31708a(injectorLike), MqttLiteAnalyticsSamplePolicy.m31717a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4296), IdBasedProvider.m1811a(injectorLike, 4284), IdBasedProvider.m1811a(injectorLike, 4292), MqttliteKeepaliveParms.m31721a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4286), RequestRoutingHelper.m31769a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4225), IdBasedProvider.m1811a(injectorLike, 4294), IdBasedProvider.m1811a(injectorLike, 4424), CrossProcessFbBroadcastManager.m3644a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4278), IdBasedProvider.m1811a(injectorLike, 4282), RefCode.m31773a(injectorLike), C0061x63d21d68.m2105a(injectorLike), MqttTrafficControlParams.m31774a(injectorLike), WhistleCoreBuilder.m31779a(injectorLike), IdBasedProvider.m1811a(injectorLike, 752), IdBasedProvider.m1811a(injectorLike, 4288), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4274));
    }

    private void m31522a(MqttUserAuthCredentials mqttUserAuthCredentials, MqttServiceIdManager mqttServiceIdManager, MqttStats mqttStats, MqttConnectionConfigManager mqttConnectionConfigManager, MqttWakeLockHolder mqttWakeLockHolder, Set<MqttPushHandler> set, PushStateBroadcaster pushStateBroadcaster, Handler handler, ServiceChannelStateListenerManager serviceChannelStateListenerManager, MonotonicClock monotonicClock, Provider<Long> provider, FbSharedPreferences fbSharedPreferences, FbTracer fbTracer, MqttLiteAnalyticsSamplePolicy mqttLiteAnalyticsSamplePolicy, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, MqttliteKeepaliveParms mqttliteKeepaliveParms, FbErrorReporter fbErrorReporter, Provider<Boolean> provider5, RequestRoutingHelper requestRoutingHelper, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<Integer> provider8, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider9, Provider<Boolean> provider10, RefCode refCode, ExecutorService executorService, MqttTrafficControlParams mqttTrafficControlParams, WhistleCoreBuilder whistleCoreBuilder, Provider<TriState> provider11, Provider<Boolean> provider12, GatekeeperStore gatekeeperStore, Provider<Boolean> provider13) {
        this.f23365r = mqttUserAuthCredentials;
        this.f23366s = mqttServiceIdManager;
        this.f23367t = mqttStats;
        this.f23368u = mqttConnectionConfigManager;
        this.f23369v = mqttWakeLockHolder;
        this.f23370w = set;
        this.f23371x = pushStateBroadcaster;
        this.f23372y = handler;
        this.f23373z = serviceChannelStateListenerManager;
        this.f23339A = monotonicClock;
        this.f23340B = provider;
        this.f23341C = fbSharedPreferences;
        this.f23342D = fbTracer;
        this.f23343E = mqttLiteAnalyticsSamplePolicy;
        this.f23344F = provider2;
        this.f23345G = provider3;
        this.f23346H = provider4;
        this.f23347I = mqttliteKeepaliveParms;
        this.f23348J = fbErrorReporter;
        this.f23349K = provider5;
        this.f23350L = requestRoutingHelper;
        this.f23351M = provider6;
        this.f23352N = provider7;
        this.f23353O = provider8;
        this.f23354P = fbBroadcastManager;
        this.f23355Q = provider9;
        this.f23356R = provider10;
        this.f23357S = refCode;
        this.f23358T = executorService;
        this.f23359U = mqttTrafficControlParams;
        this.f23360V = whistleCoreBuilder;
        this.f23361W = provider11;
        this.f23362X = provider12;
        this.f23363Y = gatekeeperStore;
        this.f23364Z = provider13;
    }

    public final void m31560a(Intent intent, int i, int i2) {
        if (intent != null) {
            if ("Orca.FBNS_STOP".equals(intent.getAction())) {
                if (this.f23341C.mo286a(MqttPrefKeys.f23401c, false)) {
                    this.f23341C.edit().putBoolean(MqttPrefKeys.f23401c, false).commit();
                    b(DisconnectDetailReason.KICK_CONFIG_CHANGED);
                    b(ConnectTriggerReason.CONFIG_CHANGED);
                    return;
                }
                return;
            } else if ("Orca.FBNS_START".equals(intent.getAction())) {
                ConnectTriggerReason connectTriggerReason = ConnectTriggerReason.PERSISTENT_KICK;
                if (!this.f23341C.mo286a(MqttPrefKeys.f23401c, false)) {
                    this.f23341C.edit().putBoolean(MqttPrefKeys.f23401c, true).commit();
                    b(DisconnectDetailReason.KICK_CONFIG_CHANGED);
                    connectTriggerReason = ConnectTriggerReason.CONFIG_CHANGED;
                }
                a(connectTriggerReason);
                return;
            }
        }
        super.a(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        return this.ah;
    }

    protected final boolean m31572j() {
        return true;
    }

    public final boolean m31576n() {
        return super.n() && this.f23365r.m31645a() != MqttAuthenticationKeySecretPair.a;
    }

    public final void m31577q() {
        super.q();
        this.f23373z.m31703a();
    }

    public final void mo822a(Object obj, Object obj2) {
        this.ae.m6132a(obj, obj2);
    }

    public final Object mo818a(Object obj) {
        return this.ae.m6131a(obj);
    }

    public final String m31570e() {
        return "MqttLite";
    }

    protected final Looper m31569b() {
        if (this.aa == null) {
            this.aa = new MqttServiceLooperAccessor(this).f23375a;
        }
        return this.aa;
    }

    protected final void m31571f() {
        AppInitLockHelper.m8874a(this);
        m31524a(MqttService.class, (Context) this);
        MqttPayloadCompressionUtil mqttPayloadCompressionUtil = new MqttPayloadCompressionUtil();
        Provider c09522 = new C09522(this);
        C09533 c09533 = new C09533(this);
        SignatureAuthSecureIntent signatureAuthSecureIntent = new SignatureAuthSecureIntent(this);
        FbnsServiceIdManager fbnsServiceIdManager = new FbnsServiceIdManager(this, new DeviceIdAndSecretSharer(this, new DeviceIdAndSecretSharingRequester(this, signatureAuthSecureIntent)));
        MqttDeviceAuthCredentials mqttDeviceAuthCredentials = new MqttDeviceAuthCredentials(this);
        FbnsServiceBootstrap.a(this, this.f23366s, this.f23365r, fbnsServiceIdManager, mqttDeviceAuthCredentials, this.f23368u, signatureAuthSecureIntent, new C09544(this), m31516a(this.f23344F), new C09555(this), m31516a(this.f23346H), c09533, m31516a(this.f23351M), m31516a(this.f23355Q), new ThriftPayloadEncoder(mqttPayloadCompressionUtil), mqttPayloadCompressionUtil, m31516a(this.f23352N), m31516a(this.f23353O), m31516a(this.f23356R), this.f23347I, m31516a(c09522), true, this.f23372y, new MqttFbTraceLogger(this.f23342D, c09522), this.f23343E, this.f23360V, this.f23357S, this.f23359U, this.f23366s.m31654a(), m31516a(this.f23362X), new C09596(this), m31516a(this.f23364Z));
        this.ad = Executors.newSingleThreadExecutor();
    }

    protected final void m31574l() {
        super.l();
        this.f23341C.mo279a(PushPrefKeys.f23602a, (OnSharedPreferenceChangeListener) this);
    }

    protected final void m31573k() {
        if (TriState.YES.equals(this.f23361W.get())) {
            this.c.a(this.j.b());
        }
    }

    protected final void m31575m() {
        super.m();
        this.f23341C.mo289b(PushPrefKeys.f23602a, (OnSharedPreferenceChangeListener) this);
    }

    public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        boolean a = this.f23341C.mo286a(PushPrefKeys.f23602a, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("make_user_available_when_in_foreground", a);
            this.c.a("/set_client_settings", jSONObject.toString(), MqttQOSLevel.FIRE_AND_FORGET);
        } catch (JSONException e) {
        } catch (MqttException e2) {
        }
    }

    protected final void m31565a(String str, byte[] bArr, long j) {
        try {
            this.f23369v.f23405a.m31692c();
            if (str.startsWith("/t_ec")) {
                m31526a(str, bArr);
            } else if ("/fbns_msg".equals(str) || "/fbns_reg_resp".equals(str)) {
                long now = this.f23339A.now();
                super.a(str, bArr, j);
                long now2 = this.f23339A.now();
                if (now != now2) {
                    this.f23369v.f23405a.m31689a("FBNS", now2 - now);
                }
                this.f23369v.f23405a.m31693d();
            } else {
                PublishedPayloadDescriptor publishedPayloadDescriptor = new PublishedPayloadDescriptor(str, bArr, j);
                this.f23371x.m9411a(publishedPayloadDescriptor, true);
                ExecutorDetour.a(this.ad, new 7(this, publishedPayloadDescriptor), 1509275493);
            }
        } catch (Exception e) {
            this.f23369v.f23405a.m31693d();
        }
    }

    protected final boolean m31568a(ConnectionState connectionState) {
        boolean a = super.a(connectionState);
        if (a) {
            this.f23373z.m31704a(m31527b(this, connectionState.name()));
        }
        return a;
    }

    protected final void m31566a(boolean z) {
        if (z) {
            int a = this.f23347I.f23449c.mo572a(ExperimentsForKeepaliveExperimentModule.f23611g, 0);
            Integer.valueOf(a);
            Long.valueOf(this.f.now());
            if (a == 0) {
                m31551u();
            } else if (this.ag == null) {
                a = this.af.nextInt(a + 1);
                long now = this.f.now() + ((long) a);
                Long.valueOf(now);
                Integer.valueOf(a);
                this.ag = Long.valueOf(now);
                HandlerDetour.b(this.f23372y, new 8(this), (long) a, 414683066);
            }
        }
    }

    private void m31551u() {
        Long.valueOf(this.f.now());
        MqttConnectionManager mqttConnectionManager = this.c;
        if (mqttConnectionManager.n.a.f()) {
            mqttConnectionManager.c();
        }
    }

    protected final void m31567a(boolean z, int i) {
        if (((Boolean) this.f23349K.get()).booleanValue()) {
            m31523a(Optional.of(Boolean.valueOf(z)), Optional.of(Integer.valueOf(i)), null, null);
        } else {
            super.a(z, i);
        }
    }

    protected final void m31578r() {
        this.f23354P.mo406a(new Intent("ACTION_MQTT_NO_AUTH"));
    }

    public static void m31530b(MqttService mqttService, boolean z) {
        synchronized (ac) {
            if (mqttService.c.b(z)) {
                mqttService.f23347I.m31724a(!z);
                mqttService.m31567a(z, mqttService.c.l());
            }
        }
    }

    public static String m31554v(MqttService mqttService) {
        ConnectionState connectionState = ConnectionState.DISCONNECTED;
        if (mqttService.c.i()) {
            connectionState = ConnectionState.CONNECTED;
        } else if (mqttService.c.h()) {
            connectionState = ConnectionState.CONNECTING;
        }
        return connectionState.name();
    }

    public static MqttChannelStateInfo m31527b(MqttService mqttService, String str) {
        MqttChannelStateInfo.ConnectionState connectionState = MqttChannelStateInfo.ConnectionState.DISCONNECTED;
        try {
            connectionState = MqttChannelStateInfo.ConnectionState.valueOf(str);
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e2) {
        }
        return new MqttChannelStateInfo(connectionState, mqttService.f23339A.now(), mqttService.c.m(), mqttService.c.n(), mqttService.c.o());
    }

    public final void m31564a(String str, String str2, Throwable th) {
        this.f23348J.m2343a(str, str2, th);
    }

    public final void m31563a(String str, long j, boolean z) {
        if (str.startsWith("PUBLISH_")) {
            str = new ThriftMqttTopic(((Boolean) this.f23345G.get()).booleanValue()).m32031b(str.substring(8));
        }
        this.f23367t.m31663a(str, j, z);
    }

    private void m31523a(Optional<Boolean> optional, Optional<Integer> optional2, List<SubscribeTopic> list, List<String> list2) {
        optional.orNull();
        optional2.orNull();
        ExecutorDetour.a(this.k, new 9(this, optional, optional2, list, list2), -1986876809);
    }

    public static List<com.facebook.rti.mqtt.protocol.messages.SubscribeTopic> m31528b(List<SubscribeTopic> list) {
        if (list == null) {
            return null;
        }
        List<com.facebook.rti.mqtt.protocol.messages.SubscribeTopic> arrayList = new ArrayList(list.size());
        for (SubscribeTopic subscribeTopic : list) {
            arrayList.add(new com.facebook.rti.mqtt.protocol.messages.SubscribeTopic(subscribeTopic.a, subscribeTopic.b));
        }
        return arrayList;
    }

    private void m31526a(String str, byte[] bArr) {
        ExecutorDetour.a(this.f23358T, new 10(this, str, bArr), 1449586913);
    }

    private static <T> NonInjectProvider<T> m31516a(Provider<T> provider) {
        return new AnonymousClass11(provider);
    }
}
