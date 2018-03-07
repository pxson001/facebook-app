package com.facebook.zero.prefs;

import android.content.Context;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.zero.common.constants.ZeroPrefKeys;

/* compiled from: zip */
public class AllowZeroRatingOnWifiPreference extends OrcaCheckBoxPreference {
    public AllowZeroRatingOnWifiPreference(Context context) {
        super(context);
        a(ZeroPrefKeys.W);
        setTitle(2131232973);
        setSummaryOn(2131232974);
        setSummaryOff(2131232975);
        setDefaultValue(Boolean.valueOf(getPersistedBoolean(false)));
    }
}
