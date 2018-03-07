package com.facebook.events.notificationsettings;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.notificationsettings.EventsNotificationSettingsFragment.C25211;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQL.FetchEventsNotificationSubscriptionLevelsString;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQLModels.FetchEventsNotificationSubscriptionLevelsModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: catalog_download_time */
public class EventsNotificationSettingsPager {
    public final GraphQLSubscriptionHolder f17815a;
    public final GraphQLQueryExecutor f17816b;
    public final TasksManager f17817c;
    public C25211 f17818d;
    public final FutureCallback<GraphQLResult<FetchEventsNotificationSubscriptionLevelsModel>> f17819e = new C25221(this);

    /* compiled from: catalog_download_time */
    class C25221 implements FutureCallback<GraphQLResult<FetchEventsNotificationSubscriptionLevelsModel>> {
        final /* synthetic */ EventsNotificationSettingsPager f17810a;

        C25221(EventsNotificationSettingsPager eventsNotificationSettingsPager) {
            this.f17810a = eventsNotificationSettingsPager;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f17810a.f17818d.m18151a(((FetchEventsNotificationSubscriptionLevelsModel) graphQLResult.e).m18187j().m18178a(), ((FetchEventsNotificationSubscriptionLevelsModel) graphQLResult.e).m18188k());
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: catalog_download_time */
    public class C25232 implements Callable<ListenableFuture<GraphQLResult<FetchEventsNotificationSubscriptionLevelsModel>>> {
        final /* synthetic */ String f17811a;
        final /* synthetic */ EventsNotificationSettingsPager f17812b;

        public Object call() {
            GraphQLRequest a = GraphQLRequest.a(new FetchEventsNotificationSubscriptionLevelsString());
            GraphQLRequest a2 = a.a(GraphQLCachePolicy.d);
            a2.b = true;
            a2.a(new FetchEventsNotificationSubscriptionLevelsString().a("event_id", this.f17811a).a);
            return this.f17812b.f17816b.a(a);
        }

        public C25232(EventsNotificationSettingsPager eventsNotificationSettingsPager, String str) {
            this.f17812b = eventsNotificationSettingsPager;
            this.f17811a = str;
        }
    }

    /* compiled from: catalog_download_time */
    public class C25243 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventsNotificationSubscriptionLevelsModel>> {
        final /* synthetic */ String f17813a;
        final /* synthetic */ EventsNotificationSettingsPager f17814b;

        public C25243(EventsNotificationSettingsPager eventsNotificationSettingsPager, String str) {
            this.f17814b = eventsNotificationSettingsPager;
            this.f17813a = str;
        }

        protected final void m18158a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((FetchEventsNotificationSubscriptionLevelsModel) graphQLResult.e).m18187j() != null) {
                this.f17814b.f17818d.m18151a(((FetchEventsNotificationSubscriptionLevelsModel) graphQLResult.e).m18187j().m18178a(), ((FetchEventsNotificationSubscriptionLevelsModel) graphQLResult.e).m18188k());
                this.f17814b.f17815a.a(this.f17814b.f17819e, this.f17813a, graphQLResult);
            }
        }

        protected final void m18159a(Throwable th) {
            this.f17814b.f17818d.m18151a(Collections.EMPTY_LIST, null);
        }
    }

    @Inject
    public EventsNotificationSettingsPager(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLSubscriptionHolder graphQLSubscriptionHolder, TasksManager tasksManager) {
        this.f17816b = graphQLQueryExecutor;
        this.f17815a = graphQLSubscriptionHolder;
        this.f17817c = tasksManager;
    }
}
