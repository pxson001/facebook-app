package com.facebook.richdocument.view.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.impl.MediaBlockView;

/* compiled from: open_url */
public final class BlockViewHolder<V extends BlockView> extends ViewHolder {
    private final V f7080l;

    public BlockViewHolder(V v) {
        super(v instanceof MediaBlockView ? ((MediaBlockView) v).m6991g() : v.iY_());
        this.f7080l = v;
        this.f7080l.mo375a(this);
    }

    public final void m7382a(BlockData blockData) {
        m7383w().mo366a(blockData);
    }

    public final AbstractBlockPresenter m7383w() {
        return this.f7080l.iX_();
    }
}
