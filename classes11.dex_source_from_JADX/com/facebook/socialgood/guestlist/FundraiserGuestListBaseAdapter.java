package com.facebook.socialgood.guestlist;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PAUSE */
public abstract class FundraiserGuestListBaseAdapter extends BaseAdapter implements ListAdapter {
    protected List<FundraiserGuestListUser> f12617a = new ArrayList();

    /* compiled from: PAUSE */
    public enum ViewTypes {
        CHILD
    }

    public int getCount() {
        return this.f12617a.size();
    }

    public Object getItem(int i) {
        return this.f12617a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ViewTypes.CHILD.ordinal();
    }

    public final void m13033a(ImmutableList<FundraiserGuestListUser> immutableList) {
        this.f12617a.addAll(immutableList);
        AdapterDetour.a(this, -330180918);
    }
}
