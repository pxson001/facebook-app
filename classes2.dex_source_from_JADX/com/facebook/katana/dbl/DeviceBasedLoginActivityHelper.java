package com.facebook.katana.dbl;

import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sms_takeover_turn_off_by_disable_components */
public class DeviceBasedLoginActivityHelper {
    private Provider<TriState> f4525a;
    public FbSharedPreferences f4526b;
    public final GatekeeperStoreImpl f4527c;
    private final GatekeeperStoreImpl f4528d;

    public static DeviceBasedLoginActivityHelper m8223b(InjectorLike injectorLike) {
        return new DeviceBasedLoginActivityHelper(IdBasedProvider.m1811a(injectorLike, 697), FbSharedPreferencesImpl.m1826a(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public DeviceBasedLoginActivityHelper(Provider<TriState> provider, FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, GatekeeperStore gatekeeperStore2) {
        this.f4525a = provider;
        this.f4526b = fbSharedPreferences;
        this.f4527c = gatekeeperStore;
        this.f4528d = gatekeeperStore2;
    }

    public static DeviceBasedLoginActivityHelper m8222a(InjectorLike injectorLike) {
        return m8223b(injectorLike);
    }

    public final Boolean m8224a() {
        return Boolean.valueOf(!((TriState) this.f4525a.get()).asBoolean(false));
    }

    public final boolean m8225b() {
        return this.f4527c.m2189a(3, false);
    }

    public final boolean m8226c() {
        return m8225b() && this.f4527c.m2189a(6, false);
    }

    public final boolean m8227d() {
        if (m8224a().booleanValue()) {
            if (Boolean.valueOf(!this.f4526b.mo297e(AuthPrefKeys.f2956k).isEmpty()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m8228e() {
        if (m8225b()) {
            if (Boolean.valueOf(!this.f4526b.mo297e(AuthPrefKeys.f2967v).isEmpty()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m8229f() {
        return this.f4528d.m2189a(991, false);
    }
}
