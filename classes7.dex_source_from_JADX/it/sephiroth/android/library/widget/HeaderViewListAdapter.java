package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import it.sephiroth.android.library.widget.HListView.FixedViewInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: view_settings */
public class HeaderViewListAdapter implements Filterable, WrapperListAdapter {
    static final ArrayList<FixedViewInfo> f512c = new ArrayList();
    ArrayList<FixedViewInfo> f513a;
    ArrayList<FixedViewInfo> f514b;
    boolean f515d;
    private final ListAdapter f516e;
    private final boolean f517f;

    public HeaderViewListAdapter(ArrayList<FixedViewInfo> arrayList, ArrayList<FixedViewInfo> arrayList2, ListAdapter listAdapter) {
        this.f516e = listAdapter;
        this.f517f = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f513a = f512c;
        } else {
            this.f513a = arrayList;
        }
        if (arrayList2 == null) {
            this.f514b = f512c;
        } else {
            this.f514b = arrayList2;
        }
        boolean z = m536a(this.f513a) && m536a(this.f514b);
        this.f515d = z;
    }

    private int m535a() {
        return this.f513a.size();
    }

    private int m537b() {
        return this.f514b.size();
    }

    public boolean isEmpty() {
        return this.f516e == null || this.f516e.isEmpty();
    }

    private static boolean m536a(ArrayList<FixedViewInfo> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((FixedViewInfo) it.next()).f508c) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getCount() {
        if (this.f516e != null) {
            return (m537b() + m535a()) + this.f516e.getCount();
        }
        return m537b() + m535a();
    }

    public boolean areAllItemsEnabled() {
        if (this.f516e == null) {
            return true;
        }
        if (this.f515d && this.f516e.areAllItemsEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isEnabled(int i) {
        int a = m535a();
        if (i < a) {
            return ((FixedViewInfo) this.f513a.get(i)).f508c;
        }
        int i2 = i - a;
        a = 0;
        if (this.f516e != null) {
            a = this.f516e.getCount();
            if (i2 < a) {
                return this.f516e.isEnabled(i2);
            }
        }
        return ((FixedViewInfo) this.f514b.get(i2 - a)).f508c;
    }

    public Object getItem(int i) {
        int a = m535a();
        if (i < a) {
            return ((FixedViewInfo) this.f513a.get(i)).f507b;
        }
        int i2 = i - a;
        a = 0;
        if (this.f516e != null) {
            a = this.f516e.getCount();
            if (i2 < a) {
                return this.f516e.getItem(i2);
            }
        }
        return ((FixedViewInfo) this.f514b.get(i2 - a)).f507b;
    }

    public long getItemId(int i) {
        int a = m535a();
        if (this.f516e != null && i >= a) {
            a = i - a;
            if (a < this.f516e.getCount()) {
                return this.f516e.getItemId(a);
            }
        }
        return -1;
    }

    public boolean hasStableIds() {
        if (this.f516e != null) {
            return this.f516e.hasStableIds();
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int a = m535a();
        if (i < a) {
            return ((FixedViewInfo) this.f513a.get(i)).f506a;
        }
        int i2 = i - a;
        a = 0;
        if (this.f516e != null) {
            a = this.f516e.getCount();
            if (i2 < a) {
                return this.f516e.getView(i2, view, viewGroup);
            }
        }
        return ((FixedViewInfo) this.f514b.get(i2 - a)).f506a;
    }

    public int getItemViewType(int i) {
        int a = m535a();
        if (this.f516e != null && i >= a) {
            a = i - a;
            if (a < this.f516e.getCount()) {
                return this.f516e.getItemViewType(a);
            }
        }
        return -2;
    }

    public int getViewTypeCount() {
        if (this.f516e != null) {
            return this.f516e.getViewTypeCount();
        }
        return 1;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f516e != null) {
            this.f516e.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f516e != null) {
            this.f516e.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public Filter getFilter() {
        if (this.f517f) {
            return ((Filterable) this.f516e).getFilter();
        }
        return null;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f516e;
    }
}
