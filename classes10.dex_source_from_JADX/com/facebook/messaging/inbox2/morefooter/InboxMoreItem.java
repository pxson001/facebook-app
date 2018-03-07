package com.facebook.messaging.inbox2.morefooter;

import com.facebook.messaging.inbox2.items.InboxItem;

/* compiled from: sender_message */
public interface InboxMoreItem extends InboxItem {

    /* compiled from: sender_message */
    public enum State {
        LOAD_MORE,
        INVISIBLE,
        LOADING
    }

    State mo82m();

    String mo83n();

    int mo84o();
}
