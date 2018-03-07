package com.facebook.facecast.plugin;

import android.content.Context;
import android.text.SpannableString;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.facecastdisplay.FacecastUiUtil;
import com.facebook.facecastdisplay.LiveEventAuthor;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.LiveVideoViewersQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersCollectionFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersCollectionFragmentModel.EdgesModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bottom_border */
public class FacecastViewerFacepileController {
    public static final String f18553a = FacecastViewerFacepileController.class.getName();
    private final Clock f18554b;
    private final GraphQLQueryExecutor f18555c;
    @ForUiThread
    private final ExecutorService f18556d;
    public final AbstractFbErrorReporter f18557e;
    private final Context f18558f;
    public final String f18559g;
    private final long f18560h;
    private ListenableFuture<GraphQLResult<LiveVideoViewersQueryModel>> f18561i;
    private final ViewersDownloadedListener f18562j;

    /* compiled from: bottom_border */
    public interface ViewersDownloadedListener {
        void mo1416a(@Nullable List<LiveEventAuthor> list, int i);
    }

    /* compiled from: bottom_border */
    class LiveWatchEventsGraphQLCallback extends AbstractDisposableFutureCallback<GraphQLResult<LiveVideoViewersQueryModel>> {
        final /* synthetic */ FacecastViewerFacepileController f18552a;

        public LiveWatchEventsGraphQLCallback(FacecastViewerFacepileController facecastViewerFacepileController) {
            this.f18552a = facecastViewerFacepileController;
        }

        protected final void m22175a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            int i = 0;
            if (graphQLResult == null) {
                FacecastViewerFacepileController.m22177b(this.f18552a, null, 0);
                return;
            }
            LiveVideoViewersQueryModel liveVideoViewersQueryModel = (LiveVideoViewersQueryModel) graphQLResult.e;
            if (liveVideoViewersQueryModel == null) {
                FacecastViewerFacepileController.m22177b(this.f18552a, null, 0);
                return;
            }
            LiveVideoViewersCollectionFragmentModel j = liveVideoViewersQueryModel.m3911j();
            if (j == null) {
                FacecastViewerFacepileController.m22177b(this.f18552a, null, 0);
                return;
            }
            ImmutableList j2 = j.m3904j();
            if (j2 == null) {
                FacecastViewerFacepileController.m22177b(this.f18552a, null, 0);
                return;
            }
            List arrayList = new ArrayList();
            int size = j2.size();
            while (i < size) {
                LiveEventAuthor a = LiveEventAuthor.m3183a(((EdgesModel) j2.get(i)).m3897a());
                if (a != null) {
                    arrayList.add(a);
                }
                i++;
            }
            FacecastViewerFacepileController.m22177b(this.f18552a, arrayList, j.m3900a());
        }

        protected final void m22176a(Throwable th) {
            this.f18552a.f18557e.a(FacecastViewerFacepileController.f18553a + "_graphFailure", new StringBuilder("Failed to get live watch events for ").append(this.f18552a.f18559g).toString() != null ? this.f18552a.f18559g : "no story id", th);
        }
    }

    @Inject
    public FacecastViewerFacepileController(Clock clock, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, ExecutorService executorService, @Assisted String str, @Assisted long j, @Assisted ViewersDownloadedListener viewersDownloadedListener, @Assisted Context context) {
        this.f18554b = clock;
        this.f18555c = graphQLQueryExecutor;
        this.f18556d = executorService;
        this.f18557e = abstractFbErrorReporter;
        this.f18558f = context;
        this.f18559g = str;
        this.f18560h = j;
        this.f18562j = viewersDownloadedListener;
    }

    public final void m22179a() {
        Number valueOf = Long.valueOf(this.f18554b.a() / 1000);
        LiveVideoViewersQueryString f = FetchLiveVideoEventsQuery.m3493f();
        f.a("targetID", this.f18559g);
        f.a("after_timestamp", Long.valueOf(this.f18560h / 1000));
        f.a("before_timestamp", valueOf);
        f.a("limit", Integer.valueOf(32));
        this.f18561i = this.f18555c.a(GraphQLRequest.a(f));
        Futures.a(this.f18561i, new LiveWatchEventsGraphQLCallback(this), this.f18556d);
    }

    public static void m22177b(@Nullable FacecastViewerFacepileController facecastViewerFacepileController, List list, int i) {
        facecastViewerFacepileController.f18562j.mo1416a(list, i);
    }

    public final SpannableString m22178a(@Nullable List<LiveEventAuthor> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (i < list.size()) {
            this.f18557e.a(f18553a, "verifiedViewCount(" + i + ") < viewers.size(" + list.size() + ")");
            i = list.size();
        }
        LiveEventAuthor liveEventAuthor = (LiveEventAuthor) list.get(0);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f18558f.getResources());
        if (i == 1) {
            styledStringBuilder.a(2131238258);
            FacecastUiUtil.m3103a(1, liveEventAuthor.f2902a, FacecastUiUtil.m3101a(this.f18558f.getResources()), styledStringBuilder);
        } else {
            styledStringBuilder.a(this.f18558f.getResources().getQuantityString(2131689706, i - 1));
            FacecastUiUtil.m3103a(1, liveEventAuthor.f2902a, FacecastUiUtil.m3101a(this.f18558f.getResources()), styledStringBuilder);
            styledStringBuilder.a("%2$d", String.valueOf(i - 1));
        }
        return styledStringBuilder.b();
    }

    public final void m22180b() {
        if (this.f18561i != null) {
            this.f18561i.cancel(false);
        }
    }
}
