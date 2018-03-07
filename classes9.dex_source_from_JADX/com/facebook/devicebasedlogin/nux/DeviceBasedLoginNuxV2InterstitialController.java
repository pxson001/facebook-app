package com.facebook.devicebasedlogin.nux;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithContextClass;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: This object has been released */
public class DeviceBasedLoginNuxV2InterstitialController implements InterstitialControllerWithContextClass, InterstitialIntentController {
    public FbSharedPreferences f24157a;
    private DeviceBasedLoginActivityHelper f24158b;
    private DeviceBasedLoginNuxV2InterstitialFetchResult f24159c = null;
    private final Provider<String> f24160d;
    private final DeviceBasedLoginNuxEligibilityController f24161e;
    private final Boolean f24162f;

    public final Optional<Intent> m26119a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public DeviceBasedLoginNuxV2InterstitialController(FbSharedPreferences fbSharedPreferences, DeviceBasedLoginActivityHelper deviceBasedLoginActivityHelper, Provider<String> provider, DeviceBasedLoginNuxEligibilityController deviceBasedLoginNuxEligibilityController, Boolean bool) {
        this.f24157a = fbSharedPreferences;
        this.f24158b = deviceBasedLoginActivityHelper;
        this.f24160d = provider;
        this.f24161e = deviceBasedLoginNuxEligibilityController;
        this.f24162f = bool;
    }

    public final String m26122b() {
        return "4196";
    }

    public final Class<? extends Parcelable> m26124d() {
        return DeviceBasedLoginNuxV2InterstitialFetchResult.class;
    }

    public final void m26121a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f24159c = (DeviceBasedLoginNuxV2InterstitialFetchResult) parcelable;
        }
    }

    public final void m26120a(long j) {
    }

    public final InterstitialControllerState m26118a(InterstitialTrigger interstitialTrigger) {
        if (!this.f24162f.booleanValue() && this.f24158b.a().booleanValue()) {
            int i;
            DeviceBasedLoginNuxEligibilityController deviceBasedLoginNuxEligibilityController = this.f24161e;
            String str = (String) deviceBasedLoginNuxEligibilityController.f24144b.get();
            if (str == null) {
                i = 0;
            } else {
                long a = deviceBasedLoginNuxEligibilityController.f24143a.a((PrefKey) AuthPrefKeys.m.a((String) deviceBasedLoginNuxEligibilityController.f24144b.get()), 0);
                i = (a == 0 || deviceBasedLoginNuxEligibilityController.f24145c.a() - a > ((long) deviceBasedLoginNuxEligibilityController.f24143a.a((PrefKey) AuthPrefKeys.o.a(str), 1)) * 1209600000) ? 1 : 0;
            }
            if (i != 0) {
                Object obj;
                deviceBasedLoginNuxEligibilityController = this.f24161e;
                if (!deviceBasedLoginNuxEligibilityController.f24146d.c() || deviceBasedLoginNuxEligibilityController.f24147e.f((String) deviceBasedLoginNuxEligibilityController.f24144b.get())) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    String str2 = (String) this.f24160d.get();
                    if (str2 != null) {
                        if (this.f24157a.a((PrefKey) AuthPrefKeys.k.a(str2))) {
                            return InterstitialControllerState.INELIGIBLE;
                        }
                        if (this.f24161e.m26103a(this.f24159c.targetedNux)) {
                            return InterstitialControllerState.ELIGIBLE;
                        }
                    }
                    return InterstitialControllerState.INELIGIBLE;
                }
            }
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m26123c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SESSION_COLD_START));
    }

    public final Intent m26117a(Context context) {
        return new Intent(context, ActivateDeviceBasedLoginNuxActivity.class).putExtra("targeted_nux", this.f24159c.targetedNux);
    }

    public final long hI_() {
        return 0;
    }
}
