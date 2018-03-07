package com.facebook.photos.upload.serverprocessing;

import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.manager.UploadManager$7;
import com.facebook.photos.upload.manager.UploadNotificationManager;
import com.facebook.photos.upload.serverprocessing.VideoStatusChecker.Listener;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: full_interstitial_gorilla */
public class FeedVideoStatusChecker {
    public final GraphQLQueryExecutor f14235a;
    public final TasksManager f14236b;
    public final Lazy<FetchGraphQLStoryMethod> f14237c;
    public final VideoStatusCheckerProvider f14238d;
    public final UploadManager$7 f14239e;
    public final String f14240f;
    public final boolean f14241g;
    public final ImmutableList<String> f14242h;

    /* compiled from: full_interstitial_gorilla */
    public class C09181 implements Listener {
        final /* synthetic */ FeedVideoStatusChecker f14233a;

        public C09181(FeedVideoStatusChecker feedVideoStatusChecker) {
            this.f14233a = feedVideoStatusChecker;
        }

        public final void mo1153a() {
            FetchType fetchType;
            FeedVideoStatusChecker feedVideoStatusChecker = this.f14233a;
            TasksManager tasksManager = feedVideoStatusChecker.f14236b;
            String str = "fetch_real_story_" + feedVideoStatusChecker.f14240f;
            String str2 = feedVideoStatusChecker.f14240f;
            boolean z = feedVideoStatusChecker.f14241g;
            DataFreshnessParam dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            if (z) {
                fetchType = FetchType.PLATFORM_DEFAULT;
            } else {
                fetchType = FetchType.GRAPHQL_VIDEO_CREATION_STORY;
            }
            tasksManager.a(str, feedVideoStatusChecker.f14235a.a(((FetchGraphQLStoryMethod) feedVideoStatusChecker.f14237c.get()).a(new FetchSingleStoryParams(str2, dataFreshnessParam, fetchType, 25), null, null)), new C09192(feedVideoStatusChecker));
        }

        public final void mo1154b() {
            if (this.f14233a.f14239e != null) {
                this.f14233a.f14239e.m21389a();
            }
        }
    }

    /* compiled from: full_interstitial_gorilla */
    public class C09192 extends AbstractDisposableFutureCallback<GraphQLResult<GraphQLStory>> {
        final /* synthetic */ FeedVideoStatusChecker f14234a;

        public C09192(FeedVideoStatusChecker feedVideoStatusChecker) {
            this.f14234a = feedVideoStatusChecker;
        }

        protected final void m21915a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                m21916a(new NullPointerException("Story not found"));
                return;
            }
            GraphQLStory graphQLStory = (GraphQLStory) graphQLResult.e;
            UploadManager$7 uploadManager$7 = this.f14234a.f14239e;
            ((UploadNotificationManager) uploadManager$7.f13648c.c.get()).m21418a(uploadManager$7.f13646a, uploadManager$7.f13647b, true, graphQLStory);
        }

        protected final void m21916a(Throwable th) {
            this.f14234a.f14239e.m21389a();
        }
    }

    @Inject
    public FeedVideoStatusChecker(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Lazy<FetchGraphQLStoryMethod> lazy, VideoStatusCheckerProvider videoStatusCheckerProvider, @Assisted String str, @Assisted boolean z, @Assisted ImmutableList<String> immutableList, @Assisted Listener listener) {
        this.f14235a = graphQLQueryExecutor;
        this.f14236b = tasksManager;
        this.f14237c = lazy;
        this.f14239e = listener;
        this.f14240f = str;
        this.f14241g = z;
        this.f14242h = immutableList;
        this.f14238d = videoStatusCheckerProvider;
    }
}
