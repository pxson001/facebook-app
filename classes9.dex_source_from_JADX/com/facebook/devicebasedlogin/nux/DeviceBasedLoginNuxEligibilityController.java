package com.facebook.devicebasedlogin.nux;

import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Thread list returned from server was null */
public class DeviceBasedLoginNuxEligibilityController {
    public final FbSharedPreferences f24143a;
    public final Provider<String> f24144b;
    public final Clock f24145c;
    public final DeviceBasedLoginActivityHelper f24146d;
    public final DBLStorageAndRetrievalHelper f24147e;

    public static DeviceBasedLoginNuxEligibilityController m26102b(InjectorLike injectorLike) {
        return new DeviceBasedLoginNuxEligibilityController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DeviceBasedLoginActivityHelper.b(injectorLike), DBLStorageAndRetrievalHelper.b(injectorLike));
    }

    @Inject
    public DeviceBasedLoginNuxEligibilityController(FbSharedPreferences fbSharedPreferences, Provider<String> provider, Clock clock, DeviceBasedLoginActivityHelper deviceBasedLoginActivityHelper, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper) {
        this.f24143a = fbSharedPreferences;
        this.f24144b = provider;
        this.f24145c = clock;
        this.f24146d = deviceBasedLoginActivityHelper;
        this.f24147e = dBLStorageAndRetrievalHelper;
    }

    public final boolean m26103a(String str) {
        String str2 = (String) this.f24144b.get();
        if (str2 == null || str == null) {
            return false;
        }
        String a = this.f24143a.a((PrefKey) AuthPrefKeys.n.a((String) this.f24144b.get()), "");
        if (!a.equals("")) {
            return !a.equals(str);
        } else {
            if (this.f24143a.a((PrefKey) AuthPrefKeys.l.a(str2), 0) == 0) {
                return str.startsWith("default");
            }
            this.f24143a.edit().a((PrefKey) AuthPrefKeys.n.a(str2), "default+1").commit();
            return false;
        }
    }
}
