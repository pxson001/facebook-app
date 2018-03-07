package com.facebook.pages.fb4a.events.eventslist;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListFragment.C04013;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListFragment.C04024;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListFragment.C04046;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQL.PageNewlyAddedEventsQueryString;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQL.PagePastEventsQueryString;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQL.PageUpcomingEventsQueryString;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQLModels.PagePastEventsQueryModel;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQLModels.PageUpcomingEventsQueryModel;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQLModels.PageUpcomingEventsQueryModel.OwnedEventsModel;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQLModels.PageUpcomingEventsQueryModel.OwnedEventsModel.PageInfoModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_video_enabled */
public class PageEventsListPager {
    public final GraphQLQueryExecutor f3007a;
    public final TasksManager f3008b;
    private final GraphQLSubscriptionHolder f3009c;
    public int f3010d;
    public PageEventsListAdapter f3011e;
    private final FutureCallback<GraphQLResult<EventCommonFragmentModel>> f3012f = new C04061(this);

    /* compiled from: profile_video_enabled */
    class C04061 implements FutureCallback<GraphQLResult<EventCommonFragmentModel>> {
        final /* synthetic */ PageEventsListPager f2988a;

        C04061(PageEventsListPager pageEventsListPager) {
            this.f2988a = pageEventsListPager;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                EventCommonFragmentModel eventCommonFragmentModel = (EventCommonFragmentModel) graphQLResult.e;
                if (this.f2988a.f3011e != null && eventCommonFragmentModel != null) {
                    this.f2988a.f3011e.m3975a(eventCommonFragmentModel.dL_(), EventGraphQLModelHelper.b(eventCommonFragmentModel));
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: profile_video_enabled */
    public class C04116 implements Callable<ListenableFuture<List<EventCommonFragmentModel>>> {
        final /* synthetic */ List f3003a;
        final /* synthetic */ PageEventsListPager f3004b;

        public C04116(PageEventsListPager pageEventsListPager, List list) {
            this.f3004b = pageEventsListPager;
            this.f3003a = list;
        }

        public Object call() {
            PageNewlyAddedEventsQueryString pageNewlyAddedEventsQueryString = new PageNewlyAddedEventsQueryString();
            pageNewlyAddedEventsQueryString.a("event_ids", this.f3003a);
            return GraphQLQueryExecutor.b(this.f3004b.f3007a.a(GraphQLRequest.a(pageNewlyAddedEventsQueryString)));
        }
    }

    /* compiled from: profile_video_enabled */
    public class C04127 extends AbstractDisposableFutureCallback<List<EventCommonFragmentModel>> {
        final /* synthetic */ C04046 f3005a;
        final /* synthetic */ PageEventsListPager f3006b;

        public C04127(PageEventsListPager pageEventsListPager, C04046 c04046) {
            this.f3006b = pageEventsListPager;
            this.f3005a = c04046;
        }

        protected final void m4009a(Object obj) {
            this.f3005a.m3988a((List) obj);
        }

        protected final void m4010a(Throwable th) {
            this.f3005a.m3988a(Collections.EMPTY_LIST);
        }
    }

    public static PageEventsListPager m4012b(InjectorLike injectorLike) {
        return new PageEventsListPager(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), GraphQLSubscriptionHolder.b(injectorLike));
    }

    @Inject
    public PageEventsListPager(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f3007a = graphQLQueryExecutor;
        this.f3008b = tasksManager;
        this.f3009c = graphQLSubscriptionHolder;
    }

    public final void m4013a(long j, final int i, String str, final C04013 c04013) {
        final long j2 = j;
        final int i2 = i;
        final String str2 = str;
        this.f3008b.a("fetchEventsList", new Callable<ListenableFuture<GraphQLResult<PageUpcomingEventsQueryModel>>>(this) {
            final /* synthetic */ PageEventsListPager f2992d;

            public Object call() {
                GraphQLRequest a = GraphQLRequest.a(new PageUpcomingEventsQueryString());
                a.a(new PageUpcomingEventsQueryString().a("page_id", String.valueOf(j2)).a("first_count", Integer.valueOf(i2)).a("end_cursor", str2).a("profile_image_size", String.valueOf(this.f2992d.f3010d)).a);
                return this.f2992d.f3007a.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<PageUpcomingEventsQueryModel>>(this) {
            final /* synthetic */ PageEventsListPager f2995c;

            protected final void m4005a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                boolean z = false;
                if (graphQLResult.e != null && ((PageUpcomingEventsQueryModel) graphQLResult.e).m4065k() != null) {
                    boolean z2;
                    if (((PageUpcomingEventsQueryModel) graphQLResult.e).m4066l() == null || ((PageUpcomingEventsQueryModel) graphQLResult.e).m4066l().isEmpty()) {
                        z2 = false;
                    } else {
                        z2 = new ProfilePermissions(((PageUpcomingEventsQueryModel) graphQLResult.e).m4066l()).a(Permission.CREATE_CONTENT);
                    }
                    OwnedEventsModel k = ((PageUpcomingEventsQueryModel) graphQLResult.e).m4065k();
                    List a = (k.m4053a() == null || k.m4053a().isEmpty()) ? Collections.EMPTY_LIST : k.m4053a();
                    GraphQLEventsCalendarSubscriptionStatus j = ((PageUpcomingEventsQueryModel) graphQLResult.e).m4064j();
                    int a2 = ((PageUpcomingEventsQueryModel) graphQLResult.e).m4058a();
                    PageInfoModel j2 = k.m4054j();
                    String a3 = j2 == null ? null : j2.m4047a();
                    if (j2 != null) {
                        z = j2.m4049j();
                    }
                    c04013.m3986a(z2, j, a2, a, a3, z);
                    PageEventsListPager.m4011a(this.f2995c, a, graphQLResult);
                }
            }

            protected final void m4006a(Throwable th) {
                c04013.m3986a(false, null, 0, Collections.EMPTY_LIST, null, false);
            }
        });
    }

    public final void m4014a(long j, final int i, String str, final C04024 c04024) {
        final long j2 = j;
        final int i2 = i;
        final String str2 = str;
        this.f3008b.a("fetchEventsList", new Callable<ListenableFuture<GraphQLResult<PagePastEventsQueryModel>>>(this) {
            final /* synthetic */ PageEventsListPager f2999d;

            public Object call() {
                GraphQLRequest a = GraphQLRequest.a(new PagePastEventsQueryString());
                a.a(new PagePastEventsQueryString().a("page_id", String.valueOf(j2)).a("first_count", Integer.valueOf(i2)).a("end_cursor", str2).a("profile_image_size", String.valueOf(this.f2999d.f3010d)).a);
                return this.f2999d.f3007a.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<PagePastEventsQueryModel>>(this) {
            final /* synthetic */ PageEventsListPager f3002c;

            protected final void m4007a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult.e != null && ((PagePastEventsQueryModel) graphQLResult.e).m4038a() != null) {
                    PagePastEventsQueryModel.OwnedEventsModel a = ((PagePastEventsQueryModel) graphQLResult.e).m4038a();
                    List a2 = (a.m4033a() == null || a.m4033a().isEmpty()) ? Collections.EMPTY_LIST : a.m4033a();
                    PagePastEventsQueryModel.OwnedEventsModel.PageInfoModel j = a.m4034j();
                    c04024.m3987a(a2, j == null ? null : j.m4027a(), j == null ? false : j.m4029j());
                }
            }

            protected final void m4008a(Throwable th) {
                c04024.m3987a(Collections.EMPTY_LIST, null, false);
            }
        });
    }

    public static void m4011a(PageEventsListPager pageEventsListPager, List list, GraphQLResult graphQLResult) {
        for (EventCommonFragmentModel eventCommonFragmentModel : list) {
            Set hashSet = new HashSet();
            hashSet.add(eventCommonFragmentModel.dL_());
            pageEventsListPager.f3009c.a(pageEventsListPager.f3012f, eventCommonFragmentModel.dL_(), new GraphQLResult(eventCommonFragmentModel, graphQLResult.freshness, graphQLResult.clientTimeMs, hashSet));
        }
    }
}
