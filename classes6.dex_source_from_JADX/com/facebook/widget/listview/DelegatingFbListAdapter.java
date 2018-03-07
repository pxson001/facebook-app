package com.facebook.widget.listview;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: remaining_character_count */
public class DelegatingFbListAdapter implements FbListAdapter {
    private final FbListAdapter f5999a;

    public DelegatingFbListAdapter(FbListAdapter fbListAdapter) {
        this.f5999a = fbListAdapter;
    }

    public final View m8583a(int i, ViewGroup viewGroup) {
        return this.f5999a.a(i, viewGroup);
    }

    public final void m8584a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f5999a.a(i, obj, view, i2, viewGroup);
    }

    public void notifyDataSetChanged() {
        this.f5999a.notifyDataSetChanged();
    }

    public boolean areAllItemsEnabled() {
        return this.f5999a.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.f5999a.isEnabled(i);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f5999a.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f5999a.unregisterDataSetObserver(dataSetObserver);
    }

    public int getCount() {
        return this.f5999a.getCount();
    }

    public Object getItem(int i) {
        return this.f5999a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f5999a.getItemId(i);
    }

    public boolean hasStableIds() {
        return this.f5999a.hasStableIds();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f5999a.getView(i, view, viewGroup);
    }

    public int getItemViewType(int i) {
        return this.f5999a.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.f5999a.getViewTypeCount();
    }

    public boolean isEmpty() {
        return this.f5999a.isEmpty();
    }
}
