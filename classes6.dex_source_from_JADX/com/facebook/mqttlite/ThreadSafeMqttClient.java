package com.facebook.mqttlite;

import com.facebook.debug.log.BLog;
import com.facebook.proxygen.MQTTClient;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;

/* compiled from: time_to_load_bootstrap_entities */
public class ThreadSafeMqttClient {
    public static final String f3033a = ThreadSafeMqttClient.class.getSimpleName();
    public final MQTTClient f3034b;
    public final Executor f3035c;
    public volatile boolean f3036d = false;

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01452 implements Runnable {
        final /* synthetic */ String[] f3018a;
        final /* synthetic */ int[] f3019b;
        final /* synthetic */ ThreadSafeMqttClient f3020c;

        public C01452(ThreadSafeMqttClient threadSafeMqttClient, String[] strArr, int[] iArr) {
            this.f3020c = threadSafeMqttClient;
            this.f3018a = strArr;
            this.f3019b = iArr;
        }

        public void run() {
            if (this.f3020c.f3036d) {
                BLog.a(ThreadSafeMqttClient.f3033a, "subscribe ignored as client has been closed");
            } else {
                this.f3020c.f3034b.subscribe(this.f3018a, this.f3019b);
            }
        }
    }

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01463 implements Runnable {
        final /* synthetic */ String[] f3021a;
        final /* synthetic */ int f3022b;
        final /* synthetic */ ThreadSafeMqttClient f3023c;

        public C01463(ThreadSafeMqttClient threadSafeMqttClient, String[] strArr, int i) {
            this.f3023c = threadSafeMqttClient;
            this.f3021a = strArr;
            this.f3022b = i;
        }

        public void run() {
            if (this.f3023c.f3036d) {
                BLog.a(ThreadSafeMqttClient.f3033a, "unsubscribe ignored as client has been closed");
            } else {
                this.f3023c.f3034b.unSubscribe(this.f3021a, this.f3022b);
            }
        }
    }

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01474 implements Runnable {
        final /* synthetic */ String f3024a;
        final /* synthetic */ byte[] f3025b;
        final /* synthetic */ int f3026c;
        final /* synthetic */ int f3027d;
        final /* synthetic */ ThreadSafeMqttClient f3028e;

        public C01474(ThreadSafeMqttClient threadSafeMqttClient, String str, byte[] bArr, int i, int i2) {
            this.f3028e = threadSafeMqttClient;
            this.f3024a = str;
            this.f3025b = bArr;
            this.f3026c = i;
            this.f3027d = i2;
        }

        public void run() {
            if (this.f3028e.f3036d) {
                BLog.a(ThreadSafeMqttClient.f3033a, "publish ignored as client has been closed");
            } else {
                this.f3028e.f3034b.publish(this.f3024a, this.f3025b, this.f3026c, this.f3027d);
            }
        }
    }

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01485 implements Runnable {
        final /* synthetic */ ThreadSafeMqttClient f3029a;

        public C01485(ThreadSafeMqttClient threadSafeMqttClient) {
            this.f3029a = threadSafeMqttClient;
        }

        public void run() {
            if (this.f3029a.f3036d) {
                BLog.a(ThreadSafeMqttClient.f3033a, "disconnect ignored as client has been closed");
                return;
            }
            String str = ThreadSafeMqttClient.f3033a;
            this.f3029a.f3034b.disconnect();
        }
    }

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01497 implements Runnable {
        final /* synthetic */ ThreadSafeMqttClient f3030a;

        public C01497(ThreadSafeMqttClient threadSafeMqttClient) {
            this.f3030a = threadSafeMqttClient;
        }

        public void run() {
            if (this.f3030a.f3036d) {
                BLog.a(ThreadSafeMqttClient.f3033a, "sendKeepAliveOnce ignored as client has been closed");
            } else {
                this.f3030a.f3034b.sendKeepAliveOnce();
            }
        }
    }

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01508 implements Runnable {
        final /* synthetic */ ThreadSafeMqttClient f3031a;

        public C01508(ThreadSafeMqttClient threadSafeMqttClient) {
            this.f3031a = threadSafeMqttClient;
        }

        public void run() {
            if (!this.f3031a.f3036d) {
                this.f3031a.f3034b.stopConnectingIfConnectNotSent();
            }
        }
    }

    /* compiled from: time_to_load_bootstrap_entities */
    public class C01519 implements Runnable {
        final /* synthetic */ ThreadSafeMqttClient f3032a;

        public C01519(ThreadSafeMqttClient threadSafeMqttClient) {
            this.f3032a = threadSafeMqttClient;
        }

        public void run() {
            if (this.f3032a.f3036d) {
                BLog.a(ThreadSafeMqttClient.f3033a, "close ignored as client has been closed");
                return;
            }
            String str = ThreadSafeMqttClient.f3033a;
            this.f3032a.f3034b.close();
            this.f3032a.f3036d = true;
        }
    }

    public ThreadSafeMqttClient(MQTTClient mQTTClient, Executor executor) {
        this.f3034b = mQTTClient;
        this.f3035c = executor;
    }

    public final void m4025a(String str, int i, byte[] bArr, int i2, int i3, boolean z) {
        final String str2 = str;
        final int i4 = i;
        final byte[] bArr2 = bArr;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        ExecutorDetour.a(this.f3035c, new Runnable(this) {
            final /* synthetic */ ThreadSafeMqttClient f3017g;

            public void run() {
                if (this.f3017g.f3036d) {
                    BLog.a(ThreadSafeMqttClient.f3033a, "connect ignored as client has been closed");
                    return;
                }
                String str = ThreadSafeMqttClient.f3033a;
                this.f3017g.f3034b.connect(str2, i4, bArr2, i5, i6, z2);
            }
        }, 1572949472);
    }
}
