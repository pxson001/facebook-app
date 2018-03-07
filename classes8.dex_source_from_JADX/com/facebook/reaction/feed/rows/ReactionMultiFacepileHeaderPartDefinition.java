package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.ReactionFacepilePartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props;
import com.facebook.reaction.feed.styling.ReactionBackgroundPartDefinition;
import com.facebook.reaction.feed.styling.ReactionBackgroundPartDefinition.StylingData;
import com.facebook.reaction.feed.styling.ReactionPaddingStyleConstants;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_moments_app_info */
public class ReactionMultiFacepileHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPositionInformation & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, LinearLayout> {
    public static final ViewType f19260a = ViewType.a(2130906626);
    private static ReactionMultiFacepileHeaderPartDefinition f19261g;
    private static final Object f19262h = new Object();
    private final BasicReactionActionPartDefinition f19263b;
    private final ReactionBackgroundPartDefinition<E> f19264c;
    private final ReactionFacepilePartDefinition f19265d;
    private final ReactionTextWithEntitiesPartDefinition f19266e;
    private final boolean f19267f;

    private static ReactionMultiFacepileHeaderPartDefinition m23276b(InjectorLike injectorLike) {
        return new ReactionMultiFacepileHeaderPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionBackgroundPartDefinition.m23451a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionFacepilePartDefinition.m23002a(injectorLike), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23278a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        String d = reactionCardNode.mo1117k().d();
        String n = reactionCardNode.mo1117k().n();
        if (this.f19267f) {
            subParts.a(this.f19264c, new StylingData(FeedProps.c(reactionCardNode), ReactionPaddingStyleConstants.f19519a));
        }
        subParts.a(2131566712, this.f19266e, new Props(fw_.fA_(), d, n));
        subParts.a(2131566651, this.f19265d, ReactionFacepilePartDefinition.m23003a(8, fw_.g()));
        ReactionStoryAttachmentActionFragmentModel b = fw_.b();
        if (b != null) {
            subParts.a(2131566651, this.f19263b, new BasicReactionActionPartDefinition.Props(b, b.M() != null ? b.M().j() : null, d, n));
        }
        return null;
    }

    public final boolean m23279a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        if (!(fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()))) {
            ImmutableList g = fw_.g();
            Object obj2 = null;
            if (g.size() > 1) {
                for (int i = 0; i < Math.min(8, g.size()); i++) {
                    ReactionFacepileProfile reactionFacepileProfile = (ReactionFacepileProfile) g.get(i);
                    if (reactionFacepileProfile.d() == null || Strings.isNullOrEmpty(reactionFacepileProfile.d().b())) {
                        break;
                    }
                }
                int i2 = 1;
            }
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public static ReactionMultiFacepileHeaderPartDefinition m23275a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionMultiFacepileHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19262h) {
                ReactionMultiFacepileHeaderPartDefinition reactionMultiFacepileHeaderPartDefinition;
                if (a2 != null) {
                    reactionMultiFacepileHeaderPartDefinition = (ReactionMultiFacepileHeaderPartDefinition) a2.a(f19262h);
                } else {
                    reactionMultiFacepileHeaderPartDefinition = f19261g;
                }
                if (reactionMultiFacepileHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23276b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19262h, b3);
                        } else {
                            f19261g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionMultiFacepileHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionMultiFacepileHeaderPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionBackgroundPartDefinition reactionBackgroundPartDefinition, ReactionExperimentController reactionExperimentController, ReactionFacepilePartDefinition reactionFacepilePartDefinition, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19263b = basicReactionActionPartDefinition;
        this.f19264c = reactionBackgroundPartDefinition;
        this.f19265d = reactionFacepilePartDefinition;
        this.f19266e = reactionTextWithEntitiesPartDefinition;
        this.f19267f = reactionExperimentController.o();
    }

    public final ViewType m23277a() {
        return f19260a;
    }
}
