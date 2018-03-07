package com.facebook.groups.events;

import android.content.res.Resources;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventRsvpMutation;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.events.GroupEventsBaseFragment.C31183;
import com.facebook.groups.events.protocol.FetchGroupEventList.FetchGroupEventListString;
import com.facebook.groups.events.protocol.FetchGroupEventListModels.FetchGroupEventListModel;
import com.facebook.groups.events.protocol.FetchGroupEventListModels.FetchGroupEventListModel.GroupEventsModel;
import com.facebook.groups.events.protocol.FetchGroupEventListModels.FetchGroupEventListModel.GroupEventsModel.EdgesModel;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: UPC_EAN_EXTENSION */
public class GroupEventsPagedListLoader {
    public static final Integer f21841a = Integer.valueOf(10);
    public final EventGraphQLModelHelper f21842b;
    public final GraphQLQueryExecutor f21843c;
    public final ExecutorService f21844d;
    public final TasksManager f21845e;
    public final Resources f21846f;
    public final String f21847g;
    public ImmutableList<Event> f21848h = RegularImmutableList.a;
    public C31183 f21849i;
    public TimeframeInputTimeframe f21850j;
    public String f21851k;
    public boolean f21852l = false;

    /* compiled from: UPC_EAN_EXTENSION */
    class C31241 implements Callable<GraphQLQueryFuture<GraphQLResult<FetchGroupEventListModel>>> {
        final /* synthetic */ GroupEventsPagedListLoader f21839a;

        /* compiled from: UPC_EAN_EXTENSION */
        class C31231 implements Runnable {
            final /* synthetic */ C31241 f21838a;

            C31231(C31241 c31241) {
                this.f21838a = c31241;
            }

            public void run() {
                this.f21838a.f21839a.f21849i.m22915a(true);
            }
        }

        C31241(GroupEventsPagedListLoader groupEventsPagedListLoader) {
            this.f21839a = groupEventsPagedListLoader;
        }

        public Object call() {
            ExecutorDetour.a(this.f21839a.f21844d, new C31231(this), 1938653832);
            GraphQlQueryString fetchGroupEventListString = new FetchGroupEventListString();
            fetchGroupEventListString.a("group_events_page_size", GroupEventsPagedListLoader.f21841a).a("profile_image_size", String.valueOf(this.f21839a.f21846f.getDimensionPixelSize(2131434274))).a("timeframe", this.f21839a.f21850j).a("group_id", this.f21839a.f21847g);
            if (this.f21839a.f21851k != null) {
                fetchGroupEventListString.a("end_cursor", this.f21839a.f21851k);
            }
            return this.f21839a.f21843c.a(GraphQLRequest.a(fetchGroupEventListString).a(GraphQLCachePolicy.c));
        }
    }

    /* compiled from: UPC_EAN_EXTENSION */
    class C31252 extends AbstractDisposableFutureCallback<GraphQLResult<FetchGroupEventListModel>> {
        final /* synthetic */ GroupEventsPagedListLoader f21840a;

        C31252(GroupEventsPagedListLoader groupEventsPagedListLoader) {
            this.f21840a = groupEventsPagedListLoader;
        }

        protected final void m22939a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            int i = 0;
            if (graphQLResult != null && graphQLResult.e != null) {
                GraphQLGroupVisibility k = ((FetchGroupEventListModel) graphQLResult.e).m23011k();
                if (k == GraphQLGroupVisibility.OPEN || k == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || ((FetchGroupEventListModel) graphQLResult.e).m23010j() == GraphQLGroupJoinState.MEMBER) {
                    boolean z;
                    GroupEventsModel a = ((FetchGroupEventListModel) graphQLResult.e).m23007a();
                    GroupEventsPagedListLoader groupEventsPagedListLoader = this.f21840a;
                    if (a.m23001j().m22996j()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    groupEventsPagedListLoader.f21852l = z;
                    this.f21840a.f21851k = a.m23001j().m22994a();
                    this.f21840a.f21849i.m22915a(false);
                    Builder builder = new Builder();
                    if (this.f21840a.f21848h != null) {
                        builder.b(this.f21840a.f21848h);
                    }
                    ImmutableList a2 = a.m23000a();
                    int size = a2.size();
                    while (i < size) {
                        EdgesModel edgesModel = (EdgesModel) a2.get(i);
                        EventGraphQLModelHelper eventGraphQLModelHelper = this.f21840a.f21842b;
                        builder.c(EventGraphQLModelHelper.m19277b(edgesModel.m22988a()));
                        i++;
                    }
                    this.f21840a.f21848h = builder.b();
                    this.f21840a.f21849i.m22914a(this.f21840a.f21848h, true);
                    return;
                }
                GroupEventsBaseFragment.m22924a(this.f21840a.f21849i.f21815a, false);
            }
        }

        protected final void m22940a(Throwable th) {
            this.f21840a.f21849i.m22915a(false);
        }
    }

    /* compiled from: UPC_EAN_EXTENSION */
    enum Tasks {
        FETCH_GROUP_EVENTS
    }

    @Inject
    public GroupEventsPagedListLoader(EventGraphQLModelHelper eventGraphQLModelHelper, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, TasksManager tasksManager, Resources resources, @Assisted String str, @Assisted C31183 c31183, @Assisted TimeframeInputTimeframe timeframeInputTimeframe) {
        this.f21842b = eventGraphQLModelHelper;
        this.f21843c = graphQLQueryExecutor;
        this.f21844d = executorService;
        this.f21845e = tasksManager;
        this.f21846f = resources;
        this.f21847g = str;
        this.f21849i = c31183;
        this.f21850j = timeframeInputTimeframe;
    }

    public final void m22941a() {
        if (!this.f21852l) {
            this.f21845e.a(Tasks.FETCH_GROUP_EVENTS, new C31241(this), new C31252(this));
        }
    }

    public final void m22942a(EventRsvpMutation eventRsvpMutation, boolean z) {
        Builder builder = new Builder();
        int size = this.f21848h.size();
        for (int i = 0; i < size; i++) {
            Event event = (Event) this.f21848h.get(i);
            if (Objects.equal(event.a, eventRsvpMutation.a())) {
                builder.c(eventRsvpMutation.b);
            } else {
                builder.c(event);
            }
        }
        this.f21848h = builder.b();
        this.f21849i.m22914a(this.f21848h, z);
    }

    public final void m22943c() {
        this.f21852l = false;
        this.f21851k = null;
        this.f21848h = RegularImmutableList.a;
    }
}
