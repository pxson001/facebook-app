package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionProfileFrameComponentFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: actionsMap */
public class ReactionProfileFramePartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType f20000a = new C21401();
    private static ReactionProfileFramePartDefinition f20001g;
    private static final Object f20002h = new Object();
    private final FbDraweePartDefinition f20003b;
    private final FbDraweePartDefinition f20004c;
    private final TextPartDefinition f20005d;
    private final BasicReactionActionPartDefinition f20006e;
    private final BasicReactionActionPartDefinition f20007f;

    /* compiled from: actionsMap */
    final class C21401 extends ViewType {
        C21401() {
        }

        public final View m23893a(Context context) {
            return LayoutInflater.from(context).inflate(2130906708, null);
        }
    }

    private static ReactionProfileFramePartDefinition m23895b(InjectorLike injectorLike) {
        return new ReactionProfileFramePartDefinition(FbDraweePartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    private static ReactionProfileFrameComponentFragment m23896b(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.f18862b instanceof ReactionProfileFrameComponentFragment) {
            return reactionUnitComponentNode.f18862b;
        }
        throw new Error("Could not convert unit component to ProfileFrameGraphQLFragment.");
    }

    public final Object m23898a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String a;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionProfileFrameComponentFragment b = m23896b(reactionUnitComponentNode);
        CallerContext a2 = CallerContext.a(getClass(), "a_place_for");
        subParts.a(2131566774, this.f20005d, b.dj().a());
        String a3 = b.bZ().a();
        if (b.au() != null) {
            a = b.au().a();
        } else {
            a = null;
        }
        FbDraweePartDefinition fbDraweePartDefinition = this.f20004c;
        Builder a4 = FbDraweePartDefinition.a().a(a3).a(920, 920);
        a4.c = a2;
        subParts.a(2131566772, fbDraweePartDefinition, a4.a());
        if (a != null) {
            FbDraweePartDefinition fbDraweePartDefinition2 = this.f20003b;
            Builder a5 = FbDraweePartDefinition.a().a(a).a(920, 920);
            a5.c = a2;
            subParts.a(2131566773, fbDraweePartDefinition2, a5.a());
        }
        if (b.v() != null) {
            subParts.a(2131566771, this.f20006e, new Props(b.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
            subParts.a(2131566774, this.f20007f, new Props(b.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23899a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Logger.a(8, EntryType.MARK_POP, 285953716, Logger.a(8, EntryType.MARK_PUSH, 267486633));
    }

    public final boolean m23900a(Object obj) {
        ReactionProfileFrameComponentFragment b = m23896b((ReactionUnitComponentNode) obj);
        return (b.dj() == null || Strings.isNullOrEmpty(b.dj().a()) || b.bZ() == null || Strings.isNullOrEmpty(b.bZ().a())) ? false : true;
    }

    @Inject
    public ReactionProfileFramePartDefinition(FbDraweePartDefinition fbDraweePartDefinition, FbDraweePartDefinition fbDraweePartDefinition2, TextPartDefinition textPartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition2) {
        this.f20004c = fbDraweePartDefinition;
        this.f20003b = fbDraweePartDefinition2;
        this.f20005d = textPartDefinition;
        this.f20006e = basicReactionActionPartDefinition;
        this.f20007f = basicReactionActionPartDefinition2;
    }

    public static ReactionProfileFramePartDefinition m23894a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionProfileFramePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20002h) {
                ReactionProfileFramePartDefinition reactionProfileFramePartDefinition;
                if (a2 != null) {
                    reactionProfileFramePartDefinition = (ReactionProfileFramePartDefinition) a2.a(f20002h);
                } else {
                    reactionProfileFramePartDefinition = f20001g;
                }
                if (reactionProfileFramePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23895b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20002h, b3);
                        } else {
                            f20001g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionProfileFramePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23897a() {
        return f20000a;
    }
}
