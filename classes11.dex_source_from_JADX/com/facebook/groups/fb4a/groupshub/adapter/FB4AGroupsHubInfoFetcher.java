package com.facebook.groups.fb4a.groupshub.adapter;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubViewPagerAdapter.GroupsCreateHubTab;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubViewPagerAdapter.GroupsHubTab;
import com.facebook.groups.fb4a.groupshub.protocol.fetchAdminedGroups.FetchAdminedGroupsCountString;
import com.facebook.groups.fb4a.groupshub.protocol.fetchAdminedGroupsModels.FetchAdminedGroupsCountModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: _sync_id */
public class FB4AGroupsHubInfoFetcher {
    public final TasksManager f10195a;
    public final GraphQLQueryExecutor f10196b;

    /* compiled from: _sync_id */
    public class C11971 implements Callable<ListenableFuture<GraphQLResult<FetchAdminedGroupsCountModel>>> {
        final /* synthetic */ FB4AGroupsHubInfoFetcher f10191a;

        public Object call() {
            return this.f10191a.f10196b.a(GraphQLRequest.a(new FetchAdminedGroupsCountString()));
        }

        public C11971(FB4AGroupsHubInfoFetcher fB4AGroupsHubInfoFetcher) {
            this.f10191a = fB4AGroupsHubInfoFetcher;
        }
    }

    /* compiled from: _sync_id */
    public class C11982 extends AbstractDisposableFutureCallback<GraphQLResult<FetchAdminedGroupsCountModel>> {
        final /* synthetic */ FB4AGroupsHubViewPagerAdapter f10192a;
        final /* synthetic */ TabbedViewPagerIndicator f10193b;
        final /* synthetic */ FB4AGroupsHubInfoFetcher f10194c;

        public C11982(FB4AGroupsHubInfoFetcher fB4AGroupsHubInfoFetcher, FB4AGroupsHubViewPagerAdapter fB4AGroupsHubViewPagerAdapter, TabbedViewPagerIndicator tabbedViewPagerIndicator) {
            this.f10194c = fB4AGroupsHubInfoFetcher;
            this.f10192a = fB4AGroupsHubViewPagerAdapter;
            this.f10193b = tabbedViewPagerIndicator;
        }

        protected final void m10526a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((FetchAdminedGroupsCountModel) graphQLResult.e).m10573a() != null && ((FetchAdminedGroupsCountModel) graphQLResult.e).m10573a().m10566a() != null) {
                FB4AGroupsHubViewPagerAdapter fB4AGroupsHubViewPagerAdapter = this.f10192a;
                int a = ((FetchAdminedGroupsCountModel) graphQLResult.e).m10573a().m10566a().m10558a();
                if (a > 0) {
                    int size = fB4AGroupsHubViewPagerAdapter.f10202b.size();
                    for (int i = 0; i < size; i++) {
                        GroupsHubTab groupsHubTab = (GroupsHubTab) fB4AGroupsHubViewPagerAdapter.f10202b.get(i);
                        if (groupsHubTab instanceof GroupsCreateHubTab) {
                            GroupsCreateHubTab groupsCreateHubTab = (GroupsCreateHubTab) groupsHubTab;
                            if (a > 0) {
                                groupsCreateHubTab.f10200c = 2131242502;
                            } else {
                                groupsCreateHubTab.f10200c = 2131242501;
                            }
                        }
                    }
                    fB4AGroupsHubViewPagerAdapter.kR_();
                }
                this.f10193b.b();
            }
        }

        protected final void m10527a(Throwable th) {
        }
    }

    /* compiled from: _sync_id */
    public enum Tasks {
        ADMINED_GROUPS_QUERY
    }

    @Inject
    public FB4AGroupsHubInfoFetcher(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f10195a = tasksManager;
        this.f10196b = graphQLQueryExecutor;
    }
}
