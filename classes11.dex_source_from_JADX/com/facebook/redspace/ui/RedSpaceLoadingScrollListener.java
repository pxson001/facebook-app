package com.facebook.redspace.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: Payment method has a null credential_id */
public class RedSpaceLoadingScrollListener extends OnScrollListener {
    private final int f12345a;
    private final OnScrolledToBottomListener f12346b;

    /* compiled from: Payment method has a null credential_id */
    public interface OnScrolledToBottomListener {
        void mo340a();
    }

    public RedSpaceLoadingScrollListener(int i, OnScrolledToBottomListener onScrolledToBottomListener) {
        this.f12345a = i;
        this.f12346b = onScrolledToBottomListener;
    }

    public final void m12765a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
        if (m12766a(recyclerView)) {
            this.f12346b.mo340a();
        }
    }

    public final boolean m12766a(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        return linearLayoutManager.n() >= linearLayoutManager.D() - this.f12345a;
    }
}
