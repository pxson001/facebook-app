package com.facebook.slideshow.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: PLACE_SELECTED */
public class DragSortThumbnailListView extends BetterRecyclerView {
    public boolean f12569l;

    public DragSortThumbnailListView(Context context) {
        super(context);
        m12970o();
    }

    public DragSortThumbnailListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12970o();
    }

    public DragSortThumbnailListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12970o();
    }

    private void m12970o() {
        setLayoutManager(new BetterLinearLayoutManager(getContext(), 0, false));
    }

    public void setIsDraggingItem(boolean z) {
        this.f12569l = z;
    }
}
