package com.facebook.qe.store;

import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.store.Index.Visitor;

/* compiled from: show_null_state */
public class OverrideRevertIndexVisitor implements Visitor {
    public int f4355a = -1;
    private final Index f4356b;
    private final View f4357c;
    private final ViewBuilder f4358d;
    private final int f4359e;

    public OverrideRevertIndexVisitor(Index index, View view, ViewBuilder viewBuilder, int i) {
        this.f4356b = index;
        this.f4357c = view;
        this.f4358d = viewBuilder;
        this.f4359e = i;
    }

    public final void m6448a(String str, int i) {
        this.f4355a = this.f4356b.a(str);
    }

    public final void m6449a(String str, int i, int i2, boolean z) {
        Utils.a(i, i, i2, this.f4357c, this.f4358d, Authority.ASSIGNED);
        if (this.f4359e != this.f4355a) {
            Utils.a(i, i, i2, this.f4357c, this.f4358d, Authority.OVERRIDE);
        }
    }
}
