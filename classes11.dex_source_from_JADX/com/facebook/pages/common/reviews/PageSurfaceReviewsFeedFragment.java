package com.facebook.pages.common.reviews;

import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.reviews.ui.PageReviewsFeedFragment;
import com.google.common.base.Preconditions;

/* compiled from: roundtrip_time */
public class PageSurfaceReviewsFeedFragment extends PageReviewsFeedFragment implements PagesSurfaceTabFragment {
    public static final int[] ar = new int[2];
    private ReactionHeaderViewWithTouchDelegate al;
    public View am;
    public PagesSurfaceFragment an;
    public int ao;
    private int ap;
    private int aq = -1;
    public boolean as = false;
    public int at = -1;
    private ReactionHeaderTouchDelegateView f2322i;

    /* compiled from: roundtrip_time */
    class C02871 implements OnScrollListener {
        final /* synthetic */ PageSurfaceReviewsFeedFragment f2321a;

        C02871(PageSurfaceReviewsFeedFragment pageSurfaceReviewsFeedFragment) {
            this.f2321a = pageSurfaceReviewsFeedFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int count;
            if (this.f2321a.as.getAdapter() != null) {
                count = this.f2321a.as.getAdapter().getCount();
            } else {
                count = 0;
            }
            if (!(this.f2321a.as && this.f2321a.at == count)) {
                Pair a = PagesScrollUtils.a(this.f2321a.am, this.f2321a.as, i, PageSurfaceReviewsFeedFragment.ar, this.f2321a.h.d());
                this.f2321a.as = ((Boolean) a.a).booleanValue();
                if (this.f2321a.as) {
                    this.f2321a.E_(((Integer) a.b).intValue());
                    this.f2321a.at = count;
                }
            }
            int top = this.f2321a.as.getChildAt(0).getTop();
            if (this.f2321a.an != null && this.f2321a.as != null && this.f2321a.ao != top && this.f2321a.D()) {
                this.f2321a.an.m5039a((ViewGroup) this.f2321a.as, i);
                this.f2321a.ao = top;
            }
        }
    }

    public static PageSurfaceReviewsFeedFragment m3284a(long j, String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putString("session_id", null);
        bundle.putString("profile_name", str);
        bundle.putString("fragment_title", str2);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z);
        PageSurfaceReviewsFeedFragment pageSurfaceReviewsFeedFragment = new PageSurfaceReviewsFeedFragment();
        pageSurfaceReviewsFeedFragment.g(bundle);
        return pageSurfaceReviewsFeedFragment;
    }

    public final void m3285a(LayoutInflater layoutInflater) {
        boolean z;
        if (this.as.getAdapter() == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        aD();
        if (this.f2322i != null) {
            this.as.addHeaderView(this.f2322i);
        }
        this.as.setVerticalScrollBarEnabled(false);
        super.a(layoutInflater);
        this.am = new View(getContext());
        E_(this.aq);
        this.as.addFooterView(this.am);
        this.ao.setBackgroundResource(0);
        this.as.a(new C02871(this));
    }

    public final void m3286a(View view, Bundle bundle) {
        super.a(view, bundle);
        D_(this.ap);
    }

    private void aD() {
        if (this.f2322i == null) {
            if (this.al == null) {
                this.f2322i = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.f2322i = new ReactionHeaderTouchDelegateView(this.al);
                this.al.a(this.f2322i);
            }
            this.f2322i.c = true;
        } else if (this.al != null) {
            this.f2322i.a = this.al;
            this.al.a(this.f2322i);
            this.f2322i.requestLayout();
        }
    }

    public final void m3288a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.an = pagesSurfaceFragment;
    }

    public final void m3290j() {
    }

    public final void m3289a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.al = reactionHeaderViewWithTouchDelegate;
        aD();
    }

    public final void D_(int i) {
        this.ap = i;
        PagesScrollUtils.a(this.as, this.ap);
    }

    public final void E_(int i) {
        if (this.aq < 0 || i <= this.aq) {
            this.aq = i;
            if (this.am != null) {
                this.am.setLayoutParams(new LayoutParams(-1, this.aq));
            }
        }
    }

    public final void m3287a(C05581 c05581) {
    }
}
