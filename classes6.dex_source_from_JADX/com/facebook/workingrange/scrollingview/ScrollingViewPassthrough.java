package com.facebook.workingrange.scrollingview;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.widget.listview.WorkingRangeScrollable;
import com.facebook.widget.listview.WorkingRangeScrollableImpl;
import com.facebook.workingrange.core.SnapshotWithVisiblity;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: com.facebook.platform.extra.REF */
public class ScrollingViewPassthrough<Item> implements SnapshotWithVisiblity<Item> {
    public final WorkingRangeScrollableImpl f20203a;
    @Nullable
    private final Function<Object, Item> f20204b;
    public int f20205c = Integer.MIN_VALUE;
    public int f20206d = Integer.MIN_VALUE;

    public ScrollingViewPassthrough(WorkingRangeScrollable workingRangeScrollable, @Nullable Function<Object, Item> function) {
        this.f20203a = workingRangeScrollable;
        this.f20204b = function;
    }

    public final Item mo1043a(int i) {
        Item g = this.f20203a.f6098a.g(i);
        return this.f20204b == null ? g : this.f20204b.apply(g);
    }

    public final void m28825c() {
        this.f20205c = this.f20203a.m8670a();
        this.f20206d = this.f20203a.m8671b();
        m28820e();
    }

    public final void m28823a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.f20205c = -1;
            this.f20206d = -1;
            return;
        }
        this.f20205c = i;
        this.f20206d = (i + i2) - 1;
        m28820e();
    }

    public final int mo1042a() {
        return this.f20205c;
    }

    public final int mo1044b() {
        return this.f20206d;
    }

    private void m28820e() {
        Object obj;
        if (!this.f20203a.f6098a.C() || this.f20205c == -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f20205c = Integer.MIN_VALUE;
            this.f20206d = Integer.MIN_VALUE;
            return;
        }
        if (this.f20205c > this.f20206d || this.f20205c < 0 || this.f20206d < 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("Provided visibility indices [%d, %d] are invalid", Integer.valueOf(this.f20205c), Integer.valueOf(this.f20206d)));
        }
    }
}
