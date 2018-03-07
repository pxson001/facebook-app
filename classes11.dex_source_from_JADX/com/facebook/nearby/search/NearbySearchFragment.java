package com.facebook.nearby.search;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.analytics.NearbySearchAnalytics;
import com.facebook.nearby.analytics.NearbySearchAnalytics.SearchSelectionType;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.data.SearchSuggestionHistoryManager;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.model.TypeaheadPlaceWithLayout;
import com.facebook.nearby.protocol.FetchNearbyPlacesLayoutParams;
import com.facebook.nearby.protocol.NearbyTypeaheadWithLayoutsParams;
import com.facebook.nearby.protocol.NearbyTypeaheadWithLayoutsResult;
import com.facebook.nearby.protocol.SearchArea;
import com.facebook.nearby.protocol.SearchNearbyPlacesParams;
import com.facebook.nearby.protocol.SearchNearbyPlacesParams.Builder;
import com.facebook.nearby.search.NearbySearchCategoriesView.C00921;
import com.facebook.nearby.ui.InflatedLayoutLocationSetter;
import com.facebook.nearby.ui.TypeaheadStatusView;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.view.inflation.DynamicLayoutInflater;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: topRequestClose */
public class NearbySearchFragment extends FbFragment {
    public static final Class<?> f756a = NearbySearchFragment.class;
    private NavigationLogger al;
    public Clock am;
    public ListView an;
    public EditText ao;
    public TypeaheadStatusView ap;
    private NearbySearchCategoriesView aq;
    @Nullable
    public Location ar;
    public String as = null;
    private SearchArea at;
    private boolean au;
    private ImmutableList<SearchSuggestion> av;
    private Operation aw;
    private InflatedLayoutLocationSetter ax;
    private AbstractFbErrorReporter ay;
    private DynamicLayoutInflater az;
    private DefaultBlueServiceOperationFactory f757b;
    private FbUriIntentHandler f758c;
    public NearbySearchAnalytics f759d;
    private NearbySearchAdapter f760e;
    private SearchSuggestionHistoryManager f761f;
    private DefaultAndroidThreadUtil f762g;
    private InputMethodManager f763h;
    private FbLocationCache f764i;

    /* compiled from: topRequestClose */
    class C00931 implements TextWatcher {
        final /* synthetic */ NearbySearchFragment f746a;

        C00931(NearbySearchFragment nearbySearchFragment) {
            this.f746a = nearbySearchFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            NearbySearchFragment.aq(this.f746a);
        }
    }

    /* compiled from: topRequestClose */
    class C00953 implements OnItemClickListener {
        final /* synthetic */ NearbySearchFragment f749a;

        C00953(NearbySearchFragment nearbySearchFragment) {
            this.f749a = nearbySearchFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            NearbySearchFragment.m1052g(this.f749a, i - this.f749a.an.getHeaderViewsCount());
        }
    }

    /* compiled from: topRequestClose */
    class C00964 implements OnScrollListener {
        final /* synthetic */ NearbySearchFragment f750a;

