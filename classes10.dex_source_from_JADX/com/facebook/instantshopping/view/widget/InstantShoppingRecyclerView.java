package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.richdocument.view.widget.RichDocumentRecyclerView;
import com.facebook.widget.recyclerview.BetterLayoutManager;

/* compiled from: SHARE_MAYBE */
public class InstantShoppingRecyclerView extends RichDocumentRecyclerView {
    public InstantShoppingRecyclerView(Context context) {
        super(context);
    }

    public InstantShoppingRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantShoppingRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected BetterLayoutManager getBetterLayoutManager() {
        throw new UnsupportedOperationException("GridLayoutManager does not support type BetterLayoutManager");
    }
}
