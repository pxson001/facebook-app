package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: friend_confirm */
public abstract class ViewGroupManager<T extends ViewGroup> extends BaseViewManager<T, LayoutShadowNode> {
    public /* synthetic */ ReactShadowNode mo742c() {
        return m13960d();
    }

    public LayoutShadowNode m13960d() {
        return new LayoutShadowNode();
    }

    public Class<? extends LayoutShadowNode> mo741b() {
        return LayoutShadowNode.class;
    }

    public void mo766a(T t, View view, int i) {
        t.addView(view, i);
    }

    public int mo763a(T t) {
        return t.getChildCount();
    }

    public View mo764a(T t, int i) {
        return t.getChildAt(i);
    }

    public void mo768b(T t, int i) {
        t.removeViewAt(i);
    }

    public final void m13954a(T t, View view) {
        for (int i = 0; i < mo763a(t); i++) {
            if (mo764a((ViewGroup) t, i) == view) {
                mo768b(t, i);
                return;
            }
        }
    }

    public void mo767b(T t) {
        for (int a = mo763a(t) - 1; a >= 0; a--) {
            mo768b(t, a);
        }
    }

    public boolean m13961e() {
        return false;
    }
}
