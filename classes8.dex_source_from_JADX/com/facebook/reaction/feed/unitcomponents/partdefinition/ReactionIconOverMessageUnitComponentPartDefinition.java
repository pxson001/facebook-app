package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ads_encrypted_data */
public class ReactionIconOverMessageUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    public static final ViewType f19808a = ViewType.a(2130906641);
    static final CallerContext f19809b = CallerContext.a(ReactionIconOverMessageUnitComponentPartDefinition.class, "reaction_dialog");
    private static ReactionIconOverMessageUnitComponentPartDefinition f19810f;
    private static final Object f19811g = new Object();
    private final BasicReactionActionPartDefinition f19812c;
    private final FbDraweePartDefinition<E> f19813d;
    private final TextPartDefinition f19814e;

    private static ReactionIconOverMessageUnitComponentPartDefinition m23722b(InjectorLike injectorLike) {
        return new ReactionIconOverMessageUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23724a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        FbDraweePartDefinition fbDraweePartDefinition = this.f19813d;
        Builder a = FbDraweePartDefinition.a().a(reactionUnitComponentFields.aP().b());
        a.c = f19809b;
        subParts.a(2131566673, fbDraweePartDefinition, a.a());
        subParts.a(2131566674, this.f19814e, reactionUnitComponentFields.bv().a());
        if (reactionUnitComponentFields.v() != null) {
            subParts.a(this.f19812c, new Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final boolean m23725a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.aP() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aP().b())) ? false : true;
    }

    public static ReactionIconOverMessageUnitComponentPartDefinition m23721a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconOverMessageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19811g) {
                ReactionIconOverMessageUnitComponentPartDefinition reactionIconOverMessageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionIconOverMessageUnitComponentPartDefinition = (ReactionIconOverMessageUnitComponentPartDefinition) a2.a(f19811g);
                } else {
                    reactionIconOverMessageUnitComponentPartDefinition = f19810f;
                }
                if (reactionIconOverMessageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23722b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19811g, b3);
                        } else {
                            f19810f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconOverMessageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23723a() {
        return f19808a;
    }

    @Inject
    public ReactionIconOverMessageUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition) {
        this.f19812c = basicReactionActionPartDefinition;
        this.f19813d = fbDraweePartDefinition;
        this.f19814e = textPartDefinition;
    }
}
