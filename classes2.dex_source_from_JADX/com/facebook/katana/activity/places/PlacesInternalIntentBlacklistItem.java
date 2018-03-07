package com.facebook.katana.activity.places;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.places.create.NewPlaceCreationActivity;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;

/* compiled from: free_space */
public class PlacesInternalIntentBlacklistItem implements InternalIntentBlacklistItem {
    public final boolean mo3410a(Intent intent) {
        ComponentName component = intent.getComponent();
        return Objects.equal(component != null ? component.getClassName() : null, NewPlaceCreationActivity.class.getCanonicalName());
    }

    public final ZeroFeatureKey mo3409a() {
        return ZeroFeatureKey.VIEW_MAP_INTERSTITIAL;
    }
}
