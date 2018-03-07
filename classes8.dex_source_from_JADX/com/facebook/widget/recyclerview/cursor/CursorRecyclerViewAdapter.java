package com.facebook.widget.recyclerview.cursor;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import javax.annotation.Nullable;

/* compiled from: video_length_ms */
public abstract class CursorRecyclerViewAdapter<C extends Cursor, VH extends ViewHolder> extends Adapter<VH> {
    @Nullable
    public C f564a;

    public final int aZ_() {
        if (this.f564a == null) {
            return 0;
        }
        return this.f564a.getCount();
    }
}
