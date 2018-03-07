package com.facebook.feed.rows.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: messages_count */
public class DelegatingMultiRowAdapter extends DelegatingHasMultiRow implements MultiRowAdapter {
    public final MultiRowAdapter f10378a;

    public DelegatingMultiRowAdapter(MultiRowAdapter multiRowAdapter) {
        super(multiRowAdapter);
        this.f10378a = multiRowAdapter;
    }

    public final MultiRowAdapter m16533b() {
        return this.f10378a;
    }

    public final View m16531a(int i, ViewGroup viewGroup) {
        return this.f10378a.a(i, viewGroup);
    }

    public final void m16532a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f10378a.a(i, obj, view, i2, viewGroup);
    }

    public int getCount() {
        return this.f10378a.getCount();
    }

    public int getItemViewType(int i) {
        return this.f10378a.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.f10378a.getViewTypeCount();
    }

    public Object getItem(int i) {
        return this.f10378a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f10378a.getItemId(i);
    }

    public void notifyDataSetChanged() {
        this.f10378a.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f10378a.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f10378a.unregisterDataSetObserver(dataSetObserver);
    }

    public boolean hasStableIds() {
        return this.f10378a.hasStableIds();
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        View a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            a = m16531a(itemViewType, viewGroup);
            Preconditions.checkState(a != null, "createView() shall not return null value!");
        } else {
            a = view;
        }
        m16532a(i, getItem(i), a, itemViewType, viewGroup);
        return a;
    }

    public boolean isEmpty() {
        return this.f10378a.isEmpty();
    }

    public boolean areAllItemsEnabled() {
        return this.f10378a.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.f10378a.isEnabled(i);
    }
}
