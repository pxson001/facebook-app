package com.facebook.inject;

import com.facebook.debug.log.BLog;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.inject.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* compiled from: whitelisted_element */
public class StaticBindingVerifier {
    private static final Class<?> f771a = StaticBindingVerifier.class;
    private final Map<Key, Binding> f772b;
    private final List<String> f773c = Lists.m1296a();
    private int f774d;
    private final List<String> f775e = Lists.m1296a();
    private Set<Key> f776f = null;

    private StaticBindingVerifier(Map<Key, Binding> map) {
        this.f772b = map;
    }

    static void m1534a(Map<Key, Binding> map) {
        BLog.a(f771a, "Verify");
        new StaticBindingVerifier(map).m1533a();
    }

    private void m1533a() {
        if (this.f774d != 0) {
            StringBuilder stringBuilder;
            if (!this.f773c.isEmpty()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Static bindings do not match runtime bindings on this platform.\n");
                stringBuilder.append("Mismatched bindings:\n");
                for (String str : this.f773c) {
                    stringBuilder.append("  ");
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                }
                throw new ProvisioningException(stringBuilder.toString());
            } else if (((double) this.f775e.size()) / ((double) this.f774d) > 0.05d) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Many bound types we tried to load failed during load.  ");
                stringBuilder.append("If we notice too many load failures, this could indicate a systematic ");
                stringBuilder.append("problem with type loading that would hide other errors.  ");
                stringBuilder.append("Types that failed loading:\n");
                for (String str2 : this.f775e) {
                    stringBuilder.append("  ").append(str2).append("\n");
                }
                throw new ProvisioningException(stringBuilder.toString());
            }
        }
    }
}
