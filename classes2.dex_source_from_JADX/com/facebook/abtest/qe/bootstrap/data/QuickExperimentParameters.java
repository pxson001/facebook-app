package com.facebook.abtest.qe.bootstrap.data;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
/* compiled from: photo_review_nux_seen */
public class QuickExperimentParameters {
    private final String f10010a;
    private final boolean f10011b;
    private final boolean f10012c;
    private final String f10013d;
    private final ImmutableMap<String, String> f10014e;

    public QuickExperimentParameters(boolean z, boolean z2, String str, ImmutableMap<String, String> immutableMap) {
        this("", z, z2, str, immutableMap);
    }

    public QuickExperimentParameters(String str, boolean z, boolean z2, String str2, ImmutableMap<String, String> immutableMap) {
        this.f10010a = (String) Preconditions.checkNotNull(str);
        this.f10011b = z;
        this.f10012c = z2;
        this.f10013d = (String) Preconditions.checkNotNull(str2);
        this.f10014e = (ImmutableMap) Preconditions.checkNotNull(immutableMap);
    }

    @Nullable
    private String m15058a(String str) {
        if ((!this.f10011b || this.f10013d.equals("local_default_group")) && !this.f10012c) {
            return null;
        }
        String str2 = (String) this.f10014e.get(str);
        return Strings.isNullOrEmpty(str2) ? null : str2;
    }

    public final String m15062a(String str, @Nullable String str2) {
        String a = m15058a(str);
        return a != null ? a : str2;
    }

    public final boolean m15063a(String str, boolean z) {
        String a = m15058a(str);
        return a != null ? m15059a(this.f10010a, str, a) : z;
    }

    public final long m15061a(String str, long j) {
        String a = m15058a(str);
        return a != null ? Long.decode(a).longValue() : j;
    }

    public final int m15060a(String str, int i) {
        String a = m15058a(str);
        return a != null ? Integer.parseInt(a) : i;
    }

    private static boolean m15059a(String str, String str2, String str3) {
        String toLowerCase = str3.toLowerCase(Locale.US);
        if ("true".equals(toLowerCase) || "yes".equals(toLowerCase) || "1".equals(toLowerCase)) {
            return true;
        }
        if ("false".equals(toLowerCase) || "no".equals(toLowerCase) || "0".equals(toLowerCase)) {
            return false;
        }
        throw new IllegalArgumentException("Experiment Name: \"" + str + "\", Parameter Name: \"" + str2 + "\", Invalid boolean: \"" + str3 + "\"");
    }

    public String toString() {
        return "/Group:" + this.f10013d + "/Experiment:" + this.f10011b + "/InDeployGroup:" + this.f10012c + "/customStrings: " + Joiner.on("\n").withKeyValueSeparator(": ").join(this.f10014e);
    }
}
