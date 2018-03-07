package com.facebook.events.ui.themeselector;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: app_is_installed */
public class SpaceItemDecoration extends ItemDecoration {
    private int f19570a;
    private int f19571b;
    private int f19572c;

    public SpaceItemDecoration(int i, int i2, int i3) {
        this.f19570a = i;
        this.f19571b = i2;
        this.f19572c = i3;
    }

    public final void m19775a(Rect rect, View view, RecyclerView recyclerView, State state) {
        ViewHolder a = recyclerView.a(view);
        int e = RecyclerView.e(view);
        if (a instanceof ThemeViewHolder) {
            if (e % this.f19571b != 0) {
                rect.left = this.f19570a;
            }
            rect.bottom = this.f19570a;
        } else if (!(a instanceof ThemeLoaderViewHolder)) {
        } else {
            if (e == 0) {
                rect.top = (recyclerView.getHeight() - ViewCompat.s(view)) / 2;
            } else {
                rect.top = this.f19572c;
            }
        }
    }
}
