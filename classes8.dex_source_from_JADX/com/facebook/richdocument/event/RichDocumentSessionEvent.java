package com.facebook.richdocument.event;

import com.facebook.content.event.FbEvent;

/* compiled from: price_rating */
public class RichDocumentSessionEvent implements FbEvent {
    public final Action f5186a;

    /* compiled from: price_rating */
    public enum Action {
        OPEN_DOCUMENT,
        CLOSE_DOCUMENT
    }

    public RichDocumentSessionEvent(Action action) {
        this.f5186a = action;
    }
}
