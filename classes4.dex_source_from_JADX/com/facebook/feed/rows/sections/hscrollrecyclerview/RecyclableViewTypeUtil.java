package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolLimit;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolPrefillAmount;
import com.facebook.widget.RecyclableView;

/* compiled from: num_of_retries */
public class RecyclableViewTypeUtil {
    public static final ViewPoolLimit f6563a = new ViewPoolLimit(3, 1);
    public static final ViewPoolPrefillAmount f6564b = new ViewPoolPrefillAmount(3, 1);

    public static <V extends View & RecyclableView> void m6979a(RecyclableViewPoolManager recyclableViewPoolManager, ViewType<V> viewType) {
        recyclableViewPoolManager.m6901a(viewType.getClass(), f6563a, f6564b);
    }
}
