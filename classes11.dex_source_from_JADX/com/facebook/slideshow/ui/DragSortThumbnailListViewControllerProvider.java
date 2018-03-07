package com.facebook.slideshow.ui;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.slideshow.analytics.SlideshowLogger;

/* compiled from: PLACE_CLAIM */
public class DragSortThumbnailListViewControllerProvider extends AbstractAssistedProvider<DragSortThumbnailListViewController> {
    public final DragSortThumbnailListViewController m12993a(DragSortThumbnailListView dragSortThumbnailListView, String str) {
        return new DragSortThumbnailListViewController(dragSortThumbnailListView, str, SlideshowLogger.b(this), new DragSortThumbnailListAdapter((Context) getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(this)));
    }
}
