package com.facebook.growth.experiment;

import com.facebook.common.time.Clock;
import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.annotations.VisibleForTesting;
import java.security.SecureRandom;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: 소봉 */
public class InitialAppLaunchExperiment {
    public final Clock f29a;
    public final FbSharedPreferences f30b;
    public final SecureRandom f31c;
    private final String f32d;
    public final String f33e;
    public final PrefKey f34f;
    public final int f35g;
    public final Date f36h;
    public final Date f37i;
    @Nullable
    public final Condition f38j;

    @Inject
    public InitialAppLaunchExperiment(Clock clock, FbSharedPreferences fbSharedPreferences, SecureRandom secureRandom, @Assisted InitialAppLaunchExperimentConstants$ExperimentSpecification initialAppLaunchExperimentConstants$ExperimentSpecification) {
        this(clock, fbSharedPreferences, secureRandom, initialAppLaunchExperimentConstants$ExperimentSpecification.name(), initialAppLaunchExperimentConstants$ExperimentSpecification.threshold, initialAppLaunchExperimentConstants$ExperimentSpecification.startDate, initialAppLaunchExperimentConstants$ExperimentSpecification.endDate, initialAppLaunchExperimentConstants$ExperimentSpecification.condition);
    }

    @VisibleForTesting
    private InitialAppLaunchExperiment(Clock clock, FbSharedPreferences fbSharedPreferences, SecureRandom secureRandom, String str, int i, Date date, Date date2, @Nullable Condition condition) {
        this.f29a = clock;
        this.f30b = fbSharedPreferences;
        this.f31c = secureRandom;
        this.f32d = str;
        this.f33e = getSystemPropertyKey(str);
        this.f34f = m27a(str);
        this.f35g = i;
        this.f36h = date;
        this.f37i = date2;
        this.f38j = condition;
    }

    @VisibleForTesting
    private static PrefKey m27a(String str) {
        return (PrefKey) InitialAppLaunchExperimentConstants.b.a(str);
    }

    @DoNotStrip
    public static String getSystemPropertyKey(String str) {
        return "fb.exp." + str;
    }
}
