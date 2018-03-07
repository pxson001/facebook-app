package com.facebook.facecastdisplay;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.facecastdisplay.protocol.FetchMomentsOfInterestQueryModels.FetchMomentsOfInterestQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio/3gpp */
public class MomentsOfInterestDownloader {
    public static final String f18997a = MomentsOfInterestDownloader.class.getName();
    public final GraphQLQueryExecutor f18998b;
    public final ExecutorService f18999c;
    public final AbstractFbErrorReporter f19000d;
    @Nullable
    public MomentsOfInterestDownloaderListener f19001e;
    @Nullable
    public String f19002f;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchMomentsOfInterestQueryModel>> f19003g;

    /* compiled from: audio/3gpp */
    public class FetchMomentsOfInterestGraphlQLCallback extends AbstractDisposableFutureCallback<GraphQLResult<FetchMomentsOfInterestQueryModel>> {
        final /* synthetic */ MomentsOfInterestDownloader f18996a;

        public FetchMomentsOfInterestGraphlQLCallback(MomentsOfInterestDownloader momentsOfInterestDownloader) {
            this.f18996a = momentsOfInterestDownloader;
        }

        protected final void m22576a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && this.f18996a.f19001e != null) {
                this.f18996a.f19001e.mo1451a(((FetchMomentsOfInterestQueryModel) graphQLResult.e).m4004j());
            }
        }

        protected final void m22577a(Throwable th) {
            this.f18996a.f19000d.a(MomentsOfInterestDownloader.f18997a + "_graphFailure", "Failed to fetch moments of interest GraphQL for video " + this.f18996a.f19002f, th);
            if (this.f18996a.f19001e != null) {
                MomentsOfInterestDownloaderListener momentsOfInterestDownloaderListener = this.f18996a.f19001e;
            }
        }
    }

    /* compiled from: audio/3gpp */
    public interface MomentsOfInterestDownloaderListener {
        void mo1451a(ImmutableList<Integer> immutableList);
    }

    @Inject
    public MomentsOfInterestDownloader(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f18999c = executorService;
        this.f18998b = graphQLQueryExecutor;
        this.f19000d = abstractFbErrorReporter;
    }

    public final void m22579b() {
        if (this.f19003g != null) {
            this.f19003g.cancel(false);
            this.f19003g = null;
        }
    }
}
