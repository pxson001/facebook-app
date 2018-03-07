package com.facebook.neko.getgamesneko.zerorating;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.intent.ActivityLaunchIntentUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.neko.getgamesneko.GetGamesNekoActivity;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: free_fb_invite */
public class GetGamesNekoInternalIntentBlacklistItem implements InternalIntentBlacklistItem {
    public final boolean mo3410a(Intent intent) {
        if (!intent.getComponent().getClassName().equals(GetGamesNekoActivity.class.getName())) {
            return false;
        }
        CharSequence b = ActivityLaunchIntentUtil.b(intent);
        if (StringUtil.m3589a(b)) {
            return false;
        }
        return FacebookUriUtil.m20917a(Uri.parse(b), Uri.parse(FBLinks.de));
    }

    public final ZeroFeatureKey mo3409a() {
        return ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL;
    }
}
