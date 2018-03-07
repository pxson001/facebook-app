package com.facebook.feedcontrollers.mutators;

import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutations.FeedbackSubscribeMutationString;
import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutations.FeedbackUnsubscribeMutationString;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.data.FeedbackSubscriptionMutator;
import com.facebook.graphql.calls.FeedbackSubscribeInputData;
import com.facebook.graphql.calls.FeedbackUnsubscribeInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEvent;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEventSubscriber;
import javax.inject.Inject;

/* compiled from: group_admin_type */
public class FeedbackNotificationSubscriber {
    public final FeedEventBus f11984a;
    public final FeedbackSubscriptionMutator f11985b;
    public final Subscriber f11986c = new Subscriber(this);

    /* compiled from: group_admin_type */
    class Subscriber extends SetNotifyMeEventSubscriber {
        final /* synthetic */ FeedbackNotificationSubscriber f11983a;

        public Subscriber(FeedbackNotificationSubscriber feedbackNotificationSubscriber) {
            this.f11983a = feedbackNotificationSubscriber;
        }

        public final void m14065b(FbEvent fbEvent) {
            SetNotifyMeEvent setNotifyMeEvent = (SetNotifyMeEvent) fbEvent;
            String str = setNotifyMeEvent.d;
            if (setNotifyMeEvent.h) {
                FeedbackSubscriptionMutator feedbackSubscriptionMutator = this.f11983a.f11985b;
                FeedbackSubscribeInputData a = new FeedbackSubscribeInputData().a(str);
                GraphQlQueryString feedbackSubscribeMutationString = new FeedbackSubscribeMutationString();
                feedbackSubscribeMutationString.a("input", a);
                feedbackSubscriptionMutator.f11928a.a(GraphQLRequest.a(feedbackSubscribeMutationString));
                return;
            }
            feedbackSubscriptionMutator = this.f11983a.f11985b;
            FeedbackUnsubscribeInputData feedbackUnsubscribeInputData = new FeedbackUnsubscribeInputData();
            feedbackUnsubscribeInputData.a("feedback_id", str);
            GraphQlCallInput graphQlCallInput = feedbackUnsubscribeInputData;
            feedbackSubscribeMutationString = new FeedbackUnsubscribeMutationString();
            feedbackSubscribeMutationString.a("input", graphQlCallInput);
            feedbackSubscriptionMutator.f11928a.a(GraphQLRequest.a(feedbackSubscribeMutationString));
        }
    }

    public static FeedbackNotificationSubscriber m14066a(InjectorLike injectorLike) {
        return new FeedbackNotificationSubscriber(FeedEventBus.a(injectorLike), new FeedbackSubscriptionMutator(GraphQLQueryExecutor.a(injectorLike)));
    }

    @Inject
    public FeedbackNotificationSubscriber(FeedEventBus feedEventBus, FeedbackSubscriptionMutator feedbackSubscriptionMutator) {
        this.f11984a = feedEventBus;
        this.f11985b = feedbackSubscriptionMutator;
    }
}
