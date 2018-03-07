package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
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
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESET */
public class OldSearchResultsNodeClickListenerPartDefinition extends BaseSinglePartDefinition<GraphQLNode, Void, OldCanLogEntityNavigation, View> {
    private static OldSearchResultsNodeClickListenerPartDefinition f23712d;
    private static final Object f23713e = new Object();
    public final GraphQLLinkExtractor f23714a;
    public final FbUriIntentHandler f23715b;
    private final ClickListenerPartDefinition f23716c;

    private static OldSearchResultsNodeClickListenerPartDefinition m27365b(InjectorLike injectorLike) {
        return new OldSearchResultsNodeClickListenerPartDefinition(GraphQLLinkExtractor.a(injectorLike), FbUriIntentHandler.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m27366a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final OldCanLogEntityNavigation oldCanLogEntityNavigation = (OldCanLogEntityNavigation) anyEnvironment;
        subParts.a(this.f23716c, new OnClickListener(this) {
            final /* synthetic */ OldSearchResultsNodeClickListenerPartDefinition f23711c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2097403491);
                String a2 = this.f23711c.f23714a.a(graphQLNode.j(), graphQLNode.dp());
                if (a2 != null) {
                    this.f23711c.f23715b.a(view.getContext(), a2);
                }
                oldCanLogEntityNavigation.mo1251b(graphQLNode);
                Logger.a(2, EntryType.UI_INPUT_END, 900792890, a);
            }
        });
        return null;
    }

    @Inject
    public OldSearchResultsNodeClickListenerPartDefinition(GraphQLLinkExtractor graphQLLinkExtractor, FbUriIntentHandler fbUriIntentHandler, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f23714a = graphQLLinkExtractor;
        this.f23715b = fbUriIntentHandler;
        this.f23716c = clickListenerPartDefinition;
    }

    public static OldSearchResultsNodeClickListenerPartDefinition m27364a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsNodeClickListenerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23713e) {
                OldSearchResultsNodeClickListenerPartDefinition oldSearchResultsNodeClickListenerPartDefinition;
                if (a2 != null) {
                    oldSearchResultsNodeClickListenerPartDefinition = (OldSearchResultsNodeClickListenerPartDefinition) a2.a(f23713e);
                } else {
                    oldSearchResultsNodeClickListenerPartDefinition = f23712d;
                }
                if (oldSearchResultsNodeClickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27365b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23713e, b3);
                        } else {
                            f23712d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsNodeClickListenerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
