package com.facebook.transliteration;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: extra_fallback_url */
public class TransliterationConfig {
    public static final PrefKey f15099a;
    public static final PrefKey f15100b;
    public final GatekeeperStoreImpl f15101c;
    public final QeAccessor f15102d;
    private final FbSharedPreferences f15103e;

    public static TransliterationConfig m19074b(InjectorLike injectorLike) {
        return new TransliterationConfig(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("transliteration/");
        f15099a = prefKey;
        f15100b = (PrefKey) prefKey.a("enabled");
    }

    @Inject
    public TransliterationConfig(GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences) {
        this.f15101c = gatekeeperStoreImpl;
        this.f15102d = qeAccessor;
        this.f15103e = fbSharedPreferences;
    }

    public static TransliterationConfig m19073a(InjectorLike injectorLike) {
        return m19074b(injectorLike);
    }

    public final boolean m19075b() {
        if (this.f15103e.a()) {
            TriState b = this.f15103e.b(f15100b);
            if (b.isSet()) {
                return b.asBoolean();
            }
        }
        return this.f15102d.a(ExperimentsForTransliterationModule.f15050a, false);
    }
}
