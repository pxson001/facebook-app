package com.facebook.search.results.fragment.places;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.ImpressionSource;
import com.facebook.nearby.v2.model.LocationStatusUtil;
import com.facebook.nearby.v2.model.LocationStatusUtil.LocationStatus;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.OnResultListModelUpdatedListener;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.Options;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.Options.Builder;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SENSOR */
public class SearchResultsPlacesFragment extends SearchResultsBaseFragment implements OnResultListModelUpdatedListener {
    private NearbyPlacesV2ResultsFragment al;
    private NearbyPlacesFragmentModel am;
    private boolean an = false;
    private boolean ao = false;
    public Options ap = null;
    @Inject
    public QeAccessor f23079h;
    @Inject
    public LocationStatusUtil f23080i;

    public static void m26744a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SearchResultsPlacesFragment searchResultsPlacesFragment = (SearchResultsPlacesFragment) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        LocationStatusUtil a = LocationStatusUtil.m17732a(injectorLike);
        searchResultsPlacesFragment.f23079h = qeAccessor;
        searchResultsPlacesFragment.f23080i = a;
    }

    public final void mo1290c(Bundle bundle) {
        super.mo1290c(bundle);
        Bundle bundle2 = this.s;
        ImpressionSource impressionSource = (bundle2 == null || !bundle2.getBoolean("tab_bar_tap", false)) ? ImpressionSource.open : ImpressionSource.tab_bar_tap;
        Class cls = SearchResultsPlacesFragment.class;
        m26744a(this, getContext());
        if (bundle == null) {
            LocationStatus a = this.f23080i.m17734a(o());
            SearchResultsMutableContext searchResultsMutableContext = this.f22960h;
            this.am = new NearbyPlacesFragmentModel(EntryPoint.SEARCH_SUGGESTION, impressionSource, a, searchResultsMutableContext);
            NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel = this.am.f15300b;
            nearbyPlacesSearchDataModel.f15311h = new NearbyPlacesResultListQueryTopic(searchResultsMutableContext.mo1211a(), searchResultsMutableContext.mo1212b());
            nearbyPlacesSearchDataModel.f15305b = false;
        } else {
            this.am = (NearbyPlacesFragmentModel) bundle.getParcelable("nearby_places_fragment_model_state");
        }
        Preconditions.checkNotNull(this.am);
        Preconditions.checkNotNull(this.am.f15300b);
        FragmentManager s = s();
        this.al = (NearbyPlacesV2ResultsFragment) s.a("resultsFragment");
        if (this.al == null) {
            if (this.ap == null) {
                boolean a2 = this.f23079h.a(ExperimentsForSearchAbTestModule.ac, false);
                boolean a3 = this.f23079h.a(ExperimentsForSearchAbTestModule.ag, false);
                boolean a4 = this.f23079h.a(ExperimentsForSearchAbTestModule.ad, false);
                boolean a5 = this.f23079h.a(ExperimentsForSearchAbTestModule.af, false);
                boolean a6 = this.f23079h.a(ExperimentsForSearchAbTestModule.ae, false);
                Builder builder = new Builder();
                builder.f15830a = true;
                builder = builder;
                builder.f15831b = a2;
                Builder builder2 = builder;
                builder2.f15832c = a3;
                builder2 = builder2;
                builder2.f15833d = a4;
                builder2 = builder2;
                builder2.f15834e = a5;
                builder2 = builder2;
                builder2.f15835f = a6;
                this.ap = builder2.m18687a();
            }
            this.al = NearbyPlacesV2ResultsFragment.m18640b(this.ap);
            s.a().a(2131558644, this.al, "resultsFragment").b();
        }
        this.al.mo960a(this.am);
        this.al.mo961a(this.am);
        this.al.mo962a((OnResultListModelUpdatedListener) this);
    }

    public final View m26745a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -560590589);
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(getContext());
        customFrameLayout.setId(2131558644);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1108906314, a);
        return customFrameLayout;
    }

    public final void m26748d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1129026162);
        super.d(bundle);
        if (this.ao) {
            this.ao = false;
            aq();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1258217398, a);
    }

    public final void mo1301e(Bundle bundle) {
        super.mo1301e(bundle);
        bundle.putParcelable("nearby_places_fragment_model_state", this.am);
    }

    protected final void aq() {
        this.an = false;
        if (this.al == null) {
            this.ao = true;
        } else {
            this.al.mo964e();
        }
    }

    protected final boolean ar() {
        return this.an;
    }

    public final String am_() {
        return "graph_search_results_page_place";
    }

    public final void mo963a(NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        this.an = true;
    }
}
