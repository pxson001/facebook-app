package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.hscrollrecyclerview.SnapRecyclerView.SnapDelegate;
import javax.inject.Inject;

/* compiled from: disable_light */
public class HScrollRecyclerView extends SnapRecyclerView implements SnapDelegate {
    @Inject
    public HScrollLinearLayoutManager f13799h;
    private RecyclerListener f13800i;
    public OnPageChangedListener f13801m;
    private int f13802n;
    private int f13803o;
    private int f13804p;

    /* compiled from: disable_light */
    public interface OnPageChangedListener {
        void mo1013a(int i, int i2);
    }

    private static <T extends View> void m14562a(Class<T> cls, T t) {
        m14563a((Object) t, t.getContext());
    }

    private static void m14563a(Object obj, Context context) {
        ((HScrollRecyclerView) obj).f13799h = HScrollLinearLayoutManager.m14579b(FbInjector.get(context));
    }

    private void m14560a(HScrollLinearLayoutManager hScrollLinearLayoutManager) {
        this.f13799h = hScrollLinearLayoutManager;
    }

    public HScrollRecyclerView(Context context) {
        this(context, null);
    }

    public HScrollRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HScrollRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13802n = -1;
        this.f13803o = -1;
        this.f13804p = 0;
        m14565m();
    }

    private void m14565m() {
        m14562a(HScrollRecyclerView.class, (View) this);
        this.f13799h = getLayoutManagerForInit();
        this.f13799h.b(0);
        setLayoutManager(this.f13799h);
        if (!this.f13807j) {
            setOnScrollListener(new 1(this, OrientationHelper.a(this.f13799h, this.f13799h.j)));
        }
        this.f13812o = this;
    }

    protected HScrollLinearLayoutManager getLayoutManagerForInit() {
        return this.f13799h;
    }

    public void setAdapter(Adapter adapter) {
        String str;
        HScrollLinearLayoutManager hScrollLinearLayoutManager = this.f13799h;
        if (adapter == null) {
            str = null;
        } else {
            str = String.valueOf(adapter.hashCode());
        }
        hScrollLinearLayoutManager.f13813a = str;
        super.setAdapter(adapter);
    }

    public final void mo990g(int i, int i2) {
        this.f13804p = i;
        this.f13799h.f13818f = (((i2 - getPaddingLeft()) - getPaddingRight()) - i) / 2;
        this.f13799h.m14580a(((double) this.f13804p) / ((double) i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TracerDetour.a("HScrollRecyclerView.onLayout", -821164969);
        try {
            super.onLayout(z, i, i2, i3, i4);
        } finally {
            TracerDetour.a(-339171426);
        }
    }

    public void setOnPageChangedListener(OnPageChangedListener onPageChangedListener) {
        this.f13801m = onPageChangedListener;
    }

    public void setCurrentPosition(int i) {
        mo988b(i, false);
    }

    protected final void mo988b(int i, boolean z) {
        super.mo988b(i, z);
        m14564j(this, i, 0);
    }

    public final int mo989f(int i) {
        int abs = Math.abs(i);
        if (abs <= this.f13809l) {
            return 0;
        }
        return this.f13804p == 0 ? 1 : (abs / this.f13804p) + 1;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f13800i = recyclerListener;
        super.setRecyclerListener(recyclerListener);
    }

    public RecyclerListener getRecyclerListener() {
        return this.f13800i;
    }

    public static void m14564j(HScrollRecyclerView hScrollRecyclerView, int i, int i2) {
        if (i != hScrollRecyclerView.f13802n || i2 != hScrollRecyclerView.f13803o) {
            hScrollRecyclerView.f13802n = i;
            hScrollRecyclerView.f13803o = i2;
            if (hScrollRecyclerView.f13801m != null) {
                hScrollRecyclerView.f13801m.mo1013a(hScrollRecyclerView.f13802n, hScrollRecyclerView.f13803o);
            }
        }
    }

    public final void mo991h(int i, int i2) {
        if (this.o != null) {
            c();
            if (!(this.o == null || this.f13811n == null)) {
                this.f13808k = i;
                this.f13811n.d(i, i2);
            }
            m14564j(this, i, i2);
        }
    }
}
