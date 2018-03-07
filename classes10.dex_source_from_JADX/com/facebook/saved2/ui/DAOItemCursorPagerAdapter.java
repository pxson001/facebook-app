package com.facebook.saved2.ui;

import android.database.Cursor;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.widget.viewpager.CursorPagerAdapter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: instant_shopping_catalog_sequence_events */
public abstract class DAOItemCursorPagerAdapter<DAO extends DAOItem> extends CursorPagerAdapter {
    @Nullable
    private DAO f9443a;

    public final void m9715a(Cursor cursor, @Nullable DAO dao) {
        this.f9443a = dao;
        super.a(cursor);
    }

    public final void m9714a(Cursor cursor) {
        if (cursor != null) {
            throw new UnsupportedOperationException("Cannot call changeCursor(cursor), must call changeCursor(cursor, daoItem)");
        }
    }

    @Nonnull
    public final DAO m9716e() {
        if (this.f9443a != null) {
            return this.f9443a;
        }
        throw new IllegalStateException("getDAOItem called from an illegal context");
    }

    @Nonnull
    public final DAO m9713a(int i) {
        this.f9443a.a(i);
        return this.f9443a;
    }
}
