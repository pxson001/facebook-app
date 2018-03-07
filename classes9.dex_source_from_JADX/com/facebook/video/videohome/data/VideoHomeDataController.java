package com.facebook.video.videohome.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.common.ReactionValidationResult;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel.Builder;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.data.VideoHomeReactionItemCollection.OnCollectionChangeListener;
import com.facebook.video.videohome.environment.VideoHomeEnvironmentImpl;
import com.facebook.video.videohome.fragment.VideoHomeHomeFragment.C02762;
import com.facebook.video.videohome.pagination.VideoHomePaginationCoordinator;
import com.facebook.video.videohome.partdefinitions.VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.C02922;
import com.facebook.video.videohome.utils.VideoHomeLiveUpdatesHelper;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: status_sender_packet_id */
public class VideoHomeDataController {
    public final FeedStorySubscriber f2809a;
    public final C02762 f2810b;
    public final VideoHomeReactionItemCollection f2811c;
    public final VideoHomePaginationCoordinator f2812d;
    public final ReactionUtil f2813e;
    private final ReactionUnitValidator f2814f;
    public final VideoHomeLiveUpdatesHelper f2815g;
    private final int f2816h;
    public final HashMap<String, Integer> f2817i;
    public final HashMap<String, FetchMoreSubcomponentsCallback> f2818j;
    public final OnCollectionChangeListener f2819k = new C02621(this);
    private final OnStoryChangeListener f2820l = new C02632(this);

    /* compiled from: status_sender_packet_id */
    class C02621 implements OnCollectionChangeListener {
        final /* synthetic */ VideoHomeDataController f2801a;

        C02621(VideoHomeDataController videoHomeDataController) {
            this.f2801a = videoHomeDataController;
        }

        public final void mo82a(GraphQLStory graphQLStory) {
            this.f2801a.f2809a.a(graphQLStory, true);
        }

        public final void mo83b(GraphQLStory graphQLStory) {
        }

        public final void mo84c(GraphQLStory graphQLStory) {
        }
    }

    /* compiled from: status_sender_packet_id */
    class C02632 implements OnStoryChangeListener {
        final /* synthetic */ VideoHomeDataController f2802a;

        C02632(VideoHomeDataController videoHomeDataController) {
            this.f2802a = videoHomeDataController;
        }

        public final void m2680a(GraphQLStory graphQLStory) {
            this.f2802a.m2696a(graphQLStory);
        }
    }

    /* compiled from: status_sender_packet_id */
    public class FetchHScrollRequestCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionMoreSubComponentsResultModel>> {
        final /* synthetic */ VideoHomeDataController f2803a;
        private final ReactionUnitComponentNode f2804b;
        private final C02922 f2805c;

        protected final void m2681a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f2805c.m2967a();
            if (graphQLResult != null && graphQLResult.e != null && ((ReactionMoreSubComponentsResultModel) graphQLResult.e).a() != null) {
                ReactionPaginatedComponentsModel a = ((ReactionMoreSubComponentsResultModel) graphQLResult.e).a();
                VideoHomeDataController.m2690a(this.f2803a, a, VideoHomeDataController.m2694b(this.f2804b.b), this.f2804b.c);
                this.f2803a.f2815g.m3164a(a);
            }
        }

        public FetchHScrollRequestCallback(VideoHomeDataController videoHomeDataController, ReactionUnitComponentNode reactionUnitComponentNode, C02922 c02922) {
            this.f2803a = videoHomeDataController;
            this.f2804b = reactionUnitComponentNode;
            this.f2805c = c02922;
        }

