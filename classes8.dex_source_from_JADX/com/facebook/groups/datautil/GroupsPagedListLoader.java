package com.facebook.groups.datautil;

import android.os.Parcelable;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.datautil.GroupsIdempotentRequestRunner.RunnerDelegate;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failures_occurred */
public class GroupsPagedListLoader<ResultType, NodeType> {
    public final GroupsIdempotentRequestRunner f13841a;
    public final GroupsIdempotentRequestRunner f13842b;
    private final DefaultAndroidThreadUtil f13843c;
    private final DefaultAppChoreographer f13844d;
    public ListLoaderDelegate<ResultType, NodeType> f13845e;
    public ImmutableList<NodeType> f13846f = RegularImmutableList.a;
    public String f13847g = null;
    public boolean f13848h = false;
    public boolean f13849i = false;
    private long f13850j = 500;
    private int f13851k = 0;

    /* compiled from: failures_occurred */
    class C14641 implements RunnerDelegate<GraphQLResult<ResultType>> {
        final /* synthetic */ GroupsPagedListLoader f13833a;

        C14641(GroupsPagedListLoader groupsPagedListLoader) {
            this.f13833a = groupsPagedListLoader;
        }

        public final ListenableFuture<GraphQLResult<ResultType>> mo838a() {
            if (this.f13833a.f13849i) {
                return this.f13833a.f13845e.m15479a(null, GraphQLCachePolicy.d);
            }
            return null;
        }
    }

    /* compiled from: failures_occurred */
    class C14652 implements FutureCallback<GraphQLResult<ResultType>> {
        final /* synthetic */ GroupsPagedListLoader f13834a;

        C14652(GroupsPagedListLoader groupsPagedListLoader) {
            this.f13834a = groupsPagedListLoader;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            synchronized (this.f13834a) {
                GroupsPagedListLoader.m15487d(this.f13834a);
                this.f13834a.f13846f = ImmutableList.of();
                GroupsPagedListLoader.m15483a(this.f13834a, graphQLResult);
            }
        }

        public void onFailure(Throwable th) {
            synchronized (this.f13834a) {
                GroupsPagedListLoader.m15484a(this.f13834a, this.f13834a.f13841a);
                if (th instanceof ServiceException) {
                    GroupsPagedListLoader.m15482a(this.f13834a, (ServiceException) th);
                }
            }
        }
    }

    /* compiled from: failures_occurred */
    class C14663 implements RunnerDelegate<GraphQLResult<ResultType>> {
        final /* synthetic */ GroupsPagedListLoader f13835a;

        C14663(GroupsPagedListLoader groupsPagedListLoader) {
            this.f13835a = groupsPagedListLoader;
        }

        public final ListenableFuture<GraphQLResult<ResultType>> mo838a() {
            if (this.f13835a.f13847g == null || !this.f13835a.f13849i) {
                return null;
            }
            return this.f13835a.f13845e.m15479a(this.f13835a.f13847g, GraphQLCachePolicy.a);
        }
    }

    /* compiled from: failures_occurred */
    class C14674 implements FutureCallback<GraphQLResult<ResultType>> {
        final /* synthetic */ GroupsPagedListLoader f13836a;

        C14674(GroupsPagedListLoader groupsPagedListLoader) {
            this.f13836a = groupsPagedListLoader;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            synchronized (this.f13836a) {
                GroupsPagedListLoader.m15487d(this.f13836a);
                GroupsPagedListLoader.m15483a(this.f13836a, graphQLResult);
            }
        }

        public void onFailure(Throwable th) {
            synchronized (this.f13836a) {
                GroupsPagedListLoader.m15484a(this.f13836a, this.f13836a.f13842b);
                if (th instanceof ServiceException) {
                    GroupsPagedListLoader.m15482a(this.f13836a, (ServiceException) th);
                }
            }
        }
    }

    /* compiled from: failures_occurred */
    class C14685 implements FutureCallback<GraphQLResult<ResultType>> {
        final /* synthetic */ GroupsPagedListLoader f13837a;

        C14685(GroupsPagedListLoader groupsPagedListLoader) {
            this.f13837a = groupsPagedListLoader;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            synchronized (this.f13837a) {
                if (graphQLResult != null) {
                    GroupsPagedListLoader.m15483a(this.f13837a, graphQLResult);
                }
                this.f13837a.f13849i = true;
                this.f13837a.m15489a();
            }
        }

        public void onFailure(Throwable th) {
            synchronized (this.f13837a) {
                this.f13837a.f13849i = true;
                this.f13837a.m15489a();
            }
        }
    }

