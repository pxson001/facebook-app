package com.facebook.search.results.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.contextual.validation.ContextualConfigValidation;
import com.facebook.contextual.validation.ContextualConfigValidationMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.ExitAction;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecImpl.Builder;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.util.SearchResultsThemeHelper;
import com.facebook.search.util.SearchThemeHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SIMPLE_PICKER */
public abstract class SearchResultsBaseFragment extends FbFragment implements AnalyticsFragmentWithExtraData, GraphSearchResultFragment {
    @Inject
    NavigationLogger f22953a;
    private boolean al = false;
    private boolean am = false;
    @Inject
    @ForUiThread
    public Handler f22954b;
    @Inject
    SearchResultsLogger f22955c;
    @Inject
    SearchThemeHelper f22956d;
    @Inject
    SearchResultsThemeHelper f22957e;
    @Inject
    ContextualConfigValidation f22958f;
    @Inject
    GatekeeperStoreImpl f22959g;
    public SearchResultsMutableContext f22960h = new SearchResultsMutableContext();
    private boolean f22961i = false;

    /* compiled from: SIMPLE_PICKER */
    class C24471 implements Runnable {
        final /* synthetic */ SearchResultsBaseFragment f22952a;

        C24471(SearchResultsBaseFragment searchResultsBaseFragment) {
            this.f22952a = searchResultsBaseFragment;
        }

        public void run() {
            this.f22952a.f22953a.a(this.f22952a, this.f22952a.getContext());
        }
    }

