package com.facebook.account.recovery.helper;

import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: udp_receiving_task */
public class GkUnsetGroupTestHelper {
    private final FbSharedPreferences f653a;
    public TriState f654b = TriState.UNSET;

    public static GkUnsetGroupTestHelper m1021a(InjectorLike injectorLike) {
        return new GkUnsetGroupTestHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public GkUnsetGroupTestHelper(FbSharedPreferences fbSharedPreferences) {
        this.f653a = fbSharedPreferences;
    }

    public final TriState m1023a(TriState triState, TriState triState2, PrefKey prefKey) {
        if (this.f653a.a(prefKey)) {
            if (triState2 == TriState.UNSET) {
                m1022a(triState, true);
                return triState;
            }
            TriState triState3 = (TriState) Enum.valueOf(TriState.class, this.f653a.a(prefKey, TriState.UNSET.name()));
            m1022a(triState3, false);
            return triState3;
        } else if (triState != TriState.UNSET) {
            m1022a(triState, true);
            return triState;
        } else {
            this.f653a.edit().a(prefKey, triState2.name()).commit();
            m1022a(triState2, false);
            return triState2;
        }
    }

    private void m1022a(TriState triState, boolean z) {
        this.f654b = TriState.UNSET;
        if (triState == TriState.YES) {
            if (z) {
                this.f654b = TriState.YES;
            } else {
                this.f654b = TriState.NO;
            }
        }
    }
}
