package com.facebook.zero.intent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: {entry_point} */
public class MessagingExternalIntentWhiteListItem implements ExternalIntentWhitelistItem {
    public final TriState m105a(Intent intent) {
        Uri data = intent.getData();
        if (data == null || !"smsto".equals(data.getScheme())) {
            return TriState.UNSET;
        }
        return TriState.YES;
    }
}
