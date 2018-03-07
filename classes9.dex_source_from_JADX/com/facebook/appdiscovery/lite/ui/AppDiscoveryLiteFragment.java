package com.facebook.appdiscovery.lite.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryError;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryException;
import com.facebook.appdiscovery.lite.model.AppDiscoveryResults;
import com.facebook.appdiscovery.lite.model.AppDiscoveryResultsCollection;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQL.FetchLiteResultsQueryString;
import com.facebook.appdiscovery.lite.protocol.loader.LiteResultsLoader;
import com.facebook.appdiscovery.lite.protocol.loader.LiteResultsLoader.C03801;
import com.facebook.appdiscovery.lite.ui.rows.AppDiscoveryEnvironment;
import com.facebook.appdiscovery.lite.ui.rows.AppDiscoveryEnvironmentProvider;
import com.facebook.appdiscovery.lite.ui.rows.AppDiscoveryFeedListType;
import com.facebook.appdiscovery.lite.ui.rows.AppDiscoveryRootPartDefinition;
import com.facebook.appdiscovery.lite.ui.widget.resultspage.AppDiscoveryPage.State;
import com.facebook.appdiscovery.lite.ui.widget.resultspage.AppDiscoveryPageView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback.AbsListViewRecyclerListener;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sellerFbId */
public class AppDiscoveryLiteFragment extends FbDialogFragment {
    public static final String au = AppDiscoveryLiteFragment.class.getName();
    public AppDiscoveryPageView aA;
    private LiteResultsListener aB;
    @Inject
    MultiRowAdapterBuilder am;
    @Inject
    AppDiscoveryEnvironmentProvider an;
    @Inject
    Provider<MultipleRowsStoriesRecycleCallback> ao;
    @Inject
    Lazy<AppDiscoveryRootPartDefinition> ap;
    @Inject
    LiteResultsLoader aq;
    @Inject
    AppDiscoveryResultsCollection ar;
    @Inject
    AbstractFbErrorReporter as;
    @Inject
    AnalyticsLogger at;
    private String av;
    private String aw;
    private String ax;
    private BetterListView ay;
    public MultiRowAdapter az;

    /* compiled from: sellerFbId */
    class C03811 implements Runnable {
        final /* synthetic */ AppDiscoveryLiteFragment f4140a;

        C03811(AppDiscoveryLiteFragment appDiscoveryLiteFragment) {
            this.f4140a = appDiscoveryLiteFragment;
        }

        public void run() {
            this.f4140a.az.notifyDataSetChanged();
        }
    }

    /* compiled from: sellerFbId */
    class C03822 implements RetryClickedListener {
        final /* synthetic */ AppDiscoveryLiteFragment f4141a;

        C03822(AppDiscoveryLiteFragment appDiscoveryLiteFragment) {
            this.f4141a = appDiscoveryLiteFragment;
        }

        public final void m4192a() {
            AppDiscoveryLiteFragment.ar(this.f4141a);
        }
    }

    /* compiled from: sellerFbId */
    public class LiteResultsListener {
        public final /* synthetic */ AppDiscoveryLiteFragment f4142a;

        public final void m4193a(AppDiscoveryResults appDiscoveryResults) {
            if (appDiscoveryResults.a.isEmpty()) {
                this.f4142a.aA.setState(State.EMPTY);
                this.f4142a.as.b(AppDiscoveryLiteFragment.au, new AppDiscoveryException("Got empty results for app discovery query", AppDiscoveryError.FETCH_LITE_RESULTS_UNRECOGNIZED_FORMAT));
                AppDiscoveryLiteFragment.m4194a(this.f4142a, "app_discovery_lite_load_failed");
                return;
            }
            this.f4142a.ar.a.clear();
            AppDiscoveryResultsCollection appDiscoveryResultsCollection = this.f4142a.ar;
            appDiscoveryResultsCollection.a.addAll(ImmutableList.copyOf(appDiscoveryResults.a));
            this.f4142a.az.notifyDataSetChanged();
            this.f4142a.aA.setState(State.LOAD_FINISHED);
            AppDiscoveryLiteFragment.m4194a(this.f4142a, "app_discovery_lite_load_success");
        }

        public LiteResultsListener(AppDiscoveryLiteFragment appDiscoveryLiteFragment) {
            this.f4142a = appDiscoveryLiteFragment;
        }
    }

