package com.facebook.zero.intent;

import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: {SouvenirRemoteItem %s} */
public class SMSAppSelectionExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public final TriState m109a(Intent intent) {
        String action = intent.getAction();
        if (action == null || !action.equals("android.provider.Telephony.ACTION_CHANGE_DEFAULT")) {
            return TriState.UNSET;
        }
        return TriState.YES;
    }
}
