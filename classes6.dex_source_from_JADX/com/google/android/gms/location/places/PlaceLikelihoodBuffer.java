package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzn;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final String f6445b;
    private final Context f6446c;
    private final int f6447d;
    private final Status f6448e;

    public class zza {
        static int m8968a(int i) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i, Context context) {
        super(dataHolder);
        this.f6446c = context;
        this.f6448e = PlacesStatusCodes.m8972b(dataHolder.h);
        this.f6447d = zza.m8968a(i);
        if (dataHolder == null || dataHolder.i == null) {
            this.f6445b = null;
        } else {
            this.f6445b = dataHolder.i.getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public final Object m8969a(int i) {
        return new zzn(this.a, i, this.f6446c);
    }

    public final Status cp_() {
        return this.f6448e;
    }

    public String toString() {
        return zzw.a(this).a("status", cp_()).a("attributions", this.f6445b).toString();
    }
}
