package com.facebook.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;

/* compiled from: recentUnread */
public class BetterGridLayoutManager extends GridLayoutManager implements BetterLayoutManager {
    private BetterLayoutManagerDelegate f6122t;

    public BetterGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public final void m8684b(int i) {
        super.b(i);
        m8681J().a(i);
    }

    public final int m8683b(int i, Recycler recycler, State state) {
        try {
            return super.b(i, recycler, state);
        } catch (Throwable e) {
            throw new RuntimeException("Adapter count: " + D() + " Scroll amount: " + i + " " + state, e);
        }
    }

    public final int m8682I() {
        return m8681J().a();
    }

    private BetterLayoutManagerDelegate m8681J() {
        if (this.f6122t == null) {
            this.f6122t = new BetterLayoutManagerDelegate(this);
        }
        return this.f6122t;
    }
}
