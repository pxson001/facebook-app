package com.facebook.nodes;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* compiled from: thread_pic_url */
class SyncThreadingModel extends BaseThreadingModel {
    private Node f3142b;
    private int f3143c = 0;

    SyncThreadingModel(NodeView nodeView) {
        super(nodeView);
    }

    public final void mo194a(Node node) {
        if (this.f3066b) {
            m4067c();
            this.f3066b = true;
        }
        int childCount = this.f3065a.getChildCount();
        if (childCount > 0) {
            this.f3065a.removeViews(0, childCount);
        }
        this.f3067c.clear();
        this.f3068d.clear();
        this.f3069e = null;
        this.f3142b = node;
        this.f3142b.f3071b = this;
        this.f3142b.mo176a((BaseThreadingModel) this);
        mo195a(this.f3065a.getDrawableState());
        this.f3065a.requestLayout();
    }

    public final Node mo196e() {
        return this.f3142b;
    }

    public final void mo193a(int i, int i2) {
        LayoutParams layoutParams = this.f3142b.f3075f;
        this.f3142b.m4089b(ViewGroup.getChildMeasureSpec(i, this.f3065a.getPaddingLeft() + this.f3065a.getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, this.f3065a.getPaddingTop() + this.f3065a.getPaddingBottom(), layoutParams.height));
    }

    public final int mo197f() {
        return this.f3142b.f3089t;
    }

    public final int mo198g() {
        return this.f3142b.f3090u;
    }

    public final void mo199h() {
        int paddingLeft;
        int i;
        if (this.f3143c == 0) {
            paddingLeft = this.f3065a.getPaddingLeft();
            i = this.f3142b.f3089t + paddingLeft;
        } else {
            i = this.f3065a.getWidth() - this.f3065a.getPaddingRight();
            paddingLeft = i - this.f3142b.f3089t;
        }
        int paddingTop = this.f3065a.getPaddingTop();
        this.f3142b.m4086b(paddingLeft, paddingTop, i, this.f3142b.f3090u + paddingTop);
        this.f3065a.f3132a.mo206a();
        this.f3065a.invalidate();
    }

    public final void mo192a(int i) {
        if (this.f3143c != i) {
            this.f3143c = i;
            this.f3142b.mo181f(i);
        }
    }

    public final void mo200s() {
        this.f3065a.requestLayout();
    }

    public final void mo195a(int[] iArr) {
        if (this.f3142b != null) {
            this.f3142b.mo178a(iArr);
        }
    }
}
