package com.facebook.search.results.rows.sections.seemore;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.HasSearchResultsPerformanceLogger;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsSeeMorePostsUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreLogger;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRESENCE_STAYED_THE_SAME */
public class SearchResultsSeeMoreTrendingPostsPartDefinition<E extends HasPositionInformation & HasContext & HasFeedItemPosition & HasSearchResultsContext & HasSearchResultsPerformanceLogger> extends MultiRowSinglePartDefinition<SearchResultsSeeMorePostsUnit, Void, E, BetterTextView> {
    public static final ViewType<BetterTextView> f24999a = ViewType.a(2130907050);
    private static final SearchResultsSeeMoreLogger f25000b = new C26291();
    private static final PaddingStyle f25001c;
    private static SearchResultsSeeMoreTrendingPostsPartDefinition f25002h;
    private static final Object f25003i = new Object();
    private final TextPartDefinition f25004d;
    private final SearchResultsSeeMoreClickListenerPartDefinition f25005e;
    private final AllCapsTransformationMethod f25006f;
    private final BackgroundPartDefinition f25007g;

    /* compiled from: PRESENCE_STAYED_THE_SAME */
    final class C26291 implements SearchResultsSeeMoreLogger {
        C26291() {
        }

        public final <E extends HasSearchResultsContext & HasFeedItemPosition> void mo1334a(SearchResultsLogger searchResultsLogger, E e, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit) {
            SearchResultsSeeMorePostsUnit searchResultsSeeMorePostsUnit = (SearchResultsSeeMorePostsUnit) searchResultsSeeMoreFeedUnit;
            searchResultsLogger.m25481a(e.mo1248s(), searchResultsSeeMorePostsUnit.mo1321k(), (String) searchResultsSeeMorePostsUnit.mo1322l().orNull(), ((HasFeedItemPosition) e).mo1245a(searchResultsSeeMorePostsUnit));
        }
    }

    private static SearchResultsSeeMoreTrendingPostsPartDefinition m28339b(InjectorLike injectorLike) {
        return new SearchResultsSeeMoreTrendingPostsPartDefinition(TextPartDefinition.a(injectorLike), SearchResultsSeeMoreClickListenerPartDefinition.m27600a(injectorLike), AllCapsTransformationMethod.b(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28341a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsSeeMorePostsUnit searchResultsSeeMorePostsUnit = (SearchResultsSeeMorePostsUnit) obj;
        subParts.a(2131558956, this.f25004d, this.f25006f.getTransformation(searchResultsSeeMorePostsUnit.f23512b, null));
        subParts.a(this.f25007g, new StylingData(FeedProps.c(searchResultsSeeMorePostsUnit), f25001c, 2131362097, 2131362097, Position.MIDDLE));
        subParts.a(2131558956, this.f25005e, new SeeMoreData(searchResultsSeeMorePostsUnit, f25000b, 2131239045));
        return null;
    }

    public final boolean m28342a(Object obj) {
        SearchResultsSeeMorePostsUnit searchResultsSeeMorePostsUnit = (SearchResultsSeeMorePostsUnit) obj;
        return searchResultsSeeMorePostsUnit.f23512b != null && searchResultsSeeMorePostsUnit.mo1331n() == GraphQLGraphSearchResultsDisplayStyle.TRENDING_FINITE_SERP_SEE_MORE;
    }

    static {
        Builder c = Builder.c();
        c.b = 4.0f;
        c = c;
        c.d = 12.0f;
        c = c;
        c.c = 4.0f;
        f25001c = c.i();
    }

    public static SearchResultsSeeMoreTrendingPostsPartDefinition m28338a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMoreTrendingPostsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25003i) {
                SearchResultsSeeMoreTrendingPostsPartDefinition searchResultsSeeMoreTrendingPostsPartDefinition;
                if (a2 != null) {
                    searchResultsSeeMoreTrendingPostsPartDefinition = (SearchResultsSeeMoreTrendingPostsPartDefinition) a2.a(f25003i);
                } else {
                    searchResultsSeeMoreTrendingPostsPartDefinition = f25002h;
                }
                if (searchResultsSeeMoreTrendingPostsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28339b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25003i, b3);
                        } else {
                            f25002h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMoreTrendingPostsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSeeMoreTrendingPostsPartDefinition(TextPartDefinition textPartDefinition, SearchResultsSeeMoreClickListenerPartDefinition searchResultsSeeMoreClickListenerPartDefinition, AllCapsTransformationMethod allCapsTransformationMethod, BackgroundPartDefinition backgroundPartDefinition) {
        this.f25004d = textPartDefinition;
        this.f25005e = searchResultsSeeMoreClickListenerPartDefinition;
        this.f25006f = allCapsTransformationMethod;
        this.f25007g = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m28340a() {
        return f24999a;
    }
}
