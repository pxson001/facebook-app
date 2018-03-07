package com.facebook.feed.rows.core;

import android.view.View;
import android.widget.AbsListView.RecyclerListener;

/* compiled from: Wifi */
public class MultipleRowsStoriesRecycleCallback$AbsListViewRecyclerListener implements RecyclerListener {
    final /* synthetic */ MultipleRowsStoriesRecycleCallback f12250a;

    public MultipleRowsStoriesRecycleCallback$AbsListViewRecyclerListener(MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback) {
        this.f12250a = multipleRowsStoriesRecycleCallback;
    }

    public void onMovedToScrapHeap(View view) {
        MultipleRowsStoriesRecycleCallback.a(view);
    }
}
