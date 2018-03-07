package com.facebook.bugreporter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: android.media.metadata.DISPLAY_SUBTITLE */
public class RageShakeDetector$AsyncSensorRegistration {
    private final Context f10649a;
    private final DefaultSerialListeningExecutorService f10650b;
    private final SensorEventListener f10651c;
    public final AtomicInteger f10652d = new AtomicInteger(0);
    private SensorManager f10653e;
    private Future<?> f10654f;
    private final Runnable f10655g = new C10191(this);

    /* compiled from: android.media.metadata.DISPLAY_SUBTITLE */
    class C10191 implements Runnable {
        final /* synthetic */ RageShakeDetector$AsyncSensorRegistration f10645a;
        private boolean f10646b;

        C10191(RageShakeDetector$AsyncSensorRegistration rageShakeDetector$AsyncSensorRegistration) {
            this.f10645a = rageShakeDetector$AsyncSensorRegistration;
        }

        public void run() {
            boolean z = this.f10645a.f10652d.get() > 0;
            if (this.f10646b != z) {
                if (z) {
                    RageShakeDetector$AsyncSensorRegistration.m18675e(this.f10645a);
                } else {
                    RageShakeDetector$AsyncSensorRegistration.m18676f(this.f10645a);
                }
                this.f10646b = z;
            }
        }
    }

    /* compiled from: android.media.metadata.DISPLAY_SUBTITLE */
    class WrappedSensorEventListener implements SensorEventListener {
        final /* synthetic */ RageShakeDetector$AsyncSensorRegistration f10647a;
        private final SensorEventListener f10648b;

        public WrappedSensorEventListener(RageShakeDetector$AsyncSensorRegistration rageShakeDetector$AsyncSensorRegistration, SensorEventListener sensorEventListener) {
            this.f10647a = rageShakeDetector$AsyncSensorRegistration;
            this.f10648b = sensorEventListener;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.f10647a.f10652d.get() > 0) {
                this.f10648b.onSensorChanged(sensorEvent);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
            if (this.f10647a.f10652d.get() > 0) {
                this.f10648b.onAccuracyChanged(sensor, i);
            }
        }
    }

    public RageShakeDetector$AsyncSensorRegistration(Context context, DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, SensorEventListener sensorEventListener) {
        this.f10649a = context;
        this.f10650b = defaultSerialListeningExecutorService;
        this.f10651c = new WrappedSensorEventListener(this, sensorEventListener);
    }

    private SensorManager m18673c() {
        if (this.f10653e == null) {
            this.f10653e = (SensorManager) this.f10649a.getSystemService("sensor");
        }
        return this.f10653e;
    }

    @MainThread
    public final void m18677a() {
        if (this.f10652d.getAndIncrement() == 0) {
            m18674d();
        }
    }

    @MainThread
    public final void m18678b() {
        int decrementAndGet = this.f10652d.decrementAndGet();
        if (decrementAndGet == 0) {
            m18674d();
        } else if (decrementAndGet < 0) {
            throw new IllegalStateException("Imbalanced start/stopReceiving calls: count=" + decrementAndGet);
        }
    }

    private void m18674d() {
        if (this.f10654f != null) {
            this.f10654f.cancel(false);
            this.f10654f = null;
        }
        this.f10654f = this.f10650b.a(this.f10655g);
    }

    @WorkerThread
    public static void m18675e(RageShakeDetector$AsyncSensorRegistration rageShakeDetector$AsyncSensorRegistration) {
        SensorManager c = rageShakeDetector$AsyncSensorRegistration.m18673c();
        c.registerListener(rageShakeDetector$AsyncSensorRegistration.f10651c, c.getDefaultSensor(1), 2);
    }

    @WorkerThread
    public static void m18676f(RageShakeDetector$AsyncSensorRegistration rageShakeDetector$AsyncSensorRegistration) {
        rageShakeDetector$AsyncSensorRegistration.m18673c().unregisterListener(rageShakeDetector$AsyncSensorRegistration.f10651c);
    }
}
