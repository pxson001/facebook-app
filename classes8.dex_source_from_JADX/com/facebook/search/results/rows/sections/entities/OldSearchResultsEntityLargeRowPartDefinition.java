package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
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
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RATING_TAP */
public class OldSearchResultsEntityLargeRowPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<GraphQLGraphSearchResultsEdge, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24132a = ViewType.a(2130903977);
    private static OldSearchResultsEntityLargeRowPartDefinition f24133h;
    private static final Object f24134i = new Object();
    private final BackgroundPartDefinition f24135b;
    private final OldSearchResultsEntityBasePartDefinition<E> f24136c;
    private final ContentViewSubtitlePartDefinition f24137d;
    private final ContentViewContentDescriptionPartDefinition f24138e;
    private final ContentViewMetaTextPartDefinition f24139f;
    private final ContentViewThumbnailUriPartDefinition f24140g;

    private static OldSearchResultsEntityLargeRowPartDefinition m27678b(InjectorLike injectorLike) {
        return new OldSearchResultsEntityLargeRowPartDefinition(BackgroundPartDefinition.a(injectorLike), OldSearchResultsEntityBasePartDefinition.m27674a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), ContentViewMetaTextPartDefinition.a(injectorLike), ContentViewThumbnailUriPartDefinition.a(injectorLike));
    }

    public final Object m27680a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge = (GraphQLGraphSearchResultsEdge) obj;
        subParts.a(this.f24136c, graphQLGraphSearchResultsEdge.j());
        subParts.a(this.f24137d, SearchResultsEntityUtils.m27757a(graphQLGraphSearchResultsEdge));
        subParts.a(this.f24138e, SearchResultsEntityUtils.m27767c(graphQLGraphSearchResultsEdge));
        subParts.a(this.f24139f, SearchResultsEntityUtils.m27764b(graphQLGraphSearchResultsEdge));
        subParts.a(this.f24140g, SearchResultsEntityUtils.m27766c(graphQLGraphSearchResultsEdge.j()));
        subParts.a(this.f24135b, SearchResultsEntityConstants.f24177b);
        return null;
    }

    public final boolean m27681a(Object obj) {
        return ((GraphQLGraphSearchResultsEdge) obj).j() != null;
    }

    @Inject
    public OldSearchResultsEntityLargeRowPartDefinition(BackgroundPartDefinition backgroundPartDefinition, OldSearchResultsEntityBasePartDefinition oldSearchResultsEntityBasePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition, ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition) {
        this.f24135b = backgroundPartDefinition;
        this.f24136c = oldSearchResultsEntityBasePartDefinition;
        this.f24137d = contentViewSubtitlePartDefinition;
        this.f24138e = contentViewContentDescriptionPartDefinition;
        this.f24139f = contentViewMetaTextPartDefinition;
        this.f24140g = contentViewThumbnailUriPartDefinition;
    }

    public static OldSearchResultsEntityLargeRowPartDefinition m27677a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsEntityLargeRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24134i) {
                OldSearchResultsEntityLargeRowPartDefinition oldSearchResultsEntityLargeRowPartDefinition;
                if (a2 != null) {
                    oldSearchResultsEntityLargeRowPartDefinition = (OldSearchResultsEntityLargeRowPartDefinition) a2.a(f24134i);
                } else {
                    oldSearchResultsEntityLargeRowPartDefinition = f24133h;
                }
                if (oldSearchResultsEntityLargeRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27678b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24134i, b3);
                        } else {
                            f24133h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsEntityLargeRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentViewWithButton> m27679a() {
        return f24132a;
    }
}
