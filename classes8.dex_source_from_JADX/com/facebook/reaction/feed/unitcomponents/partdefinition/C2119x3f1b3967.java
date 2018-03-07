package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitKey;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitUtils;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: already_added_users */
public class C2119x3f1b3967<E extends HasInvalidate & HasPersistentState & HasContext & CanLaunchReactionIntent & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19586a = ViewType.a(2130906673);
    private static C2119x3f1b3967 f19587f;
    private static final Object f19588g = new Object();
    private final ClickListenerPartDefinition f19589b;
    private final ImageBlockLayoutIconPartDefinition f19590c;
    private final TextPartDefinition f19591d;
    private final HighlightViewOnTouchListenerPartDefinition f19592e;

    private static C2119x3f1b3967 m23520b(InjectorLike injectorLike) {
        return new C2119x3f1b3967(ClickListenerPartDefinition.a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), TextPartDefinition.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike));
    }

    public final Object m23522a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566648, this.f19591d, reactionUnitComponentFields.bv().a());
        subParts.a(this.f19590c, reactionUnitComponentFields.aP().b());
        subParts.a(this.f19589b, new OnClickListener(this) {
            final /* synthetic */ C2119x3f1b3967 f19585c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -411058819);
                ReactionCollapsableUnitPersistentState reactionCollapsableUnitPersistentState = (ReactionCollapsableUnitPersistentState) ((HasPersistentState) hasInvalidate).a(new ReactionCollapsableUnitKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode);
                reactionCollapsableUnitPersistentState.f19160a = !reactionCollapsableUnitPersistentState.f19160a;
                reactionCollapsableUnitPersistentState.f19161b = true;
                hasInvalidate.a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode)});
                Logger.a(2, EntryType.UI_INPUT_END, 1027219746, a);
            }
        });
        subParts.a(this.f19592e, null);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23523a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1313511083);
        C2119x3f1b3967.m23519a((ReactionUnitComponentNode) obj, (HasInvalidate) anyEnvironment, (ImageBlockLayout) view);
        Logger.a(8, EntryType.MARK_POP, -1571109308, a);
    }

    @Inject
    public C2119x3f1b3967(ClickListenerPartDefinition clickListenerPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, TextPartDefinition textPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition) {
        this.f19589b = clickListenerPartDefinition;
        this.f19590c = imageBlockLayoutIconPartDefinition;
        this.f19592e = highlightViewOnTouchListenerPartDefinition;
        this.f19591d = textPartDefinition;
    }

    public static C2119x3f1b3967 m23518a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            C2119x3f1b3967 b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19588g) {
                C2119x3f1b3967 c2119x3f1b3967;
                if (a2 != null) {
                    c2119x3f1b3967 = (C2119x3f1b3967) a2.a(f19588g);
                } else {
                    c2119x3f1b3967 = f19587f;
                }
                if (c2119x3f1b3967 == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = C2119x3f1b3967.m23520b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19588g, b3);
                        } else {
                            f19587f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = c2119x3f1b3967;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23521a() {
        return f19586a;
    }

    private static void m23519a(ReactionUnitComponentNode reactionUnitComponentNode, E e, ImageBlockLayout imageBlockLayout) {
        imageBlockLayout.findViewById(2131566653).setVisibility(8);
        ((GlyphView) imageBlockLayout.findViewById(2131566719)).setImageResource(ReactionCollapsableUnitUtils.m23183a(reactionUnitComponentNode, (HasPersistentState) e) ? 2130840139 : 2130840143);
    }

    public final boolean m23524a(Object obj) {
        return true;
    }
}
