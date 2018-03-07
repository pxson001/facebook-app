package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitKey;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: all_autofill_values */
public class ReactionCollapsedIconMessageUnitComponentPartDefinition<E extends HasInvalidate & HasPersistentState & HasContext & CanLaunchReactionIntent & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19602a = ViewType.a(2130906625);
    private static ReactionCollapsedIconMessageUnitComponentPartDefinition f19603f;
    private static final Object f19604g = new Object();
    private final ClickListenerPartDefinition f19605b;
    private final ImageBlockLayoutIconPartDefinition f19606c;
    private final TextPartDefinition f19607d;
    private final HighlightViewOnTouchListenerPartDefinition f19608e;

    private static ReactionCollapsedIconMessageUnitComponentPartDefinition m23531b(InjectorLike injectorLike) {
        return new ReactionCollapsedIconMessageUnitComponentPartDefinition(ClickListenerPartDefinition.a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), TextPartDefinition.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike));
    }

    public final Object m23533a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566648, this.f19607d, reactionUnitComponentFields.bv().a());
        subParts.a(this.f19606c, reactionUnitComponentFields.aP().b());
        subParts.a(this.f19605b, new OnClickListener(this) {
            final /* synthetic */ ReactionCollapsedIconMessageUnitComponentPartDefinition f19601c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1124063635);
                ((ReactionCollapsableUnitPersistentState) ((HasPersistentState) hasInvalidate).a(new ReactionCollapsableUnitKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode)).m23182a(false);
                hasInvalidate.hL_();
                Logger.a(2, EntryType.UI_INPUT_END, -1548853369, a);
            }
        });
        subParts.a(this.f19608e, null);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23534a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1322686836);
        ((ImageBlockLayout) view).findViewById(2131566653).setVisibility(8);
        Logger.a(8, EntryType.MARK_POP, -1296970004, a);
    }

    @Inject
    public ReactionCollapsedIconMessageUnitComponentPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, TextPartDefinition textPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition) {
        this.f19605b = clickListenerPartDefinition;
        this.f19606c = imageBlockLayoutIconPartDefinition;
        this.f19608e = highlightViewOnTouchListenerPartDefinition;
        this.f19607d = textPartDefinition;
    }

    public static ReactionCollapsedIconMessageUnitComponentPartDefinition m23530a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCollapsedIconMessageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19604g) {
                ReactionCollapsedIconMessageUnitComponentPartDefinition reactionCollapsedIconMessageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionCollapsedIconMessageUnitComponentPartDefinition = (ReactionCollapsedIconMessageUnitComponentPartDefinition) a2.a(f19604g);
                } else {
                    reactionCollapsedIconMessageUnitComponentPartDefinition = f19603f;
                }
                if (reactionCollapsedIconMessageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23531b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19604g, b3);
                        } else {
                            f19603f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCollapsedIconMessageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23532a() {
        return f19602a;
    }

    public final boolean m23535a(Object obj) {
        return true;
    }
}
