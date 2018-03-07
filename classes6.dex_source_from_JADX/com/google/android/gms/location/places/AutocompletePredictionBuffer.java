package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzb;

public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final Object m8959a(int i) {
        return new zzb(this.a, i);
    }

    public final Status cp_() {
        return PlacesStatusCodes.m8972b(this.a.h);
    }

    public String toString() {
        return zzw.a(this).a("status", cp_()).toString();
    }
}
