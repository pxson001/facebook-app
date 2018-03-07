package com.facebook.video.videohome.fragment;

import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitor;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveStatusTracker;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.adapter.VideoHomeLiveStatusListener;
import com.facebook.video.videohome.data.VideoHomeReactionItemCollection.OnCollectionChangeListener;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: startPlayout */
public class LiveVideoCollectionListener implements OnCollectionChangeListener {
    private final VideoHomeLiveStatusListener f2896a;
    private final VideoHomeConfig f2897b;
    private final LiveStatusTracker f2898c;
    private final OnCollectionChangeListener f2899d;

    /* compiled from: startPlayout */
    class VideoCollectionListener implements OnCollectionChangeListener {
        final /* synthetic */ LiveVideoCollectionListener f2893a;
        private final List<GraphQLStory> f2894b;
        private final VideoPrefetchVisitor f2895c;

        public VideoCollectionListener(LiveVideoCollectionListener liveVideoCollectionListener, List<GraphQLStory> list, VideoPrefetchVisitor videoPrefetchVisitor) {
            this.f2893a = liveVideoCollectionListener;
            this.f2894b = list;
            this.f2895c = videoPrefetchVisitor;
        }

        public final void mo82a(GraphQLStory graphQLStory) {
            GraphQLMedia d = m2796d(graphQLStory);
            if (d != null) {
                if (d.br() == GraphQLVideoBroadcastStatus.LIVE) {
                    this.f2894b.add(graphQLStory);
                } else if (!d.aq() || d.br() == GraphQLVideoBroadcastStatus.VOD_READY) {
                    this.f2895c.a(graphQLStory);
                }
            }
        }

        public final void mo83b(GraphQLStory graphQLStory) {
            this.f2894b.remove(graphQLStory);
        }

        public final void mo84c(GraphQLStory graphQLStory) {
            GraphQLMedia d = m2796d(graphQLStory);
            if (d != null && d.br() == GraphQLVideoBroadcastStatus.VOD_READY) {
                this.f2895c.a(graphQLStory);
            }
        }

        @Nullable
        private static GraphQLMedia m2796d(GraphQLStory graphQLStory) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            return o != null ? o.r() : null;
        }
    }

    public LiveVideoCollectionListener(VideoHomeLiveStatusListener videoHomeLiveStatusListener, VideoHomeConfig videoHomeConfig, LiveStatusTracker liveStatusTracker, List<GraphQLStory> list, VideoPrefetchVisitor videoPrefetchVisitor) {
        this.f2896a = videoHomeLiveStatusListener;
        this.f2897b = videoHomeConfig;
        this.f2898c = liveStatusTracker;
        this.f2899d = new VideoCollectionListener(this, list, videoPrefetchVisitor);
    }

    public final void mo82a(GraphQLStory graphQLStory) {
        GraphQLMedia d = m2800d(graphQLStory);
        if (d != null && d.aq() && d.al()) {
            VideoHomeLiveStatusListener videoHomeLiveStatusListener = this.f2896a;
            videoHomeLiveStatusListener.f2758c.put(d.b(), graphQLStory);
            videoHomeLiveStatusListener.f2757b.a(d, videoHomeLiveStatusListener.f2756a);
            if (!this.f2897b.b) {
                this.f2898c.a(d.b(), d.br());
            }
        }
        this.f2899d.mo82a(graphQLStory);
    }

    public final void mo83b(GraphQLStory graphQLStory) {
        GraphQLMedia d = m2800d(graphQLStory);
        if (d != null) {
            VideoHomeLiveStatusListener videoHomeLiveStatusListener = this.f2896a;
            String b = d.b();
            videoHomeLiveStatusListener.f2758c.remove(b);
            videoHomeLiveStatusListener.f2757b.a(b, videoHomeLiveStatusListener.f2756a);
        }
        if (!this.f2897b.b && d != null && d.aq() && d.al()) {
            this.f2898c.b(d.b());
        }
        this.f2899d.mo83b(graphQLStory);
    }

    public final void mo84c(GraphQLStory graphQLStory) {
        GraphQLMedia d = m2800d(graphQLStory);
        if (d != null) {
            VideoHomeLiveStatusListener videoHomeLiveStatusListener = this.f2896a;
            String b = d.b();
            if (videoHomeLiveStatusListener.f2758c.containsKey(b)) {
                videoHomeLiveStatusListener.f2758c.put(b, graphQLStory);
            }
        }
        if (!(this.f2897b.b || d == null || !d.aq())) {
            if (d.br() == GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || d.br() == GraphQLVideoBroadcastStatus.VOD_READY) {
                this.f2898c.b(d.b());
            } else {
                this.f2898c.a(d.b(), d.br());
            }
        }
        this.f2899d.mo84c(graphQLStory);
    }

    private static GraphQLMedia m2800d(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        return o != null ? o.r() : null;
    }
}
