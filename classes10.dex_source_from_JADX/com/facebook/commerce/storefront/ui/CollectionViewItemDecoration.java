package com.facebook.commerce.storefront.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: couldn't extract text size from style */
public class CollectionViewItemDecoration extends ItemDecoration {
    private final int f15776a;
    private final int f15777b;

    public CollectionViewItemDecoration(int i, int i2) {
        this.f15776a = i;
        this.f15777b = i2;
    }

    public final void m16259a(Rect rect, View view, RecyclerView recyclerView, State state) {
        int e = RecyclerView.e(view) - this.f15776a;
        if (e >= 0) {
            float dimensionPixelSize = (float) recyclerView.getResources().getDimensionPixelSize(2131429766);
            rect.left = (int) dimensionPixelSize;
            if (e % this.f15777b == 0) {
                rect.left = (int) dimensionPixelSize;
                rect.right = ((int) dimensionPixelSize) / 2;
            } else if (e % this.f15777b == this.f15777b - 1) {
                rect.left = ((int) dimensionPixelSize) / 2;
                rect.right = (int) dimensionPixelSize;
            } else {
                rect.left = ((int) dimensionPixelSize) / 2;
                rect.right = ((int) dimensionPixelSize) / 2;
            }
        }
    }
}
