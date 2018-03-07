package com.facebook.bugreporter.activity.categorylist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.invariants.Invariants;
import com.facebook.common.util.TriState;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: android.media.metadata.ART_URI */
public class CategoryListAdapter extends BaseAdapter {
    private final Context f10699a;
    private final TriState f10700b;
    public ImmutableList<CategoryInfo> f10701c;

    public /* synthetic */ Object getItem(int i) {
        return m18727a(i);
    }

    @Inject
    public CategoryListAdapter(Context context, TriState triState) {
        this.f10699a = context;
        this.f10700b = triState;
    }

    public int getCount() {
        return this.f10701c.size();
    }

    public final CategoryInfo m18727a(int i) {
        if (i < this.f10701c.size()) {
            return (CategoryInfo) this.f10701c.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        if (i < this.f10701c.size()) {
            return ((CategoryInfo) this.f10701c.get(i)).f10695c;
        }
        return -1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = (CategoryListItemView) view;
        Invariants.m3751a(i <= this.f10701c.size(), "listview index is not valid");
        if (view == null) {
            view = new CategoryListItemView(this.f10699a, this.f10700b);
        }
        CategoryInfo a = m18727a(i);
        view.f10714c = a;
        view.f10712a.setText(a.m18726a(view.f10713b));
        return view;
    }
}