        protected final void m2682a(Throwable th) {
            this.f2805c.m2967a();
        }
    }

    /* compiled from: status_sender_packet_id */
    class FetchMoreSubcomponentsCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionMoreSubComponentsResultModel>> {
        final /* synthetic */ VideoHomeDataController f2806a;
        private final String f2807b;
        private final String f2808c;

        protected final void m2684a(Object obj) {
            ReactionPaginatedComponentsModel reactionPaginatedComponentsModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                reactionPaginatedComponentsModel = null;
            } else {
                reactionPaginatedComponentsModel = ((ReactionMoreSubComponentsResultModel) graphQLResult.e).a();
            }
            ReactionPaginatedComponentsModel reactionPaginatedComponentsModel2 = reactionPaginatedComponentsModel;
            if (reactionPaginatedComponentsModel2 != null) {
                int size;
                VideoHomeDataController.m2690a(this.f2806a, reactionPaginatedComponentsModel2, this.f2807b, this.f2808c);
                if (this.f2806a.f2817i.get(this.f2807b) == null) {
                    size = reactionPaginatedComponentsModel2.a().size();
                } else {
                    size = ((Integer) this.f2806a.f2817i.get(this.f2807b)).intValue() + reactionPaginatedComponentsModel2.a().size();
                }
                this.f2806a.f2817i.put(this.f2807b, Integer.valueOf(size));
            }
            m2683b();
        }

        public FetchMoreSubcomponentsCallback(VideoHomeDataController videoHomeDataController, String str, String str2) {
            this.f2806a = videoHomeDataController;
            this.f2807b = str;
            this.f2808c = str2;
        }

        protected final void m2685a(Throwable th) {
            m2683b();
        }

        private void m2683b() {
            this.f2806a.f2818j.remove(this.f2807b);
        }
    }

    @Inject
    public VideoHomeDataController(@Assisted C02762 c02762, FeedStorySubscriber feedStorySubscriber, VideoHomeReactionItemCollection videoHomeReactionItemCollection, VideoHomePaginationCoordinator videoHomePaginationCoordinator, ReactionUtil reactionUtil, ReactionUnitValidator reactionUnitValidator, QeAccessor qeAccessor, VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper) {
        this.f2810b = c02762;
        this.f2809a = feedStorySubscriber;
        this.f2811c = videoHomeReactionItemCollection;
        this.f2812d = videoHomePaginationCoordinator;
        this.f2813e = reactionUtil;
        this.f2814f = reactionUnitValidator;
        this.f2815g = videoHomeLiveUpdatesHelper;
        this.f2816h = qeAccessor.a(ExperimentsForVideoHomeAbTestModule.y, 10);
        this.f2817i = new HashMap();
        this.f2818j = new HashMap();
        this.f2809a.d = this.f2820l;
        this.f2811c.m2729a(this.f2819k);
    }

    public final VideoHomeReactionItemCollection m2695a() {
        return this.f2811c;
    }

    public final void m2696a(GraphQLStory graphQLStory) {
        this.f2811c.a(graphQLStory);
        this.f2810b.m2830a();
    }

    @Nullable
    private static ReactionUnitComponentModel m2688a(ReactionUnitFragment reactionUnitFragment) {
        if (reactionUnitFragment == null) {
            return null;
        }
        ImmutableList s = reactionUnitFragment.s();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i);
            if (reactionUnitComponentModel.a() == GraphQLReactionUnitComponentStyle.PAGINATED_V_SCROLL_GENERIC_COMPONENTS_LIST) {
                return reactionUnitComponentModel;
            }
        }
        return null;
    }

    private boolean m2691a(ReactionUnitFragment reactionUnitFragment, String str) {
        int b = m2693b(str);
        if (b < 0) {
            return false;
        }
        this.f2811c.c(b);
        m2689a(reactionUnitFragment, b);
        this.f2810b.m2830a();
        return true;
    }

    public final void m2699e() {
        if (this.f2812d.m2885c()) {
            ReactionUnitFragment reactionUnitFragment;
            Builder builder = new Builder();
            VideoHomePaginationCoordinator videoHomePaginationCoordinator = this.f2812d;
            if (videoHomePaginationCoordinator.f2989a.isEmpty()) {
                reactionUnitFragment = null;
            } else {
                reactionUnitFragment = (ReactionUnitFragment) videoHomePaginationCoordinator.f2989a.remove(0);
                ImmutableList s = reactionUnitFragment.s();
                int size = s.size();
                int i = 0;
                while (i < size) {
                    ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i);
                    if (reactionUnitComponentModel.a() != GraphQLReactionUnitComponentStyle.PAGINATED_V_SCROLL_GENERIC_COMPONENTS_LIST) {
                        i++;
                    } else if (reactionUnitComponentModel.B() != 0) {
                        Object obj = null;
                        PaginatedComponentsModel dk = reactionUnitComponentModel.dk();
                        if (dk != null) {
                            PaginatedComponentsModel.ReactionPaginatedComponentsModel c = dk.c();
                            if (c != null) {
                                DefaultPageInfoFields b = c.b();
                                if (b != null && b.b()) {
                                    obj = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            videoHomePaginationCoordinator.f2990b = false;
                        }
                    }
                }
            }
            builder.a = ReactionUnitFragmentModel.a(reactionUnitFragment);
            ReactionStoriesModel.Builder builder2 = new ReactionStoriesModel.Builder();
            builder2.a = ImmutableList.of(builder.a());
            ImmutableList a = builder2.a().a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ReactionUnitFragment a2 = ((EdgesModel) a.get(i2)).a();
                if (a2 != null) {
                    m2689a(a2, this.f2811c.a());
                }
            }
            this.f2810b.m2830a();
        }
    }

    public final void m2697a(ReactionStories reactionStories) {
        ImmutableList a = reactionStories.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (edgesModel.a() != null) {
                VideoHomePaginationCoordinator videoHomePaginationCoordinator = this.f2812d;
                videoHomePaginationCoordinator.f2989a.add(edgesModel.a());
            }
        }
    }

    public final void m2698a(VideoHomeEnvironmentImpl videoHomeEnvironmentImpl, int i, ReactionSession reactionSession) {
        boolean z = true;
        if (videoHomeEnvironmentImpl != null && !this.f2811c.b()) {
            if (i >= this.f2811c.a()) {
                i = this.f2811c.a() - 1;
            }
            ReactionUnitFragment k = this.f2811c.b(i).k();
            ReactionUnitComponentModel a = m2688a(k);
            if (a != null) {
                boolean z2;
                int B = a.B();
                String b = m2694b((ReactionUnitComponentFields) a);
                int a2 = m2686a(B, this.f2817i.get(b) == null ? 0 : ((Integer) this.f2817i.get(b)).intValue(), this.f2816h);
                if (a2 <= 0 || !m2692a(a, k.d(), a2, reactionSession)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                VideoHomePaginationCoordinator videoHomePaginationCoordinator = this.f2812d;
                if (z2) {
                    z = false;
                }
                videoHomePaginationCoordinator.f2990b = z;
            }
        }
    }

    @Nullable
    private ReactionUnitFragment m2687a(String str) {
        int b = m2693b(str);
        if (b < 0 || b >= this.f2811c.a()) {
            return null;
        }
        return this.f2811c.b(b).k();
    }

    public static void m2690a(VideoHomeDataController videoHomeDataController, ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, String str, String str2) {
        ReactionUnitFragment a = videoHomeDataController.m2687a(str2);
        if (a != null) {
            videoHomeDataController.m2691a(ReactionUnitComponentUtil.a(a, reactionPaginatedComponentsModel, str), str2);
        }
    }

    private void m2689a(ReactionUnitFragment reactionUnitFragment, int i) {
        ReactionValidationResult a = this.f2814f.a(reactionUnitFragment);
        if ("SUCCESS".equals(a.d)) {
            this.f2811c.a(i, new ReactionCardNode(reactionUnitFragment, a));
        }
    }

    private int m2693b(String str) {
        for (int i = 0; i < this.f2811c.a(); i++) {
            if (str.equals(this.f2811c.b(i).k().d())) {
                return i;
            }
        }
        return -1;
    }

    private static int m2686a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        if (i <= 0 || i2 >= i) {
            return i3;
        }
        return Math.min(i - i2, i3);
    }

    private boolean m2692a(ReactionUnitComponentModel reactionUnitComponentModel, String str, int i, ReactionSession reactionSession) {
        if (this.f2818j.get(m2694b((ReactionUnitComponentFields) reactionUnitComponentModel)) != null) {
            return true;
        }
        PaginatedComponentsModel dk = reactionUnitComponentModel.dk();
        if (dk == null || dk.c() == null) {
            return false;
        }
        DefaultPageInfoFields b = dk.c().b();
        if (b == null || !b.b()) {
            return false;
        }
        FetchMoreSubcomponentsCallback fetchMoreSubcomponentsCallback = new FetchMoreSubcomponentsCallback(this, m2694b((ReactionUnitComponentFields) reactionUnitComponentModel), str);
        this.f2818j.put(m2694b((ReactionUnitComponentFields) reactionUnitComponentModel), fetchMoreSubcomponentsCallback);
        this.f2813e.a(b.a(), fetchMoreSubcomponentsCallback, i, dk.b(), reactionSession);
        return true;
    }

    public static String m2694b(ReactionUnitComponentFields reactionUnitComponentFields) {
        return reactionUnitComponentFields.U();
    }
}
