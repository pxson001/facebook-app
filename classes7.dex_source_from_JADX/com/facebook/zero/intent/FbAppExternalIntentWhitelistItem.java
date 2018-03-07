package com.facebook.zero.intent;

import android.content.Intent;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;

/* compiled from: ू */
public class FbAppExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public final TriState m99a(Intent intent) {
        if (FacebookUriUtil.g(intent.getData())) {
            return TriState.YES;
        }
        return TriState.UNSET;
    }
}
