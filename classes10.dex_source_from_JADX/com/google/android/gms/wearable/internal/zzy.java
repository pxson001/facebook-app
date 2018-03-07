package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzy implements DataEvent {
    private int f13446a;
    private DataItem f13447b;

    public zzy(DataEvent dataEvent) {
        this.f13446a = dataEvent.mo677c();
        this.f13447b = (DataItem) dataEvent.mo676b().a();
    }

    public final Object m13641a() {
        return this;
    }

    public final DataItem mo676b() {
        return this.f13447b;
    }

    public final int mo677c() {
        return this.f13446a;
    }

    public String toString() {
        String str = mo677c() == 1 ? "changed" : mo677c() == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + mo676b() + " }";
    }
}
