package com.facebook.growth.experiment;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: email_auto_confirm_task_start */
public final class InitialAppLaunchExperimentConstants {
    protected static final PrefKey f14884a;
    protected static final PrefKey f14885b;

    private InitialAppLaunchExperimentConstants() {
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("initial_experiment/");
        f14884a = prefKey;
        f14885b = (PrefKey) prefKey.a("values/");
    }
}
