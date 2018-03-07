package com.facebook.groups.photos.loader;

import android.content.res.Resources;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.photos.adapter.GroupAlbumsAdapter;
import com.facebook.groups.photos.fragment.GroupAlbumsFragment.C33192;
import com.facebook.groups.photos.protocol.FetchGroupAlbums.FetchGroupAlbumsString;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel.NodesModel;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: TOXICLE_PRIVATE_GOING */
public class GroupAlbumsPagedListLoader {
    public static final Integer f23036a = Integer.valueOf(10);
    public static final Integer f23037b = Integer.valueOf(4);
    public final GraphQLQueryExecutor f23038c;
    public final ExecutorService f23039d;
    public final TasksManager f23040e;
    public final Resources f23041f;
    public final String f23042g;
    public ImmutableList<NodesModel> f23043h;
    public GraphQLGroupPostStatus f23044i = GraphQLGroupPostStatus.CANNOT_POST;
    public C33192 f23045j;
    public String f23046k;
    public boolean f23047l = false;

    /* compiled from: TOXICLE_PRIVATE_GOING */
    class C33271 implements Callable<GraphQLQueryFuture<GraphQLResult<FetchGroupAlbumsModel>>> {
        final /* synthetic */ GroupAlbumsPagedListLoader f23034a;

        /* compiled from: TOXICLE_PRIVATE_GOING */
        class C33261 implements Runnable {
            final /* synthetic */ C33271 f23033a;

            C33261(C33271 c33271) {
                this.f23033a = c33271;
            }

            public void run() {
                this.f23033a.f23034a.f23045j.m24222a(true);
            }
        }

        C33271(GroupAlbumsPagedListLoader groupAlbumsPagedListLoader) {
            this.f23034a = groupAlbumsPagedListLoader;
        }

        public Object call() {
            ExecutorDetour.a(this.f23034a.f23039d, new C33261(this), -2099895177);
            GraphQLQueryExecutor graphQLQueryExecutor = this.f23034a.f23038c;
            Resources resources = this.f23034a.f23041f;
            String str = this.f23034a.f23042g;
            String str2 = this.f23034a.f23046k;
            GraphQlQueryString fetchGroupAlbumsString = new FetchGroupAlbumsString();
            fetchGroupAlbumsString.a("albums_to_fetch", GroupAlbumsPagedListLoader.f23036a).a("preview_image_thumb_height", String.valueOf(resources.getDimensionPixelSize(2131434323))).a("preview_image_thumb_width", String.valueOf(resources.getDimensionPixelSize(2131434323))).a("cover_photo_height", String.valueOf(resources.getDimensionPixelSize(2131434331))).a("cover_photo_width", String.valueOf(resources.getDimensionPixelSize(2131434331))).a("group", str).a("preview_images_count", GroupAlbumsPagedListLoader.f23037b);
            if (str2 != null) {
                fetchGroupAlbumsString.a("end_cursor", str2);
            }
            return graphQLQueryExecutor.a(GraphQLRequest.a(fetchGroupAlbumsString).a(GraphQLCachePolicy.d).a(600));
        }
    }

    /* compiled from: TOXICLE_PRIVATE_GOING */
    class C33282 extends AbstractDisposableFutureCallback<GraphQLResult<FetchGroupAlbumsModel>> {
        final /* synthetic */ GroupAlbumsPagedListLoader f23035a;

        C33282(GroupAlbumsPagedListLoader groupAlbumsPagedListLoader) {
            this.f23035a = groupAlbumsPagedListLoader;
        }

        protected final void m24256a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                GraphQLGroupVisibility l = ((FetchGroupAlbumsModel) graphQLResult.e).m24350l();
                if (l == GraphQLGroupVisibility.OPEN || l == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || ((FetchGroupAlbumsModel) graphQLResult.e).m24348j() == GraphQLGroupJoinState.MEMBER) {
                    boolean z;
                    GroupAlbumsModel a = ((FetchGroupAlbumsModel) graphQLResult.e).m24345a();
                    this.f23035a.f23044i = ((FetchGroupAlbumsModel) graphQLResult.e).m24349k();
                    GroupAlbumsPagedListLoader groupAlbumsPagedListLoader = this.f23035a;
                    if (a.m24339j().m24334j()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    groupAlbumsPagedListLoader.f23047l = z;
                    this.f23035a.f23046k = a.m24339j().m24332a();
                    this.f23035a.f23045j.m24222a(false);
                    if (this.f23035a.f23043h == null) {
                        this.f23035a.f23043h = a.m24338a();
                    } else {
                        Builder builder = new Builder();
                        this.f23035a.f23043h = builder.b(this.f23035a.f23043h).b(a.m24338a()).b();
                    }
                    C33192 c33192 = this.f23035a.f23045j;
                    ImmutableList immutableList = this.f23035a.f23043h;
                    GraphQLGroupPostStatus graphQLGroupPostStatus = this.f23035a.f23044i;
                    GroupAlbumsAdapter groupAlbumsAdapter = c33192.f23004a.al;
                    if (!(immutableList == null || graphQLGroupPostStatus == null)) {
                        groupAlbumsAdapter.f22992a = immutableList;
                        groupAlbumsAdapter.f22995d = graphQLGroupPostStatus;
                        AdapterDetour.a(groupAlbumsAdapter, 1200622388);
                    }
                    if (this.f23035a.f23043h.isEmpty()) {
                        this.f23035a.f23045j.m24223a(true, true);
                        return;
                    } else {
                        this.f23035a.f23045j.m24223a(false, true);
                        return;
                    }
                }
                this.f23035a.f23045j.m24223a(true, false);
            }
        }

        protected final void m24257a(Throwable th) {
            this.f23035a.f23045j.m24222a(false);
        }
    }

    /* compiled from: TOXICLE_PRIVATE_GOING */
    enum Tasks {
        FETCH_GROUP_ALBUMS
    }

    @Inject
    public GroupAlbumsPagedListLoader(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, TasksManager tasksManager, Resources resources, @Assisted String str, @Assisted C33192 c33192) {
        this.f23038c = graphQLQueryExecutor;
        this.f23039d = executorService;
        this.f23040e = tasksManager;
        this.f23041f = resources;
        this.f23042g = str;
        this.f23045j = c33192;
    }

    public final void m24258a() {
        if (!this.f23047l) {
            this.f23040e.a(Tasks.FETCH_GROUP_ALBUMS, new C33271(this), new C33282(this));
        }
    }

    public final void m24259b() {
        this.f23047l = false;
        this.f23046k = null;
        this.f23043h = null;
        this.f23044i = GraphQLGroupPostStatus.CANNOT_POST;
    }
}
