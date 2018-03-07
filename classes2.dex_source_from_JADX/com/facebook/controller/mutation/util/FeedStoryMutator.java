package com.facebook.controller.mutation.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedbackMutator.Result;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.CallToActionResolver;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryType;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryTypeResolver;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PrimaryActionLinkResolver;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLCurrencyQuantity;
import com.facebook.graphql.model.GraphQLEditHistoryConnection;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitsConnection;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitsEdge;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge;
import com.facebook.graphql.model.GraphQLPeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLQuickPromotionPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLStatelessLargeImagePLAsConnection;
import com.facebook.graphql.model.GraphQLStatelessLargeImagePLAsEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLStorySetStoriesConnection;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PropertyBag;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.graphql.model.mutator.GraphQLLikersOfContentConnectionMutator;
import com.facebook.graphql.model.mutator.GraphQLStoryMutator;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.maps.rows.TravelStoryHelper;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sampling_weight */
public class FeedStoryMutator {
    private static final String f6314a = FeedStoryMutator.class.getName();
    private final FeedbackMutator f6315b;
    private final ActionLinkMutator f6316c;
    private final ActionLinkListMutator f6317d;
    private final AttachmentMutator f6318e;
    private final AttachmentListMutator f6319f;
    public final AttachmentTargetMutator f6320g;
    private final AbstractFbErrorReporter f6321h;
    public final Clock f6322i;
    private final CallToActionResolver f6323j;
    private final TravelStoryHelper f6324k;

