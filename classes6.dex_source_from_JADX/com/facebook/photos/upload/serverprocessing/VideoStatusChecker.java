package com.facebook.photos.upload.serverprocessing;

import android.os.Handler;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.upload.serverprocessing.VideoStatusQuery.VideoStatusQueryString;
import com.facebook.photos.upload.serverprocessing.VideoStatusQueryModels.VideoStatusQueryModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: full_interstitial_simple_animations */
public class VideoStatusChecker {
    public final GraphQLQueryExecutor f14246a;
    public final ImmutableList<String> f14247b;
    public final Listener f14248c;
    private final TasksManager f14249d;
    public final Handler f14250e = new Handler();

    /* compiled from: full_interstitial_simple_animations */
    public interface Listener {
        void mo1153a();

        void mo1154b();
    }

    /* compiled from: full_interstitial_simple_animations */
    class C09201 implements Runnable {
        final /* synthetic */ VideoStatusChecker f14243a;

        C09201(VideoStatusChecker videoStatusChecker) {
            this.f14243a = videoStatusChecker;
        }

        public void run() {
            VideoStatusChecker.m21919c(this.f14243a);
        }
    }

    /* compiled from: full_interstitial_simple_animations */
    class C09222 extends AbstractDisposableFutureCallback<List<VideoStatusQueryModel>> {
        final /* synthetic */ VideoStatusChecker f14245a;

        /* compiled from: full_interstitial_simple_animations */
        class C09211 implements Runnable {
            final /* synthetic */ C09222 f14244a;

            C09211(C09222 c09222) {
                this.f14244a = c09222;
            }

            public void run() {
                VideoStatusChecker.m21919c(this.f14244a.f14245a);
            }
        }

        C09222(VideoStatusChecker videoStatusChecker) {
            this.f14245a = videoStatusChecker;
        }

        protected final void m21917a(Object obj) {
            List<VideoStatusQueryModel> list = (List) obj;
            if (list != null) {
                for (VideoStatusQueryModel videoStatusQueryModel : list) {
                    if (videoStatusQueryModel == null) {
                        this.f14245a.f14248c.mo1154b();
                        return;
                    }
                    VideoProcessingStatus videoProcessingStatus;
                    VideoStatusChecker videoStatusChecker = this.f14245a;
                    GraphQLVideoStatusType j = videoStatusQueryModel.m21930j();
                    if (j == GraphQLVideoStatusType.ENCODING || j == GraphQLVideoStatusType.ENCODED || j == GraphQLVideoStatusType.UPLOADING || j == GraphQLVideoStatusType.UPLOADED) {
                        videoProcessingStatus = VideoProcessingStatus.VIDEO_PROCESSING_STATUS_PROCESSING;
                    } else if (j == GraphQLVideoStatusType.OK || j == GraphQLVideoStatusType.UNPUBLISHED || j == GraphQLVideoStatusType.UNDISCOVERABLE) {
                        videoProcessingStatus = VideoProcessingStatus.VIDEO_PROCESSING_STATUS_READY;
                    } else {
                        videoProcessingStatus = VideoProcessingStatus.VIDEO_PROCESSING_STATUS_FAILED;
                    }
                    VideoProcessingStatus videoProcessingStatus2 = videoProcessingStatus;
                    if (videoProcessingStatus2 == VideoProcessingStatus.VIDEO_PROCESSING_STATUS_FAILED) {
                        this.f14245a.f14248c.mo1154b();
                        return;
                    } else if (videoProcessingStatus2 == VideoProcessingStatus.VIDEO_PROCESSING_STATUS_PROCESSING) {
                        HandlerDetour.b(this.f14245a.f14250e, new C09211(this), 1000, 382873881);
                        return;
                    }
                }
                this.f14245a.f14248c.mo1153a();
            }
        }

        protected final void m21918a(Throwable th) {
            this.f14245a.f14248c.mo1154b();
        }
    }

    /* compiled from: full_interstitial_simple_animations */
    public enum VideoProcessingStatus {
        VIDEO_PROCESSING_STATUS_PROCESSING,
        VIDEO_PROCESSING_STATUS_READY,
        VIDEO_PROCESSING_STATUS_FAILED
    }

    @Inject
    public VideoStatusChecker(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, @Assisted ImmutableList<String> immutableList, @Assisted Listener listener) {
        this.f14246a = graphQLQueryExecutor;
        this.f14249d = tasksManager;
        this.f14247b = immutableList;
        this.f14248c = listener;
    }

    public final void m21920a() {
        HandlerDetour.b(this.f14250e, new C09201(this), 3000, 493938766);
    }

    public static void m21919c(VideoStatusChecker videoStatusChecker) {
        VideoStatusQueryString videoStatusQueryString = new VideoStatusQueryString();
        videoStatusQueryString.a("targetIDs", videoStatusChecker.f14247b);
        videoStatusChecker.f14249d.a("videos_status_fetch", GraphQLQueryExecutor.b(videoStatusChecker.f14246a.a(GraphQLRequest.a(videoStatusQueryString).a(GraphQLCachePolicy.c))), new C09222(videoStatusChecker));
    }
}
