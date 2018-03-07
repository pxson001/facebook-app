package com.facebook.sequencelogger;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/carrier_logo_url */
public abstract class AbstractSequenceDefinition {
    public final String f486a;
    public final boolean f487b;
    public final ImmutableSet<String> f488c;
    private final String f489d;
    public final int f490e;
    public int f491f;
    public volatile boolean f492g;

    public AbstractSequenceDefinition(int i, String str) {
        this(i, str, false, RegularImmutableSet.f688a);
    }

    public AbstractSequenceDefinition(int i, String str, boolean z, @Nullable ImmutableSet<String> immutableSet) {
        this(i, str, z, immutableSet, "perf_sequence");
    }

    private AbstractSequenceDefinition(int i, String str, boolean z, @Nullable ImmutableSet<String> immutableSet, String str2) {
        this.f491f = Integer.MAX_VALUE;
        this.f490e = i;
        this.f486a = str;
        this.f487b = z;
        if (immutableSet != null) {
            this.f488c = immutableSet;
        } else {
            this.f488c = ImmutableSet.builder().m4812b();
        }
        this.f489d = str2;
        this.f492g = false;
    }

    public final boolean m1014a() {
        return this.f487b;
    }

    public final String m1015b() {
        return this.f486a;
    }

    public final String m1016d() {
        return this.f489d;
    }

    public final int m1017e() {
        return this.f490e;
    }

    public final void m1018h() {
        this.f491f = 0;
    }
}
