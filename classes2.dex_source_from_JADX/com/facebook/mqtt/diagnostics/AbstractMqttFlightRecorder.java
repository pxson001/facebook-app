package com.facebook.mqtt.diagnostics;

import com.facebook.common.collect.RingBuffer;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: transfer_data_size */
public abstract class AbstractMqttFlightRecorder<TEvent extends FlightRecorderEvent> {
    private final RingBuffer<TEvent> f2271a;
    private final CopyOnWriteArrayList<Object> f2272b = new CopyOnWriteArrayList();

    public AbstractMqttFlightRecorder(int i) {
        this.f2271a = new RingBuffer(i);
    }

    public final List<TEvent> m4454a() {
        return this.f2271a.m4066b();
    }

    public final void m4455a(TEvent tEvent) {
        Iterator b = m4453b(tEvent);
        while (b.hasNext()) {
            b.next();
        }
    }

    private synchronized Iterator<Object> m4453b(TEvent tEvent) {
        this.f2271a.m4065a((Object) tEvent);
        return this.f2272b.iterator();
    }
}
