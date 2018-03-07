package com.facebook.contacts.iterator;

import com.facebook.contacts.omnistore.UserTranscription;
import com.facebook.omnistore.Cursor;
import com.facebook.user.model.User;
import javax.annotation.Nullable;

/* compiled from: payload_count */
public class UserOmnistoreIterator implements UserIterator {
    boolean f8252a = true;
    private final Cursor f8253b;
    private final UserTranscription f8254c;
    @Nullable
    private User f8255d = null;

    public UserOmnistoreIterator(Cursor cursor, UserTranscription userTranscription) {
        this.f8253b = cursor;
        this.f8254c = userTranscription;
    }

    public void close() {
        this.f8253b.close();
    }

    public void remove() {
        throw new UnsupportedOperationException(getClass().toString() + " does not support remove()");
    }

    public boolean hasNext() {
        if (this.f8252a) {
            m12101b();
        }
        return this.f8255d != null;
    }

    public Object next() {
        if (this.f8252a) {
            m12101b();
        }
        this.f8252a = true;
        return this.f8255d;
    }

    private void m12101b() {
        this.f8252a = false;
        this.f8255d = this.f8253b.step() ? this.f8254c.m12160a(this.f8253b.getPrimaryKey(), this.f8253b.getBlob()) : null;
    }
}
