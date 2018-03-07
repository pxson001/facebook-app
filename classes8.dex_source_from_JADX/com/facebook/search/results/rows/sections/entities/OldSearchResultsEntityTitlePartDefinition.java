package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
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
/* compiled from: RATING_BAR */
public class OldSearchResultsEntityTitlePartDefinition extends BaseSinglePartDefinition<GraphQLNode, CharSequence, AnyEnvironment, ContentView> {
    private static OldSearchResultsEntityTitlePartDefinition f24144b;
    private static final Object f24145c = new Object();
    private final Lazy<TypeaheadRowTitleFormatter> f24146a;

    private static OldSearchResultsEntityTitlePartDefinition m27687b(InjectorLike injectorLike) {
        return new OldSearchResultsEntityTitlePartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 10943));
    }

    public final Object m27688a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        if (SearchResultsEntityUtils.m27773g(graphQLNode)) {
            return graphQLNode.it() != null ? graphQLNode.it().a() : null;
        } else {
            return SearchResultsEntityUtils.m27763a(graphQLNode.dZ(), graphQLNode.eP(), this.f24146a);
        }
    }

    public final /* bridge */ /* synthetic */ void m27689a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1364499258);
        ((ContentView) view).setTitleText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, -1839658439, a);
    }

    @Inject
    public OldSearchResultsEntityTitlePartDefinition(Lazy<TypeaheadRowTitleFormatter> lazy) {
        this.f24146a = lazy;
    }

    public static OldSearchResultsEntityTitlePartDefinition m27686a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsEntityTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24145c) {
                OldSearchResultsEntityTitlePartDefinition oldSearchResultsEntityTitlePartDefinition;
                if (a2 != null) {
                    oldSearchResultsEntityTitlePartDefinition = (OldSearchResultsEntityTitlePartDefinition) a2.a(f24145c);
                } else {
                    oldSearchResultsEntityTitlePartDefinition = f24144b;
                }
                if (oldSearchResultsEntityTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27687b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24145c, b3);
                        } else {
                            f24144b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsEntityTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
