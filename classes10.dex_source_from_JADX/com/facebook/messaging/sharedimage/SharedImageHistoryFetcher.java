package com.facebook.messaging.sharedimage;

import android.content.res.Resources;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.photos.view.PhotoViewFragment.AnonymousClass13;
import com.facebook.messaging.photos.view.SharedImageMessageAdapter.C05701;
import com.facebook.messaging.sharedimage.gqlrequest.SharedMediaHistoryRequestFactory;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryModels.SubsequentSharedPhotosModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: quick_replies_received */
public class SharedImageHistoryFetcher {
    private static final Class<?> f4014a = SharedImageHistoryFetcher.class;
    public final GraphQLQueryExecutor f4015b;
    public final SharedMediaHistoryRequestFactory f4016c;
    public final Resources f4017d;
    public final TasksManager<String> f4018e;
    public C05701 f4019f;

    /* compiled from: quick_replies_received */
    public class C06031 implements Callable<ListenableFuture<GraphQLResult<SubsequentSharedPhotosModel>>> {
        final /* synthetic */ GraphQLRequest f4011a;
        final /* synthetic */ SharedImageHistoryFetcher f4012b;

        public C06031(SharedImageHistoryFetcher sharedImageHistoryFetcher, GraphQLRequest graphQLRequest) {
            this.f4012b = sharedImageHistoryFetcher;
            this.f4011a = graphQLRequest;
        }

        public Object call() {
            return this.f4012b.f4015b.a(this.f4011a);
        }
    }

    /* compiled from: quick_replies_received */
    public class SharedImageHistoryRequestCallback extends AbstractDisposableFutureCallback<GraphQLResult<SubsequentSharedPhotosModel>> {
        final /* synthetic */ SharedImageHistoryFetcher f4013a;

        public SharedImageHistoryRequestCallback(SharedImageHistoryFetcher sharedImageHistoryFetcher) {
            this.f4013a = sharedImageHistoryFetcher;
        }

        protected final void m3732a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f4013a.f4019f == null) {
                return;
            }
            if (graphQLResult == null || graphQLResult.e == null || ((SubsequentSharedPhotosModel) graphQLResult.e).j() == null) {
                this.f4013a.f4019f.m3472a(null);
            } else {
                this.f4013a.f4019f.m3472a(new MediaResultPage((SubsequentSharedPhotosModel) graphQLResult.e, ((SubsequentSharedPhotosModel) graphQLResult.e).j().j()));
            }
        }

        protected final void m3733a(Throwable th) {
            if (this.f4013a.f4019f != null) {
                C05701 c05701 = this.f4013a.f4019f;
                AnonymousClass13 anonymousClass13 = c05701.f3643a.f3648e;
                BLog.b("PhotoViewFragment", "SharedImageMessageAdapter image fetch failed", th);
                if (anonymousClass13.f3621a.aA.getCount() == 0) {
                    BLog.b("PhotoViewFragment", "SharedImageMessageAdapter has 0 images");
                    anonymousClass13.f3621a.b();
                }
                c05701.f3643a.f3650g = false;
            }
        }
    }

    @Inject
    public SharedImageHistoryFetcher(GraphQLQueryExecutor graphQLQueryExecutor, SharedMediaHistoryRequestFactory sharedMediaHistoryRequestFactory, Resources resources, TasksManager tasksManager) {
        this.f4015b = graphQLQueryExecutor;
        this.f4016c = sharedMediaHistoryRequestFactory;
        this.f4017d = resources;
        this.f4018e = tasksManager;
    }
}
