package com.facebook.composer.minutiae.protocol;

import android.location.Location;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: timeline/ */
public class MinutiaeObjectsDataFetcher {
    public final MinutiaeTaggableObjectsFetcher f1684a;
    public final TasksManager<TaskKey> f1685b;
    private final MinutiaeTaggableObjectsPreloader f1686c;
    private final String f1687d;
    private final String f1688e;
    private int f1689f;
    public Location f1690g;

    /* compiled from: timeline/ */
    enum TaskKey {
        SEARCH
    }

    @Inject
    public MinutiaeObjectsDataFetcher(@Assisted Integer num, @Assisted String str, @Assisted String str2, MinutiaeTaggableObjectsFetcher minutiaeTaggableObjectsFetcher, TasksManager tasksManager, MinutiaeTaggableObjectsPreloader minutiaeTaggableObjectsPreloader) {
        this.f1689f = num.intValue();
        this.f1687d = str;
        this.f1684a = minutiaeTaggableObjectsFetcher;
        this.f1685b = tasksManager;
        this.f1686c = minutiaeTaggableObjectsPreloader;
        this.f1688e = str2;
    }

    public final void m1683a(MinutiaeTaggableActivity minutiaeTaggableActivity, String str, String str2, AbstractDisposableFutureCallback<GraphQLResult<FetchTaggableObjectsQueryModel>> abstractDisposableFutureCallback) {
        this.f1685b.a(TaskKey.SEARCH, m1682b(this, minutiaeTaggableActivity, str, str2, null), abstractDisposableFutureCallback);
    }

    public final boolean m1684a(MinutiaeTaggableActivity minutiaeTaggableActivity, String str, String str2, String str3, AbstractDisposableFutureCallback<GraphQLResult<FetchTaggableObjectsQueryModel>> abstractDisposableFutureCallback) {
        final MinutiaeTaggableActivity minutiaeTaggableActivity2 = minutiaeTaggableActivity;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        return this.f1685b.a(TaskKey.SEARCH, new Callable<ListenableFuture<GraphQLResult<FetchTaggableObjectsQueryModel>>>(this) {
            final /* synthetic */ MinutiaeObjectsDataFetcher f1680e;

            public Object call() {
                return MinutiaeObjectsDataFetcher.m1682b(this.f1680e, minutiaeTaggableActivity2, str4, str5, str6);
            }
        }, abstractDisposableFutureCallback);
    }

    public static ListenableFuture m1682b(MinutiaeObjectsDataFetcher minutiaeObjectsDataFetcher, MinutiaeTaggableActivity minutiaeTaggableActivity, String str, @Nullable String str2, String str3) {
        boolean z = false;
        final FetchMinutiaeTaggableObjectsParams a = FetchMinutiaeTaggableObjectsParamsUtil.m1668a(minutiaeTaggableActivity, str, str3, minutiaeObjectsDataFetcher.f1689f, minutiaeObjectsDataFetcher.f1687d, str2, minutiaeObjectsDataFetcher.f1688e, false, minutiaeObjectsDataFetcher.f1690g);
        Object a2 = minutiaeObjectsDataFetcher.f1686c.m1694a(a);
        if (a2 != null) {
            z = true;
        }
        if (a2 == null) {
            a2 = minutiaeObjectsDataFetcher.f1684a.m1690a(a);
        }
        return Futures.a((ListenableFuture) Preconditions.checkNotNull(a2), new Function<GraphQLResult<FetchTaggableObjectsQueryModel>, GraphQLResult<FetchTaggableObjectsQueryModel>>(minutiaeObjectsDataFetcher) {
            final /* synthetic */ MinutiaeObjectsDataFetcher f1683c;

            public Object apply(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (z || graphQLResult.freshness != DataFreshnessResult.FROM_SERVER) {
                    this.f1683c.f1684a.m1691b(a);
                }
                return graphQLResult;
            }
        });
    }
}
