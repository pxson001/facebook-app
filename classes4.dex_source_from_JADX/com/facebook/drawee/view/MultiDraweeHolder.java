package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

/* compiled from: o_is_prefetch */
public class MultiDraweeHolder<DH extends DraweeHierarchy> {
    @VisibleForTesting
    public boolean f6342a = false;
    @VisibleForTesting
    public ArrayList<DraweeHolder<DH>> f6343b = new ArrayList();

    public final void m6812a() {
        if (!this.f6342a) {
            this.f6342a = true;
            for (int i = 0; i < this.f6343b.size(); i++) {
                ((DraweeHolder) this.f6343b.get(i)).b();
            }
        }
    }

    public final void m6818b() {
        if (this.f6342a) {
            this.f6342a = false;
            for (int i = 0; i < this.f6343b.size(); i++) {
                ((DraweeHolder) this.f6343b.get(i)).d();
            }
        }
    }

    public final boolean m6816a(MotionEvent motionEvent) {
        for (int i = 0; i < this.f6343b.size(); i++) {
            if (((DraweeHolder) this.f6343b.get(i)).a(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public final void m6819c() {
        if (this.f6342a) {
            for (int i = 0; i < this.f6343b.size(); i++) {
                ((DraweeHolder) this.f6343b.get(i)).d();
            }
        }
        this.f6343b.clear();
    }

    public final void m6814a(DraweeHolder<DH> draweeHolder) {
        int size = this.f6343b.size();
        Preconditions.a(draweeHolder);
        Preconditions.a(size, this.f6343b.size() + 1);
        this.f6343b.add(size, draweeHolder);
        if (this.f6342a) {
            draweeHolder.b();
        }
    }

    public final void m6813a(int i) {
        DraweeHolder draweeHolder = (DraweeHolder) this.f6343b.get(i);
        if (this.f6342a) {
            draweeHolder.d();
        }
        this.f6343b.remove(i);
    }

    public final DraweeHolder<DH> m6817b(int i) {
        return (DraweeHolder) this.f6343b.get(i);
    }

    public final int m6820d() {
        return this.f6343b.size();
    }

    public final boolean m6815a(Drawable drawable) {
        for (int i = 0; i < this.f6343b.size(); i++) {
            if (drawable == m6817b(i).h()) {
                return true;
            }
        }
        return false;
    }
}
