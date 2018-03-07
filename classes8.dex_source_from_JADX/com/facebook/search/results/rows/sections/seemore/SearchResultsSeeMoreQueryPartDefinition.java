package com.facebook.search.results.rows.sections.seemore;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryInterfaces.SearchResultsSeeMoreQuery;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel.QueryTitleModel;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PREVIEW */
public class SearchResultsSeeMoreQueryPartDefinition<E extends HasContext & HasPositionInformation & HasSearchResultPosition & HasSearchResultsContext> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsSeeMoreQuery>, Void, E, BetterTextView> {
    public static final ViewType<BetterTextView> f24990a = ViewType.a(2130907047);
    private static final StylingData f24991b;
    private static SearchResultsSeeMoreQueryPartDefinition f24992h;
    private static final Object f24993i = new Object();
    private final SearchBackgroundPartDefinition<E> f24994c;
    private final ClickListenerPartDefinition f24995d;
    public final Lazy<SearchResultsIntentBuilder> f24996e;
    public final Lazy<SearchResultsLogger> f24997f;
    public final Lazy<SecureContextHelper> f24998g;

    private static SearchResultsSeeMoreQueryPartDefinition m28332b(InjectorLike injectorLike) {
        return new SearchResultsSeeMoreQueryPartDefinition(SearchBackgroundPartDefinition.m27225a(injectorLike), ClickListenerPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3375), IdBasedSingletonScopeProvider.b(injectorLike, 10491), IdBasedSingletonScopeProvider.b(injectorLike, 968));
    }

    public final Object m28335a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24995d, new OnClickListener(this) {
            final /* synthetic */ SearchResultsSeeMoreQueryPartDefinition f24989c;

            public void onClick(View view) {
                String a;
                int a2 = Logger.a(2, EntryType.UI_INPUT_START, -1927637760);
                GraphQLGraphSearchResultRole d = searchResultsProps.m27106d();
                GraphQLGraphSearchResultsDisplayStyle c = SearchResultsSeeMoreQueryPartDefinition.m28333c(searchResultsProps);
                QueryTitleModel b = ((SearchResultsSeeMoreQueryModel) searchResultsProps.f23388a).m9845b();
                SearchResultsMutableContext s = ((HasSearchResultsContext) hasContext).mo1248s();
                ((SearchResultsLogger) this.f24989c.f24997f.get()).m25483a(s, d, null, c, ((HasSearchResultPosition) hasContext).mo1246a(searchResultsProps), SearchResultsEdgeUtil.m9803e(searchResultsProps.f23390c).size(), null);
                SearchResultsIntentBuilder searchResultsIntentBuilder = (SearchResultsIntentBuilder) this.f24989c.f24996e.get();
                if (b != null) {
                    a = b.m9838a();
                } else {
                    a = null;
                }
                Intent a3 = searchResultsIntentBuilder.a(c, a, ((SearchResultsSeeMoreQueryModel) searchResultsProps.f23388a).m9844a(), s.f23382q, SearchResultsSeeMoreQueryPartDefinition.m28330a((HasSearchResultsContext) hasContext), s.f23369d);
                a3.putExtra("search_theme", s.f23366a);
                ((SecureContextHelper) this.f24989c.f24998g.get()).a(a3, view.getContext());
                LogUtils.a(336758698, a2);
            }
        });
        subParts.a(this.f24994c, f24991b);
        return null;
    }

    public final boolean m28336a(Object obj) {
        return m28333c((SearchResultsProps) obj) != null;
    }

    static {
        Builder a = Builder.a();
        a.c = -1.0f;
        f24991b = new StylingData(null, a.i(), Position.BOTTOM);
    }

    public static SearchResultsSeeMoreQueryPartDefinition m28331a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMoreQueryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24993i) {
                SearchResultsSeeMoreQueryPartDefinition searchResultsSeeMoreQueryPartDefinition;
                if (a2 != null) {
                    searchResultsSeeMoreQueryPartDefinition = (SearchResultsSeeMoreQueryPartDefinition) a2.a(f24993i);
                } else {
                    searchResultsSeeMoreQueryPartDefinition = f24992h;
                }
                if (searchResultsSeeMoreQueryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28332b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24993i, b3);
                        } else {
                            f24992h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMoreQueryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSeeMoreQueryPartDefinition(SearchBackgroundPartDefinition searchBackgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Lazy<SearchResultsIntentBuilder> lazy, Lazy<SearchResultsLogger> lazy2, Lazy<SecureContextHelper> lazy3) {
        this.f24994c = searchBackgroundPartDefinition;
        this.f24995d = clickListenerPartDefinition;
        this.f24996e = lazy;
        this.f24997f = lazy2;
        this.f24998g = lazy3;
    }

    public final ViewType<BetterTextView> m28334a() {
        return f24990a;
    }

    public static SearchResultsSource m28330a(HasSearchResultsContext hasSearchResultsContext) {
        return SearchResultsSource.I.contains(hasSearchResultsContext.mo1248s().f23367b) ? SearchResultsSource.m : SearchResultsSource.l;
    }

    @Nullable
    public static GraphQLGraphSearchResultsDisplayStyle m28333c(SearchResultsProps<SearchResultsSeeMoreQuery> searchResultsProps) {
        ImmutableList c = ((SearchResultsSeeMoreQueryModel) searchResultsProps.f23388a).m9846c();
        if (c.isEmpty()) {
            return null;
        }
        int size = c.size();
        for (int i = 0; i < size; i++) {
            GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) c.get(i);
            if (SearchResultsIntentBuilder.a(graphQLGraphSearchResultsDisplayStyle)) {
                return graphQLGraphSearchResultsDisplayStyle;
            }
        }
        return null;
    }
}
