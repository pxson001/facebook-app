package com.facebook.groups.settings;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.settings.GroupSubscriptionFragment.C33461;
import com.facebook.groups.settings.protocol.FetchGroupSubscriptionInformation.FetchGroupSubscriptionInformationString;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: THREAD_VIEW_INVITE_BANNER */
public class GroupSubscriptionInfoFetcher {
    public final TasksManager f23172a;
    public final GraphQLQueryExecutor f23173b;
    public final C33461 f23174c;
    public final String f23175d;

    /* compiled from: THREAD_VIEW_INVITE_BANNER */
    public class C33471 implements Callable<ListenableFuture> {
        final /* synthetic */ GroupSubscriptionInfoFetcher f23170a;

        public C33471(GroupSubscriptionInfoFetcher groupSubscriptionInfoFetcher) {
            this.f23170a = groupSubscriptionInfoFetcher;
        }

        public Object call() {
            GraphQlQueryString fetchGroupSubscriptionInformationString = new FetchGroupSubscriptionInformationString();
            fetchGroupSubscriptionInformationString.a("group_id", this.f23170a.f23175d);
            return this.f23170a.f23173b.a(GraphQLRequest.a(fetchGroupSubscriptionInformationString).a(GraphQLCachePolicy.d));
        }
    }

    /* compiled from: THREAD_VIEW_INVITE_BANNER */
    public class C33482 extends AbstractDisposableFutureCallback {
        final /* synthetic */ GroupSubscriptionInfoFetcher f23171a;

        public C33482(GroupSubscriptionInfoFetcher groupSubscriptionInfoFetcher) {
            this.f23171a = groupSubscriptionInfoFetcher;
        }

        protected final void m24456a(Object obj) {
            if (this.f23171a.f23174c != null) {
                this.f23171a.f23174c.m24448a(obj);
            }
        }

        protected final void m24457a(Throwable th) {
            if (this.f23171a.f23174c != null) {
                GroupSubscriptionFragment.m24451e(this.f23171a.f23174c.f23161a);
            }
        }
    }

    @Inject
    public GroupSubscriptionInfoFetcher(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted String str, @Assisted C33461 c33461) {
        this.f23172a = tasksManager;
        this.f23173b = graphQLQueryExecutor;
        this.f23174c = c33461;
        this.f23175d = str;
    }
}
