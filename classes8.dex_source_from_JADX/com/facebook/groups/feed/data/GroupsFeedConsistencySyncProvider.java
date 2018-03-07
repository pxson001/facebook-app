package com.facebook.groups.feed.data;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.feed.protocol.FetchFeedbackForStoriesMethod;
import com.facebook.groups.feed.protocol.StoryInvalidaterFetchIdsMethod;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ExecutorService;

/* compiled from: faceweb/f?href=/pages/edit/pagesettings/%s */
public class GroupsFeedConsistencySyncProvider extends AbstractAssistedProvider<GroupsFeedConsistencySync> {
    public final <T> GroupsFeedConsistencySync<T> m15606a(FeedType feedType, StoryInvalidaterFetchIdsMethod storyInvalidaterFetchIdsMethod, FeedUnitCollection feedUnitCollection, GroupsOnDataChangeListener groupsOnDataChangeListener) {
        return new GroupsFeedConsistencySync(feedType, storyInvalidaterFetchIdsMethod, feedUnitCollection, groupsOnDataChangeListener, GraphQLQueryExecutor.a(this), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), DbFeedHomeStoriesHandler.a(this), FetchFeedbackForStoriesMethod.b(this), TasksManager.b(this));
    }
}
