package com.facebook.pages.fb4a.admin_activity.views;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLInterfaces.FetchPageActivityQuery.ActivityAdminInfo;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: quicksilver_load_time */
public class PageActivityInsightsUniController {
    private static final LayoutParams f2784a = new LayoutParams(-1, -2);
    private boolean f2785b;
    private boolean f2786c;
    private boolean f2787d;
    public LinearLayout f2788e;
    public InsightsUniCard f2789f;
    private boolean f2790g;
    public Activity f2791h;

    /* compiled from: quicksilver_load_time */
    public interface InsightsUniCard {
        void mo74a(long j, ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional);
    }

    public static PageActivityInsightsUniController m3772a(InjectorLike injectorLike) {
        return new PageActivityInsightsUniController();
    }

    public final void m3778a(long j, @Nullable ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional) {
        boolean z = true;
        if (activityAdminInfo != null) {
            boolean z2 = this.f2785b;
            boolean z3 = this.f2786c;
            boolean z4 = activityAdminInfo.m2746c() != null && activityAdminInfo.m2746c().m2718c();
            this.f2785b = z4;
            if (activityAdminInfo.m2748g() == null) {
                z = false;
            }
            this.f2786c = z;
            this.f2787d = activityAdminInfo.mT_();
            m3773a(z2, z3);
            m3774b(j, activityAdminInfo, optional);
        } else if (this.f2789f != null) {
            if (this.f2790g) {
                m3776d();
            }
            this.f2789f = null;
        }
    }

    public final void m3777a() {
        if (this.f2789f != null && !this.f2790g) {
            m3775c();
        }
    }

    public final void m3779b() {
        if ((this.f2789f instanceof PageActivityInsightsWithUniButtonCardView) && this.f2790g) {
            m3776d();
            return;
        }
        this.f2789f = null;
        this.f2790g = false;
    }

    private void m3774b(long j, @Nullable ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional) {
        if (this.f2789f == null || this.f2790g) {
            if (this.f2789f != null && this.f2790g) {
                if (this.f2785b && (this.f2789f instanceof PageActivityUniRunningStatusCardView)) {
                    this.f2789f.mo74a(j, activityAdminInfo, optional);
                    return;
                } else if (this.f2786c && (this.f2789f instanceof PageActivityInsightsWithUniButtonCardView)) {
                    ((PageActivityInsightsWithUniButtonCardView) this.f2789f).m3802b(j, activityAdminInfo, optional);
                    return;
                } else if (this.f2787d && (this.f2789f instanceof PageActivityUniUpsellCardView)) {
                    this.f2789f.mo74a(j, activityAdminInfo, optional);
                    return;
                } else {
                    m3776d();
                    this.f2789f = null;
                }
            }
            if (this.f2785b) {
                this.f2789f = (PageActivityUniRunningStatusCardView) LayoutInflater.from(this.f2791h).inflate(2130905956, this.f2788e, false);
            } else if (this.f2786c) {
                this.f2789f = (PageActivityInsightsWithUniButtonCardView) LayoutInflater.from(this.f2791h).inflate(2130905954, this.f2788e, false);
            } else if (this.f2787d) {
                this.f2789f = (PageActivityUniUpsellCardView) LayoutInflater.from(this.f2791h).inflate(2130905959, this.f2788e, false);
            }
            if (this.f2789f != null) {
                m3775c();
                this.f2789f.mo74a(j, activityAdminInfo, optional);
                return;
            }
            return;
        }
        ((PageActivityInsightsWithUniButtonCardView) this.f2789f).m3802b(j, activityAdminInfo, optional);
    }

    private void m3775c() {
        this.f2788e.addView((View) this.f2789f, this.f2788e.getChildCount() - 1, f2784a);
        this.f2790g = true;
    }

    private void m3776d() {
        this.f2788e.removeView((View) this.f2789f);
        this.f2790g = false;
    }

    private void m3773a(boolean z, boolean z2) {
        if (this.f2789f != null) {
            if (z != this.f2785b || (!this.f2785b && z2 != this.f2786c)) {
                m3776d();
                this.f2789f = null;
            }
        }
    }
}
