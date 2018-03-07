package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition.TabSwitchData;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPEAT_ALL_AND_SHUFFLE */
public class SearchResultsSeeMoreFigPartDefinition<T, E extends HasContext & HasFeedItemPosition & HasSearchResultsContext & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<T>>, Void, E, View> {
    public static final ViewType f23828a = new C25431();
    private static final PaddingStyle f23829b;
    private static final PaddingStyle f23830c;
    private static SearchResultsSeeMoreFigPartDefinition f23831i;
    private static final Object f23832j = new Object();
    private final TextPartDefinition f23833d;
    private final SearchResultsSeeMoreClickListenerPartDefinition f23834e;
    private final SearchResultsTabSwitchPartDefinition f23835f;
    private final BackgroundPartDefinition f23836g;
    private final QeAccessor f23837h;

    /* compiled from: REPEAT_ALL_AND_SHUFFLE */
    final class C25431 extends ViewType {
        C25431() {
        }

        public final View m27445a(Context context) {
            BetterTextView betterTextView = new BetterTextView(context);
            betterTextView.setTextAppearance(betterTextView.getContext(), 2131624531);
            betterTextView.setGravity(3);
            return betterTextView;
        }
    }

    private static SearchResultsSeeMoreFigPartDefinition m27448b(InjectorLike injectorLike) {
        return new SearchResultsSeeMoreFigPartDefinition(TextPartDefinition.a(injectorLike), SearchResultsSeeMoreClickListenerPartDefinition.m27600a(injectorLike), SearchResultsTabSwitchPartDefinition.m27607a(injectorLike), BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27450a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f23833d, ((HasContext) anyEnvironment).getContext().getString(2131239062));
        SearchResultsTab a = m27446a(searchResultsCollectionUnit);
        if (a != null) {
            subParts.a(this.f23835f, new TabSwitchData(a, searchResultsCollectionUnit));
        } else {
            subParts.a(this.f23834e, new SeeMoreData(searchResultsCollectionUnit, SearchResultsSeeMorePartDefinition.f23839b, 2131239062));
        }
        subParts.a(this.f23836g, new StylingData(feedProps, SearchResultsSeeMorePartDefinition.m27457a(searchResultsCollectionUnit) ? f23830c : f23829b, Position.BOTTOM));
        return null;
    }

    public final boolean m27451a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) ((FeedProps) obj).a;
        if (m27446a(searchResultsCollectionUnit) == null || !this.f23837h.a(ExperimentsForSearchAbTestModule.p, false)) {
            return searchResultsCollectionUnit.mo1330m().isPresent() && searchResultsCollectionUnit.f23460a.isPresent() && SearchResultsIntentBuilder.a((GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.f23460a.get()) && searchResultsCollectionUnit.mo1321k() != GraphQLGraphSearchResultRole.NEWS_MODULE && searchResultsCollectionUnit.f23460a.get() != GraphQLGraphSearchResultsDisplayStyle.WEB && this.f23837h.a(ExperimentsForSearchAbTestModule.p, false);
        } else {
            return true;
        }
    }

    static {
        Builder a = Builder.a();
        a.b = 4.0f;
        a = a;
        a.c = 2.0f;
        f23829b = a.i();
        a = Builder.a();
        a.b = 1.0f;
        a = a;
        a.c = 2.0f;
        f23830c = a.i();
    }

    public static SearchResultsSeeMoreFigPartDefinition m27447a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMoreFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23832j) {
                SearchResultsSeeMoreFigPartDefinition searchResultsSeeMoreFigPartDefinition;
                if (a2 != null) {
                    searchResultsSeeMoreFigPartDefinition = (SearchResultsSeeMoreFigPartDefinition) a2.a(f23832j);
                } else {
                    searchResultsSeeMoreFigPartDefinition = f23831i;
                }
                if (searchResultsSeeMoreFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27448b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23832j, b3);
                        } else {
                            f23831i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMoreFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSeeMoreFigPartDefinition(TextPartDefinition textPartDefinition, SearchResultsSeeMoreClickListenerPartDefinition searchResultsSeeMoreClickListenerPartDefinition, SearchResultsTabSwitchPartDefinition searchResultsTabSwitchPartDefinition, BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor) {
        this.f23833d = textPartDefinition;
        this.f23834e = searchResultsSeeMoreClickListenerPartDefinition;
        this.f23835f = searchResultsTabSwitchPartDefinition;
        this.f23836g = backgroundPartDefinition;
        this.f23837h = qeAccessor;
    }

    public final ViewType m27449a() {
        return f23828a;
    }

    private SearchResultsTab m27446a(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        if (!this.f23837h.a(ExperimentsForSearchAbTestModule.w, false) && SearchResultsSeeMorePartDefinition.f23840c.containsKey(searchResultsCollectionUnit.mo1321k())) {
            return (SearchResultsTab) SearchResultsSeeMorePartDefinition.f23840c.get(searchResultsCollectionUnit.mo1321k());
        }
        return null;
    }
}
