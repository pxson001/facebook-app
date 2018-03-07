package com.facebook.reviews.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.controller.ReviewStoriesFeedController;
import com.facebook.reviews.feed.ReviewsFeedComposerLauncherAndHandler;
import com.facebook.reviews.feed.ReviewsFeedInlineReviewController;
import com.facebook.reviews.feed.ReviewsFeedSubscriber;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: TimelineLauncher */
public class PageReviewsFeedFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    ComposerPublishServiceHelper f21743a;
    public String al;
    public boolean am = false;
    private boolean an = true;
    public ViewGroup ao;
    private ProgressBar ap;
    public View aq;
    public LoadingIndicatorView ar;
    public BetterListView as;
    public FrameLayout at;
    @Inject
    AbstractFbErrorReporter f21744b;
    @Inject
    Lazy<ReviewsFeedComposerLauncherAndHandler> f21745c;
    @Inject
    public ReviewsFeedInlineReviewController f21746d;
    @Inject
    ReviewsLogger f21747e;
    @Inject
    ReviewStoriesFeedController f21748f;
    @Inject
    Toaster f21749g;
    @Inject
    public ScreenUtil f21750h;
    public String f21751i;

    /* compiled from: TimelineLauncher */
    public class C23411 implements OnScrollListener {
        final /* synthetic */ PageReviewsFeedFragment f21742a;

        public C23411(PageReviewsFeedFragment pageReviewsFeedFragment) {
            this.f21742a = pageReviewsFeedFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ReviewStoriesFeedController reviewStoriesFeedController = this.f21742a.f21748f;
            boolean z = i3 - (i + i2) < 12;
            boolean isPresent = reviewStoriesFeedController.f21509p.isPresent();
            if (z && isPresent && !reviewStoriesFeedController.f21504k) {
                reviewStoriesFeedController.f21499f.m25124a(reviewStoriesFeedController.f21513t, 10, reviewStoriesFeedController, (String) reviewStoriesFeedController.f21509p.get());
                reviewStoriesFeedController.f21504k = true;
                reviewStoriesFeedController.f21505l.ax();
            }
        }
    }

    public static void m25234a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageReviewsFeedFragment) obj).m25233a(ComposerPublishServiceHelper.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 10266), new ReviewsFeedInlineReviewController(IdBasedProvider.a(fbInjector, 3595), ReviewsFeedComposerLauncherAndHandler.m25112b(fbInjector), ReviewsLogger.a(fbInjector)), ReviewsLogger.a(fbInjector), ReviewStoriesFeedController.m25081b(fbInjector), Toaster.b(fbInjector), ScreenUtil.a(fbInjector));
    }

    private void m25233a(ComposerPublishServiceHelper composerPublishServiceHelper, FbErrorReporter fbErrorReporter, Lazy<ReviewsFeedComposerLauncherAndHandler> lazy, ReviewsFeedInlineReviewController reviewsFeedInlineReviewController, ReviewsLogger reviewsLogger, ReviewStoriesFeedController reviewStoriesFeedController, Toaster toaster, ScreenUtil screenUtil) {
        this.f21743a = composerPublishServiceHelper;
        this.f21744b = fbErrorReporter;
        this.f21745c = lazy;
        this.f21746d = reviewsFeedInlineReviewController;
        this.f21747e = reviewsLogger;
        this.f21748f = reviewStoriesFeedController;
        this.f21749g = toaster;
        this.f21750h = screenUtil;
    }

    public void mo1188c(Bundle bundle) {
        super.c(bundle);
        Class cls = PageReviewsFeedFragment.class;
        m25234a((Object) this, getContext());
        long j = this.s.getLong("com.facebook.katana.profile.id");
        Preconditions.checkArgument(j > 0, "Invalid page id: " + j);
        this.f21751i = String.valueOf(j);
        this.al = this.s.getString("profile_name");
        this.am = this.s.getBoolean("extra_is_inside_page_surface_tab", false);
        this.an = this.s.getBoolean("show_reviews_composer", true);
        if (bundle == null) {
            this.f21747e.a(this.f21751i);
        }
    }

    public View mo1182a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -564282363);
        this.ao = (ViewGroup) layoutInflater.inflate(mo1189e(), viewGroup, false);
        mo1183a(layoutInflater, viewGroup, this.ao);
        this.as = (BetterListView) FindViewUtil.b(this.ao, 2131566997);
        m25240a(layoutInflater);
        this.as.a(new C23411(this));
        View view = this.ao;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -521830217, a);
        return view;
    }

    public void m25242a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f21748f.m25083a(this.as, this.f21751i, this.an, this);
    }

    public int mo1189e() {
        return 2130906846;
    }

    public void mo1183a(LayoutInflater layoutInflater, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.ap = (ProgressBar) layoutInflater.inflate(2130906847, viewGroup, false);
        this.ap.setLayoutParams(new LayoutParams(-1, -2));
    }

    public void m25240a(LayoutInflater layoutInflater) {
        Preconditions.checkArgument(this.as.getAdapter() == null);
        View inflate = layoutInflater.inflate(2130906842, this.as, false);
        if (this.am) {
            inflate.setPadding(inflate.getLeft(), jW_().getDimensionPixelSize(2131427418), inflate.getRight(), inflate.getBottom());
        }
        this.aq = inflate.findViewById(2131566991);
        this.as.addHeaderView(inflate);
        this.at = new FrameLayout(getContext());
        this.as.addHeaderView(this.at);
        this.aq.setVisibility(8);
        if (this.ap != null) {
            this.as.addFooterView(this.ap);
        }
        this.ar = new LoadingIndicatorView(getContext());
        this.ar.a(0, jW_().getDimensionPixelOffset(2131430057));
        this.as.addFooterView(this.ar, null, false);
    }

    public final String am_() {
        return "reviews_feed";
    }

    public void mo1180G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1088428511);
        super.G();
        this.f21748f.f21498e.f21601c.e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -453430746, a);
    }

    public void mo1181H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -995811939);
        super.H();
        this.f21748f.f21498e.f21601c.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 525782671, a);
    }

    public final void m25239a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1756:
                    this.f21749g.a(new ToastBuilder(2131234541));
                    this.f21743a.c(intent);
                    return;
                case 1759:
                    ((ReviewsFeedComposerLauncherAndHandler) this.f21745c.get()).m25114a(getContext(), i2, intent, this.f21751i, am_());
                    return;
                default:
                    return;
            }
        }
    }

    public final void m25237I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2047193772);
        super.I();
        ReviewStoriesFeedController reviewStoriesFeedController = this.f21748f;
        if (reviewStoriesFeedController.f21498e != null) {
            ReviewsFeedSubscriber reviewsFeedSubscriber = reviewStoriesFeedController.f21498e;
            reviewsFeedSubscriber.f21601c.a();
            if (reviewsFeedSubscriber.f21605g.isPresent()) {
                ((FbEventSubscriberListManager) reviewsFeedSubscriber.f21605g.get()).b(reviewsFeedSubscriber.f21600b);
            }
            reviewsFeedSubscriber.f21604f.b(reviewsFeedSubscriber.f21603e);
        }
        if (reviewStoriesFeedController.f21506m != null) {
            reviewStoriesFeedController.f21506m.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 709613388, a);
    }

    public void mo1184a(OnRefreshListener onRefreshListener) {
    }

    public void at() {
        this.ar.b();
        this.ar.setVisibility(8);
        this.ap.setVisibility(0);
    }

    public void au() {
        this.ap.setVisibility(8);
    }

    public void av() {
        this.f21744b.a(PageReviewsFeedFragment.class.getName(), "Review Feed failed to load reviews");
        this.ap.setVisibility(8);
        this.f21749g.a(new ToastBuilder(2131235346));
    }

    public final ReviewFeedOverallRatingView aw() {
        return (ReviewFeedOverallRatingView) this.aq;
    }

    public final void ax() {
        this.ar.setVisibility(0);
        this.ar.a();
    }

    public final void ay() {
        this.ar.b();
    }
}
