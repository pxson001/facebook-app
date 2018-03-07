package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.socialgood.guestlist.FundraiserGuestListDataFetcher.FundraiserGuestListDataFetcherListener;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PAGING */
public class FundraiserGuestListFragment extends FbFragment implements FundraiserGuestListDataFetcherListener {
    @Inject
    public FundraiserGuestListDataFetcher f12634a;
    @Inject
    public FundraiserGuestListAdapter f12635b;
    private String f12636c;
    private FundraiserGuestListTab f12637d;
    private final Set<String> f12638e = new HashSet();

    /* compiled from: PAGING */
    class C14931 implements OnScrollListener {
        final /* synthetic */ FundraiserGuestListFragment f12633a;

        C14931(FundraiserGuestListFragment fundraiserGuestListFragment) {
            this.f12633a = fundraiserGuestListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                this.f12633a.f12634a.m13045a();
            }
        }
    }

    public static void m13047a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FundraiserGuestListFragment fundraiserGuestListFragment = (FundraiserGuestListFragment) obj;
        FundraiserGuestListDataFetcher b = FundraiserGuestListDataFetcher.m13043b(injectorLike);
        FundraiserGuestListAdapter fundraiserGuestListAdapter = new FundraiserGuestListAdapter();
        fundraiserGuestListAdapter.f12618b = (Context) injectorLike.getInstance(Context.class);
        FundraiserGuestListAdapter fundraiserGuestListAdapter2 = fundraiserGuestListAdapter;
        fundraiserGuestListFragment.f12634a = b;
        fundraiserGuestListFragment.f12635b = fundraiserGuestListAdapter2;
    }

    public final void m13051c(Bundle bundle) {
        super.c(bundle);
        Class cls = FundraiserGuestListFragment.class;
        m13047a((Object) this, getContext());
        this.f12636c = this.s.getString("fundraiser_campaign_id");
        this.f12637d = FundraiserGuestListTab.fromString(this.s.getString("FUNDRAISER_GUEST_LIST_TAB"));
        this.f12634a.m13046a(this.f12636c, this.f12637d, this, true);
        this.f12634a.m13045a();
    }

    public final View m13048a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1613008622);
        View inflate = layoutInflater.inflate(2130904560, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1814537054, a);
        return inflate;
    }

    public final void m13049a(View view, Bundle bundle) {
        super.a(view, bundle);
        BetterListView betterListView = (BetterListView) e(2131562453);
        betterListView.setAdapter(this.f12635b);
        betterListView.setVisibility(0);
        this.f12634a.m13045a();
        betterListView.setOnScrollListener(new C14931(this));
    }

    public final void mo362a(ImmutableList<FundraiserGuestListUser> immutableList) {
        this.f12635b.m13033a(immutableList);
    }
}
