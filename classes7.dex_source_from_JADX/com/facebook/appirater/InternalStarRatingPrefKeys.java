package com.facebook.appirater;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;

/* compiled from: cta_lead_gen_field_edit_click */
public class InternalStarRatingPrefKeys implements IHaveNonCriticalKeysToClear {
    static final PrefKey f16468a;
    static final PrefKey f16469b;
    static final PrefKey f16470c = ((PrefKey) f16468a.a("report"));
    public static final PrefKey f16471d = ((PrefKey) f16468a.a("displayed"));
    public static final PrefKey f16472e = ((PrefKey) f16468a.a("report_sent"));
    static final PrefKey f16473f = ((PrefKey) f16468a.a("dialog_save_state"));

    static {
        PrefKey prefKey = (PrefKey) AppiraterPrefKeys.a.a("isr/");
        f16468a = prefKey;
        f16469b = (PrefKey) prefKey.a("api_ping_response");
    }

    public final ImmutableSet<PrefKey> m20534a() {
        return ImmutableSet.of(f16469b, f16470c, f16471d, f16472e, f16473f);
    }
}
