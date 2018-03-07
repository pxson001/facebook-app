package com.facebook.reaction.common;

import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment.PaginatedComponents;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponent;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFragmentDepth1;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFragmentDepth2;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: block_elements */
public class ReactionUnitComponentUtil {
    @Nullable
    public static ImmutableList<? extends ReactionUnitComponentFields> m22902b(ReactionUnitComponentNode reactionUnitComponentNode) {
        return m22899a(reactionUnitComponentNode.f18862b);
    }

    @Nullable
    public static PaginatedComponentsModel m22903c(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.f18862b instanceof ReactionPaginatedComponentFragment) {
            return ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.f18862b).dk();
        }
        return null;
    }

    @Nullable
    public static ReactionUnitComponentNode m22895a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        if (!(reactionUnitComponentFields instanceof ReactionUnitComponentModel)) {
            return null;
        }
        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitComponentFields;
        if (reactionUnitComponentModel.dm() == null || reactionUnitComponentModel.dm().cF().isEmpty()) {
            return null;
        }
        return new ReactionUnitComponentNode((ReactionUnitComponentFields) reactionUnitComponentModel.dm().cF().get(0), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a);
    }

    @Nullable
    public static ImmutableList<? extends ReactionUnitComponentFields> m22899a(ReactionUnitComponentFields reactionUnitComponentFields) {
        if (reactionUnitComponentFields instanceof ReactionUnitStaticAggregationComponentFragmentDepth2) {
            return ((ReactionUnitStaticAggregationComponentFragmentDepth2) reactionUnitComponentFields).cF();
        }
        if (reactionUnitComponentFields instanceof ReactionUnitStaticAggregationComponentFragmentDepth1) {
            return ((ReactionUnitStaticAggregationComponentFragmentDepth1) reactionUnitComponentFields).fW_();
        }
        return null;
    }

    @Nullable
    public static ImmutableList<? extends ReactionUnitComponentFields> m22901a(ReactionUnitComponent reactionUnitComponent) {
        PaginatedComponentsModel paginatedComponentsModel;
        if (reactionUnitComponent == null) {
            paginatedComponentsModel = null;
        } else {
            paginatedComponentsModel = reactionUnitComponent.dk();
        }
        return m22900a(paginatedComponentsModel);
    }

    @Nullable
    public static ImmutableList<? extends ReactionUnitComponentFields> m22904d(ReactionUnitComponentNode reactionUnitComponentNode) {
        return m22900a(m22903c(reactionUnitComponentNode));
    }

    @Nullable
    private static ImmutableList<? extends ReactionUnitComponentFields> m22900a(PaginatedComponents paginatedComponents) {
        if (paginatedComponents == null || paginatedComponents.c() == null) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList a = paginatedComponents.c().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (edgesModel.a() != null) {
                builder.c(edgesModel.a());
            }
        }
        return builder.b();
    }

    public static ReactionUnitFragmentModel m22897a(ReactionUnitFragment reactionUnitFragment, ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, String str) {
        if (reactionPaginatedComponentsModel.a() == null) {
            return ReactionUnitFragmentModel.a(reactionUnitFragment);
        }
        ReactionUnitComponentModel a = m22898a(reactionUnitFragment, str);
        if (a == null) {
            return ReactionUnitFragmentModel.a(reactionUnitFragment);
        }
        int i = 0;
        Builder builder = ImmutableList.builder();
        ImmutableList a2 = a.dk().c().a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            builder.c(EdgesModel.a((EdgesModel) a2.get(i2)));
        }
        ImmutableList a3 = reactionPaginatedComponentsModel.a();
        int size2 = a3.size();
        while (i < size2) {
            ReactionPaginatedComponentsModel.EdgesModel edgesModel = (ReactionPaginatedComponentsModel.EdgesModel) a3.get(i);
            EdgesModel.Builder builder2 = new EdgesModel.Builder();
            builder2.a = ReactionUnitSubComponentModel.a(edgesModel.a());
            builder.c(builder2.a());
            i++;
        }
        PaginatedComponentsModel.ReactionPaginatedComponentsModel.Builder a4 = PaginatedComponentsModel.ReactionPaginatedComponentsModel.Builder.a(PaginatedComponentsModel.ReactionPaginatedComponentsModel.a(a.dk().c()));
        a4.b = DefaultPageInfoFieldsModel.a(reactionPaginatedComponentsModel.b());
        a4 = a4;
        a4.a = builder.b();
        PaginatedComponentsModel.ReactionPaginatedComponentsModel a5 = a4.a();
        PaginatedComponentsModel.Builder a6 = PaginatedComponentsModel.Builder.a(PaginatedComponentsModel.a(a.dk()));
        a6.b = a5;
        PaginatedComponentsModel a7 = a6.a();
        ReactionUnitComponentModel.Builder a8 = ReactionUnitComponentModel.Builder.a(ReactionUnitComponentModel.a(a));
        a8.bw = a7;
        return m22896a(reactionUnitFragment, (ReactionUnitComponentFields) a8.a(), str);
    }

    @Nullable
    public static ReactionUnitComponentModel m22898a(ReactionUnitFragment reactionUnitFragment, String str) {
        ImmutableList s = reactionUnitFragment.s();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i);
            if (reactionUnitComponentModel.U().equals(str)) {
                return reactionUnitComponentModel;
            }
        }
        return null;
    }

    public static ReactionUnitFragmentModel m22896a(ReactionUnitFragment reactionUnitFragment, ReactionUnitComponentFields reactionUnitComponentFields, String str) {
        Builder builder = ImmutableList.builder();
        ImmutableList s = reactionUnitFragment.s();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i);
            if (reactionUnitComponentModel.U().equals(str) && (reactionUnitComponentFields instanceof ReactionUnitComponentModel)) {
                builder.c(ReactionUnitComponentModel.a((ReactionUnitComponentModel) reactionUnitComponentFields));
            } else if (str.contains(reactionUnitComponentModel.U()) && (reactionUnitComponentFields instanceof ReactionUnitSubComponentModel)) {
                Builder builder2 = ImmutableList.builder();
                ImmutableList cF = reactionUnitComponentModel.cF();
                int size2 = cF.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ReactionUnitSubComponentModel reactionUnitSubComponentModel = (ReactionUnitSubComponentModel) cF.get(i2);
                    if (reactionUnitSubComponentModel.U().equals(str)) {
                        builder2.c(ReactionUnitSubComponentModel.a((ReactionUnitSubComponentModel) reactionUnitComponentFields));
                    } else {
                        builder2.c(ReactionUnitSubComponentModel.a(reactionUnitSubComponentModel));
                    }
                }
                ReactionUnitComponentModel.Builder a = ReactionUnitComponentModel.Builder.a(ReactionUnitComponentModel.a(reactionUnitComponentModel));
                a.cA = builder2.b();
                builder.c(a.a());
            } else {
                builder.c(ReactionUnitComponentModel.a(reactionUnitComponentModel));
            }
        }
        ReactionUnitFragmentModel.Builder a2 = ReactionUnitFragmentModel.Builder.a(ReactionUnitFragmentModel.a(reactionUnitFragment));
        a2.i = builder.b();
        return a2.a();
    }
}
