package com.facebook.richdocument.view.transition.motion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.common.util.CollectionUtil;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: organic_surface */
public class GyroBasedMediaTiltSensor implements SensorEventListener {
    public final Context f7005a;
    private final SmoothingFilter f7006b;
    private final float[] f7007c = new float[3];
    public final float[] f7008d = new float[RichDocumentUIConfig.f6556i];
    public int f7009e = 0;
    private boolean f7010f;
    private boolean f7011g;
    private float f7012h;
    private float f7013i = RichDocumentUIConfig.f6555h;
    private float f7014j = RichDocumentUIConfig.f6557j;
    private float f7015k = RichDocumentUIConfig.f6558k;
    public final List<MediaTiltEventListener> f7016l;

    public GyroBasedMediaTiltSensor(Context context) {
        this.f7005a = context;
        this.f7006b = new SmoothingFilter(1.5f);
        this.f7006b.f7025b = 110;
        this.f7016l = new CopyOnWriteArrayList();
    }

    private void m7334b() {
        if (!this.f7010f) {
            this.f7010f = true;
            this.f7011g = true;
            this.f7012h = 0.0f;
            Arrays.fill(this.f7008d, 0.0f);
            this.f7009e = 0;
            SensorManager sensorManager = (SensorManager) this.f7005a.getSystemService("sensor");
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(4), 2);
        }
    }

    private void m7336c() {
        this.f7010f = false;
        SensorManager sensorManager = (SensorManager) this.f7005a.getSystemService("sensor");
        sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(4));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f7010f && sensorEvent.sensor.getType() == 4) {
            Object obj;
            System.arraycopy(sensorEvent.values, 0, this.f7007c, 0, 3);
            this.f7006b.m7346a(sensorEvent.timestamp / 1000000, this.f7007c);
            long j = this.f7006b.f7028e;
            SmoothingFilter smoothingFilter = this.f7006b;
            if (smoothingFilter.f7026c == null || !SmoothingFilter.m7345a(smoothingFilter.f7026c)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null && j > 0) {
                float[] fArr = this.f7006b.f7026c;
                float a = m7332a(fArr[0], j);
                float a2 = -1.0f * m7332a(fArr[1], j);
                float a3 = m7332a(fArr[2], j);
                this.f7008d[this.f7009e] = a2;
                this.f7009e = (this.f7009e + 1) % this.f7008d.length;
                if (m7333a(a, a2, a3)) {
                    m7335b(a2);
                }
            }
        }
    }

    private static float m7332a(float f, long j) {
        return (float) ((Math.toDegrees((double) f) * ((double) ((float) j))) / 1000.0d);
    }

    private boolean m7333a(float f, float f2, float f3) {
        float f4 = 0.0f;
        for (float abs : this.f7008d) {
            f4 += Math.abs(abs);
        }
        if (f4 / ((float) this.f7008d.length) < this.f7014j) {
            return false;
        }
        boolean z;
        float abs2 = Math.abs(f2);
        if (Math.abs(f) > this.f7015k * abs2) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(f3) > abs2 * this.f7015k) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || r3) {
            return false;
        }
        return true;
    }

    private void m7335b(float f) {
        if (!this.f7011g || Math.abs(f) < this.f7013i / 2.0f) {
            float f2 = this.f7012h;
            this.f7012h += f;
            if (this.f7012h < this.f7013i * -1.0f) {
                this.f7012h = this.f7013i * -1.0f;
            } else if (this.f7012h > this.f7013i) {
                this.f7012h = this.f7013i;
            }
            if (Math.abs(this.f7012h - f2) > this.f7014j) {
                f2 = this.f7012h / this.f7013i;
                if (CollectionUtil.b(this.f7016l)) {
                    for (MediaTiltPlugin a : this.f7016l) {
                        a.m7966a(Float.valueOf(f2));
                    }
                }
                return;
            }
            return;
        }
        this.f7011g = false;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final synchronized void m7338a(MediaTiltPlugin mediaTiltPlugin) {
        if (!this.f7016l.contains(mediaTiltPlugin)) {
            this.f7016l.add(mediaTiltPlugin);
            m7334b();
        }
    }

    public final synchronized void m7339b(MediaTiltPlugin mediaTiltPlugin) {
        this.f7016l.remove(mediaTiltPlugin);
        if (this.f7016l.isEmpty()) {
            m7336c();
        }
    }

    public final synchronized void m7337a() {
        this.f7016l.clear();
        m7336c();
    }
}
