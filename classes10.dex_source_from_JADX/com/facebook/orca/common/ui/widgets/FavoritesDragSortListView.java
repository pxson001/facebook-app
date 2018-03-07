package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.listview.DragSortListView;

/* compiled from: p2p_cancel_button_clicked */
public class FavoritesDragSortListView extends DragSortListView {
    private int f5315d;
    private int f5316e;

    /* compiled from: p2p_cancel_button_clicked */
    public abstract class DraggableRowView extends CustomViewGroup {
        public boolean f5314a = true;

        public abstract View getInnerRow();

        public DraggableRowView(Context context) {
            super(context);
        }

        public final boolean m4714a() {
            return this.f5314a;
        }

        public static void setCanConvert(DraggableRowView draggableRowView, boolean z) {
            draggableRowView.f5314a = z;
        }
    }

    public FavoritesDragSortListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavoritesDragSortListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5315d = -1;
        this.f5316e = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FavoritesDragSortListView, 0, 0);
            this.f5315d = obtainStyledAttributes.getResourceId(0, -1);
            this.f5316e = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
        }
    }

    protected final void m4715a(View view) {
        if (m4717b(view)) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.a;
            view.setVisibility(0);
            view.setLayoutParams(layoutParams);
            view.setVisibility(0);
            DragSortListView.a(view, this.f5315d, 4);
            DragSortListView.a(view, this.f5316e, 0);
        }
    }

    protected final void m4716a(View view, int i, int i2, int i3) {
        if (m4717b(view)) {
            DraggableRowView draggableRowView = (DraggableRowView) view;
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
            view.setVisibility(i3);
            draggableRowView.getInnerRow().setLayoutParams(new FrameLayout.LayoutParams(-1, this.a, i2));
            if (i != this.b) {
                DragSortListView.a(view, this.f5315d, 4);
            } else if (i2 == 48) {
                DragSortListView.a(view, this.f5316e, 0);
                DragSortListView.a(view, this.f5315d, 4);
                DragSortListView.a(view, this.f5316e, 0);
                DragSortListView.a(view, this.f5315d, 0);
            }
            if (i != this.a || i3 != 0) {
                draggableRowView.f5314a = false;
            }
        }
    }

    protected final boolean m4717b(View view) {
        return view.findViewById(this.c) != null;
    }
}
