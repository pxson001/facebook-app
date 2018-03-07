package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter.PageStyler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: is_viewer_subscribed_to_messenger_content */
public class HScrollRecyclerViewAdapterProvider extends AbstractAssistedProvider<HScrollRecyclerViewAdapter> {
    public final HScrollRecyclerViewAdapter m26358a(PageStyler pageStyler, PageItems pageItems) {
        return new HScrollRecyclerViewAdapter(HScrollViewTypes.m26352a((InjectorLike) this), pageStyler, pageItems);
    }
}
