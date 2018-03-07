package com.facebook.nearby.v2.resultlist;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ProgressBar;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQL.NearbyPlacesHugeResultsSearchQueryV2String;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.Photo320FragmentModel;
import com.facebook.nearby.v2.resultlist.FetchResultListRequestParamsFactory.FetchResultListRequestParamsRequestType;
import com.facebook.nearby.v2.resultlist.FetchResultListRequestRunner.C16821;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.OnResultListModelUpdatedListener;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.Options;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLogger;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLogger.TapAction;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLoggerProvider;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListData;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.nearby.v2.resultlist.util.ListViewScrollHelper;
import com.facebook.nearby.v2.resultlist.util.ListViewScrollHelper.OnScrollDirectionChangeListener;
import com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView.ActionBarItemType;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: debug_toasts */
public class NearbyPlacesV2ResultListFragment extends NearbyPlacesV2ResultsFragment implements OnScrollDirectionChangeListener {
    public static final Class<?> f15821e = NearbyPlacesV2ResultListFragment.class;
    @Inject
    public FetchResultListRequestRunner f15822a;
    public String aA = null;
    private NearbyPlacesSearchDataProvider al;
    public NearbyPlacesV2Fragment am;
    public OnResultListModelUpdatedListener an;
    private ListViewScrollHelper ao;
    public OnScrollDirectionChangeListener ap;
    public ViewGroup aq;
    private ViewGroup ar;
    private ProgressBar as;
    public BetterListView at;
    public NearbyPlacesResultListAdapter au;
    public NearbyPlacesResultListModel av;
    public ResultListViewState aw;
    public NearbyPlacesResultListLogger ax;
    private boolean ay = false;
    public final Set<String> az = new HashSet();
    @Inject
    public NearbyPlacesV2PageActionHandler f15823b;
    @Inject
    public NearbyPlacesResultListLoggerProvider f15824c;
    @Inject
    public NearbyPlacesResultListAdapterProvider f15825d;
    private final C16901 f15826f = new C16901(this);
    private final OnScrollListener f15827g = new C16912(this);
    private final C16923 f15828h = new C16923(this);
    public NearbyPlacesFragmentModel f15829i;

    /* compiled from: debug_toasts */
    public class C16901 implements FutureCallback {
        final /* synthetic */ NearbyPlacesV2ResultListFragment f15815a;

        C16901(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment) {
            this.f15815a = nearbyPlacesV2ResultListFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            NearbyPlacesResultListData nearbyPlacesResultListData = (NearbyPlacesResultListData) obj;
            if (nearbyPlacesResultListData != null) {
                this.f15815a.aq.setVisibility(nearbyPlacesResultListData.m18709o() ? 8 : 0);
                NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment = this.f15815a;
                nearbyPlacesV2ResultListFragment.av.m18710a(nearbyPlacesResultListData);
                nearbyPlacesV2ResultListFragment.au.m18638a(nearbyPlacesV2ResultListFragment.av);
                AdapterDetour.a(nearbyPlacesV2ResultListFragment.au, -1667402381);
                if (nearbyPlacesV2ResultListFragment.an != null) {
                    nearbyPlacesV2ResultListFragment.an.mo963a(nearbyPlacesV2ResultListFragment.av);
                }
                nearbyPlacesV2ResultListFragment.ax.m18690a();
                nearbyPlacesV2ResultListFragment.ax.m18692b();
                NearbyPlacesV2ResultListFragment.m18674a(this.f15815a, ResultListViewState.DISPLAYING_RESULTS);
                if (nearbyPlacesResultListData == null || nearbyPlacesResultListData.f15857l) {
                    this.f15815a.at.smoothScrollToPosition(0);
                }
            }
        }

        public void onFailure(Throwable th) {
            NearbyPlacesV2ResultListFragment.m18674a(this.f15815a, ResultListViewState.DISPLAYING_RESULTS);
        }
    }

    /* compiled from: debug_toasts */
    class C16912 implements OnScrollListener {
        final /* synthetic */ NearbyPlacesV2ResultListFragment f15816a;

