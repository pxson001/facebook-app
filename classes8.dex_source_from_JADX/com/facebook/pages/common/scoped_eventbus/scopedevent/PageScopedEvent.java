package com.facebook.pages.common.scoped_eventbus.scopedevent;

import com.facebook.content.event.FbEvent;

/* compiled from: critic_review_page_tap */
public abstract class PageScopedEvent<ID> implements FbEvent {
    public final ID f16571a;

    public PageScopedEvent(ID id) {
        this.f16571a = id;
    }
}
