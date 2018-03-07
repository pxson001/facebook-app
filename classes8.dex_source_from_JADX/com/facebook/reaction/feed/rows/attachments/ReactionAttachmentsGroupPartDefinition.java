package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.common.ReactionAttachmentStyleMapper;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ar_device_data */
public class ReactionAttachmentsGroupPartDefinition<E extends HasContext & HasReactionCardContainer & HasReactionInteractionTracker> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionAttachmentsGroupPartDefinition f19332d;
    private static final Object f19333e = new Object();
    public final ReactionAttachmentsFallbackPartDefinition f19334a;
    private final ReactionAttachmentStyleMapper f19335b;
    public boolean f19336c;

    private static ReactionAttachmentsGroupPartDefinition m23338b(InjectorLike injectorLike) {
        return new ReactionAttachmentsGroupPartDefinition(ReactionAttachmentsFallbackPartDefinition.m23329a(injectorLike), ReactionAttachmentStyleMapper.m22863a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    public final Object m23339a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded;
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionAttachmentsModel fx_ = reactionCardNode.mo1117k().fx_();
        ReactionAttachmentStyleMapper reactionAttachmentStyleMapper = this.f19335b;
        ReactionAttachmentStyle a = reactionAttachmentStyleMapper.f18837a.mo1114a(fx_.d());
        if (a == null) {
            multiRowPartWithIsNeeded = null;
        } else {
            multiRowPartWithIsNeeded = a.mo1148a();
        }
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded2 = multiRowPartWithIsNeeded;
        ReactionAttachmentStyleMapper reactionAttachmentStyleMapper2 = this.f19335b;
        if (reactionAttachmentStyleMapper2.f18837a.mo1114a(fx_.d()) == null) {
            multiRowPartWithIsNeeded = null;
        } else {
            multiRowPartWithIsNeeded = null;
        }
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded3 = multiRowPartWithIsNeeded;
        if (!this.f19336c || (multiRowPartWithIsNeeded3 == null && multiRowPartWithIsNeeded2 == null)) {
            baseMultiRowSubParts.a(this.f19334a, reactionCardNode);
        } else if (multiRowPartWithIsNeeded3 != null) {
            baseMultiRowSubParts.a(multiRowPartWithIsNeeded3, reactionCardNode);
        } else {
            ImmutableList b = reactionCardNode.mo1117k().fx_().b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) b.get(i);
                if (!(edgesModel == null || edgesModel.a() == null)) {
                    baseMultiRowSubParts.a(multiRowPartWithIsNeeded2, new ReactionAttachmentNode(edgesModel.a(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
                }
            }
        }
        return null;
    }

    public final boolean m23340a(Object obj) {
        ReactionAttachmentsModel fx_ = ((ReactionCardNode) obj).mo1117k().fx_();
        return (fx_ == null || fx_.b().isEmpty() || fx_.d() == null || fx_.d() == GraphQLReactionStoryAttachmentsStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? false : true;
    }

    @Inject
    public ReactionAttachmentsGroupPartDefinition(ReactionAttachmentsFallbackPartDefinition reactionAttachmentsFallbackPartDefinition, ReactionAttachmentStyleMapper reactionAttachmentStyleMapper, ReactionExperimentController reactionExperimentController) {
        this.f19334a = reactionAttachmentsFallbackPartDefinition;
        this.f19335b = reactionAttachmentStyleMapper;
        this.f19336c = reactionExperimentController.a.a(1074, false);
    }

    public static ReactionAttachmentsGroupPartDefinition m23337a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAttachmentsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19333e) {
                ReactionAttachmentsGroupPartDefinition reactionAttachmentsGroupPartDefinition;
                if (a2 != null) {
                    reactionAttachmentsGroupPartDefinition = (ReactionAttachmentsGroupPartDefinition) a2.a(f19333e);
                } else {
                    reactionAttachmentsGroupPartDefinition = f19332d;
                }
                if (reactionAttachmentsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23338b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19333e, b3);
                        } else {
                            f19332d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionAttachmentsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
