package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

public abstract class BannerAdapter implements AdAdapter {
    public final AdPlacementType mo706a() {
        return AdPlacementType.BANNER;
    }

    public abstract void mo707a(Context context, BannerAdapterListener bannerAdapterListener, Map<String, Object> map);

    public void mo709c() {
    }
}
