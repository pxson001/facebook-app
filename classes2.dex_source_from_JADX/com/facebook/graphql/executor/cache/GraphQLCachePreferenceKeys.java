package com.facebook.graphql.executor.cache;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: mark_thread_response */
public class GraphQLCachePreferenceKeys {
    public static final PrefKey f15057a;
    private static final PrefKey f15058b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("graphql_cache/");
        f15058b = prefKey;
        f15057a = (PrefKey) prefKey.m2011a("is_flat_buffer_corrupt");
    }
}
