package com.facebook.events.permalink.messagefriends;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventFriendsGraphQL.EventFriendsQueryString;
import com.facebook.events.graphql.EventFriendsGraphQLModels.EventFriendsQueryModel;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.messagefriends.EventMessageFriendsFragment.C26492;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: birthday */
public class EventMessageFriendsDataFetcher {
    public final GraphQLQueryExecutor f18623a;
    public final Resources f18624b;
    private final TasksManager<String> f18625c;

    @Inject
    public EventMessageFriendsDataFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, TasksManager tasksManager) {
        this.f18623a = graphQLQueryExecutor;
        this.f18624b = resources;
        this.f18625c = tasksManager;
    }

    public final void m18935a(final String str, final EventMessageFriendsFragment eventMessageFriendsFragment) {
        this.f18625c.a(str, new Callable<ListenableFuture<GraphQLResult<EventFriendsQueryModel>>>(this) {
            final /* synthetic */ EventMessageFriendsDataFetcher f18620b;

            public Object call() {
                EventMessageFriendsDataFetcher eventMessageFriendsDataFetcher = this.f18620b;
                String str = str;
                int dimensionPixelSize = eventMessageFriendsDataFetcher.f18624b.getDimensionPixelSize(2131431312);
                GraphQlQueryString eventFriendsQueryString = new EventFriendsQueryString();
                eventFriendsQueryString.a("event_id", str).a("profile_image_size", Integer.valueOf(dimensionPixelSize));
                return eventMessageFriendsDataFetcher.f18623a.a(GraphQLRequest.a(eventFriendsQueryString));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<EventFriendsQueryModel>>(this) {
            final /* synthetic */ EventMessageFriendsDataFetcher f18622b;

            protected final void m18933a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null) {
                    eventMessageFriendsFragment.m18946b();
                    return;
                }
                EventFriendsQueryModel eventFriendsQueryModel = (EventFriendsQueryModel) graphQLResult.e;
                if (eventFriendsQueryModel == null) {
                    eventMessageFriendsFragment.m18941a();
                    return;
                }
                ImmutableList immutableList;
                ImmutableList immutableList2;
                ImmutableList immutableList3;
                if (eventFriendsQueryModel.j() == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    immutableList = eventFriendsQueryModel.j().a();
                }
                if (eventFriendsQueryModel.k() == null) {
                    immutableList2 = RegularImmutableList.a;
                } else {
                    immutableList2 = eventFriendsQueryModel.k().a();
                }
                if (eventFriendsQueryModel.l() == null) {
                    immutableList3 = RegularImmutableList.a;
                } else {
                    immutableList3 = eventFriendsQueryModel.l().a();
                }
                if ((immutableList2.size() + immutableList.size()) + immutableList3.size() == 0) {
                    eventMessageFriendsFragment.m18941a();
                    return;
                }
                EventMessageFriendsFragment eventMessageFriendsFragment = eventMessageFriendsFragment;
                eventMessageFriendsFragment.f18637h.setVisibility(8);
                eventMessageFriendsFragment.f18638i.setVisibility(0);
                eventMessageFriendsFragment.f18636g = eventFriendsQueryModel;
                Context context = eventMessageFriendsFragment.getContext();
                eventMessageFriendsFragment.am = new EventMessageFriendsAdapter(ImmutableList.of(new EventFriendsSection(context, immutableList, EventGuestListType.PUBLIC_GOING), new EventFriendsSection(context, immutableList2, EventGuestListType.PUBLIC_WATCHED), new EventFriendsSection(context, immutableList3, EventGuestListType.PUBLIC_INVITED)));
                eventMessageFriendsFragment.am.f18617b = eventMessageFriendsFragment;
                eventMessageFriendsFragment.f18638i.setLayoutManager(new LinearLayoutManager(context));
                eventMessageFriendsFragment.f18638i.setAdapter(eventMessageFriendsFragment.am);
                eventMessageFriendsFragment.f18638i.setOnItemClickListener(new C26492(eventMessageFriendsFragment));
            }

            protected final void m18934a(Throwable th) {
                eventMessageFriendsFragment.m18946b();
            }
        });
    }
}
