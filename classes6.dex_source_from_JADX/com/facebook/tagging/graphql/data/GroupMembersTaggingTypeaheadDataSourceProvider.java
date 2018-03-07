package com.facebook.tagging.graphql.data;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TaggingProfiles;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: description_for_share_link */
public class GroupMembersTaggingTypeaheadDataSourceProvider extends AbstractAssistedProvider<GroupMembersTaggingTypeaheadDataSource> {
    public final GroupMembersTaggingTypeaheadDataSource m25262a(Long l) {
        return new GroupMembersTaggingTypeaheadDataSource(l, ContactsDbTaggingDataSource.m25225a((InjectorLike) this), TaggingProfiles.m25203b((InjectorLike) this), ResourcesMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(this), new GroupMembersTaggingLogger(AnalyticsLoggerMethodAutoProvider.a(this)), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this));
    }
}
