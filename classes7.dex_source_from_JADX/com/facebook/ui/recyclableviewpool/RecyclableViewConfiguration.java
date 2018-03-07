package com.facebook.ui.recyclableviewpool;

import android.view.View;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolLimit;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolPrefillAmount;
import com.facebook.widget.RecyclableView;

/* compiled from: enca */
public interface RecyclableViewConfiguration<T extends View & RecyclableView> {
    Class<T> m19316a();

    ViewPoolLimit m19317b();

    ViewPoolPrefillAmount m19318c();
}
