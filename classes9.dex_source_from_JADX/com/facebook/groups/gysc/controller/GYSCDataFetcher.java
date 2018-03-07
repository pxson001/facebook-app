package com.facebook.groups.gysc.controller;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.gysc.model.SuggestionUnitsRowModel;
import com.facebook.groups.gysc.model.SuggestionUnitsRowModel.Builder;
import com.facebook.groups.gysc.protocol.FetchGroupsGysc.FetchGroupCreationSuggestionsString;
import com.facebook.groups.gysc.protocol.FetchGroupsGyscModels.FetchGroupCreationSuggestionsModel;
import com.facebook.groups.gysc.protocol.FetchGroupsGyscModels.FetchGroupCreationSuggestionsModel.GroupsYouShouldCreateModel.NodesModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: payments_action_continue */
public class GYSCDataFetcher {
    private final TasksManager f6934a;
    public final GraphQLQueryExecutor f6935b;
    public final Resources f6936c;

    /* compiled from: payments_action_continue */
    class C07241 implements Callable<ListenableFuture<GraphQLResult<FetchGroupCreationSuggestionsModel>>> {
        final /* synthetic */ GYSCDataFetcher f6931a;

        public Object call() {
            return this.f6931a.f6935b.a(GraphQLRequest.a((FetchGroupCreationSuggestionsString) new FetchGroupCreationSuggestionsString().a("member_profile_size", Integer.valueOf(this.f6931a.f6936c.getDimensionPixelSize(2131433298)))).a(RequestPriority.NON_INTERACTIVE));
        }

        C07241(GYSCDataFetcher gYSCDataFetcher) {
            this.f6931a = gYSCDataFetcher;
        }
    }

    /* compiled from: payments_action_continue */
    enum Tasks {
        GROUPS_CREATION_SUGGESTIONS_QUERY
    }

    public static GYSCDataFetcher m7213b(InjectorLike injectorLike) {
        return new GYSCDataFetcher(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GYSCDataFetcher(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources) {
        this.f6934a = tasksManager;
        this.f6935b = graphQLQueryExecutor;
        this.f6936c = resources;
    }

    public final void m7214a(final GYSCHscrollViewAdapter gYSCHscrollViewAdapter) {
        if (!this.f6934a.a(Tasks.GROUPS_CREATION_SUGGESTIONS_QUERY)) {
            this.f6934a.a(Tasks.GROUPS_CREATION_SUGGESTIONS_QUERY, new C07241(this), new AbstractDisposableFutureCallback<GraphQLResult<FetchGroupCreationSuggestionsModel>>(this) {
                final /* synthetic */ GYSCDataFetcher f6933b;

                protected final void m7211a(Object obj) {
                    FetchGroupCreationSuggestionsModel fetchGroupCreationSuggestionsModel = (FetchGroupCreationSuggestionsModel) ((GraphQLResult) obj).e;
                    List arrayList = new ArrayList();
                    if (!(fetchGroupCreationSuggestionsModel.m7279a() == null || fetchGroupCreationSuggestionsModel.m7279a().m7275a() == null)) {
                        ImmutableList a = fetchGroupCreationSuggestionsModel.m7279a().m7275a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            NodesModel nodesModel = (NodesModel) a.get(i);
                            Builder builder = new Builder();
                            builder.f6944a = nodesModel;
                            arrayList.add(new SuggestionUnitsRowModel(builder.f6944a));
                        }
                    }
                    List list = arrayList;
                    if (!list.isEmpty()) {
                        GYSCHscrollViewAdapter gYSCHscrollViewAdapter = gYSCHscrollViewAdapter;
                        if (list != null) {
                            if (null == null || gYSCHscrollViewAdapter.f6941d == null) {
                                if (null != null && gYSCHscrollViewAdapter.f6941d == null) {
                                    BLog.c(GYSCHscrollViewAdapter.f6938a, "trying to append gysj data to an empty list");
                                }
                                gYSCHscrollViewAdapter.f6941d = new ArrayList(list);
                            } else {
                                gYSCHscrollViewAdapter.f6941d.addAll(list);
                            }
                            gYSCHscrollViewAdapter.notifyDataSetChanged();
                        }
                    }
                }

                protected final void m7212a(Throwable th) {
                }
            });
        }
    }
}
