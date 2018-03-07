package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: is_viewer_subscribed */
public class PageItemsProvider extends AbstractAssistedProvider<PageItems> {
    public final PageItems m26359a(PagerBinderDelegate pagerBinderDelegate) {
        return new PageItems(pagerBinderDelegate, IdBasedSingletonScopeProvider.m1810b(this, 494));
    }
}
