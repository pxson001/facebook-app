package com.facebook.feed.data.followup;

import android.os.Bundle;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams.FollowUpFeedUnitType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.data.followup.cache.FollowUpStateCache;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: appirater_create_report */
public class FollowUpFeedUnitFetcher {
    public static final Class<?> f19191a = FollowUpFeedUnitFetcher.class;
    private DefaultBlueServiceOperationFactory f19192b;
    private FbNetworkManager f19193c;
    private TasksManager f19194d;
    private FbAppType f19195e;
    public InstagramUtils f19196f;
    public FollowUpStateCache f19197g;

    /* compiled from: appirater_create_report */
    public class C16671 extends OperationResultFutureCallback {
        final /* synthetic */ FollowUpFeedUnitFetcher f19190a;

        public C16671(FollowUpFeedUnitFetcher followUpFeedUnitFetcher) {
            this.f19190a = followUpFeedUnitFetcher;
        }

        protected final void m22701a(ServiceException serviceException) {
            BLog.b(FollowUpFeedUnitFetcher.f19191a, "Exception during fetch follow up feed unit", serviceException);
        }
    }

    @Inject
    public FollowUpFeedUnitFetcher(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FbNetworkManager fbNetworkManager, TasksManager tasksManager, FbAppType fbAppType, InstagramUtils instagramUtils, FollowUpStateCache followUpStateCache) {
        this.f19193c = fbNetworkManager;
        this.f19192b = defaultBlueServiceOperationFactory;
        this.f19194d = tasksManager;
        this.f19195e = fbAppType;
        this.f19196f = instagramUtils;
        this.f19197g = followUpStateCache;
    }

    private void m22703a(FeedProps<GraphQLStory> feedProps, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType, ImmutableList<FollowUpFeedUnitType> immutableList, boolean z, CallerContext callerContext, OperationResultFutureCallback operationResultFutureCallback) {
        if (m22705a((FeedProps) feedProps)) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
            this.f19197g.a(graphQLStory.g(), true);
            if (StoryProps.p(feedProps)) {
                m22704a(graphQLStory);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchFollowUpFeedUnitParamsKey", new FetchFollowUpFeedUnitParams(graphQLStory.c(), graphQLStory.g(), graphQLFollowUpFeedUnitActionType, 10, immutableList, z));
            this.f19194d.a("fetchFollowUpFeedUnit_" + graphQLStory.c(), BlueServiceOperationFactoryDetour.a(this.f19192b, "feed_fetch_followup_feed_unit", bundle, callerContext, 1516558847).a(), operationResultFutureCallback);
        }
    }

    private boolean m22705a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        return (graphQLStory == null || graphQLStory.c() == null || graphQLStory.g() == null || StoryProps.h(feedProps) != null || this.f19197g.a(graphQLStory.g()) || this.f19195e.j != Product.FB4A || !this.f19193c.d()) ? false : true;
    }

    public final void m22706a(FeedProps<GraphQLStory> feedProps, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType, boolean z, CallerContext callerContext) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        List arrayList = new ArrayList();
        if (InstagramUtils.a(graphQLStory) && !this.f19196f.a()) {
            if (this.f19196f.g()) {
                this.f19197g.a(graphQLStory.g(), graphQLFollowUpFeedUnitActionType);
            } else {
                arrayList.add(FollowUpFeedUnitType.INSTAGRAM_PHOTO_CHAINING);
            }
        }
        m22703a(feedProps, graphQLFollowUpFeedUnitActionType, FollowUpFeedUnitType.getSupportedUnitTypes(arrayList), z, callerContext, new C16671(this));
    }

    private void m22704a(GraphQLStory graphQLStory) {
        this.f19197g.a(graphQLStory.g(), false);
    }
}
