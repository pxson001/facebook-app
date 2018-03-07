package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzaf;

public class DataItemBuffer extends zzf<DataItem> implements Result {
    private final Status f13144b;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f13144b = new Status(dataHolder.h);
    }

    protected final Object m13247a(int i, int i2) {
        return new zzaf(this.a, i, i2);
    }

    public final Status cp_() {
        return this.f13144b;
    }

    protected final String m13248d() {
        return "path";
    }
}
