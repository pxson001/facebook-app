package com.facebook.groups.editfavorites.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.widget.listview.DragSortListView;

/* compiled from: action_report_battery_status */
public class GroupsEditFavoritesDragSortListView extends DragSortListView {
    public GroupsEditFavoritesDragSortListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GroupsEditFavoritesDragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    protected final void m10481a(View view) {
        if (m10483b(view)) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -2;
            view.setVisibility(0);
            view.setLayoutParams(layoutParams);
        }
    }

    protected final void m10482a(View view, int i, int i2, int i3) {
        if (m10483b(view)) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setVisibility(i3);
            view.setLayoutParams(layoutParams);
            GroupFavoriteRowView groupFavoriteRowView = (GroupFavoriteRowView) view;
            groupFavoriteRowView.getChildAt(0).setLayoutParams(new FrameLayout.LayoutParams(-1, this.a, i2));
        }
    }

    protected final boolean m10483b(View view) {
        if (view == null) {
            return false;
        }
        View findViewById = view.findViewById(this.c);
        if (findViewById == null || findViewById.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
