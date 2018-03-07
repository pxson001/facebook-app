package com.facebook.search.results.rows.sections.relatednews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsTitlePartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRE_INSTALLED_FONT_SANS_SERIF_BOLD */
public class SearchResultsRelatedNewsContentPartDefinition<E extends HasPositionInformation & OldCanLogEntityNavigation> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, BetterTextView> {
    public static final ViewType f24950a = new C26261();
    private static final PaddingStyle f24951b;
    private static SearchResultsRelatedNewsContentPartDefinition f24952f;
    private static final Object f24953g = new Object();
    private final SearchResultsNewsTitlePartDefinition f24954c;
    private final SearchResultsRelatedNewsClickListenerPartDefinition f24955d;
    private final BackgroundPartDefinition f24956e;

    /* compiled from: PRE_INSTALLED_FONT_SANS_SERIF_BOLD */
    final class C26261 extends ViewType {
        C26261() {
        }

        public final View m28297a(Context context) {
            return LayoutInflater.from(context).inflate(2130905454, null);
        }
    }

    private static SearchResultsRelatedNewsContentPartDefinition m28299b(InjectorLike injectorLike) {
        return new SearchResultsRelatedNewsContentPartDefinition(SearchResultsNewsTitlePartDefinition.m28090a(injectorLike), SearchResultsRelatedNewsClickListenerPartDefinition.m28294a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28301a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        subParts.a(this.f24954c, SearchResultsNewsTitlePartDefinition.m28092b(graphQLNode));
        subParts.a(this.f24956e, new StylingData(f24951b));
        subParts.a(this.f24955d, graphQLNode);
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 4.0f;
        a = a;
        a.c = -2.0f;
        f24951b = a.i();
    }

    @Inject
    public SearchResultsRelatedNewsContentPartDefinition(SearchResultsNewsTitlePartDefinition searchResultsNewsTitlePartDefinition, SearchResultsRelatedNewsClickListenerPartDefinition searchResultsRelatedNewsClickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24954c = searchResultsNewsTitlePartDefinition;
        this.f24955d = searchResultsRelatedNewsClickListenerPartDefinition;
        this.f24956e = backgroundPartDefinition;
    }

    public static SearchResultsRelatedNewsContentPartDefinition m28298a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsRelatedNewsContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24953g) {
                SearchResultsRelatedNewsContentPartDefinition searchResultsRelatedNewsContentPartDefinition;
                if (a2 != null) {
                    searchResultsRelatedNewsContentPartDefinition = (SearchResultsRelatedNewsContentPartDefinition) a2.a(f24953g);
                } else {
                    searchResultsRelatedNewsContentPartDefinition = f24952f;
                }
                if (searchResultsRelatedNewsContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28299b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24953g, b3);
                        } else {
                            f24952f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsRelatedNewsContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m28300a() {
        return f24950a;
    }
}
