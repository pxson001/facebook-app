package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceLikelihood;

public class zzn extends zzu implements PlaceLikelihood {
    public final Context f6576c;

    public zzn(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.f6576c = context;
    }

    public final Object m9101a() {
        PlaceImpl placeImpl = (PlaceImpl) new zzs(this.a, this.b, this.f6576c).a();
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzx.a(placeImpl), m9001a("place_likelihood", -1.0f));
    }
}
