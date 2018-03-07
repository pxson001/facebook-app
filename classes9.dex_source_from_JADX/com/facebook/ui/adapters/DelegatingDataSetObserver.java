package com.facebook.ui.adapters;

import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;

/* compiled from: topics_predicted */
class DelegatingDataSetObserver extends DataSetObserver {
    private final BaseAdapter f1469a;

    public DelegatingDataSetObserver(BaseAdapter baseAdapter) {
        this.f1469a = baseAdapter;
    }

    public void onChanged() {
        AdapterDetour.a(this.f1469a, 1595843820);
    }

    public void onInvalidated() {
        AdapterDetour.b(this.f1469a, 1666528307);
    }
}
