package com.facebook.messaging.tabbedpager;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.tabbedpager.TabbedPager.C07893;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: is_auto_tag */
public class TabListAdapter extends Adapter {
    public final Map<Object, Integer> f12119a = new HashMap();
    public C07893 f12120b;
    public ItemBasedTabbedPagerAdapter f12121c;
    public ImmutableList f12122d = RegularImmutableList.a;
    public String f12123e;

    public final void m19059a(ItemBasedTabbedPagerAdapter itemBasedTabbedPagerAdapter) {
        this.f12121c = itemBasedTabbedPagerAdapter;
        notifyDataSetChanged();
        m19055d();
    }

    public final void m19060a(List list) {
        this.f12122d = ImmutableList.copyOf(list);
        notifyDataSetChanged();
        m19055d();
    }

    public final void m19057a(int i, Object obj) {
        Collection arrayList = new ArrayList();
        arrayList.addAll(this.f12122d);
        arrayList.add(i, obj);
        this.f12122d = ImmutableList.copyOf(arrayList);
        k_(i);
        m19055d();
    }

    public final void m19061e(int i) {
        Collection arrayList = new ArrayList();
        arrayList.addAll(this.f12122d);
        arrayList.remove(i);
        this.f12122d = ImmutableList.copyOf(arrayList);
        l_(i);
        m19055d();
    }

    private void m19055d() {
        int i = 0;
        this.f12119a.clear();
        int size = this.f12122d.size();
        int i2 = 0;
        while (i < size) {
            this.f12119a.put(this.f12122d.get(i), Integer.valueOf(i2));
            i2++;
            i++;
        }
    }

    public final long H_(int i) {
        if (this.f12121c == null) {
            return -1;
        }
        return (long) this.f12121c.mo1279a(this.f12122d.get(i)).hashCode();
    }

    public final int aZ_() {
        return this.f12122d.size();
    }

    public final ViewHolder m19056a(ViewGroup viewGroup, int i) {
        ViewHolder a = this.f12121c.mo1277a(viewGroup, i);
        int a2 = this.f12121c.mo1276a();
        if (a2 == -1) {
            a2 = viewGroup.getWidth() / this.f12122d.size();
        }
        a.a.setMinimumWidth(a2);
        a.a.setMinimumHeight(viewGroup.getHeight());
        return a;
    }

    public final void m19058a(final ViewHolder viewHolder, int i) {
        final Object obj = this.f12122d.get(i);
        this.f12121c.mo1280a(viewHolder, this.f12122d.get(i));
        viewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TabListAdapter f12118c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1148971608);
                this.f12118c.f12120b.m19069a(((Integer) this.f12118c.f12119a.get(obj)).intValue());
                viewHolder.a.setSelected(true);
                Logger.a(2, EntryType.UI_INPUT_END, -1224099098, a);
            }
        });
        viewHolder.a.setSelected(Objects.equal(this.f12123e, this.f12121c.mo1279a(this.f12122d.get(i))));
    }

    public int getItemViewType(int i) {
        if (this.f12121c != null) {
            return this.f12121c.mo1282c(this.f12122d.get(i));
        }
        return 0;
    }
}
