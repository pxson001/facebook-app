package com.facebook.widget.viewpager;

import android.database.Cursor;
import android.support.v4.view.PagerAdapter;
import javax.annotation.Nullable;

/* compiled from: share_map */
public abstract class CursorPagerAdapter extends PagerAdapter {
    @Nullable
    public Cursor f3567a;

    public CursorPagerAdapter() {
        this(null);
    }

    private CursorPagerAdapter(@Nullable Cursor cursor) {
        m3357a(cursor, false);
    }

    public void m3358a(@Nullable Cursor cursor) {
        m3357a(cursor, true);
    }

    private void m3357a(@Nullable Cursor cursor, boolean z) {
        if (this.f3567a != null) {
            this.f3567a.close();
        }
        this.f3567a = cursor;
        if (z) {
            kR_();
        }
    }

    public final synchronized int m3359b() {
        int i;
        if (this.f3567a == null) {
            i = 0;
        } else {
            i = this.f3567a.getCount();
        }
        return i;
    }
}
