package com.facebook.widget.listview;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SectionIndexer;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.filter.CustomFilterable;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

/* compiled from: redspace_user_demote */
public abstract class SectionedListAdapter extends BaseAdapter implements Filterable, SectionIndexer, CustomFilterable {
    public List<SectionCache> f6069a;
    public boolean f6070b;
    private List<DataSetObserver> f6071c;

    /* compiled from: redspace_user_demote */
    public class SectionCache {
        public static Comparator<SectionCache> f6065a = new C03581();
        final int f6066b;
        public int f6067c;
        public int f6068d;

        /* compiled from: redspace_user_demote */
        final class C03581 implements Comparator<SectionCache> {
            C03581() {
            }

            public final int compare(Object obj, Object obj2) {
                SectionCache sectionCache = (SectionCache) obj;
                SectionCache sectionCache2 = (SectionCache) obj2;
                if (sectionCache.f6067c + sectionCache.f6068d < sectionCache2.f6067c) {
                    return -1;
                }
                if (sectionCache.f6067c > sectionCache2.f6067c + sectionCache2.f6068d) {
                    return 1;
                }
                return 0;
            }
        }

        public SectionCache(int i) {
            this.f6066b = i;
        }
    }

    protected abstract int mo1056a(int i);

    protected abstract View mo1057a(int i, int i2, boolean z, View view, ViewGroup viewGroup);

    protected abstract View mo1058a(int i, View view, ViewGroup viewGroup);

    protected abstract Object mo1059a(int i, int i2);

    protected abstract Object mo1060b(int i);

    protected abstract boolean mo1062b(int i, int i2);

    public abstract int mo1063c();

    public abstract int mo1064c(int i);

    protected abstract int mo1065c(int i, int i2);

    public void notifyDataSetChanged() {
        this.f6070b = false;
        super.notifyDataSetChanged();
        if (this.f6071c != null) {
            for (DataSetObserver onChanged : this.f6071c) {
                onChanged.onChanged();
            }
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f6071c == null) {
            this.f6071c = new CopyOnWriteArrayList();
        }
        this.f6071c.add(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f6071c != null) {
            this.f6071c.remove(dataSetObserver);
        }
    }

    public final boolean isEmpty() {
        if (mo1061b() || getCount() == 0) {
            return true;
        }
        return false;
    }

    public final int getCount() {
        if (mo1061b()) {
            return 0;
        }
        m8638d();
        if (this.f6069a.isEmpty()) {
            return 0;
        }
        SectionCache sectionCache = (SectionCache) this.f6069a.get(this.f6069a.size() - 1);
        return (sectionCache.f6068d + sectionCache.f6067c) + 1;
    }

    public final Object getItem(int i) {
        int[] d = m8650d(i);
        if (d[1] == -1) {
            return null;
        }
        return mo1059a(d[0], d[1]);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        int[] d = m8650d(i);
        if (d[1] == -1) {
            return false;
        }
        return mo1062b(d[0], d[1]);
    }

    public final View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        int[] d = m8650d(i);
        if (d[1] == -1) {
            return mo1058a(d[0], view, viewGroup);
        }
        boolean z;
        if (((SectionCache) this.f6069a.get(d[0])).f6068d - 1 == d[1]) {
            z = true;
        } else {
            z = false;
        }
        return mo1057a(d[0], d[1], z, view, viewGroup);
    }

    public final int getItemViewType(int i) {
        int[] d = m8650d(i);
        if (d[1] == -1) {
            return mo1056a(d[0]);
        }
        return mo1065c(d[0], d[1]);
    }

    protected boolean mo1061b() {
        return false;
    }

    public final int[] m8650d(int i) {
        m8638d();
        int[] iArr = new int[2];
        List list = this.f6069a;
        SectionCache sectionCache = new SectionCache(0);
        sectionCache.f6067c = i;
        iArr[0] = Collections.binarySearch(list, sectionCache, SectionCache.f6065a);
        iArr[1] = (i - ((SectionCache) this.f6069a.get(iArr[0])).f6067c) - 1;
        return iArr;
    }

    public final int p_(int i) {
        m8638d();
        return ((SectionCache) this.f6069a.get(i)).f6067c;
    }

    private void m8638d() {
        if (!this.f6070b) {
            int size;
            boolean z;
            int i = 0;
            Preconditions.checkState(!this.f6070b);
            if (this.f6069a == null) {
                this.f6069a = Lists.a();
            }
            int c = mo1063c();
            for (size = this.f6069a.size(); size < c; size++) {
                this.f6069a.add(new SectionCache(size));
            }
            Preconditions.checkState(this.f6069a.size() >= mo1063c());
            c = mo1063c();
            for (size = this.f6069a.size(); size > c; size--) {
                this.f6069a.remove(size - 1);
            }
            if (mo1063c() == this.f6069a.size()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            for (c = 0; c < mo1063c(); c++) {
                int c2 = mo1064c(c);
                SectionCache sectionCache = (SectionCache) this.f6069a.get(c);
                sectionCache.f6067c = i;
                sectionCache.f6068d = c2;
                i += c2 + 1;
            }
            this.f6070b = true;
        }
    }

    public CustomFilter mo438a() {
        return null;
    }

    public Filter getFilter() {
        return null;
    }

    public int getPositionForSection(int i) {
        if (i < 0) {
            i = 0;
        } else if (i >= mo1063c()) {
            i = mo1063c() - 1;
        }
        return p_(i);
    }

    public int getSectionForPosition(int i) {
        if (i < 0) {
            return 0;
        }
        if (i >= getCount()) {
            return mo1063c() - 1;
        }
        return m8650d(i)[1];
    }

    public Object[] getSections() {
        int c = mo1063c();
        Object[] objArr = new Object[c];
        for (int i = 0; i < c; i++) {
            objArr[i] = mo1060b(i);
        }
        return objArr;
    }
}
