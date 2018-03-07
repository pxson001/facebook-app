package com.facebook.controller.mutation.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLNode.Builder;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlaceListItem;
import com.facebook.graphql.model.GraphQLPlaceListItemToRecommendingCommentsConnection;
import com.facebook.graphql.model.GraphQLPlaceListItemsFromPlaceListConnection;
import com.facebook.graphql.model.GraphQLQuestionOption;
import com.facebook.graphql.model.GraphQLQuestionOptionVotersConnection;
import com.facebook.graphql.model.GraphQLQuestionOptionsConnection;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sampling_frequency */
public class AttachmentMutator {
    private static final String f6328a = AttachmentMutator.class.getSimpleName();
    public final ActionLinkMutator f6329b;
    public final ActionLinkListMutator f6330c;
    private final AbstractFbErrorReporter f6331d;

    public static AttachmentMutator m10660b(InjectorLike injectorLike) {
        return new AttachmentMutator(ActionLinkMutator.m10662b(injectorLike), ActionLinkListMutator.m10664a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public AttachmentMutator(ActionLinkMutator actionLinkMutator, ActionLinkListMutator actionLinkListMutator, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f6329b = actionLinkMutator;
        this.f6330c = actionLinkListMutator;
        this.f6331d = abstractFbErrorReporter;
    }

    public static GraphQLStoryAttachment m10656a(GraphQLStoryAttachment graphQLStoryAttachment, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        GraphQLNode z = graphQLStoryAttachment.m23987z();
        if (z.cU() == graphQLFriendshipStatus) {
            return graphQLStoryAttachment;
        }
        GraphQLNode graphQLNode = null;
        if (z.m23390j() != null && z.m23390j().m22301g() == 2645995) {
            graphQLNode = Builder.a(z).a(graphQLFriendshipStatus).a();
        }
        GraphQLStoryAttachment.Builder a = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        a.t = graphQLNode;
        return a.a();
    }

    public static GraphQLStoryAttachment m10654a(GraphQLStoryAttachment graphQLStoryAttachment, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLStoryAttachment.m23987z().je() == graphQLEventGuestStatus) {
            return graphQLStoryAttachment;
        }
        GraphQLNode a = Builder.a(graphQLStoryAttachment.m23987z()).a(graphQLEventGuestStatus).a();
        GraphQLStoryAttachment.Builder a2 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        a2.t = a;
        return a2.a();
    }

    public static GraphQLStoryAttachment m10655a(GraphQLStoryAttachment graphQLStoryAttachment, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (graphQLStoryAttachment.m23987z().jq() == graphQLEventWatchStatus) {
            return graphQLStoryAttachment;
        }
        GraphQLNode a = Builder.a(graphQLStoryAttachment.m23987z()).a(graphQLEventWatchStatus).a();
        GraphQLStoryAttachment.Builder a2 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        a2.t = a;
        return a2.a();
    }

    public static GraphQLStoryAttachment m10659a(GraphQLStoryAttachment graphQLStoryAttachment, String str, boolean z, boolean z2) {
        GraphQLStoryAttachment.Builder a = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        Builder a2 = Builder.a(graphQLStoryAttachment.m23987z());
        GraphQLQuestionOptionsConnection.Builder a3 = GraphQLQuestionOptionsConnection.Builder.a(graphQLStoryAttachment.m23987z().eV());
        ImmutableList a4 = graphQLStoryAttachment.m23987z().eV().m24605a();
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = a4.size();
        for (int i = 0; i < size; i++) {
            GraphQLQuestionOption graphQLQuestionOption = (GraphQLQuestionOption) a4.get(i);
            if (graphQLQuestionOption.j().equals(str)) {
                builder.m1069c(m10653a(graphQLQuestionOption, z));
            } else if (graphQLQuestionOption.m() && z2) {
                builder.m1069c(m10653a(graphQLQuestionOption, graphQLQuestionOption.m()));
            } else {
                builder.m1069c(graphQLQuestionOption);
            }
        }
        a3.d = builder.m1068b();
        a2.fG = a3.a();
        a.t = a2.a();
        return a.a();
    }

    public static GraphQLStoryAttachment m10658a(GraphQLStoryAttachment graphQLStoryAttachment, String str, String str2) {
        GraphQLStoryAttachment.Builder a = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        Builder a2 = Builder.a(graphQLStoryAttachment.m23987z());
        GraphQLQuestionOptionsConnection.Builder a3 = GraphQLQuestionOptionsConnection.Builder.a(graphQLStoryAttachment.m23987z().eV());
        Iterable a4 = graphQLStoryAttachment.m23987z().eV().m24605a();
        ImmutableList.Builder builder = ImmutableList.builder();
        GraphQLQuestionOption.Builder builder2 = new GraphQLQuestionOption.Builder();
        GraphQLTextWithEntities.Builder builder3 = new GraphQLTextWithEntities.Builder();
        builder3.f15877i = str;
        builder2.e = builder3.m22613a();
        builder2.d = str2;
        builder2.a(false);
        GraphQLQuestionOptionVotersConnection.Builder builder4 = new GraphQLQuestionOptionVotersConnection.Builder();
        builder4.a(0);
        builder4.e = RegularImmutableList.f535a;
        builder2.h = builder4.a();
        builder.m1069c(builder2.a());
        builder.m1065b(a4);
        a3.d = builder.m1068b();
        a2.fG = a3.a();
        a.t = a2.a();
        return a.a();
    }

    public static GraphQLStoryAttachment m10657a(GraphQLStoryAttachment graphQLStoryAttachment, GraphQLPage graphQLPage, GraphQLComment graphQLComment) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = graphQLStoryAttachment.m23987z().jF().m24476a();
        int size = a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            GraphQLPlaceListItem graphQLPlaceListItem = (GraphQLPlaceListItem) a.get(i);
            if (graphQLPlaceListItem.k().ae().equals(graphQLPage.ae())) {
                GraphQLPlaceListItem.Builder a2 = GraphQLPlaceListItem.Builder.a(graphQLPlaceListItem);
                GraphQLPlaceListItemToRecommendingCommentsConnection.Builder builder2 = new GraphQLPlaceListItemToRecommendingCommentsConnection.Builder();
                builder2.d = ImmutableList.builder().m1065b(graphQLPlaceListItem.m().a()).m1069c(graphQLComment).m1068b();
                a2.f = builder2.a();
                builder.m1069c(a2.a());
                obj2 = 1;
            } else {
                builder.m1069c(graphQLPlaceListItem);
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            builder.m1069c(m10651a(graphQLPage, graphQLComment));
        }
        GraphQLStoryAttachment.Builder a3 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        Builder a4 = Builder.a(graphQLStoryAttachment.m23987z());
        GraphQLPlaceListItemsFromPlaceListConnection.Builder builder3 = new GraphQLPlaceListItemsFromPlaceListConnection.Builder();
        builder3.d = builder.m1068b();
        a4.eP = builder3.a();
        a3.t = a4.a();
        return a3.a();
    }

