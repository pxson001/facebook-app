package com.facebook.common.banner;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.ui.util.ViewReplacementUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationController.4;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MinMaxPriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_review_suggestions */
public class BannerNotificationController {
    private static final Class<?> f7690a = BannerNotificationController.class;
    private final BannerNotificationAnalyticsHelper f7691b;
    public final MinMaxPriorityQueue<BannerNotification> f7692c = MinMaxPriorityQueue.a(new C04561(this)).a();
    private ImmutableSet<BannerNotification> f7693d;
    public BannerNotificationPrioritizer f7694e;
    public ParentType f7695f = ParentType.UNKNOWN;
    @Nullable
    public 4 f7696g;
    @Nullable
    public ViewGroup f7697h;
    @Nullable
    public View f7698i;

    /* compiled from: place_review_suggestions */
    class C04561 implements Comparator<BannerNotification> {
        final /* synthetic */ BannerNotificationController f7689a;

        C04561(BannerNotificationController bannerNotificationController) {
            this.f7689a = bannerNotificationController;
        }

        public int compare(Object obj, Object obj2) {
            return this.f7689a.f7694e.m11020a(((BannerNotification) obj).getClass()) - this.f7689a.f7694e.m11020a(((BannerNotification) obj2).getClass());
        }
    }

    /* compiled from: place_review_suggestions */
    public enum ParentType {
        THREADLIST,
        THREADLIST_CHAT_HEADS,
        THREADVIEW,
        THREADVIEW_CHAT_HEADS,
        UNKNOWN
    }

    public static BannerNotificationController m11010b(InjectorLike injectorLike) {
        return new BannerNotificationController(BannerNotificationAnalyticsHelper.m11006b(injectorLike));
    }

    public static BannerNotificationController m11009a(InjectorLike injectorLike) {
        return m11010b(injectorLike);
    }

    @Inject
    public BannerNotificationController(BannerNotificationAnalyticsHelper bannerNotificationAnalyticsHelper) {
        this.f7691b = bannerNotificationAnalyticsHelper;
    }

    public final void m11017a(Set<BannerNotification> set, BannerNotificationPrioritizer bannerNotificationPrioritizer) {
        this.f7694e = bannerNotificationPrioritizer;
        this.f7693d = ImmutableSet.copyOf(set);
        Iterator it = this.f7693d.iterator();
        while (it.hasNext()) {
            ((BannerNotification) it.next()).mo918a(this);
        }
    }

    public final void m11016a(4 4) {
        this.f7696g = 4;
    }

    public final void m11014a() {
        Iterator it = this.f7693d.iterator();
        while (it.hasNext()) {
            ((BannerNotification) it.next()).mo919b();
        }
    }

    public final void m11018b() {
        Iterator it = this.f7693d.iterator();
        while (it.hasNext()) {
            ((BannerNotification) it.next()).mo920c();
        }
    }

    public final void m11015a(BannerNotification bannerNotification) {
        Preconditions.checkState(this.f7693d.contains(bannerNotification), "%s must be registered before being shown.", new Object[]{bannerNotification.getClass().getName()});
        if (this.f7692c.b() != null && m11013e(bannerNotification) < m11013e((BannerNotification) this.f7692c.b())) {
            m11011c(bannerNotification);
        } else if (this.f7697h != null) {
            m11011c(bannerNotification);
            m11012d(bannerNotification);
        }
    }

    private void m11011c(BannerNotification bannerNotification) {
        if (!this.f7692c.contains(bannerNotification)) {
            this.f7692c.add(bannerNotification);
        }
    }

    public final void m11019b(BannerNotification bannerNotification) {
        if (this.f7692c.b() == bannerNotification) {
            this.f7692c.remove(bannerNotification);
            if (this.f7692c.isEmpty()) {
                this.f7698i.setVisibility(8);
                return;
            } else {
                m11012d((BannerNotification) this.f7692c.b());
                return;
            }
        }
        this.f7692c.remove(bannerNotification);
    }

    private void m11012d(BannerNotification bannerNotification) {
        View a = bannerNotification.mo1084a(this.f7697h);
        if (this.f7697h != null) {
            if (this.f7697h.findViewById(2131558607) != null) {
                ViewReplacementUtil.b(this.f7697h, 2131558607, a);
            } else {
                ViewReplacementUtil.b(this.f7697h, this.f7698i, a);
            }
            this.f7698i = a;
            if (this.f7696g != null) {
                this.f7696g.a();
            }
        }
        this.f7691b.m11007a("view", "view", bannerNotification.mo921d());
    }

    private int m11013e(BannerNotification bannerNotification) {
        return this.f7694e.m11020a(bannerNotification.getClass());
    }
}
