package com.facebook.zero.intent;

import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: · */
public class LocationSettingsExternalWhiteListItem implements ExternalIntentWhitelistItem {
    public final TriState m104a(Intent intent) {
        String action = intent.getAction();
        if (action == null || !"android.settings.LOCATION_SOURCE_SETTINGS".equals(action)) {
            return TriState.UNSET;
        }
        return TriState.YES;
    }
}
