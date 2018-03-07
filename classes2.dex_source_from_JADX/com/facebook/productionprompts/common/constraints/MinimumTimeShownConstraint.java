package com.facebook.productionprompts.common.constraints;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import javax.inject.Inject;

/* compiled from: net.dns2 */
public class MinimumTimeShownConstraint implements PromptFetchConstraint {
    private final FbSharedPreferences f12835a;
    private boolean f12836b = false;

    @Inject
    public MinimumTimeShownConstraint(FbSharedPreferences fbSharedPreferences) {
        this.f12835a = fbSharedPreferences;
    }

    public final boolean mo2497a() {
        return this.f12836b;
    }

    public final boolean mo2498a(long j) {
        long a = this.f12835a.mo277a(PromptsPrefKeys.f12785g, -1);
        if (a == -1 || 300000 < j - a) {
            return true;
        }
        return false;
    }

    public final void mo2496a(long j, boolean z) {
        this.f12836b = false;
    }

    public final void mo2499b(long j) {
        this.f12835a.edit().mo1275a(PromptsPrefKeys.f12785g, j).commit();
        this.f12836b = true;
    }
}
