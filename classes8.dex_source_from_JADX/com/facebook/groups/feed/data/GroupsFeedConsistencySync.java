package com.facebook.groups.feed.data;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.protocol.FetchFeedbackForStories.FetchBaseFeedbackForStoriesString;
import com.facebook.groups.feed.protocol.FetchFeedbackForStoriesMethod;
import com.facebook.groups.feed.protocol.FetchFeedbackForStoriesMethod.1;
import com.facebook.groups.feed.protocol.StoryInvalidaterFetchIdsMethod;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/edit/settings/%s */
public class GroupsFeedConsistencySync<T> {
    private final Runnable f14003a;
    public final TasksManager<Tasks> f14004b;
    private boolean f14005c = true;

    /* compiled from: faceweb/f?href=/pages/edit/settings/%s */
    enum Tasks {
        SYNC
    }

    @Inject
    public GroupsFeedConsistencySync(@Assisted final FeedType feedType, @Assisted StoryInvalidaterFetchIdsMethod storyInvalidaterFetchIdsMethod, @Assisted FeedUnitCollection feedUnitCollection, @Assisted GroupsOnDataChangeListener groupsOnDataChangeListener, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, FetchFeedbackForStoriesMethod fetchFeedbackForStoriesMethod, TasksManager tasksManager) {
        this.f14004b = tasksManager;
        final ListeningExecutorService a = MoreExecutors.a(executorService);
        final DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler2 = dbFeedHomeStoriesHandler;
        final Callable c14851 = new Callable<ImmutableList<String>>(this) {
            final /* synthetic */ GroupsFeedConsistencySync f13988c;

            public Object call() {
                Builder builder = ImmutableList.builder();
                ImmutableList b = dbFeedHomeStoriesHandler2.b(feedType);
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    builder.c(((Tuple) b.get(i)).a);
                }
                return builder.b();
            }
        };
        final StoryInvalidaterFetchIdsMethod storyInvalidaterFetchIdsMethod2 = storyInvalidaterFetchIdsMethod;
        final FetchFeedbackForStoriesMethod fetchFeedbackForStoriesMethod2 = fetchFeedbackForStoriesMethod;
        final GraphQLQueryExecutor graphQLQueryExecutor2 = graphQLQueryExecutor;
        final FeedUnitCollection feedUnitCollection2 = feedUnitCollection;
        final ListeningExecutorService listeningExecutorService = a;
        final AsyncFunction c14862 = new AsyncFunction<ImmutableList<String>, GraphQLResult<T>>(this) {
            final /* synthetic */ GroupsFeedConsistencySync f13993e;

            public final ListenableFuture m15601a(Object obj) {
                ImmutableList immutableList = (ImmutableList) obj;
                GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("GroupsFeedConsistency");
                GraphQLRequest a = storyInvalidaterFetchIdsMethod2.a();
                a.a(GraphQLCachePolicy.d);
                ListenableFuture b = graphQLBatchRequest.b(a);
                Futures.a(b, storyInvalidaterFetchIdsMethod2.b(), a);
                if (!immutableList.isEmpty()) {
                    FetchFeedbackForStoriesMethod fetchFeedbackForStoriesMethod = fetchFeedbackForStoriesMethod2;
                    FetchBaseFeedbackForStoriesString fetchBaseFeedbackForStoriesString = new FetchBaseFeedbackForStoriesString();
                    fetchBaseFeedbackForStoriesString.a("story_ids", immutableList);
                    GraphQLRequest a2 = GraphQLRequest.a(fetchBaseFeedbackForStoriesString, GraphQLStory.class);
                    a2.b = true;
                    a2.h = new 1(fetchFeedbackForStoriesMethod, fetchFeedbackForStoriesMethod.a.a(a2));
                    graphQLBatchRequest.a(a2);
                }
                graphQLQueryExecutor2.a(graphQLBatchRequest);
                return b;
            }
        };
        final StoryInvalidaterFetchIdsMethod storyInvalidaterFetchIdsMethod3 = storyInvalidaterFetchIdsMethod;
        final GroupsOnDataChangeListener groupsOnDataChangeListener2 = groupsOnDataChangeListener;
        this.f14003a = new Runnable(this) {
            final /* synthetic */ GroupsFeedConsistencySync f14002g;

            /* compiled from: faceweb/f?href=/pages/edit/settings/%s */
            class C14871 implements Callable<ListenableFuture<GraphQLResult<T>>> {
                final /* synthetic */ C14893 f13994a;

                C14871(C14893 c14893) {
                    this.f13994a = c14893;
                }

                public Object call() {
                    return Futures.b(listeningExecutorService.a(c14851), c14862, listeningExecutorService);
                }
            }

            /* compiled from: faceweb/f?href=/pages/edit/settings/%s */
            class C14882 extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
                final /* synthetic */ C14893 f13995a;

                C14882(C14893 c14893) {
                    this.f13995a = c14893;
                }

                protected final void m15602a(Object obj) {
                    Iterable iterable;
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult.e == null) {
                        iterable = RegularImmutableList.a;
                    } else {
                        iterable = storyInvalidaterFetchIdsMethod3.a(graphQLResult.e);
                    }
                    HashSet b = Sets.b(iterable);
                    ArrayList a = Lists.a();
                    Iterator it = feedUnitCollection2.iterator();
                    while (it.hasNext()) {
                        GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
                        if (graphQLFeedUnitEdge.c() instanceof GraphQLStory) {
                            String c = ((GraphQLStory) graphQLFeedUnitEdge.c()).c();
                            if (!(c == null || b.contains(c))) {
                                a.add(graphQLFeedUnitEdge);
                            }
                        }
                    }
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        feedUnitCollection2.c((GraphQLFeedUnitEdge) a.get(i));
                    }
                    if (!a.isEmpty()) {
                        groupsOnDataChangeListener2.m15594b();
                    }
                }

                protected final void m15603a(Throwable th) {
                }
            }

            public void run() {
                if (!feedUnitCollection2.v()) {
                    this.f14002g.f14004b.a(Tasks.SYNC, new C14871(this), new C14882(this));
                }
            }
        };
    }

    public final void m15605a(boolean z) {
        if (this.f14005c || z) {
            this.f14005c = false;
            this.f14003a.run();
        }
    }

    public final void m15604a() {
        this.f14005c = true;
        this.f14004b.c();
    }
}
