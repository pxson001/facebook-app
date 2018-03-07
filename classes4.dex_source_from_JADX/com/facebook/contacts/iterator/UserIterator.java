package com.facebook.contacts.iterator;

import com.facebook.common.collect.CloseableIterator;
import com.facebook.user.model.User;

/* compiled from: draw_complete */
public interface UserIterator extends CloseableIterator<User> {
    void close();
}
