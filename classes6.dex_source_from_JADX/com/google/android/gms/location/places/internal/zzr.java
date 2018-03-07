package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzr extends zzu implements PlacePhotoMetadata {
    private final String f6592c = d("photo_fife_url");

    public zzr(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final Object m9107a() {
        return new zzq(this.f6592c, m9002a("photo_max_width", 0), m9002a("photo_max_height", 0), m9004a("photo_attributions", null), this.b);
    }
}
