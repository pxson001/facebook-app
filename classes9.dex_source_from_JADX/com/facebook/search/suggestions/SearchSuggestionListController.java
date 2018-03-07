package com.facebook.search.suggestions;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.SuggestionsFragment.DispatchTypeaheadSuggestionClickVisitor;
import com.facebook.search.suggestions.SuggestionsFragment.ExternalStateChangeListener;
import com.facebook.search.suggestions.SuggestionsFragment.ListInteractionListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.systems.SearchTypeaheadSystem;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.ui.typeahead.BaseTypeaheadController.OnNewSuggestionsListener;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: 😳 */
public interface SearchSuggestionListController {
    @Nullable
    TypeaheadUnitCollection mo1a(String str);

    ImmutableList<TypeaheadUnit> mo2a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse);

    void mo3a(int i);

    void mo4a(Context context, DispatchTypeaheadSuggestionClickVisitor dispatchTypeaheadSuggestionClickVisitor);

    void mo5a(@Nullable View view, ListInteractionListener listInteractionListener, boolean z);

    void mo6a(CallerContext callerContext, RefreshPolicy refreshPolicy);

    void mo7a(GraphSearchQuery graphSearchQuery);

    void mo8a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper);

    void mo9a(ExternalStateChangeListener externalStateChangeListener);

    void mo10a(OnNewSuggestionsListener onNewSuggestionsListener);

    void mo11a(@Nullable LazyView<ProgressBar> lazyView, @Nullable View view, boolean z);

    void mo12a(String str, NullStateStatus nullStateStatus, boolean z);

    void mo13a(String str, ImmutableList<TypeaheadUnit> immutableList);

    void mo14a(boolean z);

    ImmutableList<View> mo15c();

    @Nullable
    MultiRowAdapter mo16d();

    FetchState mo17e();

    @Nullable
    View mo18f();

    @Nullable
    ScrollingViewProxy mo19g();

    @Nullable
    NullStateSupplier mo20h();

    GraphSearchQuery mo21i();

    @Nullable
    BaseSuggestionsTypeaheadController mo22j();

    @Nullable
    SearchTypeaheadSystem mo23k();

    @Nullable
    TypeaheadUnitCollection mo24l();

    void mo25m();

    void mo26n();

    void mo27o();

    void mo28p();

    void mo29q();
}
