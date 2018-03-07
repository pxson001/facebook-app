package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
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
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RELATED_ARTICLES_HEADER */
public class CommerceListItemPartDefinition<E extends HasPositionInformation> extends MultiRowSinglePartDefinition<SearchResultsProductItemUnit, Void, E, ContentView> {
    public static ViewType<ContentView> f23878a = ViewType.a(2130907002);
    private static final PaddingStyle f23879b;
    private static CommerceListItemPartDefinition f23880h;
    private static final Object f23881i = new Object();
    private final BackgroundPartDefinition f23882c;
    private final CommerceThumbnailPartDefinition f23883d;
    private final ContentViewTitlePartDefinition f23884e;
    private final CommerceListItemProductInfoPartDefinition f23885f;
    private final CommerceProductItemClickPartDefinition f23886g;

    private static CommerceListItemPartDefinition m27486b(InjectorLike injectorLike) {
        return new CommerceListItemPartDefinition(BackgroundPartDefinition.a(injectorLike), CommerceThumbnailPartDefinition.m27541a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), CommerceListItemProductInfoPartDefinition.m27490a(injectorLike), CommerceProductItemClickPartDefinition.m27513a(injectorLike));
    }

    public final Object m27488a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        GraphQLNode graphQLNode = searchResultsProductItemUnit.f23494a;
        subParts.a(this.f23882c, new StylingData(f23879b));
        subParts.a(this.f23883d, searchResultsProductItemUnit);
        subParts.a(this.f23884e, graphQLNode.eP());
        subParts.a(2131567291, this.f23885f, searchResultsProductItemUnit);
        subParts.a(this.f23886g, searchResultsProductItemUnit);
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = 6.0f;
        f23879b = a.i();
    }

    @Inject
    public CommerceListItemPartDefinition(BackgroundPartDefinition backgroundPartDefinition, CommerceThumbnailPartDefinition commerceThumbnailPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, CommerceListItemProductInfoPartDefinition commerceListItemProductInfoPartDefinition, CommerceProductItemClickPartDefinition commerceProductItemClickPartDefinition) {
        this.f23882c = backgroundPartDefinition;
        this.f23883d = commerceThumbnailPartDefinition;
        this.f23884e = contentViewTitlePartDefinition;
        this.f23885f = commerceListItemProductInfoPartDefinition;
        this.f23886g = commerceProductItemClickPartDefinition;
    }

    public static CommerceListItemPartDefinition m27484a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceListItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23881i) {
                CommerceListItemPartDefinition commerceListItemPartDefinition;
                if (a2 != null) {
                    commerceListItemPartDefinition = (CommerceListItemPartDefinition) a2.a(f23881i);
                } else {
                    commerceListItemPartDefinition = f23880h;
                }
                if (commerceListItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27486b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23881i, b3);
                        } else {
                            f23880h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceListItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentView> m27487a() {
        return f23878a;
    }

    public static boolean m27485a(SearchResultsProductItemUnit searchResultsProductItemUnit) {
        GraphQLNode graphQLNode = searchResultsProductItemUnit.f23494a;
        if (graphQLNode.j() == null || graphQLNode.j().g() != 175920258 || Strings.isNullOrEmpty(graphQLNode.eP())) {
            return false;
        }
        if ((graphQLNode.ec() == null && graphQLNode.gI() == null) || graphQLNode.gU() == null || Strings.isNullOrEmpty(graphQLNode.gU().aa()) || graphQLNode.dq() == null || Strings.isNullOrEmpty(graphQLNode.dq().b())) {
            return false;
        }
        return true;
    }
}
