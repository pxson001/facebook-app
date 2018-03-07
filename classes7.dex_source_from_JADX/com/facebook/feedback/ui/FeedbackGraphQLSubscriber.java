package com.facebook.feedback.ui;

import com.facebook.api.graphql.commentservice.CommentsService.CommentCreateSubscriptionString;
import com.facebook.api.graphql.commentservice.CommentsService.FriendsTypingSubscriptionString;
import com.facebook.api.graphql.commentservice.CommentsService.PublicContentCommentCreateSubscriptionString;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.FriendsTypingSubscriptionModel;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.graphql.calls.CommentCreateSubscribeInputData;
import com.facebook.graphql.calls.FeedbackSubscribeInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PublicContentCommentCreateSubscribeInputData;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ufiservices.event.CommentEvents.GraphQLSubscriptionAddCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.GraphQLSubscriptionAddPublicContentCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.GraphQLSubscriptionFriendsTypingEvent;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: savedHasPrivacyChanged */
public class FeedbackGraphQLSubscriber implements Bindable<GraphQLFeedback> {
    public final GraphQLSubscriptionConnector f4519a;
    public final EventsStream f4520b;
    public final Executor f4521c;
    public final FeedbackAnalyticsLogger f4522d;
    public final Map<String, GraphQLSubscriptionHandle> f4523e = new HashMap();
    public final Map<String, GraphQLSubscriptionHandle> f4524f = new HashMap();
    public final Map<String, GraphQLSubscriptionHandle> f4525g = new HashMap();
    public final FutureCallback<CommentCreateMutationFragmentModel> f4526h;
    public final FutureCallback<CommentCreateMutationFragmentModel> f4527i;
    public final FutureCallback<FriendsTypingSubscriptionModel> f4528j;
    public final QeAccessor f4529k;

    /* compiled from: savedHasPrivacyChanged */
    public class C04211 implements Function<String, TypedGraphQLSubscriptionString<CommentCreateMutationFragmentModel>> {
        final /* synthetic */ FeedbackGraphQLSubscriber f4507a;

        public C04211(FeedbackGraphQLSubscriber feedbackGraphQLSubscriber) {
            this.f4507a = feedbackGraphQLSubscriber;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            String str = (String) obj;
            FeedbackGraphQLSubscriber feedbackGraphQLSubscriber = this.f4507a;
            CommentCreateSubscribeInputData commentCreateSubscribeInputData = new CommentCreateSubscribeInputData();
            commentCreateSubscribeInputData.a("feedback_id", str);
            GraphQlCallInput graphQlCallInput = commentCreateSubscribeInputData;
            GraphQlQueryString commentCreateSubscriptionString = new CommentCreateSubscriptionString();
            commentCreateSubscriptionString.a("input", graphQlCallInput);
            commentCreateSubscriptionString.a("include_replies_in_total_count", Boolean.toString(feedbackGraphQLSubscriber.f4529k.a(ExperimentsForUfiServiceQeModule.l, false)));
            return commentCreateSubscriptionString;
        }
    }

    /* compiled from: savedHasPrivacyChanged */
    public class C04222 implements Function<String, TypedGraphQLSubscriptionString<CommentCreateMutationFragmentModel>> {
        final /* synthetic */ FeedbackGraphQLSubscriber f4508a;

        public C04222(FeedbackGraphQLSubscriber feedbackGraphQLSubscriber) {
            this.f4508a = feedbackGraphQLSubscriber;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            String str = (String) obj;
            FeedbackGraphQLSubscriber feedbackGraphQLSubscriber = this.f4508a;
            PublicContentCommentCreateSubscribeInputData publicContentCommentCreateSubscribeInputData = new PublicContentCommentCreateSubscribeInputData();
            publicContentCommentCreateSubscribeInputData.a("feedback_id", str);
            GraphQlCallInput graphQlCallInput = publicContentCommentCreateSubscribeInputData;
            GraphQlQueryString publicContentCommentCreateSubscriptionString = new PublicContentCommentCreateSubscriptionString();
            publicContentCommentCreateSubscriptionString.a("input", graphQlCallInput);
            publicContentCommentCreateSubscriptionString.a("include_replies_in_total_count", Boolean.toString(feedbackGraphQLSubscriber.f4529k.a(ExperimentsForUfiServiceQeModule.l, false)));
            return publicContentCommentCreateSubscriptionString;
        }
    }

