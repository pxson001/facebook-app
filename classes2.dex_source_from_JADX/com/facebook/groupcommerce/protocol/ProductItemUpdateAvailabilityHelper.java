package com.facebook.groupcommerce.protocol;

import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;
import com.facebook.feed.util.event.StoryEvents$FeedUnitMutatedEvent;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ProductItemChangeAvailabilityInputData;
import com.facebook.graphql.calls.ProductItemChangeAvailabilityInputData.ProductAvailability;
import com.facebook.graphql.calls.ProductItemChangeAvailabilityInputData.Surface;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutations.ProductItemChangeAvailabilityCoreMutationString;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsModels.ProductItemChangeAvailabilityCoreMutationFieldsModel.StoryModel.AttachmentsModel.TargetModel.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: newCount */
public class ProductItemUpdateAvailabilityHelper {
    private static final Class<ProductItemUpdateAvailabilityHelper> f12374a = ProductItemUpdateAvailabilityHelper.class;
    private final GraphQLQueryExecutor f12375b;
    public final FeedbackGraphQLGenerator f12376c;
    public final FeedUnitCache f12377d;
    public final FeedEventBus f12378e;
    public final FeedStoryMutator f12379f;
    private final TasksManager f12380g;
    public final ControllerMutationGatekeepers f12381h;

    public static ProductItemUpdateAvailabilityHelper m18445b(InjectorLike injectorLike) {
        return new ProductItemUpdateAvailabilityHelper(GraphQLQueryExecutor.m10435a(injectorLike), FeedbackGraphQLGenerator.m14563a(injectorLike), FeedUnitCache.m10541a(injectorLike), FeedEventBus.m4573a(injectorLike), FeedStoryMutator.m10586b(injectorLike), TasksManager.m14550b(injectorLike), ControllerMutationGatekeepers.m18449b(injectorLike));
    }

    public static ProductItemUpdateAvailabilityHelper m18443a(InjectorLike injectorLike) {
        return m18445b(injectorLike);
    }

    @Inject
    public ProductItemUpdateAvailabilityHelper(GraphQLQueryExecutor graphQLQueryExecutor, FeedbackGraphQLGenerator feedbackGraphQLGenerator, FeedUnitCache feedUnitCache, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, TasksManager tasksManager, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f12375b = graphQLQueryExecutor;
        this.f12376c = feedbackGraphQLGenerator;
        this.f12377d = feedUnitCache;
        this.f12378e = feedEventBus;
        this.f12379f = feedStoryMutator;
        this.f12380g = tasksManager;
        this.f12381h = controllerMutationGatekeepers;
    }

    public final ListenableFuture<GraphQLResult> m18446a(GraphQLStory graphQLStory, ToggleAvailabilitySurface toggleAvailabilitySurface) {
        boolean a = m18444a(graphQLStory);
        String c = graphQLStory.m22350c();
        Enum enumR = a ? ProductAvailability.IN_STOCK : ProductAvailability.OUT_OF_STOCK;
        ProductItemChangeAvailabilityInputData productItemChangeAvailabilityInputData = new ProductItemChangeAvailabilityInputData();
        productItemChangeAvailabilityInputData.m11397a("story_id", c);
        GraphQlCallInput graphQlCallInput = productItemChangeAvailabilityInputData;
        graphQlCallInput.m11395a("product_availability", enumR);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.m11395a("surface", m18442a(toggleAvailabilitySurface));
        graphQlCallInput2 = graphQlCallInput2;
        TypedGraphQLMutationString productItemChangeAvailabilityCoreMutationString = new ProductItemChangeAvailabilityCoreMutationString();
        productItemChangeAvailabilityCoreMutationString.m11310a("input", graphQlCallInput2);
        MutationRequest a2 = GraphQLRequest.m11588a(productItemChangeAvailabilityCoreMutationString);
        if (this.f12381h.m18450a()) {
            GraphQLStoryAttachment a3 = StoryCommerceHelper.a(graphQLStory);
            if (!(a3 == null || a3.m23987z() == null)) {
                Builder builder = new Builder();
                builder.b = a3.m23987z().dp();
                Builder builder2 = builder;
                if (a) {
                    a = false;
                } else {
                    a = true;
                }
                builder2.c = a;
                a2.a(builder2.a());
            }
        }
        return this.f12375b.m10448a(a2);
    }

    public final void m18447a(FeedProps<GraphQLStory> feedProps, ToggleAvailabilitySurface toggleAvailabilitySurface) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        boolean a = m18444a(graphQLStory);
        if (this.f12381h.m18451b()) {
            Flattenable a2 = this.f12379f.m10614a((GraphQLStory) feedProps.f13444a, a);
            if (a2 != null) {
                GraphQLStorySet h = StoryProps.m27460h(feedProps.m19805b(a2));
                if (h == null) {
                    Flattenable flattenable = a2;
                }
                this.f12378e.mo651a(new StoryEvents$FeedUnitMutatedEvent(h));
            }
        }
        this.f12380g.m14553a("toggle_availability" + graphQLStory.m22350c(), m18446a(graphQLStory, toggleAvailabilitySurface), new 1(this, graphQLStory, a));
    }

    private static boolean m18444a(GraphQLStory graphQLStory) {
        return !StoryCommerceHelper.d(graphQLStory);
    }

    public static Surface m18442a(ToggleAvailabilitySurface toggleAvailabilitySurface) {
        switch (2.a[toggleAvailabilitySurface.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Surface.YOUR_POSTS;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return Surface.GROUP_POST_CHEVRON;
            case 3:
                return Surface.FEED_POST_CHEVRON;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return Surface.DELETE_INTERCEPT;
            case 5:
                return Surface.FEED_STORY;
            default:
                throw new IllegalArgumentException("Unrecognized surface: " + toggleAvailabilitySurface);
        }
    }
}
