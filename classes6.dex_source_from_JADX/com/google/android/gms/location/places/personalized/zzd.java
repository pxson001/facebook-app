package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlacesStatusCodes;

public final class zzd extends com.google.android.gms.common.data.zzd<PlaceUserData> implements Result {
    private final Status f6608b;

    public zzd(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.m8972b(dataHolder.h));
    }

    private zzd(DataHolder dataHolder, Status status) {
        super(dataHolder, PlaceUserData.CREATOR);
        boolean z = dataHolder == null || dataHolder.h == status.g;
        zzx.b(z);
        this.f6608b = status;
    }

    public final Status cp_() {
        return this.f6608b;
    }
}
