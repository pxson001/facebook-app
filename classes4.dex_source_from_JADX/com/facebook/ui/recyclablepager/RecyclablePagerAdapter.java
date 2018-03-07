package com.facebook.ui.recyclablepager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.recyclableviewpool.IRecyclableViewFactory;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.FbCustomViewGroup;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: nux_ref */
public abstract class RecyclablePagerAdapter<Item> extends PagerAdapter {
    private Map<Object, Class> f6441a = Maps.c();
    private Map<Object, Integer> f6442b = Maps.c();
    private RecyclableViewPoolManager f6443c;
    private ViewTransactionList f6444d = new ViewTransactionList(this);
    private boolean f6445e;

    /* compiled from: nux_ref */
    public class ViewTransactionList {
        public final /* synthetic */ RecyclablePagerAdapter f6465a;
        public List<QueuedViewAction> f6466b = Lists.a();

        public ViewTransactionList(RecyclablePagerAdapter recyclablePagerAdapter) {
            this.f6465a = recyclablePagerAdapter;
        }

        public final void m6902a() {
            this.f6466b.clear();
        }

        public final Iterable<QueuedViewAction> m6903b() {
            return Iterables.a(this.f6466b);
        }
    }

    protected abstract PagerViewType mo581a(int i);

    protected abstract void mo582a(View view, Item item, int i);

    protected abstract Item mo583b(int i);

    protected RecyclablePagerAdapter(RecyclableViewPoolManager recyclableViewPoolManager) {
        this.f6443c = recyclableViewPoolManager;
    }

    public void mo584b(View view, Item item) {
    }

    public boolean m6886a(View view, Object obj) {
        return view.getTag(2131558745) == obj;
    }

    public final Object m6883a(ViewGroup viewGroup, int i) {
        Object b = mo583b(i);
        ViewTransactionList viewTransactionList = this.f6444d;
        viewTransactionList.f6466b.add(new QueuedViewAction(viewTransactionList.f6465a, Action.ADD, b, i));
        return b;
    }

    public final void m6885a(ViewGroup viewGroup, int i, Object obj) {
        ViewTransactionList viewTransactionList = this.f6444d;
        viewTransactionList.f6466b.add(new QueuedViewAction(viewTransactionList.f6465a, Action.REMOVE, obj, i));
    }

    public final void m6890b(ViewGroup viewGroup) {
        CustomViewPager customViewPager = (CustomViewPager) viewGroup;
        for (QueuedViewAction queuedViewAction : this.f6444d.m6903b()) {
            switch (1.a[queuedViewAction.a.ordinal()]) {
                case 1:
                    PagerViewType a = mo581a(queuedViewAction.c);
                    TracerDetour.a("RecyclablePagerAdapter.add %s", a.mo1000a(), 1719643368);
                    LoomLogger.a(LoomLoggerDetour.a(-825547171), "RecyclablePagerAdapter.add", a.mo1000a().toString());
                    try {
                        View b = m6887b(viewGroup, queuedViewAction.c);
                        b.setTag(2131558745, queuedViewAction.b);
                        m6879a(queuedViewAction, queuedViewAction.c, (Integer) this.f6442b.put(queuedViewAction.b, Integer.valueOf(queuedViewAction.c)), (Class) this.f6441a.put(queuedViewAction.b, mo581a(queuedViewAction.c).mo1000a()));
                        mo582a(b, queuedViewAction.b, queuedViewAction.c);
                        int i = "RecyclablePagerAdapter.ViewPager.addView";
                        TracerDetour.a(i, -127144752);
                        try {
                            customViewPager.addView(b);
                            TracerDetour.a(i);
                            break;
                        } finally {
                            i = -817972654;
                            TracerDetour.a(-817972654);
                        }
                    } finally {
                        TracerDetour.a(1731452970);
                    }
                case 2:
                    View a2 = m6878a(customViewPager, queuedViewAction.b);
                    if (a2 != null) {
                        mo584b(a2, queuedViewAction.b);
                        m6880a(customViewPager, a2, queuedViewAction.b);
                    }
                    this.f6442b.remove(queuedViewAction.b);
                    this.f6441a.remove(queuedViewAction.b);
                    break;
                default:
                    break;
            }
        }
        this.f6444d.m6902a();
        this.f6445e = false;
    }

    private static void m6879a(QueuedViewAction queuedViewAction, int i, @Nullable Integer num, @Nullable Class cls) {
        if (num != null && num.intValue() != i && cls != null) {
            throw new IllegalStateException(StringFormatUtil.a("Object is being added to pager twice: %s", new Object[]{queuedViewAction.b}));
        }
    }

    public final void kR_() {
        this.f6445e = true;
        super.kR_();
    }

    @Nullable
    private View m6878a(CustomViewPager customViewPager, Item item) {
        int childCount = customViewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = customViewPager.getChildAt(i);
            if (a(childAt, item)) {
                return childAt;
            }
        }
        return null;
    }

    public final View m6887b(ViewGroup viewGroup, int i) {
        IRecyclableViewFactory a = mo581a(i);
        View a2 = this.f6443c.m6897a(a.mo1000a());
        if (a2 == null) {
            return a.mo999a(viewGroup.getContext());
        }
        return a2;
    }

    private void m6880a(CustomViewPager customViewPager, View view, Item item) {
        Class cls = (Class) this.f6441a.get(item);
        if (cls != null) {
            this.f6443c.m6899a(cls, view, (FbCustomViewGroup) customViewPager);
        }
    }

    public final int m6881a(Object obj) {
        return (this.f6445e || !this.f6441a.containsKey(obj)) ? -2 : -1;
    }
}
