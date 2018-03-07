package com.facebook.groups.docsandfiles.loader;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment.C30461;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFiles.GroupDocsAndFilesQueryString;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.NodesModel;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.PageInfoModel;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Unsupported item type =  */
public class GroupDocsAndFilesPagedListLoader {
    public final GraphQLQueryExecutor f21442a;
    public final ExecutorService f21443b;
    public final TasksManager f21444c;
    public final String f21445d;
    public ImmutableList<NodesModel> f21446e;
    public C30461 f21447f;
    public String f21448g;
    public boolean f21449h = false;

    /* compiled from: Unsupported item type =  */
    public class C30541 extends AbstractDisposableFutureCallback<GraphQLResult<GroupDocsAndFilesQueryModel>> {
        final /* synthetic */ GroupDocsAndFilesPagedListLoader f21439a;

        public C30541(GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader) {
            this.f21439a = groupDocsAndFilesPagedListLoader;
        }

        protected final void m22382a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((GroupDocsAndFilesQueryModel) graphQLResult.e).m22501a() != null && ((GroupDocsAndFilesQueryModel) graphQLResult.e).m22501a().m22497j() != null) {
                boolean z;
                GroupDocsAndFilesModel a = ((GroupDocsAndFilesQueryModel) graphQLResult.e).m22501a();
                PageInfoModel j = a.m22497j();
                this.f21439a.f21448g = j.m22489a();
                this.f21439a.f21447f.m22351a(false);
                GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader = this.f21439a;
                if (!j.m22491b() || this.f21439a.f21448g == null) {
                    z = true;
                } else {
                    z = false;
                }
                groupDocsAndFilesPagedListLoader.f21449h = z;
                if (this.f21439a.f21446e == null) {
                    this.f21439a.f21446e = a.m22495a();
                } else {
                    Builder builder = new Builder();
                    this.f21439a.f21446e = builder.b(this.f21439a.f21446e).b(a.m22495a()).b();
                }
                this.f21439a.f21447f.m22350a(this.f21439a.f21446e);
                this.f21439a.f21447f.m22352b(this.f21439a.f21446e.isEmpty());
            }
        }

        protected final void m22383a(Throwable th) {
            this.f21439a.f21447f.m22351a(false);
        }
    }

    /* compiled from: Unsupported item type =  */
    public class C30552 implements Runnable {
        final /* synthetic */ GroupDocsAndFilesPagedListLoader f21440a;

        public C30552(GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader) {
            this.f21440a = groupDocsAndFilesPagedListLoader;
        }

        public void run() {
            this.f21440a.f21447f.m22351a(true);
        }
    }

    /* compiled from: Unsupported item type =  */
    public class C30563 implements Callable<ListenableFuture<GraphQLResult<GroupDocsAndFilesQueryModel>>> {
        final /* synthetic */ GroupDocsAndFilesPagedListLoader f21441a;

        public C30563(GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader) {
            this.f21441a = groupDocsAndFilesPagedListLoader;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f21441a.f21442a;
            String str = this.f21441a.f21445d;
            String str2 = this.f21441a.f21448g;
            GraphQlQueryString groupDocsAndFilesQueryString = new GroupDocsAndFilesQueryString();
            groupDocsAndFilesQueryString.a("id", str);
            groupDocsAndFilesQueryString.a("count", Integer.valueOf(10));
            if (str2 != null) {
                groupDocsAndFilesQueryString.a("offset", str2);
            }
            return graphQLQueryExecutor.a(GraphQLRequest.a(groupDocsAndFilesQueryString).a(GraphQLCachePolicy.d).a(600));
        }
    }

    /* compiled from: Unsupported item type =  */
    public enum Tasks {
        FETCH_GROUP_DOCS_AND_FILES
    }

    @Inject
    public GroupDocsAndFilesPagedListLoader(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, TasksManager tasksManager, @Assisted String str, @Assisted C30461 c30461) {
        this.f21442a = graphQLQueryExecutor;
        this.f21443b = executorService;
        this.f21444c = tasksManager;
        this.f21445d = str;
        this.f21447f = c30461;
    }
}
