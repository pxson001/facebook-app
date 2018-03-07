package com.facebook.messengerwear.support;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import javax.inject.Inject;

/* compiled from: set streamdriedout */
public class MessengerWearHelper {
    private static final Class f2464a = MessengerWearHelper.class;
    private GatekeeperStoreImpl f2465b;
    public FbSharedPreferences f2466c;

    public static MessengerWearHelper m2742b(InjectorLike injectorLike) {
        return new MessengerWearHelper(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public MessengerWearHelper(GatekeeperStoreImpl gatekeeperStoreImpl, FbSharedPreferences fbSharedPreferences) {
        this.f2465b = gatekeeperStoreImpl;
        this.f2466c = fbSharedPreferences;
    }

    public final boolean m2744a() {
        return m2745c() && this.f2466c.a(MessengerWearPrefKeys.f11148c, false);
    }

    public static MessengerWearHelper m2741a(InjectorLike injectorLike) {
        return m2742b(injectorLike);
    }

    public final boolean m2745c() {
        return this.f2465b.a(985, false);
    }

    public final void m2743a(CapabilityInfo capabilityInfo) {
        if ("messenger_wear".equals(capabilityInfo.a())) {
            boolean z;
            for (Node b : capabilityInfo.b()) {
                if (b.b()) {
                    z = true;
                    break;
                }
            }
            z = false;
            boolean z2 = z;
            boolean a = m2744a();
            Integer.valueOf(capabilityInfo.b().size());
            Boolean.valueOf(z2);
            Boolean.valueOf(a);
            Editor putBoolean = this.f2466c.edit().putBoolean(MessengerWearPrefKeys.f11147b, z2);
            PrefKey prefKey = MessengerWearPrefKeys.f11148c;
            z2 = a || z2;
            putBoolean.putBoolean(prefKey, z2).commit();
        }
    }
}
