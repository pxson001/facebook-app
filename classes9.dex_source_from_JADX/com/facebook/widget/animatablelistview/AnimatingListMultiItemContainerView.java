package com.facebook.widget.animatablelistview;

import android.content.Context;
import android.view.View;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.listview.WrappingListItemView;

/* compiled from: android.permission.CALL_PHONE */
public class AnimatingListMultiItemContainerView extends CustomLinearLayout implements WrappingListItemView {
    public AnimatingListMultiItemContainerView(Context context) {
        super(context);
        setOrientation(1);
    }

    public View getWrappedView() {
        return getChildCount() > 0 ? getChildAt(0) : null;
    }
}
