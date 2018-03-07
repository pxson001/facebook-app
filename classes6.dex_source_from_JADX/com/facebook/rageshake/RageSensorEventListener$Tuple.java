package com.facebook.rageshake;

import android.hardware.SensorEvent;

/* compiled from: showTagExpansionOption */
public class RageSensorEventListener$Tuple {
    float f4383a;
    float f4384b;
    float f4385c;
    long f4386d;

    public RageSensorEventListener$Tuple(SensorEvent sensorEvent) {
        m6459a(sensorEvent);
    }

    public final void m6459a(SensorEvent sensorEvent) {
        this.f4383a = sensorEvent.values[0];
        this.f4384b = sensorEvent.values[1];
        this.f4385c = sensorEvent.values[2];
        this.f4386d = sensorEvent.timestamp;
    }
}
