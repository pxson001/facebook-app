package com.facebook.feed.ui.feedprefetch;

import android.net.Uri;
import com.facebook.common.collect.LongArraySet;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.MediaPlayerPool;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.engine.VideoPlayerManager.2;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ListViewPreloader;
import com.facebook.widget.listview.ListViewPreloader.PreloadDirection;
import com.facebook.widget.listview.ListViewPreloader.PreloadType;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: messenger_send_video_android_v7 */
public class VideoPrepareViewPreloader extends ListViewPreloader {
    private final BasicAdapter f13751d;
    private final LongArraySet f13752e = new LongArraySet();
    private final NativePlayerPool f13753f;
    private DefaultAndroidThreadUtil f13754g;
    private VideoPlayerManager f13755h;
    private VideoExoplayerConfig f13756i;

    @Inject
    public VideoPrepareViewPreloader(@Assisted ScrollingViewProxy scrollingViewProxy, @Assisted BasicAdapter basicAdapter, NativePlayerPool nativePlayerPool, DefaultAndroidThreadUtil defaultAndroidThreadUtil, VideoPlayerManager videoPlayerManager, QeAccessor qeAccessor, ThrottledOnScrollListenerFactory throttledOnScrollListenerFactory, VideoExoplayerConfig videoExoplayerConfig) {
        super(scrollingViewProxy, videoExoplayerConfig.f6939z, PreloadDirection.CLOSEST_FIRST, PreloadType.ALL_ONSCREEN_AND_OFFSCREEN, null, true, throttledOnScrollListenerFactory, m20176a(qeAccessor));
        this.f13753f = nativePlayerPool;
        this.f13751d = basicAdapter;
        this.f13754g = defaultAndroidThreadUtil;
        this.f13755h = videoPlayerManager;
        this.f13756i = videoExoplayerConfig;
    }

    public static void m20177a(VideoPrepareViewPreloader videoPrepareViewPreloader, GraphQLStory graphQLStory) {
        if (graphQLStory != null) {
            if (graphQLStory.m22326L() != null) {
                m20177a(videoPrepareViewPreloader, graphQLStory.m22326L());
            }
            ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                m20177a(videoPrepareViewPreloader, (GraphQLStory) j.get(i));
            }
            if (StoryAttachmentHelper.m28037j(graphQLStory)) {
                for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.m22367x()) {
                    if (GraphQLStoryAttachmentUtil.m28055d(graphQLStoryAttachment)) {
                        String str;
                        GraphQLMedia r = graphQLStoryAttachment.m23979r();
                        if (r == null || r.m24453j() == null || r.m24453j().m22301g() != 82650203) {
                            str = null;
                        } else {
                            str = r.m24452b();
                        }
                        Object obj = str;
                        if (obj != null) {
                            if (!videoPrepareViewPreloader.f13756i.m11520a()) {
                                NativePlayerPool nativePlayerPool = videoPrepareViewPreloader.f13753f;
                                PlayerType playerType = PlayerType.INLINE_PLAYER;
                                if (obj != null) {
                                    VideoPlayerParams videoPlayerParams = (VideoPlayerParams) nativePlayerPool.f13777c.m4432a(obj);
                                    if (videoPlayerParams != null) {
                                        Uri uri;
                                        VideoDataSource b = NativePlayerPool.m20193b(videoPlayerParams);
                                        if (b == null) {
                                            uri = null;
                                        } else {
                                            uri = b.b;
                                        }
                                        Object obj2 = uri;
                                        if (obj2 != null && ((!nativePlayerPool.f13782h.f6904D || nativePlayerPool.f13779e.m4432a(obj2) == null) && !nativePlayerPool.m20197a())) {
                                            ((MediaPlayerPool) nativePlayerPool.f13776b.get()).c(obj2);
                                        }
                                    }
                                }
                            } else if (videoPrepareViewPreloader.f13756i.m11521b() && videoPrepareViewPreloader.f13756i.f6934u) {
                                VideoPlayerManager videoPlayerManager = videoPrepareViewPreloader.f13755h;
                                if (videoPlayerManager.f9034M == null) {
                                    VideoPlayerManager.m13915h(videoPlayerManager);
                                } else if (videoPlayerManager.f9039R.m4432a(obj) == null) {
                                    videoPlayerManager.f9039R.m4433a(obj, Boolean.valueOf(true));
                                    VideoDataSource b2 = NativePlayerPool.m20193b((VideoPlayerParams) ((NativePlayerPool) videoPlayerManager.f9031J.get()).f13777c.m4432a(obj));
                                    if (b2 != null) {
                                        int i2;
                                        Uri uri2 = b2.b;
                                        if (b2.f == null) {
                                            i2 = 0;
                                        } else {
                                            i2 = b2.f.length();
                                        }
                                        Integer.valueOf(i2);
                                        2 2 = new 2(videoPlayerManager, obj, b2);
                                        if (videoPlayerManager.f9059o.f6923j) {
                                            ExecutorDetour.a(videoPlayerManager.f9061q, 2, 1398080004);
                                        } else {
                                            2.run();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected final void mo2667a(int i) {
        if (i < this.f13751d.aZ_() && i >= 0) {
            Object item = this.f13751d.getItem(i);
            this.f13752e.m20210a(m20178d(i));
            final FeedUnit a = FeedUnitHelper.m21141a(item);
            if (a != null && (a instanceof GraphQLStory)) {
                this.f13754g.m1656b(new Runnable(this) {
                    final /* synthetic */ VideoPrepareViewPreloader f22053b;

                    public void run() {
                        VideoPrepareViewPreloader.m20177a(this.f22053b, (GraphQLStory) a);
                    }
                });
            }
        }
    }

    private static int m20176a(QeAccessor qeAccessor) {
        return qeAccessor.mo572a(ExperimentsForNewsFeedAbTestModule.af, 0);
    }

    private long m20178d(int i) {
        if (i >= this.f13751d.aZ_() || i < 0) {
            return -1;
        }
        Object item = this.f13751d.getItem(i);
        if (item != null) {
            return (long) System.identityHashCode(item);
        }
        return -1;
    }

    public final boolean mo2668b(int i) {
        return this.f13752e.f13799a.m4367d(m20178d(i)) >= 0;
    }

    public final void mo2669c(int i) {
        if (this.f13756i.f6902B) {
            LongArraySet longArraySet = this.f13752e;
            longArraySet.f13799a.m4363b(m20178d(i));
        }
    }
}