    public static void m4196a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AppDiscoveryLiteFragment) obj).m4195a(MultiRowAdapterBuilder.b(injectorLike), (AppDiscoveryEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppDiscoveryEnvironmentProvider.class), IdBasedSingletonScopeProvider.a(injectorLike, 1489), IdBasedLazy.a(injectorLike, 4846), LiteResultsLoader.m4183a(injectorLike), new AppDiscoveryResultsCollection(), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    private void m4195a(MultiRowAdapterBuilder multiRowAdapterBuilder, AppDiscoveryEnvironmentProvider appDiscoveryEnvironmentProvider, Provider<MultipleRowsStoriesRecycleCallback> provider, Lazy<AppDiscoveryRootPartDefinition> lazy, LiteResultsLoader liteResultsLoader, AppDiscoveryResultsCollection appDiscoveryResultsCollection, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger) {
        this.am = multiRowAdapterBuilder;
        this.an = appDiscoveryEnvironmentProvider;
        this.ao = provider;
        this.ap = lazy;
        this.aq = liteResultsLoader;
        this.ar = appDiscoveryResultsCollection;
        this.as = fbErrorReporter;
        this.at = analyticsLogger;
    }

    public final void m4200a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 120614137);
        super.a(bundle);
        Class cls = AppDiscoveryLiteFragment.class;
        m4196a((Object) this, getContext());
        this.av = this.s.getString("package_name");
        this.ax = this.s.getString("referrer");
        Object string = this.s.getString("app_invite_id");
        if (!StringUtil.a(string)) {
            this.aw = string;
        }
        if (this.av == null && this.aw == null) {
            this.as.b(au, new AppDiscoveryException("Package name or Base Entity Id needs to be specified", AppDiscoveryError.ILLEGAL_ARGUMENT));
        }
        if (this.ax == null) {
            this.as.b(au, new AppDiscoveryException("Referrer not specified", AppDiscoveryError.ILLEGAL_ARGUMENT));
        }
        this.aB = new LiteResultsListener(this);
        AnyEnvironment appDiscoveryEnvironment = new AppDiscoveryEnvironment(getContext(), AppDiscoveryFeedListType.f4144a, new C03811(this));
        Builder a2 = this.am.a(this.ap, this.ar);
        a2.f = appDiscoveryEnvironment;
        this.az = a2.e();
        ar(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -585353942, a);
    }

    public final View m4199a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 952437686);
        this.aA = new AppDiscoveryPageView(new ContextThemeWrapper(getContext(), 2131626319));
        this.aA.setBackground(new ColorDrawable(jW_().getColor(2131362148)));
        this.aA.f4196g = new C03822(this);
        this.ay = this.aA.f4190a;
        this.ay.setAdapter(this.az);
        this.ay.setRecyclerListener(new AbsListViewRecyclerListener((MultipleRowsStoriesRecycleCallback) this.ao.get()));
        Object obj = this.aA;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 808568171, a);
        return obj;
    }

    public final void m4197G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -288666465);
        super.G();
        this.aq.m4185a(this.aB);
        m4194a(this, "app_discovery_lite_resumed");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1949314289, a);
    }

    public final void m4198H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1073122233);
        this.aq.m4185a(null);
        m4194a(this, "app_discovery_lite_paused");
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -665631992, a);
    }

    public static void ar(AppDiscoveryLiteFragment appDiscoveryLiteFragment) {
        m4194a(appDiscoveryLiteFragment, "app_discovery_lite_load_started");
        LiteResultsLoader liteResultsLoader = appDiscoveryLiteFragment.aq;
        String str = appDiscoveryLiteFragment.av;
        liteResultsLoader.f4131b.a("appdiscovery_results_loader_key", liteResultsLoader.f4130a.a(GraphQLRequest.a((FetchLiteResultsQueryString) new FetchLiteResultsQueryString().a("package_name", str).a("base_entity_id", appDiscoveryLiteFragment.aw).a("default_image_scale", GraphQlQueryDefaults.a).a("generic_attachment_small_square_image_dimension", Integer.valueOf(100)).a("generic_attachment_large_square_image_dimension", Integer.valueOf(560)).a("generic_attachment_small_cover_image_width", Integer.valueOf(88)).a("generic_attachment_small_cover_image_height", Integer.valueOf(88)).a("generic_attachment_tall_cover_image_width", Integer.valueOf(670)).a("generic_attachment_tall_cover_image_height", Integer.valueOf(352))).a(GraphQLCachePolicy.c)), new C03801(liteResultsLoader));
        State state = State.LOADING;
        if (appDiscoveryLiteFragment.aA != null) {
            appDiscoveryLiteFragment.aA.setState(state);
        }
    }

    public static void m4194a(AppDiscoveryLiteFragment appDiscoveryLiteFragment, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.b("package_name", appDiscoveryLiteFragment.av);
        honeyClientEvent.b("app_invite_id", appDiscoveryLiteFragment.aw);
        honeyClientEvent.b("referrer", appDiscoveryLiteFragment.ax);
        appDiscoveryLiteFragment.at.a(honeyClientEvent);
    }
}
