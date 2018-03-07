package com.facebook.camera.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;

/* compiled from: all_groups */
public class RotationMonitor implements SensorEventListener {
    public SensorManager f11060a;
    public Sensor f11061b;
    public Sensor f11062c;
    public boolean f11063d = false;
    private float[] f11064e = null;
    private float[] f11065f = null;
    private final float[] f11066g = new float[9];
    private final float[] f11067h = new float[9];
    private final float[] f11068i = new float[3];
    public float f11069j = 0.0f;
    public float f11070k = 0.0f;
    public long f11071l = 0;

    public RotationMonitor(Context context) {
        boolean z;
        this.f11060a = (SensorManager) context.getSystemService("sensor");
        this.f11061b = this.f11060a.getDefaultSensor(1);
        this.f11062c = this.f11060a.getDefaultSensor(2);
        if (this.f11061b == null || this.f11062c == null) {
            z = false;
        } else {
            z = true;
        }
        this.f11063d = z;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.f11064e = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.f11065f = sensorEvent.values;
        }
        if (this.f11064e != null && this.f11065f != null && SensorManager.getRotationMatrix(this.f11066g, this.f11067h, this.f11064e, this.f11065f)) {
            SensorManager.getOrientation(this.f11066g, this.f11068i);
            this.f11069j = (float) (((double) (this.f11068i[1] * 180.0f)) / 3.141592653589793d);
            this.f11070k = (float) (((double) (this.f11068i[2] * 180.0f)) / 3.141592653589793d);
            this.f11071l = SystemClock.uptimeMillis();
        }
    }
}
