package com.facebook.groups.fb4a.discover;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.groups.fb4a.discover.FB4AGroupsDiscoverPagedListLoader.C31421;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.HasTitleBar;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
public class FB4AGroupsDiscoverFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    public FB4AGroupsDiscoverPagedListLoader f21924a;
    public final RetryClickedListener al = new C31382(this);
    @Inject
    public FB4AGroupsDiscoverAdapter f21925b;
    @Inject
    public FbNetworkManager f21926c;
    @Inject
    public FbLocalBroadcastManager f21927d;
    private NetworkConnectivityBroadcastReceiver f21928e;
    private BetterListView f21929f;
    public BetterTextView f21930g;
    public LoadingIndicatorView f21931h;
    private final C31371 f21932i = new C31371(this);

    /* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
    public class C31371 {
        public final /* synthetic */ FB4AGroupsDiscoverFragment f21918a;

        C31371(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
            this.f21918a = fB4AGroupsDiscoverFragment;
        }
    }

    /* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
    class C31382 implements RetryClickedListener {
        final /* synthetic */ FB4AGroupsDiscoverFragment f21919a;

        C31382(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
            this.f21919a = fB4AGroupsDiscoverFragment;
        }

        public final void m23054a() {
            FB4AGroupsDiscoverFragment.m23056e(this.f21919a);
        }
    }

    /* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
    class C31393 implements OnScrollListener {
        final /* synthetic */ FB4AGroupsDiscoverFragment f21920a;

        C31393(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
            this.f21920a = fB4AGroupsDiscoverFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment = this.f21920a;
            Object obj = null;
            if (i2 > 0 && i3 > 0 && (i + i2) + 3 > i3 && !fB4AGroupsDiscoverFragment.f21924a.f21950l) {
                obj = 1;
            }
            if (obj != null) {
                FB4AGroupsDiscoverFragment.m23056e(this.f21920a);
            }
        }
    }

    /* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
    public class C31404 {
        public final /* synthetic */ FB4AGroupsDiscoverFragment f21921a;

        C31404(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
            this.f21921a = fB4AGroupsDiscoverFragment;
        }
    }

    /* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
    class NetworkConnectivityBroadcastReceiver extends DynamicSecureBroadcastReceiver {
        final /* synthetic */ FB4AGroupsDiscoverFragment f21923a;

        /* compiled from: Trying to stop TimelineScrubberClickEventProcessor that was not started */
        class C31411 implements ActionReceiver {
            final /* synthetic */ FB4AGroupsDiscoverFragment f21922a;

            C31411(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
                this.f21922a = fB4AGroupsDiscoverFragment;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2039432077);
                if (this.f21922a.f21926c.d() && this.f21922a.f21924a.f21956r) {
                    FB4AGroupsDiscoverFragment.m23056e(this.f21922a);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2130048077, a);
            }
        }

        public NetworkConnectivityBroadcastReceiver(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
            this.f21923a = fB4AGroupsDiscoverFragment;
            super("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C31411(fB4AGroupsDiscoverFragment));
        }
    }

    public static void m23055a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment = (FB4AGroupsDiscoverFragment) obj;
        FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader = new FB4AGroupsDiscoverPagedListLoader(TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), FbNetworkManager.a(fbInjector), GraphQLSubscriptionHolder.b(fbInjector));
        FB4AGroupsDiscoverAdapter fB4AGroupsDiscoverAdapter = new FB4AGroupsDiscoverAdapter();
        FbNetworkManager a = FbNetworkManager.a(fbInjector);
        FbLocalBroadcastManager a2 = FbLocalBroadcastManagerMethodAutoProvider.a(fbInjector);
        fB4AGroupsDiscoverFragment.f21924a = fB4AGroupsDiscoverPagedListLoader;
        fB4AGroupsDiscoverFragment.f21925b = fB4AGroupsDiscoverAdapter;
        fB4AGroupsDiscoverFragment.f21926c = a;
        fB4AGroupsDiscoverFragment.f21927d = a2;
    }

    public final void m23059c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FB4AGroupsDiscoverFragment.class;
        m23055a((Object) this, getContext());
    }

    public final View m23057a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1207980801);
        View inflate = layoutInflater.inflate(2130904252, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 519126461, a);
        return inflate;
    }

    public final void m23058a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f21928e = new NetworkConnectivityBroadcastReceiver(this);
        this.f21927d.a(this.f21928e, new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED"));
        this.f21931h = (LoadingIndicatorView) e(2131561758);
        this.f21931h.a();
        this.f21929f = (BetterListView) e(2131561759);
        this.f21929f.setAdapter(this.f21925b);
        this.f21925b.f21916f = this.f21932i;
        this.f21929f.setOnScrollListener(new C31393(this));
        FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader = this.f21924a;
        Resources resources = view.getContext().getResources();
        fB4AGroupsDiscoverPagedListLoader.f21948j = new C31404(this);
        fB4AGroupsDiscoverPagedListLoader.f21954p = resources;
        fB4AGroupsDiscoverPagedListLoader.f21955q = fB4AGroupsDiscoverPagedListLoader.f21954p.getDimension(2131434250);
        fB4AGroupsDiscoverPagedListLoader.f21947i = new C31421(fB4AGroupsDiscoverPagedListLoader);
        m23056e(this);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -322803974);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(b(2131242058));
            hasTitleBar.c(true);
            hasTitleBar.a(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1383621266, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1571153827);
        super.mY_();
        FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader = this.f21924a;
        fB4AGroupsDiscoverPagedListLoader.f21948j = null;
        fB4AGroupsDiscoverPagedListLoader.f21940b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 848600909, a);
    }

    public final String am_() {
        return "discovery";
    }

    public static void m23056e(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
        fB4AGroupsDiscoverFragment.f21925b.m23052a(true);
        fB4AGroupsDiscoverFragment.f21924a.m23070d();
    }

    public static void ar(FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment) {
        if (fB4AGroupsDiscoverFragment.f21930g == null) {
            fB4AGroupsDiscoverFragment.f21930g = (BetterTextView) fB4AGroupsDiscoverFragment.e(2131561757);
            fB4AGroupsDiscoverFragment.f21930g.setText(StringFormatUtil.a("%s\n\n%s", new Object[]{fB4AGroupsDiscoverFragment.b(2131242061), fB4AGroupsDiscoverFragment.b(2131242062)}));
        }
        fB4AGroupsDiscoverFragment.f21930g.setVisibility(0);
        fB4AGroupsDiscoverFragment.e(2131561759).setVisibility(8);
        if (fB4AGroupsDiscoverFragment.f21931h.f()) {
            fB4AGroupsDiscoverFragment.f21931h.b();
        }
    }
}
