package com.facebook.messaging.tabbedpager;

import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Queue;
import javax.inject.Inject;

/* compiled from: isSucceeded */
public class TabbedPagerAdapter<T> extends PagerAdapter {
    private static final Class<?> f12159a = TabbedPagerAdapter.class;
    private final DefaultAppChoreographer f12160b;
    private ItemBasedTabbedPagerAdapter<T> f12161c;
    public ImmutableList<T> f12162d = RegularImmutableList.a;
    private Queue<ItemInfo<T>> f12163e = Lists.b();
    private SparseArrayCompat<List<View>> f12164f = new SparseArrayCompat();
    private Object f12165g;

    /* compiled from: isSucceeded */
    class C07901 implements Runnable {
        final /* synthetic */ TabbedPagerAdapter f12155a;

        C07901(TabbedPagerAdapter tabbedPagerAdapter) {
            this.f12155a = tabbedPagerAdapter;
        }

        public void run() {
            TabbedPagerAdapter.m19096f(this.f12155a);
        }
    }

    /* compiled from: isSucceeded */
    class ItemInfo<T> {
        final int f12156a;
        final ViewGroup f12157b;
        final T f12158c;

        public ItemInfo(int i, ViewGroup viewGroup, T t) {
            this.f12156a = i;
            this.f12157b = viewGroup;
            this.f12158c = t;
        }
    }

    public static TabbedPagerAdapter m19094b(InjectorLike injectorLike) {
        return new TabbedPagerAdapter(DefaultAppChoreographer.a(injectorLike));
    }

    public static TabbedPagerAdapter m19091a(InjectorLike injectorLike) {
        return m19094b(injectorLike);
    }

    @Inject
    TabbedPagerAdapter(DefaultAppChoreographer defaultAppChoreographer) {
        this.f12160b = defaultAppChoreographer;
    }

    public final void m19101a(ItemBasedTabbedPagerAdapter<T> itemBasedTabbedPagerAdapter) {
        this.f12161c = itemBasedTabbedPagerAdapter;
        kR_();
    }

    public final void m19102a(List<T> list) {
        Preconditions.checkNotNull(list);
        this.f12162d = ImmutableList.copyOf(list);
        kR_();
    }

    public final ImmutableList<T> m19106d() {
        return this.f12162d;
    }

    public final int m19098a(String str) {
        if (this.f12161c == null) {
            return -1;
        }
        for (int i = 0; i < this.f12162d.size(); i++) {
            if (Objects.equal(str, this.f12161c.mo1279a(this.f12162d.get(i)))) {
                return i;
            }
        }
        return -1;
    }

    public final int m19104b() {
        return this.f12162d.size();
    }

    public final void m19105b(ViewGroup viewGroup, int i, Object obj) {
        if (obj != null) {
            ItemInfo itemInfo = (ItemInfo) obj;
            this.f12165g = itemInfo.f12158c;
            if (this.f12163e.remove(itemInfo)) {
                Integer.valueOf(i);
                m19093a(this.f12162d.get(i), itemInfo.f12157b);
            }
        }
    }

    public final Object m19099a(ViewGroup viewGroup, int i) {
        View frameLayout = new FrameLayout(viewGroup.getContext());
        ItemInfo itemInfo = new ItemInfo(i, frameLayout, this.f12162d.get(i));
        this.f12163e.offer(itemInfo);
        viewGroup.addView(frameLayout);
        m19095e();
        return itemInfo;
    }

    public final void m19100a(ViewGroup viewGroup, int i, Object obj) {
        ItemInfo itemInfo = (ItemInfo) obj;
        viewGroup.removeView(itemInfo.f12157b);
        this.f12163e.remove(itemInfo);
        if (itemInfo.f12157b.getChildCount() > 0) {
            int b = this.f12161c.mo1281b(itemInfo.f12158c);
            if (b != -1) {
                List list = (List) this.f12164f.a(b);
                if (list == null) {
                    list = Lists.a(3);
                    this.f12164f.a(b, list);
                }
                View childAt = itemInfo.f12157b.getChildAt(0);
                itemInfo.f12157b.removeView(childAt);
                if (list.size() < 3) {
                    list.add(childAt);
                }
            }
        }
    }

    public final boolean m19103a(View view, Object obj) {
        return view == ((ItemInfo) obj).f12157b;
    }

    public final int m19097a(Object obj) {
        int indexOf = this.f12162d.indexOf(((ItemInfo) obj).f12158c);
        return indexOf >= 0 ? indexOf : -2;
    }

    private void m19095e() {
        if (!this.f12163e.isEmpty()) {
            this.f12160b.a("TabbedPagerAdapter", new C07901(this), Priority.APPLICATION_LOADED_HIGH_PRIORITY, ThreadType.UI);
        }
    }

    public static void m19096f(TabbedPagerAdapter tabbedPagerAdapter) {
        if (!tabbedPagerAdapter.f12163e.isEmpty()) {
            ItemInfo itemInfo = (ItemInfo) tabbedPagerAdapter.f12163e.poll();
            Integer.valueOf(itemInfo.f12156a);
            tabbedPagerAdapter.m19093a(tabbedPagerAdapter.f12162d.get(itemInfo.f12156a), itemInfo.f12157b);
            tabbedPagerAdapter.m19095e();
        }
    }

    private void m19093a(T t, ViewGroup viewGroup) {
        List list;
        View view = null;
        int b = this.f12161c.mo1281b(t);
        if (b != -1) {
            list = (List) this.f12164f.a(b);
            if (list != null && list.size() > 0) {
                view = (View) list.remove(list.size() - 1);
            }
        } else {
            list = null;
        }
        View a = this.f12161c.mo1278a(t, view, viewGroup, t == this.f12165g);
        if (!(view == null || a == view)) {
            list.add(view);
        }
        viewGroup.addView(a);
    }
}
