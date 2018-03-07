package com.facebook.zero.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: whitelisted_faceweb_regexes */
public class Boolean_IsZeroRatingCampaignEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ZeroCommonModule.a(TriState_IsZeroRatingAvailableGatekeeperAutoProvider.b(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 3759));
    }
}
