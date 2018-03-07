package com.facebook.feedback.reactions.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: gsm_info */
public class FeedbackReactionsPrefKeys {
    public static final PrefKey f21470a;
    public static final PrefKey f21471b;
    public static final PrefKey f21472c = ((PrefKey) f21470a.m2011a("user_left_reaction/"));
    public static final PrefKey f21473d = ((PrefKey) f21470a.m2011a("user_left_comment_reaction/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("feedback_reactions/");
        f21470a = prefKey;
        f21471b = (PrefKey) prefKey.m2011a("identifiers/");
    }

    public static PrefKey m29185a(int i) {
        return (PrefKey) f21470a.m2011a(i + "/");
    }

    public static PrefKey m29187b(int i) {
        return (PrefKey) m29185a(i).m2011a("is_deprecated/");
    }

    public static PrefKey m29186a(int i, String str) {
        return (PrefKey) m29185a(i).m2011a(str + "/");
    }

    public static PrefKey m29188c(int i) {
        return (PrefKey) m29185a(i).m2011a("reaction_color/");
    }
}
