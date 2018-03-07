package com.facebook.search.results.rows.sections.relatednews;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRE_INSTALLED_FONT_SANS_SERIF_ITALIC */
public class SearchResultsRelatedNewsClickListenerPartDefinition<E extends OldCanLogEntityNavigation & HasSearchResultsContext> extends BaseSinglePartDefinition<GraphQLNode, Void, E, View> {
    private static SearchResultsRelatedNewsClickListenerPartDefinition f24945d;
    private static final Object f24946e = new Object();
    public final SecureContextHelper f24947a;
    public final SearchResultsIntentBuilder f24948b;
    private final ClickListenerPartDefinition f24949c;

    private static SearchResultsRelatedNewsClickListenerPartDefinition m28295b(InjectorLike injectorLike) {
        return new SearchResultsRelatedNewsClickListenerPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m28296a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final OldCanLogEntityNavigation oldCanLogEntityNavigation = (OldCanLogEntityNavigation) anyEnvironment;
        subParts.a(this.f24949c, new OnClickListener(this) {
            final /* synthetic */ SearchResultsRelatedNewsClickListenerPartDefinition f24944c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -350103686);
                if (graphQLNode.dp() == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -1434909737, a);
                    return;
                }
                oldCanLogEntityNavigation.mo1251b(graphQLNode);
                this.f24944c.f24947a.a(this.f24944c.f24948b.a(((HasSearchResultsContext) oldCanLogEntityNavigation).mo1248s().f23369d, graphQLNode.dp(), graphQLNode.eP(), SearchResultsSource.k), view.getContext());
                LogUtils.a(-232111094, a);
            }
        });
        return null;
    }

    @Inject
    public SearchResultsRelatedNewsClickListenerPartDefinition(SecureContextHelper secureContextHelper, SearchResultsIntentBuilder searchResultsIntentBuilder, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f24947a = secureContextHelper;
        this.f24948b = searchResultsIntentBuilder;
        this.f24949c = clickListenerPartDefinition;
    }

    public static SearchResultsRelatedNewsClickListenerPartDefinition m28294a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsRelatedNewsClickListenerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24946e) {
                SearchResultsRelatedNewsClickListenerPartDefinition searchResultsRelatedNewsClickListenerPartDefinition;
                if (a2 != null) {
                    searchResultsRelatedNewsClickListenerPartDefinition = (SearchResultsRelatedNewsClickListenerPartDefinition) a2.a(f24946e);
                } else {
                    searchResultsRelatedNewsClickListenerPartDefinition = f24945d;
                }
                if (searchResultsRelatedNewsClickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28295b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24946e, b3);
                        } else {
                            f24945d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsRelatedNewsClickListenerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