        C00964(NearbySearchFragment nearbySearchFragment) {
            this.f750a = nearbySearchFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            NearbySearchFragment.av(this.f750a);
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: topRequestClose */
    public class C00975 {
        final /* synthetic */ NearbySearchFragment f751a;

        C00975(NearbySearchFragment nearbySearchFragment) {
            this.f751a = nearbySearchFragment;
        }

        public final void m1029a(SearchSuggestion searchSuggestion) {
            this.f751a.f759d.m391a(this.f751a.ao.getText().toString(), SearchSelectionType.CATEGORY_PRESET, searchSuggestion.d.b.asList(), null, this.f751a.as, null, this.f751a.ar, searchSuggestion.c);
            this.f751a.m1035a(searchSuggestion);
        }
    }

    /* compiled from: topRequestClose */
    class C00997 implements Predicate<TypeaheadPlaceWithLayout> {
        final /* synthetic */ NearbySearchFragment f755a;

        C00997(NearbySearchFragment nearbySearchFragment) {
            this.f755a = nearbySearchFragment;
        }

        public boolean apply(@Nullable Object obj) {
            TypeaheadPlaceWithLayout typeaheadPlaceWithLayout = (TypeaheadPlaceWithLayout) obj;
            boolean z = (typeaheadPlaceWithLayout == null || typeaheadPlaceWithLayout.typeaheadPlace == null || typeaheadPlaceWithLayout.typeaheadPlace.f400e == null) ? false : true;
            if (!z) {
                BLog.a(NearbySearchFragment.f756a, "filtering out invalid TypeaheadPlace result");
            }
            return z;
        }
    }

    public final void m1056d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1992226563);
        super.d(bundle);
        Preconditions.checkArgument(ao().getIntent().hasExtra("search_area"), "Missing search area info in intent");
        this.f757b = DefaultBlueServiceOperationFactory.b(an());
        this.f758c = FbUriIntentHandler.a(an());
        this.f759d = NearbySearchAnalytics.m389b(an());
        this.f762g = DefaultAndroidThreadUtil.b(an());
        this.f763h = InputMethodManagerMethodAutoProvider.b(an());
        this.f764i = FbLocationCache.b(an());
        this.al = NavigationLogger.a(an());
        this.ax = InflatedLayoutLocationSetter.m1064b(an());
        this.ay = (AbstractFbErrorReporter) FbErrorReporterImpl.a(an());
        this.az = DynamicLayoutInflater.b(an());
        this.am = (Clock) SystemClockMethodAutoProvider.a(an());
        this.at = (SearchArea) ao().getIntent().getParcelableExtra("search_area");
        this.ar = (Location) ao().getIntent().getParcelableExtra("user_location");
        this.au = ao().getIntent().getBooleanExtra("user_defined_search_location", false);
        FbInjector an = an();
        this.f761f = new SearchSuggestionHistoryManager((FbSharedPreferences) FbSharedPreferencesImpl.a(an), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(an), IdBasedProvider.a(an, 4442));
        this.am = (Clock) SystemClockMethodAutoProvider.a(an());
        this.av = this.f761f.f321d;
        m1049e();
        at();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -26451249, a);
    }

    public final View m1055a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -55589559);
        View inflate = layoutInflater.inflate(2130905408, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1684980623, a);
        return inflate;
    }

    private void m1049e() {
        this.ao = (EditText) e(2131564165);
        this.ao.addTextChangedListener(new C00931(this));
    }

    public static void aq(NearbySearchFragment nearbySearchFragment) {
        int length = nearbySearchFragment.ao.getText().length();
        final String obj = nearbySearchFragment.ao.getText().toString();
        if (length > 0) {
            nearbySearchFragment.f762g.b(new Runnable(nearbySearchFragment) {
                final /* synthetic */ NearbySearchFragment f748b;

                public void run() {
                    if (obj.equals(this.f748b.ao.getText().toString())) {
                        this.f748b.m1043a(obj);
                    }
                }
            }, 300);
        }
        if (length > 0) {
            nearbySearchFragment.ar();
            return;
        }
        nearbySearchFragment.ap.setVisibility(8);
        nearbySearchFragment.as();
    }

    private void ar() {
        if (this.an.getHeaderViewsCount() > 0) {
            this.an.removeHeaderView(this.aq);
        }
        this.f760e.m1026a(Collections.emptyList(), Collections.emptyList(), this.ar);
    }

    private void as() {
        if (this.an.getHeaderViewsCount() == 0) {
            this.an.setAdapter(null);
            this.an.addHeaderView(this.aq, null, false);
            this.an.setAdapter(this.f760e);
        }
        this.f760e.m1025a(this.av);
    }

    private void at() {
        this.ap = (TypeaheadStatusView) e(2131564167);
        this.an = (ListView) e(2131564166);
        this.an.setOnItemClickListener(new C00953(this));
        this.an.setOnScrollListener(new C00964(this));
        this.aq = au();
        this.an.addHeaderView(this.aq, null, false);
        this.f760e = new NearbySearchAdapter(this.ax, this.az, this.ay, getContext());
        this.f760e.m1025a(this.av);
        this.an.setAdapter(this.f760e);
    }

    private NearbySearchCategoriesView au() {
        NearbySearchCategoriesView nearbySearchCategoriesView = new NearbySearchCategoriesView(getContext());
        C00975 c00975 = new C00975(this);
        Iterator it = nearbySearchCategoriesView.f735a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            nearbySearchCategoriesView.findViewById(((Integer) entry.getKey()).intValue()).setOnClickListener(new C00921(nearbySearchCategoriesView, c00975, entry));
        }
        return nearbySearchCategoriesView;
    }

    public static void m1052g(NearbySearchFragment nearbySearchFragment, int i) {
        Object item = nearbySearchFragment.f760e.getItem(i);
        if (item instanceof SearchSuggestion) {
            SearchSuggestion searchSuggestion = (SearchSuggestion) item;
            nearbySearchFragment.m1034a(i, searchSuggestion);
            nearbySearchFragment.m1035a(searchSuggestion);
        } else if (item instanceof TypeaheadPlaceWithLayout) {
            nearbySearchFragment.m1036a(((TypeaheadPlaceWithLayout) item).typeaheadPlace, i);
        } else {
            throw new RuntimeException("unexpected object type " + item);
        }
    }

    private void m1034a(int i, SearchSuggestion searchSuggestion) {
        SearchSelectionType searchSelectionType;
        List asList;
        if (this.an.getHeaderViewsCount() > 0) {
            searchSelectionType = SearchSelectionType.HISTORY_SUGGESTION;
        } else {
            searchSelectionType = SearchSelectionType.TYPEAHEAD_SUGGESTION;
        }
        if (searchSuggestion.d != null) {
            asList = searchSuggestion.d.b.asList();
        } else {
            asList = Collections.emptyList();
        }
        this.f759d.m391a(this.ao.getText().toString(), searchSelectionType, asList, null, this.as, Integer.valueOf(i), this.ar, searchSuggestion.c);
    }

    private void m1035a(SearchSuggestion searchSuggestion) {
        av(this);
        if (searchSuggestion.d != null) {
            NearbySearchAnalytics nearbySearchAnalytics = this.f759d;
            ImmutableSet immutableSet = searchSuggestion.d.b;
            String str = this.as;
            if (!immutableSet.isEmpty()) {
                HoneyClientEventFast a = nearbySearchAnalytics.f298a.a("category_selected", true);
                if (a.a()) {
                    a.a("places_search").a("topic_ids", (Long) immutableSet.toArray()[0]).a("session_id", str);
                    a.b();
                }
            }
        }
        this.f761f.m412a(searchSuggestion);
        this.av = this.f761f.f321d;
        Intent intent = new Intent();
        intent.putExtra("result_place_search_suggestion", searchSuggestion);
        intent.putExtra("result_search_area", this.at);
        ao().setResult(-1, intent);
        ao().finish();
    }

    private void m1036a(TypeaheadPlace typeaheadPlace, int i) {
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, typeaheadPlace.f396a);
        String b = SecureHashUtil.b(typeaheadPlace.f396a + this.am.a());
        this.f759d.m391a(this.ao.getText().toString(), SearchSelectionType.PAGE, Lists.a(new Long[]{Long.valueOf(Long.parseLong(typeaheadPlace.f396a))}), b, this.as, Integer.valueOf(i), this.ar, null);
        Bundle bundle = new Bundle();
        ModelBundle.b(bundle, typeaheadPlace.f396a, typeaheadPlace.f397b, typeaheadPlace.f399d.b());
        bundle.putParcelable("extra_user_location", this.ar);
        if (this.f758c.a(getContext(), formatStrLocaleSafe, bundle)) {
            this.al.a("via_nearby_result");
            return;
        }
        BLog.b(f756a, "Failed navigating to page id = %s ", new Object[]{typeaheadPlace.f396a});
    }

    private void m1043a(final String str) {
        float f;
        float f2 = 0.0f;
        final long a = this.am.a();
        ImmutableLocation a2 = this.f764i.a(1800000);
        this.ar = a2 == null ? null : a2.l();
        if (!(this.au || this.ar == null)) {
            this.at = new SearchArea(this.ar, this.at.f659b);
        }
        Builder builder = new Builder(this.at, str);
        builder.f702c = this.ar;
        Builder builder2 = builder;
        if (this.ar == null) {
            f = 0.0f;
        } else {
            f = (float) this.ar.getAltitude();
        }
        builder2.f703d = f;
        builder2 = builder2;
        if (this.ar == null) {
            f = 0.0f;
        } else {
            f = this.ar.getBearing();
        }
        builder2.f705f = f;
        builder = builder2;
        if (this.ar != null) {
            f2 = this.ar.getSpeed();
        }
        builder.f707h = f2;
        Parcelable nearbyTypeaheadWithLayoutsParams = new NearbyTypeaheadWithLayoutsParams(new SearchNearbyPlacesParams(builder), new FetchNearbyPlacesLayoutParams());
        Bundle bundle = new Bundle();
        bundle.putParcelable("searchNearbyPlacesAndLayoutsParams", nearbyTypeaheadWithLayoutsParams);
        if (this.aw != null) {
            this.aw.d();
        }
        this.aw = BlueServiceOperationFactoryDetour.a(this.f757b, "search_nearby_places_and_layout", bundle, -62287666);
        this.f760e.m1026a(Collections.emptyList(), Collections.emptyList(), this.ar);
        this.ap.setVisibility(0);
        this.ap.m1066a();
        this.f762g.a(this.aw.a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ NearbySearchFragment f754c;

            public final void m1031a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                NearbySearchAnalytics nearbySearchAnalytics = this.f754c.f759d;
                String str = str;
                String str2 = this.f754c.as;
                HoneyClientEventFast a = nearbySearchAnalytics.f298a.a("search_results_loaded", true);
                if (a.a()) {
                    a.a("places_search").a("search_query_string", str).a("session_id", str2);
                    a.b();
                }
                this.f754c.ap.setVisibility(8);
                this.f754c.m1037a((NearbyTypeaheadWithLayoutsResult) operationResult.k());
                this.f754c.f759d.m390a((float) (this.f754c.am.a() - a));
            }

            protected final void m1030a(ServiceException serviceException) {
                NearbySearchAnalytics nearbySearchAnalytics = this.f754c.f759d;
                String message = serviceException.getMessage();
                String str = str;
                String str2 = this.f754c.as;
                HoneyClientEventFast a = nearbySearchAnalytics.f298a.a("search_results_error", true);
                if (a.a()) {
                    a.a("places_search").a("search_error", message).a("search_query_string", str).a("session_id", str2);
                    a.b();
                }
                BLog.b(NearbySearchFragment.f756a, "Error searching nearby places", serviceException);
                this.f754c.ap.setVisibility(0);
                this.f754c.ap.m1067a(this.f754c.jW_().getString(2131230758));
            }

            protected final void m1032a(CancellationException cancellationException) {
                super.a(cancellationException);
                NearbySearchAnalytics nearbySearchAnalytics = this.f754c.f759d;
                String str = str;
                String str2 = this.f754c.as;
                HoneyClientEventFast a = nearbySearchAnalytics.f298a.a("search_cancel", true);
                if (a.a()) {
                    a.a("places_search").a("search_query_string", str).a("session_id", str2);
                    a.b();
                }
            }
        });
    }

    public static void av(NearbySearchFragment nearbySearchFragment) {
        nearbySearchFragment.f763h.hideSoftInputFromWindow(nearbySearchFragment.an.getWindowToken(), 0);
    }

    private List<TypeaheadPlaceWithLayout> m1033a(List<TypeaheadPlaceWithLayout> list) {
        return Lists.a(Iterables.c(list, new C00997(this)));
    }

    private void m1037a(NearbyTypeaheadWithLayoutsResult nearbyTypeaheadWithLayoutsResult) {
        this.as = nearbyTypeaheadWithLayoutsResult.f654a;
        List a = m1033a(nearbyTypeaheadWithLayoutsResult.f657d);
        if (this.ao.getText().toString().equals(nearbyTypeaheadWithLayoutsResult.f655b)) {
            this.f760e.m1026a(nearbyTypeaheadWithLayoutsResult.f656c, a, this.ar);
            if (nearbyTypeaheadWithLayoutsResult.f656c.isEmpty() && a.isEmpty()) {
                this.ap.setVisibility(0);
                this.ap.m1067a(jW_().getString(2131236618));
                return;
            }
            this.ap.setVisibility(8);
        }
    }
}
