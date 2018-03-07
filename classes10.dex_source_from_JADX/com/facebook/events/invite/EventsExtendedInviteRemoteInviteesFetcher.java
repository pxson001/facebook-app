package com.facebook.events.invite;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.events.graphql.EventsGraphQL.EventInvitableEntriesSearchQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntriesSearchQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntryFragmentModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.BaseTypeaheadFetcher;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.user.model.Name;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: classes.dex */
public class EventsExtendedInviteRemoteInviteesFetcher extends BaseTypeaheadFetcher<SimpleUserToken> {
    private static final String f17681a = EventsExtendedInviteRemoteInviteesFetcher.class.getSimpleName();
    private final ExecutorService f17682b;
    private final AbstractFbErrorReporter f17683c;
    private final GraphQLQueryExecutor f17684d;
    public String f17685e;

    @Inject
    public EventsExtendedInviteRemoteInviteesFetcher(ExecutorService executorService, EventsExtendedInviteTypeaheadQueryCacheSupplier eventsExtendedInviteTypeaheadQueryCacheSupplier, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, @Assisted String str) {
        super(tasksManager, eventsExtendedInviteTypeaheadQueryCacheSupplier);
        this.f17682b = executorService;
        this.f17683c = abstractFbErrorReporter;
        this.f17684d = graphQLQueryExecutor;
        this.f17685e = str;
    }

    public final String m18007a() {
        return "FETCH_REMOTE_CONTACTS_TASK";
    }

    public final ListenableFuture<SearchResponse<SimpleUserToken>> m18006a(final TypeaheadRequest typeaheadRequest) {
        GraphQLQueryExecutor graphQLQueryExecutor = this.f17684d;
        String str = typeaheadRequest.b;
        GraphQlQueryString eventInvitableEntriesSearchQueryString = new EventInvitableEntriesSearchQueryString();
        eventInvitableEntriesSearchQueryString.a("event_id", this.f17685e);
        eventInvitableEntriesSearchQueryString.a("search_query", str);
        eventInvitableEntriesSearchQueryString.a("first_count", Integer.valueOf(10));
        return Futures.a(GraphQLQueryExecutor.a(graphQLQueryExecutor.a(GraphQLRequest.a(eventInvitableEntriesSearchQueryString).a(GraphQLCachePolicy.c))), new Function<EventInvitableEntriesSearchQueryModel, SearchResponse<SimpleUserToken>>(this) {
            final /* synthetic */ EventsExtendedInviteRemoteInviteesFetcher f17680b;

            public Object apply(Object obj) {
                EventInvitableEntriesSearchQueryModel eventInvitableEntriesSearchQueryModel = (EventInvitableEntriesSearchQueryModel) obj;
                if (eventInvitableEntriesSearchQueryModel == null || eventInvitableEntriesSearchQueryModel.a() == null) {
                    this.f17680b.a(typeaheadRequest, new Throwable("Server returned null"));
                    return new SearchResponse(RegularImmutableList.a);
                }
                ImmutableList a = eventInvitableEntriesSearchQueryModel.a().a();
                Builder builder = new Builder();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EventInvitableEntryFragmentModel eventInvitableEntryFragmentModel = (EventInvitableEntryFragmentModel) a.get(i);
                    builder.c(new EventsExtendedInviteUserToken(UserKey.b(eventInvitableEntryFragmentModel.m()), new Name(eventInvitableEntryFragmentModel.l()), eventInvitableEntryFragmentModel.k(), eventInvitableEntryFragmentModel.j(), eventInvitableEntryFragmentModel.a()));
                }
                return new SearchResponse(builder.b());
            }
        }, this.f17682b);
    }

    protected final FetchSource m18009b() {
        return FetchSource.REMOTE;
    }

    public final void m18008a(@Nullable TypeaheadRequest typeaheadRequest, Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f17683c;
        SoftErrorBuilder a = SoftError.a(f17681a, "Failed to fetch local invitees");
        a.c = th;
        abstractFbErrorReporter.a(a.g());
    }
}
