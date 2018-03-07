package com.facebook.widget.listview;

import android.view.View;

/* compiled from: event_photo_check */
public class ListViewItemWithDataUtil {
    public static <T> T m13548a(View view) {
        View view2 = view;
        while (view2 != null && (view2 instanceof WrappingListItemView)) {
            view2 = ((WrappingListItemView) view2).getWrappedView();
        }
        if (view2 instanceof ListViewItemWithData) {
            return ((ListViewItemWithData) view2).getDataItem();
        }
        return null;
    }
}