    /* compiled from: savedHasPrivacyChanged */
    public class C04233 implements Function<String, TypedGraphQLSubscriptionString<FriendsTypingSubscriptionModel>> {
        final /* synthetic */ FeedbackGraphQLSubscriber f4509a;

        public C04233(FeedbackGraphQLSubscriber feedbackGraphQLSubscriber) {
            this.f4509a = feedbackGraphQLSubscriber;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            String str = (String) obj;
            FeedbackGraphQLSubscriber feedbackGraphQLSubscriber = this.f4509a;
            FeedbackSubscribeInputData a = new FeedbackSubscribeInputData().a(str);
            FriendsTypingSubscriptionString friendsTypingSubscriptionString = new FriendsTypingSubscriptionString();
            friendsTypingSubscriptionString.a("input", a);
            return friendsTypingSubscriptionString;
        }
    }

    /* compiled from: savedHasPrivacyChanged */
    public class C04254 implements FutureCallback<CommentCreateMutationFragmentModel> {
        final /* synthetic */ FeedbackGraphQLSubscriber f4512a;

        public C04254(FeedbackGraphQLSubscriber feedbackGraphQLSubscriber) {
            this.f4512a = feedbackGraphQLSubscriber;
        }

        public void onSuccess(Object obj) {
            final CommentCreateMutationFragmentModel commentCreateMutationFragmentModel = (CommentCreateMutationFragmentModel) obj;
            ExecutorDetour.a(this.f4512a.f4521c, new Runnable(this) {
                final /* synthetic */ C04254 f4511b;

                public void run() {
                    if (commentCreateMutationFragmentModel != null && commentCreateMutationFragmentModel.j() != null) {
                        String j = commentCreateMutationFragmentModel.j().j();
                        if (this.f4511b.f4512a.f4523e.containsKey(j)) {
                            this.f4511b.f4512a.f4520b.a(new GraphQLSubscriptionAddCommentEvent(commentCreateMutationFragmentModel.a(), j));
                            this.f4511b.f4512a.f4522d.a();
                        }
                    }
                }
            }, 160034097);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: savedHasPrivacyChanged */
    public class C04275 implements FutureCallback<CommentCreateMutationFragmentModel> {
        final /* synthetic */ FeedbackGraphQLSubscriber f4515a;

        public C04275(FeedbackGraphQLSubscriber feedbackGraphQLSubscriber) {
            this.f4515a = feedbackGraphQLSubscriber;
        }

        public void onSuccess(Object obj) {
            final CommentCreateMutationFragmentModel commentCreateMutationFragmentModel = (CommentCreateMutationFragmentModel) obj;
            ExecutorDetour.a(this.f4515a.f4521c, new Runnable(this) {
                final /* synthetic */ C04275 f4514b;

                public void run() {
                    if (commentCreateMutationFragmentModel != null && commentCreateMutationFragmentModel.j() != null) {
                        String j = commentCreateMutationFragmentModel.j().j();
                        if (this.f4514b.f4515a.f4525g.containsKey(j)) {
                            this.f4514b.f4515a.f4520b.a(new GraphQLSubscriptionAddPublicContentCommentEvent(commentCreateMutationFragmentModel.a(), j));
                            this.f4514b.f4515a.f4522d.a();
                        }
                    }
                }
            }, -844485009);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: savedHasPrivacyChanged */
    public class C04296 implements FutureCallback<FriendsTypingSubscriptionModel> {
        final /* synthetic */ FeedbackGraphQLSubscriber f4518a;

        public C04296(FeedbackGraphQLSubscriber feedbackGraphQLSubscriber) {
            this.f4518a = feedbackGraphQLSubscriber;
        }

        public void onSuccess(Object obj) {
            final FriendsTypingSubscriptionModel friendsTypingSubscriptionModel = (FriendsTypingSubscriptionModel) obj;
            ExecutorDetour.a(this.f4518a.f4521c, new Runnable(this) {
                final /* synthetic */ C04296 f4517b;

                public void run() {
                    int i = 0;
                    if (friendsTypingSubscriptionModel != null && friendsTypingSubscriptionModel.a() != null && friendsTypingSubscriptionModel.a().a() != null) {
                        String j = friendsTypingSubscriptionModel.a().j();
                        if (this.f4517b.f4518a.f4524f.containsKey(j)) {
                            if (this.f4517b.f4518a.f4529k.a(ExperimentsForFeedbackTestModule.X, false)) {
                                i = friendsTypingSubscriptionModel.a().a().a();
                            } else if (this.f4517b.f4518a.f4529k.a(ExperimentsForFeedbackTestModule.Y, false)) {
                                i = friendsTypingSubscriptionModel.a().a().j();
                            }
                            this.f4517b.f4518a.f4520b.a(new GraphQLSubscriptionFriendsTypingEvent(j, i));
                        }
                    }
                }
            }, 300082117);
        }

        public void onFailure(Throwable th) {
        }
    }

    public static FeedbackGraphQLSubscriber m5080a(InjectorLike injectorLike) {
        return new FeedbackGraphQLSubscriber(GraphQLSubscriptionConnector.a(injectorLike), EventsStream.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FeedbackAnalyticsLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedbackGraphQLSubscriber(GraphQLSubscriptionConnector graphQLSubscriptionConnector, EventsStream eventsStream, Executor executor, FeedbackAnalyticsLogger feedbackAnalyticsLogger, QeAccessor qeAccessor) {
        this.f4519a = graphQLSubscriptionConnector;
        this.f4520b = eventsStream;
        this.f4521c = executor;
        this.f4522d = feedbackAnalyticsLogger;
        this.f4529k = qeAccessor;
        this.f4526h = new C04254(this);
        this.f4527i = new C04275(this);
        this.f4528j = new C04296(this);
    }

    public final void m5084a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback != null) {
            CharSequence z_ = graphQLFeedback.z_();
            if (!StringUtil.a(z_)) {
                ImmutableSet of = ImmutableSet.of(z_);
                if (this.f4529k.a(ExperimentsForFeedbackTestModule.t, false)) {
                    m5081a(this.f4519a, of, new C04211(this), this.f4526h, this.f4523e);
                }
                if (this.f4529k.a(ExperimentsForFeedbackTestModule.R, false)) {
                    m5081a(this.f4519a, of, new C04222(this), this.f4527i, this.f4525g);
                }
                if (this.f4529k.a(ExperimentsForFeedbackTestModule.Y, false) || this.f4529k.a(ExperimentsForFeedbackTestModule.X, false)) {
                    m5081a(this.f4519a, of, new C04233(this), this.f4528j, this.f4524f);
                }
            }
        }
    }

    public final void m5083a() {
        m5082a(this.f4523e);
        m5082a(this.f4525g);
        m5082a(this.f4524f);
    }

    private void m5082a(Map<String, GraphQLSubscriptionHandle> map) {
        Set hashSet = new HashSet(map.size());
        hashSet.addAll(map.values());
        map.clear();
        this.f4519a.a(hashSet);
    }

    public static <T extends GraphQLVisitableModel> void m5081a(GraphQLSubscriptionConnector graphQLSubscriptionConnector, Set<String> set, Function<String, TypedGraphQLSubscriptionString<T>> function, FutureCallback<T> futureCallback, Map<String, GraphQLSubscriptionHandle> map) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        for (String str : set) {
            if (!(StringUtil.a(str) || map.containsKey(str))) {
                TypedGraphQLSubscriptionString typedGraphQLSubscriptionString = (TypedGraphQLSubscriptionString) function.apply(str);
                hashMap.put(str, typedGraphQLSubscriptionString);
                hashMap2.put(typedGraphQLSubscriptionString, futureCallback);
            }
        }
        if (!hashMap2.isEmpty()) {
            Map a = graphQLSubscriptionConnector.a(hashMap2);
            for (Entry entry : hashMap.entrySet()) {
                GraphQLSubscriptionResult graphQLSubscriptionResult = (GraphQLSubscriptionResult) a.get(entry.getValue());
                if (graphQLSubscriptionResult.a != null) {
                    map.put(entry.getKey(), graphQLSubscriptionResult.a);
                }
            }
        }
    }
}
