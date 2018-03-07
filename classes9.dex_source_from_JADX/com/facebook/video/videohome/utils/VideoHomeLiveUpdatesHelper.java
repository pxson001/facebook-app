package com.facebook.video.videohome.utils;

import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.video.analytics.VideoAnalytics.PrefetchReason;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateListener;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: show_risk_controller_fragment_tag */
public class VideoHomeLiveUpdatesHelper {
    private final VideoHomeConfig f3329a;
    private final Lazy<LiveUpdatesManager> f3330b;
    private final Set<String> f3331c = new HashSet();
    private final BroadcastStatusUpdateListener f3332d = new LatwVideosBroadcastStatusUpdateListener(this);
    public WeakReference<LatwLiveUpdatesListener> f3333e;

    /* compiled from: show_risk_controller_fragment_tag */
    class LatwVideosBroadcastStatusUpdateListener implements BroadcastStatusUpdateListener {
        final /* synthetic */ VideoHomeLiveUpdatesHelper f3328a;

        public LatwVideosBroadcastStatusUpdateListener(VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper) {
            this.f3328a = videoHomeLiveUpdatesHelper;
        }

        public final void mo80a(String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, @Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
            if (graphQLVideoBroadcastStatus != GraphQLVideoBroadcastStatus.LIVE) {
                VideoHomeLiveUpdatesHelper.m3157a(this.f3328a, str);
                VideoHomeLiveUpdatesHelper.m3156a(this.f3328a);
            }
        }

        public final void mo79a(String str) {
            VideoHomeLiveUpdatesHelper.m3157a(this.f3328a, str);
            VideoHomeLiveUpdatesHelper.m3156a(this.f3328a);
        }
    }

    public static VideoHomeLiveUpdatesHelper m3160b(InjectorLike injectorLike) {
        return new VideoHomeLiveUpdatesHelper(IdBasedSingletonScopeProvider.b(injectorLike, 3708), VideoHomeConfig.a(injectorLike));
    }

    public static VideoHomeLiveUpdatesHelper m3155a(InjectorLike injectorLike) {
        return m3160b(injectorLike);
    }

    @Inject
    public VideoHomeLiveUpdatesHelper(Lazy<LiveUpdatesManager> lazy, VideoHomeConfig videoHomeConfig) {
        this.f3330b = lazy;
        this.f3329a = videoHomeConfig;
    }

    public final void m3163a(@Nullable ReactionSession reactionSession) {
        if (this.f3329a.b && reactionSession != null) {
            m3161c(reactionSession);
        }
    }

    public final void m3165b(@Nullable ReactionSession reactionSession) {
        if (this.f3329a.b && reactionSession != null) {
            m3161c(reactionSession);
        }
    }

    public final void m3164a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel) {
        if (this.f3329a.b) {
            Collection arrayList = new ArrayList();
            ImmutableList a = reactionPaginatedComponentsModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ReactionUnitSubComponentModel a2 = ((EdgesModel) a.get(i)).a();
                if (a2 != null) {
                    arrayList.add(a2.ax());
                }
            }
            m3158a(arrayList, true);
        }
    }

    public static boolean m3159a(ReactionUnitComponentModel reactionUnitComponentModel) {
        return reactionUnitComponentModel.a() == GraphQLReactionUnitComponentStyle.PAGINATED_H_SCROLL_GENERIC_COMPONENTS_LIST_LIVE_VIDEO;
    }

    private void m3161c(ReactionSession reactionSession) {
        Collection arrayList = new ArrayList();
        ReactionUnitComponentModel d = m3162d(reactionSession);
        if (d != null) {
            ImmutableList a = ReactionUnitComponentUtil.a(d);
            if (a != null) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(((ReactionUnitComponentFields) a.get(i)).ax());
                }
            }
            m3158a(arrayList, false);
        }
    }

    private void m3158a(Collection<GraphQLStory> collection, boolean z) {
        int size = this.f3331c.size();
        if (z) {
            Set set = null;
        } else {
            Object hashSet = new HashSet(this.f3331c);
        }
        for (GraphQLStory graphQLStory : collection) {
            if (graphQLStory != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                GraphQLMedia r = o == null ? null : o.r();
                if (r != null && r.br() == GraphQLVideoBroadcastStatus.LIVE) {
                    String b = r.b();
                    if (!this.f3331c.contains(b)) {
                        this.f3331c.add(b);
                        ((LiveUpdatesManager) this.f3330b.get()).a(r, this.f3332d);
                    }
                    if (!z) {
                        r1.remove(b);
                    }
                }
            }
        }
        if (!z) {
            for (String a : r1) {
                m3157a(this, a);
            }
        }
        if (this.f3331c.size() != size) {
            m3156a(this);
        }
    }

    public static void m3157a(VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper, String str) {
        videoHomeLiveUpdatesHelper.f3331c.remove(str);
        ((LiveUpdatesManager) videoHomeLiveUpdatesHelper.f3330b.get()).a(str, videoHomeLiveUpdatesHelper.f3332d);
    }

    public static void m3156a(VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper) {
        VideoHomeReactionSessionHelper videoHomeReactionSessionHelper = videoHomeLiveUpdatesHelper.f3333e == null ? null : (VideoHomeReactionSessionHelper) videoHomeLiveUpdatesHelper.f3333e.get();
        if (videoHomeReactionSessionHelper != null) {
            int size = videoHomeLiveUpdatesHelper.f3331c.size();
            videoHomeReactionSessionHelper.f3313w = size;
            if (size < videoHomeReactionSessionHelper.f3306p.a(ExperimentsForVideoHomeAbTestModule.v, 3) && !((VideoHomeSessionManager) videoHomeReactionSessionHelper.f3298h.get()).g()) {
                videoHomeReactionSessionHelper.m3139a(VideoHomeReactionSessionHelper.m3136m(videoHomeReactionSessionHelper), PrefetchReason.LIVE_UPDATES);
            }
        }
    }

    @Nullable
    private static ReactionUnitComponentModel m3162d(ReactionSession reactionSession) {
        ImmutableList p = reactionSession.p();
        int size = p.size();
        for (int i = 0; i < size; i++) {
            ImmutableList a = ((ReactionStories) p.get(i)).a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ReactionStoriesModel.EdgesModel edgesModel = (ReactionStoriesModel.EdgesModel) a.get(i2);
                if (edgesModel.a() != null) {
                    ImmutableList s = edgesModel.a().s();
                    int size3 = s.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i3);
                        if (m3159a(reactionUnitComponentModel)) {
                            return reactionUnitComponentModel;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }
}
