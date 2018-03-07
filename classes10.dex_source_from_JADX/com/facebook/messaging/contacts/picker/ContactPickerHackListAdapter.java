package com.facebook.messaging.contacts.picker;

import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.filter.CustomFilterable;

/* compiled from: tcp443 */
public class ContactPickerHackListAdapter implements Filterable, ListAdapter, CustomFilterable {
    private final BaseSearchableContactPickerListAdapter f1798a;
    private boolean f1799b;
    public int f1800c;
    public Drawable f1801d;
    public OnScrollListener f1802e;

    public ContactPickerHackListAdapter(BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter, OnScrollListener onScrollListener) {
        this.f1798a = baseSearchableContactPickerListAdapter;
        this.f1802e = onScrollListener;
    }

    public boolean areAllItemsEnabled() {
        return this.f1798a.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.f1798a.isEnabled(i);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f1798a.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f1798a.unregisterDataSetObserver(dataSetObserver);
        this.f1799b = false;
    }

    public int getCount() {
        return this.f1798a.getCount();
    }

    public Object getItem(int i) {
        return this.f1798a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f1798a.getItemId(i);
    }

    public boolean hasStableIds() {
        return this.f1798a.hasStableIds();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1799b) {
            ListView listView;
            for (ViewParent viewParent = viewGroup; viewParent != null; viewParent = viewParent.getParent()) {
                if (viewParent instanceof ListView) {
                    listView = (ListView) viewParent;
                    break;
                }
            }
            listView = null;
            if (listView != null) {
                listView.setDividerHeight(0);
                listView.setDivider(listView.getResources().getDrawable(2130843719));
                listView.setVerticalFadingEdgeEnabled(false);
                if (this.f1800c > 0) {
                    listView.setPadding(this.f1800c, 0, this.f1800c, 0);
                    listView.setClipToPadding(false);
                    listView.setScrollBarStyle(33554432);
                }
                if (this.f1801d != null) {
                    listView.setSelector(this.f1801d);
                    listView.setDrawSelectorOnTop(true);
                }
                if (this.f1802e != null) {
                    listView.setOnScrollListener(this.f1802e);
                }
            }
            this.f1799b = true;
        }
        return this.f1798a.getView(i, view, viewGroup);
    }

    public int getItemViewType(int i) {
        return this.f1798a.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.f1798a.getViewTypeCount();
    }

    public boolean isEmpty() {
        return this.f1798a.isEmpty();
    }

    public Filter getFilter() {
        return this.f1798a.getFilter();
    }

    public final CustomFilter m1739a() {
        return this.f1798a.d();
    }
}
