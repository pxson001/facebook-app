package com.facebook.qe.store;

import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.store.Index.Visitor;

/* compiled from: show_edit_interface */
public class OverrideWithRemovalIndexVisitor implements Visitor {
    public int f4368a = -1;
    private final Index f4369b;
    private final View f4370c;
    private final ViewBuilder f4371d;
    private final int f4372e;

    public OverrideWithRemovalIndexVisitor(Index index, View view, ViewBuilder viewBuilder, int i) {
        this.f4369b = index;
        this.f4370c = view;
        this.f4371d = viewBuilder;
        this.f4372e = i;
    }

    public final void m6452a(String str, int i) {
        this.f4368a = this.f4369b.a(str);
        if (this.f4372e == this.f4368a) {
            int i2 = i + 1;
            int i3 = i + 2;
            int i4 = i + 3;
            this.f4371d.a(Authority.OVERRIDE, i + 0, false);
            this.f4371d.a(Authority.OVERRIDE, i2, false);
            this.f4371d.a(i3);
            this.f4371d.a(i4);
        }
    }

    public final void m6453a(String str, int i, int i2, boolean z) {
        Utils.a(i, i, i2, this.f4370c, this.f4371d, Authority.ASSIGNED);
        if (this.f4372e != this.f4368a) {
            Utils.a(i, i, i2, this.f4370c, this.f4371d, Authority.OVERRIDE);
        } else if (!z) {
            this.f4371d.a(i);
        }
    }
}
