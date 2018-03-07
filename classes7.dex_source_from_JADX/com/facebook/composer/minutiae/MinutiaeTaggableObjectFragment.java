package com.facebook.composer.minutiae;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL.FetchTaggableSuggestionsAtPlaceQueryString;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableSuggestionsAtPlaceQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.MinutiaeTaggableObjectsModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.Builder;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger;
import com.facebook.composer.minutiae.perf.MinutiaePerformanceLogger;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.protocol.FetchTaggableSuggestionsAtPlaceParams;
import com.facebook.composer.minutiae.protocol.MinutiaeObjectsDataFetcher;
import com.facebook.composer.minutiae.protocol.MinutiaeObjectsDataFetcherProvider;
import com.facebook.composer.minutiae.protocol.MinutiaeTypeaheadGraphQLCacheKeySerializer;
import com.facebook.composer.minutiae.protocol.TaggableSuggestionsAtPlaceFetcher;
import com.facebook.composer.minutiae.protocol.TaggableSuggestionsAtPlaceFetcher.C01691;
import com.facebook.composer.minutiae.ridge.RidgeFragmentController;
import com.facebook.composer.minutiae.ridge.RidgeFragmentControllerProvider;
import com.facebook.composer.minutiae.ridge.RidgeHost;
import com.facebook.composer.minutiae.ridge.RidgeHostActivity;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.util.MinutiaeObjectPickerState;
import com.facebook.composer.minutiae.view.MinutiaeTaggableObjectViewController.SuggestionCallback;
import com.facebook.composer.minutiae.view.RidgeRefreshableListViewContainer;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLTaggableActivitySuggestionMechanism;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewStub;
import com.facebook.widget.CustomViewStubHelper;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.sectionedadapter.SectionedAdapterForListView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Random;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: total_visits */
public class MinutiaeTaggableObjectFragment extends FbFragment implements MinutiaeFragment, RidgeHost, SuggestionCallback {
    public ObjectSelectedListener f1417a;
    public MinutiaeSuggestionAdapter aA;
    public MinutiaeTaggableActivity aB;
    public String aC;
    public String aD;
    public String aE;
    public int aF;
    private MinutiaeTypeaheadEventBuilder aG;
    public ActivityPickerAnalyticsLogger al;
    public MinutiaeObjectPickerPerformanceLogger am;
    private RidgeFragmentControllerProvider an;
    public Optional<RidgeFragmentController> ao;
    private FbLocationCache ap;
    private Provider<TriState> aq;
    public BetterListView ar;
    public ProgressBar as;
    public CustomLinearLayout at;
    public SearchEditText au;
    public CustomViewStubHelper<GenericErrorView> av;
    public String aw;
    public MinutiaeObjectPickerState ax;
    public MinutiaeConfiguration ay;
    public MinutiaeTaggableObjectAdapter az;
    private MinutiaeCustomIconPickerLauncher f1418b;
    private MinutiaeObjectsDataFetcherProvider f1419c;
    private TasksManager<Task> f1420d;
    private AbstractFbErrorReporter f1421e;
    private FbSharedPreferences f1422f;
    private AnalyticsLogger f1423g;
    private MinutiaeObjectsDataFetcher f1424h;
    public TaggableSuggestionsAtPlaceFetcher f1425i;

    /* compiled from: total_visits */
    public class C01291 implements OnScrollListener {
        final /* synthetic */ MinutiaeTaggableObjectFragment f1404a;

        public C01291(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
            this.f1404a = minutiaeTaggableObjectFragment;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f1404a.ax.f1850b != i) {
                Object obj;
                if (this.f1404a.ax.f1850b == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f1404a.al;
                    String str = this.f1404a.ay.f1835a;
                    activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_first_scroll", str).a(this.f1404a.aw).a);
                }
                this.f1404a.ax.f1850b = i;
                if (this.f1404a.au != null) {
                    this.f1404a.au.c();
                }
            }
            if (this.f1404a.az.m1472a() != -1) {
                Object obj2;
                MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment = this.f1404a;
                int a = this.f1404a.az.m1472a();
                if (a == -1 || a < i || a >= i + i2) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    this.f1404a.az.m1478b(this.f1404a.aB);
                }
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* compiled from: total_visits */
    public class C01302 implements TextWatcher {
        final /* synthetic */ MinutiaeTaggableObjectFragment f1405a;

