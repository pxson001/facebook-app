package com.facebook.prefs.shared;

import com.facebook.common.invariants.Invariants;
import com.facebook.common.typedkey.TypedKey;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.Lazy;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.inject.Inject;

/* compiled from: viewport_visible_duration */
public class PrefsMigrator {
    private static final String f1013a = new String();
    private final Lazy<ObjectMapper> f1014b;

    private static void m2058a(PrefKey prefKey, PrefKey prefKey2, SortedMap<PrefKey, Object> sortedMap, SortedMap<PrefKey, Object> sortedMap2) {
        SortedMap headMap;
        SortedMap tailMap = sortedMap.tailMap(prefKey);
        for (Entry entry : tailMap.entrySet()) {
            if (!((PrefKey) entry.getKey()).m2013a((TypedKey) prefKey)) {
                headMap = tailMap.headMap(entry.getKey());
                break;
            }
        }
        headMap = tailMap;
        SortedMap sortedMap3 = headMap;
        for (Entry entry2 : sortedMap3.entrySet()) {
            if (prefKey2 != null) {
                sortedMap2.put((PrefKey) prefKey2.m2011a(((PrefKey) entry2.getKey()).m2014b(prefKey)), entry2.getValue());
            }
        }
        sortedMap3.clear();
    }

    private static ImmutableMap<String, String> m2055a() {
        return ImmutableMap.builder().m609b("/app_info", f1013a).m609b("//gk", f1013a).m610b();
    }

    private static ImmutableMap<String, String> m2060b() {
        return ImmutableMap.builder().m609b("/auth/", "/auth/user_data/").m609b("/orca/auth_machine_id", "/auth/auth_machine_id").m609b("/orca/me_user_version", "/auth/me_user_version").m609b("/orca/app_info", "/config/app_info").m609b("/orca/gk/", "/config/gk/").m609b("/orca/gk_version", "/config/gk/version").m609b("/orca/rollout/", "/config/rollout").m609b("/orca/rollout_version", "/config/rollout/version").m609b("/orca/device_id/", "/shared/device_id").m609b("/orca/c2dm/", "/messenger/c2dm/").m609b("/orca/first_install_time", "/messenger/first_install_time").m609b("/orca/nux_completed", "/messenger/nux_completed").m609b("/orca/login_reminder_trigger_state", "/messenger/login_reminder_trigger_state").m609b("/orca/phone_confirm", "/messenger/phone_confirm").m609b("/orca/sms", "/messages/sms").m609b("/orca/ui_counters", "/messages/ui_counters").m609b("/orca/notifications/recent_threads", "/messages/notifications/recent_threads").m609b("/preferences/notifications/location_services", "/settings/messages/location_services").m609b("/preferences/notifications", "/settings/messages/notifications").m609b("/preferences/threads", "/settings/messages/threads").m609b("/orca/internal/debug_logs", "/settings/logging/debug_logs").m609b("/orca/internal/logging_level", "/settings/logging/logging_level").m609b("/orca/internal/php_profiling", "/settings/http/php_profiling").m609b("/orca/internal/wirehog_profiling", "/settings/http/wirehog_profiling").m609b("/orca/internal/force_fb4a_look_and_feel", "/settings/messenger/force_fb4a_look_and_feel").m609b("/orca/internal/web", "/settings/sandbox/web").m609b("/orca/internal/mqtt", "/settings/sandbox/mqtt").m609b("/orca/device_id", "/shared/device_id").m609b("/orca/mqtt", "/mqtt").m609b("/orca/top_last_active_sync_time", f1013a).m610b();
    }

    private static PrefKey m2063d() {
        return new PrefKey("/orca/pref_version");
    }

    private static PrefKey m2065e() {
        return new PrefKey("/_meta_/prefs_version");
    }

    @Inject
    public PrefsMigrator(Lazy<ObjectMapper> lazy) {
        this.f1014b = lazy;
    }

    public final boolean m2068a(Map<PrefKey, Object> map) {
        return m2059b((Map) map) != 6;
    }

    public final SortedMap<PrefKey, Object> m2067a(SortedMap<PrefKey, Object> sortedMap) {
        Map a = m2056a((SortedMap) sortedMap, 6);
        Invariants.a(6, m2059b(a));
        return a;
    }

