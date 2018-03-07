package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: SLIDESHOW_POSTED */
public class PopoverFilterWindowsAdapter extends FbBaseAdapter {
    private final List<FilterValue> f22891a;
    private final Context f22892b;
    private final LayoutInflater f22893c = ((LayoutInflater) this.f22892b.getSystemService("layout_inflater"));

    public PopoverFilterWindowsAdapter(Context context, List<FilterValue> list) {
        this.f22892b = context;
        this.f22891a = list;
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public boolean isEnabled(int i) {
        return true;
    }

    public int getCount() {
        return this.f22891a.size();
    }

    public Object getItem(int i) {
        return this.f22891a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public boolean hasStableIds() {
        return false;
    }

    public final View m26533a(int i, ViewGroup viewGroup) {
        return i == 0 ? this.f22893c.inflate(2130907011, viewGroup, false) : this.f22893c.inflate(2130907006, viewGroup, false);
    }

    public final void m26534a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        FilterValue filterValue = (FilterValue) obj;
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(filterValue.f8689a);
        if (filterValue.f8693e != null) {
            contentView.setThumbnailUri(filterValue.f8693e);
        } else {
            contentView.setThumbnailDrawable(null);
        }
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        Object obj = 1;
        Object obj2 = ((view instanceof ContentViewWithButton) || !(view instanceof ContentView)) ? null : 1;
        if ((obj2 == null || getItemViewType(i) != 1) && !((view instanceof ContentViewWithButton) && getItemViewType(i) == 0)) {
            obj = null;
        }
        if (obj == null) {
            view = null;
        }
        return super.getView(i, view, viewGroup);
    }

    public int getItemViewType(int i) {
        return ((FilterValue) this.f22891a.get(i)).f8692d ? 0 : 1;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEmpty() {
        return this.f22891a.isEmpty();
    }
}
