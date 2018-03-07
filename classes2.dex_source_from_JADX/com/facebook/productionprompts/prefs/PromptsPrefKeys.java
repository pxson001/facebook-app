package com.facebook.productionprompts.prefs;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: netego_promote_instagram_image_scale */
public class PromptsPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f12779a;
    public static final PrefKey f12780b;
    public static final PrefKey f12781c = ((PrefKey) f12779a.m2011a("time_last_media_prompt_dismissed"));
    public static final PrefKey f12782d = ((PrefKey) f12779a.m2011a("time_last_media_prompt_seen"));
    public static final PrefKey f12783e = ((PrefKey) f12779a.m2011a("media_prompt_impression_count"));
    public static final PrefKey f12784f = ((PrefKey) f12779a.m2011a("is_photo_reminder_nux_shown"));
    public static final PrefKey f12785g = ((PrefKey) f12779a.m2011a("time_last_prompt_shown"));
    public static final PrefKey f12786h = ((PrefKey) f12779a.m2011a("time_last_photo_reminder_prompt_posted"));
    public static final PrefKey f12787i = ((PrefKey) f12779a.m2011a("time_last_weekend_photo_reminder_prompt_posted"));
    public static final PrefKey f12788j = ((PrefKey) f12779a.m2011a("time_last_photo_clipboard_prompt_posted"));
    public static final PrefKey f12789k = ((PrefKey) f12779a.m2011a("num_days_until_show_photo_reminder_prompt_again"));
    public static final PrefKey f12790l = ((PrefKey) f12779a.m2011a("num_days_until_show_weekend_photo_reminder_prompt_again"));
    public static final PrefKey f12791m = ((PrefKey) f12779a.m2011a("num_days_until_show_clipboard_prompt_again"));
    public static final PrefKey f12792n = ((PrefKey) f12779a.m2011a("num_dismiss_since_last_photo_prompt_post"));
    public static final PrefKey f12793o = ((PrefKey) f12779a.m2011a("num_dismiss_since_last_weekend_photo_prompt_post"));
    public static final PrefKey f12794p = ((PrefKey) f12779a.m2011a("num_dismiss_since_last_clipboard_prompt_post"));
    public static final PrefKey f12795q = ((PrefKey) f12779a.m2011a("clipboard_prompt_uri"));
    public static final PrefKey f12796r = ((PrefKey) f12779a.m2011a("clipboard_prompt_expired_time"));
    public static final PrefKey f12797s = ((PrefKey) f12779a.m2011a("last_prompt_id_hidden"));

    public static PromptsPrefKeys m18829a(InjectorLike injectorLike) {
        return new PromptsPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("prompts/");
        f12779a = prefKey;
        f12780b = (PrefKey) prefKey.m2011a("time_last_production_prompt_network_fetch_seconds");
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(f12781c, f12782d, f12783e, f12784f, f12785g, f12786h, f12788j, f12789k, f12791m, f12792n, f12793o, f12794p, f12796r, f12795q, f12797s);
    }
}
