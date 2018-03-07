package com.facebook.groups.events;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.events.GroupEventsBaseFragment.C31183;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ExecutorService;

/* compiled from: UPC_E */
public class GroupEventsPagedListLoaderProvider extends AbstractAssistedProvider<GroupEventsPagedListLoader> {
    public final GroupEventsPagedListLoader m22944a(String str, C31183 c31183, TimeframeInputTimeframe timeframeInputTimeframe) {
        return new GroupEventsPagedListLoader(EventGraphQLModelHelper.m19271a((InjectorLike) this), GraphQLQueryExecutor.a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), TasksManager.b(this), ResourcesMethodAutoProvider.a(this), str, c31183, timeframeInputTimeframe);
    }
}
