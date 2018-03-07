package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzs;

public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Context f6434b;
    private final Status f6435c;
    private final String f6436d;

    public PlaceBuffer(DataHolder dataHolder, Context context) {
        super(dataHolder);
        this.f6434b = context;
        this.f6435c = PlacesStatusCodes.m8972b(dataHolder.h);
        if (dataHolder == null || dataHolder.i == null) {
            this.f6436d = null;
        } else {
            this.f6436d = dataHolder.i.getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public final Object m8967a(int i) {
        return new zzs(this.a, i, this.f6434b);
    }

    public final Status cp_() {
        return this.f6435c;
    }
}
