package com.facebook.feed.fragment.subscriber;

import android.os.Bundle;
import com.facebook.api.feedcache.memory.XOutPlaceReviewItemParams;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$FeedUnitMutatedEvent;
import com.facebook.feedplugins.reviews.events.PlaceReviewEvents$XOutEvent;
import com.facebook.feedplugins.reviews.events.PlaceReviewEvents$XOutEventSubscriber;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit.Builder;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnitItem;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.PropertyBag;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: object should implement Flattenable to save persistent states. */
public class XOutPlaceReviewItemEventSubscriber extends PlaceReviewEvents$XOutEventSubscriber {
    public final DefaultBlueServiceOperationFactory f11628a;
    private final FeedEventBus f11629b;
    private final FeedStoryMutator f11630c;
    private final TasksManager f11631d;
    private final NewsFeedFragment f11632e;

    public final void mo650b(FbEvent fbEvent) {
        PlaceReviewEvents$XOutEvent placeReviewEvents$XOutEvent = (PlaceReviewEvents$XOutEvent) fbEvent;
        for (GraphQLFeedUnitEdge c : this.f11632e.ax().m9669a(placeReviewEvents$XOutEvent.f11657a)) {
            FeedUnit c2 = c.mo2540c();
            if (c2 instanceof GraphQLPlaceReviewFeedUnit) {
                FeedStoryMutator feedStoryMutator = this.f11630c;
                GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) c2;
                String str = placeReviewEvents$XOutEvent.f11658b;
                Builder builder = new Builder();
                graphQLPlaceReviewFeedUnit.m9958h();
                builder.d = graphQLPlaceReviewFeedUnit.mo2507g();
                builder.e = graphQLPlaceReviewFeedUnit.S_();
                builder.f = graphQLPlaceReviewFeedUnit.T_();
                builder.g = graphQLPlaceReviewFeedUnit.m25913l();
                builder.h = graphQLPlaceReviewFeedUnit.m25915o();
                builder.i = graphQLPlaceReviewFeedUnit.m25916p();
                builder.j = graphQLPlaceReviewFeedUnit.mo2877k();
                BaseModel.Builder.m22419a(builder, graphQLPlaceReviewFeedUnit);
                builder.k = (PropertyBag) graphQLPlaceReviewFeedUnit.U_().clone();
                Builder builder2 = builder;
                ImmutableList a = ItemListFeedUnitImpl.m30150a(graphQLPlaceReviewFeedUnit);
                ImmutableList.Builder builder3 = ImmutableList.builder();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem = (GraphQLPlaceReviewFeedUnitItem) a.get(i);
                    if (graphQLPlaceReviewFeedUnitItem.l() != null && (str == null || !str.equals(graphQLPlaceReviewFeedUnitItem.l().ae()))) {
                        builder3.m1069c(graphQLPlaceReviewFeedUnitItem);
                    }
                }
                builder2.g = builder3.m1068b();
                builder2 = builder2;
                builder2.f = feedStoryMutator.f6322i.mo211a();
                graphQLPlaceReviewFeedUnit = new GraphQLPlaceReviewFeedUnit(builder2);
                this.f11629b.mo651a(new StoryEvents$FeedUnitMutatedEvent(graphQLPlaceReviewFeedUnit));
                XOutPlaceReviewItemParams xOutPlaceReviewItemParams = new XOutPlaceReviewItemParams(placeReviewEvents$XOutEvent.f11657a, graphQLPlaceReviewFeedUnit);
                Bundle bundle = new Bundle();
                bundle.putParcelable("xOutPlaceReviewItemParamKey", xOutPlaceReviewItemParams);
                this.f11631d.m14556a("task_key_x_out_place_review_item" + placeReviewEvents$XOutEvent.f11657a + placeReviewEvents$XOutEvent.f11658b, m16940a(bundle), new 1(this));
            }
        }
    }

    @Inject
    public XOutPlaceReviewItemEventSubscriber(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, TasksManager tasksManager, @Assisted NewsFeedFragment newsFeedFragment) {
        this.f11628a = defaultBlueServiceOperationFactory;
        this.f11629b = feedEventBus;
        this.f11630c = feedStoryMutator;
        this.f11631d = tasksManager;
        this.f11632e = newsFeedFragment;
    }

    private Callable<ListenableFuture<OperationResult>> m16940a(Bundle bundle) {
        return new 2(this, bundle);
    }
}