    private static GraphQLQuestionOption m10653a(GraphQLQuestionOption graphQLQuestionOption, boolean z) {
        GraphQLQuestionOption.Builder builder = new GraphQLQuestionOption.Builder();
        graphQLQuestionOption.m9958h();
        builder.d = graphQLQuestionOption.j();
        builder.e = graphQLQuestionOption.k();
        builder.f = graphQLQuestionOption.l();
        builder.g = graphQLQuestionOption.m();
        builder.h = graphQLQuestionOption.n();
        BaseModel.Builder.m22419a(builder, graphQLQuestionOption);
        GraphQLQuestionOption.Builder builder2 = builder;
        builder2.a(!z);
        GraphQLQuestionOptionVotersConnection n = graphQLQuestionOption.n();
        GraphQLQuestionOptionVotersConnection.Builder builder3 = new GraphQLQuestionOptionVotersConnection.Builder();
        n.m9958h();
        builder3.d = n.a();
        builder3.e = n.j();
        builder3.f = n.k();
        BaseModel.Builder.m22419a(builder3, n);
        GraphQLQuestionOptionVotersConnection.Builder builder4 = builder3;
        if (z) {
            builder4.a(graphQLQuestionOption.n().a() - 1);
        } else {
            builder4.a(graphQLQuestionOption.n().a() + 1);
        }
        builder2.h = builder4.a();
        return builder2.a();
    }

    public final GraphQLStoryAttachment m10661a(GraphQLStoryAttachment graphQLStoryAttachment, String str, String str2, boolean z) {
        if (!z) {
            return graphQLStoryAttachment;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = graphQLStoryAttachment.m23987z().jF().m24476a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPlaceListItem graphQLPlaceListItem = (GraphQLPlaceListItem) a.get(i);
            if (graphQLPlaceListItem.k().ae().equals(str)) {
                graphQLPlaceListItem = m10652a(graphQLPlaceListItem, str2);
                if (graphQLPlaceListItem != null) {
                    builder.m1069c(graphQLPlaceListItem);
                }
            } else {
                builder.m1069c(graphQLPlaceListItem);
            }
        }
        GraphQLStoryAttachment.Builder a2 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        Builder a3 = Builder.a(graphQLStoryAttachment.m23987z());
        GraphQLPlaceListItemsFromPlaceListConnection.Builder builder2 = new GraphQLPlaceListItemsFromPlaceListConnection.Builder();
        builder2.d = builder.m1068b();
        a3.eP = builder2.a();
        a2.t = a3.a();
        return a2.a();
    }

    @Nullable
    private GraphQLPlaceListItem m10652a(GraphQLPlaceListItem graphQLPlaceListItem, String str) {
        ImmutableList a = graphQLPlaceListItem.m().a();
        if (a.size() == 1) {
            if (!((GraphQLComment) a.get(0)).m27192y().equals(str)) {
                this.f6331d.m2340a(f6328a, "Did not find a matching comment to remove");
            }
            return null;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = a.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            GraphQLComment graphQLComment = (GraphQLComment) a.get(i);
            if (graphQLComment.m27192y().equals(str)) {
                i3 = 1;
            } else {
                builder.m1069c(graphQLComment);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 == 0) {
            this.f6331d.m2340a(f6328a, "Did not find a matching comment to remove");
        }
        GraphQLPlaceListItem.Builder a2 = GraphQLPlaceListItem.Builder.a(graphQLPlaceListItem);
        GraphQLPlaceListItemToRecommendingCommentsConnection.Builder builder2 = new GraphQLPlaceListItemToRecommendingCommentsConnection.Builder();
        builder2.d = builder.m1068b();
        a2.f = builder2.a();
        return a2.a();
    }

    private static GraphQLPlaceListItem m10651a(GraphQLPage graphQLPage, GraphQLComment graphQLComment) {
        GraphQLPlaceListItem.Builder builder = new GraphQLPlaceListItem.Builder();
        builder.e = graphQLPage;
        builder = builder;
        GraphQLPlaceListItemToRecommendingCommentsConnection.Builder builder2 = new GraphQLPlaceListItemToRecommendingCommentsConnection.Builder();
        builder2.d = ImmutableList.of(graphQLComment);
        builder.f = builder2.a();
        return builder.a();
    }
}
