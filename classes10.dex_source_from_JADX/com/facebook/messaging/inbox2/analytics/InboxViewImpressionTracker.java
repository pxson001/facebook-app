package com.facebook.messaging.inbox2.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.inbox2.photoreminders.InboxUnitPhotoRemindersItem;
import com.facebook.messaging.photoreminders.PhotoRemindersLogger;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: setup_friends */
public class InboxViewImpressionTracker {
    private static final Class<?> f2633a = InboxViewImpressionTracker.class;
    public final InboxViewLogger f2634b;
    public final ListeningScheduledExecutorService f2635c;
    private final DefaultProcessIdleExecutor f2636d;
    private final InboxRecyclerViewItemTrackerProvider f2637e;
    private final AnalyticsLogger f2638f;
    private final PhotoRemindersLogger f2639g;
    private final InboxRecyclerViewItemTracker f2640h;
    private final C04391 f2641i = new C04391(this);
    private final Map<Long, InboxRecyclerViewItemTracker> f2642j;
    public final Map<InboxUnitViewWithRecyclerView, InboxRecyclerViewItemTracker> f2643k;
    public ListenableScheduledFuture<?> f2644l;
    public ListenableFuture<?> f2645m;
    private boolean f2646n;
    private boolean f2647o;
    private boolean f2648p;
    private boolean f2649q;
    private boolean f2650r;

    /* compiled from: setup_friends */
    public class C04391 {
        public final /* synthetic */ InboxViewImpressionTracker f2630a;

        C04391(InboxViewImpressionTracker inboxViewImpressionTracker) {
            this.f2630a = inboxViewImpressionTracker;
        }
    }

    /* compiled from: setup_friends */
    public class C04402 implements Runnable {
        final /* synthetic */ InboxViewImpressionTracker f2631a;

        public C04402(InboxViewImpressionTracker inboxViewImpressionTracker) {
            this.f2631a = inboxViewImpressionTracker;
        }

        public void run() {
            InboxViewImpressionTracker.m2612e(this.f2631a);
        }
    }

    /* compiled from: setup_friends */
    class C04413 implements Runnable {
        final /* synthetic */ InboxViewImpressionTracker f2632a;

        C04413(InboxViewImpressionTracker inboxViewImpressionTracker) {
            this.f2632a = inboxViewImpressionTracker;
        }

        public void run() {
            this.f2632a.f2645m = null;
            InboxViewImpressionTracker.m2613f(this.f2632a);
        }
    }

    @Inject
    InboxViewImpressionTracker(InboxViewLogger inboxViewLogger, ListeningScheduledExecutorService listeningScheduledExecutorService, DefaultProcessIdleExecutor defaultProcessIdleExecutor, InboxRecyclerViewItemTrackerProvider inboxRecyclerViewItemTrackerProvider, AnalyticsLogger analyticsLogger, PhotoRemindersLogger photoRemindersLogger, @Assisted InboxUnitViewWithRecyclerView inboxUnitViewWithRecyclerView) {
        this.f2634b = inboxViewLogger;
        this.f2635c = listeningScheduledExecutorService;
        this.f2636d = defaultProcessIdleExecutor;
        this.f2638f = analyticsLogger;
        this.f2639g = photoRemindersLogger;
        this.f2637e = inboxRecyclerViewItemTrackerProvider;
        this.f2640h = this.f2637e.m2606a(inboxUnitViewWithRecyclerView, this.f2641i);
        this.f2642j = new HashMap();
        this.f2643k = new HashMap();
    }

    public static void m2607a(InboxViewImpressionTracker inboxViewImpressionTracker) {
        if (!inboxViewImpressionTracker.f2646n) {
            m2612e(inboxViewImpressionTracker);
        } else if (inboxViewImpressionTracker.f2645m == null && inboxViewImpressionTracker.f2644l == null) {
            inboxViewImpressionTracker.f2644l = inboxViewImpressionTracker.f2635c.a(new C04402(inboxViewImpressionTracker), 5, TimeUnit.MINUTES);
        }
        inboxViewImpressionTracker.m2611c();
    }

    public final void m2615a(boolean z) {
        this.f2646n = z;
        m2609b();
    }

    public final void m2616b(boolean z) {
        this.f2647o = z;
        m2609b();
    }

