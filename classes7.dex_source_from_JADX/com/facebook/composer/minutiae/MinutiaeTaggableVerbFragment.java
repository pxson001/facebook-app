package com.facebook.composer.minutiae;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.metatext.MetaTextBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.ParamsBuilder;
import com.facebook.composer.metatext.MinutiaeTemplateMetaTextBuilder;
import com.facebook.composer.minutiae.abtest.ExperimentsForMinutiaeAbTestModule;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger;
import com.facebook.composer.minutiae.perf.MinutiaePerformanceLogger;
import com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.protocol.MinutiaeActiveUserStore;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbModelEdge;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher;
import com.facebook.composer.minutiae.ridge.RidgeFragmentControllerProvider;
import com.facebook.composer.minutiae.ridge.RidgeHost;
import com.facebook.composer.minutiae.ridge.RidgeHostActivity;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.view.MinutiaeFooterView;
import com.facebook.composer.minutiae.view.MinutiaeFooterView.C01891;
import com.facebook.composer.minutiae.view.MinutiaeFooterView.C01902;
import com.facebook.composer.minutiae.view.MinutiaeFooterView.C01913;
import com.facebook.composer.minutiae.view.MinutiaeTaggableObjectViewController.SuggestionCallback;
import com.facebook.composer.minutiae.view.RidgeRefreshableListViewContainer;
import com.facebook.composer.minutiae.view.stubs.MinutiaeListViewStub;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLTaggableActivitySuggestionMechanism;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.Liveness;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewStub;
import com.facebook.widget.CustomViewStubHelper;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.sectionedadapter.SectionedAdapterForListView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: total_candidates */
public class MinutiaeTaggableVerbFragment extends FbFragment implements MinutiaeFragment, RidgeHost, SuggestionCallback {
    public final PrefKey f1436a = ((PrefKey) SharedPrefKeys.a.a("minutiae_nux"));
    public VerbSelectedListener aA;
    public MinutiaeCustomIconPickerLauncher aB;
    public MinutiaeObjectPickerPerformanceLogger al;
    private RidgeFragmentControllerProvider am;
    private MinutiaeActiveUserStore an;
    public BetterListView ao;
    public CustomViewStubHelper<GenericErrorView> ap;
    public CustomViewStubHelper<MinutiaeFooterView> aq;
    private CustomViewStubHelper<TextView> ar;
    private Optional<RidgeRefreshableListViewContainer> as;
    public boolean at = false;
    private MinutiaeTaggableVerbAdapter au;
    public MinutiaeSuggestionAdapter av;
    public ImmutableList<MinutiaeVerbModelEdge> aw;
    public MinutiaeConfiguration ax;
    private boolean ay = false;
    public DataFreshnessResult az;
    public MinutiaeVerbsFetcher f1437b;
    public AbstractFbErrorReporter f1438c;
    public FbSharedPreferences f1439d;
    public Product f1440e;
    public MetaTextBuilder f1441f;
    private Provider<TriState> f1442g;
    public ActivityPickerAnalyticsLogger f1443h;
    public MinutiaeVerbPickerPerformanceLogger f1444i;

    /* compiled from: total_candidates */
    public class C01391 implements OnDrawListener {
        final /* synthetic */ MinutiaeTaggableVerbFragment f1434a;

        public C01391(MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment) {
            this.f1434a = minutiaeTaggableVerbFragment;
        }

        public final boolean gD_() {
            MinutiaePerformanceLogger minutiaePerformanceLogger = this.f1434a.f1444i;
            DataFreshnessResult dataFreshnessResult = this.f1434a.az;
            minutiaePerformanceLogger.m1654b(4390917, "minutiae_verb_picker_rendering_time");
            minutiaePerformanceLogger.m1653a(4390923, "minutiae_verb_picker_time_to_verbs_shown", dataFreshnessResult);
            minutiaePerformanceLogger.m1654b(4390918, "minutiae_verb_picker_tti");
            return true;
        }
    }

    /* compiled from: total_candidates */
    public class C01402 implements OnClickListener {
        final /* synthetic */ MinutiaeTaggableVerbFragment f1435a;

