package com.facebook.reaction;

import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionFeedbackFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: browser_alive_marker */
public class ReactionUnitTagHelper {

    /* compiled from: browser_alive_marker */
    class ReactionUnitIdFindingVisitor extends GraphQLReadOnlyVisitor {
        final Set<String> f18716a = new HashSet();

        public final boolean m22630a(GraphQLVisitableModel graphQLVisitableModel) {
            if (graphQLVisitableModel instanceof GraphQLPersistableNode) {
                m22629a(((GraphQLPersistableNode) graphQLVisitableModel).a());
            }
            if (graphQLVisitableModel instanceof ReactionFeedbackFieldsModel) {
                m22629a(((ReactionFeedbackFieldsModel) graphQLVisitableModel).d());
                m22629a(((ReactionFeedbackFieldsModel) graphQLVisitableModel).eF_());
            }
            if (graphQLVisitableModel instanceof ReactionStoryAttachmentStoryFragmentModel) {
                m22629a(((ReactionStoryAttachmentStoryFragmentModel) graphQLVisitableModel).g());
                m22629a(((ReactionStoryAttachmentStoryFragmentModel) graphQLVisitableModel).c());
            }
            return true;
        }

        private void m22629a(@Nullable String str) {
            if (!Strings.isNullOrEmpty(str)) {
                this.f18716a.add(str);
            }
        }
    }

    @Nullable
    public static Set<String> m22631a(@Nullable ReactionUnitFragment reactionUnitFragment) {
        Set<String> set = null;
        TracerDetour.a("ReactionUnitTagHelper.getTags", 1355792417);
        if (reactionUnitFragment == null) {
            TracerDetour.a(-425862630);
        } else {
            try {
                ReactionUnitIdFindingVisitor reactionUnitIdFindingVisitor = new ReactionUnitIdFindingVisitor();
                reactionUnitIdFindingVisitor.b((GraphQLVisitableModel) reactionUnitFragment);
                if (!reactionUnitIdFindingVisitor.f18716a.isEmpty()) {
                    set = ImmutableSet.copyOf(reactionUnitIdFindingVisitor.f18716a);
                }
                TracerDetour.a(-1080248714);
            } catch (Throwable th) {
                TracerDetour.a(1228326030);
            }
        }
        return set;
    }
}
