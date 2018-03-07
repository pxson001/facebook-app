package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragments.CommerceShoppingTrendingQueryString;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.loader.CommerceShoppingTrendingLoader;
import com.facebook.messaging.business.commerceui.loader.CommerceShoppingTrendingLoader.C09501;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.ui.segmentedtabbar.SegmentedTabBar;
import com.facebook.messaging.ui.segmentedtabbar.SegmentedTabBar.Listener;
import com.facebook.messaging.ui.segmentedtabbar.SegmentedTabBar.Tab;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null content-transfer-encoding */
public final class CommerceShoppingTrendingFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public CommerceShoppingTrendingLoader f8492a;
    @Inject
    public CommerceShoppingTrendingAdapter f8493b;
    public String f8494c;
    @Nullable
    public EventListener f8495d;
    public SegmentedTabBar f8496e;
    public RecyclerView f8497f;
    public ProgressBar f8498g;

    /* compiled from: null content-transfer-encoding */
    public class C09661 {
        public final /* synthetic */ CommerceShoppingTrendingFragment f8489a;

        public C09661(CommerceShoppingTrendingFragment commerceShoppingTrendingFragment) {
            this.f8489a = commerceShoppingTrendingFragment;
        }
    }

    /* compiled from: null content-transfer-encoding */
    public class C09672 implements Listener {
        final /* synthetic */ CommerceShoppingTrendingFragment f8490a;

        public C09672(CommerceShoppingTrendingFragment commerceShoppingTrendingFragment) {
            this.f8490a = commerceShoppingTrendingFragment;
        }

        public final void mo312a(Tab tab) {
            switch (tab) {
                case LEFT:
                    CommerceShoppingTrendingFragment.m8741a(this.f8490a, this.f8490a.f8494c, "female");
                    return;
                case RIGHT:
                    CommerceShoppingTrendingFragment.m8741a(this.f8490a, this.f8490a.f8494c, "male");
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: null content-transfer-encoding */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "CommerceShoppingTrendingFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new CommerceShoppingTrendingFragment();
        }
    }

    public static void m8742a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommerceShoppingTrendingFragment commerceShoppingTrendingFragment = (CommerceShoppingTrendingFragment) obj;
        CommerceShoppingTrendingLoader commerceShoppingTrendingLoader = new CommerceShoppingTrendingLoader(GraphQLQueryExecutor.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), MessengerCommerceAnalyticsLogger.m8651b(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector));
        CommerceShoppingTrendingAdapter commerceShoppingTrendingAdapter = new CommerceShoppingTrendingAdapter();
        commerceShoppingTrendingFragment.f8492a = commerceShoppingTrendingLoader;
        commerceShoppingTrendingFragment.f8493b = commerceShoppingTrendingAdapter;
    }

    public final void mo310a(Parcelable parcelable) {
        this.f8494c = ((Bundle) parcelable).getString("business_page_id");
        Preconditions.checkNotNull(this.f8494c);
    }

    public final String mo309a(Context context) {
        return context.getString(2131240691);
    }

    public final void mo311a(EventListener eventListener) {
        this.f8495d = eventListener;
    }

    public final void m8750e(Bundle bundle) {
        super.e(bundle);
        if (!Strings.isNullOrEmpty(this.f8494c)) {
            bundle.putString("business_page_id", this.f8494c);
        }
        if (this.f8493b != null && this.f8493b.f8487a != null) {
            bundle.putParcelableArrayList("tending_items", new ArrayList(this.f8493b.f8487a));
        }
    }

    public final void m8749c(Bundle bundle) {
        super.c(bundle);
        Class cls = CommerceShoppingTrendingFragment.class;
        m8742a((Object) this, getContext());
        if (bundle != null) {
            this.f8494c = bundle.getString("business_page_id");
            Collection parcelableArrayList = bundle.getParcelableArrayList("tending_items");
            if (parcelableArrayList != null && this.f8493b != null) {
                this.f8493b.f8487a = ImmutableList.copyOf(parcelableArrayList);
            }
        }
    }

    public final View m8744a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -646689777);
        View inflate = layoutInflater.inflate(2130905635, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -754624082, a);
        return inflate;
    }

    public final void m8747a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8496e = (SegmentedTabBar) e(2131564682);
        this.f8497f = (RecyclerView) e(2131564683);
        this.f8498g = (ProgressBar) e(2131564684);
        this.f8497f.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.f8493b.f8488b = this.f8494c;
        this.f8497f.setAdapter(this.f8493b);
        this.f8492a.f8395f = new C09661(this);
        this.f8496e.f18268e = new C09672(this);
        m8741a(this, this.f8494c, "female");
    }

    public final void m8743H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1268068353);
        super.H();
        CommerceShoppingTrendingLoader commerceShoppingTrendingLoader = this.f8492a;
        if (commerceShoppingTrendingLoader.f8394e != null) {
            commerceShoppingTrendingLoader.f8394e.cancel(true);
            commerceShoppingTrendingLoader.f8394e = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1294116944, a);
    }

    public static void m8741a(CommerceShoppingTrendingFragment commerceShoppingTrendingFragment, String str, String str2) {
        commerceShoppingTrendingFragment.f8498g.setVisibility(0);
        commerceShoppingTrendingFragment.f8497f.setVisibility(4);
        CommerceShoppingTrendingLoader commerceShoppingTrendingLoader = commerceShoppingTrendingFragment.f8492a;
        if (commerceShoppingTrendingLoader.f8394e == null) {
            GraphQlQueryString commerceShoppingTrendingQueryString = new CommerceShoppingTrendingQueryString();
            commerceShoppingTrendingQueryString.a("business_id", str).a("gender", str2);
            GraphQLRequest a = GraphQLRequest.a(commerceShoppingTrendingQueryString).a(GraphQLCachePolicy.a).a(600);
            long now = commerceShoppingTrendingLoader.f8393d.now();
            commerceShoppingTrendingLoader.f8394e = commerceShoppingTrendingLoader.f8390a.a(a);
            Futures.a(commerceShoppingTrendingLoader.f8394e, new C09501(commerceShoppingTrendingLoader, now), commerceShoppingTrendingLoader.f8391b);
        }
    }
}
