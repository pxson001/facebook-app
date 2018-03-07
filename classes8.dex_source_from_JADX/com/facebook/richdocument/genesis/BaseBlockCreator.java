package com.facebook.richdocument.genesis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.richdocument.presenter.BlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;

/* compiled from: post_text */
public abstract class BaseBlockCreator<V extends BlockView> {
    private final int f5283a;
    public final int f5284b;

    public abstract BlockPresenter mo263a(V v);

    public abstract V mo264a(View view);

    public BaseBlockCreator(int i, int i2) {
        this.f5283a = i;
        this.f5284b = i2;
    }

    public BlockViewHolder mo265a(ViewGroup viewGroup) {
        BlockView a = mo264a(LayoutInflater.from(viewGroup.getContext()).inflate(this.f5283a, viewGroup, false));
        mo263a(a);
        return new BlockViewHolder(a);
    }
}
