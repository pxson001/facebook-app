package com.facebook.timeline.datafetcher;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.LegacyConsistencyBridge;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.profile.api.ProfileViewerContext;
import java.util.concurrent.Executor;

/* compiled from: groupInformation or groupId is null in addMembersToGroup */
public class TimelineGenericDataFetcherProvider extends AbstractAssistedProvider<TimelineGenericDataFetcher> {
    public final TimelineGenericDataFetcher m10601a(Context context, ProfileViewerContext profileViewerContext, CallerContext callerContext) {
        return new TimelineGenericDataFetcher(context, profileViewerContext, callerContext, IdBasedSingletonScopeProvider.a(this, 470), IdBasedLazy.a(this, 1144), LegacyConsistencyBridge.b(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
