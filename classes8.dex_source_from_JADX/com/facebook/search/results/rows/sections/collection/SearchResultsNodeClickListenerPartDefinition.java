package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
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
import com.facebook.search.results.environment.entity.CanLogEntityNavigation;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPLACE_UNIT_TAP */
public class SearchResultsNodeClickListenerPartDefinition extends BaseSinglePartDefinition<SearchResultsProps<Node>, Void, CanLogEntityNavigation, View> {
    private static SearchResultsNodeClickListenerPartDefinition f23803d;
    private static final Object f23804e = new Object();
    public final GraphQLLinkExtractor f23805a;
    public final FbUriIntentHandler f23806b;
    private final ClickListenerPartDefinition f23807c;

    private static SearchResultsNodeClickListenerPartDefinition m27430b(InjectorLike injectorLike) {
        return new SearchResultsNodeClickListenerPartDefinition(GraphQLLinkExtractor.a(injectorLike), FbUriIntentHandler.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m27431a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final CanLogEntityNavigation canLogEntityNavigation = (CanLogEntityNavigation) anyEnvironment;
        final NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        if (!(nodeModel.mo572C() == null || nodeModel.m9745b() == null)) {
            subParts.a(this.f23807c, new OnClickListener(this) {
                final /* synthetic */ SearchResultsNodeClickListenerPartDefinition f23802d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1850770275);
                    String a2 = this.f23802d.f23805a.a(nodeModel.m9745b(), nodeModel.mo572C());
                    if (a2 != null) {
                        this.f23802d.f23806b.a(view.getContext(), a2);
                    }
                    canLogEntityNavigation.mo1256c(searchResultsProps);
                    Logger.a(2, EntryType.UI_INPUT_END, 896265263, a);
                }
            });
        }
        return null;
    }

    @Inject
    public SearchResultsNodeClickListenerPartDefinition(GraphQLLinkExtractor graphQLLinkExtractor, FbUriIntentHandler fbUriIntentHandler, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f23805a = graphQLLinkExtractor;
        this.f23806b = fbUriIntentHandler;
        this.f23807c = clickListenerPartDefinition;
    }

    public static SearchResultsNodeClickListenerPartDefinition m27429a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNodeClickListenerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23804e) {
                SearchResultsNodeClickListenerPartDefinition searchResultsNodeClickListenerPartDefinition;
                if (a2 != null) {
                    searchResultsNodeClickListenerPartDefinition = (SearchResultsNodeClickListenerPartDefinition) a2.a(f23804e);
                } else {
                    searchResultsNodeClickListenerPartDefinition = f23803d;
                }
                if (searchResultsNodeClickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27430b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23804e, b3);
                        } else {
                            f23803d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNodeClickListenerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