        public C01302(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
            this.f1405a = minutiaeTaggableObjectFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f1405a.m1508a(editable);
        }
    }

    /* compiled from: total_visits */
    public class C01313 implements OnEditorActionListener {
        final /* synthetic */ MinutiaeTaggableObjectFragment f1406a;

        public C01313(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
            this.f1406a = minutiaeTaggableObjectFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.f1406a.au.c();
            return true;
        }
    }

    /* compiled from: total_visits */
    public class C01324 implements OnDispatchDrawListener {
        final /* synthetic */ MinutiaeTaggableObjectFragment f1407a;

        public C01324(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
            this.f1407a = minutiaeTaggableObjectFragment;
        }

        public final boolean m1483a() {
            this.f1407a.am.m1654b(4325383, "minutiae_object_picker_time_to_search_shown");
            return true;
        }
    }

    /* compiled from: total_visits */
    class C01368 implements OnClickListener {
        final /* synthetic */ MinutiaeTaggableObjectFragment f1414a;

        C01368(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
            this.f1414a = minutiaeTaggableObjectFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1387122066);
            this.f1414a.m1497a(this.f1414a.aE);
            Logger.a(2, EntryType.UI_INPUT_END, -1046990405, a);
        }
    }

    /* compiled from: total_visits */
    enum Task {
        SEARCH
    }

