package com.facebook.search.results.fragment.pps;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.SeeMoreAnalyticHelper;
import com.facebook.search.results.fragment.pps.SeeMoreResultsListFragment.C24771;
import com.facebook.search.results.util.SearchResultsThemeHelper;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;

/* compiled from: SEE_PAGE_ADS_AND_PROMOTIONS */
public class SeeMoreResultsPagerAdapterProvider extends AbstractAssistedProvider<SeeMoreResultsPagerAdapter> {
    public final SeeMoreResultsPagerAdapter m26780a(FragmentManager fragmentManager, ViewPager viewPager, C24771 c24771, SeeMoreAnalyticHelper seeMoreAnalyticHelper) {
        SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter = new SeeMoreResultsPagerAdapter((Context) getInstance(Context.class), IdBasedProvider.a(this, 10577), (SimpleAndGraphSearchFetchHelperProvider) getOnDemandAssistedProviderForStaticDi(SimpleAndGraphSearchFetchHelperProvider.class), fragmentManager, viewPager, c24771, seeMoreAnalyticHelper, GraphSearchTitleSearchBoxSupplier.m28576a(this), SearchResultsThemeHelper.m28572a((InjectorLike) this));
        seeMoreResultsPagerAdapter.f23106a = GatekeeperStoreImplMethodAutoProvider.a(this);
        return seeMoreResultsPagerAdapter;
    }
}
