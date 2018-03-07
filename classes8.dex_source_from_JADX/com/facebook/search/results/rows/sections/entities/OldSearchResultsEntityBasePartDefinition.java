package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.collection.OldSearchResultsNodeClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: REACTION */
public class OldSearchResultsEntityBasePartDefinition<E extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends BaseSinglePartDefinition<GraphQLNode, Void, E, ContentViewWithButton> {
    private static OldSearchResultsEntityBasePartDefinition f24127d;
    private static final Object f24128e = new Object();
    private final OldSearchResultsEntityTitlePartDefinition f24129a;
    private final SearchResultsEntityActionButtonPartDefinition f24130b;
    private final OldSearchResultsNodeClickListenerPartDefinition f24131c;

    private static OldSearchResultsEntityBasePartDefinition m27675b(InjectorLike injectorLike) {
        return new OldSearchResultsEntityBasePartDefinition(OldSearchResultsEntityTitlePartDefinition.m27686a(injectorLike), SearchResultsEntityActionButtonPartDefinition.m27700a(injectorLike), OldSearchResultsNodeClickListenerPartDefinition.m27364a(injectorLike));
    }

    public final Object m27676a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24129a, graphQLNode);
        subParts.a(this.f24130b, OldSearchResultsEntityBaseFigPartDefinition.m27667a(graphQLNode, hasContext));
        subParts.a(this.f24131c, graphQLNode);
        return null;
    }

    public static OldSearchResultsEntityBasePartDefinition m27674a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsEntityBasePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24128e) {
                OldSearchResultsEntityBasePartDefinition oldSearchResultsEntityBasePartDefinition;
                if (a2 != null) {
                    oldSearchResultsEntityBasePartDefinition = (OldSearchResultsEntityBasePartDefinition) a2.a(f24128e);
                } else {
                    oldSearchResultsEntityBasePartDefinition = f24127d;
                }
                if (oldSearchResultsEntityBasePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27675b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24128e, b3);
                        } else {
                            f24127d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsEntityBasePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OldSearchResultsEntityBasePartDefinition(OldSearchResultsEntityTitlePartDefinition oldSearchResultsEntityTitlePartDefinition, SearchResultsEntityActionButtonPartDefinition searchResultsEntityActionButtonPartDefinition, OldSearchResultsNodeClickListenerPartDefinition oldSearchResultsNodeClickListenerPartDefinition) {
        this.f24129a = oldSearchResultsEntityTitlePartDefinition;
        this.f24130b = searchResultsEntityActionButtonPartDefinition;
        this.f24131c = oldSearchResultsNodeClickListenerPartDefinition;
    }
}
