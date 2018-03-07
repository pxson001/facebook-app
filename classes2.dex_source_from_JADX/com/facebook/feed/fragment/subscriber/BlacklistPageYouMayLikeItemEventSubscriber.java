package com.facebook.feed.fragment.subscriber;

import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEvent;
import com.facebook.feed.util.event.PagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEventSubscriber;
import com.facebook.feed.util.event.StoryEvents$FeedUnitMutatedEvent;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.PropertyBag;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.modelutil.BaseModel;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: observer can not be null */
public class BlacklistPageYouMayLikeItemEventSubscriber extends PagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEventSubscriber {
    private NewsFeedFragment f11625a;
    private FeedStoryMutator f11626b;
    private FeedEventBus f11627c;

    public final void mo650b(FbEvent fbEvent) {
        PagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEvent pagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEvent = (PagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEvent) fbEvent;
        for (GraphQLFeedUnitEdge c : this.f11625a.ax().m9669a(pagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEvent.f11655a)) {
            GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) c.mo2540c();
            FeedStoryMutator feedStoryMutator = this.f11626b;
            String str = pagesYouMayLikeEvents$BlacklistPageYouMayLikeItemEvent.f11656b;
            int ac_ = graphQLPagesYouMayLikeFeedUnit.ac_();
            Builder builder = ImmutableList.builder();
            ImmutableList t = graphQLPagesYouMayLikeFeedUnit.m22832t();
            int i = ac_;
            ac_ = 0;
            while (ac_ < t.size()) {
                GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem = (GraphQLPagesYouMayLikeFeedUnitItem) t.get(ac_);
                if (graphQLPagesYouMayLikeFeedUnitItem.u() == null || !Objects.equal(graphQLPagesYouMayLikeFeedUnitItem.u().ae(), str)) {
                    builder.m1069c(graphQLPagesYouMayLikeFeedUnitItem);
                } else if (ac_ >= 0 && ac_ < i) {
                    i--;
                }
                ac_++;
            }
            GraphQLPagesYouMayLikeFeedUnit.Builder builder2 = new GraphQLPagesYouMayLikeFeedUnit.Builder();
            graphQLPagesYouMayLikeFeedUnit.m9958h();
            builder2.d = graphQLPagesYouMayLikeFeedUnit.mo2507g();
            builder2.e = graphQLPagesYouMayLikeFeedUnit.S_();
            builder2.f = graphQLPagesYouMayLikeFeedUnit.T_();
            builder2.g = graphQLPagesYouMayLikeFeedUnit.m22831s();
            builder2.h = graphQLPagesYouMayLikeFeedUnit.m22812B();
            builder2.i = graphQLPagesYouMayLikeFeedUnit.m22813C();
            builder2.j = graphQLPagesYouMayLikeFeedUnit.m22814D();
            builder2.k = graphQLPagesYouMayLikeFeedUnit.m22832t();
            builder2.l = graphQLPagesYouMayLikeFeedUnit.m22836x();
            builder2.m = graphQLPagesYouMayLikeFeedUnit.m22837y();
            builder2.n = graphQLPagesYouMayLikeFeedUnit.m22838z();
            builder2.o = graphQLPagesYouMayLikeFeedUnit.m22811A();
            builder2.p = graphQLPagesYouMayLikeFeedUnit.mo2877k();
            BaseModel.Builder.m22419a(builder2, graphQLPagesYouMayLikeFeedUnit);
            builder2.q = (PropertyBag) graphQLPagesYouMayLikeFeedUnit.U_().clone();
            GraphQLPagesYouMayLikeFeedUnit.Builder builder3 = builder2;
            builder3.k = builder.m1068b();
            builder3 = builder3;
            builder3.f = feedStoryMutator.f6322i.mo211a();
            GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit2 = new GraphQLPagesYouMayLikeFeedUnit(builder3);
            VisibleItemHelper.m26979a((ScrollableItemListFeedUnit) graphQLPagesYouMayLikeFeedUnit2, i);
            ImpressionUtil.m29322a((Sponsorable) graphQLPagesYouMayLikeFeedUnit2, ImpressionUtil.m29327d(graphQLPagesYouMayLikeFeedUnit));
            if (!IsValidUtil.m22955a(graphQLPagesYouMayLikeFeedUnit2)) {
                graphQLPagesYouMayLikeFeedUnit2 = null;
            }
            this.f11627c.mo651a(new StoryEvents$FeedUnitMutatedEvent(graphQLPagesYouMayLikeFeedUnit2));
        }
    }

    public BlacklistPageYouMayLikeItemEventSubscriber(NewsFeedFragment newsFeedFragment, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator) {
        this.f11625a = newsFeedFragment;
        this.f11627c = feedEventBus;
        this.f11626b = feedStoryMutator;
    }
}
