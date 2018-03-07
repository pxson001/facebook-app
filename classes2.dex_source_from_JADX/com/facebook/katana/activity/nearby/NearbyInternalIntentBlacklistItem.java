package com.facebook.katana.activity.nearby;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.intent.ActivityLaunchIntentUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: free_success_pings */
public class NearbyInternalIntentBlacklistItem implements InternalIntentBlacklistItem {
    private final Provider<ComponentName> f23258a;

    @Inject
    public NearbyInternalIntentBlacklistItem(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f23258a = provider;
    }

    public final boolean mo3410a(Intent intent) {
        if (!Objects.equal(intent.getComponent(), this.f23258a.get())) {
            return false;
        }
        CharSequence b = ActivityLaunchIntentUtil.b(intent);
        if (StringUtil.m3589a(b)) {
            return false;
        }
        return FacebookUriUtil.m20917a(Uri.parse(b), Uri.parse(FBLinks.bp));
    }

    public final ZeroFeatureKey mo3409a() {
        return ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL;
    }
}
