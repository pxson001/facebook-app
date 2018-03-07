package com.facebook.push.mqtt.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.base.service.CachedBindServiceResult;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.abtest.ExperimentsForMqttPushModule;
import com.facebook.push.mqtt.ipc.IMqttPushService;
import com.facebook.push.mqtt.ipc.IMqttPushService.Stub;
import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;
import com.facebook.push.mqtt.service.MqttPushServiceClient.PublishParams;
import com.facebook.push.mqtt.service.response.JsonMqttResponseProcessor.Callback;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.push.mqtt.service.response.MqttResponse.ErrorType;
import com.facebook.push.mqtt.service.response.MqttResponseManager;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.facebook.push.mqtt.service.response.SimpleMqttPushServiceClientFlightRecorderEvent;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sync.connection.SyncQueueTrackerImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: fetch_single_story */
public class MqttPushServiceClientImpl implements MqttPushServiceClient {
    private static final Class<?> f11626b = MqttPushServiceClientImpl.class;
    private final Context f11627c;
    private final MqttResponseManager f11628d;
    private final Clock f11629e;
    public final MonotonicClock f11630f;
    public final MqttPushServiceClientFlightRecorder f11631g;
    private final PushServiceTargetingHelper f11632h;
    private final DefaultAndroidThreadUtil f11633i;
    private final MqttPushServiceConnection f11634j;
    private final QeAccessor f11635k;
    @GuardedBy("this")
    private final Set<MqttPublishListener> f11636l = Sets.a();
    @GuardedBy("this")
    private IMqttPushService f11637m;
    @GuardedBy("this")
    private boolean f11638n;

    /* compiled from: fetch_single_story */
    class MqttPushServiceConnection implements ServiceConnection {
        final /* synthetic */ MqttPushServiceClientImpl f11642a;
        private final CountDownLatch f11643b = new CountDownLatch(1);

        public MqttPushServiceConnection(MqttPushServiceClientImpl mqttPushServiceClientImpl) {
            this.f11642a = mqttPushServiceClientImpl;
        }

        public final boolean m12187a(long j) {
            return Uninterruptibles.a(this.f11643b, j, TimeUnit.MILLISECONDS);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f11642a.f11631g.a(new SimpleMqttPushServiceClientFlightRecorderEvent(this.f11642a.f11630f.now(), "ServiceConnected (MqttPushServiceClientManager)", new Object[0]));
            m12186a(iBinder);
            this.f11643b.countDown();
        }

