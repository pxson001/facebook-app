package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerIndicatorPartDefinition.OnPageChangedListener;
import com.facebook.flatbuffers.Flattenable;

/* compiled from: offline_retry_success */
public class FeedUnitAndChangePageListener<T extends Flattenable> {
    public final FeedProps<T> f6289a;
    public final OnPageChangedListener f6290b;

    public FeedUnitAndChangePageListener(FeedProps<T> feedProps, OnPageChangedListener onPageChangedListener) {
        this.f6289a = feedProps;
        this.f6290b = onPageChangedListener;
    }
}
