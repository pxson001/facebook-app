package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.fig.listitem.FigListItem;
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
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.entities.NavigationalLinkPartDefinition.State;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_ATTACHMENT_INVALIDATED */
public class NavigationalLinkFigPartDefinition<E extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends BaseSinglePartDefinition<GraphQLNode, State, E, FigListItem> {
    private static NavigationalLinkFigPartDefinition f24100e;
    private static final Object f24101f = new Object();
    private final OldSearchResultsEntityTitleFigPartDefinition f24102a;
    private final ClickListenerPartDefinition f24103b;
    public final FbUriIntentHandler f24104c;
    public final GlyphColorizer f24105d;

    private static NavigationalLinkFigPartDefinition m27653b(InjectorLike injectorLike) {
        return new NavigationalLinkFigPartDefinition(OldSearchResultsEntityTitleFigPartDefinition.m27682a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m27654a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24102a, graphQLNode);
        Drawable a = this.f24105d.a(2130839952, -7235677);
        CharSequence text = hasContext.getContext().getText(2131239009);
        C25681 c25681 = new OnClickListener(this) {
            final /* synthetic */ NavigationalLinkFigPartDefinition f24099c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1148957574);
                String iR = graphQLNode.iR();
                if (iR != null) {
                    this.f24099c.f24104c.a(view.getContext(), iR);
                }
                ((OldCanLogEntityNavigation) hasContext).mo1251b(graphQLNode);
                Logger.a(2, EntryType.UI_INPUT_END, -1550250267, a);
            }
        };
        subParts.a(this.f24103b, c25681);
        return new State(a, text, c25681);
    }

    public final /* bridge */ /* synthetic */ void m27655a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1575057430);
        State state = (State) obj2;
        FigListItem figListItem = (FigListItem) view;
        figListItem.setActionType(7);
        figListItem.setActionDrawable(state.f24109a);
        figListItem.setActionOnClickListener(state.f24111c);
        figListItem.setActionContentDescription(state.f24110b);
        Logger.a(8, EntryType.MARK_POP, 1021916888, a);
    }

    public final void m27656b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FigListItem figListItem = (FigListItem) view;
        figListItem.setActionOnClickListener(null);
        figListItem.setActionDrawable(null);
        figListItem.setActionContentDescription(null);
    }

    @Inject
    public NavigationalLinkFigPartDefinition(OldSearchResultsEntityTitleFigPartDefinition oldSearchResultsEntityTitleFigPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, GlyphColorizer glyphColorizer) {
        this.f24102a = oldSearchResultsEntityTitleFigPartDefinition;
        this.f24103b = clickListenerPartDefinition;
        this.f24104c = fbUriIntentHandler;
        this.f24105d = glyphColorizer;
    }

    public static NavigationalLinkFigPartDefinition m27652a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NavigationalLinkFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24101f) {
                NavigationalLinkFigPartDefinition navigationalLinkFigPartDefinition;
                if (a2 != null) {
                    navigationalLinkFigPartDefinition = (NavigationalLinkFigPartDefinition) a2.a(f24101f);
                } else {
                    navigationalLinkFigPartDefinition = f24100e;
                }
                if (navigationalLinkFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27653b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24101f, b3);
                        } else {
                            f24100e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = navigationalLinkFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