    /* compiled from: failures_occurred */
    public interface ListLoaderDelegate<ResultType, NodeType> {
        ResultDescription<NodeType> m15478a(GraphQLResult<ResultType> graphQLResult);

        ListenableFuture<GraphQLResult<ResultType>> m15479a(@Nullable String str, GraphQLCachePolicy graphQLCachePolicy);

        void m15480a(ImmutableList<NodeType> immutableList, boolean z);
    }

    /* compiled from: failures_occurred */
    public class ResultDescription<NodeType> {
        public final ImmutableList<NodeType> f13838a;
        public final boolean f13839b;
        public final String f13840c;

        public ResultDescription(ImmutableList<NodeType> immutableList, boolean z, String str) {
            this.f13838a = immutableList;
            this.f13839b = z;
            this.f13840c = str;
        }
    }

    public static GroupsPagedListLoader m15486b(InjectorLike injectorLike) {
        return new GroupsPagedListLoader(DefaultAndroidThreadUtil.b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), DefaultAppChoreographer.a(injectorLike));
    }

    public static void m15482a(GroupsPagedListLoader groupsPagedListLoader, ServiceException serviceException) {
        Parcelable parcelable = (Parcelable) serviceException.result.k();
        if ((parcelable instanceof GraphQLError) && ((GraphQLError) parcelable).code == 1675011) {
            groupsPagedListLoader.m15488e();
            groupsPagedListLoader.m15489a();
        }
    }

    @Inject
    public GroupsPagedListLoader(DefaultAndroidThreadUtil defaultAndroidThreadUtil, MonotonicClock monotonicClock, DefaultAppChoreographer defaultAppChoreographer) {
        this.f13843c = defaultAndroidThreadUtil;
        this.f13844d = defaultAppChoreographer;
        this.f13841a = new GroupsIdempotentRequestRunner(new C14641(this), new C14652(this), monotonicClock, defaultAndroidThreadUtil);
        this.f13842b = new GroupsIdempotentRequestRunner(new C14663(this), new C14674(this), monotonicClock, defaultAndroidThreadUtil);
    }

    public static void m15483a(GroupsPagedListLoader groupsPagedListLoader, GraphQLResult graphQLResult) {
        if (graphQLResult == null) {
            groupsPagedListLoader.f13847g = null;
            return;
        }
        ResultDescription a = groupsPagedListLoader.f13845e.m15478a(graphQLResult);
        if (a == null) {
            groupsPagedListLoader.f13847g = null;
            return;
        }
        groupsPagedListLoader.f13847g = a.f13840c;
        groupsPagedListLoader.f13848h = a.f13839b;
        if (a.f13838a != null) {
            groupsPagedListLoader.f13846f = ImmutableList.builder().b(groupsPagedListLoader.f13846f).b(a.f13838a).b();
            groupsPagedListLoader.f13845e.m15480a(groupsPagedListLoader.f13846f, groupsPagedListLoader.f13848h);
        }
    }

    public static void m15484a(GroupsPagedListLoader groupsPagedListLoader, GroupsIdempotentRequestRunner groupsIdempotentRequestRunner) {
        int i = groupsPagedListLoader.f13851k;
        groupsPagedListLoader.f13851k = i + 1;
        if (i < 5) {
            long j = groupsPagedListLoader.f13850j * 2;
            groupsPagedListLoader.f13850j = j;
            groupsIdempotentRequestRunner.m15473a(j);
        }
    }

    public static void m15487d(GroupsPagedListLoader groupsPagedListLoader) {
        groupsPagedListLoader.f13850j = 500;
        groupsPagedListLoader.f13851k = 0;
    }

    private void m15488e() {
        this.f13841a.m15475b();
        this.f13842b.m15475b();
        this.f13848h = false;
        this.f13847g = null;
        this.f13846f = RegularImmutableList.a;
        m15487d(this);
    }

    public final void m15490a(ListLoaderDelegate<ResultType, NodeType> listLoaderDelegate) {
        this.f13845e = listLoaderDelegate;
        if (!this.f13848h) {
            ListenableFuture a = this.f13845e.m15479a(null, GraphQLCachePolicy.b);
            this.f13843c.a(a, new C14685(this));
            this.f13844d.a(a);
        }
    }

    public final synchronized void m15489a() {
        this.f13841a.m15474a();
    }

    public final synchronized void m15491b() {
        this.f13842b.m15474a();
    }

    public final synchronized void m15492c() {
        m15488e();
    }
}