        public final void m12186a(IBinder iBinder) {
            MqttPushServiceClientImpl.m12145a(this.f11642a, Stub.a(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f11642a.f11631g.a(new SimpleMqttPushServiceClientFlightRecorderEvent(this.f11642a.f11630f.now(), "ServiceDisconnected (MqttPushServiceClientManager)", new Object[0]));
            this.f11642a.m12169g();
        }
    }

    MqttPushServiceClientImpl(Context context, MqttResponseManager mqttResponseManager, Clock clock, PushServiceTargetingHelper pushServiceTargetingHelper, DefaultAndroidThreadUtil defaultAndroidThreadUtil, MonotonicClock monotonicClock, MqttPushServiceClientFlightRecorder mqttPushServiceClientFlightRecorder, QeAccessor qeAccessor) {
        this.f11627c = context;
        this.f11628d = mqttResponseManager;
        this.f11629e = clock;
        this.f11632h = pushServiceTargetingHelper;
        this.f11633i = defaultAndroidThreadUtil;
        this.f11630f = monotonicClock;
        this.f11631g = mqttPushServiceClientFlightRecorder;
        this.f11635k = qeAccessor;
        this.f11634j = new MqttPushServiceConnection(this);
    }

    public final boolean m12164b(long j) {
        this.f11633i.b();
        m12150j();
        CachedBindServiceResult a = this.f11632h.a(this.f11627c, new Intent(), this.f11634j, 1);
        if (!a.f10847a) {
            return false;
        }
        if (a.f10848b != null) {
            this.f11634j.m12186a(a.f10848b);
        } else if (!this.f11634j.m12187a(j)) {
            return false;
        }
        synchronized (this) {
            this.f11638n = true;
        }
        return true;
    }

    @VisibleForTesting
    public static synchronized void m12145a(MqttPushServiceClientImpl mqttPushServiceClientImpl, IMqttPushService iMqttPushService) {
        synchronized (mqttPushServiceClientImpl) {
            mqttPushServiceClientImpl.f11637m = iMqttPushService;
        }
    }

    @VisibleForTesting
    final synchronized void m12169g() {
        this.f11637m = null;
        m12151k();
    }

    public final boolean mo861a() {
        return m12148h().a();
    }

    public final boolean mo866b() {
        return m12148h().b();
    }

    public final boolean mo862a(long j) {
        return m12148h().a(j);
    }

    public final void mo860a(SyncQueueTrackerImpl syncQueueTrackerImpl) {
        m12148h().a(new SyncQueueTrackerStub(syncQueueTrackerImpl));
    }

    public final int mo855a(String str, JsonNode jsonNode, MqttQOSLevel mqttQOSLevel, @Nullable MqttPublishListener mqttPublishListener) {
        return mo856a(str, StringUtil.a(jsonNode.toString()), mqttQOSLevel, mqttPublishListener);
    }

    public final int mo856a(String str, byte[] bArr, MqttQOSLevel mqttQOSLevel, @Nullable MqttPublishListener mqttPublishListener) {
        IMqttPushService h = m12148h();
        com.facebook.push.mqtt.ipc.MqttPublishListener mqttPublishListener2 = null;
        if (mqttPublishListener != null) {
            mqttPublishListener2 = new MqttPublishListenerStub(this, mqttPublishListener);
            m12144a(mqttPublishListener);
        }
        return h.a(str, bArr, mqttQOSLevel.getValue(), mqttPublishListener2);
    }

    public final boolean mo863a(String str, JsonNode jsonNode, long j) {
        return mo864a(str, StringUtil.a(jsonNode.toString()), j, 0);
    }

    public final boolean mo864a(String str, byte[] bArr, long j, long j2) {
        return m12148h().a(str, bArr, j, null, j2);
    }

    public final boolean mo865a(String str, byte[] bArr, long j, long j2, @Nullable Integer num) {
        return m12148h().a(str, bArr, j, null, j2, num != null ? String.valueOf(num) : null);
    }

    public final <T> MqttResponse<T> mo858a(String str, JsonNode jsonNode, String str2, Callback<T> callback) {
        try {
            return m12146b(str, StringUtil.a(jsonNode.toString()), this.f11628d.a(str2, callback));
        } catch (Exception e) {
            return MqttResponse.a(e, this.f11629e.a());
        }
    }

    public final <T> MqttResponse<T> mo857a(String str, JsonNode jsonNode, MqttResponseProcessor<T> mqttResponseProcessor) {
        try {
            return m12146b(str, StringUtil.a(jsonNode.toString()), mqttResponseProcessor);
        } catch (Exception e) {
            return MqttResponse.a(e, this.f11629e.a());
        }
    }

    public final <T> MqttResponse<T> mo859a(String str, byte[] bArr, MqttResponseProcessor<T> mqttResponseProcessor) {
        try {
            return m12146b(str, bArr, mqttResponseProcessor);
        } catch (Exception e) {
            return MqttResponse.a(e, this.f11629e.a());
        }
    }

    private <T> MqttResponse<T> m12146b(String str, byte[] bArr, MqttResponseProcessor<T> mqttResponseProcessor) {
        PublishParams publishParams = new PublishParams(this.f11635k.a(ExperimentsForMqttPushModule.f10806c, a.a), this.f11635k.a(ExperimentsForMqttPushModule.f10808e, a.b), this.f11635k.a(ExperimentsForMqttPushModule.f10809f, a.c));
        if (!mo862a(publishParams.a)) {
            return MqttResponse.a(ErrorType.MQTT_FAILED_TO_CONNECT, this.f11629e.a());
        }
        mqttResponseProcessor.c();
        String a = this.f11635k.a(ExperimentsForMqttPushModule.f10807d, "pubandwait");
        try {
            long a2 = this.f11629e.a();
            boolean a3 = "publish".equals(a) ? mo856a(str, bArr, MqttQOSLevel.FIRE_AND_FORGET, null) != -1 : mo864a(str, bArr, publishParams.b, 0);
            MqttResponse<T> a4;
            if (a3) {
                try {
                    if (mqttResponseProcessor.a(publishParams.c)) {
                        a4 = MqttResponse.a(mqttResponseProcessor.e(), a2);
                        mqttResponseProcessor.d();
                        return a4;
                    }
                    a4 = MqttResponse.a(ErrorType.MQTT_DID_NOT_RECEIVE_RESPONSE, a2);
                    mqttResponseProcessor.d();
                    return a4;
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    a4 = MqttResponse.a(e, a2);
                    mqttResponseProcessor.d();
                    return a4;
                }
            }
            a4 = MqttResponse.a(ErrorType.MQTT_PUBLISH_FAILED, a2);
            return a4;
        } finally {
            mqttResponseProcessor.d();
        }
    }

    public final synchronized ConnectionState mo867c() {
        ConnectionState connectionState;
        try {
            m12149i();
            IMqttPushService iMqttPushService = this.f11637m;
            if (iMqttPushService == null) {
                connectionState = ConnectionState.DISCONNECTED;
            } else {
                connectionState = ConnectionState.valueOf(iMqttPushService.c());
            }
        } catch (RemoteException e) {
            connectionState = ConnectionState.DISCONNECTED;
        }
        return connectionState;
    }

    public final synchronized String mo868d() {
        String d;
        try {
            d = m12148h().d();
        } catch (RemoteException e) {
            d = e.toString();
        }
        return d;
    }

    public final synchronized String mo869e() {
        String e;
        try {
            e = m12148h().e();
        } catch (RemoteException e2) {
            e = e2.toString();
        }
        return e;
    }

    public final synchronized void mo870f() {
        if (this.f11638n) {
            m12143a(this.f11634j);
            this.f11638n = false;
        }
    }

    private void m12143a(ServiceConnection serviceConnection) {
        this.f11631g.a(new SimpleMqttPushServiceClientFlightRecorderEvent(this.f11630f.now(), "ServiceUnbound (MqttPushServiceClientManager)", new Object[0]));
        try {
            this.f11632h.a(serviceConnection);
        } catch (Throwable e) {
            BLog.b(f11626b, "Exception unbinding", e);
        }
    }

    private synchronized IMqttPushService m12148h() {
        IMqttPushService iMqttPushService;
        m12149i();
        iMqttPushService = this.f11637m;
        if (iMqttPushService == null) {
            throw new RemoteException();
        }
        return iMqttPushService;
    }

    private synchronized void m12149i() {
        if (!this.f11638n) {
            throw new RemoteException();
        }
    }

    private synchronized void m12150j() {
        if (this.f11638n) {
            throw new RemoteException();
        }
    }

    private synchronized void m12144a(MqttPublishListener mqttPublishListener) {
        this.f11636l.add(mqttPublishListener);
    }

    public static synchronized void m12147b(MqttPushServiceClientImpl mqttPushServiceClientImpl, MqttPublishListener mqttPublishListener) {
        synchronized (mqttPushServiceClientImpl) {
            mqttPushServiceClientImpl.f11636l.remove(mqttPublishListener);
        }
    }

    private synchronized void m12151k() {
        for (MqttPublishListener b : this.f11636l) {
            b.b();
        }
        this.f11636l.clear();
    }
}
