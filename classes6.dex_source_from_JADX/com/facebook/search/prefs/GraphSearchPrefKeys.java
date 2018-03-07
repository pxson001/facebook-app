package com.facebook.search.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: event_ticket_order_purchase_status_change */
public class GraphSearchPrefKeys {
    public static final PrefKey f15916a;
    public static final PrefKey f15917b;
    public static final PrefKey f15918c = ((PrefKey) f15916a.a("db_bootstrap_keywords_last_fetch_ms"));
    public static final PrefKey f15919d = ((PrefKey) f15916a.a("db_bootstrap_last_fetch_user_id"));
    public static final PrefKey f15920e = ((PrefKey) f15916a.a("injected_trending_topic_id"));
    public static final PrefKey f15921f = ((PrefKey) f15916a.a("injected_pulse_url"));
    public static final PrefKey f15922g = ((PrefKey) f15916a.a("phonetic_tokens_generated"));
    public static final PrefKey f15923h = ((PrefKey) f15916a.a("num_extra_profiles_added_to_bootstrap"));
    public static final PrefKey f15924i = ((PrefKey) f15916a.a("extra_profile_ids_added_to_bootstrap"));
    public static final PrefKey f15925j = ((PrefKey) f15916a.a("post_search_enabled_override"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("graph_search/");
        f15916a = prefKey;
        f15917b = (PrefKey) prefKey.a("db_bootstrap_entities_last_fetch_ms");
    }
}
