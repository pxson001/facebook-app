package com.facebook.crudolib.dao.recyclerview;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import javax.annotation.Nullable;

/* compiled from: TreehouseTTPogs */
public abstract class RecyclerCursorAdapter<V extends ViewHolder> extends Adapter<V> {
    protected Context f23970a;
    @Nullable
    public Cursor f23971b;
    public DataSetObserver f23972c;
    public boolean f23973d;
    public int f23974e;

    /* compiled from: TreehouseTTPogs */
    class NotifyingDataSetObserver extends DataSetObserver {
        final /* synthetic */ RecyclerCursorAdapter f23976a;

        public NotifyingDataSetObserver(RecyclerCursorAdapter recyclerCursorAdapter) {
            this.f23976a = recyclerCursorAdapter;
        }

        public void onChanged() {
            super.onChanged();
            this.f23976a.f23973d = true;
            this.f23976a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            this.f23976a.f23973d = false;
            this.f23976a.notifyDataSetChanged();
        }
    }

    public RecyclerCursorAdapter(Context context) {
        this(context, null);
    }

    private RecyclerCursorAdapter(Context context, @Nullable Cursor cursor) {
        this.f23970a = context;
        this.f23971b = cursor;
        this.f23973d = cursor != null;
        this.f23974e = this.f23973d ? this.f23971b.getColumnIndex("_id") : -1;
        this.f23972c = new NotifyingDataSetObserver(this);
        if (this.f23971b != null) {
            this.f23971b.registerDataSetObserver(this.f23972c);
        }
        a(true);
    }

    public void mo1104a(V v, int i) {
        if (!this.f23973d) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (!this.f23971b.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public final int aZ_() {
        if (!this.f23973d || this.f23971b == null) {
            return 0;
        }
        return this.f23971b.getCount();
    }

    public final long H_(int i) {
        if (this.f23973d && this.f23971b != null && this.f23971b.moveToPosition(i)) {
            return this.f23971b.getLong(this.f23974e);
        }
        return 0;
    }

    public final void m25920a(boolean z) {
        super.a(true);
    }

    public void mo1103a(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.f23971b) {
            cursor2 = null;
        } else {
            cursor2 = this.f23971b;
            if (!(cursor2 == null || this.f23972c == null)) {
                cursor2.unregisterDataSetObserver(this.f23972c);
            }
            this.f23971b = cursor;
            if (this.f23971b != null) {
                if (this.f23972c != null) {
                    this.f23971b.registerDataSetObserver(this.f23972c);
                }
                this.f23974e = cursor.getColumnIndexOrThrow("_id");
                this.f23973d = true;
                notifyDataSetChanged();
            } else {
                this.f23974e = -1;
                this.f23973d = false;
                notifyDataSetChanged();
            }
        }
        Cursor cursor3 = cursor2;
        if (cursor3 != null) {
            cursor3.close();
        }
    }
}
