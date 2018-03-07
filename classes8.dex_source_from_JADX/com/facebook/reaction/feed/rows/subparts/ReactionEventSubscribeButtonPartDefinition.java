package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.ui.card.header.ReactionEventSubscribeButtonBinder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: anniversary_video */
public class ReactionEventSubscribeButtonPartDefinition extends BaseSinglePartDefinition<ReactionCardNode, Void, HasReactionInteractionTracker, TextView> {
    private static ReactionEventSubscribeButtonPartDefinition f19422b;
    private static final Object f19423c = new Object();
    public final ReactionEventSubscribeButtonBinder f19424a;

    private static ReactionEventSubscribeButtonPartDefinition m23408b(InjectorLike injectorLike) {
        return new ReactionEventSubscribeButtonPartDefinition(ReactionEventSubscribeButtonBinder.m24716b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m23409a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1752110807);
        TextView textView = (TextView) view;
        this.f19424a.m24718a((ReactionCardNode) obj, textView, ((HasReactionInteractionTracker) anyEnvironment).kE_());
        Logger.a(8, EntryType.MARK_POP, -1839310633, a);
    }

    public final void m23410b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TextView textView = (TextView) view;
        ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder = this.f19424a;
        textView.setOnClickListener(null);
        reactionEventSubscribeButtonBinder.f21094h.b(reactionEventSubscribeButtonBinder.f21089c);
        reactionEventSubscribeButtonBinder.f21089c = null;
    }

    @Inject
    public ReactionEventSubscribeButtonPartDefinition(ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder) {
        this.f19424a = reactionEventSubscribeButtonBinder;
    }

    public static ReactionEventSubscribeButtonPartDefinition m23407a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventSubscribeButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19423c) {
                ReactionEventSubscribeButtonPartDefinition reactionEventSubscribeButtonPartDefinition;
                if (a2 != null) {
                    reactionEventSubscribeButtonPartDefinition = (ReactionEventSubscribeButtonPartDefinition) a2.a(f19423c);
                } else {
                    reactionEventSubscribeButtonPartDefinition = f19422b;
                }
                if (reactionEventSubscribeButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23408b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19423c, b3);
                        } else {
                            f19422b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionEventSubscribeButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
