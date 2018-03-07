package com.facebook.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: not a valid float value */
public class BetterLinearLayoutManager extends LinearLayoutManager implements BetterLayoutManager {
    private BetterLayoutManagerDelegate f12190a;

    public BetterLinearLayoutManager(Context context) {
        super(context);
    }

    public BetterLinearLayoutManager(Context context, int i, boolean z) {
        super(i, z);
    }

    protected final void m17920a(AbstractFbErrorReporter abstractFbErrorReporter) {
        m17915c().f12208a = abstractFbErrorReporter;
    }

    public final void mo2302b(int i) {
        super.mo2302b(i);
        m17915c().m17999a(i);
    }

    public final LayoutParams mo2301b() {
        return new LayoutParams(-1, -2);
    }

    public final int mo2300b(int i, Recycler recycler, State state) {
        TracerDetour.a("BetterLinearLayoutManager.scrollVerticallyBy", -1146863961);
        try {
            int b = super.mo2300b(i, recycler, state);
            TracerDetour.a(1760586876);
            return b;
        } catch (Throwable e) {
            throw new RuntimeException("Adapter count: " + m17288D() + " Scroll amount: " + i + " " + state, e);
        } catch (Throwable th) {
            TracerDetour.a(-2034778066);
        }
    }

    public final int mo2297I() {
        return m17915c().m17998a();
    }

    public final void mo2304b(View view, int i, int i2) {
        TracerDetour.a("BetterLinearLayoutManager.measureChildWithMargins", 240356205);
        try {
            super.mo2304b(view, i, i2);
        } finally {
            TracerDetour.a(1426560024);
        }
    }

    public final void mo2299a(View view, int i, int i2, int i3, int i4) {
        TracerDetour.a("BetterLinearLayoutManager.layoutDecorated", -769499428);
        try {
            super.mo2299a(view, i, i2, i3, i4);
        } finally {
            TracerDetour.a(-1877398806);
        }
    }

    public final void mo2303b(View view, int i) {
        TracerDetour.a("BetterLinearLayoutManager.addView", 259265234);
        try {
            super.mo2303b(view, i);
        } finally {
            TracerDetour.a(-662339497);
        }
    }

    public void mo2296a(View view, Recycler recycler) {
        TracerDetour.a("BetterLinearLayoutManager.removeAndRecycleView", 330239721);
        try {
            super.mo2296a(view, recycler);
        } finally {
            TracerDetour.a(1101747694);
        }
    }

    public final void mo2298a(RecyclerView recyclerView, State state, int i) {
        if (i != -1) {
            super.mo2298a(recyclerView, state, i);
        }
    }

    private BetterLayoutManagerDelegate m17915c() {
        if (this.f12190a == null) {
            this.f12190a = new BetterLayoutManagerDelegate(this);
        }
        return this.f12190a;
    }
}
