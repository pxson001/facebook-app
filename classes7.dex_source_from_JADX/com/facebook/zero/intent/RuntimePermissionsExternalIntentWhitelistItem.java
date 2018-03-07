package com.facebook.zero.intent;

import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: {SouvenirVideoItem %s} */
public class RuntimePermissionsExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public static RuntimePermissionsExternalIntentWhitelistItem m107a(InjectorLike injectorLike) {
        return new RuntimePermissionsExternalIntentWhitelistItem();
    }

    public final TriState m108a(Intent intent) {
        String action = intent.getAction();
        if (action == null || !action.startsWith("android.settings.")) {
            return TriState.UNSET;
        }
        return TriState.YES;
    }
}
