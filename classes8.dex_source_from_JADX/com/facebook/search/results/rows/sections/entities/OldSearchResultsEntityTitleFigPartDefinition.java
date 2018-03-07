package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.graphql.model.GraphQLNode;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RATING_BAR_OLD */
public class OldSearchResultsEntityTitleFigPartDefinition extends BaseSinglePartDefinition<GraphQLNode, CharSequence, AnyEnvironment, FigListItem> {
    private static OldSearchResultsEntityTitleFigPartDefinition f24141b;
    private static final Object f24142c = new Object();
    private final Lazy<TypeaheadRowTitleFormatter> f24143a;

    private static OldSearchResultsEntityTitleFigPartDefinition m27683b(InjectorLike injectorLike) {
        return new OldSearchResultsEntityTitleFigPartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 10943));
    }

    public final Object m27684a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        if (SearchResultsEntityUtils.m27773g(graphQLNode)) {
            return graphQLNode.it() != null ? graphQLNode.it().a() : null;
        } else {
            return SearchResultsEntityUtils.m27763a(graphQLNode.dZ(), graphQLNode.eP(), this.f24143a);
        }
    }

    public final /* bridge */ /* synthetic */ void m27685a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1380113343);
        ((FigListItem) view).setTitleText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, 1934961222, a);
    }

    @Inject
    public OldSearchResultsEntityTitleFigPartDefinition(Lazy<TypeaheadRowTitleFormatter> lazy) {
        this.f24143a = lazy;
    }

    public static OldSearchResultsEntityTitleFigPartDefinition m27682a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsEntityTitleFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24142c) {
                OldSearchResultsEntityTitleFigPartDefinition oldSearchResultsEntityTitleFigPartDefinition;
                if (a2 != null) {
                    oldSearchResultsEntityTitleFigPartDefinition = (OldSearchResultsEntityTitleFigPartDefinition) a2.a(f24142c);
                } else {
                    oldSearchResultsEntityTitleFigPartDefinition = f24141b;
                }
                if (oldSearchResultsEntityTitleFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27683b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24142c, b3);
                        } else {
                            f24141b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsEntityTitleFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
