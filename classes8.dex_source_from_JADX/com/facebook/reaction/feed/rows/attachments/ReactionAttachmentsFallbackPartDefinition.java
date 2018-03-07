package com.facebook.reaction.feed.rows.attachments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;

@ContextScoped
/* compiled from: ar_password_shown */
public class ReactionAttachmentsFallbackPartDefinition<E extends HasReactionSession & HasReactionInteractionTracker & HasReactionCardContainer> extends MultiRowSinglePartDefinition<ReactionCardNode, State, E, LinearLayout> {
    public static final ViewType f19329a = new C21061();
    private static ReactionAttachmentsFallbackPartDefinition f19330b;
    private static final Object f19331c = new Object();

    /* compiled from: ar_password_shown */
    final class C21061 extends ViewType {
        C21061() {
        }

        @SuppressLint({"InflateParams"})
        public final View m23328a(Context context) {
            return (LinearLayout) LayoutInflater.from(context).inflate(2130906615, null);
        }
    }

    /* compiled from: ar_password_shown */
    public class State {
        public final ReactionAttachmentHandler f19328a;

        public State(ReactionAttachmentHandler reactionAttachmentHandler) {
            this.f19328a = reactionAttachmentHandler;
        }
    }

    private static ReactionAttachmentsFallbackPartDefinition m23331b() {
        return new ReactionAttachmentsFallbackPartDefinition();
    }

    public final Object m23333a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(((ReactionCardNode) obj).f18839b.f18874a);
    }

    public final boolean m23335a(Object obj) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        return (reactionCardNode.mo1117k().fx_() == null || reactionCardNode.f18839b.f18874a == null) ? false : true;
    }

    public final void m23336b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((LinearLayout) view).removeAllViews();
    }

    public final ViewType<LinearLayout> m23332a() {
        return f19329a;
    }

    public static ReactionAttachmentsFallbackPartDefinition m23329a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAttachmentsFallbackPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19331c) {
                ReactionAttachmentsFallbackPartDefinition reactionAttachmentsFallbackPartDefinition;
                if (a2 != null) {
                    reactionAttachmentsFallbackPartDefinition = (ReactionAttachmentsFallbackPartDefinition) a2.a(f19331c);
                } else {
                    reactionAttachmentsFallbackPartDefinition = f19330b;
                }
                if (reactionAttachmentsFallbackPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23331b();
                        if (a2 != null) {
                            a2.a(f19331c, b3);
                        } else {
                            f19330b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionAttachmentsFallbackPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m23330a(ReactionCardNode reactionCardNode, State state, E e, LinearLayout linearLayout) {
        state.f19328a.mo1127a(((HasReactionInteractionTracker) e).kE_(), linearLayout, ((HasReactionCardContainer) e).mo705q(), e.mo704p().f18658a, e.mo704p().f18660c, null);
        state.f19328a.mo1135a(reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n(), reactionCardNode.mo1117k().fx_());
    }
}
