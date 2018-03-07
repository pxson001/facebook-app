package com.facebook.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: size_style */
public interface FbCustomViewGroup {
    void attachRecyclableViewToParent(View view, int i, LayoutParams layoutParams);

    void detachRecyclableViewFromParent(View view);

    void removeRecyclableViewFromParent(View view, boolean z);
}
