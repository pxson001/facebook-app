package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.presenter.BlockPresenter;
import com.facebook.richdocument.view.block.BlockView;

/* compiled from: paged_data_source_discontinuity */
public abstract class AbstractBlockView<T extends BlockPresenter> implements InjectableComponentWithContext, BlockView<T> {
    public ViewHolder f6602a;
    private View f6603b;
    private T f6604c;

    public AbstractBlockView(View view) {
        this.f6603b = view;
    }

    public void mo375a(ViewHolder viewHolder) {
        this.f6602a = viewHolder;
    }

    public void mo376a(T t) {
        this.f6604c = t;
    }

    public final T iX_() {
        return this.f6604c;
    }

    public void mo374a(Bundle bundle) {
    }

    public final View iY_() {
        return this.f6603b;
    }

    public Context getContext() {
        return this.f6603b.getContext();
    }

    public boolean mo377a(int i, int i2) {
        return false;
    }

    public void mo378b(Bundle bundle) {
    }

    public void mo379c(Bundle bundle) {
    }
}
