package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
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
import com.facebook.multirow.parts.ContentViewContentDescriptionPartDefinition;
import com.facebook.multirow.parts.ContentViewMetaTextPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityGroupFacepilePartDefinition.FacepileData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY_TOPIC_FEEDS_CLASSIFICATIONS_KEY */
public class SearchResultsEntityWithFacepileLargeRowPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24231a = ViewType.a(2130903981);
    private static SearchResultsEntityWithFacepileLargeRowPartDefinition f24232h;
    private static final Object f24233i = new Object();
    private final BackgroundPartDefinition f24234b;
    private final OldSearchResultsEntityBasePartDefinition<E> f24235c;
    private final SearchResultsEntityGroupFacepilePartDefinition f24236d;
    private final ContentViewSubtitlePartDefinition f24237e;
    private final ContentViewContentDescriptionPartDefinition f24238f;
    private final ContentViewMetaTextPartDefinition f24239g;

    private static SearchResultsEntityWithFacepileLargeRowPartDefinition m27775b(InjectorLike injectorLike) {
        return new SearchResultsEntityWithFacepileLargeRowPartDefinition(BackgroundPartDefinition.a(injectorLike), OldSearchResultsEntityBasePartDefinition.m27674a(injectorLike), SearchResultsEntityGroupFacepilePartDefinition.m27721a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), ContentViewMetaTextPartDefinition.a(injectorLike));
    }

    public final Object m27777a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        subParts.a(this.f24235c, graphQLNode);
        subParts.a(this.f24234b, SearchResultsEntityConstants.f24177b);
        subParts.a(2131561192, this.f24236d, new FacepileData(9, SearchResultsEntityUtils.m27770e(graphQLNode)));
        subParts.a(this.f24237e, SearchResultsEntityUtils.m27759a(graphQLNode));
        subParts.a(this.f24238f, SearchResultsEntityUtils.m27765b(graphQLNode));
        subParts.a(this.f24239g, SearchResultsEntityUtils.m27772f(graphQLNode));
        return null;
    }

    public final boolean m27778a(Object obj) {
        return SearchResultsEntityUtils.m27768d((GraphQLNode) obj) == 69076575;
    }

    @Inject
    public SearchResultsEntityWithFacepileLargeRowPartDefinition(BackgroundPartDefinition backgroundPartDefinition, OldSearchResultsEntityBasePartDefinition oldSearchResultsEntityBasePartDefinition, SearchResultsEntityGroupFacepilePartDefinition searchResultsEntityGroupFacepilePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition) {
        this.f24234b = backgroundPartDefinition;
        this.f24235c = oldSearchResultsEntityBasePartDefinition;
        this.f24236d = searchResultsEntityGroupFacepilePartDefinition;
        this.f24237e = contentViewSubtitlePartDefinition;
        this.f24238f = contentViewContentDescriptionPartDefinition;
        this.f24239g = contentViewMetaTextPartDefinition;
    }

    public static SearchResultsEntityWithFacepileLargeRowPartDefinition m27774a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityWithFacepileLargeRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24233i) {
                SearchResultsEntityWithFacepileLargeRowPartDefinition searchResultsEntityWithFacepileLargeRowPartDefinition;
                if (a2 != null) {
                    searchResultsEntityWithFacepileLargeRowPartDefinition = (SearchResultsEntityWithFacepileLargeRowPartDefinition) a2.a(f24233i);
                } else {
                    searchResultsEntityWithFacepileLargeRowPartDefinition = f24232h;
                }
                if (searchResultsEntityWithFacepileLargeRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27775b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24233i, b3);
                        } else {
                            f24232h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityWithFacepileLargeRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentViewWithButton> m27776a() {
        return f24231a;
    }
}
