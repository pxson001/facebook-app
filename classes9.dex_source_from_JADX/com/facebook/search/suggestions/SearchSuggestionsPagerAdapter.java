package com.facebook.search.suggestions;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.inject.Assisted;
import com.facebook.marketplace.tab.MarketplaceTabFragmentFactory;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.SuggestionTabType;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.SuggestionsFragment.DispatchTypeaheadSuggestionClickVisitor;
import com.facebook.search.suggestions.SuggestionsFragment.ExternalStateChangeListener;
import com.facebook.search.suggestions.SuggestionsFragment.ListInteractionListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.systems.ReactSearchTypeaheadSystem;
import com.facebook.search.suggestions.systems.SearchTypeaheadSystem;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.typeahead.BaseTypeaheadController.OnNewSuggestionsListener;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: 😕 */
public class SearchSuggestionsPagerAdapter extends PagerAdapter implements SearchSuggestionListController {
    private final Context f18a;
    private final SingleSearchSuggestionListControllerProvider f19b;
    private final SingleSearchSuggestionsReactControllerProvider f20c;
    private final ImmutableList<SuggestionTabType> f21d = SuggestionTabType.getTabs(this.f24g);
    private final FragmentManager f22e;
    private final boolean f23f;
    private GraphSearchQuery f24g;
    private int f25h;
    private Map<SuggestionTabType, SearchSuggestionListController> f26i;

    /* compiled from: 😕 */
    /* synthetic */ class C00001 {
        static final /* synthetic */ int[] f16a = new int[SuggestionTabType.values().length];
        static final /* synthetic */ int[] f17b = new int[ScopedEntityType.values().length];

        static {
            try {
                f17b[ScopedEntityType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17b[ScopedEntityType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17b[ScopedEntityType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17b[ScopedEntityType.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17b[ScopedEntityType.EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17b[ScopedEntityType.MARKETPLACE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16a[SuggestionTabType.SCOPED.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public final ImmutableList<TypeaheadUnit> mo2a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        return ((SearchSuggestionListController) this.f26i.get(m35b(typeaheadResponse.a.c))).mo2a((TypeaheadResponse) typeaheadResponse);
    }

    @Inject
    public SearchSuggestionsPagerAdapter(@Assisted Context context, @Assisted GraphSearchQuery graphSearchQuery, @Assisted Boolean bool, @Assisted FragmentManager fragmentManager, SingleSearchSuggestionListControllerProvider singleSearchSuggestionListControllerProvider, SingleSearchSuggestionsReactControllerProvider singleSearchSuggestionsReactControllerProvider) {
        this.f23f = bool.booleanValue();
        this.f19b = singleSearchSuggestionListControllerProvider;
        this.f20c = singleSearchSuggestionsReactControllerProvider;
        this.f24g = graphSearchQuery;
        this.f18a = context;
        this.f22e = fragmentManager;
        Preconditions.checkState(this.f21d.contains(SuggestionTabType.SCOPED));
        Preconditions.checkState(this.f21d.contains(SuggestionTabType.GLOBAL));
        this.f26i = new HashMap();
        m37s();
    }

    public final void mo27o() {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo27o();
        }
    }

    public final void mo28p() {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo28p();
        }
    }

    public final void mo6a(CallerContext callerContext, RefreshPolicy refreshPolicy) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo6a(callerContext, refreshPolicy);
        }
    }

    public final void mo29q() {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo29q();
        }
    }

    public final void mo9a(ExternalStateChangeListener externalStateChangeListener) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo9a(externalStateChangeListener);
        }
    }

    public final void mo7a(GraphSearchQuery graphSearchQuery) {
        ((SearchSuggestionListController) this.f26i.get(SuggestionTabType.SCOPED)).mo7a(graphSearchQuery);
        ((SearchSuggestionListController) this.f26i.get(SuggestionTabType.GLOBAL)).mo7a(GraphSearchQuery.a(graphSearchQuery));
    }

    public final void mo10a(OnNewSuggestionsListener onNewSuggestionsListener) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo10a(onNewSuggestionsListener);
        }
    }

    public final void mo13a(String str, ImmutableList<TypeaheadUnit> immutableList) {
        ((SearchSuggestionListController) this.f26i.get(m35b(str))).mo13a(str, (ImmutableList) immutableList);
    }

    public final void mo3a(int i) {
        ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo3a(i);
    }

    public final void mo12a(String str, NullStateStatus nullStateStatus, boolean z) {
        ((SearchSuggestionListController) this.f26i.get(m35b(str))).mo12a(str, nullStateStatus, false);
    }

    public final void mo14a(boolean z) {
    }

    public final int m55b() {
        return this.f21d.size();
    }

    public final boolean m54a(View view, Object obj) {
        return view == obj;
    }

    public final Object m40a(ViewGroup viewGroup, int i) {
        boolean z = i >= 0 && i < b();
        Preconditions.checkArgument(z);
        View f = ((SearchSuggestionListController) this.f26i.get(this.f21d.get(i))).mo18f();
        viewGroup.addView(f);
        return f;
    }

    public final void m44a(ViewGroup viewGroup, int i, Object obj) {
        boolean z = i >= 0 && i < b();
        Preconditions.checkArgument(z);
        viewGroup.removeView((View) obj);
        ((SearchSuggestionListController) this.f26i.get(this.f21d.get(i))).mo14a(false);
    }

    public final CharSequence J_(int i) {
        switch (C00001.f16a[((SuggestionTabType) this.f21d.get(i)).ordinal()]) {
            case 1:
                return m36r();
            default:
                return this.f18a.getString(2131237400);
        }
    }

