package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLFundraiserSupportersConnectionType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ultralight.Inject;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import java.util.Arrays;
import java.util.List;

/* compiled from: PAGE_PHOTOS_OF */
public class FundraiserGuestListFrameFragment extends FbFragment {
    @Inject
    public FbTitleBarSupplier f12640a;
    public FundraiserGuestListPagerAdapter f12641b;
    public List<FundraiserGuestListTab> f12642c;

    /* compiled from: PAGE_PHOTOS_OF */
    public /* synthetic */ class C14941 {
        public static final /* synthetic */ int[] f12639a = new int[GraphQLFundraiserSupportersConnectionType.values().length];

        static {
            try {
                f12639a[GraphQLFundraiserSupportersConnectionType.DONATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12639a[GraphQLFundraiserSupportersConnectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12639a[GraphQLFundraiserSupportersConnectionType.INVITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12639a[GraphQLFundraiserSupportersConnectionType.SHARED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void m13053a(Object obj, Context context) {
        ((FundraiserGuestListFrameFragment) obj).f12640a = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(FbInjector.get(context));
    }

    public final void m13056c(Bundle bundle) {
        super.c(bundle);
        Class cls = FundraiserGuestListFrameFragment.class;
        m13053a((Object) this, getContext());
        this.f12642c = Arrays.asList(new FundraiserGuestListTab[]{FundraiserGuestListTab.DONATED, FundraiserGuestListTab.INVITED, FundraiserGuestListTab.SHARED});
        this.f12641b = new FundraiserGuestListPagerAdapter(s(), getContext(), this.f12642c, this.s.getString("fundraiser_campaign_id"));
    }

    public final View m13054a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -188081275);
        View inflate = layoutInflater.inflate(2130904561, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1964832456, a);
        return inflate;
    }

    public final void m13055a(View view, Bundle bundle) {
        FundraiserGuestListTab fundraiserGuestListTab;
        super.a(view, bundle);
        ViewPager viewPager = (ViewPager) e(2131562456);
        viewPager.setAdapter(this.f12641b);
        FundraiserGuestListPagerAdapter fundraiserGuestListPagerAdapter = this.f12641b;
        for (int i = 0; i < fundraiserGuestListPagerAdapter.f12679c.size(); i++) {
            FbFragment[] fbFragmentArr = fundraiserGuestListPagerAdapter.f12678b;
            String str = fundraiserGuestListPagerAdapter.f12681e;
            fundraiserGuestListTab = (FundraiserGuestListTab) fundraiserGuestListPagerAdapter.f12679c.get(i);
            Bundle bundle2 = new Bundle();
            bundle2.putString("FUNDRAISER_GUEST_LIST_TAB", fundraiserGuestListTab.toString());
            bundle2.putString("fundraiser_campaign_id", str);
            FundraiserGuestListFragment fundraiserGuestListFragment = new FundraiserGuestListFragment();
            fundraiserGuestListFragment.g(bundle2);
            fbFragmentArr[i] = fundraiserGuestListFragment;
        }
        ((TabbedViewPagerIndicator) e(2131562455)).setViewPager(viewPager);
        List list = this.f12642c;
        GraphQLFundraiserSupportersConnectionType graphQLFundraiserSupportersConnectionType = (GraphQLFundraiserSupportersConnectionType) this.s.get("extra_view_fundraiser_supporters_connection_type");
        if (graphQLFundraiserSupportersConnectionType != null) {
            switch (C14941.f12639a[graphQLFundraiserSupportersConnectionType.ordinal()]) {
                case 1:
                case 2:
                    fundraiserGuestListTab = FundraiserGuestListTab.DONATED;
                    break;
                case 3:
                    fundraiserGuestListTab = FundraiserGuestListTab.INVITED;
                    break;
                case 4:
                    fundraiserGuestListTab = FundraiserGuestListTab.SHARED;
                    break;
            }
        }
        fundraiserGuestListTab = FundraiserGuestListTab.DONATED;
        viewPager.setCurrentItem(list.indexOf(fundraiserGuestListTab));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2038814346);
        super.mi_();
        FbTitleBar fbTitleBar = (FbTitleBar) this.f12640a.get();
        if (fbTitleBar != null) {
            fbTitleBar.setTitle(2131242344);
            if (fbTitleBar instanceof Fb4aTitleBar) {
                ((Fb4aTitleBar) fbTitleBar).setSearchButtonVisible(false);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1312119746, a);
    }
}
