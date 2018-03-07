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
/* compiled from: QUERY_AWESOMIZER_SEEFIRST_TASK_ID */
public class SearchResultsEntityWithFacepileRowPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24250a = ViewType.a(2130903979);
    private static SearchResultsEntityWithFacepileRowPartDefinition f24251h;
    private static final Object f24252i = new Object();
    private final BackgroundPartDefinition f24253b;
    private final OldSearchResultsEntityBasePartDefinition<E> f24254c;
    private final SearchResultsEntityGroupFacepilePartDefinition f24255d;
    private final ContentViewSubtitlePartDefinition f24256e;
    private final ContentViewContentDescriptionPartDefinition f24257f;
    private final ContentViewMetaTextPartDefinition f24258g;

    private static SearchResultsEntityWithFacepileRowPartDefinition m27785b(InjectorLike injectorLike) {
        return new SearchResultsEntityWithFacepileRowPartDefinition(BackgroundPartDefinition.a(injectorLike), OldSearchResultsEntityBasePartDefinition.m27674a(injectorLike), SearchResultsEntityGroupFacepilePartDefinition.m27721a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), ContentViewMetaTextPartDefinition.a(injectorLike));
    }

    public final Object m27787a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        subParts.a(this.f24254c, graphQLNode);
        subParts.a(this.f24253b, SearchResultsEntityConstants.f24177b);
        subParts.a(2131561192, this.f24255d, new FacepileData(4, SearchResultsEntityUtils.m27770e(graphQLNode)));
        subParts.a(this.f24256e, SearchResultsEntityUtils.m27759a(graphQLNode));
        subParts.a(this.f24257f, SearchResultsEntityUtils.m27765b(graphQLNode));
        subParts.a(this.f24258g, SearchResultsEntityUtils.m27772f(graphQLNode));
        return null;
    }

    public final boolean m27788a(Object obj) {
        return SearchResultsEntityUtils.m27768d((GraphQLNode) obj) == 69076575;
    }

    @Inject
    public SearchResultsEntityWithFacepileRowPartDefinition(BackgroundPartDefinition backgroundPartDefinition, OldSearchResultsEntityBasePartDefinition oldSearchResultsEntityBasePartDefinition, SearchResultsEntityGroupFacepilePartDefinition searchResultsEntityGroupFacepilePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition) {
        this.f24253b = backgroundPartDefinition;
        this.f24254c = oldSearchResultsEntityBasePartDefinition;
        this.f24255d = searchResultsEntityGroupFacepilePartDefinition;
        this.f24256e = contentViewSubtitlePartDefinition;
        this.f24257f = contentViewContentDescriptionPartDefinition;
        this.f24258g = contentViewMetaTextPartDefinition;
    }

    public static SearchResultsEntityWithFacepileRowPartDefinition m27784a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityWithFacepileRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24252i) {
                SearchResultsEntityWithFacepileRowPartDefinition searchResultsEntityWithFacepileRowPartDefinition;
                if (a2 != null) {
                    searchResultsEntityWithFacepileRowPartDefinition = (SearchResultsEntityWithFacepileRowPartDefinition) a2.a(f24252i);
                } else {
                    searchResultsEntityWithFacepileRowPartDefinition = f24251h;
                }
                if (searchResultsEntityWithFacepileRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27785b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24252i, b3);
                        } else {
                            f24251h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityWithFacepileRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentViewWithButton> m27786a() {
        return f24250a;
    }
}
