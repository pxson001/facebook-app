package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_ATTACHMENT_INVALID */
public class NavigationalLinkPartDefinition<E extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends BaseSinglePartDefinition<GraphQLNode, State, E, ContentViewWithButton> {
    private static NavigationalLinkPartDefinition f24112e;
    private static final Object f24113f = new Object();
    private final OldSearchResultsEntityTitlePartDefinition f24114a;
    private final ClickListenerPartDefinition f24115b;
    public final FbUriIntentHandler f24116c;
    public final GlyphColorizer f24117d;

    /* compiled from: REACTION_ATTACHMENT_INVALID */
    public class State {
        @Nullable
        public final Drawable f24109a;
        @Nullable
        public final CharSequence f24110b;
        public final OnClickListener f24111c;

        public State(Drawable drawable, CharSequence charSequence, OnClickListener onClickListener) {
            this.f24109a = drawable;
            this.f24110b = charSequence;
            this.f24111c = onClickListener;
        }
    }

    private static NavigationalLinkPartDefinition m27658b(InjectorLike injectorLike) {
        return new NavigationalLinkPartDefinition(OldSearchResultsEntityTitlePartDefinition.m27686a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m27659a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24114a, graphQLNode);
        Drawable a = this.f24117d.a(2130839952, -7235677);
        CharSequence text = hasContext.getContext().getText(2131239009);
        C25691 c25691 = new OnClickListener(this) {
            final /* synthetic */ NavigationalLinkPartDefinition f24108c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1754528608);
                String iR = graphQLNode.iR();
                if (iR != null) {
                    this.f24108c.f24116c.a(view.getContext(), iR);
                }
                ((OldCanLogEntityNavigation) hasContext).mo1251b(graphQLNode);
                Logger.a(2, EntryType.UI_INPUT_END, 756502014, a);
            }
        };
        subParts.a(this.f24115b, c25691);
        return new State(a, text, c25691);
    }

    public final /* bridge */ /* synthetic */ void m27660a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -444077503);
        State state = (State) obj2;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setActionButtonDrawable(state.f24109a);
        contentViewWithButton.setShowActionButton(state.f24109a != null);
        contentViewWithButton.setActionButtonBackground(null);
        contentViewWithButton.setActionButtonOnClickListener(state.f24111c);
        contentViewWithButton.setActionButtonContentDescription(state.f24110b);
        Logger.a(8, EntryType.MARK_POP, -1178298680, a);
    }

    public final void m27661b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setActionButtonDrawable(null);
        contentViewWithButton.setShowActionButton(false);
        contentViewWithButton.setActionButtonOnClickListener(null);
        contentViewWithButton.setActionButtonContentDescription(null);
    }

    public static NavigationalLinkPartDefinition m27657a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NavigationalLinkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24113f) {
                NavigationalLinkPartDefinition navigationalLinkPartDefinition;
                if (a2 != null) {
                    navigationalLinkPartDefinition = (NavigationalLinkPartDefinition) a2.a(f24113f);
                } else {
                    navigationalLinkPartDefinition = f24112e;
                }
                if (navigationalLinkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27658b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24113f, b3);
                        } else {
                            f24112e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = navigationalLinkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NavigationalLinkPartDefinition(OldSearchResultsEntityTitlePartDefinition oldSearchResultsEntityTitlePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, GlyphColorizer glyphColorizer) {
        this.f24114a = oldSearchResultsEntityTitlePartDefinition;
        this.f24115b = clickListenerPartDefinition;
        this.f24116c = fbUriIntentHandler;
        this.f24117d = glyphColorizer;
    }
}
