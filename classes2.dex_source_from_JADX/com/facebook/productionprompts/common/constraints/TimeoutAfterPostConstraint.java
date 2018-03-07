package com.facebook.productionprompts.common.constraints;

import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;

/* compiled from: netego_promote_instagram_for_resurrection */
public class TimeoutAfterPostConstraint implements PromptFetchConstraint {
    private final FbSharedPreferences f12827a;
    private boolean f12828b = true;

    @Inject
    public TimeoutAfterPostConstraint(FbSharedPreferences fbSharedPreferences) {
        this.f12827a = fbSharedPreferences;
    }

    public final boolean mo2497a() {
        return this.f12828b;
    }

    public final boolean mo2498a(long j) {
        long a = this.f12827a.mo277a(ComposerPrefKeys.f2673p, -1);
        if (a == -1 || 60000 < j - a) {
            return true;
        }
        return false;
    }

    public final void mo2496a(long j, boolean z) {
    }

    public final void mo2499b(long j) {
    }
}
