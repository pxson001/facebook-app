package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;

@ContextScoped
/* compiled from: direct_reply */
public class HScrollRecyclerViewChildMeasurer {
    private static HScrollRecyclerViewChildMeasurer f13821a;
    private static final Object f13822b = new Object();

    private static HScrollRecyclerViewChildMeasurer m14588a() {
        return new HScrollRecyclerViewChildMeasurer();
    }

    public final int[] m14592a(Recycler recycler, int i, int i2, int i3) {
        View c = recycler.c(i);
        TracerDetour.a("HScrollRecyclerViewChildMeasurer.measureView", 15986822);
        int[] a;
        try {
            a = m14590a(c, i2, i3);
            recycler.a(c);
            return a;
        } finally {
            a = 1115958529;
            TracerDetour.a(1115958529);
        }
    }

    public final int[] m14593a(View view, HScrollRecyclerViewAdapter hScrollRecyclerViewAdapter, int i, int i2) {
        TracerDetour.a("HScrollRecyclerViewChildMeasurer.measureView", -1851223332);
        try {
            hScrollRecyclerViewAdapter.m14732a(view, 0);
            int[] b = m14591b(view, i, i2);
            hScrollRecyclerViewAdapter.m14734b(view, 0);
            return b;
        } finally {
            TracerDetour.a(-559076082);
        }
    }

    public static HScrollRecyclerViewChildMeasurer m14589a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollRecyclerViewChildMeasurer a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f13822b) {
                HScrollRecyclerViewChildMeasurer hScrollRecyclerViewChildMeasurer;
                if (a3 != null) {
                    hScrollRecyclerViewChildMeasurer = (HScrollRecyclerViewChildMeasurer) a3.a(f13822b);
                } else {
                    hScrollRecyclerViewChildMeasurer = f13821a;
                }
                if (hScrollRecyclerViewChildMeasurer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14588a();
                        if (a3 != null) {
                            a3.a(f13822b, a2);
                        } else {
                            f13821a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = hScrollRecyclerViewChildMeasurer;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    @VisibleForTesting
    private static int[] m14590a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), layoutParams.height));
        int[] iArr = new int[2];
        iArr[0] = (view.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
        iArr[1] = layoutParams.topMargin + (view.getMeasuredHeight() + layoutParams.bottomMargin);
        return iArr;
    }

    @VisibleForTesting
    private static int[] m14591b(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), layoutParams.height));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }
}
