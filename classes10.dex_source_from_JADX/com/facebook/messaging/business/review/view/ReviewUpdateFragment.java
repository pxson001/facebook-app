package com.facebook.messaging.business.review.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.review.graphql.ReviewQueryFragments.MessengerPlatformBotReviewQueryString;
import com.facebook.messaging.business.review.util.ReviewTaskManager;
import com.facebook.messaging.business.review.util.ReviewTaskManager.C02681;
import com.facebook.messaging.business.review.util.ReviewTaskManager.ReviewUpdateTask;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.ratingbar.BetterRatingBar;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread.notif_muted */
public final class ReviewUpdateFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public ReviewTaskManager f1677a;
    public String al;
    @Nullable
    public EventListener am;
    @Inject
    public BusinessMessageDialogHelper f1678b;
    public LinearLayout f1679c;
    public BetterRatingBar f1680d;
    public FbEditText f1681e;
    public BetterTextView f1682f;
    public ProgressBar f1683g;
    public DialogBasedProgressIndicator f1684h;
    public MenuItem f1685i;

    /* compiled from: thread.notif_muted */
    class C02701 implements RatingChangedListener {
        final /* synthetic */ ReviewUpdateFragment f1674a;

        C02701(ReviewUpdateFragment reviewUpdateFragment) {
            this.f1674a = reviewUpdateFragment;
        }

        public final void m1641a(int i, int i2) {
        }

        public final void m1640a(int i) {
            ReviewUpdateFragment.m1645g(this.f1674a, i);
        }
    }

    /* compiled from: thread.notif_muted */
    public class C02712 {
        public final /* synthetic */ ReviewUpdateFragment f1675a;

        C02712(ReviewUpdateFragment reviewUpdateFragment) {
            this.f1675a = reviewUpdateFragment;
        }
    }

    /* compiled from: thread.notif_muted */
    public class C02723 {
        public final /* synthetic */ ReviewUpdateFragment f1676a;

        public C02723(ReviewUpdateFragment reviewUpdateFragment) {
            this.f1676a = reviewUpdateFragment;
        }
    }

    /* compiled from: thread.notif_muted */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String m1642a() {
            return "ReviewUpdateFragment";
        }

        public final BusinessActivityFragment m1643b() {
            return new ReviewUpdateFragment();
        }
    }

    public static void m1644a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReviewUpdateFragment reviewUpdateFragment = (ReviewUpdateFragment) obj;
        ReviewTaskManager reviewTaskManager = new ReviewTaskManager((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector));
        BusinessMessageDialogHelper b = BusinessMessageDialogHelper.b(fbInjector);
        reviewUpdateFragment.f1677a = reviewTaskManager;
        reviewUpdateFragment.f1678b = b;
    }

    public final void m1649a(Parcelable parcelable) {
        this.al = ((Bundle) parcelable).getString("page_id");
    }

    public final String m1648a(Context context) {
        return context.getString(2131241180);
    }

    public final void m1653a(EventListener eventListener) {
        this.am = eventListener;
    }

    public final void m1654c(Bundle bundle) {
        super.c(bundle);
        e(true);
        Class cls = ReviewUpdateFragment.class;
        m1644a((Object) this, getContext());
    }

    public final View m1647a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1154796164);
        View inflate = layoutInflater.inflate(2130906845, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -740390987, a);
        return inflate;
    }

    public final void m1652a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f1679c = (LinearLayout) e(2131566992);
        this.f1680d = (BetterRatingBar) e(2131566993);
        this.f1681e = (FbEditText) e(2131566994);
        this.f1682f = (BetterTextView) e(2131566995);
        this.f1683g = (ProgressBar) e(2131566996);
        this.f1680d.a(new C02701(this));
        ReviewTaskManager reviewTaskManager = this.f1677a;
        String str = this.al;
        C02723 c02723 = new C02723(this);
        GraphQlQueryString messengerPlatformBotReviewQueryString = new MessengerPlatformBotReviewQueryString();
        messengerPlatformBotReviewQueryString.a("page_id", str);
        ReviewUpdateFragment reviewUpdateFragment = c02723.f1676a;
        reviewUpdateFragment.f1679c.setVisibility(4);
        reviewUpdateFragment.f1683g.setVisibility(0);
        reviewTaskManager.f1673c.a(ReviewUpdateTask.FETCH_REVIEW, reviewTaskManager.f1672b.a(GraphQLRequest.a(messengerPlatformBotReviewQueryString)), new C02681(reviewTaskManager, c02723));
    }

    public final void m1651a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(2131820584, menu);
    }

    public final void m1650a(Menu menu) {
        this.f1685i = menu.findItem(2131568681);
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568681) {
            return false;
        }
        this.f1677a.m1639a(this.al, this.f1680d.f, this.f1681e.getText().toString(), new C02712(this));
        return true;
    }

    public final void m1646I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2056717126);
        super.I();
        this.f1677a.f1673c.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -84169979, a);
    }

    public static void aq(ReviewUpdateFragment reviewUpdateFragment) {
        reviewUpdateFragment.f1683g.setVisibility(8);
        reviewUpdateFragment.f1679c.setVisibility(0);
    }

    public static void ar(ReviewUpdateFragment reviewUpdateFragment) {
        if (reviewUpdateFragment.f1684h != null) {
            reviewUpdateFragment.f1684h.b();
        }
    }

    public static void m1645g(ReviewUpdateFragment reviewUpdateFragment, int i) {
        if (reviewUpdateFragment.f1685i != null) {
            reviewUpdateFragment.f1685i.setEnabled(i != 0);
        }
    }
}
