package com.facebook.events.create;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.events.create.EventCreationNikumanActivity.C22568;
import com.facebook.events.create.protocol.PageEventCreationGraphQL.PageEventCreationPageHostsQueryString;
import com.facebook.events.create.protocol.PageEventCreationGraphQL.PageHostInfoQueryString;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCreationPageHostsQueryModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: contact_picker_non_friend_filter */
public class PageEventCreationPageHostsPager {
    public final GraphQLQueryExecutor f16249a;
    public final Resources f16250b;
    public final ScreenUtil f16251c;
    public final TasksManager f16252d;

    /* compiled from: contact_picker_non_friend_filter */
    public interface FetchPageEventHostCallback {
        void mo776a(List<PageHostInfoFragmentModel> list);
    }

    /* compiled from: contact_picker_non_friend_filter */
    public class C22703 implements Callable<ListenableFuture<GraphQLResult<PageHostInfoFragmentModel>>> {
        final /* synthetic */ String f16245a;
        final /* synthetic */ PageEventCreationPageHostsPager f16246b;

        public C22703(PageEventCreationPageHostsPager pageEventCreationPageHostsPager, String str) {
            this.f16246b = pageEventCreationPageHostsPager;
            this.f16245a = str;
        }

        public Object call() {
            GraphQlQueryParamSet graphQlQueryParamSet;
            GraphQLRequest a = GraphQLRequest.a(new PageHostInfoQueryString());
            PageEventCreationPageHostsPager pageEventCreationPageHostsPager = this.f16246b;
            Object obj = this.f16245a;
            if (StringUtil.a(obj)) {
                graphQlQueryParamSet = null;
            } else {
                PageHostInfoQueryString pageHostInfoQueryString = new PageHostInfoQueryString();
                pageHostInfoQueryString.a("page_id", obj);
                pageHostInfoQueryString.a("profile_image_size", String.valueOf(pageEventCreationPageHostsPager.f16250b.getDimensionPixelSize(2131427458)));
                pageHostInfoQueryString.a("cover_image_portrait_size", Integer.valueOf(pageEventCreationPageHostsPager.f16251c.f()));
                graphQlQueryParamSet = pageHostInfoQueryString.a;
            }
            a.a(graphQlQueryParamSet);
            return this.f16246b.f16249a.a(a);
        }
    }

    /* compiled from: contact_picker_non_friend_filter */
    public class C22714 extends AbstractDisposableFutureCallback<GraphQLResult<PageHostInfoFragmentModel>> {
        final /* synthetic */ C22568 f16247a;
        final /* synthetic */ PageEventCreationPageHostsPager f16248b;

        public C22714(PageEventCreationPageHostsPager pageEventCreationPageHostsPager, C22568 c22568) {
            this.f16248b = pageEventCreationPageHostsPager;
            this.f16247a = c22568;
        }

        protected final void m16632a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f16247a.m16504a((PageHostInfoFragmentModel) graphQLResult.e);
            }
        }

        protected final void m16633a(Throwable th) {
        }
    }

    public static PageEventCreationPageHostsPager m16635b(InjectorLike injectorLike) {
        return new PageEventCreationPageHostsPager(GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), TasksManager.b(injectorLike));
    }

    public static PageEventCreationPageHostsPager m16634a(InjectorLike injectorLike) {
        return m16635b(injectorLike);
    }

    @Inject
    public PageEventCreationPageHostsPager(GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, ScreenUtil screenUtil, TasksManager tasksManager) {
        this.f16249a = graphQLQueryExecutor;
        this.f16250b = resources;
        this.f16251c = screenUtil;
        this.f16252d = tasksManager;
    }

    public final void m16636a(final String str, final FetchPageEventHostCallback fetchPageEventHostCallback) {
        this.f16252d.a("fetchOwnedPages", new Callable<ListenableFuture<GraphQLResult<PageEventCreationPageHostsQueryModel>>>(this) {
            final /* synthetic */ PageEventCreationPageHostsPager f16242b;

            public Object call() {
                GraphQLRequest a = GraphQLRequest.a(new PageEventCreationPageHostsQueryString());
                PageEventCreationPageHostsPager pageEventCreationPageHostsPager = this.f16242b;
                Object obj = str;
                PageEventCreationPageHostsQueryString pageEventCreationPageHostsQueryString = new PageEventCreationPageHostsQueryString();
                if (!StringUtil.a(obj)) {
                    pageEventCreationPageHostsQueryString.a("first_count", obj);
                }
                pageEventCreationPageHostsQueryString.a("profile_image_size", String.valueOf(pageEventCreationPageHostsPager.f16250b.getDimensionPixelSize(2131427458)));
                pageEventCreationPageHostsQueryString.a("cover_image_portrait_size", Integer.valueOf(pageEventCreationPageHostsPager.f16251c.f()));
                a.a(pageEventCreationPageHostsQueryString.a);
                return this.f16242b.f16249a.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<PageEventCreationPageHostsQueryModel>>(this) {
            final /* synthetic */ PageEventCreationPageHostsPager f16244b;

            protected final void m16630a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null && ((PageEventCreationPageHostsQueryModel) graphQLResult.e).m16711a() != null) {
                    fetchPageEventHostCallback.mo776a(((PageEventCreationPageHostsQueryModel) graphQLResult.e).m16711a().m16707a());
                }
            }

            protected final void m16631a(Throwable th) {
                fetchPageEventHostCallback.mo776a(Collections.EMPTY_LIST);
            }
        });
    }
}
