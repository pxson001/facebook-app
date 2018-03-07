package com.facebook.bookmark.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment.ViewItemType;
import com.facebook.bookmark.ui.BaseViewItemFactory.CaspianDividerViewItem;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: receiver_ids */
public class BookmarkAdapter extends BaseAdapter {
    protected final List<ViewItem> f5727a = Lists.a();
    protected final int f5728b;

    /* compiled from: receiver_ids */
    public interface RowType {
        int ordinal();
    }

    /* compiled from: receiver_ids */
    public interface ViewItem {
        View mo224a(int i, View view, ViewGroup viewGroup);

        RowType mo225a();

        Bookmark mo226c();
    }

    /* compiled from: receiver_ids */
    public abstract class BaseViewItem<H, D> implements ViewItem {
        protected final RowType f5705b;
        protected final int f5706c;
        @Nullable
        public final D f5707d;
        protected final LayoutInflater f5708e;

        public abstract H mo227a(View view);

        public abstract void mo228a(H h);

        public BaseViewItem(RowType rowType, int i, @Nullable D d, LayoutInflater layoutInflater) {
            this.f5705b = rowType;
            this.f5706c = i;
            this.f5707d = d;
            this.f5708e = layoutInflater;
        }

        public final RowType mo225a() {
            return this.f5705b;
        }

        public final Bookmark mo226c() {
            if (this.f5707d == null || !(this.f5707d instanceof Bookmark)) {
                return null;
            }
            return (Bookmark) this.f5707d;
        }

        public View mo224a(int i, @Nullable View view, ViewGroup viewGroup) {
            Object a;
            if (view == null) {
                view = this.f5708e.inflate(this.f5706c, viewGroup, false);
                a = mo227a(view);
                view.setTag(a);
            } else {
                a = view.getTag();
            }
            mo228a(a);
            return view;
        }
    }

    public BookmarkAdapter(int i) {
        this.f5728b = i;
    }

    public final void m5958a(List<ViewItem> list) {
        this.f5727a.clear();
        this.f5727a.addAll((Collection) Preconditions.checkNotNull(list));
        AdapterDetour.a(this, 446139515);
    }

    public final ArrayList<Bookmark> m5957a() {
        ArrayList<Bookmark> arrayList = new ArrayList();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            ViewItem viewItem = (ViewItem) this.f5727a.get(i);
            if (viewItem.mo225a() == ViewItemType.Bookmark) {
                Bookmark c = viewItem.mo226c();
                if (c != null) {
                    arrayList.add(c);
                }
            }
        }
        return arrayList;
    }

    public int getViewTypeCount() {
        return this.f5728b;
    }

    public int getItemViewType(int i) {
        return ((ViewItem) this.f5727a.get(i)).mo225a().ordinal();
    }

    public int getCount() {
        return this.f5727a.size();
    }

    public Object getItem(int i) {
        return this.f5727a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        return ((ViewItem) this.f5727a.get(i)).mo224a(i, view, viewGroup);
    }

    public boolean isEnabled(int i) {
        ViewItem viewItem = (ViewItem) this.f5727a.get(i);
        if ((viewItem instanceof CaspianDividerViewItem) && ((CaspianDividerViewItem) viewItem).f5707d == null) {
            return false;
        }
        return true;
    }
}