        public C01402(MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment) {
            this.f1435a = minutiaeTaggableVerbFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2115469036);
            MinutiaeTaggableVerbFragment.ay(this.f1435a);
            Logger.a(2, EntryType.UI_INPUT_END, -307733389, a);
        }
    }

    public static void m1522a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MinutiaeTaggableVerbFragment) obj).m1521a(MinutiaeVerbsFetcher.m1699a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), MinutiaeTemplateMetaTextBuilder.m1391b(injectorLike), IdBasedProvider.a(injectorLike, 637), ActivityPickerAnalyticsLogger.m1538a(injectorLike), MinutiaeVerbPickerPerformanceLogger.m1663a(injectorLike), MinutiaeObjectPickerPerformanceLogger.m1656a(injectorLike), (RidgeFragmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RidgeFragmentControllerProvider.class), MinutiaeActiveUserStore.m1672a(injectorLike));
    }

    public final Optional<MinutiaeTaggableActivity> av() {
        return Absent.INSTANCE;
    }

    @Inject
    private void m1521a(MinutiaeVerbsFetcher minutiaeVerbsFetcher, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, Product product, MinutiaeTemplateMetaTextBuilder minutiaeTemplateMetaTextBuilder, Provider<TriState> provider, ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger, MinutiaeVerbPickerPerformanceLogger minutiaeVerbPickerPerformanceLogger, MinutiaeObjectPickerPerformanceLogger minutiaeObjectPickerPerformanceLogger, RidgeFragmentControllerProvider ridgeFragmentControllerProvider, MinutiaeActiveUserStore minutiaeActiveUserStore) {
        this.f1437b = minutiaeVerbsFetcher;
        this.f1438c = fbErrorReporter;
        this.f1439d = fbSharedPreferences;
        this.f1440e = product;
        this.f1441f = minutiaeTemplateMetaTextBuilder;
        this.f1442g = provider;
        this.f1443h = activityPickerAnalyticsLogger;
        this.f1444i = minutiaeVerbPickerPerformanceLogger;
        this.al = minutiaeObjectPickerPerformanceLogger;
        this.am = ridgeFragmentControllerProvider;
        this.an = minutiaeActiveUserStore;
    }

    public final void m1531c(Bundle bundle) {
        super.c(bundle);
        Class cls = MinutiaeTaggableVerbFragment.class;
        m1522a((Object) this, getContext());
        this.ax = (MinutiaeConfiguration) this.s.getParcelable("minutiae_configuration");
        Preconditions.checkNotNull(this.ax);
    }

    public final View m1525a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -61546640);
        this.au = new MinutiaeTaggableVerbAdapter(getContext(), layoutInflater, this);
        this.av = new MinutiaeSuggestionAdapter(getContext(), this.ax, this.f1443h, this);
        if (this.aw != null) {
            this.au.m1520a(this.aw);
        }
        this.f1437b.f1726l = this;
        Collection collection = this.ax.f1837c;
        if (collection != null) {
            if (this.au.getCount() == 0) {
                this.av.f1348g = ImmutableList.copyOf(collection);
            } else {
                this.av.m1429a(ImmutableList.copyOf(collection));
            }
        }
        View inflate = layoutInflater.inflate(2130903709, null);
        MinutiaeListViewStub minutiaeListViewStub = (MinutiaeListViewStub) FindViewUtil.b(inflate, 2131560584);
        minutiaeListViewStub.f1901b = au();
        CustomViewStubHelper a2 = CustomViewStubHelper.a(minutiaeListViewStub);
        a2.d();
        this.as = FindViewUtil.a(a2.a(), 2131560579);
        this.ao = (BetterListView) FindViewUtil.b(a2.a(), 16908298);
        this.ao.setEmptyView(inflate.findViewById(16908292));
        aw();
        this.ap = CustomViewStubHelper.a((CustomViewStub) FindViewUtil.b(inflate, 2131560575));
        this.aq = CustomViewStubHelper.a((CustomViewStub) FindViewUtil.b(inflate, 2131560586));
        this.ar = CustomViewStubHelper.a((CustomViewStub) FindViewUtil.b(inflate, 2131560583));
        boolean z = false;
        if (this.f1440e != Product.PAA) {
            boolean a3 = this.f1439d.a(this.f1436a, false);
            if (!a3) {
                Editor edit = this.f1439d.edit();
                edit.putBoolean(this.f1436a, true);
                edit.commit();
            }
            if (!a3) {
                z = true;
            }
        }
        if (z) {
            this.ar.d();
        }
        if (au()) {
            a(this.am.m1729a(this));
        }
        this.an.m1674a();
        if (this.ay) {
            this.ay = false;
            aw();
        }
        LogUtils.f(883601861, a);
        return inflate;
    }

    private void aw() {
        this.ao.setAdapter(new SectionedAdapterForListView(ImmutableList.of(this.av, this.au)));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2113487949);
        super.mi_();
        this.f1437b.f1728n.a(Liveness.Cached, ExperimentsForMinutiaeAbTestModule.f1455a);
        ay(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2113039827, a);
    }

    public final void m1523H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -782534766);
        super.H();
        MinutiaePerformanceLogger minutiaePerformanceLogger = this.f1444i;
        minutiaePerformanceLogger.m1652a(4390913, "minutiae_verb_picker_time_to_init");
        minutiaePerformanceLogger.m1652a(4390915, "minutiae_verb_picker_time_to_fetch_end");
        minutiaePerformanceLogger.m1652a(4390923, "minutiae_verb_picker_time_to_verbs_shown");
        minutiaePerformanceLogger.m1652a(4390916, "minutiae_verb_picker_fetch_time");
        minutiaePerformanceLogger.m1652a(4390917, "minutiae_verb_picker_rendering_time");
        minutiaePerformanceLogger.m1652a(4390918, "minutiae_verb_picker_tti");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -626413160, a);
    }

    public static void ay(MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment) {
        minutiaeTaggableVerbFragment.ap.c();
        MinutiaeVerbsFetcher minutiaeVerbsFetcher = minutiaeTaggableVerbFragment.f1437b;
        minutiaeVerbsFetcher.f1727m.m1655c(4390916, "minutiae_verb_picker_fetch_time");
        MinutiaeVerbsFetcher.m1703i(minutiaeVerbsFetcher);
    }

    public final void m1528a(ImmutableList<MinutiaeVerbModelEdge> immutableList, DataFreshnessResult dataFreshnessResult) {
        this.az = dataFreshnessResult;
        this.aw = immutableList;
        if (this.au != null) {
            this.au.m1520a(this.aw);
        }
        MinutiaePerformanceLogger minutiaePerformanceLogger = this.f1444i;
        minutiaePerformanceLogger.m1653a(4390915, "minutiae_verb_picker_time_to_fetch_end", dataFreshnessResult);
        minutiaePerformanceLogger.m1653a(4390916, "minutiae_verb_picker_fetch_time", dataFreshnessResult);
        minutiaePerformanceLogger.m1655c(4390917, "minutiae_verb_picker_rendering_time");
        if (this.ao != null) {
            this.ao.setOnDrawListenerTo(new C01391(this));
            if (!this.at) {
                ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f1443h;
                activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_verbs_loaded", this.ax.f1835a).a);
                this.at = true;
            }
            if (this.av != null) {
                this.av.m1427a();
            }
            if (this.ax.f1838d == null || this.ax.f1844j) {
                this.aq.c();
                return;
            }
            MinutiaeFooterView minutiaeFooterView = (MinutiaeFooterView) this.aq.a();
            MinutiaeObject minutiaeObject = this.ax.f1838d;
            MetaTextBuilder metaTextBuilder = this.f1441f;
            OnClickListener c01891 = new C01891(minutiaeFooterView);
            minutiaeFooterView.f1880d.a(minutiaeObject.a(), MinutiaeFooterView.f1877a);
            minutiaeFooterView.f1880d.setOnClickListener(new C01902(minutiaeFooterView, minutiaeObject));
            ParamsBuilder paramsBuilder = new ParamsBuilder();
            paramsBuilder.f1298g = false;
            paramsBuilder = paramsBuilder;
            paramsBuilder.f1297f = false;
            paramsBuilder = paramsBuilder;
            paramsBuilder.f1292a = minutiaeObject;
            minutiaeFooterView.f1881e.setText(metaTextBuilder.mo56a(paramsBuilder.m1371a()).toString());
            minutiaeFooterView.f1879c.setOnClickListener(c01891);
            minutiaeFooterView.f1878b.setOnClickListener(new C01913(minutiaeFooterView));
            ((MinutiaeFooterView) this.aq.a()).setVisibility(0);
            ((MinutiaeFooterView) this.aq.a()).f1882f = this;
            ((MinutiaeFooterView) this.aq.a()).bringToFront();
            return;
        }
        this.ay = true;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -331263130);
        this.ao = null;
        if (this.ap.b()) {
            ((GenericErrorView) this.ap.a()).setOnClickListener(null);
        }
        if (this.aq.b()) {
            ((MinutiaeFooterView) this.aq.a()).f1882f = null;
        }
        this.aq = null;
        this.ap = null;
        this.f1437b.f1725k.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1515135423, a);
    }

    public final void m1524I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2075539081);
        this.f1438c = null;
        this.f1437b.f1726l = null;
        this.f1437b = null;
        this.aA = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 29404909, a);
    }

    public final void m1533g(int i) {
        ao().setResult(i);
        ao().finish();
    }

    public final void mo71a(MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel) {
        GraphQLTaggableActivitySuggestionMechanism graphQLTaggableActivitySuggestionMechanism;
        Intent intent = new Intent();
        MinutiaeObject a = MinutiaeObject.a(minutiaeTaggableSuggestionsModel);
        intent.putExtra("minutiae_object", a);
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f1443h;
        String str = this.ax.f1835a;
        String l = minutiaeTaggableSuggestionsModel.c().b().l();
        if (minutiaeTaggableSuggestionsModel.ag_().isEmpty()) {
            graphQLTaggableActivitySuggestionMechanism = GraphQLTaggableActivitySuggestionMechanism.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        } else {
            graphQLTaggableActivitySuggestionMechanism = (GraphQLTaggableActivitySuggestionMechanism) minutiaeTaggableSuggestionsModel.ag_().get(0);
        }
        activityPickerAnalyticsLogger.m1543a(str, l, graphQLTaggableActivitySuggestionMechanism, this.av.m1425a(minutiaeTaggableSuggestionsModel));
        if (minutiaeTaggableSuggestionsModel.a() == null || minutiaeTaggableSuggestionsModel.a().isEmpty() || this.aB == null) {
            if (this.ax.f1840f != null) {
                FlatBufferModelHelper.a(intent, "extra_place", this.ax.f1840f);
            }
            ao().setResult(-1, intent);
            ao().finish();
            return;
        }
        this.aB.mo66b(a, 1010);
    }

    public final void hl_() {
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f1443h;
        activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_tapped_cancel", this.ax.f1835a).a);
    }

    public final void hm_() {
    }

    public final void mo78b() {
        mo80e().mo67b(b(2131234697));
    }

    public final void mo79c() {
        if (!this.f1439d.a(MinutiaePrefKeys.f1623k, false)) {
            mo80e().mo67b(b(2131234698));
            this.f1439d.edit().putBoolean(MinutiaePrefKeys.f1623k, true).commit();
        }
    }

    public final RidgeHostActivity mo80e() {
        return (RidgeHostActivity) ao();
    }

    public final boolean aq() {
        return this.au.getCount() == 0;
    }

    public final MinutiaeConfiguration ar() {
        return this.ax;
    }

    public final MinutiaeSuggestionAdapter as() {
        return this.av;
    }

    public final Optional<RidgeRefreshableListViewContainer> at() {
        return this.as;
    }

    public final boolean au() {
        return this.f1442g.get() == TriState.YES && this.ax.f1841g;
    }

    public final void mo70a(MinutiaeCustomIconPickerLauncher minutiaeCustomIconPickerLauncher) {
        this.aB = minutiaeCustomIconPickerLauncher;
    }
}
