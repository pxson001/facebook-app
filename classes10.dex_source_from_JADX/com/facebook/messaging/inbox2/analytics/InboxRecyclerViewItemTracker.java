package com.facebook.messaging.inbox2.analytics;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.facebook.common.objectpool.ObjectPool;
import com.facebook.common.objectpool.ObjectPool.BasicAllocator;
import com.facebook.common.objectpool.ObjectPoolBuilder;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.inbox2.analytics.InboxViewImpressionTracker.C04391;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: shareItem */
public class InboxRecyclerViewItemTracker {
    private static final ObjectPool<ItemInfo> f2621a;
    public final MonotonicClock f2622b;
    public final InboxUnitViewWithRecyclerView f2623c;
    private final C04391 f2624d;
    public final OnScrollListener f2625e = new C04382(this);
    public final Map<Long, ItemInfo> f2626f;
    private boolean f2627g;
    public boolean f2628h;
    public int f2629i;

    /* compiled from: shareItem */
    final class C04371 extends BasicAllocator<ItemInfo> {
        C04371(Class cls) {
            super(cls);
        }

        public final void m2599a(Object obj) {
            ItemInfo itemInfo = (ItemInfo) obj;
            itemInfo.f2654a = null;
            itemInfo.f2656c = false;
            itemInfo.f2655b = 0;
            itemInfo.f2658e = 0;
            itemInfo.f2657d = 0;
            itemInfo.f2659f = -1;
            itemInfo.f2660g = -1;
        }

        public final Object m2598a() {
            return new ItemInfo();
        }
    }

    /* compiled from: shareItem */
    class C04382 extends OnScrollListener {
        final /* synthetic */ InboxRecyclerViewItemTracker f2620a;

        C04382(InboxRecyclerViewItemTracker inboxRecyclerViewItemTracker) {
            this.f2620a = inboxRecyclerViewItemTracker;
        }

        public final void m2600a(RecyclerView recyclerView, int i) {
            InboxRecyclerViewItemTracker inboxRecyclerViewItemTracker = this.f2620a;
            inboxRecyclerViewItemTracker.f2629i = i;
            InboxRecyclerViewItemTracker.m2602f(inboxRecyclerViewItemTracker);
        }

        public final void m2601a(RecyclerView recyclerView, int i, int i2) {
            InboxRecyclerViewItemTracker.m2602f(this.f2620a);
        }
    }

    static {
        ObjectPoolBuilder objectPoolBuilder = new ObjectPoolBuilder(ItemInfo.class, AwakeTimeSinceBootClock.INSTANCE);
        objectPoolBuilder.f = new C04371(ItemInfo.class);
        f2621a = objectPoolBuilder.a();
    }

    @Inject
    public InboxRecyclerViewItemTracker(MonotonicClock monotonicClock, @Assisted InboxUnitViewWithRecyclerView inboxUnitViewWithRecyclerView, @Assisted C04391 c04391) {
        this.f2622b = monotonicClock;
        this.f2623c = inboxUnitViewWithRecyclerView;
        BetterRecyclerView recyclerView = inboxUnitViewWithRecyclerView.getRecyclerView();
        this.f2624d = c04391;
        recyclerView.a(this.f2625e);
        this.f2626f = new HashMap();
    }

    final void m2603a(boolean z) {
        if (!this.f2628h && this.f2627g != z) {
            this.f2627g = z;
            m2602f(this);
        }
    }

    public static void m2602f(InboxRecyclerViewItemTracker inboxRecyclerViewItemTracker) {
        if (inboxRecyclerViewItemTracker.f2629i != 2) {
            boolean z;
            BetterRecyclerView recyclerView = inboxRecyclerViewItemTracker.f2623c.getRecyclerView();
            InboxAdapter inboxAdapter = inboxRecyclerViewItemTracker.f2623c.getInboxAdapter();
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int l = linearLayoutManager.l();
            int n = linearLayoutManager.n();
            long now = inboxRecyclerViewItemTracker.f2622b.now();
            if (l < 0 || n >= inboxAdapter.b() || l > n || !inboxRecyclerViewItemTracker.f2627g) {
                z = false;
            } else {
                z = false;
                for (int i = l; i <= n; i++) {
                    InboxItem b = inboxAdapter.b(i);
                    long c = b.c();
                    ItemInfo itemInfo = (ItemInfo) inboxRecyclerViewItemTracker.f2626f.get(Long.valueOf(c));
                    if (itemInfo == null) {
                        itemInfo = (ItemInfo) f2621a.a();
                        inboxRecyclerViewItemTracker.f2626f.put(Long.valueOf(c), itemInfo);
                    }
                    itemInfo.f2654a = b;
                    itemInfo.f2659f = i;
                    if (!itemInfo.f2656c) {
                        itemInfo.f2656c = true;
                        itemInfo.f2657d = now;
                        z = true;
                    }
                    itemInfo.f2658e = now;
                    View c2 = linearLayoutManager.c(i);
                    itemInfo.f2660g = SizeUtil.b(c2.getResources(), (float) c2.getHeight());
                }
            }
            for (Entry value : inboxRecyclerViewItemTracker.f2626f.entrySet()) {
                ItemInfo itemInfo2 = (ItemInfo) value.getValue();
                if (itemInfo2.f2658e != now) {
                    if (itemInfo2.f2656c) {
                        itemInfo2.f2656c = false;
                        itemInfo2.f2655b += now - itemInfo2.f2657d;
                        z = true;
                    }
                    itemInfo2.f2658e = now;
                }
            }
            if (z) {
                InboxViewImpressionTracker.m2607a(inboxRecyclerViewItemTracker.f2624d.f2630a);
            }
        }
    }

    final Collection<ItemInfo> m2604c() {
        long now = this.f2622b.now();
        for (Entry value : this.f2626f.entrySet()) {
            ItemInfo itemInfo = (ItemInfo) value.getValue();
            if (itemInfo.f2656c) {
                itemInfo.f2655b += now - itemInfo.f2657d;
                itemInfo.f2657d = now;
            }
        }
        return this.f2626f.values();
    }

    final void m2605d() {
        Iterator it = this.f2626f.values().iterator();
        while (it.hasNext()) {
            ItemInfo itemInfo = (ItemInfo) it.next();
            if (itemInfo.f2656c) {
                itemInfo.f2655b = 0;
            } else {
                it.remove();
                f2621a.a(itemInfo);
            }
        }
    }
}