    public final void m2614a(InboxItem inboxItem, InboxUnitViewWithRecyclerView inboxUnitViewWithRecyclerView) {
        InboxRecyclerViewItemTracker a = this.f2637e.m2606a(inboxUnitViewWithRecyclerView, this.f2641i);
        this.f2642j.put(Long.valueOf(inboxItem.c()), a);
        this.f2643k.put(inboxUnitViewWithRecyclerView, a);
        m2611c();
    }

    private void m2609b() {
        boolean z = this.f2648p;
        boolean z2 = this.f2646n && this.f2647o;
        this.f2648p = z2;
        if (this.f2648p != z) {
            this.f2640h.m2603a(this.f2648p);
        }
    }

    private void m2611c() {
        for (Entry entry : this.f2642j.entrySet()) {
            ItemInfo itemInfo = (ItemInfo) this.f2640h.f2626f.get(Long.valueOf(((Long) entry.getKey()).longValue()));
            InboxRecyclerViewItemTracker inboxRecyclerViewItemTracker = (InboxRecyclerViewItemTracker) entry.getValue();
            if (this.f2648p && itemInfo != null && itemInfo.f2656c) {
                inboxRecyclerViewItemTracker.m2603a(true);
            } else {
                inboxRecyclerViewItemTracker.m2603a(false);
            }
        }
    }

    public static void m2612e(InboxViewImpressionTracker inboxViewImpressionTracker) {
        if (inboxViewImpressionTracker.f2645m == null) {
            if (inboxViewImpressionTracker.f2644l != null) {
                inboxViewImpressionTracker.f2644l.cancel(false);
                inboxViewImpressionTracker.f2644l = null;
            }
            inboxViewImpressionTracker.f2636d.a(new C04413(inboxViewImpressionTracker));
        }
    }

    public static void m2613f(InboxViewImpressionTracker inboxViewImpressionTracker) {
        Collection<ItemInfo> arrayList = new ArrayList();
        arrayList.addAll(inboxViewImpressionTracker.f2640h.m2604c());
        for (InboxRecyclerViewItemTracker c : inboxViewImpressionTracker.f2642j.values()) {
            arrayList.addAll(c.m2604c());
        }
        if (BLog.b(2)) {
            for (ItemInfo itemInfo : arrayList) {
                InboxItem inboxItem = itemInfo.f2654a;
                if (inboxItem instanceof InboxUnitItem) {
                    InboxUnitItem inboxUnitItem = (InboxUnitItem) inboxItem;
                    inboxItem.a();
                    inboxUnitItem.me_();
                    Long.valueOf(itemInfo.f2655b / 1000);
                }
            }
        }
        inboxViewImpressionTracker.m2610b((List) arrayList);
        inboxViewImpressionTracker.f2634b.m2626a((Collection) arrayList);
        inboxViewImpressionTracker.f2640h.m2605d();
        for (InboxRecyclerViewItemTracker c2 : inboxViewImpressionTracker.f2642j.values()) {
            c2.m2605d();
        }
        m2608a(inboxViewImpressionTracker.f2642j.values());
        m2608a(inboxViewImpressionTracker.f2643k.values());
    }

    private static void m2608a(Collection<InboxRecyclerViewItemTracker> collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((InboxRecyclerViewItemTracker) it.next()).f2628h) {
                it.remove();
            }
        }
    }

    private void m2610b(List<ItemInfo> list) {
        for (ItemInfo itemInfo : list) {
            if (itemInfo.f2654a.a() == InboxItemType.V2_MESSAGE_REQUEST_HEADER) {
                if (!this.f2649q) {
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("core_graph_show_requests_banner");
                    honeyClientEvent.c = "messages";
                    this.f2638f.a(honeyClientEvent);
                    this.f2649q = true;
                }
            } else if (itemInfo.f2654a.a() == InboxItemType.V2_PHOTO_REMINDERS && !this.f2650r) {
                InboxUnitPhotoRemindersItem inboxUnitPhotoRemindersItem = (InboxUnitPhotoRemindersItem) itemInfo.f2654a;
                PhotoRemindersLogger photoRemindersLogger = this.f2639g;
                int i = inboxUnitPhotoRemindersItem.f2856f.f3566a;
                Integer.valueOf(i);
                photoRemindersLogger.b.a(PhotoRemindersLogger.a("inbox_banner_exposed").a("num_suggestions", i));
                this.f2650r = true;
            }
        }
    }
}
