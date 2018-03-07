package com.facebook.events.invite;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ExecutorService;

/* compiled from: ckqw */
public class EventsExtendedInviteRemoteInviteesFetcherProvider extends AbstractAssistedProvider<EventsExtendedInviteRemoteInviteesFetcher> {
    public final EventsExtendedInviteRemoteInviteesFetcher m18010a(String str) {
        return new EventsExtendedInviteRemoteInviteesFetcher((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), EventsExtendedInviteTypeaheadQueryCacheSupplier.m18014b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), GraphQLQueryExecutor.a(this), TasksManager.b(this), str);
    }
}
