package com.facebook.groups.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.groups.feed.controller.GroupsFeedController;
import com.facebook.groups.feed.controller.GroupsFeedControllerResponder;
import com.facebook.groups.feed.controller.GroupsFeedPager;
import com.facebook.groups.feed.controller.GroupsFeedPager.PagerListener;
import com.facebook.groups.feed.controller.GroupsFeedPagerProtocol;
import com.facebook.groups.feed.data.GroupsFeedConsistencySync;
import com.facebook.groups.feed.data.GroupsFeedConsistencySyncProvider;
import com.facebook.groups.feed.data.GroupsOnDataChangeListener;
import com.facebook.groups.feed.rows.GroupsFeedListType;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimelineGetNotifiedButtonImpression */
public abstract class BaseForSalePostsFeedFragment extends GroupsFeedSearchQueryFragment implements GroupsFeedControllerResponder {
    @Inject
    GroupsFeedConsistencySyncProvider f21999a;
    @Inject
    GroupsFeedPager f22000b;
    @Inject
    GroupsFeedPagerProtocol f22001c;
    @Inject
    public GroupsFeedController f22002d;
    @Inject
    GroupsEnvironmentProvider f22003e;
    protected MultiRowAdapter f22004f;
    private FeedType f22005g;
    public GroupsFeedConsistencySync f22006h;
    public boolean f22007i;

    /* compiled from: TimelineGetNotifiedButtonImpression */
    class C31491 implements Runnable {
        final /* synthetic */ BaseForSalePostsFeedFragment f21994a;

        C31491(BaseForSalePostsFeedFragment baseForSalePostsFeedFragment) {
            this.f21994a = baseForSalePostsFeedFragment;
        }

        public void run() {
            this.f21994a.f22004f.notifyDataSetChanged();
        }
    }

    /* compiled from: TimelineGetNotifiedButtonImpression */
    class C31502 implements PagerListener {
        final /* synthetic */ BaseForSalePostsFeedFragment f21995a;

        C31502(BaseForSalePostsFeedFragment baseForSalePostsFeedFragment) {
            this.f21995a = baseForSalePostsFeedFragment;
        }

        public final void m23120a() {
            this.f21995a.f22002d.h();
        }

        public final void m23122b() {
            this.f21995a.f22002d.f();
        }

        public final void m23123b(boolean z) {
            if (this.f21995a.f22007i) {
                this.f21995a.f22006h.a(z);
            }
        }

        public final void m23121a(boolean z) {
            this.f21995a.f22002d.b(z);
        }
    }

    /* compiled from: TimelineGetNotifiedButtonImpression */
    class C31513 implements GroupsOnDataChangeListener {
        final /* synthetic */ BaseForSalePostsFeedFragment f21996a;

        C31513(BaseForSalePostsFeedFragment baseForSalePostsFeedFragment) {
            this.f21996a = baseForSalePostsFeedFragment;
        }

        public final void m23124b() {
            this.f21996a.f22004f.notifyDataSetChanged();
        }
    }

    public static void m23129a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BaseForSalePostsFeedFragment) obj).m23128a((GroupsFeedConsistencySyncProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsFeedConsistencySyncProvider.class), GroupsFeedPager.b(fbInjector), GroupsFeedPagerProtocol.b(fbInjector), GroupsFeedController.b(fbInjector), (GroupsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsEnvironmentProvider.class));
    }

    public abstract GroupsFeedConsistencySync mo974a(GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, FeedUnitCollection feedUnitCollection, GroupsOnDataChangeListener groupsOnDataChangeListener);

    public abstract FeedType at();

    public abstract int au();

    public void mo973c(Bundle bundle) {
        super.mo973c(bundle);
        Class cls = BaseForSalePostsFeedFragment.class;
        m23129a((Object) this, getContext());
        this.f22005g = at();
        this.f22001c.a(this.f22005g, 10, 3);
    }

    public final FeedEnvironment m23131a(BetterListView betterListView) {
        return this.f22003e.m23223a(MenuType.NORMAL, getContext(), GroupsFeedListType.a, new C31491(this), HasScrollListenerSupportImpl.a(betterListView), null);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 947352852);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(au());
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1114104010, a);
    }

    public final View m23130a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1702670088);
        View view = (ViewGroup) layoutInflater.inflate(2130904711, viewGroup, false);
        this.f22000b.a(this.f22001c, new C31502(this), 1000, 5, null);
        FeedUnitCollection e = this.f22000b.e();
        GroupsFeedController groupsFeedController = this.f22002d;
        GroupsFeedPager groupsFeedPager = this.f22000b;
        GroupsFeedListType.b();
        groupsFeedController.a(view, groupsFeedPager, e, this, this, true, null);
        this.f22006h = mo974a(this.f21999a, e, new C31513(this));
        if (this.f22006h != null) {
            this.f22007i = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 557434474, a);
        return view;
    }

    public final void m23133a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.f22002d.b(i, i2, intent);
    }

    public final void m23135a(boolean z, boolean z2) {
    }

    @Nullable
    public final FbBaseAdapter m23141l() {
        return null;
    }

    @Nullable
    public final FbBaseAdapter m23142m() {
        return null;
    }

    public final void m23140f() {
    }

    public final boolean m23136a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner) {
        return false;
    }

    public final void nt_() {
        this.f22002d.h();
    }

    public final void m23143r() {
    }

    public final void m23134a(View view) {
        FbTextView fbTextView = (FbTextView) view.findViewById(2131561172);
        fbTextView.setVisibility(8);
        fbTextView.setText(jW_().getText(2131238016));
    }

    public final void m23139e() {
        this.f22002d.i();
    }

    public final void m23137b(boolean z) {
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -561796703);
        super.mY_();
        if (this.f22007i) {
            this.f22006h.a();
        }
        this.f22000b.g();
        if (this.f22004f != null) {
            this.f22004f.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -232355678, a);
    }

    private void m23128a(GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, GroupsFeedPager groupsFeedPager, GroupsFeedPagerProtocol groupsFeedPagerProtocol, GroupsFeedController groupsFeedController, GroupsEnvironmentProvider groupsEnvironmentProvider) {
        this.f21999a = groupsFeedConsistencySyncProvider;
        this.f22000b = groupsFeedPager;
        this.f22001c = groupsFeedPagerProtocol;
        this.f22002d = groupsFeedController;
        this.f22003e = groupsEnvironmentProvider;
    }
}
