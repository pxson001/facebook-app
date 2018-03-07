package com.facebook.events.ui.themeselector;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.ui.themeselector.ThemeSelectorActivity.C27882;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQL;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeCategoriesModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: app_invite_view_did_show */
public class ThemeCategoriesFetcher {
    public final GraphQLQueryExecutor f19575a;
    public final TasksManager f19576b;
    public final C27882 f19577c;

    /* compiled from: app_invite_view_did_show */
    public class C27851 implements Callable<ListenableFuture<GraphQLResult<EventsThemeCategoriesModel>>> {
        final /* synthetic */ ThemeCategoriesFetcher f19573a;

        public C27851(ThemeCategoriesFetcher themeCategoriesFetcher) {
            this.f19573a = themeCategoriesFetcher;
        }

        public Object call() {
            return this.f19573a.f19575a.a(GraphQLRequest.a(EventsThemeSelectorGraphQL.m19805c()).a(EventsThemeSelectorGraphQL.m19805c().a).a(GraphQLCachePolicy.c));
        }
    }

    /* compiled from: app_invite_view_did_show */
    public class C27862 extends AbstractDisposableFutureCallback<GraphQLResult<EventsThemeCategoriesModel>> {
        final /* synthetic */ ThemeCategoriesFetcher f19574a;

        public C27862(ThemeCategoriesFetcher themeCategoriesFetcher) {
            this.f19574a = themeCategoriesFetcher;
        }

        protected final void m19776a(Object obj) {
            EventsThemeCategoriesModel eventsThemeCategoriesModel = (EventsThemeCategoriesModel) ((GraphQLResult) obj).e;
            if (eventsThemeCategoriesModel != null && eventsThemeCategoriesModel.m19821a() != null) {
                this.f19574a.f19577c.m19782a(eventsThemeCategoriesModel.m19821a().m19818a());
            }
        }

        protected final void m19777a(Throwable th) {
            this.f19574a.f19577c.m19782a(RegularImmutableList.a);
        }
    }

    @Inject
    public ThemeCategoriesFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, @Assisted C27882 c27882) {
        this.f19575a = graphQLQueryExecutor;
        this.f19576b = tasksManager;
        this.f19577c = c27882;
    }
}
