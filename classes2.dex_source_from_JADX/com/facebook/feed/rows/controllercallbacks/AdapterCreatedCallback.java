package com.facebook.feed.rows.controllercallbacks;

import com.facebook.controllercallbacks.api.ControllerCallback;
import com.facebook.controllercallbacks.api.SetUp;
import com.facebook.controllercallbacks.api.TearDown;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.widget.listview.ScrollingViewProxy;

@ControllerCallback
/* compiled from: privacy */
public interface AdapterCreatedCallback {
    @SetUp
    void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment);

    @TearDown
    void kF_();
}
