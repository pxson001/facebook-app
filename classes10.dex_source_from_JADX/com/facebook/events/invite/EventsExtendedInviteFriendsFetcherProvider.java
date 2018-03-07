package com.facebook.events.invite;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.contacts.iterator.ContactCursors;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.events.invite.EventsExtendedInviteFragment.C24904;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ExecutorService;

/* compiled from: client_id */
public class EventsExtendedInviteFriendsFetcherProvider extends AbstractAssistedProvider<EventsExtendedInviteFriendsFetcher> {
    public final EventsExtendedInviteFriendsFetcher m17961a(String str, C24904 c24904) {
        return new EventsExtendedInviteFriendsFetcher(ContactCursors.a(this), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.b(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), GraphQLQueryExecutor.a(this), (InviteeIteratorProvider) getOnDemandAssistedProviderForStaticDi(InviteeIteratorProvider.class), InvitePickerPerformanceLogger.m18041a(this), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(this), TasksManager.b(this), str, c24904);
    }
}
