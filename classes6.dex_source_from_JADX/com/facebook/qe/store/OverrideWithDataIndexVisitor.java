package com.facebook.qe.store;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.store.Index.Visitor;

/* compiled from: show_failure_state */
public class OverrideWithDataIndexVisitor implements Visitor {
    private static final Class<OverrideWithDataIndexVisitor> f4360a = OverrideWithDataIndexVisitor.class;
    private final Index f4361b;
    private final View f4362c;
    private final ViewBuilder f4363d;
    private final int f4364e;
    private final QuickExperimentInfo f4365f;
    private int f4366g = -1;
    private String f4367h;

    public OverrideWithDataIndexVisitor(Index index, View view, ViewBuilder viewBuilder, int i, QuickExperimentInfo quickExperimentInfo) {
        this.f4361b = index;
        this.f4362c = view;
        this.f4363d = viewBuilder;
        this.f4364e = i;
        this.f4365f = quickExperimentInfo;
    }

    public final void m6450a(String str, int i) {
        this.f4367h = str;
        this.f4366g = this.f4361b.a(str);
        if (this.f4364e == this.f4366g) {
            int i2 = i + 1;
            int i3 = i + 2;
            int i4 = i + 3;
            this.f4363d.a(Authority.OVERRIDE, i + 0, this.f4365f.d);
            this.f4363d.a(Authority.OVERRIDE, i2, true);
            this.f4363d.a(Authority.OVERRIDE, i3, this.f4365f.b());
            this.f4363d.a(Authority.OVERRIDE, i4, this.f4365f.c());
        }
    }

    public final void m6451a(String str, int i, int i2, boolean z) {
        Utils.a(i, i, i2, this.f4362c, this.f4363d, Authority.ASSIGNED);
        if (this.f4364e != this.f4366g) {
            Utils.a(i, i, i2, this.f4362c, this.f4363d, Authority.OVERRIDE);
        } else if (!z) {
            String str2 = (String) this.f4365f.f().get(str);
            if (str2 == null || str2.isEmpty()) {
                this.f4363d.a(i);
            } else {
                this.f4363d.a(Authority.OVERRIDE, this.f4367h, str, i, i2, str2);
            }
        }
    }
}