    public static void m1496a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MinutiaeTaggableObjectFragment) obj).m1495a(TasksManager.b(injectorLike), TaggableSuggestionsAtPlaceFetcher.m1709a(injectorLike), (MinutiaeObjectsDataFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MinutiaeObjectsDataFetcherProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 637), ActivityPickerAnalyticsLogger.m1538a(injectorLike), MinutiaeObjectPickerPerformanceLogger.m1656a(injectorLike), (RidgeFragmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RidgeFragmentControllerProvider.class), FbLocationCache.b(injectorLike));
    }

    public final Optional<RidgeRefreshableListViewContainer> at() {
        return Absent.INSTANCE;
    }

    @Inject
    private void m1495a(TasksManager tasksManager, TaggableSuggestionsAtPlaceFetcher taggableSuggestionsAtPlaceFetcher, MinutiaeObjectsDataFetcherProvider minutiaeObjectsDataFetcherProvider, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, AnalyticsLogger analyticsLogger, Provider<TriState> provider, ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger, MinutiaeObjectPickerPerformanceLogger minutiaeObjectPickerPerformanceLogger, RidgeFragmentControllerProvider ridgeFragmentControllerProvider, FbLocationCache fbLocationCache) {
        this.f1420d = tasksManager;
        this.f1425i = taggableSuggestionsAtPlaceFetcher;
        this.f1421e = fbErrorReporter;
        this.f1422f = fbSharedPreferences;
        this.f1423g = analyticsLogger;
        this.f1419c = minutiaeObjectsDataFetcherProvider;
        this.aq = provider;
        this.al = activityPickerAnalyticsLogger;
        this.am = minutiaeObjectPickerPerformanceLogger;
        this.an = ridgeFragmentControllerProvider;
        this.ap = fbLocationCache;
    }

    public final void m1514c(@Nullable Bundle bundle) {
        String c;
        super.c(bundle);
        Class cls = MinutiaeTaggableObjectFragment.class;
        m1496a((Object) this, getContext());
        this.ay = (MinutiaeConfiguration) this.s.getParcelable("minutiae_configuration");
        this.aB = this.ay.f1839e;
        this.aw = this.aB == null ? this.ay.m1817g().g().a() : this.aB.l();
        if (this.aB == null) {
            c = this.ay.m1817g().g().c();
        } else {
            c = this.aB.o();
        }
        this.aC = c;
        this.aG = new MinutiaeTypeaheadEventBuilder(this.ay.f1835a);
        if (bundle != null) {
            this.aE = bundle.getString("search_query");
            this.aF = bundle.getInt("session_id");
        } else {
            this.aF = new Random().nextInt();
        }
        this.f1424h = this.f1419c.m1685a(Integer.valueOf(this.aF), this.ay.f1840f != null ? this.ay.f1840f.cf_() : null, this.ay.f1847m != null ? this.ay.f1847m : "composer");
        this.az = new MinutiaeTaggableObjectAdapter(getContext(), this.f1424h, this.f1421e, this.am, this);
        this.aA = new MinutiaeSuggestionAdapter(getContext(), this.ay, this.al, this);
        if (o().getIntent().hasExtra("composer_location")) {
            this.f1424h.f1690g = (Location) o().getIntent().getParcelableExtra("composer_location");
        } else {
            ImmutableLocation a = this.ap.a();
            if (a != null) {
                this.f1424h.f1690g = a.l();
            }
        }
        m1497a(this.aE);
    }

    public final void m1516e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("search_query", this.aE);
        bundle.putInt("session_id", this.aF);
    }

    public final View m1507a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1840832835);
        this.ax = new MinutiaeObjectPickerState();
        View inflate = layoutInflater.inflate(2130903704, null);
        this.ar = (BetterListView) inflate.findViewById(16908298);
        this.ar.setEmptyView(inflate.findViewById(16908292));
        this.ar.setOnScrollListener(new C01291(this));
        this.ar.setAdapter(new SectionedAdapterForListView(ImmutableList.of(this.aA, this.az)));
        if (!this.ay.f1845k) {
            ((ViewStub) FindViewUtil.b(inflate, 2131560572)).inflate();
            this.at = (CustomLinearLayout) FindViewUtil.b(inflate, 2131560574);
            this.at.setVisibility(0);
            this.as = (ProgressBar) FindViewUtil.b(inflate, 2131560582);
            this.au = (SearchEditText) FindViewUtil.b(inflate, 2131560581);
            this.au.addTextChangedListener(new C01302(this));
            this.au.setOnEditorActionListener(new C01313(this));
            if (this.aE != null) {
                this.au.setText(this.aE);
            }
            this.au.setHint(this.aC);
            this.at.a(new C01324(this));
        }
        this.av = CustomViewStubHelper.a((CustomViewStub) FindViewUtil.b(inflate, 2131560575));
        if (au()) {
            RidgeFragmentController a2 = this.an.m1729a(this);
            this.ao = Optional.of(a2);
            a(a2);
        } else {
            this.ao = Absent.INSTANCE;
        }
        LogUtils.f(684701349, a);
        return inflate;
    }

    public final void m1508a(Editable editable) {
        Object obj;
        if (this.ax.f1849a == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.al;
            String str = this.ay.f1835a;
            activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_first_keystroke", str).a(this.aw).a);
        }
        MinutiaeObjectPickerState minutiaeObjectPickerState = this.ax;
        minutiaeObjectPickerState.f1849a++;
        m1498b(editable);
    }

    private void aw() {
        if (this.aG != null && this.f1423g != null) {
            AnalyticsLogger analyticsLogger = this.f1423g;
            MinutiaeTypeaheadEventBuilder minutiaeTypeaheadEventBuilder = this.aG;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("minutiae_session_finished");
            honeyClientEvent.c = "taggable_objects";
            MinutiaeTypeaheadEventBuilder.m1534a(honeyClientEvent, "query", minutiaeTypeaheadEventBuilder.f1445a);
            MinutiaeTypeaheadEventBuilder.m1534a(honeyClientEvent, "selected_object_id", minutiaeTypeaheadEventBuilder.f1449e);
            MinutiaeTypeaheadEventBuilder.m1534a(honeyClientEvent, "composer_session_id", minutiaeTypeaheadEventBuilder.f1451g);
            honeyClientEvent.a("query_length", minutiaeTypeaheadEventBuilder.f1446b);
            honeyClientEvent.a("query_count", minutiaeTypeaheadEventBuilder.f1447c);
            honeyClientEvent.a("has_clicked", minutiaeTypeaheadEventBuilder.f1448d);
            honeyClientEvent.a("selected_object_position", minutiaeTypeaheadEventBuilder.f1450f);
            analyticsLogger.c(honeyClientEvent);
        }
    }

    private void m1497a(@Nullable String str) {
        MinutiaePerformanceLogger minutiaePerformanceLogger = this.am;
        minutiaePerformanceLogger.m1654b(4325378, "minutiae_object_picker_time_to_fetch_start");
        minutiaePerformanceLogger.m1655c(4325381, "minutiae_object_picker_fetch_time");
        if (this.ay.m1816f()) {
            m1503c(str);
        } else {
            m1500b(str);
        }
        if (this.aD == null || !this.aD.equals(str)) {
            this.aD = str;
            MinutiaeTypeaheadEventBuilder minutiaeTypeaheadEventBuilder = this.aG;
            minutiaeTypeaheadEventBuilder.f1447c++;
            minutiaeTypeaheadEventBuilder = this.aG;
            String str2 = this.aE;
            minutiaeTypeaheadEventBuilder.f1445a = str2;
            minutiaeTypeaheadEventBuilder.f1446b = str2 != null ? str2.length() : 0;
        }
    }

    private void m1500b(@Nullable String str) {
        if (this.av != null) {
            this.av.c();
        }
        final String uuid = SafeUUIDGenerator.a().toString();
        az();
        this.f1424h.m1683a(this.aB, str, uuid, new AbstractDisposableFutureCallback<GraphQLResult<FetchTaggableObjectsQueryModel>>(this) {
            final /* synthetic */ MinutiaeTaggableObjectFragment f1409b;

            protected final void m1484a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (this.f1409b.y) {
                    this.f1409b.av.c();
                    if (!this.f1409b.ax.f1851c) {
                        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f1409b.al;
                        String str = this.f1409b.ay.f1835a;
                        String str2 = this.f1409b.aw;
                        String valueOf = String.valueOf(this.f1409b.aF);
                        activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_bootstrap_loaded", str).a(str2).d(valueOf).e(uuid).a);
                        this.f1409b.ax.f1851c = true;
                    }
                    FetchTaggableObjectsQueryModel fetchTaggableObjectsQueryModel = (FetchTaggableObjectsQueryModel) graphQLResult.e;
                    MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment = this.f1409b;
                    if (minutiaeTaggableObjectFragment.aB.v() == null) {
                        Builder a = Builder.a((MinutiaeTaggableActivityModel) minutiaeTaggableObjectFragment.aB);
                        a.i = fetchTaggableObjectsQueryModel.j();
                        a = a;
                        a.j = fetchTaggableObjectsQueryModel.k();
                        a = a;
                        a.k = fetchTaggableObjectsQueryModel.l();
                        a = a;
                        a.l = fetchTaggableObjectsQueryModel.m();
                        a = a;
                        a.m = fetchTaggableObjectsQueryModel.n();
                        a = a;
                        a.n = fetchTaggableObjectsQueryModel.o();
                        minutiaeTaggableObjectFragment.aB = a.a();
                    }
                    MinutiaeTaggableObjectFragment.m1490a(this.f1409b, fetchTaggableObjectsQueryModel.p(), this.f1409b.aD, graphQLResult.freshness, uuid);
                    if (this.f1409b.ao.isPresent()) {
                        ((RidgeFragmentController) this.f1409b.ao.get()).m1727d();
                    }
                    if (!StringUtil.c(this.f1409b.aE, this.f1409b.aD)) {
                        this.f1409b.m1500b(this.f1409b.aE);
                    }
                    MinutiaeTaggableObjectFragment.aA(this.f1409b);
                    this.f1409b.am.m1659a(graphQLResult.freshness);
                }
            }

            protected final void m1485a(Throwable th) {
                ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f1409b.al;
                String str = this.f1409b.ay.f1835a;
                activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_load_failed", str).a(this.f1409b.aw).a);
                MinutiaeTaggableObjectFragment.m1492a(this.f1409b, th);
                MinutiaeTaggableObjectFragment.aA(this.f1409b);
                this.f1409b.am.m1662g();
            }
        });
    }

    private void m1503c(String str) {
        FetchTaggableSuggestionsAtPlaceParams.Builder builder = new FetchTaggableSuggestionsAtPlaceParams.Builder();
        builder.f1654a = this.ay.m1817g().g().a();
        builder = builder;
        builder.f1655b = this.ay.f1840f.cf_();
        builder = builder;
        builder.f1656c = str;
        builder = builder;
        builder.f1657d = this.aF;
        builder = builder;
        builder.f1658e = SafeUUIDGenerator.a().toString();
        builder = builder;
        builder.f1659f = "place";
        builder = builder;
        builder.f1660g = null;
        final FetchTaggableSuggestionsAtPlaceParams fetchTaggableSuggestionsAtPlaceParams = new FetchTaggableSuggestionsAtPlaceParams(builder);
        az();
        this.f1420d.a(Task.SEARCH, new Callable<ListenableFuture<GraphQLResult<FetchTaggableSuggestionsAtPlaceQueryModel>>>(this) {
            final /* synthetic */ MinutiaeTaggableObjectFragment f1411b;

            public Object call() {
                String str;
                TaggableSuggestionsAtPlaceFetcher taggableSuggestionsAtPlaceFetcher = this.f1411b.f1425i;
                FetchTaggableSuggestionsAtPlaceParams fetchTaggableSuggestionsAtPlaceParams = fetchTaggableSuggestionsAtPlaceParams;
                Preconditions.checkNotNull(fetchTaggableSuggestionsAtPlaceParams);
                Enum a = GraphQlQueryDefaults.a();
                if (a == null) {
                    a = GraphQlQueryDefaults.a;
                }
                FetchTaggableSuggestionsAtPlaceQueryString b = FetchTaggableObjectGraphQL.b();
                GraphQlQueryString a2 = b.a("legacy_activity_api_id", String.valueOf(fetchTaggableSuggestionsAtPlaceParams.f1661a)).a("taggable_object_count", TaggableSuggestionsAtPlaceFetcher.f1738b).a("taggable_object_image_scale", a).a("taggable_object_pp_size", TaggableSuggestionsAtPlaceFetcher.f1737a).a("image_scale", a).a("minutiae_image_size_large", TaggableSuggestionsAtPlaceFetcher.f1739c).a("place_id", fetchTaggableSuggestionsAtPlaceParams.f1662b).a("typeahead_session_id", String.valueOf(fetchTaggableSuggestionsAtPlaceParams.f1664d)).a("request_id", fetchTaggableSuggestionsAtPlaceParams.f1665e);
                String str2 = "taggable_object_query_string";
                if (fetchTaggableSuggestionsAtPlaceParams.f1663c != null) {
                    str = fetchTaggableSuggestionsAtPlaceParams.f1663c;
                } else {
                    str = "";
                }
                a2.a(str2, str).a("flow_source", fetchTaggableSuggestionsAtPlaceParams.f1666f);
                if (fetchTaggableSuggestionsAtPlaceParams.f1667g != null) {
                    b.a("userLongitude", Double.valueOf(fetchTaggableSuggestionsAtPlaceParams.f1667g.getLongitude())).a("userLatitude", Double.valueOf(fetchTaggableSuggestionsAtPlaceParams.f1667g.getLatitude()));
                }
                GraphQlQueryString graphQlQueryString = b;
                FetchTaggableObjectGraphQL.b();
                return Futures.a(taggableSuggestionsAtPlaceFetcher.f1741d.a(GraphQLRequest.a(graphQlQueryString).a(GraphQLCachePolicy.c).a(new MinutiaeTypeaheadGraphQLCacheKeySerializer(graphQlQueryString, graphQlQueryString.a))), new C01691(taggableSuggestionsAtPlaceFetcher), MoreExecutors.a());
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchTaggableSuggestionsAtPlaceQueryModel>>(this) {
            final /* synthetic */ MinutiaeTaggableObjectFragment f1413b;

            protected final void m1486a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f1413b.av.c();
                this.f1413b.am.m1659a(graphQLResult.freshness);
                FetchTaggableSuggestionsAtPlaceQueryModel fetchTaggableSuggestionsAtPlaceQueryModel = (FetchTaggableSuggestionsAtPlaceQueryModel) graphQLResult.e;
                this.f1413b.aB = fetchTaggableSuggestionsAtPlaceQueryModel;
                MinutiaeTaggableObjectFragment.m1490a(this.f1413b, fetchTaggableSuggestionsAtPlaceQueryModel.K(), this.f1413b.aD, graphQLResult.freshness, fetchTaggableSuggestionsAtPlaceParams.f1665e);
                if (!StringUtil.c(this.f1413b.aE, this.f1413b.aD)) {
                    this.f1413b.m1503c(this.f1413b.aE);
                }
                MinutiaeTaggableObjectFragment.aA(this.f1413b);
            }

            protected final void m1487a(Throwable th) {
                this.f1413b.am.m1662g();
                MinutiaeTaggableObjectFragment.m1492a(this.f1413b, th);
                MinutiaeTaggableObjectFragment.aA(this.f1413b);
            }
        });
    }

    private void ax() {
        this.av.d();
        ((GenericErrorView) this.av.a()).setClickable(true);
        ((GenericErrorView) this.av.a()).setOnClickListener(new C01368(this));
    }

    private void ay() {
        ((GenericErrorView) this.av.a()).setCustomErrorMessage(2131234676);
        ax();
    }

    public static void m1492a(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment, Throwable th) {
        ((GenericErrorView) minutiaeTaggableObjectFragment.av.a()).m19992a();
        minutiaeTaggableObjectFragment.ax();
        minutiaeTaggableObjectFragment.f1421e.a("minutiae_taggable_object_fetch_fail", th);
    }

    private void az() {
        if (this.as != null) {
            this.as.setVisibility(0);
        }
    }

    public static void aA(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
        if (minutiaeTaggableObjectFragment.as != null) {
            minutiaeTaggableObjectFragment.as.setVisibility(8);
        }
    }

    public static void m1490a(MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment, @Nullable MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel, String str, final DataFreshnessResult dataFreshnessResult, String str2) {
        boolean z;
        if (minutiaeTaggableObjectFragment.at != null) {
            minutiaeTaggableObjectFragment.at.setVisibility(0);
        }
        ImmutableList a = minutiaeTaggableObjectsModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (((TaggableObjectEdgeModel) a.get(i)).af_().C_().equalsIgnoreCase(str)) {
                z = true;
                break;
            }
        }
        z = false;
        TaggableObjectEdgeModel taggableObjectEdgeModel = null;
        if (!(StringUtil.c(str) || r0 || !minutiaeTaggableObjectFragment.aB.q())) {
            TaggableObjectEdgeModel.Builder builder = new TaggableObjectEdgeModel.Builder();
            builder.d = str;
            builder = builder;
            builder.h = false;
            builder = builder;
            DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
            builder2.b = minutiaeTaggableObjectFragment.aB.z().a();
            builder.f = builder2.a();
            builder = builder;
            MinutiaeTaggableObjectFieldsModel.Builder builder3 = new MinutiaeTaggableObjectFieldsModel.Builder();
            builder3.d = str;
            builder3 = builder3;
            builder3.c = false;
            builder3 = builder3;
            DefaultImageFieldsModel.Builder builder4 = new DefaultImageFieldsModel.Builder();
            builder4.b = minutiaeTaggableObjectFragment.aB.A().a();
            builder3.h = builder4.a();
            builder.g = builder3.a();
            taggableObjectEdgeModel = builder.a();
        }
        if (minutiaeTaggableObjectsModel.a().isEmpty() && taggableObjectEdgeModel == null) {
            minutiaeTaggableObjectFragment.ay();
        }
        minutiaeTaggableObjectFragment.ar.setOnDrawListenerTo(new OnDrawListener(minutiaeTaggableObjectFragment) {
            final /* synthetic */ MinutiaeTaggableObjectFragment f1416b;

            public final boolean gD_() {
                MinutiaePerformanceLogger minutiaePerformanceLogger = this.f1416b.am;
                DataFreshnessResult dataFreshnessResult = dataFreshnessResult;
                minutiaePerformanceLogger.m1654b(4325382, "minutiae_object_picker_rendering_time");
                minutiaePerformanceLogger.m1653a(4325380, "minutiae_object_picker_time_to_results_shown", dataFreshnessResult);
                return false;
            }
        });
        minutiaeTaggableObjectFragment.az.f1392b = minutiaeTaggableObjectFragment.aB;
        boolean z2 = (minutiaeTaggableObjectFragment.aB == null || minutiaeTaggableObjectFragment.aB.l() == null || !minutiaeTaggableObjectFragment.aB.l().equals("668012816568345")) ? false : true;
        minutiaeTaggableObjectFragment.az.m1476a(str, minutiaeTaggableObjectsModel, taggableObjectEdgeModel, str2, z2);
        minutiaeTaggableObjectFragment.aA.m1427a();
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 304258150);
        this.ar = null;
        this.f1420d.c();
        this.f1424h.f1685b.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1895462320, a);
    }

    public final void m1505H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2140330830);
        super.H();
        MinutiaePerformanceLogger minutiaePerformanceLogger = this.am;
        minutiaePerformanceLogger.m1652a(4325377, "minutiae_object_picker_time_to_init");
        minutiaePerformanceLogger.m1652a(4325378, "minutiae_object_picker_time_to_fetch_start");
        minutiaePerformanceLogger.m1652a(4325379, "minutiae_object_picker_time_to_fetch_end");
        minutiaePerformanceLogger.m1652a(4325380, "minutiae_object_picker_time_to_results_shown");
        minutiaePerformanceLogger.m1652a(4325381, "minutiae_object_picker_fetch_time");
        minutiaePerformanceLogger.m1652a(4325382, "minutiae_object_picker_rendering_time");
        minutiaePerformanceLogger.m1652a(4325387, "minutiae_object_picker_time_to_scroll_load");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1009663817, a);
    }

    public final void m1506I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -549663463);
        this.f1421e = null;
        this.f1417a = null;
        this.f1418b = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1691968066, a);
    }

    public final void m1504G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1981834992);
        super.G();
        if (this.au != null && this.au.isFocused()) {
            this.au.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2067075420, a);
    }

    private void m1498b(Editable editable) {
        String trim = editable.toString().trim();
        if (StringUtil.a(trim)) {
            trim = null;
        }
        this.aE = trim;
        m1497a(this.aE);
        Object obj = this.aA;
        boolean z = !Strings.isNullOrEmpty(this.aE);
        if (z != obj.f1349h) {
            obj.f1349h = z;
            AdapterDetour.a(obj, 754841338);
        }
    }

    private boolean m1501b(TaggableObjectEdgeModel taggableObjectEdgeModel) {
        boolean b = this.az.m1479b(taggableObjectEdgeModel);
        boolean z;
        if (taggableObjectEdgeModel.b() == null || taggableObjectEdgeModel.b().isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (b || r2) {
            return true;
        }
        return false;
    }

    private void m1493a(MinutiaeObject minutiaeObject) {
        if (this.f1418b == null) {
            return;
        }
        if (minutiaeObject.c()) {
            this.f1418b.mo66b(minutiaeObject, 1011);
        } else {
            this.f1418b.mo64a(minutiaeObject, 1011);
        }
    }

    private void m1494a(MinutiaeObject minutiaeObject, @Nullable Intent intent) {
        if (this.f1417a != null) {
            this.f1417a.mo65a(minutiaeObject, intent);
        }
    }

    public final void m1510a(TaggableObjectEdgeModel taggableObjectEdgeModel) {
        String str;
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.al;
        String str2 = this.ay.f1835a;
        String str3 = this.aw;
        String d = taggableObjectEdgeModel.af_().d();
        int b = this.az.m1477b();
        ImmutableList d2 = this.az.m1482d();
        int i = this.ax.f1849a;
        int a = this.az.m1473a(taggableObjectEdgeModel);
        if (this.aE == null) {
            str = "";
        } else {
            str = this.aE;
        }
        activityPickerAnalyticsLogger.m1544a(str2, str3, d, b, d2, i, a, str, String.valueOf(this.aF), this.az.m1481c(taggableObjectEdgeModel), taggableObjectEdgeModel.ae_());
        this.aG.m1535a(taggableObjectEdgeModel, this.az.m1473a(taggableObjectEdgeModel));
        String ch_ = this.ay.m1816f() ? this.ay.m1817g().ch_() : null;
        MinutiaeObject.Builder builder = new MinutiaeObject.Builder();
        builder.a = this.aB;
        builder = builder;
        builder.b = taggableObjectEdgeModel;
        builder = builder;
        builder.d = ch_;
        MinutiaeObject.Builder builder2 = builder;
        builder2.g = taggableObjectEdgeModel.a();
        MinutiaeObject a2 = builder2.a();
        aw();
        if (m1501b(taggableObjectEdgeModel)) {
            m1493a(a2);
        } else {
            m1494a(a2, null);
        }
        if (this.au != null) {
            this.au.c();
        }
    }

    public final void mo71a(MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel) {
        GraphQLTaggableActivitySuggestionMechanism graphQLTaggableActivitySuggestionMechanism;
        Intent intent = new Intent();
        MinutiaeObject a = MinutiaeObject.a(minutiaeTaggableSuggestionsModel);
        intent.putExtra("minutiae_object", a);
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.al;
        String str = this.ay.f1835a;
        String l = minutiaeTaggableSuggestionsModel.c().b().l();
        if (minutiaeTaggableSuggestionsModel.ag_().isEmpty()) {
            graphQLTaggableActivitySuggestionMechanism = GraphQLTaggableActivitySuggestionMechanism.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        } else {
            graphQLTaggableActivitySuggestionMechanism = (GraphQLTaggableActivitySuggestionMechanism) minutiaeTaggableSuggestionsModel.ag_().get(0);
        }
        activityPickerAnalyticsLogger.m1543a(str, l, graphQLTaggableActivitySuggestionMechanism, this.aA.m1425a(minutiaeTaggableSuggestionsModel));
        if (minutiaeTaggableSuggestionsModel.a() == null || minutiaeTaggableSuggestionsModel.a().isEmpty()) {
            if (this.ay.f1840f != null) {
                FlatBufferModelHelper.a(intent, "extra_place", this.ay.f1840f);
            }
            ao().setResult(-1, intent);
            ao().finish();
            return;
        }
        m1493a(a);
    }

    public final void hl_() {
        String str;
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.al;
        String str2 = this.ay.f1835a;
        String str3 = this.aw;
        int count = this.az.getCount();
        ImmutableList d = this.az.m1482d();
        int i = this.ax.f1849a;
        if (this.aE == null) {
            str = "";
        } else {
            str = this.aE;
        }
        activityPickerAnalyticsLogger.m1542a(str2, str3, count, d, i, str, String.valueOf(this.aF), this.az.m1480c());
        aw();
    }

    public final void hm_() {
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.al;
        String str = this.ay.f1835a;
        String valueOf = String.valueOf(this.aF);
        activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_object_skipped", str).d(valueOf).e(this.az.m1480c()).a);
    }

    public final void mo78b() {
        mo80e().mo67b(b(2131234697));
    }

    public final void mo79c() {
        if (!this.f1422f.a(MinutiaePrefKeys.f1623k, false)) {
            mo80e().mo67b(b(2131234698));
            this.f1422f.edit().putBoolean(MinutiaePrefKeys.f1623k, true).commit();
        }
    }

    public final RidgeHostActivity mo80e() {
        return (RidgeHostActivity) ao();
    }

    public final boolean aq() {
        return this.az.getCount() == 0;
    }

    public final MinutiaeConfiguration ar() {
        return this.ay;
    }

    public final MinutiaeSuggestionAdapter as() {
        return this.aA;
    }

    public final boolean au() {
        return this.aB != null && this.aB.p() && this.ay.f1841g && this.aq.get() == TriState.YES;
    }

    public final Optional<MinutiaeTaggableActivity> av() {
        return Optional.of(this.aB);
    }

    public final void mo70a(MinutiaeCustomIconPickerLauncher minutiaeCustomIconPickerLauncher) {
        this.f1418b = minutiaeCustomIconPickerLauncher;
    }
}
