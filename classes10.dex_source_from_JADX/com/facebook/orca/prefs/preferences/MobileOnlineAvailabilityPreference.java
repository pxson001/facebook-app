package com.facebook.orca.prefs.preferences;

import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.prefs.PushPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: new_permissions */
public class MobileOnlineAvailabilityPreference extends CheckBoxOrSwitchPreference {
    public static MobileOnlineAvailabilityPreference m5975a(InjectorLike injectorLike) {
        return new MobileOnlineAvailabilityPreference((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4296));
    }

    @Inject
    public MobileOnlineAvailabilityPreference(Context context, Provider<Boolean> provider) {
        int i;
        super(context);
        setKey(PushPrefKeys.a.a());
        setTitle(2131231496);
        if (BuildConstants.j) {
            i = 2131231499;
        } else {
            i = 2131231498;
        }
        setSummaryOff(i);
        setSummaryOn(2131231497);
        setDefaultValue(provider.get());
    }
}
