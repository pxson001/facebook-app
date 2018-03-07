package com.facebook.common.cursors;

import android.database.Cursor;
import com.facebook.common.collect.CloseableIterator;
import com.google.common.base.Preconditions;

/* compiled from: forceLiveVideoToEnd */
public abstract class CursorIterator<E> implements CloseableIterator<E> {
    protected final Cursor f11476a;
    private E f11477b = null;
    private boolean f11478c = true;

    protected abstract E mo849a(Cursor cursor);

    public CursorIterator(Cursor cursor) {
        this.f11476a = (Cursor) Preconditions.checkNotNull(cursor);
    }

    public void close() {
        this.f11476a.close();
    }

    public boolean hasNext() {
        if (this.f11478c) {
            m11967a();
        }
        return this.f11477b != null;
    }

    public E next() {
        if (this.f11478c) {
            m11967a();
        }
        this.f11478c = true;
        return this.f11477b;
    }

    public void remove() {
        throw new UnsupportedOperationException(getClass().toString() + " does not support remove()");
    }

    private void m11967a() {
        this.f11478c = false;
        this.f11477b = this.f11476a.moveToNext() ? mo849a(this.f11476a) : null;
    }
}
