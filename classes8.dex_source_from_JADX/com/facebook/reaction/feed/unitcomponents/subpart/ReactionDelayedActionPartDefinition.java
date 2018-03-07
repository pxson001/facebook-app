package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionDelayedActionKey;
import com.facebook.reaction.feed.persistentstate.ReactionDelayedActionPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [[contactpoint]] */
public class ReactionDelayedActionPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPersistentState & HasReactionSession> extends BaseSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    private static ReactionDelayedActionPartDefinition f20567d;
    private static final Object f20568e = new Object();
    public final ReactionActionHandler f20569a;
    private final ClickListenerPartDefinition f20570b;
    public final Handler f20571c;

    private static ReactionDelayedActionPartDefinition m24303b(InjectorLike injectorLike) {
        return new ReactionDelayedActionPartDefinition(ReactionActionHandler.m22673a(injectorLike), ClickListenerPartDefinition.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    public final Object m24304a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        final ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        final ReactionDelayedActionPersistentState reactionDelayedActionPersistentState = (ReactionDelayedActionPersistentState) ((HasPersistentState) canLaunchReactionIntent).a(new ReactionDelayedActionKey(reactionUnitComponentFields.v()), reactionUnitComponentNode);
        final CanLaunchReactionIntent canLaunchReactionIntent2 = canLaunchReactionIntent;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final Runnable c21801 = new Runnable(this) {
            final /* synthetic */ ReactionDelayedActionPartDefinition f20563e;

            public void run() {
                if (!reactionDelayedActionPersistentState.f19164a.getAndSet(true)) {
                    canLaunchReactionIntent2.mo695a(reactionUnitComponentNode2.f18863c, reactionUnitComponentNode2.f18864d, this.f20563e.f20569a.m22678a(reactionUnitComponentFields.v(), ((HasContext) canLaunchReactionIntent2).getContext(), null, ((HasReactionSession) canLaunchReactionIntent2).mo704p().f18658a, ((HasReactionSession) canLaunchReactionIntent2).mo704p().f18660c, reactionUnitComponentNode2.f18863c, reactionUnitComponentNode2.f18861a, reactionUnitComponentNode2.f18864d));
                }
            }
        };
        final boolean z = reactionUnitComponentFields.A() > 0;
        if (z) {
            HandlerDetour.b(this.f20571c, c21801, ((long) reactionUnitComponentFields.A()) * 1000, 1656465627);
        }
        subParts.a(this.f20570b, new OnClickListener(this) {
            final /* synthetic */ ReactionDelayedActionPartDefinition f20566c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -70065278);
                if (z) {
                    HandlerDetour.a(this.f20566c.f20571c, c21801);
                }
                c21801.run();
                Logger.a(2, EntryType.UI_INPUT_END, 768285773, a);
            }
        });
        return null;
    }

    @Inject
    public ReactionDelayedActionPartDefinition(ReactionActionHandler reactionActionHandler, ClickListenerPartDefinition clickListenerPartDefinition, Handler handler) {
        this.f20569a = reactionActionHandler;
        this.f20570b = clickListenerPartDefinition;
        this.f20571c = handler;
    }

    public static ReactionDelayedActionPartDefinition m24302a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionDelayedActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20568e) {
                ReactionDelayedActionPartDefinition reactionDelayedActionPartDefinition;
                if (a2 != null) {
                    reactionDelayedActionPartDefinition = (ReactionDelayedActionPartDefinition) a2.a(f20568e);
                } else {
                    reactionDelayedActionPartDefinition = f20567d;
                }
                if (reactionDelayedActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24303b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20568e, b3);
                        } else {
                            f20567d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionDelayedActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
