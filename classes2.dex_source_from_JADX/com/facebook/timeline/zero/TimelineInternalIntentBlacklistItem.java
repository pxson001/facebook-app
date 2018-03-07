package com.facebook.timeline.zero;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.intent.ActivityLaunchIntentUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;

/* compiled from: free_failure_pings */
public class TimelineInternalIntentBlacklistItem implements InternalIntentBlacklistItem {
    public final boolean mo3410a(Intent intent) {
        CharSequence a = ActivityLaunchIntentUtil.a(intent);
        Uri parse = !StringUtil.m3589a(a) ? Uri.parse(a) : null;
        if (parse != null && Objects.equal(parse.getAuthority(), "m.facebook.com") && Objects.equal(parse.getQueryParameter("v"), "map")) {
            return true;
        }
        return false;
    }

    public final ZeroFeatureKey mo3409a() {
        return ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL;
    }
}
