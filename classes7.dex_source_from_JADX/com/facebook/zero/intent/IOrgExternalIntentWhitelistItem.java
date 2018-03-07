package com.facebook.zero.intent;

import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: ि */
public class IOrgExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public final TriState m102a(Intent intent) {
        String str = intent.getPackage();
        if (str == null) {
            return TriState.UNSET;
        }
        if (str.equals("org.internet")) {
            return TriState.YES;
        }
        return TriState.UNSET;
    }
}