    @VisibleForTesting
    private SortedMap<PrefKey, Object> m2056a(SortedMap<PrefKey, Object> sortedMap, int i) {
        Map a = m2055a();
        Map b = m2060b();
        SortedMap<PrefKey, Object> treeMap = new TreeMap(sortedMap);
        int b2 = m2059b((Map) treeMap);
        PrefKey d = m2063d();
        PrefKey e = m2065e();
        if (b2 == 0) {
            treeMap = m2057a((SortedMap) treeMap, a);
            b2 = 1;
        }
        if (b2 == 1 && b2 < i) {
            treeMap.remove(d);
            treeMap = m2057a((SortedMap) treeMap, b);
            treeMap.put(e, Integer.valueOf(2));
            b2 = 2;
        }
        if (b2 == 2 && b2 < i) {
            treeMap = m2061b((SortedMap) treeMap);
            treeMap.put(e, Integer.valueOf(3));
            b2 = 3;
        }
        if (b2 == 3 && b2 < i) {
            m2062c(treeMap);
            treeMap.put(e, Integer.valueOf(4));
            b2 = 4;
        }
        if (b2 == 4 && b2 < i) {
            treeMap = m2064d(treeMap);
            treeMap.put(e, Integer.valueOf(5));
            b2 = 5;
        }
        if (b2 != 5 || b2 >= i) {
            return treeMap;
        }
        treeMap = m2066e(treeMap);
        treeMap.put(e, Integer.valueOf(6));
        return treeMap;
    }

    private static int m2059b(Map<PrefKey, Object> map) {
        PrefKey e = m2065e();
        PrefKey d = m2063d();
        if (map.containsKey(e)) {
            return ((Integer) map.get(e)).intValue();
        }
        if (map.containsKey(d)) {
            return 1;
        }
        return 0;
    }

    @VisibleForTesting
    private SortedMap<PrefKey, Object> m2057a(SortedMap<PrefKey, Object> sortedMap, Map<String, String> map) {
        SortedMap<PrefKey, Object> f = Maps.m844f();
        for (Entry entry : map.entrySet()) {
            PrefKey prefKey;
            PrefKey prefKey2 = new PrefKey((String) entry.getKey());
            if (entry.getValue() != f1013a) {
                prefKey = new PrefKey((String) entry.getValue());
            } else {
                prefKey = null;
            }
            m2058a(prefKey2, prefKey, sortedMap, f);
        }
        return f;
    }

    private SortedMap<PrefKey, Object> m2061b(SortedMap<PrefKey, Object> sortedMap) {
        PrefKey prefKey = new PrefKey("/auth/user_data/fb_me_user");
        PrefKey prefKey2 = new PrefKey("/auth/user_data/fb_uid");
        String str = (String) sortedMap.get(prefKey);
        if (str != null) {
            try {
                sortedMap.put(prefKey2, JSONUtil.m13454a(((ObjectMapper) this.f1014b.get()).m6636a(str).mo709b("uid"), null));
            } catch (IOException e) {
            }
        }
        return sortedMap;
    }

    private static SortedMap<PrefKey, Object> m2062c(SortedMap<PrefKey, Object> sortedMap) {
        PrefKey prefKey = new PrefKey("/fb_android/bookmarks/newsfeed_filter_type_key");
        ImmutableMap b = ImmutableMap.builder().m609b(Integer.valueOf(0), "most_recent").m609b(Integer.valueOf(1), "top_stories").m610b();
        Object remove = sortedMap.remove(prefKey);
        if (remove instanceof String) {
            sortedMap.put(prefKey, remove);
        } else if (remove instanceof Integer) {
            String str = (String) b.get((Integer) remove);
            if (str != null) {
                sortedMap.put(prefKey, str);
            }
        }
        return sortedMap;
    }

    private static SortedMap<PrefKey, Object> m2064d(SortedMap<PrefKey, Object> sortedMap) {
        PrefKey prefKey = new PrefKey("/fb_android/notifications/polling_interval");
        PrefKey prefKey2 = new PrefKey("/notifications/polling_interval");
        Object remove = sortedMap.remove(prefKey);
        if (remove instanceof String) {
            sortedMap.put(prefKey2, remove);
        }
        return sortedMap;
    }

    private static SortedMap<PrefKey, Object> m2066e(SortedMap<PrefKey, Object> sortedMap) {
        PrefKey prefKey = new PrefKey("/fb_android/uvm/sync");
        PrefKey prefKey2 = new PrefKey("/contactsync/nux_shown");
        Object remove = sortedMap.remove(prefKey);
        if (remove != null && (remove instanceof String)) {
            sortedMap.put(prefKey2, Boolean.valueOf(Boolean.parseBoolean((String) remove)));
        }
        return sortedMap;
    }
}
