package com.facebook.friendsnearby.zerorating;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.intent.ActivityLaunchIntentUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fresco_facerec_and_facedetection */
public class FriendsNearbyInternalIntentBlacklistItem implements InternalIntentBlacklistItem {
    private final Provider<ComponentName> f23256a;
    private final GatekeeperStoreImpl f23257b;

    @Inject
    public FriendsNearbyInternalIntentBlacklistItem(@FragmentChromeActivity Provider<ComponentName> provider, GatekeeperStore gatekeeperStore) {
        this.f23256a = provider;
        this.f23257b = gatekeeperStore;
    }

    public final boolean mo3410a(Intent intent) {
        if (this.f23257b.m2189a(998, false) || !Objects.equal(intent.getComponent(), this.f23256a.get())) {
            return false;
        }
        CharSequence b = ActivityLaunchIntentUtil.b(intent);
        if (StringUtil.m3589a(b)) {
            return false;
        }
        return FacebookUriUtil.m20917a(Uri.parse(b), Uri.parse(FBLinks.cQ));
    }

    public final ZeroFeatureKey mo3409a() {
        return ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL;
    }
}
