package com.facebook.saved.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.views.SavedDashboardSectionItemView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: itemized_price_infos */
public class SavedSectionsListAdapter extends FbBaseAdapter {
    private final LayoutInflater f8951a;
    private ArrayList<SavedDashboardSection> f8952b = Lists.a();

    private static SavedSectionsListAdapter m8938b(InjectorLike injectorLike) {
        return new SavedSectionsListAdapter(LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public SavedSectionsListAdapter(LayoutInflater layoutInflater) {
        this.f8951a = layoutInflater;
    }

    public int getCount() {
        return this.f8952b.size();
    }

    public Object getItem(int i) {
        return this.f8952b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final View m8939a(int i, ViewGroup viewGroup) {
        return this.f8951a.inflate(2130906949, viewGroup, false);
    }

    public final void m8940a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((SavedDashboardSectionItemView) view).m9518a((SavedDashboardSection) obj);
    }
}
