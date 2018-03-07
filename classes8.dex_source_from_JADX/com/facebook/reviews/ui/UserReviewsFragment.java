package com.facebook.reviews.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.adapter.UserReviewsListAdapter;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.binder.UserPlacesToReviewViewBinder;
import com.facebook.reviews.binder.UserReviewFeedRowViewBinder;
import com.facebook.reviews.binder.UserReviewsSeeMoreViewBinder;
import com.facebook.reviews.controller.UserReviewsListController;
import com.facebook.reviews.controller.UserReviewsListController.C23022;
import com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ScrollState.ScrollPosition;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TimeToProfilePicOnSubmit */
public class UserReviewsFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    @LoggedInUserId
    Provider<String> f21797a;
    public String al;
    @Nullable
    private String am;
    @Inject
    ReviewsLogger f21798b;
    @Inject
    UserReviewsListAdapter f21799c;
    @Inject
    UserReviewsListComposerLauncherAndHandler f21800d;
    @Inject
    UserReviewsListController f21801e;
    public RefreshableListViewContainer f21802f;
    public BetterListView f21803g;
    public LoadingIndicatorView f21804h;
    private String f21805i;

    /* compiled from: TimeToProfilePicOnSubmit */
    public class C23441 implements Runnable {
        final /* synthetic */ UserReviewsFragment f21796a;

        public C23441(UserReviewsFragment userReviewsFragment) {
            this.f21796a = userReviewsFragment;
        }

        public void run() {
            if (this.f21796a.f21803g.getScrollPosition() == ScrollPosition.BOTTOM) {
                this.f21796a.f21803g.smoothScrollToPosition(this.f21796a.f21803g.getCount() + 1);
            }
        }
    }

    public static void m25278a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((UserReviewsFragment) obj).m25279a(IdBasedProvider.a(injectorLike, 4442), ReviewsLogger.a(injectorLike), new UserReviewsListAdapter(ResourcesMethodAutoProvider.a(injectorLike), UserPlacesToReviewViewBinder.m25048a(injectorLike), UserReviewFeedRowViewBinder.m25056a(injectorLike), new UserReviewsSeeMoreViewBinder()), UserReviewsListComposerLauncherAndHandler.m25177a(injectorLike), UserReviewsListController.m25092b(injectorLike));
    }

    private void m25279a(Provider<String> provider, ReviewsLogger reviewsLogger, UserReviewsListAdapter userReviewsListAdapter, UserReviewsListComposerLauncherAndHandler userReviewsListComposerLauncherAndHandler, UserReviewsListController userReviewsListController) {
        this.f21797a = provider;
        this.f21798b = reviewsLogger;
        this.f21799c = userReviewsListAdapter;
        this.f21800d = userReviewsListComposerLauncherAndHandler;
        this.f21801e = userReviewsListController;
    }

    public final void m25285c(Bundle bundle) {
        super.c(bundle);
        Class cls = UserReviewsFragment.class;
        m25278a((Object) this, getContext());
        this.f21805i = this.s.getString("com.facebook.katana.profile.id");
        if (this.f21805i == null) {
            this.f21805i = (String) this.f21797a.get();
        }
        this.al = this.s.getString("profile_name");
        this.am = this.s.getString("review_id");
        if (bundle == null) {
            ReviewsLogger reviewsLogger = this.f21798b;
            String str = this.f21805i;
            AnalyticsLogger analyticsLogger = reviewsLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("user_reviews_list_impression");
            honeyClientEvent.c = "user_reviews_list";
            analyticsLogger.a(honeyClientEvent.b("review_creator_id", str));
        }
    }

    public final View m25281a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1251709083);
        View inflate = layoutInflater.inflate(2130907627, viewGroup, false);
        this.f21802f = (RefreshableListViewContainer) FindViewUtil.b(inflate, 2131568233);
        this.f21803g = (BetterListView) FindViewUtil.b(this.f21802f, 2131568234);
        this.f21804h = (LoadingIndicatorView) LayoutInflater.from(getContext()).inflate(2130906854, this.f21803g, false);
        this.f21803g.addFooterView(this.f21804h, null, false);
        this.f21803g.setAdapter(this.f21799c);
        this.f21803g.setStickyHeaderEnabled(true);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1299019647, a);
        return inflate;
    }

    public final void m25283a(View view, Bundle bundle) {
        super.a(view, bundle);
        UserReviewsListController userReviewsListController = this.f21801e;
        UserReviewsListAdapter userReviewsListAdapter = this.f21799c;
        String str = this.f21805i;
        String str2 = this.am;
        userReviewsListController.f21530o = (FbEventSubscriberListManager) userReviewsListController.f21519d.get();
        userReviewsListController.f21531p = (FbEventSubscriberListManager) userReviewsListController.f21519d.get();
        userReviewsListController.f21528m = str;
        userReviewsListController.f21527l = Optional.fromNullable(str2);
        userReviewsListController.f21533r = userReviewsListAdapter;
        userReviewsListController.f21529n = this;
        userReviewsListController.f21525j = ((String) userReviewsListController.f21521f.get()).equals(userReviewsListController.f21528m);
        UserReviewsFragment userReviewsFragment = userReviewsListController.f21529n;
        userReviewsFragment.f21802f.setOnRefreshListener(new C23022(userReviewsListController));
        userReviewsListController.m25100b();
        this.f21802f.e();
    }

    public final void m25280G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -325778762);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            if (this.al != null) {
                hasTitleBar.a_(StringFormatUtil.formatStrLocaleSafe(b(2131235337), this.al));
            } else {
                hasTitleBar.a_(b(2131235343));
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2053181207, a);
    }

    public final void m25284a(OnScrollListener onScrollListener) {
        this.f21803g.setOnScrollListener(onScrollListener);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 303761465);
        UserReviewsListController userReviewsListController = this.f21801e;
        userReviewsListController.f21522g.m25214a();
        if (userReviewsListController.f21530o != null) {
            userReviewsListController.f21530o.b(userReviewsListController.f21518c);
        }
        if (userReviewsListController.f21531p != null) {
            userReviewsListController.f21531p.b(userReviewsListController.f21516a);
        }
        userReviewsListController.f21530o = null;
        userReviewsListController.f21531p = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -245089245, a);
    }

    public final void m25282a(int i, int i2, Intent intent) {
        if (i == 1759) {
            PostReviewParams postReviewParams = (PostReviewParams) intent.getParcelableExtra("publishReviewParams");
            if (postReviewParams != null) {
                this.f21800d.m25179a(getContext(), i2, intent, String.valueOf(postReviewParams.b), "user_reviews_list");
            }
        }
    }

    public final String am_() {
        return "user_reviews_list";
    }

    public final void m25286e() {
        this.f21802f.f();
    }

    public final void aq() {
        this.f21804h.b();
    }
}
