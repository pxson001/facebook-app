package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
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
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUESTION_ANSWER_TAP */
public class SearchResultsEntityRowPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24219a = ViewType.a(2130903976);
    private static SearchResultsEntityRowPartDefinition f24220h;
    private static final Object f24221i = new Object();
    private final BackgroundPartDefinition f24222b;
    private final OldSearchResultsEntityBasePartDefinition<E> f24223c;
    private final NavigationalLinkPartDefinition f24224d;
    private final ContentViewSubtitlePartDefinition f24225e;
    private final ContentViewContentDescriptionPartDefinition f24226f;
    private final ContentViewThumbnailUriPartDefinition f24227g;

    private static SearchResultsEntityRowPartDefinition m27748b(InjectorLike injectorLike) {
        return new SearchResultsEntityRowPartDefinition(BackgroundPartDefinition.a(injectorLike), OldSearchResultsEntityBasePartDefinition.m27674a(injectorLike), NavigationalLinkPartDefinition.m27657a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), ContentViewThumbnailUriPartDefinition.a(injectorLike));
    }

    public final Object m27750a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        Position position = ((HasPositionInformation) hasContext).h() == null ? Position.BOTTOM : Position.MIDDLE;
        subParts.a(SearchResultsEntityUtils.m27773g(graphQLNode) ? this.f24224d : this.f24223c, graphQLNode);
        subParts.a(this.f24225e, SearchResultsEntityUtils.m27760a(graphQLNode, hasContext.getContext().getString(2131239060)));
        subParts.a(this.f24226f, SearchResultsEntityUtils.m27765b(graphQLNode));
        subParts.a(this.f24227g, SearchResultsEntityUtils.m27766c(graphQLNode));
        subParts.a(this.f24222b, new StylingData(null, SearchResultsEntityConstants.f24176a, position));
        return null;
    }

    @Inject
    public SearchResultsEntityRowPartDefinition(BackgroundPartDefinition backgroundPartDefinition, OldSearchResultsEntityBasePartDefinition oldSearchResultsEntityBasePartDefinition, NavigationalLinkPartDefinition navigationalLinkPartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition) {
        this.f24222b = backgroundPartDefinition;
        this.f24223c = oldSearchResultsEntityBasePartDefinition;
        this.f24224d = navigationalLinkPartDefinition;
        this.f24225e = contentViewSubtitlePartDefinition;
        this.f24226f = contentViewContentDescriptionPartDefinition;
        this.f24227g = contentViewThumbnailUriPartDefinition;
    }

    public static SearchResultsEntityRowPartDefinition m27747a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24221i) {
                SearchResultsEntityRowPartDefinition searchResultsEntityRowPartDefinition;
                if (a2 != null) {
                    searchResultsEntityRowPartDefinition = (SearchResultsEntityRowPartDefinition) a2.a(f24221i);
                } else {
                    searchResultsEntityRowPartDefinition = f24220h;
                }
                if (searchResultsEntityRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27748b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24221i, b3);
                        } else {
                            f24220h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentViewWithButton> m27749a() {
        return f24219a;
    }

    public final boolean m27751a(Object obj) {
        return true;
    }
}