    public static void m26571a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsBaseFragment) obj).m26570a(NavigationLogger.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), SearchResultsLogger.m25460a(injectorLike), SearchThemeHelper.m10662a(injectorLike), SearchResultsThemeHelper.m28572a(injectorLike), ContextualConfigValidationMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    protected abstract void aq();

    protected abstract boolean ar();

    private void m26570a(NavigationLogger navigationLogger, Handler handler, SearchResultsLogger searchResultsLogger, SearchThemeHelper searchThemeHelper, SearchResultsThemeHelper searchResultsThemeHelper, ContextualConfigValidation contextualConfigValidation, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f22953a = navigationLogger;
        this.f22954b = handler;
        this.f22955c = searchResultsLogger;
        this.f22956d = searchThemeHelper;
        this.f22957e = searchResultsThemeHelper;
        this.f22958f = contextualConfigValidation;
        this.f22959g = gatekeeperStoreImpl;
    }

    public Class<?> mo1294e() {
        return getClass();
    }

    protected String as() {
        return this.f22960h.mo1211a();
    }

    public void mo1290c(Bundle bundle) {
        super.c(bundle);
        mo1294e();
        Class cls = SearchResultsBaseFragment.class;
        m26571a((Object) this, getContext());
        this.f22958f.a();
        SearchResultsMutableContext searchResultsMutableContext = (bundle == null || !this.f22959g.a(SearchAbTestGatekeepers.w, false)) ? null : (SearchResultsMutableContext) bundle.getParcelable("SEARCH_RESULTS_CONTEXT");
        if (searchResultsMutableContext != null) {
            this.f22960h = searchResultsMutableContext;
        }
        Bundle bundle2 = this.s;
        if (bundle2 == null) {
            mo1294e();
            return;
        }
        this.f22960h.f23366a = SearchResultsThemeHelper.m28570a(bundle2);
        if (m26572n(bundle2)) {
            ImmutableList of;
            String string = bundle2.getString("query_title");
            String string2 = bundle2.getString("query_function");
            String string3 = bundle2.getString("query_vertical");
            ExactMatchInputExactMatch exactMatchInputExactMatch = ExactMatchInputExactMatch.FALSE;
            GraphQLGraphSearchResultsDisplayStyle fromString = GraphQLGraphSearchResultsDisplayStyle.fromString(bundle2.getString("display_style"));
            String string4 = bundle2.getString("source");
            ScopedEntityType scopedEntityType = (ScopedEntityType) bundle2.getSerializable("graph_search_scoped_entity_type");
            String string5 = bundle2.getString("graph_search_scoped_entity_id");
            String string6 = bundle2.getString("graph_search_scoped_entity_name");
            Builder builder = new Builder();
            builder.f22061a = string;
            builder = builder;
            builder.f22063c = string;
            Builder builder2 = builder;
            builder2.f22062b = string2;
            builder2 = builder2;
            builder2.f22064d = string3;
            builder2 = builder2;
            builder2.f22065e = exactMatchInputExactMatch;
            Builder builder3 = builder2;
            if (fromString != null) {
                of = ImmutableList.of(fromString);
            } else {
                of = RegularImmutableList.a;
            }
            builder3.f22066f = of;
            builder2 = builder3;
            builder2.f22067g = RegularImmutableBiMap.a;
            builder2 = builder2;
            builder2.f22071k = scopedEntityType;
            Builder builder4 = builder2;
            builder4.f22069i = string5;
            builder4 = builder4;
            builder4.f22070j = string6;
            GraphSearchQuerySpec i = builder4.m25632i();
            SearchResultsSource searchResultsSource = (SearchResultsSource) Optional.fromNullable(SearchResultsSource.a(string4)).or(SearchResultsSource.H);
            string2 = bundle2.getString("typeahead_session_id");
            string3 = bundle2.getString("candidate_session_id");
            GraphQLGraphSearchResultRole fromString2 = GraphQLGraphSearchResultRole.fromString(bundle2.getString("source_module_role"));
            mo1281a(i, new SearchTypeaheadSession(string2, string3), searchResultsSource);
            this.f22960h.f23368c = fromString2;
        }
    }

    public final void m26575a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        mo1294e();
        this.al = true;
    }

    public void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1350456053);
        super.mi_();
        mo1294e();
        Bundle bundle = this.s;
        boolean z = bundle != null && m26572n(bundle);
        this.am = z;
        if (this.am) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            String as = as();
            if (!(hasTitleBar == null || as == null)) {
                mo1294e();
                as();
                hasTitleBar.a_(as);
            }
            LogUtils.f(1635754878, a);
            return;
        }
        LogUtils.f(1872460415, a);
    }

    public void m26584g(boolean z) {
        super.g(z);
        if (!this.y) {
            return;
        }
        if (z) {
            au();
        } else {
            av();
        }
    }

    public void mo1282G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1434436154);
        super.G();
        if (D()) {
            au();
            LogUtils.f(1000404458, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1004324178, a);
    }

    public void mo1301e(Bundle bundle) {
        super.e(bundle);
        if (this.f22959g.a(SearchAbTestGatekeepers.w, false)) {
            bundle.putParcelable("SEARCH_RESULTS_CONTEXT", this.f22960h);
        }
    }

    protected void au() {
        mo1294e();
        if (!this.am) {
            HandlerDetour.a(this.f22954b, new C24471(this), 69615323);
        }
        ay();
    }

    protected void av() {
        mo1294e();
    }

    public void mo1283H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1683946047);
        if (D()) {
            av();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 794623165, a);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -274886151);
        this.al = false;
        mo1294e();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1198693390, a);
    }

    public void mo1281a(GraphSearchQuerySpec graphSearchQuerySpec, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource) {
        Preconditions.checkState(graphSearchQuerySpec.mo1212b() != null);
        mo1294e();
        if (!Objects.equal(this.f22960h.mo1212b(), graphSearchQuerySpec.mo1212b())) {
            mo1294e();
            this.f22961i = true;
        }
        mo1294e();
        this.f22960h.m27087a(graphSearchQuerySpec, searchTypeaheadSession, searchResultsSource);
        mo1294e();
        if (this.f22961i && aA()) {
            mo1294e();
            aq();
            this.f22961i = false;
        }
    }

    public final Fragment mo1192b() {
        return this;
    }

    public boolean mo1191a(boolean z) {
        ExitAction exitAction;
        SearchResultsLogger searchResultsLogger = this.f22955c;
        SearchTypeaheadSession searchTypeaheadSession = this.f22960h.f23369d;
        if (z) {
            exitAction = ExitAction.UP_BUTTON;
        } else {
            exitAction = ExitAction.BACK_BUTTON;
        }
        searchResultsLogger.m25467a(searchTypeaheadSession, exitAction);
        return false;
    }

    public void mo1190a(OnResultClickListener onResultClickListener) {
    }

    public final Map<String, Object> m26580c() {
        return SearchResultsLogger.m25462a(this.f22960h.f23370e);
    }

    protected final boolean aw() {
        return aA() && !Strings.isNullOrEmpty(this.f22960h.mo1212b()) && (!ar() || this.f22961i);
    }

    protected final SearchResultsMutableContext ax() {
        return this.f22960h;
    }

    protected final void ay() {
        if (aw()) {
            mo1294e();
            aq();
            this.f22961i = false;
        }
    }

    protected final Context az() {
        Context a = SearchResultsThemeHelper.m28569a(getContext(), this.s);
        this.f22956d.m10664a(a);
        return a;
    }

    private boolean aA() {
        return this.al && D();
    }

    private static boolean m26572n(Bundle bundle) {
        return (bundle.getString("query_function") == null || bundle.getString("query_title") == null) ? false : true;
    }
}
