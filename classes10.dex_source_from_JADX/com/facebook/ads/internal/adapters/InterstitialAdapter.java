package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

public abstract class InterstitialAdapter implements AdAdapter {
    public final AdPlacementType mo706a() {
        return AdPlacementType.INTERSTITIAL;
    }

    public abstract void mo710a(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map);
}
