package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzz;

public class DataEventBuffer extends zzf<DataEvent> implements Result {
    private final Status f13143b;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f13143b = new Status(dataHolder.h);
    }

    protected final Object m13240a(int i, int i2) {
        return new zzz(this.a, i, i2);
    }

    public final Status cp_() {
        return this.f13143b;
    }

    protected final String m13241d() {
        return "path";
    }
}