        C16912(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment) {
            this.f15816a = nearbyPlacesV2ResultListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2) {
                this.f15816a.ax.m18693c();
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3 && this.f15816a.aw != ResultListViewState.LOADING_PAGINATION) {
                Preconditions.checkNotNull(this.f15816a.av);
                if (this.f15816a.av.f15863c.f15858m) {
                    NearbyPlacesV2ResultListFragment.m18673a(this.f15816a, FetchResultListRequestParamsRequestType.PAGINATION_REQUEST);
                }
            }
        }
    }

    /* compiled from: debug_toasts */
    public class C16923 {
        public final /* synthetic */ NearbyPlacesV2ResultListFragment f15817a;

        C16923(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment) {
            this.f15817a = nearbyPlacesV2ResultListFragment;
        }

        public final void m18666a(int i) {
            NearbyPlacesPlaceModel g = NearbyPlacesV2ResultListFragment.m18676g(this.f15817a, i);
            if (g != null) {
                this.f15817a.m18670a(i, g, TapAction.CELL, null, null);
                this.f15817a.f15823b.m18728a(this.f15817a.getContext(), g, null, this.f15817a.f15829i, this.f15817a, NearbyPlacesV2ResultListFragment.f15821e);
            }
        }

        public final void m18667a(int i, int i2) {
            NearbyPlacesPlaceModel g = NearbyPlacesV2ResultListFragment.m18676g(this.f15817a, i);
            if (g != null) {
                this.f15817a.m18670a(i, g, TapAction.PHOTO_IN_COLLECTION, Integer.valueOf(i2), Integer.valueOf(g.m17748l().size()));
                NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment = this.f15817a;
                boolean z = true;
                Preconditions.checkArgument(i2 >= 0);
                NearbyPlacesPlaceModel g2 = NearbyPlacesV2ResultListFragment.m18676g(nearbyPlacesV2ResultListFragment, i);
                Preconditions.checkNotNull(g2, "Null place model cannot have hscroll photos");
                ImmutableList<Photo320FragmentModel> l = g2.m17748l();
                if (i2 >= l.size()) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                Builder builder = new Builder();
                for (Photo320FragmentModel photo320FragmentModel : l) {
                    Preconditions.checkNotNull(photo320FragmentModel.m18301g());
                    builder.c(photo320FragmentModel.m18301g());
                }
                ImmutableList b = builder.b();
                nearbyPlacesV2ResultListFragment.f15823b.m18730a(b, (String) b.get(i2), nearbyPlacesV2ResultListFragment.getContext());
                if (this.f15817a.am != null) {
                    this.f15817a.am.as.f15299a.m17731e();
                }
            }
        }

        public final void m18668a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel) {
            this.f15817a.az.add(nearbyPlacesPlaceModel.m17738b());
            this.f15817a.aA = null;
        }
    }

    /* compiled from: debug_toasts */
    public /* synthetic */ class C16934 {
        public static final /* synthetic */ int[] f15818a = new int[ActionBarItemType.values().length];
        static final /* synthetic */ int[] f15819b = new int[FetchResultListRequestParamsRequestType.values().length];
        static final /* synthetic */ int[] f15820c = new int[ResultListViewState.values().length];

        static {
            try {
                f15820c[ResultListViewState.LOADING_INITIAL_RESULTS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15820c[ResultListViewState.LOADING_PAGINATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15820c[ResultListViewState.DISPLAYING_RESULTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15820c[ResultListViewState.COUNT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15819b[FetchResultListRequestParamsRequestType.PAGINATION_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15819b[FetchResultListRequestParamsRequestType.RESULT_LIST_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15819b[FetchResultListRequestParamsRequestType.MAP_REGION_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f15819b[FetchResultListRequestParamsRequestType.FILTER_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f15818a[ActionBarItemType.DISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f15818a[ActionBarItemType.LIKES.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f15818a[ActionBarItemType.REVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f15818a[ActionBarItemType.OPEN_NOW.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f15818a[ActionBarItemType.PRICE.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* compiled from: debug_toasts */
    public enum ResultListViewState {
        LOADING_INITIAL_RESULTS,
        LOADING_PAGINATION,
        DISPLAYING_RESULTS,
        COUNT
    }

    public static void m18675a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment = (NearbyPlacesV2ResultListFragment) obj;
        FetchResultListRequestRunner fetchResultListRequestRunner = new FetchResultListRequestRunner(SimpleExecutor.b(fbInjector), GraphQLQueryExecutor.a(fbInjector));
        NearbyPlacesV2PageActionHandler a = NearbyPlacesV2PageActionHandler.m18723a(fbInjector);
        NearbyPlacesResultListLoggerProvider nearbyPlacesResultListLoggerProvider = (NearbyPlacesResultListLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NearbyPlacesResultListLoggerProvider.class);
        NearbyPlacesResultListAdapterProvider nearbyPlacesResultListAdapterProvider = (NearbyPlacesResultListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NearbyPlacesResultListAdapterProvider.class);
        nearbyPlacesV2ResultListFragment.f15822a = fetchResultListRequestRunner;
        nearbyPlacesV2ResultListFragment.f15823b = a;
        nearbyPlacesV2ResultListFragment.f15824c = nearbyPlacesResultListLoggerProvider;
        nearbyPlacesV2ResultListFragment.f15825d = nearbyPlacesResultListAdapterProvider;
    }

    public static NearbyPlacesV2ResultListFragment m18669a(Options options) {
        NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment = new NearbyPlacesV2ResultListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("options", options);
        nearbyPlacesV2ResultListFragment.g(bundle);
        return nearbyPlacesV2ResultListFragment;
    }

    public final void m18683c(Bundle bundle) {
        super.c(bundle);
        Class cls = NearbyPlacesV2ResultListFragment.class;
        m18675a((Object) this, getContext());
        Preconditions.checkNotNull(this.f15829i);
        Preconditions.checkNotNull(this.al);
        Preconditions.checkArgument(this.al.mo918c().m17761h());
        Options ar = ar();
        if (bundle == null) {
            this.av = new NearbyPlacesResultListModel(ar.f15840e);
            this.aw = ResultListViewState.LOADING_INITIAL_RESULTS;
        } else {
            this.av = (NearbyPlacesResultListModel) bundle.getParcelable("nearby_places_result_list_model");
            this.aw = (ResultListViewState) bundle.getSerializable("nearby_places_result_list_view_state");
        }
        this.au = new NearbyPlacesResultListAdapter(ar, IdBasedSingletonScopeProvider.b(this.f15825d, 8671));
        this.au.m18638a(this.av);
        this.au.f15801d = this.f15828h;
        this.ax = this.f15824c.m18694a(this.f15829i, this.al, this.av);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1745412859);
        super.mi_();
        if (this.av.m18712c() && this.ax != null) {
            this.ax.m18690a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2133695988, a);
    }

    public final void m18684d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -91195844);
        super.d(bundle);
        m18674a(this, this.aw);
        NearbyPlacesSearchDataModel c = this.al.mo918c();
        if (!(c.f15307d == null && c.f15306c == null)) {
            m18673a(this, FetchResultListRequestParamsRequestType.RESULT_LIST_REQUEST);
        }
        if (this.ay) {
            this.ay = false;
            mo964e();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -702690921, a);
    }

    public static void m18672a(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment, NearbyPlacesPlaceModel nearbyPlacesPlaceModel) {
        nearbyPlacesV2ResultListFragment.f15823b.m18732a(nearbyPlacesPlaceModel.m17738b(), nearbyPlacesPlaceModel.m17737a(), nearbyPlacesV2ResultListFragment.getContext(), SafeUUIDGenerator.a().toString());
    }

    public final View m18677a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1850969272);
        if (ar().f15836a) {
            i = 2130905405;
        } else {
            i = 2130905398;
        }
        this.ar = (ViewGroup) layoutInflater.inflate(i, viewGroup, false);
        this.at = (BetterListView) this.ar.findViewById(2131564127);
        this.as = (ProgressBar) this.ar.findViewById(2131564129);
        this.aq = (ViewGroup) this.ar.findViewById(2131564128);
        View view = this.ar;
        LogUtils.f(1681741006, a);
        return view;
    }

    public final void m18678a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ao = new ListViewScrollHelper(this.at);
        this.ao.f15866b = this;
        this.at.setAdapter(this.au);
        this.at.setOnScrollListener(this.f15827g);
    }

    public final void m18686e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("nearby_places_result_list_model", this.av);
        bundle.putSerializable("nearby_places_result_list_view_state", this.aw);
    }

    public final String am_() {
        return "nearby_places_result_list";
    }

    public final void mo960a(NearbyPlacesFragmentModel nearbyPlacesFragmentModel) {
        this.f15829i = nearbyPlacesFragmentModel;
    }

    public final void mo961a(NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider) {
        this.al = nearbyPlacesSearchDataProvider;
    }

    public final void mo964e() {
        if (this.av == null) {
            this.ay = true;
            return;
        }
        NearbyPlacesSearchDataModel c = this.al.mo918c();
        if (!c.m17761h()) {
            return;
        }
        if (!c.f15305b || c.f15306c != null) {
            m18673a(this, FetchResultListRequestParamsRequestType.RESULT_LIST_REQUEST);
        }
    }

    public final void mo959a(@Nullable NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
        this.am = nearbyPlacesV2Fragment;
    }

    public final void mo962a(@Nullable OnResultListModelUpdatedListener onResultListModelUpdatedListener) {
        this.an = onResultListModelUpdatedListener;
    }

    public final void w_(int i) {
        if (this.ap != null) {
            this.ap.w_(i);
        }
    }

    private String as() {
        if (this.aA == null) {
            this.aA = TextUtils.join(", ", this.az);
        }
        return this.aA;
    }

    public static NearbyPlacesPlaceModel m18676g(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment, int i) {
        boolean z;
        boolean z2 = false;
        Preconditions.checkArgument(i >= 0);
        List a = nearbyPlacesV2ResultListFragment.au.m18637a();
        if (a == null || i < 0) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (i < a.size() || (i >= a.size() && nearbyPlacesV2ResultListFragment.au.m18639b())) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        if (i < a.size() || !nearbyPlacesV2ResultListFragment.av.f15863c.f15858m) {
            return (NearbyPlacesPlaceModel) a.get(i);
        }
        return null;
    }

    public static void m18673a(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment, FetchResultListRequestParamsRequestType fetchResultListRequestParamsRequestType) {
        ResultListViewState resultListViewState;
        Preconditions.checkNotNull(nearbyPlacesV2ResultListFragment.f15822a);
        Preconditions.checkNotNull(nearbyPlacesV2ResultListFragment.av);
        switch (C16934.f15819b[fetchResultListRequestParamsRequestType.ordinal()]) {
            case 1:
                boolean z;
                NearbyPlacesResultListData nearbyPlacesResultListData = nearbyPlacesV2ResultListFragment.av.f15863c;
                if (nearbyPlacesResultListData == null || !nearbyPlacesResultListData.f15858m || Strings.isNullOrEmpty(nearbyPlacesResultListData.f15856k)) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkArgument(z);
                resultListViewState = ResultListViewState.LOADING_PAGINATION;
                break;
            case 2:
                nearbyPlacesV2ResultListFragment.az.clear();
                nearbyPlacesV2ResultListFragment.aA = null;
                resultListViewState = ResultListViewState.LOADING_INITIAL_RESULTS;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        nearbyPlacesV2ResultListFragment.f15822a.f15791a.c();
        FetchResultListRequestRunner fetchResultListRequestRunner = nearbyPlacesV2ResultListFragment.f15822a;
        NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider = nearbyPlacesV2ResultListFragment.al;
        NearbyPlacesResultListModel nearbyPlacesResultListModel = nearbyPlacesV2ResultListFragment.av;
        C16901 c16901 = nearbyPlacesV2ResultListFragment.f15826f;
        FetchResultListRequestParams fetchResultListRequestParams = null;
        Preconditions.checkNotNull(nearbyPlacesSearchDataProvider);
        Preconditions.checkNotNull(nearbyPlacesResultListModel);
        NearbyPlacesSearchDataModel c = nearbyPlacesSearchDataProvider.mo918c();
        if (c != null) {
            switch (fetchResultListRequestParamsRequestType) {
                case FILTER_REQUEST:
                    fetchResultListRequestParams = FetchResultListRequestParamsFactory.m18617a(nearbyPlacesResultListModel);
                    break;
                case RESULT_LIST_REQUEST:
                    fetchResultListRequestParams = FetchResultListRequestParamsFactory.m18616a(c, nearbyPlacesResultListModel);
                    break;
                case PAGINATION_REQUEST:
                    fetchResultListRequestParams = FetchResultListRequestParamsFactory.m18620b(nearbyPlacesResultListModel);
                    break;
                case MAP_REGION_REQUEST:
                    fetchResultListRequestParams = FetchResultListRequestParamsFactory.m18619b(c, nearbyPlacesResultListModel);
                    break;
                default:
                    break;
            }
        }
        FetchResultListRequestParams fetchResultListRequestParams2 = fetchResultListRequestParams;
        if (fetchResultListRequestParams2 != null) {
            NearbyPlacesHugeResultsSearchQueryV2String a = FetchResultListRequestRunner.m18623a(fetchResultListRequestParams2);
            if (a != null) {
                fetchResultListRequestRunner.f15791a.a(GraphQLQueryExecutor.a(fetchResultListRequestRunner.f15792b.a(GraphQLRequest.a(a))), new C16821(fetchResultListRequestRunner, fetchResultListRequestParams2, c16901));
            }
        }
        m18674a(nearbyPlacesV2ResultListFragment, resultListViewState);
    }

    public static void m18674a(NearbyPlacesV2ResultListFragment nearbyPlacesV2ResultListFragment, ResultListViewState resultListViewState) {
        switch (C16934.f15820c[resultListViewState.ordinal()]) {
            case 1:
                nearbyPlacesV2ResultListFragment.as.setVisibility(0);
                nearbyPlacesV2ResultListFragment.at.setVisibility(8);
                break;
            case 2:
                nearbyPlacesV2ResultListFragment.as.setVisibility(8);
                nearbyPlacesV2ResultListFragment.at.setVisibility(0);
                break;
            case 3:
                nearbyPlacesV2ResultListFragment.as.setVisibility(8);
                nearbyPlacesV2ResultListFragment.at.setVisibility(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid view state for NearbyPlaces Fragment!");
        }
        nearbyPlacesV2ResultListFragment.aw = resultListViewState;
    }

    private void m18670a(int i, NearbyPlacesPlaceModel nearbyPlacesPlaceModel, TapAction tapAction, @Nullable Integer num, @Nullable Integer num2) {
        this.ax.m18691a(nearbyPlacesPlaceModel.m17738b(), i, this.av.f15863c.m18703i().size(), false, tapAction, num, num2, as());
    }
}
