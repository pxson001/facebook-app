package com.facebook.sensor;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.facebook.common.android.SensorManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.lockscreenservice.LockScreenService.LockProximitySensorListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sessionLatch has been interrupted. */
public class ProximitySensor {
    public static final Class<?> f4880a = ProximitySensor.class;
    public static final String f4881b = (f4880a.getSimpleName() + "_missing_sensor");
    public static final String f4882c = (f4880a.getSimpleName() + "_multiple_sensors");
    private static volatile ProximitySensor f4883n;
    private final SensorManager f4884d;
    public final DefaultAndroidThreadUtil f4885e;
    public final Handler f4886f;
    public final Sensor f4887g;
    private final Set<ProximitySensorListener> f4888h = new HashSet();
    public final Runnable f4889i = new RunnableReportFirstEvent(this);
    private MySensorEventListener f4890j;
    public boolean f4891k;
    public float f4892l;
    public boolean f4893m;

    /* compiled from: sessionLatch has been interrupted. */
    class MySensorEventListener implements SensorEventListener {
        final /* synthetic */ ProximitySensor f4876a;
        private boolean f4877b = true;
        private boolean f4878c;

        public MySensorEventListener(ProximitySensor proximitySensor) {
            this.f4876a = proximitySensor;
        }

        public static void m7679a(MySensorEventListener mySensorEventListener) {
            mySensorEventListener.f4878c = true;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            boolean z = false;
            if (!this.f4878c) {
                this.f4876a.f4885e.a();
                this.f4876a.f4892l = sensorEvent.values[0];
                Class cls = ProximitySensor.f4880a;
                new StringBuilder("proximity cm changed to ").append(this.f4876a.f4892l).append("/").append(this.f4876a.f4887g.getMaximumRange());
                if (this.f4877b) {
                    boolean z2;
                    if (this.f4876a.f4891k) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    Preconditions.checkState(z2);
                    this.f4877b = false;
                    if (!this.f4876a.f4893m) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    this.f4876a.f4893m = true;
                    HandlerDetour.b(this.f4876a.f4886f, this.f4876a.f4889i, 500, -89730849);
                    return;
                }
                if (this.f4876a.f4893m) {
                    this.f4876a.f4893m = false;
                    HandlerDetour.a(this.f4876a.f4886f, this.f4876a.f4889i);
                }
                ProximitySensor.m7684c(this.f4876a);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    /* compiled from: sessionLatch has been interrupted. */
    class RunnableReportFirstEvent implements Runnable {
        final /* synthetic */ ProximitySensor f4879a;

        public RunnableReportFirstEvent(ProximitySensor proximitySensor) {
            this.f4879a = proximitySensor;
        }

        public void run() {
            boolean z;
            this.f4879a.f4885e.a();
            if (this.f4879a.f4891k) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z);
            Preconditions.checkState(this.f4879a.f4893m);
            this.f4879a.f4893m = false;
            ProximitySensor.m7684c(this.f4879a);
        }
    }

    public static com.facebook.sensor.ProximitySensor m7680a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4883n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sensor.ProximitySensor.class;
        monitor-enter(r1);
        r0 = f4883n;	 Catch:{ all -> 0x003a }
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
        r0 = m7682b(r0);	 Catch:{ all -> 0x0035 }
        f4883n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4883n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sensor.ProximitySensor.a(com.facebook.inject.InjectorLike):com.facebook.sensor.ProximitySensor");
    }

    private static ProximitySensor m7682b(InjectorLike injectorLike) {
        return new ProximitySensor(Handler_ForUiThreadMethodAutoProvider.b(injectorLike), SensorManagerMethodAutoProvider.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ProximitySensor(Handler handler, SensorManager sensorManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4886f = (Handler) Preconditions.checkNotNull(handler);
        this.f4884d = (SensorManager) Preconditions.checkNotNull(sensorManager);
        this.f4885e = (DefaultAndroidThreadUtil) Preconditions.checkNotNull(defaultAndroidThreadUtil);
        Preconditions.checkNotNull(abstractFbErrorReporter);
        this.f4887g = this.f4884d.getDefaultSensor(8);
        if (sensorManager.getDefaultSensor(8) == null) {
            abstractFbErrorReporter.a(f4881b, m7681a(sensorManager));
        }
        if (sensorManager.getSensorList(8).size() > 1) {
            abstractFbErrorReporter.a(f4882c, m7681a(sensorManager));
        }
    }

    public final boolean m7685a(LockProximitySensorListener lockProximitySensorListener) {
        this.f4885e.a();
        if (this.f4887g == null) {
            return false;
        }
        if (!this.f4888h.add(lockProximitySensorListener)) {
            return true;
        }
        if (this.f4888h.size() <= 1) {
            Preconditions.checkState(this.f4890j == null);
            this.f4890j = new MySensorEventListener(this);
            if (this.f4884d.registerListener(this.f4890j, this.f4887g, 0)) {
                return true;
            }
            this.f4888h.remove(lockProximitySensorListener);
            MySensorEventListener.m7679a(this.f4890j);
            this.f4890j = null;
            return false;
        } else if (!this.f4891k) {
            return true;
        } else {
            lockProximitySensorListener.a(m7683b());
            return true;
        }
    }

    public final void m7686b(LockProximitySensorListener lockProximitySensorListener) {
        boolean z = false;
        this.f4885e.a();
        if (this.f4888h.remove(lockProximitySensorListener) && this.f4888h.size() == 0) {
            this.f4891k = false;
            HandlerDetour.a(this.f4886f, this.f4889i);
            if (this.f4890j != null) {
                z = true;
            }
            Preconditions.checkState(z);
            this.f4884d.unregisterListener(this.f4890j);
            MySensorEventListener.m7679a(this.f4890j);
            this.f4890j = null;
        }
    }

    private boolean m7683b() {
        return this.f4892l < Math.min(5.0f, this.f4887g.getMaximumRange());
    }

    public static void m7684c(ProximitySensor proximitySensor) {
        proximitySensor.f4891k = true;
        boolean b = proximitySensor.m7683b();
        ImmutableList copyOf = ImmutableList.copyOf(proximitySensor.f4888h);
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            LockProximitySensorListener lockProximitySensorListener = (LockProximitySensorListener) copyOf.get(i);
            if (proximitySensor.f4888h.contains(lockProximitySensorListener)) {
                lockProximitySensorListener.a(b);
            }
        }
    }

    @TargetApi(9)
    public static String m7681a(SensorManager sensorManager) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            stringBuilder.append("sensor ").append(sensor.getName()).append(": type=").append(sensor.getType()).append(" vendor=").append(sensor.getVendor()).append(" maxRange=").append(sensor.getMaximumRange()).append(" power=").append(sensor.getPower());
            if (VERSION.SDK_INT >= 9) {
                stringBuilder.append(" minDelay=").append(sensor.getMinDelay());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
