package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentsGroupPartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_admin_config */
public class ReactionStoryUnitGroupPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPositionInformation & HasReactionAnalyticsParams & HasReactionCardContainer & HasReactionInteractionTracker & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionStoryUnitGroupPartDefinition f19305g;
    private static final Object f19306h = new Object();
    private final ReactionAttachmentsGroupPartDefinition<E> f19307a;
    private final ReactionStoryBottomWithMarginPartDefinition f19308b;
    private final ReactionStoryFooterSelectorPartDefinition f19309c;
    private final ReactionStoryHeaderGroupPartDefinition<E> f19310d;
    private final ReactionStoryTopWithMarginPartDefinition f19311e;
    public final boolean f19312f;

    private static ReactionStoryUnitGroupPartDefinition m23310b(InjectorLike injectorLike) {
        return new ReactionStoryUnitGroupPartDefinition(ReactionAttachmentsGroupPartDefinition.m23337a(injectorLike), ReactionStoryBottomWithMarginPartDefinition.m23292a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionStoryFooterSelectorPartDefinition.m23296a(injectorLike), ReactionStoryHeaderGroupPartDefinition.m23300a(injectorLike), ReactionStoryTopWithMarginPartDefinition.m23305a(injectorLike));
    }

    public final Object m23311a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        Object obj3;
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        if (this.f19312f && reactionCardNode.mo1117k().fw_() != null && reactionCardNode.mo1117k().fw_().c() == GraphQLReactionUnitHeaderStyle.THIN_FACEPILE) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            baseMultiRowSubParts.a(this.f19311e, null);
        }
        baseMultiRowSubParts.a(this.f19310d, reactionCardNode);
        baseMultiRowSubParts.a(this.f19307a, reactionCardNode);
        baseMultiRowSubParts.a(this.f19309c, reactionCardNode);
        if (obj3 != null) {
            baseMultiRowSubParts.a(this.f19308b, null);
        }
        return null;
    }

    public final boolean m23312a(Object obj) {
        ReactionUnitFragment k = ((ReactionCardNode) obj).mo1117k();
        return (Strings.isNullOrEmpty(k.d()) || Strings.isNullOrEmpty(k.n())) ? false : true;
    }

    @Inject
    public ReactionStoryUnitGroupPartDefinition(ReactionAttachmentsGroupPartDefinition reactionAttachmentsGroupPartDefinition, ReactionStoryBottomWithMarginPartDefinition reactionStoryBottomWithMarginPartDefinition, ReactionExperimentController reactionExperimentController, ReactionStoryFooterSelectorPartDefinition reactionStoryFooterSelectorPartDefinition, ReactionStoryHeaderGroupPartDefinition reactionStoryHeaderGroupPartDefinition, ReactionStoryTopWithMarginPartDefinition reactionStoryTopWithMarginPartDefinition) {
        this.f19307a = reactionAttachmentsGroupPartDefinition;
        this.f19308b = reactionStoryBottomWithMarginPartDefinition;
        this.f19309c = reactionStoryFooterSelectorPartDefinition;
        this.f19310d = reactionStoryHeaderGroupPartDefinition;
        this.f19311e = reactionStoryTopWithMarginPartDefinition;
        this.f19312f = reactionExperimentController.o();
    }

    public static ReactionStoryUnitGroupPartDefinition m23309a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryUnitGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19306h) {
                ReactionStoryUnitGroupPartDefinition reactionStoryUnitGroupPartDefinition;
                if (a2 != null) {
                    reactionStoryUnitGroupPartDefinition = (ReactionStoryUnitGroupPartDefinition) a2.a(f19306h);
                } else {
                    reactionStoryUnitGroupPartDefinition = f19305g;
                }
                if (reactionStoryUnitGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23310b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19306h, b3);
                        } else {
                            f19305g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionStoryUnitGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
