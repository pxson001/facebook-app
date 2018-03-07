package com.facebook.zero.intent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: {com.facebook.katana.profile.id} */
public class PhoneNumberExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public final TriState m106a(Intent intent) {
        Uri data = intent.getData();
        if (data == null || !"tel".equals(data.getScheme())) {
            return TriState.UNSET;
        }
        return TriState.YES;
    }
}
