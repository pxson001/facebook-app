package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.ReactionFacepilePartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_name */
public class ReactionTextWithInlineFacepileUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    public static final ViewType f20102a = ViewType.a(2130906652);
    private static ReactionTextWithInlineFacepileUnitComponentPartDefinition f20103e;
    private static final Object f20104f = new Object();
    private final ReactionFacepilePartDefinition f20105b;
    private final ReactionTextWithEntitiesPartDefinition f20106c;
    private final BasicReactionActionPartDefinition f20107d;

    private static ReactionTextWithInlineFacepileUnitComponentPartDefinition m23992b(InjectorLike injectorLike) {
        return new ReactionTextWithInlineFacepileUnitComponentPartDefinition(ReactionFacepilePartDefinition.m23002a(injectorLike), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    public static boolean m23991a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public final Object m23994a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566693, this.f20106c, new Props(reactionUnitComponentFields.bv(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        ImmutableList a = ReactionFacepilePartDefinition.m23003a(3, reactionUnitComponentFields.ca());
        if (CollectionUtil.b(a)) {
            subParts.a(2131566694, this.f20105b, a);
        }
        if (reactionUnitComponentFields.v() != null) {
            subParts.a(this.f20107d, new BasicReactionActionPartDefinition.Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    @Inject
    public ReactionTextWithInlineFacepileUnitComponentPartDefinition(ReactionFacepilePartDefinition reactionFacepilePartDefinition, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f20107d = basicReactionActionPartDefinition;
        this.f20105b = reactionFacepilePartDefinition;
        this.f20106c = reactionTextWithEntitiesPartDefinition;
    }

    public static ReactionTextWithInlineFacepileUnitComponentPartDefinition m23990a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTextWithInlineFacepileUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20104f) {
                ReactionTextWithInlineFacepileUnitComponentPartDefinition reactionTextWithInlineFacepileUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionTextWithInlineFacepileUnitComponentPartDefinition = (ReactionTextWithInlineFacepileUnitComponentPartDefinition) a2.a(f20104f);
                } else {
                    reactionTextWithInlineFacepileUnitComponentPartDefinition = f20103e;
                }
                if (reactionTextWithInlineFacepileUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23992b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20104f, b3);
                        } else {
                            f20103e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTextWithInlineFacepileUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23993a() {
        return f20102a;
    }
}
