package com.facebook.richdocument.view.transition;

import android.graphics.Rect;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;

/* compiled from: orientation attribute must be either "horizontal" or "vertical" */
public final class ViewRect implements ViewAttribute<Rect> {
    public final Rect f7004a;

    public ViewRect(int i, int i2, int i3, int i4) {
        this.f7004a = new Rect(i, i2, i3, i4);
    }

    public ViewRect(Rect rect) {
        this.f7004a = new Rect(rect);
    }

    private ViewRect(ViewRect viewRect) {
        this.f7004a = new Rect(viewRect.f7004a);
    }

    public final Rect m7324b() {
        return this.f7004a;
    }

    public final /* synthetic */ Object mo415d() {
        return this.f7004a;
    }

    public final ViewAttributeType mo412a() {
        return ViewAttributeType.RECT;
    }

    public final int m7328e() {
        return this.f7004a.width();
    }

    public final int m7329f() {
        return this.f7004a.height();
    }

    public final void m7323a(int i) {
        int height = this.f7004a.height();
        this.f7004a.top = i;
        this.f7004a.bottom = height + i;
    }

    public final void m7325b(int i) {
        int width = this.f7004a.width();
        this.f7004a.left = i;
        this.f7004a.right = width + i;
    }

    public final int m7330g() {
        return this.f7004a.top;
    }

    public final int m7331h() {
        return this.f7004a.bottom;
    }

    public final ViewAttribute<Rect> mo413a(ViewAttribute<Rect> viewAttribute, float f) {
        Rect rect = (Rect) viewAttribute.mo415d();
        return new ViewRect(new Rect(ViewLayoutUtil.m7315a(this.f7004a.left, rect.left, f), ViewLayoutUtil.m7315a(this.f7004a.top, rect.top, f), ViewLayoutUtil.m7315a(this.f7004a.right, rect.right, f), ViewLayoutUtil.m7315a(this.f7004a.bottom, rect.bottom, f)));
    }

    public final ViewAttribute<Rect> mo414c() {
        return new ViewRect(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f7004a.equals(((ViewRect) obj).f7004a);
    }

    public final int hashCode() {
        return this.f7004a.hashCode();
    }

    public final String toString() {
        return "{type: " + mo412a() + ", l: " + this.f7004a.left + ", t: " + this.f7004a.top + ", w: " + this.f7004a.width() + ", h: " + this.f7004a.height() + "}";
    }
}
