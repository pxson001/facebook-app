package com.facebook.messaging.business.commerceui.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragments.CommerceReceiptListQueryString;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.views.retail.CommerceOrderHistoryLoader;
import com.facebook.messaging.business.commerceui.views.retail.CommerceOrderHistoryLoader.C09651;
import com.facebook.messaging.business.commerceui.views.retail.ReceiptDetailsFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.widget.listview.BetterListView;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: numShares */
public final class CommerceOrderHistoryFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public CommerceOrderHistoryLoader f8431a;
    @Inject
    public SecureContextHelper f8432b;
    public BetterListView f8433c;
    public CommerceOrderHistoryAdapter f8434d;
    public String f8435e;
    public ProgressBar f8436f;
    public ProgressBar f8437g;
    @Nullable
    public EventListener f8438h;

    /* compiled from: numShares */
    public class C09561 implements OnItemClickListener {
        final /* synthetic */ CommerceOrderHistoryFragment f8428a;

        public C09561(CommerceOrderHistoryFragment commerceOrderHistoryFragment) {
            this.f8428a = commerceOrderHistoryFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f8428a.f8432b.a(ReceiptDetailsFragment.m8792c(this.f8428a.getContext(), ((CommerceOrderItemView) view).f8443e.a), this.f8428a.getContext());
        }
    }

    /* compiled from: numShares */
    public class C09572 implements OnScrollListener {
        final /* synthetic */ CommerceOrderHistoryFragment f8429a;

        public C09572(CommerceOrderHistoryFragment commerceOrderHistoryFragment) {
            this.f8429a = commerceOrderHistoryFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3 && !this.f8429a.f8434d.isEmpty()) {
                Object obj;
                if (this.f8429a.f8431a.f8484g != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    CommerceOrderHistoryFragment.m8697a(this.f8429a, this.f8429a.f8435e);
                }
            }
        }
    }

    /* compiled from: numShares */
    public class C09583 {
        public final /* synthetic */ CommerceOrderHistoryFragment f8430a;

        public C09583(CommerceOrderHistoryFragment commerceOrderHistoryFragment) {
            this.f8430a = commerceOrderHistoryFragment;
        }
    }

    /* compiled from: numShares */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "CommerceOrderHistoryFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new CommerceOrderHistoryFragment();
        }
    }

    public static void m8698a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommerceOrderHistoryFragment commerceOrderHistoryFragment = (CommerceOrderHistoryFragment) obj;
        CommerceOrderHistoryLoader commerceOrderHistoryLoader = new CommerceOrderHistoryLoader(GraphQLQueryExecutor.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), ModelConverters.a(fbInjector), MessengerCommerceAnalyticsLogger.m8651b(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector));
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        commerceOrderHistoryFragment.f8431a = commerceOrderHistoryLoader;
        commerceOrderHistoryFragment.f8432b = secureContextHelper;
    }

    public final void mo310a(Parcelable parcelable) {
        this.f8435e = ((Bundle) parcelable).getString("commerce_id");
    }

    public final String mo309a(Context context) {
        return context.getString(2131240688);
    }

    public final void mo311a(EventListener eventListener) {
        this.f8438h = eventListener;
    }

    public final void m8705c(Bundle bundle) {
        Class cls = CommerceOrderHistoryFragment.class;
        m8698a((Object) this, getContext());
    }

    public final View m8700a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 271857534);
        View inflate = layoutInflater.inflate(2130905629, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -428061956, a);
        return inflate;
    }

    public final void m8703a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8436f = (ProgressBar) e(2131564669);
        this.f8433c = (BetterListView) e(2131564668);
        this.f8437g = (ProgressBar) LayoutInflater.from(getContext()).inflate(2130905630, this.f8433c, false);
        this.f8433c.addFooterView(this.f8437g);
        this.f8434d = new CommerceOrderHistoryAdapter(getContext());
        this.f8433c.setAdapter(this.f8434d);
        this.f8433c.removeFooterView(this.f8437g);
        this.f8433c.setOnItemClickListener(new C09561(this));
        this.f8433c.a(new C09572(this));
        this.f8431a.f8485h = new C09583(this);
        m8697a(this, this.f8435e);
    }

    public static void as(CommerceOrderHistoryFragment commerceOrderHistoryFragment) {
        commerceOrderHistoryFragment.f8436f.setVisibility(4);
        if (commerceOrderHistoryFragment.f8433c.getFooterViewsCount() != 0) {
            commerceOrderHistoryFragment.f8433c.removeFooterView(commerceOrderHistoryFragment.f8437g);
        }
    }

    public static void m8697a(CommerceOrderHistoryFragment commerceOrderHistoryFragment, String str) {
        Object obj;
        CommerceOrderHistoryLoader commerceOrderHistoryLoader = commerceOrderHistoryFragment.f8431a;
        if (commerceOrderHistoryLoader.f8483f == null || commerceOrderHistoryLoader.f8483f.b()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (commerceOrderHistoryFragment.f8434d.isEmpty()) {
                commerceOrderHistoryFragment.f8436f.setVisibility(0);
            } else if (commerceOrderHistoryFragment.f8433c.getFooterViewsCount() == 0) {
                commerceOrderHistoryFragment.f8433c.addFooterView(commerceOrderHistoryFragment.f8437g);
            }
            commerceOrderHistoryLoader = commerceOrderHistoryFragment.f8431a;
            if (commerceOrderHistoryLoader.f8484g == null) {
                GraphQlQueryString commerceReceiptListQueryString = new CommerceReceiptListQueryString();
                commerceReceiptListQueryString.a("business_id", str).a("receipt_count", "10").a("item_count", Integer.valueOf(1));
                if (null == null && commerceOrderHistoryLoader.f8483f != null && commerceOrderHistoryLoader.f8483f.b()) {
                    commerceReceiptListQueryString.a("receipt_after_cursor", commerceOrderHistoryLoader.f8483f.a());
                }
                GraphQLRequest a = GraphQLRequest.a(commerceReceiptListQueryString).a(GraphQLCachePolicy.a).a(120);
                long now = commerceOrderHistoryLoader.f8482e.now();
                commerceOrderHistoryLoader.f8484g = commerceOrderHistoryLoader.f8478a.a(a);
                Futures.a(commerceOrderHistoryLoader.f8484g, new C09651(commerceOrderHistoryLoader, now), commerceOrderHistoryLoader.f8479b);
            }
        }
    }

    public final void m8699H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -216336547);
        super.H();
        CommerceOrderHistoryLoader commerceOrderHistoryLoader = this.f8431a;
        if (commerceOrderHistoryLoader.f8484g != null) {
            commerceOrderHistoryLoader.f8484g.cancel(true);
            commerceOrderHistoryLoader.f8484g = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1799566223, a);
    }
}
