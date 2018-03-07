package com.facebook.crudolib.dao.recyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@TargetApi(11)
/* compiled from: TreehouseTTNotifWarm */
public abstract class DAOItemCursorAdapter<T extends DAOItem, V extends ViewHolder> extends RecyclerCursorAdapter<V> {
    @Nullable
    private T f23975b;

    protected abstract void m25924a(V v, T t);

    public DAOItemCursorAdapter(Context context) {
        super(context);
    }

    public final void m25922a(Cursor cursor, @Nullable T t) {
        this.f23975b = t;
        super.mo1103a(cursor);
    }

    public final void mo1103a(Cursor cursor) {
        throw new UnsupportedOperationException("Cannot call changeCursor(cursor), must call changeCursor(cursor, daoItem)");
    }

    @Nonnull
    public final T m25925d() {
        if (this.f23975b != null) {
            return this.f23975b;
        }
        throw new IllegalStateException("getDAOItem called from an illegal context");
    }

    public void mo1104a(V v, int i) {
        super.mo1104a(v, i);
        m25924a((ViewHolder) v, (DAOItem) Assertions.b(this.f23975b));
    }
}
