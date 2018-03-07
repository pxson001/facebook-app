package com.facebook.reviews.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Timed out fetching results */
public class PageReviewsFeedFullscreenFragment extends PageReviewsFeedFragment {
    @Inject
    public GatekeeperStoreImpl al;
    private ViewGroup am;
    private RefreshableListViewContainer an;
    private View ao;
    public String ap;
    @Inject
    public AbstractFbErrorReporter f21752i;

    public static void m25246a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageReviewsFeedFullscreenFragment pageReviewsFeedFullscreenFragment = (PageReviewsFeedFullscreenFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        pageReviewsFeedFullscreenFragment.f21752i = abstractFbErrorReporter;
        pageReviewsFeedFullscreenFragment.al = a;
    }

    public final void mo1188c(Bundle bundle) {
        super.mo1188c(bundle);
        Class cls = PageReviewsFeedFullscreenFragment.class;
        m25246a(this, getContext());
        this.ap = this.s.getString("profile_name");
    }

    public final View mo1182a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1999548189);
        this.am = (ViewGroup) super.mo1182a(layoutInflater, viewGroup, bundle);
        if (aE()) {
            layoutInflater.inflate(2130906855, this.am, true);
            this.ao = FindViewUtil.b(this.am, 2131567017);
            this.an.setVisibility(8);
        }
        View view = this.am;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1895133388, a);
        return view;
    }

    public final int mo1189e() {
        return 2130906848;
    }

    public final void mo1183a(LayoutInflater layoutInflater, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.an = (RefreshableListViewContainer) FindViewUtil.b(viewGroup2, 2131566998);
    }

    public final void mo1180G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -777965780);
        super.mo1180G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(Strings.isNullOrEmpty(this.ap) ? b(2131235343) : this.ap);
            hasTitleBar.c(true);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 849521119, a);
    }

    public final void mo1181H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 559823066);
        super.mo1181H();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -25505799, a);
    }

    public final void mo1184a(OnRefreshListener onRefreshListener) {
        this.an.setOnRefreshListener(onRefreshListener);
    }

    public final void au() {
        if (aE()) {
            aC();
        }
        this.an.f();
    }

    public final void av() {
        if (aE()) {
            aC();
        }
        this.f21752i.a(PageReviewsFeedFullscreenFragment.class.getName(), "Review Feed failed to load reviews");
        this.an.a(b(2131235346));
    }

    private void aC() {
        this.ao.setVisibility(8);
        if (this.an != null) {
            this.an.setVisibility(0);
        }
    }

    private boolean aE() {
        return this.al.a(1080, false);
    }

    public final void at() {
        this.ar.b();
        this.ar.setVisibility(8);
        this.an.e();
    }
}
