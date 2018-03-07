package com.facebook.events.permalink.adapters;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Pair;
import com.facebook.widget.listview.FbListAdapter;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: c208b535e6b6d71f55b821daa983ae61 */
public class AdapterWithOffsets<T> {
    public final T f18135a;
    public final int f18136b;
    public final int f18137c;

    public AdapterWithOffsets(T t, int i) {
        this.f18135a = t;
        this.f18136b = -1;
        this.f18137c = i;
    }

    public AdapterWithOffsets(T t, int i, int i2) {
        this.f18135a = t;
        this.f18136b = i;
        this.f18137c = i2;
    }

    public final int m18506a(int i) {
        Preconditions.checkState(this.f18136b != -1);
        return i - this.f18136b;
    }

    public final int m18509b(int i) {
        return this.f18137c + i;
    }

    public final FbListAdapter m18508a() {
        return (FbListAdapter) this.f18135a;
    }

    public final <VH extends ViewHolder> Adapter<VH> m18510b() {
        return (Adapter) this.f18135a;
    }

    public final boolean m18511c() {
        return this.f18135a instanceof Adapter;
    }

    @Nullable
    public final Pair<Integer, Integer> m18507a(int i, int i2) {
        if (i2 < i) {
            return null;
        }
        int i3 = i - this.f18136b;
        int i4 = i2 - this.f18136b;
        if (i4 < 0) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        return new Pair(Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
