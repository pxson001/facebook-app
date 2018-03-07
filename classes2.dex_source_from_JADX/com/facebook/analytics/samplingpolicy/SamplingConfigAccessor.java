package com.facebook.analytics.samplingpolicy;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: used_bytes */
public abstract class SamplingConfigAccessor {
    protected abstract int mo401a(String str, int i);

    protected abstract String mo402a(String str, String str2);

    public abstract Set<String> mo403a(String str, Set<String> set);

    SamplingConfigAccessor() {
    }

    public final boolean m2917a(String str) {
        return mo403a("__fs_policy_blacklisted_events__", Collections.emptySet()).contains(str);
    }

    public final String m2914a() {
        return mo402a("__fs_policy_config_checksum__", "");
    }

    public final boolean m2919b(String str) {
        return (m2917a(str) || mo401a(str, -2) == -2) ? false : true;
    }

    public final boolean m2920c(String str) {
        return (m2917a(str) || m2919b(str)) ? false : true;
    }

    public final boolean m2918b() {
        return !TextUtils.isEmpty(m2914a());
    }

    public final int m2913a(String str, @Nullable String str2, @Nullable String str3) {
        if (!m2918b()) {
            return -1;
        }
        if (m2917a(str)) {
            return 0;
        }
        Integer valueOf;
        if (!(str2 == null || str3 == null)) {
            valueOf = Integer.valueOf(mo401a(str + ":" + str2 + ":" + str3, -2));
            if (valueOf.intValue() != -2) {
                return valueOf.intValue();
            }
        }
        if (str2 != null) {
            valueOf = Integer.valueOf(mo401a(str + ":" + str2, -2));
            if (valueOf.intValue() != -2) {
                return valueOf.intValue();
            }
        }
        valueOf = Integer.valueOf(mo401a(str, -2));
        if (valueOf.intValue() != -2) {
            return valueOf.intValue();
        }
        return 1;
    }
}
