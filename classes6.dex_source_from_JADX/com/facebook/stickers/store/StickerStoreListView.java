package com.facebook.stickers.store;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;
import com.facebook.widget.listview.DragSortListView;

/* compiled from: e1cafbfe0721f69eeffd6be89ce0e29b */
public class StickerStoreListView extends DragSortListView {
    private int f17007d;
    private int f17008e;
    private int f17009f;
    private int f17010g;

    public StickerStoreListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerStoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17007d = -1;
        this.f17008e = -1;
        this.f17009f = -1;
        this.f17010g = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StickerStoreListView, 0, 0);
        this.f17007d = obtainStyledAttributes.getResourceId(0, -1);
        this.f17008e = obtainStyledAttributes.getResourceId(1, -1);
        this.f17009f = obtainStyledAttributes.getResourceId(2, -1);
        this.f17010g = obtainStyledAttributes.getResourceId(3, -1);
        obtainStyledAttributes.recycle();
    }

    protected final void mo1291a(View view) {
        if (mo1293b(view)) {
            DragSortListView.m8590a(view, this.f17007d, 8);
            DragSortListView.m8590a(view, this.f17008e, 0);
            DragSortListView.m8590a(view, this.f17009f, 8);
            DragSortListView.m8590a(view, this.f17010g, 8);
            ((StickerStoreListItemView) view).f17005w = true;
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.f6009a;
            view.setLayoutParams(layoutParams);
            view.setVisibility(0);
        }
    }

    protected final void mo1292a(View view, int i, int i2, int i3) {
        if (mo1293b(view)) {
            StickerStoreListItemView stickerStoreListItemView = (StickerStoreListItemView) view;
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -2;
            view.setVisibility(i3);
            if (i != this.f6010b) {
                DragSortListView.m8590a(view, this.f17009f, 8);
                DragSortListView.m8590a(view, this.f17010g, 8);
                DragSortListView.m8590a(view, this.f17007d, 8);
                DragSortListView.m8590a(view, this.f17008e, 0);
                if (i != this.f6009a) {
                    layoutParams.height = i;
                }
            } else if (i2 == 48) {
                DragSortListView.m8590a(view, this.f17009f, 8);
                DragSortListView.m8590a(view, this.f17010g, 0);
                DragSortListView.m8590a(view, this.f17007d, 8);
                DragSortListView.m8590a(view, this.f17008e, 0);
            } else {
                DragSortListView.m8590a(view, this.f17009f, 0);
                DragSortListView.m8590a(view, this.f17010g, 8);
                DragSortListView.m8590a(view, this.f17007d, 0);
                DragSortListView.m8590a(view, this.f17008e, 0);
            }
            if (i3 != 0) {
                stickerStoreListItemView.f17005w = false;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    protected final boolean mo1293b(View view) {
        if (!(view instanceof StickerStoreListItemView)) {
            return false;
        }
        StickerStoreListItemView stickerStoreListItemView = (StickerStoreListItemView) view;
        boolean z = false;
        if (stickerStoreListItemView.f16991i != null && stickerStoreListItemView.f16991i.getVisibility() == 0) {
            z = true;
        }
        return z;
    }
}
