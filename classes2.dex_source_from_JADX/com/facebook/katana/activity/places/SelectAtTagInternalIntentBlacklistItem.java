package com.facebook.katana.activity.places;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: free_messenger_setting */
public class SelectAtTagInternalIntentBlacklistItem implements InternalIntentBlacklistItem {
    public final boolean mo3410a(Intent intent) {
        ComponentName component = intent.getComponent();
        return "com.facebook.places.checkin.activity.SelectAtTagActivity".equals(component != null ? component.getClassName() : null);
    }

    public final ZeroFeatureKey mo3409a() {
        return ZeroFeatureKey.CHECKIN_INTERSTITIAL;
    }
}
