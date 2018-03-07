package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitKey;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitPersistentState;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionIconMessageWithMenuPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: altitude */
public class ReactionCollapsableIconMessageUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasPersistentState & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    public static final ViewType f19572a = ViewType.a(2130906630);
    private static ReactionCollapsableIconMessageUnitComponentPartDefinition f19573e;
    private static final Object f19574f = new Object();
    private final ClickListenerPartDefinition f19575b;
    private final ReactionIconMessageWithMenuPartDefinition f19576c;
    private final HighlightViewOnTouchListenerPartDefinition f19577d;

    private static ReactionCollapsableIconMessageUnitComponentPartDefinition m23509b(InjectorLike injectorLike) {
        return new ReactionCollapsableIconMessageUnitComponentPartDefinition(ClickListenerPartDefinition.a(injectorLike), ReactionIconMessageWithMenuPartDefinition.m24325a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike));
    }

    public final Object m23511a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        subParts.a(this.f19576c, reactionUnitComponentNode);
        subParts.a(this.f19575b, new OnClickListener(this) {
            final /* synthetic */ ReactionCollapsableIconMessageUnitComponentPartDefinition f19571c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 623396787);
                ((ReactionCollapsableUnitPersistentState) ((HasPersistentState) canLaunchReactionIntent).a(new ReactionCollapsableUnitKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode)).m23182a(true);
                ((HasInvalidate) canLaunchReactionIntent).hL_();
                Logger.a(2, EntryType.UI_INPUT_END, -755996241, a);
            }
        });
        subParts.a(this.f19577d, null);
        return null;
    }

    @Inject
    public ReactionCollapsableIconMessageUnitComponentPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ReactionIconMessageWithMenuPartDefinition reactionIconMessageWithMenuPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition) {
        this.f19575b = clickListenerPartDefinition;
        this.f19576c = reactionIconMessageWithMenuPartDefinition;
        this.f19577d = highlightViewOnTouchListenerPartDefinition;
    }

    public static ReactionCollapsableIconMessageUnitComponentPartDefinition m23508a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCollapsableIconMessageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19574f) {
                ReactionCollapsableIconMessageUnitComponentPartDefinition reactionCollapsableIconMessageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionCollapsableIconMessageUnitComponentPartDefinition = (ReactionCollapsableIconMessageUnitComponentPartDefinition) a2.a(f19574f);
                } else {
                    reactionCollapsableIconMessageUnitComponentPartDefinition = f19573e;
                }
                if (reactionCollapsableIconMessageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23509b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19574f, b3);
                        } else {
                            f19573e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCollapsableIconMessageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23510a() {
        return f19572a;
    }

    public final boolean m23512a(Object obj) {
        return true;
    }
}
