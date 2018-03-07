package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzz extends zzc implements DataEvent {
    private final int f13448c;

    public zzz(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f13448c = i2;
    }

    public final Object m13644a() {
        return new zzy(this);
    }

    public final DataItem mo676b() {
        return new zzaf(this.a, this.b, this.f13448c);
    }

    public final int mo677c() {
        return b("event_type");
    }

    public final String toString() {
        String str = mo677c() == 1 ? "changed" : mo677c() == 2 ? "deleted" : "unknown";
        return "DataEventRef{ type=" + str + ", dataitem=" + mo676b() + " }";
    }
}
