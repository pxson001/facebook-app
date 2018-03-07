package com.facebook.events.permalink.tabbar;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ViewStub;
import com.facebook.events.permalink.adapters.EventPermalinkRecyclerViewAdapter.EventPermalinkTabBarViewHolder;
import com.facebook.events.permalink.tabbar.EventPermalinkTabBar.OnTabChangeListener;
import com.facebook.widget.titlebar.FadingFbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: background_location_location_disabled_miniphone_selected */
public class StickyTabBarController extends OnScrollListener implements OnTabChangeListener {
    public EventPermalinkTabBar f18947a;
    public EventPermalinkTabBarViewHolder f18948b;
    public OnTabChangeListener f18949c;
    @IdRes
    private int f18950d = 2131561368;
    private boolean f18951e;
    private Context f18952f;
    private FbTitleBarSupplier f18953g;
    private ViewStub f18954h;
    private Runnable f18955i;
    private int f18956j;

    /* compiled from: background_location_location_disabled_miniphone_selected */
    class C26881 implements Runnable {
        final /* synthetic */ StickyTabBarController f18946a;

        C26881(StickyTabBarController stickyTabBarController) {
            this.f18946a = stickyTabBarController;
        }

        public void run() {
            if (this.f18946a.f18948b.a.getTop() > StickyTabBarController.m19188h(this.f18946a)) {
                this.f18946a.f18947a.setVisibility(4);
            }
        }
    }

    public StickyTabBarController(Context context, FbTitleBarSupplier fbTitleBarSupplier, ViewStub viewStub, Boolean bool, int i) {
        this.f18952f = context;
        this.f18953g = fbTitleBarSupplier;
        this.f18954h = viewStub;
        this.f18951e = bool.booleanValue();
        this.f18956j = i;
    }

    public final void m19191a(EventPermalinkTabBarViewHolder eventPermalinkTabBarViewHolder) {
        this.f18948b = eventPermalinkTabBarViewHolder;
        this.f18948b.a(false);
        EventPermalinkTabBar f = m19186f();
        f.setSelected(this.f18950d);
        f.f18944b = this;
    }

    @VisibleForTesting
    private EventPermalinkTabBar m19186f() {
        return this.f18948b == null ? null : (EventPermalinkTabBar) this.f18948b.a;
    }

    public final void mo837a(int i, boolean z) {
        this.f18950d = i;
        EventPermalinkTabBar f = m19186f();
        if (f != null) {
            f.setSelected(i);
        }
        if (this.f18947a != null) {
            this.f18947a.setSelected(i);
        }
        if (this.f18949c != null) {
            this.f18949c.mo837a(i, z);
        }
        if (this.f18955i == null) {
            this.f18955i = new C26881(this);
        }
        if (this.f18947a != null) {
            this.f18947a.post(this.f18955i);
        }
    }

    public final boolean m19192a() {
        return this.f18950d == 2131561368;
    }

    public final int m19193b() {
        if (this.f18951e) {
            return 0;
        }
        return ((FbTitleBar) this.f18953g.get()) instanceof FadingFbTitleBar ? this.f18952f.getResources().getDimensionPixelSize(2131428128) + this.f18956j : 0;
    }

    public final boolean m19194c() {
        return this.f18947a != null && this.f18947a.getVisibility() == 0;
    }

    @VisibleForTesting
    private EventPermalinkTabBar m19187g() {
        if (this.f18947a != null) {
            return this.f18947a;
        }
        this.f18947a = (EventPermalinkTabBar) this.f18954h.inflate();
        this.f18947a.setVisibility(4);
        this.f18947a.setTranslationY((float) m19193b());
        this.f18947a.setSelected(this.f18950d);
        this.f18947a.f18944b = this;
        return this.f18947a;
    }

    public static int m19188h(StickyTabBarController stickyTabBarController) {
        return stickyTabBarController.m19187g().getTop() + stickyTabBarController.m19193b();
    }

    public final void m19190a(RecyclerView recyclerView, int i, int i2) {
        EventPermalinkTabBar f = m19186f();
        if (f == null) {
            return;
        }
        if (i2 <= 0 || m19194c()) {
            if (i2 < 0 && m19194c() && f.getTop() > m19193b() && this.f18947a != null) {
                this.f18947a.setVisibility(4);
            }
        } else if (f.getTop() <= m19193b()) {
            m19187g().setVisibility(0);
        }
    }
}
