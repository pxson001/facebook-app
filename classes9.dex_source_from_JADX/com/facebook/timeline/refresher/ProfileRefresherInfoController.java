package com.facebook.timeline.refresher;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.timeline.event.HeaderDataEvents.AdapterDataChangedEventSubscriber;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.inforeview.TimelineInfoReviewData;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.TimelineInfoReviewQueryModel;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: unsupported/unknown media type returned from gallery */
public class ProfileRefresherInfoController {
    public final ProfileRefresherInfoFragment f994a;
    public final GraphQLQueryExecutor f995b;
    public final Executor f996c;
    public final TimelineHeaderEventBus f997d;
    public TimelineInfoReviewData f998e = new TimelineInfoReviewData();
    public FbEventSubscriberListManager f999f = new FbEventSubscriberListManager();

    /* compiled from: unsupported/unknown media type returned from gallery */
    public class C01011 extends AdapterDataChangedEventSubscriber {
        final /* synthetic */ ProfileRefresherInfoController f992a;

        public C01011(ProfileRefresherInfoController profileRefresherInfoController) {
            this.f992a = profileRefresherInfoController;
        }

        public final void m1014b(FbEvent fbEvent) {
            this.f992a.m1015d();
        }
    }

    /* compiled from: unsupported/unknown media type returned from gallery */
    public class C01022 implements FutureCallback<GraphQLResult<TimelineInfoReviewQueryModel>> {
        final /* synthetic */ ProfileRefresherInfoController f993a;

        public C01022(ProfileRefresherInfoController profileRefresherInfoController) {
            this.f993a = profileRefresherInfoController;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ProfileRefresherInfoController profileRefresherInfoController = this.f993a;
            profileRefresherInfoController.f998e.m921a(((TimelineInfoReviewQueryModel) graphQLResult.e).a(), 2);
            profileRefresherInfoController.m1015d();
        }

        public void onFailure(Throwable th) {
        }
    }

    @Inject
    public ProfileRefresherInfoController(@Assisted ProfileRefresherInfoFragment profileRefresherInfoFragment, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, TimelineHeaderEventBus timelineHeaderEventBus) {
        this.f994a = profileRefresherInfoFragment;
        this.f995b = graphQLQueryExecutor;
        this.f996c = executor;
        this.f997d = timelineHeaderEventBus;
    }

    public final void m1015d() {
        this.f994a.m1022a(this.f998e);
    }
}
