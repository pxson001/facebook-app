package com.facebook.goodwill.dailydialogue.data;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: pending_story_too_many_stories */
public class DailyDialoguePrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f10259a;
    public static final PrefKey f10260b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("dailydialogue/");
        f10259a = prefKey;
        f10260b = (PrefKey) prefKey.m2011a("last_fetch_time");
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(f10260b);
    }
}
