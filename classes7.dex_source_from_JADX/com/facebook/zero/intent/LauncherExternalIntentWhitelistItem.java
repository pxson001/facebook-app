package com.facebook.zero.intent;

import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: ा */
public class LauncherExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public final TriState m103a(Intent intent) {
        if (intent == null || intent.getCategories() == null || !intent.getCategories().contains("android.intent.category.HOME") || intent.getAction() != "android.intent.action.MAIN") {
            return TriState.UNSET;
        }
        return TriState.YES;
    }
}
