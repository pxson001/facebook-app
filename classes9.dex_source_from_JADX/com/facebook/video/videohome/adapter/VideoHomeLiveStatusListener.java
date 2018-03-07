package com.facebook.video.videohome.adapter;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.video.util.VideoStoryMutationHelper;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateListener;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: stopUsingNetworkFeature */
public class VideoHomeLiveStatusListener implements LiveStatusListener {
    public final BroadcastStatusUpdateListener f2756a = new VideoHomeBroadcastStatusUpdatesListener(this);
    public final LiveUpdatesManager f2757b;
    public final HashMap<String, GraphQLStory> f2758c;
    public final DefaultAndroidThreadUtil f2759d;
    public final VideoStoryMutationHelper f2760e;

    /* compiled from: stopUsingNetworkFeature */
    public class C02561 implements Runnable {
        final /* synthetic */ GraphQLStory f2751a;
        final /* synthetic */ GraphQLVideoBroadcastStatus f2752b;
        final /* synthetic */ VideoBroadcastFragmentModel f2753c;
        final /* synthetic */ VideoHomeLiveStatusListener f2754d;

        public C02561(VideoHomeLiveStatusListener videoHomeLiveStatusListener, GraphQLStory graphQLStory, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
            this.f2754d = videoHomeLiveStatusListener;
            this.f2751a = graphQLStory;
            this.f2752b = graphQLVideoBroadcastStatus;
            this.f2753c = videoBroadcastFragmentModel;
        }

        public void run() {
            VideoHomeLiveStatusListener videoHomeLiveStatusListener = this.f2754d;
            GraphQLStory graphQLStory = this.f2751a;
            GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus = this.f2752b;
            VideoBroadcastFragmentModel videoBroadcastFragmentModel = this.f2753c;
            if (videoBroadcastFragmentModel == null) {
                videoHomeLiveStatusListener.f2760e.a(graphQLStory, graphQLVideoBroadcastStatus);
            } else {
                videoHomeLiveStatusListener.f2760e.a(graphQLStory, videoBroadcastFragmentModel);
            }
        }
    }

    /* compiled from: stopUsingNetworkFeature */
    class VideoHomeBroadcastStatusUpdatesListener implements BroadcastStatusUpdateListener {
        final /* synthetic */ VideoHomeLiveStatusListener f2755a;

        public VideoHomeBroadcastStatusUpdatesListener(VideoHomeLiveStatusListener videoHomeLiveStatusListener) {
            this.f2755a = videoHomeLiveStatusListener;
        }

        public final void mo80a(String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, @Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
            GraphQLStory graphQLStory = (GraphQLStory) this.f2755a.f2758c.get(str);
            if (graphQLStory != null) {
                VideoHomeLiveStatusListener videoHomeLiveStatusListener;
                if (FacecastUtil.a(graphQLVideoBroadcastStatus)) {
                    if (!FacecastUtil.a(VideoHomeLiveStatusListener.m2649b(graphQLStory))) {
                        videoHomeLiveStatusListener = this.f2755a;
                        videoHomeLiveStatusListener.f2759d.b(new C02561(videoHomeLiveStatusListener, graphQLStory, graphQLVideoBroadcastStatus, videoBroadcastFragmentModel));
                    }
                } else if (graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.VOD_READY) {
                    videoHomeLiveStatusListener = this.f2755a;
                    videoHomeLiveStatusListener.f2759d.b(new C02561(videoHomeLiveStatusListener, graphQLStory, graphQLVideoBroadcastStatus, videoBroadcastFragmentModel));
                }
            }
        }

        public final void mo79a(String str) {
            GraphQLStory graphQLStory = (GraphQLStory) this.f2755a.f2758c.get(str);
            if (graphQLStory != null) {
                VideoHomeLiveStatusListener videoHomeLiveStatusListener = this.f2755a;
                videoHomeLiveStatusListener.f2759d.b(new C02561(videoHomeLiveStatusListener, graphQLStory, null, null));
            }
        }
    }

    public static VideoHomeLiveStatusListener m2648a(InjectorLike injectorLike) {
        return new VideoHomeLiveStatusListener(LiveUpdatesManager.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), VideoStoryMutationHelper.b(injectorLike));
    }

    @Inject
    public VideoHomeLiveStatusListener(LiveUpdatesManager liveUpdatesManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, VideoStoryMutationHelper videoStoryMutationHelper) {
        this.f2757b = liveUpdatesManager;
        this.f2759d = defaultAndroidThreadUtil;
        this.f2760e = videoStoryMutationHelper;
        this.f2758c = new HashMap();
    }

    public static GraphQLVideoBroadcastStatus m2649b(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o == null || o.r() == null) {
            return GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        return o.r().br();
    }

    public final void m2650a(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        GraphQLStory graphQLStory = (GraphQLStory) this.f2758c.get(videoBroadcastFragmentModel.n());
        if (graphQLStory != null && FacecastUtil.a(videoBroadcastFragmentModel.d()) && !FacecastUtil.a(m2649b(graphQLStory))) {
            this.f2760e.a(graphQLStory, videoBroadcastFragmentModel);
        }
    }

    public final void m2652b(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        GraphQLStory graphQLStory = (GraphQLStory) this.f2758c.get(videoBroadcastFragmentModel.n());
        if (graphQLStory != null && videoBroadcastFragmentModel.d() == GraphQLVideoBroadcastStatus.VOD_READY) {
            this.f2760e.a(graphQLStory, videoBroadcastFragmentModel);
        }
    }

    public final void m2651a(String str) {
        GraphQLStory graphQLStory = (GraphQLStory) this.f2758c.get(str);
        if (graphQLStory != null) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            if (o != null && o.r() != null) {
                this.f2760e.a(graphQLStory, null);
            }
        }
    }

    public final void r_(int i) {
    }
}
