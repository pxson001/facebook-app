package com.facebook.backstage.consumption;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/* compiled from: saveDraftParams */
public class BackstageSwipeRefreshLayout extends SwipeRefreshLayout {
    public BackstageSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public BackstageSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColorSchemeResources(new int[]{17170459, 17170452, 17170456, 17170454});
    }
}
