package com.facebook.devicebasedlogin.nux;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithContextClass;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Thread key is missing other user id.  */
public class DeviceBasedLoginNuxInterstitialController implements InterstitialControllerWithContextClass, InterstitialIntentController {
    public FbSharedPreferences f24148a;
    private DBLStorageAndRetrievalHelper f24149b;
    private DeviceBasedLoginActivityHelper f24150c;
    private DeviceBasedLoginNuxInterstitialFetchResult f24151d = null;
    public Resources f24152e;
    private final Provider<String> f24153f;
    private final Clock f24154g;
    private final QeAccessor f24155h;

    public static DeviceBasedLoginNuxInterstitialController m26104b(InjectorLike injectorLike) {
        return new DeviceBasedLoginNuxInterstitialController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DBLStorageAndRetrievalHelper.b(injectorLike), DeviceBasedLoginActivityHelper.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Optional<Intent> m26107a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public DeviceBasedLoginNuxInterstitialController(FbSharedPreferences fbSharedPreferences, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, DeviceBasedLoginActivityHelper deviceBasedLoginActivityHelper, Resources resources, Provider<String> provider, Clock clock, QeAccessor qeAccessor) {
        this.f24148a = fbSharedPreferences;
        this.f24149b = dBLStorageAndRetrievalHelper;
        this.f24150c = deviceBasedLoginActivityHelper;
        this.f24152e = resources;
        this.f24153f = provider;
        this.f24154g = clock;
        this.f24155h = qeAccessor;
    }

    public final String m26110b() {
        return "2504";
    }

    public final Class<? extends Parcelable> m26112d() {
        return DeviceBasedLoginNuxInterstitialFetchResult.class;
    }

    public final void m26109a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f24151d = (DeviceBasedLoginNuxInterstitialFetchResult) parcelable;
        }
    }

    public final void m26108a(long j) {
    }

    public final InterstitialControllerState m26106a(InterstitialTrigger interstitialTrigger) {
        Object obj;
        if ((this.f24152e.getConfiguration().screenLayout & 15) >= 3) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && this.f24150c.a().booleanValue() && !this.f24150c.f()) {
            String str = (String) this.f24153f.get();
            if (str != null && (!this.f24150c.c() || this.f24149b.f(str))) {
                if (this.f24148a.a((PrefKey) AuthPrefKeys.k.a(str))) {
                    return InterstitialControllerState.INELIGIBLE;
                }
                if (this.f24151d != null) {
                    int a = this.f24148a.a((PrefKey) AuthPrefKeys.l.a(str), 0);
                    long a2 = this.f24148a.a((PrefKey) AuthPrefKeys.m.a(str), 0);
                    if (this.f24151d.triggerGeneration > a) {
                        long a3 = this.f24155h.a(ExperimentsForDBLNuxModule.f24165a, 1209600000);
                        if (a2 == 0 || this.f24154g.a() - a2 > a3) {
                            return InterstitialControllerState.ELIGIBLE;
                        }
                    }
                }
            }
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m26111c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SESSION_COLD_START));
    }

    public final Intent m26105a(Context context) {
        Intent intent = new Intent(context, ActivateDeviceBasedLoginNuxActivity.class);
        if (this.f24151d != null) {
            intent.putExtra("generation", this.f24151d.triggerGeneration);
        }
        return intent;
    }

    public final long hI_() {
        return 0;
    }
}
