package com.facebook.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import javax.annotation.Nullable;

/* compiled from: facts_after_cursor */
public class MergingAdapter extends BaseAdapter {
    private final BaseAdapter f13976a;
    private final BaseAdapter f13977b;

    public MergingAdapter(BaseAdapter baseAdapter, BaseAdapter baseAdapter2) {
        this.f13976a = baseAdapter;
        this.f13977b = baseAdapter2;
        this.f13977b.registerDataSetObserver(new DelegatingDataSetObserver(this));
        this.f13976a.registerDataSetObserver(new DelegatingDataSetObserver(this));
    }

    public int getItemViewType(int i) {
        if (i < this.f13976a.getCount()) {
            return this.f13976a.getItemViewType(i);
        }
        return this.f13976a.getViewTypeCount() + this.f13977b.getItemViewType(i - this.f13976a.getCount());
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        if (i < this.f13976a.getCount()) {
            return this.f13976a.getView(i, view, viewGroup);
        }
        return this.f13977b.getView(i - this.f13976a.getCount(), view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.f13976a.getViewTypeCount() + this.f13977b.getViewTypeCount();
    }

    public int getCount() {
        return this.f13976a.getCount() + this.f13977b.getCount();
    }

    public Object getItem(int i) {
        if (i < this.f13976a.getCount()) {
            return this.f13976a.getItem(i);
        }
        return this.f13977b.getItem(i - this.f13976a.getCount());
    }

    public long getItemId(int i) {
        if (i < this.f13976a.getCount()) {
            return this.f13976a.getItemId(i);
        }
        return this.f13977b.getItemId(i - this.f13976a.getCount());
    }

    public boolean areAllItemsEnabled() {
        return this.f13976a.areAllItemsEnabled() && this.f13977b.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        if (i < this.f13976a.getCount()) {
            return this.f13976a.isEnabled(i);
        }
        return this.f13977b.isEnabled(i - this.f13976a.getCount());
    }

    public boolean hasStableIds() {
        return this.f13976a.hasStableIds() && this.f13977b.hasStableIds();
    }

    public boolean isEmpty() {
        return this.f13976a.isEmpty() && this.f13977b.isEmpty();
    }
}
