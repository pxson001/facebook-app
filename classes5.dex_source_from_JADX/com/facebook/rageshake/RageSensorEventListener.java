package com.facebook.rageshake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: android.media.metadata.DISPLAY_TITLE */
public abstract class RageSensorEventListener implements SensorEventListener {
    public Inspector f10643a = new Inspector();

    protected abstract void mo1122a();

    public void onSensorChanged(SensorEvent sensorEvent) {
        Inspector inspector = this.f10643a;
        int d = inspector.b.d();
        if (d == 0) {
            inspector.c = sensorEvent.timestamp + 1000000000;
            inspector.b.a(new Tuple(sensorEvent));
        } else if ((sensorEvent.timestamp >= inspector.c || d >= 32) && d >= 10) {
            Tuple tuple = (Tuple) inspector.b.a();
            tuple.a(sensorEvent);
            inspector.b.a(tuple);
        } else {
            inspector.b.a(new Tuple(sensorEvent));
        }
        if (this.f10643a.b()) {
            this.f10643a.a();
            mo1122a();
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
