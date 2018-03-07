package com.facebook.events.create;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.create.EventCreationCategorySelectionFragment.C22462;
import com.facebook.events.create.protocol.PageEventCreationGraphQL.PageEventCategoriesQueryString;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: contact_invite_list_item_invite_button_click */
public class PageEventCreationCategoryPager {
    public final GraphQLQueryExecutor f16239a;
    public final TasksManager f16240b;

    /* compiled from: contact_invite_list_item_invite_button_click */
    public class C22661 implements Callable<ListenableFuture<GraphQLResult<PageEventCategoriesQueryModel>>> {
        final /* synthetic */ String f16235a;
        final /* synthetic */ PageEventCreationCategoryPager f16236b;

        public C22661(PageEventCreationCategoryPager pageEventCreationCategoryPager, String str) {
            this.f16236b = pageEventCreationCategoryPager;
            this.f16235a = str;
        }

        public Object call() {
            GraphQLRequest a = GraphQLRequest.a(new PageEventCategoriesQueryString());
            String str = this.f16235a;
            PageEventCategoriesQueryString pageEventCategoriesQueryString = new PageEventCategoriesQueryString();
            pageEventCategoriesQueryString.a("page_id", str);
            a.a(pageEventCategoriesQueryString.a);
            return this.f16236b.f16239a.a(a);
        }
    }

    /* compiled from: contact_invite_list_item_invite_button_click */
    public class C22672 extends AbstractDisposableFutureCallback<GraphQLResult<PageEventCategoriesQueryModel>> {
        final /* synthetic */ C22462 f16237a;
        final /* synthetic */ PageEventCreationCategoryPager f16238b;

        public C22672(PageEventCreationCategoryPager pageEventCreationCategoryPager, C22462 c22462) {
            this.f16238b = pageEventCreationCategoryPager;
            this.f16237a = c22462;
        }

        protected final void m16628a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f16237a.m16475a(((PageEventCategoriesQueryModel) graphQLResult.e).m16699a());
            }
        }

        protected final void m16629a(Throwable th) {
            this.f16237a.m16475a(null);
        }
    }

    @Inject
    public PageEventCreationCategoryPager(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f16239a = graphQLQueryExecutor;
        this.f16240b = tasksManager;
    }
}
