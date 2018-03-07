package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.socialgood.guestlist.FundraiserGuestListDataFetcher.FundraiserGuestListDataFetcherListener;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PAGES_LAUNCHPOINT_DISCOVER_FRAGMENT */
public class FundraiserMessageGuestsFragment extends FbFragment implements FundraiserGuestListDataFetcherListener {
    @Inject
    public FundraiserGuestListDataFetcher f12687a;
    @Inject
    public FundraiserMessageGuestsListAdapter f12688b;
    private String f12689c;
    private FundraiserGuestListTab f12690d;
    public FundraiserMessageGuestsFrameFragment f12691e;
    public final Set<String> f12692f = new HashSet();

    /* compiled from: PAGES_LAUNCHPOINT_DISCOVER_FRAGMENT */
    class C14961 implements OnScrollListener {
        final /* synthetic */ FundraiserMessageGuestsFragment f12685a;

        C14961(FundraiserMessageGuestsFragment fundraiserMessageGuestsFragment) {
            this.f12685a = fundraiserMessageGuestsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                this.f12685a.f12687a.m13045a();
            }
        }
    }

    /* compiled from: PAGES_LAUNCHPOINT_DISCOVER_FRAGMENT */
    class C14972 implements OnItemClickListener {
        final /* synthetic */ FundraiserMessageGuestsFragment f12686a;

        C14972(FundraiserMessageGuestsFragment fundraiserMessageGuestsFragment) {
            this.f12686a = fundraiserMessageGuestsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FundraiserMessageGuestsFragment fundraiserMessageGuestsFragment = this.f12686a;
            FundraiserGuestListUser fundraiserGuestListUser = (FundraiserGuestListUser) this.f12686a.f12688b.getItem(i);
            if (fundraiserMessageGuestsFragment.f12692f.contains(fundraiserGuestListUser.m13192e())) {
                fundraiserMessageGuestsFragment.f12692f.remove(fundraiserGuestListUser.m13192e());
            } else {
                fundraiserMessageGuestsFragment.f12692f.add(fundraiserGuestListUser.m13192e());
            }
            fundraiserGuestListUser.f12683b = !fundraiserGuestListUser.f12683b;
            fundraiserMessageGuestsFragment.f12691e.m13203a();
            AdapterDetour.a(fundraiserMessageGuestsFragment.f12688b, -817615257);
        }
    }

    public static void m13193a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FundraiserMessageGuestsFragment fundraiserMessageGuestsFragment = (FundraiserMessageGuestsFragment) obj;
        FundraiserGuestListDataFetcher b = FundraiserGuestListDataFetcher.m13043b(injectorLike);
        FundraiserMessageGuestsListAdapter fundraiserMessageGuestsListAdapter = new FundraiserMessageGuestsListAdapter((Context) injectorLike.getInstance(Context.class));
        fundraiserMessageGuestsListAdapter.f12707b = (Context) injectorLike.getInstance(Context.class);
        FundraiserMessageGuestsListAdapter fundraiserMessageGuestsListAdapter2 = fundraiserMessageGuestsListAdapter;
        fundraiserMessageGuestsFragment.f12687a = b;
        fundraiserMessageGuestsFragment.f12688b = fundraiserMessageGuestsListAdapter2;
    }

    public final void m13197c(Bundle bundle) {
        super.c(bundle);
        Class cls = FundraiserMessageGuestsFragment.class;
        m13193a((Object) this, getContext());
        this.f12689c = this.s.getString("fundraiser_campaign_id");
        this.f12690d = FundraiserGuestListTab.fromString(this.s.getString("FUNDRAISER_GUEST_LIST_TAB"));
        Fragment fragment = this.G;
        Preconditions.checkArgument(fragment instanceof FundraiserMessageGuestsFrameFragment, "Parent fragment must implement FundraiserMessageGuestsListener");
        this.f12691e = (FundraiserMessageGuestsFrameFragment) fragment;
        this.f12687a.m13046a(this.f12689c, this.f12690d, this, false);
        this.f12687a.m13045a();
    }

    public final View m13194a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -480601509);
        View inflate = layoutInflater.inflate(2130904560, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 770642692, a);
        return inflate;
    }

    public final void m13195a(View view, Bundle bundle) {
        super.a(view, bundle);
        BetterListView betterListView = (BetterListView) e(2131562453);
        betterListView.setAdapter(this.f12688b);
        betterListView.setVisibility(0);
        betterListView.requestLayout();
        this.f12687a.m13045a();
        betterListView.setOnScrollListener(new C14961(this));
        betterListView.setOnItemClickListener(new C14972(this));
    }

    public final void mo362a(ImmutableList<FundraiserGuestListUser> immutableList) {
        this.f12688b.m13033a(immutableList);
    }
}