    public static FeedStoryMutator m10586b(InjectorLike injectorLike) {
        return new FeedStoryMutator(FeedbackMutator.m10618a(injectorLike), AttachmentMutator.m10660b(injectorLike), AttachmentListMutator.m10672b(injectorLike), ActionLinkMutator.m10662b(injectorLike), ActionLinkListMutator.m10664a(injectorLike), AttachmentTargetMutator.m10674a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), CallToActionResolver.m10678a(injectorLike), TravelStoryHelper.m10683b(injectorLike));
    }

    public static FeedStoryMutator m10578a(InjectorLike injectorLike) {
        return m10586b(injectorLike);
    }

    private FeedProps<GraphQLStory> m10587b(FeedProps<GraphQLStory> feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Preconditions.checkNotNull(StoryActionLinkHelper.m28074a(graphQLStory));
        Collection a = this.f6317d.m10670a(StoryActionLinkHelper.m28074a(graphQLStory), this.f6316c.m10663a(graphQLStoryActionLink));
        Builder a2 = Builder.a(graphQLStory);
        a2.d = ImmutableListHelper.m21625a(a);
        a2 = a2;
        a2.F = this.f6322i.mo211a();
        return m10579a(a2.a(), (FeedProps) feedProps);
    }

    private FeedProps<GraphQLStory> m10591c(FeedProps<GraphQLStory> feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Preconditions.checkNotNull(StoryActionLinkHelper.m28075b(graphQLStory));
        ImmutableList a = this.f6317d.m10670a(StoryActionLinkHelper.m28075b(graphQLStory), this.f6316c.m10663a(graphQLStoryActionLink));
        Builder a2 = Builder.a(graphQLStory);
        a2.k = a;
        a2 = a2;
        a2.F = this.f6322i.mo211a();
        return m10579a(a2.a(), (FeedProps) feedProps);
    }

    private FeedProps<GraphQLStory> m10592d(FeedProps<GraphQLStory> feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Preconditions.checkNotNull(StoryAttachmentHelper.m28042o(graphQLStory));
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        AttachmentMutator attachmentMutator = this.f6318e;
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o.m23971j());
        ImmutableList a = attachmentMutator.f6330c.m10670a(o.m23971j(), attachmentMutator.f6329b.m10663a(graphQLStoryActionLink));
        GraphQLStoryAttachment.Builder a2 = GraphQLStoryAttachment.Builder.a(o);
        a2.d = a;
        ImmutableList a3 = AttachmentListMutator.m10671a(graphQLStory.m22367x(), a2.a());
        Builder a4 = Builder.a(graphQLStory);
        a4.m = a3;
        a4 = a4;
        a4.F = this.f6322i.mo211a();
        return m10579a(a4.a(), (FeedProps) feedProps);
    }

    public final FeedProps<GraphQLStory> m10593a(FeedProps<GraphQLStory> feedProps, StoryVisibility storyVisibility) {
        String str;
        Builder a = Builder.a((GraphQLStory) feedProps.f13444a);
        if (storyVisibility == null) {
            str = null;
        } else {
            str = storyVisibility.name();
        }
        Builder a2 = a.g(str).a(((GraphQLStory) feedProps.f13444a).mo2880p());
        a2.F = this.f6322i.mo211a();
        return m10579a(a2.a(), (FeedProps) feedProps);
    }

    public final FeedProps<GraphQLStory> m10594a(FeedProps<GraphQLStory> feedProps, GraphQLActor graphQLActor) {
        return m10595a((FeedProps) feedProps, graphQLActor, !((GraphQLStory) feedProps.f13444a).m22316B());
    }

    public final FeedProps<GraphQLStory> m10596a(FeedProps<GraphQLStory> feedProps, GraphQLFeedback graphQLFeedback) {
        return m10579a(m10581a((GraphQLStory) feedProps.f13444a, graphQLFeedback), (FeedProps) feedProps);
    }

    @Nullable
    public final FeedProps<GraphQLStory> m10597a(FeedProps<GraphQLStory> feedProps, GraphQLPage graphQLPage, String str) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Preconditions.checkNotNull(StoryAttachmentHelper.m28042o(graphQLStory));
        Result a = this.f6315b.m10636a(graphQLStory.mo2890l(), graphQLPage, str);
        if (a == null) {
            return feedProps;
        }
        ImmutableList a2 = AttachmentListMutator.m10671a(graphQLStory.m22367x(), AttachmentMutator.m10657a(StoryAttachmentHelper.m28042o(graphQLStory), graphQLPage, a.b));
        Builder a3 = Builder.a(graphQLStory);
        a3.m = a2;
        a3 = a3;
        a3.D = a.a;
        a3 = a3;
        a3.F = this.f6322i.mo211a();
        return m10579a(a3.a(), (FeedProps) feedProps);
    }

    public final FeedProps<GraphQLStory> m10599a(FeedProps<GraphQLStoryAttachment> feedProps, String str, String str2) {
        GraphQLStoryAttachment a = AttachmentMutator.m10658a((GraphQLStoryAttachment) feedProps.f13444a, str, str2);
        FeedProps e = AttachmentProps.m28715e(feedProps);
        Builder a2 = Builder.a((GraphQLStory) e.f13444a);
        a2.m = AttachmentListMutator.m10671a(((GraphQLStory) e.f13444a).m22327M(), a);
        Builder builder = a2;
        builder.F = this.f6322i.mo211a();
        return m10579a(builder.a(), e);
    }

    @Nullable
    public final FeedProps<GraphQLStory> m10600a(FeedProps<GraphQLStory> feedProps, String str, String str2, boolean z) {
        GraphQLFeedback graphQLFeedback;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Preconditions.checkNotNull(StoryAttachmentHelper.m28042o(graphQLStory));
        ImmutableList a = AttachmentListMutator.m10671a(graphQLStory.m22367x(), this.f6318e.m10661a(StoryAttachmentHelper.m28042o(graphQLStory), str, str2, z));
        Result a2 = this.f6315b.m10637a(graphQLStory.mo2890l(), str2, str, z);
        Builder a3 = Builder.a(graphQLStory);
        a3.m = a;
        Builder builder = a3;
        if (a2 != null) {
            graphQLFeedback = a2.a;
        } else {
            graphQLFeedback = graphQLStory.mo2890l();
        }
        builder.D = graphQLFeedback;
        Builder builder2 = builder;
        builder2.F = this.f6322i.mo211a();
        return m10579a(builder2.a(), (FeedProps) feedProps);
    }

    public final FeedProps<GraphQLStory> m10601a(FeedProps<GraphQLStoryAttachment> feedProps, String str, boolean z, boolean z2) {
        GraphQLStoryAttachment a = AttachmentMutator.m10659a((GraphQLStoryAttachment) feedProps.f13444a, str, z, z2);
        FeedProps e = AttachmentProps.m28715e(feedProps);
        Builder a2 = Builder.a((GraphQLStory) e.f13444a);
        a2.m = AttachmentListMutator.m10671a(((GraphQLStory) e.f13444a).m22327M(), a);
        Builder builder = a2;
        builder.F = this.f6322i.mo211a();
        return m10579a(builder.a(), e);
    }

    public final FeedProps<GraphQLStory> m10602a(FeedProps<GraphQLStory> feedProps, boolean z) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.mo2890l() == null) {
            this.f6321h.m2350b(f6314a, "Story feedback is null: " + graphQLStory.S_());
            return FeedProps.m19802c(graphQLStory);
        }
        GraphQLFeedback a = this.f6315b.m10644a(graphQLStory.mo2890l(), z);
        Builder a2 = Builder.a(graphQLStory);
        a2.D = a;
        a2 = a2;
        a2.F = a.m23255v();
        return m10579a(a2.a(), (FeedProps) feedProps);
    }

    public final FeedUnit m10617b(FeedProps<GraphQLStory> feedProps, boolean z) {
        Preconditions.checkNotNull(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a));
        GraphQLStoryAttachment a = AttachmentMutator.m10656a(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a), z ? GraphQLFriendshipStatus.OUTGOING_REQUEST : GraphQLFriendshipStatus.CAN_REQUEST);
        List M = ((GraphQLStory) feedProps.f13444a).m22327M();
        Builder a2 = Builder.a((GraphQLStory) feedProps.f13444a);
        a2.m = AttachmentListMutator.m10671a(M, a);
        a2 = a2;
        a2.F = this.f6322i.mo211a();
        return StoryProps.m27459f(m10579a(a2.a(), (FeedProps) feedProps));
    }

    @Inject
    public FeedStoryMutator(FeedbackMutator feedbackMutator, AttachmentMutator attachmentMutator, AttachmentListMutator attachmentListMutator, ActionLinkMutator actionLinkMutator, ActionLinkListMutator actionLinkListMutator, AttachmentTargetMutator attachmentTargetMutator, AbstractFbErrorReporter abstractFbErrorReporter, Clock clock, CallToActionResolver callToActionResolver, TravelStoryHelper travelStoryHelper) {
        this.f6315b = feedbackMutator;
        this.f6318e = attachmentMutator;
        this.f6319f = attachmentListMutator;
        this.f6316c = actionLinkMutator;
        this.f6317d = actionLinkListMutator;
        this.f6320g = attachmentTargetMutator;
        this.f6321h = abstractFbErrorReporter;
        this.f6322i = clock;
        this.f6323j = callToActionResolver;
        this.f6324k = travelStoryHelper;
    }

    private GraphQLStory m10582a(GraphQLStory graphQLStory, GraphQLStory graphQLStory2, GraphQLStory graphQLStory3) {
        Builder builder = null;
        if (graphQLStory3 == null) {
            return null;
        }
        if (graphQLStory == graphQLStory2) {
            return graphQLStory3;
        }
        if (graphQLStory3.m22326L() == graphQLStory2) {
            builder = Builder.a(graphQLStory3);
            builder.l = graphQLStory;
        } else if (!StoryHierarchyHelper.m27436c(graphQLStory3).m22608j().isEmpty()) {
            ImmutableList a = m10584a(StoryHierarchyHelper.m27436c(graphQLStory3).m22608j(), (CacheableEntity) graphQLStory, (CacheableEntity) graphQLStory2);
            if (a != StoryHierarchyHelper.m27436c(graphQLStory3).m22608j()) {
                builder = Builder.a(graphQLStory3);
                GraphQLSubstoriesConnection.Builder a2 = GraphQLSubstoriesConnection.Builder.a(StoryHierarchyHelper.m27434a(graphQLStory3));
                a2.e = a;
                builder.g = a2.a();
            }
        }
        if (builder == null) {
            this.f6321h.m2340a("CORRUPT_CACHED_FEED_STORY", "invalid parent pointer");
            return graphQLStory3;
        }
        builder.F = graphQLStory.T_();
        return builder.a();
    }

    private FeedProps<GraphQLStory> m10579a(GraphQLStory graphQLStory, FeedProps<GraphQLStory> feedProps) {
        GraphQLStorySet h = StoryProps.m27460h(feedProps);
        if (h == null) {
            return m10580a((GraphQLStory) feedProps.f13444a, graphQLStory, feedProps.m19808d());
        }
        ImmutableList a = m10584a(StorySetHelper.b(h), (CacheableEntity) graphQLStory, (GraphQLStory) feedProps.f13444a);
        GraphQLStorySetStoriesConnection.Builder a2 = GraphQLStorySetStoriesConnection.Builder.a(m10583a(h));
        a2.e = GraphQLHelper.m22469a(a);
        GraphQLStorySetStoriesConnection a3 = a2.a();
        GraphQLStorySet.Builder a4 = GraphQLStorySet.Builder.a(h);
        a4.e = a3;
        GraphQLStorySet.Builder builder = a4;
        builder.j = graphQLStory.T_();
        return FeedProps.m19802c(builder.a()).m19803a(graphQLStory);
    }

    private FeedProps<GraphQLStory> m10580a(GraphQLStory graphQLStory, GraphQLStory graphQLStory2, ImmutableList<Flattenable> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        GraphQLStory graphQLStory3 = graphQLStory2;
        while (i < immutableList.size() && (immutableList.get(i) instanceof GraphQLStory)) {
            GraphQLStory graphQLStory4 = (GraphQLStory) immutableList.get(i);
            graphQLStory3 = m10582a(graphQLStory3, graphQLStory, graphQLStory4);
            builder.m1069c(graphQLStory3);
            i++;
            graphQLStory = graphQLStory4;
        }
        while (i < immutableList.size()) {
            builder.m1069c(immutableList.get(i));
            i++;
        }
        PropertyHelper.m21281a((CachedFeedTrackable) graphQLStory2, null);
        return FeedProps.m19801a(graphQLStory2, builder.m1068b());
    }

    public final FeedProps<GraphQLStory> m10595a(FeedProps<GraphQLStory> feedProps, GraphQLActor graphQLActor, boolean z) {
        GraphQLFeedback a = this.f6315b.m10640a(((GraphQLStory) feedProps.f13444a).mo2890l(), graphQLActor, z);
        Builder a2 = Builder.a((GraphQLStory) feedProps.f13444a);
        a2.D = a;
        a2 = a2;
        a2.F = a.m23255v();
        return m10579a(a2.a(), (FeedProps) feedProps);
    }

    public final FeedProps<GraphQLStory> m10598a(FeedProps<GraphQLStory> feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        switch (1.a[PageStoryTypeResolver.m28081a((FeedProps) feedProps).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m10592d(feedProps, graphQLStoryActionLink);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m10591c(feedProps, graphQLStoryActionLink);
            case 3:
                return m10591c(StoryProps.m27455b(feedProps), graphQLStoryActionLink);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return (this.f6323j.m10679a(graphQLStory) && PageStoryTypeResolver.m28081a((FeedProps) feedProps) == PageStoryType.GROUPER) ? m10591c(feedProps, graphQLStoryActionLink) : m10587b((FeedProps) feedProps, graphQLStoryActionLink);
            case 5:
                GraphQLStoryActionLink a = PrimaryActionLinkResolver.m31292a(graphQLStory);
                if (a.m22901a() != null && -508788748 == a.m22901a().m22301g()) {
                    return m10587b((FeedProps) feedProps, graphQLStoryActionLink);
                }
            case 6:
                return m10592d(feedProps, graphQLStoryActionLink);
        }
        return null;
    }

    public final FeedProps<GraphQLStory> m10603a(GraphQLStory graphQLStory, GraphQLStory graphQLStory2) {
        Builder b = m10588b(graphQLStory2);
        b.o = graphQLStory.mo2507g();
        b = b;
        b.D = graphQLStory.mo2890l();
        b = b;
        b.x = graphQLStory.m22336V();
        GraphQLStory a = b.a();
        PropertyHelper.m21277a(a, false);
        return FeedProps.m19802c(a);
    }

    public final FeedProps<GraphQLStory> m10604a(GraphQLStory graphQLStory, GraphQLTextWithEntities graphQLTextWithEntities, boolean z) {
        GraphQLStory graphQLStory2 = GraphQLStoryMutator.a(m10588b(graphQLStory).a()).a(graphQLTextWithEntities).a;
        PropertyHelper.m21277a(graphQLStory2, z);
        return FeedProps.m19802c(graphQLStory2);
    }

    public final FeedProps<GraphQLStory> m10605a(GraphQLStory graphQLStory, ProductItemAttachment productItemAttachment, boolean z) {
        if (graphQLStory == null || productItemAttachment == null || !StoryAttachmentHelper.m28042o(graphQLStory).m23984w().contains(GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM)) {
            return FeedProps.m19802c(graphQLStory);
        }
        GraphQLNode z2 = StoryAttachmentHelper.m28042o(graphQLStory).m23987z();
        BaseModel ec = z2.ec();
        GraphQLCurrencyQuantity.Builder builder = new GraphQLCurrencyQuantity.Builder();
        ec.m9958h();
        builder.d = ec.m23878a();
        builder.e = ec.m23882j();
        builder.f = ec.m23883k();
        builder.g = ec.m23884l();
        builder.h = ec.m23885m();
        builder.i = ec.m23886n();
        BaseModel.Builder.m22419a(builder, ec);
        GraphQLCurrencyQuantity.Builder builder2 = builder;
        builder2.i = String.valueOf(productItemAttachment.price.longValue() * 100);
        GraphQLCurrencyQuantity a = builder2.a();
        GraphQLTextWithEntities a2 = GraphQLHelper.m22463a(productItemAttachment.description);
        GraphQLTextWithEntities a3 = GraphQLHelper.m22463a(productItemAttachment.pickupDeliveryInfo);
        GraphQLNode.Builder a4 = GraphQLNode.Builder.a(z2);
        a4.dr = a2;
        a4 = a4;
        a4.gh = a3;
        a4 = a4;
        a4.eC = a;
        z2 = a4.a();
        GraphQLStoryAttachment.Builder a5 = GraphQLStoryAttachment.Builder.a(StoryAttachmentHelper.m28042o(graphQLStory));
        a5.u = productItemAttachment.title;
        a5 = a5;
        a5.t = z2;
        GraphQLStoryAttachment a6 = a5.a();
        Builder b = m10588b(graphQLStory);
        b.m = AttachmentListMutator.m10671a(graphQLStory.m22367x(), a6);
        GraphQLStory a7 = b.g(StoryVisibility.VISIBLE.name()).a();
        PropertyHelper.m21277a(a7, z);
        return FeedProps.m19802c(a7);
    }

    public final GraphQLStory m10614a(GraphQLStory graphQLStory, boolean z) {
        GraphQLStoryAttachment a = StoryCommerceHelper.a(graphQLStory);
        if (a == null) {
            this.f6321h.mo336a(SoftError.b("null_GroupCommerceItemAttachment", "ProductItem is null on story after product availability change. t7270764."));
            return null;
        }
        boolean z2;
        GraphQLNode.Builder a2 = GraphQLNode.Builder.a(a.m23987z());
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        a2.et = z2;
        if (a2.f15736a != null && a2.f15736a.f15024d) {
            a2.f15736a.m21538a(a2.f15737b, 253, z2);
        }
        GraphQLNode a3 = a2.a();
        GraphQLStoryAttachment.Builder a4 = GraphQLStoryAttachment.Builder.a(a);
        a4.t = a3;
        a = a4.a();
        Builder a5 = Builder.a(graphQLStory);
        a5.m = AttachmentListMutator.m10671a(graphQLStory.m22327M(), a);
        Builder builder = a5;
        builder.F = this.f6322i.mo211a();
        return builder.a();
    }

    private Builder m10588b(GraphQLStory graphQLStory) {
        Builder a = Builder.a(graphQLStory);
        a.F = this.f6322i.mo211a();
        a = a;
        BaseModel k = GraphQLHelper.m22513k(graphQLStory);
        GraphQLEditHistoryConnection.Builder builder = new GraphQLEditHistoryConnection.Builder();
        k.m9958h();
        builder.d = k.m22578a();
        builder.e = k.m22582j();
        BaseModel.Builder.m22419a(builder, k);
        GraphQLEditHistoryConnection.Builder builder2 = builder;
        builder2.d = GraphQLHelper.m22513k(graphQLStory).m22578a() + 1;
        a.A = builder2.a();
        return a;
    }

    @VisibleForTesting
    public static int m10577a(int i, int i2) {
        return (i2 < 0 || i == 0) ? 0 : Math.min(i2, i - 1);
    }

    @VisibleForTesting
    public static ImmutableList<String> m10585a(ImmutableList<String> immutableList, String str) {
        if (immutableList == null) {
            return ImmutableList.of(str);
        }
        return !immutableList.contains(str) ? ImmutableList.builder().m1065b((Iterable) immutableList).m1069c(str).m1068b() : immutableList;
    }

    public final GraphQLPaginatedGroupsYouShouldJoinFeedUnit m10607a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit, String str) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = ScrollableItemListFeedUnitImpl.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) a.get(i);
            if (!(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.l() == null || Objects.equal(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.l().m23275I(), str))) {
                builder.m1069c(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge);
            }
        }
        ImmutableList b = builder.m1068b();
        GraphQLPaginatedGroupsYouShouldJoinFeedUnit.Builder a2 = GraphQLPaginatedGroupsYouShouldJoinFeedUnit.Builder.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.Builder a3 = GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.Builder.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25300o());
        a3.d = b;
        a2.d = a3.a();
        a2 = a2;
        a2.g = this.f6322i.mo211a();
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) FeedUnitMutator.a(a2.a()).b(m10585a(graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25306u().f20932c, str)).a();
        VisibleItemHelper.m26979a(scrollableItemListFeedUnit, m10577a(b.size(), graphQLPaginatedGroupsYouShouldJoinFeedUnit.ac_()));
        return scrollableItemListFeedUnit;
    }

    public final GraphQLPaginatedPeopleYouMayKnowFeedUnit m10608a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection, GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.m1065b(ItemListFeedUnitImpl.m30146a(graphQLPaginatedPeopleYouMayKnowFeedUnit));
        ImmutableList a = graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.m23876a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) a.get(i);
            if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m31478j()) {
                builder.m1069c(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge);
            }
        }
        GraphQLPaginatedPeopleYouMayKnowFeedUnit.Builder a2 = GraphQLPaginatedPeopleYouMayKnowFeedUnit.Builder.a(graphQLPaginatedPeopleYouMayKnowFeedUnit);
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.Builder a3 = GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.Builder.a(graphQLPaginatedPeopleYouMayKnowFeedUnit.m25696o());
        a3.d = builder.m1068b();
        a3 = a3;
        a3.e = graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.m23877j();
        a2.d = a3.a();
        a2 = a2;
        a2.g = this.f6322i.mo211a();
        FeedUnit feedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) FeedUnitMutator.a(a2.a()).b(graphQLPaginatedPeopleYouMayKnowFeedUnit.m25702u().f20932c).a();
        VisibleItemHelper.m26979a((ScrollableItemListFeedUnit) feedUnit, graphQLPaginatedPeopleYouMayKnowFeedUnit.ac_());
        PropertyHelper.m21267a(feedUnit, null);
        return feedUnit;
    }

    public final PeopleYouMayKnowFeedUnit m10616a(PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit, String str) {
        int i = 0;
        FeedUnit feedUnit = null;
        ImmutableList.Builder builder;
        ImmutableList a;
        int size;
        int i2;
        ImmutableList b;
        if (peopleYouMayKnowFeedUnit instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) peopleYouMayKnowFeedUnit;
            builder = ImmutableList.builder();
            a = ItemListFeedUnitImpl.m30146a(graphQLPaginatedPeopleYouMayKnowFeedUnit);
            size = a.size();
            for (i2 = 0; i2 < size; i2++) {
                GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) a.get(i2);
                if (!(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m31481m() == null || Objects.equal(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m31481m().m23909P(), str))) {
                    builder.m1069c(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge);
                }
            }
            b = builder.m1068b();
            i = b.size();
            GraphQLPaginatedPeopleYouMayKnowFeedUnit.Builder a2 = GraphQLPaginatedPeopleYouMayKnowFeedUnit.Builder.a(graphQLPaginatedPeopleYouMayKnowFeedUnit);
            GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.Builder a3 = GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.Builder.a(graphQLPaginatedPeopleYouMayKnowFeedUnit.m25696o());
            a3.d = b;
            a2.d = a3.a();
            GraphQLPaginatedPeopleYouMayKnowFeedUnit.Builder builder2 = a2;
            builder2.g = this.f6322i.mo211a();
            feedUnit = builder2.a();
        } else if (peopleYouMayKnowFeedUnit instanceof GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) {
            GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) peopleYouMayKnowFeedUnit;
            builder = new ImmutableList.Builder();
            a = ScrollableItemListFeedUnitImpl.a(graphQLQuickPromotionPeopleYouMayKnowFeedUnit);
            size = a.size();
            for (i2 = 0; i2 < size; i2++) {
                GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem = (GraphQLPeopleYouMayKnowFeedUnitItem) a.get(i2);
                if (IsValidUtil.m22961a(graphQLPeopleYouMayKnowFeedUnitItem) && !Objects.equal(graphQLPeopleYouMayKnowFeedUnitItem.l(), str)) {
                    builder.m1069c(graphQLPeopleYouMayKnowFeedUnitItem);
                }
            }
            b = builder.m1068b();
            i = b.size();
            GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.Builder builder3 = new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.Builder();
            graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m9958h();
            builder3.d = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.mo2507g();
            builder3.e = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.S_();
            builder3.f = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.T_();
            builder3.g = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25715l();
            builder3.h = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25717o();
            builder3.i = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25718p();
            builder3.j = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25719q();
            builder3.k = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25720r();
            builder3.l = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.mo2877k();
            BaseModel.Builder.m22419a(builder3, graphQLQuickPromotionPeopleYouMayKnowFeedUnit);
            builder3.m = (PropertyBag) graphQLQuickPromotionPeopleYouMayKnowFeedUnit.U_().clone();
            GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.Builder builder4 = builder3;
            builder4.h = b;
            builder4 = builder4;
            builder4.f = this.f6322i.mo211a();
            Object graphQLQuickPromotionPeopleYouMayKnowFeedUnit2 = new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit(builder4);
        }
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (PeopleYouMayKnowFeedUnit) FeedUnitMutator.a(feedUnit).b(m10585a(peopleYouMayKnowFeedUnit.mo2876j().f20932c, str)).a();
        VisibleItemHelper.m26979a(scrollableItemListFeedUnit, m10577a(i, peopleYouMayKnowFeedUnit.ac_()));
        return scrollableItemListFeedUnit;
    }

    private GraphQLStory m10589b(GraphQLStory graphQLStory, GraphQLSavedState graphQLSavedState) {
        Builder a = Builder.a(graphQLStory);
        if (graphQLStory.as() != null) {
            a.ai = StorySaveInfoMutator.a(graphQLStory.as(), graphQLSavedState);
        }
        if (!(graphQLStory.m22367x() == null || graphQLStory.m22367x().isEmpty())) {
            ImmutableList b;
            ImmutableList<GraphQLStoryAttachment> a2 = this.f6319f.m10673a(graphQLStory.m22367x(), graphQLSavedState);
            if (this.f6324k.m10686a(graphQLStory)) {
                AttachmentListMutator attachmentListMutator = this.f6319f;
                ImmutableList.Builder builder = ImmutableList.builder();
                for (GraphQLStoryAttachment graphQLStoryAttachment : a2) {
                    if (graphQLStoryAttachment.m23987z() != null) {
                        GraphQLStoryAttachment.Builder a3 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
                        a3.t = GraphQLNode.Builder.a(graphQLStoryAttachment.m23987z()).a(graphQLSavedState).a();
                        builder.m1069c(a3.a());
                    }
                }
                b = builder.m1068b();
            }
            a.m = b;
        }
        if (!(graphQLStory.m22339Y() == null || this.f6324k.m10686a(graphQLStory))) {
            a.B = GraphQLPlace.Builder.a(graphQLStory.m22339Y()).a(graphQLSavedState).a();
        }
        a.d = this.f6317d.m10668a(StoryActionLinkHelper.m28074a(graphQLStory), graphQLSavedState);
        if (!StoryHierarchyHelper.m27436c(graphQLStory).m22608j().isEmpty()) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            ImmutableList j = StoryHierarchyHelper.m27436c(graphQLStory).m22608j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                builder2.m1069c(m10589b((GraphQLStory) j.get(i), graphQLSavedState));
            }
            GraphQLSubstoriesConnection.Builder builder3 = StoryHierarchyHelper.m27434a(graphQLStory) == null ? new GraphQLSubstoriesConnection.Builder() : GraphQLSubstoriesConnection.Builder.a(StoryHierarchyHelper.m27434a(graphQLStory));
            builder3.e = builder2.m1068b();
            a.g = builder3.a();
        }
        if (graphQLStory.m22326L() != null) {
            a.l = m10589b(graphQLStory.m22326L(), graphQLSavedState);
        }
        a.F = this.f6322i.mo211a();
        return a.a();
    }

    public final GraphQLStory m10610a(GraphQLStory graphQLStory, GraphQLSavedState graphQLSavedState) {
        return graphQLStory.as() == null ? graphQLStory : m10589b(graphQLStory, graphQLSavedState);
    }

    public final GraphQLStory m10613a(GraphQLStory graphQLStory, String str, String str2, Action action) {
        if (graphQLStory.m22367x() == null || graphQLStory.m22367x().isEmpty()) {
            return graphQLStory;
        }
        for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.m22367x()) {
            if (str.equals(graphQLStoryAttachment.m23974m())) {
                break;
            }
        }
        GraphQLStoryAttachment graphQLStoryAttachment2 = null;
        GraphQLStoryAttachment graphQLStoryAttachment3 = graphQLStoryAttachment2;
        if (graphQLStoryAttachment3 == null) {
            return graphQLStory;
        }
        GraphQLNode a;
        GraphQLStoryAttachment.Builder a2 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment3);
        GraphQLNode z = graphQLStoryAttachment3.m23987z();
        AttachmentTargetMutator attachmentTargetMutator;
        if (action == Action.ADD) {
            attachmentTargetMutator = this.f6320g;
            a = AttachmentTargetMutator.m10675a(z, str2, true);
        } else {
            attachmentTargetMutator = this.f6320g;
            a = AttachmentTargetMutator.m10675a(z, str2, false);
        }
        a2.t = a;
        graphQLStoryAttachment3 = a2.a();
        Builder a3 = Builder.a(graphQLStory);
        a3.m = AttachmentListMutator.m10671a(graphQLStory.m22367x(), graphQLStoryAttachment3);
        Builder builder = a3;
        builder.F = this.f6322i.mo211a();
        return builder.a();
    }

    public final GraphQLPYMLWithLargeImageFeedUnit m10606a(GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection, GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (graphQLPYMLWithLargeImageFeedUnit.m25730B() != null) {
            builder.m1065b(graphQLPYMLWithLargeImageFeedUnit.m25730B().a());
        }
        if (graphQLStatelessLargeImagePLAsConnection.a() != null) {
            ImmutableList a = graphQLStatelessLargeImagePLAsConnection.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLStatelessLargeImagePLAsEdge graphQLStatelessLargeImagePLAsEdge = (GraphQLStatelessLargeImagePLAsEdge) a.get(i);
                if (graphQLStatelessLargeImagePLAsEdge.a() != null && IsValidUtil.m22951a(graphQLStatelessLargeImagePLAsEdge.a())) {
                    GraphQLPYMLWithLargeImageFeedUnitsEdge.Builder builder2 = new GraphQLPYMLWithLargeImageFeedUnitsEdge.Builder();
                    builder2.d = graphQLStatelessLargeImagePLAsEdge.a();
                    builder.m1069c(new GraphQLPYMLWithLargeImageFeedUnitsEdge(builder2));
                }
            }
        }
        GraphQLPYMLWithLargeImageFeedUnit.Builder builder3 = new GraphQLPYMLWithLargeImageFeedUnit.Builder();
        graphQLPYMLWithLargeImageFeedUnit.m9958h();
        builder3.d = graphQLPYMLWithLargeImageFeedUnit.mo2507g();
        builder3.e = graphQLPYMLWithLargeImageFeedUnit.S_();
        builder3.f = graphQLPYMLWithLargeImageFeedUnit.m25759y();
        builder3.g = graphQLPYMLWithLargeImageFeedUnit.T_();
        builder3.h = graphQLPYMLWithLargeImageFeedUnit.m25760z();
        builder3.i = graphQLPYMLWithLargeImageFeedUnit.m25734F();
        builder3.j = graphQLPYMLWithLargeImageFeedUnit.m25735G();
        builder3.k = graphQLPYMLWithLargeImageFeedUnit.m25736H();
        builder3.l = graphQLPYMLWithLargeImageFeedUnit.m25729A();
        builder3.m = graphQLPYMLWithLargeImageFeedUnit.m25730B();
        builder3.n = graphQLPYMLWithLargeImageFeedUnit.m25731C();
        builder3.o = graphQLPYMLWithLargeImageFeedUnit.m25732D();
        builder3.p = graphQLPYMLWithLargeImageFeedUnit.m25733E();
        builder3.q = graphQLPYMLWithLargeImageFeedUnit.mo2877k();
        BaseModel.Builder.m22419a(builder3, graphQLPYMLWithLargeImageFeedUnit);
        builder3.r = (PropertyBag) graphQLPYMLWithLargeImageFeedUnit.U_().clone();
        GraphQLPYMLWithLargeImageFeedUnit.Builder builder4 = builder3;
        GraphQLPYMLWithLargeImageFeedUnitsConnection.Builder builder5 = new GraphQLPYMLWithLargeImageFeedUnitsConnection.Builder();
        builder5.d = builder.m1068b();
        builder4.m = new GraphQLPYMLWithLargeImageFeedUnitsConnection(builder5);
        builder4 = builder4;
        builder4.g = this.f6322i.mo211a();
        GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit2 = new GraphQLPYMLWithLargeImageFeedUnit(builder4);
        PropertyHelper.m21267a((FeedUnit) graphQLPYMLWithLargeImageFeedUnit2, null);
        VisibleItemHelper.m26979a((ScrollableItemListFeedUnit) graphQLPYMLWithLargeImageFeedUnit2, graphQLPYMLWithLargeImageFeedUnit.ac_());
        ImpressionUtil.m29322a((Sponsorable) graphQLPYMLWithLargeImageFeedUnit2, ImpressionUtil.m29327d(graphQLPYMLWithLargeImageFeedUnit));
        return IsValidUtil.m22950a(graphQLPYMLWithLargeImageFeedUnit2) ? graphQLPYMLWithLargeImageFeedUnit2 : null;
    }

    public final GraphQLStory m10611a(GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        Preconditions.checkNotNull(graphQLStoryAttachment);
        Preconditions.checkNotNull(graphQLStory);
        ImmutableList a = AttachmentListMutator.m10671a(graphQLStory.m22327M(), AttachmentMutator.m10654a(graphQLStoryAttachment, graphQLEventGuestStatus));
        Builder a2 = Builder.a(graphQLStory);
        a2.m = a;
        Builder builder = a2;
        builder.F = this.f6322i.mo211a();
        return builder.a();
    }

    public final GraphQLStory m10612a(GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        Preconditions.checkNotNull(graphQLStoryAttachment);
        Preconditions.checkNotNull(graphQLStory);
        ImmutableList a = AttachmentListMutator.m10671a(graphQLStory.m22327M(), AttachmentMutator.m10655a(graphQLStoryAttachment, graphQLEventWatchStatus));
        Builder a2 = Builder.a(graphQLStory);
        a2.m = a;
        Builder builder = a2;
        builder.F = this.f6322i.mo211a();
        return builder.a();
    }

    public static GraphQLStory m10590b(GraphQLStory graphQLStory, boolean z) {
        GraphQLFeedback l = graphQLStory.mo2890l();
        if (l.y_() == z) {
            return graphQLStory;
        }
        GraphQLLikersOfContentConnection o = GraphQLHelper.m22520o(l);
        int a = (z ? 1 : -1) + o.mo2914a();
        if (a < 0) {
            a = 0;
        }
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection = GraphQLLikersOfContentConnectionMutator.a(o).a(a).a;
        GraphQLFeedback.Builder a2 = GraphQLFeedback.Builder.a(l);
        a2.C = graphQLLikersOfContentConnection;
        GraphQLFeedback a3 = a2.j(z).a();
        Builder a4 = Builder.a(graphQLStory);
        a4.D = a3;
        return a4.a();
    }

    public final GraphQLStory m10615a(GraphQLStory graphQLStory, boolean z, boolean z2, GraphQLTextWithEntities graphQLTextWithEntities) {
        GraphQLFeedback.Builder b = GraphQLFeedback.Builder.a(graphQLStory.mo2890l()).b(z);
        b.u = z2;
        if (b.f15736a != null && b.f15736a.f15024d) {
            b.f15736a.m21538a(b.f15737b, 18, z2);
        }
        b = b;
        b.m = graphQLTextWithEntities;
        GraphQLFeedback a = b.a();
        Builder a2 = Builder.a(graphQLStory);
        a2.D = a;
        if (StoryActionLinkHelper.m28072a(graphQLStory, -1103690310) != null) {
            GraphQLStoryActionLink a3 = StoryActionLinkHelper.m28072a(graphQLStory, -1103690310);
            Preconditions.checkArgument(a3 != null, "The action link is null");
            GraphQLStoryActionLink.Builder a4 = GraphQLStoryActionLink.Builder.a(a3);
            a4.y = a;
            a2.d = ActionLinkListMutator.m10666a(graphQLStory.m22319E(), a4.a());
        }
        a2.F = this.f6322i.mo211a();
        return a2.a();
    }

    public final GraphQLStory m10609a(GraphQLStory graphQLStory) {
        Builder a = Builder.a(graphQLStory);
        a.F = this.f6322i.mo211a();
        return a.a();
    }

    public static GraphQLStory m10581a(GraphQLStory graphQLStory, GraphQLFeedback graphQLFeedback) {
        if (graphQLStory == null) {
            return null;
        }
        Builder a = Builder.a(graphQLStory);
        a.D = graphQLFeedback;
        a = a;
        a.F = SystemClock.f762a.mo211a();
        return a.a();
    }

    public static GraphQLStorySetStoriesConnection m10583a(GraphQLStorySet graphQLStorySet) {
        if (graphQLStorySet == null || graphQLStorySet.m22788z() == null) {
            return new GraphQLStorySetStoriesConnection.Builder().a();
        }
        return graphQLStorySet.m22788z();
    }

    public static <Z extends CacheableEntity> ImmutableList<Z> m10584a(ImmutableList<Z> immutableList, Z z, Z z2) {
        if (immutableList == null) {
            return immutableList;
        }
        int size = immutableList.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            if (((CacheableEntity) immutableList.get(i)).mo2507g().equals(z2.mo2507g())) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            return immutableList;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Z z3 = (CacheableEntity) immutableList.get(i2);
            if (z3 != z2) {
                builder.m1069c(z3);
            } else {
                builder.m1069c(z);
            }
        }
        return builder.m1068b();
    }
}
