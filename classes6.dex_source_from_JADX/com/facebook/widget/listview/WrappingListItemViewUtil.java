package com.facebook.widget.listview;

import android.view.View;
import javax.annotation.Nullable;

/* compiled from: red */
public class WrappingListItemViewUtil {
    @Nullable
    public static View m8672a(View view) {
        if (view == null) {
            return null;
        }
        if (!(view instanceof WrappingListItemView)) {
            return view;
        }
        View wrappedView = ((WrappingListItemView) view).getWrappedView();
        if (wrappedView != null) {
            return wrappedView;
        }
        return view;
    }
}