    public final void mo26n() {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo26n();
        }
        this.f26i.clear();
    }

    public final ImmutableList<View> mo15c() {
        Builder builder = new Builder();
        for (SearchSuggestionListController c : this.f26i.values()) {
            builder.b(c.mo15c());
        }
        return builder.b();
    }

    @Nullable
    public final MultiRowAdapter mo16d() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo16d();
    }

    public final FetchState mo17e() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo17e();
    }

    @Nullable
    public final View mo18f() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo18f();
    }

    @Nullable
    public final ScrollingViewProxy mo19g() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo19g();
    }

    @Nullable
    public final NullStateSupplier mo20h() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo20h();
    }

    public final GraphSearchQuery mo21i() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo21i();
    }

    @Nullable
    public final BaseSuggestionsTypeaheadController mo22j() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo22j();
    }

    @Nullable
    public final SearchTypeaheadSystem mo23k() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo23k();
    }

    @Nullable
    public final TypeaheadUnitCollection mo24l() {
        return ((SearchSuggestionListController) this.f26i.get(this.f21d.get(this.f25h))).mo24l();
    }

    @Nullable
    public final TypeaheadUnitCollection mo1a(String str) {
        return ((SearchSuggestionListController) this.f26i.get(m35b(str))).mo1a(str);
    }

    public final void mo4a(Context context, DispatchTypeaheadSuggestionClickVisitor dispatchTypeaheadSuggestionClickVisitor) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo4a(context, dispatchTypeaheadSuggestionClickVisitor);
        }
    }

    public final void mo5a(@Nullable View view, ListInteractionListener listInteractionListener, boolean z) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo5a(null, listInteractionListener, z);
        }
    }

    public final void mo11a(LazyView<ProgressBar> lazyView, @Nullable View view, boolean z) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo11a(null, view, false);
        }
    }

    public final void mo8a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
        int size = this.f21d.size();
        for (int i = 0; i < size; i++) {
            ((SearchSuggestionListController) this.f26i.get((SuggestionTabType) this.f21d.get(i))).mo8a(suggestionsTypeaheadAnalyticHelper);
        }
        NullStateSupplier h = ((SearchSuggestionListController) this.f26i.get(SuggestionTabType.SCOPED)).mo20h();
        if (h != null) {
            h.a(this.f24g);
        }
    }

    public final void mo25m() {
        ((SearchSuggestionListController) this.f26i.get(SuggestionTabType.GLOBAL)).mo25m();
    }

    private String m36r() {
        ScopedEntityType scopedEntityType = this.f24g.h;
        if (scopedEntityType == null) {
            return "";
        }
        int i;
        switch (C00001.f17b[scopedEntityType.ordinal()]) {
            case 1:
                i = 2131237405;
                break;
            case 2:
                i = 2131237402;
                break;
            case 3:
                i = 2131237401;
                break;
            case 4:
                i = 2131237403;
                break;
            case 5:
                i = 2131237404;
                break;
            case 6:
                i = 2131237406;
                break;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Search query had an invalid scoped entity type of %s", scopedEntityType.toString()));
        }
        return this.f18a.getString(i);
    }

    public final void m56b(int i) {
        boolean z;
        if (i < 0 || i >= b()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f25h = i;
        for (int i2 = 0; i2 < this.f21d.size(); i2++) {
            boolean z2;
            SearchSuggestionListController searchSuggestionListController = (SearchSuggestionListController) this.f26i.get(this.f21d.get(i2));
            if (i2 == i) {
                z2 = true;
            } else {
                z2 = false;
            }
            searchSuggestionListController.mo14a(z2);
        }
    }

    private SuggestionTabType m35b(String str) {
        boolean z = false;
        if (this.f24g != null) {
            z = str.equals(this.f24g.f + ScopedSearchStyle.TAB.toString());
        }
        return z ? SuggestionTabType.SCOPED : SuggestionTabType.GLOBAL;
    }

    private void m37s() {
        Object singleSearchSuggestionsReactController;
        Preconditions.checkState(this.f21d.contains(SuggestionTabType.SCOPED));
        Preconditions.checkState(this.f21d.contains(SuggestionTabType.GLOBAL));
        if (GraphSearchConfig.c(this.f24g)) {
            SingleSearchSuggestionsReactControllerProvider singleSearchSuggestionsReactControllerProvider = this.f20c;
            Context context = this.f18a;
            GraphSearchQuery graphSearchQuery = this.f24g;
            singleSearchSuggestionsReactController = new SingleSearchSuggestionsReactController(context, graphSearchQuery, this.f22e, MarketplaceTabFragmentFactory.a(singleSearchSuggestionsReactControllerProvider), (ReactSearchSugestionsTypeaheadControllerProvider) singleSearchSuggestionsReactControllerProvider.getOnDemandAssistedProviderForStaticDi(ReactSearchSugestionsTypeaheadControllerProvider.class), new ReactSearchTypeaheadSystem(GraphSearchTitleSearchBoxSupplier.a(singleSearchSuggestionsReactControllerProvider)), ReactSearchEventBus.a(singleSearchSuggestionsReactControllerProvider));
        } else {
            singleSearchSuggestionsReactController = this.f19b.m114a(this.f18a, this.f24g);
        }
        this.f26i.put(SuggestionTabType.SCOPED, singleSearchSuggestionsReactController);
        this.f26i.put(SuggestionTabType.GLOBAL, this.f19b.m114a(this.f18a, GraphSearchQuery.a(this.f24g)));
    }
}
