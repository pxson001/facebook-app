package com.facebook.richdocument.view.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: offers_wallet */
public abstract class RecyclerViewChildSelector {
    public final RecyclerView f7250a;
    public final float f7251b;
    public final float f7252c;

    public RecyclerViewChildSelector(RecyclerView recyclerView) {
        this(recyclerView, 0.0f, 1.0f);
    }

    public RecyclerViewChildSelector(RecyclerView recyclerView, float f, float f2) {
        this.f7250a = recyclerView;
        this.f7251b = f;
        this.f7252c = f2;
    }

    public final View m7517a(Collection<View> collection) {
        Rect rect = new Rect();
        this.f7250a.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect(rect);
        rect2.top = rect.top + Math.round(this.f7251b * ((float) rect.height()));
        rect2.bottom = Math.round(((float) rect.height()) * this.f7252c) + rect.top;
        Rect rect3 = rect2;
        Collection arrayList = new ArrayList();
        for (View view : collection) {
            if (view != null && view.getVisibility() == 0) {
                Object obj;
                rect = m7515a(view);
                if (rect == null || !rect.intersect(rect3)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    arrayList.add(view);
                }
            }
        }
        if (arrayList.size() == 1) {
            return (View) arrayList.get(0);
        }
        if (arrayList.size() > 1) {
            return m7516a(arrayList, rect3);
        }
        return null;
    }

    public static Rect m7515a(View view) {
        if (view != null) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                return rect;
            }
        }
        return null;
    }

    private View m7516a(Collection<View> collection, Rect rect) {
        int height = rect.top + (rect.height() / 2);
        View view = null;
        int i = Integer.MAX_VALUE;
        for (View view2 : collection) {
            View view3;
            int i2;
            Rect a = m7515a(view2);
            int i3 = a.top;
            int i4 = a.bottom;
            if (i4 < height) {
                i3 = height - i4;
            } else if (i3 > height) {
                i3 -= height;
            } else {
                i3 = 0;
            }
            int i5 = i3;
            if (i5 < i) {
                int i6 = i5;
                view3 = view2;
                i2 = i6;
            } else {
                i2 = i;
                view3 = view;
            }
            i = i2;
            view = view3;
        }
        return view;
    }
}
